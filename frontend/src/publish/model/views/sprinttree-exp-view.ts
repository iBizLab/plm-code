export default {
  showDataInfoBar: true,
  loadDefault: true,
  deviewCodeName: 'tree_exp_view',
  deviewId: '9e91449f463ecce8f39d1da83c2c97aa',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.SPRINT',
  },
  caption: '迭代',
  codeName: 'sprinttree_exp_view',
  appDataEntityId: 'plmweb.sprint',
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
  appViewNavParams: [
    {
      key: 'n_owner_id_eq',
      value: 'project',
      id: 'n_owner_id_eq',
    },
    {
      rawValue: true,
      key: 'n_owner_subtype_eq',
      value: 'sprint',
      id: 'n_owner_subtype_eq',
    },
    {
      rawValue: true,
      key: 'n_owner_type_eq',
      value: 'project',
      id: 'n_owner_type_eq',
    },
  ],
  controls: [
    {
      title: '迭代',
      xdataControlName: 'treeexpbar_tree',
      enableCounter: true,
      showTitleBar: true,
      autoLoad: true,
      showBusyIndicator: true,
      appViewRefs: [
        {
          realTitle: '迭代树导航表格视图',
          refAppViewId: 'plmweb.sprintgrid_view_all',
          name: 'EXPITEM:node',
          id: 'expitem:node',
        },
        {
          realTitle: '迭代树导航表格视图',
          refAppViewId: 'plmweb.sprintgrid_view_all',
          name: 'EXPITEM:node_2',
          id: 'expitem:node_2',
        },
        {
          realTitle: '迭代树导航表格视图',
          refAppViewId: 'plmweb.sprintgrid_view_all',
          name: 'EXPITEM:node_3',
          id: 'expitem:node_3',
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
              id: '默认根节点 - 全部迭代',
            },
            {
              childDETreeNodeId: 'node_2',
              parentAppDEFieldId: 'section_id',
              parentDER1N: {
                masterRS: 32,
                pickupDEFName: 'SECTION_ID',
                codeName: 'Section',
                dertype: 'DER1N',
                logicName: '分组-类别',
                minorCodeName: 'section_categories',
                minorServiceCodeName: 'section_categories',
                orderValue: 100,
                serviceCodeName: 'Section',
                name: 'DER1N_CATEGORY_SECTION_SECTION_ID',
                id: 'base.category.der1n_category_section_section_id',
              },
              parentDETreeNodeId: 'node_1',
              parentValueLevel: 1,
              searchMode: 3,
              id: '迭代分组 - 迭代类型',
            },
            {
              childDETreeNodeId: 'node_3',
              parentDETreeNodeId: 'root',
              parentValueLevel: 1,
              searchMode: 3,
              id: '默认根节点 - 无分组',
            },
            {
              childDETreeNodeId: 'node_1',
              parentDETreeNodeId: 'root',
              parentValueLevel: 1,
              searchMode: 3,
              id: '默认根节点 - 迭代分组',
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
              text: '全部迭代',
              navAppViewId: 'plmweb.sprintgrid_view_all',
              nodeType: 'node',
              navigateParams: [
                {
                  key: 'n_project_id_eq',
                  value: 'project',
                  id: 'n_project_id_eq',
                },
              ],
              sysImage: {
                cssClass: 'fa fa-th-large',
                glyph: 'xf009@FontAwesome',
              },
              treeNodeType: 'STATIC',
              name: '全部迭代',
              id: 'node',
            },
            {
              idAppDEFieldId: 'id',
              leafFlagAppDEFieldId: 'is_leaf',
              appDEDataSetId: 'fetchdefault',
              sortDir: 'ASC',
              sortAppDEFieldId: 'sequence',
              textAppDEFieldId: 'name',
              nodeType: 'node_1',
              appDataEntityId: 'plmweb.section',
              decontextMenu: {
                detoolbarItems: [
                  {
                    actionLevel: 100,
                    noPrivDisplayMode: 2,
                    uiactionId:
                      'toolbar_tree_exp_viewnode_1_cm_deuiaction1_click@sprint',
                    uiactionTarget: 'SINGLEDATA',
                    valid: true,
                    caption: '编辑',
                    itemType: 'DEUIACTION',
                    sysImage: {
                      cssClass: 'fa fa-edit',
                      glyph: 'xf044@FontAwesome',
                    },
                    tooltip: '编辑',
                    showCaption: true,
                    showIcon: true,
                    id: 'deuiaction1',
                  },
                  {
                    actionLevel: 100,
                    noPrivDisplayMode: 2,
                    uiactionId:
                      'toolbar_tree_exp_viewnode_1_cm_deuiaction2_click@sprint',
                    uiactionTarget: 'SINGLEDATA',
                    valid: true,
                    caption: '删除',
                    itemType: 'DEUIACTION',
                    sysImage: {
                      cssClass: 'fa fa-trash-o',
                      glyph: 'xf014@FontAwesome',
                    },
                    tooltip: '删除',
                    showCaption: true,
                    showIcon: true,
                    id: 'deuiaction2',
                  },
                ],
                toolbarStyle: 'CONTEXTMENU',
                codeName: 'tree_exp_viewnode_1_cm',
                controlType: 'CONTEXTMENU',
                logicName: '树节点上下文菜单',
                appDataEntityId: 'plmweb.sprint',
                controlParam: {
                  id: 'node_1_cm',
                },
                modelId: '543565081aa885721f9f24522a62c7a5',
                modelType: 'PSDETOOLBAR',
                name: 'node_1_cm',
                id: 'tree_exp_viewnode_1_cm',
              },
              sysImage: {
                cssClass: 'fa fa-table',
                glyph: 'xf0ce@FontAwesome',
              },
              treeNodeType: 'DE',
              hasDETreeNodeRSs: true,
              allowDrag: true,
              allowDrop: true,
              allowEditText: true,
              allowOrder: true,
              expanded: true,
              name: '迭代分组',
              id: 'node_1',
            },
            {
              idAppDEFieldId: 'id',
              leafFlagAppDEFieldId: 'is_leaf',
              appDEDataSetId: 'fetchdefault',
              sortDir: 'ASC',
              sortAppDEFieldId: 'sequence',
              textAppDEFieldId: 'name',
              navAppViewId: 'plmweb.sprintgrid_view_all',
              nodeType: 'node_2',
              appDataEntityId: 'plmweb.category',
              decontextMenu: {
                detoolbarItems: [
                  {
                    actionLevel: 100,
                    noPrivDisplayMode: 2,
                    uiactionId:
                      'toolbar_tree_exp_viewnode_2_cm_deuiaction1_click@sprint',
                    uiactionTarget: 'SINGLEDATA',
                    valid: true,
                    caption: '编辑',
                    itemType: 'DEUIACTION',
                    sysImage: {
                      cssClass: 'fa fa-edit',
                      glyph: 'xf044@FontAwesome',
                    },
                    tooltip: '编辑',
                    showCaption: true,
                    showIcon: true,
                    id: 'deuiaction1',
                  },
                  {
                    actionLevel: 100,
                    noPrivDisplayMode: 2,
                    uiactionId:
                      'toolbar_tree_exp_viewnode_2_cm_deuiaction2_click@sprint',
                    uiactionTarget: 'SINGLEDATA',
                    valid: true,
                    caption: '删除',
                    itemType: 'DEUIACTION',
                    sysImage: {
                      cssClass: 'fa fa-trash-o',
                      glyph: 'xf014@FontAwesome',
                    },
                    tooltip: '删除',
                    showCaption: true,
                    showIcon: true,
                    id: 'deuiaction2',
                  },
                ],
                toolbarStyle: 'CONTEXTMENU',
                codeName: 'tree_exp_viewnode_2_cm',
                controlType: 'CONTEXTMENU',
                logicName: '树节点上下文菜单',
                appDataEntityId: 'plmweb.sprint',
                controlParam: {
                  id: 'node_2_cm',
                },
                modelId: '543565081aa885721f9f24522a62c7a5',
                modelType: 'PSDETOOLBAR',
                name: 'node_2_cm',
                id: 'tree_exp_viewnode_2_cm',
              },
              navigateParams: [
                {
                  key: 'n_categories_like',
                  value: 'id',
                  id: 'n_categories_like',
                },
              ],
              sysImage: {
                cssClass: 'fa fa-reorder',
                glyph: 'xf0c9@FontAwesome',
              },
              treeNodeType: 'DE',
              allowDrag: true,
              allowDrop: true,
              allowEditText: true,
              allowOrder: true,
              name: '迭代类型',
              id: 'node_2',
            },
            {
              idAppDEFieldId: 'id',
              leafFlagAppDEFieldId: 'is_leaf',
              appDEDataSetId: 'fetchno_section',
              sortDir: 'ASC',
              sortAppDEFieldId: 'sequence',
              textAppDEFieldId: 'name',
              navAppViewId: 'plmweb.sprintgrid_view_all',
              nodeType: 'node_3',
              appDataEntityId: 'plmweb.category',
              decontextMenu: {
                detoolbarItems: [
                  {
                    actionLevel: 100,
                    noPrivDisplayMode: 2,
                    uiactionId:
                      'toolbar_tree_exp_viewnode_3_cm_deuiaction1_click@sprint',
                    uiactionTarget: 'SINGLEDATA',
                    valid: true,
                    caption: '编辑',
                    itemType: 'DEUIACTION',
                    sysImage: {
                      cssClass: 'fa fa-edit',
                      glyph: 'xf044@FontAwesome',
                    },
                    tooltip: '编辑',
                    showCaption: true,
                    showIcon: true,
                    id: 'deuiaction1',
                  },
                  {
                    actionLevel: 100,
                    noPrivDisplayMode: 2,
                    uiactionId:
                      'toolbar_tree_exp_viewnode_3_cm_deuiaction2_click@sprint',
                    uiactionTarget: 'SINGLEDATA',
                    valid: true,
                    caption: '删除',
                    itemType: 'DEUIACTION',
                    sysImage: {
                      cssClass: 'fa fa-trash-o',
                      glyph: 'xf014@FontAwesome',
                    },
                    tooltip: '删除',
                    showCaption: true,
                    showIcon: true,
                    id: 'deuiaction2',
                  },
                ],
                toolbarStyle: 'CONTEXTMENU',
                codeName: 'tree_exp_viewnode_3_cm',
                controlType: 'CONTEXTMENU',
                logicName: '树节点上下文菜单',
                appDataEntityId: 'plmweb.sprint',
                controlParam: {
                  id: 'node_3_cm',
                },
                modelId: '543565081aa885721f9f24522a62c7a5',
                modelType: 'PSDETOOLBAR',
                name: 'node_3_cm',
                id: 'tree_exp_viewnode_3_cm',
              },
              navigateParams: [
                {
                  key: 'n_categories_like',
                  value: 'id',
                  id: 'n_categories_like',
                },
              ],
              sysImage: {
                cssClass: 'fa fa-reorder',
                glyph: 'xf0c9@FontAwesome',
              },
              treeNodeType: 'DE',
              allowDrag: true,
              allowDrop: true,
              allowEditText: true,
              allowOrder: true,
              name: '无分组',
              id: 'node_3',
            },
          ],
          outputIconDefault: true,
          createControlAction: {
            appDEMethodId: 'create',
            appDataEntityId: 'plmweb.sprint',
            id: 'create',
          },
          fetchControlAction: {
            appDataEntityId: 'plmweb.sprint',
            id: 'fetch',
          },
          getControlAction: {
            appDEMethodId: 'get',
            appDataEntityId: 'plmweb.sprint',
            id: 'load',
          },
          removeControlAction: {
            appDEMethodId: 'remove',
            appDataEntityId: 'plmweb.sprint',
            id: 'remove',
          },
          updateControlAction: {
            appDEMethodId: 'update',
            appDataEntityId: 'plmweb.sprint',
            id: 'update',
          },
          autoLoad: true,
          showBusyIndicator: true,
          controls: [
            {
              detoolbarItems: [
                {
                  actionLevel: 100,
                  noPrivDisplayMode: 2,
                  uiactionId:
                    'toolbar_tree_exp_viewnode_3_cm_deuiaction1_click@sprint',
                  uiactionTarget: 'SINGLEDATA',
                  valid: true,
                  caption: '编辑',
                  itemType: 'DEUIACTION',
                  sysImage: {
                    cssClass: 'fa fa-edit',
                    glyph: 'xf044@FontAwesome',
                  },
                  tooltip: '编辑',
                  showCaption: true,
                  showIcon: true,
                  id: 'deuiaction1',
                },
                {
                  actionLevel: 100,
                  noPrivDisplayMode: 2,
                  uiactionId:
                    'toolbar_tree_exp_viewnode_3_cm_deuiaction2_click@sprint',
                  uiactionTarget: 'SINGLEDATA',
                  valid: true,
                  caption: '删除',
                  itemType: 'DEUIACTION',
                  sysImage: {
                    cssClass: 'fa fa-trash-o',
                    glyph: 'xf014@FontAwesome',
                  },
                  tooltip: '删除',
                  showCaption: true,
                  showIcon: true,
                  id: 'deuiaction2',
                },
              ],
              toolbarStyle: 'CONTEXTMENU',
              codeName: 'tree_exp_viewnode_3_cm',
              controlType: 'CONTEXTMENU',
              logicName: '树节点上下文菜单',
              appDataEntityId: 'plmweb.sprint',
              controlParam: {
                id: 'node_3_cm',
              },
              modelId: '543565081aa885721f9f24522a62c7a5',
              modelType: 'PSDETOOLBAR',
              name: 'node_3_cm',
              id: 'tree_exp_viewnode_3_cm',
            },
            {
              detoolbarItems: [
                {
                  actionLevel: 100,
                  noPrivDisplayMode: 2,
                  uiactionId:
                    'toolbar_tree_exp_viewnode_2_cm_deuiaction1_click@sprint',
                  uiactionTarget: 'SINGLEDATA',
                  valid: true,
                  caption: '编辑',
                  itemType: 'DEUIACTION',
                  sysImage: {
                    cssClass: 'fa fa-edit',
                    glyph: 'xf044@FontAwesome',
                  },
                  tooltip: '编辑',
                  showCaption: true,
                  showIcon: true,
                  id: 'deuiaction1',
                },
                {
                  actionLevel: 100,
                  noPrivDisplayMode: 2,
                  uiactionId:
                    'toolbar_tree_exp_viewnode_2_cm_deuiaction2_click@sprint',
                  uiactionTarget: 'SINGLEDATA',
                  valid: true,
                  caption: '删除',
                  itemType: 'DEUIACTION',
                  sysImage: {
                    cssClass: 'fa fa-trash-o',
                    glyph: 'xf014@FontAwesome',
                  },
                  tooltip: '删除',
                  showCaption: true,
                  showIcon: true,
                  id: 'deuiaction2',
                },
              ],
              toolbarStyle: 'CONTEXTMENU',
              codeName: 'tree_exp_viewnode_2_cm',
              controlType: 'CONTEXTMENU',
              logicName: '树节点上下文菜单',
              appDataEntityId: 'plmweb.sprint',
              controlParam: {
                id: 'node_2_cm',
              },
              modelId: '543565081aa885721f9f24522a62c7a5',
              modelType: 'PSDETOOLBAR',
              name: 'node_2_cm',
              id: 'tree_exp_viewnode_2_cm',
            },
            {
              detoolbarItems: [
                {
                  actionLevel: 100,
                  noPrivDisplayMode: 2,
                  uiactionId:
                    'toolbar_tree_exp_viewnode_1_cm_deuiaction1_click@sprint',
                  uiactionTarget: 'SINGLEDATA',
                  valid: true,
                  caption: '编辑',
                  itemType: 'DEUIACTION',
                  sysImage: {
                    cssClass: 'fa fa-edit',
                    glyph: 'xf044@FontAwesome',
                  },
                  tooltip: '编辑',
                  showCaption: true,
                  showIcon: true,
                  id: 'deuiaction1',
                },
                {
                  actionLevel: 100,
                  noPrivDisplayMode: 2,
                  uiactionId:
                    'toolbar_tree_exp_viewnode_1_cm_deuiaction2_click@sprint',
                  uiactionTarget: 'SINGLEDATA',
                  valid: true,
                  caption: '删除',
                  itemType: 'DEUIACTION',
                  sysImage: {
                    cssClass: 'fa fa-trash-o',
                    glyph: 'xf014@FontAwesome',
                  },
                  tooltip: '删除',
                  showCaption: true,
                  showIcon: true,
                  id: 'deuiaction2',
                },
              ],
              toolbarStyle: 'CONTEXTMENU',
              codeName: 'tree_exp_viewnode_1_cm',
              controlType: 'CONTEXTMENU',
              logicName: '树节点上下文菜单',
              appDataEntityId: 'plmweb.sprint',
              controlParam: {
                id: 'node_1_cm',
              },
              modelId: '543565081aa885721f9f24522a62c7a5',
              modelType: 'PSDETOOLBAR',
              name: 'node_1_cm',
              id: 'tree_exp_viewnode_1_cm',
            },
          ],
          codeName: 'Tree_exp_view_TreeView',
          controlStyle: 'GROUP_TREE',
          controlType: 'TREEVIEW',
          logicName: '迭代实体树导航视图_树视图',
          appDataEntityId: 'plmweb.sprint',
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
          sysPFPluginId: 'group_tree',
          modelId: '977336e9b32518573c6823a44dab3b86',
          modelType: 'PSDETREEVIEW',
          name: 'treeexpbar_tree',
          id: 'plmweb.sprint.tree_exp_view_treeview',
        },
        {
          detoolbarItems: [
            {
              detoolbarItems: [
                {
                  actionLevel: 100,
                  noPrivDisplayMode: 2,
                  uiactionId:
                    'toolbar_tree_exp_viewtreeexpbar_toolbar_deuiaction1_click@sprint',
                  uiactionTarget: 'SINGLEDATA',
                  valid: true,
                  caption: '新建分组',
                  itemType: 'DEUIACTION',
                  sysImage: {
                    cssClass: 'fa fa-navicon',
                    glyph: 'xf0c9@FontAwesome',
                  },
                  tooltip: '新建分组',
                  showCaption: true,
                  showIcon: true,
                  id: 'deuiaction1',
                },
                {
                  actionLevel: 100,
                  noPrivDisplayMode: 2,
                  uiactionId:
                    'toolbar_tree_exp_viewtreeexpbar_toolbar_deuiaction2_click@sprint',
                  uiactionTarget: 'SINGLEDATA',
                  valid: true,
                  caption: '新建类别',
                  itemType: 'DEUIACTION',
                  sysImage: {
                    cssClass: 'fa fa-navicon',
                    glyph: 'xf0c9@FontAwesome',
                  },
                  tooltip: '新建类别',
                  showCaption: true,
                  showIcon: true,
                  id: 'deuiaction2',
                },
              ],
              valid: true,
              caption: '新建',
              itemType: 'ITEMS',
              sysImage: {
                cssClass: 'fa fa-plus',
                glyph: 'xf067@FontAwesome',
              },
              tooltip: '新建',
              showIcon: true,
              id: 'items1',
            },
            {
              actionLevel: 100,
              noPrivDisplayMode: 2,
              uiactionId: 'refreshall',
              valid: true,
              caption: '刷新',
              itemType: 'DEUIACTION',
              sysImage: {
                cssClass: 'fa fa-refresh',
                glyph: 'xf021@FontAwesome',
              },
              tooltip: '刷新',
              showIcon: true,
              id: 'deuiaction3',
            },
          ],
          codeName: 'tree_exp_viewtreeexpbar_toolbar',
          controlType: 'TOOLBAR',
          logicName: '新建类别或分组',
          appDataEntityId: 'plmweb.sprint',
          controlParam: {
            id: 'treeexpbar_toolbar',
          },
          modelId: '634364367f0faf0e51c8829fd77feee7',
          modelType: 'PSDETOOLBAR',
          name: 'treeexpbar_toolbar',
          id: 'tree_exp_viewtreeexpbar_toolbar',
        },
      ],
      codeName: 'tree_exp_viewtreeexpbar',
      controlType: 'TREEEXPBAR',
      appDataEntityId: 'plmweb.sprint',
      controlParam: {
        id: 'treeexpbar',
      },
      modelId: 'e5e9c8204182f49cd0762d10a93edd86_treeexpbar',
      modelType: 'PSEXPBAR',
      name: 'treeexpbar',
      id: 'tree_exp_viewtreeexpbar',
    },
    {
      groupMode: 'SINGLE',
      quickSearchMode: 1,
      enableQuickSearch: true,
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.sprint',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.SPRINT',
      },
      caption: '迭代',
      codeName: 'tree_exp_viewcaptionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.sprint',
      controlParam: {},
      name: 'captionbar',
      id: 'tree_exp_viewcaptionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'Layoutpanel',
    controlStyle: 'APPDETREEEXPVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.sprint',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '迭代实体树导航视图',
  viewStyle: 'DEFAULT',
  viewType: 'DETREEEXPVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: 'e5e9c8204182f49cd0762d10a93edd86',
  modelType: 'PSAPPDEVIEW',
  name: 'sprinttree_exp_view',
  id: 'plmweb.sprinttree_exp_view',
};