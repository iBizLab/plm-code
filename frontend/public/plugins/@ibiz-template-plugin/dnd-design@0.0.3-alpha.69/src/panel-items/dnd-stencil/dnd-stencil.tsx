import { PropType, VNode, defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import {
  IPanelRawItem,
  ICodeItem,
  IUIActionGroupDetail,
} from '@ibiz/model-core';
import { DndStencilPanelItemController } from './dnd-stencil.controller';
import { resource } from '../../global';
import './dnd-stencil.scss';

export default defineComponent({
  name: 'IBizDndStencilPanelItem',
  props: {
    modelData: {
      type: Object as PropType<IPanelRawItem>,
      required: true,
    },
    controller: {
      type: DndStencilPanelItemController,
      required: true,
    },
  },
  setup(props) {
    const ns = useNamespace('dnd-stencil');

    const actives = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9'];

    const clone = (item: ICodeItem) => {
      const data = JSON.parse(item.data || `{}`);
      data.srftype = data.detailtype;
      return data;
    };

    const onStart = (e: IData) => {
      const el = e.item as HTMLDivElement;
      if (el) {
        el.style.setProperty('--svg-visibility', 'hidden');
      }
    };

    const onEnd = (e: IData) => {
      const el = e.item as HTMLDivElement;
      if (el) {
        el.style.setProperty('--svg-visibility', '');
      }
    };

    const onActionClick = async (
      detail: IUIActionGroupDetail,
      event: MouseEvent,
    ): Promise<void> => {
      await props.controller.onActionClick(detail, event);
    };

    // 渲染图标
    const renderIcon = (icon?: string) => {
      if (icon) {
        if (icon.startsWith('http')) {
          return <img src={icon} />;
        }
        if (icon.endsWith('</svg>')) {
          const svg = URL.createObjectURL(
            new Blob([icon], { type: 'image/svg+xml;charset=utf-8' }),
          );
          return <img src={svg} />;
        }
        if (icon.startsWith('data:image')) {
          return <img src={icon} />;
        }
        return <ion-icon src={resource.dir(icon)} />;
      }
    };

    const renderGroup = (
      groupName: string,
      items: ICodeItem[],
      i: number,
      codeName: string,
    ) => {
      const buttonGroup = props.controller.buttonGroupMap.get(codeName);
      const model = buttonGroup && buttonGroup.model;
      const state = buttonGroup && buttonGroup.state;
      const group = model && model.uiactionGroup;
      return (
        <el-collapse-item title={groupName} name={i.toString()}>
          {{
            title: () => {
              return (
                <div class={ns.b('group-header')}>
                  <div class={ns.b('group-header-text')}>{groupName}</div>
                  {group && state ? (
                    <iBizActionToolbar
                      class={ns.b('group-header-toolbar')}
                      actionDetails={group.uiactionGroupDetails}
                      actionsState={state}
                      onActionClick={onActionClick}
                      caption={group.name}
                      mode={
                        model.actionGroupExtractMode === 'ITEMS'
                          ? 'dropdown'
                          : 'buttons'
                      }
                    ></iBizActionToolbar>
                  ) : null}
                </div>
              );
            },
            default: () => {
              return items.length === 0 ? (
                <div class={ns.bm('drag-container', 'empty')}>暂无数据</div>
              ) : (
                <iBizDraggable
                  itemKey='dnd-stencil'
                  sort={false}
                  group={{
                    name: 'dnd-design',
                    pull: 'clone',
                    put: false,
                  }}
                  class={ns.b('drag-container')}
                  list={items}
                  clone={clone}
                  onStart={onStart}
                  onEnd={onEnd}
                >
                  {{
                    item: (data: IData) => {
                      const item = data.element as ICodeItem;
                      return (
                        <div
                          key={data.index}
                          class={[ns.b('handle')]}
                          title={item.text}
                          onDblclick={e => {
                            e.stopPropagation();
                            props.controller.view?.evt.emit('onStencilAdd', {
                              stencil: clone(item),
                            });
                          }}
                        >
                          <svg
                            class={ns.be('handle', 'svg')}
                            height='100%'
                            width='100%'
                            xmlns='http://www.w3.org/2000/svg'
                          >
                            <rect height='100%' width='100%'></rect>
                          </svg>
                          <div class={[ns.b('handle-content')]}>
                            <div class={[ns.be('handle', 'icon')]}>
                              {item.iconPath ? renderIcon(item.iconPath) : null}
                            </div>
                            <div class={[ns.be('handle', 'text')]}>
                              {item.text}
                            </div>
                          </div>
                        </div>
                      );
                    },
                  }}
                </iBizDraggable>
              );
            },
          }}
        </el-collapse-item>
      );
    };

    return { ns, renderGroup, clone, actives };
  },
  render() {
    const content: VNode[] = [];
    if (this.controller.enableGroup) {
      this.controller.state.items.forEach((codeItem, i) => {
        content.push(
          this.renderGroup(
            codeItem.text!,
            codeItem.codeItems || [],
            i,
            codeItem.codeName!,
          ),
        );
      });
    } else {
      content.push(
        this.renderGroup(
          this.controller.codeList.name!,
          this.controller.state.items,
          0,
          this.controller.codeList.codeName!,
        ),
      );
    }
    return (
      <div class={this.ns.b()}>
        <el-collapse v-model={this.actives}>{content}</el-collapse>
      </div>
    );
  },
});
