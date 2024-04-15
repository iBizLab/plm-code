import { createTextVNode, createVNode, defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { linkLogicCountIcon } from './icons/index.mjs';
import './logic-design-label.css';

"use strict";
const LogicDesignLabel = /* @__PURE__ */ defineComponent({
  props: {
    dataProvider: {
      type: Object,
      required: true
    },
    isOpenLoopPostProcess: {
      type: Boolean || Number,
      default: false
    },
    sourceNodeOutgoingEdgeLength: {
      type: Number,
      default: 0
    },
    logicType: {
      type: String
    }
  },
  setup(props) {
    var _a;
    const ns = useNamespace("logic-design-label");
    const data = (_a = props.dataProvider) == null ? void 0 : _a.data;
    let logicLinkCount = 0;
    if (data) {
      if (data.linklogiccount != null) {
        logicLinkCount = data.linklogiccount;
      } else if (Array.isArray(data.psdellconds)) {
        logicLinkCount = data.psdellconds.length;
      }
    }
    return {
      ns,
      logicLinkCount
    };
  },
  render() {
    const isShowCaseText = !this.isOpenLoopPostProcess && this.sourceNodeOutgoingEdgeLength > 1 && this.logicType !== "DATAFLOWLOGIC" && this.logicType !== "MAINSTATELOGIC";
    if (!this.logicLinkCount && !isShowCaseText) {
      return;
    }
    return createVNode("div", {
      "class": [this.ns.b()]
    }, [createVNode("div", {
      "class": [this.ns.b("right"), !this.logicLinkCount ? this.ns.bm("right", "small") : ""]
    }, [isShowCaseText ? createVNode("div", {
      "class": this.ns.b("case-text")
    }, [createTextVNode("case")]) : null, this.logicLinkCount ? createVNode("div", {
      "class": this.ns.b("link-logic-count-icon")
    }, [linkLogicCountIcon()]) : null])]);
  }
});

export { LogicDesignLabel };
