export default {
  getDataAppDEActionId: 'get',
  redirectAppViewRefs: [
    {
      realTitle: '工作项编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.WORK_ITEM.EDITVIEW',
      },
      refAppViewId: 'plmweb.work_item_edit_view',
      name: 'WORK_ITEM:EDITVIEW',
      id: 'work_item:editview',
    },
    {
      realTitle: '工作项编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.WORK_ITEM.EDITVIEW',
      },
      refAppViewId: 'plmweb.work_item_edit_view',
      name: 'EDITVIEW',
      id: 'editview',
    },
    {
      realOpenMode: 'INDEXVIEWTAB_POPUPMODAL',
      realTitle: '工作项（动态）',
      refAppViewId: 'plmweb.work_item_dyna_main_view',
      name: 'SCRUM_BUG',
      id: 'scrum_bug',
    },
  ],
  typeAppDEFieldId: 'work_item_type_id',
  enableCustomGetDataAction: true,
  enableWorkflow: true,
  deviewCodeName: 'RedirectView_Dyna',
  deviewId: '8a365ef79e7d86f4fc4eadfb9bd3e86a',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.WORK_ITEM',
  },
  caption: '工作项',
  codeName: 'work_item_redirect_view_dyna',
  appDataEntityId: 'plmweb.work_item',
  appViewRefs: [
    {
      realOpenMode: 'INDEXVIEWTAB_POPUPMODAL',
      realTitle: '工作项（动态）',
      refAppViewId: 'plmweb.work_item_dyna_main_view',
      name: 'RDITEM:SCRUM_BUG',
      id: 'rditem:scrum_bug',
    },
    {
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
      name: 'SCRUM_EPIC',
      id: 'scrum_epic',
    },
  ],
  controls: [
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.WORK_ITEM',
      },
      caption: '工作项',
      codeName: 'redirect_view_dyna_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.work_item',
      controlParam: {},
      name: 'captionbar',
      id: 'redirect_view_dyna_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEREDIRECTVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.work_item',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '工作项数据重定向视图',
  titleLanguageRes: {
    lanResTag: 'PAGE.TITLE.WORK_ITEM.REDIRECTVIEW',
  },
  viewStyle: 'DEFAULT',
  viewType: 'DEREDIRECTVIEW',
  enableDP: true,
  redirectView: true,
  showCaptionBar: true,
  modelId: '19d45213efbdce5c97e0a830b395a58e',
  modelType: 'PSAPPDEVIEW',
  name: 'work_itemRedirectView_Dyna',
  id: 'plmweb.work_item_redirect_view_dyna',
};