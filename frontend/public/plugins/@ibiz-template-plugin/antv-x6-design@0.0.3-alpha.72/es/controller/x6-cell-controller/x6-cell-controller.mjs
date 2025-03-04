"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class X6CellController {
  constructor(panel, g) {
    this.panel = panel;
    /**
     * 当前视图上下文(由外部传入)
     *
     * @author chitanda
     * @date 2023-11-20 11:11:59
     * @protected
     * @type {IContext}
     */
    __publicField(this, "context");
    /**
     * 当前图形参数(由外部传入)
     *
     * @author chitanda
     * @date 2023-11-20 11:11:29
     * @protected
     * @type {IParams}
     */
    __publicField(this, "params");
    /**
     * 当前x6图形实例
     *
     * @author chitanda
     * @date 2023-11-09 18:11:46
     * @type {Graph}
     */
    __publicField(this, "g");
    /**
     * 连线表单模型对象
     *
     * @author chitanda
     * @date 2023-11-21 12:11:45
     * @protected
     * @type {IDEEditForm}
     */
    __publicField(this, "model");
    /**
     * 当前数据
     *
     * @author chitanda
     * @date 2023-11-21 17:11:24
     * @protected
     * @type {IDataEntity[]}
     */
    __publicField(this, "items", []);
    /**
     * 当前数据映射，用于快速查找
     *
     * @description 主键为key
     * @author chitanda
     * @date 2023-11-22 12:11:32
     * @type {Map<string, X6CellDataProvider>}
     */
    __publicField(this, "map", /* @__PURE__ */ new Map());
    /**
     * 图形适配器
     *
     * @author zhanghengfeng
     * @date 2023-12-11 19:12:02
     * @type {X6CellServiceProvider}
     */
    __publicField(this, "provider");
    this.context = panel.context;
    this.params = panel.params;
    this.g = g;
  }
  /**
   * 由外部调用进行初始化(不可以重写)
   *
   * @author chitanda
   * @date 2023-11-21 11:11:25
   * @return {*}  {Promise<void>}
   */
  init() {
    return this.onInit();
  }
  /**
   * 初始化(子类重写)
   *
   * @author chitanda
   * @date 2023-11-21 11:11:23
   * @protected
   */
  onInit() {
    this.onMessageChange = this.onMessageChange.bind(this);
    ibiz.mc.command.update.on(this.onMessageChange);
  }
  /**
   * 监听消息变更
   *
   * @author zhanghengfeng
   * @date 2024-01-10 17:01:46
   * @protected
   * @param {IPortalMessage} msg
   */
  onMessageChange(msg) {
    if (msg.data && typeof msg.data === "object") {
      const id = msg.data.srfkey;
      if (id && this.map.has(id)) {
        const cell = this.g.getCellById(id);
        if (cell) {
          const dataProvider = this.provider.createDataProvider(
            msg.data
          );
          this.map.set(id, dataProvider);
          cell.trigger("update", dataProvider);
        }
      }
    }
  }
  /**
   * 销毁
   *
   * @author zhanghengfeng
   * @date 2024-01-10 17:01:36
   */
  destroy() {
    ibiz.mc.command.update.off(this.onMessageChange);
  }
}

export { X6CellController };
