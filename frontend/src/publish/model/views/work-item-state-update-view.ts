export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  openMode: 'POPUPMODAL',
  deviewCodeName: 'update_view',
  deviewId: '3e58dbf191bd0d330bf4e16c25edf141',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.WORK_ITEM_STATE',
  },
  caption: '编辑状态',
  codeName: 'work_item_state_update_view',
  height: 280,
  appDataEntityId: 'plmweb.work_item_state',
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
        appDataEntityId: 'plmweb.work_item_state',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.work_item_state',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'get_draft',
        appDataEntityId: 'plmweb.work_item_state',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.work_item_state',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.work_item_state',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.work_item_state',
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
                  labelPos: 'LEFT',
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
                  caption: '状态名称',
                  codeName: 'name',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colLG: 12,
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'name',
                },
                {
                  dataType: 6,
                  enableCond: 3,
                  labelPos: 'LEFT',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'sequence',
                  editor: {
                    editorType: 'TEXTBOX',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'sequence',
                  },
                  caption: '序号',
                  codeName: 'sequence',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colLG: 12,
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'sequence',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'LEFT',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'type',
                  editor: {
                    singleSelect: true,
                    appCodeListId: 'plmweb.projmgmt__state_type',
                    editorType: 'DROPDOWNLIST',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'type',
                  },
                  needCodeListConfig: true,
                  caption: '状态类型',
                  codeName: 'type',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colLG: 12,
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
                  appDEFieldId: 'style',
                  editor: {
                    maxLength: 100,
                    editorType: 'TEXTBOX',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'style',
                  },
                  allowEmpty: true,
                  caption: '样式表',
                  codeName: 'style',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colLG: 12,
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'style',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'LEFT',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'color',
                  editor: {
                    editorType: 'COLORPICKER',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'color',
                  },
                  allowEmpty: true,
                  caption: '颜色',
                  codeName: 'color',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colLG: 12,
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'color',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'LEFT',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'work_item_type_id',
                  editor: {
                    editorType: 'HIDDEN',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'work_item_type_id',
                  },
                  allowEmpty: true,
                  hidden: true,
                  caption: '工作项类型标识',
                  codeName: 'work_item_type_id',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colLG: 12,
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'work_item_type_id',
                },
              ],
              caption: '工作项状态基本信息',
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
      codeName: 'edit_view_form',
      controlType: 'FORM',
      logicName: '工作项编辑_表单',
      appDataEntityId: 'plmweb.work_item_state',
      controlParam: {
        id: 'form',
      },
      modelId: 'a6964c39e12d117745ca02380c7e4ef5',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.work_item_state.edit_view_form',
    },
    {
      codeName: 'update_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.work_item_state',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'update_view_datainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.WORK_ITEM_STATE',
      },
      caption: '编辑状态',
      codeName: 'update_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.work_item_state',
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
    appDataEntityId: 'plmweb.work_item_state',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '编辑工作项状态',
  viewStyle: 'DEFAULT',
  viewType: 'DEOPTVIEW',
  width: 800,
  enableDP: true,
  showCaptionBar: true,
  modelId: '6d93a859064dcf0ea96eb5263267c888',
  modelType: 'PSAPPDEVIEW',
  name: 'work_item_stateupdate_view',
  id: 'plmweb.work_item_state_update_view',
};