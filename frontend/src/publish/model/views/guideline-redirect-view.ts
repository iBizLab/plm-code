export default {
  redirectAppViewRefs: [
    {
      realTitle: '流程准则编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.GUIDELINE.EDITVIEW',
      },
      refAppViewId: 'plmweb.guideline_edit_view',
      name: 'GUIDELINE:EDITVIEW',
      id: 'guideline:editview',
    },
    {
      realTitle: '流程准则编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.GUIDELINE.EDITVIEW',
      },
      refAppViewId: 'plmweb.guideline_edit_view',
      name: 'EDITVIEW',
      id: 'editview',
    },
  ],
  enableWorkflow: true,
  funcViewMode: 'REDIRECTVIEW',
  deviewCodeName: 'RedirectView',
  deviewId: '04b16b883fd7a173b96813f3be9afaad',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.GUIDELINE',
  },
  caption: '流程准则',
  codeName: 'guideline_redirect_view',
  appDataEntityId: 'plmweb.guideline',
  controls: [
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.GUIDELINE',
      },
      caption: '流程准则',
      codeName: 'redirect_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.guideline',
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
    appDataEntityId: 'plmweb.guideline',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '流程准则数据重定向视图',
  titleLanguageRes: {
    lanResTag: 'PAGE.TITLE.GUIDELINE.REDIRECTVIEW',
  },
  viewStyle: 'DEFAULT',
  viewType: 'DEREDIRECTVIEW',
  enableDP: true,
  redirectView: true,
  showCaptionBar: true,
  modelId: 'b2409a905b567b30dcd1694cbedfb095',
  modelType: 'PSAPPDEVIEW',
  name: 'guidelineRedirectView',
  id: 'plmweb.guideline_redirect_view',
};