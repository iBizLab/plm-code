export default {
  showDataInfoBar: true,
  loadDefault: true,
  deviewCodeName: 'tree_exp_view',
  deviewId: '28f548e7bc823f03de0b3eedd92dafb2',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.TICKET',
  },
  caption: '工单导航',
  codeName: 'ticket_tree_exp_view',
  appDataEntityId: 'plmweb.ticket',
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
      xdataControlName: 'treeexpbar_tree',
      enableCounter: true,
      showTitleBar: true,
      autoLoad: true,
      showBusyIndicator: true,
      appViewRefs: [
        {
          realTitle: '全部工单',
          refAppViewId: 'plmweb.ticket_all_grid_view',
          name: 'EXPITEM:node',
          id: 'expitem:node',
        },
        {
          realTitle: '待计划的工单',
          refAppViewId: 'plmweb.ticket_un_plan_grid_view',
          name: 'EXPITEM:node_1',
          id: 'expitem:node_1',
        },
        {
          realTitle: '进行中的工单',
          refAppViewId: 'plmweb.ticket_progress_grid_view',
          name: 'EXPITEM:node_2',
          id: 'expitem:node_2',
        },
        {
          realTitle: '我负责的工单',
          refAppViewId: 'plmweb.ticket_my_assignee_grid_view',
          name: 'EXPITEM:node_3',
          id: 'expitem:node_3',
        },
        {
          realTitle: '我提交的工单',
          refAppViewId: 'plmweb.ticket_submit_grid_view',
          name: 'EXPITEM:node_4',
          id: 'expitem:node_4',
        },
        {
          realTitle: '已归档的工单',
          refAppViewId: 'plmweb.ticket_archived_grid_view',
          name: 'EXPITEM:node_5',
          id: 'expitem:node_5',
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
              id: '默认根节点 - 全部工单',
            },
            {
              childDETreeNodeId: 'node_1',
              parentDETreeNodeId: 'root',
              parentValueLevel: 1,
              searchMode: 3,
              id: '默认根节点 - 待计划的工单',
            },
            {
              childDETreeNodeId: 'node_2',
              parentDETreeNodeId: 'root',
              parentValueLevel: 1,
              searchMode: 3,
              id: '默认根节点 - 进行中的工单',
            },
            {
              childDETreeNodeId: 'node_3',
              parentDETreeNodeId: 'root',
              parentValueLevel: 1,
              searchMode: 3,
              id: '默认根节点 - 我负责的工单',
            },
            {
              childDETreeNodeId: 'node_4',
              parentDETreeNodeId: 'root',
              parentValueLevel: 1,
              searchMode: 3,
              id: '默认根节点 - 我提交的工单',
            },
            {
              childDETreeNodeId: 'node_5',
              parentDETreeNodeId: 'root',
              parentValueLevel: 1,
              searchMode: 3,
              id: '默认根节点 - 已归档的工单',
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
              text: '全部工单',
              navAppViewId: 'plmweb.ticket_all_grid_view',
              nodeType: 'node',
              navigateParams: [
                {
                  key: 'target_type',
                  value: 'target_type',
                  id: 'target_type',
                },
                {
                  key: 'principal_type',
                  value: 'principal_type',
                  id: 'principal_type',
                },
                {
                  key: 'principal_id',
                  value: 'principal_id',
                  id: 'principal_id',
                },
              ],
              sysImage: {
                cssClass: 'fa fa-list',
                glyph: 'xf03a@FontAwesome',
              },
              treeNodeType: 'STATIC',
              name: '全部工单',
              id: 'node',
            },
            {
              text: '待计划的工单',
              navAppViewId: 'plmweb.ticket_un_plan_grid_view',
              nodeType: 'node_1',
              navigateParams: [
                {
                  key: 'target_type',
                  value: 'target_type',
                  id: 'target_type',
                },
                {
                  key: 'principal_type',
                  value: 'principal_type',
                  id: 'principal_type',
                },
                {
                  key: 'principal_id',
                  value: 'principal_id',
                  id: 'principal_id',
                },
              ],
              sysImage: {
                cssClass: 'fa fa-list-ul',
                glyph: 'xf0ca@FontAwesome',
              },
              treeNodeType: 'STATIC',
              name: '待计划的工单',
              id: 'node_1',
            },
            {
              text: '进行中的工单',
              navAppViewId: 'plmweb.ticket_progress_grid_view',
              nodeType: 'node_2',
              sysImage: {
                cssClass: 'fa fa-list-ul',
                glyph: 'xf0ca@FontAwesome',
              },
              treeNodeType: 'STATIC',
              name: '进行中的工单',
              id: 'node_2',
            },
            {
              text: '我负责的工单',
              navAppViewId: 'plmweb.ticket_my_assignee_grid_view',
              nodeType: 'node_3',
              sysImage: {
                cssClass: 'fa fa-list-ul',
                glyph: 'xf0ca@FontAwesome',
              },
              treeNodeType: 'STATIC',
              name: '我负责的工单',
              id: 'node_3',
            },
            {
              text: '我提交的工单',
              navAppViewId: 'plmweb.ticket_submit_grid_view',
              nodeType: 'node_4',
              sysImage: {
                cssClass: 'fa fa-list-ul',
                glyph: 'xf0ca@FontAwesome',
              },
              treeNodeType: 'STATIC',
              name: '我提交的工单',
              id: 'node_4',
            },
            {
              text: '已归档的工单',
              navAppViewId: 'plmweb.ticket_archived_grid_view',
              nodeType: 'node_5',
              sysImage: {
                cssClass: 'fa fa-list-ul',
                glyph: 'xf0ca@FontAwesome',
              },
              treeNodeType: 'STATIC',
              name: '已归档的工单',
              id: 'node_5',
            },
          ],
          outputIconDefault: true,
          createControlAction: {
            appDEMethodId: 'create',
            appDataEntityId: 'plmweb.ticket',
            id: 'create',
          },
          fetchControlAction: {
            appDataEntityId: 'plmweb.ticket',
            id: 'fetch',
          },
          getControlAction: {
            appDEMethodId: 'get',
            appDataEntityId: 'plmweb.ticket',
            id: 'load',
          },
          dedataImportId: 'import_ticket',
          removeControlAction: {
            appDEMethodId: 'remove',
            appDataEntityId: 'plmweb.ticket',
            id: 'remove',
          },
          updateControlAction: {
            appDEMethodId: 'update',
            appDataEntityId: 'plmweb.ticket',
            id: 'update',
          },
          autoLoad: true,
          showBusyIndicator: true,
          codeName: 'tree_exp_view_tree_view',
          controlType: 'TREEVIEW',
          logicName: '工单导航视图_树视图',
          appDataEntityId: 'plmweb.ticket',
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
          modelId: '56c2ec405a7e81832c5071787b3107d1',
          modelType: 'PSDETREEVIEW',
          name: 'treeexpbar_tree',
          id: 'plmweb.ticket.tree_exp_view_tree_view',
        },
      ],
      codeName: 'tree_exp_view_treeexpbar',
      controlType: 'TREEEXPBAR',
      appDataEntityId: 'plmweb.ticket',
      controlParam: {
        id: 'treeexpbar',
      },
      modelId: 'c5b417b819f6d969f19c8c689d994a45_treeexpbar',
      modelType: 'PSEXPBAR',
      name: 'treeexpbar',
      id: 'tree_exp_view_treeexpbar',
    },
    {
      groupMode: 'SINGLE',
      quickSearchMode: 1,
      enableQuickSearch: true,
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.ticket',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.TICKET',
      },
      caption: '工单导航',
      codeName: 'tree_exp_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.ticket',
      controlParam: {},
      name: 'captionbar',
      id: 'tree_exp_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDETREEEXPVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.ticket',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '工单导航',
  viewStyle: 'DEFAULT',
  viewType: 'DETREEEXPVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: 'c5b417b819f6d969f19c8c689d994a45',
  modelType: 'PSAPPDEVIEW',
  name: 'tickettree_exp_view',
  id: 'plmweb.ticket_tree_exp_view',
};