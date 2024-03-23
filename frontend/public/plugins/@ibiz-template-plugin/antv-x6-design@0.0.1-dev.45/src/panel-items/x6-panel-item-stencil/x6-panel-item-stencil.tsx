import { PropType, defineComponent, onActivated, onMounted, ref } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { IPanelField } from '@ibiz/model-core';
import { X6PanelItemStencilController } from './x6-panel-item-stencil.controller';
import './x6-panel-item-stencil.scss';

export default defineComponent({
  name: 'IBizX6PanelItemStencil',
  props: {
    modelData: {
      type: Object as PropType<IPanelField>,
      required: true,
    },
    controller: {
      type: X6PanelItemStencilController,
      required: true,
    },
  },
  setup(props) {
    const ns = useNamespace('x6-panel-item-stencil');

    const domRef = ref(null);

    onMounted(() => {
      if (props.controller.panel.state.isMounted) {
        Object.assign(props.controller, { s: undefined });
      }

      props.controller.initStencil(domRef.value!);
    });

    onActivated(() => {
      props.controller.initStencil(domRef.value!);
    });

    return { ns, domRef };
  },
  render() {
    return <div class={this.ns.b()} ref='domRef'></div>;
  },
});
