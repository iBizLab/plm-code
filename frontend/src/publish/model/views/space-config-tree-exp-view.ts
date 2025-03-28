export default {
  showDataInfoBar: true,
  loadDefault: true,
  openMode: 'INDEXVIEWTAB',
  deviewCodeName: 'config_tree_exp_view',
  deviewId: 'a19dad17404136a830fbab202d80fdd9',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.SPACE',
  },
  caption: '配置中心',
  codeName: 'space_config_tree_exp_view',
  appDataEntityId: 'plmweb.space',
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
      title: '空间',
      xdataControlName: 'treeexpbar_tree',
      enableCounter: true,
      showTitleBar: true,
      autoLoad: true,
      showBusyIndicator: true,
      appViewRefs: [
        {
          realTitle: '空间管理',
          refAppViewId: 'plmweb.space_tab_exp_view',
          name: 'EXPITEM:node_4',
          id: 'expitem:node_4',
        },
        {
          realTitle: '页面模板表格视图（全部）',
          refAppViewId: 'plmweb.stencil_all_grid_view',
          name: 'EXPITEM:node_5',
          id: 'expitem:node_5',
        },
        {
          realTitle: '共享页面表格视图',
          refAppViewId: 'plmweb.article_page_shared_grid_view',
          name: 'EXPITEM:node_6',
          id: 'expitem:node_6',
        },
        {
          realTitle: '组件设置',
          refAppViewId: 'plmweb.addon_setting_grid_view',
          name: 'EXPITEM:node_7',
          id: 'expitem:node_7',
        },
        {
          realTitle: '空间分类树导航',
          refAppViewId: 'plmweb.space_category_tree_exp_view',
          name: 'EXPITEM:node_9',
          id: 'expitem:node_9',
        },
      ],
      controls: [
        {
          detreeNodeRSs: [
            {
              childDETreeNodeId: 'node',
              parentDETreeNodeId: 'root',
              parentValueLevel: 1,
              searchMode: 3,
              id: '默认根节点 - 通用',
            },
            {
              childDETreeNodeId: 'node_7',
              parentDETreeNodeId: 'node_2',
              parentValueLevel: 1,
              searchMode: 3,
              id: '配置 - 空间配置',
            },
            {
              childDETreeNodeId: 'node_4',
              parentDETreeNodeId: 'node',
              parentValueLevel: 1,
              searchMode: 3,
              id: '通用 - 空间管理',
            },
            {
              childDETreeNodeId: 'node_5',
              parentDETreeNodeId: 'node_1',
              parentValueLevel: 1,
              searchMode: 3,
              id: '页面 - 页面模板',
            },
            {
              childDETreeNodeId: 'node_8',
              parentDETreeNodeId: 'node_3',
              parentValueLevel: 1,
              searchMode: 3,
              id: '权限 - 权限配置',
            },
            {
              childDETreeNodeId: 'node_6',
              parentDETreeNodeId: 'node_1',
              parentValueLevel: 1,
              searchMode: 3,
              id: '页面 - 页面共享',
            },
            {
              childDETreeNodeId: 'node_1',
              parentDETreeNodeId: 'root',
              parentValueLevel: 1,
              searchMode: 3,
              id: '默认根节点 - 页面',
            },
            {
              childDETreeNodeId: 'node_2',
              parentDETreeNodeId: 'root',
              parentValueLevel: 1,
              searchMode: 3,
              id: '默认根节点 - 配置',
            },
            {
              childDETreeNodeId: 'node_9',
              parentDETreeNodeId: 'node_2',
              parentValueLevel: 1,
              searchMode: 3,
              id: '配置 - 空间分类',
            },
          ],
          detreeNodes: [
            {
              text: '默认根节点',
              nodeType: 'ROOT',
              treeNodeType: 'STATIC',
              hasDETreeNodeRSs: true,
              rootNode: true,
              name: '默认根节点',
              id: 'root',
            },
            {
              text: '通用',
              nodeType: 'node',
              treeNodeType: 'STATIC',
              hasDETreeNodeRSs: true,
              expanded: true,
              name: '通用',
              id: 'node',
            },
            {
              text: '页面',
              nodeType: 'node_1',
              treeNodeType: 'STATIC',
              hasDETreeNodeRSs: true,
              expanded: true,
              name: '页面',
              id: 'node_1',
            },
            {
              text: '配置',
              nodeType: 'node_2',
              treeNodeType: 'STATIC',
              hasDETreeNodeRSs: true,
              expanded: true,
              name: '配置',
              id: 'node_2',
            },
            {
              text: '权限',
              nodeType: 'node_3',
              treeNodeType: 'STATIC',
              hasDETreeNodeRSs: true,
              expanded: true,
              name: '权限',
              id: 'node_3',
            },
            {
              text: '空间管理',
              navAppViewId: 'plmweb.space_tab_exp_view',
              nodeType: 'node_4',
              treeNodeType: 'STATIC',
              name: '空间管理',
              id: 'node_4',
            },
            {
              text: '页面模板',
              navAppViewId: 'plmweb.stencil_all_grid_view',
              nodeType: 'node_5',
              treeNodeType: 'STATIC',
              enableCheck: true,
              name: '页面模板',
              id: 'node_5',
            },
            {
              text: '页面共享',
              navAppViewId: 'plmweb.article_page_shared_grid_view',
              nodeType: 'node_6',
              treeNodeType: 'STATIC',
              enableCheck: true,
              name: '页面共享',
              id: 'node_6',
            },
            {
              text: '空间配置',
              navAppViewId: 'plmweb.addon_setting_grid_view',
              nodeType: 'node_7',
              navigateParams: [
                {
                  key: 'n_owner_id_isnull',
                  value: '1',
                  rawValue: true,
                  id: 'n_owner_id_isnull',
                },
                {
                  key: 'n_owner_type_eq',
                  value: 'space',
                  rawValue: true,
                  id: 'n_owner_type_eq',
                },
              ],
              treeNodeType: 'STATIC',
              name: '空间配置',
              id: 'node_7',
            },
            {
              text: '权限配置',
              nodeType: 'node_8',
              treeNodeType: 'STATIC',
              disableSelect: true,
              name: '权限配置',
              id: 'node_8',
            },
            {
              text: '空间分类',
              navAppViewId: 'plmweb.space_category_tree_exp_view',
              nodeType: 'node_9',
              treeNodeType: 'STATIC',
              expanded: true,
              name: '空间分类',
              id: 'node_9',
            },
          ],
          outputIconDefault: true,
          navViewPos: 'NONE',
          createControlAction: {
            appDEMethodId: 'create',
            appDataEntityId: 'plmweb.space',
            id: 'create',
          },
          fetchControlAction: {
            appDataEntityId: 'plmweb.space',
            id: 'fetch',
          },
          getControlAction: {
            appDEMethodId: 'get',
            appDataEntityId: 'plmweb.space',
            id: 'load',
          },
          removeControlAction: {
            appDEMethodId: 'remove',
            appDataEntityId: 'plmweb.space',
            id: 'remove',
          },
          updateControlAction: {
            appDEMethodId: 'update',
            appDataEntityId: 'plmweb.space',
            id: 'update',
          },
          autoLoad: true,
          showBusyIndicator: true,
          codeName: 'config_view_tree_view',
          controlStyle: 'LIST_TREE',
          controlType: 'TREEVIEW',
          logicName: '空间配置中心树视图',
          appDataEntityId: 'plmweb.space',
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
          modelId: '0a44f73d863a9446eec580daf6d2a9f8',
          modelType: 'PSDETREEVIEW',
          name: 'treeexpbar_tree',
          id: 'plmweb.space.config_view_tree_view',
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
          appDataEntityId: 'plmweb.space',
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
      appDataEntityId: 'plmweb.space',
      controlParam: {
        id: 'treeexpbar',
      },
      modelId: 'd0f250efa95a31f9562b4dfe3bb77416_treeexpbar',
      modelType: 'PSEXPBAR',
      name: 'treeexpbar',
      id: 'config_tree_exp_view_treeexpbar',
    },
    {
      groupMode: 'SINGLE',
      quickSearchMode: 1,
      enableQuickSearch: true,
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.space',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.SPACE',
      },
      caption: '配置中心',
      codeName: 'config_tree_exp_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.space',
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
    appDataEntityId: 'plmweb.space',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '配置中心',
  viewStyle: 'DEFAULT',
  viewType: 'DETREEEXPVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: 'd0f250efa95a31f9562b4dfe3bb77416',
  modelType: 'PSAPPDEVIEW',
  name: 'spaceconfig_tree_exp_view',
  id: 'plmweb.space_config_tree_exp_view',
};
