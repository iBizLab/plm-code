export default {
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  openMode: 'POPUPMODAL',
  deviewCodeName: 'update_view',
  deviewId: 'b73eefc7f9363f9bb9306a77b22ff928',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.SPRINT',
  },
  caption: '编辑迭代',
  codeName: 'sprint_update_view',
  height: 520,
  appDataEntityId: 'plmweb.sprint',
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
        appDataEntityId: 'plmweb.sprint',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.sprint',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'get_draft',
        appDataEntityId: 'plmweb.sprint',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.sprint',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.sprint',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.sprint',
        id: 'update',
      },
      deformItemVRs: [
        {
          checkMode: 1,
          defvalueRule: {
            codeName: 'START_AT',
            groupCond: {
              condOp: 'AND',
              conds: [
                {
                  condOp: 'OR',
                  conds: [
                    {
                      condOp: 'ISNULL',
                      defname: 'START_AT',
                      condType: 'SIMPLE',
                      name: '[常规条件] 值为空(Nil)',
                      id: '[常规条件] 值为空(nil)',
                    },
                    {
                      condOp: 'OR',
                      conds: [
                        {
                          condOp: 'ISNULL',
                          defname: 'END_AT',
                          condType: 'SIMPLE',
                          name: '[常规条件] 值为空(Nil)',
                          id: '[常规条件] 值为空(nil)',
                        },
                        {
                          condOp: 'LTANDEQ',
                          paramType: 'ENTITYFIELD',
                          paramValue: 'END_AT',
                          defname: 'START_AT',
                          condType: 'SIMPLE',
                          ruleInfo: '开始时间必须小于等于结束时间',
                          name: '[常规条件] 小于等于(<=) 数据对象属性 (END_AT)',
                          id: '[常规条件] 小于等于(<=) 数据对象属性 (end_at)',
                        },
                      ],
                      condType: 'GROUP',
                      ruleInfo: '开始时间必须小于等于结束时间',
                      name: '[条件组]OR',
                      id: '[条件组]or',
                    },
                  ],
                  condType: 'GROUP',
                  ruleInfo: '开始时间必须小于等于结束时间',
                  name: '[条件组]OR',
                  id: '[条件组]or',
                },
              ],
              condType: 'GROUP',
              ruleInfo: '开始时间必须小于等于结束时间',
              id: '默认组',
            },
            ruleInfo: '开始时间必须小于等于结束时间',
            checkDefault: true,
            name: '开始时间',
            id: 'start_at',
          },
          deformItemName: 'start_at',
          valueRuleType: 'DEFVALUERULE',
          id: '表单项值规则',
        },
        {
          checkMode: 1,
          defvalueRule: {
            codeName: 'END_AT',
            groupCond: {
              condOp: 'AND',
              conds: [
                {
                  condOp: 'OR',
                  conds: [
                    {
                      condOp: 'ISNULL',
                      defname: 'END_AT',
                      condType: 'SIMPLE',
                      name: '[常规条件] 值为空(Nil)',
                      id: '[常规条件] 值为空(nil)',
                    },
                    {
                      condOp: 'OR',
                      conds: [
                        {
                          condOp: 'ISNULL',
                          defname: 'START_AT',
                          condType: 'SIMPLE',
                          name: '[常规条件] 值为空(Nil)',
                          id: '[常规条件] 值为空(nil)',
                        },
                        {
                          condOp: 'GTANDEQ',
                          paramType: 'ENTITYFIELD',
                          paramValue: 'START_AT',
                          defname: 'END_AT',
                          condType: 'SIMPLE',
                          ruleInfo: '结束时间必须大于等于开始时间',
                          name: '[常规条件] 大于等于(>=) 数据对象属性 (START_AT)',
                          id: '[常规条件] 大于等于(>=) 数据对象属性 (start_at)',
                        },
                      ],
                      condType: 'GROUP',
                      ruleInfo: '结束时间必须大于等于开始时间',
                      name: '[条件组]OR',
                      id: '[条件组]or',
                    },
                  ],
                  condType: 'GROUP',
                  ruleInfo: '结束时间必须大于等于开始时间',
                  name: '[条件组]OR',
                  id: '[条件组]or',
                },
              ],
              condType: 'GROUP',
              ruleInfo: '结束时间必须大于等于开始时间',
              id: '默认组',
            },
            ruleInfo: '结束时间必须大于等于开始时间',
            checkDefault: true,
            name: '结束时间',
            id: 'end_at',
          },
          deformItemName: 'end_at',
          valueRuleType: 'DEFVALUERULE',
          id: '表单项值规则',
        },
      ],
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
                  caption: '迭代名称',
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
                  createDV: 'project',
                  createDVT: 'APPDATA',
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
                  caption: '项目标识',
                  codeName: 'project_id',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'project_id',
                },
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
                  caption: '所属项目',
                  codeName: 'project_name',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colLG: 12,
                    colMD: 12,
                    colSM: 12,
                    colXS: 12,
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
                    valueItemName: 'ASSIGNEE_ID',
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
                    colLG: 12,
                    colMD: 12,
                    colSM: 12,
                    colXS: 12,
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
                      'srfnavparam.n_owner_subtype_eq': 'sprint',
                      'srfnavparam.n_owner_id_eq': '%project%',
                      PICKUPVIEW: 'TRUE',
                      'srfnavparam.n_owner_type_eq': 'project',
                    },
                    editorType: 'ADDRESSPICKUP',
                    valueType: 'SIMPLE',
                    editable: true,
                    navigateParams: [
                      {
                        key: 'n_owner_subtype_eq',
                        value: 'sprint',
                        rawValue: true,
                        id: 'n_owner_subtype_eq',
                      },
                      {
                        key: 'n_owner_id_eq',
                        value: 'project',
                        id: 'n_owner_id_eq',
                      },
                      {
                        key: 'n_owner_type_eq',
                        value: 'project',
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
                  dataType: 5,
                  enableCond: 3,
                  itemWidth: 131,
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
                    editorWidth: 1,
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'start_at',
                  },
                  valueFormat: 'YYYY-MM-DD',
                  caption: '开始时间',
                  codeName: 'start_at',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  controlAttributes: [
                    {
                      attrName: 'disabledDate',
                      attrValue:
                        '(time) => {\r\n    if (!data.end_at) {\r\n        return false;\r\n    }\r\n    const end_at = new Date(data.end_at);\r\n    // 比对天\r\n    time.setHours(0, 0, 0, 0);\r\n    end_at.setHours(0, 0, 0, 0);\r\n    return time.getTime() > end_at.getTime();\r\n}',
                      name: 'start_at_disabledDate',
                      id: 'start_at_disableddate',
                    },
                  ],
                  layoutPos: {
                    colLG: 12,
                    colMD: 12,
                    colSM: 12,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'start_at',
                },
                {
                  dataType: 5,
                  enableCond: 3,
                  itemWidth: 131,
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
                    editorWidth: 1,
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'end_at',
                  },
                  valueFormat: 'YYYY-MM-DD',
                  caption: '结束时间',
                  codeName: 'end_at',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  controlAttributes: [
                    {
                      attrName: 'disabledDate',
                      attrValue:
                        '(time) => {\r\n    if (!data.start_at) {\r\n        return false;\r\n    }\r\n    const start_at = new Date(data.start_at);\r\n    // 比对天\r\n    start_at.setHours(0, 0, 0, 0);\r\n    time.setHours(0, 0, 0, 0);\r\n    return time.getTime() < start_at.getTime();\r\n}',
                      name: 'end_at_disabledDate',
                      id: 'end_at_disableddate',
                    },
                  ],
                  layoutPos: {
                    colLG: 12,
                    colMD: 12,
                    colSM: 12,
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
                  appDEFieldId: 'description',
                  editor: {
                    maxLength: 2000,
                    showMaxLength: true,
                    editorType: 'TEXTAREA',
                    placeHolder: '输入迭代目标',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'description',
                  },
                  allowEmpty: true,
                  caption: '迭代目标',
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
              ],
              caption: '迭代基本信息',
              codeName: 'group1',
              detailStyle: 'DEFAULT',
              detailType: 'GROUPPANEL',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
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
      codeName: 'quick_create_view_form',
      controlType: 'FORM',
      logicName: '迭代快速建立视图_表单',
      appDataEntityId: 'plmweb.sprint',
      controlParam: {
        id: 'form',
      },
      modelId: '2029cf424b7f33d8a6928b11a9918a6b',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.sprint.quick_create_view_form',
    },
    {
      codeName: 'update_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.sprint',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'update_view_datainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.SPRINT',
      },
      caption: '编辑迭代',
      codeName: 'update_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.sprint',
      controlParam: {},
      name: 'captionbar',
      id: 'update_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEOPTVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.sprint',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '迭代编辑视图',
  viewStyle: 'DEFAULT',
  viewType: 'DEOPTVIEW',
  width: 800,
  enableDP: true,
  showCaptionBar: true,
  modelId: 'ac36ddcff30f019a7f2c7b5c8fd34f7f',
  modelType: 'PSAPPDEVIEW',
  name: 'sprintupdate_view',
  id: 'plmweb.sprint_update_view',
};