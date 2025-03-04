import {
  ref,
  watch,
  nextTick,
  onMounted,
  onUnmounted,
  defineComponent,
} from 'vue';
import {
  useUIStore,
  getCodeProps,
  useNamespace,
  getEditorEmits,
} from '@ibiz-template/vue3-util';
import loader from '@monaco-editor/loader';
import { FormLogicEventScriptEditorController } from './form-logic-event-script.controller';
import './form-logic-event-script.scss';

export const FormLogicEventScript = defineComponent({
  name: 'IBizFormLogicEventScript',
  props: getCodeProps<FormLogicEventScriptEditorController>(),
  emits: getEditorEmits(),
  setup(props) {
    const ns = useNamespace('form-logic-event-script');
    const c = props.controller;

    let editor: IData;

    let monacoEditor: IData;

    // 是否加载中
    const isLoading = ref(false);

    const { UIStore } = useUIStore();

    // 编辑器主题
    const getMonacoTheme = (name: string): string => {
      return name === 'dark' ? `vs-${UIStore.theme}` : 'vs'; // 官方自带三种主题vs, hc-black, or vs-dark
    };

    watch(
      () => UIStore.theme,
      newVal => {
        monacoEditor.setTheme(getMonacoTheme(newVal));
      },
    );

    watch(
      [(): boolean => props.readonly, (): boolean => props.disabled],
      () => {
        editor?.updateOptions({
          readOnly: props.readonly || props.disabled,
        });
      },
      {
        immediate: true,
      },
    );

    const codeEditBox = ref();

    const editorInit = (): void => {
      nextTick(() => {
        isLoading.value = true;
        loader.config({
          paths: {
            vs: `${ibiz.env.pluginBaseUrl}/monaco-editor@0.45.0/min/vs`,
          },
        });
        loader
          .init()
          .then(loaderMonaco => {
            isLoading.value = false;
            // 初始化编辑器
            if (!editor) {
              monacoEditor = loaderMonaco.editor;
              editor = monacoEditor.create(codeEditBox.value, {
                language: props.controller.language,
                theme: getMonacoTheme(UIStore.theme),
                foldingStrategy: 'indentation',
                renderLineHighlight: 'all', // 行亮
                selectOnLineNumbers: true, // 显示行号
                minimap: {
                  enabled: true,
                },
                readOnly: props.readonly || props.disabled, // 只读
                readOnlyMessage: {
                  value: ibiz.i18n.t('editor.code.readOnlyPrompt'),
                },
                fontSize: 16, // 字体大小
                scrollBeyondLastLine: false, // 取消代码后面一大段空白
                overviewRulerBorder: false, // 不要滚动条的边框
              });
            }
            setTimeout(() => {
              editor!.layout();
              editor!.setValue(c.logicData?.condvalue);
            });

            // 监听值的变化
            editor.onDidChangeModelContent(() => {
              const value = editor!.getValue();
              c.saveScriptContent(value);
            });

            window.addEventListener('resize', () => {
              editor!.layout();
            });
          })
          .catch(() => {
            isLoading.value = false;
          });
      });
    };

    onMounted(() => {
      editorInit();
    });

    onUnmounted(() => {
      editor?.dispose();
    });

    return {
      ns,
      isLoading,
      codeEditBox,
    };
  },
  render() {
    return (
      <div class={[this.ns.b()]} v-loading={this.isLoading}>
        <div ref='codeEditBox' class={this.ns.e('box')}></div>
      </div>
    );
  },
});
