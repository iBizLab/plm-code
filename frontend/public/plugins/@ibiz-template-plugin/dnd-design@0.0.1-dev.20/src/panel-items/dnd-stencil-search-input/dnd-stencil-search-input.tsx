import { IPanelRawItem } from '@ibiz/model-core';
import { PropType, defineComponent, ref, watch } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { DndStencilSearchInputController } from './dnd-stencil-search-input.controller';
import './dnd-stencil-search-input.scss';

export default defineComponent({
  name: 'IBizDndStencilSearchInput',
  props: {
    modelData: {
      type: Object as PropType<IPanelRawItem>,
      required: true,
    },
    controller: {
      type: DndStencilSearchInputController,
      required: true,
    },
  },
  setup(props) {
    const ns = useNamespace('dnd-stencil-search-input');

    const searchValue = ref('');

    watch(searchValue, () => {
      props.controller.sendMessage(searchValue.value);
    });

    return {
      ns,
      searchValue,
    };
  },
  render() {
    return (
      <div class={this.ns.b()}>
        <el-input
          v-model={this.searchValue}
          placeholder='输入关键词进行过滤'
          prefix-icon={<ion-icon name='search-outline'></ion-icon>}
          clearable={true}
        ></el-input>
      </div>
    );
  },
});
