export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  funcViewMode: 'EDITVIEW',
  deviewCodeName: 'EditView',
  deviewId: 'f477da0208199a1a7ee5816ad1fd72bb',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.VERSION',
  },
  caption: '版本',
  codeName: 'version_edit_view',
  appDataEntityId: 'plmweb.version',
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
          uiactionId: 'saveandexit',
          valid: true,
          capLanguageRes: {
            lanResTag: 'TBB.TEXT.EDITVIEW.SAVEANDCLOSE',
          },
          caption: '保存',
          itemType: 'DEUIACTION',
          sysImage: {
            cssClass: 'sx-tb-saveandclose',
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
      appDataEntityId: 'plmweb.version',
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
        appDataEntityId: 'plmweb.version',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.version',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'get_draft',
        appDataEntityId: 'plmweb.version',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.version',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.version',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.version',
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
              deformDetails: [
                {
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'LEFT',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'name',
                  editor: {
                    maxLength: 200,
                    editorType: 'TEXTBOX',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'name',
                  },
                  allowEmpty: true,
                  capLanguageRes: {
                    lanResTag: 'DEF.LNAME.NAME',
                  },
                  caption: '名称',
                  codeName: 'name',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colLG: 12,
                    colMD: 12,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'name',
                },
              ],
              capLanguageRes: {
                lanResTag: 'CONTROL.DEFORM.VERSION.MAIN.GROUPPANEL.GROUP1',
              },
              caption: '基本信息',
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
              showCaption: true,
              id: 'id',
            },
          ],
          capLanguageRes: {
            lanResTag: 'CONTROL.DEFORM.VERSION.MAIN.FORMPAGE.FORMPAGE1',
          },
          caption: '概览',
          codeName: 'formpage1',
          detailStyle: 'DEFAULT',
          detailType: 'FORMPAGE',
          id: 'formpage1',
        },
      ],
      layout: {
        columnCount: 24,
        layout: 'TABLE_24COL',
      },
      tabHeaderPos: 'TOP',
      noTabHeader: true,
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'main',
      controlType: 'FORM',
      logicName: '主编辑表单',
      appDataEntityId: 'plmweb.version',
      controlParam: {
        id: 'form',
      },
      modelId: '5234259897d1a73b79a9346e5da05fe9',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.version.main',
    },
    {
      codeName: 'edit_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.version',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'edit_view_datainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.VERSION',
      },
      caption: '版本',
      codeName: 'edit_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.version',
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
    appDataEntityId: 'plmweb.version',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '项目发布编辑视图',
  titleLanguageRes: {
    lanResTag: 'PAGE.TITLE.VERSION.EDITVIEW',
  },
  viewStyle: 'DEFAULT',
  viewType: 'DEEDITVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '3d97c61204eb6c4fdcc2ded40690b8b7',
  modelType: 'PSAPPDEVIEW',
  name: 'versionEditView',
  id: 'plmweb.version_edit_view',
};