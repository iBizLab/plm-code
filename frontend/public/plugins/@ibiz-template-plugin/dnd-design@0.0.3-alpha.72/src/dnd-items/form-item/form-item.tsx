/* eslint-disable eqeqeq */
import { useNamespace } from '@ibiz-template/vue3-util';
import { defineComponent } from 'vue';
import { IDataEntity } from '@ibiz-template/runtime';
import dayjs from 'dayjs';
import { DndItemController } from '../../controller';
import './form-item.scss';

export default defineComponent({
  name: 'IBizDndDesignFormItem',
  props: {
    controller: {
      type: DndItemController,
      required: true,
    },
    formItemLabelWidth: {
      type: Number,
    },
  },
  setup(props) {
    const ns = useNamespace('dnd-design-form-item');

    const getContentStyle = () => {
      const data = props.controller.data;
      if (data && data.rawcssstyle) {
        const res = data.rawcssstyle.split('\n');
        const target: string[] = [];
        for (let i = 0; i < res.length; i++) {
          target.push(...res[i].split(';').filter((value: string) => value));
        }
        return target
          .filter((value: string) => {
            return value.split(':').length === 2;
          })
          .join(';');
      }
    };

    const renderDefaultField = () => {
      const data = props.controller.data;
      return <el-input placeholder={data.srftext} disabled />;
    };

    const renderDesignItem = () => {
      const data = props.controller.data;
      const contentStyle = getContentStyle();
      const text = `${data.srftext}`;
      const curDate = new Date();
      if (data) {
        switch (data.editortype) {
          case 'HIDDEN':
            return (
              <div style='padding-left: 10px;' class='design-item-hidden'>
                隐藏表单项
              </div>
            );
          case 'SPAN':
            return (
              <span
                style={`padding-left: 10px;${contentStyle}`}
                class='design-design-editor'
              >
                {text}
              </span>
            );
          case 'RADIOBUTTONLIST':
            return (
              <el-radio-group model-value='' disabled>
                <el-radio label='1'>选项一</el-radio>
                <el-radio label='2'>选项二</el-radio>
                <el-radio label='3'>选项三</el-radio>
              </el-radio-group>
            );
          case 'ADDRESSPICKUP':
          case 'ADDRESSPICKUP_AC':
            return (
              <el-select
                mode='tags'
                style='width: 100%'
                placeholder={text}
                disabled
              >
                <el-option value='1'>选项一</el-option>
                <el-option value='2'>选项二</el-option>
                <el-option value='3'>选项三</el-option>
              </el-select>
            );
          case 'TEXTAREA':
            return (
              <el-input
                placeholder={text}
                style={data.ctrlheight ? `height: ${data.ctrlheight}px;` : ''}
                class={ns.e('textarea')}
                type='textarea'
                rows={1}
                disabled
              />
            );
          case 'TEXTAREA_10':
            return (
              <el-input placeholder={text} rows={10} type='textarea' disabled />
            );
          case 'PASSWORD':
            return <el-input placeholder={text} disabled />;
          case 'DATEPICKEREX':
            return (
              <el-date-picker
                class={ns.e('datepicker')}
                model-value={dayjs(curDate).format('YYYY-MM-DD HH:mm:ss')}
                format='YYYY-MM-DD HH:mm:ss'
                disabled
              />
            );
          case 'DATEPICKEREX_MINUTE':
            return (
              <el-date-picker
                class={ns.e('datepicker')}
                model-value={dayjs(curDate).format('YYYY-MM-DD HH:mm')}
                format='YYYY-MM-DD HH:mm'
                disabled
              />
            );
          case 'DATEPICKEREX_SECOND':
            return (
              <el-date-picker
                class={ns.e('datepicker')}
                model-value={dayjs(curDate).format('YYYY-MM-DD HH:mm:ss')}
                format='YYYY-MM-DD HH:mm:ss'
                disabled
              />
            );
          case 'DATEPICKEREX_NODAY':
            return (
              <el-date-picker
                class={ns.e('datepicker')}
                model-value={curDate}
                format='HH:mm:ss'
                disabled
              />
            );
          case 'DATEPICKEREX_NODAY_NOSECOND':
            return (
              <el-date-picker
                class={ns.e('datepicker')}
                model-value={curDate}
                format='HH:mm'
                disabled
              />
            );
          case 'DATEPICKEREX_NOTIME':
            return (
              <el-date-picker
                class={ns.e('datepicker')}
                model-value={dayjs(curDate).format('YYYY-MM-DD')}
                format='YYYY-MM-DD'
                disabled
              />
            );
          case 'DATEPICKEREX_HOUR':
            return (
              <el-date-picker
                class={ns.e('datepicker')}
                model-value={dayjs(curDate).format('YYYY-MM-DD HH')}
                format='YYYY-MM-DD HH'
                disabled
              />
            );
          case 'DATEPICKER':
            return (
              <el-date-picker
                class={ns.e('datepicker')}
                model-value={dayjs(curDate).format('YYYY-MM-DD HH:mm:ss')}
                format='YYYY-MM-DD HH:mm:ss'
                disabled
              />
            );
          case 'TEXTBOX':
            return (
              <el-input style={contentStyle} placeholder={text} disabled />
            );
          case 'FILEUPLOADER':
            return (
              <el-button disabled class={ns.e('fileuploader')}>
                <ion-icon name='cloud-upload-outline'></ion-icon>
                {text}
              </el-button>
            );
          case 'AC':
          case 'AC_NOBUTTON':
          case 'AC_FS_NOBUTTON':
          case 'AC_FS':
          case 'PICKEREX_LINKONLY':
          case 'PICKER':
          case 'PICKUPVIEW':
          case 'PICKEREX_LINK':
          case 'PICKEREX_NOAC_LINK':
          case 'PICKEREX_NOAC':
          case 'PICKEREX_NOBUTTON':
          case 'PICKEREX_TRIGGER_LINK':
          case 'PICKEREX_TRIGGER':
          case 'DROPDOWNLIST':
            return (
              <el-select model-value='选项一' style='width: 100%' disabled>
                <el-option value='选项一'>选项一</el-option>
                <el-option value='选项二'>选项二</el-option>
                <el-option value='选项三'>选项三</el-option>
              </el-select>
            );
          case 'MDROPDOWNLIST':
            return (
              <el-select model-value='选项一' style='width: 100%' disabled>
                <el-option value='选项一'>选项一</el-option>
                <el-option value='选项二'>选项二</el-option>
                <el-option value='选项三'>选项三</el-option>
              </el-select>
            );
          case 'DROPDOWNLIST_100':
            return (
              <el-select model-value='选项一' style='width: 100px' disabled>
                <el-option value='选项一'>选项一</el-option>
                <el-option value='选项二'>选项二</el-option>
                <el-option value='选项三'>选项三</el-option>
              </el-select>
            );
          case 'CHECKBOX':
            return <el-checkbox disabled>选项</el-checkbox>;
          case 'CHECKBOXLIST':
            return (
              <el-checkbox-group disabled>
                <el-checkbox disabled>选项一</el-checkbox>;
                <el-checkbox disabled>选项二</el-checkbox>;
              </el-checkbox-group>
            );
          case 'NUMBER':
            return (
              <el-input-number
                class={ns.e('number')}
                style='width: 100%'
                disabled
              />
            );
          case 'USERCONTROL':
            return <span>用户自定义</span>;
          case 'RATING':
            return (
              <el-rate text-color='#ff9900' model-value={4} disabled={true} />
            );
          case 'SLIDER':
            return (
              <el-slider
                model-value={30}
                show-input={true}
                class={ns.e('slider')}
              />
            );
          case 'DATERANGE':
            return (
              <el-date-picker
                model-value={[curDate, curDate]}
                type='datetimerange'
                range-separator='至'
                start-placeholder='开始日期'
                end-placeholder='结束日期'
                format='YYYY-MM-DD HH:mm:ss'
                disabled={true}
                class={ns.e('daterange')}
              />
            );
          case 'ARRAY':
            return (
              <div class={ns.e('panel-array-input')}>
                <el-input placeholder={text} disabled />
                <el-button
                  type='primary'
                  circle
                  class={ns.e('panel-array-input-add-button')}
                >
                  <ion-icon name='add-outline'></ion-icon>
                </el-button>
                <el-button
                  type='danger'
                  circle
                  class={ns.e('panel-array-input-remove-button')}
                >
                  <ion-icon name='remove-outline'></ion-icon>
                </el-button>
              </div>
            );
          case 'MAPPICKER':
            return (
              <el-cascader
                class={ns.e('mappicker')}
                options={[
                  {
                    value: '省',
                    label: '省',
                    children: [
                      {
                        value: '市',
                        label: '市',
                        children: [
                          {
                            value: '区',
                            label: '区',
                          },
                        ],
                      },
                    ],
                  },
                ]}
                model-value={['省', '市', '区']}
                disabled
              />
            );
          case 'SWITCH':
            return <el-switch disabled={true} />;
          default:
            return renderDefaultField();
        }
      }
      return renderDefaultField();
    };

    const getFormCtrlStyle = (tag: IDataEntity, labelPos: string) => {
      let style: string = '';
      if (
        Object.is(labelPos, 'none') ||
        Object.is(labelPos, 'top') ||
        Object.is(labelPos, 'bottom') ||
        tag.showcaption === '0'
      ) {
        if (tag.ctrlwidth) {
          style += `width: ${tag.ctrlwidth}px;`;
        } else {
          style += `width: 100%;`;
        }
      } else if (tag.ctrlwidth) {
        style += `width: ${tag.ctrlwidth}px;`;
      } else {
        style += `width: calc(100% - ${
          tag.labelwidth || props.formItemLabelWidth || 130
        }px);`;
      }
      if (tag.ctrlheight) {
        style += `height: ${tag.ctrlheight}px;`;
      } else {
        style += `height: 100%;`;
      }
      return style;
    };

    const renderContent = () => {
      const data = props.controller.data;
      const caption = props.controller.getItemCaption();
      // 当前项数据
      const tag: IDataEntity = data;
      // 标签位置
      const labelPos: string = tag.labelpos
        ? tag.labelpos.toLowerCase()
        : 'left';
      // 标签样式
      const labelStyle: string =
        Object.is(labelPos, 'top') || Object.is(labelPos, 'bottom')
          ? ''
          : `width: ${tag.labelwidth || props.formItemLabelWidth || 130}px;`;
      // 编辑器样式
      const ctrlStyle: string = getFormCtrlStyle(tag, labelPos);

      if (tag.itemtype === 'FIELD') {
        return (
          <div class={`design-form-item ${labelPos || 'left'}`}>
            <div
              class={ns.e('container-content')}
              style={{ width: '100%', height: '100%' }}
            >
              {renderDesignItem()}
            </div>
          </div>
        );
      }

      return (
        <div
          class={`${ns.e('item-content')} ${ns.em(
            'item-content',
            labelPos || 'left',
          )}`}
        >
          {tag.showcaption == '0' ? null : (
            <div class={ns.e('label-content')} style={labelStyle}>
              {tag.emptycaption == '1' ? null : (
                <label class={ns.e('label')}>
                  {Object.is(labelPos, 'right') ? '：' : ''}
                  {caption || ''}
                  {!Object.is(labelPos, 'right') ? '：' : ''}
                </label>
              )}
            </div>
          )}
          <div class={ns.e('container-content')} style={ctrlStyle}>
            {renderDesignItem()}
          </div>
        </div>
      );
    };

    return { ns, renderDesignItem, renderContent };
  },
  render() {
    return (
      <div class={this.ns.b()}>
        <div class={this.ns.e('wrapper')}></div>
        {this.renderContent()}
      </div>
    );
  },
});
