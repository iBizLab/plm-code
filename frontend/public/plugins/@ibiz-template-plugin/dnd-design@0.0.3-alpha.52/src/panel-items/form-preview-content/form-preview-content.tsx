import { PropType, defineComponent } from 'vue';
import { IPanelRawItem } from '@ibiz/model-core';
import { useNamespace } from '@ibiz-template/vue3-util';
import { FormPreviewContentController } from './form-preview-content.controller';
import './form-preview-content.scss';

export default defineComponent({
  name: 'IBizFormPreviewContent',
  props: {
    modelData: {
      type: Object as PropType<IPanelRawItem>,
      required: true,
    },
    controller: {
      type: Object as PropType<FormPreviewContentController>,
      required: true,
    },
  },
  setup() {
    const ns = useNamespace('form-preview-content');

    return { ns };
  },
  render() {
    return (
      <div class={this.ns.b()}>
        <iBizFormShell
          data={this.controller.majorData}
          items={this.controller.state.items}
          context={this.controller.panel.context}
        ></iBizFormShell>
      </div>
    );
  },
});
