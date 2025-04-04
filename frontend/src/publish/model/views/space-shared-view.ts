export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  deviewCodeName: 'shared_view',
  deviewId: 'db66004925d96f516f2449848031ac3c',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.SPACE',
  },
  caption: '空间',
  codeName: 'space_shared_view',
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
                  rawItem: {
                    caption: '开启共享后，获得链接的人可以访问该空间。',
                    halign: 'LEFT',
                    valign: 'MIDDLE',
                    wrapMode: 'NOWRAP',
                    contentType: 'RAW',
                    id: 'rawitem1',
                  },
                  codeName: 'rawitem1',
                  detailStyle: 'DEFAULT',
                  detailType: 'RAWITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'rawitem1',
                },
                {
                  actionType: 'UIACTION',
                  uiactionId: 'open_shared@space',
                  tooltip: '开启共享',
                  uiactionTarget: 'SINGLEKEY',
                  caption: '开启共享',
                  codeName: 'button2',
                  detailStyle: 'DEFAULT',
                  detailType: 'BUTTON',
                  defdgroupLogics: [
                    {
                      logicCat: 'PANELVISIBLE',
                      relatedDetailNames: ['is_shared'],
                      groupOP: 'AND',
                      defdlogics: [
                        {
                          groupOP: 'OR',
                          defdlogics: [
                            {
                              condOP: 'ISNULL',
                              defdname: 'is_shared',
                              logicType: 'SINGLE',
                            },
                            {
                              condOP: 'EQ',
                              defdname: 'is_shared',
                              value: '0',
                              logicType: 'SINGLE',
                            },
                          ],
                          logicType: 'GROUP',
                        },
                      ],
                      logicType: 'GROUP',
                    },
                  ],
                  layoutPos: {
                    colLG: 2,
                    colMD: 2,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'button2',
                },
                {
                  actionType: 'UIACTION',
                  uiactionId: 'space_shared_setting@space',
                  tooltip: '共享设置',
                  uiactionTarget: 'SINGLEKEY',
                  caption: '共享设置',
                  codeName: 'button1',
                  detailStyle: 'DEFAULT',
                  detailType: 'BUTTON',
                  defdgroupLogics: [
                    {
                      logicCat: 'PANELVISIBLE',
                      relatedDetailNames: ['is_shared'],
                      groupOP: 'AND',
                      defdlogics: [
                        {
                          groupOP: 'OR',
                          defdlogics: [
                            {
                              condOP: 'EQ',
                              defdname: 'is_shared',
                              value: '1',
                              logicType: 'SINGLE',
                            },
                            {
                              condOP: 'EQ',
                              defdname: 'is_shared',
                              value: '2',
                              logicType: 'SINGLE',
                            },
                          ],
                          logicType: 'GROUP',
                        },
                      ],
                      logicType: 'GROUP',
                    },
                  ],
                  layoutPos: {
                    colLG: 2,
                    colMD: 2,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'button1',
                },
              ],
              caption: '空间共享',
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
              labelPos: 'NONE',
              noPrivDisplayMode: 1,
              appDEFieldId: 'is_shared',
              editor: {
                editorType: 'HIDDEN',
                valueType: 'SIMPLE',
                editable: true,
                id: 'is_shared',
              },
              allowEmpty: true,
              hidden: true,
              caption: '是否开启共享',
              codeName: 'is_shared',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              id: 'is_shared',
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
      codeName: 'shared_form',
      controlType: 'FORM',
      logicName: '空间共享_表单',
      appDataEntityId: 'plmweb.space',
      controlParam: {
        id: 'form',
      },
      modelId: 'f553cff505f96cb2cf263ca6a3dfbb3f',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.space.shared_form',
    },
    {
      codeName: 'shared_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.space',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'shared_view_datainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.SPACE',
      },
      caption: '空间',
      codeName: 'shared_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.space',
      controlParam: {},
      name: 'captionbar',
      id: 'shared_view_captionbar',
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
  title: '空间共享',
  viewStyle: 'DEFAULT',
  viewType: 'DEEDITVIEW',
  enableDP: true,
  showCaptionBar: false,
  modelId: '3c3d86e5eb72451bc47bc3b0284cf635',
  modelType: 'PSAPPDEVIEW',
  name: 'spaceshared_view',
  id: 'plmweb.space_shared_view',
};
