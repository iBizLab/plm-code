/* eslint-disable no-param-reassign */
/* eslint-disable vue/no-mutating-props */
import { IViewProvider, getViewProvider } from '@ibiz-template/runtime';
import { defineComponent, h, PropType, ref, resolveComponent } from 'vue';
import './special-view.scss';
import { IAppView } from '@ibiz/model-core';
import { useNamespace } from '@ibiz-template/vue3-util';

export const IBizSpecialView = defineComponent({
  name: 'IBizSpecialView',
  props: {
    context: { type: Object as PropType<IContext>, required: true },
    params: { type: Object as PropType<IParams> },
    modelData: { type: Object as PropType<IAppView> },
    viewId: { type: String },
  },
  setup(props) {
    const ns = useNamespace('special-view');
    const isComplete = ref(false);
    const errMsg = ref('');
    const provider = ref<IViewProvider>();
    // 初始化方法
    const init = async (): Promise<void> => {
      try {
        provider.value = await getViewProvider(props.modelData!);
      } catch (error) {
        ibiz.log.error(error);
        errMsg.value = (error as IData).message;
      } finally {
        isComplete.value = true;
      }
    };

    init();

    return { ns, isComplete, errMsg, provider };
  },
  render() {
    if (this.isComplete && this.provider) {
      return h(
        resolveComponent(this.provider.component) as string,
        {
          context: this.$props.context,
          params: this.$props.params,
          modelData: this.$props.modelData,
          ...this.$attrs,
          provider: this.provider,
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
