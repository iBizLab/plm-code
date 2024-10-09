import { ViewController, getPFPlugin } from '@ibiz-template/runtime';
import '../utils/index.mjs';
import { SelectState } from '../utils/select-state/select-state.mjs';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class DesignViewControllerBase extends ViewController {
  constructor() {
    super(...arguments);
    /**
     * 选中数据
     *
     * @author tony001
     * @date 2024-09-10 10:09:14
     */
    __publicField(this, "select", new SelectState());
    /**
     * 预览适配器
     *
     * @author tony001
     * @date 2024-09-10 10:09:18
     * @protected
     * @type {IDesignPreviewProvider}
     */
    __publicField(this, "preViewProvider");
  }
  /**
   * 获取预览区适配器
   *
   * @author tony001
   * @date 2024-09-10 10:09:33
   * @return {*}  {IDesignPreviewProvider}
   */
  getPreViewProvider() {
    return this.preViewProvider;
  }
  /**
   * 生命周期-创建完成(将插件参数合入上下文中)
   *
   * @author tony001
   * @date 2024-09-10 10:09:15
   * @protected
   * @return {*}  {Promise<void>}
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
    await this.initPreViewProvider();
  }
  /**
   * 初始化预览适配器
   *
   * @author tony001
   * @date 2024-09-10 10:09:56
   * @protected
   * @return {*}  {Promise<void>}
   */
  async initPreViewProvider() {
    throw new Error("Method not implemented.");
  }
}

export { DesignViewControllerBase };
