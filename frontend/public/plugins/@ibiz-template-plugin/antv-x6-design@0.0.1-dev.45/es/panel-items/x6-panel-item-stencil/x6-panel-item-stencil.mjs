import { ref, onMounted, onActivated, createVNode, defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { X6PanelItemStencilController } from './x6-panel-item-stencil.controller.mjs';
import './x6-panel-item-stencil.css';

"use strict";
var X6PanelItemStencil = /* @__PURE__ */ defineComponent({
  name: "IBizX6PanelItemStencil",
  props: {
    modelData: {
      type: Object,
      required: true
    },
    controller: {
      type: X6PanelItemStencilController,
      required: true
    }
  },
  setup(props) {
    const ns = useNamespace("x6-panel-item-stencil");
    const domRef = ref(null);
    onMounted(() => {
      if (props.controller.panel.state.isMounted) {
        Object.assign(props.controller, {
          s: void 0
        });
      }
      props.controller.initStencil(domRef.value);
    });
    onActivated(() => {
      props.controller.initStencil(domRef.value);
    });
    return {
      ns,
      domRef
    };
  },
  render() {
    return createVNode("div", {
      "class": this.ns.b(),
      "ref": "domRef"
    }, null);
  }
});

export { X6PanelItemStencil as default };
