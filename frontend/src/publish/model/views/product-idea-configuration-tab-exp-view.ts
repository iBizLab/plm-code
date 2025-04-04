export default {
  tabLayout: 'TOP',
  loadDefault: true,
  showDataInfoBar: true,
  deviewCodeName: 'idea_configuration_tab_exp_view',
  deviewId: '86ee33717a72af70d6e26134e0e486eb',
  accUserMode: 2,
  caption: '产品',
  codeName: 'product_idea_configuration_tab_exp_view',
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
              {
                rawItem: {
                  predefinedType: 'TELEPORT_PLACEHOLDER',
                  id: 'tabtoolbar',
                },
                caption: '传送部件占位',
                itemStyle: 'DEFAULT',
                itemType: 'RAWITEM',
                layoutPos: {
                  shrink: 1,
                  layout: 'FLEX',
                },
                showCaption: true,
                id: 'tabtoolbar',
              },
            ],
            layout: {
              align: 'flex-start',
              dir: 'row',
              layout: 'FLEX',
              valign: 'center',
            },
            dataRegionType: 'INHERIT',
            caption: '容器',
            itemStyle: 'DEFAULT',
            itemType: 'CONTAINER',
            layoutPos: {
              shrink: 1,
              layout: 'FLEX',
              spacingRight: 'OUTERMEDIUM',
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
        dedrtabPages: [
          {
            caption: '需求设置',
            appViewId: 'plmweb.product_idea_configuration_view',
            id: 'setting',
          },
          {
            caption: '属性管理',
            appViewId: 'plmweb.psde_field_idea_extend_transmit_grid_view',
            navigateContexts: [
              {
                key: 'PSDATAENTITY',
                value: 'FIELD__PRODUCT_ID__${product}@ProdMgmt.idea',
                name: 'PSDATAENTITY',
                id: 'psdataentity',
              },
              {
                key: 'PSDENAME',
                value: 'IDEA',
                rawValue: true,
                name: 'PSDENAME',
                id: 'psdename',
              },
            ],
            id: 'field_manage',
          },
        ],
        dataRelationTag: 'idea_configuration_tab_exp_dr',
        editItemCaption: '产品',
        uniqueTag: 'product_idea_configuration_tab_exp_view__tabexppanel',
        autoLoad: true,
        showBusyIndicator: true,
        codeName: 'idea_configuration_tab_exp_dr',
        controlType: 'DRTAB',
        appDataEntityId: 'plmweb.product',
        controlParam: {
          id: 'tabexppanel',
        },
        modelId: '627b5e67840aa3948a80a3ef3aab58c5',
        modelType: 'PSDEDRTAB',
        name: 'tabexppanel',
        id: 'idea_configuration_tab_exp_dr',
      },
      {
        caption: '产品',
        codeName: 'idea_configuration_tab_exp_view_captionbar',
        controlType: 'CAPTIONBAR',
        appDataEntityId: 'plmweb.product',
        controlParam: {},
        name: 'captionbar',
        id: 'idea_configuration_tab_exp_view_captionbar',
      },
    ],
    codeName: 'usr1023637829',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: 'idea_configuration_tab_exp_view分页导航视图布局面板',
    appDataEntityId: 'plmweb.product',
    controlParam: {},
    modelId: 'e2f2ab77a9db94d07e2fcbf12c78f8cd',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'usr1023637829',
  },
  title: '产品需求事项配置',
  viewStyle: 'DEFAULT',
  viewType: 'DETABEXPVIEW',
  enableDP: true,
  showCaptionBar: false,
  modelId: '4a01ebb9406b3d88bffdc3a98b2a209a',
  modelType: 'PSAPPDEVIEW',
  name: 'productidea_configuration_tab_exp_view',
  id: 'plmweb.product_idea_configuration_tab_exp_view',
};
