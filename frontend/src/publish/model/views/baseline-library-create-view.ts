export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  openMode: 'POPUPMODAL',
  deviewCodeName: 'library_create_view',
  deviewId: '6c7ca786e6090294818f59cdd5692c5b',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.BASELINE',
  },
  caption: '新建基线',
  codeName: 'baseline_library_create_view',
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
                    placeHolder: '输入基线名称',
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
                    appCodeListId: 'plmweb.testmgmt__library_list',
                    editorType: 'DROPDOWNLIST',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'owner_id',
                  },
                  needCodeListConfig: true,
                  caption: '所属测试库',
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
                      'SRFNAVPARAM.n_status_eq': '1',
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
                    placeHolder: '选择负责人',
                    valueType: 'SIMPLE',
                    editable: true,
                    navigateParams: [
                      {
                        key: 'n_status_eq',
                        value: '1',
                        rawValue: true,
                        id: 'n_status_eq',
                      },
                    ],
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
                  appDEFieldId: 'categories_name',
                  editor: {
                    dropDownView: true,
                    enablePickupView: true,
                    singleSelect: true,
                    pickupAppViewId:
                      'plmweb.baseline_library_categories_pick_up_tree_view',
                    handlerType: 'PickupText',
                    forceSelection: true,
                    showTrigger: true,
                    valueItemName: 'categories',
                    editorParams: {
                      multiple: 'true',
                      DROPDOWNVIEW: 'TRUE',
                      AC: 'FALSE',
                      TRIGGER: 'TRUE',
                      PICKUPVIEW: 'TRUE',
                    },
                    editorType: 'PICKEREX_DROPDOWNVIEW',
                    editorItems: [
                      {
                        id: 'categories',
                      },
                    ],
                    placeHolder: '选择类别',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'categories_name',
                  },
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
                    placeHolder: '输入基线描述',
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
                  id: 'assignee_id',
                },
                {
                  createDV: 'LIBRARY',
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
                {
                  createDV: 'principal',
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'NONE',
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'type',
                  editor: {
                    editorType: 'HIDDEN',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'type',
                  },
                  allowEmpty: true,
                  hidden: true,
                  caption: '基线类型',
                  codeName: 'type',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  id: 'type',
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
      codeName: 'library_create_form',
      controlType: 'FORM',
      logicName: '测试库基线快速建立_表单',
      appDataEntityId: 'plmweb.baseline',
      controlParam: {
        id: 'form',
      },
      modelId: '4e197d847eb9c0983f290ce9598339a5',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.baseline.library_create_form',
    },
    {
      codeName: 'library_create_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.baseline',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'library_create_view_datainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.BASELINE',
      },
      caption: '新建基线',
      codeName: 'library_create_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.baseline',
      controlParam: {},
      name: 'captionbar',
      id: 'library_create_view_captionbar',
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
  title: '测试库基线快速建立视图',
  viewStyle: 'DEFAULT',
  viewType: 'DEOPTVIEW',
  width: 800,
  enableDP: true,
  showCaptionBar: true,
  modelId: '35967565e8e3b6deafabbdd4ba32e23a',
  modelType: 'PSAPPDEVIEW',
  name: 'baselinelibrary_create_view',
  id: 'plmweb.baseline_library_create_view',
};
