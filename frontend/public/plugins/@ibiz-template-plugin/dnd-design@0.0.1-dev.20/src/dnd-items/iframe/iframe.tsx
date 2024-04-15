import { defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { DndItemController } from '../../controller';
import './iframe.scss';

export default defineComponent({
  name: 'IBizDndDesignIframe',
  props: {
    controller: {
      type: DndItemController,
      required: true,
    },
  },
  setup() {
    const ns = useNamespace('dnd-design-iframe');
    return {
      ns,
    };
  },
  render() {
    const data = this.controller.data;
    return (
      <div class={this.ns.b()}>
        <div class={this.ns.b('content')}>
          {data.srftext || ''}[直接嵌入页面（iframe）]
        </div>
      </div>
    );
  },
});
