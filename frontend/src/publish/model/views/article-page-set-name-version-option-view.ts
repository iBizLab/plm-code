export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  openMode: 'POPUPMODAL',
  deviewCodeName: 'set_name_version_option_view',
  deviewId: '6E7A4E34-4255-407D-BBD1-89DF9581347A',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.PAGE',
  },
  caption: '保存命名版本',
  codeName: 'article_page_set_name_version_option_view',
  height: 200,
  appDataEntityId: 'plmweb.article_page',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'OptionView',
      id: 'engine',
    },
  ],
  controls: [
    {
      createControlAction: {
        appDEMethodId: 'nothing',
        appDataEntityId: 'plmweb.article_page',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.article_page',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'get_draft',
        appDataEntityId: 'plmweb.article_page',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'nothing',
        appDataEntityId: 'plmweb.article_page',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.article_page',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'nothing',
        appDataEntityId: 'plmweb.article_page',
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
              dataType: 25,
              enableCond: 3,
              fieldName: 'version_name',
              labelPos: 'TOP',
              labelWidth: 130,
              noPrivDisplayMode: 1,
              editor: {
                editorType: 'TEXTBOX',
                valueType: 'SIMPLE',
                editable: true,
                id: 'version_name',
              },
              caption: '版本名称',
              codeName: 'version_name',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'version_name',
            },
            {
              createDV: 'page_version',
              createDVT: 'APPDATA',
              dataType: 25,
              enableCond: 3,
              fieldName: 'version_id',
              labelPos: 'LEFT',
              labelWidth: 130,
              noPrivDisplayMode: 1,
              editor: {
                editorType: 'HIDDEN',
                valueType: 'SIMPLE',
                editable: true,
                id: 'version',
              },
              updateDV: 'page_version',
              updateDVT: 'APPDATA',
              allowEmpty: true,
              hidden: true,
              caption: '当前版本',
              codeName: 'version',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              id: 'version',
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
          caption: '基本信息',
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
      codeName: 'usr06110734_form',
      controlType: 'FORM',
      logicName: '保存命名版本选项操作视图_表单',
      appDataEntityId: 'plmweb.article_page',
      controlParam: {
        id: 'form',
      },
      modelId: 'F27819BB-B2B9-465E-9497-4E7810E212CD',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.article_page.usr06110734_form',
    },
    {
      codeName: 'set_name_version_option_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.article_page',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'set_name_version_option_view_datainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.PAGE',
      },
      caption: '保存命名版本',
      codeName: 'set_name_version_option_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.article_page',
      controlParam: {},
      name: 'captionbar',
      id: 'set_name_version_option_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEOPTVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.article_page',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '保存命名版本',
  viewStyle: 'DEFAULT',
  viewType: 'DEOPTVIEW',
  width: 500,
  enableDP: true,
  showCaptionBar: true,
  modelId: '9c602bc73fba040a487de8e02b1d9d0f',
  modelType: 'PSAPPDEVIEW',
  name: 'article_pageset_name_version_option_view',
  id: 'plmweb.article_page_set_name_version_option_view',
};