export default {
  showDataInfoBar: true,
  loadDefault: true,
  deviewCodeName: 'details_setting_view',
  deviewId: 'caf5bf549a5d3c0ad3b0973aea4e11db',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'PAGE.CAPTION.SPACE.DETAILS_SETTING_VIEW',
  },
  caption: '空间配置',
  codeName: 'space_details_setting_view',
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
      xdataControlName: 'treeexpbar_tree',
      enableCounter: true,
      showTitleBar: true,
      autoLoad: true,
      showBusyIndicator: true,
      appViewRefs: [
        {
          realTitle: '基本信息',
          refAppViewId: 'plmweb.space_base_info_edit_view',
          name: 'EXPITEM:node_13',
          id: 'expitem:node_13',
        },
        {
          realTitle: '高级设置',
          refAppViewId: 'plmweb.space_advanced_setting_edit_view',
          name: 'EXPITEM:node_14',
          id: 'expitem:node_14',
        },
        {
          parentDataJO: {
            srfparentdename: 'SPACE',
            srfparentmode: 'DER1N_SPACE_MEMBER_SPACE_SPACE_ID',
            srfparentdefname: 'SPACE_ID',
          },
          realTitle: '空间成员表格',
          refAppViewId: 'plmweb.space_member_config_grid_view',
          name: 'EXPITEM:node_2',
          id: 'expitem:node_2',
        },
        {
          parentDataJO: {
            srfparentdename: 'SPACE',
            n_space_id_eq: '%space%',
            srfparentmode: 'DER1N_PAGE_SPACE_SPACE_ID',
            srfparentdefname: 'SPACE_ID',
          },
          realTitle: '页面数据统计表格',
          refAppViewId: 'plmweb.article_page_statistical_grid_view',
          viewParamJO: {
            n_space_id_eq: '%space%',
          },
          name: 'EXPITEM:node_4',
          id: 'expitem:node_4',
        },
        {
          realTitle: '空间下页面模板表格视图',
          refAppViewId: 'plmweb.stencil_space_all_grid_view',
          name: 'EXPITEM:node_5',
          id: 'expitem:node_5',
        },
        {
          parentDataJO: {
            srfparentdename: 'SPACE',
            n_space_id_eq: '%space%',
            srfparentmode: 'DER1N_PAGE_SPACE_SPACE_ID',
            srfparentdefname: 'SPACE_ID',
          },
          realTitle: '回收站',
          refAppViewId: 'plmweb.article_page_recycle_grid_view',
          viewParamJO: {
            n_space_id_eq: '%space%',
          },
          name: 'EXPITEM:node_6',
          id: 'expitem:node_6',
        },
      ],
      controls: [
        {
          detreeNodeRSs: [
            {
              childDETreeNodeId: 'node_2',
              parentDETreeNodeId: 'node',
              parentValueLevel: 1,
              searchMode: 3,
              id: '通用 - 空间成员',
            },
            {
              childDETreeNodeId: 'node',
              parentDETreeNodeId: 'root',
              parentValueLevel: 1,
              searchMode: 3,
              id: '默认根节点 - 通用',
            },
            {
              childDETreeNodeId: 'node_10',
              parentDETreeNodeId: 'node_1',
              parentValueLevel: 1,
              searchMode: 3,
              id: '空间 - 空间组件',
            },
            {
              childDETreeNodeId: 'node_13',
              parentDETreeNodeId: 'node_12',
              parentValueLevel: 1,
              searchMode: 3,
              id: '设置 - 基本信息',
            },
            {
              childDETreeNodeId: 'node_8',
              parentDETreeNodeId: 'node_7',
              parentValueLevel: 1,
              searchMode: 3,
              id: '共享 - 页面共享',
            },
            {
              childDETreeNodeId: 'node_5',
              parentDETreeNodeId: 'node',
              parentValueLevel: 1,
              searchMode: 3,
              id: '通用 - 页面模板',
            },
            {
              childDETreeNodeId: 'node_9',
              parentDETreeNodeId: 'node_7',
              parentValueLevel: 1,
              searchMode: 3,
              id: '共享 - 空间共享',
            },
            {
              childDETreeNodeId: 'node_3',
              parentDETreeNodeId: 'node',
              parentValueLevel: 1,
              searchMode: 3,
              id: '通用 - 自动化规则',
            },
            {
              childDETreeNodeId: 'node_6',
              parentDETreeNodeId: 'node',
              parentValueLevel: 1,
              searchMode: 3,
              id: '通用 - 回收站',
            },
            {
              childDETreeNodeId: 'node_1',
              parentDETreeNodeId: 'root',
              parentValueLevel: 1,
              searchMode: 3,
              id: '默认根节点 - 空间',
            },
            {
              childDETreeNodeId: 'node_11',
              parentDETreeNodeId: 'node_1',
              parentValueLevel: 1,
              searchMode: 3,
              id: '空间 - 目录管理',
            },
            {
              childDETreeNodeId: 'node_14',
              parentDETreeNodeId: 'node_12',
              parentValueLevel: 1,
              searchMode: 3,
              id: '设置 - 高级设置',
            },
            {
              childDETreeNodeId: 'node_4',
              parentDETreeNodeId: 'node_1',
              parentValueLevel: 1,
              searchMode: 3,
              id: '空间 - 数据统计',
            },
            {
              childDETreeNodeId: 'node_7',
              parentDETreeNodeId: 'root',
              parentValueLevel: 1,
              searchMode: 3,
              id: '默认根节点 - 共享',
            },
            {
              childDETreeNodeId: 'node_12',
              parentDETreeNodeId: 'root',
              parentValueLevel: 1,
              searchMode: 3,
              id: '默认根节点 - 设置',
            },
          ],
          detreeNodes: [
            {
              text: '默认根节点',
              nodeType: 'ROOT',
              treeNodeType: 'STATIC',
              hasDETreeNodeRSs: true,
              expanded: true,
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
              text: '空间',
              nodeType: 'node_1',
              treeNodeType: 'STATIC',
              hasDETreeNodeRSs: true,
              expanded: true,
              name: '空间',
              id: 'node_1',
            },
            {
              text: '空间组件',
              nodeType: 'node_10',
              treeNodeType: 'STATIC',
              disableSelect: true,
              name: '空间组件',
              id: 'node_10',
            },
            {
              text: '目录管理',
              nodeType: 'node_11',
              treeNodeType: 'STATIC',
              disableSelect: true,
              name: '目录管理',
              id: 'node_11',
            },
            {
              text: '设置',
              nodeType: 'node_12',
              treeNodeType: 'STATIC',
              hasDETreeNodeRSs: true,
              expanded: true,
              name: '设置',
              id: 'node_12',
            },
            {
              text: '基本信息',
              navAppViewId: 'plmweb.space_base_info_edit_view',
              nodeType: 'node_13',
              treeNodeType: 'STATIC',
              name: '基本信息',
              id: 'node_13',
            },
            {
              text: '高级设置',
              navAppViewId: 'plmweb.space_advanced_setting_edit_view',
              nodeType: 'node_14',
              treeNodeType: 'STATIC',
              name: '高级设置',
              id: 'node_14',
            },
            {
              text: '空间成员',
              navAppViewId: 'plmweb.space_member_config_grid_view',
              navDER: {
                masterOrder: 100,
                masterRS: 7,
                pickupDEFName: 'SPACE_ID',
                codeName: 'space',
                dertype: 'DER1N',
                logicName: '名称',
                minorCodeName: 'space_members',
                minorServiceCodeName: 'space_members',
                orderValue: 100,
                serviceCodeName: 'space',
                name: 'DER1N_SPACE_MEMBER_SPACE_SPACE_ID',
                id: 'wiki.space_member.der1n_space_member_space_space_id',
              },
              nodeType: 'node_2',
              treeNodeType: 'STATIC',
              name: '空间成员',
              id: 'node_2',
            },
            {
              text: '自动化规则',
              nodeType: 'node_3',
              treeNodeType: 'STATIC',
              disableSelect: true,
              name: '自动化规则',
              id: 'node_3',
            },
            {
              text: '数据统计',
              navAppViewId: 'plmweb.article_page_statistical_grid_view',
              navDER: {
                masterOrder: 10,
                masterRS: 5,
                pickupDEFName: 'SPACE_ID',
                codeName: 'space',
                dertype: 'DER1N',
                logicName: '空间-页面',
                minorCodeName: 'pages',
                minorServiceCodeName: 'pages',
                orderValue: 100,
                serviceCodeName: 'space',
                name: 'DER1N_PAGE_SPACE_SPACE_ID',
                id: 'wiki.article_page.der1n_page_space_space_id',
              },
              navViewParamJO: {
                n_space_id_eq: '%space%',
              },
              nodeType: 'node_4',
              navigateParams: [
                {
                  key: 'n_space_id_eq',
                  value: 'space',
                  id: 'n_space_id_eq',
                },
              ],
              treeNodeType: 'STATIC',
              name: '数据统计',
              id: 'node_4',
            },
            {
              text: '页面模板',
              navAppViewId: 'plmweb.stencil_space_all_grid_view',
              nodeType: 'node_5',
              treeNodeType: 'STATIC',
              name: '页面模板',
              id: 'node_5',
            },
            {
              text: '回收站',
              navAppViewId: 'plmweb.article_page_recycle_grid_view',
              navDER: {
                masterOrder: 10,
                masterRS: 5,
                pickupDEFName: 'SPACE_ID',
                codeName: 'space',
                dertype: 'DER1N',
                logicName: '空间-页面',
                minorCodeName: 'pages',
                minorServiceCodeName: 'pages',
                orderValue: 100,
                serviceCodeName: 'space',
                name: 'DER1N_PAGE_SPACE_SPACE_ID',
                id: 'wiki.article_page.der1n_page_space_space_id',
              },
              navViewParamJO: {
                n_space_id_eq: '%space%',
              },
              nodeType: 'node_6',
              navigateParams: [
                {
                  key: 'n_space_id_eq',
                  value: 'space',
                  id: 'n_space_id_eq',
                },
              ],
              treeNodeType: 'STATIC',
              name: '回收站',
              id: 'node_6',
            },
            {
              text: '共享',
              nodeType: 'node_7',
              treeNodeType: 'STATIC',
              hasDETreeNodeRSs: true,
              expanded: true,
              name: '共享',
              id: 'node_7',
            },
            {
              text: '页面共享',
              nodeType: 'node_8',
              treeNodeType: 'STATIC',
              disableSelect: true,
              name: '页面共享',
              id: 'node_8',
            },
            {
              text: '空间共享',
              nodeType: 'node_9',
              treeNodeType: 'STATIC',
              disableSelect: true,
              name: '空间共享',
              id: 'node_9',
            },
          ],
          outputIconDefault: true,
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
          codeName: 'details_setting_view_tree_view',
          controlType: 'TREEVIEW',
          logicName: '空间详情配置视图_树视图',
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
          modelId: '60bde4b6c72092a7153d558468c946dd',
          modelType: 'PSDETREEVIEW',
          name: 'treeexpbar_tree',
          id: 'plmweb.space.details_setting_view_tree_view',
        },
      ],
      codeName: 'details_setting_view_treeexpbar',
      controlType: 'TREEEXPBAR',
      appDataEntityId: 'plmweb.space',
      controlParam: {
        id: 'treeexpbar',
      },
      modelId: 'a148615f45beabf69d52deb486f8aeae_treeexpbar',
      modelType: 'PSEXPBAR',
      name: 'treeexpbar',
      id: 'details_setting_view_treeexpbar',
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
        lanResTag: 'PAGE.CAPTION.SPACE.DETAILS_SETTING_VIEW',
      },
      caption: '空间配置',
      codeName: 'details_setting_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.space',
      controlParam: {},
      name: 'captionbar',
      id: 'details_setting_view_captionbar',
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
  title: '空间详情配置',
  titleLanguageRes: {
    lanResTag: 'PAGE.TITLE.SPACE.DETAILS_SETTING_VIEW',
  },
  viewStyle: 'DEFAULT',
  viewType: 'DETREEEXPVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: 'a148615f45beabf69d52deb486f8aeae',
  modelType: 'PSAPPDEVIEW',
  name: 'spacedetails_setting_view',
  id: 'plmweb.space_details_setting_view',
};