export default {
  gridRowActiveMode: 1,
  xdataControlName: 'grid',
  loadDefault: true,
  deviewCodeName: 'event_hook_grid_view',
  deviewId: 'c874422327451be8464b57a3d5de736e',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.PSDENOTIFY',
  },
  caption: '事件通知',
  codeName: 'psde_notify_event_hook_grid_view',
  appDataEntityId: 'plmweb.psdenotify',
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
          openMode: 'POPUPMODAL',
          refAppViewId: 'plmweb.psde_notify_event_hook_edit_view',
        },
        appUILogicRefViews: [
          {
            openMode: 'POPUPMODAL',
            refAppViewId: 'plmweb.psde_notify_event_hook_edit_view',
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
          refAppViewId: 'plmweb.psde_notify_event_hook_edit_view',
        },
        editMode: true,
        appUILogicRefViews: [
          {
            openMode: 'POPUPMODAL',
            refAppViewId: 'plmweb.psde_notify_event_hook_edit_view',
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
  appViewNavParams: [
    {
      key: 'n_psdeid_eq',
      value: 'psdataentity',
      id: 'n_psdeid_eq',
    },
    {
      key: 'n_usertag_eq',
      value: 'notifytag',
      id: 'n_usertag_eq',
    },
    {
      rawValue: true,
      key: 'n_notifysubtype_eq',
      value: 'EVENTHOOK',
      id: 'n_notifysubtype_eq',
    },
  ],
  appViewRefs: [
    {
      realOpenMode: 'POPUPMODAL',
      realTitle: '事件通知',
      refAppViewId: 'plmweb.psde_notify_event_hook_edit_view',
      name: 'NEWDATA',
      id: 'newdata',
    },
    {
      realOpenMode: 'POPUPMODAL',
      realTitle: '事件通知',
      refAppViewId: 'plmweb.psde_notify_event_hook_edit_view',
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
      degridColumns: [
        {
          clconvertMode: 'NONE',
          dataItemName: 'psdenotifyname',
          excelCaption: '通知名称',
          appDEFieldId: 'psdenotifyname',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '通知名称',
          codeName: 'psdenotifyname',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'STAR',
          enableSort: true,
          id: 'psdenotifyname',
        },
        {
          clconvertMode: 'FRONT',
          dataItemName: 'msgtype',
          excelCaption: '通知方式',
          appCodeListId: 'plmweb.extension__wfinfommsgtype',
          appDEFieldId: 'msgtype',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '通知方式',
          codeName: 'msgtype',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 150,
          widthUnit: 'PX',
          enableSort: true,
          id: 'msgtype',
        },
        {
          deuiactionGroup: {
            uiactionGroupDetails: [
              {
                actionLevel: 100,
                afterItemType: 'NONE',
                beforeItemType: 'NONE',
                capLanguageRes: {
                  lanResTag: 'TBB.TEXT.*.REMOVE',
                },
                caption: '删除',
                detailType: 'DEUIACTION',
                uiactionId: 'remove',
                tooltip: '删除',
                tooltipLanguageRes: {
                  lanResTag: 'TBB.TOOLTIP.*.REMOVE',
                },
                showCaption: true,
                id: 'u572ef19',
              },
            ],
            appDataEntityId: 'plmweb.psdenotify',
            uniqueTag: 'PSDENotify__Usr0123619189',
            name: '表格操作栏界面行为组',
            id: 'usr0123619189',
          },
          aggMode: 'NONE',
          align: 'CENTER',
          caption: '操作',
          codeName: 'uagridcolumn1',
          columnType: 'UAGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'PX',
          id: 'uagridcolumn1',
        },
      ],
      degridDataItems: [
        {
          appDEFieldId: 'psdenotifyname',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'psdenotifyname',
        },
        {
          appDEFieldId: 'msgtype',
          valueType: 'SIMPLE',
          dataType: 9,
          id: 'msgtype',
        },
        {
          appDEFieldId: 'psdenotifyid',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'srfkey',
        },
        {
          appDEFieldId: 'psdenotifyid',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'srfdataaccaction',
        },
        {
          appDEFieldId: 'psdenotifyname',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'srfmajortext',
        },
      ],
      degridEditItems: [
        {
          caption: '实体通知标识',
          codeName: 'srfkey',
          enableCond: 3,
          appDEFieldId: 'psdenotifyid',
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
      fetchControlAction: {
        appDEMethodId: 'fetchdefault',
        appDataEntityId: 'plmweb.psdenotify',
        id: 'fetch',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.psdenotify',
        id: 'remove',
      },
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'event_hook',
      controlType: 'GRID',
      logicName: '事件通知',
      appDataEntityId: 'plmweb.psdenotify',
      controlParam: {
        id: 'grid',
      },
      modelId: '40edded5d40639393fdd7e962f98216a',
      modelType: 'PSDEGRID',
      name: 'grid',
      id: 'plmweb.psdenotify.event_hook',
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
            lanResTag: 'CONTROL.DEFORM.PSDENOTIFY.DEFAULT.FORMPAGE.FORMPAGE1',
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
      appDataEntityId: 'plmweb.psdenotify',
      controlParam: {
        id: 'searchform',
      },
      modelId: '87ec72bb7382fc4f3a62883a5461b9f8',
      modelType: 'PSDEFORM_SEARCHFORM',
      name: 'searchform',
      id: 'plmweb.psdenotify.default',
    },
    {
      detoolbarItems: [
        {
          actionLevel: 100,
          noPrivDisplayMode: 2,
          uiactionId: 'new',
          valid: true,
          capLanguageRes: {
            lanResTag: 'TBB.TEXT.*.NEW',
          },
          caption: '新建',
          itemType: 'DEUIACTION',
          sysImage: {
            cssClass: 'fa fa-file-text-o',
            glyph: 'xf0f6@FontAwesome',
          },
          tooltip: '新建',
          tooltipLanguageRes: {
            lanResTag: 'TBB.TOOLTIP.*.NEW',
          },
          showCaption: true,
          showIcon: true,
          id: 'deuiaction1_new',
        },
      ],
      xdataControlName: 'grid',
      codeName: 'event_hook_grid_view_tabtoolbar',
      controlType: 'TOOLBAR',
      logicName: '工具栏模板（只有一个实体界面行为组）',
      appDataEntityId: 'plmweb.psdenotify',
      controlParam: {
        ctrlParams: {
          TELEPORTFLAG: 'true',
        },
        id: 'tabtoolbar',
      },
      modelId: '97b647cbe00cc608f9a368e2d0874c1e',
      modelType: 'PSDETOOLBAR',
      name: 'tabtoolbar',
      id: 'event_hook_grid_view_tabtoolbar',
    },
    {
      groupMode: 'SINGLE',
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.psdenotify',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.PSDENOTIFY',
      },
      caption: '事件通知',
      codeName: 'event_hook_grid_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.psdenotify',
      controlParam: {},
      name: 'captionbar',
      id: 'event_hook_grid_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEGRIDVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.psdenotify',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '事件通知',
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  enableDP: true,
  showCaptionBar: false,
  modelId: 'ec074fdbe7deec98152db461607d4952',
  modelType: 'PSAPPDEVIEW',
  name: 'PSDENotifyevent_hook_grid_view',
  id: 'plmweb.psde_notify_event_hook_grid_view',
};