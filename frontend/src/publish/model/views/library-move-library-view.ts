export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  openMode: 'POPUPMODAL',
  deviewCodeName: 'move_library_view',
  deviewId: '6CB8C861-95CA-496B-9120-B98B11ADC3A3',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.LIBRARY',
  },
  caption: '移动测试库',
  codeName: 'library_move_library_view',
  height: 350,
  appDataEntityId: 'plmweb.library',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'OptionView',
      id: 'engine',
    },
  ],
  appViewNavParams: [
    {
      key: 'srfdefaulttype',
      value: 'scope_type',
      id: 'srfdefaulttype',
    },
  ],
  controls: [
    {
      createControlAction: {
        appDEMethodId: 'nothing',
        appDataEntityId: 'plmweb.library',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.library',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'get_draft',
        appDataEntityId: 'plmweb.library',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.library',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.library',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'nothing',
        appDataEntityId: 'plmweb.library',
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
                  appDEFieldId: 'scope_id',
                  editor: {
                    editorType: 'HIDDEN',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'scope_id',
                  },
                  allowEmpty: true,
                  hidden: true,
                  caption: '所属对象',
                  codeName: 'scope_id',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  id: 'scope_id',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'scope_type',
                  editor: {
                    enablePickupView: true,
                    singleSelect: true,
                    handlerType: 'PickupText',
                    appDEACModeId: 'default',
                    appDEDataSetId: 'fetch_default',
                    appDataEntityId: 'plmweb.group',
                    enableAC: true,
                    forceSelection: true,
                    showTrigger: true,
                    valueItemName: 'scope_id',
                    editorParams: {
                      AC: 'TRUE',
                      fillMap:
                        '{"user":"user","user_group":"user_group","organization":"organization"}',
                      enablePerson: 'false',
                      PICKUPVIEW: 'TRUE',
                    },
                    editorStyle: 'TEAM_PICKER',
                    editorType: 'PICKER',
                    editorItems: [
                      {
                        id: 'scope_id',
                      },
                    ],
                    sysPFPluginId: 'team_picker',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'scope_type',
                  },
                  caption: '移动至所属',
                  codeName: 'scope_type',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'scope_type',
                },
              ],
              caption: '测试库信息',
              codeName: 'grouppanel1',
              detailStyle: 'DEFAULT',
              detailType: 'GROUPPANEL',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              id: 'grouppanel1',
            },
            {
              dataType: 25,
              enableCond: 3,
              labelPos: 'TOP',
              labelWidth: 130,
              noPrivDisplayMode: 1,
              appDEFieldId: 'visibility',
              editor: {
                singleSelect: true,
                appCodeListId: 'plmweb.visibility',
                editorType: 'DROPDOWNLIST',
                valueType: 'SIMPLE',
                editable: true,
                id: 'visibility',
              },
              needCodeListConfig: true,
              caption: '可见范围',
              codeName: 'visibility',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'visibility',
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
      codeName: 'move_library_view_form',
      controlType: 'FORM',
      logicName: '移动测试库视图_表单',
      appDataEntityId: 'plmweb.library',
      controlParam: {
        id: 'form',
      },
      modelId: '72FF1EF0-A374-4541-8132-32ADE71420DA',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.library.move_library_view_form',
    },
    {
      codeName: 'move_library_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.library',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'move_library_view_datainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.LIBRARY',
      },
      caption: '移动测试库',
      codeName: 'move_library_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.library',
      controlParam: {},
      name: 'captionbar',
      id: 'move_library_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEOPTVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.library',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '移动测试库',
  viewStyle: 'DEFAULT',
  viewType: 'DEOPTVIEW',
  width: 500,
  enableDP: true,
  showCaptionBar: true,
  modelId: '73f1363ae1ac185a3bf93a2ba66ccdf0',
  modelType: 'PSAPPDEVIEW',
  name: 'librarymove_library_view',
  id: 'plmweb.library_move_library_view',
};