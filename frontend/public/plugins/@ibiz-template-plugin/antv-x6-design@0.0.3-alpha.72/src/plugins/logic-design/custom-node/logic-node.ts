import { Node, Shape } from '@antv/x6';
import { Namespace } from '@ibiz-template/core';
import { IDataEntity } from '@ibiz-template/runtime';
import { X6NodeDataProvider } from '../../../interface';

const port = {
  groups: {
    left: {
      attrs: {
        circle: {
          r: 5,
          magnet: true,
          stroke: '#46AEFF',
          strokeWidth: 2,
        },
      },
      position: {
        name: 'left',
      },
    },
    right: {
      attrs: {
        circle: {
          r: 5,
          magnet: true,
          stroke: '#46AEFF',
          strokeWidth: 2,
        },
      },
      position: {
        name: 'right',
      },
    },
    top: {
      attrs: {
        circle: {
          r: 5,
          magnet: true,
          stroke: '#46AEFF',
          strokeWidth: 2,
        },
      },
      position: {
        name: 'top',
      },
    },
    bottom: {
      attrs: {
        circle: {
          r: 5,
          magnet: true,
          stroke: '#46AEFF',
          strokeWidth: 2,
        },
      },
      position: {
        name: 'bottom',
      },
    },
  },
  items: [
    {
      id: 'top',
      group: 'top',
    },
    {
      id: 'left',
      group: 'left',
    },
    {
      id: 'right',
      group: 'right',
    },
    {
      id: 'bottom',
      group: 'bottom',
    },
  ],
};

export function generateMarkup(
  ns: Namespace,
  text: string,
  smallText: string,
  drag: boolean,
  special: boolean,
  showTitle: boolean = false,
) {
  return {
    tagName: 'foreignObject',
    selector: 'foreignObject',
    children: [
      {
        ns: 'http://www.w3.org/1999/xhtml',
        tagName: 'div',
        className: `${ns.b('container')} ${
          drag ? ns.bm('container', 'drag') : ''
        } ${special ? ns.bm('container', 'special') : ''}`,
        selector: 'container',
        children: [
          {
            tagName: 'div',
            className: ns.b('left'),
            selector: 'icon',
          },
          {
            tagName: 'div',
            className: ns.b('right'),
            children: [
              {
                tagName: 'div',
                className: ns.b('text'),
                textContent: text,
                attrs: {
                  title: showTitle ? text : '',
                },
              },
              {
                tagName: 'div',
                className: `${ns.b('small-text')} ${
                  text === smallText ? ns.bm('small-text', 'hidden') : ''
                }`,
                textContent: smallText,
              },
            ],
          },
        ],
      },
    ],
  };
}

export const specialType = [
  'BEGIN',
  'END',
  'COMMIT',
  'ROLLBACK',
  'THROWEXCEPTION',
];

export class LogicNode extends Shape.Rect {
  constructor(metadata: Node.Metadata = {}) {
    const ns = new Namespace('logic-node');
    const data = metadata.data;
    const drag = data && data.isNew;
    const type = metadata.type;
    const isSpecialType = specialType.includes(type);
    const nodeSize = {
      width: isSpecialType ? 56 : 136,
      height: isSpecialType ? 56 : 60,
    };
    super({
      ...nodeSize,
      ports: {
        groups: port.groups,
      },
      markup: generateMarkup(
        ns,
        metadata.label || '',
        metadata.typeLabel || '',
        drag,
        isSpecialType,
        metadata.showTitle,
      ),
      attrs: {
        foreignObject: nodeSize,
        icon: {
          html: metadata.icon || '',
        },
      },
      ...metadata,
    });
    this.on('update', (dataProvider: X6NodeDataProvider<IDataEntity>) => {
      this.replaceData(dataProvider, { silent: true });
      this.setMarkup(
        generateMarkup(
          ns,
          dataProvider.label || '',
          metadata.typeLabel || '',
          drag,
          isSpecialType,
        ),
      );
      const g = this.model?.graph;
      if (g) {
        const outgoingEdges = g.getOutgoingEdges(this);
        if (Array.isArray(outgoingEdges)) {
          outgoingEdges.forEach(outgoingEdge => {
            if (outgoingEdge.getData()) {
              outgoingEdge.trigger('update', outgoingEdge.getData());
            }
          });
        }
      }
    });
    this.on('selected', (): void => {
      this.setAttrs({
        container: {
          style: {
            '--container-border-color': '#feb663',
          },
        },
      });
    });
    this.on('unselected', (): void => {
      this.setAttrs({
        container: {
          style: {
            '--container-border-color': isSpecialType
              ? 'transparent'
              : '#1890FF',
          },
        },
      });
    });
    this.on('mouseenter', (): void => {
      this.removePorts();
      this.addPorts(port.items);
    });
    this.on('mouseleave', (): void => {
      this.removePorts();
    });
  }
}
