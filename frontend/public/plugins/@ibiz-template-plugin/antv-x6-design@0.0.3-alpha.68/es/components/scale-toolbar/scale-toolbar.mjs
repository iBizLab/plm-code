import { isVNode, resolveComponent, createVNode, defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { enlarge, shrink, oneToOne, adaptive } from './icons/index.mjs';
import { X6PanelItemController } from '../../panel-items/x6-panel-item/x6-panel-item.controller.mjs';
import './scale-toolbar.css';

"use strict";
function _isSlot(s) {
  return typeof s === "function" || Object.prototype.toString.call(s) === "[object Object]" && !isVNode(s);
}
const ScaleToolbar = /* @__PURE__ */ defineComponent({
  props: {
    controller: X6PanelItemController
  },
  setup(props) {
    const ns = useNamespace("x6-scale-toolbar");
    const shellNS = useNamespace("light-theme-shell");
    const onClick = (tag) => {
      if (tag === "enlarge") {
        props.controller.x6.g.zoom(0.2);
      } else if (tag === "shrink") {
        props.controller.x6.g.zoom(-0.2);
      } else if (tag === "default") {
        props.controller.x6.g.zoomTo(1);
      } else if (tag === "adaptive") {
        props.controller.x6.g.zoomToFit();
      } else if (tag === "export") {
        props.controller.x6.g.exportPNG("logic", {
          copyStyles: false,
          padding: 10
        });
      }
    };
    return {
      ns,
      shellNS,
      onClick
    };
  },
  render() {
    let _slot, _slot2, _slot3, _slot4;
    return createVNode("div", {
      "class": [this.ns.b(), this.shellNS.b()]
    }, [createVNode(resolveComponent("el-button-group"), {
      "class": this.ns.b("button")
    }, {
      default: () => [createVNode(resolveComponent("el-button"), {
        "size": "small",
        "type": "primary",
        "title": "\u653E\u5927",
        "onClick": () => this.onClick("enlarge")
      }, _isSlot(_slot = enlarge()) ? _slot : {
        default: () => [_slot]
      }), createVNode(resolveComponent("el-button"), {
        "size": "small",
        "type": "primary",
        "title": "\u7F29\u5C0F",
        "onClick": () => this.onClick("shrink")
      }, _isSlot(_slot2 = shrink()) ? _slot2 : {
        default: () => [_slot2]
      }), createVNode(resolveComponent("el-button"), {
        "size": "small",
        "type": "primary",
        "title": "\u7F29\u653E\u81F31:1",
        "onClick": () => this.onClick("default")
      }, _isSlot(_slot3 = oneToOne()) ? _slot3 : {
        default: () => [_slot3]
      }), createVNode(resolveComponent("el-button"), {
        "size": "small",
        "type": "primary",
        "title": "\u7F29\u653E\u81F3\u9002\u5E94\u5C4F\u5E55\u5927\u5C0F",
        "onClick": () => this.onClick("adaptive")
      }, _isSlot(_slot4 = adaptive()) ? _slot4 : {
        default: () => [_slot4]
      })]
    })]);
  }
});

export { ScaleToolbar };
