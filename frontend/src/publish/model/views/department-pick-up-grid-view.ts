export default {
  gridRowActiveMode: 1,
  expandSearchForm: true,
  pickupMode: true,
  xdataControlName: 'grid',
  loadDefault: true,
  deviewCodeName: 'pick_up_grid_view',
  deviewId: '6ca0553d7ed6ef9a90d5de128da84eee',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.DEPARTMENT',
  },
  caption: '部门',
  codeName: 'department_pick_up_grid_view',
  appDataEntityId: 'plmweb.department',
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
      degridColumns: [
        {
          clconvertMode: 'NONE',
          dataItemName: 'name',
          excelCaption: '名称',
          appDEFieldId: 'name',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.NAME',
          },
          caption: '名称',
          codeName: 'name',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 150,
          widthUnit: 'PX',
          enableSort: true,
          id: 'name',
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
          appDEFieldId: 'head_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'head_id',
        },
        {
          appDEFieldId: 'parent_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'parent_id',
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
      fetchControlAction: {
        appDEMethodId: 'fetch_default',
        appDataEntityId: 'plmweb.department',
        id: 'fetch',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.department',
        id: 'remove',
      },
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'main',
      controlType: 'GRID',
      logicName: '主表格',
      appDataEntityId: 'plmweb.department',
      controlParam: {
        id: 'grid',
      },
      modelId: '9a309aaaad16f2ad65364a88cc3d1282',
      modelType: 'PSDEGRID',
      name: 'grid',
      id: 'plmweb.department.main',
    },
    {
      searchButtonStyle: 'DEFAULT',
      deformPages: [
        {
          layout: {
            columnCount: 24,
            layout: 'TABLE_24COL',
          },
          capLanguageRes: {
            lanResTag: 'CONTROL.DEFORM.DEPARTMENT.DEFAULT.FORMPAGE.FORMPAGE1',
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
      codeName: 'default',
      controlType: 'SEARCHFORM',
      logicName: '默认搜索表单',
      appDataEntityId: 'plmweb.department',
      controlParam: {
        id: 'searchform',
      },
      modelId: 'd89252a6dfd66abe6ed3f88bdce38d46',
      modelType: 'PSDEFORM_SEARCHFORM',
      name: 'searchform',
      id: 'plmweb.department.default',
    },
    {
      groupMode: 'SINGLE',
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.department',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.DEPARTMENT',
      },
      caption: '部门',
      codeName: 'pick_up_grid_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.department',
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
    appDataEntityId: 'plmweb.department',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '部门选择表格视图',
  titleLanguageRes: {
    lanResTag: 'PAGE.TITLE.DEPARTMENT.PICKUPGRIDVIEW',
  },
  viewStyle: 'DEFAULT',
  viewType: 'DEPICKUPGRIDVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: 'c22aa2957ce6266a4bd3bc525aec42e5',
  modelType: 'PSAPPDEVIEW',
  name: 'departmentpick_up_grid_view',
  id: 'plmweb.department_pick_up_grid_view',
};