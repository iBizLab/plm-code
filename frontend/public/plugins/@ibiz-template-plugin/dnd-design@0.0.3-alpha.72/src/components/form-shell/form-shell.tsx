/* eslint-disable @typescript-eslint/no-explicit-any */
import { PropType, defineComponent, ref, watch } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import {
  IDEEditForm,
  IDEFormDetail,
  IDEFormPage,
  IDEFormItem,
  IDEFormIFrame,
  IDEFormRawItem,
  ILayoutPos,
  ILayout,
  IDESearchForm,
  IDEFormGroupBase,
  IDEFormButtonList,
  IDEFormMDCtrl,
} from '@ibiz/model-core';
import './form-shell.scss';

export default defineComponent({
  name: 'IBizFormShell',
  props: {
    context: { type: Object as PropType<IContext>, required: true },
    data: {
      type: Object as PropType<IData>,
      required: true,
    },
    items: {
      type: Object as PropType<IData[]>,
      required: true,
    },
  },
  setup(props) {
    const ns = useNamespace('form-shell');
    const shellNS = useNamespace('light-theme-shell');

    /**
     * 表单模型
     */
    const modelData = ref<IDEEditForm | IDESearchForm>();

    /**
     * 转换树型数据
     *
     * @param {IData[]} originalTree
     * @param {(node: IData) => IData} transformFunc
     * @param {{
     *         originalChildrenName: string;
     *         currentChildrenName: string;
     *       }} opt
     * @return {*}  {IData[]}
     */
    const transformTree = (
      original: IData[],
      transformFunc: (node: IData, parentNode?: IData) => IDEFormDetail,
      parentNode?: IData,
    ): IDEFormDetail[] => {
      return original.map(item => {
        const children = item.psdeformdetails
          ? transformTree(item.psdeformdetails, transformFunc, item)
          : [];
        const detail = transformFunc(item, parentNode);
        if (children.length > 0) {
          (detail as any)[
            detail.detailType === 'TABPANEL'
              ? 'deformTabPages'
              : 'deformDetails'
          ] = children;
        }
        return detail;
      });
    };

    // 转换编辑器参数
    const transformEditorParams = (val?: string) => {
      if (!val) {
        return {};
      }
      const params = val.split('\n');
      const editorParams: IData = {};
      params.forEach(param => {
        const [key, value] = param.split('=');
        editorParams[key] = value;
      });
      return editorParams;
    };

    // 获取自定义编辑器参数
    const getCustomEditorParams = (item: IData) => {
      const type: string | undefined = item.editortype;
      const editorParams: IData = {};
      if (!type) {
        return editorParams;
      }
      if (['CODE', 'MARKDOWN'].includes(type)) {
        editorParams.customTheme = 'light';
      }
      return editorParams;
    };

    /**
     * 解析表单成员
     *
     * @param {IData[]} data
     * @return {*}  {IDEFormPage[]}
     */
    const parseFormDetail = (data: IData[]): IDEFormPage[] => {
      const transform = (item: IData, parent?: IData): IDEFormDetail => {
        let detail = {
          width: item.width,
          height: item.height,
          caption: item.caption,
          detailType: item.detailtype,
          id: item.psdeformdetailname,
          name: item.psdeformdetailname,
          appId: props.context.srfappid,
          codeName: item.psdeformdetailname,
          showCaption: item.showcaption !== 0,
          sysImage: {
            appId: props.context.srfappid,
            cssClass: item.pssysimagename,
          },
          detailStyle: item.detailstyle,
          layout: {
            appId: props.context.srfappid,
            layout:
              item.layoutmode ||
              parent?.layoutmode ||
              item.playoutmode ||
              'TABLE_24COL',
            // flex布局
            dir: item.flexdir,
            align: item.flexalign,
            valign: item.flexvalign,
          } as ILayout,
          layoutPos: {
            appId: props.context.srfappid,
            layout:
              item.layoutmode ||
              parent?.layoutmode ||
              item.playoutmode ||
              'TABLE_24COL',
            // 栅格布局
            colXS: item.col_xs || parent?.child_col_xs,
            colXSOffset: item.col_xs_os,
            colSM: item.col_sm || parent?.child_col_sm,
            colSMOffset: item.col_sm_os,
            colMD: item.col_md || parent?.child_col_md,
            colMDOffset: item.col_md_os,
            colLG: item.col_lg || parent?.child_col_lg,
            colLGOffset: item.col_lg_os,
            // flex布局
            basis: item.flexbasis,
            grow: item.flexgrow,
            shrink: item.flexshrink,
          } as ILayoutPos,
        } as IDEFormDetail;
        switch (detail.detailType) {
          case 'FORMITEM':
            detail = {
              ...detail,
              emptyCaption: item.emptycaption,
              labelPos: item.labelpos || 'LEFT',
              labelWidth: item.labelwidth,
              allowEmpty: item.allowempty !== 0,
              hidden: item.editortype === 'HIDDEN',
              valueFormat: item.valueformat,
              // enableCond: item.enablecond,
              enableItemPriv: item.enableitempriv,
              resetItemNames: item.resetitemname
                ? item.resetitemname.split(';')
                : undefined,
              editor: {
                appId: props.context.srfappid,
                editorType: item.editortype || 'TEXTBOX',
                placeHolder: item.placeholder,
                editorItems: item.valueitemname
                  ? item.valueitemname.split(';')
                  : undefined,
                editorHeight: item.ctrlheight,
                editorWidth: item.ctrlwidth,
                editorParams: {
                  enumOptions: [
                    {
                      appId: props.context.srfappid,
                      text: '选项1',
                      value: 'option1',
                    },
                    {
                      appId: props.context.srfappid,
                      text: '选项2',
                      value: 'option2',
                    },
                  ],
                  ...transformEditorParams(item.editorparams),
                  ...getCustomEditorParams(item),
                },
              },
            } as IDEFormItem;
            break;
          case 'TABPAGE':
          case 'TABPANEL':
          case 'FORMPAGE':
          case 'GROUPPANEL':
            detail = {
              ...detail,
              enableAnchor: item.enableanchor,
              captionItemName: item.valueitemname,
              titleBarCloseMode: item.titlebarclosemode,
            } as IDEFormGroupBase;
            break;
          case 'IFRAME':
            detail = {
              ...detail,
              iframeUrl: item.editorparams,
            } as IDEFormIFrame;
            break;
          case 'RAWITEM':
            detail = {
              ...detail,
              rawItem: {
                appId: props.context.srfappid,
                contentType: item.contenttype,
                caption: item.rawcontent || '',
                content: item.htmlcontent || '',
                sysImage: {
                  appId: props.context.srfappid,
                  cssClass: item.pssysimagename,
                },
              },
            } as IDEFormRawItem;
            break;
          case 'BUTTONLIST':
            detail = {
              ...detail,
              buttonListType: 'UIACTIONGROUP',
              actionGroupExtractMode: 'ITEM',
              uiactionGroup: {
                id: 'buttonList',
                appId: props.context.srfappid,
                uiactionGroupDetails: [
                  {
                    id: 'button1',
                    uiactionId: 'button1',
                    appId: props.context.srfappid,
                    caption: '按钮1',
                    showCaption: true,
                  },
                  {
                    id: 'button2',
                    uiactionId: 'button2',
                    appId: props.context.srfappid,
                    caption: '按钮2',
                    showCaption: true,
                  },
                ],
              },
            } as IDEFormButtonList;
            break;
          case 'MDCTRL':
            detail = {
              ...detail,
              contentType: item.mdctrltype,
            } as IDEFormMDCtrl;
            break;
          case 'FORMITEMEX':
            detail = {
              ...detail,
              detailType: 'FORMITEM',
              emptyCaption: item.emptycaption,
              labelPos: item.labelpos || 'LEFT',
              labelWidth: item.labelwidth,
              allowEmpty: item.allowempty !== 0,
              hidden: item.editortype === 'HIDDEN',
              // enableCond: item.enablecond,
              enableItemPriv: item.enableitempriv,
              compositeItem: true,
              editor: {
                id: detail.id,
                appId: props.context.srfappid,
                editorType: item.editortype || 'TEXTBOX',
                editorHeight: item.ctrlheight,
                editorWidth: item.ctrlwidth,
                editorParams: {
                  enumOptions: [
                    {
                      appId: props.context.srfappid,
                      text: '选项1',
                      value: 'option1',
                    },
                    {
                      appId: props.context.srfappid,
                      text: '选项2',
                      value: 'option2',
                    },
                  ],
                  ...transformEditorParams(item.editorparams),
                  ...getCustomEditorParams(item),
                },
                editorItems:
                  item.psdeformdetails?.map((editorItem: IData) => {
                    return {
                      appId: props.context.srfappid,
                      id: editorItem.psdeformdetailname,
                    };
                  }) || [],
              },
            } as IDEFormMDCtrl;
            break;
          default:
            break;
        }
        return detail;
      };
      return transformTree(data, transform);
    };

    const init = async (): Promise<void> => {
      const data = props.data;
      if (!data) {
        return;
      }
      const model: IDEEditForm | IDESearchForm = {
        controlType: data.formtype,
        appId: props.context.srfappid,
        codeName: data.codename,
        autoSaveMode: 0,
        navBarPos: data.navbarpos,
        navBarStyle: data.navbarstyle,
        navBarWidth: data.navbarwidth || 0,
        navbarHeight: data.navbarheight,
        navBarSysCss: {
          appId: props.context.srfappid,
          cssName: data.navbarpssyscssname,
        },
        enableAutoSave: false,
        enableCustomized: false,
        infoFormMode: data.infoformflag,
        showFormNavBar: data.formnavbar,
        formFuncMode: data.funcmode,
        formStyle: data.formstyle,
        formWidth: data.formwidth,
        noTabHeader: data.showtabheader === 0,
        tabHeaderPos: data.tabheaderpos,
        logicName: data.psdeformname,
        deformPages: parseFormDetail(props.items),
        sysCss: {
          appId: props.context.srfappid,
          cssName: shellNS.b(),
        },
        searchButtonStyle:
          data.formtype === 'EDITFORM' ? undefined : 'SEARCHONLY',
      } as IDEEditForm;
      modelData.value = model;
    };

    watch(
      () => props.items,
      () => {
        init();
      },
      {
        immediate: true,
        deep: true,
      },
    );

    return {
      ns,
      shellNS,
      modelData,
    };
  },
  render() {
    if (this.modelData) {
      return (
        <div class={this.ns.b()}>
          {this.modelData.controlType === 'EDITFORM' ? (
            <iBizEditFormControl
              data={{}}
              isSimple={true}
              class={[this.ns.m('light')]}
              modelData={this.modelData}
              context={this.context}
            ></iBizEditFormControl>
          ) : (
            <iBizSearchFormControl
              data={{}}
              isSimple={true}
              class={[this.ns.m('light')]}
              modelData={this.modelData}
              context={this.context}
            ></iBizSearchFormControl>
          )}
        </div>
      );
    }
    return null;
  },
});
