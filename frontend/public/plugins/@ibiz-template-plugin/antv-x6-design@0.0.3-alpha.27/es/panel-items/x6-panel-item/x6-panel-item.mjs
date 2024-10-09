import { ref, onMounted, onUnmounted, createVNode, resolveDirective, withDirectives, defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { X6PanelItemController } from './x6-panel-item.controller.mjs';
import '../../components/index.mjs';
import './x6-panel-item.css';
import { ScaleToolbar } from '../../components/scale-toolbar/scale-toolbar.mjs';

"use strict";
var X6PanelItem = /* @__PURE__ */ defineComponent({
  name: "IBizX6PanelItem",
  props: {
    modelData: {
      type: Object,
      required: true
    },
    controller: {
      type: X6PanelItemController,
      required: true
    }
  },
  setup(props) {
    const ns = useNamespace("x6-panel-item");
    const shellNS = useNamespace("light-theme-shell");
    const x6Ref = ref(null);
    const theme = ref("light");
    onMounted(() => {
      props.controller.initX6(x6Ref.value);
      if (props.controller.panel.state.isMounted) {
        props.controller.load();
      }
    });
    onUnmounted(() => {
      props.controller.x6.destroy();
    });
    return {
      ns,
      shellNS,
      theme,
      x6Ref
    };
  },
  render() {
    return withDirectives(createVNode("div", {
      "class": this.ns.b()
    }, [createVNode(ScaleToolbar, {
      "controller": this.$props.controller
    }, null), createVNode("div", {
      "class": [this.ns.b("container"), this.ns.m(this.theme), this.shellNS.b()],
      "ref": "x6Ref"
    }, null), createVNode("div", {
      "class": this.ns.b("minimap")
    }, null)]), [[resolveDirective("loading"), this.controller.state.loading]]);
  }
});

export { X6PanelItem as default };
