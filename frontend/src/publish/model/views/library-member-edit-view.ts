export default {
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  funcViewMode: 'EDITVIEW',
  deviewCodeName: 'EditView',
  deviewId: 'ac559dd60d8e85ef50c7f2c4eee3e567',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.LIBRARY_MEMBER',
  },
  caption: '测试库成员',
  codeName: 'library_memberEditView',
  appDataEntityId: 'plmweb.library_member',
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
          uiactionId: 'save',
          valid: true,
          capLanguageRes: {
            lanResTag: 'TBB.TEXT.*.SAVE',
          },
          caption: '保存',
          itemType: 'DEUIACTION',
          sysImage: {
            cssClass: 'fa fa-save',
            glyph: 'xf0c7@FontAwesome',
          },
          tooltip: '保存',
          tooltipLanguageRes: {
            lanResTag: 'TBB.TOOLTIP.*.SAVE',
          },
          showCaption: true,
          showIcon: true,
          id: 'tbitem3',
        },
      ],
      xdataControlName: 'form',
      codeName: 'EditViewtoolbar',
      controlType: 'TOOLBAR',
      logicName: '工具栏模板（默认编辑界面）',
      appDataEntityId: 'plmweb.library_member',
      controlParam: {
        id: 'toolbar',
      },
      modelId: '48c8f789be8a5522d3003293c1cf2ffb',
      modelType: 'PSDETOOLBAR',
      name: 'toolbar',
      id: 'editviewtoolbar',
    },
    {
      createControlAction: {
        appDEMethodId: 'create',
        appDataEntityId: 'plmweb.library_member',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.library_member',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'getdraft',
        appDataEntityId: 'plmweb.library_member',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.library_member',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.library_member',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.library_member',
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
                  labelPos: 'LEFT',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'user_id',
                  editor: {
                    enablePickupView: true,
                    singleSelect: true,
                    pickupAppViewId: 'plmweb.userpickupview',
                    handlerType: 'PickupText',
                    appDEACModeId: 'default',
                    appDEDataSetId: 'fetchdefault',
                    appDataEntityId: 'plmweb.user',
                    enableAC: true,
                    forceSelection: true,
                    showTrigger: true,
                    editorParams: {
                      AC: 'TRUE',
                      PICKUPVIEW: 'TRUE',
                    },
                    editorType: 'PICKER',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'user_id',
                  },
                  allowEmpty: true,
                  caption: '登录名',
                  codeName: 'user_id',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'user_id',
                },
              ],
              capLanguageRes: {
                lanResTag:
                  'CONTROL.DEFORM.LIBRARY_MEMBER.MAIN.GROUPPANEL.GROUP1',
              },
              caption: '测试库成员基本信息',
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
          capLanguageRes: {
            lanResTag: 'CONTROL.DEFORM.LIBRARY_MEMBER.MAIN.FORMPAGE.FORMPAGE1',
          },
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
              actionGroupExtractMode: 'ITEM',
              layout: {
                columnCount: 24,
                layout: 'TABLE_24COL',
              },
              capLanguageRes: {
                lanResTag:
                  'CONTROL.DEFORM.LIBRARY_MEMBER.MAIN.GROUPPANEL.GROUP2',
              },
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
          capLanguageRes: {
            lanResTag: 'CONTROL.DEFORM.LIBRARY_MEMBER.MAIN.FORMPAGE.FORMPAGE2',
          },
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
      codeName: 'Main',
      controlType: 'FORM',
      logicName: '主编辑表单',
      appDataEntityId: 'plmweb.library_member',
      controlParam: {
        id: 'form',
      },
      modelId: 'f66616e09e4b6b2938876713b009ede9',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.library_member.main',
    },
    {
      codeName: 'EditViewdatainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.library_member',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'editviewdatainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.LIBRARY_MEMBER',
      },
      caption: '测试库成员',
      codeName: 'EditViewcaptionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.library_member',
      controlParam: {},
      name: 'captionbar',
      id: 'editviewcaptionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'Layoutpanel',
    controlStyle: 'APPDEEDITVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.library_member',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '测试库成员编辑视图',
  titleLanguageRes: {
    lanResTag: 'PAGE.TITLE.LIBRARY_MEMBER.EDITVIEW',
  },
  viewStyle: 'DEFAULT',
  viewType: 'DEEDITVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: 'bf6aeff3368d6791c23919f6d36cd03d',
  modelType: 'PSAPPDEVIEW',
  name: 'library_memberEditView',
  id: 'plmweb.library_membereditview',
};