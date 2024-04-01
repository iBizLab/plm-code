export default {
  tabLayout: 'TOP',
  loadDefault: true,
  showDataInfoBar: true,
  deviewCodeName: 'tab_exp_view',
  deviewId: '1dbca22be03dee45bf016c828e3ebd7c',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.RECENT',
  },
  caption: '工作台',
  codeName: 'recenttab_exp_view',
  appDataEntityId: 'plmweb.recent',
  sysCss: {
    cssName: 'recenttab-head',
  },
  sysImage: {
    cssClass: 'fa fa-home',
    glyph: 'xf015@FontAwesome',
  },
  viewLayoutPanel: {
    viewProxyMode: true,
    layoutMode: 'FLEX',
    layout: {
      layout: 'FLEX',
    },
    rootPanelItems: [
      {
        panelItems: [
          {
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
        panelItems: [
          {
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
            panelItems: [
              {
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
              {
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
            caption: '首页',
            appViewId: 'plmweb.recenttree_exp_view',
            id: 'overview',
          },
          {
            caption: '仪表盘',
            appViewId: 'plmweb.recentcustom_dashboard_view',
            id: 'dashboard',
          },
          {
            caption: '工时',
            appViewId: 'plmweb.workloadtab_exp_view',
            id: 'workload',
          },
        ],
        editItemCapLanguageRes: {
          lanResTag: 'DE.LNAME.RECENT',
        },
        editItemCaption: '最近访问',
        uniqueTag: 'recenttab_exp_view__tabexppanel',
        hideEditItem: true,
        autoLoad: true,
        showBusyIndicator: true,
        codeName: 'OverView_DR',
        controlType: 'DRTAB',
        appDataEntityId: 'plmweb.recent',
        controlParam: {
          id: 'tabexppanel',
        },
        modelId: '6fbc6d3b6b53bd9ec40b7e81897bbede',
        modelType: 'PSDEDRTAB',
        name: 'tabexppanel',
        id: 'overview_dr',
      },
      {
        capLanguageRes: {
          lanResTag: 'DE.LNAME.RECENT',
        },
        caption: '工作台',
        sysImage: {
          cssClass: 'fa fa-home',
          glyph: 'xf015@FontAwesome',
        },
        codeName: 'tab_exp_viewcaptionbar',
        controlType: 'CAPTIONBAR',
        appDataEntityId: 'plmweb.recent',
        controlParam: {},
        name: 'captionbar',
        id: 'tab_exp_viewcaptionbar',
      },
    ],
    codeName: 'Usr0205336127',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: 'tab_exp_view分页导航视图布局面板',
    appDataEntityId: 'plmweb.recent',
    controlParam: {},
    modelId: '56ba3aa4efa62bfda81fd5b5a400e07b',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'usr0205336127',
  },
  title: '工作台',
  viewStyle: 'DEFAULT',
  viewType: 'DETABEXPVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '37f82b2fdf1ff3b449423327874dbb9e',
  modelType: 'PSAPPDEVIEW',
  name: 'recenttab_exp_view',
  id: 'plmweb.recenttab_exp_view',
};
