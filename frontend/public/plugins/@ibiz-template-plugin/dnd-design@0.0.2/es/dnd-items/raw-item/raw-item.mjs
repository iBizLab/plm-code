import { createVNode, createTextVNode, resolveComponent, defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import '../../controller/index.mjs';
import { video, picture } from './icons/index.mjs';
import './raw-item.css';
import { DndItemController } from '../../controller/dnd-item-controller/dnd-item-controller.mjs';

"use strict";
var Component = /* @__PURE__ */ defineComponent({
  name: "IBizDndDesignRawItem",
  props: {
    controller: {
      type: DndItemController,
      required: true
    }
  },
  setup(props) {
    const ns = useNamespace("dnd-design-raw-item");
    const renderRaw = () => {
      const data = props.controller.data;
      return createVNode("div", {
        "class": ns.e("raw")
      }, [data.rawcontent || data.srftext || ""]);
    };
    const renderHtml = () => {
      const data = props.controller.data;
      if (data.htmlcontent) {
        return createVNode("div", {
          "class": ns.e("html"),
          "innerHTML": data.htmlcontent
        }, null);
      }
      return createVNode("div", {
        "class": ns.e("html")
      }, [data.srftext || ""]);
    };
    const renderContent = () => {
      const data = props.controller.data;
      switch (data.contenttype) {
        case "RAW":
          return renderRaw();
        case "HTML":
          return renderHtml();
        case "IMAGE":
          return createVNode("div", {
            "class": ns.e("image")
          }, [picture()]);
        case "VIDEO":
          return createVNode("div", {
            "class": ns.e("video")
          }, [video()]);
        case "PLACEHOLDER":
          return createVNode("div", {
            "class": ns.e("placeholder")
          }, [createTextVNode("\u5360\u4F4D(PLACEHOLDER)")]);
        case "DIVIDER":
          return createVNode(resolveComponent("el-divider"), {
            "class": ns.e("divider")
          }, {
            default: () => [createTextVNode("\u5206\u5272\u7EBF(DIVIDER)")]
          });
        case "INFO":
          return createVNode("div", {
            "class": ns.e("info")
          }, [createTextVNode("\u5E38\u89C4\u63D0\u793A(INFO)")]);
        case "WARNING":
          return createVNode("div", {
            "class": ns.e("warning")
          }, [createTextVNode("\u8B66\u544A\u63D0\u793A(WARNING)")]);
        case "ERROR":
          return createVNode("div", {
            "class": ns.e("error")
          }, [createTextVNode("\u9519\u8BEF\u63D0\u793A(ERROR)")]);
        default:
          return createVNode("div", {
            "class": ns.e("default")
          }, [createTextVNode("\u76F4\u63A5\u5185\u5BB9")]);
      }
    };
    return {
      ns,
      renderContent
    };
  },
  render() {
    return createVNode("div", {
      "class": this.ns.b()
    }, [this.renderContent()]);
  }
});

export { Component as default };
