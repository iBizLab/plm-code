export default {
  gridRowActiveMode: 1,
  xdataControlName: 'grid',
  loadDefault: true,
  deviewCodeName: 'idea_re_customer_grid_view',
  deviewId: 'e4f6e77bb0767445fc95f1ad890d34e9',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.CUSTOMER',
  },
  caption: '需求关联客户',
  codeName: 'customer_idea_re_customer_grid_view',
  appDataEntityId: 'plmweb.customer',
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
                      caption: '个客户',
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
                  dir: 'row',
                  layout: 'FLEX',
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
            id: 'view_header_left',
          },
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
                          stepValue: 1,
                          maxValue: 1,
                          editorParams: {
                            maxvalue: '1',
                            showText: 'true',
                            format: '0',
                            textItem: 'score',
                          },
                          editorType: 'SLIDER',
                          editorWidth: 150,
                          predefinedType: 'FIELD_SLIDER',
                          valueType: 'SIMPLE',
                          editable: true,
                          id: 'score_precent',
                        },
                        viewFieldName: 'score_precent',
                        allowEmpty: true,
                        caption: '滑块',
                        contentWidth: 150,
                        itemStyle: 'DEFAULT',
                        itemType: 'FIELD',
                        layoutPos: {
                          shrink: 1,
                          layout: 'FLEX',
                          width: 150,
                          widthMode: 'PX',
                        },
                        panelItemGroupLogics: [
                          {
                            logicCat: 'ITEMENABLE',
                            relatedItemNames: ['score_precent'],
                            groupOP: 'AND',
                            panelItemLogics: [
                              {
                                condOp: 'EQ',
                                dstModelField: 'score_precent',
                                value: '-1',
                                logicType: 'SINGLE',
                                id: '逻辑项',
                              },
                            ],
                            logicType: 'GROUP',
                            id: '面板成员[score_precent][表单项启用]逻辑',
                          },
                        ],
                        width: 150,
                        id: 'score_precent',
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
                    },
                    id: 'container1',
                  },
                  {
                    rawItem: {
                      caption: 'I',
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
                    controlLogics: [
                      {
                        itemName: 'STATIC_TEXT1',
                        logicTag: 'layoutpanel',
                        logicType: 'SCRIPT',
                        scriptCode: 'context.srfreadonly != true',
                        triggerType: 'ITEMVISIBLE',
                        name: 'logic_I',
                        id: 'logic_i',
                      },
                    ],
                    layoutPos: {
                      shrink: 1,
                      layout: 'FLEX',
                    },
                    showCaption: true,
                    id: 'static_text1',
                  },
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
            actionGroupExtractMode: 'ITEM',
            panelItems: [
              {
                editor: {
                  enablePickupView: true,
                  singleSelect: true,
                  appDEACModeId: 'default',
                  appDEDataSetId: 'fetch_idea_notre_customer',
                  appDataEntityId: 'plmweb.customer',
                  enableAC: true,
                  forceSelection: true,
                  showTrigger: true,
                  editorParams: {
                    'srfnavparam.principal_id': '%principal_id%',
                    'srfnavparam.size': '20',
                    AC: 'TRUE',
                    PICKUPVIEW: 'TRUE',
                  },
                  editorStyle: 'MANAGE',
                  editorType: 'PICKER',
                  editorWidth: 90,
                  sysPFPluginId: 'manage',
                  placeHolder: '添加关联客户，点击确定按钮保存',
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
                  id: 'choose_relation_data',
                },
                allowEmpty: true,
                caption: '文本(动态)',
                contentWidth: 90,
                itemStyle: 'DEFAULT',
                itemType: 'FIELD',
                layoutPos: {
                  shrink: 1,
                  layout: 'FLEX',
                  spacingBottom: 'INNERMEDIUM',
                  spacingLeft: 'INNERMEDIUM',
                  spacingRight: 'INNERMEDIUM',
                  spacingTop: 'INNERMEDIUM',
                  width: 90,
                  widthMode: 'PERCENTAGE',
                },
                width: 90,
                id: 'choose_relation_data',
              },
              {
                editor: {
                  singleSelect: true,
                  appCodeListId: 'plmweb.prodmgmt__common_level',
                  editorParams: {
                    type: 'round',
                    value: '10',
                  },
                  editorType: 'DROPDOWNLIST',
                  editorWidth: 10,
                  predefinedType: 'FIELD_DROPDOWNLIST',
                  valueType: 'SIMPLE',
                  editable: true,
                  id: 'choose_level',
                },
                allowEmpty: true,
                caption: '下拉列表框',
                contentWidth: 10,
                itemStyle: 'DEFAULT',
                itemType: 'FIELD',
                layoutPos: {
                  shrink: 1,
                  layout: 'FLEX',
                  spacingBottom: 'INNERMEDIUM',
                  spacingLeft: 'INNERMEDIUM',
                  spacingRight: 'INNERMEDIUM',
                  spacingTop: 'INNERMEDIUM',
                  width: 10,
                  widthMode: 'PERCENTAGE',
                },
                sysCss: {
                  cssName: 'common-level-dropdown',
                },
                width: 10,
                id: 'choose_level',
              },
            ],
            layout: {
              align: 'flex-start',
              dir: 'row',
              layout: 'FLEX',
            },
            dataRegionType: 'INHERIT',
            caption: '容器',
            itemStyle: 'DEFAULT',
            itemType: 'CONTAINER',
            layoutPos: {
              shrink: 1,
              layout: 'FLEX',
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
          "view.layoutPanel.panelItems.choose_data.state.visible = view.context.srfshowchoose || false;\n\n// 初始化默认隐藏表格\nview.layoutPanel.panelItems.grid.state.keepAlive = true;\nview.layoutPanel.panelItems.grid.state.visible = false;\nconst form = view.getController('form');\nif (form) {\n    form.evt.on('onFormDetailEvent', event =>{\n        const panelItems = view.layoutPanel.panelItems;\n        if (!panelItems.comment) {\n            return;\n        }\n        if (event.formDetailName === 'tabpage1') {\n            panelItems.comment.state.visible = true;\n        } else {\n            panelItems.comment.state.visible = false;\n        }\n    });\n}\n\n// 初始化隐藏发送和清空按钮\nview.layoutPanel.panelItems.button_calluilogic1.state.visible = false\nview.layoutPanel.panelItems.button_calluilogic.state.visible = false",
        builtinLogic: true,
        id: 'viewmounted',
      },
      {
        eventNames: 'onLoadSuccess',
        logicTrigger: 'VIEWEVENT',
        logicType: 'APPDEUILOGIC',
        appDEUILogicId: 'get_grid_total',
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
            openMode: 'POPUPMODAL',
            refAppViewId: 'plmweb.customer_quick_create_view',
          },
          appUILogicRefViews: [
            {
              openMode: 'POPUPMODAL',
              refAppViewId: 'plmweb.customer_quick_create_view',
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
                key: 'PRODUCT',
                value: 'product_id',
                name: 'PRODUCT',
                id: 'product',
              },
            ],
            refAppViewId: 'plmweb.customer_main_view',
          },
          editMode: true,
          appUILogicRefViews: [
            {
              openMode: 'POPUPMODAL',
              navigateContexts: [
                {
                  key: 'PRODUCT',
                  value: 'product_id',
                  name: 'PRODUCT',
                  id: 'product',
                },
              ],
              refAppViewId: 'plmweb.customer_main_view',
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
        openMode: 'POPUPMODAL',
        navigateContexts: [
          {
            key: 'PRODUCT',
            value: 'product_id',
            name: 'PRODUCT',
            id: 'product',
          },
        ],
        realOpenMode: 'POPUPMODAL',
        realTitle: '客户实体主视图',
        refAppViewId: 'plmweb.customer_main_view',
        name: 'EDITDATA',
        id: 'editdata',
      },
      {
        realOpenMode: 'POPUPMODAL',
        realTitle: '新建客户',
        refAppViewId: 'plmweb.customer_quick_create_view',
        name: 'NEWDATA',
        id: 'newdata',
      },
    ],
    controls: [
      {
        detoolbarItems: [
          {
            actionLevel: 100,
            noPrivDisplayMode: 2,
            uiactionId: 'other_add_relation_customer@customer',
            uiactionTarget: 'NONE',
            valid: true,
            caption: '添加客户',
            itemType: 'DEUIACTION',
            sysImage: {
              cssClass: 'fa fa-plus',
              glyph: 'xf067@FontAwesome',
            },
            tooltip: '添加客户',
            showCaption: true,
            showIcon: true,
            id: 'deuiaction1',
          },
        ],
        toolbarStyle: 'USER',
        xdataControlName: 'grid',
        codeName: 'idea_re_customer_grid_view_toolbar',
        controlType: 'TOOLBAR',
        logicName: '添加客户',
        appDataEntityId: 'plmweb.customer',
        controlParam: {
          id: 'toolbar',
        },
        modelId: '4cb342fddb3b8fc242bd61e6f07a1489',
        modelType: 'PSDETOOLBAR',
        name: 'toolbar',
        id: 'idea_re_customer_grid_view_toolbar',
      },
      {
        aggMode: 'NONE',
        columnEnableFilter: 2,
        columnEnableLink: 2,
        groupMode: 'NONE',
        degridColumns: [
          {
            clconvertMode: 'NONE',
            dataItemName: 'name',
            excelCaption: '客户名称',
            appDEFieldId: 'name',
            valueType: 'SIMPLE',
            aggMode: 'NONE',
            align: 'LEFT',
            capLanguageRes: {
              lanResTag: 'DEF.LNAME.NAME',
            },
            caption: '客户名称',
            codeName: 'name',
            columnType: 'DEFGRIDCOLUMN',
            noPrivDisplayMode: 1,
            width: 100,
            widthUnit: 'STAR',
            enableSort: true,
            id: 'name',
          },
          {
            clconvertMode: 'FRONT',
            dataItemName: 'categories',
            excelCaption: '类别',
            appCodeListId: 'plmweb.prodmgmt__category',
            appDEFieldId: 'categories',
            valueType: 'SIMPLE',
            enableRowEdit: true,
            aggMode: 'NONE',
            align: 'LEFT',
            caption: '类别',
            codeName: 'categorys',
            columnType: 'DEFGRIDCOLUMN',
            noPrivDisplayMode: 1,
            width: 200,
            widthUnit: 'PX',
            enableSort: true,
            id: 'categorys',
          },
          {
            clconvertMode: 'FRONT',
            dataItemName: 'industry_id',
            excelCaption: '行业',
            appCodeListId: 'plmweb.prodmgmt__customer_sector',
            appDEFieldId: 'industry_id',
            valueType: 'SIMPLE',
            aggMode: 'NONE',
            align: 'LEFT',
            caption: '行业',
            codeName: 'industry_id',
            columnType: 'DEFGRIDCOLUMN',
            noPrivDisplayMode: 1,
            width: 150,
            widthUnit: 'PX',
            enableSort: true,
            id: 'industry_id',
          },
          {
            clconvertMode: 'FRONT',
            dataItemName: 'grade_id',
            excelCaption: '等级',
            appCodeListId: 'plmweb.prodmgmt__customer_level',
            appDEFieldId: 'grade_id',
            deuiactionGroup: {
              uiactionGroupDetails: [
                {
                  actionLevel: 100,
                  afterItemType: 'NONE',
                  beforeItemType: 'NONE',
                  caption: '取消关联',
                  detailType: 'DEUIACTION',
                  uiactionId: 'del_relation@customer',
                  showCaption: true,
                  showIcon: true,
                  sysImage: {
                    cssClass: 'fa fa-unlink',
                    glyph: 'xf127@FontAwesome',
                  },
                  id: 'u0fd50fe',
                },
              ],
              appDataEntityId: 'plmweb.customer',
              uniqueTag: 'customer__Usr0117237114',
              name: '取消关联',
              id: 'usr0117237114',
            },
            valueType: 'SIMPLE',
            aggMode: 'NONE',
            align: 'LEFT',
            caption: '等级',
            codeName: 'grade_id',
            columnType: 'DEFGRIDCOLUMN',
            noPrivDisplayMode: 1,
            width: 150,
            widthUnit: 'PX',
            enableSort: true,
            id: 'grade_id',
          },
        ],
        degridDataItems: [
          {
            appDEFieldId: 'name',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'name',
          },
          {
            appDEFieldId: 'categories',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'categories',
          },
          {
            appDEFieldId: 'industry_id',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'industry_id',
          },
          {
            appDEFieldId: 'grade_id',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'grade_id',
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
            appDEFieldId: 'assignee_id',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'assignee_id',
          },
          {
            appDEFieldId: 'product_id',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'product_id',
          },
          {
            appDEFieldId: 'name',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'srfmajortext',
          },
        ],
        degridEditItems: [
          {
            caption: '类别',
            codeName: 'categorys',
            enableCond: 3,
            appDEFieldId: 'categories',
            editor: {
              enablePickupView: true,
              appDEACModeId: 'default',
              appDEDataSetId: 'fetch_default',
              appDataEntityId: 'plmweb.category',
              forceSelection: true,
              showTrigger: true,
              editorParams: {
                readonly: 'true',
                PICKUPVIEW: 'TRUE',
              },
              editorType: 'ADDRESSPICKUP',
              valueType: 'SIMPLE',
              editable: true,
              readOnly: true,
              id: 'categorys',
            },
            allowEmpty: true,
            id: 'categorys',
          },
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
          appDEMethodId: 'fetch_idea_relation_customer',
          appDataEntityId: 'plmweb.customer',
          id: 'fetch',
        },
        dedataImportId: 'import_customer',
        removeControlAction: {
          appDEMethodId: 'remove',
          appDataEntityId: 'plmweb.customer',
          id: 'remove',
        },
        autoLoad: true,
        showBusyIndicator: true,
        codeName: 'other_re_customer_grid',
        controlType: 'GRID',
        logicName: '其他实体关联客户表格',
        appDataEntityId: 'plmweb.customer',
        controlParam: {
          id: 'grid',
        },
        modelId: '65e6343173e8a295bc27eef5094025c9',
        modelType: 'PSDEGRID',
        name: 'grid',
        id: 'plmweb.customer.other_re_customer_grid',
      },
      {
        groupMode: 'SINGLE',
        quickSearchMode: 1,
        enableQuickSearch: true,
        controlType: 'SEARCHBAR',
        appDataEntityId: 'plmweb.customer',
        controlParam: {
          id: 'searchbar',
        },
        id: 'searchbar',
      },
      {
        capLanguageRes: {
          lanResTag: 'DE.LNAME.CUSTOMER',
        },
        caption: '需求关联客户',
        codeName: 'idea_re_customer_grid_view_captionbar',
        controlType: 'CAPTIONBAR',
        appDataEntityId: 'plmweb.customer',
        controlParam: {},
        name: 'captionbar',
        id: 'idea_re_customer_grid_view_captionbar',
      },
    ],
    codeName: 'idea_re_customer_grid_view',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: '需求关联客户',
    appDataEntityId: 'plmweb.customer',
    controlLogics: [
      {
        eventNames: 'onClick',
        itemName: 'score_precent',
        logicTag: 'layoutpanel',
        logicType: 'APPDEUIACTION',
        appDEUIActionId: 'check_customer_info@idea',
        triggerType: 'CTRLEVENT',
        id: 'check_customer',
      },
      {
        eventNames: 'onChange',
        itemName: 'CHOOSE_RELATION_DATA',
        logicTag: 'layoutpanel',
        logicType: 'APPDEUILOGIC',
        appDEUILogicId: 'idea_relation_customer',
        appDataEntityId: 'plmweb.customer',
        triggerType: 'CTRLEVENT',
        id: 'logic',
      },
      {
        eventNames: 'onSaveSuccess',
        itemName: 'GRID',
        logicTag: 'layoutpanel',
        logicType: 'APPDEUILOGIC',
        appDEUILogicId: 'refresh_counter',
        appDataEntityId: 'plmweb.relation',
        triggerType: 'CTRLEVENT',
        id: 'refresh_form',
      },
    ],
    controlParam: {},
    modelId: '61f0163bec69b4d50cdd4bf6c73fb7db',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'idea_re_customer_grid_view',
  },
  title: '需求关联客户',
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  enableDP: true,
  showCaptionBar: false,
  modelId: '023a4ae51285c34374cd282bb136e8d9',
  modelType: 'PSAPPDEVIEW',
  name: 'customeridea_re_customer_grid_view',
  id: 'plmweb.customer_idea_re_customer_grid_view',
};