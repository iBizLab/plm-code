export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  openMode: 'POPUPMODAL',
  deviewCodeName: 'change_stage_view',
  deviewId: 'B4EF1175-A20C-471A-BF58-2567A89025C1',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.RELEASE',
  },
  caption: '修改阶段',
  codeName: 'release_change_stage_view',
  height: 300,
  appDataEntityId: 'plmweb.release',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'OptionView',
      id: 'engine',
    },
  ],
  appViewNavParams: [
    {
      key: 'release',
      value: 'release',
      id: 'release',
    },
  ],
  controls: [
    {
      createControlAction: {
        appDEMethodId: 'change_stage',
        appDataEntityId: 'plmweb.release',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.release',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'change_draft',
        appDataEntityId: 'plmweb.release',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'change_draft',
        appDataEntityId: 'plmweb.release',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.release',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'change_stage',
        appDataEntityId: 'plmweb.release',
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
                  createDV: 'release',
                  createDVT: 'APPDATA',
                  dataType: 25,
                  enableCond: 3,
                  fieldName: 'release',
                  labelPos: 'NONE',
                  noPrivDisplayMode: 1,
                  editor: {
                    editorType: 'HIDDEN',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'release',
                  },
                  updateDV: 'release',
                  updateDVT: 'APPDATA',
                  allowEmpty: true,
                  hidden: true,
                  codeName: 'release',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  id: 'release',
                },
                {
                  rawItem: {
                    contentType: 'PLACEHOLDER',
                    rawItemHeight: 30,
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
                  dataType: 21,
                  enableCond: 1,
                  labelPos: 'NONE',
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'stage_transitions',
                  editor: {
                    halign: 'LEFT',
                    valign: 'MIDDLE',
                    wrapMode: 'NOWRAP',
                    enableLinkView: true,
                    editorParams: {
                      DATERANGE:
                        '{"startField":"date_gt","endField":"date_lt"}',
                      SHOWMODE: 'operate',
                      SHOWCONFIG:
                        '{"sort": "p_sequence","typeName":"pname","color":"p_color"}',
                      LINKVIEW: 'TRUE',
                    },
                    editorStyle: 'STAGE_PROGRESS_BAR',
                    editorType: 'SPAN_LINK',
                    objectIdField: 'id',
                    objectNameField: 'name',
                    sysPFPluginId: 'stage_progress_bar',
                    valueType: 'OBJECTS',
                    editable: true,
                    id: 'stage_transitions',
                  },
                  allowEmpty: true,
                  caption: '发布阶段',
                  codeName: 'stage_transitions',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  id: 'stage_transitions',
                },
              ],
              caption: '项目发布基本信息',
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
      codeName: 'change_stage_view_form',
      controlType: 'FORM',
      logicName: '修改阶段选项操作视图_表单',
      appDataEntityId: 'plmweb.release',
      controlParam: {
        id: 'form',
      },
      modelId: '6C0D879C-E3B8-416A-9B11-FBC502C7C771',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.release.change_stage_view_form',
    },
    {
      codeName: 'change_stage_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.release',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'change_stage_view_datainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.RELEASE',
      },
      caption: '修改阶段',
      codeName: 'change_stage_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.release',
      controlParam: {},
      name: 'captionbar',
      id: 'change_stage_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEOPTVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.release',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '修改阶段选项操作视图',
  viewStyle: 'DEFAULT',
  viewType: 'DEOPTVIEW',
  width: 650,
  enableDP: true,
  showCaptionBar: true,
  modelId: 'd191a2b16ff8cc3269dce8b1222f9c4b',
  modelType: 'PSAPPDEVIEW',
  name: 'releasechange_stage_view',
  id: 'plmweb.release_change_stage_view',
};