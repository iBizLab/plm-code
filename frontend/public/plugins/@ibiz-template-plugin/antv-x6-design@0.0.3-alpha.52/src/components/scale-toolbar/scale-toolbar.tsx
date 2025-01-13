import { useNamespace } from '@ibiz-template/vue3-util';
import { defineComponent } from 'vue';
import { enlarge, shrink, oneToOne, adaptive } from './icons';
import { X6PanelItemController } from '../../panel-items/x6-panel-item/x6-panel-item.controller';
import './scale-toolbar.scss';

export const ScaleToolbar = defineComponent({
  props: {
    controller: X6PanelItemController,
  },
  setup(props) {
    const ns = useNamespace('x6-scale-toolbar');
    const shellNS = useNamespace('light-theme-shell');

    const onClick = (tag: string) => {
      if (tag === 'enlarge') {
        props.controller!.x6.g.zoom(0.2);
      } else if (tag === 'shrink') {
        props.controller!.x6.g.zoom(-0.2);
      } else if (tag === 'default') {
        props.controller!.x6.g.zoomTo(1);
      } else if (tag === 'adaptive') {
        props.controller!.x6.g.zoomToFit();
      } else if (tag === 'export') {
        props.controller!.x6.g.exportPNG('logic', {
          copyStyles: false,
          padding: 10,
        });
      }
    };

    return { ns, shellNS, onClick };
  },
  render() {
    return (
      <div class={[this.ns.b(), this.shellNS.b()]}>
        <el-button-group class={this.ns.b('button')}>
          <el-button
            size='small'
            type='primary'
            title='放大'
            onClick={() => this.onClick('enlarge')}
          >
            {enlarge()}
          </el-button>
          <el-button
            size='small'
            type='primary'
            title='缩小'
            onClick={() => this.onClick('shrink')}
          >
            {shrink()}
          </el-button>
          <el-button
            size='small'
            type='primary'
            title='缩放至1:1'
            onClick={() => this.onClick('default')}
          >
            {oneToOne()}
          </el-button>
          <el-button
            size='small'
            type='primary'
            title='缩放至适应屏幕大小'
            onClick={() => this.onClick('adaptive')}
          >
            {adaptive()}
          </el-button>
          {/* <el-button
            size='small'
            type='primary'
            title='导出为图片'
            onClick={() => this.onClick('export')}
          >
            {exportIcon()}
          </el-button> */}
        </el-button-group>
      </div>
    );
  },
});
