export default {
  gridRowActiveMode: 1,
  expandSearchForm: true,
  pickupMode: true,
  xdataControlName: 'grid',
  loadDefault: true,
  deviewCodeName: 'pick_up_grid_view',
  deviewId: 'd73bf5ed3756ada2b9333ff95b5ca0ca',
  accUserMode: 2,
  caption: '选择项目',
  codeName: 'project_pick_up_grid_view',
  appDataEntityId: 'plmweb.project',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'PickupGridView',
      id: 'engine',
    },
  ],
  controls: [
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
                placeHolder: '请输入查询标识',
                valueType: 'SIMPLE',
                editable: true,
                id: 'n_identifier_like',
              },
              allowEmpty: true,
              emptyCaption: true,
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
              appDEFieldId: 'name',
              editor: {
                editorType: 'TEXTBOX',
                placeHolder: '项目名称',
                valueType: 'SIMPLE',
                editable: true,
                id: 'n_name_like',
              },
              allowEmpty: true,
              capLanguageRes: {
                lanResTag: 'CONTROL.DEFSFITEM.PROJECT.N_NAME_LIKE',
              },
              caption: '项目名称',
              codeName: 'n_name_like',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colLG: 8,
                colMD: 8,
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
      codeName: 'default',
      controlType: 'SEARCHFORM',
      logicName: '默认搜索表单',
      appDataEntityId: 'plmweb.project',
      controlParam: {
        id: 'searchform',
      },
      modelId: '657254194c00e46b209f92081042060d',
      modelType: 'PSDEFORM_SEARCHFORM',
      name: 'searchform',
      id: 'plmweb.project.default',
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
          excelCaption: '项目',
          appDEFieldId: 'name',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.NAME',
          },
          caption: '项目',
          codeName: 'name',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'STAR',
          enableSort: true,
          id: 'name',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'identifier',
          excelCaption: '标识',
          appDEFieldId: 'identifier',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.IDENTIFIER',
          },
          caption: '标识',
          codeName: 'identifier',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'PX',
          enableSort: true,
          id: 'identifier',
        },
        {
          clconvertMode: 'FRONT',
          dataItemName: 'type',
          excelCaption: '类型',
          appCodeListId: 'plmweb.projmgmt__project_type',
          appDEFieldId: 'type',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.TYPE',
          },
          caption: '类型',
          codeName: 'type',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 150,
          widthUnit: 'PX',
          enableSort: true,
          id: 'type',
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
          appDEFieldId: 'identifier',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'identifier',
        },
        {
          appDEFieldId: 'type',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'type',
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
      enablePagingBar: true,
      navViewPos: 'NONE',
      fetchControlAction: {
        appDEMethodId: 'fetch_choose_project',
        appDataEntityId: 'plmweb.project',
        id: 'fetch',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.project',
        id: 'remove',
      },
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'choose_project_grid',
      controlType: 'GRID',
      logicName: '选择项目_表格',
      appDataEntityId: 'plmweb.project',
      controlParam: {
        id: 'grid',
      },
      modelId: 'e41e852d9312f34e7f2bb0440c569a25',
      modelType: 'PSDEGRID',
      name: 'grid',
      id: 'plmweb.project.choose_project_grid',
    },
    {
      groupMode: 'SINGLE',
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.project',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      caption: '选择项目',
      codeName: 'pick_up_grid_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.project',
      controlParam: {},
      name: 'captionbar',
      id: 'pick_up_grid_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEPICKUPGRIDVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.project',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '项目选择表格视图',
  viewStyle: 'DEFAULT',
  viewType: 'DEPICKUPGRIDVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '8bff190c4b482bd8c0e623515655d5e3',
  modelType: 'PSAPPDEVIEW',
  name: 'projectpick_up_grid_view',
  id: 'plmweb.project_pick_up_grid_view',
};
