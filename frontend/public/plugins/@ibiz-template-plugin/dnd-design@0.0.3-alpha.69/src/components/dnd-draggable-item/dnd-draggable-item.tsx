import { computed, defineComponent, PropType } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { IActionItem } from '../../interface';
import { modelStateUtil } from '../../utils';
import './dnd-draggable-item.scss';

export default defineComponent({
  name: 'IBizDraggableItem',
  props: {
    isSelect: {
      type: Boolean,
      default: false,
    },
    item: {
      type: Object as PropType<IData>,
      required: true,
    },
    actions: {
      type: Array as PropType<IActionItem[]>,
      required: false,
    },
    modelState: {
      type: Number,
      required: true,
    },
    isShowMask: {
      type: Boolean,
    },
    isShowLogicButton: {
      type: Boolean,
    },
  },
  setup(props, { emit }) {
    const ns = useNamespace('dnd-design-draggable-item');

    const onClick = (e: MouseEvent, action: IActionItem) => {
      e.stopPropagation();
      emit('action', action);
    };

    const layoutStyle = computed(() => {
      return {
        width: props.item.width ? `${props.item.width}px` : '',
        height: props.item.height ? `${props.item.height}px` : '',
      };
    });

    return { ns, layoutStyle, onClick };
  },
  render() {
    return (
      <div
        class={[this.ns.b(), this.ns.is('select', this.isSelect)]}
        style={this.layoutStyle}
      >
        <div
          class={[
            this.ns.b('content'),
            this.isShowMask ? this.ns.bm('content', 'mask') : '',
          ]}
        >
          {this.isShowMask && <div class={this.ns.be('content', 'mask')}></div>}
          {this.$slots.default?.()}
        </div>

        {modelStateUtil.isEnableDrag(this.modelState) && (
          <div class={[this.ns.e('handle'), 'handle']}>
            <svg
              viewBox='64 64 896 896'
              data-icon='drag'
              width='1em'
              height='1em'
              fill='currentColor'
              aria-hidden='true'
              focusable='false'
              class=''
            >
              <path d='M909.3 506.3L781.7 405.6a7.23 7.23 0 0 0-11.7 5.7V476H548V254h64.8c6 0 9.4-7 5.7-11.7L517.7 114.7a7.14 7.14 0 0 0-11.3 0L405.6 242.3a7.23 7.23 0 0 0 5.7 11.7H476v222H254v-64.8c0-6-7-9.4-11.7-5.7L114.7 506.3a7.14 7.14 0 0 0 0 11.3l127.5 100.8c4.7 3.7 11.7.4 11.7-5.7V548h222v222h-64.8c-6 0-9.4 7-5.7 11.7l100.8 127.5c2.9 3.7 8.5 3.7 11.3 0l100.8-127.5c3.7-4.7.4-11.7-5.7-11.7H548V548h222v64.8c0 6 7 9.4 11.7 5.7l127.5-100.8a7.3 7.3 0 0 0 .1-11.4z'></path>
            </svg>
          </div>
        )}
        {this.actions ? (
          <ul class={this.ns.b('actions')}>
            {this.actions.map(action => {
              if (
                action.command === 'delete' &&
                !modelStateUtil.isEnableRemove(this.modelState)
              ) {
                return;
              }
              if (action.command === 'delete' && !this.isSelect) {
                return;
              }
              if (action.command === 'logic' && !this.isShowLogicButton) {
                return;
              }

              return (
                <li
                  class={this.ns.be('actions', 'item')}
                  title={action.tooltip}
                  onClick={e => this.onClick(e, action)}
                >
                  {action.icon}
                </li>
              );
            })}
          </ul>
        ) : null}
      </div>
    );
  },
});
