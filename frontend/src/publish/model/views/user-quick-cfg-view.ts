export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  funcViewMode: 'EDITVIEW',
  deviewCodeName: 'quick_cfg_view',
  deviewId: 'ed16a62deee6b07cdc4c7b720b27617a',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.USER',
  },
  caption: '设置成员信息',
  codeName: 'user_quick_cfg_view',
  appDataEntityId: 'plmweb.user',
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
      codeName: 'quick_cfg_view_toolbar',
      controlType: 'TOOLBAR',
      logicName: '企业用户快速配置视图_工具栏',
      appDataEntityId: 'plmweb.user',
      controlParam: {
        id: 'toolbar',
      },
      modelId: '95ff935d8e08d0c0610c85e026afe9ff',
      modelType: 'PSDETOOLBAR',
      name: 'toolbar',
      id: 'quick_cfg_view_toolbar',
    },
    {
      createControlAction: {
        appDEMethodId: 'create',
        appDataEntityId: 'plmweb.user',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.user',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'get_draft',
        appDataEntityId: 'plmweb.user',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.user',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.user',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.user',
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
                  caption: '登录名',
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
              caption: '企业用户基本信息',
              codeName: 'group1',
              detailStyle: 'DEFAULT',
              detailType: 'GROUPPANEL',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
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
          caption: '基本信息',
          codeName: 'formpage1',
          detailStyle: 'DEFAULT',
          detailType: 'FORMPAGE',
          id: 'formpage1',
        },
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
                  ignoreInput: 3,
                  labelPos: 'LEFT',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'create_man',
                  editor: {
                    halign: 'LEFT',
                    valign: 'MIDDLE',
                    wrapMode: 'NOWRAP',
                    appCodeListId: 'plmweb.sysoperator',
                    editorType: 'SPAN',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'create_man',
                  },
                  allowEmpty: true,
                  convertToCodeItemText: true,
                  capLanguageRes: {
                    lanResTag: 'DEF.LNAME.CREATE_MAN',
                  },
                  caption: '建立人',
                  codeName: 'create_man',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'create_man',
                },
                {
                  dataType: 5,
                  enableCond: 3,
                  ignoreInput: 3,
                  labelPos: 'LEFT',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'create_time',
                  editor: {
                    halign: 'LEFT',
                    valign: 'MIDDLE',
                    wrapMode: 'NOWRAP',
                    editorType: 'SPAN',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'create_time',
                  },
                  valueFormat: 'YYYY-MM-DD HH:mm:ss',
                  allowEmpty: true,
                  capLanguageRes: {
                    lanResTag: 'DEF.LNAME.CREATE_TIME',
                  },
                  caption: '建立时间',
                  codeName: 'create_time',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'create_time',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  ignoreInput: 3,
                  labelPos: 'LEFT',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'update_man',
                  editor: {
                    halign: 'LEFT',
                    valign: 'MIDDLE',
                    wrapMode: 'NOWRAP',
                    appCodeListId: 'plmweb.sysoperator',
                    editorType: 'SPAN',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'update_man',
                  },
                  allowEmpty: true,
                  convertToCodeItemText: true,
                  capLanguageRes: {
                    lanResTag: 'DEF.LNAME.UPDATE_MAN',
                  },
                  caption: '更新人',
                  codeName: 'update_man',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'update_man',
                },
                {
                  dataType: 5,
                  enableCond: 3,
                  ignoreInput: 3,
                  labelPos: 'LEFT',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'update_time',
                  editor: {
                    halign: 'LEFT',
                    valign: 'MIDDLE',
                    wrapMode: 'NOWRAP',
                    editorType: 'SPAN',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'update_time',
                  },
                  valueFormat: 'YYYY-MM-DD HH:mm:ss',
                  allowEmpty: true,
                  capLanguageRes: {
                    lanResTag: 'DEF.LNAME.UPDATE_TIME',
                  },
                  caption: '更新时间',
                  codeName: 'update_time',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'update_time',
                },
              ],
              caption: '操作信息',
              codeName: 'group2',
              detailStyle: 'DEFAULT',
              detailType: 'GROUPPANEL',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'group2',
            },
          ],
          caption: '其它',
          codeName: 'formpage2',
          detailStyle: 'DEFAULT',
          detailType: 'FORMPAGE',
          id: 'formpage2',
        },
      ],
      layout: {
        columnCount: 24,
        layout: 'TABLE_24COL',
      },
      tabHeaderPos: 'TOP',
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'quick_cfg',
      controlType: 'FORM',
      logicName: '企业用户快速配置视图_表单',
      appDataEntityId: 'plmweb.user',
      controlParam: {
        id: 'form',
      },
      modelId: 'edaa37f58ea44a4daa0e76fbeb04a8aa',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.user.quick_cfg',
    },
    {
      codeName: 'quick_cfg_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.user',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'quick_cfg_view_datainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.USER',
      },
      caption: '设置成员信息',
      codeName: 'quick_cfg_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.user',
      controlParam: {},
      name: 'captionbar',
      id: 'quick_cfg_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEEDITVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.user',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '设置成员信息',
  viewStyle: 'DEFAULT',
  viewType: 'DEEDITVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '883777df6c2f24c7447b4b97db3d2fb1',
  modelType: 'PSAPPDEVIEW',
  name: 'userquick_cfg_view',
  id: 'plmweb.user_quick_cfg_view',
};
