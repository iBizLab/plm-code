export default {
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  funcViewMode: 'EDITVIEW',
  openMode: 'POPUPMODAL',
  deviewCodeName: 'EditView',
  deviewId: 'f03eb5449300127c50a617c7b60b329e',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.PROJECT_MEMBER',
  },
  caption: '项目成员',
  codeName: 'project_memberEditView',
  appDataEntityId: 'plmweb.project_member',
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
        appDataEntityId: 'plmweb.project_member',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.project_member',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'getdraft',
        appDataEntityId: 'plmweb.project_member',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.project_member',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.project_member',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.project_member',
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
                  appDEFieldId: 'name',
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
                    valueItemName: 'user_id',
                    editorParams: {
                      AC: 'TRUE',
                      PICKUPVIEW: 'TRUE',
                    },
                    editorType: 'PICKER',
                    editorItems: [
                      {
                        id: 'user_id',
                      },
                    ],
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'name',
                  },
                  allowEmpty: true,
                  capLanguageRes: {
                    lanResTag: 'DEF.LNAME.NAME',
                  },
                  caption: '姓名',
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
              capLanguageRes: {
                lanResTag:
                  'CONTROL.DEFORM.PROJECT_MEMBER.MAIN.GROUPPANEL.GROUP1',
              },
              caption: '产品成员基本信息',
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
              appDEFieldId: 'user_id',
              editor: {
                editorType: 'HIDDEN',
                valueType: 'SIMPLE',
                editable: true,
                id: 'user_id',
              },
              allowEmpty: true,
              hidden: true,
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
            lanResTag: 'CONTROL.DEFORM.PROJECT_MEMBER.MAIN.FORMPAGE.FORMPAGE1',
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
      codeName: 'Main',
      controlType: 'FORM',
      logicName: '主编辑表单',
      appDataEntityId: 'plmweb.project_member',
      controlParam: {
        id: 'form',
      },
      modelId: '2efe5a81db86ad8fa99919dd4764eee9',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.project_member.main',
    },
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
      appDataEntityId: 'plmweb.project_member',
      controlParam: {
        id: 'toolbar',
      },
      modelId: '48c8f789be8a5522d3003293c1cf2ffb',
      modelType: 'PSDETOOLBAR',
      name: 'toolbar',
      id: 'editviewtoolbar',
    },
    {
      codeName: 'EditViewdatainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.project_member',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'editviewdatainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.PROJECT_MEMBER',
      },
      caption: '项目成员',
      codeName: 'EditViewcaptionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.project_member',
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
    appDataEntityId: 'plmweb.project_member',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '项目成员编辑视图',
  titleLanguageRes: {
    lanResTag: 'PAGE.TITLE.PROJECT_MEMBER.EDITVIEW',
  },
  viewStyle: 'DEFAULT',
  viewType: 'DEEDITVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '1f88f268232bf41d28b8afe3793b951e',
  modelType: 'PSAPPDEVIEW',
  name: 'project_memberEditView',
  id: 'plmweb.project_membereditview',
};