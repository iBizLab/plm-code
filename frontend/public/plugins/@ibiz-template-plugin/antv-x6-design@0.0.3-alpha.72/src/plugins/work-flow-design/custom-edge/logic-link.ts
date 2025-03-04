import { Shape, Edge, EdgeView, Cell, Dom } from '@antv/x6';
import { IDataEntity } from '@ibiz-template/runtime';
import { Namespace } from '@ibiz-template/core';
import { X6LinkDataProvider } from '../../../interface';
import { linkUtil } from '../utils';

export const lightningTool = {
  name: 'button',
  args: {
    markup: [
      {
        tagName: 'path',
        selector: 'icon',
        attrs: {
          d: 'M7.558 2.282h7.166l-2.728 5.36 4.63 0.006-9.702 11.186 2.79-7.128H4.452z',
          fill: '#FED928',
          stroke: 'none',
          'stroke-width': 2,
          cursor: 'pointer',
        },
      },
    ],
    distance: '50%',
    offset: { x: 0, y: 20 },
    zIndex: 999,
    name: 'lightning-tool',
  },
};

export const verticesTool = {
  name: 'vertices',
  args: {
    attrs: { fill: '#666' },
  },
};

export const edgeToolbar = [
  {
    text: '切换',
    key: 'shift',
    icon: 'shift',
  },
];

export const boundaryTool = {
  name: 'boundary',
  args: {
    useCellGeometry: false,
    padding: 5,
    attrs: {
      fill: '#7c68fc',
      stroke: '#333',
      strokeWidth: 0.5,
      fillOpacity: 0.2,
    },
  },
};

/**
 * 逻辑连线
 *
 * @author chitanda
 * @date 2023-11-24 14:11:16
 * @export
 * @class LogicLink
 * @extends {Shape.Edge}
 */
export class LogicLink extends Shape.Edge {
  shiftButtonStatus: boolean = false;

  setLightningTool(dataProvider: X6LinkDataProvider<IDataEntity>): void {
    if (!dataProvider) {
      return;
    }
    let logicLinkCount = 0;
    const data = dataProvider.data;
    if (data) {
      if (data.linklogiccount != null) {
        logicLinkCount = data.linklogiccount;
      } else if (Array.isArray(data.pswflinkconds)) {
        logicLinkCount = data.pswflinkconds.length;
      }
    }
    const tools = this.getTools();
    if (tools) {
      const items = tools.items;
      if (Array.isArray(items)) {
        const index = items.findIndex(item => {
          if (item && typeof item === 'object') {
            return (
              item.name === 'button' &&
              item.args &&
              item.args.name === 'lightning-tool'
            );
          }
          return false;
        });
        if (index !== -1) {
          this.removeTool(index);
        }
      }
    }
    if (logicLinkCount) {
      this.addTools(lightningTool);
    }
  }

  constructor(metadata: Edge.Metadata = {}) {
    const dataProvider = metadata.dataProvider;
    super({
      markup: [
        {
          tagName: 'path',
          selector: 'wrap',
          attrs: {
            fill: 'none',
            cursor: 'pointer',
            stroke: 'transparent',
          },
        },
        {
          tagName: 'path',
          selector: 'line',
          attrs: {
            fill: 'none',
            cursor: 'pointer',
            stroke: 'transparent',
          },
        },
      ],
      attrs: {
        arrow: {
          d: 'M 0 -6 8 0 0 6 z',
          fill: dataProvider.type === 'TIMEOUT' ? 'red' : '#1890ff',
          stroke: dataProvider.type === 'TIMEOUT' ? 'red' : '#1890ff',
        },
        background: {
          color: 'rgba(0, 255, 0, 0.3)',
        },
        wrap: {
          connection: true,
          strokeWidth: 20,
          strokeLinejoin: 'round',
        },
        line: {
          connection: true,
          strokeLinejoin: 'round',
          targetMarker: 'classic',
          stroke: dataProvider.type === 'TIMEOUT' ? 'red' : '#82B1FF',
          strokeWidth: 2,
        },
      },
      connector: {
        name: 'jumpover',
      },
      router: {
        name: 'normal',
        args: {
          startDirections: ['top', 'right', 'bottom', 'left'],
          endDirections: ['top', 'right', 'bottom', 'left'],
        },
      },
      label: metadata.label,
      ...metadata,
    });
    this.setLightningTool(metadata.dataProvider);
    this.on('update', (linkDataProvider: X6LinkDataProvider<IDataEntity>) => {
      this.setData(JSON.stringify(linkDataProvider.data), { overwrite: true });
      this.setLabelAt(0, linkDataProvider.label);
      this.setLightningTool(linkDataProvider);
    });
    this.on('selected', (): void => {
      this.setAttrs({
        line: {
          stroke: '#feb663',
          strokeDasharray: 5,
          style: {
            animation: 'wf-link-ant-line 30s infinite linear',
          },
        },
        arrow: {
          fill: '#feb663',
          stroke: '#feb663',
        },
      });
      this.shiftButtonStatus = false;
      this.addTools(this.generateToolbarButton());
      if (!this.hasTool('boundary')) {
        this.addTools(boundaryTool);
      }
    });
    this.on('unselected', (): void => {
      this.setAttrs({
        line: {
          stroke: dataProvider.type === 'TIMEOUT' ? 'red' : '#82B1FF',
          strokeDasharray: 0,
          style: {
            animation: 'none',
          },
        },
        arrow: {
          fill: dataProvider.type === 'TIMEOUT' ? 'red' : '#1890ff',
          stroke: dataProvider.type === 'TIMEOUT' ? 'red' : '#1890ff',
        },
      });
      const tools = this.getTools();
      if (tools && tools.items) {
        const index = tools.items.findIndex(item => {
          if (
            item &&
            typeof item === 'object' &&
            item.args &&
            item.args.name === 'shift-button'
          ) {
            return true;
          }
          return false;
        });
        if (index !== -1) {
          this.removeTool(index);
        }
      }
      this.shiftButtonStatus = false;
      this.removeTool('boundary');
    });
    this.on('mouseenter', (args: IData): void => {
      const tools = this.getTools() || { items: [] };
      if (tools && tools.items) {
        const shiftButton = tools.items.find(item => {
          if (item && typeof item === 'object' && item.args && item.args.name) {
            if (item.args.name === 'shift-button') {
              return true;
            }
          }
          return false;
        });
        const boundary = this.hasTool('boundary');
        this.removeTools();
        if (!this.hasTool('source-arrowhead') && !this.shiftButtonStatus) {
          this.addTools({
            name: 'source-arrowhead',
            args: {
              attrs: {
                d: 'M 12,0 a5,5 0 1,0 10,0 a5,5 0 1,0 -10,0',
                fill: '#feb663',
              },
            },
          });
        }
        if (!this.hasTool('target-arrowhead') && !this.shiftButtonStatus) {
          this.addTools({
            name: 'target-arrowhead',
            args: {
              attrs: {
                d: 'M -20,0 a5,5 0 1,0 10,0 a5,5 0 1,0 -10,0',
                fill: '#feb663',
              },
            },
          });
        }
        this.setLightningTool(args.data);
        if (boundary) {
          this.addTools(boundaryTool);
        }
        if (this.shiftButtonStatus) {
          this.addTools(verticesTool);
        }
        if (shiftButton) {
          this.addTools(shiftButton);
        }
      }
      const view = args.view as EdgeView;
      if (!view) {
        return;
      }
      const container = view.graph.container;
      if (!container) {
        return;
      }
      linkUtil.changePortsVisible(true, container);
    });
    this.on('mouseleave', (args: IData): void => {
      const tools = this.getTools();
      if (tools && tools.items) {
        const shiftButton = tools.items.find(item => {
          if (item && typeof item === 'object' && item.args && item.args.name) {
            if (item.args.name === 'shift-button') {
              return true;
            }
          }
          return false;
        });
        const boundary = this.hasTool('boundary');
        this.removeTools();
        this.setLightningTool(args.data);
        if (boundary) {
          this.addTools(boundaryTool);
        }
        if (shiftButton) {
          this.addTools(shiftButton);
        }
      }
      const view = args.view as EdgeView;
      if (!view) {
        return;
      }
      const container = view.graph.container;
      if (!container) {
        return;
      }
      linkUtil.changePortsVisible(false, container);
    });
  }

  generateToolbarButton(): Cell.ToolItem[] {
    const ns = new Namespace('wf-link');
    const buttonTools: Cell.ToolItem[] = [];
    const id: {
      svg_shift_wrapper: string;
      svg_shift1: string;
      svg_shift2: string;
      [key: string]: string;
    } = {
      svg_shift_wrapper: ns.b('svg_shift_wrapper'),
      svg_shift1: ns.b('svg_shift1'),
      svg_shift2: ns.b('svg_shift2'),
    };
    const s = this.getSourceCell()?.getProp<{ x: number; y: number }>(
      'position',
    );
    const t = this.getTargetCell()?.getProp<{ x: number; y: number }>(
      'position',
    );
    if (s && t) {
      if (s.x < t.x) {
        if (s.y > t.y) {
          Object.keys(id).forEach(key => {
            id[key] += '_lb';
          });
        } else {
          Object.keys(id).forEach(key => {
            id[key] += '_lt';
          });
        }
      } else if (s.y > t.y) {
        Object.keys(id).forEach(key => {
          id[key] += '_rb';
        });
      } else {
        Object.keys(id).forEach(key => {
          id[key] += '_rt';
        });
      }
    } else {
      Object.keys(id).forEach(key => {
        id[key] += '_lb';
      });
    }
    edgeToolbar.forEach(() => {
      buttonTools.push({
        name: 'button',
        args: {
          markup: linkUtil.generateShiftButtonMarkup(
            id,
            this.shiftButtonStatus,
          ),
          distance: 0,
          zIndex: 999,
          name: 'shift-button',
          onClick: ({ e }: { e: Dom.MouseDownEvent }) => {
            e.stopPropagation();
            const tools = this.getTools();
            if (tools && tools.items) {
              const index = tools.items.findIndex(item => {
                if (
                  item &&
                  typeof item === 'object' &&
                  item.args &&
                  item.args.name === 'shift-button'
                ) {
                  return true;
                }
                return false;
              });
              if (index !== -1) {
                this.removeTool(index);
              }
            }
            this.shiftButtonStatus = !this.shiftButtonStatus;
            this.removeTool('vertices');
            if (this.shiftButtonStatus) {
              this.removeTool('source-arrowhead');
              this.removeTool('target-arrowhead');
            }
            this.addTools(this.generateToolbarButton());
          },
        },
      });
    });
    return buttonTools;
  }
}
