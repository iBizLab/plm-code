export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  openMode: 'POPUPMODAL',
  deviewCodeName: 'members_distribution_option_view',
  deviewId: 'A40063AB-BBC2-463E-9D08-28DA11F40FCE',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.RUN',
  },
  caption: '编辑部件',
  codeName: 'run_members_distribution_option_view',
  height: 200,
  appDataEntityId: 'plmweb.run',
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
        appDataEntityId: 'plmweb.run',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.run',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'get_draft',
        appDataEntityId: 'plmweb.run',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.run',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.run',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.run',
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
              labelPos: 'LEFT',
              labelWidth: 130,
              noPrivDisplayMode: 1,
              editor: {
                editorType: 'TEXTBOX',
                valueType: 'SIMPLE',
                editable: true,
                id: 'srftitle',
              },
              caption: '部件名称',
              codeName: 'srftitle',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'srftitle',
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
      codeName: 'usr04307192_form',
      controlType: 'FORM',
      logicName: '成员执行情况选项操作视图_表单',
      appDataEntityId: 'plmweb.run',
      controlParam: {
        id: 'form',
      },
      modelId: '10A3699C-57AA-4703-87AC-AD4D99D18AA8',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.run.usr04307192_form',
    },
    {
      codeName: 'members_distribution_option_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.run',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'members_distribution_option_view_datainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.RUN',
      },
      caption: '编辑部件',
      codeName: 'members_distribution_option_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.run',
      controlParam: {},
      name: 'captionbar',
      id: 'members_distribution_option_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEOPTVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.run',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '成员执行情况选项操作视图',
  viewStyle: 'DEFAULT',
  viewType: 'DEOPTVIEW',
  width: 500,
  enableDP: true,
  showCaptionBar: true,
  modelId: 'aae0cc4c7c16f964ebfc7fc3492e9081',
  modelType: 'PSAPPDEVIEW',
  name: 'runmembers_distribution_option_view',
  id: 'plmweb.run_members_distribution_option_view',
};