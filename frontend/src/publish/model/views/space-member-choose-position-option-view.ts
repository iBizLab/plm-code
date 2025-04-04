export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  openMode: 'POPUPMODAL',
  deviewCodeName: 'choose_position_option_view',
  deviewId: '446ee3c079ccf4e8217c7317e1c43169',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.SPACE_MEMBER',
  },
  caption: '职位选择',
  codeName: 'space_member_choose_position_option_view',
  height: 220,
  appDataEntityId: 'plmweb.space_member',
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
        appDataEntityId: 'plmweb.space_member',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.space_member',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'get_draft',
        appDataEntityId: 'plmweb.space_member',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'nothing',
        appDataEntityId: 'plmweb.space_member',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.space_member',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'nothing',
        appDataEntityId: 'plmweb.space_member',
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
              fieldName: 'target_title',
              labelPos: 'TOP',
              labelWidth: 130,
              noPrivDisplayMode: 1,
              editor: {
                singleSelect: true,
                appCodeListId: 'plmweb.base__position',
                editorType: 'DROPDOWNLIST',
                placeHolder: '请选择职位',
                valueType: 'SIMPLE',
                editable: true,
                id: 'target_title',
              },
              allowEmpty: true,
              needCodeListConfig: true,
              caption: '职位',
              codeName: 'target_title',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'target_title',
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
      codeName: 'usr12128313_form',
      controlType: 'FORM',
      logicName: '空间成员选择职位选项操作视图_表单',
      appDataEntityId: 'plmweb.space_member',
      controlParam: {
        id: 'form',
      },
      modelId: 'c53282b03ed0b9bff4c87971843a78ce',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.space_member.usr12128313_form',
    },
    {
      codeName: 'choose_position_option_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.space_member',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'choose_position_option_view_datainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.SPACE_MEMBER',
      },
      caption: '职位选择',
      codeName: 'choose_position_option_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.space_member',
      controlParam: {},
      name: 'captionbar',
      id: 'choose_position_option_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEOPTVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.space_member',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '职位选择',
  viewStyle: 'DEFAULT',
  viewType: 'DEOPTVIEW',
  width: 400,
  enableDP: true,
  showCaptionBar: true,
  modelId: 'adac7cc40c8d6002e5c7074e9b1e1882',
  modelType: 'PSAPPDEVIEW',
  name: 'space_memberchoose_position_option_view',
  id: 'plmweb.space_member_choose_position_option_view',
};
