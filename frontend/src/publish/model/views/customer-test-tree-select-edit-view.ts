export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  deviewCodeName: 'test_tree_select_edit_view',
  deviewId: '4473feeeae40beffb1526edbe3609387',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.CUSTOMER',
  },
  caption: '客户',
  codeName: 'customer_test_tree_select_edit_view',
  appDataEntityId: 'plmweb.customer',
  appViewNavParams: [
    {
      key: 'n_owner_id_eq',
      value: 'n_owner_id_eq',
      id: 'n_owner_id_eq',
    },
    {
      key: 'n_owner_type_eq',
      value: 'n_owner_type_eq',
      id: 'n_owner_type_eq',
    },
  ],
  viewLayoutPanel: {
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
                    editor: {
                      enablePickupView: true,
                      singleSelect: true,
                      pickupAppViewId: 'plmweb.customer_pick_up_tree_view',
                      enableAC: true,
                      forceSelection: true,
                      showTrigger: true,
                      editorParams: {
                        URL: '`sections/fetchdefault`',
                        PTAGFIELD: 'categories',
                        TAGFIELD: 'categories',
                        'SRFNAVPARAM.n_owner_id_eq': '%n_owner_id_eq%',
                        AC: 'TRUE',
                        'SRFNAVPARAM.n_owner_type_eq': '%n_owner_type_eq%',
                        PICKUPVIEW: 'TRUE',
                      },
                      editorType: 'PICKER',
                      predefinedType: 'PICKEREX_DROPDOWNVIEW',
                      valueType: 'SIMPLE',
                      editable: true,
                      navigateParams: [
                        {
                          key: 'n_owner_id_eq',
                          value: 'n_owner_id_eq',
                          id: 'n_owner_id_eq',
                        },
                        {
                          key: 'n_owner_type_eq',
                          value: 'n_owner_type_eq',
                          id: 'n_owner_type_eq',
                        },
                      ],
                      id: 'field_picker',
                    },
                    allowEmpty: true,
                    caption: '数据选择',
                    itemStyle: 'DEFAULT',
                    itemType: 'FIELD',
                    layoutPos: {
                      shrink: 1,
                      layout: 'FLEX',
                    },
                    id: 'field_picker',
                  },
                ],
                layout: {
                  align: 'center',
                  dir: 'row',
                  layout: 'FLEX',
                  valign: 'center',
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
              grow: 1,
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
    ],
    layoutPanel: true,
    appViewEngines: [
      {
        engineCat: 'VIEW',
        engineType: 'EditView',
        id: 'engine',
      },
    ],
    controls: [
      {
        xdataControlName: 'form',
        codeName: 'test_tree_select_edit_view_toolbar',
        controlType: 'TOOLBAR',
        logicName: '测试树下拉选择的编辑视图_工具栏',
        appDataEntityId: 'plmweb.customer',
        controlParam: {
          id: 'toolbar',
        },
        modelId: '11ab98a931f23e9f973a37079cce0da7',
        modelType: 'PSDETOOLBAR',
        name: 'toolbar',
        id: 'test_tree_select_edit_view_toolbar',
      },
      {
        autoSaveMode: 1,
        createControlAction: {
          appDEMethodId: 'create',
          appDataEntityId: 'plmweb.customer',
          id: 'create',
        },
        getDraftFromControlAction: {
          appDataEntityId: 'plmweb.customer',
          id: 'loaddraftfrom',
        },
        getDraftControlAction: {
          appDEMethodId: 'get_draft',
          appDataEntityId: 'plmweb.customer',
          id: 'loaddraft',
        },
        getControlAction: {
          appDEMethodId: 'get',
          appDataEntityId: 'plmweb.customer',
          id: 'load',
        },
        removeControlAction: {
          appDEMethodId: 'remove',
          appDataEntityId: 'plmweb.customer',
          id: 'remove',
        },
        updateControlAction: {
          appDEMethodId: 'update',
          appDataEntityId: 'plmweb.customer',
          id: 'update',
        },
        enableAutoSave: true,
        deformPages: [
          {
            layout: {
              columnCount: 24,
              layout: 'TABLE_24COL',
            },
            deformDetails: [
              {
                layout: {
                  columnCount: 24,
                  layout: 'TABLE_24COL',
                },
                deformDetails: [
                  {
                    dataType: 25,
                    enableCond: 3,
                    labelPos: 'LEFT',
                    labelWidth: 130,
                    noPrivDisplayMode: 1,
                    appDEFieldId: 'name',
                    editor: {
                      maxLength: 500,
                      editorType: 'TEXTBOX',
                      valueType: 'SIMPLE',
                      editable: true,
                      id: 'name',
                    },
                    capLanguageRes: {
                      lanResTag: 'DEF.LNAME.NAME',
                    },
                    caption: '客户名称',
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
                    dataType: 25,
                    enableCond: 3,
                    labelPos: 'LEFT',
                    labelWidth: 130,
                    noPrivDisplayMode: 1,
                    appDEFieldId: 'categories_name',
                    editor: {
                      dropDownView: true,
                      enablePickupView: true,
                      singleSelect: true,
                      pickupAppViewId: 'plmweb.customer_pick_up_tree_view',
                      handlerType: 'PickupText',
                      forceSelection: true,
                      showTrigger: true,
                      valueItemName: 'categories',
                      editorParams: {
                        DROPDOWNVIEW: 'TRUE',
                        'SRFNAVPARAM.name': '%name%',
                        'SRFNAVPARAM.n_owner_id_eq': '%n_owner_id_eq%',
                        AC: 'FALSE',
                        MULTIPLE: 'true',
                        TRIGGER: 'TRUE',
                        'SRFNAVPARAM.n_owner_type_eq': '%n_owner_type_eq%',
                        PICKUPVIEW: 'TRUE',
                      },
                      editorType: 'PICKEREX_DROPDOWNVIEW',
                      editorItems: [
                        {
                          id: 'categories',
                        },
                      ],
                      valueType: 'SIMPLE',
                      editable: true,
                      navigateParams: [
                        {
                          key: 'name',
                          value: 'name',
                          id: 'name',
                        },
                        {
                          key: 'n_owner_id_eq',
                          value: 'n_owner_id_eq',
                          id: 'n_owner_id_eq',
                        },
                        {
                          key: 'n_owner_type_eq',
                          value: 'n_owner_type_eq',
                          id: 'n_owner_type_eq',
                        },
                      ],
                      id: 'categories_name',
                    },
                    resetItemNames: ['name'],
                    allowEmpty: true,
                    caption: '类别',
                    codeName: 'categories_name',
                    detailStyle: 'DEFAULT',
                    detailType: 'FORMITEM',
                    layoutPos: {
                      colMD: 24,
                      layout: 'TABLE_24COL',
                    },
                    showCaption: true,
                    id: 'categories_name',
                  },
                  {
                    dataType: 25,
                    enableCond: 3,
                    labelPos: 'LEFT',
                    labelWidth: 130,
                    noPrivDisplayMode: 1,
                    appDEFieldId: 'categories',
                    editor: {
                      editorType: 'HIDDEN',
                      valueType: 'SIMPLE',
                      editable: true,
                      id: 'categories',
                    },
                    allowEmpty: true,
                    hidden: true,
                    caption: '类别',
                    codeName: 'categories',
                    detailStyle: 'DEFAULT',
                    detailType: 'FORMITEM',
                    layoutPos: {
                      colMD: 24,
                      layout: 'TABLE_24COL',
                    },
                    id: 'categories',
                  },
                ],
                caption: '客户基本信息',
                codeName: 'group1',
                detailStyle: 'DEFAULT',
                detailType: 'GROUPPANEL',
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                showCaption: true,
                id: 'group1',
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
        codeName: 'test_tree_select_edit_view_form',
        controlType: 'FORM',
        logicName: '测试树下拉选择的编辑视图_表单',
        appDataEntityId: 'plmweb.customer',
        controlParam: {
          id: 'form',
        },
        modelId: '6c23d6d336840f9a1f1e7e4aa34430b7',
        modelType: 'PSDEFORM_EDITFORM',
        name: 'form',
        id: 'plmweb.customer.test_tree_select_edit_view_form',
      },
      {
        codeName: 'test_tree_select_edit_view_datainfobar',
        controlType: 'DATAINFOBAR',
        appDataEntityId: 'plmweb.customer',
        controlParam: {
          id: 'datainfobar',
        },
        name: 'datainfobar',
        id: 'test_tree_select_edit_view_datainfobar',
      },
      {
        capLanguageRes: {
          lanResTag: 'DE.LNAME.CUSTOMER',
        },
        caption: '客户',
        codeName: 'test_tree_select_edit_view_captionbar',
        controlType: 'CAPTIONBAR',
        appDataEntityId: 'plmweb.customer',
        controlParam: {},
        name: 'captionbar',
        id: 'test_tree_select_edit_view_captionbar',
      },
    ],
    codeName: 'usr0207166292',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: 'TestTreeSelectEditView编辑视图布局面板',
    appDataEntityId: 'plmweb.customer',
    controlLogics: [
      {
        eventNames: 'onChange',
        itemName: 'FIELD_PICKER',
        logicTag: 'layoutpanel',
        logicType: 'SCRIPT',
        scriptCode: "console.log('面包屑路径改变')",
        triggerType: 'CTRLEVENT',
        id: 'logic',
      },
    ],
    controlParam: {},
    modelId: 'ed5cd81eed361c38282ff1277580e9e9',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'usr0207166292',
  },
  title: '测试树下拉选择的编辑视图',
  viewStyle: 'DEFAULT',
  viewType: 'DEEDITVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '148615e85e751e24dc3eaa28aa59bd2a',
  modelType: 'PSAPPDEVIEW',
  name: 'customertest_tree_select_edit_view',
  id: 'plmweb.customer_test_tree_select_edit_view',
};