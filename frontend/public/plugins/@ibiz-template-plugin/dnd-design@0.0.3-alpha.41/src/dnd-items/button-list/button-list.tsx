import { defineComponent, ref, watch } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { DndItemController } from '../../controller';
import { resource } from '../../global';
import './button-list.scss';

export default defineComponent({
  name: 'IBizDndDesignButtonList',
  props: {
    controller: {
      type: DndItemController,
      required: true,
    },
  },
  setup(props) {
    const ns = useNamespace('dnd-design-button-list');

    // 界面行为项
    const items = ref<IData[]>([]);

    // 加载次数
    const count = ref(0);

    // 加载数据
    const load = async () => {
      items.value = [];
      const context = (props.controller as IData).c.panel.context.clone();
      const data = props.controller.data;
      const app = ibiz.hub.getApp(context.srfappid);
      const service = await app.deService.getService(context, 'PSDEUAGroup');
      if (service && data.psdeuagroupid) {
        context.psdeuagroup = data.psdeuagroupid;
        const result = await service.get(context);
        if (result && result.ok && result.data) {
          if (
            count.value > 1 &&
            (!Array.isArray(result.data.psdeuagrpdetails) ||
              !result.data.psdeuagrpdetails.length)
          ) {
            ibiz.message.warning('当前绑定界面行为组未配置界面行为');
            return;
          }
          if (Array.isArray(result.data.psdeuagrpdetails)) {
            items.value = result.data.psdeuagrpdetails;
          }
        }
      }
    };

    watch(
      () => props.controller.data,
      (value, oldValue) => {
        if (count.value <= 1) {
          count.value += 1;
        }
        const oldGroupId = oldValue?.psdeuagroupid;
        const groupId = value?.psdeuagroupid;
        if (groupId !== oldGroupId) {
          load();
        }
      },
      { immediate: true },
    );

    return {
      ns,
      items,
    };
  },
  render() {
    const data = this.controller.data;
    if (!data) {
      return;
    }
    if (!data.psdeuagroupid) {
      return (
        <div class={this.ns.b()}>
          <div class={this.ns.b('placeholder')}>
            <ion-icon
              class={this.ns.be('placeholder', 'icon')}
              src={resource.dir('./assets/svg/action-button.svg')}
            ></ion-icon>
            <div class={this.ns.be('placeholder', 'text')}>按钮组</div>
          </div>
        </div>
      );
    }
    if (data.updatedvt === 'ITEMS') {
      return (
        <div class={this.ns.b()}>
          <div class={this.ns.b('item')}>
            <el-button>...</el-button>
          </div>
        </div>
      );
    }
    return (
      <div class={this.ns.b()}>
        {this.items.map(item => {
          return (
            <div class={this.ns.b('item')}>
              <el-button>{item.uacaption || ''}</el-button>
            </div>
          );
        })}
      </div>
    );
  },
});
