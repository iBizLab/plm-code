export default {
  redirectAppViewRefs: [
    {
      realTitle: '话题编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.DISCUSS_TOPIC.EDITVIEW',
      },
      refAppViewId: 'plmweb.discuss_topic_edit_view',
      name: 'DISCUSS_TOPIC:EDITVIEW',
      id: 'discuss_topic:editview',
    },
    {
      realTitle: '话题编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.DISCUSS_TOPIC.EDITVIEW',
      },
      refAppViewId: 'plmweb.discuss_topic_edit_view',
      name: 'EDITVIEW',
      id: 'editview',
    },
  ],
  enableWorkflow: true,
  funcViewMode: 'REDIRECTVIEW',
  deviewCodeName: 'RedirectView',
  deviewId: '0b622557533ea7d64e879f054719d993',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.DISCUSS_TOPIC',
  },
  caption: '话题',
  codeName: 'discuss_topic_redirect_view',
  appDataEntityId: 'plmweb.discuss_topic',
  controls: [
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.DISCUSS_TOPIC',
      },
      caption: '话题',
      codeName: 'redirect_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.discuss_topic',
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
    appDataEntityId: 'plmweb.discuss_topic',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '话题数据重定向视图',
  titleLanguageRes: {
    lanResTag: 'PAGE.TITLE.DISCUSS_TOPIC.REDIRECTVIEW',
  },
  viewStyle: 'DEFAULT',
  viewType: 'DEREDIRECTVIEW',
  enableDP: true,
  redirectView: true,
  showCaptionBar: true,
  modelId: '184d4e1377f0d7a8c6e4e6084c18b0a7',
  modelType: 'PSAPPDEVIEW',
  name: 'discuss_topicRedirectView',
  id: 'plmweb.discuss_topic_redirect_view',
};