export default {
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  openMode: 'POPOVER',
  deviewCodeName: 'change_state_view',
  deviewId: 'e02b67ca0fecab2db8c6ce0b65e6878e',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.IDEA',
  },
  caption: '需求',
  codeName: 'idea_change_state_view',
  appDataEntityId: 'plmweb.idea',
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
        appDataEntityId: 'plmweb.idea',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.idea',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'get_draft',
        appDataEntityId: 'plmweb.idea',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'nothing',
        appDataEntityId: 'plmweb.idea',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.idea',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'nothing',
        appDataEntityId: 'plmweb.idea',
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
                  labelPos: 'NONE',
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'state',
                  editor: {
                    singleSelect: true,
                    appCodeListId: 'plmweb.prodmgmt__idea_state',
                    editorType: 'DROPDOWNLIST',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'state',
                  },
                  emptyCaption: true,
                  needCodeListConfig: true,
                  capLanguageRes: {
                    lanResTag: 'DEF.LNAME.STATE',
                  },
                  codeName: 'state',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  id: 'state',
                },
              ],
              capLanguageRes: {
                lanResTag:
                  'CONTROL.DEFORM.IDEA.CHANGE_STATE_FORM.GROUPPANEL.GROUP1',
              },
              caption: '需求基本信息',
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
              id: 'id',
            },
          ],
          capLanguageRes: {
            lanResTag:
              'CONTROL.DEFORM.IDEA.CHANGE_STATE_FORM.FORMPAGE.FORMPAGE1',
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
      codeName: 'change_state_form',
      controlType: 'FORM',
      logicName: '变更状态表单（需求）',
      appDataEntityId: 'plmweb.idea',
      controlParam: {
        id: 'form',
      },
      ctrlMsg: {
        codeName: 'UsrCtrlMsg0228593610',
        ctrlMsgItems: [
          {
            name: 'BEFOREREMOVE_HIDDEN',
            id: 'beforeremove_hidden',
          },
          {
            name: 'CREATESUCCESS_HIDDEN',
            id: 'createsuccess_hidden',
          },
          {
            name: 'UPDATESUCCESS_HIDDEN',
            id: 'updatesuccess_hidden',
          },
        ],
        name: '编辑表单自定义消息(隐藏)',
        id: 'usrctrlmsg0228593610',
      },
      modelId: '89e94609aef253bee88a823169db8317',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.idea.change_state_form',
    },
    {
      codeName: 'change_state_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.idea',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'change_state_view_datainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.IDEA',
      },
      caption: '需求',
      codeName: 'change_state_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.idea',
      controlParam: {},
      name: 'captionbar',
      id: 'change_state_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEOPTVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.idea',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '变更状态',
  titleLanguageRes: {
    lanResTag: 'PAGE.TITLE.IDEA.CHANGE_STATE_VIEW',
  },
  viewStyle: 'DEFAULT',
  viewType: 'DEOPTVIEW',
  enableDP: true,
  showCaptionBar: false,
  modelId: '431d7dc035acfd34b93125a3b675572f',
  modelType: 'PSAPPDEVIEW',
  name: 'ideachange_state_view',
  id: 'plmweb.idea_change_state_view',
};
