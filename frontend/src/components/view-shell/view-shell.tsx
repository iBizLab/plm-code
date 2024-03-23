/* eslint-disable no-param-reassign */
/* eslint-disable vue/no-mutating-props */
import { IViewProvider } from '@ibiz-template/runtime';
import { defineComponent, h, PropType, ref, Component } from 'vue';
import { IAppView } from '@ibiz/model-core';
import './view-shell.scss';
import { useNamespace } from '@ibiz-template/vue3-util';
import { getAppViewComponent } from '@/publish/pages';

export const IBizViewShell = defineComponent({
  name: 'IBizViewShell',
  props: {
    context: { type: Object as PropType<IContext>, required: true },
    params: { type: Object as PropType<IParams> },
    modelData: { type: Object as PropType<IAppView> },
    viewId: { type: String },
  },
  setup(props) {
    const ns = useNamespace('view-shell');
    const isComplete = ref(false);
    const errMsg = ref('');
    const provider = ref<IViewProvider>();
    const viewComponent = ref<Component>();
    // 初始化方法
    const init = async (): Promise<void> => {
      const viewId = props.modelData ? props.modelData.id! : props.viewId!;
      viewComponent.value = await getAppViewComponent(viewId);

      if (!viewComponent.value) {
        errMsg.value = `未找到${viewId}对应的视图组件`;
      }
      isComplete.value = true;
    };

    init();

    return { ns, isComplete, errMsg, viewComponent, provider };
  },
  render() {
    if (this.isComplete && this.viewComponent) {
      return h(
        this.viewComponent,
        {
          context: this.$props.context,
          params: this.$props.params,
          ...this.$attrs,
        },
        this.$slots,
      );
    }
    return (
      <div class={this.ns.b()} v-loading={!this.isComplete}>
        {this.isComplete ? this.errMsg : null}
      </div>
    );
  },
});
