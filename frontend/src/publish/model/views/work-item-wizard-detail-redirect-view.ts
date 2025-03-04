export default {
  redirectAppViewRefs: [
    {
      realTitle: '工作项操作向导成员编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.WORK_ITEM_WIZARD_DETAIL.EDITVIEW',
      },
      refAppViewId: 'plmweb.work_item_wizard_detail_edit_view',
      name: 'WORK_ITEM_WIZARD_DETAIL:EDITVIEW',
      id: 'work_item_wizard_detail:editview',
    },
    {
      realTitle: '工作项操作向导成员编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.WORK_ITEM_WIZARD_DETAIL.EDITVIEW',
      },
      refAppViewId: 'plmweb.work_item_wizard_detail_edit_view',
      name: 'EDITVIEW',
      id: 'editview',
    },
  ],
  enableWorkflow: true,
  funcViewMode: 'REDIRECTVIEW',
  deviewCodeName: 'RedirectView',
  deviewId: '3be86aa0fe47c764192a2f017455d65f',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.WORK_ITEM_WIZARD_DETAIL',
  },
  caption: '工作项操作向导明细',
  codeName: 'work_item_wizard_detail_redirect_view',
  appDataEntityId: 'plmweb.work_item_wizard_detail',
  controls: [
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.WORK_ITEM_WIZARD_DETAIL',
      },
      caption: '工作项操作向导明细',
      codeName: 'redirect_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.work_item_wizard_detail',
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
    appDataEntityId: 'plmweb.work_item_wizard_detail',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '工作项操作向导成员数据重定向视图',
  titleLanguageRes: {
    lanResTag: 'PAGE.TITLE.WORK_ITEM_WIZARD_DETAIL.REDIRECTVIEW',
  },
  viewStyle: 'DEFAULT',
  viewType: 'DEREDIRECTVIEW',
  enableDP: true,
  redirectView: true,
  showCaptionBar: true,
  modelId: 'f2521af08d49e316ce58059c1419ca72',
  modelType: 'PSAPPDEVIEW',
  name: 'work_item_wizard_detailRedirectView',
  id: 'plmweb.work_item_wizard_detail_redirect_view',
};
