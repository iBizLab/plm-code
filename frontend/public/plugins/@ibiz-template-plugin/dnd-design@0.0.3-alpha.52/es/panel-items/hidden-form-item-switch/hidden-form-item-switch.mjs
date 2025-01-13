import { ref, resolveComponent, createVNode, defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { PanelItemController } from '@ibiz-template/runtime';

"use strict";
var HiddenFormItemSwitch = /* @__PURE__ */ defineComponent({
  name: "IBizHiddenFormItemSwitch",
  props: {
    modelData: {
      type: Object,
      required: true
    },
    controller: {
      type: PanelItemController,
      required: true
    }
  },
  setup(props) {
    const ns = useNamespace("hidden-form-item-switch");
    const isActive = ref(false);
    const activeText = "\u663E\u793A";
    const inactiveText = "\u9690\u85CF";
    const handleChange = (value) => {
      var _a;
      const view = props.controller.panel.view;
      if (!view) {
        return;
      }
      const dndDesignController = (_a = view.layoutPanel) == null ? void 0 : _a.panelItems.dnd_design_panel_item;
      if (!dndDesignController) {
        return;
      }
      dndDesignController.updateHiddenFormItemVisible(value);
    };
    return {
      ns,
      isActive,
      activeText,
      inactiveText,
      handleChange
    };
  },
  render() {
    return createVNode("div", {
      "class": this.ns.b()
    }, [createVNode(resolveComponent("el-switch"), {
      "modelValue": this.isActive,
      "onUpdate:modelValue": ($event) => this.isActive = $event,
      "active-text": this.activeText,
      "inactive-text": this.inactiveText,
      "inline-prompt": true,
      "size": "large",
      "title": "".concat(this.isActive ? this.inactiveText : this.activeText, "\u9690\u85CF\u8868\u5355\u9879"),
      "onChange": this.handleChange
    }, null)]);
  }
});

export { HiddenFormItemSwitch as default };
