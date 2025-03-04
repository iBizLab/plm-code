import '../../../node_modules/.pnpm/@antv_x6@2.18.1/node_modules/@antv/x6/es/index.mjs';
import { Namespace } from '@ibiz-template/core';
import { Rect } from '../../../node_modules/.pnpm/@antv_x6@2.18.1/node_modules/@antv/x6/es/shape/rect.mjs';

"use strict";
class MaterialAddNode extends Rect {
  constructor(metadata = {}) {
    const ns = new Namespace("material-add-node");
    super({
      width: 98,
      height: 80,
      markup: [
        {
          tagName: "foreignObject",
          selector: "foreignObject",
          className: [ns.b(), metadata.data.data.actionID],
          children: [
            {
              ns: "http://www.w3.org/1999/xhtml",
              tagName: "div",
              className: ns.b("container"),
              attrs: {
                title: metadata.label || ""
              },
              children: [
                {
                  tagName: "div",
                  className: ns.b("icon"),
                  selector: "icon"
                }
              ]
            }
          ]
        }
      ],
      attrs: {
        foreignObject: {
          width: 98,
          height: 80
        },
        icon: {
          html: '<svg xmlns="http://www.w3.org/2000/svg" class="ionicon" viewBox="0 0 512 512"><path fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="32" d="M256 112v288M400 256H112"/></svg>'
        }
      },
      ...metadata
    });
  }
}

export { MaterialAddNode };
