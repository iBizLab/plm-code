export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  deviewCodeName: 'test_setting_view',
  deviewId: '98581970-E5AD-41B5-BDB0-5D365D304D6A',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.MANAGEMENT',
  },
  caption: '配置中心',
  codeName: 'management_test_setting_view',
  appDataEntityId: 'plmweb.management',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'EditView2',
      id: 'engine',
    },
  ],
  appViewNavContexts: [
    {
      rawValue: true,
      key: 'MANAGEMENT',
      value: 'management',
      name: 'MANAGEMENT',
      id: 'management',
    },
  ],
  controls: [
    {
      createControlAction: {
        appDEMethodId: 'create',
        appDataEntityId: 'plmweb.management',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.management',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'get_draft',
        appDataEntityId: 'plmweb.management',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.management',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.management',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.management',
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
              capLanguageRes: {
                lanResTag: 'CONTROL.DEFORM.MANAGEMENT.MAIN.GROUPPANEL.GROUP1',
              },
              caption: '后台管理基本信息',
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
          capLanguageRes: {
            lanResTag: 'CONTROL.DEFORM.MANAGEMENT.MAIN.FORMPAGE.FORMPAGE1',
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
      codeName: 'main',
      controlType: 'FORM',
      logicName: '主编辑表单',
      appDataEntityId: 'plmweb.management',
      controlParam: {
        id: 'form',
      },
      modelId: '6ce527151e22b4b202ac44c7ac5c39bb',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.management.main',
    },
    {
      dedrbarGroups: [
        {
          caption: '通用',
          name: '通用',
          id: 'usrdrgroup0514095082',
        },
        {
          caption: '产品',
          name: '产品',
          id: 'usrdrgroup0514569929',
        },
      ],
      showTitle: true,
      dataRelationTag: 'config_tab_exp_view_DR',
      editItemCapLanguageRes: {
        lanResTag: 'DE.LNAME.MANAGEMENT',
      },
      editItemCaption: '后台管理',
      dedrctrlItems: [
        {
          dedrbarGroupId: 'usrdrgroup0514095082',
          caption: '工时设置',
          appViewId: 'plmweb.workload_type_setup_grid_view',
          sysImage: {
            cssClass: 'fa fa-gear',
            glyph: 'xf013@FontAwesome',
          },
          id: 'workload',
        },
        {
          dedrbarGroupId: 'usrdrgroup0514569929',
          caption: '产品管理',
          appViewId: 'plmweb.product_config_tree_exp_view',
          sysImage: {
            cssClass: 'fa fa-th-large',
            glyph: 'xf009@FontAwesome',
          },
          id: 'product',
        },
        {
          dedrbarGroupId: 'usrdrgroup0514569929',
          caption: '项目管理',
          appViewId: 'plmweb.project_config_tree_exp_view',
          sysImage: {
            cssClass: 'fa fa-file-text-o',
            glyph: 'xf0f6@FontAwesome',
          },
          id: 'project',
        },
        {
          dedrbarGroupId: 'usrdrgroup0514569929',
          caption: '测试管理',
          appViewId: 'plmweb.library_config_tree_exp_view',
          sysImage: {
            cssClass: 'fa fa-bug',
            glyph: 'xf188@FontAwesome',
          },
          id: 'library',
        },
        {
          dedrbarGroupId: 'usrdrgroup0514569929',
          caption: '知识管理',
          appViewId: 'plmweb.space_config_tree_exp_view',
          sysImage: {
            cssClass: 'fa fa-book',
            glyph: 'xf02d@FontAwesome',
          },
          id: 'space',
        },
        {
          dedrbarGroupId: 'usrdrgroup0514569929',
          caption: '效能度量',
          appViewId: 'plmweb.insight_view_config_tree_exp_view',
          sysImage: {
            cssClass: 'fa fa-bar-chart-o',
            glyph: 'xf080@FontAwesome',
          },
          id: 'insight_view',
        },
        {
          dedrbarGroupId: 'usrdrgroup0514569929',
          caption: '协作空间',
          appViewId: 'plmweb.discuss_topic_config_tree_exp_view',
          sysImage: {
            cssClass: 'fa fa-comments',
            glyph: 'xf086@FontAwesome',
          },
          id: 'discuss',
        },
      ],
      uniqueTag: 'management_test_setting_view__drbar',
      hideEditItem: true,
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'config_tab_exp_view_dr',
      controlStyle: 'ROUTE_DRBAR',
      controlType: 'DRBAR',
      appDataEntityId: 'plmweb.management',
      controlParam: {
        ctrlParams: {
          ROUTE_ITEMS: '["product", "project", "library", "space"]',
        },
        id: 'drbar',
      },
      sysPFPluginId: 'route_drbar',
      modelId: '73F9D095-4112-43A5-B444-F9A1DB2349C1',
      modelType: 'PSDEDRBAR',
      name: 'drbar',
      id: 'config_tab_exp_view_dr',
    },
    {
      codeName: 'test_setting_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.management',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'test_setting_view_datainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.MANAGEMENT',
      },
      caption: '配置中心',
      codeName: 'test_setting_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.management',
      controlParam: {},
      name: 'captionbar',
      id: 'test_setting_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEEDITVIEW2',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.management',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '配置中心',
  viewStyle: 'DEFAULT',
  viewType: 'DEEDITVIEW2',
  enableDP: true,
  showCaptionBar: false,
  modelId: '1148a5101ae882a50c20fa157f54d805',
  modelType: 'PSAPPDEVIEW',
  name: 'managementtest_setting_view',
  id: 'plmweb.management_test_setting_view',
};