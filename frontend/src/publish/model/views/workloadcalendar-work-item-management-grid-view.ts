export default {
  gridRowActiveMode: 1,
  expandSearchForm: true,
  xdataControlName: 'grid',
  loadDefault: true,
  deviewCodeName: 'calendar_work_item_management_grid_view',
  deviewId: 'f3405c56ebe0f1638d931c26bf98cf2e',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.WORKLOAD',
  },
  caption: '工时',
  codeName: 'workloadcalendar_work_item_management_grid_view',
  appDataEntityId: 'plmweb.workload',
  viewLayoutPanel: {
    viewProxyMode: true,
    layoutMode: 'FLEX',
    layout: {
      layout: 'FLEX',
    },
    rootPanelItems: [
      {
        panelItems: [
          {
            panelItems: [
              {
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
            panelItems: [
              {
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
        name: 'LOGICUPDATE',
        id: 'logicupdate',
      },
      {
        eventNames: 'onActive',
        logicTrigger: 'CTRLEVENT',
        logicType: 'APPDEUILOGIC',
        appDEUILogicId: 'open_main_view',
        appDataEntityId: 'plmweb.workload',
        ctrlName: 'grid',
        builtinLogic: true,
        name: 'OPENDATA',
        id: 'opendata',
      },
      {
        logicTrigger: 'CUSTOM',
        logicType: 'APPUILOGIC',
        builtinAppUILogic: {
          actionAfterWizard: 'DEFAULT',
          newDataAppView: {
            refAppViewId: 'plmweb.workloadeditview',
          },
          appUILogicRefViews: [
            {
              refAppViewId: 'plmweb.workloadeditview',
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
    ],
    appViewRefs: [
      {
        realTitle: '工时数据重定向视图',
        realTitleLanguageRes: {
          lanResTag: 'PAGE.TITLE.WORKLOAD.REDIRECTVIEW',
        },
        refAppViewId: 'plmweb.workloadredirectview',
        name: 'EDITDATA',
        id: 'editdata',
      },
      {
        realTitle: '工时编辑视图',
        realTitleLanguageRes: {
          lanResTag: 'PAGE.TITLE.WORKLOAD.EDITVIEW',
        },
        refAppViewId: 'plmweb.workloadeditview',
        name: 'NEWDATA',
        id: 'newdata',
      },
    ],
    controls: [
      {
        aggMode: 'NONE',
        columnEnableFilter: 2,
        columnEnableLink: 2,
        groupMode: 'AUTO',
        groupAppDEFieldId: 'principal_id',
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
            dataItemName: 'name',
            excelCaption: '工作项',
            appDEFieldId: 'name',
            valueType: 'SIMPLE',
            aggMode: 'NONE',
            align: 'LEFT',
            capLanguageRes: {
              lanResTag: 'DEF.LNAME.NAME',
            },
            caption: '工作项',
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
            dataItemName: 'duration',
            excelCaption: '总登记工时',
            appDEFieldId: 'duration',
            deuiactionId: 'calendar_duration_management_link@workload',
            valueFormat: '#.0',
            valueType: 'SIMPLE',
            aggMode: 'NONE',
            align: 'RIGHT',
            caption: '总登记工时',
            codeName: 'duration',
            columnType: 'DEFGRIDCOLUMN',
            noPrivDisplayMode: 1,
            width: 150,
            widthUnit: 'PX',
            enableSort: true,
            id: 'duration',
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
            appDEFieldId: 'name',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'name',
          },
          {
            format: '#.0',
            appDEFieldId: 'duration',
            valueType: 'SIMPLE',
            dataType: 6,
            id: 'duration',
          },
          {
            appDEFieldId: 'principal_id',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'principal_id',
          },
          {
            appDEFieldId: 'recent_parent',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'recent_parent',
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
        pagingSize: 20,
        sortMode: 'REMOTE',
        enableGroup: true,
        singleSelect: true,
        fetchControlAction: {
          appDEMethodId: 'fetchwork_item_management_dimension',
          appDataEntityId: 'plmweb.workload',
          id: 'fetch',
        },
        removeControlAction: {
          appDEMethodId: 'remove',
          appDataEntityId: 'plmweb.workload',
          id: 'remove',
        },
        autoLoad: true,
        showBusyIndicator: true,
        codeName: 'Calendar_work_item_management_grid',
        controlStyle: 'WORKLOAD_TABLE',
        controlType: 'GRID',
        logicName: '工时日历_工作项管理表格',
        appDataEntityId: 'plmweb.workload',
        controlParam: {
          ctrlParams: {
            DATERANGE: 'date_range',
          },
          id: 'grid',
        },
        sysPFPluginId: 'workload_table',
        modelId: '2a20f16e64cf9b90db6109a832133946',
        modelType: 'PSDEGRID',
        name: 'grid',
        id: 'plmweb.workload.calendar_work_item_management_grid',
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
                showCaption: true,
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
                showCaption: true,
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
        codeName: 'Register_date_search_form',
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
            dataType: 21,
            labelPos: 'NONE',
            defsearchMode: {
              codeName: 'N_WORK_ITEM_EXISTS__N_PRIORITY_EQ',
              stdDataType: 25,
              valueOP: 'EXISTS',
              name: 'N_WORK_ITEM_EXISTS__N_PRIORITY_EQ',
              id: 'n_work_item_exists__n_priority_eq',
            },
            editor: {
              singleSelect: true,
              appCodeListId: 'plmweb.projmgmt__work_item_priority',
              editorType: 'DROPDOWNLIST',
              valueType: 'SIMPLE',
              editable: true,
              id: 'work_item_priority',
            },
            allowEmpty: true,
            needCodeListConfig: true,
            caption: '工作项',
            itemType: 'FILTER',
            appDEFieldId: 'work_item',
            id: 'work_item_priority',
          },
          {
            dataType: 21,
            labelPos: 'NONE',
            defsearchMode: {
              codeName: 'N_WORK_ITEM_EXISTS__N_STATE_EQ',
              stdDataType: 25,
              valueOP: 'EXISTS',
              name: 'N_WORK_ITEM_EXISTS__N_STATE_EQ',
              id: 'n_work_item_exists__n_state_eq',
            },
            editor: {
              singleSelect: true,
              appCodeListId: 'plmweb.projmgmt__work_item_state2',
              editorType: 'DROPDOWNLIST',
              valueType: 'SIMPLE',
              editable: true,
              id: 'work_item_state',
            },
            allowEmpty: true,
            needCodeListConfig: true,
            caption: '工作项(Exists)',
            itemType: 'FILTER',
            appDEFieldId: 'work_item',
            id: 'work_item_state',
          },
          {
            dataType: 21,
            labelPos: 'NONE',
            defsearchMode: {
              codeName: 'N_WORK_ITEM_EXISTS__N_TITLE_LIKE',
              stdDataType: 25,
              valueOP: 'EXISTS',
              name: 'N_WORK_ITEM_EXISTS__N_TITLE_LIKE',
              id: 'n_work_item_exists__n_title_like',
            },
            editor: {
              halign: 'LEFT',
              valign: 'MIDDLE',
              wrapMode: 'NOWRAP',
              editorType: 'SPAN',
              valueType: 'SIMPLE',
              editable: true,
              id: 'work_item_title',
            },
            allowEmpty: true,
            caption: '标题',
            itemType: 'FILTER',
            appDEFieldId: 'work_item',
            id: 'work_item_title',
          },
          {
            dataType: 21,
            labelPos: 'NONE',
            defsearchMode: {
              codeName: 'N_WORK_ITEM_EXISTS__N_PROJECT_ID_EQ',
              stdDataType: 25,
              valueOP: 'EXISTS',
              name: 'N_WORK_ITEM_EXISTS__N_PROJECT_ID_EQ',
              id: 'n_work_item_exists__n_project_id_eq',
            },
            editor: {
              singleSelect: true,
              appCodeListId: 'plmweb.projmgmt__usrcodelist0122047845',
              editorType: 'DROPDOWNLIST',
              valueType: 'SIMPLE',
              editable: true,
              id: 'work_item_project_id',
            },
            allowEmpty: true,
            needCodeListConfig: true,
            caption: '项目',
            itemType: 'FILTER',
            appDEFieldId: 'work_item',
            id: 'work_item_project_id',
          },
          {
            dataType: 21,
            labelPos: 'NONE',
            defsearchMode: {
              codeName: 'N_WORK_ITEM_EXISTS__N_WORK_ITEM_TYPE_ID_EQ',
              stdDataType: 25,
              valueOP: 'EXISTS',
              name: 'N_WORK_ITEM_EXISTS__N_WORK_ITEM_TYPE_ID_EQ',
              id: 'n_work_item_exists__n_work_item_type_id_eq',
            },
            editor: {
              singleSelect: true,
              appCodeListId: 'plmweb.projmgmt__work_item_type',
              editorType: 'DROPDOWNLIST',
              valueType: 'SIMPLE',
              editable: true,
              id: 'work_item_type_id',
            },
            allowEmpty: true,
            needCodeListConfig: true,
            caption: '工作项(Exists)',
            itemType: 'FILTER',
            appDEFieldId: 'work_item',
            id: 'work_item_type_id',
          },
          {
            dataType: 21,
            labelPos: 'NONE',
            defsearchMode: {
              codeName: 'N_WORK_ITEM_EXISTS__N_ASSIGNEE_ID_EQ',
              stdDataType: 25,
              valueOP: 'EXISTS',
              name: 'N_WORK_ITEM_EXISTS__N_ASSIGNEE_ID_EQ',
              id: 'n_work_item_exists__n_assignee_id_eq',
            },
            editor: {
              singleSelect: true,
              enableAC: true,
              forceSelection: true,
              showTrigger: true,
              valueItemName: 'assignee_id',
              editorParams: {
                ISSHOWTAB: 'false',
                ISADDSYMBOL: 'true',
                MULTIPLE: 'true',
                AC: 'TRUE',
                TRIGGER: 'TRUE',
                URL: '/users/fetchdefault',
                PICKUPVIEW: 'FALSE',
                USERMETHOD: 'get',
                USERMAP: '{"id":"id","name":"display_name"}',
              },
              editorStyle: 'PERSONEL_SELECT_ALL',
              editorType: 'PICKEREX_TRIGGER',
              sysPFPluginId: 'person_select',
              valueType: 'SIMPLE',
              editable: true,
              id: 'work_item_assignee',
            },
            allowEmpty: true,
            caption: '负责人',
            itemType: 'FILTER',
            appDEFieldId: 'work_item',
            id: 'work_item_assignee',
          },
          {
            dataType: 21,
            labelPos: 'NONE',
            defsearchMode: {
              codeName: 'N_WORK_ITEM_EXISTS__N_IS_ARCHIVED_EQ',
              stdDataType: 9,
              valueOP: 'EXISTS',
              name: 'N_WORK_ITEM_EXISTS__N_IS_ARCHIVED_EQ',
              id: 'n_work_item_exists__n_is_archived_eq',
            },
            editor: {
              singleSelect: true,
              appCodeListId: 'plmweb.yesno',
              editorType: 'DROPDOWNLIST',
              valueType: 'SIMPLE',
              editable: true,
              id: 'work_item_archived',
            },
            allowEmpty: true,
            needCodeListConfig: true,
            caption: '工作项(Exists)',
            itemType: 'FILTER',
            appDEFieldId: 'work_item',
            id: 'work_item_archived',
          },
          {
            dataType: 21,
            labelPos: 'NONE',
            defsearchMode: {
              codeName: 'N_WORK_ITEM_EXISTS__N_CREATE_MAN_EQ',
              stdDataType: 25,
              valueOP: 'EXISTS',
              name: 'N_WORK_ITEM_EXISTS__N_CREATE_MAN_EQ',
              id: 'n_work_item_exists__n_create_man_eq',
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
                TRIGGER: 'TRUE',
                URL: '/users/fetchdefault',
                PICKUPVIEW: 'FALSE',
                USERMETHOD: 'get',
                USERMAP: '{"id":"id","name":"display_name"}',
              },
              editorStyle: 'PERSONEL_SELECT_ALL',
              editorType: 'PICKEREX_TRIGGER',
              sysPFPluginId: 'person_select',
              valueType: 'SIMPLE',
              editable: true,
              id: 'work_item_createman',
            },
            allowEmpty: true,
            caption: '工作项(Exists)',
            itemType: 'FILTER',
            appDEFieldId: 'work_item',
            id: 'work_item_createman',
          },
        ],
        quickSearchMode: 1,
        searchBarStyle: 'SEARCHBAR2',
        enableFilter: true,
        enableQuickSearch: true,
        codeName: 'work_item_management_searchbar',
        controlType: 'SEARCHBAR',
        logicName: '工作项工时日历（管理）_搜索栏',
        appDataEntityId: 'plmweb.workload',
        controlParam: {
          id: 'searchbar',
        },
        modelId: 'e9d668862bff4ce59e43c4a5abc27f3e',
        modelType: 'PSSYSSEARCHBAR',
        name: 'searchbar',
        id: 'plmweb.workload.work_item_management_searchbar',
      },
      {
        capLanguageRes: {
          lanResTag: 'DE.LNAME.WORKLOAD',
        },
        caption: '工时',
        codeName: 'calendar_work_item_management_grid_viewcaptionbar',
        controlType: 'CAPTIONBAR',
        appDataEntityId: 'plmweb.workload',
        controlParam: {},
        name: 'captionbar',
        id: 'calendar_work_item_management_grid_viewcaptionbar',
      },
    ],
    codeName: 'Usr0326121994',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: 'calendar_work_item_grid_view表格视图布局',
    appDataEntityId: 'plmweb.workload',
    controlParam: {},
    modelId: '573354a8b5acab6de070ad8bb0a75c1d',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'usr0326121994',
  },
  title: '工时日历工作项维度表格视图（管理）',
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  enableDP: true,
  showCaptionBar: false,
  modelId: '09dc664beaffca637e9cb9c45f5621a1',
  modelType: 'PSAPPDEVIEW',
  name: 'workloadcalendar_work_item_management_grid_view',
  id: 'plmweb.workloadcalendar_work_item_management_grid_view',
};