import { Node, Shape } from '@antv/x6';
import { Namespace } from '@ibiz-template/core';

/**
 * 素材区节点呈现
 *
 * @author chitanda
 * @date 2023-11-24 14:11:41
 * @export
 * @class MaterialNode
 * @extends {Shape.Edge}
 */
export class MaterialNode extends Shape.Rect {
  getNodeSize() {
    const width = 98;
    let height = 30;
    const text = document.createElement('div');
    const ns = new Namespace('wf-material-node');
    text.classList.add(ns.b('text'));
    text.style.width = `${width}px`;
    text.textContent = this.label || '';
    document.body.appendChild(text);
    const offsetHeight = text.offsetHeight;
    height += offsetHeight;
    document.body.removeChild(text);

    return {
      width,
      height,
    };
  }

  constructor(metadata: Node.Metadata = {}) {
    const ns = new Namespace('wf-material-node');
    super({
      markup: [
        {
          tagName: 'foreignObject',
          selector: 'foreignObject',
          children: [
            {
              ns: 'http://www.w3.org/1999/xhtml',
              tagName: 'div',
              className: ns.b('container'),
              children: [
                {
                  tagName: 'div',
                  className: ns.b('icon'),
                  selector: 'icon',
                },
                {
                  tagName: 'div',
                  className: ns.b('text'),
                  textContent: metadata.label || '',
                },
              ],
            },
          ],
        },
      ],
      attrs: {
        icon: {
          html: metadata.icon || '',
        },
      },
      ...metadata,
    });

    const nodeSize = this.getNodeSize();
    this.setSize(nodeSize);
    this.setAttrs({
      foreignObject: nodeSize,
    });
  }
}
