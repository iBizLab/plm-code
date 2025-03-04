import { ViewController, getPFPlugin } from '@ibiz-template/runtime';
import { DndDesignViewEngine } from './dnd-design-view.engine.mjs';
import '../../utils/index.mjs';
import { DndPreViewFactory } from '../../preview-providers/dnd-preview-factory.mjs';
import { SelectState } from '../../utils/select-state/select-state.mjs';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class DndDesignViewController extends ViewController {
  constructor() {
    super(...arguments);
    /**
     * 视图中的选中数据
     *
     * @author chitanda
     * @date 2023-12-21 18:12:25
     */
    __publicField(this, "select", new SelectState());
    /**
     * 预览适配器
     *
     * @author tony001
     * @date 2024-09-06 15:09:59
     * @private
     * @type {IPreviewProvider}
     */
    __publicField(this, "preViewProvider");
  }
  /**
   * 获取预览区适配器
   *
   * @author tony001
   * @date 2024-09-06 15:09:07
   * @return {*}  {IPreviewProvider}
   */
  getPreViewProvider() {
    return this.preViewProvider;
  }
  /**
   * 生命周期-创建完成
   * - 将插件参数合入上下文中
   * @protected
   * @return {*}  {Promise<void>}
   * @memberof DndDesignViewController
   */
  async onCreated() {
    await super.onCreated();
    const { sysPFPluginId, appId } = this.model;
    const plugin = getPFPlugin(sysPFPluginId, appId);
    if (plugin && plugin.pluginParams) {
      const params = plugin.pluginParams;
      Object.keys(params).forEach((key) => {
        if (params[key] && key !== "appId") {
          this.context[key.toLowerCase()] = params[key];
        }
      });
    }
    const srfRunMode = this.context.srfrunmode ? this.context.srfrunmode : "RUNTIME";
    this.preViewProvider = DndPreViewFactory.getInstance().getProvider(
      srfRunMode
    );
    await this.preViewProvider.init(this);
  }
  initEngines() {
    this.engines.push(new DndDesignViewEngine(this));
  }
}

export { DndDesignViewController };
