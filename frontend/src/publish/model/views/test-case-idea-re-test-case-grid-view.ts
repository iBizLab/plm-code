export default {
  gridRowActiveMode: 1,
  xdataControlName: 'grid',
  loadDefault: true,
  deviewCodeName: 'idea_re_test_case_grid_view',
  deviewId: '2e4df047d261a1d0ae49d007dfd27de0',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.TEST_CASE',
  },
  caption: '用例',
  codeName: 'test_case_idea_re_test_case_grid_view',
  appDataEntityId: 'plmweb.test_case',
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
                      id: 'total',
                    },
                    viewFieldName: 'total',
                    allowEmpty: true,
                    caption: '文本(动态)',
                    itemStyle: 'DEFAULT',
                    itemType: 'FIELD',
                    layoutPos: {
                      shrink: 1,
                      layout: 'FLEX',
                      spacingLeft: 'INNERMEDIUM',
                    },
                    id: 'total',
                  },
                  {
                    rawItem: {
                      caption: '个测试用例',
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
                    showCaption: true,
                    id: 'static_text',
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
                  layout: 'FLEX',
                },
                id: 'container',
              },
            ],
            layout: {
              dir: 'row',
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
            caption: '表格',
            itemStyle: 'DEFAULT',
            itemType: 'CTRLPOS',
            layoutPos: {
              grow: 1,
              shrink: 1,
              layout: 'FLEX',
            },
            showCaption: true,
            id: 'grid',
          },
          {
            editor: {
              enablePickupView: true,
              singleSelect: true,
              pickupAppViewId: 'plmweb.test_case_others_re_mpick_up_view',
              appDEACModeId: 'create_test_case',
              appDEDataSetId: 'fetch_recent_test_case',
              appDataEntityId: 'plmweb.recent',
              uiactionGroup: {
                uiactionGroupDetails: [
                  {
                    actionLevel: 100,
                    afterItemType: 'NONE',
                    beforeItemType: 'NONE',
                    caption: '新建',
                    detailType: 'DEUIACTION',
                    uiactionId: 'create_new_test_case@recent',
                    showCaption: true,
                    showIcon: true,
                    sysImage: {
                      cssClass: 'fa fa-plus',
                      glyph: 'xf067@FontAwesome',
                    },
                    id: 'ua2b3bbd',
                  },
                ],
                appDataEntityId: 'plmweb.recent',
                uniqueTag: 'recent__Usr0122130784',
                name: '新建测试用例',
                id: 'usr0122130784',
              },
              enableAC: true,
              forceSelection: true,
              showTrigger: true,
              editorParams: {
                'srfnavparam.principal_id': '%principal_id%',
                'srfnavparam.size': '20',
                lastlabel: '更多用例',
                AC: 'TRUE',
                toplabel: '最近浏览',
                PICKUPVIEW: 'TRUE',
              },
              editorStyle: 'MANAGE',
              editorType: 'PICKER',
              sysPFPluginId: 'manage',
              placeHolder: '添加关联测试用例，点击确定按钮保存',
              predefinedType: 'FIELD_TEXT_DYNAMIC',
              valueType: 'SIMPLE',
              editable: true,
              navigateParams: [
                {
                  key: 'principal_id',
                  value: 'principal_id',
                  id: 'principal_id',
                },
                {
                  key: 'size',
                  value: '20',
                  rawValue: true,
                  id: 'size',
                },
              ],
              id: 'choose_data',
            },
            allowEmpty: true,
            caption: '文本(动态)',
            itemStyle: 'DEFAULT',
            itemType: 'FIELD',
            layoutPos: {
              shrink: 1,
              layout: 'FLEX',
              spacingBottom: 'INNERMEDIUM',
              spacingLeft: 'INNERMEDIUM',
              spacingRight: 'INNERMEDIUM',
              spacingTop: 'INNERMEDIUM',
            },
            id: 'choose_data',
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
        engineType: 'GridView',
        id: 'engine',
      },
    ],
    appViewLogics: [
      {
        eventNames: 'onMounted',
        logicTrigger: 'VIEWEVENT',
        logicType: 'SCRIPT',
        scriptCode:
          "view.layoutPanel.panelItems.choose_data.state.visible = view.context.srfshowchoose || false;\n\n// 初始化默认隐藏表格\nview.layoutPanel.panelItems.grid.state.keepAlive = true;\nview.layoutPanel.panelItems.grid.state.visible = false;\nconst form = view.getController('form');\nconsole.log('项显示逻辑执行了');\nif (form) {\n    form.evt.on('onFormDetailEvent', event =>{\n        const panelItems = view.layoutPanel.panelItems;\n        if (!panelItems.comment) {\n            return;\n        }\n        if (event.formDetailName === 'tabpage1') {\n            panelItems.comment.state.visible = true;\n        } else {\n            panelItems.comment.state.visible = false;\n        }\n    });\n}\n\n// 初始化隐藏发送和清空按钮\nview.layoutPanel.panelItems.button_calluilogic1.state.visible = false\nview.layoutPanel.panelItems.button_calluilogic.state.visible = false",
        builtinLogic: true,
        id: 'viewmounted',
      },
      {
        eventNames: 'onLoadSuccess',
        logicTrigger: 'VIEWEVENT',
        logicType: 'APPDEUILOGIC',
        appDEUILogicId: 'get_idea_total',
        appDataEntityId: 'plmweb.idea',
        builtinLogic: true,
        id: 'onloadsuccess',
      },
      {
        logicTrigger: 'CUSTOM',
        logicType: 'APPUILOGIC',
        builtinAppUILogic: {
          actionAfterWizard: 'DEFAULT',
          newDataAppView: {
            refAppViewId: 'plmweb.test_case_edit_view',
          },
          appUILogicRefViews: [
            {
              refAppViewId: 'plmweb.test_case_edit_view',
            },
          ],
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
          openDataAppView: {
            openMode: 'POPUPMODAL',
            navigateContexts: [
              {
                key: 'LIBRARY',
                value: 'TEST_LIBRARY_ID',
                name: 'LIBRARY',
                id: 'library',
              },
            ],
            refAppViewId: 'plmweb.test_case_main_view',
          },
          editMode: true,
          appUILogicRefViews: [
            {
              openMode: 'POPUPMODAL',
              navigateContexts: [
                {
                  key: 'LIBRARY',
                  value: 'TEST_LIBRARY_ID',
                  name: 'LIBRARY',
                  id: 'library',
                },
              ],
              refAppViewId: 'plmweb.test_case_main_view',
            },
          ],
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
        realTitle: '用例编辑视图',
        realTitleLanguageRes: {
          lanResTag: 'PAGE.TITLE.TEST_CASE.EDITVIEW',
        },
        refAppViewId: 'plmweb.test_case_edit_view',
        name: 'NEWDATA',
        id: 'newdata',
      },
      {
        openMode: 'POPUPMODAL',
        navigateContexts: [
          {
            key: 'LIBRARY',
            value: 'TEST_LIBRARY_ID',
            name: 'LIBRARY',
            id: 'library',
          },
        ],
        realOpenMode: 'POPUPMODAL',
        realTitle: '用例',
        refAppViewId: 'plmweb.test_case_main_view',
        name: 'EDITDATA',
        id: 'editdata',
      },
    ],
    controls: [
      {
        detoolbarItems: [
          {
            actionLevel: 100,
            noPrivDisplayMode: 2,
            uiactionId: 'others_add_relation_test_case@test_case',
            uiactionTarget: 'NONE',
            valid: true,
            caption: '添加用例',
            itemType: 'DEUIACTION',
            sysImage: {
              cssClass: 'fa fa-plus',
              glyph: 'xf067@FontAwesome',
            },
            tooltip: '添加用例',
            showCaption: true,
            showIcon: true,
            id: 'deuiaction3',
          },
        ],
        toolbarStyle: 'USER',
        xdataControlName: 'grid',
        codeName: 'idea_re_test_case_grid_view_toolbar',
        controlType: 'TOOLBAR',
        logicName: '添加用例',
        appDataEntityId: 'plmweb.test_case',
        controlParam: {
          id: 'toolbar',
        },
        modelId: '854dbf2dc2a8faa68eb23f2dfab451cc',
        modelType: 'PSDETOOLBAR',
        name: 'toolbar',
        id: 'idea_re_test_case_grid_view_toolbar',
      },
      {
        aggMode: 'NONE',
        columnEnableFilter: 2,
        columnEnableLink: 2,
        groupMode: 'NONE',
        degridColumns: [
          {
            clconvertMode: 'NONE',
            dataItemName: 'show_identifier',
            excelCaption: '编号',
            appDEFieldId: 'show_identifier',
            valueType: 'SIMPLE',
            aggMode: 'NONE',
            align: 'LEFT',
            caption: '编号',
            codeName: 'identifier',
            columnType: 'DEFGRIDCOLUMN',
            noPrivDisplayMode: 1,
            width: 150,
            widthUnit: 'PX',
            enableSort: true,
            id: 'identifier',
          },
          {
            clconvertMode: 'NONE',
            dataItemName: 'title',
            excelCaption: '标题',
            appDEFieldId: 'title',
            valueType: 'SIMPLE',
            aggMode: 'NONE',
            align: 'LEFT',
            caption: '标题',
            codeName: 'title',
            columnType: 'DEFGRIDCOLUMN',
            noPrivDisplayMode: 1,
            width: 100,
            widthUnit: 'STAR',
            enableSort: true,
            id: 'title',
          },
          {
            clconvertMode: 'FRONT',
            dataItemName: 'level',
            excelCaption: '重要程度',
            appCodeListId: 'plmweb.testmgmt__test_case_level',
            appDEFieldId: 'level',
            valueType: 'SIMPLE',
            aggMode: 'NONE',
            align: 'LEFT',
            caption: '重要程度',
            codeName: 'level',
            columnType: 'DEFGRIDCOLUMN',
            noPrivDisplayMode: 1,
            width: 150,
            widthUnit: 'PX',
            enableSort: true,
            id: 'level',
          },
          {
            clconvertMode: 'NONE',
            dataItemName: 'maintenance_name',
            excelCaption: '维护人',
            appDEFieldId: 'maintenance_name',
            deuiactionGroup: {
              uiactionGroupDetails: [
                {
                  actionLevel: 100,
                  afterItemType: 'NONE',
                  beforeItemType: 'NONE',
                  caption: '取消关联',
                  detailType: 'DEUIACTION',
                  uiactionId: 'del_relation@test_case',
                  showCaption: true,
                  showIcon: true,
                  sysImage: {
                    cssClass: 'fa fa-unlink',
                    glyph: 'xf127@FontAwesome',
                  },
                  id: 'u08d9a95',
                },
              ],
              appDataEntityId: 'plmweb.test_case',
              uniqueTag: 'test_case__Usr1227538660',
              name: '取消关联',
              id: 'usr1227538660',
            },
            valueType: 'SIMPLE',
            aggMode: 'NONE',
            align: 'LEFT',
            caption: '维护人',
            codeName: 'maintenance_name',
            columnType: 'DEFGRIDCOLUMN',
            noPrivDisplayMode: 1,
            width: 150,
            widthUnit: 'PX',
            enableSort: true,
            id: 'maintenance_name',
          },
        ],
        degridDataItems: [
          {
            appDEFieldId: 'show_identifier',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'show_identifier',
          },
          {
            appDEFieldId: 'title',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'title',
          },
          {
            appDEFieldId: 'level',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'level',
          },
          {
            appDEFieldId: 'maintenance_name',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'maintenance_name',
          },
          {
            appDEFieldId: 'maintenance_id',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'maintenance_id',
          },
          {
            appDEFieldId: 'id',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'srfkey',
          },
          {
            appDEFieldId: 'id',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'srfdataaccaction',
          },
          {
            appDEFieldId: 'test_library_id',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'test_library_id',
          },
          {
            appDEFieldId: 'suite_id',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'suite_id',
          },
          {
            appDEFieldId: 'title',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'srfmajortext',
          },
        ],
        degridEditItems: [
          {
            caption: '标识',
            codeName: 'srfkey',
            enableCond: 3,
            appDEFieldId: 'id',
            editor: {
              editorType: 'HIDDEN',
              valueType: 'SIMPLE',
              editable: true,
              id: 'srfkey',
            },
            allowEmpty: true,
            id: 'srfkey',
          },
        ],
        pagingSize: 1000,
        sortMode: 'REMOTE',
        singleSelect: true,
        fetchControlAction: {
          appDEMethodId: 'fetch_idea_relation_test_case',
          appDataEntityId: 'plmweb.test_case',
          id: 'fetch',
        },
        dedataImportId: 'import_test_case',
        removeControlAction: {
          appDEMethodId: 'remove',
          appDataEntityId: 'plmweb.test_case',
          id: 'remove',
        },
        autoLoad: true,
        showBusyIndicator: true,
        codeName: 'others_relation_case_grid',
        controlType: 'GRID',
        logicName: '其他实体关联用例_表格',
        appDataEntityId: 'plmweb.test_case',
        controlParam: {
          id: 'grid',
        },
        modelId: 'ebd3a28c91c7ca8912ac078389e75fb9',
        modelType: 'PSDEGRID',
        name: 'grid',
        id: 'plmweb.test_case.others_relation_case_grid',
      },
      {
        groupMode: 'SINGLE',
        quickSearchMode: 1,
        enableQuickSearch: true,
        controlType: 'SEARCHBAR',
        appDataEntityId: 'plmweb.test_case',
        controlParam: {
          id: 'searchbar',
        },
        id: 'searchbar',
      },
      {
        capLanguageRes: {
          lanResTag: 'DE.LNAME.TEST_CASE',
        },
        caption: '用例',
        codeName: 'idea_re_test_case_grid_view_captionbar',
        controlType: 'CAPTIONBAR',
        appDataEntityId: 'plmweb.test_case',
        controlParam: {},
        name: 'captionbar',
        id: 'idea_re_test_case_grid_view_captionbar',
      },
    ],
    codeName: 'idea_relation_test_case_grid_view',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: '需求关联用例表格视图布局',
    appDataEntityId: 'plmweb.test_case',
    controlLogics: [
      {
        eventNames: 'onChange',
        itemName: 'CHOOSE_DATA',
        logicTag: 'layoutpanel',
        logicType: 'APPDEUILOGIC',
        appDEUILogicId: 'idea_relation_test_case',
        appDataEntityId: 'plmweb.test_case',
        triggerType: 'CTRLEVENT',
        id: 'logic',
      },
    ],
    controlParam: {},
    modelId: 'e926131c63832bd36476bd0b092cb89a',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'idea_relation_test_case_grid_view',
  },
  title: '产品需求关联用例表格',
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  enableDP: true,
  showCaptionBar: false,
  modelId: '568f13740e7cf4f669be4fd71b44cb52',
  modelType: 'PSAPPDEVIEW',
  name: 'test_caseidea_re_test_case_grid_view',
  id: 'plmweb.test_case_idea_re_test_case_grid_view',
};