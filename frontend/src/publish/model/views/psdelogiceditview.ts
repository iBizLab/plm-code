export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  funcViewMode: 'EDITVIEW',
  deviewCodeName: 'EditView',
  deviewId: 'bbfa95c117983b725082d18d6d2958a7',
  accUserMode: 2,
  caption: '实体处理逻辑',
  codeName: 'psdelogiceditview',
  appDataEntityId: 'plmweb.psdelogic',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'EditView',
      id: 'engine',
    },
  ],
  controls: [
    {
      detoolbarItems: [
        {
          actionLevel: 100,
          noPrivDisplayMode: 2,
          uiactionId: 'editview_saveandexitaction',
          valid: true,
          capLanguageRes: {
            lanResTag: 'TBB.TEXT.EDITVIEW.SAVEANDCLOSE',
          },
          caption: '保存',
          itemType: 'DEUIACTION',
          sysImage: {
            cssClass: 'fa fa-save',
            glyph: 'xf0c7@FontAwesome',
          },
          tooltip: '保存',
          tooltipLanguageRes: {
            lanResTag: 'TBB.TOOLTIP.EDITVIEW.SAVEANDCLOSE',
          },
          showCaption: true,
          showIcon: true,
          id: 'deuiaction1',
        },
      ],
      xdataControlName: 'form',
      codeName: 'edit_view_toolbar',
      controlType: 'TOOLBAR',
      logicName: '工具栏模板（默认编辑界面）',
      appDataEntityId: 'plmweb.psdelogic',
      controlParam: {
        id: 'toolbar',
      },
      modelId: '48c8f789be8a5522d3003293c1cf2ffb',
      modelType: 'PSDETOOLBAR',
      name: 'toolbar',
      id: 'edit_view_toolbar',
    },
    {
      createControlAction: {
        appDEMethodId: 'create',
        appDataEntityId: 'plmweb.psdelogic',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.psdelogic',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'getdraft',
        appDataEntityId: 'plmweb.psdelogic',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.psdelogic',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.psdelogic',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.psdelogic',
        id: 'update',
      },
      infoFormMode: true,
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
                  appDEFieldId: 'psdelogicname',
                  editor: {
                    halign: 'LEFT',
                    valign: 'MIDDLE',
                    wrapMode: 'NOWRAP',
                    editorType: 'SPAN',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'psdelogicname',
                  },
                  allowEmpty: true,
                  caption: '规则名称',
                  codeName: 'psdelogicname',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colLG: 20,
                    colMD: 20,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'psdelogicname',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  ignoreInput: 3,
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'applyflag',
                  editor: {
                    halign: 'LEFT',
                    valign: 'MIDDLE',
                    wrapMode: 'NOWRAP',
                    appCodeListId: 'plmweb.extension__extension_status',
                    editorType: 'SPAN',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'applyflag',
                  },
                  allowEmpty: true,
                  convertToCodeItemText: true,
                  emptyCaption: true,
                  codeName: 'applyflag',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colLG: 4,
                    colMD: 4,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'applyflag',
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
                      ignoreInput: 3,
                      labelPos: 'TOP',
                      labelWidth: 130,
                      noPrivDisplayMode: 1,
                      appDEFieldId: 'last_state',
                      editor: {
                        halign: 'LEFT',
                        valign: 'MIDDLE',
                        wrapMode: 'NOWRAP',
                        appCodeListId: 'plmweb.extension__log_state',
                        editorType: 'SPAN',
                        valueType: 'SIMPLE',
                        editable: true,
                        id: 'last_state',
                      },
                      allowEmpty: true,
                      convertToCodeItemText: true,
                      caption: '最后运行状态',
                      codeName: 'last_state',
                      detailStyle: 'DEFAULT',
                      detailType: 'FORMITEM',
                      layoutPos: {
                        colLG: 6,
                        colMD: 8,
                        layout: 'TABLE_24COL',
                      },
                      showCaption: true,
                      id: 'last_state',
                    },
                    {
                      dataType: 25,
                      enableCond: 3,
                      ignoreInput: 3,
                      labelPos: 'TOP',
                      labelWidth: 130,
                      noPrivDisplayMode: 1,
                      appDEFieldId: 'logicsubtype',
                      editor: {
                        halign: 'LEFT',
                        valign: 'MIDDLE',
                        wrapMode: 'NOWRAP',
                        appCodeListId: 'plmweb.extension__delogicsubtype',
                        editorType: 'SPAN',
                        valueType: 'SIMPLE',
                        editable: true,
                        id: 'logicsubtype',
                      },
                      allowEmpty: true,
                      convertToCodeItemText: true,
                      caption: '类型',
                      codeName: 'logicsubtype',
                      detailStyle: 'DEFAULT',
                      detailType: 'FORMITEM',
                      layoutPos: {
                        colLG: 6,
                        colMD: 8,
                        layout: 'TABLE_24COL',
                      },
                      showCaption: true,
                      id: 'logicsubtype',
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
                          ignoreInput: 3,
                          labelPos: 'TOP',
                          labelWidth: 130,
                          noPrivDisplayMode: 1,
                          appDEFieldId: 'events',
                          editor: {
                            halign: 'LEFT',
                            valign: 'MIDDLE',
                            wrapMode: 'NOWRAP',
                            appCodeListId: 'plmweb.extension__enable_action',
                            editorType: 'SPAN',
                            valueType: 'SIMPLE',
                            editable: true,
                            id: 'events',
                          },
                          allowEmpty: true,
                          convertToCodeItemText: true,
                          caption: '监控事件',
                          codeName: 'events',
                          detailStyle: 'DEFAULT',
                          detailType: 'FORMITEM',
                          defdgroupLogics: [
                            {
                              logicCat: 'PANELVISIBLE',
                              relatedDetailNames: ['logicsubtype'],
                              groupOP: 'AND',
                              defdlogics: [
                                {
                                  condOP: 'EQ',
                                  defdname: 'logicsubtype',
                                  value: 'EVENTHOOK',
                                  logicType: 'SINGLE',
                                },
                              ],
                              logicType: 'GROUP',
                            },
                          ],
                          layoutPos: {
                            colMD: 24,
                            layout: 'TABLE_24COL',
                          },
                          showCaption: true,
                          id: 'events',
                        },
                        {
                          dataType: 25,
                          enableCond: 3,
                          labelPos: 'TOP',
                          labelWidth: 130,
                          noPrivDisplayMode: 1,
                          appDEFieldId: 'attachtopsdedatasetname',
                          editor: {
                            halign: 'LEFT',
                            valign: 'MIDDLE',
                            wrapMode: 'NOWRAP',
                            editorType: 'SPAN',
                            valueType: 'SIMPLE',
                            editable: true,
                            id: 'attachtopsdedatasetname',
                          },
                          allowEmpty: true,
                          caption: '附加到指定数据集',
                          codeName: 'attachtopsdedatasetname',
                          detailStyle: 'DEFAULT',
                          detailType: 'FORMITEM',
                          defdgroupLogics: [
                            {
                              logicCat: 'PANELVISIBLE',
                              relatedDetailNames: ['logicsubtype'],
                              groupOP: 'AND',
                              defdlogics: [
                                {
                                  condOP: 'EQ',
                                  defdname: 'logicsubtype',
                                  value: 'ATTACHTODEDATASET',
                                  logicType: 'SINGLE',
                                },
                              ],
                              logicType: 'GROUP',
                            },
                          ],
                          layoutPos: {
                            colMD: 24,
                            layout: 'TABLE_24COL',
                          },
                          showCaption: true,
                          id: 'attachtopsdedatasetname',
                        },
                        {
                          dataType: 25,
                          enableCond: 3,
                          labelPos: 'TOP',
                          labelWidth: 130,
                          noPrivDisplayMode: 1,
                          appDEFieldId: 'attachtopsdeactionname',
                          editor: {
                            halign: 'LEFT',
                            valign: 'MIDDLE',
                            wrapMode: 'NOWRAP',
                            editorType: 'SPAN',
                            valueType: 'SIMPLE',
                            editable: true,
                            id: 'attachtopsdeactionname',
                          },
                          allowEmpty: true,
                          caption: '附加到指定行为',
                          codeName: 'attachtopsdeactionname',
                          detailStyle: 'DEFAULT',
                          detailType: 'FORMITEM',
                          defdgroupLogics: [
                            {
                              logicCat: 'PANELVISIBLE',
                              relatedDetailNames: ['logicsubtype'],
                              groupOP: 'AND',
                              defdlogics: [
                                {
                                  condOP: 'EQ',
                                  defdname: 'logicsubtype',
                                  value: 'ATTACHTODEACTION',
                                  logicType: 'SINGLE',
                                },
                              ],
                              logicType: 'GROUP',
                            },
                          ],
                          layoutPos: {
                            colMD: 24,
                            layout: 'TABLE_24COL',
                          },
                          showCaption: true,
                          id: 'attachtopsdeactionname',
                        },
                        {
                          dataType: 25,
                          enableCond: 3,
                          labelPos: 'TOP',
                          labelWidth: 130,
                          noPrivDisplayMode: 1,
                          appDEFieldId: 'timerpolicy',
                          editor: {
                            halign: 'LEFT',
                            valign: 'MIDDLE',
                            wrapMode: 'NOWRAP',
                            editorType: 'SPAN',
                            valueType: 'SIMPLE',
                            editable: true,
                            id: 'timerpolicy',
                          },
                          allowEmpty: true,
                          caption: '定时触发策略',
                          codeName: 'timerpolicy',
                          detailStyle: 'DEFAULT',
                          detailType: 'FORMITEM',
                          defdgroupLogics: [
                            {
                              logicCat: 'PANELVISIBLE',
                              relatedDetailNames: ['logicsubtype'],
                              groupOP: 'AND',
                              defdlogics: [
                                {
                                  condOP: 'EQ',
                                  defdname: 'logicsubtype',
                                  value: 'TIMERTASK',
                                  logicType: 'SINGLE',
                                },
                              ],
                              logicType: 'GROUP',
                            },
                          ],
                          layoutPos: {
                            colMD: 24,
                            layout: 'TABLE_24COL',
                          },
                          showCaption: true,
                          id: 'timerpolicy',
                        },
                      ],
                      codeName: 'grouppanel2',
                      detailStyle: 'DEFAULT',
                      detailType: 'GROUPPANEL',
                      layoutPos: {
                        colLG: 6,
                        colMD: 8,
                        layout: 'TABLE_24COL',
                      },
                      id: 'grouppanel2',
                    },
                    {
                      dataType: 5,
                      enableCond: 3,
                      labelPos: 'TOP',
                      labelWidth: 130,
                      noPrivDisplayMode: 1,
                      appDEFieldId: 'last_start_at',
                      editor: {
                        halign: 'LEFT',
                        valign: 'MIDDLE',
                        wrapMode: 'NOWRAP',
                        editorType: 'SPAN',
                        valueType: 'SIMPLE',
                        editable: true,
                        id: 'last_start_at',
                      },
                      valueFormat: 'YYYY-MM-DD HH:mm:ss',
                      allowEmpty: true,
                      caption: '最后运行时间',
                      codeName: 'last_start_at',
                      detailStyle: 'DEFAULT',
                      detailType: 'FORMITEM',
                      layoutPos: {
                        colLG: 6,
                        colMD: 8,
                        layout: 'TABLE_24COL',
                      },
                      showCaption: true,
                      id: 'last_start_at',
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
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  editor: {
                    halign: 'LEFT',
                    valign: 'MIDDLE',
                    wrapMode: 'NOWRAP',
                    editorType: 'SPAN',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'webhookurl',
                  },
                  allowEmpty: true,
                  caption: 'webhook地址',
                  codeName: 'webhookurl',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  defdgroupLogics: [
                    {
                      logicCat: 'PANELVISIBLE',
                      relatedDetailNames: ['logicsubtype'],
                      groupOP: 'AND',
                      defdlogics: [
                        {
                          condOP: 'EQ',
                          defdname: 'logicsubtype',
                          value: 'WEBHOOK',
                          logicType: 'SINGLE',
                        },
                      ],
                      logicType: 'GROUP',
                    },
                  ],
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'webhookurl',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'memo',
                  editor: {
                    halign: 'LEFT',
                    valign: 'MIDDLE',
                    wrapMode: 'NOWRAP',
                    editorType: 'SPAN',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'memo',
                  },
                  allowEmpty: true,
                  caption: '描述',
                  codeName: 'memo',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colLG: 24,
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'memo',
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
              appDEFieldId: 'psdelogicid',
              editor: {
                editorType: 'HIDDEN',
                valueType: 'SIMPLE',
                editable: true,
                id: 'psdelogicid',
              },
              allowEmpty: true,
              hidden: true,
              caption: '实体处理逻辑标识',
              codeName: 'psdelogicid',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              id: 'psdelogicid',
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
      codeName: 'main',
      controlType: 'FORM',
      logicName: '主编辑表单',
      appDataEntityId: 'plmweb.psdelogic',
      controlParam: {
        id: 'form',
      },
      modelId: '412ad071269ec94c0917602e8fe81827',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.psdelogic.main',
    },
    {
      codeName: 'edit_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.psdelogic',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'edit_view_datainfobar',
    },
    {
      caption: '实体处理逻辑',
      codeName: 'edit_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.psdelogic',
      controlParam: {},
      name: 'captionbar',
      id: 'edit_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEEDITVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.psdelogic',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '实体处理逻辑编辑视图',
  viewStyle: 'DEFAULT',
  viewType: 'DEEDITVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '9dff5fcca86b34a32eddc34b4bdce0a2',
  modelType: 'PSAPPDEVIEW',
  name: 'psdelogiceditview',
  id: 'plmweb.psdelogiceditview',
};
