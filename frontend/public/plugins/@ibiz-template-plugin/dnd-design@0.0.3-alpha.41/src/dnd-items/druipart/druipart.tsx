import { defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { DndItemController } from '../../controller';
import './druipart.scss';

export default defineComponent({
  name: 'IBizDndDesignDRUIPart',
  props: {
    controller: {
      type: DndItemController,
      required: true,
    },
  },
  setup() {
    const ns = useNamespace('dnd-design-druipart');
    return {
      ns,
    };
  },
  render() {
    const data = this.controller.data;
    return (
      <div class={this.ns.b()}>
        <div class={this.ns.b('content')}>{data.srftext || ''}[关系]</div>
      </div>
    );
  },
});
