export default {
  openMode: 'POPUPMODAL',
  deviewCodeName: 'pick_up_around_view',
  deviewId: '3db95d24407962213833d00954205450',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.SPRINT',
  },
  caption: '迭代',
  codeName: 'sprint_pick_up_around_view',
  appDataEntityId: 'plmweb.sprint',
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
      key: 'n_project_id_eq',
      value: 'project',
      id: 'n_project_id_eq',
    },
  ],
  controls: [
    {
      embeddedAppDEViewId: 'plmweb.sprint_pick_up_around_grid_view',
      codeName: 'pick_up_around_view_pickupviewpanel',
      controlType: 'PICKUPVIEWPANEL',
      appDataEntityId: 'plmweb.sprint',
      controlParam: {
        id: 'pickupviewpanel',
      },
      name: 'pickupviewpanel',
      id: 'pick_up_around_view_pickupviewpanel',
    },
    {
      title: '选择迭代',
      xdataControlName: 'treeexpbar_tree',
      enableCounter: true,
      showTitleBar: true,
      autoLoad: true,
      showBusyIndicator: true,
      appViewRefs: [
        {
          realTitle: '迭代树导航表格视图',
          refAppViewId: 'plmweb.sprint_all_grid_view',
          name: 'EXPITEM:node',
          id: 'expitem:node',
        },
        {
          realTitle: '迭代树导航表格视图',
          refAppViewId: 'plmweb.sprint_all_grid_view',
          name: 'EXPITEM:node_2',
          id: 'expitem:node_2',
        },
        {
          realTitle: '迭代树导航表格视图',
          refAppViewId: 'plmweb.sprint_all_grid_view',
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
              navAppViewId: 'plmweb.sprint_all_grid_view',
              nodeType: 'node',
              navigateParams: [
                {
                  key: 'n_project_id_eq',
                  value: 'project',
                  id: 'n_project_id_eq',
                },
              ],
              treeNodeType: 'STATIC',
              name: '全部迭代',
              id: 'node',
            },
            {
              dataSourceType: 'DEDATASET',
              idAppDEFieldId: 'id',
              appDEDataSetId: 'fetch_default',
              textAppDEFieldId: 'name',
              nodeType: 'node_1',
              appDataEntityId: 'plmweb.section',
              treeNodeType: 'DE',
              hasDETreeNodeRSs: true,
              expanded: true,
              name: '迭代分组',
              id: 'node_1',
            },
            {
              dataSourceType: 'DEDATASET',
              idAppDEFieldId: 'id',
              appDEDataSetId: 'fetch_default',
              textAppDEFieldId: 'name',
              navAppViewId: 'plmweb.sprint_all_grid_view',
              nodeType: 'node_2',
              appDataEntityId: 'plmweb.category',
              navigateParams: [
                {
                  key: 'n_categories_like',
                  value: 'id',
                  id: 'n_categories_like',
                },
              ],
              treeNodeType: 'DE',
              name: '迭代类型',
              id: 'node_2',
            },
            {
              dataSourceType: 'DEDATASET',
              idAppDEFieldId: 'id',
              appDEDataSetId: 'fetch_no_section',
              textAppDEFieldId: 'name',
              navAppViewId: 'plmweb.sprint_all_grid_view',
              nodeType: 'node_3',
              appDataEntityId: 'plmweb.category',
              navigateParams: [
                {
                  key: 'n_categorys_like',
                  value: 'id',
                  id: 'n_categorys_like',
                },
              ],
              treeNodeType: 'DE',
              name: '无分组',
              id: 'node_3',
            },
          ],
          outputIconDefault: true,
          navViewPos: 'NONE',
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
          codeName: 'pick_up_view_tree_view',
          controlType: 'TREEVIEW',
          logicName: '迭代实体数据选择视图（选择关系）_树视图',
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
          modelId: '8bc847c2c88d169451907e26c3ba4808',
          modelType: 'PSDETREEVIEW',
          name: 'treeexpbar_tree',
          id: 'plmweb.sprint.pick_up_view_tree_view',
        },
      ],
      codeName: 'pick_up_around_view_treeexpbar',
      controlType: 'TREEEXPBAR',
      appDataEntityId: 'plmweb.sprint',
      controlParam: {
        id: 'treeexpbar',
      },
      modelId: 'b359380f3411204eb1e5846517696c8f_treeexpbar',
      modelType: 'PSEXPBAR',
      name: 'treeexpbar',
      id: 'pick_up_around_view_treeexpbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.SPRINT',
      },
      caption: '迭代',
      codeName: 'pick_up_around_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.sprint',
      controlParam: {},
      name: 'captionbar',
      id: 'pick_up_around_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutMode: 'FLEX',
    layout: {
      layout: 'FLEX',
    },
    rootPanelItems: [
      {
        actionGroupExtractMode: 'ITEM',
        panelItems: [
          {
            actionGroupExtractMode: 'ITEM',
            panelItems: [
              {
                actionGroupExtractMode: 'ITEM',
                panelItems: [
                  {
                    caption: '页面标题',
                    itemStyle: 'DEFAULT',
                    itemType: 'CTRLPOS',
                    layoutPos: {
                      shrink: 1,
                      layout: 'FLEX',
                    },
                    showCaption: true,
                    id: 'captionbar',
                  },
                ],
                layout: {
                  align: 'center',
                  layout: 'FLEX',
                },
                dataRegionType: 'INHERIT',
                caption: '容器',
                itemStyle: 'DEFAULT',
                itemType: 'CONTAINER',
                layoutPos: {
                  shrink: 1,
                  heightMode: 'FULL',
                  layout: 'FLEX',
                },
                id: 'view_captionbar',
              },
            ],
            layout: {
              layout: 'FLEX',
            },
            dataRegionType: 'INHERIT',
            caption: '容器',
            itemStyle: 'DEFAULT',
            itemType: 'CONTAINER',
            layoutPos: {
              shrink: 1,
              heightMode: 'FULL',
              layout: 'FLEX',
            },
            id: 'view_header_left',
          },
          {
            actionGroupExtractMode: 'ITEM',
            panelItems: [
              {
                actionGroupExtractMode: 'ITEM',
                panelItems: [
                  {
                    caption: '工具栏',
                    itemStyle: 'DEFAULT',
                    itemType: 'CTRLPOS',
                    layoutPos: {
                      shrink: 1,
                      layout: 'FLEX',
                    },
                    showCaption: true,
                    id: 'toolbar',
                  },
                ],
                layout: {
                  align: 'center',
                  layout: 'FLEX',
                },
                dataRegionType: 'INHERIT',
                caption: '容器',
                itemStyle: 'DEFAULT',
                itemType: 'CONTAINER',
                layoutPos: {
                  shrink: 1,
                  heightMode: 'FULL',
                  layout: 'FLEX',
                },
                id: 'view_toolbar',
              },
            ],
            layout: {
              layout: 'FLEX',
            },
            dataRegionType: 'INHERIT',
            caption: '容器',
            itemStyle: 'DEFAULT',
            itemType: 'CONTAINER',
            layoutPos: {
              shrink: 1,
              heightMode: 'FULL',
              layout: 'FLEX',
            },
            id: 'view_header_right',
          },
        ],
        predefinedType: 'VIEWHEADER',
        layout: {
          align: 'space-between',
          dir: 'row',
          layout: 'FLEX',
          valign: 'center',
        },
        dataRegionType: 'INHERIT',
        caption: '容器',
        itemStyle: 'DEFAULT',
        itemType: 'CONTAINER',
        layoutPos: {
          shrink: 0,
          layout: 'FLEX',
        },
        id: 'view_header',
      },
      {
        actionGroupExtractMode: 'ITEM',
        panelItems: [
          {
            actionGroupExtractMode: 'ITEM',
            panelItems: [
              {
                actionGroupExtractMode: 'ITEM',
                panelItems: [
                  {
                    caption: '树导航栏',
                    itemStyle: 'DEFAULT',
                    itemType: 'CTRLPOS',
                    layoutPos: {
                      shrink: 1,
                      layout: 'FLEX',
                    },
                    showCaption: true,
                    id: 'treeexpbar',
                  },
                ],
                layout: {
                  layout: 'FLEX',
                },
                dataRegionType: 'INHERIT',
                caption: '容器',
                contentWidth: 300,
                itemStyle: 'DEFAULT',
                itemType: 'CONTAINER',
                layoutPos: {
                  shrink: 0,
                  layout: 'FLEX',
                  width: 300,
                  widthMode: 'PX',
                },
                width: 300,
                id: 'container6',
              },
              {
                actionGroupExtractMode: 'ITEM',
                panelItems: [
                  {
                    caption: '控件占位',
                    itemStyle: 'DEFAULT',
                    itemType: 'CTRLPOS',
                    layoutPos: {
                      grow: 1,
                      shrink: 1,
                      layout: 'FLEX',
                    },
                    showCaption: true,
                    id: 'pickupviewpanel',
                  },
                ],
                predefinedType: 'VIEWCONTENT',
                layout: {
                  layout: 'FLEX',
                },
                dataRegionType: 'INHERIT',
                caption: '容器',
                itemStyle: 'DEFAULT',
                itemType: 'CONTAINER',
                layoutPos: {
                  grow: 1,
                  shrink: 1,
                  layout: 'FLEX',
                },
                id: 'container7',
              },
            ],
            layout: {
              dir: 'row',
              layout: 'FLEX',
            },
            dataRegionType: 'INHERIT',
            caption: '容器',
            itemStyle: 'DEFAULT',
            itemType: 'CONTAINER',
            layoutPos: {
              grow: 1,
              shrink: 1,
              layout: 'FLEX',
            },
            id: 'container3',
          },
        ],
        predefinedType: 'VIEWCONTENT',
        layout: {
          dir: 'column',
          layout: 'FLEX',
        },
        dataRegionType: 'INHERIT',
        caption: '容器',
        itemStyle: 'DEFAULT',
        itemType: 'CONTAINER',
        layoutPos: {
          grow: 1,
          shrink: 1,
          layout: 'FLEX',
        },
        id: 'view_content',
      },
      {
        actionGroupExtractMode: 'ITEM',
        panelItems: [
          {
            actionType: 'UIACTION',
            buttonStyle: 'PRIMARY',
            buttonType: 'PANELBUTTON',
            uiactionId: 'view_okaction',
            renderMode: 'BUTTON',
            tooltip: '确定',
            caption: '确定',
            itemStyle: 'PRIMARY',
            itemType: 'BUTTON',
            layoutPos: {
              shrink: 1,
              layout: 'FLEX',
            },
            showCaption: true,
            id: 'button_okaction',
          },
          {
            actionType: 'UIACTION',
            buttonStyle: 'INFO',
            buttonType: 'PANELBUTTON',
            uiactionId: 'view_cancelaction',
            renderMode: 'BUTTON',
            tooltip: '取消',
            caption: '取消',
            itemStyle: 'INFO',
            itemType: 'BUTTON',
            layoutPos: {
              shrink: 1,
              layout: 'FLEX',
            },
            showCaption: true,
            id: 'button_cancelaction',
          },
        ],
        layout: {
          dir: 'row-reverse',
          layout: 'FLEX',
          valign: 'center',
        },
        dataRegionType: 'INHERIT',
        caption: '容器',
        itemStyle: 'DEFAULT',
        itemType: 'CONTAINER',
        layoutPos: {
          shrink: 0,
          layout: 'FLEX',
        },
        id: 'view_footer',
      },
    ],
    layoutPanel: true,
    codeName: 'ex_release_pickup_view2_layout',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: '选择视图(左右关系)布局面板(项目发布实体扩展)',
    appDataEntityId: 'plmweb.sprint',
    controlParam: {},
    modelId: '7f8b0b1998812e4323ecee2d9ea553ab',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'ex_release_pickup_view2_layout',
  },
  title: '迭代实体数据选择视图（左右关系）',
  viewStyle: 'DEFAULT',
  viewType: 'DEPICKUPVIEW2',
  enableDP: true,
  showCaptionBar: false,
  modelId: 'b359380f3411204eb1e5846517696c8f',
  modelType: 'PSAPPDEVIEW',
  name: 'sprintpick_up_around_view',
  id: 'plmweb.sprint_pick_up_around_view',
};
