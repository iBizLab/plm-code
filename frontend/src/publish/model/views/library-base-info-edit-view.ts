export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  deviewCodeName: 'base_info_edit_view',
  deviewId: 'b67b7b9c5f68cc4ee96894a360e43160',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.LIBRARY',
  },
  caption: '基本信息',
  codeName: 'library_base_info_edit_view',
  appDataEntityId: 'plmweb.library',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'EditView',
      id: 'engine',
    },
  ],
  controls: [
    {
      createControlAction: {
        appDEMethodId: 'create',
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
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.library',
        id: 'update',
      },
      deformItemVRs: [
        {
          checkMode: 1,
          deformItemName: 'identifier',
          sysValueRule: {
            codeName: 'UsrValueRule0312488358',
            regExCode: '^[A-Z0-9]{1,15}$',
            ruleInfo: '请填写大写字母和数字',
            ruleType: 'REGEX',
            name: '大写字母和数字',
            id: 'usrvaluerule0312488358',
          },
          valueRuleType: 'SYSVALUERULE',
          id: '表单项值规则',
        },
      ],
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
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'name',
                  },
                  capLanguageRes: {
                    lanResTag: 'DEF.LNAME.NAME',
                  },
                  caption: '测试库名称',
                  codeName: 'name',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colLG: 6,
                    colMD: 6,
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
                  appDEFieldId: 'identifier',
                  editor: {
                    maxLength: 15,
                    sysValueRule: {
                      codeName: 'UsrValueRule0312488358',
                      regExCode: '^[A-Z0-9]{1,15}$',
                      ruleInfo: '请填写大写字母和数字',
                      ruleType: 'REGEX',
                      name: '大写字母和数字',
                      id: 'plmweb.usrvaluerule0312488358',
                    },
                    editorType: 'TEXTBOX',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'identifier',
                  },
                  caption: '测试库标识',
                  codeName: 'identifier',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colLG: 6,
                    colMD: 6,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'identifier',
                },
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
                        colLG: 12,
                        colMD: 12,
                        layout: 'TABLE_24COL',
                      },
                      showCaption: true,
                      id: 'visibility',
                    },
                  ],
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
                  itemHeight: 220,
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'description',
                  editor: {
                    maxLength: 2000,
                    showMaxLength: true,
                    editorHeight: 200,
                    editorParams: {
                      HEIGHT: '200',
                    },
                    editorType: 'TEXTAREA_10',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'description',
                  },
                  allowEmpty: true,
                  caption: '描述',
                  codeName: 'description',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colLG: 12,
                    colMD: 12,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'description',
                },
                {
                  layout: {
                    columnCount: 24,
                    layout: 'TABLE_24COL',
                  },
                  deformDetails: [
                    {
                      actionType: 'UIACTION',
                      uiactionId: 'save',
                      tooltip: '确定',
                      capLanguageRes: {
                        lanResTag: 'TBB.TEXT.*.SAVE',
                      },
                      caption: '确定',
                      codeName: 'button1',
                      detailStyle: 'DEFAULT',
                      detailType: 'BUTTON',
                      layoutPos: {
                        colLG: 2,
                        colMD: 2,
                        layout: 'TABLE_24COL',
                      },
                      sysImage: {
                        cssClass: 'fa fa-save',
                        glyph: 'xf0c7@FontAwesome',
                      },
                      showCaption: true,
                      id: 'button1',
                    },
                  ],
                  codeName: 'grouppanel2',
                  detailStyle: 'DEFAULT',
                  detailType: 'GROUPPANEL',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  id: 'grouppanel2',
                },
              ],
              caption: '基本信息',
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
      codeName: 'base_info',
      controlType: 'FORM',
      logicName: '基本信息',
      appDataEntityId: 'plmweb.library',
      controlParam: {
        id: 'form',
      },
      modelId: '6e082385e843a5853eab5e451a0dc49d',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.library.base_info',
    },
    {
      codeName: 'base_info_edit_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.library',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'base_info_edit_view_datainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.LIBRARY',
      },
      caption: '基本信息',
      codeName: 'base_info_edit_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.library',
      controlParam: {},
      name: 'captionbar',
      id: 'base_info_edit_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEEDITVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.library',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '基本信息',
  viewStyle: 'DEFAULT',
  viewType: 'DEEDITVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '758da90a5eff6e1e4c7aa43cb4ab86d4',
  modelType: 'PSAPPDEVIEW',
  name: 'librarybase_info_edit_view',
  id: 'plmweb.library_base_info_edit_view',
};