import { defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { DndItemController } from '../../controller';
import { useRenderItems } from '../../use';
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
    const renderItems = useRenderItems();

    return { ns, renderItems };
  },
  render() {
    const data = this.controller.data;
    return (
      <div class={[this.ns.b(), this.ns.b(data.mdctrltype.toLowerCase())]}>
        <div class={this.ns.e('info')}>{data.srftext || ''}[多数据部件]</div>
        {data.mdctrltype === 'REPEATER' && (
          <div class={this.ns.e('content')}>
            {this.renderItems(data.children, data)}
          </div>
        )}
      </div>
    );
  },
});
