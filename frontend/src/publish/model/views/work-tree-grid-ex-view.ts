export default {
  mdctrlActiveMode: 1,
  xdataControlName: 'treegridex',
  loadDefault: true,
  deviewCodeName: 'tree_grid_ex_view',
  deviewId: 'f9d01b56fe894bc7b07202d661fbf9e8',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.WORK',
  },
  caption: '工作',
  codeName: 'work_tree_grid_ex_view',
  appDataEntityId: 'plmweb.work',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'TreeGridExView',
      id: 'engine',
    },
  ],
  appViewNavContexts: [
    {
      rawValue: true,
      key: 'SRFDEFAULTTOROUTEDEPTH',
      value: '2',
      name: 'SRFDEFAULTTOROUTEDEPTH',
      id: 'srfdefaulttoroutedepth',
    },
  ],
  appViewNavParams: [
    {
      key: 'project_portfolio',
      value: 'portfolio',
      id: 'project_portfolio',
    },
  ],
  appViewRefs: [
    {
      realTitle: '工作数据重定向视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.WORK.REDIRECTVIEW',
      },
      refAppViewId: 'plmweb.work_redirect_view',
      name: 'EDITDATA',
      id: 'editdata',
    },
    {
      realTitle: '工作编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.WORK.EDITVIEW',
      },
      refAppViewId: 'plmweb.work_edit_view',
      name: 'NEWDATA',
      id: 'newdata',
    },
  ],
  controls: [
    {
      detoolbarItems: [
        {
          actionLevel: 100,
          noPrivDisplayMode: 2,
          uiactionId: 'choose_project@work',
          uiactionTarget: 'NONE',
          valid: true,
          caption: '选择项目',
          itemType: 'DEUIACTION',
          tooltip: '选择项目',
          showCaption: true,
          showIcon: true,
          id: 'deuiaction1',
        },
        {
          actionLevel: 100,
          noPrivDisplayMode: 2,
          uiactionId: 'choose_item_set@work',
          uiactionTarget: 'NONE',
          valid: true,
          caption: '选择项目集',
          itemType: 'DEUIACTION',
          tooltip: '选择项目集',
          showCaption: true,
          showIcon: true,
          id: 'deuiaction2',
        },
      ],
      xdataControlName: 'treegridex',
      codeName: 'tree_grid_ex_view_toolbar',
      controlType: 'TOOLBAR',
      logicName: '添加',
      appDataEntityId: 'plmweb.work',
      controlParam: {
        id: 'toolbar',
      },
      modelId: '454a290d0783bdc78098cd01581564a9',
      modelType: 'PSDETOOLBAR',
      name: 'toolbar',
      id: 'tree_grid_ex_view_toolbar',
    },
    {
      detreeColumns: [
        {
          align: 'LEFT',
          caption: '名称',
          codeName: 'name',
          columnType: 'DEFGRIDCOLUMN',
          width: 200,
          widthUnit: 'STAR',
          id: 'name',
        },
        {
          caption: '状态',
          codeName: 'state',
          columnType: 'DEFGRIDCOLUMN',
          width: 150,
          widthUnit: 'PX',
          id: 'state',
        },
        {
          caption: '负责人',
          codeName: 'assignee_name',
          columnType: 'DEFGRIDCOLUMN',
          width: 200,
          widthUnit: 'PX',
          id: 'assignee_name',
        },
        {
          caption: '开始时间',
          codeName: 'start_at',
          columnType: 'DEFGRIDCOLUMN',
          width: 200,
          widthUnit: 'PX',
          id: 'start_at',
        },
        {
          caption: '结束时间',
          codeName: 'end_at',
          columnType: 'DEFGRIDCOLUMN',
          width: 200,
          widthUnit: 'PX',
          id: 'end_at',
        },
      ],
      detreeNodeRSs: [
        {
          childDETreeNodeId: 'node_1',
          parentFilter: 'portfolio_id',
          parentDETreeNodeId: 'node',
          parentValueLevel: 1,
          searchMode: 3,
          id: '项目集 - 项目集下的项目',
        },
        {
          childDETreeNodeId: 'node',
          parentDETreeNodeId: 'root',
          parentValueLevel: 1,
          searchMode: 3,
          id: '默认根节点 - 项目集',
        },
        {
          childDETreeNodeId: 'node_2',
          parentDETreeNodeId: 'root',
          parentValueLevel: 1,
          searchMode: 3,
          id: '默认根节点 - 项目',
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
          idAppDEFieldId: 'id',
          appDEDataSetId: 'fetch_work_project_portfolio',
          textAppDEFieldId: 'name',
          nodeType: 'node',
          appDataEntityId: 'plmweb.portfolio',
          detreeNodeColumns: [
            {
              clconvertMode: 'NONE',
              dataItemName: 'assignee_name',
              appDEFieldId: 'assignee_name',
              valueType: 'SIMPLE',
              codeName: 'assignee_name',
              columnType: 'DEFGRIDCOLUMN',
              noPrivDisplayMode: 1,
              detreeColumnId: 'assignee_name',
              id: 'assignee_name',
            },
            {
              clconvertMode: 'NONE',
              dataItemName: 'end_at',
              appDEFieldId: 'end_at',
              valueFormat: 'YYYY-MM-DD',
              valueType: 'SIMPLE',
              codeName: 'end_at',
              columnType: 'DEFGRIDCOLUMN',
              noPrivDisplayMode: 1,
              detreeColumnId: 'end_at',
              id: 'end_at',
            },
            {
              clconvertMode: 'NONE',
              dataItemName: 'name',
              appDEFieldId: 'name',
              deuiactionGroup: {
                uiactionGroupDetails: [
                  {
                    actionLevel: 200,
                    afterItemType: 'NONE',
                    beforeItemType: 'NONE',
                    detailType: 'DEUIACTION',
                    uiactionId: 'remove_from_project_set@portfolio',
                    showIcon: true,
                    sysImage: {
                      cssClass: 'fa fa-trash-o',
                      glyph: 'xf014@FontAwesome',
                    },
                    id: 'uda81f5e',
                  },
                ],
                appDataEntityId: 'plmweb.portfolio',
                uniqueTag: 'portfolio__Usr0305508371',
                name: '从项目集中移除',
                id: 'usr0305508371',
              },
              valueType: 'SIMPLE',
              codeName: 'name',
              columnType: 'DEFGRIDCOLUMN',
              noPrivDisplayMode: 1,
              detreeColumnId: 'name',
              id: 'name',
            },
            {
              clconvertMode: 'NONE',
              dataItemName: 'start_at',
              appDEFieldId: 'start_at',
              valueFormat: 'YYYY-MM-DD',
              valueType: 'SIMPLE',
              codeName: 'start_at',
              columnType: 'DEFGRIDCOLUMN',
              noPrivDisplayMode: 1,
              detreeColumnId: 'start_at',
              id: 'start_at',
            },
            {
              clconvertMode: 'FRONT',
              dataItemName: 'state',
              appCodeListId: 'plmweb.projmgmt__project_state',
              appDEFieldId: 'state',
              valueType: 'SIMPLE',
              codeName: 'state',
              columnType: 'DEFGRIDCOLUMN',
              noPrivDisplayMode: 1,
              detreeColumnId: 'state',
              id: 'state',
            },
          ],
          detreeNodeDataItems: [
            {
              clconvertMode: 'NONE',
              appDEFieldId: 'assignee_name',
              detreeColumnId: 'assignee_name',
              valueType: 'SIMPLE',
              dataType: 25,
              id: 'assignee_name',
            },
            {
              clconvertMode: 'NONE',
              appDEFieldId: 'end_at',
              detreeColumnId: 'end_at',
              valueType: 'SIMPLE',
              dataType: 5,
              id: 'end_at',
            },
            {
              clconvertMode: 'NONE',
              appDEFieldId: 'name',
              detreeColumnId: 'name',
              valueType: 'SIMPLE',
              dataType: 25,
              id: 'name',
            },
            {
              clconvertMode: 'NONE',
              appDEFieldId: 'start_at',
              detreeColumnId: 'start_at',
              valueType: 'SIMPLE',
              dataType: 5,
              id: 'start_at',
            },
            {
              clconvertMode: 'NONE',
              appDEFieldId: 'state',
              detreeColumnId: 'state',
              valueType: 'SIMPLE',
              dataType: 25,
              id: 'state',
            },
          ],
          treeNodeType: 'DE',
          hasDETreeNodeRSs: true,
          expanded: true,
          name: '项目集',
          id: 'node',
        },
        {
          idAppDEFieldId: 'id',
          appDEDataSetId: 'fetch_under_project_portfolio',
          textAppDEFieldId: 'name',
          nodeType: 'node_1',
          appDataEntityId: 'plmweb.project',
          detreeNodeColumns: [
            {
              clconvertMode: 'NONE',
              dataItemName: 'assignee_name',
              appDEFieldId: 'assignee_name',
              valueType: 'SIMPLE',
              codeName: 'assignee_name',
              columnType: 'DEFGRIDCOLUMN',
              noPrivDisplayMode: 1,
              detreeColumnId: 'assignee_name',
              id: 'assignee_name',
            },
            {
              clconvertMode: 'NONE',
              dataItemName: 'end_at',
              appDEFieldId: 'end_at',
              valueFormat: 'YYYY-MM-DD',
              valueType: 'SIMPLE',
              codeName: 'end_at',
              columnType: 'DEFGRIDCOLUMN',
              noPrivDisplayMode: 1,
              detreeColumnId: 'end_at',
              id: 'end_at',
            },
            {
              clconvertMode: 'NONE',
              dataItemName: 'name',
              linkAppViewId: 'plmweb.project_redirect_view',
              linkValueItem: 'srfkey',
              appDEFieldId: 'name',
              deuiactionGroup: {
                uiactionGroupDetails: [
                  {
                    actionLevel: 200,
                    afterItemType: 'NONE',
                    beforeItemType: 'NONE',
                    detailType: 'DEUIACTION',
                    uiactionId: 'remove_from_project_set@project',
                    tooltip: '移除',
                    showIcon: true,
                    sysImage: {
                      cssClass: 'fa fa-trash-o',
                      glyph: 'xf014@FontAwesome',
                    },
                    id: 'u33e263f',
                  },
                ],
                appDataEntityId: 'plmweb.project',
                uniqueTag: 'project__Usr0305093607',
                name: '从项目集中移除',
                id: 'usr0305093607',
              },
              valueType: 'SIMPLE',
              enableLinkView: true,
              codeName: 'name',
              columnType: 'DEFGRIDCOLUMN',
              noPrivDisplayMode: 1,
              detreeColumnId: 'name',
              id: 'name',
            },
            {
              clconvertMode: 'NONE',
              dataItemName: 'start_at',
              appDEFieldId: 'start_at',
              valueFormat: 'YYYY-MM-DD',
              valueType: 'SIMPLE',
              codeName: 'start_at',
              columnType: 'DEFGRIDCOLUMN',
              noPrivDisplayMode: 1,
              detreeColumnId: 'start_at',
              id: 'start_at',
            },
            {
              clconvertMode: 'FRONT',
              dataItemName: 'state',
              appCodeListId: 'plmweb.projmgmt__project_state',
              appDEFieldId: 'state',
              valueType: 'SIMPLE',
              codeName: 'state',
              columnType: 'DEFGRIDCOLUMN',
              noPrivDisplayMode: 1,
              detreeColumnId: 'state',
              id: 'state',
            },
          ],
          detreeNodeDataItems: [
            {
              clconvertMode: 'NONE',
              appDEFieldId: 'assignee_name',
              detreeColumnId: 'assignee_name',
              valueType: 'SIMPLE',
              dataType: 25,
              id: 'assignee_name',
            },
            {
              clconvertMode: 'NONE',
              appDEFieldId: 'end_at',
              detreeColumnId: 'end_at',
              valueType: 'SIMPLE',
              dataType: 5,
              id: 'end_at',
            },
            {
              clconvertMode: 'NONE',
              appDEFieldId: 'name',
              detreeColumnId: 'name',
              valueType: 'SIMPLE',
              dataType: 25,
              id: 'name',
            },
            {
              clconvertMode: 'NONE',
              appDEFieldId: 'start_at',
              detreeColumnId: 'start_at',
              valueType: 'SIMPLE',
              dataType: 5,
              id: 'start_at',
            },
            {
              clconvertMode: 'NONE',
              appDEFieldId: 'state',
              detreeColumnId: 'state',
              valueType: 'SIMPLE',
              dataType: 25,
              id: 'state',
            },
          ],
          treeNodeType: 'DE',
          name: '项目集下的项目',
          id: 'node_1',
        },
        {
          idAppDEFieldId: 'id',
          appDEDataSetId: 'fetch_work_project',
          textAppDEFieldId: 'name',
          nodeType: 'node_2',
          appDataEntityId: 'plmweb.project',
          detreeNodeColumns: [
            {
              clconvertMode: 'NONE',
              dataItemName: 'assignee_name',
              appDEFieldId: 'assignee_name',
              valueType: 'SIMPLE',
              codeName: 'assignee_name',
              columnType: 'DEFGRIDCOLUMN',
              noPrivDisplayMode: 1,
              detreeColumnId: 'assignee_name',
              id: 'assignee_name',
            },
            {
              clconvertMode: 'NONE',
              dataItemName: 'end_at',
              appDEFieldId: 'end_at',
              valueFormat: 'YYYY-MM-DD',
              valueType: 'SIMPLE',
              codeName: 'end_at',
              columnType: 'DEFGRIDCOLUMN',
              noPrivDisplayMode: 1,
              detreeColumnId: 'end_at',
              id: 'end_at',
            },
            {
              clconvertMode: 'NONE',
              dataItemName: 'name',
              linkAppViewId: 'plmweb.project_redirect_view',
              linkValueItem: 'srfkey',
              appDEFieldId: 'name',
              deuiactionGroup: {
                uiactionGroupDetails: [
                  {
                    actionLevel: 200,
                    afterItemType: 'NONE',
                    beforeItemType: 'NONE',
                    detailType: 'DEUIACTION',
                    uiactionId: 'remove_from_project_set@project',
                    tooltip: '移除',
                    showIcon: true,
                    sysImage: {
                      cssClass: 'fa fa-trash-o',
                      glyph: 'xf014@FontAwesome',
                    },
                    id: 'u33e263f',
                  },
                ],
                appDataEntityId: 'plmweb.project',
                uniqueTag: 'project__Usr0305093607',
                name: '从项目集中移除',
                id: 'usr0305093607',
              },
              valueType: 'SIMPLE',
              enableLinkView: true,
              codeName: 'name',
              columnType: 'DEFGRIDCOLUMN',
              noPrivDisplayMode: 1,
              detreeColumnId: 'name',
              id: 'name',
            },
            {
              clconvertMode: 'NONE',
              dataItemName: 'start_at',
              appDEFieldId: 'start_at',
              valueFormat: 'YYYY-MM-DD',
              valueType: 'SIMPLE',
              codeName: 'start_at',
              columnType: 'DEFGRIDCOLUMN',
              noPrivDisplayMode: 1,
              detreeColumnId: 'start_at',
              id: 'start_at',
            },
            {
              clconvertMode: 'FRONT',
              dataItemName: 'state',
              appCodeListId: 'plmweb.projmgmt__project_state',
              appDEFieldId: 'state',
              valueType: 'SIMPLE',
              codeName: 'state',
              columnType: 'DEFGRIDCOLUMN',
              noPrivDisplayMode: 1,
              detreeColumnId: 'state',
              id: 'state',
            },
          ],
          detreeNodeDataItems: [
            {
              clconvertMode: 'NONE',
              appDEFieldId: 'assignee_name',
              detreeColumnId: 'assignee_name',
              valueType: 'SIMPLE',
              dataType: 25,
              id: 'assignee_name',
            },
            {
              clconvertMode: 'NONE',
              appDEFieldId: 'end_at',
              detreeColumnId: 'end_at',
              valueType: 'SIMPLE',
              dataType: 5,
              id: 'end_at',
            },
            {
              clconvertMode: 'NONE',
              appDEFieldId: 'name',
              detreeColumnId: 'name',
              valueType: 'SIMPLE',
              dataType: 25,
              id: 'name',
            },
            {
              clconvertMode: 'NONE',
              appDEFieldId: 'start_at',
              detreeColumnId: 'start_at',
              valueType: 'SIMPLE',
              dataType: 5,
              id: 'start_at',
            },
            {
              clconvertMode: 'NONE',
              appDEFieldId: 'state',
              detreeColumnId: 'state',
              valueType: 'SIMPLE',
              dataType: 25,
              id: 'state',
            },
          ],
          treeNodeType: 'DE',
          name: '项目',
          id: 'node_2',
        },
      ],
      treeGridMode: 1,
      outputIconDefault: true,
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'tree_grid_ex_view_tree_grid',
      controlType: 'TREEGRIDEX',
      logicName: '工作实体树表格视图_树表格',
      appDataEntityId: 'plmweb.work',
      controlParam: {
        id: 'treegridex',
      },
      modelId: 'f720a521cc496bc1e9b7a63678e19d64',
      modelType: 'PSDETREEGRIDEX',
      name: 'treegridex',
      id: 'plmweb.work.tree_grid_ex_view_tree_grid',
    },
    {
      groupMode: 'SINGLE',
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.work',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.WORK',
      },
      caption: '工作',
      codeName: 'tree_grid_ex_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.work',
      controlParam: {},
      name: 'captionbar',
      id: 'tree_grid_ex_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDETREEGRIDEXVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.work',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '工作实体树表格视图',
  viewStyle: 'DEFAULT',
  viewType: 'DETREEGRIDEXVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '1ceccb8debea89c59d963504096335a5',
  modelType: 'PSAPPDEVIEW',
  name: 'worktree_grid_ex_view',
  id: 'plmweb.work_tree_grid_ex_view',
};