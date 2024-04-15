import { defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { DndItemController } from '../../controller';
import './mdctrl.scss';

export default defineComponent({
  name: 'IBizDndDesignMDCtrl',
  props: {
    controller: {
      type: DndItemController,
      required: true,
    },
  },
  setup() {
    const ns = useNamespace('dnd-design-mdctrl');
    return {
      ns,
    };
  },
  render() {
    const data = this.controller.data;
    return (
      <div class={this.ns.b()}>
        <div class={this.ns.b('content')}>{data.srftext || ''}[多数据部件]</div>
      </div>
    );
  },
});
