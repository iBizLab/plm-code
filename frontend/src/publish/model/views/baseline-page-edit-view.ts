export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  funcViewMode: 'EDITVIEW',
  deviewCodeName: 'EditView',
  deviewId: '2e1162c2cb559489cb106dd3bdd30a94',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.BASELINE_PAGE',
  },
  caption: '基线页面',
  codeName: 'baseline_page_edit_view',
  appDataEntityId: 'plmweb.baseline_page',
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
      appDataEntityId: 'plmweb.baseline_page',
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
        appDataEntityId: 'plmweb.baseline_page',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.baseline_page',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'get_draft',
        appDataEntityId: 'plmweb.baseline_page',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.baseline_page',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.baseline_page',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.baseline_page',
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
                  'CONTROL.DEFORM.BASELINE_PAGE.MAIN.GROUPPANEL.GROUP1',
              },
              caption: '基线页面基本信息',
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
            lanResTag: 'CONTROL.DEFORM.BASELINE_PAGE.MAIN.FORMPAGE.FORMPAGE1',
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
                  'CONTROL.DEFORM.BASELINE_PAGE.MAIN.GROUPPANEL.GROUP2',
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
            lanResTag: 'CONTROL.DEFORM.BASELINE_PAGE.MAIN.FORMPAGE.FORMPAGE2',
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
      appDataEntityId: 'plmweb.baseline_page',
      controlParam: {
        id: 'form',
      },
      modelId: '8ba2cc25876b418e8527a1050ac58395',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.baseline_page.main',
    },
    {
      codeName: 'edit_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.baseline_page',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'edit_view_datainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.BASELINE_PAGE',
      },
      caption: '基线页面',
      codeName: 'edit_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.baseline_page',
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
    appDataEntityId: 'plmweb.baseline_page',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '基线页面编辑视图',
  titleLanguageRes: {
    lanResTag: 'PAGE.TITLE.BASELINE_PAGE.EDITVIEW',
  },
  viewStyle: 'DEFAULT',
  viewType: 'DEEDITVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: 'd23217df04d8d53c96382b414706c6d7',
  modelType: 'PSAPPDEVIEW',
  name: 'baseline_pageEditView',
  id: 'plmweb.baseline_page_edit_view',
};
