import { useNamespace } from '@ibiz-template/vue3-util';
import { IDataEntity } from '@ibiz-template/runtime';
import { PropType, defineComponent, ref, watch } from 'vue';
import { IDndDesignPanelItemController } from '../../interface';
import './form-page.scss';

export default defineComponent({
  name: 'IBizDndDesignFormPage',
  props: {
    items: {
      type: Array as PropType<IDataEntity[]>,
      required: true,
      default: (): IDataEntity[] => {
        return [];
      },
    },
    select: {
      type: Object as PropType<IDataEntity>,
    },
    dndDesignController: {
      type: Object as PropType<IDndDesignPanelItemController>,
      required: true,
    },
  },
  emits: ['change', 'remove', 'select'],
  setup(props, { emit }) {
    const ns = useNamespace('dnd-design-form-page');

    const activePage = ref<string | undefined>();

    watch(
      () => props.select,
      () => {
        const items = props.items;
        if (Array.isArray(items) && items.length) {
          if (props.select) {
            const data = items.find(
              item => item.srfkey === props.select!.srfkey,
            );
            if (data) {
              activePage.value = data.srfkey;
            }
          }
        }
      },
      {
        immediate: true,
      },
    );

    const onActivePageChange = (item: IDataEntity) => {
      activePage.value = item.srfkey;
      emit('select', item);
    };

    const onPagePositionChange = async (evt: IData) => {
      emit('change', evt);
    };

    const onPageAdd = async () => {
      const items = props.items;
      items.push({
        detailtype: 'FORMPAGE',
      } as unknown as IDataEntity);
      emit('change', {
        added: {
          element: items[items.length - 1],
          newIndex: items.length - 1,
        },
      });
    };

    const onPageRemove = async (page: IDataEntity) => {
      emit('remove', page);
    };

    return {
      ns,
      activePage,
      onActivePageChange,
      onPagePositionChange,
      onPageAdd,
      onPageRemove,
    };
  },
  render() {
    return (
      <div class={this.ns.b()}>
        <iBizDraggableTabs
          value={this.activePage}
          items={this.items}
          dndDesignController={this.dndDesignController}
          select={this.select}
          onChange={this.onActivePageChange}
          onDragChange={this.onPagePositionChange}
          onAdd={this.onPageAdd}
          onRemove={this.onPageRemove}
        >
          {{
            default: (item: IDataEntity) => {
              return this.$slots.default?.(item);
            },
          }}
        </iBizDraggableTabs>
      </div>
    );
  },
});
