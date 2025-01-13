/* eslint-disable @typescript-eslint/explicit-function-return-type */
import { getInputProps, useNamespace } from '@ibiz-template/vue3-util';
import { clone, debounce } from '@ibiz-template/core';
import { defineComponent, ref, watch } from 'vue';
import { ViewNavParamsController } from './view-nav-params.controller';
import './view-nav-params.scss';

export const ViewNavParams = defineComponent({
  name: 'ViewNavParams',
  props: getInputProps<ViewNavParamsController>(),
  emits: ['change'],
  setup(props, { emit }) {
    const ns = useNamespace('view-nav-params');
    const c = props.controller;
    // 是否使用自定义
    const isCustom = ref(false);

    // 自定义输入值
    const curValue = ref('');

    // 参数数组
    const items = ref<IData[]>([]);

    // 参数类型列表
    const paramType = [
      {
        label: '默认',
        value: 'DEFAULT',
      },
      {
        label: '上下文',
        value: 'SRFNAVCTX',
      },
      {
        label: '视图参数',
        value: 'SRFNAVPARAM',
      },
    ];

    // 参数值类型
    const paramValueType = [
      {
        label: '直接值',
        value: 1,
      },
      {
        label: '填充值',
        value: 2,
      },
    ];

    // 将字符串格式化为参数数组
    const formatParams = (value: string) => {
      const list = value.split('\n');
      const params: IData[] = [];
      list.forEach((item: string) => {
        if (!item) {
          return;
        }
        const param = item.split('=');
        let tempParamType = 'DEFAULT';
        let tempParamKey = '';
        let tempValue = param[1];
        let tempValueType = 1;
        if (param[0].indexOf('.') >= 0) {
          // 不是默认类型,第一个值就是类型,第二个值为参数key
          const typeKey = param[0].split('.');
          tempParamType = typeKey[0];
          tempParamKey = typeKey[1];
        } else {
          // 是默认类型
          tempParamKey = param[0];
        }

        if (param[1].startsWith('%') && param[1].endsWith('%')) {
          tempValue = param[1].slice(1, -1);
          tempValueType = 2;
        }

        params.push({
          paramType: tempParamType,
          paramKey: tempParamKey,
          paramValue: tempValue,
          paramValueType: tempValueType,
        });
      });
      items.value = params;
    };

    // 监听值变更
    watch(
      () => props.value,
      () => {
        curValue.value = props.value as string;
        formatParams((props.value as string) || '');
      },
      {
        immediate: true,
      },
    );

    // 计算参数字符串化后的数据
    const calcParamStr = () => {
      const params = items.value.map((item: IData) => {
        const type = item.paramType === 'DEFAULT' ? '' : `${item.paramType}.`;
        const key = item.paramKey ? `${item.paramKey}` : '';
        const value =
          item.paramValueType === 1 ? item.paramValue : `%${item.paramValue}%`;
        return `${type}${key}=${value}`;
      });
      return params.join('\n');
    };

    // 抛出值
    const emitFunc = debounce(() => {
      emit('change', curValue.value);
    }, 500);

    // 值类型改变
    const onValueChange = () => {
      // 将数组转为字符串
      curValue.value = calcParamStr();
      emitFunc();
    };

    // 删除
    const onDelete = (index: number) => {
      if (props.disabled || props.readonly) {
        return;
      }
      items.value.splice(index, 1);
      curValue.value = calcParamStr();
      emitFunc();
    };

    // 复制
    const onCopy = (index: number) => {
      if (props.disabled || props.readonly) {
        return;
      }
      const tempCopy = clone(items.value[index]);
      items.value.splice(index, 0, tempCopy);
      curValue.value = calcParamStr();
      emitFunc();
    };

    // 添加项
    const onAddItem = () => {
      if (props.disabled || props.readonly) {
        return;
      }
      items.value.push({
        paramType: 'DEFAULT',
        paramKey: '',
        paramValue: '',
        paramValueType: 1,
      });
      curValue.value = calcParamStr();
      emitFunc();
    };

    // 切换自定义
    const onSwitchCustom = (value: boolean) => {
      isCustom.value = value;
    };

    // 绘制选择模式参数列表
    const renderSelectList = () => {
      return items.value.map((item: IData, index: number) => {
        return (
          <div class={ns.e('item')}>
            <div class={ns.em('item', 'param-type')}>
              <el-select
                v-model={item.paramType}
                onChange={onValueChange}
                readonly={props.readonly}
                disabled={props.disabled}
              >
                {{
                  default: () => {
                    return paramType.map((type: IData) => {
                      return (
                        <el-option
                          key={type.value}
                          label={type.label}
                          value={type.value}
                        ></el-option>
                      );
                    });
                  },
                }}
              </el-select>
            </div>
            <div class={ns.em('item', 'param-key')}>
              <el-input
                v-model={item.paramKey}
                readonly={props.readonly}
                disabled={props.disabled}
                onInput={onValueChange}
              ></el-input>
            </div>
            <div class={ns.em('item', 'param-value')}>
              <el-input
                v-model={item.paramValue}
                readonly={props.readonly}
                disabled={props.disabled}
                onInput={onValueChange}
              ></el-input>
            </div>
            <div class={ns.em('item', 'param-value-type')}>
              <el-select
                v-model={item.paramValueType}
                onChange={onValueChange}
                disabled={props.disabled}
              >
                {{
                  default: () => {
                    return paramValueType.map((type: IData) => {
                      return (
                        <el-option
                          key={type.value}
                          label={type.label}
                          value={type.value}
                        ></el-option>
                      );
                    });
                  },
                }}
              </el-select>
            </div>
            <div
              class={[
                ns.em('item', 'remove'),
                ns.is('disabled', props.disabled || props.readonly),
              ]}
              title='删除'
              onClick={() => onDelete(index)}
            >
              <ion-icon name='close-outline'></ion-icon>
            </div>
            <div
              class={[
                ns.em('item', 'copy'),
                ns.is('disabled', props.disabled || props.readonly),
              ]}
              title='复制'
              onClick={() => onCopy(index)}
            >
              <ion-icon name='copy-outline'></ion-icon>
            </div>
          </div>
        );
      });
    };

    // 自定义值改变
    const onCustomChange = () => {
      emitFunc();
    };

    return {
      ns,
      c,
      isCustom,
      items,
      curValue,
      onValueChange,
      renderSelectList,
      onAddItem,
      onSwitchCustom,
      onCustomChange,
    };
  },
  render() {
    return (
      <div class={this.ns.b()}>
        {!this.isCustom ? (
          <div class={this.ns.e('select')}>
            <div class={this.ns.em('select', 'list')}>
              {this.renderSelectList()}
            </div>
            <div class={this.ns.em('select', 'use-custom')}>
              <div
                class={[this.ns.em('select', 'btn')]}
                onClick={() => this.onSwitchCustom(true)}
              >
                开启自定义
              </div>
              <ion-icon
                class={[
                  this.ns.em('select', 'add-icon'),
                  this.ns.is('disabled', this.disabled || this.readonly),
                ]}
                name='add-outline'
                onClick={this.onAddItem}
                title='新增'
              ></ion-icon>
            </div>
          </div>
        ) : (
          <div class={this.ns.e('custom')}>
            <div class={this.ns.em('custom', 'textarea')}>
              <el-input
                type='textarea'
                v-model={this.curValue}
                disabled={this.disabled}
                readonly={this.readonly}
                this
                rows='6'
                onInput={this.onCustomChange}
              ></el-input>
            </div>
            <div class={this.ns.em('custom', 'close-custom')}>
              <div
                class={this.ns.em('select', 'btn')}
                onClick={() => this.onSwitchCustom(false)}
              >
                关闭自定义
              </div>
            </div>
          </div>
        )}
      </div>
    );
  },
});
