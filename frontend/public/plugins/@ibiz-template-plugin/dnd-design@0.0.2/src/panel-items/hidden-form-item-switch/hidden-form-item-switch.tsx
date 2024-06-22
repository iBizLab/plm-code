import { PropType, defineComponent, ref } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { IPanelRawItem } from '@ibiz/model-core';
import { PanelItemController } from '@ibiz-template/runtime';
import { IDndDesignPanelItemController } from '../../interface';

export default defineComponent({
  name: 'IBizHiddenFormItemSwitch',
  props: {
    modelData: {
      type: Object as PropType<IPanelRawItem>,
      required: true,
    },
    controller: {
      type: PanelItemController,
      required: true,
    },
  },
  setup(props) {
    const ns = useNamespace('hidden-form-item-switch');

    const isActive = ref(false);

    const activeText = '显示';
    const inactiveText = '隐藏';

    const handleChange = (value: boolean) => {
      const view = props.controller.panel.view;
      if (!view) {
        return;
      }
      const dndDesignController = view.layoutPanel?.panelItems
        .dnd_design_panel_item as IDndDesignPanelItemController;
      if (!dndDesignController) {
        return;
      }
      dndDesignController.updateHiddenFormItemVisible(value);
    };

    return { ns, isActive, activeText, inactiveText, handleChange };
  },
  render() {
    return (
      <div class={this.ns.b()}>
        <el-switch
          v-model={this.isActive}
          active-text={this.activeText}
          inactive-text={this.inactiveText}
          inline-prompt={true}
          size={'large'}
          title={`${
            this.isActive ? this.inactiveText : this.activeText
          }隐藏表单项`}
          onChange={this.handleChange}
        ></el-switch>
      </div>
    );
  },
});
