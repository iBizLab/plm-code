import { createVNode, defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { ActiveHomeButtonController } from './active-home-button.controller.mjs';
import './active-home-button.css';

"use strict";
var ActiveHomeButton = /* @__PURE__ */ defineComponent({
  name: "IBizActiveHomeButton",
  props: {
    modelData: {
      type: Object,
      required: true
    },
    controller: {
      type: ActiveHomeButtonController,
      required: true
    }
  },
  setup(props) {
    const ns = useNamespace("active-home-button");
    const onActiveRoot = (e) => {
      e.stopPropagation();
      props.controller.panel.view.call("onActiveRoot");
    };
    return {
      ns,
      onActiveRoot
    };
  },
  render() {
    return createVNode("div", {
      "class": this.ns.b(),
      "onClick": this.onActiveRoot
    }, [createVNode("i", {
      "class": [this.ns.e("icon"), "fa fa-home"]
    }, null)]);
  }
});

export { ActiveHomeButton as default };
