import { computed, ref, watch, onMounted, createTextVNode, createVNode, defineComponent } from 'vue';
import { getInputProps, getEditorEmits, useNamespace, useUIStore } from '@ibiz-template/vue3-util';
import Cherry from 'cherry-markdown';
import './markdown-memo-editor.css';

"use strict";
const MarkdownMemoEditor = /* @__PURE__ */ defineComponent({
  name: "IBizMarkdownMemoEditor",
  props: getInputProps(),
  emits: getEditorEmits(),
  setup(props, {
    emit
  }) {
    const ns = useNamespace("markdown-memo-editor");
    const c = props.controller;
    const curVal = computed(() => {
      return props.value ? "".concat(props.value) : "";
    });
    const isCollapsed = ref(false);
    const collapsed = localStorage.getItem("memo-form-collapsed");
    if (collapsed) {
      isCollapsed.value = collapsed === "true";
    }
    const switchCollapsed = () => {
      isCollapsed.value = !isCollapsed.value;
      localStorage.setItem("memo-form-collapsed", JSON.stringify(isCollapsed.value));
    };
    const editorRef = ref();
    let editor;
    const {
      UIStore
    } = useUIStore();
    const theme = ref(UIStore.theme);
    watch(() => UIStore.theme, (newVal) => {
      theme.value = newVal;
      editor == null ? void 0 : editor.setTheme(theme.value);
    });
    const defaultModel = ref("editOnly");
    watch(curVal, (newVal, oldVal) => {
      if (!editor) {
        return;
      }
      const content = editor.getMarkdown();
      if (newVal !== oldVal && content !== newVal) {
        editor.setMarkdown(newVal);
      }
    });
    const afterChange = () => {
      if (!editor) {
        return;
      }
      emit("change", editor.getMarkdown());
    };
    onMounted(() => {
      if (!editorRef.value) {
        return;
      }
      if (props.disabled || props.readonly) {
        defaultModel.value = "previewOnly";
      }
      editor = new Cherry({
        el: editorRef.value,
        value: curVal.value,
        theme: theme.value,
        editor: {
          defaultModel: defaultModel.value,
          codemirror: {
            autofocus: false
          }
        },
        toolbars: {
          theme: theme.value,
          bubble: false,
          float: false,
          sidebar: false,
          toolbar: ["bold", "italic", "header", "underline", "link", "togglePreview"]
        },
        callback: {
          afterChange
        }
      });
      editor.setTheme(theme.value);
      editor.switchModel(defaultModel.value);
    });
    return {
      c,
      ns,
      editorRef,
      isCollapsed,
      switchCollapsed
    };
  },
  render() {
    return createVNode("div", {
      "class": [this.ns.b(), this.ns.is("collapsed", this.isCollapsed), this.ns.is("readonly", this.disabled || this.readonly)]
    }, [createVNode("div", {
      "class": [this.ns.b("title")]
    }, [createTextVNode("\u5907\u6CE8")]), createVNode("div", {
      "ref": "editorRef",
      "class": [this.ns.b("content")]
    }, null), createVNode("div", {
      "class": [this.ns.b("btn")],
      "title": this.isCollapsed ? "\u5C55\u5F00" : "\u6536\u7F29",
      "onClick": this.switchCollapsed
    }, [createVNode("svg", {
      "xmlns": "http://www.w3.org/2000/svg",
      "viewBox": "0 0 1024 1024"
    }, [createVNode("path", {
      "fill": "currentColor",
      "d": "m192 384 320 384 320-384z"
    }, null)])])]);
  }
});

export { MarkdownMemoEditor };
