export default {
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  deviewCodeName: 'setting_view',
  deviewId: '5578f54141f5dfe5c51ec7293c125c73',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.LIBRARY',
  },
  caption: '测试库配置',
  codeName: 'library_setting_view',
  appDataEntityId: 'plmweb.library',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'EditView2',
      id: 'engine',
    },
  ],
  controls: [
    {
      createControlAction: {
        appDEMethodId: 'create',
        appDataEntityId: 'plmweb.library',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.library',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'getdraft',
        appDataEntityId: 'plmweb.library',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.library',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.library',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.library',
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
          caption: '分页1',
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
      codeName: 'Overview',
      controlType: 'FORM',
      logicName: '测试库首页视图_表单',
      appDataEntityId: 'plmweb.library',
      controlParam: {
        id: 'form',
      },
      modelId: 'efc0ff7efce2ac40b1f159cd0a5874c1',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.library.overview',
    },
    {
      dedrbarGroups: [
        {
          caption: '通用',
          name: '通用',
          id: 'usrdrgroup0319461775',
        },
        {
          caption: '设置',
          name: '设置',
          id: 'usrdrgroup0319986719',
        },
      ],
      showTitle: true,
      editItemCapLanguageRes: {
        lanResTag: 'DE.LNAME.LIBRARY',
      },
      editItemCaption: '测试库',
      dedrctrlItems: [
        {
          dedrbarGroupId: 'usrdrgroup0319461775',
          caption: '测试库成员',
          appViewId: 'plmweb.library_membergrid_view_config',
          id: 'member',
        },
        {
          dedrbarGroupId: 'usrdrgroup0319461775',
          caption: '回收站',
          appViewId: 'plmweb.test_caserecycle_grid_view',
          id: 'recycle',
        },
        {
          dedrbarGroupId: 'usrdrgroup0319986719',
          caption: '基本信息',
          appViewId: 'plmweb.libraryedit_view_base_info',
          id: 'base',
        },
        {
          dedrbarGroupId: 'usrdrgroup0319986719',
          caption: '高级设置',
          appViewId: 'plmweb.libraryedit_view_advanced_setting',
          id: 'adv',
        },
      ],
      uniqueTag: 'library_setting_view__drbar',
      hideEditItem: true,
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'setting_view_dr',
      controlType: 'DRBAR',
      appDataEntityId: 'plmweb.library',
      controlParam: {
        ctrlParams: {
          SINGLEITEMGROUP: 'true',
        },
        id: 'drbar',
      },
      modelId: 'e5961ed40a3843e7a440e2b7665b9be4',
      modelType: 'PSDEDRBAR',
      name: 'drbar',
      id: 'setting_view_dr',
    },
    {
      codeName: 'setting_viewdatainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.library',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'setting_viewdatainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.LIBRARY',
      },
      caption: '测试库配置',
      codeName: 'setting_viewcaptionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.library',
      controlParam: {},
      name: 'captionbar',
      id: 'setting_viewcaptionbar',
    },
  ],
  sysCss: {
    cssName: 'editview2-menu',
  },
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'Layoutpanel',
    controlStyle: 'APPDEEDITVIEW2',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.library',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '测试库配置',
  viewStyle: 'DEFAULT',
  viewType: 'DEEDITVIEW2',
  enableDP: true,
  showCaptionBar: false,
  modelId: 'ce46569c589b9b4e7d1b14ccea84aae2',
  modelType: 'PSAPPDEVIEW',
  name: 'library_setting_view',
  id: 'plmweb.library_setting_view',
};