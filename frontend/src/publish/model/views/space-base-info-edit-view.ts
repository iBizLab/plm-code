export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  deviewCodeName: 'base_info_edit_view',
  deviewId: '92de9919ed42f740b4b1ff98feecce6f',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.SPACE',
  },
  caption: '基本信息',
  codeName: 'space_base_info_edit_view',
  appDataEntityId: 'plmweb.space',
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
        appDataEntityId: 'plmweb.space',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.space',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'get_draft',
        appDataEntityId: 'plmweb.space',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.space',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.space',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.space',
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
                  caption: '空间名称',
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
                  capLanguageRes: {
                    lanResTag: 'DEF.LNAME.SPACE.IDENTIFIER',
                  },
                  caption: '空间标识',
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
                      capLanguageRes: {
                        lanResTag: 'DEF.LNAME.VISIBILITY',
                      },
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
                  codeName: 'grouppanel2',
                  detailStyle: 'DEFAULT',
                  detailType: 'GROUPPANEL',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  id: 'grouppanel2',
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
                      appDEFieldId: 'category_name',
                      editor: {
                        dropDownView: true,
                        enablePickupView: true,
                        singleSelect: true,
                        pickupAppViewId: 'plmweb.space_pick_up_tree_view',
                        handlerType: 'PickupText',
                        appDEACModeId: 'default',
                        appDEDataSetId: 'fetch_default',
                        appDataEntityId: 'plmweb.category',
                        forceSelection: true,
                        showTrigger: true,
                        valueItemName: 'category_id',
                        editorParams: {
                          DROPDOWNVIEW: 'TRUE',
                          AC: 'FALSE',
                          TRIGGER: 'TRUE',
                          PICKUPVIEW: 'TRUE',
                        },
                        editorType: 'PICKEREX_DROPDOWNVIEW',
                        editorItems: [
                          {
                            id: 'category_id',
                          },
                        ],
                        valueType: 'SIMPLE',
                        editable: true,
                        id: 'category_name',
                      },
                      allowEmpty: true,
                      caption: '分类',
                      codeName: 'category_name',
                      detailStyle: 'DEFAULT',
                      detailType: 'FORMITEM',
                      layoutPos: {
                        colLG: 12,
                        colMD: 24,
                        layout: 'TABLE_24COL',
                      },
                      showCaption: true,
                      id: 'category_name',
                    },
                  ],
                  codeName: 'grouppanel4',
                  detailStyle: 'DEFAULT',
                  detailType: 'GROUPPANEL',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  id: 'grouppanel4',
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
                  capLanguageRes: {
                    lanResTag: 'DEF.LNAME.DESCRIPTION',
                  },
                  caption: '描述',
                  codeName: 'description',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colLG: 12,
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'description',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'category_id',
                  editor: {
                    editorType: 'HIDDEN',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'category_id',
                  },
                  allowEmpty: true,
                  hidden: true,
                  caption: '分类ID',
                  codeName: 'category_id',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'category_id',
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
                  codeName: 'grouppanel3',
                  detailStyle: 'DEFAULT',
                  detailType: 'GROUPPANEL',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  id: 'grouppanel3',
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
      codeName: 'edit_view_base_info_form',
      controlType: 'FORM',
      logicName: '空间基本信息_表单',
      appDataEntityId: 'plmweb.space',
      controlParam: {
        id: 'form',
      },
      modelId: 'dbaca95726a3defcec35e9aaf84fa712',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.space.edit_view_base_info_form',
    },
    {
      codeName: 'base_info_edit_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.space',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'base_info_edit_view_datainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.SPACE',
      },
      caption: '基本信息',
      codeName: 'base_info_edit_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.space',
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
    appDataEntityId: 'plmweb.space',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '基本信息',
  viewStyle: 'DEFAULT',
  viewType: 'DEEDITVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: 'b54a6e84f09751835d88e56c7ce1500c',
  modelType: 'PSAPPDEVIEW',
  name: 'spacebase_info_edit_view',
  id: 'plmweb.space_base_info_edit_view',
};