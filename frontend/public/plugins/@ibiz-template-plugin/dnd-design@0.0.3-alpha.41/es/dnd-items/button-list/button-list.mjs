import { ref, watch, createVNode, createTextVNode, resolveComponent, defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import '../../controller/index.mjs';
import { resource } from '../../global.mjs';
import './button-list.css';
import { DndItemController } from '../../controller/dnd-item-controller/dnd-item-controller.mjs';

"use strict";
var Component = /* @__PURE__ */ defineComponent({
  name: "IBizDndDesignButtonList",
  props: {
    controller: {
      type: DndItemController,
      required: true
    }
  },
  setup(props) {
    const ns = useNamespace("dnd-design-button-list");
    const items = ref([]);
    const count = ref(0);
    const load = async () => {
      items.value = [];
      const context = props.controller.c.panel.context.clone();
      const data = props.controller.data;
      const app = ibiz.hub.getApp(context.srfappid);
      const service = await app.deService.getService(context, "PSDEUAGroup");
      if (service && data.psdeuagroupid) {
        context.psdeuagroup = data.psdeuagroupid;
        const result = await service.get(context);
        if (result && result.ok && result.data) {
          if (count.value > 1 && (!Array.isArray(result.data.psdeuagrpdetails) || !result.data.psdeuagrpdetails.length)) {
            ibiz.message.warning("\u5F53\u524D\u7ED1\u5B9A\u754C\u9762\u884C\u4E3A\u7EC4\u672A\u914D\u7F6E\u754C\u9762\u884C\u4E3A");
            return;
          }
          if (Array.isArray(result.data.psdeuagrpdetails)) {
            items.value = result.data.psdeuagrpdetails;
          }
        }
      }
    };
    watch(() => props.controller.data, (value, oldValue) => {
      if (count.value <= 1) {
        count.value += 1;
      }
      const oldGroupId = oldValue == null ? void 0 : oldValue.psdeuagroupid;
      const groupId = value == null ? void 0 : value.psdeuagroupid;
      if (groupId !== oldGroupId) {
        load();
      }
    }, {
      immediate: true
    });
    return {
      ns,
      items
    };
  },
  render() {
    const data = this.controller.data;
    if (!data) {
      return;
    }
    if (!data.psdeuagroupid) {
      return createVNode("div", {
        "class": this.ns.b()
      }, [createVNode("div", {
        "class": this.ns.b("placeholder")
      }, [createVNode("ion-icon", {
        "class": this.ns.be("placeholder", "icon"),
        "src": resource.dir("./assets/svg/action-button.svg")
      }, null), createVNode("div", {
        "class": this.ns.be("placeholder", "text")
      }, [createTextVNode("\u6309\u94AE\u7EC4")])])]);
    }
    if (data.updatedvt === "ITEMS") {
      return createVNode("div", {
        "class": this.ns.b()
      }, [createVNode("div", {
        "class": this.ns.b("item")
      }, [createVNode(resolveComponent("el-button"), null, {
        default: () => [createTextVNode("...")]
      })])]);
    }
    return createVNode("div", {
      "class": this.ns.b()
    }, [this.items.map((item) => {
      return createVNode("div", {
        "class": this.ns.b("item")
      }, [createVNode(resolveComponent("el-button"), null, {
        default: () => [item.uacaption || ""]
      })]);
    })]);
  }
});

export { Component as default };
