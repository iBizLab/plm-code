export default {
  deviewCodeName: 'setting_view',
  deviewId: 'c6dc15e04ae9d08dca79af1c6b651664',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.MANAGEMENT',
  },
  caption: '配置中心',
  codeName: 'management_setting_view',
  appDataEntityId: 'plmweb.management',
  sysCss: {
    cssName: 'management_setting_style',
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
                actionGroupExtractMode: 'ITEM',
                panelItems: [
                  {
                    actionGroupExtractMode: 'ITEM',
                    panelItems: [
                      {
                        caption: '关系数据栏',
                        itemStyle: 'DEFAULT',
                        itemType: 'CTRLPOS',
                        layoutPos: {
                          shrink: 1,
                          layout: 'FLEX',
                        },
                        showCaption: true,
                        id: 'drbar',
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
                      colMD: 24,
                      heightMode: 'FULL',
                      layout: 'TABLE_24COL',
                      widthMode: 'FULL',
                    },
                    id: 'container3',
                  },
                ],
                layout: {
                  columnCount: 24,
                  layout: 'TABLE_24COL',
                },
                dataRegionType: 'INHERIT',
                caption: '面板容器',
                contentWidth: 300,
                itemStyle: 'DEFAULT',
                itemType: 'CONTAINER',
                layoutPos: {
                  shrink: 1,
                  layout: 'SIMPLEFLEX',
                  width: 300,
                  widthMode: 'PX',
                },
                width: 300,
                id: 'container',
              },
              {
                actionGroupExtractMode: 'ITEM',
                panelItems: [
                  {
                    rawItem: {
                      rawItemParams: [
                        {
                          key: 'SHOW_BREADCRUMB',
                          value: 'false',
                        },
                      ],
                      predefinedType: 'NAV_POS',
                      id: 'nav_pos',
                    },
                    caption: '导航区占位',
                    itemStyle: 'DEFAULT',
                    itemType: 'RAWITEM',
                    layoutPos: {
                      colMD: 24,
                      heightMode: 'FULL',
                      layout: 'TABLE_24COL',
                      spacingLeft: 'INNERSMALL',
                      widthMode: 'FULL',
                    },
                    sysPFPluginId: 'breadcrumb_nav_pos',
                    showCaption: true,
                    id: 'nav_pos',
                  },
                ],
                layout: {
                  columnCount: 24,
                  layout: 'TABLE_24COL',
                },
                dataRegionType: 'INHERIT',
                caption: '面板容器',
                itemStyle: 'DEFAULT',
                itemType: 'CONTAINER',
                layoutPos: {
                  shrink: 1,
                  layout: 'SIMPLEFLEX',
                },
                id: 'container1',
              },
            ],
            predefinedType: 'CONTAINER_H_SPLIT',
            layout: {
              layout: 'SIMPLEFLEX',
            },
            dataRegionType: 'INHERIT',
            caption: '分割容器(左右)',
            itemStyle: 'DEFAULT',
            itemType: 'CONTAINER',
            layoutPos: {
              grow: 1,
              shrink: 1,
              layout: 'FLEX',
            },
            id: 'container_h_split',
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
          widthMode: 'FULL',
        },
        id: 'container2',
      },
    ],
    layoutPanel: true,
    controls: [
      {
        dedrbarGroups: [
          {
            caption: '通用',
            name: '通用',
            id: 'usrdrgroup0514095082',
          },
          {
            caption: '产品',
            name: '产品',
            id: 'usrdrgroup0514569929',
          },
        ],
        showTitle: true,
        dataRelationTag: 'config_tab_exp_view_DR',
        editItemCapLanguageRes: {
          lanResTag: 'DE.LNAME.MANAGEMENT',
        },
        editItemCaption: '后台管理',
        dedrctrlItems: [
          {
            dedrbarGroupId: 'usrdrgroup0514095082',
            caption: '角色配置',
            appViewId: 'plmweb.role_grid_view',
            sysImage: {
              cssClass: 'fa fa-users',
              glyph: 'xf0c0@FontAwesome',
            },
            id: 'role',
          },
          {
            dedrbarGroupId: 'usrdrgroup0514095082',
            caption: '工时设置',
            appViewId: 'plmweb.workload_type_setup_grid_view',
            sysImage: {
              cssClass: 'fa fa-gear',
              glyph: 'xf013@FontAwesome',
            },
            id: 'workload',
          },
          {
            dedrbarGroupId: 'usrdrgroup0514569929',
            caption: '产品管理',
            appViewId: 'plmweb.product_config_tree_exp_view',
            sysImage: {
              cssClass: 'fa fa-th-large',
              glyph: 'xf009@FontAwesome',
            },
            id: 'product',
          },
          {
            dedrbarGroupId: 'usrdrgroup0514569929',
            caption: '项目管理',
            appViewId: 'plmweb.project_config_tree_exp_view',
            sysImage: {
              cssClass: 'fa fa-file-text-o',
              glyph: 'xf0f6@FontAwesome',
            },
            id: 'project',
          },
          {
            dedrbarGroupId: 'usrdrgroup0514569929',
            caption: '测试管理',
            appViewId: 'plmweb.library_config_tree_exp_view',
            sysImage: {
              cssClass: 'fa fa-bug',
              glyph: 'xf188@FontAwesome',
            },
            id: 'library',
          },
          {
            dedrbarGroupId: 'usrdrgroup0514569929',
            caption: '知识管理',
            appViewId: 'plmweb.space_config_tree_exp_view',
            sysImage: {
              cssClass: 'fa fa-book',
              glyph: 'xf02d@FontAwesome',
            },
            id: 'space',
          },
          {
            dedrbarGroupId: 'usrdrgroup0514569929',
            caption: '效能度量',
            appViewId: 'plmweb.insight_view_config_tree_exp_view',
            sysImage: {
              cssClass: 'fa fa-bar-chart-o',
              glyph: 'xf080@FontAwesome',
            },
            id: 'insight_view',
          },
          {
            dedrbarGroupId: 'usrdrgroup0514569929',
            caption: '协作空间',
            appViewId: 'plmweb.discuss_topic_config_tree_exp_view',
            sysImage: {
              cssClass: 'fa fa-comments',
              glyph: 'xf086@FontAwesome',
            },
            id: 'discuss',
          },
        ],
        uniqueTag: 'management_setting_view__drbar',
        hideEditItem: true,
        autoLoad: true,
        showBusyIndicator: true,
        codeName: 'config_tab_exp_view_dr',
        controlStyle: 'ROUTE_DRBAR',
        controlType: 'DRBAR',
        appDataEntityId: 'plmweb.management',
        controlParam: {
          ctrlParams: {
            SINGLEITEMGROUP: 'true',
            ROUTE_ITEMS:
              '["product", "project", "library", "space", "insight_view","discuss"]',
          },
          id: 'drbar',
        },
        sysPFPluginId: 'route_drbar',
        modelId: 'fdaddc168287baf717c525401bb92d52',
        modelType: 'PSDEDRBAR',
        name: 'drbar',
        id: 'config_tab_exp_view_dr',
      },
      {
        capLanguageRes: {
          lanResTag: 'DE.LNAME.MANAGEMENT',
        },
        caption: '配置中心',
        codeName: 'setting_view_captionbar',
        controlType: 'CAPTIONBAR',
        appDataEntityId: 'plmweb.management',
        controlParam: {},
        name: 'captionbar',
        id: 'setting_view_captionbar',
      },
    ],
    codeName: 'usr0514640216',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: '配置中心布局面板',
    appDataEntityId: 'plmweb.management',
    controlParam: {},
    modelId: '30f71c235e0a227c0f97bbc82df6b2e8',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'usr0514640216',
  },
  title: '配置中心',
  viewStyle: 'DEFAULT',
  viewType: 'DECUSTOMVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: 'fc26a7b93e50981871878e8eebfee3b9',
  modelType: 'PSAPPDEVIEW',
  name: 'managementsetting_view',
  id: 'plmweb.management_setting_view',
};
