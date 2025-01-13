import { defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { DndItemController } from '../../controller';
import './button.scss';

export default defineComponent({
  name: 'IBizDndDesignButton',
  props: {
    controller: {
      type: DndItemController,
      required: true,
    },
  },
  setup() {
    const ns = useNamespace('dnd-design-button');
    return {
      ns,
    };
  },
  render() {
    const data = this.controller.data;
    return (
      <div class={this.ns.b()}>
        <el-button class={this.ns.b('content')}>
          {data.showcaption !== 0 ? data.srftext || '' : '*'}
        </el-button>
      </div>
    );
  },
});
