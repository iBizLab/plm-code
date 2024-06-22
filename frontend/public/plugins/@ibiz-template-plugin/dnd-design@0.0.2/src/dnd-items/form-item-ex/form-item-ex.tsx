import { PropType, defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { IDndItemController } from '../../interface';
import './form-item-ex.scss';

export default defineComponent({
  name: 'IBizDndDesignFormItemEx',
  props: {
    controller: {
      type: Object as PropType<IDndItemController>,
      required: true,
    },
  },
  setup() {
    const ns = useNamespace('dnd-design-form-item-ex');
    return {
      ns,
    };
  },
  render() {
    const data = this.controller.data;
    return (
      <div class={this.ns.b()}>
        <div class={this.ns.b('content')}>{data.srftext || ''}[复合表单项]</div>
      </div>
    );
  },
});
