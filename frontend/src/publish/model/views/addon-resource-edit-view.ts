export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  funcViewMode: 'EDITVIEW',
  deviewCodeName: 'EditView',
  deviewId: '11210bea475f58d45f616859cb73e018',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.ADDON_RESOURCE',
  },
  caption: '资源组件',
  codeName: 'addon_resource_edit_view',
  appDataEntityId: 'plmweb.addon_resource',
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
      appDataEntityId: 'plmweb.addon_resource',
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
        appDataEntityId: 'plmweb.addon_resource',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.addon_resource',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'get_draft',
        appDataEntityId: 'plmweb.addon_resource',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.addon_resource',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.addon_resource',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.addon_resource',
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
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'name',
                },
              ],
              capLanguageRes: {
                lanResTag:
                  'CONTROL.DEFORM.ADDON_RESOURCE.MAIN.GROUPPANEL.GROUP1',
              },
              caption: '资源组件基本信息',
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
            lanResTag: 'CONTROL.DEFORM.ADDON_RESOURCE.MAIN.FORMPAGE.FORMPAGE1',
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
                  'CONTROL.DEFORM.ADDON_RESOURCE.MAIN.GROUPPANEL.GROUP2',
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
            lanResTag: 'CONTROL.DEFORM.ADDON_RESOURCE.MAIN.FORMPAGE.FORMPAGE2',
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
      appDataEntityId: 'plmweb.addon_resource',
      controlParam: {
        id: 'form',
      },
      modelId: 'f77c281dbca0a79dad1aebf392c8b678',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.addon_resource.main',
    },
    {
      codeName: 'edit_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.addon_resource',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'edit_view_datainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.ADDON_RESOURCE',
      },
      caption: '资源组件',
      codeName: 'edit_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.addon_resource',
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
    appDataEntityId: 'plmweb.addon_resource',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '资源组件编辑视图',
  titleLanguageRes: {
    lanResTag: 'PAGE.TITLE.ADDON_RESOURCE.EDITVIEW',
  },
  viewStyle: 'DEFAULT',
  viewType: 'DEEDITVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: 'c73ed01a2d26ca42a38c055d8766b99e',
  modelType: 'PSAPPDEVIEW',
  name: 'addon_resourceEditView',
  id: 'plmweb.addon_resource_edit_view',
};