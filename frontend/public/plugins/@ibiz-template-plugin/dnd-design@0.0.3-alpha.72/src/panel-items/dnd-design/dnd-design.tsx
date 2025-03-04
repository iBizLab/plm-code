/* eslint-disable no-nested-ternary */
/* eslint-disable no-use-before-define */
import {
  PropType,
  defineComponent,
  resolveComponent,
  h,
  VNode,
  provide,
  ref,
  Transition,
} from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { IPanelRawItem } from '@ibiz/model-core';
import { IDataEntity } from '@ibiz-template/runtime';
import { DndDesignPanelItemController } from './dnd-design.controller';
import { IActionItem } from '../../interface';
import { layoutUtil, modelStateUtil } from '../../utils';
import './dnd-design.scss';

export default defineComponent({
  name: 'IBizDndDesignPanelItem',
  props: {
    modelData: {
      type: Object as PropType<IPanelRawItem>,
      required: true,
    },
    controller: {
      type: DndDesignPanelItemController,
      required: true,
    },
  },
  setup(props) {
    const c = props.controller;

    const select = ref<IDataEntity>();

    const ns = useNamespace('dnd-design');
    const shellNS = useNamespace('light-theme-shell');

    const theme = ref('light');

    c.view.select.on(data => {
      select.value = data as IDataEntity;
    });

    const onSelect = (e: MouseEvent, item: IDataEntity) => {
      e.stopPropagation();
      c.view.select.set(item);
    };

    const onActiveRoot = (e: MouseEvent) => {
      e.stopPropagation();
      c.view.call('onActiveRoot');
    };

    const renderItems = (
      items: IDataEntity[],
      parent?: IDataEntity,
      renderChildren?: (
        items2: IDataEntity[],
        parent2: IDataEntity,
      ) => VNode | VNode[],
    ): VNode => {
      const key = `dnd-design-${parent ? parent.srfkey : 'root'}`;
      const modelState = parent ? c.getModelState(parent) : 0;
      return (
        <iBizDraggable
          class={{
            [ns.b('drag-container')]: true,
            ...(parent
              ? layoutUtil.getDraggableContainerClass(parent, ns)
              : {}),
          }}
          style={parent ? layoutUtil.getFlexLayoutStyle(parent) : {}}
          itemKey='srfkey'
          handle='.handle'
          key={key}
          group={{
            name: 'dnd-design',
            put: modelStateUtil.isEnableDrop(modelState),
          }}
          ghost-class={ns.b('ghost')}
          list={items}
          onChange={(e: IData) => c.change(e, items, parent)}
        >
          {{
            item: (data: IData) => {
              const item = data.element as IDataEntity;
              const provider = c.providers[item.srfkey!];
              if (!provider) {
                return null;
              }
              const controller = c.controllers[item.srfkey!];
              const com = resolveComponent(provider.component);
              const state = c.getModelState(item);
              if (
                item.editortype === 'HIDDEN' &&
                !c.state.hiddenFormItemVisible
              ) {
                return null;
              }
              return (
                <iBizDraggableItem
                  class={parent ? layoutUtil.calcColClass(item, parent) : {}}
                  style={parent ? layoutUtil.calcStyle(item, parent) : {}}
                  controller={controller}
                  isSelect={select.value?.srfkey === item.srfkey}
                  key={item.srfkey}
                  item={item}
                  actions={controller.actions}
                  modelState={state}
                  isShowMask={c.isShowMask(item)}
                  isShowLogicButton={!!c.state.logicMap[item.srfkey]}
                  onClick={(e: MouseEvent) => onSelect(e, item)}
                  onAction={(action: IActionItem) => {
                    if (action.command === 'logic') {
                      c.openLogicView(item);
                      return;
                    }
                    controller.onAction(action).then((result: boolean) => {
                      if (result === false) {
                        if (action.command === 'delete') {
                          c.remove(items, item);
                        }
                      }
                    });
                  }}
                >
                  {h(
                    com,
                    {
                      controller,
                      dndDesignController: c,
                      formItemLabelWidth: c.state.formItemLabelWidth,
                    },
                    renderChildren
                      ? renderChildren(items, item)
                      : item.children
                        ? () => renderItems(item.children, item)
                        : undefined,
                  )}
                </iBizDraggableItem>
              );
            },
          }}
        </iBizDraggable>
      );
    };

    const renderFormPage = (): VNode => {
      return (
        <iBizDndDesignFormPage
          key={c.state.uuid}
          items={c.state.items}
          dndDesignController={c}
          select={select.value}
          onChange={(e: IData) => c.change(e, c.state.items)}
          onRemove={(item: IDataEntity) => c.remove(c.state.items, item)}
          onSelect={(item: IDataEntity) => {
            c.view.select.set(item);
          }}
        >
          {{
            default: (item: IDataEntity) => {
              if (!item.children) {
                item.children = [];
              }
              return renderItems(item.children, item);
            },
          }}
        </iBizDndDesignFormPage>
      );
    };

    provide('dndDesignRenderItems', renderItems);

    return { ns, shellNS, theme, renderItems, renderFormPage, onActiveRoot };
  },
  render() {
    const { isPreview, previewData, previewKey } = this.controller.state;
    return (
      <div
        class={[this.ns.b(), this.ns.m(this.theme), this.shellNS.b()]}
        onClick={(e: MouseEvent) => {
          this.onActiveRoot(e);
        }}
      >
        <Transition name='dnd-design-fade'>
          <div class={this.ns.b('preview-container')} v-show={isPreview}>
            {isPreview && previewData ? (
              <iBizFormShell
                key={previewKey}
                data={previewData}
                items={previewData.psdeformdetails}
                context={this.controller.panel.context}
              ></iBizFormShell>
            ) : null}
          </div>
        </Transition>
        <Transition name='dnd-design-fade'>
          <div class={this.ns.b('container')} v-show={!isPreview}>
            {this.renderFormPage()}
          </div>
        </Transition>
      </div>
    );
  },
});
