export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  openMode: 'POPUPMODAL',
  deviewCodeName: 'info_edit_view',
  deviewId: 'd69993e86420017e75a313d6dafe7b5f',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.DYNADASHBOARD',
  },
  caption: '仪表盘',
  codeName: 'dyna_dashboard_info_edit_view',
  height: 180,
  appDataEntityId: 'plmweb.dyna_dashboard',
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
      codeName: 'info_edit_view_toolbar',
      controlType: 'TOOLBAR',
      logicName: '仪表盘快速建立视图_工具栏',
      appDataEntityId: 'plmweb.dyna_dashboard',
      controlParam: {
        id: 'toolbar',
      },
      modelId: 'efed127fba84cdda3c85dc0d8c6c5167',
      modelType: 'PSDETOOLBAR',
      name: 'toolbar',
      id: 'info_edit_view_toolbar',
    },
    {
      createControlAction: {
        appDEMethodId: 'create',
        appDataEntityId: 'plmweb.dyna_dashboard',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.dyna_dashboard',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'get_draft',
        appDataEntityId: 'plmweb.dyna_dashboard',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.dyna_dashboard',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.dyna_dashboard',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.dyna_dashboard',
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
              labelPos: 'TOP',
              labelWidth: 130,
              noPrivDisplayMode: 1,
              appDEFieldId: 'dyna_dashboard_name',
              editor: {
                maxLength: 200,
                editorType: 'TEXTBOX',
                valueType: 'SIMPLE',
                editable: true,
                id: 'dynadashboardname',
              },
              caption: '仪表盘名称',
              codeName: 'dynadashboardname',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'dynadashboardname',
            },
            {
              createDV: 'insight_view',
              dataType: 25,
              enableCond: 3,
              labelPos: 'LEFT',
              labelWidth: 130,
              noPrivDisplayMode: 1,
              appDEFieldId: 'owner_type',
              editor: {
                editorType: 'HIDDEN',
                valueType: 'SIMPLE',
                editable: true,
                id: 'owner_type',
              },
              updateDV: 'insight_view',
              allowEmpty: true,
              hidden: true,
              caption: '所属数据类型',
              codeName: 'owner_type',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              id: 'owner_type',
            },
            {
              createDV: 'insight_view',
              createDVT: 'APPDATA',
              dataType: 25,
              enableCond: 3,
              labelPos: 'LEFT',
              labelWidth: 130,
              noPrivDisplayMode: 1,
              appDEFieldId: 'owner_id',
              editor: {
                editorType: 'HIDDEN',
                valueType: 'SIMPLE',
                editable: true,
                id: 'owner_id',
              },
              updateDV: 'insight_view',
              updateDVT: 'APPDATA',
              allowEmpty: true,
              hidden: true,
              caption: '所属数据标识',
              codeName: 'owner_id',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              id: 'owner_id',
            },
            {
              createDV: 'data',
              dataType: 25,
              enableCond: 3,
              labelPos: 'LEFT',
              labelWidth: 130,
              noPrivDisplayMode: 1,
              appDEFieldId: 'type',
              editor: {
                editorType: 'HIDDEN',
                valueType: 'SIMPLE',
                editable: true,
                id: 'type',
              },
              updateDV: 'data',
              allowEmpty: true,
              hidden: true,
              caption: '看板类型',
              codeName: 'type',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              id: 'type',
            },
            {
              createDV: 'ibizplm__plmweb',
              dataType: 25,
              enableCond: 3,
              labelPos: 'LEFT',
              labelWidth: 130,
              noPrivDisplayMode: 1,
              appDEFieldId: 'app_id',
              editor: {
                editorType: 'HIDDEN',
                valueType: 'SIMPLE',
                editable: true,
                id: 'appid',
              },
              updateDV: 'ibizplm__plmweb',
              allowEmpty: true,
              hidden: true,
              caption: '应用标识',
              codeName: 'appid',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              id: 'appid',
            },
            {
              dataType: 25,
              enableCond: 3,
              labelPos: 'LEFT',
              labelWidth: 130,
              noPrivDisplayMode: 1,
              appDEFieldId: 'dyna_dashboard_id',
              editor: {
                editorType: 'HIDDEN',
                valueType: 'SIMPLE',
                editable: true,
                id: 'dynadashboardid',
              },
              allowEmpty: true,
              hidden: true,
              caption: '动态数据看板标识',
              codeName: 'dynadashboardid',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              id: 'dynadashboardid',
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
      logicName: '仪表盘快速建立视图_表单',
      appDataEntityId: 'plmweb.dyna_dashboard',
      controlParam: {
        id: 'form',
      },
      modelId: 'c4b373911646027e40e7276a402168b6',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.dyna_dashboard.quick_create_view_form',
    },
    {
      codeName: 'info_edit_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.dyna_dashboard',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'info_edit_view_datainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.DYNADASHBOARD',
      },
      caption: '仪表盘',
      codeName: 'info_edit_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.dyna_dashboard',
      controlParam: {},
      name: 'captionbar',
      id: 'info_edit_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEEDITVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.dyna_dashboard',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '仪表盘编辑视图',
  viewStyle: 'DEFAULT',
  viewType: 'DEEDITVIEW',
  width: 500,
  enableDP: true,
  showCaptionBar: true,
  modelId: 'da4cc0716175ddeddc88034f1e9c1539',
  modelType: 'PSAPPDEVIEW',
  name: 'dyna_dashboardinfo_edit_view',
  id: 'plmweb.dyna_dashboard_info_edit_view',
};
