export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  openMode: 'POPUPMODAL',
  deviewCodeName: 'quick_create_view',
  deviewId: '853eff3c36ea98e930783df8f713524d',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.TICKET_TYPE',
  },
  caption: '新建工单类型',
  codeName: 'ticket_type_quick_create_view',
  height: 500,
  appDataEntityId: 'plmweb.ticket_type',
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
        appDataEntityId: 'plmweb.ticket_type',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.ticket_type',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'get_draft',
        appDataEntityId: 'plmweb.ticket_type',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.ticket_type',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.ticket_type',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.ticket_type',
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
                  layout: {
                    columnCount: 12,
                    layout: 'TABLE_12COL',
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
                        placeHolder: '输入工单类型名称',
                        valueType: 'SIMPLE',
                        editable: true,
                        id: 'name',
                      },
                      capLanguageRes: {
                        lanResTag: 'DEF.LNAME.NAME',
                      },
                      caption: '工单类型名称',
                      codeName: 'name',
                      detailStyle: 'DEFAULT',
                      detailType: 'FORMITEM',
                      layoutPos: {
                        colLG: 10,
                        colMD: 10,
                        layout: 'TABLE_12COL',
                      },
                      showCaption: true,
                      id: 'name',
                    },
                    {
                      dataType: 9,
                      enableCond: 3,
                      itemWidth: 230,
                      labelPos: 'TOP',
                      labelWidth: 130,
                      noPrivDisplayMode: 1,
                      appDEFieldId: 'is_system',
                      editor: {
                        singleSelect: true,
                        appCodeListId: 'plmweb.yesno',
                        editorType: 'DROPDOWNLIST_100',
                        editorWidth: 100,
                        valueType: 'SIMPLE',
                        editable: true,
                        id: 'is_system',
                      },
                      needCodeListConfig: true,
                      caption: '是否系统默认',
                      codeName: 'is_system',
                      detailStyle: 'DEFAULT',
                      detailType: 'FORMITEM',
                      layoutPos: {
                        colLG: 2,
                        colMD: 2,
                        layout: 'TABLE_12COL',
                      },
                      showCaption: true,
                      id: 'is_system',
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
                    placeHolder: '输入工单类型描述',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'description',
                  },
                  caption: '描述',
                  codeName: 'description',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'description',
                },
              ],
              caption: '工单类型基本信息',
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
      codeName: 'quick_create_view_form',
      controlType: 'FORM',
      logicName: '工单类型新建视图_表单',
      appDataEntityId: 'plmweb.ticket_type',
      controlParam: {
        id: 'form',
      },
      modelId: '9f87e26f46eb01292b0a2907bad85437',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.ticket_type.quick_create_view_form',
    },
    {
      codeName: 'quick_create_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.ticket_type',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'quick_create_view_datainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.TICKET_TYPE',
      },
      caption: '新建工单类型',
      codeName: 'quick_create_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.ticket_type',
      controlParam: {},
      name: 'captionbar',
      id: 'quick_create_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEOPTVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.ticket_type',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '新建工单类型',
  viewStyle: 'DEFAULT',
  viewType: 'DEOPTVIEW',
  width: 800,
  enableDP: true,
  showCaptionBar: true,
  modelId: '48a4960202fcb2d3c48ff8769a17559a',
  modelType: 'PSAPPDEVIEW',
  name: 'ticket_typequick_create_view',
  id: 'plmweb.ticket_type_quick_create_view',
};
