import { PropType, defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { IPanelRawItem } from '@ibiz/model-core';
import { ActiveHomeButtonController } from './active-home-button.controller';
import './active-home-button.scss';

export default defineComponent({
  name: 'IBizActiveHomeButton',
  props: {
    modelData: {
      type: Object as PropType<IPanelRawItem>,
      required: true,
    },
    controller: {
      type: ActiveHomeButtonController,
      required: true,
    },
  },
  setup(props) {
    const ns = useNamespace('active-home-button');

    const onActiveRoot = (e: MouseEvent) => {
      e.stopPropagation();
      props.controller.panel.view.call('onActiveRoot');
    };

    return { ns, onActiveRoot };
  },
  render() {
    return (
      <div class={this.ns.b()} onClick={this.onActiveRoot}>
        <i class={[this.ns.e('icon'), 'fa fa-home']} />
      </div>
    );
  },
});
