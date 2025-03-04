import { Graph } from '@antv/x6';
import { Scroller } from '@antv/x6-plugin-scroller';
import { MiniMap } from '@antv/x6-plugin-minimap';
import { Snapline } from '@antv/x6-plugin-snapline';
import { Clipboard } from '@antv/x6-plugin-clipboard';
import { Keyboard } from '@antv/x6-plugin-keyboard';
// import { History } from '@antv/x6-plugin-history';
import { Selection } from '@antv/x6-plugin-selection';
// import { Dnd } from '@antv/x6-plugin-dnd';
import { Export } from '@antv/x6-plugin-export';
import {
  ControllerEvent,
  EventBase,
  IPanelController,
} from '@ibiz-template/runtime';
import { Namespace } from '@ibiz-template/core';
import { X6Options } from '../../interface';
import { defaultX6Options } from '../../utils';
import { X6NodeController } from '../x6-node-controller/x6-node-controller';
import { X6LinkController } from '../x6-link-controller/x6-link-controller';
import { X6ControllerEvent } from './x6-controller.event';

/**
 * 负责对x6的图形进行操作
 *
 * @author chitanda
 * @date 2023-11-09 17:11:33
 * @export
 * @class X6Controller
 */
export class X6Controller {
  /**
   * 当前x6图形实例
   *
   * @author chitanda
   * @date 2023-11-09 18:11:46
   * @type {Graph}
   */
  readonly g: Graph;

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
  protected ns = new Namespace('x6-panel-item');

  /**
   * 节点控制器
   *
   * @author chitanda
   * @date 2023-11-16 18:11:29
   * @type {X6NodeController}
   */
  readonly node: X6NodeController;

  /**
   * 连线适控制器
   *
   * @author chitanda
   * @date 2023-11-16 18:11:00
   * @type {X6LinkController}
   */
  readonly link: X6LinkController;

  /**
   * @description x6事件
   * @type {ControllerEvent<X6ControllerEvent>}
   * @memberof X6Controller
   */
  evt: ControllerEvent<X6ControllerEvent> =
    new ControllerEvent<X6ControllerEvent>(this.getEventArgs.bind(this));

  /**
   * 滚动条位置
   *
   * @author zhanghengfeng
   * @date 2025-01-10 19:01:22
   * @type {{ left: number; top: number }}
   */
  scrollbarPosition: { left: number; top: number } = { left: 0, top: 0 };

  /**
   * 设置滚动条位置
   *
   * @author zhanghengfeng
   * @date 2025-01-10 19:01:42
   * @param {{ left: number; top: number }} position
   */
  setScrollbarPosition(position: { left: number; top: number }): void {
    this.scrollbarPosition = position;
  }

  protected getEventArgs(): Omit<EventBase, 'eventName'> {
    return {
      context: this.panel.context,
      params: this.panel.params,
      data: [],
      eventArg: '',
      targetName: this.panel.model.name!,
      view: this.panel.view,
    };
  }

  /**
   * x6图形配置
   *
   * @author chitanda
   * @date 2023-11-09 18:11:29
   * @protected
   * @type {Graph.Options}
   */
  protected graphOptions: Graph.Options = {
    autoResize: true,
    connecting: {
      allowMulti: false,
      allowLoop: false,
      allowEdge: false,
      allowBlank: false,
    },
    // 最小最大缩放级别
    panning: {
      enabled: false,
    },
    // 滚轮缩放
    mousewheel: {
      enabled: true,
      modifiers: ['ctrl', 'meta'],
    },
    // 网格系统
    grid: {
      size: 10, // 网格大小 10px
      visible: true, // 是否显示渲染网格背景
      type: 'mesh', // 网格类型 'dot' | 'fixedDot' | 'mesh'
      // 网格样式配置
      args: [
        {
          color: '#f0f0f0', // 主网格线颜色
          thickness: 1, // 主网格线宽度
        },
        {
          color: '#ddd', // 次网格线颜色
          thickness: 1, // 次网格线宽度
          factor: 4, // 主次网格线间隔
        },
      ],
    },
    // 高亮
    highlighting: {
      nodeAvailable: {
        name: 'stroke',
        args: {
          padding: 4,
          attrs: {
            'stroke-width': 2,
            stroke: 'red',
          },
        },
      },
      magnetAvailable: {
        name: 'stroke',
        args: {
          padding: 3,
          attrs: {
            strokeWidth: 3,
            stroke: '#52c41a',
          },
        },
      },
    },
  };

  /**
   * Creates an instance of X6Controller.
   * @author chitanda
   * @date 2023-11-20 16:11:50
   * @param {IPanelController} panel
   * @param {HTMLElement} dom
   * @param {X6Options} [opt={}]
   */
  constructor(
    protected panel: IPanelController,
    protected dom: HTMLElement,
    protected minimap: HTMLElement,
    protected opt: X6Options = {},
  ) {
    this.opt = defaultX6Options(opt);
    this.graphOptions.container = dom;
    this.g = new Graph(this.graphOptions);
    // this.dnd = new Dnd({ target: this.g });
    this.link = new X6LinkController(panel, this.g);
    this.node = new X6NodeController(panel, this.g);
    this.init();
  }

  protected init(): void {
    // 滚动画布插件
    this.g.use(
      new Scroller({
        enabled: true,
        pannable: true,
      }),
    );
    // 小地图插件
    if (this.opt.minimap === true) {
      if (this.minimap) {
        this.g.use(
          new MiniMap({
            container: this.minimap,
          }),
        );
      } else {
        throw new Error('未找到小地图容器');
      }
    }
    // 滚动画布插件
    // this.g.use(new Scroller({ enabled: true }));
    // 对齐线插件
    this.g.use(new Snapline({ enabled: true, sharp: true }));
    // 剪切板插件
    this.g.use(new Clipboard({ enabled: true }));
    // 快捷键插件
    this.g.use(new Keyboard({ enabled: true }));
    // 历史记录插件
    // this.g.use(new History({ enabled: true }));
    // 框选插件
    this.g.use(
      new Selection({
        enabled: true,
        multiple: true,
        rubberband: true,
        movable: true,
        showNodeSelectionBox: false,
        modifiers: ['ctrl', 'meta'],
      }),
    );
    // 导出插件
    this.g.use(new Export());
    // 初始化节点和连线控制器
    this.node.init();
    this.link.init();
    this.g.bindKey('ctrl+c', () => {
      const cells = this.g.getSelectedCells();
      if (cells.length) {
        this.g.copy(cells.filter(cell => cell.isNode()));
      }
      return false;
    });

    this.g.bindKey('ctrl+v', () => {
      if (!this.g.isClipboardEmpty()) {
        this.g.paste({
          offset: 32,
          nodeProps: { data: { isCopy: true } },
        });
      }
      return false;
    });
    this.initEvents();
  }

  protected initEvents(): void {
    this.g.on('blank:click', () => {
      this.panel.view.call('onActiveRoot');
    });
    this.g.on('graph:mouseleave', () => {
      this.scrollbarPosition = this.g.getScrollbarPosition();
    });
    this.g.on('resize', () => {
      if (this.panel.state.activated) {
        this.scrollbarPosition = this.g.getScrollbarPosition();
      }
    });
  }

  async load(): Promise<void> {
    this.evt.emit('onBeforeLoad', undefined);
    await this.node.load();
    await this.link.load();
    this.evt.emit('onLoadSuccess', undefined);
  }

  async refresh(): Promise<void> {
    this.g.clearCells({ refresh: true });
    await this.load();
  }

  /**
   * 销毁
   *
   * @author chitanda
   * @date 2023-11-09 17:11:16
   */
  destroy(): void {
    this.g.dispose();
    this.node.destroy();
    this.link.destroy();
  }
}
