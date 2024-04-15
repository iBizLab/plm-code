import { PropType, defineComponent, ref, watch } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { IDataEntity } from '@ibiz-template/runtime';
import { IDndItemController } from '../../interface';
import { useRenderItems } from '../../use';
import './tab-panel.scss';

export default defineComponent({
  name: 'IBizDndDesignTabPanel',
  props: {
    controller: {
      type: Object as PropType<IDndItemController>,
      required: true,
    },
  },
  setup(props) {
    const ns = useNamespace('dnd-design-tab-panel');
    const c = props.controller;
    const renderItems = useRenderItems();

    const activePage = ref<string | undefined>();

    const select = ref<IDataEntity>(c.select.data as IDataEntity);

    c.select.on(data => {
      select.value = data as IDataEntity;
    });

    const onActivePageChange = (item: IDataEntity) => {
      activePage.value = item.srfkey;
      c.select.set(item);
    };

    watch(
      select,
      () => {
        const items = c.data.children;
        if (Array.isArray(items) && items.length) {
          if (select.value) {
            const data = items.find(
              item => item.srfkey === select.value.srfkey,
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

    const onPagePositionChange = async (evt: IData) => {
      const items = c.data.children;
      if (Array.isArray(items)) {
        c.change(evt, items, c.data);
      }
    };

    const onPageAdd = async () => {
      const items = c.data.children;
      if (Array.isArray(items)) {
        items.push({
          detailtype: 'TABPAGE',
        } as unknown as IDataEntity);
        c.change(
          {
            added: {
              element: items[items.length - 1],
              newIndex: items.length - 1,
            },
          },
          items,
          c.data,
        );
      }
    };

    const onPageRemove = async (page: IDataEntity) => {
      const items = c.data.children;
      if (Array.isArray(items)) {
        c.remove(items, page);
      }
    };

    return {
      ns,
      activePage,
      select,
      onActivePageChange,
      onPagePositionChange,
      onPageAdd,
      onPageRemove,
      renderItems,
    };
  },

  render() {
    const data = this.controller.data;
    const items = data.children || [];
    return (
      <div class={this.ns.b()}>
        <iBizDraggableTabs
          value={this.activePage}
          items={items}
          dragSwitchPage={false}
          select={this.select}
          class={this.ns.b('content')}
          onChange={this.onActivePageChange}
          onDragChange={this.onPagePositionChange}
          onAdd={this.onPageAdd}
          onRemove={this.onPageRemove}
        >
          {{
            default: (item: IDataEntity) => {
              return this.renderItems(item.children, item);
            },
          }}
        </iBizDraggableTabs>
      </div>
    );
  },
});
