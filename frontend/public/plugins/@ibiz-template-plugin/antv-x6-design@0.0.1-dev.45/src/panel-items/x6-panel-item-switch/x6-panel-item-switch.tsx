import { PropType, defineComponent, onMounted, ref } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { ICodeItem, IPanelField } from '@ibiz/model-core';
import { X6PanelItemSwitchController } from './x6-panel-item-switch.controller';
import './x6-panel-item-switch.scss';

export default defineComponent({
  name: 'IBizX6PanelItemSwitch',
  props: {
    modelData: {
      type: Object as PropType<IPanelField>,
      required: true,
    },
    controller: {
      type: X6PanelItemSwitchController,
      required: true,
    },
  },
  setup(props) {
    const ns = useNamespace('x6-panel-item-switch');
    const activeItem = ref(props.controller.items[0]?.value);
    const indicatorStyle = ref({
      transition: 'none',
      width: '',
      transform: '',
    });

    const key = 'x6_panel_item_switch';

    const onClick = (e: MouseEvent, item: ICodeItem) => {
      e.stopPropagation();
      const el = e.target as HTMLElement;
      if (!el) {
        return;
      }
      indicatorStyle.value.transition = '';
      indicatorStyle.value.width = `${el.offsetWidth}px`;
      indicatorStyle.value.transform = `translateX(${el.offsetLeft}px)`;
      activeItem.value = item.value;
      props.controller.panel.setDataValue(key, activeItem.value);
    };

    props.controller.panel.evt.on('onMounted', () => {
      props.controller.panel.setDataValue(key, activeItem.value);
    });

    const content = ref<HTMLElement | null>(null);

    onMounted(() => {
      const el = content.value;
      if (!el) {
        return;
      }
      const child = Array.from(el.children).find(item =>
        item.classList.contains(ns.is('active', true)),
      ) as HTMLElement;
      if (child) {
        indicatorStyle.value.width = `${child.offsetWidth}px`;
        indicatorStyle.value.transform = `translateX(${child.offsetLeft}px)`;
      }
    });

    return { ns, activeItem, indicatorStyle, content, onClick };
  },
  render() {
    return (
      <div class={this.ns.b()}>
        <div class={this.ns.b('content')} ref='content'>
          {this.controller.items.map(item => {
            return (
              <div
                class={[
                  this.ns.b('item'),
                  this.ns.is('active', this.activeItem === item.value),
                ]}
                onClick={(e: MouseEvent) => this.onClick(e, item)}
              >
                {item.text || ''}
              </div>
            );
          })}
          <div class={this.ns.b('indicator')} style={this.indicatorStyle}></div>
        </div>
      </div>
    );
  },
});
