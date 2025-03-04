export default {
  tabLayout: 'TOP',
  loadDefault: true,
  showDataInfoBar: true,
  deviewCodeName: 'project_main_view',
  deviewId: 'da2da70f4c10360c764505a752bee884',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.BASELINE',
  },
  caption: '基线',
  codeName: 'baseline_project_main_view',
  appDataEntityId: 'plmweb.baseline',
  appViewNavParams: [
    {
      rawValue: true,
      key: 'srfdataaccaction',
      value: 'true',
      id: 'srfdataaccaction',
    },
  ],
  sysCss: {
    cssName: 'view-content-no-padding',
  },
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
              layout: 'FLEX',
            },
            dataRegionType: 'INHERIT',
            caption: '容器',
            cssStyle: 'margin-right:5px',
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
            caption: '基线工作项',
            appViewId: 'plmweb.baseline_work_item_relation_grid_view',
            id: 'baseline_work_item',
          },
          {
            caption: '基线对比',
            appViewId: 'plmweb.baseline_work_item_comparison_grid_view',
            id: 'comparison',
          },
        ],
        dataRelationTag: 'project_tab_exp_view_dr',
        editItemCapLanguageRes: {
          lanResTag: 'DE.LNAME.BASELINE',
        },
        editItemCaption: '基线',
        uniqueTag: 'baseline_project_main_view__tabexppanel',
        hideEditItem: true,
        autoLoad: true,
        showBusyIndicator: true,
        codeName: 'project_tab_exp_view_dr',
        controlType: 'DRTAB',
        appDataEntityId: 'plmweb.baseline',
        controlParam: {
          id: 'tabexppanel',
        },
        modelId: 'c89637a46b5dc29036a0a5d481df34b9',
        modelType: 'PSDEDRTAB',
        name: 'tabexppanel',
        id: 'project_tab_exp_view_dr',
      },
      {
        capLanguageRes: {
          lanResTag: 'DE.LNAME.BASELINE',
        },
        caption: '基线',
        codeName: 'project_main_view_captionbar',
        controlType: 'CAPTIONBAR',
        appDataEntityId: 'plmweb.baseline',
        controlParam: {},
        name: 'captionbar',
        id: 'project_main_view_captionbar',
      },
    ],
    codeName: 'usr0530723052',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: 'project_main_view分页导航视图布局面板',
    appDataEntityId: 'plmweb.baseline',
    controlParam: {},
    modelId: '45beb9199f8fb0a7f6ac82975d393280',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'usr0530723052',
  },
  title: '项目基线分页导航视图',
  viewStyle: 'DEFAULT',
  viewType: 'DETABEXPVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: 'd5257e2f1257152e6c488b478398bcfa',
  modelType: 'PSAPPDEVIEW',
  name: 'baselineproject_main_view',
  id: 'plmweb.baseline_project_main_view',
};
