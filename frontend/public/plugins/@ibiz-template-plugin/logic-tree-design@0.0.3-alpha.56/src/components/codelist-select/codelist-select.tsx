import { PropType, defineComponent, ref } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { CodeListItem } from '@ibiz-template/runtime';
import './codelist-select.scss';

export const CodeListSelect = defineComponent({
  name: 'IBizCodeListSelect',
  props: {
    codeListId: {
      type: String,
      required: true,
    },
    context: { type: Object as PropType<IContext>, required: true },
    params: { type: Object as PropType<IParams> },
  },
  emits: ['select'],
  setup(props, { emit }) {
    const ns = useNamespace('codelist-select');
    const codeListItems = ref<readonly CodeListItem[]>();
    ibiz.hub
      .getApp(props.context.srfappid)
      .codeList.get(props.codeListId, props.context, props.params)
      .then(items => {
        codeListItems.value = items;
      });
    const onSelect = (item: CodeListItem) => {
      emit('select', item);
    };
    return { ns, codeListItems, onSelect };
  },
  render() {
    return (
      <div class={[this.ns.b()]}>
        <div class={[this.ns.e('header')]}>新建</div>
        <div class={[this.ns.e('items')]}>
          {this.codeListItems?.map(item => (
            <div
              class={[this.ns.b('item')]}
              onClick={() => this.onSelect(item)}
            >
              {item.sysImage && (
                <iBizIcon
                  class={[this.ns.be('item', 'icon')]}
                  icon={item.sysImage}
                ></iBizIcon>
              )}
              <div class={[this.ns.be('item', 'text')]}>{item.text}</div>
            </div>
          ))}
        </div>
      </div>
    );
  },
});
