export default {
  mdctrlActiveMode: 1,
  xdataControlName: 'list',
  loadDefault: true,
  deviewCodeName: 'test_all_list_view',
  deviewId: '656142B2-A65C-40AC-86BE-8D9CAE9095D5',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.ACTIVITIY',
  },
  caption: '全部活动列表（测试）',
  codeName: 'activity_test_all_list_view',
  appDataEntityId: 'plmweb.activity',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'ListView',
      id: 'engine',
    },
  ],
  appViewLogics: [
    {
      eventNames: 'onSelectionChange',
      logicTrigger: 'CTRLEVENT',
      logicType: 'APPDEUILOGIC',
      appDEUILogicId: 'jump_view',
      appDataEntityId: 'plmweb.activity',
      ctrlName: 'list',
      builtinLogic: true,
      name: 'JUMP_VIEW',
      id: 'jump_view',
    },
    {
      logicTrigger: 'CUSTOM',
      logicType: 'APPUILOGIC',
      builtinAppUILogic: {
        actionAfterWizard: 'DEFAULT',
        builtinLogic: true,
        logicType: 'PREDEFINED',
        viewLogicType: 'APP_NEWDATA',
        id: '新建数据',
      },
      builtinLogic: true,
      id: 'newdata',
    },
    {
      logicTrigger: 'CUSTOM',
      logicType: 'APPUILOGIC',
      builtinAppUILogic: {
        editMode: true,
        builtinLogic: true,
        logicType: 'PREDEFINED',
        viewLogicType: 'APP_OPENDATA',
        id: '打开数据',
      },
      builtinLogic: true,
      id: 'opendata',
    },
  ],
  appViewRefs: [
    {
      name: 'NEWDATA',
      id: 'newdata',
    },
    {
      name: 'EDITDATA',
      id: 'editdata',
    },
  ],
  controls: [
    {
      xdataControlName: 'list',
      codeName: 'test_all_list_view_toolbar',
      controlType: 'TOOLBAR',
      logicName: '全部活动列表（测试）_工具栏',
      appDataEntityId: 'plmweb.activity',
      controlParam: {
        id: 'toolbar',
      },
      modelId: '1EC580C1-00A6-4FA5-A8C8-DCB1F8B7D9FD',
      modelType: 'PSDETOOLBAR',
      name: 'toolbar',
      id: 'test_all_list_view_toolbar',
    },
    {
      searchButtonStyle: 'DEFAULT',
      deformPages: [
        {
          layout: {
            columnCount: 24,
            layout: 'TABLE_24COL',
          },
          caption: '常规条件',
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
      codeName: 'test_all_list_view_search_form',
      controlType: 'SEARCHFORM',
      logicName: '全部活动列表（测试）_搜索表单',
      appDataEntityId: 'plmweb.activity',
      controlParam: {
        id: 'searchform',
      },
      modelId: 'A02B84C4-19C3-4C8D-ACEB-5449EF73A7E8',
      modelType: 'PSDEFORM_SEARCHFORM',
      name: 'searchform',
      id: 'plmweb.activity.test_all_list_view_search_form',
    },
    {
      groupMode: 'NONE',
      itemLayoutPanel: {
        layoutMode: 'TABLE_24COL',
        layout: {
          columnCount: 24,
          layout: 'TABLE_24COL',
        },
        rootPanelItems: [
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
                      appCodeListId: 'plmweb.sysoperator',
                      editorStyle: 'PERSONNEL_INFO',
                      editorType: 'SPAN',
                      sysPFPluginId: 'personnel_info',
                      predefinedType: 'FIELD_TEXT_DYNAMIC',
                      valueType: 'SIMPLE',
                      editable: true,
                      id: 'op_person_name',
                    },
                    viewFieldName: 'op_person_name',
                    allowEmpty: true,
                    convertToCodeItemText: true,
                    caption: '文本(动态)',
                    itemStyle: 'DEFAULT',
                    itemType: 'FIELD',
                    layoutPos: {
                      shrink: 1,
                      layout: 'FLEX',
                      spacingRight: 'OUTERMEDIUM',
                    },
                    id: 'op_person_name',
                  },
                  {
                    actionGroupExtractMode: 'ITEM',
                    panelItems: [
                      {
                        rawItem: {
                          caption: '创建了',
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
                          shrink: 1,
                          layout: 'FLEX',
                        },
                        panelItemGroupLogics: [
                          {
                            logicCat: 'PANELVISIBLE',
                            relatedItemNames: ['audit_type'],
                            groupOP: 'AND',
                            panelItemLogics: [
                              {
                                condOp: 'EQ',
                                dstModelField: 'audit_type',
                                value: 'Create',
                                logicType: 'SINGLE',
                                id: '逻辑项',
                              },
                            ],
                            logicType: 'GROUP',
                            id: '面板成员[static_text][面板显示]逻辑',
                          },
                        ],
                        showCaption: true,
                        id: 'static_text',
                      },
                      {
                        rawItem: {
                          caption: '变更了',
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
                          shrink: 1,
                          layout: 'FLEX',
                        },
                        panelItemGroupLogics: [
                          {
                            logicCat: 'PANELVISIBLE',
                            relatedItemNames: ['audit_type'],
                            groupOP: 'AND',
                            panelItemLogics: [
                              {
                                condOp: 'NOTEQ',
                                dstModelField: 'audit_type',
                                value: 'Create',
                                logicType: 'SINGLE',
                                id: '逻辑项',
                              },
                            ],
                            logicType: 'GROUP',
                            id: '面板成员[static_text1][面板显示]逻辑',
                          },
                        ],
                        showCaption: true,
                        id: 'static_text1',
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
                      layout: 'FLEX',
                      spacingRight: 'OUTERSMALL',
                    },
                    id: 'container3',
                  },
                  {
                    actionGroupExtractMode: 'ITEM',
                    panelItems: [
                      {
                        rawItem: {
                          caption: '工作项',
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
                          shrink: 1,
                          layout: 'FLEX',
                        },
                        panelItemGroupLogics: [
                          {
                            logicCat: 'PANELVISIBLE',
                            relatedItemNames: ['object_type'],
                            groupOP: 'AND',
                            panelItemLogics: [
                              {
                                condOp: 'EQ',
                                dstModelField: 'object_type',
                                value: 'WORK_ITEM',
                                logicType: 'SINGLE',
                                id: '逻辑项',
                              },
                            ],
                            logicType: 'GROUP',
                            id: '面板成员[static_text2][面板显示]逻辑',
                          },
                        ],
                        showCaption: true,
                        id: 'static_text2',
                      },
                      {
                        rawItem: {
                          caption: '需求',
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
                          shrink: 1,
                          layout: 'FLEX',
                        },
                        panelItemGroupLogics: [
                          {
                            logicCat: 'PANELVISIBLE',
                            relatedItemNames: ['object_type'],
                            groupOP: 'AND',
                            panelItemLogics: [
                              {
                                condOp: 'EQ',
                                dstModelField: 'object_type',
                                value: 'IDEA',
                                logicType: 'SINGLE',
                                id: '逻辑项',
                              },
                            ],
                            logicType: 'GROUP',
                            id: '面板成员[static_text3][面板显示]逻辑',
                          },
                        ],
                        showCaption: true,
                        id: 'static_text3',
                      },
                      {
                        rawItem: {
                          caption: '工单',
                          halign: 'LEFT',
                          renderMode: 'TEXT',
                          valign: 'MIDDLE',
                          wrapMode: 'NOWRAP',
                          contentType: 'RAW',
                          predefinedType: 'STATIC_TEXT',
                          id: 'static_text4',
                        },
                        caption: '文本',
                        itemStyle: 'DEFAULT',
                        itemType: 'RAWITEM',
                        layoutPos: {
                          shrink: 1,
                          layout: 'FLEX',
                        },
                        panelItemGroupLogics: [
                          {
                            logicCat: 'PANELVISIBLE',
                            relatedItemNames: ['object_type'],
                            groupOP: 'AND',
                            panelItemLogics: [
                              {
                                condOp: 'EQ',
                                dstModelField: 'object_type',
                                value: 'TICKET',
                                logicType: 'SINGLE',
                                id: '逻辑项',
                              },
                            ],
                            logicType: 'GROUP',
                            id: '面板成员[static_text4][面板显示]逻辑',
                          },
                        ],
                        showCaption: true,
                        id: 'static_text4',
                      },
                      {
                        rawItem: {
                          caption: '测试用例',
                          halign: 'LEFT',
                          renderMode: 'TEXT',
                          valign: 'MIDDLE',
                          wrapMode: 'NOWRAP',
                          contentType: 'RAW',
                          predefinedType: 'STATIC_TEXT',
                          id: 'static_text5',
                        },
                        caption: '文本',
                        itemStyle: 'DEFAULT',
                        itemType: 'RAWITEM',
                        layoutPos: {
                          shrink: 1,
                          layout: 'FLEX',
                        },
                        panelItemGroupLogics: [
                          {
                            logicCat: 'PANELVISIBLE',
                            relatedItemNames: ['object_type'],
                            groupOP: 'AND',
                            panelItemLogics: [
                              {
                                condOp: 'EQ',
                                dstModelField: 'object_type',
                                value: 'TEST_CASE',
                                logicType: 'SINGLE',
                                id: '逻辑项',
                              },
                            ],
                            logicType: 'GROUP',
                            id: '面板成员[static_text5][面板显示]逻辑',
                          },
                        ],
                        showCaption: true,
                        id: 'static_text5',
                      },
                      {
                        rawItem: {
                          caption: '执行用例',
                          halign: 'LEFT',
                          renderMode: 'TEXT',
                          valign: 'MIDDLE',
                          wrapMode: 'NOWRAP',
                          contentType: 'RAW',
                          predefinedType: 'STATIC_TEXT',
                          id: 'static_text6',
                        },
                        caption: '文本',
                        itemStyle: 'DEFAULT',
                        itemType: 'RAWITEM',
                        layoutPos: {
                          shrink: 1,
                          layout: 'FLEX',
                        },
                        panelItemGroupLogics: [
                          {
                            logicCat: 'PANELVISIBLE',
                            relatedItemNames: ['object_type'],
                            groupOP: 'AND',
                            panelItemLogics: [
                              {
                                condOp: 'EQ',
                                dstModelField: 'object_type',
                                value: 'RUN',
                                logicType: 'SINGLE',
                                id: '逻辑项',
                              },
                            ],
                            logicType: 'GROUP',
                            id: '面板成员[static_text6][面板显示]逻辑',
                          },
                        ],
                        showCaption: true,
                        id: 'static_text6',
                      },
                      {
                        rawItem: {
                          caption: '客户',
                          halign: 'LEFT',
                          renderMode: 'TEXT',
                          valign: 'MIDDLE',
                          wrapMode: 'NOWRAP',
                          contentType: 'RAW',
                          predefinedType: 'STATIC_TEXT',
                          id: 'static_text7',
                        },
                        caption: '文本',
                        itemStyle: 'DEFAULT',
                        itemType: 'RAWITEM',
                        layoutPos: {
                          shrink: 1,
                          layout: 'FLEX',
                        },
                        panelItemGroupLogics: [
                          {
                            logicCat: 'PANELVISIBLE',
                            relatedItemNames: ['object_type'],
                            groupOP: 'AND',
                            panelItemLogics: [
                              {
                                condOp: 'EQ',
                                dstModelField: 'object_type',
                                value: 'CUSTOMER',
                                logicType: 'SINGLE',
                                id: '逻辑项',
                              },
                            ],
                            logicType: 'GROUP',
                            id: '面板成员[static_text7][面板显示]逻辑',
                          },
                        ],
                        showCaption: true,
                        id: 'static_text7',
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
                      layout: 'FLEX',
                      spacingRight: 'OUTERSMALL',
                    },
                    id: 'container2',
                  },
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
                      id: 'object_id',
                    },
                    viewFieldName: 'object_id',
                    allowEmpty: true,
                    caption: '文本(动态)',
                    itemStyle: 'DEFAULT',
                    itemType: 'FIELD',
                    layoutPos: {
                      shrink: 1,
                      layout: 'FLEX',
                    },
                    id: 'object_id',
                  },
                  {
                    editor: {
                      editorType: 'HIDDEN',
                      predefinedType: 'FIELD_TEXT_DYNAMIC',
                      valueType: 'SIMPLE',
                      editable: true,
                      id: 'audit_type',
                    },
                    viewFieldName: 'audit_type',
                    allowEmpty: true,
                    hidden: true,
                    caption: '文本(动态)',
                    itemType: 'FIELD',
                    layoutPos: {
                      shrink: 1,
                      layout: 'FLEX',
                    },
                    id: 'audit_type',
                  },
                  {
                    editor: {
                      editorType: 'HIDDEN',
                      predefinedType: 'FIELD_TEXT_DYNAMIC',
                      valueType: 'SIMPLE',
                      editable: true,
                      id: 'object_type',
                    },
                    viewFieldName: 'object_type',
                    allowEmpty: true,
                    hidden: true,
                    caption: '文本(动态)',
                    itemType: 'FIELD',
                    layoutPos: {
                      shrink: 1,
                      layout: 'FLEX',
                    },
                    id: 'object_type',
                  },
                ],
                layout: {
                  align: 'flex-start',
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
                  layout: 'FLEX',
                  spacingLeft: 'OUTERMEDIUM',
                },
                id: 'container',
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
                      id: 'create_time',
                    },
                    viewFieldName: 'CREATE_TIME',
                    allowEmpty: true,
                    caption: '文本(动态)',
                    itemStyle: 'DEFAULT',
                    itemType: 'FIELD',
                    layoutPos: {
                      shrink: 1,
                      layout: 'FLEX',
                      spacingTop: 'OUTERMEDIUM',
                    },
                    id: 'create_time',
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
                  layout: 'FLEX',
                  spacingLeft: 'OUTERMEDIUM',
                },
                id: 'container1',
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
              colMD: 24,
              layout: 'TABLE_24COL',
            },
            id: 'page_container',
          },
        ],
        codeName: 'usr0424588412',
        controlType: 'PANEL',
        logicName: 'List_列表项面板',
        appDataEntityId: 'plmweb.activity',
        controlParam: {},
        modelId: 'EF62BCFA-8694-4F3D-ACA9-827E0E8B27F6',
        modelType: 'PSSYSVIEWPANEL',
        name: 'list_itempanel',
        id: 'plmweb.activity.usr0424588412',
      },
      minorSortDir: 'DESC',
      minorSortAppDEFieldId: 'create_time',
      delistDataItems: [
        {
          appDEFieldId: 'id',
          dataType: 25,
          id: 'srfkey',
        },
        {
          appDEFieldId: 'name',
          dataType: 25,
          id: 'srfmajortext',
        },
      ],
      pagingSize: 30,
      showHeader: true,
      createControlAction: {
        appDEMethodId: 'create',
        appDataEntityId: 'plmweb.activity',
        id: 'create',
      },
      fetchControlAction: {
        appDEMethodId: 'fetch_default',
        appDataEntityId: 'plmweb.activity',
        id: 'fetch',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.activity',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.activity',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.activity',
        id: 'update',
      },
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'test_all_list_view_list',
      controlType: 'LIST',
      logicName: 'List',
      appDataEntityId: 'plmweb.activity',
      controlParam: {
        id: 'list',
      },
      modelId: '55FAFD54-206E-4F4C-BF90-72B34E0050E1',
      modelType: 'PSDELIST',
      name: 'list',
      id: 'plmweb.activity.test_all_list_view_list',
    },
    {
      groupMode: 'SINGLE',
      quickSearchMode: 1,
      enableQuickSearch: true,
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.activity',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.ACTIVITIY',
      },
      caption: '全部活动列表（测试）',
      codeName: 'test_all_list_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.activity',
      controlParam: {},
      name: 'captionbar',
      id: 'test_all_list_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDELISTVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.activity',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '全部活动列表（测试）',
  viewStyle: 'DEFAULT',
  viewType: 'DELISTVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: 'd03684e82e20b4fb68f8302cf6c6aec2',
  modelType: 'PSAPPDEVIEW',
  name: 'activitytest_all_list_view',
  id: 'plmweb.activity_test_all_list_view',
};