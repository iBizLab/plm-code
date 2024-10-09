import { defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { DndItemController } from '../../controller';
import { picture, video } from './icons';
import './raw-item.scss';

export default defineComponent({
  name: 'IBizDndDesignRawItem',
  props: {
    controller: {
      type: DndItemController,
      required: true,
    },
  },
  setup(props) {
    const ns = useNamespace('dnd-design-raw-item');

    const renderRaw = () => {
      const data = props.controller.data;
      return (
        <div class={ns.e('raw')}>{data.rawcontent || data.srftext || ''}</div>
      );
    };

    const renderHtml = () => {
      const data = props.controller.data;
      if (data.htmlcontent) {
        return <div class={ns.e('html')} v-html={data.htmlcontent}></div>;
      }
      return <div class={ns.e('html')}>{data.srftext || ''}</div>;
    };

    const renderContent = () => {
      const data = props.controller.data;
      switch (data.contenttype) {
        case 'RAW':
          return renderRaw();
        case 'HTML':
          return renderHtml();
        case 'IMAGE':
          return <div class={ns.e('image')}>{picture()}</div>;
        case 'VIDEO':
          return <div class={ns.e('video')}>{video()}</div>;
        case 'PLACEHOLDER':
          return <div class={ns.e('placeholder')}>占位(PLACEHOLDER)</div>;
        case 'DIVIDER':
          return (
            <el-divider class={ns.e('divider')}>分割线(DIVIDER)</el-divider>
          );
        case 'INFO':
          return <div class={ns.e('info')}>常规提示(INFO)</div>;
        case 'WARNING':
          return <div class={ns.e('warning')}>警告提示(WARNING)</div>;
        case 'ERROR':
          return <div class={ns.e('error')}>错误提示(ERROR)</div>;
        default:
          return <div class={ns.e('default')}>直接内容</div>;
      }
    };

    return { ns, renderContent };
  },
  render() {
    return <div class={this.ns.b()}>{this.renderContent()}</div>;
  },
});
