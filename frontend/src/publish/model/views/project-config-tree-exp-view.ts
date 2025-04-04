export default {
  showDataInfoBar: true,
  loadDefault: true,
  deviewCodeName: 'config_tree_exp_view',
  deviewId: '8f3308d70621c164f17488800512c653',
  accUserMode: 2,
  caption: '项目管理',
  codeName: 'project_config_tree_exp_view',
  appDataEntityId: 'plmweb.project',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'TreeExpView',
      id: 'engine',
    },
  ],
  appViewLogics: [
    {
      logicTrigger: 'CUSTOM',
      logicType: 'APPUILOGIC',
      builtinAppUILogic: {
        actionAfterWizard: 'DEFAULT',
        builtinLogic: true,
        logicType: 'PREDEFINED',
        viewLogicType: 'APP_NEWDATA',
        id: '新建数据',
      },
      builtinLogic: true,
      id: 'newdata',
    },
    {
      logicTrigger: 'CUSTOM',
      logicType: 'APPUILOGIC',
      builtinAppUILogic: {
        editMode: true,
        builtinLogic: true,
        logicType: 'PREDEFINED',
        viewLogicType: 'APP_OPENDATA',
        id: '打开数据',
      },
      builtinLogic: true,
      id: 'opendata',
    },
  ],
  controls: [
    {
      title: '项目',
      xdataControlName: 'treeexpbar_tree',
      enableCounter: true,
      showTitleBar: true,
      autoLoad: true,
      showBusyIndicator: true,
      appViewRefs: [
        {
          realTitle: '项目管理',
          refAppViewId: 'plmweb.project_management_tab_exp_view',
          name: 'EXPITEM:node',
          id: 'expitem:node',
        },
        {
          realTitle: '项目标签管理',
          refAppViewId: 'plmweb.project_tag_tag_grid_view',
          name: 'EXPITEM:node_1',
          id: 'expitem:node_1',
        },
        {
          realTitle: '工时类别',
          refAppViewId: 'plmweb.workload_type_pick_up_tap_exp_view',
          name: 'EXPITEM:node_14',
          id: 'expitem:node_14',
        },
        {
          realTitle: '混合项目流程全局配置分页视图',
          refAppViewId: 'plmweb.project_hybrid_flow_setting_tab_view',
          name: 'EXPITEM:node_15',
          id: 'expitem:node_15',
        },
        {
          realTitle: '项目集管理分页导航视图',
          refAppViewId: 'plmweb.portfolio_project_set_tab_exp_view',
          name: 'EXPITEM:node_2',
          id: 'expitem:node_2',
        },
        {
          realTitle: 'scrum项目',
          refAppViewId: 'plmweb.project_scrum_flow_setting_tab_view',
          name: 'EXPITEM:node_3',
          id: 'expitem:node_3',
        },
        {
          realTitle: 'kanban项目流程全局配置分页视图',
          refAppViewId: 'plmweb.project_kanban_flow_setting_tab_view',
          name: 'EXPITEM:node_4',
          id: 'expitem:node_4',
        },
        {
          realTitle: 'waterfall项目流程全局配置分页视图',
          refAppViewId: 'plmweb.project_waterfall_flow_setting_tab_view',
          name: 'EXPITEM:node_5',
          id: 'expitem:node_5',
        },
        {
          realTitle: '工作项配置',
          refAppViewId: 'plmweb.work_item_global_setting_view',
          name: 'EXPITEM:node_6',
          id: 'expitem:node_6',
        },
        {
          realTitle: '项目全局配置视图',
          refAppViewId: 'plmweb.project_global_setting_view',
          name: 'EXPITEM:node_7',
          id: 'expitem:node_7',
        },
        {
          realTitle: '发布配置',
          refAppViewId: 'plmweb.dictionary_data_global_tab_exp_view',
          name: 'EXPITEM:node_8',
          id: 'expitem:node_8',
        },
      ],
      controls: [
        {
          detreeNodeRSs: [
            {
              childDETreeNodeId: 'node',
              parentDETreeNodeId: 'node_10',
              parentValueLevel: 1,
              searchMode: 3,
              id: '通用 - 项目管理',
            },
            {
              childDETreeNodeId: 'node_3',
              parentDETreeNodeId: 'node_11',
              parentValueLevel: 1,
              searchMode: 3,
              name: '流程 - Scrum项目',
              id: '流程 - scrum项目',
            },
            {
              childDETreeNodeId: 'node_6',
              parentDETreeNodeId: 'node_12',
              parentValueLevel: 1,
              searchMode: 3,
              id: '配置 - 工作项配置',
            },
            {
              childDETreeNodeId: 'node_9',
              parentDETreeNodeId: 'node_13',
              parentValueLevel: 1,
              searchMode: 3,
              id: '权限 - 权限配置',
            },
            {
              childDETreeNodeId: 'node_10',
              parentDETreeNodeId: 'root',
              parentValueLevel: 1,
              searchMode: 3,
              id: '默认根节点 - 通用',
            },
            {
              childDETreeNodeId: 'node_11',
              parentDETreeNodeId: 'root',
              parentValueLevel: 1,
              searchMode: 3,
              id: '默认根节点 - 流程',
            },
            {
              childDETreeNodeId: 'node_2',
              parentDETreeNodeId: 'node_10',
              parentValueLevel: 1,
              searchMode: 3,
              id: '通用 - 项目集管理',
            },
            {
              childDETreeNodeId: 'node_7',
              parentDETreeNodeId: 'node_12',
              parentValueLevel: 1,
              searchMode: 3,
              id: '配置 - 项目配置',
            },
            {
              childDETreeNodeId: 'node_4',
              parentDETreeNodeId: 'node_11',
              parentValueLevel: 1,
              searchMode: 3,
              name: '流程 - Kanban项目',
              id: '流程 - kanban项目',
            },
            {
              childDETreeNodeId: 'node_12',
              parentDETreeNodeId: 'root',
              parentValueLevel: 1,
              searchMode: 3,
              id: '默认根节点 - 配置',
            },
            {
              childDETreeNodeId: 'node_1',
              parentDETreeNodeId: 'node_10',
              parentValueLevel: 1,
              searchMode: 3,
              id: '通用 - 标签管理',
            },
            {
              childDETreeNodeId: 'node_8',
              parentDETreeNodeId: 'node_12',
              parentValueLevel: 1,
              searchMode: 3,
              id: '配置 - 发布配置',
            },
            {
              childDETreeNodeId: 'node_5',
              parentDETreeNodeId: 'node_11',
              parentValueLevel: 1,
              searchMode: 3,
              id: '流程 - 瀑布项目',
            },
            {
              childDETreeNodeId: 'node_15',
              parentDETreeNodeId: 'node_11',
              parentValueLevel: 1,
              searchMode: 3,
              id: '流程 - 混合项目',
            },
          ],
          detreeNodes: [
            {
              nodeValue: 'root',
              text: '默认根节点',
              nodeType: 'ROOT',
              treeNodeType: 'STATIC',
              hasDETreeNodeRSs: true,
              rootNode: true,
              name: '默认根节点',
              id: 'root',
            },
            {
              text: '项目管理',
              navAppViewId: 'plmweb.project_management_tab_exp_view',
              nodeType: 'node',
              appDataEntityId: 'plmweb.project',
              treeNodeType: 'STATIC',
              name: '项目管理',
              id: 'node',
            },
            {
              text: '标签管理',
              navAppViewId: 'plmweb.project_tag_tag_grid_view',
              nodeType: 'node_1',
              treeNodeType: 'STATIC',
              name: '标签管理',
              id: 'node_1',
            },
            {
              text: '通用',
              nodeType: 'node_10',
              treeNodeType: 'STATIC',
              hasDETreeNodeRSs: true,
              expanded: true,
              name: '通用',
              id: 'node_10',
            },
            {
              text: '流程',
              nodeType: 'node_11',
              treeNodeType: 'STATIC',
              hasDETreeNodeRSs: true,
              expanded: true,
              name: '流程',
              id: 'node_11',
            },
            {
              text: '配置',
              nodeType: 'node_12',
              treeNodeType: 'STATIC',
              hasDETreeNodeRSs: true,
              expanded: true,
              name: '配置',
              id: 'node_12',
            },
            {
              text: '权限',
              nodeType: 'node_13',
              treeNodeType: 'STATIC',
              hasDETreeNodeRSs: true,
              expanded: true,
              name: '权限',
              id: 'node_13',
            },
            {
              text: '工时设置',
              navAppViewId: 'plmweb.workload_type_pick_up_tap_exp_view',
              nodeType: 'node_14',
              treeNodeType: 'STATIC',
              name: '工时设置',
              id: 'node_14',
            },
            {
              text: '混合项目',
              navAppViewId: 'plmweb.project_hybrid_flow_setting_tab_view',
              nodeType: 'node_15',
              treeNodeType: 'STATIC',
              enableCheck: true,
              name: '混合项目',
              id: 'node_15',
            },
            {
              text: '项目集管理',
              navAppViewId: 'plmweb.portfolio_project_set_tab_exp_view',
              nodeType: 'node_2',
              treeNodeType: 'STATIC',
              name: '项目集管理',
              id: 'node_2',
            },
            {
              text: 'Scrum项目',
              navAppViewId: 'plmweb.project_scrum_flow_setting_tab_view',
              nodeType: 'node_3',
              treeNodeType: 'STATIC',
              name: 'Scrum项目',
              id: 'node_3',
            },
            {
              text: 'Kanban项目',
              navAppViewId: 'plmweb.project_kanban_flow_setting_tab_view',
              nodeType: 'node_4',
              treeNodeType: 'STATIC',
              enableCheck: true,
              name: 'Kanban项目',
              id: 'node_4',
            },
            {
              text: '瀑布项目',
              navAppViewId: 'plmweb.project_waterfall_flow_setting_tab_view',
              nodeType: 'node_5',
              treeNodeType: 'STATIC',
              enableCheck: true,
              name: '瀑布项目',
              id: 'node_5',
            },
            {
              text: '工作项配置',
              navAppViewId: 'plmweb.work_item_global_setting_view',
              nodeType: 'node_6',
              treeNodeType: 'STATIC',
              name: '工作项配置',
              id: 'node_6',
            },
            {
              text: '项目配置',
              navAppViewId: 'plmweb.project_global_setting_view',
              nodeType: 'node_7',
              treeNodeType: 'STATIC',
              enableCheck: true,
              name: '项目配置',
              id: 'node_7',
            },
            {
              text: '发布配置',
              navAppViewId: 'plmweb.dictionary_data_global_tab_exp_view',
              nodeType: 'node_8',
              treeNodeType: 'STATIC',
              name: '发布配置',
              id: 'node_8',
            },
            {
              text: '权限配置',
              nodeType: 'node_9',
              treeNodeType: 'STATIC',
              disableSelect: true,
              name: '权限配置',
              id: 'node_9',
            },
          ],
          outputIconDefault: true,
          navViewPos: 'NONE',
          createControlAction: {
            appDEMethodId: 'create',
            appDataEntityId: 'plmweb.project',
            id: 'create',
          },
          fetchControlAction: {
            appDataEntityId: 'plmweb.project',
            id: 'fetch',
          },
          getControlAction: {
            appDEMethodId: 'get',
            appDataEntityId: 'plmweb.project',
            id: 'load',
          },
          removeControlAction: {
            appDEMethodId: 'remove',
            appDataEntityId: 'plmweb.project',
            id: 'remove',
          },
          updateControlAction: {
            appDEMethodId: 'update',
            appDataEntityId: 'plmweb.project',
            id: 'update',
          },
          autoLoad: true,
          showBusyIndicator: true,
          codeName: 'tree_exp_view_config_tree_view',
          controlStyle: 'LIST_TREE',
          controlType: 'TREEVIEW',
          logicName: '项目配置中心视图_树视图',
          appDataEntityId: 'plmweb.project',
          controlLogics: [
            {
              eventNames: 'SELECTIONCHANGE',
              logicTag: 'treeexpbar_tree',
              logicType: 'CUSTOM',
              triggerType: 'CTRLEVENT',
              id: 'treeexpbar_selectionchange',
            },
            {
              eventNames: 'LOAD',
              logicTag: 'treeexpbar_tree',
              logicType: 'CUSTOM',
              triggerType: 'CTRLEVENT',
              id: 'treeexpbar_load',
            },
          ],
          controlParam: {
            id: 'treeexpbar_tree',
          },
          sysPFPluginId: 'list_tree',
          modelId: '8d94ad11f9804a52c86924b4e19fe2e5',
          modelType: 'PSDETREEVIEW',
          name: 'treeexpbar_tree',
          id: 'plmweb.project.tree_exp_view_config_tree_view',
        },
        {
          detoolbarItems: [
            {
              actionLevel: 100,
              buttonStyle: 'STYLE2',
              noPrivDisplayMode: 2,
              uiactionId: 'back@management',
              uiactionTarget: 'NONE',
              valid: true,
              caption: '返回',
              itemType: 'DEUIACTION',
              sysImage: {
                cssClass: 'fa fa-chevron-left',
                glyph: 'xf053@FontAwesome',
              },
              tooltip: '返回',
              showCaption: true,
              showIcon: true,
              id: 'deuiaction1',
            },
          ],
          toolbarStyle: 'USER',
          codeName: 'config_tree_exp_view_treeexpbar_toolbar',
          controlType: 'TOOLBAR',
          logicName: '工具栏模板（只有返回按钮）',
          appDataEntityId: 'plmweb.project',
          controlParam: {
            id: 'treeexpbar_toolbar',
          },
          modelId: 'be873c7b0d54fcd8bd373a87dc6c926b',
          modelType: 'PSDETOOLBAR',
          name: 'treeexpbar_toolbar',
          id: 'config_tree_exp_view_treeexpbar_toolbar',
        },
      ],
      codeName: 'config_tree_exp_view_treeexpbar',
      controlType: 'TREEEXPBAR',
      appDataEntityId: 'plmweb.project',
      controlParam: {
        id: 'treeexpbar',
      },
      modelId: '97997bce36c67fe34b96a8dcc23c4855_treeexpbar',
      modelType: 'PSEXPBAR',
      name: 'treeexpbar',
      id: 'config_tree_exp_view_treeexpbar',
    },
    {
      groupMode: 'SINGLE',
      quickSearchMode: 1,
      enableQuickSearch: true,
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.project',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      caption: '项目管理',
      codeName: 'config_tree_exp_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.project',
      controlParam: {},
      name: 'captionbar',
      id: 'config_tree_exp_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDETREEEXPVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.project',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '项目管理配置',
  viewStyle: 'DEFAULT',
  viewType: 'DETREEEXPVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '97997bce36c67fe34b96a8dcc23c4855',
  modelType: 'PSAPPDEVIEW',
  name: 'projectconfig_tree_exp_view',
  id: 'plmweb.project_config_tree_exp_view',
};
