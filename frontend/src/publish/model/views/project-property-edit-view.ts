export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  deviewCodeName: 'property_edit_view',
  deviewId: '0B9096B4-FACE-4F49-A845-A3B03957F01C',
  accUserMode: 2,
  caption: '项目属性',
  codeName: 'project_property_edit_view',
  appDataEntityId: 'plmweb.project',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'EditView',
      id: 'engine',
    },
  ],
  controls: [
    {
      xdataControlName: 'form',
      codeName: 'property_edit_view_toolbar',
      controlType: 'TOOLBAR',
      logicName: '项目动态属性编辑视图（呈现）_工具栏',
      appDataEntityId: 'plmweb.project',
      controlParam: {
        id: 'toolbar',
      },
      modelId: '6EA908C3-424A-4FD2-951D-9A29C681F834',
      modelType: 'PSDETOOLBAR',
      name: 'toolbar',
      id: 'property_edit_view_toolbar',
    },
    {
      autoSaveMode: 1,
      createControlAction: {
        appDEMethodId: 'create',
        appDataEntityId: 'plmweb.project',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.project',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'get_draft',
        appDataEntityId: 'plmweb.project',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.project',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.project',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.project',
        id: 'update',
      },
      enableAutoSave: true,
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
              appDEFieldId: 'type',
              editor: {
                singleSelect: true,
                handlerType: 'PickupText',
                enableAC: true,
                forceSelection: true,
                showTrigger: true,
                editorParams: {
                  AC: 'TRUE',
                  TRIGGER: 'TRUE',
                  PICKUPVIEW: 'FALSE',
                },
                editorType: 'PICKEREX_TRIGGER',
                valueType: 'SIMPLE',
                editable: true,
                id: 'type',
              },
              allowEmpty: true,
              capLanguageRes: {
                lanResTag: 'DEF.LNAME.TYPE',
              },
              caption: '类型',
              codeName: 'type',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'type',
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
      codeName: 'usr06271954_edit_view_form',
      controlStyle: 'PROJECT_ATTRIBUTES',
      controlType: 'FORM',
      logicName: '项目动态属性编辑视图（呈现）_表单',
      appDataEntityId: 'plmweb.project',
      controlParam: {
        id: 'form',
      },
      sysPFPluginId: 'project_attributes',
      modelId: '5981C477-57E9-40FD-AD88-33EC7659EF1C',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.project.usr06271954_edit_view_form',
    },
    {
      codeName: 'property_edit_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.project',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'property_edit_view_datainfobar',
    },
    {
      caption: '项目属性',
      codeName: 'property_edit_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.project',
      controlParam: {},
      name: 'captionbar',
      id: 'property_edit_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEEDITVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.project',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '项目动态属性呈现',
  viewStyle: 'DEFAULT',
  viewType: 'DEEDITVIEW',
  enableDP: true,
  showCaptionBar: false,
  modelId: '469242e9d14cfc86f8fe3a96716c7707',
  modelType: 'PSAPPDEVIEW',
  name: 'projectproperty_edit_view',
  id: 'plmweb.project_property_edit_view',
};