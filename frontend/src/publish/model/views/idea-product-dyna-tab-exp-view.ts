export default {
  tabLayout: 'TOP',
  loadDefault: true,
  showDataInfoBar: true,
  openMode: 'INDEXVIEWTAB_POPUPMODAL',
  deviewCodeName: 'product_dyna_tab_exp_view',
  deviewId: '2c5834c7309a7a4dbbaa09eb4cabaa54',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.IDEA',
  },
  caption: '需求动态设计',
  codeName: 'idea_product_dyna_tab_exp_view',
  height: 90,
  appDataEntityId: 'plmweb.idea',
  appViewMsgGroupId: 'usrvmgroup1119762016',
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
                rawItem: {
                  rawItemParams: [
                    {
                      key: 'POSITION',
                      value: 'TOP',
                    },
                  ],
                  predefinedType: 'VIEWMSG_POS',
                  id: 'viewmsg_pos',
                },
                caption: '视图消息占位',
                itemStyle: 'DEFAULT',
                itemType: 'RAWITEM',
                layoutPos: {
                  shrink: 0,
                  layout: 'FLEX',
                },
                showCaption: true,
                id: 'viewmsg_pos',
              },
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
            caption: '显示视图配置',
            appViewId: 'plmweb.psdeformdesign_modal',
            navigateContexts: [
              {
                key: 'PSDEFORM',
                value: 'FIELD__PRODUCT_ID__${product}@ProdMgmt.idea.Main',
                name: 'PSDEFORM',
                id: 'psdeform',
              },
            ],
            id: 'show_view',
          },
          {
            caption: '新建视图配置',
            appViewId: 'plmweb.psdeformdesign_modal',
            navigateContexts: [
              {
                key: 'PSDEFORM',
                value:
                  'FIELD__PRODUCT_ID__${product}@ProdMgmt.idea.quick_create',
                name: 'PSDEFORM',
                id: 'psdeform',
              },
            ],
            id: 'new_view',
          },
        ],
        dataRelationTag: 'product_dyna_tab_exp_view_DR',
        editItemCapLanguageRes: {
          lanResTag: 'DE.LNAME.IDEA',
        },
        editItemCaption: '需求',
        uniqueTag: 'idea_product_dyna_tab_exp_view__tabexppanel',
        autoLoad: true,
        showBusyIndicator: true,
        codeName: 'product_dyna_tab_exp_view_dr',
        controlType: 'DRTAB',
        appDataEntityId: 'plmweb.idea',
        controlParam: {
          id: 'tabexppanel',
        },
        modelId: '0508e8439eef16f051334c8c3dc72a99',
        modelType: 'PSDEDRTAB',
        name: 'tabexppanel',
        id: 'product_dyna_tab_exp_view_dr',
      },
      {
        capLanguageRes: {
          lanResTag: 'DE.LNAME.IDEA',
        },
        caption: '需求动态设计',
        codeName: 'product_dyna_tab_exp_view_captionbar',
        controlType: 'CAPTIONBAR',
        appDataEntityId: 'plmweb.idea',
        controlParam: {},
        name: 'captionbar',
        id: 'product_dyna_tab_exp_view_captionbar',
      },
    ],
    codeName: 'usr1119122680',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: 'product_dyna_tab_exp_view分页导航视图布局面板',
    appDataEntityId: 'plmweb.idea',
    controlParam: {},
    modelId: 'eb123f6262d4444bedb07fef887ebc13',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'usr1119122680',
  },
  title: '需求动态设计（产品）',
  viewStyle: 'DEFAULT',
  viewType: 'DETABEXPVIEW',
  width: 90,
  enableDP: true,
  showCaptionBar: false,
  modelId: '1f90b7f8e2ac1704dfe40e571778e677',
  modelType: 'PSAPPDEVIEW',
  name: 'ideaproduct_dyna_tab_exp_view',
  id: 'plmweb.idea_product_dyna_tab_exp_view',
};
