export default {
  mdctrlActiveMode: 1,
  xdataControlName: 'calendar',
  loadDefault: true,
  deviewCodeName: 'road_map_view',
  deviewId: 'c583cfda982eb9632a8b52b549a8b2e2',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.RELEASE',
  },
  caption: '路线图',
  codeName: 'release_road_map_view',
  appDataEntityId: 'plmweb.release',
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
      id: 'newdata',
    },
    {
      logicTrigger: 'CUSTOM',
      logicType: 'APPUILOGIC',
      builtinAppUILogic: {
        editMode: true,
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
      realOpenMode: 'INDEXVIEWTAB_POPUPMODAL',
      realTitle: '项目发布主视图',
      refAppViewId: 'plmweb.release_modal_main_view',
      id: 'opendata@release',
    },
    {
      realTitle: '项目发布编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.RELEASE.EDITVIEW',
      },
      refAppViewId: 'plmweb.release_edit_view',
      name: 'EDITDATA@release',
      id: 'editdata@release',
    },
  ],
  controls: [
    {
      calendarStyle: 'TIMELINE',
      groupLayout: 'ROW',
      groupMode: 'AUTO',
      groupAppDEFieldId: 'end_year',
      legendPos: 'NONE',
      sysCalendarItems: [
        {
          beginTimeAppDEFieldId: 'end_at',
          endTimeAppDEFieldId: 'end_at',
          idAppDEFieldId: 'id',
          itemStyle: 'DEFAULT',
          itemType: 'release',
          appDEDataSetId: 'fetch_published',
          textAppDEFieldId: 'name',
          appDataEntityId: 'plmweb.release',
          name: '发布',
          id: 'release',
        },
      ],
      enableGroup: true,
      navViewPos: 'NONE',
      autoLoad: true,
      showBusyIndicator: true,
      appViewLogics: [
        {
          logicTrigger: 'CUSTOM',
          logicType: 'APPUILOGIC',
          builtinAppUILogic: {
            editMode: true,
            builtinLogic: true,
            logicType: 'PREDEFINED',
            viewLogicType: 'APP_OPENDATA',
            id: '编辑数据',
          },
          builtinLogic: true,
          id: 'release_editdata',
        },
        {
          logicTrigger: 'CUSTOM',
          logicType: 'APPUILOGIC',
          builtinAppUILogic: {
            openDataAppView: {
              openMode: 'INDEXVIEWTAB_POPUPMODAL',
              navigateContexts: [
                {
                  key: 'PROJECT',
                  value: 'project_id',
                  name: 'PROJECT',
                  id: 'project',
                },
                {
                  key: 'RELEASE',
                  value: 'id',
                  name: 'RELEASE',
                  id: 'release',
                },
              ],
              refAppViewId: 'plmweb.release_modal_main_view',
            },
            appUILogicRefViews: [
              {
                openMode: 'INDEXVIEWTAB_POPUPMODAL',
                navigateContexts: [
                  {
                    key: 'PROJECT',
                    value: 'project_id',
                    name: 'PROJECT',
                    id: 'project',
                  },
                  {
                    key: 'RELEASE',
                    value: 'id',
                    name: 'RELEASE',
                    id: 'release',
                  },
                ],
                refAppViewId: 'plmweb.release_modal_main_view',
              },
            ],
            builtinLogic: true,
            logicType: 'PREDEFINED',
            viewLogicType: 'APP_OPENDATA',
            id: '打开数据',
          },
          builtinLogic: true,
          id: 'release_opendata',
        },
      ],
      codeName: 'road_map_view_calendar',
      controlType: 'CALENDAR',
      logicName: '路线图视图_日历部件',
      appDataEntityId: 'plmweb.release',
      controlParam: {
        id: 'calendar',
      },
      controlRenders: [
        {
          layoutPanelModel:
            "function chunkArray(array, chunkSize) {\r\n  let result = [];\r\n  let items = [...array];\r\n  items.sort((a, b) => new Date(a.endTime) - new Date(b.endTime));\r\n  for (let i = 0; i < items.length; i += chunkSize) {\r\n    result.unshift(items.slice(i, i + chunkSize));\r\n  }\r\n  return result;\r\n}\r\nconst groups = ctrl.state.groups;\r\nconst htmlArr = groups.map(group => {\r\n  const items = chunkArray(group.children, 7);\r\n  return `<div class='time-line'>\r\n\t  <div class='time-line-right'>\r\n\t\t<div class='time-line-right--title'>\r\n\t\t  <div class='time-line-right--caption'>${group.caption}年</div>\r\n\t\t  <div class='time-line-right--description'>\r\n\t\t  迭代 ${group.children.length} 次\r\n\t\t  </div>\r\n\t\t</div>\r\n\t  </div>\r\n\t  <div class='time-line-left'>\r\n\t\t${items.map(children => {\r\n      return `<div class='time-line-left--line'>\r\n\t\t  ${children.map((child, index) => {\r\n        return `<div class='time-line-left--item ${index % 2 !== 0 ? 'is-top' : ''}'>\r\n\t\t\t  <div class='time-line-left--item__dot'></div>\r\n\t\t\t  <div class='time-line-left--item__vertical'></div>\r\n\t\t\t  <div class='time-line-left--item__content'>\r\n\t\t\t\t<div class='time-line-left--item__caption' click='ctrl.onRowClick(data)' data=\"{'id': '${child.id}' }\">\r\n\t\t\t\t\t${child.text}\r\n\t\t\t\t</div>\r\n\t\t\t\t<div class='time-line-left--item__time' click='ctrl.onRowClick(data)' data=\"{'id': '${child.id}' }\">\r\n\t\t\t\t\t${child.endTime}\r\n\t\t\t\t</div>\r\n\t\t\t  </div>\r\n\t\t\t</div>`;\r\n      })}\r\n\t\t  </div>`;\r\n    })}\r\n\t  </div>\r\n\t  </div>`;\r\n});\r\nreturn htmlArr.join('').replaceAll(',', '');",
          renderType: 'LAYOUTPANEL_MODEL',
          id: 'render',
        },
      ],
      modelId: '1c9d26ca5373c45419646dddac4f55d4',
      modelType: 'PSSYSCALENDAR',
      name: 'calendar',
      id: 'plmweb.release.road_map_view_calendar',
    },
    {
      groupMode: 'SINGLE',
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.release',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.RELEASE',
      },
      caption: '路线图',
      codeName: 'road_map_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.release',
      controlParam: {},
      name: 'captionbar',
      id: 'road_map_view_captionbar',
    },
  ],
  sysCss: {
    cssName: 'road-map-view',
  },
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDECALENDARVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.release',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '路线图',
  viewStyle: 'DEFAULT',
  viewType: 'DECALENDARVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '61e54bb5846bc277b12bb136f2d87d14',
  modelType: 'PSAPPDEVIEW',
  name: 'releaseroad_map_view',
  id: 'plmweb.release_road_map_view',
};
