export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  openMode: 'POPUPMODAL',
  deviewCodeName: 'plan_quick_create_view',
  deviewId: 'b7ec6378a0de8100c4aeb043bdc7b97e',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.WORK_ITEM',
  },
  caption: '规划',
  codeName: 'work_item_plan_quick_create_view',
  appDataEntityId: 'plmweb.work_item',
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
        appDataEntityId: 'plmweb.work_item',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.work_item',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'get_draft',
        appDataEntityId: 'plmweb.work_item',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.work_item',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.work_item',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.work_item',
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
                  appDEFieldId: 'title',
                  editor: {
                    maxLength: 500,
                    editorType: 'TEXTBOX',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'title',
                  },
                  caption: '标题',
                  codeName: 'title',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'title',
                },
                {
                  dataType: 21,
                  enableCond: 3,
                  itemHeight: 320,
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'description',
                  editor: {
                    editorHeight: 300,
                    editorType: 'HTMLEDITOR',
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
              ],
              caption: '基本信息',
              codeName: 'group1',
              detailStyle: 'DEFAULT',
              detailType: 'GROUPPANEL',
              layoutPos: {
                colLG: 12,
                colMD: 12,
                colSM: 12,
                colXS: 12,
                layout: 'TABLE_24COL',
              },
              id: 'group1',
            },
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
                  appDEFieldId: 'project_name',
                  editor: {
                    enablePickupView: true,
                    singleSelect: true,
                    pickupAppViewId: 'plmweb.project_pick_up_view',
                    handlerType: 'PickupText',
                    appDEACModeId: 'default',
                    appDEDataSetId: 'fetch_default',
                    appDataEntityId: 'plmweb.project',
                    uiactionGroup: {
                      uiactionGroupDetails: [
                        {
                          actionLevel: 100,
                          afterItemType: 'NONE',
                          beforeItemType: 'NONE',
                          caption: '项目配置',
                          detailType: 'DEUIACTION',
                          uiactionId: 'open_global_setting@project',
                          showCaption: true,
                          showIcon: true,
                          id: 'u3fee786',
                        },
                      ],
                      appDataEntityId: 'plmweb.project',
                      uniqueTag: 'project__Usr1221520658',
                      name: '自填模式行为组',
                      id: 'usr1221520658',
                    },
                    enableAC: true,
                    forceSelection: true,
                    showTrigger: true,
                    valueItemName: 'project_id',
                    editorParams: {
                      AC: 'TRUE',
                      PICKUPVIEW: 'TRUE',
                    },
                    editorType: 'PICKER',
                    editorItems: [
                      {
                        id: 'project_id',
                      },
                    ],
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'project_name',
                  },
                  allowEmpty: true,
                  caption: '所属项目',
                  codeName: 'project_name',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'project_name',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'project_id',
                  editor: {
                    editorType: 'HIDDEN',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'project_id',
                  },
                  allowEmpty: true,
                  hidden: true,
                  caption: '项目',
                  codeName: 'project_id',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  id: 'project_id',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'work_item_type_name',
                  editor: {
                    enablePickupView: true,
                    singleSelect: true,
                    pickupAppViewId: 'plmweb.work_item_type_pick_up_view',
                    handlerType: 'PickupText',
                    appDEACModeId: 'default',
                    appDEDataSetId: 'fetch_default',
                    appDataEntityId: 'plmweb.work_item_type',
                    enableAC: true,
                    forceSelection: true,
                    showTrigger: true,
                    valueItemName: 'work_item_type_id',
                    editorParams: {
                      AC: 'TRUE',
                      PICKUPVIEW: 'TRUE',
                    },
                    editorType: 'PICKER',
                    editorItems: [
                      {
                        id: 'work_item_type_id',
                      },
                    ],
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'work_item_type_name',
                  },
                  allowEmpty: true,
                  caption: '工作项类型',
                  codeName: 'work_item_type_name',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'work_item_type_name',
                },
                {
                  createDV: 'work_item_type_id',
                  createDVT: 'CONTEXT',
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'work_item_type_id',
                  editor: {
                    editorType: 'HIDDEN',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'work_item_type_id',
                  },
                  allowEmpty: true,
                  hidden: true,
                  caption: '工作项类型',
                  codeName: 'work_item_type_id',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  id: 'work_item_type_id',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'ptitle',
                  editor: {
                    enablePickupView: true,
                    singleSelect: true,
                    pickupAppViewId: 'plmweb.work_item_pick_up_view',
                    handlerType: 'PickupText',
                    appDEACModeId: 'default',
                    appDEDataSetId: 'fetch_default',
                    appDataEntityId: 'plmweb.work_item',
                    enableAC: true,
                    forceSelection: true,
                    showTrigger: true,
                    valueItemName: 'pid',
                    editorParams: {
                      AC: 'TRUE',
                      PICKUPVIEW: 'TRUE',
                    },
                    editorType: 'PICKER',
                    editorItems: [
                      {
                        id: 'pid',
                      },
                    ],
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'ptitle',
                  },
                  allowEmpty: true,
                  caption: '父计划',
                  codeName: 'ptitle',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'ptitle',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'pid',
                  editor: {
                    editorType: 'HIDDEN',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'pid',
                  },
                  allowEmpty: true,
                  hidden: true,
                  caption: '父计划标识',
                  codeName: 'pid',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  id: 'pid',
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
                    appDEACModeId: 'member_select',
                    appDEDataSetId: 'fetch_default',
                    appDataEntityId: 'plmweb.project_member',
                    uiactionGroup: {
                      uiactionGroupDetails: [
                        {
                          actionLevel: 100,
                          afterItemType: 'NONE',
                          beforeItemType: 'NONE',
                          caption: '跳转至成员设置',
                          detailType: 'DEUIACTION',
                          uiactionId: 'jump_to_member_set@project_member',
                          tooltip: '跳转至成员设置',
                          showCaption: true,
                          showIcon: true,
                          sysImage: {
                            cssClass: 'fa fa-user-md',
                            glyph: 'xf0f0@FontAwesome',
                          },
                          id: 'uc5eeb4c',
                        },
                      ],
                      appDataEntityId: 'plmweb.project_member',
                      uniqueTag: 'project_member__Usr0104465165',
                      name: '跳转至成员配置',
                      id: 'usr0104465165',
                    },
                    enableAC: true,
                    forceSelection: true,
                    showTrigger: true,
                    valueItemName: 'assignee_id',
                    editorParams: {
                      'SRFNAVPARAM.n_department_id_eq': '%srforgsectorid%',
                      AC: 'TRUE',
                      TRIGGER: 'TRUE',
                      URL: 'projects/${context.project}/project_members/fetch_default',
                      PICKUPVIEW: 'FALSE',
                      USERMETHOD: 'post',
                      USERMAP: '{"id":"user_id","name":"name"}',
                      DEPTMAP: '{"id":"id","name":"display_name"}',
                      DEPTMETHOD: 'get',
                      DEPTURL: '/users/fetch_default',
                    },
                    editorStyle: 'PERSONEL_SELECT_PROJECT',
                    editorType: 'PICKEREX_TRIGGER',
                    editorItems: [
                      {
                        id: 'assignee_id',
                      },
                    ],
                    sysPFPluginId: 'person_select',
                    valueType: 'SIMPLE',
                    editable: true,
                    navigateParams: [
                      {
                        key: 'n_department_id_eq',
                        value: 'srforgsectorid',
                        id: 'n_department_id_eq',
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
                    colMD: 24,
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
                  appDEFieldId: 'assignee_id',
                  editor: {
                    editorType: 'HIDDEN',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'assignee_id',
                  },
                  allowEmpty: true,
                  hidden: true,
                  caption: '负责人',
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
                  dataType: 5,
                  enableCond: 3,
                  itemWidth: 230,
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'start_at',
                  editor: {
                    dateTimeFormat: 'YYYY-MM-DD',
                    editorParams: {
                      TIMEFMT: 'YYYY-MM-DD',
                    },
                    editorType: 'DATEPICKEREX_NOTIME',
                    editorWidth: 100,
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'start_at',
                  },
                  valueFormat: 'YYYY-MM-DD',
                  allowEmpty: true,
                  caption: '开始时间',
                  codeName: 'start_at',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'start_at',
                },
                {
                  dataType: 5,
                  enableCond: 3,
                  itemWidth: 230,
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'end_at',
                  editor: {
                    dateTimeFormat: 'YYYY-MM-DD',
                    editorParams: {
                      TIMEFMT: 'YYYY-MM-DD',
                    },
                    editorType: 'DATEPICKEREX_NOTIME',
                    editorWidth: 100,
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'end_at',
                  },
                  valueFormat: 'YYYY-MM-DD',
                  allowEmpty: true,
                  caption: '截止时间',
                  codeName: 'end_at',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'end_at',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'priority',
                  editor: {
                    singleSelect: true,
                    appCodeListId: 'plmweb.projmgmt__work_item_priority',
                    editorType: 'DROPDOWNLIST',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'priority',
                  },
                  allowEmpty: true,
                  needCodeListConfig: true,
                  caption: '优先级',
                  codeName: 'priority',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'priority',
                },
                {
                  layout: {
                    columnCount: 24,
                    layout: 'TABLE_24COL',
                  },
                  deformDetails: [
                    {
                      dataType: 21,
                      enableCond: 3,
                      labelPos: 'TOP',
                      labelWidth: 130,
                      noPrivDisplayMode: 1,
                      appDEFieldId: 'attentions',
                      editor: {
                        singleSelect: true,
                        handlerType: 'PickupText',
                        enableAC: true,
                        forceSelection: true,
                        showTrigger: true,
                        editorParams: {
                          MULTIPLE: 'true',
                          DEFAULTATNVALUE: '40',
                          'SRFNAVPARAM.n_department_id_eq': '%srforgsectorid%',
                          AC: 'TRUE',
                          DEFAULTSELCURUSER: 'true',
                          TRIGGER: 'TRUE',
                          SELFFILLMAP:
                            '{"user_id":"user_id","user_name":"name"}',
                          URL: 'projects/${context.project}/project_members/fetch_default',
                          PICKUPVIEW: 'FALSE',
                          USERMETHOD: 'post',
                          USERMAP: '{"id":"user_id","name":"name"}',
                          DEPTMAP: '{"id":"id","name":"display_name"}',
                          DEPTMETHOD: 'get',
                          DEPTURL: '/users/fetch_default',
                        },
                        editorStyle: 'PERSONEL_SELECT_PROJECT',
                        editorType: 'PICKEREX_TRIGGER',
                        objectIdField: 'id',
                        objectNameField: 'name',
                        sysPFPluginId: 'person_select',
                        valueType: 'OBJECTS',
                        editable: true,
                        navigateParams: [
                          {
                            key: 'n_department_id_eq',
                            value: 'srforgsectorid',
                            id: 'n_department_id_eq',
                          },
                        ],
                        id: 'attentions',
                      },
                      allowEmpty: true,
                      caption: '关注人',
                      codeName: 'attentions',
                      detailStyle: 'DEFAULT',
                      detailType: 'FORMITEM',
                      layoutPos: {
                        colMD: 24,
                        layout: 'TABLE_24COL',
                      },
                      showCaption: true,
                      id: 'attentions',
                    },
                  ],
                  caption: '关注字段',
                  codeName: 'grouppanel2',
                  detailStyle: 'DEFAULT',
                  detailType: 'GROUPPANEL',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  id: 'grouppanel2',
                },
              ],
              caption: '其他',
              codeName: 'grouppanel1',
              detailStyle: 'DEFAULT',
              detailType: 'GROUPPANEL',
              layoutPos: {
                colLG: 12,
                colMD: 12,
                colSM: 12,
                colXS: 12,
                layout: 'TABLE_24COL',
              },
              id: 'grouppanel1',
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
                colLG: 12,
                colMD: 12,
                colSM: 12,
                colXS: 12,
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
      codeName: 'quick_create_view_gantt_form',
      controlType: 'FORM',
      logicName: '工作项快速建立视图（规划）_表单',
      appDataEntityId: 'plmweb.work_item',
      controlParam: {
        id: 'form',
      },
      modelId: 'e91755f1586a5e9976c7a2ca4876607e',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.work_item.quick_create_view_gantt_form',
    },
    {
      codeName: 'plan_quick_create_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.work_item',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'plan_quick_create_view_datainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.WORK_ITEM',
      },
      caption: '规划',
      codeName: 'plan_quick_create_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.work_item',
      controlParam: {},
      name: 'captionbar',
      id: 'plan_quick_create_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEOPTVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.work_item',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '规划',
  viewStyle: 'DEFAULT',
  viewType: 'DEOPTVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '258c81c7dff3ee2bda7842ec4d995ba3',
  modelType: 'PSAPPDEVIEW',
  name: 'work_itemplan_quick_create_view',
  id: 'plmweb.work_item_plan_quick_create_view',
};