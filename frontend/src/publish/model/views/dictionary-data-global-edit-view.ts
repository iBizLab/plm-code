export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  openMode: 'POPUPMODAL',
  deviewCodeName: 'global_edit_view',
  deviewId: '5DBAEBD1-4C3F-4AA5-B882-9DDA1B926F76',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.DICTIONARY',
  },
  caption: '编辑阶段',
  codeName: 'dictionary_data_global_edit_view',
  height: 320,
  appDataEntityId: 'plmweb.dictionary_data',
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
        appDataEntityId: 'plmweb.dictionary_data',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.dictionary_data',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'get_draft',
        appDataEntityId: 'plmweb.dictionary_data',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.dictionary_data',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.dictionary_data',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.dictionary_data',
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
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'name',
                  editor: {
                    maxLength: 200,
                    editorType: 'TEXTBOX',
                    placeHolder: '输入阶段名称',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'name',
                  },
                  capLanguageRes: {
                    lanResTag: 'DEF.LNAME.NAME',
                  },
                  caption: '阶段名称',
                  codeName: 'name',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colLG: 12,
                    colMD: 12,
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
                  appDEFieldId: 'type',
                  editor: {
                    singleSelect: true,
                    appCodeListId: 'plmweb.base__stage_type',
                    editorType: 'DROPDOWNLIST',
                    placeHolder: '选择阶段类型',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'type',
                  },
                  needCodeListConfig: true,
                  caption: '阶段类型',
                  codeName: 'type',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colLG: 12,
                    colMD: 12,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'type',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'color',
                  editor: {
                    editorType: 'COLORPICKER',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'color',
                  },
                  caption: '颜色',
                  codeName: 'color',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colLG: 12,
                    colMD: 12,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'color',
                },
                {
                  createDV: 'catalog',
                  createDVT: 'APPDATA',
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'catalog',
                  editor: {
                    editorType: 'HIDDEN',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'catalog',
                  },
                  allowEmpty: true,
                  hidden: true,
                  caption: '字典目录',
                  codeName: 'catalog',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colLG: 12,
                    colMD: 12,
                    layout: 'TABLE_24COL',
                  },
                  id: 'catalog',
                },
              ],
              caption: '数据字典基本信息',
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
      codeName: 'global_edit_view_form',
      controlType: 'FORM',
      logicName: '实体选项操作视图（编辑阶段）_表单',
      appDataEntityId: 'plmweb.dictionary_data',
      controlParam: {
        id: 'form',
      },
      modelId: '976A1505-44F2-44D1-90D6-516FC299A115',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.dictionary_data.global_edit_view_form',
    },
    {
      codeName: 'global_edit_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.dictionary_data',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'global_edit_view_datainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.DICTIONARY',
      },
      caption: '编辑阶段',
      codeName: 'global_edit_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.dictionary_data',
      controlParam: {},
      name: 'captionbar',
      id: 'global_edit_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEOPTVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.dictionary_data',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '编辑阶段',
  viewStyle: 'DEFAULT',
  viewType: 'DEOPTVIEW',
  width: 660,
  enableDP: true,
  showCaptionBar: true,
  modelId: 'aef99d1f16fc01e57b3f0ee3d891dbe8',
  modelType: 'PSAPPDEVIEW',
  name: 'dictionary_dataglobal_edit_view',
  id: 'plmweb.dictionary_data_global_edit_view',
};