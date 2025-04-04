export default {
  tabLayout: 'TOP',
  loadDefault: true,
  showDataInfoBar: true,
  deviewCodeName: 'hybrid_flow_setting_tab_view',
  deviewId: 'dac27787a92b7acb7f8bce6ff80b454b',
  accUserMode: 2,
  caption: '混合项目',
  codeName: 'project_hybrid_flow_setting_tab_view',
  appDataEntityId: 'plmweb.project',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'TabExpView',
      id: 'engine',
    },
  ],
  controls: [
    {
      dedrtabPages: [
        {
          caption: '工作项类型',
          appViewId: 'plmweb.work_item_type_global_setting_mixed',
          navigateParams: [
            {
              key: 'n_project_type_eq',
              value: 'hybrid',
              rawValue: true,
              id: 'n_project_type_eq',
            },
          ],
          id: 'work_item_type',
        },
        {
          caption: '组件设置',
          appViewId: 'plmweb.addon_no_name_setting_grid_view',
          navigateParams: [
            {
              key: 'n_owner_subtype_eq',
              value: 'hybrid',
              rawValue: true,
              id: 'n_owner_subtype_eq',
            },
            {
              key: 'n_owner_type_eq',
              value: 'project',
              rawValue: true,
              id: 'n_owner_type_eq',
            },
            {
              key: 'n_owner_id_isnull',
              value: '1',
              rawValue: true,
              id: 'n_owner_id_isnull',
            },
          ],
          id: 'addon_setting',
        },
      ],
      dataRelationTag: 'mixed_flow_setting_tab_view_DR',
      editItemCaption: '项目',
      uniqueTag: 'project_hybrid_flow_setting_tab_view__tabexppanel',
      hideEditItem: true,
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'mixed_flow_setting_tab_view_dr',
      controlType: 'DRTAB',
      appDataEntityId: 'plmweb.project',
      controlParam: {
        id: 'tabexppanel',
      },
      modelId: 'b7e628c5617a22f725579c0f56e68f11',
      modelType: 'PSDEDRTAB',
      name: 'tabexppanel',
      id: 'mixed_flow_setting_tab_view_dr',
    },
    {
      caption: '混合项目',
      codeName: 'hybrid_flow_setting_tab_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.project',
      controlParam: {},
      name: 'captionbar',
      id: 'hybrid_flow_setting_tab_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDETABEXPVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.project',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '混合项目流程全局配置分页视图',
  viewStyle: 'DEFAULT',
  viewType: 'DETABEXPVIEW',
  enableDP: true,
  showCaptionBar: false,
  modelId: '237ba9cb769348863e55cdb4f463b184',
  modelType: 'PSAPPDEVIEW',
  name: 'projecthybrid_flow_setting_tab_view',
  id: 'plmweb.project_hybrid_flow_setting_tab_view',
};
