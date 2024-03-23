import { Ref, VNode, defineComponent, ref, watch } from 'vue';
import {
  getInputProps,
  getEditorEmits,
  useNamespace,
} from '@ibiz-template/vue3-util';
import { debounce } from 'lodash-es';
import { CronEditorController } from './cron-editor.controller';
import './cron-editor.scss';

export default defineComponent({
  name: 'IBizCronEditor',
  props: getInputProps<CronEditorController>(),
  emits: getEditorEmits(),
  setup(props, { emit }) {
    const c = props.controller;

    const ns = useNamespace('cron-editor');

    const cronPopover: Ref<Boolean> = ref(false);

    const currentVal = ref<string>('');

    watch(
      () => props.value,
      (newVal, oldVal) => {
        if (newVal !== oldVal) {
          if (newVal == null) {
            currentVal.value = '';
          } else {
            currentVal.value = newVal.toString();
          }
        }
      },
      { immediate: true },
    );

    const changeCron = (val: string) => {
      if (typeof val !== 'string') return false;
      currentVal.value = val;
      emit('change', val);
    };

    const closeCron = () => {
      cronPopover.value = false;
    };

    const changeButton = () => {
      cronPopover.value = !cronPopover.value;
    };

    const debounceChange = debounce(
      (val: string | number) => {
        emit('change', val);
      },
      300,
      { leading: true },
    );

    const handleChange = (val: string) => {
      debounceChange(val);
    };

    return {
      c,
      ns,
      changeCron,
      closeCron,
      changeButton,
      cronPopover,
      currentVal,
      handleChange,
    };
  },
  render() {
    let content = null;
    if (this.readonly) {
      // 只读显示
      content = <span>{this.currentVal}</span>;
    } else {
      content = (
        <el-input
          v-model={this.currentVal}
          disabled={this.c.model.disabled}
          onInput={this.handleChange}
          placeholder={this.c.placeHolder}
        >
          {{
            append: (): VNode => (
              <el-popover
                visible={this.cronPopover}
                width='700px'
                trigger='click'
              >
                {{
                  reference: (): VNode => (
                    <el-button
                      onClick={this.changeButton}
                      disabled={this.c.model.disabled}
                    >
                      设置
                    </el-button>
                  ),
                  default: (): VNode => (
                    <noVue3Cron
                      cronValue={this.currentVal}
                      onChange={this.changeCron}
                      onClose={this.closeCron}
                      maxHeight={'400px'}
                      i18n={'cn'}
                    ></noVue3Cron>
                  ),
                }}
              </el-popover>
            ),
          }}
        </el-input>
      );
    }
    return (
      <div class={[this.ns.b(), this.readonly ? this.ns.m('readonly') : '']}>
        {content}
      </div>
    );
  },
});
