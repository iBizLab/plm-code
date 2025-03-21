export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  openMode: 'POPUPMODAL',
  deviewCodeName: 'version_comparison_view',
  deviewId: 'fb10fbd8a81bcd688cff937b22a8b58c',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.TEST_CASE',
  },
  caption: '版本对比',
  codeName: 'test_case_version_comparison_view',
  appDataEntityId: 'plmweb.test_case',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'EditView',
      id: 'engine',
    },
  ],
  controls: [
    {
      createControlAction: {
        appDEMethodId: 'create',
        appDataEntityId: 'plmweb.test_case',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.test_case',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'get_draft',
        appDataEntityId: 'plmweb.test_case',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.test_case',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.test_case',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.test_case',
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
              labelPos: 'LEFT',
              labelWidth: 130,
              noPrivDisplayMode: 1,
              appDEFieldId: 'suite_name',
              editor: {
                enablePickupView: true,
                singleSelect: true,
                pickupAppViewId: 'plmweb.test_suite_pick_up_view',
                handlerType: 'PickupText',
                appDEACModeId: 'default',
                appDEDataSetId: 'fetch_default',
                appDataEntityId: 'plmweb.test_suite',
                enableAC: true,
                forceSelection: true,
                showTrigger: true,
                valueItemName: 'suite_id',
                editorParams: {
                  AC: 'TRUE',
                  PICKUPVIEW: 'TRUE',
                },
                editorType: 'PICKER',
                editorItems: [
                  {
                    id: 'suite_id',
                  },
                ],
                valueType: 'SIMPLE',
                editable: true,
                id: 'suite_name',
              },
              allowEmpty: true,
              caption: '模块',
              codeName: 'suite_name',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'suite_name',
            },
            {
              dataType: 25,
              enableCond: 3,
              labelPos: 'LEFT',
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
              dataType: 25,
              enableCond: 3,
              labelPos: 'LEFT',
              labelWidth: 130,
              noPrivDisplayMode: 1,
              appDEFieldId: 'maintenance_name',
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
                valueItemName: 'MAINTENANCE_ID',
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
                    id: 'maintenance_id',
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
                id: 'maintenance_name',
              },
              allowEmpty: true,
              caption: '维护人',
              codeName: 'maintenance_name',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'maintenance_name',
            },
            {
              dataType: 25,
              enableCond: 3,
              labelPos: 'LEFT',
              labelWidth: 130,
              noPrivDisplayMode: 1,
              appDEFieldId: 'state',
              editor: {
                singleSelect: true,
                appCodeListId: 'plmweb.testmgmt__case_state',
                editorType: 'DROPDOWNLIST',
                valueType: 'SIMPLE',
                editable: true,
                id: 'state',
              },
              needCodeListConfig: true,
              caption: '状态',
              codeName: 'state',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'state',
            },
            {
              dataType: 25,
              enableCond: 3,
              labelPos: 'LEFT',
              labelWidth: 130,
              noPrivDisplayMode: 1,
              appDEFieldId: 'type',
              editor: {
                singleSelect: true,
                appCodeListId: 'plmweb.testmgmt__test_case_type',
                editorType: 'DROPDOWNLIST',
                valueType: 'SIMPLE',
                editable: true,
                id: 'type',
              },
              allowEmpty: true,
              needCodeListConfig: true,
              caption: '用例类型',
              codeName: 'type',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'type',
            },
            {
              dataType: 25,
              enableCond: 3,
              labelPos: 'LEFT',
              labelWidth: 130,
              noPrivDisplayMode: 1,
              appDEFieldId: 'level',
              editor: {
                singleSelect: true,
                appCodeListId: 'plmweb.testmgmt__test_case_level',
                editorType: 'DROPDOWNLIST',
                valueType: 'SIMPLE',
                editable: true,
                id: 'level',
              },
              allowEmpty: true,
              needCodeListConfig: true,
              caption: '重要程度',
              codeName: 'level',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'level',
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
                  labelPos: 'LEFT',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'precondition',
                  editor: {
                    editorType: 'HTMLEDITOR',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'precondition',
                  },
                  allowEmpty: true,
                  caption: '前置条件',
                  codeName: 'precondition',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'precondition',
                },
              ],
              caption: '基本信息',
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
                  appDEFieldId: 'test_type',
                  editor: {
                    singleSelect: true,
                    appCodeListId: 'plmweb.testmgmt__test_case_test_type',
                    editorType: 'DROPDOWNLIST',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'test_type',
                  },
                  allowEmpty: true,
                  needCodeListConfig: true,
                  caption: '测试类型',
                  codeName: 'test_type',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'test_type',
                },
              ],
              caption: '属性',
              codeName: 'grouppanel1',
              detailStyle: 'DEFAULT',
              detailType: 'GROUPPANEL',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'grouppanel1',
            },
            {
              layout: {
                columnCount: 24,
                layout: 'TABLE_24COL',
              },
              deformDetails: [
                {
                  contentType: 'REPEATER',
                  fieldName: 'steps',
                  appDEFieldId: 'steps',
                  layout: {
                    columnCount: 24,
                    layout: 'TABLE_24COL',
                  },
                  deformDetails: [
                    {
                      dataType: 25,
                      enableCond: 3,
                      fieldName: 'name',
                      labelPos: 'LEFT',
                      labelWidth: 130,
                      noPrivDisplayMode: 1,
                      editor: {
                        halign: 'LEFT',
                        valign: 'MIDDLE',
                        wrapMode: 'NOWRAP',
                        editorType: 'SPAN',
                        valueType: 'SIMPLE',
                        editable: true,
                        id: 'step_name',
                      },
                      allowEmpty: true,
                      caption: '名称',
                      codeName: 'step_name',
                      detailStyle: 'DEFAULT',
                      detailType: 'FORMITEM',
                      defdgroupLogics: [
                        {
                          logicCat: 'PANELVISIBLE',
                          relatedDetailNames: ['is_group'],
                          groupOP: 'AND',
                          defdlogics: [
                            {
                              condOP: 'EQ',
                              defdname: 'is_group',
                              value: '1',
                              logicType: 'SINGLE',
                            },
                          ],
                          logicType: 'GROUP',
                        },
                      ],
                      layoutPos: {
                        colMD: 24,
                        layout: 'TABLE_24COL',
                      },
                      repeatContent: true,
                      showCaption: true,
                      id: 'step_name',
                    },
                    {
                      dataType: 25,
                      enableCond: 3,
                      labelPos: 'LEFT',
                      labelWidth: 130,
                      noPrivDisplayMode: 1,
                      editor: {
                        halign: 'LEFT',
                        valign: 'MIDDLE',
                        wrapMode: 'NOWRAP',
                        editorType: 'SPAN',
                        valueType: 'SIMPLE',
                        editable: true,
                        id: 'description',
                      },
                      allowEmpty: true,
                      caption: '步骤描述',
                      codeName: 'description',
                      detailStyle: 'DEFAULT',
                      detailType: 'FORMITEM',
                      defdgroupLogics: [
                        {
                          logicCat: 'PANELVISIBLE',
                          relatedDetailNames: ['is_group'],
                          groupOP: 'AND',
                          defdlogics: [
                            {
                              condOP: 'NOTEQ',
                              defdname: 'is_group',
                              value: '1',
                              logicType: 'SINGLE',
                            },
                          ],
                          logicType: 'GROUP',
                        },
                      ],
                      layoutPos: {
                        colMD: 24,
                        layout: 'TABLE_24COL',
                      },
                      repeatContent: true,
                      showCaption: true,
                      id: 'description',
                    },
                    {
                      dataType: 25,
                      enableCond: 3,
                      labelPos: 'LEFT',
                      labelWidth: 130,
                      noPrivDisplayMode: 1,
                      editor: {
                        halign: 'LEFT',
                        valign: 'MIDDLE',
                        wrapMode: 'NOWRAP',
                        editorType: 'SPAN',
                        valueType: 'SIMPLE',
                        editable: true,
                        id: 'expected_value',
                      },
                      allowEmpty: true,
                      caption: '预期结果',
                      codeName: 'expected_value',
                      detailStyle: 'DEFAULT',
                      detailType: 'FORMITEM',
                      defdgroupLogics: [
                        {
                          logicCat: 'PANELVISIBLE',
                          relatedDetailNames: ['is_group'],
                          groupOP: 'AND',
                          defdlogics: [
                            {
                              condOP: 'NOTEQ',
                              defdname: 'is_group',
                              value: '1',
                              logicType: 'SINGLE',
                            },
                          ],
                          logicType: 'GROUP',
                        },
                      ],
                      layoutPos: {
                        colMD: 24,
                        layout: 'TABLE_24COL',
                      },
                      repeatContent: true,
                      showCaption: true,
                      id: 'expected_value',
                    },
                    {
                      dataType: 25,
                      enableCond: 3,
                      labelPos: 'LEFT',
                      labelWidth: 130,
                      noPrivDisplayMode: 1,
                      editor: {
                        editorType: 'HIDDEN',
                        valueType: 'SIMPLE',
                        editable: true,
                        id: 'is_group',
                      },
                      allowEmpty: true,
                      hidden: true,
                      caption: '是否分组',
                      codeName: 'is_group',
                      detailStyle: 'DEFAULT',
                      detailType: 'FORMITEM',
                      layoutPos: {
                        colMD: 24,
                        layout: 'TABLE_24COL',
                      },
                      repeatContent: true,
                      id: 'is_group',
                    },
                    {
                      dataType: 25,
                      enableCond: 3,
                      labelPos: 'LEFT',
                      labelWidth: 130,
                      noPrivDisplayMode: 1,
                      editor: {
                        editorType: 'HIDDEN',
                        valueType: 'SIMPLE',
                        editable: true,
                        id: 'group_id',
                      },
                      allowEmpty: true,
                      hidden: true,
                      caption: '分组标识',
                      codeName: 'group_id',
                      detailStyle: 'DEFAULT',
                      detailType: 'FORMITEM',
                      layoutPos: {
                        colMD: 24,
                        layout: 'TABLE_24COL',
                      },
                      repeatContent: true,
                      id: 'group_id',
                    },
                    {
                      dataType: 25,
                      enableCond: 3,
                      labelPos: 'LEFT',
                      labelWidth: 130,
                      noPrivDisplayMode: 1,
                      editor: {
                        editorType: 'HIDDEN',
                        valueType: 'SIMPLE',
                        editable: true,
                        id: 'id',
                      },
                      allowEmpty: true,
                      hidden: true,
                      caption: '标识',
                      codeName: 'id',
                      detailStyle: 'DEFAULT',
                      detailType: 'FORMITEM',
                      layoutPos: {
                        colMD: 24,
                        layout: 'TABLE_24COL',
                      },
                      repeatContent: true,
                      id: 'id',
                    },
                  ],
                  caption: '用例步骤',
                  codeName: 'mdctrl1',
                  detailStyle: 'STYLE2',
                  detailType: 'MDCTRL',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  sysPFPluginId: 'case_steps',
                  showCaption: true,
                  id: 'mdctrl1',
                },
              ],
              caption: '用例步骤',
              codeName: 'grouppanel4',
              detailStyle: 'DEFAULT',
              detailType: 'GROUPPANEL',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'grouppanel4',
            },
            {
              layout: {
                columnCount: 24,
                layout: 'TABLE_24COL',
              },
              deformDetails: [
                {
                  contentType: 'REPEATER',
                  layout: {
                    columnCount: 24,
                    layout: 'TABLE_24COL',
                  },
                  deformDetails: [
                    {
                      dataType: 25,
                      enableCond: 3,
                      labelPos: 'NONE',
                      noPrivDisplayMode: 1,
                      editor: {
                        halign: 'LEFT',
                        valign: 'MIDDLE',
                        wrapMode: 'NOWRAP',
                        editorType: 'SPAN',
                        valueType: 'SIMPLE',
                        editable: true,
                        id: 'name',
                      },
                      allowEmpty: true,
                      emptyCaption: true,
                      codeName: 'name',
                      detailStyle: 'DEFAULT',
                      detailType: 'FORMITEM',
                      layoutPos: {
                        colMD: 24,
                        layout: 'TABLE_24COL',
                      },
                      repeatContent: true,
                      id: 'name',
                    },
                  ],
                  codeName: 'attachments',
                  detailStyle: 'DEFAULT',
                  detailType: 'MDCTRL',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'attachments',
                },
              ],
              caption: '附件',
              codeName: 'grouppanel2',
              detailStyle: 'DEFAULT',
              detailType: 'GROUPPANEL',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'grouppanel2',
            },
            {
              layout: {
                columnCount: 24,
                layout: 'TABLE_24COL',
              },
              deformDetails: [
                {
                  appViewId: 'plmweb.relation_test_case_re_idea_list_view',
                  navigateParams: [
                    {
                      key: 'principal_id',
                      value: 'test_case',
                      id: 'principal_id',
                    },
                    {
                      key: 'srfversionid',
                      value: 'cur_version_id',
                      id: 'srfversionid',
                    },
                  ],
                  parentDataJO: {
                    srfparentdename: 'TEST_CASE',
                    SRFPARENTTYPE: 'CUSTOM',
                  },
                  caption: '关联产品需求',
                  codeName: 'druipart1',
                  detailStyle: 'DEFAULT',
                  detailType: 'DRUIPART',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  userTag: 'idea',
                  userTag2: 'show_identifier,title',
                  id: 'druipart1',
                },
                {
                  appViewId: 'plmweb.relation_test_case_re_work_item_list_view',
                  navigateParams: [
                    {
                      key: 'principal_id',
                      value: 'test_case',
                      id: 'principal_id',
                    },
                    {
                      key: 'srfversionid',
                      value: 'cur_version_id',
                      id: 'srfversionid',
                    },
                  ],
                  parentDataJO: {
                    srfparentdename: 'TEST_CASE',
                    SRFPARENTTYPE: 'CUSTOM',
                  },
                  caption: '关联工作项',
                  codeName: 'druipart2',
                  detailStyle: 'DEFAULT',
                  detailType: 'DRUIPART',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  userTag: 'work_item',
                  userTag2: 'show_identifier,title',
                  id: 'druipart2',
                },
                {
                  appViewId: 'plmweb.relation_test_case_re_bug_list_view',
                  navigateParams: [
                    {
                      key: 'principal_id',
                      value: 'test_case',
                      id: 'principal_id',
                    },
                    {
                      key: 'srfversionid',
                      value: 'cur_version_id',
                      id: 'srfversionid',
                    },
                  ],
                  parentDataJO: {
                    srfparentdename: 'TEST_CASE',
                    SRFPARENTTYPE: 'CUSTOM',
                  },
                  caption: '关联缺陷',
                  codeName: 'druipart3',
                  detailStyle: 'DEFAULT',
                  detailType: 'DRUIPART',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  userTag: 'work_item',
                  userTag2: 'show_identifier,title',
                  id: 'druipart3',
                },
              ],
              caption: '关联',
              codeName: 'grouppanel3',
              detailStyle: 'DEFAULT',
              detailType: 'GROUPPANEL',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'grouppanel3',
            },
            {
              dataType: 25,
              enableCond: 3,
              labelPos: 'LEFT',
              labelWidth: 130,
              noPrivDisplayMode: 1,
              appDEFieldId: 'maintenance_id',
              editor: {
                editorType: 'HIDDEN',
                valueType: 'SIMPLE',
                editable: true,
                id: 'maintenance_id',
              },
              allowEmpty: true,
              hidden: true,
              caption: '维护人',
              codeName: 'maintenance_id',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              id: 'maintenance_id',
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
            {
              dataType: 25,
              enableCond: 3,
              labelPos: 'LEFT',
              labelWidth: 130,
              noPrivDisplayMode: 1,
              appDEFieldId: 'suite_id',
              editor: {
                editorType: 'HIDDEN',
                valueType: 'SIMPLE',
                editable: true,
                id: 'suite_id',
              },
              allowEmpty: true,
              hidden: true,
              caption: '用例模块标识',
              codeName: 'suite_id',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              id: 'suite_id',
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
      codeName: 'verison_comparison_form',
      controlStyle: 'FORM_DATA_COMPARISON',
      controlType: 'FORM',
      logicName: '版本对比_表单',
      appDataEntityId: 'plmweb.test_case',
      controlParam: {
        ctrlParams: {
          RESPONSEMAP: '{"id":"id","label":"name"}',
          REQUESTURL: '/versions/fetch_default',
          REQUESTPARAMS: '`${context.test_case}`',
          REQUESTMETHOD: 'post',
        },
        id: 'form',
      },
      sysPFPluginId: 'form_data_comparison',
      modelId: 'e682dca19b94bf89a63b27de65b5d54f',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.test_case.verison_comparison_form',
    },
    {
      codeName: 'version_comparison_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.test_case',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'version_comparison_view_datainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.TEST_CASE',
      },
      caption: '版本对比',
      codeName: 'version_comparison_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.test_case',
      controlParam: {},
      name: 'captionbar',
      id: 'version_comparison_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEEDITVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.test_case',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '用例版本对比视图',
  viewStyle: 'DEFAULT',
  viewType: 'DEEDITVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '4e65bf306b1ac952040f3dfa5377760d',
  modelType: 'PSAPPDEVIEW',
  name: 'test_caseversion_comparison_view',
  id: 'plmweb.test_case_version_comparison_view',
};
