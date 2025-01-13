import { useNamespace } from '@ibiz-template/vue3-util';
import { PropType, defineComponent } from 'vue';
import { IDataEntity } from '@ibiz-template/runtime';
import { linkLogicCountIcon } from './icons';
import { X6LinkDataProvider } from '../../../../interface';
import './logic-design-label.scss';

export const LogicDesignLabel = defineComponent({
  props: {
    dataProvider: {
      type: Object as PropType<X6LinkDataProvider<IDataEntity>>,
      required: true,
    },
    isOpenLoopPostProcess: {
      type: Boolean || Number,
      default: false,
    },
    sourceNodeOutgoingEdgeLength: {
      type: Number,
      default: 0,
    },
    logicType: {
      type: String,
    },
  },
  setup(props) {
    const ns = useNamespace('logic-design-label');

    const data = props.dataProvider?.data;
    let logicLinkCount = 0;
    if (data) {
      if (data.linklogiccount != null) {
        logicLinkCount = data.linklogiccount;
      } else if (Array.isArray(data.psdellconds)) {
        logicLinkCount = data.psdellconds.length;
      }
    }

    return {
      ns,
      logicLinkCount,
    };
  },
  render() {
    const isShowCaseText =
      !this.isOpenLoopPostProcess &&
      this.sourceNodeOutgoingEdgeLength > 1 &&
      this.logicType !== 'DATAFLOWLOGIC' &&
      this.logicType !== 'MAINSTATELOGIC';
    if (!this.logicLinkCount && !isShowCaseText) {
      return;
    }
    return (
      <div class={[this.ns.b()]}>
        <div
          class={[
            this.ns.b('right'),
            !this.logicLinkCount ? this.ns.bm('right', 'small') : '',
          ]}
        >
          {isShowCaseText ? (
            <div class={this.ns.b('case-text')}>case</div>
          ) : null}
          {this.logicLinkCount ? (
            <div class={this.ns.b('link-logic-count-icon')}>
              {linkLogicCountIcon()}
            </div>
          ) : null}
        </div>
      </div>
    );
  },
});
