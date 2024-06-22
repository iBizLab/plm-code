import { RuntimeModelError } from '@ibiz-template/core';
import {
  IButtonContainerState,
  PanelItemController,
  UIActionUtil,
} from '@ibiz-template/runtime';
import {
  IAppCodeList,
  ICodeItem,
  ICodeListEditor,
  IDEFormGroupPanel,
  IPanelField,
  IUIActionGroupDetail,
} from '@ibiz/model-core';
import { DndDesignViewController } from '../../views';
import { DndStencilPanelItemState } from './dnd-stencil.state';

/**
 * 拖拽素材区控制器
 *
 * @author chitanda
 * @date 2023-12-14 16:12:54
 * @export
 * @class DndStencilPanelItemController
 * @extends {PanelItemController<IPanelField>}
 */
export class DndStencilPanelItemController extends PanelItemController<IPanelField> {
  codeList!: IAppCodeList;

  /**
   * 代码表项
   *
   * @author zhanghengfeng
   * @date 2024-01-11 18:01:27
   * @protected
   * @type {ICodeItem[]}
   */
  protected codeItems: ICodeItem[] = [];

  /**
   * 是否启用分组呈现
   *
   * @author chitanda
   * @date 2023-12-23 15:12:05
   * @type {boolean}
   */
  enableGroup: boolean = false;

  declare state: DndStencilPanelItemState;

  protected createState(): DndStencilPanelItemState {
    return new DndStencilPanelItemState(this.parent?.state);
  }

  get view(): DndDesignViewController {
    return this.panel.view as DndDesignViewController;
  }

  /**
   * 按钮分组映射
   *
   * @author zhanghengfeng
   * @date 2024-01-12 18:01:05
   * @type {Map<
   *     string,
   *     { model: IDEFormGroupPanel; state: IButtonContainerState }
   *   >}
   */
  buttonGroupMap: Map<
    string,
    { model: IDEFormGroupPanel; state: IButtonContainerState }
  > = new Map();

  protected async onInit(): Promise<void> {
    await super.onInit();
    await this.load();
    this.view.evt.on('onStencilSearch', e => {
      const searchValue = e.eventArg || '';
      this.state.filterValue = searchValue.trim().toLowerCase();
      this.filter();
    });
  }

  async load(): Promise<void> {
    const editor = this.model.editor as ICodeListEditor;
    if (editor) {
      const { appCodeListId } = editor;
      if (appCodeListId) {
        const app = await ibiz.hub.getApp(this.model.appId);
        this.codeList = app.codeList.getCodeList(appCodeListId)!;
      }
      if (!this.codeList) {
        throw new RuntimeModelError(this.model, `未配置素材区代码表`);
      }
      this.codeItems = this.codeList.codeItems || [];
      // 判断是否启用分组代码表项，有分组默认只能用分组模式
      const index = this.codeItems.findIndex(item => {
        if (item.codeItems && item.codeItems.length > 1) {
          return true;
        }
        return false;
      });
      this.enableGroup = index !== -1;
      this.state.items = this.codeItems;
      this.filter();
    } else {
      ibiz.log.warn('拖拽素材区控制器的 editor 为空');
    }
  }

  /**
   * 过滤项
   *
   * @author zhanghengfeng
   * @date 2024-01-11 19:01:19
   * @protected
   * @return {*}  {void}
   */
  protected filter(): void {
    if (!this.state.filterValue) {
      this.state.items = this.codeItems;
      return;
    }
    if (this.enableGroup) {
      this.state.items = [];
      this.codeItems.forEach(item => {
        const group = { ...item };
        if (!Array.isArray(group.codeItems)) {
          group.codeItems = [];
        }
        group.codeItems = group.codeItems.filter(codeItem => {
          return (
            codeItem.text &&
            codeItem.text.toLowerCase().includes(this.state.filterValue)
          );
        });
        this.state.items.push(group);
      });
    } else {
      this.state.items = this.codeItems.filter(item => {
        return (
          item.text && item.text.toLowerCase().includes(this.state.filterValue)
        );
      });
    }
  }

  /**
   * 监听行为组点击
   *
   * @author zhanghengfeng
   * @date 2024-01-12 18:01:48
   * @param {IUIActionGroupDetail} detail
   * @param {MouseEvent} event
   * @return {*}  {Promise<void>}
   */
  async onActionClick(
    detail: IUIActionGroupDetail,
    event: MouseEvent,
  ): Promise<void> {
    const actionId = detail.uiactionId;

    await UIActionUtil.execAndResolved(
      actionId!,
      {
        context: this.panel.context,
        params: this.panel.params,
        data: [],
        view: this.panel.view,
        event,
      },
      detail.appId,
    );
  }
}
