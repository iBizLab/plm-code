/* eslint-disable no-shadow */
/* eslint-disable array-callback-return */
import {
  ControlType,
  findChildFormDetails,
  FormController,
  ScriptFactory,
} from '@ibiz-template/runtime';
import { useNamespace } from '@ibiz-template/vue3-util';
import { IDEFormDetail, IDEFormItem } from '@ibiz/model-core';
import {
  defineComponent,
  h,
  PropType,
  renderSlot,
  resolveComponent,
  VNode,
} from 'vue';
import './memo-form.scss';

export const MemoFormControl = defineComponent({
  name: 'IBizMemoFormControl',
  props: {
    controller: {
      type: Object as PropType<FormController>,
      required: true,
    },
  },
  setup(props, { slots }) {
    const ns = useNamespace('memo-form');

    const c = props.controller;

    /** 作用域插槽提供的参数 */
    const slotProps: IData = { form: c };

    /**
     * 绘制成员的attrs
     * @author lxm
     * @date 2024-03-19 03:48:00
     * @param {IDEFormDetail} model
     * @return {*}  {IParams}
     */
    const renderAttrs = (model: IDEFormDetail): IParams => {
      const attrs: IParams = {};
      model.controlAttributes?.forEach(item => {
        if (item.attrName && item.attrValue) {
          attrs[item.attrName!] = ScriptFactory.execSingleLine(
            item.attrValue!,
            {
              ...props.controller.getEventArgs(),
              data: props.controller.data,
            },
          );
        }
      });
      return attrs;
    };

    /**
     * 按照类型绘制表单成员
     * @author lxm
     * @date 2023-06-12 06:24:14
     * @param {IDEFormDetail} detail
     * @return {*}  {(VNode | VNode[] | undefined)}
     */
    const renderByDetailType = (
      detail: IDEFormDetail,
      hidden: boolean = true,
    ): VNode | VNode[] | undefined => {
      if ((detail as IDEFormItem).hidden) {
        return;
      }
      const detailId = detail.id!;

      // 有插槽走插槽
      if (slots[detailId]) {
        return renderSlot(slots, detailId, {
          model: detail,
          data: c.state.data,
          value: c.state.data[detailId],
        });
      }

      // 子插槽
      const childSlots: IData = {};
      // 表单项如果有编辑器插槽的时候，调用插槽绘制表单项的默认插槽。
      if (detail.detailType === 'FORMITEM' && slots[`${detailId}_editor`]) {
        childSlots.default = (...args: IData[]): VNode[] => {
          return slots[`${detailId}_editor`]!(...args);
        };
      }
      const childDetails = findChildFormDetails(detail);
      if (childDetails.length) {
        // 容器成员绘制子成员
        childSlots.default = (): (VNode[] | VNode | undefined)[] =>
          childDetails.map(child => {
            return renderByDetailType(child);
          });
      }

      // 根据适配器绘制表单成员
      const provider = c.providers[detailId];
      if (!provider) {
        return (
          <div>
            {ibiz.i18n.t('control.form.noSupportDetailType', {
              detailType: detail.detailType,
            })}
          </div>
        );
      }
      const component = resolveComponent(provider.component) as string;
      if (detail.detailType === 'FORMITEM' && hidden) {
        const formItem = detail as IDEFormItem;
        if (
          formItem.editor &&
          formItem.editor.editorType === 'TEXTAREA' &&
          formItem.codeName === 'memo'
        ) {
          return;
        }
      }
      return h(
        component,
        {
          modelData: detail,
          controller: c.details[detailId],
          key: detail.id,
          attrs: renderAttrs(detail),
        },
        childSlots,
      );
    };

    /** 内置表单成员组件 */
    const FormDetail = (_props: {
      modelData: IDEFormDetail | IDEFormDetail[];
    }): (VNode | VNode[] | undefined)[] => {
      const { modelData } = _props;
      const detailModels = modelData instanceof Array ? modelData : [modelData];
      return detailModels.map(detail => {
        return renderByDetailType(detail);
      });
    };
    FormDetail.props = ['modelData'];

    slotProps.FormDetail = FormDetail;

    return { ns, c, FormDetail, slotProps, renderByDetailType, renderAttrs };
  },
  render() {
    const { state, model, controlPanel } = this.c;
    const { isCreated } = state;
    const slots: IData = {};
    if (isCreated) {
      if (this.$slots.default) {
        slots.default = () => {
          return this.$slots.default!({
            ...this.slotProps,
          });
        };
      } else {
        // 部件布局的默认占位标识
        const formSlotKey =
          model.controlType === ControlType.SEARCHFORM ? 'searchform' : 'form';
        const key = controlPanel ? formSlotKey : 'default';
        let memo: IDEFormItem | undefined;
        this.c.formItems.some(item => {
          const model = item.model;
          if (model.detailType === 'FORMITEM') {
            if (
              model.editor &&
              model.editor.editorType === 'TEXTAREA' &&
              model.codeName === 'memo'
            ) {
              memo = model;
              return true;
            }
          }
        });
        // 树自己绘制，要传递额外的参数
        slots[key] = () => {
          return [
            <div class={this.ns.b('container')}>
              <div class={this.ns.b('content')}>
                <iBizFormPage modelData={this.c.model} controller={this.c}>
                  {this.c.model.deformPages?.map(page => {
                    return this.renderByDetailType(page);
                  })}
                </iBizFormPage>
              </div>
              <div class={this.ns.b('footer')}>
                {memo && (
                  <iBizFormItem
                    modelData={memo}
                    controller={this.c.details[memo.id!]}
                    key={memo.id}
                    attrs={this.renderAttrs(memo)}
                  >
                    {{
                      default: (editorProps: IData) => {
                        const component = resolveComponent(
                          'IBizMarkdownMemoEditor',
                        );
                        return h(component, { ...editorProps });
                      },
                    }}
                  </iBizFormItem>
                )}
              </div>
            </div>,
          ];
        };
      }
    }

    return (
      <iBizControlBase class={[this.ns.b()]} controller={this.c}>
        {slots}
      </iBizControlBase>
    );
  },
});
