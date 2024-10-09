import { Ref, VNode, defineComponent, ref, watch } from 'vue';
import {
  useNamespace,
  getInputProps,
  getEditorEmits,
} from '@ibiz-template/vue3-util';
import { IDEFormItem } from '@ibiz/model-core';
import { debounce } from 'lodash-es';
import { createUUID } from 'qx-util';
import { EditorParamsController } from './editor-params.controller';
import { resource } from '../../global';
import './editor-params-custom.scss';

interface DynamicParam {
  id: string;
  key: string;
  value: string;
  type: 'param' | 'srfnavparam' | 'srfnavctx';
}

export default defineComponent({
  name: 'IBizEditorParmas',
  props: getInputProps<EditorParamsController>(),
  emits: getEditorEmits(),
  setup(props, { emit }) {
    const c = props.controller;
    const ns = useNamespace('editor-params-custom');

    const isCustom = ref(false);

    const changeIscustom = () => {
      isCustom.value = !isCustom.value;
    };

    /**
     * 编辑器类型
     *
     * @author zhanghengfeng
     * @date 2023-02-16 15:02:14
     * @type {(string | undefined)}
     */
    let editorType: string | undefined = props.data?.editortype;

    /**
     * 编辑器参数
     *
     * @author zhanghengfeng
     * @date 2023-02-16 15:02:28
     * @type {(string | undefined)}
     */
    const editorParams: Ref<string | undefined> = ref(
      props.value as string | undefined,
    );

    /**
     * 表单参数数据
     *
     * @author zhanghengfeng
     * @date 2023-02-16 15:02:18
     * @type {Record<string, unknown>}
     */
    const formData: Ref<Record<string, unknown>> = ref({});

    /**
     * 类型映射
     *
     * @author zhanghengfeng
     * @date 2023-02-16 15:02:00
     */
    const typeMap = {
      param: '',
      srfnavparam: 'SRFNAVPARAM.',
      srfnavctx: 'SRFNAVCTX.',
    };

    /**
     * 表单参数项集合
     *
     * @author zhanghengfeng
     * @date 2023-02-16 15:02:40
     * @type {IPSDEFormItem[]}
     */
    const formItems: Ref<IDEFormItem[]> = ref([]);

    /**
     * 动态参数项集合
     *
     * @author zhanghengfeng
     * @date 2023-02-17 10:02:05
     * @type {DynamicParam[]}
     */
    const dynamicItems: Ref<DynamicParam[]> = ref([]);

    /**
     * 转换编辑器参数
     *
     * @author zhanghengfeng
     * @date 2023-02-17 17:02:23
     * @param {string} editorParamsStr
     * @return {*}
     */
    const transformEditorParams = (editorParamsStr: string) => {
      if (!editorParamsStr) {
        return;
      }
      const items = editorParamsStr.split('\n');
      const dynamicParamList: DynamicParam[] = [];
      items.forEach(item => {
        if (!item) {
          return;
        }
        const index = item.indexOf('=');
        if (index === -1) {
          return;
        }
        const key = item.slice(0, index);
        const value = item.slice(index + 1);
        if (!key) {
          return;
        }
        if (Object.prototype.hasOwnProperty.call(formData.value, key)) {
          if (!value) {
            formData.value[key] = undefined;
          } else {
            try {
              formData.value[key] = JSON.parse(value);
            } catch (error: unknown) {
              formData.value[key] = value;
            }
          }
        } else {
          let tempKey = key;
          let type: DynamicParam['type'] = 'param';
          if (key.startsWith('SRFNAVPARAM.')) {
            tempKey = key.slice(key.indexOf('.') + 1);
            type = 'srfnavparam';
          } else if (key.startsWith('SRFNAVCTX.')) {
            tempKey = key.slice(key.indexOf('.') + 1);
            type = 'srfnavctx';
          }

          const obj: DynamicParam = {
            id: createUUID(),
            key: tempKey,
            value,
            type,
          };
          dynamicParamList.push(obj);
        }
      });
      dynamicItems.value = dynamicParamList;
    };

    const initFormItems = (_editorType: string) => {
      return false;
    };

    /**
     * 监听编辑器类型变化
     *
     * @author zhanghengfeng
     * @date 2023-02-16 21:02:51
     * @param {string} newEditorType
     * @return {*}
     */
    const onEditorTypeChange = (editorTypeStr: string) => {
      if (!editorTypeStr) {
        formItems.value = [];
        formData.value = {};
      } else if (editorTypeStr !== editorType) {
        const result = initFormItems(editorTypeStr);
        if (!result) {
          formItems.value = [];
          formData.value = {};
        }
      }
    };

    /**
     * 监听参数数据变化
     *
     * @author zhanghengfeng
     * @date 2023-02-16 15:02:52
     */
    const onParamDataChange = () => {
      const formParamList: string[] = [];
      const dynamicParamList: string[] = [];
      // formItems.forEach(item => {
      //   const editor = item.getPSEditor();
      //   if (!editor) {
      //     return;
      //   }
      //   const key = editor.name;
      //   const value = isNil(this.formData[key]) ? '' : this.formData[key];
      //   if (value !== 0 && value !== false && !value) {
      //     return;
      //   }
      //   formParamList.push(
      //     `${key}=${typeof value === 'object' ? JSON.stringify(value) : value}`,
      //   );
      // });
      dynamicItems.value.forEach(item => {
        if (!item.key) {
          return;
        }
        dynamicParamList.push(`${typeMap[item.type]}${item.key}=${item.value}`);
      });
      const formParams = formParamList.join('\n');
      const dynamicParams = dynamicParamList.join('\n');
      if (formParams) {
        editorParams.value = `${formParams}${
          dynamicParams ? `\n${dynamicParams}` : ''
        }`;
        emit('change', editorParams.value || null);
      } else {
        editorParams.value = dynamicParams;
        emit('change', editorParams.value || null);
      }
    };

    if (editorParams.value) {
      transformEditorParams(editorParams.value);
    }

    watch(
      () => props.value,
      (_newVal, _oldVal) => {
        if (editorParams.value) {
          transformEditorParams(editorParams.value);
        }
      },
    );

    watch(
      () => props.data,
      (newVal, _oldVal) => {
        const editorTypeStr = newVal?.editortype;
        const editorParamsStr = props.value ? props.value.toString() : '';
        // if (!this.editorIsLoaded) {
        //   this.editorType = editorTypeStr;
        //   this.editorParams = editorParamsStr;
        //   return;
        // }

        // onEditorTypeChange(editorTypeStr);

        if (!editorParamsStr) {
          // formItems.value.forEach(item => {
          //   const editor = item.getPSEditor();
          //   if (editor) {
          //     formData.value[editor.name] = undefined;
          //   }
          // });
          dynamicItems.value = [];
        } else if (
          editorParamsStr !== editorParams.value ||
          editorTypeStr !== editorType
        ) {
          // formItems.value.forEach(item => {
          //   const editor = item.getPSEditor();
          //   if (editor) {
          //     formData.value[editor.name] = undefined;
          //   }
          // });
          transformEditorParams(editorParamsStr);
        }
        editorType = editorTypeStr;
        editorParams.value = editorParamsStr;
        onParamDataChange();
      },
      { immediate: true },
    );

    /**
     * 添加动态参数
     *
     * @author zhanghengfeng
     * @date 2023-02-16 15:02:01
     * @param {EditorDynamicParam['type']} type
     */
    const addDynamicParam = (type: DynamicParam['type']) => {
      dynamicItems.value.push({
        id: createUUID(),
        key: '',
        value: '',
        type,
      });
      onParamDataChange();
    };

    /**
     * 删除动态参数
     *
     * @author zhanghengfeng
     * @date 2023-02-16 15:02:30
     * @param {number} index
     */
    const deleteDynamicParam = (index: number) => {
      dynamicItems.value.splice(index, 1);
      onParamDataChange();
    };

    /**
     * 监听动态参数变化
     *
     * @author zhanghengfeng
     * @date 2023-02-17 11:02:47
     * @param {InputEvent} e
     * @param {DynamicParam} item
     * @param {('key' | 'value')} key
     */
    const onDynamicParamChange = (
      value: string,
      item: DynamicParam,
      key: 'key' | 'value',
    ) => {
      item[key] = value;
      const fn = debounce(() => {
        onParamDataChange();
      }, 0);
      fn();
    };

    /**
     * 监听自定义参数变化
     *
     * @author zhanghengfeng
     * @date 2023-02-17 11:02:54
     * @param {InputEvent} e
     */
    const onCustomParamChange = (valueStr: string) => {
      const fn = debounce(() => {
        emit('change', valueStr);
      }, 0);
      fn();
    };

    return {
      ns,
      c,
      isCustom,
      changeIscustom,
      dynamicItems,
      formItems,
      addDynamicParam,
      editorParams,
      typeMap,
      formData,
      onEditorTypeChange,
      transformEditorParams,
      editorType,
      onCustomParamChange,
      onDynamicParamChange,
      deleteDynamicParam,
    };
  },
  render() {
    return (
      <div class={this.ns.b()}>
        {this.isCustom ? (
          <el-input
            class={[
              this.ns.e('param-textarea'),
              this.ns.is('readonly', this.readonly),
            ]}
            type='textarea'
            rows={6}
            v-model={this.editorParams}
            readonly={this.readonly}
            disabled={this.readonly}
            onInput={(value: string) => this.onCustomParamChange(value)}
          />
        ) : (
          <div class={this.ns.e('param-container')}>
            <div class={this.ns.e('param-list-from')}>
              {/* {this.formItems.map(item => (
                <div class={this.ns.e('param-item-from')}>
                  <div
                    class={this.ns.e('param-item-from', 'caption')}
                    style={{ width: `${item.labelWidth || 90}px` }}
                    title={item.caption}
                  >
                    {item.caption}
                  </div>
                  <div class='param-item__editor--form'>
                    <app-default-editor
                      value={this.formData[item.getPSEditor()!.name]}
                      editorInstance={item.getPSEditor()}
                      containerCtrl={this.formControl}
                      parentItem={item}
                      context={Util.deepCopy(this.context)}
                      viewparams={Util.deepCopy(this.viewparams)}
                      contextData={this.formData}
                      disabled={this.disabled}
                      service={this.service}
                      valueFormat={item.valueFormat}
                      isDebounce={this.isDebounce}
                      on-change={(data: Record<string, unknown>) => {
                        this.formData[item.getPSEditor()!.name] = data.value;
                        this.onParamDataChange();
                      }}
                    />
                  </div>
                </div>
              ))} */}
            </div>
            <div class={this.ns.e('param-list-dynamic')}>
              {this.dynamicItems.map((item, index) => (
                <div class={this.ns.e('param-item-dynamic')} key={item.id}>
                  <ion-icon
                    src={resource.dir(`./assets/svg/${item.type}.svg`)}
                    class={this.ns.em('param-item-dynamic', 'icon')}
                  ></ion-icon>
                  {this.readonly
                    ? [
                        <div
                          class={[
                            this.ns.em('param-item-dynamic', 'key'),
                            this.ns.is('readonly', this.readonly),
                          ]}
                        >
                          {item.key}
                        </div>,
                        <div
                          class={[
                            this.ns.em('param-item-dynamic', 'value'),
                            this.ns.is('readonly', this.readonly),
                          ]}
                        >
                          {item.value}
                        </div>,
                      ]
                    : [
                        <el-input
                          class={this.ns.em('param-item-dynamic', 'key')}
                          v-model={item.key}
                          onChange={(value: string) =>
                            this.onDynamicParamChange(value, item, 'key')
                          }
                        />,
                        <el-input
                          class={this.ns.em('param-item-dynamic', 'value')}
                          v-model={item.value}
                          onChange={(value: string) =>
                            this.onDynamicParamChange(value, item, 'value')
                          }
                        />,
                        <ion-icon
                          name='close-outline'
                          class={this.ns.em('param-item-dynamic', 'delete')}
                          onClick={() => this.deleteDynamicParam(index)}
                        ></ion-icon>,
                      ]}
                </div>
              ))}
            </div>
          </div>
        )}
        <div class={this.ns.e('param-custom-button')}>
          <el-button size='small' onClick={() => this.changeIscustom()}>{`${
            this.isCustom ? '关闭' : '开启'
          }自定义`}</el-button>
          {this.readonly ? null : (
            <el-dropdown
              trigger='click'
              size='small'
              onCommand={this.addDynamicParam}
            >
              {{
                default: (): VNode => (
                  <el-button size='small'>
                    <ion-icon name='add-outline'></ion-icon>
                  </el-button>
                ),
                dropdown: (): VNode => (
                  <el-dropdown-menu>
                    <el-dropdown-item command='param'>参数</el-dropdown-item>
                    <el-dropdown-item command='srfnavparam'>
                      视图参数
                    </el-dropdown-item>
                    <el-dropdown-item command='srfnavctx'>
                      视图上下文
                    </el-dropdown-item>
                  </el-dropdown-menu>
                ),
              }}
            </el-dropdown>
          )}
        </div>
      </div>
    );
  },
});
