export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  openMode: 'POPUPMODAL',
  deviewCodeName: 'product_re_space_choose_option_view',
  deviewId: '124b1f5b7254e637b7460f2d61ba392f',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.SPACE',
  },
  caption: '关联空间',
  codeName: 'space_product_re_space_choose_option_view',
  height: 200,
  appDataEntityId: 'plmweb.space',
  appViewNavParams: [
    {
      key: 'principal_type',
      value: 'principal_type',
      id: 'principal_type',
    },
    {
      key: 'target_type',
      value: 'target_type',
      id: 'target_type',
    },
    {
      key: 'principal_id',
      value: 'principal_id',
      id: 'principal_id',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    viewProxyMode: true,
    layoutMode: 'FLEX',
    layout: {
      layout: 'FLEX',
    },
    rootPanelItems: [
      {
        actionGroupExtractMode: 'ITEM',
        panelItems: [
          {
            actionGroupExtractMode: 'ITEM',
            panelItems: [
              {
                actionGroupExtractMode: 'ITEM',
                panelItems: [
                  {
                    caption: '页面标题',
                    itemStyle: 'DEFAULT',
                    itemType: 'CTRLPOS',
                    layoutPos: {
                      shrink: 1,
                      layout: 'FLEX',
                    },
                    showCaption: true,
                    id: 'captionbar',
                  },
                ],
                layout: {
                  align: 'center',
                  layout: 'FLEX',
                },
                dataRegionType: 'INHERIT',
                caption: '容器',
                itemStyle: 'DEFAULT',
                itemType: 'CONTAINER',
                layoutPos: {
                  shrink: 1,
                  heightMode: 'FULL',
                  layout: 'FLEX',
                },
                id: 'view_captionbar',
              },
            ],
            layout: {
              layout: 'FLEX',
            },
            dataRegionType: 'INHERIT',
            caption: '容器',
            itemStyle: 'DEFAULT',
            itemType: 'CONTAINER',
            layoutPos: {
              shrink: 1,
              heightMode: 'FULL',
              layout: 'FLEX',
            },
            id: 'view_header_left',
          },
          {
            actionGroupExtractMode: 'ITEM',
            panelItems: [
              {
                actionGroupExtractMode: 'ITEM',
                panelItems: [
                  {
                    caption: '工具栏',
                    itemStyle: 'DEFAULT',
                    itemType: 'CTRLPOS',
                    layoutPos: {
                      shrink: 1,
                      layout: 'FLEX',
                    },
                    showCaption: true,
                    id: 'toolbar',
                  },
                ],
                layout: {
                  align: 'center',
                  layout: 'FLEX',
                },
                dataRegionType: 'INHERIT',
                caption: '容器',
                itemStyle: 'DEFAULT',
                itemType: 'CONTAINER',
                layoutPos: {
                  shrink: 1,
                  heightMode: 'FULL',
                  layout: 'FLEX',
                },
                id: 'view_toolbar',
              },
            ],
            layout: {
              layout: 'FLEX',
            },
            dataRegionType: 'INHERIT',
            caption: '容器',
            itemStyle: 'DEFAULT',
            itemType: 'CONTAINER',
            layoutPos: {
              shrink: 1,
              heightMode: 'FULL',
              layout: 'FLEX',
            },
            id: 'view_header_right',
          },
        ],
        predefinedType: 'VIEWHEADER',
        layout: {
          align: 'space-between',
          dir: 'row',
          layout: 'FLEX',
          valign: 'center',
        },
        dataRegionType: 'INHERIT',
        caption: '容器',
        itemStyle: 'DEFAULT',
        itemType: 'CONTAINER',
        layoutPos: {
          shrink: 0,
          layout: 'FLEX',
        },
        id: 'view_header',
      },
      {
        actionGroupExtractMode: 'ITEM',
        panelItems: [
          {
            caption: '表单',
            itemStyle: 'DEFAULT',
            itemType: 'CTRLPOS',
            layoutPos: {
              shrink: 1,
              layout: 'FLEX',
            },
            showCaption: true,
            id: 'form',
          },
        ],
        predefinedType: 'VIEWCONTENT',
        layout: {
          layout: 'FLEX',
        },
        dataRegionType: 'INHERIT',
        caption: '容器',
        itemStyle: 'DEFAULT',
        itemType: 'CONTAINER',
        layoutPos: {
          grow: 1,
          shrink: 1,
          layout: 'FLEX',
        },
        id: 'view_content',
      },
      {
        actionGroupExtractMode: 'ITEM',
        panelItems: [
          {
            actionType: 'UIACTION',
            buttonStyle: 'PRIMARY',
            buttonType: 'PANELBUTTON',
            uiactionId: 'ok',
            renderMode: 'BUTTON',
            tooltip: '确定',
            caption: '确定',
            itemStyle: 'PRIMARY',
            itemType: 'BUTTON',
            layoutPos: {
              shrink: 1,
              layout: 'FLEX',
            },
            showCaption: true,
            id: 'button_okaction',
          },
          {
            actionType: 'UIACTION',
            buttonStyle: 'INFO',
            buttonType: 'PANELBUTTON',
            uiactionId: 'cancel',
            renderMode: 'BUTTON',
            tooltip: '取消',
            caption: '取消',
            itemStyle: 'INFO',
            itemType: 'BUTTON',
            layoutPos: {
              shrink: 1,
              layout: 'FLEX',
            },
            showCaption: true,
            id: 'button_cancelaction',
          },
        ],
        layout: {
          dir: 'row-reverse',
          layout: 'FLEX',
          valign: 'center',
        },
        dataRegionType: 'INHERIT',
        caption: '容器',
        itemStyle: 'DEFAULT',
        itemType: 'CONTAINER',
        layoutPos: {
          shrink: 0,
          layout: 'FLEX',
        },
        id: 'view_footer',
      },
    ],
    layoutPanel: true,
    appViewEngines: [
      {
        engineCat: 'VIEW',
        engineType: 'OptionView',
        id: 'engine',
      },
    ],
    controls: [
      {
        createControlAction: {
          appDEMethodId: 'nothing',
          appDataEntityId: 'plmweb.space',
          id: 'create',
        },
        getDraftFromControlAction: {
          appDataEntityId: 'plmweb.space',
          id: 'loaddraftfrom',
        },
        getDraftControlAction: {
          appDEMethodId: 'get_draft',
          appDataEntityId: 'plmweb.space',
          id: 'loaddraft',
        },
        getControlAction: {
          appDEMethodId: 'nothing',
          appDataEntityId: 'plmweb.space',
          id: 'load',
        },
        removeControlAction: {
          appDEMethodId: 'remove',
          appDataEntityId: 'plmweb.space',
          id: 'remove',
        },
        updateControlAction: {
          appDEMethodId: 'nothing',
          appDataEntityId: 'plmweb.space',
          id: 'update',
        },
        deformPages: [
          {
            layout: {
              columnCount: 24,
              layout: 'TABLE_24COL',
            },
            deformDetails: [
              {
                dataType: 25,
                enableCond: 3,
                labelPos: 'TOP',
                labelWidth: 130,
                noPrivDisplayMode: 1,
                appDEFieldId: 'name',
                editor: {
                  singleSelect: true,
                  handlerType: 'PickupText',
                  appDEACModeId: 'default',
                  appDEDataSetId: 'fetch_no_re_space',
                  appDataEntityId: 'plmweb.space',
                  enableAC: true,
                  forceSelection: true,
                  showTrigger: true,
                  valueItemName: 'space_id',
                  editorParams: {
                    'SRFNAVPARAM.principal_type': '%principal_type%',
                    'SRFNAVPARAM.target_type': '%target_type%',
                    'SRFNAVCTX.principal_type': '%principal_type%',
                    AC: 'TRUE',
                    'SRFNAVPARAM.principal_id': '%principal_id%',
                    TRIGGER: 'TRUE',
                    PICKUPVIEW: 'FALSE',
                    'SRFNAVCTX.target_type': '%target_type%',
                  },
                  editorType: 'PICKEREX_TRIGGER',
                  editorItems: [
                    {
                      id: 'space_id',
                    },
                  ],
                  placeHolder: '选择关联页面，点击确定按钮保存',
                  valueType: 'SIMPLE',
                  editable: true,
                  navigateContexts: [
                    {
                      key: 'PRINCIPAL_TYPE',
                      value: 'principal_type',
                      name: 'PRINCIPAL_TYPE',
                      id: 'principal_type',
                    },
                    {
                      key: 'TARGET_TYPE',
                      value: 'target_type',
                      name: 'TARGET_TYPE',
                      id: 'target_type',
                    },
                  ],
                  navigateParams: [
                    {
                      key: 'principal_type',
                      value: 'principal_type',
                      id: 'principal_type',
                    },
                    {
                      key: 'target_type',
                      value: 'target_type',
                      id: 'target_type',
                    },
                    {
                      key: 'principal_id',
                      value: 'principal_id',
                      id: 'principal_id',
                    },
                  ],
                  id: 'name',
                },
                capLanguageRes: {
                  lanResTag: 'DEF.LNAME.NAME',
                },
                caption: '空间名称',
                codeName: 'name',
                detailStyle: 'DEFAULT',
                detailType: 'FORMITEM',
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                showCaption: true,
                id: 'name',
              },
              {
                createDV: 'principal_id',
                createDVT: 'APPDATA',
                dataType: 25,
                enableCond: 3,
                fieldName: 'target_id',
                labelPos: 'LEFT',
                labelWidth: 130,
                noPrivDisplayMode: 1,
                editor: {
                  editorType: 'HIDDEN',
                  editorItems: [
                    {
                      id: 'target_id',
                    },
                  ],
                  valueType: 'SIMPLE',
                  editable: true,
                  id: 'target_id',
                },
                allowEmpty: true,
                hidden: true,
                caption: '目标ID',
                codeName: 'target_id',
                detailStyle: 'DEFAULT',
                detailType: 'FORMITEM',
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                showCaption: true,
                id: 'target_id',
              },
              {
                dataType: 25,
                enableCond: 3,
                fieldName: 'space_id',
                labelPos: 'LEFT',
                labelWidth: 130,
                noPrivDisplayMode: 1,
                editor: {
                  editorType: 'HIDDEN',
                  valueType: 'SIMPLE',
                  editable: true,
                  id: 'space_id',
                },
                allowEmpty: true,
                hidden: true,
                caption: '空间ID',
                codeName: 'space_id',
                detailStyle: 'DEFAULT',
                detailType: 'FORMITEM',
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                showCaption: true,
                id: 'space_id',
              },
              {
                dataType: 25,
                enableCond: 3,
                labelPos: 'LEFT',
                labelWidth: 130,
                noPrivDisplayMode: 1,
                appDEFieldId: 'id',
                editor: {
                  editorType: 'HIDDEN',
                  valueType: 'SIMPLE',
                  editable: true,
                  id: 'id',
                },
                allowEmpty: true,
                hidden: true,
                capLanguageRes: {
                  lanResTag: 'DEF.LNAME.ID',
                },
                caption: '标识',
                codeName: 'id',
                detailStyle: 'DEFAULT',
                detailType: 'FORMITEM',
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                showCaption: true,
                id: 'id',
              },
            ],
            caption: '基本信息',
            codeName: 'formpage1',
            detailStyle: 'DEFAULT',
            detailType: 'FORMPAGE',
            id: 'formpage1',
          },
        ],
        layout: {
          columnCount: 24,
          layout: 'TABLE_24COL',
        },
        tabHeaderPos: 'TOP',
        noTabHeader: true,
        autoLoad: true,
        showBusyIndicator: true,
        codeName: 'choose_re_space_form',
        controlType: 'FORM',
        logicName: '选择关联空间_表单',
        appDataEntityId: 'plmweb.space',
        controlParam: {
          id: 'form',
        },
        modelId: 'c482c8710ce0bf1567d625ea38726b4c',
        modelType: 'PSDEFORM_EDITFORM',
        name: 'form',
        id: 'plmweb.space.choose_re_space_form',
      },
      {
        codeName: 'product_re_space_choose_option_view_datainfobar',
        controlType: 'DATAINFOBAR',
        appDataEntityId: 'plmweb.space',
        controlParam: {
          id: 'datainfobar',
        },
        name: 'datainfobar',
        id: 'product_re_space_choose_option_view_datainfobar',
      },
      {
        capLanguageRes: {
          lanResTag: 'DE.LNAME.SPACE',
        },
        caption: '关联空间',
        codeName: 'product_re_space_choose_option_view_captionbar',
        controlType: 'CAPTIONBAR',
        appDataEntityId: 'plmweb.space',
        controlParam: {},
        name: 'captionbar',
        id: 'product_re_space_choose_option_view_captionbar',
      },
    ],
    codeName: 'usr0228001496',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: 'choose_re_space选项操作视图布局面',
    appDataEntityId: 'plmweb.space',
    controlParam: {},
    modelId: 'c3adac290a2a2e19a0217a03f8d9ee56',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'usr0228001496',
  },
  title: '产品选择关联空间',
  viewStyle: 'DEFAULT',
  viewType: 'DEOPTVIEW',
  width: 500,
  enableDP: true,
  showCaptionBar: true,
  modelId: '4049a976636935e7897428f4a0fe92c7',
  modelType: 'PSAPPDEVIEW',
  name: 'spaceproduct_re_space_choose_option_view',
  id: 'plmweb.space_product_re_space_choose_option_view',
};