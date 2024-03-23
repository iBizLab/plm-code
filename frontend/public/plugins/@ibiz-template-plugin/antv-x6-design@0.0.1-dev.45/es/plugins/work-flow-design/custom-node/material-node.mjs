import '../../../node_modules/.pnpm/@antv_x6@2.18.1/node_modules/@antv/x6/es/index.mjs';
import { Namespace } from '@ibiz-template/core';
import { Rect } from '../../../node_modules/.pnpm/@antv_x6@2.18.1/node_modules/@antv/x6/es/shape/rect.mjs';

"use strict";
class MaterialNode extends Rect {
  getNodeSize() {
    const width = 98;
    let height = 30;
    const text = document.createElement("div");
    const ns = new Namespace("wf-material-node");
    text.classList.add(ns.b("text"));
    text.style.width = "".concat(width, "px");
    text.textContent = this.label || "";
    document.body.appendChild(text);
    const offsetHeight = text.offsetHeight;
    height += offsetHeight;
    document.body.removeChild(text);
    return {
      width,
      height
    };
  }
  constructor(metadata = {}) {
    const ns = new Namespace("wf-material-node");
    super({
      markup: [
        {
          tagName: "foreignObject",
          selector: "foreignObject",
          children: [
            {
              ns: "http://www.w3.org/1999/xhtml",
              tagName: "div",
              className: ns.b("container"),
              children: [
                {
                  tagName: "div",
                  className: ns.b("icon"),
                  selector: "icon"
                },
                {
                  tagName: "div",
                  className: ns.b("text"),
                  textContent: metadata.label || ""
                }
              ]
            }
          ]
        }
      ],
      attrs: {
        icon: {
          html: metadata.icon || ""
        }
      },
      ...metadata
    });
    const nodeSize = this.getNodeSize();
    this.setSize(nodeSize);
    this.setAttrs({
      foreignObject: nodeSize
    });
  }
}

export { MaterialNode };
