import { ref, watch, nextTick, onMounted, onUnmounted, createVNode, resolveDirective, withDirectives, defineComponent } from 'vue';
import { getCodeProps, getEditorEmits, useNamespace, useUIStore } from '@ibiz-template/vue3-util';
import '../../node_modules/.pnpm/@monaco-editor_loader@1.4.0_monaco-editor@0.51.0/node_modules/@monaco-editor/loader/lib/es/index.mjs';
import './form-logic-event-script.css';
import loader from '../../node_modules/.pnpm/@monaco-editor_loader@1.4.0_monaco-editor@0.51.0/node_modules/@monaco-editor/loader/lib/es/loader/index.mjs';

"use strict";
const FormLogicEventScript = /* @__PURE__ */ defineComponent({
  name: "IBizFormLogicEventScript",
  props: getCodeProps(),
  emits: getEditorEmits(),
  setup(props) {
    const ns = useNamespace("form-logic-event-script");
    const c = props.controller;
    let editor;
    let monacoEditor;
    const isLoading = ref(false);
    const {
      UIStore
    } = useUIStore();
    const getMonacoTheme = (name) => {
      return name === "dark" ? "vs-".concat(UIStore.theme) : "vs";
    };
    watch(() => UIStore.theme, (newVal) => {
      monacoEditor.setTheme(getMonacoTheme(newVal));
    });
    watch([() => props.readonly, () => props.disabled], () => {
      editor == null ? void 0 : editor.updateOptions({
        readOnly: props.readonly || props.disabled
      });
    }, {
      immediate: true
    });
    const codeEditBox = ref();
    const editorInit = () => {
      nextTick(() => {
        isLoading.value = true;
        loader.config({
          paths: {
            vs: "".concat(ibiz.env.pluginBaseUrl, "/monaco-editor@0.45.0/min/vs")
          }
        });
        loader.init().then((loaderMonaco) => {
          isLoading.value = false;
          if (!editor) {
            monacoEditor = loaderMonaco.editor;
            editor = monacoEditor.create(codeEditBox.value, {
              language: props.controller.language,
              theme: getMonacoTheme(UIStore.theme),
              foldingStrategy: "indentation",
              renderLineHighlight: "all",
              // 行亮
              selectOnLineNumbers: true,
              // 显示行号
              minimap: {
                enabled: true
              },
              readOnly: props.readonly || props.disabled,
              // 只读
              readOnlyMessage: {
                value: ibiz.i18n.t("editor.code.readOnlyPrompt")
              },
              fontSize: 16,
              // 字体大小
              scrollBeyondLastLine: false,
              // 取消代码后面一大段空白
              overviewRulerBorder: false
              // 不要滚动条的边框
            });
          }
          setTimeout(() => {
            var _a;
            editor.layout();
            editor.setValue((_a = c.logicData) == null ? void 0 : _a.condvalue);
          });
          editor.onDidChangeModelContent(() => {
            const value = editor.getValue();
            c.saveScriptContent(value);
          });
          window.addEventListener("resize", () => {
            editor.layout();
          });
        }).catch(() => {
          isLoading.value = false;
        });
      });
    };
    onMounted(() => {
      editorInit();
    });
    onUnmounted(() => {
      editor == null ? void 0 : editor.dispose();
    });
    return {
      ns,
      isLoading,
      codeEditBox
    };
  },
  render() {
    return withDirectives(createVNode("div", {
      "class": [this.ns.b()]
    }, [createVNode("div", {
      "ref": "codeEditBox",
      "class": this.ns.e("box")
    }, null)]), [[resolveDirective("loading"), this.isLoading]]);
  }
});

export { FormLogicEventScript };
