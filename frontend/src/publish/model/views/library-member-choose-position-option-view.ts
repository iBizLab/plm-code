export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  openMode: 'POPUPMODAL',
  deviewCodeName: 'choose_position_option_view',
  deviewId: 'f19880dcb55ef9467d694cd9951524b5',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.LIBRARY_MEMBER',
  },
  caption: '职位选择',
  codeName: 'library_member_choose_position_option_view',
  height: 220,
  appDataEntityId: 'plmweb.library_member',
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
        appDataEntityId: 'plmweb.library_member',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.library_member',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'get_draft',
        appDataEntityId: 'plmweb.library_member',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'nothing',
        appDataEntityId: 'plmweb.library_member',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.library_member',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'nothing',
        appDataEntityId: 'plmweb.library_member',
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
      codeName: 'usr12129613_form',
      controlType: 'FORM',
      logicName: '测试库成员选择职位选项操作视图_表单',
      appDataEntityId: 'plmweb.library_member',
      controlParam: {
        id: 'form',
      },
      modelId: '2fbc5eedc9e2cc886c7bfc41679b6b9a',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.library_member.usr12129613_form',
    },
    {
      codeName: 'choose_position_option_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.library_member',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'choose_position_option_view_datainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.LIBRARY_MEMBER',
      },
      caption: '职位选择',
      codeName: 'choose_position_option_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.library_member',
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
    appDataEntityId: 'plmweb.library_member',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '选择职位',
  viewStyle: 'DEFAULT',
  viewType: 'DEOPTVIEW',
  width: 400,
  enableDP: true,
  showCaptionBar: true,
  modelId: 'd3a627783b66ed6e8ee9b27633268e9e',
  modelType: 'PSAPPDEVIEW',
  name: 'library_memberchoose_position_option_view',
  id: 'plmweb.library_member_choose_position_option_view',
};
