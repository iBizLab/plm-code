export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  openMode: 'POPUPMODAL',
  deviewCodeName: 'product_update_view',
  deviewId: '41efdb9f3054129fd877afa6aa64ae67',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.BASELINE',
  },
  caption: '编辑基线',
  codeName: 'baseline_product_update_view',
  height: 580,
  appDataEntityId: 'plmweb.baseline',
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
        appDEMethodId: 'create',
        appDataEntityId: 'plmweb.baseline',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.baseline',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'get_draft',
        appDataEntityId: 'plmweb.baseline',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.baseline',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.baseline',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.baseline',
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
                    maxLength: 200,
                    editorType: 'TEXTBOX',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'name',
                  },
                  capLanguageRes: {
                    lanResTag: 'DEF.LNAME.NAME',
                  },
                  caption: '基线名称',
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
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'owner_id',
                  editor: {
                    singleSelect: true,
                    appCodeListId: 'plmweb.prodmgmt__product_list',
                    editorType: 'DROPDOWNLIST',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'owner_id',
                  },
                  needCodeListConfig: true,
                  caption: '所属产品',
                  codeName: 'owner_id',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  defdgroupLogics: [
                    {
                      logicCat: 'ITEMENABLE',
                      relatedDetailNames: ['id'],
                      groupOP: 'AND',
                      defdlogics: [
                        {
                          condOP: 'ISNULL',
                          defdname: 'id',
                          logicType: 'SINGLE',
                        },
                      ],
                      logicType: 'GROUP',
                      id: '表单成员[owner_id][表单项启用]逻辑',
                    },
                  ],
                  layoutPos: {
                    colLG: 12,
                    colMD: 12,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'owner_id',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'assignee_name',
                  editor: {
                    singleSelect: true,
                    handlerType: 'PickupText',
                    enableAC: true,
                    forceSelection: true,
                    showTrigger: true,
                    valueItemName: 'ASSIGNEE_ID',
                    editorParams: {
                      URL: '/users/fetch_default',
                      ISSHOWTAB: 'false',
                      USERMAP: '{"id":"id","name":"display_name"}',
                      AC: 'TRUE',
                      USERMETHOD: 'get',
                      TRIGGER: 'TRUE',
                      PICKUPVIEW: 'FALSE',
                    },
                    editorStyle: 'PERSONEL_SELECT_ALL',
                    editorType: 'PICKEREX_TRIGGER',
                    sysPFPluginId: 'person_select',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'assignee_name',
                  },
                  allowEmpty: true,
                  caption: '负责人',
                  codeName: 'assignee_name',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colLG: 12,
                    colMD: 12,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'assignee_name',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'categories',
                  editor: {
                    enablePickupView: true,
                    appDEACModeId: 'default',
                    appDEDataSetId: 'fetch_default',
                    appDataEntityId: 'plmweb.category',
                    forceSelection: true,
                    showTrigger: true,
                    editorParams: {
                      'srfnavparam.n_owner_subtype_eq': 'baseline',
                      'srfnavparam.n_owner_id_eq': '%product%',
                      PICKUPVIEW: 'TRUE',
                      'srfnavparam.n_owner_type_eq': 'product',
                    },
                    editorType: 'ADDRESSPICKUP',
                    valueType: 'SIMPLE',
                    editable: true,
                    navigateParams: [
                      {
                        key: 'n_owner_subtype_eq',
                        value: 'baseline',
                        rawValue: true,
                        id: 'n_owner_subtype_eq',
                      },
                      {
                        key: 'n_owner_id_eq',
                        value: 'product',
                        id: 'n_owner_id_eq',
                      },
                      {
                        key: 'n_owner_type_eq',
                        value: 'product',
                        rawValue: true,
                        id: 'n_owner_type_eq',
                      },
                    ],
                    id: 'categories',
                  },
                  allowEmpty: true,
                  caption: '类别',
                  codeName: 'categories',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'categories',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  itemHeight: 220,
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'description',
                  editor: {
                    maxLength: 2000,
                    showMaxLength: true,
                    editorHeight: 200,
                    editorParams: {
                      HEIGHT: '200',
                    },
                    editorType: 'TEXTAREA_10',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'description',
                  },
                  allowEmpty: true,
                  caption: '描述',
                  codeName: 'description',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'description',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'assignee_id',
                  editor: {
                    editorType: 'HIDDEN',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'assignee_id',
                  },
                  allowEmpty: true,
                  hidden: true,
                  caption: '负责人标识',
                  codeName: 'assignee_id',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'assignee_id',
                },
                {
                  createDV: 'PRODUCT',
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'owner_type',
                  editor: {
                    editorType: 'HIDDEN',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'owner_type',
                  },
                  allowEmpty: true,
                  hidden: true,
                  caption: '所属数据对象',
                  codeName: 'owner_type',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'owner_type',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'NONE',
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
              caption: '基线基本信息',
              codeName: 'group1',
              detailStyle: 'DEFAULT',
              detailType: 'GROUPPANEL',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              id: 'group1',
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
      codeName: 'product_create_form',
      controlType: 'FORM',
      logicName: '产品基线快速建立_表单',
      appDataEntityId: 'plmweb.baseline',
      controlParam: {
        id: 'form',
      },
      modelId: 'e3e84fbbd45c9ad6382289dbc761f41b',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.baseline.product_create_form',
    },
    {
      codeName: 'product_update_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.baseline',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'product_update_view_datainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.BASELINE',
      },
      caption: '编辑基线',
      codeName: 'product_update_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.baseline',
      controlParam: {},
      name: 'captionbar',
      id: 'product_update_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEOPTVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.baseline',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '产品基线编辑视图',
  viewStyle: 'DEFAULT',
  viewType: 'DEOPTVIEW',
  width: 800,
  enableDP: true,
  showCaptionBar: true,
  modelId: '7de4ab4ca8385f7882230ca05020ad81',
  modelType: 'PSAPPDEVIEW',
  name: 'baselineproduct_update_view',
  id: 'plmweb.baseline_product_update_view',
};