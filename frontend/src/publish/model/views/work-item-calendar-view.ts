export default {
  mdctrlActiveMode: 1,
  xdataControlName: 'calendar',
  loadDefault: true,
  deviewCodeName: 'calendar_view',
  deviewId: '8f3f72ae82620652822b738bdf6a6a95',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.WORK_ITEM',
  },
  caption: '我的日历',
  codeName: 'work_item_calendar_view',
  appDataEntityId: 'plmweb.work_item',
  appViewLogics: [
    {
      logicTrigger: 'CUSTOM',
      logicType: 'APPUILOGIC',
      builtinAppUILogic: {
        actionAfterWizard: 'DEFAULT',
        enableWizardAdd: true,
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
    {
      realOpenMode: 'INDEXVIEWTAB_POPUPMODAL',
      realTitle: '工作项（动态）',
      refAppViewId: 'plmweb.work_item_dyna_main_view',
      id: 'editdata@my_work_item',
    },
    {
      realTitle: '工作项编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.WORK_ITEM.EDITVIEW',
      },
      refAppViewId: 'plmweb.work_item_edit_view',
      name: 'NEWDATA@my_work_item',
      id: 'newdata@my_work_item',
    },
  ],
  controls: [
    {
      calendarStyle: 'MONTH',
      groupMode: 'NONE',
      legendPos: 'NONE',
      sysCalendarItems: [
        {
          bkcolor: '#71bbf6',
          beginTimeAppDEFieldId: 'start_at',
          color: 'white',
          endTimeAppDEFieldId: 'end_at',
          idAppDEFieldId: 'id',
          itemStyle: 'DEFAULT',
          itemType: 'my_work_item',
          appDEDataSetId: 'fetch_my_assignee',
          textAppDEFieldId: 'title',
          appDataEntityId: 'plmweb.work_item',
          navAppViewId: 'plmweb.work_item_main_view',
          name: '我的工作项',
          id: 'my_work_item',
        },
      ],
      navViewPos: 'NONE',
      autoLoad: true,
      showBusyIndicator: true,
      appViewLogics: [
        {
          logicTrigger: 'CUSTOM',
          logicType: 'APPUILOGIC',
          builtinAppUILogic: {
            actionAfterWizard: 'DEFAULT',
            builtinLogic: true,
            logicType: 'PREDEFINED',
            viewLogicType: 'APP_NEWDATA',
            id: '新建数据',
          },
          builtinLogic: true,
          id: 'my_work_item_newdata',
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
            id: '编辑数据',
          },
          builtinLogic: true,
          id: 'my_work_item_editdata',
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
          id: 'my_work_item_opendata',
        },
      ],
      codeName: 'work_item_calendar_view_calendar',
      controlType: 'CALENDAR',
      logicName: '工作项日历视图_日历部件',
      appDataEntityId: 'plmweb.work_item',
      controlParam: {
        ctrlParams: {
          SHOWMODE: 'daterange',
        },
        id: 'calendar',
      },
      modelId: '0ce99aef6f6f851a642d204e3d68efa6',
      modelType: 'PSSYSCALENDAR',
      name: 'calendar',
      id: 'plmweb.work_item.work_item_calendar_view_calendar',
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
      caption: '我的日历',
      codeName: 'calendar_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.work_item',
      controlParam: {},
      name: 'captionbar',
      id: 'calendar_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDECALENDARVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.work_item',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '工作项日历',
  viewStyle: 'DEFAULT',
  viewType: 'DECALENDARVIEW',
  enableDP: true,
  showCaptionBar: false,
  modelId: 'e41deafcffaf79640a9b9196e21ad9f1',
  modelType: 'PSAPPDEVIEW',
  name: 'work_itemcalendar_view',
  id: 'plmweb.work_item_calendar_view',
};
