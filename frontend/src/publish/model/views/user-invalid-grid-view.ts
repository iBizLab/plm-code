export default {
  enableRowEdit: true,
  xdataControlName: 'grid',
  loadDefault: true,
  deviewCodeName: 'invalid_grid_view',
  deviewId: '6309d6db5c624e40dd5042419a127857',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.USER',
  },
  caption: '失效帐号管理',
  codeName: 'user_invalid_grid_view',
  appDataEntityId: 'plmweb.user',
  appViewNavParams: [
    {
      rawValue: true,
      key: 'n_status_eq',
      value: '0',
      id: 'n_status_eq',
    },
  ],
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
      {
        caption: '搜索栏',
        itemStyle: 'DEFAULT',
        itemType: 'CTRLPOS',
        layoutPos: {
          shrink: 1,
          layout: 'FLEX',
        },
        showCaption: true,
        id: 'tabsearchbar',
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
        logicTrigger: 'CUSTOM',
        logicType: 'APPUILOGIC',
        builtinAppUILogic: {
          actionAfterWizard: 'DEFAULT',
          newDataAppView: {
            refAppViewId: 'plmweb.user_quick_cfg_view',
          },
          appUILogicRefViews: [
            {
              refAppViewId: 'plmweb.user_quick_cfg_view',
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
            refAppViewId: 'plmweb.user_redirect_view',
          },
          editMode: true,
          appUILogicRefViews: [
            {
              refAppViewId: 'plmweb.user_redirect_view',
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
        realTitle: '设置成员信息',
        refAppViewId: 'plmweb.user_quick_cfg_view',
        name: 'NEWDATA',
        id: 'newdata',
      },
      {
        realTitle: '企业用户数据重定向视图',
        realTitleLanguageRes: {
          lanResTag: 'PAGE.TITLE.USER.REDIRECTVIEW',
        },
        refAppViewId: 'plmweb.user_redirect_view',
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
        degridColumns: [
          {
            clconvertMode: 'NONE',
            dataItemName: 'display_name',
            excelCaption: '姓名',
            appDEFieldId: 'display_name',
            valueType: 'SIMPLE',
            aggMode: 'NONE',
            align: 'LEFT',
            caption: '姓名',
            codeName: 'display_name',
            columnType: 'DEFGRIDCOLUMN',
            noPrivDisplayMode: 1,
            width: 150,
            widthUnit: 'PX',
            enableSort: true,
            id: 'display_name',
          },
          {
            clconvertMode: 'NONE',
            dataItemName: 'name',
            excelCaption: '登录名',
            appDEFieldId: 'name',
            valueType: 'SIMPLE',
            aggMode: 'NONE',
            align: 'LEFT',
            capLanguageRes: {
              lanResTag: 'DEF.LNAME.NAME',
            },
            caption: '登录名',
            codeName: 'name',
            columnType: 'DEFGRIDCOLUMN',
            noPrivDisplayMode: 1,
            width: 150,
            widthUnit: 'PX',
            enableSort: true,
            id: 'name',
          },
          {
            clconvertMode: 'NONE',
            dataItemName: 'employee_number',
            excelCaption: '工号',
            appDEFieldId: 'employee_number',
            valueType: 'SIMPLE',
            aggMode: 'NONE',
            align: 'LEFT',
            caption: '工号',
            codeName: 'employee_number',
            columnType: 'DEFGRIDCOLUMN',
            noPrivDisplayMode: 1,
            width: 200,
            widthUnit: 'PX',
            enableSort: true,
            id: 'employee_number',
          },
          {
            clconvertMode: 'NONE',
            dataItemName: 'mobile',
            excelCaption: '手机号',
            appDEFieldId: 'mobile',
            valueType: 'SIMPLE',
            aggMode: 'NONE',
            align: 'LEFT',
            caption: '手机号',
            codeName: 'mobile',
            columnType: 'DEFGRIDCOLUMN',
            noPrivDisplayMode: 1,
            width: 200,
            widthUnit: 'PX',
            enableSort: true,
            id: 'mobile',
          },
          {
            clconvertMode: 'NONE',
            dataItemName: 'email',
            excelCaption: '邮箱',
            appDEFieldId: 'email',
            valueType: 'SIMPLE',
            aggMode: 'NONE',
            align: 'LEFT',
            caption: '邮箱',
            codeName: 'email',
            columnType: 'DEFGRIDCOLUMN',
            noPrivDisplayMode: 1,
            width: 200,
            widthUnit: 'STAR',
            enableSort: true,
            id: 'email',
          },
          {
            clconvertMode: 'NONE',
            dataItemName: 'department_name',
            excelCaption: '部门',
            appDEFieldId: 'department_name',
            valueType: 'SIMPLE',
            aggMode: 'NONE',
            align: 'LEFT',
            caption: '部门',
            codeName: 'department_name',
            columnType: 'DEFGRIDCOLUMN',
            noPrivDisplayMode: 1,
            width: 200,
            widthUnit: 'PX',
            enableSort: true,
            id: 'department_name',
          },
          {
            clconvertMode: 'NONE',
            dataItemName: 'job_name',
            excelCaption: '职位',
            appDEFieldId: 'job_name',
            valueType: 'SIMPLE',
            aggMode: 'NONE',
            align: 'LEFT',
            caption: '职位',
            codeName: 'job_name',
            columnType: 'DEFGRIDCOLUMN',
            noPrivDisplayMode: 1,
            width: 200,
            widthUnit: 'PX',
            enableSort: true,
            id: 'job_name',
          },
          {
            clconvertMode: 'FRONT',
            dataItemName: 'report_flag',
            excelCaption: '统计',
            appCodeListId: 'plmweb.base__user_report_flag',
            appDEFieldId: 'report_flag',
            valueType: 'SIMPLE',
            enableRowEdit: true,
            aggMode: 'NONE',
            align: 'LEFT',
            caption: '统计',
            codeName: 'report_flag',
            columnType: 'DEFGRIDCOLUMN',
            noPrivDisplayMode: 1,
            width: 100,
            widthUnit: 'PX',
            id: 'report_flag',
          },
          {
            clconvertMode: 'NONE',
            dataItemName: 'create_time',
            excelCaption: '建立时间',
            appDEFieldId: 'create_time',
            valueFormat: 'YYYY-MM-DD HH:mm:ss',
            valueType: 'SIMPLE',
            aggMode: 'NONE',
            align: 'LEFT',
            capLanguageRes: {
              lanResTag: 'DEF.LNAME.CREATE_TIME',
            },
            caption: '建立时间',
            codeName: 'create_time',
            columnType: 'DEFGRIDCOLUMN',
            noPrivDisplayMode: 1,
            width: 200,
            widthUnit: 'PX',
            enableSort: true,
            id: 'create_time',
          },
        ],
        degridDataItems: [
          {
            appDEFieldId: 'display_name',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'display_name',
          },
          {
            appDEFieldId: 'name',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'name',
          },
          {
            appDEFieldId: 'employee_number',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'employee_number',
          },
          {
            appDEFieldId: 'mobile',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'mobile',
          },
          {
            appDEFieldId: 'email',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'email',
          },
          {
            appDEFieldId: 'department_name',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'department_name',
          },
          {
            appDEFieldId: 'job_name',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'job_name',
          },
          {
            appDEFieldId: 'report_flag',
            valueType: 'SIMPLE',
            dataType: 9,
            id: 'report_flag',
          },
          {
            format: 'YYYY-MM-DD HH:mm:ss',
            appDEFieldId: 'create_time',
            valueType: 'SIMPLE',
            dataType: 5,
            id: 'create_time',
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
            appDEFieldId: 'department_id',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'department_id',
          },
          {
            appDEFieldId: 'job_id',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'job_id',
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
            caption: '统计',
            codeName: 'report_flag',
            enableCond: 3,
            appDEFieldId: 'report_flag',
            editor: {
              singleSelect: true,
              appCodeListId: 'plmweb.base__user_report_flag',
              editorType: 'DROPDOWNLIST_100',
              valueType: 'SIMPLE',
              editable: true,
              id: 'report_flag',
            },
            allowEmpty: true,
            needCodeListConfig: true,
            id: 'report_flag',
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
        pagingMode: 1,
        pagingSize: 20,
        sortMode: 'REMOTE',
        enableCustomized: true,
        enablePagingBar: true,
        enableRowEdit: true,
        enableRowNew: true,
        navViewPos: 'NONE',
        createControlAction: {
          appDEMethodId: 'create',
          appDataEntityId: 'plmweb.user',
          id: 'create',
        },
        fetchControlAction: {
          appDEMethodId: 'fetch_default',
          appDataEntityId: 'plmweb.user',
          id: 'fetch',
        },
        getDraftControlAction: {
          appDEMethodId: 'get_draft',
          appDataEntityId: 'plmweb.user',
          id: 'loaddraft',
        },
        getControlAction: {
          appDEMethodId: 'get',
          appDataEntityId: 'plmweb.user',
          id: 'load',
        },
        removeControlAction: {
          appDEMethodId: 'remove',
          appDataEntityId: 'plmweb.user',
          id: 'remove',
        },
        updateControlAction: {
          appDEMethodId: 'update',
          appDataEntityId: 'plmweb.user',
          id: 'update',
        },
        autoLoad: true,
        showBusyIndicator: true,
        controls: [
          {
            detoolbarItems: [
              {
                actionLevel: 100,
                noPrivDisplayMode: 2,
                uiactionId: 'set_report_flag@user',
                uiactionTarget: 'MULTIKEY',
                valid: true,
                caption: '开启统计',
                itemType: 'DEUIACTION',
                sysImage: {
                  cssClass: 'fa fa-sun-o',
                  glyph: 'xf185@FontAwesome',
                },
                tooltip: '开启统计',
                showCaption: true,
                showIcon: true,
                id: 'deuiaction1',
              },
              {
                actionLevel: 100,
                noPrivDisplayMode: 2,
                uiactionId: 'cancel_report_flag@user',
                uiactionTarget: 'MULTIKEY',
                valid: true,
                caption: '停止统计',
                itemType: 'DEUIACTION',
                sysImage: {
                  cssClass: 'fa fa-remove',
                  glyph: 'xf00d@FontAwesome',
                },
                tooltip: '停止统计',
                showCaption: true,
                showIcon: true,
                id: 'deuiaction2',
              },
            ],
            codeName: 'invalid_grid_view_grid_batchtoolbar',
            controlType: 'TOOLBAR',
            logicName: '企业用户管理表格视图_工具栏',
            appDataEntityId: 'plmweb.user',
            controlParam: {
              id: 'grid_batchtoolbar',
            },
            modelId: '924215731158b518ae501c3fb92f16a8',
            modelType: 'PSDETOOLBAR',
            name: 'grid_batchtoolbar',
            id: 'invalid_grid_view_grid_batchtoolbar',
          },
        ],
        codeName: 'main_grid',
        controlType: 'GRID',
        logicName: '企业用户管理表格视图_表格',
        appDataEntityId: 'plmweb.user',
        controlParam: {
          id: 'grid',
        },
        modelId: '7b8681e48aefe9f75b36984ec97a6f22',
        modelType: 'PSDEGRID',
        name: 'grid',
        id: 'plmweb.user.main_grid',
      },
      {
        groupMode: 'SINGLE',
        quickSearchMode: 1,
        enableQuickSearch: true,
        codeName: 'query_search_bar',
        controlType: 'SEARCHBAR',
        logicName: '快速搜索栏',
        appDataEntityId: 'plmweb.user',
        controlParam: {
          ctrlParams: {
            TELEPORTFLAG: 'true',
          },
          id: 'tabsearchbar',
        },
        modelId: '93068F88-6076-43F2-812C-812DB121C63C',
        modelType: 'PSSYSSEARCHBAR',
        name: 'tabsearchbar',
        id: 'plmweb.user.query_search_bar',
      },
      {
        groupMode: 'SINGLE',
        quickSearchMode: 1,
        enableQuickSearch: true,
        controlType: 'SEARCHBAR',
        appDataEntityId: 'plmweb.user',
        controlParam: {
          id: 'searchbar',
        },
        id: 'searchbar',
      },
      {
        capLanguageRes: {
          lanResTag: 'DE.LNAME.USER',
        },
        caption: '失效帐号管理',
        codeName: 'invalid_grid_view_captionbar',
        controlType: 'CAPTIONBAR',
        appDataEntityId: 'plmweb.user',
        controlParam: {},
        name: 'captionbar',
        id: 'invalid_grid_view_captionbar',
      },
    ],
    codeName: 'usr1022568492',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: 'invalid_grid_view表格视图布局',
    appDataEntityId: 'plmweb.user',
    controlParam: {},
    modelId: '71EA85D6-A887-4B1B-94B0-8B429BF2E8B2',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'usr1022568492',
  },
  title: '失效帐号',
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  enableDP: true,
  showCaptionBar: false,
  modelId: 'd8a1e42939b9809b715c62ee8f421978',
  modelType: 'PSAPPDEVIEW',
  name: 'userinvalid_grid_view',
  id: 'plmweb.user_invalid_grid_view',
};