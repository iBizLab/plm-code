export default {
  tabLayout: 'TOP',
  loadDefault: true,
  showDataInfoBar: true,
  deviewCodeName: 'main_view',
  deviewId: '36e6dc492dc76954d80c74921657d5a3',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.SPRINT',
  },
  caption: '迭代',
  codeName: 'sprint_main_view',
  appDataEntityId: 'plmweb.sprint',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'TabExpView',
      id: 'engine',
    },
  ],
  controls: [
    {
      tabExpPageIds: ['work_item'],
      tabLayout: 'TOP',
      uniqueTag: 'sprint_main_view__tabexppanel',
      appViewRefs: [
        {
          parentDataJO: {
            srfparentdename: 'SPRINT',
            srfparentmode: 'DER1N_WORK_ITEM_SPRINT_SPRINT_ID',
            srfparentdefname: 'SPRINT_ID',
          },
          realTitle: '工作项表格视图（迭代）',
          refAppViewId: 'plmweb.work_item_sprint_grid_view',
          name: 'EXPITEM:work_item',
          id: 'expitem:work_item',
        },
      ],
      controls: [
        {
          navDER: {
            pickupDEFName: 'SPRINT_ID',
            removeActionType: 2,
            codeName: 'sprint',
            dertype: 'DER1N',
            logicName: '迭代',
            minorCodeName: 'work_items',
            minorServiceCodeName: 'work_items',
            orderValue: 100,
            serviceCodeName: 'sprint',
            name: 'DER1N_WORK_ITEM_SPRINT_SPRINT_ID',
            id: 'projmgmt.work_item.der1n_work_item_sprint_sprint_id',
          },
          parentDataJO: {
            srfparentdename: 'SPRINT',
            srfparentmode: 'DER1N_WORK_ITEM_SPRINT_SPRINT_ID',
            srfparentdefname: 'SPRINT_ID',
          },
          caption: '工作项',
          embeddedAppDEViewId: 'plmweb.work_item_sprint_grid_view',
          codeName: 'main_view_work_item',
          controlType: 'TABVIEWPANEL',
          appDataEntityId: 'plmweb.work_item',
          controlParam: {
            id: 'work_item',
          },
          modelId: '01c20953bb0fb9b9b5be3730e60e427c_work_item',
          modelType: 'PSVIEWPANEL',
          name: 'work_item',
          id: 'main_view_work_item',
        },
      ],
      codeName: 'main_view_tabexppanel',
      controlType: 'TABEXPPANEL',
      appDataEntityId: 'plmweb.sprint',
      controlParam: {},
      modelId: '01c20953bb0fb9b9b5be3730e60e427c_tabexppanel',
      modelType: 'PSTABEXPPANEL',
      name: 'tabexppanel',
      id: 'main_view_tabexppanel',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.SPRINT',
      },
      caption: '迭代',
      codeName: 'main_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.sprint',
      controlParam: {},
      name: 'captionbar',
      id: 'main_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDETABEXPVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.sprint',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '迭代实体分页导航视图',
  viewStyle: 'DEFAULT',
  viewType: 'DETABEXPVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '01c20953bb0fb9b9b5be3730e60e427c',
  modelType: 'PSAPPDEVIEW',
  name: 'sprintmain_view',
  id: 'plmweb.sprint_main_view',
};