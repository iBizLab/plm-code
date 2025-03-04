import { Node, NodeView, Shape } from '@antv/x6';
import { Namespace } from '@ibiz-template/core';
import { IDataEntity } from '@ibiz-template/runtime';
import { X6NodeDataProvider } from '../../../interface';
import { linkUtil } from '../utils';

export const port = {
  groups: {
    left: {
      position: {
        name: 'absolute',
      },
      attrs: {
        circle: {
          r: 4,
          magnet: true,
          fill: 'rgba(255,0,0,0.4)',
          stroke: 'transparent',
          style: {
            visibility: 'hidden',
          },
        },
      },
    },
    right: {
      position: {
        name: 'absolute',
      },
      attrs: {
        circle: {
          r: 4,
          magnet: true,
          fill: 'rgba(255,0,0,0.4)',
          stroke: 'transparent',
          style: {
            visibility: 'hidden',
          },
        },
      },
    },
    top: {
      position: {
        name: 'absolute',
      },
      attrs: {
        circle: {
          r: 4,
          magnet: true,
          fill: 'rgba(255,0,0,0.4)',
          stroke: 'transparent',
          style: {
            visibility: 'hidden',
          },
        },
      },
    },
    bottom: {
      position: {
        name: 'absolute',
      },
      attrs: {
        circle: {
          r: 4,
          magnet: true,
          fill: 'rgba(255,0,0,0.4)',
          stroke: 'transparent',
          style: {
            visibility: 'hidden',
          },
        },
      },
    },
    center: {
      position: {
        name: 'absolute',
      },
      attrs: {
        circle: {
          r: 4,
          magnet: true,
          fill: 'rgba(255,0,0,0.4)',
          stroke: 'transparent',
          style: {
            visibility: 'hidden',
          },
        },
      },
    },
  },
  specialItems: [
    {
      id: 'left',
      group: 'left',
    },
    {
      id: 'right',
      group: 'right',
    },
    {
      id: 'top',
      group: 'top',
    },
    {
      id: 'bottom',
      group: 'bottom',
    },
  ],
  items: [
    {
      id: 'left1',
      selector: 'portBody',
      group: 'left',
    },
    {
      id: 'left2',
      selector: 'portBody',
      group: 'left',
    },
    {
      id: 'left3',
      selector: 'portBody',
      group: 'left',
    },
    {
      id: 'right1',
      selector: 'portBody',
      group: 'right',
    },
    {
      id: 'right2',
      selector: 'portBody',
      group: 'right',
    },
    {
      id: 'right3',
      selector: 'portBody',
      group: 'right',
    },
    {
      id: 'top1',
      selector: 'portBody',
      group: 'top',
    },
    {
      id: 'top2',
      selector: 'portBody',
      group: 'top',
    },
    {
      id: 'top3',
      selector: 'portBody',
      group: 'top',
    },
    {
      id: 'bottom1',
      selector: 'portBody',
      group: 'bottom',
    },
    {
      id: 'bottom2',
      selector: 'portBody',
      group: 'bottom',
    },
    {
      id: 'bottom3',
      selector: 'portBody',
      group: 'bottom',
    },
    {
      id: 'center',
      selector: 'portBody',
      group: 'center',
    },
  ],
};

export const nodeModel: Record<
  string,
  {
    width: number;
    height: number;
    type?: string;
    resize?: boolean;
  }
> = {
  START: {
    width: 40,
    height: 40,
    type: 'special',
  },
  INTERACTIVE: {
    resize: true,
    width: 100,
    height: 80,
  },
  END: {
    width: 40,
    height: 40,
    type: 'special',
  },
  PROCESS: {
    resize: true,
    width: 100,
    height: 80,
  },
  EXCLUSIVEGATEWAY: {
    width: 40,
    height: 40,
    type: 'special',
  },
  PARALLELGATEWAY: {
    width: 40,
    height: 40,
    type: 'special',
  },
  INCLUSIVEGATEWAY: {
    width: 40,
    height: 40,
    type: 'special',
  },
  EMBED: {
    resize: true,
    width: 200,
    height: 120,
    type: 'embed',
  },
  CALLORGACTIVITY: {
    resize: true,
    width: 100,
    height: 80,
  },
  TIMEREVENT: {
    width: 40,
    height: 40,
    type: 'special',
  },
};

export function calcRectPort(id: string, width: number, height: number) {
  if (id === 'top') {
    return {
      x: width / 2,
      y: 1,
    };
  }
  if (id === 'bottom') {
    return {
      x: width / 2,
      y: height - 1,
    };
  }
  if (id === 'left') {
    return {
      x: 1,
      y: height / 2,
    };
  }
  if (id === 'right') {
    return {
      x: width - 1,
      y: height / 2,
    };
  }
  if (id === 'top1') {
    return {
      x: width / 2 - width / 6,
      y: 1,
    };
  }
  if (id === 'top2') {
    return {
      x: width / 2,
      y: 1,
    };
  }
  if (id === 'top3') {
    return {
      x: width / 2 + width / 6,
      y: 1,
    };
  }
  if (id === 'bottom1') {
    return {
      x: width / 2 - width / 6,
      y: height - 1,
    };
  }
  if (id === 'bottom2') {
    return {
      x: width / 2,
      y: height - 1,
    };
  }
  if (id === 'bottom3') {
    return {
      x: width / 2 + width / 6,
      y: height - 1,
    };
  }
  if (id === 'left1') {
    return {
      x: 1,
      y: height / 2 - height / 6,
    };
  }
  if (id === 'left2') {
    return {
      x: 1,
      y: height / 2,
    };
  }
  if (id === 'left3') {
    return {
      x: 1,
      y: height / 2 + height / 6,
    };
  }
  if (id === 'right1') {
    return {
      x: width - 1,
      y: height / 2 - height / 6,
    };
  }
  if (id === 'right2') {
    return {
      x: width - 1,
      y: height / 2,
    };
  }
  if (id === 'right3') {
    return {
      x: width - 1,
      y: height / 2 + height / 6,
    };
  }
  if (id === 'center') {
    return {
      x: width / 2,
      y: height / 2,
    };
  }
}

export function generatePorts(type: string) {
  const data = nodeModel[type];
  const ports: Node.Metadata['ports'] = [];
  if (data) {
    const width = data.width;
    const height = data.height;
    const items = data.type === 'special' ? port.specialItems : port.items;
    items.forEach(item => {
      const rectPort = calcRectPort(item.id, width, height);
      if (rectPort) {
        ports.push({
          ...item,
          args: rectPort,
        });
      }
    });
  }

  return ports;
}

export function generateMarkup(ns: Namespace, type: string, text: string) {
  return {
    tagName: 'foreignObject',
    selector: 'foreignObject',
    children: [
      {
        ns: 'http://www.w3.org/1999/xhtml',
        tagName: 'div',
        className: `${ns.b('container')} ${ns.bm(
          'container',
          type.toLowerCase(),
        )}`,
        selector: 'container',
        children: [
          {
            tagName: 'div',
            className: ns.b('icon'),
            selector: 'icon',
          },
          {
            tagName: 'div',
            className: ns.b('text'),
            textContent: text,
          },
        ],
      },
    ],
  };
}

export class LogicNode extends Shape.Rect {
  constructor(metadata: Node.Metadata = {}) {
    const ns = new Namespace('wf-node');
    const data = metadata.data;
    const isNew = data && data.isNew;
    const label = metadata.label || '';
    const type = metadata.type || 'START';
    const model = nodeModel[type];
    const nodeSize = { width: model.width, height: model.height };
    super({
      ports: {
        groups: port.groups,
      },
      markup: generateMarkup(
        ns,
        type,
        isNew && model.type === 'special' ? '' : label,
      ),
      attrs: {
        icon: {
          html: metadata.icon || '',
        },
      },
      ...metadata,
    });
    this.setSize(nodeSize);
    this.setAttrs({
      foreignObject: nodeSize,
    });
    this.on('update', (dataProvider: X6NodeDataProvider<IDataEntity>) => {
      this.setMarkup(generateMarkup(ns, type, dataProvider.label || ''));
      this.setData(dataProvider, { overwrite: true });
    });
    this.on('selected', (): void => {
      this.setAttrs({
        container: {
          style: {
            '--container-border-display': 'block',
          },
        },
      });
    });
    this.on('unselected', (): void => {
      this.setAttrs({
        container: {
          style: {
            '--container-border-display': 'none',
          },
        },
      });
    });
    const ports = this.getPorts();
    if (!ports.length) {
      this.addPorts(generatePorts(type));
    }
    this.on('mouseenter', (args: IData): void => {
      const view = args.view as NodeView;
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
      const view = args.view as NodeView;
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
}
