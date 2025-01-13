import { useNamespace } from '@ibiz-template/vue3-util';
import { defineComponent } from 'vue';
import { DndItemController } from '../../controller';
import { useRenderItems } from '../../use';
import './group-panel.scss';

export default defineComponent({
  name: 'IBizDndDesignFormPanel',
  props: {
    controller: {
      type: DndItemController,
      required: true,
    },
  },
  setup() {
    const ns = useNamespace('dnd-design-group-panel');

    const renderItems = useRenderItems();

    return { ns, renderItems };
  },
  render() {
    const data = this.controller.data;
    const isHiddenHeader = data.showcaption === 0;
    return (
      <div class={this.ns.b()}>
        {isHiddenHeader ? (
          <div class={this.ns.b('info')}>{data.srftext || ''}</div>
        ) : (
          <div class={this.ns.b('header')}>
            <div>
              <div class={this.ns.be('header', 'text')}>
                {data.srftext || ''}
              </div>
              <ion-icon
                class={this.ns.be('header', 'icon')}
                name='caret-down'
              ></ion-icon>
            </div>
          </div>
        )}
        <div class={this.ns.b('content')}>
          {this.renderItems(data.children, data)}
        </div>
      </div>
    );
  },
});
