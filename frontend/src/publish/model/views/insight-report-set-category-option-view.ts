export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  openMode: 'POPUPMODAL',
  deviewCodeName: 'set_category_option_view',
  deviewId: '9B0A4428-A1CE-4672-B9C0-CC519D3EAC4C',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.INSIGHT_REPORT',
  },
  caption: '设置类别',
  codeName: 'insight_report_set_category_option_view',
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
              dataType: 21,
              enableCond: 3,
              labelPos: 'TOP',
              labelWidth: 130,
              noPrivDisplayMode: 1,
              appDEFieldId: 'categories_name',
              editor: {
                singleSelect: true,
                appCodeListId: 'plmweb.prodmgmt__category',
                editorParams: {
                  'srfnavparam.n_owner_id_eq': '%insight_view%',
                },
                editorType: 'DROPDOWNLIST',
                editorItems: [
                  {
                    id: 'categories',
                  },
                ],
                placeHolder: '请选择类别',
                valueType: 'SIMPLE',
                editable: true,
                navigateParams: [
                  {
                    key: 'n_owner_id_eq',
                    value: 'insight_view',
                    id: 'n_owner_id_eq',
                  },
                ],
                id: 'categories_name',
              },
              allowEmpty: true,
              needCodeListConfig: true,
              caption: '类别',
              codeName: 'categories_name',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'categories_name',
            },
            {
              dataType: 25,
              enableCond: 3,
              labelPos: 'LEFT',
              labelWidth: 130,
              noPrivDisplayMode: 1,
              appDEFieldId: 'categories',
              editor: {
                editorType: 'HIDDEN',
                valueType: 'SIMPLE',
                editable: true,
                id: 'categories',
              },
              allowEmpty: true,
              hidden: true,
              caption: '类别',
              codeName: 'categories',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              id: 'categories',
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
      codeName: 'set_category_option_view_form',
      controlType: 'FORM',
      logicName: '设置类别选项操作视图_表单',
      appDataEntityId: 'plmweb.insight_report',
      controlParam: {
        id: 'form',
      },
      modelId: '3D9407FC-516A-47FB-B4DF-FF4680BCDADE',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.insight_report.set_category_option_view_form',
    },
    {
      codeName: 'set_category_option_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.insight_report',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'set_category_option_view_datainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.INSIGHT_REPORT',
      },
      caption: '设置类别',
      codeName: 'set_category_option_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.insight_report',
      controlParam: {},
      name: 'captionbar',
      id: 'set_category_option_view_captionbar',
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
  title: '设置类别',
  viewStyle: 'DEFAULT',
  viewType: 'DEOPTVIEW',
  width: 600,
  enableDP: true,
  showCaptionBar: true,
  modelId: '40f4b190400b24bfccd8a86c87e00fd0',
  modelType: 'PSAPPDEVIEW',
  name: 'insight_reportset_category_option_view',
  id: 'plmweb.insight_report_set_category_option_view',
};