/* eslint-disable no-param-reassign */
import { IControlProvider } from '@ibiz-template/runtime';
import { useControlController, useNamespace } from '@ibiz-template/vue3-util';
import { IDEEditForm } from '@ibiz/model-core';
import { defineComponent, PropType, reactive, watch } from 'vue';
import { MemoEditFormController } from './memo-edit-form.controller';

export const MemoEditFormControl = defineComponent({
  name: 'IBizMemoEditFormControl',
  props: {
    modelData: {
      type: Object as PropType<IDEEditForm>,
      required: true,
    },
    context: { type: Object as PropType<IContext>, required: true },
    params: { type: Object as PropType<IParams>, default: () => ({}) },
    provider: { type: Object as PropType<IControlProvider> },
    isSimple: { type: Boolean, required: false },
    data: { type: Object as PropType<IData>, required: false },
    loadDefault: { type: Boolean, default: true },
  },
  setup(props) {
    const c = useControlController(
      (...args) => new MemoEditFormController(...args),
      { excludePropsKeys: ['data'] },
    );

    if (props.isSimple) {
      c.evt.on('onMounted', () => {
        // 第一次data直接赋值，后面默认加载会走load
        c.setSimpleData(props.data || {});
      });
      watch(
        () => props.data,
        newVal => {
          const changeVal = newVal || {};
          // 找有没有不一致的属性
          const find = Object.keys(c.data).find(key => {
            return changeVal[key] !== c.data[key];
          });
          // 内外部数据不一致时，只能是外部修改了，这是更新数据并重走load
          if (find) {
            c.setSimpleData(changeVal);
          }
        },
        { deep: true },
      );
    }

    const ns = useNamespace(`control-${c.model.controlType!.toLowerCase()}`);

    c.evt.on('onCreated', () => {
      // 表单成员state响应式
      const keys = Object.keys(c.details);
      keys.forEach(key => {
        const detail = c.details[key];
        detail.state = reactive(detail.state);
      });
    });

    return { c, ns };
  },

  render() {
    return (
      <iBizMemoFormControl class={this.ns.b()} controller={this.c}>
        {{ ...this.$slots }}
      </iBizMemoFormControl>
    );
  },
});
