import { useNamespace } from '@ibiz-template/vue3-util';
import { PropType, defineComponent } from 'vue';
import { IDataEntity } from '@ibiz-template/runtime';
import { createUUID } from 'qx-util';
import { modelStateUtil } from '../../utils';
import { IDndDesignPanelItemController } from '../../interface';
import './dnd-draggable-tabs.scss';

export default defineComponent({
  name: 'IBizDraggableTabs',
  props: {
    value: {
      type: String,
    },
    items: {
      type: Array as PropType<IDataEntity[]>,
      required: true,
      default: (): IDataEntity[] => {
        return [];
      },
    },
    dragSwitchPage: {
      type: Boolean,
      default: true,
    },
    select: {
      type: Object as PropType<IDataEntity>,
    },
    dndDesignController: {
      type: Object as PropType<IDndDesignPanelItemController>,
      required: true,
    },
  },
  emits: ['change', 'drag-change', 'remove', 'add'],
  setup(props, { emit }) {
    const ns = useNamespace('dnd-design-draggable-tabs');
    const shellNS = useNamespace('light-theme-shell');

    const uuid = createUUID();

    const onDragChange = (evt: IData) => {
      emit('drag-change', evt);
    };

    const onItemClick = (item: IDataEntity) => {
      if (
        item.srfkey !== props.value ||
        !props.select ||
        props.select.srfkey !== props.value
      ) {
        emit('change', item);
      }
    };

    const onAddButtonClick = (e: MouseEvent) => {
      e.stopPropagation();
      emit('add');
    };

    const onConfirm = (item: IDataEntity) => {
      emit('remove', item);
    };

    const timerMap = new Map<string, number[]>();

    const onDragenter = (_e: DragEvent, item: IDataEntity) => {
      if (!props.dragSwitchPage) {
        return;
      }
      if (item.srfkey) {
        const timerList = timerMap.get(item.srfkey) || [];
        const timer = window.setTimeout(() => {
          onItemClick(item);
          timerList.pop();
        }, 500);
        timerList.push(timer);
        timerMap.set(item.srfkey, timerList);
      }
    };

    const onDragLeave = (_e: DragEvent, item: IDataEntity) => {
      if (!props.dragSwitchPage) {
        return;
      }
      if (item.srfkey) {
        const timerList = timerMap.get(item.srfkey);
        if (timerList) {
          const timer = timerList.pop();
          if (timer) {
            clearTimeout(timer);
          }
        }
      }
    };

    return {
      ns,
      shellNS,
      uuid,
      onDragChange,
      onItemClick,
      onConfirm,
      onAddButtonClick,
      onDragenter,
      onDragLeave,
    };
  },
  render() {
    return (
      <div class={this.ns.b()}>
        <div class={this.ns.b('header')}>
          <iBizDraggable
            class={this.ns.b('nav')}
            list={this.items}
            group={{
              name: this.uuid,
              pull: false,
            }}
            filter={`.${this.ns.bm('item', 'forbid')}`}
            itemKey='srfkey'
            onChange={this.onDragChange}
          >
            {{
              item: (args: { element: IDataEntity; index: number }) => {
                const { element, index } = args;
                const isActive = this.value
                  ? this.value === element.srfkey
                  : index === 0;
                const state = this.dndDesignController.getModelState(element);
                return (
                  <div
                    class={[
                      this.ns.b('item'),
                      this.ns.is('active', isActive),
                      !modelStateUtil.isEnableDrag(state) &&
                        this.ns.bm('item', 'forbid'),
                    ]}
                    onClick={(e: MouseEvent) => {
                      e.stopPropagation();
                      this.onItemClick(element);
                    }}
                    onDragenter={(e: DragEvent) => this.onDragenter(e, element)}
                    onDragleave={(e: DragEvent) => this.onDragLeave(e, element)}
                  >
                    <div class={this.ns.be('item', 'text')}>
                      {element.srftext || ''}
                    </div>
                    {modelStateUtil.isEnableRemove(state) && (
                      <div class={this.ns.be('item', 'remove-button')}>
                        <el-popconfirm
                          title='确认删除表单分页?子数据将一并删除!'
                          confirm-button-text='确认'
                          cancel-button-text='取消'
                          width='auto'
                          placement='left'
                          popper-class={[
                            this.ns.be('item', 'pop-confirm'),
                            this.shellNS.m('popper'),
                          ]}
                          icon={<ion-icon name='alert-circle'></ion-icon>}
                          icon-color='#faad14'
                          onConfirm={() => this.onConfirm(element)}
                        >
                          {{
                            reference: () => {
                              return (
                                <ion-icon
                                  name='close-outline'
                                  onClick={(e: MouseEvent) => {
                                    e.stopPropagation();
                                  }}
                                ></ion-icon>
                              );
                            },
                          }}
                        </el-popconfirm>
                      </div>
                    )}
                  </div>
                );
              },
              footer: () => {
                return (
                  <div
                    class={this.ns.b('item-add-button')}
                    onClick={(e: MouseEvent) => this.onAddButtonClick(e)}
                    title='新建分页'
                  >
                    <ion-icon
                      name='add-outline'
                      class={this.ns.be('item-add-button', 'icon')}
                    ></ion-icon>
                  </div>
                );
              },
            }}
          </iBizDraggable>
        </div>

        <div class={this.ns.b('content')}>
          {this.items.map((item, i) => {
            const isHidden = this.value ? item.srfkey !== this.value : i !== 0;
            const isShowMask = this.dndDesignController.isShowMask(item);
            return (
              <div
                class={[
                  this.ns.b('item-content'),
                  this.ns.is('hidden', isHidden),
                  this.ns.is(
                    'select',
                    this.select && item.srfkey === this.select.srfkey,
                  ),
                  isShowMask ? this.ns.bm('item-content', 'mask') : '',
                ]}
                onClick={(e: MouseEvent) => {
                  e.stopPropagation();
                  this.onItemClick(item);
                }}
              >
                {isShowMask && (
                  <div class={this.ns.be('item-content', 'mask')}></div>
                )}
                {this.$slots.default?.(item)}
              </div>
            );
          })}
        </div>
      </div>
    );
  },
});
