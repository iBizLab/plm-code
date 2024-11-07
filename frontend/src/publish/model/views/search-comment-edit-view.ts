export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  funcViewMode: 'EDITVIEW',
  deviewCodeName: 'EditView',
  deviewId: '5c2991da14a081972fb9a7ce19056e68',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.SEARCH_COMMENT',
  },
  caption: '评论搜索',
  codeName: 'search_comment_edit_view',
  appDataEntityId: 'plmweb.search_comment',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'EditView',
      id: 'engine',
    },
  ],
  controls: [
    {
      detoolbarItems: [
        {
          actionLevel: 100,
          noPrivDisplayMode: 2,
          uiactionId: 'editview_saveandexitaction',
          valid: true,
          capLanguageRes: {
            lanResTag: 'TBB.TEXT.EDITVIEW.SAVEANDCLOSE',
          },
          caption: '保存',
          itemType: 'DEUIACTION',
          sysImage: {
            cssClass: 'fa fa-save',
            glyph: 'xf0c7@FontAwesome',
          },
          tooltip: '保存',
          tooltipLanguageRes: {
            lanResTag: 'TBB.TOOLTIP.EDITVIEW.SAVEANDCLOSE',
          },
          showCaption: true,
          showIcon: true,
          id: 'deuiaction1',
        },
      ],
      xdataControlName: 'form',
      codeName: 'edit_view_toolbar',
      controlType: 'TOOLBAR',
      logicName: '工具栏模板（默认编辑界面）',
      appDataEntityId: 'plmweb.search_comment',
      controlParam: {
        id: 'toolbar',
      },
      modelId: '48c8f789be8a5522d3003293c1cf2ffb',
      modelType: 'PSDETOOLBAR',
      name: 'toolbar',
      id: 'edit_view_toolbar',
    },
    {
      createControlAction: {
        appDEMethodId: 'create',
        appDataEntityId: 'plmweb.search_comment',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.search_comment',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'getdraft',
        appDataEntityId: 'plmweb.search_comment',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.search_comment',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.search_comment',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.search_comment',
        id: 'update',
      },
      deformPages: [
        {
          layout: {
            columnCount: 24,
            layout: 'TABLE_24COL',
          },
          deformDetails: [
            {
              layout: {
                columnCount: 24,
                layout: 'TABLE_24COL',
              },
              capLanguageRes: {
                lanResTag:
                  'CONTROL.DEFORM.SEARCH_COMMENT.MAIN.GROUPPANEL.GROUP1',
              },
              caption: '评论搜索基本信息',
              codeName: 'group1',
              detailStyle: 'DEFAULT',
              detailType: 'GROUPPANEL',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'group1',
            },
            {
              dataType: 25,
              enableCond: 3,
              labelPos: 'LEFT',
              labelWidth: 130,
              noPrivDisplayMode: 1,
              appDEFieldId: 'id',
              editor: {
                editorType: 'HIDDEN',
                valueType: 'SIMPLE',
                editable: true,
                id: 'id',
              },
              allowEmpty: true,
              hidden: true,
              capLanguageRes: {
                lanResTag: 'DEF.LNAME.ID',
              },
              caption: '标识',
              codeName: 'id',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              id: 'id',
            },
          ],
          capLanguageRes: {
            lanResTag: 'CONTROL.DEFORM.SEARCH_COMMENT.MAIN.FORMPAGE.FORMPAGE1',
          },
          caption: '基本信息',
          codeName: 'formpage1',
          detailStyle: 'DEFAULT',
          detailType: 'FORMPAGE',
          id: 'formpage1',
        },
        {
          layout: {
            columnCount: 24,
            layout: 'TABLE_24COL',
          },
          deformDetails: [
            {
              layout: {
                columnCount: 24,
                layout: 'TABLE_24COL',
              },
              capLanguageRes: {
                lanResTag:
                  'CONTROL.DEFORM.SEARCH_COMMENT.MAIN.GROUPPANEL.GROUP2',
              },
              caption: '操作信息',
              codeName: 'group2',
              detailStyle: 'DEFAULT',
              detailType: 'GROUPPANEL',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'group2',
            },
          ],
          capLanguageRes: {
            lanResTag: 'CONTROL.DEFORM.SEARCH_COMMENT.MAIN.FORMPAGE.FORMPAGE2',
          },
          caption: '其它',
          codeName: 'formpage2',
          detailStyle: 'DEFAULT',
          detailType: 'FORMPAGE',
          id: 'formpage2',
        },
      ],
      layout: {
        columnCount: 24,
        layout: 'TABLE_24COL',
      },
      tabHeaderPos: 'TOP',
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'main',
      controlType: 'FORM',
      logicName: '主编辑表单',
      appDataEntityId: 'plmweb.search_comment',
      controlParam: {
        id: 'form',
      },
      modelId: '870f83ec85e92ac941040c625e0bf810',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.search_comment.main',
    },
    {
      codeName: 'edit_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.search_comment',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'edit_view_datainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.SEARCH_COMMENT',
      },
      caption: '评论搜索',
      codeName: 'edit_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.search_comment',
      controlParam: {},
      name: 'captionbar',
      id: 'edit_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEEDITVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.search_comment',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '评论搜索编辑视图',
  titleLanguageRes: {
    lanResTag: 'PAGE.TITLE.SEARCH_COMMENT.EDITVIEW',
  },
  viewStyle: 'DEFAULT',
  viewType: 'DEEDITVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '859db8eeaa887a9c19dc7315678287d8',
  modelType: 'PSAPPDEVIEW',
  name: 'search_commentEditView',
  id: 'plmweb.search_comment_edit_view',
};
