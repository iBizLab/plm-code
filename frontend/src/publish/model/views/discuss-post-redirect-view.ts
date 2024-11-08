export default {
  redirectAppViewRefs: [
    {
      realTitle: '讨论编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.DISCUSS_POST.EDITVIEW',
      },
      refAppViewId: 'plmweb.discuss_post_edit_view',
      name: 'DISCUSS_POST:EDITVIEW',
      id: 'discuss_post:editview',
    },
    {
      realTitle: '讨论编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.DISCUSS_POST.EDITVIEW',
      },
      refAppViewId: 'plmweb.discuss_post_edit_view',
      name: 'EDITVIEW',
      id: 'editview',
    },
  ],
  enableWorkflow: true,
  funcViewMode: 'REDIRECTVIEW',
  deviewCodeName: 'RedirectView',
  deviewId: '131c270cb5558ecc5b071a2a28f096ae',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.DISCUSS_POST',
  },
  caption: '讨论',
  codeName: 'discuss_post_redirect_view',
  appDataEntityId: 'plmweb.discuss_post',
  controls: [
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.DISCUSS_POST',
      },
      caption: '讨论',
      codeName: 'redirect_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.discuss_post',
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
    appDataEntityId: 'plmweb.discuss_post',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '讨论数据重定向视图',
  titleLanguageRes: {
    lanResTag: 'PAGE.TITLE.DISCUSS_POST.REDIRECTVIEW',
  },
  viewStyle: 'DEFAULT',
  viewType: 'DEREDIRECTVIEW',
  enableDP: true,
  redirectView: true,
  showCaptionBar: true,
  modelId: '3c8c314162641311cb8d51adb3e60404',
  modelType: 'PSAPPDEVIEW',
  name: 'discuss_postRedirectView',
  id: 'plmweb.discuss_post_redirect_view',
};
