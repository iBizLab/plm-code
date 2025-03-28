export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  openMode: 'POPUPMODAL',
  deviewCodeName: 'quick_create_view',
  deviewId: '84b8d53c613984cf36f39ec71b6eeb34',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.INSIGHT_REPORT',
  },
  caption: '新建报表',
  codeName: 'insight_report_quick_create_view',
  height: 200,
  appDataEntityId: 'plmweb.insight_report',
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
        appDEMethodId: 'create',
        appDataEntityId: 'plmweb.insight_report',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.insight_report',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'get_draft',
        appDataEntityId: 'plmweb.insight_report',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.insight_report',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.insight_report',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.insight_report',
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
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'name',
                  editor: {
                    maxLength: 200,
                    editorType: 'TEXTBOX',
                    placeHolder: '输入报表名称',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'name',
                  },
                  capLanguageRes: {
                    lanResTag: 'DEF.LNAME.NAME',
                  },
                  caption: '报表名称',
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
              caption: '效能报表基本信息',
              codeName: 'group1',
              detailStyle: 'DEFAULT',
              detailType: 'GROUPPANEL',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
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
      codeName: 'quick_create_view_form',
      controlType: 'FORM',
      logicName: '效能报表快速建立视图_表单',
      appDataEntityId: 'plmweb.insight_report',
      controlParam: {
        id: 'form',
      },
      modelId: '4a43548027e813326b6f60d075bd41ab',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.insight_report.quick_create_view_form',
    },
    {
      codeName: 'quick_create_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.insight_report',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'quick_create_view_datainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.INSIGHT_REPORT',
      },
      caption: '新建报表',
      codeName: 'quick_create_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.insight_report',
      controlParam: {},
      name: 'captionbar',
      id: 'quick_create_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEOPTVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.insight_report',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '效能报表',
  viewStyle: 'DEFAULT',
  viewType: 'DEOPTVIEW',
  width: 600,
  enableDP: true,
  showCaptionBar: true,
  modelId: '41a86991453c780c6dcf708986991b34',
  modelType: 'PSAPPDEVIEW',
  name: 'insight_reportquick_create_view',
  id: 'plmweb.insight_report_quick_create_view',
};
