export default {
  showDataInfoBar: true,
  loadDefault: true,
  deviewCodeName: 'space_tree_exp_view',
  deviewId: '9EF4E358-07E1-416D-88B0-814AB0FC93F1',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.BASELINE',
  },
  caption: '基线',
  codeName: 'baseline_space_tree_exp_view',
  appDataEntityId: 'plmweb.baseline',
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
      value: 'space',
      id: 'n_owner_id_eq',
    },
    {
      rawValue: true,
      key: 'n_owner_subtype_eq',
      value: 'baseline',
      id: 'n_owner_subtype_eq',
    },
    {
      rawValue: true,
      key: 'n_owner_type_eq',
      value: 'space',
      id: 'n_owner_type_eq',
    },
  ],
  controls: [
    {
      title: '基线',
      xdataControlName: 'treeexpbar_tree',
      enableCounter: true,
      showTitleBar: true,
      autoLoad: true,
      showBusyIndicator: true,
      appViewRefs: [
        {
          realTitle: '空间基线树导航表格视图',
          refAppViewId: 'plmweb.baseline_space_grid_view',
          name: 'EXPITEM:node',
          id: 'expitem:node',
        },
        {
          realTitle: '空间基线树导航表格视图',
          refAppViewId: 'plmweb.baseline_space_grid_view',
          name: 'EXPITEM:node_2',
          id: 'expitem:node_2',
        },
        {
          realTitle: '空间基线树导航表格视图',
          refAppViewId: 'plmweb.baseline_space_grid_view',
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
              id: '默认根节点 - 全部基线',
            },
            {
              childDETreeNodeId: 'node_2',
              parentAppDEFieldId: 'section_id',
              parentDER1N: {
                masterRS: 32,
                pickupDEFName: 'SECTION_ID',
                removeActionType: 2,
                codeName: 'section',
                dertype: 'DER1N',
                logicName: '分组-类别',
                minorCodeName: 'section_categories',
                minorServiceCodeName: 'section_categories',
                orderValue: 100,
                serviceCodeName: 'section',
                name: 'DER1N_CATEGORY_SECTION_SECTION_ID',
                id: 'base.category.der1n_category_section_section_id',
              },
              parentDETreeNodeId: 'node_1',
              parentValueLevel: 1,
              searchMode: 3,
              id: '基线分组 - 基线类型',
            },
            {
              childDETreeNodeId: 'node_1',
              parentDETreeNodeId: 'root',
              parentValueLevel: 1,
              searchMode: 3,
              id: '默认根节点 - 基线分组',
            },
            {
              childDETreeNodeId: 'node_3',
              parentDETreeNodeId: 'root',
              parentValueLevel: 1,
              searchMode: 3,
              id: '默认根节点 - 无分组',
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
              text: '全部基线',
              navAppViewId: 'plmweb.baseline_space_grid_view',
              nodeType: 'node',
              navigateParams: [
                {
                  key: 'n_owner_id_eq',
                  value: 'space',
                  id: 'n_owner_id_eq',
                },
                {
                  key: 'n_owner_type_eq',
                  value: 'space',
                  rawValue: true,
                  id: 'n_owner_type_eq',
                },
              ],
              sysImage: {
                rawContent:
                  '<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 18 18" class="design-iconfont" width="14" height="14">\n  <path d="M1,8.16 L7.28571429,8.16 L7.28571429,2 L1,2 L1,8.16 Z M2.14285714,3.12 L6.14285714,3.12 L6.14285714,7.04 L2.14285714,7.04 L2.14285714,3.12 Z M1,16 L7.28571429,16 L7.28571429,9.84 L1,9.84 L1,16 Z M2.14285714,10.96 L6.14285714,10.96 L6.14285714,14.88 L2.14285714,14.88 L2.14285714,10.96 Z M9.26514286,3.68 L16.4285714,3.68 C16.7441627,3.68 17,3.42927946 17,3.12 C17,2.81072054 16.7441627,2.56 16.4285714,2.56 L9.26514286,2.56 C8.94955157,2.56 8.69371429,2.81072054 8.69371429,3.12 C8.69371429,3.42927946 8.94955157,3.68 9.26514286,3.68 Z M16.4285714,10.4 L9.26514286,10.4 C8.94955157,10.4 8.69371429,10.6507205 8.69371429,10.96 C8.69371429,11.2692795 8.94955157,11.52 9.26514286,11.52 L16.4285714,11.52 C16.7441627,11.52 17,11.2692795 17,10.96 C17,10.6507205 16.7441627,10.4 16.4285714,10.4 Z M16.4285714,6.48 L9.26514286,6.48 C8.94955157,6.48 8.69371429,6.73072054 8.69371429,7.04 C8.69371429,7.34927946 8.94955157,7.6 9.26514286,7.6 L16.4285714,7.6 C16.7441627,7.6 17,7.34927946 17,7.04 C17,6.73072054 16.7441627,6.48 16.4285714,6.48 Z M16.4285714,14.32 L9.26514286,14.32 C8.94955157,14.32 8.69371429,14.5707205 8.69371429,14.88 C8.69371429,15.1892795 8.94955157,15.44 9.26514286,15.44 L16.4285714,15.44 C16.7441627,15.44 17,15.1892795 17,14.88 C17,14.5707205 16.7441627,14.32 16.4285714,14.32 Z" stroke="#1D1F23" stroke-width=".3" fill="#1D1F23" fill-rule="nonzero"></path>\n</svg>',
              },
              treeNodeType: 'STATIC',
              name: '全部基线',
              id: 'node',
            },
            {
              idAppDEFieldId: 'id',
              leafFlagAppDEFieldId: 'is_leaf',
              appDEDataSetId: 'fetch_default',
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
                      'toolbar_space_tree_exp_view_node1_cm_deuiaction1_click@baseline',
                    uiactionTarget: 'SINGLEDATA',
                    valid: true,
                    caption: '编辑',
                    itemType: 'DEUIACTION',
                    controlLogics: [
                      {
                        itemName: 'deuiaction1',
                        logicTag: 'node_1_cm',
                        logicType: 'SCRIPT',
                        scriptCode: '!context.srfreadonly',
                        triggerType: 'ITEMVISIBLE',
                        id: 'deuiaction1',
                      },
                    ],
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
                      'toolbar_space_tree_exp_view_node1_cm_deuiaction2_click@baseline',
                    uiactionTarget: 'SINGLEDATA',
                    valid: true,
                    caption: '删除',
                    itemType: 'DEUIACTION',
                    controlLogics: [
                      {
                        itemName: 'deuiaction2',
                        logicTag: 'node_1_cm',
                        logicType: 'SCRIPT',
                        scriptCode: '!context.srfreadonly',
                        triggerType: 'ITEMVISIBLE',
                        id: 'deuiaction2',
                      },
                    ],
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
                codeName: 'space_tree_exp_view_node1_cm',
                controlType: 'CONTEXTMENU',
                logicName: '树节点上下文菜单',
                appDataEntityId: 'plmweb.baseline',
                controlParam: {
                  id: 'node_1_cm',
                },
                modelId: '90ce9a30940cfaa299547e13a27b8161',
                modelType: 'PSDETOOLBAR',
                name: 'node_1_cm',
                id: 'space_tree_exp_view_node1_cm',
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
              name: '基线分组',
              id: 'node_1',
            },
            {
              idAppDEFieldId: 'id',
              leafFlagAppDEFieldId: 'is_leaf',
              appDEDataSetId: 'fetch_default',
              sortDir: 'ASC',
              sortAppDEFieldId: 'sequence',
              textAppDEFieldId: 'name',
              navAppViewId: 'plmweb.baseline_space_grid_view',
              nodeType: 'node_2',
              appDataEntityId: 'plmweb.category',
              decontextMenu: {
                detoolbarItems: [
                  {
                    actionLevel: 100,
                    noPrivDisplayMode: 2,
                    uiactionId:
                      'toolbar_space_tree_exp_view_node2_cm_deuiaction1_click@baseline',
                    uiactionTarget: 'SINGLEDATA',
                    valid: true,
                    caption: '编辑',
                    itemType: 'DEUIACTION',
                    controlLogics: [
                      {
                        itemName: 'deuiaction1',
                        logicTag: 'node_2_cm',
                        logicType: 'SCRIPT',
                        scriptCode: '!context.srfreadonly',
                        triggerType: 'ITEMVISIBLE',
                        id: 'deuiaction1',
                      },
                    ],
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
                      'toolbar_space_tree_exp_view_node2_cm_deuiaction2_click@baseline',
                    uiactionTarget: 'SINGLEDATA',
                    valid: true,
                    caption: '删除',
                    itemType: 'DEUIACTION',
                    controlLogics: [
                      {
                        itemName: 'deuiaction2',
                        logicTag: 'node_2_cm',
                        logicType: 'SCRIPT',
                        scriptCode: '!context.srfreadonly',
                        triggerType: 'ITEMVISIBLE',
                        id: 'deuiaction2',
                      },
                    ],
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
                codeName: 'space_tree_exp_view_node2_cm',
                controlType: 'CONTEXTMENU',
                logicName: '树节点上下文菜单',
                appDataEntityId: 'plmweb.baseline',
                controlParam: {
                  id: 'node_2_cm',
                },
                modelId: '90ce9a30940cfaa299547e13a27b8161',
                modelType: 'PSDETOOLBAR',
                name: 'node_2_cm',
                id: 'space_tree_exp_view_node2_cm',
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
              name: '基线类型',
              id: 'node_2',
            },
            {
              idAppDEFieldId: 'id',
              leafFlagAppDEFieldId: 'is_leaf',
              appDEDataSetId: 'fetch_no_section',
              sortDir: 'ASC',
              sortAppDEFieldId: 'sequence',
              textAppDEFieldId: 'name',
              navAppViewId: 'plmweb.baseline_space_grid_view',
              nodeType: 'node_3',
              appDataEntityId: 'plmweb.category',
              decontextMenu: {
                detoolbarItems: [
                  {
                    actionLevel: 100,
                    noPrivDisplayMode: 2,
                    uiactionId:
                      'toolbar_space_tree_exp_view_node3_cm_deuiaction1_click@baseline',
                    uiactionTarget: 'SINGLEDATA',
                    valid: true,
                    caption: '编辑',
                    itemType: 'DEUIACTION',
                    controlLogics: [
                      {
                        itemName: 'deuiaction1',
                        logicTag: 'node_3_cm',
                        logicType: 'SCRIPT',
                        scriptCode: '!context.srfreadonly',
                        triggerType: 'ITEMVISIBLE',
                        id: 'deuiaction1',
                      },
                    ],
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
                      'toolbar_space_tree_exp_view_node3_cm_deuiaction2_click@baseline',
                    uiactionTarget: 'SINGLEDATA',
                    valid: true,
                    caption: '删除',
                    itemType: 'DEUIACTION',
                    controlLogics: [
                      {
                        itemName: 'deuiaction2',
                        logicTag: 'node_3_cm',
                        logicType: 'SCRIPT',
                        scriptCode: '!context.srfreadonly',
                        triggerType: 'ITEMVISIBLE',
                        id: 'deuiaction2',
                      },
                    ],
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
                codeName: 'space_tree_exp_view_node3_cm',
                controlType: 'CONTEXTMENU',
                logicName: '树节点上下文菜单',
                appDataEntityId: 'plmweb.baseline',
                controlParam: {
                  id: 'node_3_cm',
                },
                modelId: '90ce9a30940cfaa299547e13a27b8161',
                modelType: 'PSDETOOLBAR',
                name: 'node_3_cm',
                id: 'space_tree_exp_view_node3_cm',
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
            appDataEntityId: 'plmweb.baseline',
            id: 'create',
          },
          fetchControlAction: {
            appDataEntityId: 'plmweb.baseline',
            id: 'fetch',
          },
          getControlAction: {
            appDEMethodId: 'get',
            appDataEntityId: 'plmweb.baseline',
            id: 'load',
          },
          removeControlAction: {
            appDEMethodId: 'remove',
            appDataEntityId: 'plmweb.baseline',
            id: 'remove',
          },
          updateControlAction: {
            appDEMethodId: 'update',
            appDataEntityId: 'plmweb.baseline',
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
                    'toolbar_space_tree_exp_view_node3_cm_deuiaction1_click@baseline',
                  uiactionTarget: 'SINGLEDATA',
                  valid: true,
                  caption: '编辑',
                  itemType: 'DEUIACTION',
                  controlLogics: [
                    {
                      itemName: 'deuiaction1',
                      logicTag: 'node_3_cm',
                      logicType: 'SCRIPT',
                      scriptCode: '!context.srfreadonly',
                      triggerType: 'ITEMVISIBLE',
                      id: 'deuiaction1',
                    },
                  ],
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
                    'toolbar_space_tree_exp_view_node3_cm_deuiaction2_click@baseline',
                  uiactionTarget: 'SINGLEDATA',
                  valid: true,
                  caption: '删除',
                  itemType: 'DEUIACTION',
                  controlLogics: [
                    {
                      itemName: 'deuiaction2',
                      logicTag: 'node_3_cm',
                      logicType: 'SCRIPT',
                      scriptCode: '!context.srfreadonly',
                      triggerType: 'ITEMVISIBLE',
                      id: 'deuiaction2',
                    },
                  ],
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
              codeName: 'space_tree_exp_view_node3_cm',
              controlType: 'CONTEXTMENU',
              logicName: '树节点上下文菜单',
              appDataEntityId: 'plmweb.baseline',
              controlParam: {
                id: 'node_3_cm',
              },
              modelId: '90ce9a30940cfaa299547e13a27b8161',
              modelType: 'PSDETOOLBAR',
              name: 'node_3_cm',
              id: 'space_tree_exp_view_node3_cm',
            },
            {
              detoolbarItems: [
                {
                  actionLevel: 100,
                  noPrivDisplayMode: 2,
                  uiactionId:
                    'toolbar_space_tree_exp_view_node2_cm_deuiaction1_click@baseline',
                  uiactionTarget: 'SINGLEDATA',
                  valid: true,
                  caption: '编辑',
                  itemType: 'DEUIACTION',
                  controlLogics: [
                    {
                      itemName: 'deuiaction1',
                      logicTag: 'node_2_cm',
                      logicType: 'SCRIPT',
                      scriptCode: '!context.srfreadonly',
                      triggerType: 'ITEMVISIBLE',
                      id: 'deuiaction1',
                    },
                  ],
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
                    'toolbar_space_tree_exp_view_node2_cm_deuiaction2_click@baseline',
                  uiactionTarget: 'SINGLEDATA',
                  valid: true,
                  caption: '删除',
                  itemType: 'DEUIACTION',
                  controlLogics: [
                    {
                      itemName: 'deuiaction2',
                      logicTag: 'node_2_cm',
                      logicType: 'SCRIPT',
                      scriptCode: '!context.srfreadonly',
                      triggerType: 'ITEMVISIBLE',
                      id: 'deuiaction2',
                    },
                  ],
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
              codeName: 'space_tree_exp_view_node2_cm',
              controlType: 'CONTEXTMENU',
              logicName: '树节点上下文菜单',
              appDataEntityId: 'plmweb.baseline',
              controlParam: {
                id: 'node_2_cm',
              },
              modelId: '90ce9a30940cfaa299547e13a27b8161',
              modelType: 'PSDETOOLBAR',
              name: 'node_2_cm',
              id: 'space_tree_exp_view_node2_cm',
            },
            {
              detoolbarItems: [
                {
                  actionLevel: 100,
                  noPrivDisplayMode: 2,
                  uiactionId:
                    'toolbar_space_tree_exp_view_node1_cm_deuiaction1_click@baseline',
                  uiactionTarget: 'SINGLEDATA',
                  valid: true,
                  caption: '编辑',
                  itemType: 'DEUIACTION',
                  controlLogics: [
                    {
                      itemName: 'deuiaction1',
                      logicTag: 'node_1_cm',
                      logicType: 'SCRIPT',
                      scriptCode: '!context.srfreadonly',
                      triggerType: 'ITEMVISIBLE',
                      id: 'deuiaction1',
                    },
                  ],
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
                    'toolbar_space_tree_exp_view_node1_cm_deuiaction2_click@baseline',
                  uiactionTarget: 'SINGLEDATA',
                  valid: true,
                  caption: '删除',
                  itemType: 'DEUIACTION',
                  controlLogics: [
                    {
                      itemName: 'deuiaction2',
                      logicTag: 'node_1_cm',
                      logicType: 'SCRIPT',
                      scriptCode: '!context.srfreadonly',
                      triggerType: 'ITEMVISIBLE',
                      id: 'deuiaction2',
                    },
                  ],
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
              codeName: 'space_tree_exp_view_node1_cm',
              controlType: 'CONTEXTMENU',
              logicName: '树节点上下文菜单',
              appDataEntityId: 'plmweb.baseline',
              controlParam: {
                id: 'node_1_cm',
              },
              modelId: '90ce9a30940cfaa299547e13a27b8161',
              modelType: 'PSDETOOLBAR',
              name: 'node_1_cm',
              id: 'space_tree_exp_view_node1_cm',
            },
          ],
          codeName: 'space_baseline_tree_view',
          controlStyle: 'GROUP_TREE',
          controlType: 'TREEVIEW',
          logicName: '空间基线树导航视图_树视图',
          appDataEntityId: 'plmweb.baseline',
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
          modelId: '1A7E690A-36F5-4D07-8918-0C1ACACE74AB',
          modelType: 'PSDETREEVIEW',
          name: 'treeexpbar_tree',
          id: 'plmweb.baseline.space_baseline_tree_view',
        },
        {
          detoolbarItems: [
            {
              actionLevel: 100,
              detoolbarItems: [
                {
                  actionLevel: 100,
                  noPrivDisplayMode: 2,
                  uiactionId:
                    'toolbar_space_tree_exp_view_treeexpbar_toolbar_deuiaction1_click@baseline',
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
                    'toolbar_space_tree_exp_view_treeexpbar_toolbar_deuiaction2_click@baseline',
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
              controlLogics: [
                {
                  itemName: 'items1',
                  logicTag: 'treeexpbar_toolbar',
                  logicType: 'SCRIPT',
                  scriptCode: 'context.srfreadonly != true',
                  triggerType: 'ITEMVISIBLE',
                  id: 'items1',
                },
              ],
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
              controlLogics: [
                {
                  itemName: 'deuiaction3',
                  logicTag: 'treeexpbar_toolbar',
                  logicType: 'SCRIPT',
                  scriptCode: 'context.srfreadonly != true',
                  triggerType: 'ITEMVISIBLE',
                  id: 'deuiaction3',
                },
              ],
              sysImage: {
                cssClass: 'fa fa-refresh',
                glyph: 'xf021@FontAwesome',
              },
              tooltip: '刷新',
              showIcon: true,
              id: 'deuiaction3',
            },
          ],
          toolbarStyle: 'USER',
          codeName: 'space_tree_exp_view_treeexpbar_toolbar',
          controlType: 'TOOLBAR',
          logicName: '空间基线新建类别或类别',
          appDataEntityId: 'plmweb.baseline',
          controlParam: {
            id: 'treeexpbar_toolbar',
          },
          modelId: '5BB3D726-AA2A-4E11-A6C0-0D4E2F572572',
          modelType: 'PSDETOOLBAR',
          name: 'treeexpbar_toolbar',
          id: 'space_tree_exp_view_treeexpbar_toolbar',
        },
      ],
      codeName: 'space_tree_exp_view_treeexpbar',
      controlType: 'TREEEXPBAR',
      appDataEntityId: 'plmweb.baseline',
      controlParam: {
        id: 'treeexpbar',
      },
      modelId: '2d6860c06f5478c2ea9ba457fdee47c4_treeexpbar',
      modelType: 'PSEXPBAR',
      name: 'treeexpbar',
      id: 'space_tree_exp_view_treeexpbar',
    },
    {
      groupMode: 'SINGLE',
      quickSearchMode: 1,
      enableQuickSearch: true,
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.baseline',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.BASELINE',
      },
      caption: '基线',
      codeName: 'space_tree_exp_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.baseline',
      controlParam: {},
      name: 'captionbar',
      id: 'space_tree_exp_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDETREEEXPVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.baseline',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '空间基线树导航视图',
  viewStyle: 'DEFAULT',
  viewType: 'DETREEEXPVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '2d6860c06f5478c2ea9ba457fdee47c4',
  modelType: 'PSAPPDEVIEW',
  name: 'baselinespace_tree_exp_view',
  id: 'plmweb.baseline_space_tree_exp_view',
};