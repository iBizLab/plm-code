import { ref, onMounted, createVNode, defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { X6PanelItemSwitchController } from './x6-panel-item-switch.controller.mjs';
import './x6-panel-item-switch.css';

"use strict";
var X6PanelItemSwitch = /* @__PURE__ */ defineComponent({
  name: "IBizX6PanelItemSwitch",
  props: {
    modelData: {
      type: Object,
      required: true
    },
    controller: {
      type: X6PanelItemSwitchController,
      required: true
    }
  },
  setup(props) {
    const ns = useNamespace("x6-panel-item-switch");
    const activeItem = ref(props.controller.items[0].value);
    const indicatorStyle = ref({
      transition: "none",
      width: "",
      transform: ""
    });
    const key = "x6_panel_item_switch";
    const onClick = (e, item) => {
      e.stopPropagation();
      const el = e.target;
      if (!el) {
        return;
      }
      indicatorStyle.value.transition = "";
      indicatorStyle.value.width = "".concat(el.offsetWidth, "px");
      indicatorStyle.value.transform = "translateX(".concat(el.offsetLeft, "px)");
      activeItem.value = item.value;
      props.controller.panel.setDataValue(key, activeItem.value);
    };
    props.controller.panel.evt.on("onMounted", () => {
      props.controller.panel.setDataValue(key, activeItem.value);
    });
    const content = ref(null);
    onMounted(() => {
      const el = content.value;
      if (!el) {
        return;
      }
      const child = Array.from(el.children).find((item) => item.classList.contains(ns.is("active", true)));
      if (child) {
        indicatorStyle.value.width = "".concat(child.offsetWidth, "px");
        indicatorStyle.value.transform = "translateX(".concat(child.offsetLeft, "px)");
      }
    });
    return {
      ns,
      activeItem,
      indicatorStyle,
      content,
      onClick
    };
  },
  render() {
    return createVNode("div", {
      "class": this.ns.b()
    }, [createVNode("div", {
      "class": this.ns.b("content"),
      "ref": "content"
    }, [this.controller.items.map((item) => {
      return createVNode("div", {
        "class": [this.ns.b("item"), this.ns.is("active", this.activeItem === item.value)],
        "onClick": (e) => this.onClick(e, item)
      }, [item.text || ""]);
    }), createVNode("div", {
      "class": this.ns.b("indicator"),
      "style": this.indicatorStyle
    }, null)])]);
  }
});

export { X6PanelItemSwitch as default };
