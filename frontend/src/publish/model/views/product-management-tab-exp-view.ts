export default {
  tabLayout: 'TOP',
  loadDefault: true,
  showDataInfoBar: true,
  deviewCodeName: 'management_tab_exp_view',
  deviewId: 'a0320b12ea145bb9dd2d46ed78bbbe9b',
  accUserMode: 2,
  caption: '产品管理',
  codeName: 'product_management_tab_exp_view',
  appDataEntityId: 'plmweb.product',
  viewLayoutPanel: {
    viewProxyMode: true,
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
                caption: '标题栏',
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
              layout: 'FLEX',
            },
            dataRegionType: 'INHERIT',
            caption: '容器',
            itemStyle: 'DEFAULT',
            itemType: 'CONTAINER',
            layoutPos: {
              shrink: 1,
              layout: 'FLEX',
            },
            id: 'view_captionbar',
          },
          {
            actionGroupExtractMode: 'ITEM',
            panelItems: [
              {
                caption: '分页导航',
                itemStyle: 'DEFAULT',
                itemType: 'CTRLPOS',
                layoutPos: {
                  shrink: 1,
                  layout: 'FLEX',
                },
                showCaption: true,
                id: 'tabexppanel',
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
              grow: 1,
              shrink: 1,
              layout: 'FLEX',
            },
            id: 'view_tabexppanel',
          },
          {
            actionGroupExtractMode: 'ITEM',
            panelItems: [
              {
                rawItem: {
                  predefinedType: 'TELEPORT_PLACEHOLDER',
                  id: 'tabsearchbar',
                },
                caption: '传送部件占位',
                itemStyle: 'DEFAULT',
                itemType: 'RAWITEM',
                layoutPos: {
                  shrink: 1,
                  layout: 'FLEX',
                },
                showCaption: true,
                id: 'tabsearchbar',
              },
            ],
            layout: {
              layout: 'FLEX',
            },
            dataRegionType: 'INHERIT',
            caption: '容器',
            cssStyle: 'margin-right:10px',
            itemStyle: 'DEFAULT',
            itemType: 'CONTAINER',
            layoutPos: {
              shrink: 1,
              layout: 'FLEX',
            },
            id: 'container2',
          },
        ],
        predefinedType: 'VIEWHEADER',
        layout: {
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
            layout: {
              layout: 'FLEX',
            },
            dataRegionType: 'INHERIT',
            caption: '容器',
            itemStyle: 'DEFAULT',
            itemType: 'CONTAINER',
            layoutPos: {
              shrink: 0,
              layout: 'FLEX',
            },
            id: 'view_tabexppanel_left',
          },
          {
            actionGroupExtractMode: 'ITEM',
            panelItems: [
              {
                actionGroupExtractMode: 'ITEM',
                panelItems: [
                  {
                    rawItem: {
                      rawItemParams: [
                        {
                          key: 'EXPCACHE',
                          value: 'NO_CACHE',
                        },
                      ],
                      predefinedType: 'NAV_POS',
                      id: 'nav_pos',
                    },
                    caption: '导航区占位',
                    itemStyle: 'DEFAULT',
                    itemType: 'RAWITEM',
                    layoutPos: {
                      grow: 1,
                      shrink: 1,
                      layout: 'FLEX',
                    },
                    showCaption: true,
                    id: 'nav_pos',
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
                id: 'view_content',
              },
              {
                actionGroupExtractMode: 'ITEM',
                layout: {
                  layout: 'FLEX',
                },
                dataRegionType: 'INHERIT',
                caption: '容器',
                itemStyle: 'DEFAULT',
                itemType: 'CONTAINER',
                layoutPos: {
                  shrink: 0,
                  layout: 'FLEX',
                },
                id: 'view_tabexppanel_bottom',
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
              grow: 1,
              shrink: 1,
              layout: 'FLEX',
            },
            id: 'container1',
          },
          {
            actionGroupExtractMode: 'ITEM',
            layout: {
              layout: 'FLEX',
            },
            dataRegionType: 'INHERIT',
            caption: '容器',
            itemStyle: 'DEFAULT',
            itemType: 'CONTAINER',
            layoutPos: {
              shrink: 0,
              layout: 'FLEX',
            },
            id: 'view_tabexppanel_right',
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
        id: 'container',
      },
    ],
    layoutPanel: true,
    appViewEngines: [
      {
        engineCat: 'VIEW',
        engineType: 'TabExpView',
        id: 'engine',
      },
    ],
    controls: [
      {
        tabExpPageIds: ['in_progress', 'archived', 'deleted'],
        tabLayout: 'TOP',
        uniqueTag: 'product_management_tab_exp_view__tabexppanel',
        appViewRefs: [
          {
            realTitle: '产品管理',
            refAppViewId: 'plmweb.product_in_progress_grid_view',
            name: 'EXPITEM:in_progress',
            id: 'expitem:in_progress',
          },
          {
            realTitle: '产品管理',
            refAppViewId: 'plmweb.product_archived_grid_view',
            name: 'EXPITEM:archived',
            id: 'expitem:archived',
          },
          {
            realTitle: '产品管理',
            refAppViewId: 'plmweb.product_deleted_grid_view',
            name: 'EXPITEM:deleted',
            id: 'expitem:deleted',
          },
        ],
        controls: [
          {
            caption: '进行中',
            embeddedAppDEViewId: 'plmweb.product_in_progress_grid_view',
            codeName: 'management_tab_exp_view_in_progress',
            controlType: 'TABVIEWPANEL',
            appDataEntityId: 'plmweb.product',
            controlParam: {
              id: 'in_progress',
            },
            modelId: 'ad65949f58158cb9ccb5df905e200a6a_in_progress',
            modelType: 'PSVIEWPANEL',
            name: 'in_progress',
            id: 'management_tab_exp_view_in_progress',
          },
          {
            caption: '已归档',
            embeddedAppDEViewId: 'plmweb.product_archived_grid_view',
            codeName: 'management_tab_exp_view_archived',
            controlType: 'TABVIEWPANEL',
            appDataEntityId: 'plmweb.product',
            controlParam: {
              id: 'archived',
            },
            modelId: 'ad65949f58158cb9ccb5df905e200a6a_archived',
            modelType: 'PSVIEWPANEL',
            name: 'archived',
            id: 'management_tab_exp_view_archived',
          },
          {
            caption: '已删除',
            embeddedAppDEViewId: 'plmweb.product_deleted_grid_view',
            codeName: 'management_tab_exp_view_deleted',
            controlType: 'TABVIEWPANEL',
            appDataEntityId: 'plmweb.product',
            controlParam: {
              id: 'deleted',
            },
            modelId: 'ad65949f58158cb9ccb5df905e200a6a_deleted',
            modelType: 'PSVIEWPANEL',
            name: 'deleted',
            id: 'management_tab_exp_view_deleted',
          },
        ],
        codeName: 'management_tab_exp_view_tabexppanel',
        controlType: 'TABEXPPANEL',
        appDataEntityId: 'plmweb.product',
        controlParam: {},
        modelId: 'ad65949f58158cb9ccb5df905e200a6a_tabexppanel',
        modelType: 'PSTABEXPPANEL',
        name: 'tabexppanel',
        id: 'management_tab_exp_view_tabexppanel',
      },
      {
        caption: '产品管理',
        codeName: 'management_tab_exp_view_captionbar',
        controlType: 'CAPTIONBAR',
        appDataEntityId: 'plmweb.product',
        controlParam: {},
        name: 'captionbar',
        id: 'management_tab_exp_view_captionbar',
      },
    ],
    codeName: 'usr0416853624',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: 'management_tab_exp_view分页导航视图布局面板',
    appDataEntityId: 'plmweb.product',
    controlParam: {},
    modelId: '07b862287eac0817bd5377a037368a24',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'usr0416853624',
  },
  title: '产品管理导航',
  viewStyle: 'DEFAULT',
  viewType: 'DETABEXPVIEW',
  enableDP: true,
  showCaptionBar: false,
  modelId: 'ad65949f58158cb9ccb5df905e200a6a',
  modelType: 'PSAPPDEVIEW',
  name: 'productmanagement_tab_exp_view',
  id: 'plmweb.product_management_tab_exp_view',
};
