import { PropType, defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { IPanelRawItem } from '@ibiz/model-core';
import { DndDesignPreviewButtonController } from './dnd-design-preview-button.controller';
import './dnd-design-preview-button.scss';

export default defineComponent({
  name: 'IBizDndDesignPreviewButton',
  props: {
    modelData: {
      type: Object as PropType<IPanelRawItem>,
      required: true,
    },
    controller: {
      type: DndDesignPreviewButtonController,
      required: true,
    },
  },
  setup() {
    const ns = useNamespace('dnd-design-preview-button');

    return { ns };
  },
  render() {
    return (
      <div class={this.ns.b()}>
        <el-button
          size='small'
          onClick={() => {
            this.controller.handleButtonClick();
          }}
        >
          {this.controller.state.isPreview ? '取消预览' : '预览'}
        </el-button>
      </div>
    );
  },
});
