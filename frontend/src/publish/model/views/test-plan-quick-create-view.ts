export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  openMode: 'POPUPMODAL',
  deviewCodeName: 'quick_create_view',
  deviewId: '56a879efc0cd0407bfef2f02f5cd92d6',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.TEST_PLAN',
  },
  caption: '新建测试计划',
  codeName: 'test_plan_quick_create_view',
  height: 570,
  appDataEntityId: 'plmweb.test_plan',
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
        appDataEntityId: 'plmweb.test_plan',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.test_plan',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'get_draft',
        appDataEntityId: 'plmweb.test_plan',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.test_plan',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.test_plan',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.test_plan',
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
                          ruleInfo: '开始时间必须小于等于发布时间',
                          name: '[常规条件] 小于等于(<=) 数据对象属性 (END_AT)',
                          id: '[常规条件] 小于等于(<=) 数据对象属性 (end_at)',
                        },
                      ],
                      condType: 'GROUP',
                      ruleInfo: '开始时间必须小于等于发布时间',
                      name: '[条件组]OR',
                      id: '[条件组]or',
                    },
                  ],
                  condType: 'GROUP',
                  ruleInfo: '开始时间必须小于等于发布时间',
                  name: '[条件组]OR',
                  id: '[条件组]or',
                },
              ],
              condType: 'GROUP',
              ruleInfo: '开始时间必须小于等于发布时间',
              id: '默认组',
            },
            ruleInfo: '开始时间必须小于等于发布时间',
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
                          condOp: 'GTANDEQ',
                          paramType: 'ENTITYFIELD',
                          paramValue: 'START_AT',
                          defname: 'END_AT',
                          condType: 'SIMPLE',
                          ruleInfo: '发布时间必须大于等于开始时间',
                          name: '[常规条件] 大于等于(>=) 数据对象属性 (START_AT)',
                          id: '[常规条件] 大于等于(>=) 数据对象属性 (start_at)',
                        },
                        {
                          condOp: 'ISNULL',
                          defname: 'START_AT',
                          condType: 'SIMPLE',
                          name: '[常规条件] 值为空(Nil)',
                          id: '[常规条件] 值为空(nil)',
                        },
                      ],
                      condType: 'GROUP',
                      ruleInfo: '发布时间必须大于等于开始时间',
                      name: '[条件组]OR',
                      id: '[条件组]or',
                    },
                  ],
                  condType: 'GROUP',
                  ruleInfo: '发布时间必须大于等于开始时间',
                  name: '[条件组]OR',
                  id: '[条件组]or',
                },
              ],
              condType: 'GROUP',
              ruleInfo: '发布时间必须大于等于开始时间',
              id: '默认组',
            },
            ruleInfo: '发布时间必须大于等于开始时间',
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
                    placeHolder: '输入计划名称',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'name',
                  },
                  capLanguageRes: {
                    lanResTag: 'DEF.LNAME.NAME',
                  },
                  caption: '计划名称',
                  codeName: 'name',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colLG: 24,
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'name',
                },
                {
                  dataType: 25,
                  enableCond: 1,
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'library_name',
                  editor: {
                    enablePickupView: true,
                    singleSelect: true,
                    pickupAppViewId: 'plmweb.library_pick_up_view',
                    handlerType: 'PickupText',
                    appDEACModeId: 'default',
                    appDEDataSetId: 'fetch_default',
                    appDataEntityId: 'plmweb.library',
                    enableAC: true,
                    forceSelection: true,
                    showTrigger: true,
                    valueItemName: 'library_id',
                    editorParams: {
                      AC: 'TRUE',
                      PICKUPVIEW: 'TRUE',
                    },
                    editorType: 'PICKER',
                    editorItems: [
                      {
                        id: 'library_id',
                      },
                    ],
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'library_name',
                  },
                  caption: '所属测试库',
                  codeName: 'library_name',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  defdgroupLogics: [
                    {
                      logicCat: 'ITEMENABLE',
                      relatedDetailNames: ['checkid'],
                      groupOP: 'AND',
                      defdlogics: [
                        {
                          condOP: 'ISNULL',
                          defdname: 'checkid',
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
                  id: 'library_name',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'type',
                  editor: {
                    singleSelect: true,
                    appCodeListId: 'plmweb.testmgmt__test_plan_type',
                    editorType: 'DROPDOWNLIST',
                    placeHolder: '选择测试分类',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'type',
                  },
                  needCodeListConfig: true,
                  caption: '测试分类',
                  codeName: 'type',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colLG: 12,
                    colMD: 12,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'type',
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
                      appDEFieldId: 'assignee_name',
                      editor: {
                        singleSelect: true,
                        handlerType: 'PickupText',
                        appDEACModeId: 'member_select',
                        appDEDataSetId: 'fetch_default',
                        appDataEntityId: 'plmweb.library_member',
                        uiactionGroup: {
                          uiactionGroupDetails: [
                            {
                              actionLevel: 100,
                              afterItemType: 'NONE',
                              beforeItemType: 'NONE',
                              caption: '跳转至成员设置',
                              detailType: 'DEUIACTION',
                              uiactionId: 'jump_to_member_set@library_member',
                              tooltip: '跳转至成员设置',
                              showCaption: true,
                              showIcon: true,
                              sysImage: {
                                cssClass: 'fa fa-user-md',
                                glyph: 'xf0f0@FontAwesome',
                              },
                              id: 'u23c0102',
                            },
                          ],
                          appDataEntityId: 'plmweb.library_member',
                          uniqueTag: 'library_member__Usr0311619181',
                          name: '跳转至成员设置',
                          id: 'usr0311619181',
                        },
                        enableAC: true,
                        forceSelection: true,
                        showTrigger: true,
                        valueItemName: 'assignee_id',
                        editorParams: {
                          'SRFNAVPARAM.n_department_id_eq': '%srforgsectorid%',
                          AC: 'TRUE',
                          'SRFNAVPARAM.n_status_eq': '1',
                          TRIGGER: 'TRUE',
                          URL: 'libraries/${context.library}/library_members/fetch_default',
                          PICKUPVIEW: 'FALSE',
                          USERMETHOD: 'post',
                          USERMAP: '{"id":"user_id","name":"name"}',
                          DEPTMAP: '{"id":"id","name":"display_name"}',
                          DEPTMETHOD: 'get',
                          DEPTURL: '/users/fetch_default',
                        },
                        editorStyle: 'PERSONEL_SELECT_LIBRARY',
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
                          {
                            key: 'n_status_eq',
                            value: '1',
                            rawValue: true,
                            id: 'n_status_eq',
                          },
                        ],
                        id: 'assignee_name',
                      },
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
                      appDEFieldId: 'project_name',
                      editor: {
                        enablePickupView: true,
                        singleSelect: true,
                        pickupAppViewId: 'plmweb.project_pick_up_view',
                        handlerType: 'PickupText',
                        appDEACModeId: 'default',
                        appDEDataSetId: 'fetch_main',
                        appDataEntityId: 'plmweb.project',
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
                        placeHolder: '选择关联项目',
                        valueType: 'SIMPLE',
                        editable: true,
                        id: 'project_name',
                      },
                      allowEmpty: true,
                      caption: '关联项目',
                      codeName: 'project_name',
                      detailStyle: 'DEFAULT',
                      detailType: 'FORMITEM',
                      defdgroupLogics: [
                        {
                          logicCat: 'SCRIPTCODE_CHANGE',
                          groupOP: 'AND',
                          defdlogics: [
                            {
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
                      id: 'project_name',
                    },
                    {
                      dataType: 25,
                      enableCond: 3,
                      labelPos: 'TOP',
                      labelWidth: 130,
                      noPrivDisplayMode: 1,
                      appDEFieldId: 'sprint_name',
                      editor: {
                        enablePickupView: true,
                        singleSelect: true,
                        pickupAppViewId: 'plmweb.sprint_pick_up_view',
                        handlerType: 'PickupText',
                        appDEACModeId: 'default',
                        appDEDataSetId: 'fetch_default',
                        appDataEntityId: 'plmweb.sprint',
                        enableAC: true,
                        forceSelection: true,
                        showTrigger: true,
                        valueItemName: 'sprint_id',
                        editorParams: {
                          'SRFNAVCTX.project': '%project_id%',
                          AC: 'TRUE',
                          PICKUPVIEW: 'TRUE',
                        },
                        editorType: 'PICKER',
                        editorItems: [
                          {
                            id: 'sprint_id',
                          },
                        ],
                        placeHolder: '选择关联迭代',
                        valueType: 'SIMPLE',
                        editable: true,
                        navigateContexts: [
                          {
                            key: 'PROJECT',
                            value: 'project_id',
                            name: 'PROJECT',
                            id: 'project',
                          },
                        ],
                        id: 'sprint_name',
                      },
                      resetItemNames: ['project_name'],
                      allowEmpty: true,
                      caption: '关联迭代',
                      codeName: 'sprint_name',
                      detailStyle: 'DEFAULT',
                      detailType: 'FORMITEM',
                      defdgroupLogics: [
                        {
                          logicCat: 'PANELVISIBLE',
                          relatedDetailNames: ['type'],
                          groupOP: 'AND',
                          defdlogics: [
                            {
                              condOP: 'EQ',
                              defdname: 'type',
                              value: '20',
                              logicType: 'SINGLE',
                            },
                          ],
                          logicType: 'GROUP',
                        },
                        {
                          logicCat: 'ITEMENABLE',
                          relatedDetailNames: ['project_name'],
                          groupOP: 'AND',
                          defdlogics: [
                            {
                              condOP: 'ISNOTNULL',
                              defdname: 'project_name',
                              logicType: 'SINGLE',
                            },
                          ],
                          logicType: 'GROUP',
                        },
                      ],
                      layoutPos: {
                        colLG: 24,
                        colMD: 24,
                        layout: 'TABLE_24COL',
                      },
                      showCaption: true,
                      id: 'sprint_name',
                    },
                    {
                      dataType: 25,
                      enableCond: 3,
                      labelPos: 'TOP',
                      labelWidth: 130,
                      noPrivDisplayMode: 1,
                      appDEFieldId: 'release_name',
                      editor: {
                        enablePickupView: true,
                        singleSelect: true,
                        pickupAppViewId: 'plmweb.release_pick_up_view',
                        handlerType: 'PickupText',
                        appDEACModeId: 'default',
                        appDEDataSetId: 'fetch_default',
                        appDataEntityId: 'plmweb.release',
                        enableAC: true,
                        forceSelection: true,
                        showTrigger: true,
                        valueItemName: 'release_id',
                        editorParams: {
                          'SRFNAVCTX.project': '%project_id%',
                          AC: 'TRUE',
                          PICKUPVIEW: 'TRUE',
                        },
                        editorType: 'PICKER',
                        editorItems: [
                          {
                            id: 'release_id',
                          },
                        ],
                        placeHolder: '选择关联发布',
                        valueType: 'SIMPLE',
                        editable: true,
                        navigateContexts: [
                          {
                            key: 'PROJECT',
                            value: 'project_id',
                            name: 'PROJECT',
                            id: 'project',
                          },
                        ],
                        id: 'release_name',
                      },
                      resetItemNames: ['project_name'],
                      allowEmpty: true,
                      caption: '关联发布',
                      codeName: 'release_name',
                      detailStyle: 'DEFAULT',
                      detailType: 'FORMITEM',
                      defdgroupLogics: [
                        {
                          logicCat: 'PANELVISIBLE',
                          relatedDetailNames: ['type'],
                          groupOP: 'AND',
                          defdlogics: [
                            {
                              condOP: 'EQ',
                              defdname: 'type',
                              value: '30',
                              logicType: 'SINGLE',
                            },
                          ],
                          logicType: 'GROUP',
                        },
                        {
                          logicCat: 'ITEMENABLE',
                          relatedDetailNames: ['project_name'],
                          groupOP: 'AND',
                          defdlogics: [
                            {
                              condOP: 'ISNOTNULL',
                              defdname: 'project_name',
                              logicType: 'SINGLE',
                            },
                          ],
                          logicType: 'GROUP',
                        },
                      ],
                      layoutPos: {
                        colLG: 24,
                        colMD: 24,
                        layout: 'TABLE_24COL',
                      },
                      showCaption: true,
                      id: 'release_name',
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
                          'plmweb.test_plan_categories_pick_up_tree_view',
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
                        colLG: 24,
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
                        colLG: 24,
                        colMD: 24,
                        layout: 'TABLE_24COL',
                      },
                      id: 'categories',
                    },
                  ],
                  codeName: 'grouppanel1',
                  detailStyle: 'DEFAULT',
                  detailType: 'GROUPPANEL',
                  layoutPos: {
                    colLG: 24,
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  id: 'grouppanel1',
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
                    placeHolder: '选择开始时间',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'start_at',
                  },
                  valueFormat: 'YYYY-MM-DD',
                  allowEmpty: true,
                  caption: '计划开始',
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
                    placeHolder: '选择结束时间',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'end_at',
                  },
                  valueFormat: 'YYYY-MM-DD',
                  allowEmpty: true,
                  caption: '计划结束',
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
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'end_at',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'LEFT',
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
                    colLG: 12,
                    colMD: 12,
                    layout: 'TABLE_24COL',
                  },
                  id: 'assignee_id',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'LEFT',
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
                  caption: '关联项目',
                  codeName: 'project_id',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colLG: 12,
                    colMD: 12,
                    layout: 'TABLE_24COL',
                  },
                  id: 'project_id',
                },
                {
                  createDV: 'library',
                  createDVT: 'APPDATA',
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'NONE',
                  noPrivDisplayMode: 1,
                  editor: {
                    editorType: 'HIDDEN',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'checkid',
                  },
                  allowEmpty: true,
                  hidden: true,
                  caption: '上下文id',
                  codeName: 'checkid',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colLG: 12,
                    colMD: 12,
                    layout: 'TABLE_24COL',
                  },
                  id: 'checkid',
                },
              ],
              caption: '测试计划基本信息',
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
              appDEFieldId: 'release_id',
              editor: {
                editorType: 'HIDDEN',
                valueType: 'SIMPLE',
                editable: true,
                id: 'release_id',
              },
              allowEmpty: true,
              hidden: true,
              caption: '项目发布标识',
              codeName: 'release_id',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              id: 'release_id',
            },
            {
              dataType: 25,
              enableCond: 3,
              labelPos: 'LEFT',
              labelWidth: 130,
              noPrivDisplayMode: 1,
              appDEFieldId: 'library_id',
              editor: {
                editorType: 'HIDDEN',
                valueType: 'SIMPLE',
                editable: true,
                id: 'library_id',
              },
              allowEmpty: true,
              hidden: true,
              caption: '测试库标识',
              codeName: 'library_id',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              id: 'library_id',
            },
            {
              dataType: 25,
              enableCond: 3,
              labelPos: 'LEFT',
              labelWidth: 130,
              noPrivDisplayMode: 1,
              appDEFieldId: 'sprint_id',
              editor: {
                editorType: 'HIDDEN',
                valueType: 'SIMPLE',
                editable: true,
                id: 'sprint_id',
              },
              allowEmpty: true,
              hidden: true,
              caption: '关联迭代',
              codeName: 'sprint_id',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              id: 'sprint_id',
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
      codeName: 'quick_create_view_form',
      controlType: 'FORM',
      logicName: '测试计划快速建立_表单',
      appDataEntityId: 'plmweb.test_plan',
      controlParam: {
        id: 'form',
      },
      modelId: 'a6da07253192c8ca11e03d77b03d51b4',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.test_plan.quick_create_view_form',
    },
    {
      codeName: 'quick_create_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.test_plan',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'quick_create_view_datainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.TEST_PLAN',
      },
      caption: '新建测试计划',
      codeName: 'quick_create_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.test_plan',
      controlParam: {},
      name: 'captionbar',
      id: 'quick_create_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEOPTVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.test_plan',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '新建测试计划',
  viewStyle: 'DEFAULT',
  viewType: 'DEOPTVIEW',
  width: 800,
  enableDP: true,
  showCaptionBar: true,
  modelId: '113acf6c34a1bbbd2046ecb683458817',
  modelType: 'PSAPPDEVIEW',
  name: 'test_planquick_create_view',
  id: 'plmweb.test_plan_quick_create_view',
};
