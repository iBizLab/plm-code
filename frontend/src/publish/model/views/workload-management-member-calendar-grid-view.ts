export default {
  expandSearchForm: true,
  xdataControlName: 'grid',
  loadDefault: true,
  deviewCodeName: 'management_member_calendar_grid_view',
  deviewId: '9f6aec6065ca8bee47abc290f144ee58',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.WORKLOAD',
  },
  caption: '工时',
  codeName: 'workload_management_member_calendar_grid_view',
  appDataEntityId: 'plmweb.workload',
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
                caption: '搜索栏',
                itemStyle: 'DEFAULT',
                itemType: 'CTRLPOS',
                layoutPos: {
                  shrink: 1,
                  layout: 'FLEX',
                },
                showCaption: true,
                id: 'searchbar',
              },
            ],
            layout: {
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
            id: 'view_header_right',
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
              dir: 'row-reverse',
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
        eventNames: 'onBeforeLoadDraft',
        logicTrigger: 'CTRLEVENT',
        logicType: 'SCRIPT',
        ctrlName: 'searchform',
        scriptCode:
          "const time = new Date();\r\nconst preTime = new Date(time.getTime() - 604800000);\r\nconst n_register_date_gtandeq = preTime.getFullYear() +'-' +(preTime.getMonth() + 1 < 10 ? '0' + (preTime.getMonth() + 1): preTime.getMonth() + 1) +'-' +(preTime.getDate() < 10 ? '0' + preTime.getDate() : preTime.getDate()) \r\nconst n_register_date_ltandeq = time.getFullYear() +'-' +(time.getMonth() + 1 < 10 ? '0' + (time.getMonth() + 1): time.getMonth() + 1) +'-' +(time.getDate() < 10 ? '0' + time.getDate() : time.getDate())\r\nconst date_range = n_register_date_gtandeq + ',' + n_register_date_ltandeq;\r\nObject.assign(viewParam, { n_register_date_gtandeq, n_register_date_ltandeq, date_range });",
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
            refAppViewId: 'plmweb.workload_edit_view',
          },
          appUILogicRefViews: [
            {
              refAppViewId: 'plmweb.workload_edit_view',
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
            refAppViewId: 'plmweb.workload_redirect_view',
          },
          editMode: true,
          appUILogicRefViews: [
            {
              refAppViewId: 'plmweb.workload_redirect_view',
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
        realTitle: '工时编辑视图',
        realTitleLanguageRes: {
          lanResTag: 'PAGE.TITLE.WORKLOAD.EDITVIEW',
        },
        refAppViewId: 'plmweb.workload_edit_view',
        name: 'NEWDATA',
        id: 'newdata',
      },
      {
        realTitle: '工时数据重定向视图',
        realTitleLanguageRes: {
          lanResTag: 'PAGE.TITLE.WORKLOAD.REDIRECTVIEW',
        },
        refAppViewId: 'plmweb.workload_redirect_view',
        name: 'EDITDATA',
        id: 'editdata',
      },
    ],
    controls: [
      {
        aggMode: 'NONE',
        columnEnableFilter: 2,
        columnEnableLink: 2,
        groupMode: 'AUTO',
        groupAppDEFieldId: 'create_man',
        groupCodeListId: 'plmweb.sysoperator',
        groupStyle: 'DEFAULT',
        degridColumns: [
          {
            clconvertMode: 'FRONT',
            dataItemName: 'create_man',
            excelCaption: '登记人',
            appCodeListId: 'plmweb.sysoperator',
            appDEFieldId: 'create_man',
            valueType: 'SIMPLE',
            aggMode: 'NONE',
            align: 'LEFT',
            capLanguageRes: {
              lanResTag: 'DEF.LNAME.CREATE_MAN',
            },
            caption: '登记人',
            codeName: 'create_man',
            columnType: 'DEFGRIDCOLUMN',
            noPrivDisplayMode: 1,
            width: 150,
            widthUnit: 'STAR',
            userParam: {
              DEFAULTSORT: 'asc',
            },
            id: 'create_man',
          },
          {
            clconvertMode: 'NONE',
            dataItemName: 'duration',
            excelCaption: '总登记时长',
            appDEFieldId: 'duration',
            deuiactionId: 'member_duration_link@workload',
            valueFormat: '#0.0',
            valueType: 'SIMPLE',
            aggMode: 'NONE',
            align: 'RIGHT',
            caption: '总登记时长',
            codeName: 'duration',
            columnType: 'DEFGRIDCOLUMN',
            noPrivDisplayMode: 1,
            width: 150,
            widthUnit: 'PX',
            id: 'duration',
          },
        ],
        degridDataItems: [
          {
            appDEFieldId: 'create_man',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'create_man',
          },
          {
            format: '#0.0',
            appDEFieldId: 'duration',
            valueType: 'SIMPLE',
            dataType: 6,
            id: 'duration',
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
            appDEFieldId: 'type_id',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'type_id',
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
        enableGroup: true,
        enablePagingBar: true,
        singleSelect: true,
        navViewPos: 'NONE',
        fetchControlAction: {
          appDEMethodId: 'fetch_member_dimension',
          appDataEntityId: 'plmweb.workload',
          id: 'fetch',
        },
        controlNavParams: [
          {
            key: 'n_create_man_eq',
            value: 'create_man',
            id: 'n_create_man_eq',
          },
          {
            key: 'n_register_date_eq',
            value: 'date',
            id: 'n_register_date_eq',
          },
        ],
        removeControlAction: {
          appDEMethodId: 'remove',
          appDataEntityId: 'plmweb.workload',
          id: 'remove',
        },
        autoLoad: true,
        showBusyIndicator: true,
        codeName: 'member_calendar_grid',
        controlStyle: 'WORKLOAD_TABLE',
        controlType: 'GRID',
        logicName: '工时日历_人员表格',
        appDataEntityId: 'plmweb.workload',
        controlParam: {
          ctrlParams: {
            'SRFNAVPARAM.N_CREATE_MAN_EQ': '%create_man%',
            DATERANGE: 'date_range',
            'SRFNAVPARAM.N_REGISTER_DATE_EQ': '%date%',
            OPENVIEW: 'workload_day_link_management_grid_view',
          },
          id: 'grid',
        },
        sysPFPluginId: 'workload_table',
        modelId: 'dcd35c51510ef565d59b1ee77a99f6a5',
        modelType: 'PSDEGRID',
        name: 'grid',
        id: 'plmweb.workload.member_calendar_grid',
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
                editor: {
                  editorParams: {
                    TIMEFMT: 'YYYY-MM-DD',
                  },
                  editorType: 'DATERANGE_NOTIME',
                  editorItems: [
                    {
                      id: 'n_register_date_gtandeq',
                    },
                    {
                      id: 'n_register_date_ltandeq',
                    },
                  ],
                  valueType: 'SIMPLE',
                  editable: true,
                  id: 'date_range',
                },
                allowEmpty: true,
                caption: '工作日期',
                codeName: 'date_range',
                detailStyle: 'DEFAULT',
                detailType: 'FORMITEM',
                controlAttributes: [
                  {
                    attrName: 'disabledDate',
                    attrValue:
                      "(time) => {\r\n    const searchForm = view.ctx.controllersMap.get('searchform');\r\n    if (!searchForm) {\r\n        return false;\r\n    }\r\n\r\n    const formItem = searchForm.formItems.find((item) => item.model.codeName === 'date_range');\r\n    if(!formItem) {\r\n        return false;\r\n    }\r\n\r\n    // 获取日期弹框内选择日期的选中值t\r\n    const dateRange = formItem.editor.dateRange;\r\n    if (!dateRange || dateRange && dateRange.length === 0) {\r\n        return false;\r\n    }\r\n\r\n    const currentTime = dateRange[0];\r\n    currentTime.setHours(0, 0, 0, 0);\r\n    time.setHours(0, 0, 0, 0);\r\n\r\n    const beforeDays = new Date(\r\n        currentTime.getTime() - 31 * 24 * 60 * 60 * 1000,\r\n    );\r\n    const afterDays = new Date(\r\n        currentTime.getTime() + 31 * 24 * 60 * 60 * 1000,\r\n    );\r\n\r\n    return (\r\n        beforeDays.getTime() >= time.getTime() ||\r\n        afterDays.getTime() <= time.getTime()\r\n    );\r\n}",
                    name: 'logic_disabledDate',
                    id: 'logic_disableddate',
                  },
                  {
                    attrName: 'clearable',
                    attrValue: 'false',
                    id: 'logic_clearable',
                  },
                  {
                    attrName: 'shortcuts',
                    attrValue:
                      "[\r\n    {\r\n    text: '最近7天',\r\n    value: () => {\r\n        const end_at = new Date();\r\n        const start_at = new Date();\r\n        start_at.setDate(end_at.getDate() - 6);\r\n        return [start_at, end_at];\r\n    },\r\n    },\r\n    {\r\n    text: '最近30天',\r\n    value: () => {\r\n        const end_at = new Date();\r\n        const start_at = new Date();\r\n        start_at.setDate(end_at.getDate() - 29);\r\n        return [start_at, end_at];\r\n    },\r\n    },\r\n    {\r\n    text: '本周',\r\n    value: () => {\r\n        const end_at = new Date();\r\n        const currentDay = end_at.getDay();\r\n        const start_at = new Date(end_at);\r\n\r\n        // 计算本周的开始日期 (周一)\r\n        start_at.setDate(\r\n        end_at.getDate() - currentDay + (currentDay === 0 ? -6 : 1),\r\n        );\r\n        return [start_at, end_at];\r\n    },\r\n    },\r\n    {\r\n    text: '本月',\r\n    value: () => {\r\n        const end_at = new Date();\r\n        const start_at = new Date(end_at);\r\n\r\n        // 将日期设置为本月第一天\r\n        start_at.setDate(1);\r\n        return [start_at, end_at];\r\n    },\r\n    },\r\n]",
                    id: 'date_range_shortcuts',
                  },
                ],
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                id: 'date_range',
              },
              {
                dataType: 5,
                enableCond: 3,
                labelPos: 'LEFT',
                labelWidth: 130,
                noPrivDisplayMode: 1,
                appDEFieldId: 'register_date',
                editor: {
                  editorType: 'HIDDEN',
                  valueType: 'SIMPLE',
                  editable: true,
                  id: 'n_register_date_gtandeq',
                },
                valueFormat: 'YYYY-MM-DD',
                allowEmpty: true,
                hidden: true,
                caption: '工作日期（大于）',
                codeName: 'n_register_date_gtandeq',
                detailStyle: 'DEFAULT',
                detailType: 'FORMITEM',
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                id: 'n_register_date_gtandeq',
              },
              {
                dataType: 5,
                enableCond: 3,
                labelPos: 'LEFT',
                labelWidth: 130,
                noPrivDisplayMode: 1,
                appDEFieldId: 'register_date',
                editor: {
                  editorType: 'HIDDEN',
                  valueType: 'SIMPLE',
                  editable: true,
                  id: 'n_register_date_ltandeq',
                },
                valueFormat: 'YYYY-MM-DD',
                allowEmpty: true,
                hidden: true,
                caption: '工作日期（小于）',
                codeName: 'n_register_date_ltandeq',
                detailStyle: 'DEFAULT',
                detailType: 'FORMITEM',
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                id: 'n_register_date_ltandeq',
              },
            ],
            capLanguageRes: {
              lanResTag: 'CONTROL.DEFORM.WORKLOAD.DEFAULT.FORMPAGE.FORMPAGE1',
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
        codeName: 'register_date_search_form',
        controlType: 'SEARCHFORM',
        logicName: '登记日期_搜索表单',
        appDataEntityId: 'plmweb.workload',
        controlParam: {
          id: 'searchform',
        },
        modelId: '3318849a4312bd64804d404ac154bde9',
        modelType: 'PSDEFORM_SEARCHFORM',
        name: 'searchform',
        id: 'plmweb.workload.register_date_search_form',
      },
      {
        groupMode: 'SINGLE',
        searchBarFilters: [
          {
            dataType: 25,
            labelPos: 'NONE',
            defsearchMode: {
              codeName: 'N_CREATE_MAN_IN',
              stdDataType: 25,
              valueOP: 'IN',
              name: 'N_CREATE_MAN_IN',
              id: 'n_create_man_in',
            },
            editor: {
              singleSelect: true,
              enableAC: true,
              forceSelection: true,
              showTrigger: true,
              valueItemName: 'create_man',
              editorParams: {
                ISSHOWTAB: 'false',
                ISADDSYMBOL: 'true',
                MULTIPLE: 'true',
                AC: 'TRUE',
                'SRFNAVPARAM.n_status_eq': '1',
                TRIGGER: 'TRUE',
                URL: '/users/fetch_default',
                PICKUPVIEW: 'FALSE',
                USERMETHOD: 'get',
                USERMAP: '{"id":"id","name":"display_name"}',
              },
              editorStyle: 'PERSONEL_SELECT_ALL',
              editorType: 'PICKEREX_TRIGGER',
              sysPFPluginId: 'person_select',
              valueType: 'SIMPLE',
              editable: true,
              navigateParams: [
                {
                  key: 'n_status_eq',
                  value: '1',
                  rawValue: true,
                  id: 'n_status_eq',
                },
              ],
              id: 'user_id',
            },
            allowEmpty: true,
            caption: '登记人',
            itemType: 'FILTER',
            appDEFieldId: 'create_man',
            id: 'user_id',
          },
          {
            dataType: 25,
            labelPos: 'NONE',
            editor: {
              editorType: 'TEXTBOX',
              valueType: 'SIMPLE',
              editable: true,
              id: 'name',
            },
            allowEmpty: true,
            caption: '事项',
            itemType: 'FILTER',
            appDEFieldId: 'name',
            id: 'name',
          },
          {
            dataType: 25,
            labelPos: 'NONE',
            editor: {
              singleSelect: true,
              appCodeListId: 'plmweb.base__workload_type',
              editorType: 'DROPDOWNLIST',
              valueType: 'SIMPLE',
              editable: true,
              id: 'workload_type',
            },
            allowEmpty: true,
            needCodeListConfig: true,
            itemType: 'FILTER',
            appDEFieldId: 'type_id',
            id: 'workload_type',
          },
          {
            dataType: 25,
            labelPos: 'NONE',
            editor: {
              singleSelect: true,
              appCodeListId: 'plmweb.projmgmt__usrcodelist0122047845',
              editorType: 'DROPDOWNLIST',
              valueType: 'SIMPLE',
              editable: true,
              id: 'project_id',
            },
            allowEmpty: true,
            needCodeListConfig: true,
            caption: '项目',
            itemType: 'FILTER',
            appDEFieldId: 'recent_parent',
            id: 'project_id',
          },
          {
            dataType: 25,
            labelPos: 'NONE',
            editor: {
              singleSelect: true,
              appCodeListId: 'plmweb.prodmgmt__product_list',
              editorType: 'DROPDOWNLIST',
              valueType: 'SIMPLE',
              editable: true,
              id: 'product_id',
            },
            allowEmpty: true,
            needCodeListConfig: true,
            caption: '产品',
            itemType: 'FILTER',
            appDEFieldId: 'recent_parent',
            id: 'product_id',
          },
          {
            dataType: 25,
            labelPos: 'NONE',
            editor: {
              singleSelect: true,
              appCodeListId: 'plmweb.testmgmt__library_list',
              editorType: 'DROPDOWNLIST',
              valueType: 'SIMPLE',
              editable: true,
              id: 'library_id',
            },
            allowEmpty: true,
            needCodeListConfig: true,
            caption: '测试库',
            itemType: 'FILTER',
            appDEFieldId: 'recent_parent',
            id: 'library_id',
          },
        ],
        searchBarGroups: [
          {
            defaultGroup: true,
            caption: '全部人员',
            itemType: 'GROUP',
            id: 'all',
          },
        ],
        quickGroupCount: 4,
        quickSearchMode: 1,
        searchBarStyle: 'SEARCHBAR2',
        enableFilter: true,
        enableGroup: true,
        enableQuickSearch: true,
        codeName: 'member_calendar_searchbar',
        controlType: 'SEARCHBAR',
        logicName: '人员工时日历_搜索栏',
        appDataEntityId: 'plmweb.workload',
        controlParam: {
          id: 'searchbar',
        },
        modelId: '6bddd4bb5fb019442cb32c7bb453ead8',
        modelType: 'PSSYSSEARCHBAR',
        name: 'searchbar',
        id: 'plmweb.workload.member_calendar_searchbar',
      },
      {
        detoolbarItems: [
          {
            actionLevel: 100,
            noPrivDisplayMode: 2,
            uiactionId: 'gridview_exportaction',
            valid: true,
            capLanguageRes: {
              lanResTag: 'TBB.TEXT.*.EXPORT',
            },
            caption: '导出',
            itemType: 'DEUIACTION',
            sysImage: {
              cssClass: 'fa fa-file-excel-o',
              glyph: 'xf1c3@FontAwesome',
            },
            tooltip: '导出',
            tooltipLanguageRes: {
              lanResTag: 'TBB.TOOLTIP.*.EXPORT',
            },
            showCaption: true,
            showIcon: true,
            id: 'deuiaction1',
          },
        ],
        xdataControlName: 'grid',
        codeName: 'management_member_calendar_grid_view_toolbar',
        controlType: 'TOOLBAR',
        logicName: '工时日历_工具栏',
        appDataEntityId: 'plmweb.workload',
        controlParam: {
          id: 'toolbar',
        },
        modelId: '1caa28e37cd29023f9d644f5b0378f0f',
        modelType: 'PSDETOOLBAR',
        name: 'toolbar',
        id: 'management_member_calendar_grid_view_toolbar',
      },
      {
        capLanguageRes: {
          lanResTag: 'DE.LNAME.WORKLOAD',
        },
        caption: '工时',
        codeName: 'management_member_calendar_grid_view_captionbar',
        controlType: 'CAPTIONBAR',
        appDataEntityId: 'plmweb.workload',
        controlParam: {},
        name: 'captionbar',
        id: 'management_member_calendar_grid_view_captionbar',
      },
    ],
    codeName: 'usr0322932185',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: 'management_member_calendar_grid_view表格视图布局',
    appDataEntityId: 'plmweb.workload',
    controlParam: {},
    modelId: 'ba5af80f17fb3f5cfe18c1c03fffadee',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'usr0322932185',
  },
  title: '工时日历人员维度表格视图（管理）',
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  enableDP: true,
  showCaptionBar: false,
  modelId: '874bc86f5f7673da56a7ccc404bae9de',
  modelType: 'PSAPPDEVIEW',
  name: 'workloadmanagement_member_calendar_grid_view',
  id: 'plmweb.workload_management_member_calendar_grid_view',
};
