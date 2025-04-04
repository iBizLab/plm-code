export default {
  gridRowActiveMode: 1,
  xdataControlName: 'grid',
  loadDefault: true,
  deviewCodeName: 'index_my_created_grid_view',
  deviewId: 'c66002d06f75986965666821a0878816',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.WORK_ITEM',
  },
  caption: '我创建的工作项',
  codeName: 'work_item_index_my_created_grid_view',
  appDataEntityId: 'plmweb.work_item',
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
                    rawItem: {
                      content: '<p><span style="color: #ced4d9;">共</span></p>',
                      contentType: 'HTML',
                      predefinedType: 'STATIC_TEXT',
                      id: 'static_text',
                    },
                    caption: '文本',
                    itemStyle: 'DEFAULT',
                    itemType: 'RAWITEM',
                    layoutPos: {
                      shrink: 1,
                      layout: 'FLEX',
                      spacingLeft: 'OUTERSMALL',
                    },
                    showCaption: true,
                    id: 'static_text',
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
                      spacingLeft: 'OUTERSMALL',
                      spacingRight: 'OUTERSMALL',
                    },
                    id: 'total',
                  },
                  {
                    rawItem: {
                      content:
                        '<p><span style="color: #ced4d9;">个工作项</span></p>',
                      contentType: 'HTML',
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
                    showCaption: true,
                    id: 'static_text1',
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
                  spacingBottom: 'OUTERSMALL',
                  spacingLeft: 'OUTERLARGE',
                },
                sysCss: {
                  cssName: 'dashboard_repair_style',
                },
                id: 'container',
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
            caption: '搜索表单',
            itemStyle: 'DEFAULT',
            itemType: 'CTRLPOS',
            layoutPos: {
              shrink: 1,
              layout: 'FLEX',
            },
            showCaption: true,
            id: 'searchform',
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
          shrink: 0,
          layout: 'FLEX',
        },
        id: 'view_searchform',
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
        eventNames: 'onLoadSuccess',
        logicTrigger: 'VIEWEVENT',
        logicType: 'APPDEUILOGIC',
        appDEUILogicId: 'get_table_size',
        appDataEntityId: 'plmweb.product',
        builtinLogic: true,
        name: 'LOGIC',
        id: 'logic',
      },
      {
        logicTrigger: 'CUSTOM',
        logicType: 'APPUILOGIC',
        builtinAppUILogic: {
          actionAfterWizard: 'DEFAULT',
          newDataAppView: {
            refAppViewId: 'plmweb.work_item_edit_view',
          },
          wizardAppView: {
            refAppViewId: 'plmweb.work_item_edit_view',
          },
          enableWizardAdd: true,
          appUILogicRefViews: [
            {
              refAppViewId: 'plmweb.work_item_edit_view',
            },
            {
              refAppViewId: 'plmweb.work_item_edit_view',
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
            openMode: 'INDEXVIEWTAB_POPUPMODAL',
            navigateContexts: [
              {
                key: 'SRFDATATYPE',
                value: 'work_item_type_id',
                name: 'SRFDATATYPE',
                id: 'srfdatatype',
              },
              {
                key: 'PROJECT',
                value: 'project_id',
                name: 'PROJECT',
                id: 'project',
              },
              {
                key: 'WORK_ITEM_TYPE_ID',
                value: 'work_item_type_id',
                name: 'WORK_ITEM_TYPE_ID',
                id: 'work_item_type_id',
              },
            ],
            navigateParams: [
              {
                key: 'srfdatatype',
                value: 'work_item_type_id',
                id: 'srfdatatype',
              },
            ],
            refAppViewId: 'plmweb.work_item_dyna_main_view',
          },
          editMode: true,
          appUILogicRefViews: [
            {
              openMode: 'INDEXVIEWTAB_POPUPMODAL',
              navigateContexts: [
                {
                  key: 'SRFDATATYPE',
                  value: 'work_item_type_id',
                  name: 'SRFDATATYPE',
                  id: 'srfdatatype',
                },
                {
                  key: 'PROJECT',
                  value: 'project_id',
                  name: 'PROJECT',
                  id: 'project',
                },
                {
                  key: 'WORK_ITEM_TYPE_ID',
                  value: 'work_item_type_id',
                  name: 'WORK_ITEM_TYPE_ID',
                  id: 'work_item_type_id',
                },
              ],
              navigateParams: [
                {
                  key: 'srfdatatype',
                  value: 'work_item_type_id',
                  id: 'srfdatatype',
                },
              ],
              refAppViewId: 'plmweb.work_item_dyna_main_view',
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
        realTitle: '工作项编辑视图',
        realTitleLanguageRes: {
          lanResTag: 'PAGE.TITLE.WORK_ITEM.EDITVIEW',
        },
        refAppViewId: 'plmweb.work_item_edit_view',
        name: 'NEWDATA',
        id: 'newdata',
      },
      {
        openMode: 'INDEXVIEWTAB_POPUPMODAL',
        navigateContexts: [
          {
            key: 'SRFDATATYPE',
            value: 'work_item_type_id',
            name: 'SRFDATATYPE',
            id: 'srfdatatype',
          },
          {
            key: 'PROJECT',
            value: 'project_id',
            name: 'PROJECT',
            id: 'project',
          },
          {
            key: 'WORK_ITEM_TYPE_ID',
            value: 'work_item_type_id',
            name: 'WORK_ITEM_TYPE_ID',
            id: 'work_item_type_id',
          },
        ],
        navigateParams: [
          {
            key: 'srfdatatype',
            value: 'work_item_type_id',
            id: 'srfdatatype',
          },
        ],
        realOpenMode: 'INDEXVIEWTAB_POPUPMODAL',
        realTitle: '工作项（动态）',
        refAppViewId: 'plmweb.work_item_dyna_main_view',
        name: 'EDITDATA',
        id: 'editdata',
      },
    ],
    controls: [
      {
        aggMode: 'NONE',
        columnEnableFilter: 2,
        columnEnableLink: 2,
        groupMode: 'NONE',
        groupStyle: 'DEFAULT',
        orderValueAppDEFieldId: 'sequence',
        degridColumns: [
          {
            clconvertMode: 'FRONT',
            dataItemName: 'work_item_type_id',
            excelCaption: '工作项类型',
            appCodeListId: 'plmweb.projmgmt__work_item_type',
            appDEFieldId: 'work_item_type_id',
            valueType: 'SIMPLE',
            aggMode: 'NONE',
            align: 'LEFT',
            caption: '工作项类型',
            codeName: 'work_item_type_id',
            columnType: 'DEFGRIDCOLUMN',
            noPrivDisplayMode: 1,
            sysPFPluginId: 'icon_gridcolumn',
            width: 40,
            widthUnit: 'PX',
            enableSort: true,
            id: 'work_item_type_id',
          },
          {
            clconvertMode: 'NONE',
            dataItemName: 'show_identifier',
            excelCaption: '编号',
            appDEFieldId: 'show_identifier',
            valueType: 'SIMPLE',
            aggMode: 'NONE',
            align: 'LEFT',
            caption: '编号',
            codeName: 'show_identifier',
            columnType: 'DEFGRIDCOLUMN',
            noPrivDisplayMode: 1,
            width: 150,
            widthUnit: 'PX',
            enableSort: true,
            id: 'show_identifier',
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
            cellSysCss: {
              cssName: 'td_a_link',
            },
            codeName: 'title',
            columnType: 'DEFGRIDCOLUMN',
            noPrivDisplayMode: 1,
            width: 250,
            widthUnit: 'STAR',
            enableSort: true,
            id: 'title',
          },
          {
            clconvertMode: 'FRONT',
            dataItemName: 'state',
            excelCaption: '状态',
            appCodeListId: 'plmweb.projmgmt__work_item_state',
            appDEFieldId: 'state',
            valueType: 'SIMPLE',
            aggMode: 'NONE',
            align: 'LEFT',
            caption: '状态',
            codeName: 'state',
            columnType: 'DEFGRIDCOLUMN',
            noPrivDisplayMode: 1,
            width: 100,
            widthUnit: 'PX',
            enableSort: true,
            id: 'state',
          },
          {
            clconvertMode: 'NONE',
            dataItemName: 'project_name',
            excelCaption: '所属项目',
            appDEFieldId: 'project_name',
            valueType: 'SIMPLE',
            aggMode: 'NONE',
            align: 'RIGHT',
            caption: '所属项目',
            cellSysCss: {
              cssName: 'td_right',
            },
            codeName: 'project_name',
            columnType: 'DEFGRIDCOLUMN',
            noPrivDisplayMode: 1,
            width: 200,
            widthUnit: 'PX',
            enableSort: true,
            id: 'project_name',
          },
        ],
        degridDataItems: [
          {
            appDEFieldId: 'work_item_type_id',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'work_item_type_id',
          },
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
            appDEFieldId: 'state',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'state',
          },
          {
            appDEFieldId: 'project_name',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'project_name',
          },
          {
            appDEFieldId: 'project_id',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'project_id',
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
            appDEFieldId: 'work_item_type_id',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'srfdatatype',
          },
          {
            appDEFieldId: 'pid',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'pid',
          },
          {
            appDEFieldId: 'sprint_id',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'sprint_id',
          },
          {
            appDEFieldId: 'board_id',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'board_id',
          },
          {
            appDEFieldId: 'entry_id',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'entry_id',
          },
          {
            appDEFieldId: 'swimlane_id',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'swimlane_id',
          },
          {
            appDEFieldId: 'top_id',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'top_id',
          },
          {
            appDEFieldId: 'release_id',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'release_id',
          },
          {
            appDEFieldId: 'title',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'srfmajortext',
          },
          {
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'srfmstag',
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
        pagingSize: 10,
        sortMode: 'REMOTE',
        enableCustomized: true,
        forceFit: true,
        hideHeader: true,
        singleSelect: true,
        navViewPos: 'NONE',
        fetchControlAction: {
          appDEMethodId: 'fetch_my_created',
          appDataEntityId: 'plmweb.work_item',
          id: 'fetch',
        },
        dedataImportId: 'import_work_item_waterfall',
        removeControlAction: {
          appDEMethodId: 'remove',
          appDataEntityId: 'plmweb.work_item',
          id: 'remove',
        },
        autoLoad: true,
        showBusyIndicator: true,
        codeName: 'my_created_work_item_grid_index',
        controlType: 'GRID',
        logicName: '我创建的工作项首页表格',
        appDataEntityId: 'plmweb.work_item',
        controlParam: {
          id: 'grid',
        },
        modelId: '534470fd56c4400373fc9e51843f56f4',
        modelType: 'PSDEGRID',
        name: 'grid',
        id: 'plmweb.work_item.my_created_work_item_grid_index',
      },
      {
        detoolbarItems: [
          {
            actionLevel: 100,
            buttonStyle: 'STYLE2',
            noPrivDisplayMode: 2,
            uiactionId: 'open_more_my_create@work_item',
            uiactionTarget: 'NONE',
            valid: true,
            caption: '更多',
            itemType: 'DEUIACTION',
            sysCss: {
              cssName: 'swap_icon_text',
            },
            sysImage: {
              rawContent:
                '<?xml version="1.0" standalone="no"?><!DOCTYPE svg PUBLIC "-//W3C//DTD SVG 1.1//EN" "http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd"><svg t="1732774437860" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="11278" width="12" height="12" xmlns:xlink="http://www.w3.org/1999/xlink"><path d="M767.369846 526.099692a47.261538 47.261538 0 0 0-13.705846-29.538461L328.940308 71.837538a47.419077 47.419077 0 1 0-67.032616 67.032616l391.640616 391.640615-391.640616 391.719385a47.419077 47.419077 0 1 0 66.953846 67.032615l424.802462-424.723692a47.261538 47.261538 0 0 0 13.705846-29.459692z" fill="#999999" p-id="11279"></path></svg>',
            },
            tooltip: '查看更多工作项',
            showCaption: true,
            showIcon: true,
            id: 'deuiaction1',
          },
        ],
        xdataControlName: 'grid',
        codeName: 'index_my_created_grid_view_toolbar',
        controlType: 'TOOLBAR',
        logicName: '我创建的工作项工具栏',
        appDataEntityId: 'plmweb.work_item',
        controlParam: {
          id: 'toolbar',
        },
        modelId: '34bc1e081b196c96d2c776c1c27dfe72',
        modelType: 'PSDETOOLBAR',
        name: 'toolbar',
        id: 'index_my_created_grid_view_toolbar',
      },
      {
        groupMode: 'SINGLE',
        controlType: 'SEARCHBAR',
        appDataEntityId: 'plmweb.work_item',
        controlParam: {
          id: 'searchbar',
        },
        id: 'searchbar',
      },
      {
        capLanguageRes: {
          lanResTag: 'DE.LNAME.WORK_ITEM',
        },
        caption: '我创建的工作项',
        codeName: 'index_my_created_grid_view_captionbar',
        controlType: 'CAPTIONBAR',
        appDataEntityId: 'plmweb.work_item',
        controlParam: {},
        name: 'captionbar',
        id: 'index_my_created_grid_view_captionbar',
      },
    ],
    codeName: 'usr1127548022',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: 'index_my_created_grid_view表格视图布局',
    appDataEntityId: 'plmweb.work_item',
    controlParam: {},
    modelId: 'da47ce49cfa82a22b9e78c6ab30ccfcc',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'usr1127548022',
  },
  title: '我创建的工作项',
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '87d9cd4709da8c5cdb02f36c4d223593',
  modelType: 'PSAPPDEVIEW',
  name: 'work_itemindex_my_created_grid_view',
  id: 'plmweb.work_item_index_my_created_grid_view',
};
