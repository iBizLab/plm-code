export default {
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  openMode: 'POPOVER',
  deviewCodeName: 'set_run_status_option_view',
  deviewId: '246e11e283e0586f5ad5b4bac4e7d44c',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.RUN',
  },
  caption: '执行用例',
  codeName: 'run_set_run_status_option_view',
  appDataEntityId: 'plmweb.run',
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
        appDataEntityId: 'plmweb.run',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.run',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'get_draft',
        appDataEntityId: 'plmweb.run',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'nothing',
        appDataEntityId: 'plmweb.run',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.run',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'nothing',
        appDataEntityId: 'plmweb.run',
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
              labelPos: 'NONE',
              noPrivDisplayMode: 1,
              appDEFieldId: 'status',
              editor: {
                singleSelect: true,
                appCodeListId: 'plmweb.testmgmt__run_status',
                editorType: 'DROPDOWNLIST',
                valueType: 'SIMPLE',
                editable: true,
                id: 'status',
              },
              allowEmpty: true,
              needCodeListConfig: true,
              caption: '执行结果',
              codeName: 'status',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              id: 'status',
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
      codeName: 'update_run_status_form',
      controlType: 'FORM',
      logicName: '设置执行结果',
      appDataEntityId: 'plmweb.run',
      controlParam: {
        id: 'form',
      },
      ctrlMsg: {
        codeName: 'UsrCtrlMsg0228593610',
        ctrlMsgItems: [
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
      modelId: '6f4c0f21f987a830beeb6ae3d05b1c6b',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.run.update_run_status_form',
    },
    {
      codeName: 'set_run_status_option_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.run',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'set_run_status_option_view_datainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.RUN',
      },
      caption: '执行用例',
      codeName: 'set_run_status_option_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.run',
      controlParam: {},
      name: 'captionbar',
      id: 'set_run_status_option_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEOPTVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.run',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '设置执行结果',
  viewStyle: 'DEFAULT',
  viewType: 'DEOPTVIEW',
  enableDP: true,
  showCaptionBar: false,
  modelId: '0fe293b401ec273c3cab6e08eb9a30c6',
  modelType: 'PSAPPDEVIEW',
  name: 'runset_run_status_option_view',
  id: 'plmweb.run_set_run_status_option_view',
};