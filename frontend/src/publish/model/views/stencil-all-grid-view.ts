export default {
  gridRowActiveMode: 1,
  xdataControlName: 'grid',
  loadDefault: true,
  deviewCodeName: 'all_grid_view',
  deviewId: '48f7694d54b301f0b56375b7c5571bde',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.STENCIL',
  },
  caption: '页面模板',
  codeName: 'stencil_all_grid_view',
  appDataEntityId: 'plmweb.stencil',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'GridView',
      id: 'engine',
    },
  ],
  appViewLogics: [
    {
      logicTrigger: 'CUSTOM',
      logicType: 'APPUILOGIC',
      builtinAppUILogic: {
        actionAfterWizard: 'DEFAULT',
        newDataAppView: {
          openMode: 'INDEXVIEWTAB_POPUPMODAL',
          refAppViewId: 'plmweb.stencil_model_edit_view',
        },
        appUILogicRefViews: [
          {
            openMode: 'INDEXVIEWTAB_POPUPMODAL',
            refAppViewId: 'plmweb.stencil_model_edit_view',
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
          refAppViewId: 'plmweb.stencil_edit_view',
        },
        editMode: true,
        appUILogicRefViews: [
          {
            openMode: 'POPUPMODAL',
            refAppViewId: 'plmweb.stencil_edit_view',
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
      realOpenMode: 'POPUPMODAL',
      realTitle: '页面模板编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.STENCIL.EDITVIEW',
      },
      refAppViewId: 'plmweb.stencil_edit_view',
      name: 'EDITDATA',
      id: 'editdata',
    },
    {
      openMode: 'INDEXVIEWTAB_POPUPMODAL',
      realOpenMode: 'INDEXVIEWTAB_POPUPMODAL',
      realTitle: '页面模板编辑视图',
      refAppViewId: 'plmweb.stencil_model_edit_view',
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
          uiactionId: 'gridview_newaction',
          valid: true,
          capLanguageRes: {
            lanResTag: 'TBB.TEXT.*.NEW',
          },
          caption: '新建模板',
          itemType: 'DEUIACTION',
          sysImage: {
            cssClass: 'fa fa-plus',
            glyph: 'xf067@FontAwesome',
          },
          tooltip: '新建模板',
          tooltipLanguageRes: {
            lanResTag: 'TBB.TOOLTIP.*.NEW',
          },
          showCaption: true,
          showIcon: true,
          id: 'deuiaction1',
        },
      ],
      xdataControlName: 'grid',
      codeName: 'all_grid_view_toolbar',
      controlType: 'TOOLBAR',
      logicName: '页面模板表格视图（全部）_工具栏',
      appDataEntityId: 'plmweb.stencil',
      controlParam: {
        id: 'toolbar',
      },
      modelId: 'dbd88b988ba4be066de117a4a6baa17b',
      modelType: 'PSDETOOLBAR',
      name: 'toolbar',
      id: 'all_grid_view_toolbar',
    },
    {
      aggMode: 'NONE',
      columnEnableFilter: 2,
      columnEnableLink: 2,
      groupMode: 'NONE',
      groupStyle: 'DEFAULT',
      degridColumns: [
        {
          clconvertMode: 'NONE',
          dataItemName: 'name',
          excelCaption: '模板名称',
          appDEFieldId: 'name',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.NAME',
          },
          caption: '模板名称',
          codeName: 'name',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 300,
          widthUnit: 'STAR',
          enableSort: true,
          id: 'name',
        },
        {
          clconvertMode: 'FRONT',
          dataItemName: 'update_man',
          excelCaption: '更新人',
          appCodeListId: 'plmweb.sysoperator',
          appDEFieldId: 'update_man',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.UPDATE_MAN',
          },
          caption: '更新人',
          codeName: 'update_man',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'PX',
          enableSort: true,
          id: 'update_man',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'update_time',
          excelCaption: '更新时间',
          appDEFieldId: 'update_time',
          valueFormat: 'YYYY年MM月DD日 HH:mm',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.UPDATE_TIME',
          },
          caption: '更新时间',
          codeName: 'update_time',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'PX',
          enableSort: true,
          id: 'update_time',
        },
        {
          deuiactionGroup: {
            uiactionGroupDetails: [
              {
                actionLevel: 100,
                afterItemType: 'NONE',
                beforeItemType: 'NONE',
                detailType: 'DEUIACTION',
                uiactionId: 'gridview_editaction',
                tooltip: '编辑',
                tooltipLanguageRes: {
                  lanResTag: 'TBB.TOOLTIP.*.EDIT',
                },
                showIcon: true,
                sysImage: {
                  cssClass: 'fa fa-edit',
                  glyph: 'xf044@FontAwesome',
                },
                id: 'ubaae24f',
              },
              {
                actionLevel: 100,
                afterItemType: 'NONE',
                beforeItemType: 'NONE',
                detailType: 'DEUIACTION',
                uiactionId: 'delete@stencil',
                tooltip: '删除',
                showIcon: true,
                sysImage: {
                  cssClass: 'fa fa-trash-o',
                  glyph: 'xf014@FontAwesome',
                },
                id: 'u6fac85a',
              },
            ],
            appDataEntityId: 'plmweb.stencil',
            uniqueTag: 'stencil__Usr0312219795',
            name: '表格操作列',
            id: 'usr0312219795',
          },
          aggMode: 'NONE',
          align: 'CENTER',
          caption: '操作',
          codeName: 'uagridcolumn1',
          columnType: 'UAGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 100,
          widthUnit: 'PX',
          id: 'uagridcolumn1',
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
          appDEFieldId: 'update_man',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'update_man',
        },
        {
          format: 'YYYY年MM月DD日 HH:mm',
          appDEFieldId: 'update_time',
          valueType: 'SIMPLE',
          dataType: 5,
          id: 'update_time',
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
          appDEFieldId: 'space_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'space_id',
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
      pagingMode: 1,
      pagingSize: 20,
      sortMode: 'REMOTE',
      enableCustomized: true,
      enablePagingBar: true,
      singleSelect: true,
      navViewPos: 'NONE',
      fetchControlAction: {
        appDEMethodId: 'fetch_no_space_stencil',
        appDataEntityId: 'plmweb.stencil',
        id: 'fetch',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.stencil',
        id: 'remove',
      },
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'all_grid_view_grid',
      controlType: 'GRID',
      logicName: '页面模板表格视图（全部）_表格',
      appDataEntityId: 'plmweb.stencil',
      controlParam: {
        id: 'grid',
      },
      modelId: '3ec62622afb2a986f7cbdc0baedc1538',
      modelType: 'PSDEGRID',
      name: 'grid',
      id: 'plmweb.stencil.all_grid_view_grid',
    },
    {
      searchButtonStyle: 'NONE',
      enableAutoSearch: true,
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
              labelPos: 'NONE',
              noPrivDisplayMode: 1,
              appDEFieldId: 'name',
              editor: {
                editorType: 'TEXTBOX',
                placeHolder: '输入名称搜索',
                valueType: 'SIMPLE',
                editable: true,
                id: 'n_name_like',
              },
              allowEmpty: true,
              emptyCaption: true,
              capLanguageRes: {
                lanResTag: 'CONTROL.DEFSFITEM.STENCIL.N_NAME_LIKE',
              },
              codeName: 'n_name_like',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              id: 'n_name_like',
            },
          ],
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
      codeName: 'all_grid_view_search_form',
      controlType: 'SEARCHFORM',
      logicName: '页面模板表格视图（全部）_搜索表单',
      appDataEntityId: 'plmweb.stencil',
      controlParam: {
        id: 'searchform',
      },
      modelId: 'a1a293471fd5189f903227dbdbd23e22',
      modelType: 'PSDEFORM_SEARCHFORM',
      name: 'searchform',
      id: 'plmweb.stencil.all_grid_view_search_form',
    },
    {
      groupMode: 'SINGLE',
      quickSearchMode: 1,
      enableQuickSearch: true,
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.stencil',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.STENCIL',
      },
      caption: '页面模板',
      codeName: 'all_grid_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.stencil',
      controlParam: {},
      name: 'captionbar',
      id: 'all_grid_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEGRIDVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.stencil',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '页面模板表格视图（全部）',
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: 'e7cc3d8339f132b7bc08547008e4c4aa',
  modelType: 'PSAPPDEVIEW',
  name: 'stencilall_grid_view',
  id: 'plmweb.stencil_all_grid_view',
};
