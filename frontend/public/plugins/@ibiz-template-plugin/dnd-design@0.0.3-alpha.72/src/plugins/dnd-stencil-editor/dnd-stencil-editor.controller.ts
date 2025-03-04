/* eslint-disable eqeqeq */
import {
  ICodeListEditor,
  IDEEditForm,
  IDEFormGroupPanel,
} from '@ibiz/model-core';
import {
  ButtonContainerState,
  IAppDEService,
  IButtonContainerState,
  UIActionButtonState,
  getControl,
} from '@ibiz-template/runtime';
import { RuntimeModelError } from '@ibiz-template/core';
import { DndStencilPanelItemController } from '../../panel-items/dnd-stencil/dnd-stencil.controller';

export class DndStencilEditorController extends DndStencilPanelItemController {
  /**
   * 主表单
   *
   * @author zhanghengfeng
   * @date 2025-01-22 19:01:14
   * @protected
   * @type {IDEEditForm}
   */
  protected majorForm!: IDEEditForm;

  /**
   * 主表单服务
   *
   * @author zhanghengfeng
   * @date 2025-01-22 19:01:22
   * @protected
   * @type {IAppDEService}
   */
  protected majorService!: IAppDEService;

  /**
   * 编辑器表单
   *
   * @author zhanghengfeng
   * @date 2025-01-22 19:01:33
   * @protected
   * @type {IDEEditForm}
   */
  protected editorForm!: IDEEditForm;

  /**
   * 编辑器表单服务
   *
   * @author zhanghengfeng
   * @date 2025-01-22 19:01:46
   * @protected
   * @type {IAppDEService}
   */
  protected editorService!: IAppDEService;

  /**
   * 是否启用分组呈现
   *
   * @author zhanghengfeng
   * @date 2025-01-22 19:01:07
   * @type {boolean}
   */
  enableGroup: boolean = true;

  /**
   * 初始化
   *
   * @author zhanghengfeng
   * @date 2025-01-22 19:01:17
   * @protected
   * @return {*}  {Promise<void>}
   */
  protected async onInit(): Promise<void> {
    await this.initBaseResource();
    await super.onInit();
  }

  /**
   * 初始化基础资源
   *
   * @author zhanghengfeng
   * @date 2025-01-22 19:01:29
   * @protected
   * @return {*}  {Promise<void>}
   */
  protected async initBaseResource(): Promise<void> {
    const app = ibiz.hub.getApp(this.view.model.appId);
    const majorForm = getControl(this.view.model, 'form');
    if (!majorForm) {
      throw new RuntimeModelError(this.view, '未找到 form 表单模型');
    }
    this.majorForm = majorForm;
    this.majorService = await app.deService.getService(
      this.panel.context,
      this.majorForm.appDataEntityId!,
    );
    const editorForm = getControl(this.view.model, 'editor');
    if (!editorForm) {
      throw new RuntimeModelError(this.view, '未找到 editor 表单模型');
    }
    this.editorForm = editorForm;
    this.editorService = await app.deService.getService(
      this.panel.context,
      this.editorForm.appDataEntityId!,
    );
    const editor = this.model.editor as ICodeListEditor;
    if (editor) {
      const { appCodeListId } = editor;
      if (appCodeListId) {
        this.codeList = app.codeList.getCodeList(appCodeListId)!;
      }
      if (!this.codeList) {
        throw new RuntimeModelError(this.model, `未配置用户扩展编辑器代码表`);
      }
    } else {
      ibiz.log.warn('拖拽素材区控制器的 editor 为空');
    }
    await this.initButtonGroup();
  }

  /**
   * 加载数据
   *
   * @author zhanghengfeng
   * @date 2025-01-22 19:01:20
   * @return {*}  {Promise<void>}
   */
  async load(): Promise<void> {
    const majorResult = await this.majorService.getTemp(
      this.panel.context,
      this.panel.params,
    );
    if (!majorResult || !majorResult.ok || !majorResult.data) {
      return;
    }
    const editorResult = await this.editorService.exec(
      'FetchCurSysWithIcon',
      this.panel.context,
      this.panel.params,
    );
    if (
      !editorResult ||
      !editorResult.ok ||
      !Array.isArray(editorResult.data)
    ) {
      return;
    }
    const formData = majorResult.data;
    const editorData = editorResult.data;
    const items = editorData.filter(item => {
      const editorType = item.pseditortypeid;
      if (
        editorType === 'HIDDEN' ||
        editorType === 'USERCONTROL' ||
        editorType === 'SPAN'
      ) {
        return true;
      }
      if (formData && item.validflag == 1) {
        if (formData.mobflag == 1 && /^MOB/.test(editorType)) {
          return true;
        }
        if (formData.mobflag != 1 && !/^MOB/.test(editorType)) {
          return true;
        }
      }
      return false;
    });
    const codeItems = this.codeList.codeItems || [];
    this.state.items = codeItems.map(codeItem => {
      const parent = { ...codeItem };
      const data = JSON.parse(parent.data || '{}');
      parent.codeItems = items.map(item => {
        let text = `${item.pssyseditorstylename || ''}`;
        text += item.pseditortypename ? `(${item.pseditortypename})` : '';
        return {
          appId: parent.appId,
          text,
          iconPath: item.studioicon || parent.iconPath,
          data: JSON.stringify({
            ...data,
            detailtype: 'FORMITEM',
            formtype: formData.formtype,
            pssyseditorstylename: item.pssyseditorstylename,
            pssyseditorstyleid: item.pssyseditorstyleid,
            editortype: item.pseditortypeid,
            editortypename: item.pseditortypename,
            width: item.width,
            height: item.height,
          }),
        };
      });
      return parent;
    });
    this.codeItems = this.state.items;
    this.filter();
  }

  /**
   * 初始化界面行为按钮
   *
   * @author zhanghengfeng
   * @date 2025-01-22 19:01:51
   * @protected
   * @return {*}  {Promise<void>}
   */
  protected async initButtonGroup(): Promise<void> {
    if (this.editorForm) {
      const pages = this.editorForm.deformPages;
      if (!Array.isArray(pages) || !pages[0]) {
        ibiz.log.warn('editor 表单模型未配置表单分页');
        return;
      }
      const page = pages[0];
      const formDetails = page.deformDetails;
      const group = formDetails?.find(
        item => item.codeName === 'editor_group',
      ) as IDEFormGroupPanel;
      if (!group) {
        ibiz.log.warn('editor 表单模型未配置标识为 editor_group 表单分组');
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
   * @date 2025-01-22 19:01:04
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
}
