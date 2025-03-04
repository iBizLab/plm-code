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
    const x6MiniMapRef = ref();
    const x6ContainerRef = ref();
    let resizeObserver;
    onMounted(() => {
      if (!x6ContainerRef.value || !x6Ref.value || !x6MiniMapRef.value) {
        return;
      }
      props.controller.initX6(x6Ref.value, x6MiniMapRef.value);
      if (props.controller.panel.state.isMounted) {
        props.controller.load();
      }
      resizeObserver = new ResizeObserver(() => {
        const el = x6ContainerRef.value;
        if (!props.controller.x6 || !el) {
          return;
        }
        props.controller.x6.g.resize(el.offsetWidth, el.offsetHeight);
      });
      resizeObserver.observe(x6ContainerRef.value);
    });
    onUnmounted(() => {
      props.controller.x6.destroy();
      resizeObserver == null ? void 0 : resizeObserver.disconnect();
    });
    return {
      ns,
      shellNS,
      theme,
      x6Ref,
      x6ContainerRef,
      x6MiniMapRef
    };
  },
  render() {
    return withDirectives(createVNode("div", {
      "ref": "x6ContainerRef",
      "class": [this.ns.b(), this.ns.m(this.theme), this.shellNS.b()]
    }, [createVNode(ScaleToolbar, {
      "controller": this.$props.controller
    }, null), createVNode("div", {
      "class": this.ns.b("container"),
      "ref": "x6Ref"
    }, null), createVNode("div", {
      "class": this.ns.b("minimap"),
      "ref": "x6MiniMapRef"
    }, null)]), [[resolveDirective("loading"), this.controller.state.loading]]);
  }
});

export { X6PanelItem as default };
