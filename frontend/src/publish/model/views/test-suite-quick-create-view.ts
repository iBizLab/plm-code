export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  openMode: 'POPUPMODAL',
  deviewCodeName: 'quick_create_view',
  deviewId: 'f7250b78f92d43b040929173e1b6ee8a',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.TEST_SUITE',
  },
  caption: '新建用例模块',
  codeName: 'test_suite_quick_create_view',
  height: 300,
  appDataEntityId: 'plmweb.test_suite',
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
        appDataEntityId: 'plmweb.test_suite',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.test_suite',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'get_draft',
        appDataEntityId: 'plmweb.test_suite',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.test_suite',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.test_suite',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.test_suite',
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
                  appDEFieldId: 'pname',
                  editor: {
                    enablePickupView: true,
                    singleSelect: true,
                    pickupAppViewId: 'plmweb.test_suite_pick_up_view',
                    handlerType: 'PickupText',
                    appDEACModeId: 'default',
                    appDEDataSetId: 'fetch_default',
                    appDataEntityId: 'plmweb.test_suite',
                    enableAC: true,
                    forceSelection: true,
                    showTrigger: true,
                    valueItemName: 'pid',
                    editorParams: {
                      AC: 'TRUE',
                      PICKUPVIEW: 'TRUE',
                    },
                    editorType: 'PICKER',
                    editorItems: [
                      {
                        id: 'pid',
                      },
                    ],
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'pname',
                  },
                  allowEmpty: true,
                  caption: '上级模块',
                  codeName: 'pname',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'pname',
                },
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
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'name',
                  },
                  capLanguageRes: {
                    lanResTag: 'DEF.LNAME.NAME',
                  },
                  caption: '模块名称',
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
              caption: '用例模块基本信息',
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
              appDEFieldId: 'pid',
              editor: {
                editorType: 'HIDDEN',
                valueType: 'SIMPLE',
                editable: true,
                id: 'pid',
              },
              allowEmpty: true,
              hidden: true,
              caption: '父标识',
              codeName: 'pid',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'pid',
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
      logicName: '用例模块快速建立视图_表单',
      appDataEntityId: 'plmweb.test_suite',
      controlParam: {
        id: 'form',
      },
      modelId: '608eab45f885c519d12b9cede7df009e',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.test_suite.quick_create_view_form',
    },
    {
      codeName: 'quick_create_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.test_suite',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'quick_create_view_datainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.TEST_SUITE',
      },
      caption: '新建用例模块',
      codeName: 'quick_create_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.test_suite',
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
    appDataEntityId: 'plmweb.test_suite',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '新建用例模块',
  viewStyle: 'DEFAULT',
  viewType: 'DEOPTVIEW',
  width: 300,
  enableDP: true,
  showCaptionBar: true,
  modelId: 'ed596c7a88cb9a4a688db1f51555d414',
  modelType: 'PSAPPDEVIEW',
  name: 'test_suitequick_create_view',
  id: 'plmweb.test_suite_quick_create_view',
};