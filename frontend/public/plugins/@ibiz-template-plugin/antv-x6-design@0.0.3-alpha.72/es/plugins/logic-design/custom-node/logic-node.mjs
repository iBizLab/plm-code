import '../../../node_modules/.pnpm/@antv_x6@2.18.1/node_modules/@antv/x6/es/index.mjs';
import { Namespace } from '@ibiz-template/core';
import { Rect } from '../../../node_modules/.pnpm/@antv_x6@2.18.1/node_modules/@antv/x6/es/shape/rect.mjs';

"use strict";
const port = {
  groups: {
    left: {
      attrs: {
        circle: {
          r: 5,
          magnet: true,
          stroke: "#46AEFF",
          strokeWidth: 2
        }
      },
      position: {
        name: "left"
      }
    },
    right: {
      attrs: {
        circle: {
          r: 5,
          magnet: true,
          stroke: "#46AEFF",
          strokeWidth: 2
        }
      },
      position: {
        name: "right"
      }
    },
    top: {
      attrs: {
        circle: {
          r: 5,
          magnet: true,
          stroke: "#46AEFF",
          strokeWidth: 2
        }
      },
      position: {
        name: "top"
      }
    },
    bottom: {
      attrs: {
        circle: {
          r: 5,
          magnet: true,
          stroke: "#46AEFF",
          strokeWidth: 2
        }
      },
      position: {
        name: "bottom"
      }
    }
  },
  items: [
    {
      id: "top",
      group: "top"
    },
    {
      id: "left",
      group: "left"
    },
    {
      id: "right",
      group: "right"
    },
    {
      id: "bottom",
      group: "bottom"
    }
  ]
};
function generateMarkup(ns, text, smallText, drag, special, showTitle = false) {
  return {
    tagName: "foreignObject",
    selector: "foreignObject",
    children: [
      {
        ns: "http://www.w3.org/1999/xhtml",
        tagName: "div",
        className: "".concat(ns.b("container"), " ").concat(drag ? ns.bm("container", "drag") : "", " ").concat(special ? ns.bm("container", "special") : ""),
        selector: "container",
        children: [
          {
            tagName: "div",
            className: ns.b("left"),
            selector: "icon"
          },
          {
            tagName: "div",
            className: ns.b("right"),
            children: [
              {
                tagName: "div",
                className: ns.b("text"),
                textContent: text,
                attrs: {
                  title: showTitle ? text : ""
                }
              },
              {
                tagName: "div",
                className: "".concat(ns.b("small-text"), " ").concat(text === smallText ? ns.bm("small-text", "hidden") : ""),
                textContent: smallText
              }
            ]
          }
        ]
      }
    ]
  };
}
const specialType = [
  "BEGIN",
  "END",
  "COMMIT",
  "ROLLBACK",
  "THROWEXCEPTION"
];
class LogicNode extends Rect {
  constructor(metadata = {}) {
    const ns = new Namespace("logic-node");
    const data = metadata.data;
    const drag = data && data.isNew;
    const type = metadata.type;
    const isSpecialType = specialType.includes(type);
    const nodeSize = {
      width: isSpecialType ? 56 : 136,
      height: isSpecialType ? 56 : 60
    };
    super({
      ...nodeSize,
      ports: {
        groups: port.groups
      },
      markup: generateMarkup(
        ns,
        metadata.label || "",
        metadata.typeLabel || "",
        drag,
        isSpecialType,
        metadata.showTitle
      ),
      attrs: {
        foreignObject: nodeSize,
        icon: {
          html: metadata.icon || ""
        }
      },
      ...metadata
    });
    this.on("update", (dataProvider) => {
      var _a;
      this.replaceData(dataProvider, { silent: true });
      this.setMarkup(
        generateMarkup(
          ns,
          dataProvider.label || "",
          metadata.typeLabel || "",
          drag,
          isSpecialType
        )
      );
      const g = (_a = this.model) == null ? void 0 : _a.graph;
      if (g) {
        const outgoingEdges = g.getOutgoingEdges(this);
        if (Array.isArray(outgoingEdges)) {
          outgoingEdges.forEach((outgoingEdge) => {
            if (outgoingEdge.getData()) {
              outgoingEdge.trigger("update", outgoingEdge.getData());
            }
          });
        }
      }
    });
    this.on("selected", () => {
      this.setAttrs({
        container: {
          style: {
            "--container-border-color": "#feb663"
          }
        }
      });
    });
    this.on("unselected", () => {
      this.setAttrs({
        container: {
          style: {
            "--container-border-color": isSpecialType ? "transparent" : "#1890FF"
          }
        }
      });
    });
    this.on("mouseenter", () => {
      this.removePorts();
      this.addPorts(port.items);
    });
    this.on("mouseleave", () => {
      this.removePorts();
    });
  }
}

export { LogicNode, generateMarkup, specialType };
