export default {
  gridRowActiveMode: 1,
  expandSearchForm: true,
  pickupMode: true,
  xdataControlName: 'grid',
  loadDefault: true,
  deviewCodeName: 're_self_mpick_up_grid_view',
  deviewId: '200206afab4b886f74d10d2e56503f3f',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.WORK_ITEM',
  },
  caption: '工作项',
  codeName: 'work_item_re_self_mpick_up_grid_view',
  appDataEntityId: 'plmweb.work_item',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'PickupGridView',
      id: 'engine',
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
          width: 150,
          widthUnit: 'STAR',
          enableSort: true,
          id: 'title',
        },
      ],
      degridDataItems: [
        {
          appDEFieldId: 'title',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'title',
        },
        {
          appDEFieldId: 'id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'id',
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
          appDEFieldId: 'state',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'state',
        },
        {
          appDEFieldId: 'assignee_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'assignee_id',
        },
        {
          appDEFieldId: 'project_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'project_id',
        },
        {
          appDEFieldId: 'work_item_type_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'srfdatatype',
        },
        {
          appDEFieldId: 'work_item_type_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'work_item_type_id',
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
      pagingMode: 1,
      pagingSize: 20,
      sortMode: 'REMOTE',
      enableCustomized: true,
      enablePagingBar: true,
      navViewPos: 'NONE',
      fetchControlAction: {
        appDEMethodId: 'fetch_not_exsists_relation',
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
      codeName: 're_self_mpickup_view_pickup_grid_view_grid',
      controlStyle: 'CHECKBOX_GRID',
      controlType: 'GRID',
      logicName: '工作项关联工作项多项选择视图_选择数据视图_表格',
      appDataEntityId: 'plmweb.work_item',
      controlParam: {
        id: 'grid',
      },
      sysPFPluginId: 'checkbox_grid',
      modelId: 'a89245f44e126f230f5a65e92675620c',
      modelType: 'PSDEGRID',
      name: 'grid',
      id: 'plmweb.work_item.re_self_mpickup_view_pickup_grid_view_grid',
    },
    {
      searchButtonStyle: 'DEFAULT',
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
              appDEFieldId: 'identifier',
              editor: {
                editorType: 'TEXTBOX',
                placeHolder: '请输入查询编号',
                valueType: 'SIMPLE',
                editable: true,
                id: 'n_identifier_like',
              },
              allowEmpty: true,
              caption: '编号',
              codeName: 'n_identifier_like',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colLG: 8,
                colMD: 8,
                layout: 'TABLE_24COL',
              },
              id: 'n_identifier_like',
            },
            {
              dataType: 25,
              enableCond: 3,
              labelPos: 'NONE',
              noPrivDisplayMode: 1,
              appDEFieldId: 'title',
              editor: {
                editorType: 'TEXTBOX',
                placeHolder: '标题',
                valueType: 'SIMPLE',
                editable: true,
                id: 'n_title_like',
              },
              allowEmpty: true,
              caption: '标题',
              codeName: 'n_title_like',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colLG: 8,
                colMD: 8,
                layout: 'TABLE_24COL',
              },
              id: 'n_title_like',
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
      codeName: 'choose_search_form',
      controlType: 'SEARCHFORM',
      logicName: '工作项选择视图_搜索表单',
      appDataEntityId: 'plmweb.work_item',
      controlParam: {
        id: 'searchform',
      },
      modelId: '3bc81178ebb00e652c430a221700382f',
      modelType: 'PSDEFORM_SEARCHFORM',
      name: 'searchform',
      id: 'plmweb.work_item.choose_search_form',
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
      caption: '工作项',
      codeName: 're_self_mpick_up_grid_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.work_item',
      controlParam: {},
      name: 'captionbar',
      id: 're_self_mpick_up_grid_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEPICKUPGRIDVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.work_item',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '工作项关联工作项多项选择视图_选择数据视图',
  viewStyle: 'DEFAULT',
  viewType: 'DEPICKUPGRIDVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '50e4053ef5070395ed7c1ec37aada738',
  modelType: 'PSAPPDEVIEW',
  name: 'work_itemre_self_mpick_up_grid_view',
  id: 'plmweb.work_item_re_self_mpick_up_grid_view',
};
