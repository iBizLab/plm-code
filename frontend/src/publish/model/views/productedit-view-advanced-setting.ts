export default {
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  deviewCodeName: 'edit_view_advanced_setting',
  deviewId: 'f244c1b4ea44fb5b9411ef6006191703',
  accUserMode: 2,
  caption: '高级设置',
  codeName: 'productedit_view_advanced_setting',
  appDataEntityId: 'plmweb.product',
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
        appDataEntityId: 'plmweb.product',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.product',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'getdraft',
        appDataEntityId: 'plmweb.product',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.product',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.product',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.product',
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
              caption: '移动产品',
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
              actionGroupExtractMode: 'ITEM',
              layout: {
                columnCount: 24,
                layout: 'TABLE_24COL',
              },
              deformDetails: [
                {
                  rawItem: {
                    caption:
                      '如果此产品已经结束了，你可以归档它。归档后如果想重新使用该产品，可以通过配置中心由管理员进行激活。',
                    halign: 'LEFT',
                    valign: 'MIDDLE',
                    wrapMode: 'NOWRAP',
                    contentType: 'RAW',
                    id: 'archive_product',
                  },
                  codeName: 'archive_product',
                  detailStyle: 'DEFAULT',
                  detailType: 'RAWITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'archive_product',
                },
                {
                  actionType: 'UIACTION',
                  uiactionId: 'in_progress_into_archived@product',
                  tooltip: '归档产品',
                  uiactionTarget: 'SINGLEKEY',
                  caption: '归档产品',
                  codeName: 'button2',
                  detailStyle: 'DEFAULT',
                  detailType: 'BUTTON',
                  layoutPos: {
                    colLG: 2,
                    colMD: 2,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'button2',
                },
              ],
              caption: '归档产品',
              codeName: 'grouppanel2',
              detailStyle: 'DEFAULT',
              detailType: 'GROUPPANEL',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'grouppanel2',
            },
            {
              actionGroupExtractMode: 'ITEM',
              layout: {
                columnCount: 24,
                layout: 'TABLE_24COL',
              },
              deformDetails: [
                {
                  rawItem: {
                    caption:
                      '如果此产品已经不再需要了，你可以删除它。删除后如果想找回该产品，可以通过配置中心由管理员进行恢复。',
                    halign: 'LEFT',
                    valign: 'MIDDLE',
                    wrapMode: 'NOWRAP',
                    contentType: 'RAW',
                    id: 'rawitem2',
                  },
                  codeName: 'rawitem2',
                  detailStyle: 'DEFAULT',
                  detailType: 'RAWITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'rawitem2',
                },
                {
                  actionType: 'UIACTION',
                  uiactionId: 'in_progress_into_deleted@product',
                  tooltip: '删除产品',
                  uiactionTarget: 'SINGLEKEY',
                  caption: '删除产品',
                  codeName: 'button3',
                  detailStyle: 'DEFAULT',
                  detailType: 'BUTTON',
                  layoutPos: {
                    colLG: 2,
                    colMD: 2,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'button3',
                },
              ],
              caption: '删除产品',
              codeName: 'grouppanel3',
              detailStyle: 'DEFAULT',
              detailType: 'GROUPPANEL',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'grouppanel3',
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
      enableItemPrivilege: true,
      showBusyIndicator: true,
      codeName: 'Advanced_setting',
      controlType: 'FORM',
      logicName: '高级设置',
      appDataEntityId: 'plmweb.product',
      controlParam: {
        id: 'form',
      },
      modelId: '79c5fb98b947502931f7f6ff148779de',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.product.advanced_setting',
    },
    {
      codeName: 'edit_view_advanced_settingdatainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.product',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'edit_view_advanced_settingdatainfobar',
    },
    {
      caption: '高级设置',
      codeName: 'edit_view_advanced_settingcaptionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.product',
      controlParam: {},
      name: 'captionbar',
      id: 'edit_view_advanced_settingcaptionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'Layoutpanel',
    controlStyle: 'APPDEEDITVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.product',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '高级设置',
  viewStyle: 'DEFAULT',
  viewType: 'DEEDITVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '537f87fa0665bd5fe79c75c3a684cda6',
  modelType: 'PSAPPDEVIEW',
  name: 'productedit_view_advanced_setting',
  id: 'plmweb.productedit_view_advanced_setting',
};