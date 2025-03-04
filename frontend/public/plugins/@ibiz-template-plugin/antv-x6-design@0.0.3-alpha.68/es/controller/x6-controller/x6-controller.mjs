import '../../node_modules/.pnpm/@antv_x6@2.18.1/node_modules/@antv/x6/es/index.mjs';
import { Scroller } from '../../node_modules/.pnpm/@antv_x6-plugin-scroller@2.0.10_@antv_x6@2.18.1/node_modules/@antv/x6-plugin-scroller/es/index.mjs';
import { MiniMap } from '../../node_modules/.pnpm/@antv_x6-plugin-minimap@2.0.7_@antv_x6@2.18.1/node_modules/@antv/x6-plugin-minimap/es/index.mjs';
import { Snapline } from '../../node_modules/.pnpm/@antv_x6-plugin-snapline@2.1.7_@antv_x6@2.18.1/node_modules/@antv/x6-plugin-snapline/es/index.mjs';
import { Clipboard } from '../../node_modules/.pnpm/@antv_x6-plugin-clipboard@2.1.6_@antv_x6@2.18.1/node_modules/@antv/x6-plugin-clipboard/es/index.mjs';
import { Keyboard } from '../../node_modules/.pnpm/@antv_x6-plugin-keyboard@2.2.3_@antv_x6@2.18.1/node_modules/@antv/x6-plugin-keyboard/es/index.mjs';
import { Selection } from '../../node_modules/.pnpm/@antv_x6-plugin-selection@2.2.2_@antv_x6@2.18.1/node_modules/@antv/x6-plugin-selection/es/index.mjs';
import { Export } from '../../node_modules/.pnpm/@antv_x6-plugin-export@2.1.6_@antv_x6@2.18.1/node_modules/@antv/x6-plugin-export/es/index.mjs';
import { ControllerEvent } from '@ibiz-template/runtime';
import { Namespace } from '@ibiz-template/core';
import '../../utils/index.mjs';
import { X6NodeController } from '../x6-node-controller/x6-node-controller.mjs';
import { X6LinkController } from '../x6-link-controller/x6-link-controller.mjs';
import { defaultX6Options } from '../../utils/default-x6-options/default-x6-options.mjs';
import { Graph } from '../../node_modules/.pnpm/@antv_x6@2.18.1/node_modules/@antv/x6/es/graph/graph.mjs';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class X6Controller {
  /**
   * Creates an instance of X6Controller.
   * @author chitanda
   * @date 2023-11-20 16:11:50
   * @param {IPanelController} panel
   * @param {HTMLElement} dom
   * @param {X6Options} [opt={}]
   */
  constructor(panel, dom, minimap, opt = {}) {
    this.panel = panel;
    this.dom = dom;
    this.minimap = minimap;
    this.opt = opt;
    /**
     * 当前x6图形实例
     *
     * @author chitanda
     * @date 2023-11-09 18:11:46
     * @type {Graph}
     */
    __publicField(this, "g");
    /**
     * 拖拽工具
     *
     * @author chitanda
     * @date 2023-11-09 21:11:50
     * @type {Dnd}
     */
    // readonly dnd: Dnd;
    /**
     * 样式命名空间
     *
     * @author chitanda
     * @date 2023-11-09 17:11:12
     * @protected
     */
    __publicField(this, "ns", new Namespace("x6-panel-item"));
    /**
     * 节点控制器
     *
     * @author chitanda
     * @date 2023-11-16 18:11:29
     * @type {X6NodeController}
     */
    __publicField(this, "node");
    /**
     * 连线适控制器
     *
     * @author chitanda
     * @date 2023-11-16 18:11:00
     * @type {X6LinkController}
     */
    __publicField(this, "link");
    /**
     * @description x6事件
     * @type {ControllerEvent<X6ControllerEvent>}
     * @memberof X6Controller
     */
    __publicField(this, "evt", new ControllerEvent(this.getEventArgs.bind(this)));
    /**
     * 滚动条位置
     *
     * @author zhanghengfeng
     * @date 2025-01-10 19:01:22
     * @type {{ left: number; top: number }}
     */
    __publicField(this, "scrollbarPosition", { left: 0, top: 0 });
    /**
     * x6图形配置
     *
     * @author chitanda
     * @date 2023-11-09 18:11:29
     * @protected
     * @type {Graph.Options}
     */
    __publicField(this, "graphOptions", {
      autoResize: true,
      connecting: {
        allowMulti: false,
        allowLoop: false,
        allowEdge: false,
        allowBlank: false
      },
      // 最小最大缩放级别
      panning: {
        enabled: false
      },
      // 滚轮缩放
      mousewheel: {
        enabled: true,
        modifiers: ["ctrl", "meta"]
      },
      // 网格系统
      grid: {
        size: 10,
        // 网格大小 10px
        visible: true,
        // 是否显示渲染网格背景
        type: "mesh",
        // 网格类型 'dot' | 'fixedDot' | 'mesh'
        // 网格样式配置
        args: [
          {
            color: "#f0f0f0",
            // 主网格线颜色
            thickness: 1
            // 主网格线宽度
          },
          {
            color: "#ddd",
            // 次网格线颜色
            thickness: 1,
            // 次网格线宽度
            factor: 4
            // 主次网格线间隔
          }
        ]
      },
      // 高亮
      highlighting: {
        nodeAvailable: {
          name: "stroke",
          args: {
            padding: 4,
            attrs: {
              "stroke-width": 2,
              stroke: "red"
            }
          }
        },
        magnetAvailable: {
          name: "stroke",
          args: {
            padding: 3,
            attrs: {
              strokeWidth: 3,
              stroke: "#52c41a"
            }
          }
        }
      }
    });
    this.opt = defaultX6Options(opt);
    this.graphOptions.container = dom;
    this.g = new Graph(this.graphOptions);
    this.link = new X6LinkController(panel, this.g);
    this.node = new X6NodeController(panel, this.g);
    this.init();
  }
  /**
   * 设置滚动条位置
   *
   * @author zhanghengfeng
   * @date 2025-01-10 19:01:42
   * @param {{ left: number; top: number }} position
   */
  setScrollbarPosition(position) {
    this.scrollbarPosition = position;
  }
  getEventArgs() {
    return {
      context: this.panel.context,
      params: this.panel.params,
      data: [],
      eventArg: "",
      targetName: this.panel.model.name,
      view: this.panel.view
    };
  }
  init() {
    this.g.use(
      new Scroller({
        enabled: true,
        pannable: true
      })
    );
    if (this.opt.minimap === true) {
      if (this.minimap) {
        this.g.use(
          new MiniMap({
            container: this.minimap
          })
        );
      } else {
        throw new Error("\u672A\u627E\u5230\u5C0F\u5730\u56FE\u5BB9\u5668");
      }
    }
    this.g.use(new Snapline({ enabled: true, sharp: true }));
    this.g.use(new Clipboard({ enabled: true }));
    this.g.use(new Keyboard({ enabled: true }));
    this.g.use(
      new Selection({
        enabled: true,
        multiple: true,
        rubberband: true,
        movable: true,
        showNodeSelectionBox: false,
        modifiers: ["ctrl", "meta"]
      })
    );
    this.g.use(new Export());
    this.node.init();
    this.link.init();
    this.g.bindKey("ctrl+c", () => {
      const cells = this.g.getSelectedCells();
      if (cells.length) {
        this.g.copy(cells.filter((cell) => cell.isNode()));
      }
      return false;
    });
    this.g.bindKey("ctrl+v", () => {
      if (!this.g.isClipboardEmpty()) {
        this.g.paste({
          offset: 32,
          nodeProps: { data: { isCopy: true } }
        });
      }
      return false;
    });
    this.initEvents();
  }
  initEvents() {
    this.g.on("blank:click", () => {
      this.panel.view.call("onActiveRoot");
    });
    this.g.on("graph:mouseleave", () => {
      this.scrollbarPosition = this.g.getScrollbarPosition();
    });
    this.g.on("resize", () => {
      if (this.panel.state.activated) {
        this.scrollbarPosition = this.g.getScrollbarPosition();
      }
    });
  }
  async load() {
    this.evt.emit("onBeforeLoad", void 0);
    await this.node.load();
    await this.link.load();
    this.evt.emit("onLoadSuccess", void 0);
  }
  async refresh() {
    this.g.clearCells({ refresh: true });
    await this.load();
  }
  /**
   * 销毁
   *
   * @author chitanda
   * @date 2023-11-09 17:11:16
   */
  destroy() {
    this.g.dispose();
    this.node.destroy();
    this.link.destroy();
  }
}

export { X6Controller };
