export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  openMode: 'POPUPMODAL',
  deviewCodeName: 'update_view',
  deviewId: '345cc06d47a548bc5a98aa74d1a2078c',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.GROUP',
  },
  caption: '编辑团队',
  codeName: 'group_update_view',
  height: 600,
  appDataEntityId: 'plmweb.group',
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
        appDataEntityId: 'plmweb.group',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.group',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'get_draft',
        appDataEntityId: 'plmweb.group',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.group',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.group',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.group',
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
                    placeHolder: '输入团队名称',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'name',
                  },
                  capLanguageRes: {
                    lanResTag: 'DEF.LNAME.NAME',
                  },
                  caption: '团队名称',
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
                {
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'avatar',
                  editor: {
                    maxFileCount: 1,
                    editorParams: {
                      MAXCOUNT: '1',
                    },
                    editorType: 'PICTURE_ONE',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'avatar',
                  },
                  allowEmpty: true,
                  caption: '团队头像',
                  codeName: 'avatar',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'avatar',
                },
                {
                  createDV: 'private',
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
                  updateDV: 'private',
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
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'section_name',
                  editor: {
                    enablePickupView: true,
                    singleSelect: true,
                    pickupAppViewId: 'plmweb.section_pick_up_view',
                    handlerType: 'PickupText',
                    appDEACModeId: 'default',
                    appDEDataSetId: 'fetch_default',
                    appDataEntityId: 'plmweb.section',
                    enableAC: true,
                    forceSelection: true,
                    showTrigger: true,
                    valueItemName: 'section_id',
                    editorParams: {
                      'SRFNAVPARAM.n_owner_id_eq': 'group',
                      AC: 'TRUE',
                      PICKUPVIEW: 'TRUE',
                    },
                    editorType: 'PICKER',
                    editorItems: [
                      {
                        id: 'section_id',
                      },
                    ],
                    placeHolder: '选择所属分组',
                    valueType: 'SIMPLE',
                    editable: true,
                    navigateParams: [
                      {
                        key: 'n_owner_id_eq',
                        value: 'group',
                        rawValue: true,
                        id: 'n_owner_id_eq',
                      },
                    ],
                    id: 'section_name',
                  },
                  allowEmpty: true,
                  caption: '所属分组',
                  codeName: 'section_name',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'section_name',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'description',
                  editor: {
                    maxLength: 2000,
                    showMaxLength: true,
                    editorType: 'TEXTAREA',
                    placeHolder: '输入描述',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'description',
                  },
                  allowEmpty: true,
                  capLanguageRes: {
                    lanResTag: 'DEF.LNAME.DESCRIPTION',
                  },
                  caption: '描述',
                  codeName: 'description',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'description',
                },
              ],
              capLanguageRes: {
                lanResTag: 'CONTROL.DEFORM.GROUP.MAIN.GROUPPANEL.GROUP1',
              },
              caption: '团队基本信息',
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
              appDEFieldId: 'section_id',
              editor: {
                editorType: 'HIDDEN',
                valueType: 'SIMPLE',
                editable: true,
                id: 'section_id',
              },
              allowEmpty: true,
              hidden: true,
              caption: '分组标识',
              codeName: 'section_id',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              id: 'section_id',
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
            lanResTag: 'CONTROL.DEFORM.GROUP.MAIN.FORMPAGE.FORMPAGE1',
          },
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
      codeName: 'main',
      controlType: 'FORM',
      logicName: '主编辑表单',
      appDataEntityId: 'plmweb.group',
      controlParam: {
        id: 'form',
      },
      modelId: '3c724ea6a78484a7c8064fe940ce0e4c',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.group.main',
    },
    {
      codeName: 'update_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.group',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'update_view_datainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.GROUP',
      },
      caption: '编辑团队',
      codeName: 'update_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.group',
      controlParam: {},
      name: 'captionbar',
      id: 'update_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEOPTVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.group',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '编辑团队',
  viewStyle: 'DEFAULT',
  viewType: 'DEOPTVIEW',
  width: 800,
  enableDP: true,
  showCaptionBar: true,
  modelId: '0578e3e380fa356d1cb3ff6eb1fedddb',
  modelType: 'PSAPPDEVIEW',
  name: 'groupupdate_view',
  id: 'plmweb.group_update_view',
};
