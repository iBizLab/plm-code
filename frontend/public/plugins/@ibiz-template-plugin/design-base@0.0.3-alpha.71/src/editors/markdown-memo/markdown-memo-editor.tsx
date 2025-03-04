import { computed, defineComponent, onMounted, ref, watch } from 'vue';
import { CodeListEditorController } from '@ibiz-template/runtime';
import {
  getEditorEmits,
  getInputProps,
  useNamespace,
  useUIStore,
} from '@ibiz-template/vue3-util';
import Cherry from 'cherry-markdown';
import './markdown-memo-editor.scss';

export const MarkdownMemoEditor = defineComponent({
  name: 'IBizMarkdownMemoEditor',
  props: getInputProps<CodeListEditorController>(),
  emits: getEditorEmits(),
  setup(props, { emit }) {
    const ns = useNamespace('markdown-memo-editor');
    const c = props.controller;

    // 当前值
    const curVal = computed(() => {
      return props.value ? `${props.value}` : '';
    });

    // 是否收缩
    const isCollapsed = ref(false);

    const collapsed = localStorage.getItem('memo-form-collapsed');

    if (collapsed) {
      isCollapsed.value = collapsed === 'true';
    }

    // 切换收缩状态
    const switchCollapsed = () => {
      isCollapsed.value = !isCollapsed.value;
      localStorage.setItem(
        'memo-form-collapsed',
        JSON.stringify(isCollapsed.value),
      );
    };

    // 编辑器容器
    const editorRef = ref<HTMLElement>();

    // 编辑器
    let editor: Cherry | undefined;

    // 编辑器主题
    const { UIStore } = useUIStore();
    const theme = ref(UIStore.theme);

    watch(
      () => UIStore.theme,
      newVal => {
        theme.value = newVal;
        editor?.setTheme(theme.value);
      },
    );

    // 编辑器模式
    const defaultModel = ref<'editOnly' | 'previewOnly'>('editOnly');

    watch(curVal, (newVal, oldVal) => {
      if (!editor) {
        return;
      }
      const content = editor.getMarkdown();
      if (newVal !== oldVal && content !== newVal) {
        editor.setMarkdown(newVal);
      }
    });

    // 值变更事件回调
    const afterChange = () => {
      if (!editor) {
        return;
      }
      emit('change', editor.getMarkdown());
    };

    onMounted(() => {
      if (!editorRef.value) {
        return;
      }
      if (props.disabled || props.readonly) {
        defaultModel.value = 'previewOnly';
      }
      editor = new Cherry({
        el: editorRef.value,
        value: curVal.value,
        theme: theme.value,
        editor: {
          defaultModel: defaultModel.value,
          codemirror: {
            autofocus: false,
          },
        },
        toolbars: {
          theme: theme.value,
          bubble: false,
          float: false,
          sidebar: false,
          toolbar: [
            'bold',
            'italic',
            'header',
            'underline',
            'link',
            'togglePreview',
          ],
        },
        callback: {
          afterChange,
        },
      });
      editor.setTheme(theme.value);
      editor.switchModel(defaultModel.value);
    });

    return {
      c,
      ns,
      editorRef,
      isCollapsed,
      switchCollapsed,
    };
  },
  render() {
    return (
      <div
        class={[
          this.ns.b(),
          this.ns.is('collapsed', this.isCollapsed),
          this.ns.is('readonly', this.disabled || this.readonly),
        ]}
      >
        <div class={[this.ns.b('title')]}>备注</div>
        <div ref='editorRef' class={[this.ns.b('content')]}></div>
        <div
          class={[this.ns.b('btn')]}
          title={this.isCollapsed ? '展开' : '收缩'}
          onClick={this.switchCollapsed}
        >
          <svg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 1024 1024'>
            <path fill='currentColor' d='m192 384 320 384 320-384z'></path>
          </svg>
        </div>
      </div>
    );
  },
});
