import { PropType, defineComponent, onMounted, onUnmounted, ref } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { IPanelRawItem } from '@ibiz/model-core';
import { X6PanelItemController } from './x6-panel-item.controller';
import { ScaleToolbar } from '../../components';
import './x6-panel-item.scss';

export default defineComponent({
  name: 'IBizX6PanelItem',
  props: {
    modelData: {
      type: Object as PropType<IPanelRawItem>,
      required: true,
    },
    controller: {
      type: X6PanelItemController,
      required: true,
    },
  },
  setup(props) {
    const ns = useNamespace('x6-panel-item');
    const shellNS = useNamespace('light-theme-shell');
    const x6Ref = ref(null);
    const theme = ref('light');

    // 小地图
    const x6MiniMapRef = ref<HTMLElement>();
    // 容器
    const x6ContainerRef = ref<HTMLElement>();
    // 容器大小变化监听器
    let resizeObserver: ResizeObserver | undefined;

    onMounted(() => {
      if (!x6ContainerRef.value || !x6Ref.value || !x6MiniMapRef.value) {
        return;
      }
      props.controller.initX6(x6Ref.value, x6MiniMapRef.value);
      if (props.controller.panel.state.isMounted) {
        props.controller.load();
      }
      resizeObserver = new ResizeObserver(() => {
        const el = x6ContainerRef.value;
        if (!props.controller.x6 || !el) {
          return;
        }
        props.controller.x6.g.resize(el.offsetWidth, el.offsetHeight);
      });
      resizeObserver.observe(x6ContainerRef.value);
    });

    onUnmounted(() => {
      props.controller.x6.destroy();
      resizeObserver?.disconnect();
    });

    return { ns, shellNS, theme, x6Ref, x6ContainerRef, x6MiniMapRef };
  },
  render() {
    return (
      <div
        ref='x6ContainerRef'
        class={[this.ns.b(), this.ns.m(this.theme), this.shellNS.b()]}
        v-loading={this.controller.state.loading}
      >
        <ScaleToolbar controller={this.$props.controller} />
        <div class={this.ns.b('container')} ref='x6Ref'></div>
        <div class={this.ns.b('minimap')} ref='x6MiniMapRef'></div>
      </div>
    );
  },
});
