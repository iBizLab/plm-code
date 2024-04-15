import { PropType, defineComponent, onMounted, onUnmounted, ref } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { IPanelRawItem } from '@ibiz/model-core';
import { X6PanelItemController } from './x6-panel-item.controller';
import { ScaleToolbar } from '../../components';
import './x6-panel-item.scss';

export default defineComponent({
  name: 'IBizX6PanelItem',
  props: {
    modelData: {
      type: Object as PropType<IPanelRawItem>,
      required: true,
    },
    controller: {
      type: X6PanelItemController,
      required: true,
    },
  },
  setup(props) {
    const ns = useNamespace('x6-panel-item');
    const x6Ref = ref(null);

    onMounted(() => {
      props.controller.initX6(x6Ref.value!);
      if (props.controller.panel.state.isMounted) {
        props.controller.load();
      }
    });

    onUnmounted(() => {
      props.controller.x6.destroy();
    });

    return { ns, x6Ref };
  },
  render() {
    return (
      <div class={this.ns.b()}>
        <ScaleToolbar controller={this.$props.controller} />
        <div class={this.ns.b('container')} ref='x6Ref'></div>
        <div class={this.ns.b('minimap')}></div>
      </div>
    );
  },
});
