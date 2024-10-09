import {
  ButtonContainerState,
  IAppDEService,
  IAppService,
  IButtonContainerState,
  IDataEntity,
  UIActionButtonState,
  getControl,
} from '@ibiz-template/runtime';
import { ICodeListEditor, IDEForm, IDEFormGroupPanel } from '@ibiz/model-core';
import { IPortalMessage, RuntimeModelError } from '@ibiz-template/core';
import { debounce } from 'lodash-es';
import { DndStencilPanelItemController } from '../../panel-items/dnd-stencil/dnd-stencil.controller';
import { DndDesignViewController } from '../../views';

export class DndStencilFieldController extends DndStencilPanelItemController {
  protected app!: IAppService;

  protected form!: IDEForm;

  protected service!: IAppDEService;

  protected fieldForm!: IDEForm;

  protected fieldService!: IAppDEService;

  protected fieldItems: IDataEntity[] = [];

  protected items: IDataEntity[] = [];

  enableGroup: boolean = true;

  protected mdCtrlFieldType: string[] = [
    'ONE2MANYDATA',
    'ONE2ONEDATA',
    'ONE2MANYDATA_MAP',
    'ONE2MANYOBJ',
    'ONE2ONEOBJ',
    'ONE2MANYOBJ_MAP',
  ];

  get view(): DndDesignViewController {
    return this.panel.view as DndDesignViewController;
  }

  protected async onInit(): Promise<void> {
    this.app = await ibiz.hub.getApp(this.model.appId);
    const form = getControl(this.panel.view.model, 'item');
    if (!form) {
      throw new RuntimeModelError(this.panel.view, '未找到 item 表单模型');
    }
    this.form = form as IDEForm;
    this.service = await this.app.deService.getService(
      this.panel.context,
      form.appDataEntityId!,
    );
    const fieldForm = getControl(this.panel.view.model, 'field');
    if (!fieldForm) {
      throw new RuntimeModelError(this.panel.view, '未找到 field 表单模型');
    }
    this.fieldForm = fieldForm as IDEForm;
    this.fieldService = await this.app.deService.getService(
      this.panel.context,
      fieldForm.appDataEntityId!,
    );
    const editor = this.model.editor as ICodeListEditor;
    if (editor) {
      const { appCodeListId } = editor;
      if (appCodeListId) {
        this.codeList = this.app.codeList.getCodeList(appCodeListId)!;
      }
      if (!this.codeList) {
        throw new RuntimeModelError(this.model, `未配置属性项代码表`);
      }
    } else {
      ibiz.log.warn('拖拽素材区控制器的 editor 为空');
    }
    await this.initButtonGroup();
    this.view.evt.on('onSaveSuccess', async () => {
      await this.load();
    });
    await super.onInit();
    this.debounceTransformFieldItems = debounce(
      this.debounceTransformFieldItems,
      50,
    );
    this.subscribeMessage();
  }

  /**
   * 初始化界面行为按钮
   *
   * @author zhanghengfeng
   * @date 2024-01-12 18:01:04
   * @protected
   * @return {*}  {Promise<void>}
   */
  protected async initButtonGroup(): Promise<void> {
    if (this.fieldForm) {
      const pages = this.fieldForm.deformPages;
      if (!Array.isArray(pages) || !pages[0]) {
        ibiz.log.warn('field 表单模型未配置表单分页');
        return;
      }
      const page = pages[0];
      const formDetails = page.deformDetails;
      const group = formDetails?.find(
        item => item.codeName === 'filed_group',
      ) as IDEFormGroupPanel;
      if (!group) {
        ibiz.log.warn('field 表单模型未配置标识为 filed_group 表单分组');
        return;
      }
      const state = await this.initActionStates(group);
      this.codeList.codeItems?.forEach(item => {
        if (item.codeName) {
          if (state) {
            this.buttonGroupMap.set(item.codeName, { model: group, state });
          }
        }
      });
    }
  }

  /**
   * 初始化界面行为按钮的状态
   *
   * @author zhanghengfeng
   * @date 2024-01-12 18:01:53
   * @param {IDEFormGroupPanel} model
   * @return {*}  {(Promise<IButtonContainerState | undefined>)}
   */
  async initActionStates(
    model: IDEFormGroupPanel,
  ): Promise<IButtonContainerState | undefined> {
    const { uiactionGroup } = model;
    if (!uiactionGroup?.uiactionGroupDetails?.length) {
      return;
    }
    const containerState = new ButtonContainerState();
    uiactionGroup.uiactionGroupDetails.forEach(detail => {
      const actionid = detail.uiactionId;
      if (actionid) {
        const buttonState = new UIActionButtonState(
          detail.id!,
          this.panel.context.srfappid!,
          actionid,
        );
        containerState.addState(detail.id!, buttonState);
      }
    });
    await containerState.update(this.panel.context);
    return containerState;
  }

  /**
   * 监听数据更新
   *
   * @author zhanghengfeng
   * @date 2024-02-04 17:02:27
   * @protected
   * @param {IPortalMessage} msg
   */
  protected onDataUpdate(msg: IPortalMessage): void {
    if (msg.data && typeof msg.data === 'object') {
      const data = msg.data as IDataEntity;
      if (data.srfkey) {
        const index = this.items.findIndex(item => item.srfkey === data.srfkey);
        if (index !== -1) {
          this.items[index] = data;
          this.debounceTransformFieldItems();
        }
      }
    }
  }

  /**
   * 监听数据新建
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:06
   * @protected
   * @param {IPortalMessage} msg
   */
  protected onDataCreate(msg: IPortalMessage): void {
    if (msg.messageid !== this.panel.context.srfsessionid) {
      return;
    }
    if (msg.data && typeof msg.data === 'object') {
      const data = msg.data as IDataEntity;
      if (data.srfkey) {
        this.items.push(data);
        this.transformFieldItems();
      }
    }
  }

  /**
   * 监听数据删除
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:17
   * @protected
   * @param {IPortalMessage} msg
   */
  protected onDataRemove(msg: IPortalMessage): void {
    if (msg.data && typeof msg.data === 'object') {
      const data = msg.data as IDataEntity;
      if (data.srfkey) {
        const index = this.items.findIndex(item => item.srfkey === data.srfkey);
        if (index !== -1) {
          this.loadItems();
        }
      }
    }
  }

  /**
   * 订阅消息
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:54
   * @protected
   */
  protected subscribeMessage(): void {
    this.onDataUpdate = this.onDataUpdate.bind(this);
    this.onDataCreate = this.onDataCreate.bind(this);
    this.onDataRemove = this.onDataRemove.bind(this);
    ibiz.mc.command.update.on(this.onDataUpdate);
    ibiz.mc.command.create.on(this.onDataCreate);
    ibiz.mc.command.remove.on(this.onDataRemove);
  }

  /**
   * 取消订阅消息
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:03
   * @protected
   */
  protected unsubscribeMessage(): void {
    ibiz.mc.command.update.off(this.onDataUpdate);
    ibiz.mc.command.remove.off(this.onDataRemove);
    ibiz.mc.command.create.off(this.onDataCreate);
  }

  /**
   * 销毁方法
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:29
   */
  destroy(): void {
    super.destroy();
    this.unsubscribeMessage();
  }

  /**
   * 数据加载
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:35
   * @return {*}  {Promise<void>}
   */
  async load(): Promise<void> {
    const res = await this.fieldService.exec('fetchcurde', this.panel.context, {
      n_psdeid_eq: this.view.state.data.psdeid,
      n_usertag4_noteq: 'INTENAL',
    });
    this.state.items = this.codeList.codeItems || [];
    if (res.ok && Array.isArray(res.data)) {
      this.fieldItems = res.data;
      await this.loadItems();
    }
  }

  /**
   * 加载数据集
   *
   * @author zhanghengfeng
   * @date 2024-02-04 16:02:27
   * @return {*}  {Promise<void>}
   */
  async loadItems(): Promise<void> {
    const result = await this.service.fetchDefault(this.panel.context);
    if (result.ok && Array.isArray(result.data)) {
      this.items = result.data as IDataEntity[];
      this.transformFieldItems();
    }
  }

  /**
   * 过滤属性项
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:46
   * @protected
   * @return {*}  {IDataEntity[]}
   */
  protected filterFieldItems(): IDataEntity[] {
    const mdCtrlList: string[] = [];
    const data = this.view.state.data;
    const str = this.items
      .map(item => {
        if (item.detailtype === 'FORMITEM') {
          if (data.formtype === 'EDITFORM') {
            return `|${item.psdefid}`;
          }
          if (data.formtype === 'SEARCHFORM') {
            return `|${item.psdefsfitemid}`;
          }
        }
        if (item.detailtype === 'MDCTRL' && item.psdefid) {
          mdCtrlList.push(item.psdefid);
        }
        return '';
      })
      .join('');
    return this.fieldItems.filter(item => {
      if (this.mdCtrlFieldType.includes(item.psdatatypeid)) {
        if (!mdCtrlList.includes(item.srfkey)) {
          return true;
        }
        return false;
      }
      if (item.srfkey && str.indexOf(`|${item.srfkey}`) === -1) {
        return true;
      }
      return false;
    });
  }

  /**
   * 转换属性项
   *
   * @author zhanghengfeng
   * @date 2024-02-04 17:02:39
   * @protected
   */
  protected debounceTransformFieldItems(): void {
    this.transformFieldItems();
  }

  /**
   * 转换属性项
   *
   * @author zhanghengfeng
   * @date 2024-01-09 18:01:59
   * @protected
   * @return {*}  {void}
   */
  protected transformFieldItems(): void {
    const items = this.filterFieldItems();
    this.state.items.forEach(parent => {
      const data = JSON.parse(parent.data || '{}');
      parent.codeItems = items.map(item => {
        let text: string = item.logicname || item.caption;
        if (item.psdefsfitemname || item.psdefieldname) {
          text += `[${item.psdefsfitemname || item.psdefieldname}]`;
        }
        if (this.view.state.data.formtype === 'EDITFORM') {
          return {
            appId: parent.appId,
            text,
            iconPath: parent.iconPath,
            data: JSON.stringify({
              ...data,
              caption: item.logicname,
              logicname: item.logicname,
              psdefid: item.psdefieldid,
              psdefname: item.psdefieldname,
              detailtype: this.mdCtrlFieldType.includes(item.psdatatypeid)
                ? 'MDCTRL'
                : 'FORMITEM',
              formtype: this.view.state.data.formtype,
            }),
          };
        }
        return {
          appId: parent.appId,
          text,
          iconPath: parent.iconPath,
          data: JSON.stringify({
            ...data,
            caption: item.logicname,
            logicname: item.logicname,
            psdefsfitemid: item.psdefsfitemid,
            psdefsfitemname: item.psdefsfitemname,
            psdefname: item.psdefname,
            psdefid: item.psdefid,
            detailtype: 'FORMITEM',
            formtype: this.view.state.data.formtype,
          }),
        };
      });
    });
    this.codeItems = this.state.items;
    this.filter();
  }
}
