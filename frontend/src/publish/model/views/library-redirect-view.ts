export default {
  redirectAppViewRefs: [
    {
      realTitle: '测试库',
      refAppViewId: 'plmweb.library_index_view',
      name: 'LIBRARY:EDITVIEW',
      id: 'library:editview',
    },
    {
      realTitle: '测试库',
      refAppViewId: 'plmweb.library_index_view',
      name: 'EDITVIEW',
      id: 'editview',
    },
  ],
  enableWorkflow: true,
  funcViewMode: 'REDIRECTVIEW',
  deviewCodeName: 'RedirectView',
  deviewId: '337098ceab4222981759ca4d206ab22a',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.LIBRARY',
  },
  caption: '测试库',
  codeName: 'library_redirect_view',
  appDataEntityId: 'plmweb.library',
  controls: [
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.LIBRARY',
      },
      caption: '测试库',
      codeName: 'redirect_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.library',
      controlParam: {},
      name: 'captionbar',
      id: 'redirect_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEREDIRECTVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.library',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '测试库数据重定向视图',
  titleLanguageRes: {
    lanResTag: 'PAGE.TITLE.LIBRARY.REDIRECTVIEW',
  },
  viewStyle: 'DEFAULT',
  viewType: 'DEREDIRECTVIEW',
  enableDP: true,
  redirectView: true,
  showCaptionBar: true,
  modelId: '991b095460767e1572c9851d21f87be8',
  modelType: 'PSAPPDEVIEW',
  name: 'libraryRedirectView',
  id: 'plmweb.library_redirect_view',
};