import '../../../node_modules/.pnpm/@antv_x6@2.18.1/node_modules/@antv/x6/es/index.mjs';
import { Namespace } from '@ibiz-template/core';
import { Rect } from '../../../node_modules/.pnpm/@antv_x6@2.18.1/node_modules/@antv/x6/es/shape/rect.mjs';

"use strict";
class MaterialNode extends Rect {
  constructor(metadata = {}) {
    const ns = new Namespace("material-node");
    const config = {
      width: 98,
      height: 80,
      markup: [
        {
          tagName: "foreignObject",
          selector: "foreignObject",
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
        foreignObject: {
          width: 98,
          height: 80
        },
        icon: {
          html: metadata.icon || ""
        }
      },
      ...metadata
    };
    const data = metadata.data.data || {};
    if (data.actionID) {
      config.markup[0].children[0].children.push({
        tagName: "div",
        className: [ns.b("delete-icon"), data.actionID],
        selector: "deleteIcon"
      });
      Object.assign(config.attrs, {
        deleteIcon: {
          html: '<svg xmlns="http://www.w3.org/2000/svg" class="ionicon" viewBox="0 0 512 512"><path fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="32" d="M368 368L144 144M368 144L144 368"/></svg>'
        }
      });
    }
    super(config);
  }
}

export { MaterialNode };
