export default {
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  openMode: 'POPUPMODAL',
  deviewCodeName: 'confirm_finish_view',
  deviewId: '4ab97e72494ac2e84a0dae4a515f5934',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.SPRINT',
  },
  caption: '确认完成',
  codeName: 'sprintconfirm_finish_view',
  height: 300,
  appDataEntityId: 'plmweb.sprint',
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
        appDataEntityId: 'plmweb.sprint',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.sprint',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'getdraft',
        appDataEntityId: 'plmweb.sprint',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get_not_finish',
        appDataEntityId: 'plmweb.sprint',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.sprint',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'nothing',
        appDataEntityId: 'plmweb.sprint',
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
              actionGroupExtractMode: 'ITEM',
              layout: {
                columnCount: 24,
                layout: 'TABLE_24COL',
              },
              deformDetails: [
                {
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'NONE',
                  noPrivDisplayMode: 1,
                  editor: {
                    contentType: 'RAW',
                    editorType: 'RAW',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'remind',
                  },
                  allowEmpty: true,
                  codeName: 'remind',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  id: 'remind',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  fieldName: 'choose_move',
                  labelPos: 'NONE',
                  noPrivDisplayMode: 1,
                  editor: {
                    editorType: 'CHECKBOX',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'choose_move',
                  },
                  resetItemNames: ['choose_finish'],
                  updateDV: '1',
                  allowEmpty: true,
                  codeName: 'choose_move',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colLG: 2,
                    colMD: 2,
                    colSM: 2,
                    colXS: 2,
                    layout: 'TABLE_24COL',
                  },
                  id: 'choose_move',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'NONE',
                  noPrivDisplayMode: 1,
                  editor: {
                    halign: 'LEFT',
                    valign: 'MIDDLE',
                    wrapMode: 'NOWRAP',
                    editorType: 'SPAN',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'formitem1',
                  },
                  updateDV: '移动至',
                  allowEmpty: true,
                  codeName: 'formitem1',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colLG: 2,
                    colMD: 2,
                    colSM: 2,
                    colXS: 2,
                    layout: 'TABLE_24COL',
                  },
                  id: 'formitem1',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'NONE',
                  noPrivDisplayMode: 1,
                  editor: {
                    enablePickupView: true,
                    singleSelect: true,
                    appDEACModeId: 'default',
                    appDEDataSetId: 'fetchchoose_move',
                    appDataEntityId: 'plmweb.sprint',
                    enableAC: true,
                    forceSelection: true,
                    showTrigger: true,
                    valueItemName: 'target_sprint_id',
                    editorParams: {
                      AC: 'TRUE',
                      'srfnavparam.sprint_id': '%sprint%',
                      PICKUPVIEW: 'TRUE',
                    },
                    editorType: 'PICKER',
                    editorItems: [
                      {
                        id: 'target_sprint_id',
                      },
                    ],
                    valueType: 'SIMPLE',
                    editable: true,
                    navigateParams: [
                      {
                        key: 'sprint_id',
                        value: 'sprint',
                        id: 'sprint_id',
                      },
                    ],
                    id: 'target_sprint_name',
                  },
                  updateDV: '待分配工作项',
                  allowEmpty: true,
                  caption: '目标迭代标识',
                  codeName: 'target_sprint_name',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  defdgroupLogics: [
                    {
                      logicCat: 'ITEMENABLE',
                      relatedDetailNames: ['choose_move'],
                      groupOP: 'AND',
                      defdlogics: [
                        {
                          condOP: 'EQ',
                          defdname: 'choose_move',
                          value: '1',
                          logicType: 'SINGLE',
                        },
                      ],
                      logicType: 'GROUP',
                      id: '表单成员[target_sprint_name][表单项启用]逻辑',
                    },
                  ],
                  layoutPos: {
                    colLG: 20,
                    colMD: 20,
                    colSM: 20,
                    colXS: 20,
                    layout: 'TABLE_24COL',
                  },
                  id: 'target_sprint_name',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  fieldName: 'choose_finish',
                  labelPos: 'NONE',
                  noPrivDisplayMode: 1,
                  editor: {
                    editorType: 'CHECKBOX',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'choose_finish',
                  },
                  resetItemNames: ['choose_move'],
                  allowEmpty: true,
                  codeName: 'choose_finish',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colLG: 2,
                    colMD: 2,
                    colSM: 2,
                    colXS: 2,
                    layout: 'TABLE_24COL',
                  },
                  id: 'choose_finish',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'NONE',
                  noPrivDisplayMode: 1,
                  editor: {
                    halign: 'LEFT',
                    valign: 'MIDDLE',
                    wrapMode: 'NOWRAP',
                    editorType: 'SPAN',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'formitem',
                  },
                  updateDV: '全部标记为已完成',
                  allowEmpty: true,
                  codeName: 'formitem',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colLG: 22,
                    colMD: 22,
                    colSM: 22,
                    colXS: 22,
                    layout: 'TABLE_24COL',
                  },
                  id: 'formitem',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  fieldName: 'target_sprint_id',
                  labelPos: 'NONE',
                  noPrivDisplayMode: 1,
                  editor: {
                    editorType: 'HIDDEN',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'target_sprint_id',
                  },
                  allowEmpty: true,
                  hidden: true,
                  codeName: 'target_sprint_id',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  id: 'target_sprint_id',
                },
              ],
              caption: '迭代基本信息',
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
      codeName: 'Confirm_finish_form',
      controlType: 'FORM',
      logicName: '迭代确认完成视图_表单',
      appDataEntityId: 'plmweb.sprint',
      controlParam: {
        id: 'form',
      },
      modelId: 'c08074e3c23bb5fa2d86ce5dc48e0c53',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.sprint.confirm_finish_form',
    },
    {
      codeName: 'confirm_finish_viewdatainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.sprint',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'confirm_finish_viewdatainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.SPRINT',
      },
      caption: '确认完成',
      codeName: 'confirm_finish_viewcaptionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.sprint',
      controlParam: {},
      name: 'captionbar',
      id: 'confirm_finish_viewcaptionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'Layoutpanel',
    controlStyle: 'APPDEOPTVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.sprint',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '迭代实体确认完成视图',
  viewStyle: 'DEFAULT',
  viewType: 'DEOPTVIEW',
  width: 650,
  enableDP: true,
  showCaptionBar: true,
  modelId: '4de4be2aed811e46dfea245c209f9d14',
  modelType: 'PSAPPDEVIEW',
  name: 'sprintconfirm_finish_view',
  id: 'plmweb.sprintconfirm_finish_view',
};