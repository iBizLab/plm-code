export default {
  deviewCodeName: 'report_survey_custom_view',
  deviewId: '93CDE579-FE51-46DC-AAFE-4128864F52F9',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.TEST_PLAN',
  },
  caption: '报告概览',
  codeName: 'test_plan_report_survey_custom_view',
  appDataEntityId: 'plmweb.test_plan',
  appViewNavParams: [
    {
      key: 'n_id_eq',
      value: 'test_plan',
      id: 'n_id_eq',
    },
  ],
  sysCss: {
    cssName: 'test-plan-report-survey-view',
  },
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
                    actionGroupExtractMode: 'ITEM',
                    panelItems: [
                      {
                        editor: {
                          halign: 'LEFT',
                          renderMode: 'TEXT_DYNAMIC',
                          valign: 'MIDDLE',
                          wrapMode: 'NOWRAP',
                          editorType: 'SPAN',
                          predefinedType: 'FIELD_TEXT_DYNAMIC',
                          valueType: 'SIMPLE',
                          editable: true,
                          id: 'case_count',
                        },
                        viewFieldName: 'case_count',
                        allowEmpty: true,
                        caption: '文本(动态)',
                        itemStyle: 'DEFAULT',
                        itemType: 'FIELD',
                        layoutPos: {
                          colMD: 24,
                          layout: 'TABLE_24COL',
                        },
                        id: 'case_count',
                      },
                      {
                        rawItem: {
                          caption: '用例数',
                          halign: 'LEFT',
                          renderMode: 'TEXT',
                          valign: 'MIDDLE',
                          wrapMode: 'NOWRAP',
                          contentType: 'RAW',
                          predefinedType: 'STATIC_TEXT',
                          id: 'static_text',
                        },
                        caption: '文本',
                        itemStyle: 'DEFAULT',
                        itemType: 'RAWITEM',
                        layoutPos: {
                          colMD: 24,
                          layout: 'TABLE_24COL',
                        },
                        showCaption: true,
                        id: 'static_text',
                      },
                    ],
                    layout: {
                      columnCount: 24,
                      layout: 'TABLE_24COL',
                    },
                    dataRegionType: 'INHERIT',
                    caption: '面板容器',
                    itemStyle: 'DEFAULT',
                    itemType: 'CONTAINER',
                    layoutPos: {
                      grow: 3,
                      shrink: 1,
                      layout: 'SIMPLEFLEX',
                    },
                    id: 'container',
                  },
                  {
                    actionGroupExtractMode: 'ITEM',
                    panelItems: [
                      {
                        actionGroupExtractMode: 'ITEM',
                        panelItems: [
                          {
                            editor: {
                              halign: 'LEFT',
                              renderMode: 'TEXT_DYNAMIC',
                              valign: 'MIDDLE',
                              wrapMode: 'NOWRAP',
                              editorType: 'SPAN',
                              predefinedType: 'FIELD_TEXT_DYNAMIC',
                              valueType: 'SIMPLE',
                              editable: true,
                              id: 'coverage_percentage',
                            },
                            valueFormat: '0.0',
                            viewFieldName: 'Coverage_Percentage',
                            allowEmpty: true,
                            caption: '文本(动态)',
                            itemStyle: 'DEFAULT',
                            itemType: 'FIELD',
                            layoutPos: {
                              shrink: 1,
                              layout: 'FLEX',
                            },
                            id: 'coverage_percentage',
                          },
                          {
                            rawItem: {
                              caption: '%',
                              halign: 'LEFT',
                              renderMode: 'PARAGRAPH',
                              valign: 'MIDDLE',
                              wrapMode: 'NOWRAP',
                              contentType: 'RAW',
                              predefinedType: 'STATIC_LABEL',
                              id: 'coverage_percent',
                            },
                            caption: '百分比符号',
                            itemStyle: 'DEFAULT',
                            itemType: 'RAWITEM',
                            layoutPos: {
                              shrink: 1,
                              layout: 'FLEX',
                            },
                            showCaption: true,
                            id: 'coverage_percent',
                          },
                        ],
                        layout: {
                          align: 'flex-start',
                          dir: 'row',
                          layout: 'FLEX',
                          valign: 'baseline',
                        },
                        dataRegionType: 'INHERIT',
                        caption: '容器',
                        itemStyle: 'DEFAULT',
                        itemType: 'CONTAINER',
                        layoutPos: {
                          colMD: 24,
                          layout: 'TABLE_24COL',
                        },
                        id: 'container4',
                      },
                      {
                        rawItem: {
                          caption: '用例覆盖率',
                          halign: 'LEFT',
                          renderMode: 'TEXT',
                          valign: 'MIDDLE',
                          wrapMode: 'NOWRAP',
                          contentType: 'RAW',
                          predefinedType: 'STATIC_TEXT',
                          id: 'static_text1',
                        },
                        caption: '文本',
                        itemStyle: 'DEFAULT',
                        itemType: 'RAWITEM',
                        layoutPos: {
                          colMD: 24,
                          layout: 'TABLE_24COL',
                        },
                        showCaption: true,
                        id: 'static_text1',
                      },
                    ],
                    layout: {
                      columnCount: 24,
                      layout: 'TABLE_24COL',
                    },
                    dataRegionType: 'INHERIT',
                    caption: '面板容器',
                    itemStyle: 'DEFAULT',
                    itemType: 'CONTAINER',
                    layoutPos: {
                      grow: 3,
                      shrink: 1,
                      layout: 'SIMPLEFLEX',
                    },
                    id: 'container1',
                  },
                  {
                    actionGroupExtractMode: 'ITEM',
                    panelItems: [
                      {
                        actionGroupExtractMode: 'ITEM',
                        panelItems: [
                          {
                            editor: {
                              halign: 'LEFT',
                              renderMode: 'TEXT_DYNAMIC',
                              valign: 'MIDDLE',
                              wrapMode: 'NOWRAP',
                              editorType: 'SPAN',
                              predefinedType: 'FIELD_TEXT_DYNAMIC',
                              valueType: 'SIMPLE',
                              editable: true,
                              id: 'pass_percentage',
                            },
                            valueFormat: '0.0',
                            viewFieldName: 'Pass_Percentage',
                            allowEmpty: true,
                            caption: '文本(动态)',
                            itemStyle: 'DEFAULT',
                            itemType: 'FIELD',
                            layoutPos: {
                              shrink: 1,
                              layout: 'FLEX',
                            },
                            id: 'pass_percentage',
                          },
                          {
                            rawItem: {
                              caption: '%',
                              halign: 'LEFT',
                              renderMode: 'PARAGRAPH',
                              valign: 'MIDDLE',
                              wrapMode: 'NOWRAP',
                              contentType: 'RAW',
                              predefinedType: 'STATIC_LABEL',
                              id: 'pass_percent',
                            },
                            caption: '百分比符号',
                            itemStyle: 'DEFAULT',
                            itemType: 'RAWITEM',
                            layoutPos: {
                              shrink: 1,
                              layout: 'FLEX',
                            },
                            showCaption: true,
                            id: 'pass_percent',
                          },
                        ],
                        layout: {
                          align: 'flex-start',
                          dir: 'row',
                          layout: 'FLEX',
                          valign: 'baseline',
                        },
                        dataRegionType: 'INHERIT',
                        caption: '容器',
                        itemStyle: 'DEFAULT',
                        itemType: 'CONTAINER',
                        layoutPos: {
                          colMD: 24,
                          layout: 'TABLE_24COL',
                        },
                        id: 'container5',
                      },
                      {
                        rawItem: {
                          caption: '用例通过率',
                          halign: 'LEFT',
                          renderMode: 'TEXT',
                          valign: 'MIDDLE',
                          wrapMode: 'NOWRAP',
                          contentType: 'RAW',
                          predefinedType: 'STATIC_TEXT',
                          id: 'static_text2',
                        },
                        caption: '文本',
                        itemStyle: 'DEFAULT',
                        itemType: 'RAWITEM',
                        layoutPos: {
                          colMD: 24,
                          layout: 'TABLE_24COL',
                        },
                        showCaption: true,
                        id: 'static_text2',
                      },
                    ],
                    layout: {
                      columnCount: 24,
                      layout: 'TABLE_24COL',
                    },
                    dataRegionType: 'INHERIT',
                    caption: '面板容器',
                    itemStyle: 'DEFAULT',
                    itemType: 'CONTAINER',
                    layoutPos: {
                      grow: 3,
                      shrink: 1,
                      layout: 'SIMPLEFLEX',
                    },
                    id: 'container2',
                  },
                  {
                    actionGroupExtractMode: 'ITEM',
                    panelItems: [
                      {
                        editor: {
                          halign: 'LEFT',
                          renderMode: 'TEXT_DYNAMIC',
                          valign: 'MIDDLE',
                          wrapMode: 'NOWRAP',
                          editorType: 'SPAN',
                          predefinedType: 'FIELD_TEXT_DYNAMIC',
                          valueType: 'SIMPLE',
                          editable: true,
                          id: 'bug_count',
                        },
                        viewFieldName: 'bug_count',
                        allowEmpty: true,
                        caption: '文本(动态)',
                        itemStyle: 'DEFAULT',
                        itemType: 'FIELD',
                        layoutPos: {
                          colMD: 24,
                          layout: 'TABLE_24COL',
                        },
                        id: 'bug_count',
                      },
                      {
                        rawItem: {
                          caption: '缺陷数',
                          halign: 'LEFT',
                          renderMode: 'TEXT',
                          valign: 'MIDDLE',
                          wrapMode: 'NOWRAP',
                          contentType: 'RAW',
                          predefinedType: 'STATIC_TEXT',
                          id: 'static_text3',
                        },
                        caption: '文本',
                        itemStyle: 'DEFAULT',
                        itemType: 'RAWITEM',
                        layoutPos: {
                          colMD: 24,
                          layout: 'TABLE_24COL',
                        },
                        showCaption: true,
                        id: 'static_text3',
                      },
                    ],
                    layout: {
                      columnCount: 24,
                      layout: 'TABLE_24COL',
                    },
                    dataRegionType: 'INHERIT',
                    caption: '面板容器',
                    itemStyle: 'DEFAULT',
                    itemType: 'CONTAINER',
                    layoutPos: {
                      grow: 3,
                      shrink: 1,
                      layout: 'SIMPLEFLEX',
                    },
                    id: 'container3',
                  },
                ],
                predefinedType: 'CONTAINER_GRID',
                layout: {
                  layout: 'SIMPLEFLEX',
                },
                dataRegionType: 'INHERIT',
                caption: '栅格容器',
                itemStyle: 'DEFAULT',
                itemType: 'CONTAINER',
                layoutPos: {
                  shrink: 1,
                  layout: 'FLEX',
                },
                id: 'container_grid',
              },
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
            predefinedType: 'CONTAINER_SINGLEDATA',
            layout: {
              layout: 'FLEX',
            },
            dataRegionType: 'SINGLEDATA',
            dataSourceType: 'DEACTION',
            appDEMethodId: 'test_plan_report_survey',
            appDataEntityId: 'plmweb.test_plan',
            caption: '单项数据容器',
            itemStyle: 'DEFAULT',
            itemType: 'CONTAINER',
            layoutPos: {
              shrink: 1,
              layout: 'FLEX',
            },
            id: 'container_singledata',
          },
        ],
        layout: {
          dir: 'column',
          layout: 'FLEX',
        },
        dataRegionType: 'INHERIT',
        itemStyle: 'DEFAULT',
        itemType: 'CONTAINER',
        layoutPos: {
          shrink: 1,
          layout: 'FLEX',
        },
        id: 'page_container',
      },
    ],
    layoutPanel: true,
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
                appDEFieldId: 'library_name',
                editor: {
                  halign: 'LEFT',
                  valign: 'MIDDLE',
                  wrapMode: 'NOWRAP',
                  editorType: 'SPAN',
                  valueType: 'SIMPLE',
                  editable: true,
                  id: 'library_name',
                },
                allowEmpty: true,
                caption: '测试库',
                codeName: 'library_name',
                detailStyle: 'DEFAULT',
                detailType: 'FORMITEM',
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
                labelPos: 'LEFT',
                labelWidth: 130,
                noPrivDisplayMode: 1,
                appDEFieldId: 'name',
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
                capLanguageRes: {
                  lanResTag: 'DEF.LNAME.NAME',
                },
                caption: '测试计划',
                codeName: 'name',
                detailStyle: 'DEFAULT',
                detailType: 'FORMITEM',
                layoutPos: {
                  colLG: 12,
                  colMD: 12,
                  layout: 'TABLE_24COL',
                },
                showCaption: true,
                id: 'name',
              },
              {
                dataType: 5,
                enableCond: 3,
                labelPos: 'LEFT',
                labelWidth: 130,
                noPrivDisplayMode: 1,
                appDEFieldId: 'start_at',
                editor: {
                  halign: 'LEFT',
                  valign: 'MIDDLE',
                  wrapMode: 'NOWRAP',
                  editorType: 'SPAN',
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
                labelPos: 'LEFT',
                labelWidth: 130,
                noPrivDisplayMode: 1,
                appDEFieldId: 'end_at',
                editor: {
                  halign: 'LEFT',
                  valign: 'MIDDLE',
                  wrapMode: 'NOWRAP',
                  editorType: 'SPAN',
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
                ignoreInput: 3,
                labelPos: 'LEFT',
                labelWidth: 130,
                noPrivDisplayMode: 1,
                appDEFieldId: 'status',
                editor: {
                  halign: 'LEFT',
                  valign: 'MIDDLE',
                  wrapMode: 'NOWRAP',
                  appCodeListId: 'plmweb.testmgmt__test_plan_status',
                  editorType: 'SPAN',
                  valueType: 'SIMPLE',
                  editable: true,
                  id: 'status',
                },
                allowEmpty: true,
                convertToCodeItemText: true,
                caption: '状态',
                codeName: 'status',
                detailStyle: 'DEFAULT',
                detailType: 'FORMITEM',
                layoutPos: {
                  colLG: 12,
                  colMD: 12,
                  layout: 'TABLE_24COL',
                },
                showCaption: true,
                id: 'status',
              },
              {
                dataType: 25,
                enableCond: 3,
                labelPos: 'LEFT',
                labelWidth: 130,
                noPrivDisplayMode: 1,
                appDEFieldId: 'assignee_name',
                editor: {
                  halign: 'LEFT',
                  valign: 'MIDDLE',
                  wrapMode: 'NOWRAP',
                  editorStyle: 'PERSONNEL_INFO',
                  editorType: 'SPAN',
                  sysPFPluginId: 'personnel_info',
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
                labelPos: 'LEFT',
                labelWidth: 130,
                noPrivDisplayMode: 1,
                appDEFieldId: 'project_name',
                editor: {
                  halign: 'LEFT',
                  valign: 'MIDDLE',
                  wrapMode: 'NOWRAP',
                  editorType: 'SPAN',
                  valueType: 'SIMPLE',
                  editable: true,
                  id: 'project_name',
                },
                allowEmpty: true,
                caption: '关联项目',
                codeName: 'project_name',
                detailStyle: 'DEFAULT',
                detailType: 'FORMITEM',
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
                labelPos: 'LEFT',
                labelWidth: 130,
                noPrivDisplayMode: 1,
                appDEFieldId: 'sprint_name',
                editor: {
                  halign: 'LEFT',
                  valign: 'MIDDLE',
                  wrapMode: 'NOWRAP',
                  editorType: 'SPAN',
                  valueType: 'SIMPLE',
                  editable: true,
                  id: 'sprint_name',
                },
                allowEmpty: true,
                caption: '关联迭代',
                codeName: 'sprint_name',
                detailStyle: 'DEFAULT',
                detailType: 'FORMITEM',
                layoutPos: {
                  colLG: 12,
                  colMD: 12,
                  layout: 'TABLE_24COL',
                },
                showCaption: true,
                id: 'sprint_name',
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
        codeName: 'report_form',
        controlType: 'FORM',
        logicName: '概览表单',
        appDataEntityId: 'plmweb.test_plan',
        controlParam: {
          id: 'form',
        },
        modelId: 'B75C2076-C028-407D-8334-D6C286214409',
        modelType: 'PSDEFORM_EDITFORM',
        name: 'form',
        id: 'plmweb.test_plan.report_form',
      },
      {
        capLanguageRes: {
          lanResTag: 'DE.LNAME.TEST_PLAN',
        },
        caption: '报告概览',
        codeName: 'report_survey_custom_view_captionbar',
        controlType: 'CAPTIONBAR',
        appDataEntityId: 'plmweb.test_plan',
        controlParam: {},
        name: 'captionbar',
        id: 'report_survey_custom_view_captionbar',
      },
    ],
    codeName: 'usr0412899555',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: '报告概览自定义视图布局面板',
    appDataEntityId: 'plmweb.test_plan',
    controlParam: {},
    modelId: '80E5C6CE-ACD3-444B-9199-3889779B358F',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'usr0412899555',
  },
  title: '报告概览',
  viewStyle: 'DEFAULT',
  viewType: 'DECUSTOMVIEW',
  enableDP: true,
  showCaptionBar: false,
  modelId: '03e085432d8cc4b2bd68fca216ba7f0a',
  modelType: 'PSAPPDEVIEW',
  name: 'test_planreport_survey_custom_view',
  id: 'plmweb.test_plan_report_survey_custom_view',
};