export default {
  redirectAppViewRefs: [
    {
      realTitle: '基线页面编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.BASELINE_PAGE.EDITVIEW',
      },
      refAppViewId: 'plmweb.baseline_page_edit_view',
      name: 'BASELINE_PAGE:EDITVIEW',
      id: 'baseline_page:editview',
    },
    {
      realTitle: '基线页面编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.BASELINE_PAGE.EDITVIEW',
      },
      refAppViewId: 'plmweb.baseline_page_edit_view',
      name: 'EDITVIEW',
      id: 'editview',
    },
  ],
  enableWorkflow: true,
  funcViewMode: 'REDIRECTVIEW',
  deviewCodeName: 'RedirectView',
  deviewId: 'bc21d6d459b0d66ccb147f5b3f8380e8',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.BASELINE_PAGE',
  },
  caption: '基线页面',
  codeName: 'baseline_page_redirect_view',
  appDataEntityId: 'plmweb.baseline_page',
  controls: [
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.BASELINE_PAGE',
      },
      caption: '基线页面',
      codeName: 'redirect_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.baseline_page',
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
    appDataEntityId: 'plmweb.baseline_page',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '基线页面数据重定向视图',
  titleLanguageRes: {
    lanResTag: 'PAGE.TITLE.BASELINE_PAGE.REDIRECTVIEW',
  },
  viewStyle: 'DEFAULT',
  viewType: 'DEREDIRECTVIEW',
  enableDP: true,
  redirectView: true,
  showCaptionBar: true,
  modelId: '2472b77ff07f09321b3b0dcf07fdfe6e',
  modelType: 'PSAPPDEVIEW',
  name: 'baseline_pageRedirectView',
  id: 'plmweb.baseline_page_redirect_view',
};