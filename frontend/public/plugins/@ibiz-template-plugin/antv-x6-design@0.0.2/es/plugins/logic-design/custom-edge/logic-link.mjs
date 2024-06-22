import '../../../node_modules/.pnpm/@antv_x6@2.18.1/node_modules/@antv/x6/es/index.mjs';
import { Namespace } from '@ibiz-template/core';
import { createApp } from 'vue';
import '../components/index.mjs';
import { sourceArrowhead, targetArrowhead, boundary, shiftButton, vertices, loopIcon } from './tools/index.mjs';
import { Edge } from '../../../node_modules/.pnpm/@antv_x6@2.18.1/node_modules/@antv/x6/es/shape/edge.mjs';
import { LogicDesignLabel } from '../components/logic-design-label/logic-design-label.mjs';

"use strict";
var __defProp = Object.defineProperty;
var __defNormalProp = (obj, key, value) => key in obj ? __defProp(obj, key, { enumerable: true, configurable: true, writable: true, value }) : obj[key] = value;
var __publicField = (obj, key, value) => {
  __defNormalProp(obj, typeof key !== "symbol" ? key + "" : key, value);
  return value;
};
class LogicLink extends Edge {
  constructor(metadata = {}) {
    super({
      markup: [
        {
          tagName: "path",
          selector: "wrap",
          attrs: {
            fill: "none",
            cursor: "pointer",
            stroke: "transparent"
          }
        },
        {
          tagName: "path",
          selector: "line",
          attrs: {
            fill: "none",
            cursor: "pointer",
            stroke: "transparent"
          }
        }
      ],
      attrs: {
        arrow: {
          d: "M 0 -6 8 0 0 6 z",
          fill: "#1890ff",
          stroke: "#1890ff"
        },
        background: {
          color: "rgba(0, 255, 0, 0.3)"
        },
        wrap: {
          connection: true,
          strokeWidth: 20,
          strokeLinejoin: "round"
        },
        line: {
          connection: true,
          strokeLinejoin: "round",
          targetMarker: "classic",
          stroke: "#999999",
          strokeWidth: 1
        }
      },
      connector: {
        name: "jumpover"
      },
      router: {
        name: "normal",
        args: {
          startDirections: ["top", "right", "bottom", "left"],
          endDirections: ["top", "right", "bottom", "left"]
        }
      },
      label: metadata.label,
      ...metadata
    });
    __publicField(this, "ns", new Namespace("logic-link"));
    __publicField(this, "shiftButtonStatus", false);
    __publicField(this, "logicType", "");
    __publicField(this, "g");
    this.logicType = metadata.logicType || "";
    this.setLinkMode();
    this.onShiftButtonClick = this.onShiftButtonClick.bind(this);
    this.on("update", (dataProvider) => {
      this.replaceData(dataProvider, { silent: true });
      this.setLogicLinkLabel();
      this.setLinkMode();
    });
    this.on("added", () => {
      var _a, _b;
      this.g = (_a = this.model) == null ? void 0 : _a.graph;
      const sourceNode = this.getSourceNode();
      if (sourceNode) {
        const g = (_b = sourceNode.model) == null ? void 0 : _b.graph;
        if (g) {
          const outgoingEdges = g.getOutgoingEdges(sourceNode);
          if (Array.isArray(outgoingEdges)) {
            outgoingEdges.forEach((edge) => {
              if (edge.getData()) {
                edge.trigger("update", edge.getData());
              }
            });
          }
        }
      }
    });
    this.on("selected", () => {
      this.setAttrs({
        line: {
          stroke: "#feb663",
          strokeWidth: 2,
          strokeDasharray: 5,
          style: {
            animation: "logic-link-ant-line 30s infinite linear"
          }
        }
      });
      this.shiftButtonStatus = false;
      if (!this.hasTool("source-arrowhead")) {
        this.addTools(sourceArrowhead());
      }
      if (!this.hasTool("target-arrowhead")) {
        this.addTools(targetArrowhead());
      }
      if (!this.hasTool("boundary")) {
        this.addTools(boundary());
      }
      if (!this.hasTool("logic-link-shift-button")) {
        this.addTools(
          shiftButton(
            this.shiftButtonStatus,
            this.getShiftButtonClassName(),
            this.onShiftButtonClick
          )
        );
      }
    });
    this.on("unselected", () => {
      this.setAttrs({
        line: {
          stroke: "#999999",
          strokeWidth: 1,
          strokeDasharray: 0,
          style: {
            animation: "none"
          }
        }
      });
      this.setLinkMode();
      this.shiftButtonStatus = false;
      this.removeTool("source-arrowhead");
      this.removeTool("target-arrowhead");
      this.removeTool("vertices");
      this.removeTool("boundary");
      this.removeTool("logic-link-shift-button");
    });
    this.on("mouseenter", () => {
      if (!this.hasTool("source-arrowhead") && !this.shiftButtonStatus) {
        this.addTools(sourceArrowhead());
      }
      if (!this.hasTool("target-arrowhead") && !this.shiftButtonStatus) {
        this.addTools(targetArrowhead());
      }
      if (!this.hasTool("vertices") && this.shiftButtonStatus) {
        this.addTools(vertices());
      }
    });
    this.on("mouseleave", () => {
      this.removeTool("source-arrowhead");
      this.removeTool("target-arrowhead");
      this.removeTool("vertices");
    });
    this.on("removed", (args) => {
      const { options } = args;
      if (options.g || this.g) {
        const g = options.g || this.g;
        const sourceNodeId = this.getSourceCellId();
        if (sourceNodeId) {
          const sourceNode = g.getCellById(sourceNodeId);
          if (sourceNode) {
            const outgoingEdges = g.getOutgoingEdges(sourceNode);
            if (Array.isArray(outgoingEdges)) {
              outgoingEdges.forEach((edge) => {
                if (edge.getData()) {
                  edge.trigger("update", edge.getData());
                }
              });
            }
          }
        }
      }
    });
  }
  get isSelected() {
    var _a;
    const g = (_a = this.model) == null ? void 0 : _a.graph;
    if (g) {
      return g.isSelected(this);
    }
    return false;
  }
  getShiftButtonClassName() {
    var _a, _b;
    const className = {
      svg_shift_wrapper: this.ns.b("svg_shift_wrapper"),
      svg_shift1: this.ns.b("svg_shift1"),
      svg_shift2: this.ns.b("svg_shift2")
    };
    const s = (_a = this.getSourceNode()) == null ? void 0 : _a.position();
    const t = (_b = this.getTargetNode()) == null ? void 0 : _b.position();
    if (s && t) {
      if (s.x < t.x) {
        if (s.y > t.y) {
          Object.keys(className).forEach((key) => {
            className[key] += "_lb";
          });
        } else {
          Object.keys(className).forEach((key) => {
            className[key] += "_lt";
          });
        }
      } else if (s.y > t.y) {
        Object.keys(className).forEach((key) => {
          className[key] += "_rb";
        });
      } else {
        Object.keys(className).forEach((key) => {
          className[key] += "_rt";
        });
      }
    } else {
      Object.keys(className).forEach((key) => {
        className[key] += "_lb";
      });
    }
    return className;
  }
  onShiftButtonClick() {
    this.shiftButtonStatus = !this.shiftButtonStatus;
    this.removeTool("logic-link-shift-button");
    this.removeTool("vertices");
    this.addTools(
      shiftButton(
        this.shiftButtonStatus,
        this.getShiftButtonClassName(),
        this.onShiftButtonClick
      )
    );
    if (this.shiftButtonStatus) {
      this.removeTool("source-arrowhead");
      this.removeTool("target-arrowhead");
    }
  }
  getLogicDesignLabel(dataProvider) {
    var _a;
    const content = document.createElement("div");
    let isOpenLoopPostProcess = false;
    let sourceNodeOutgoingEdgeLength = 0;
    const sourceNode = this.getSourceNode();
    if (sourceNode) {
      const sourceNodeDataProvider = sourceNode.getData();
      if (sourceNodeDataProvider) {
        const sourceNodeData = sourceNodeDataProvider.data;
        isOpenLoopPostProcess = (sourceNodeData == null ? void 0 : sourceNodeData.paralleloutput) || false;
      }
      const g = (_a = sourceNode.model) == null ? void 0 : _a.graph;
      if (g) {
        const outgoingEdges = g.getOutgoingEdges(sourceNode);
        if (Array.isArray(outgoingEdges)) {
          sourceNodeOutgoingEdgeLength = outgoingEdges.length;
        }
      }
    }
    const app = createApp(LogicDesignLabel, {
      dataProvider,
      isOpenLoopPostProcess,
      sourceNodeOutgoingEdgeLength,
      logicType: this.logicType
    });
    app.mount(content);
    content.style.position = "absolute";
    document.body.appendChild(content);
    const width = content.offsetWidth;
    const height = content.offsetHeight;
    content.style.position = "";
    document.body.removeChild(content);
    return {
      el: content,
      width,
      height
    };
  }
  getLogicDesignLabelPosition(width) {
    const labelVertices = this.getVertices();
    const vertex = labelVertices == null ? void 0 : labelVertices[0];
    const sourcePoint = this.getSourcePoint();
    const targetPoint = vertex && vertex.x != null && vertex.y != null ? vertex : this.getTargetPoint();
    let angle = Math.atan2(targetPoint.y - sourcePoint.y, targetPoint.x - sourcePoint.x) * (180 / Math.PI);
    let distance = 20;
    if (angle < -90 || angle > 90) {
      angle += 180;
      distance += width;
    }
    return {
      distance,
      angle
    };
  }
  setLogicLinkLabel() {
    const dataProvider = this.getData();
    if (!dataProvider) {
      return;
    }
    const logicDesignLabel = this.getLogicDesignLabel(dataProvider);
    const position = this.getLogicDesignLabelPosition(logicDesignLabel.width);
    this.setLabelAt(0, {
      position,
      logicDesignLabel
    });
    this.setLabelAt(1, dataProvider.label);
  }
  setLinkMode() {
    const dataProvider = this.getData();
    if (!dataProvider) {
      return;
    }
    const data = dataProvider.data;
    if (data && typeof data === "object") {
      let color = "#999999";
      const linkType = data.defaultlink;
      this.removeTool("logic-link-loop-icon");
      if (linkType === 1) {
        color = "#52d456";
      } else if (linkType === 9) {
        color = "#e43b3b";
      } else if (linkType === 10) {
        this.addTools(loopIcon());
      }
      if (this.isSelected) {
        return;
      }
      this.setAttrs({
        line: {
          stroke: color
        }
      });
    }
  }
}

export { LogicLink };
