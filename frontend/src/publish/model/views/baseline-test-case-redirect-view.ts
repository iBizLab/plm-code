export default {
  redirectAppViewRefs: [
    {
      realTitle: '基线用例编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.BASELINE_TEST_CASE.EDITVIEW',
      },
      refAppViewId: 'plmweb.baseline_test_case_edit_view',
      name: 'BASELINE_TEST_CASE:EDITVIEW',
      id: 'baseline_test_case:editview',
    },
    {
      realTitle: '基线用例编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.BASELINE_TEST_CASE.EDITVIEW',
      },
      refAppViewId: 'plmweb.baseline_test_case_edit_view',
      name: 'EDITVIEW',
      id: 'editview',
    },
  ],
  enableWorkflow: true,
  funcViewMode: 'REDIRECTVIEW',
  deviewCodeName: 'RedirectView',
  deviewId: '9fbaff2141be1c4104f6aba0af28db2f',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.BASELINE_TEST_CASE',
  },
  caption: '基线用例',
  codeName: 'baseline_test_case_redirect_view',
  appDataEntityId: 'plmweb.baseline_test_case',
  controls: [
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.BASELINE_TEST_CASE',
      },
      caption: '基线用例',
      codeName: 'redirect_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.baseline_test_case',
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
    appDataEntityId: 'plmweb.baseline_test_case',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '基线用例数据重定向视图',
  titleLanguageRes: {
    lanResTag: 'PAGE.TITLE.BASELINE_TEST_CASE.REDIRECTVIEW',
  },
  viewStyle: 'DEFAULT',
  viewType: 'DEREDIRECTVIEW',
  enableDP: true,
  redirectView: true,
  showCaptionBar: true,
  modelId: '5764e4ad34b9d20f6285f7ff6e46fdec',
  modelType: 'PSAPPDEVIEW',
  name: 'baseline_test_caseRedirectView',
  id: 'plmweb.baseline_test_case_redirect_view',
};