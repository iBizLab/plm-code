export default {
  tabLayout: 'TOP',
  loadDefault: true,
  showDataInfoBar: true,
  deviewCodeName: 'filter_tab_exp_view',
  deviewId: '7e65df8a0c255c57210704f6408d6699',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.LIBRARY',
  },
  caption: '测试库',
  codeName: 'library_filter_tab_exp_view',
  appDataEntityId: 'plmweb.library',
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
            caption: '测试用例',
            appViewId: 'plmweb.test_case_filter_grid_view',
            id: 'test_case',
          },
          {
            caption: '执行用例',
            appViewId: 'plmweb.run_filter_grid_view',
            id: 'run',
          },
        ],
        dataRelationTag: 'filter_tab_exp_view_DR',
        editItemCapLanguageRes: {
          lanResTag: 'DE.LNAME.LIBRARY',
        },
        editItemCaption: '测试库',
        uniqueTag: 'library_filter_tab_exp_view__tabexppanel',
        hideEditItem: true,
        autoLoad: true,
        showBusyIndicator: true,
        codeName: 'filter_tab_exp_view_dr',
        controlType: 'DRTAB',
        appDataEntityId: 'plmweb.library',
        controlParam: {
          id: 'tabexppanel',
        },
        modelId: '7045c4c75139a125f4a1e1e5c47ff0c4',
        modelType: 'PSDEDRTAB',
        name: 'tabexppanel',
        id: 'filter_tab_exp_view_dr',
      },
      {
        capLanguageRes: {
          lanResTag: 'DE.LNAME.LIBRARY',
        },
        caption: '测试库',
        codeName: 'filter_tab_exp_view_captionbar',
        controlType: 'CAPTIONBAR',
        appDataEntityId: 'plmweb.library',
        controlParam: {},
        name: 'captionbar',
        id: 'filter_tab_exp_view_captionbar',
      },
    ],
    codeName: 'usr0813777103',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: 'filter_tab_exp_view分页导航视图布局面板',
    appDataEntityId: 'plmweb.library',
    controlParam: {},
    modelId: 'de43eb56a755bd7b05d22d8041647137',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'usr0813777103',
  },
  title: '测试库筛选器',
  viewStyle: 'DEFAULT',
  viewType: 'DETABEXPVIEW',
  enableDP: true,
  showCaptionBar: false,
  modelId: 'fe6af33cea7bb29e26d2b67423312370',
  modelType: 'PSAPPDEVIEW',
  name: 'libraryfilter_tab_exp_view',
  id: 'plmweb.library_filter_tab_exp_view',
};
