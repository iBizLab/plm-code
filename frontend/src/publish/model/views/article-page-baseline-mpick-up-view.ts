export default {
  openMode: 'POPUPMODAL',
  deviewCodeName: 'baseline_mpick_up_view',
  deviewId: '5C611C4D-29FF-4CF5-A41C-904ADBB30B27',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.PAGE',
  },
  caption: '页面',
  codeName: 'article_page_baseline_mpick_up_view',
  appDataEntityId: 'plmweb.article_page',
  appViewNavParams: [
    {
      key: 'space',
      value: 'space',
      id: 'space',
    },
  ],
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
          {
            actionGroupExtractMode: 'ITEM',
            panelItems: [
              {
                actionType: 'UIACTION',
                buttonStyle: 'DEFAULT',
                buttonType: 'PANELBUTTON',
                uiactionId: 'addselection',
                renderMode: 'BUTTON',
                tooltip: '添加选中数据',
                caption: '添加选中数据',
                itemStyle: 'DEFAULT',
                itemType: 'BUTTON',
                layoutPos: {
                  shrink: 1,
                  layout: 'FLEX',
                  spacingBottom: 'OUTERMEDIUM',
                },
                sysImage: {
                  cssClass: 'fa fa-angle-right',
                  glyph: 'xf105@FontAwesome',
                },
                id: 'button_addselection',
              },
              {
                actionType: 'UIACTION',
                buttonStyle: 'DEFAULT',
                buttonType: 'PANELBUTTON',
                uiactionId: 'addall',
                renderMode: 'BUTTON',
                tooltip: '添加全部数据',
                caption: '添加全部数据',
                itemStyle: 'DEFAULT',
                itemType: 'BUTTON',
                layoutPos: {
                  shrink: 1,
                  layout: 'FLEX',
                  spacingBottom: 'OUTERMEDIUM',
                },
                sysImage: {
                  cssClass: 'fa fa-angle-double-right',
                  glyph: 'xf101@FontAwesome',
                },
                id: 'button_addall',
              },
              {
                actionType: 'UIACTION',
                buttonStyle: 'DEFAULT',
                buttonType: 'PANELBUTTON',
                uiactionId: 'removeall',
                renderMode: 'BUTTON',
                tooltip: '移除全部数据',
                caption: '移除全部数据',
                itemStyle: 'DEFAULT',
                itemType: 'BUTTON',
                layoutPos: {
                  shrink: 1,
                  layout: 'FLEX',
                  spacingBottom: 'OUTERMEDIUM',
                },
                sysImage: {
                  cssClass: 'fa fa-angle-double-left',
                  glyph: 'xf100@FontAwesome',
                },
                id: 'button_removeall',
              },
              {
                actionType: 'UIACTION',
                buttonStyle: 'DEFAULT',
                buttonType: 'PANELBUTTON',
                uiactionId: 'removeselection',
                renderMode: 'BUTTON',
                tooltip: '移除选中数据',
                caption: '移除选中数据',
                itemStyle: 'DEFAULT',
                itemType: 'BUTTON',
                layoutPos: {
                  shrink: 1,
                  layout: 'FLEX',
                },
                sysImage: {
                  cssClass: 'fa fa-angle-left',
                  glyph: 'xf104@FontAwesome',
                },
                id: 'button_removeselection',
              },
            ],
            layout: {
              align: 'center',
              dir: 'column',
              layout: 'FLEX',
            },
            dataRegionType: 'INHERIT',
            caption: '容器',
            itemStyle: 'DEFAULT',
            itemType: 'CONTAINER',
            layoutPos: {
              shrink: 0,
              layout: 'FLEX',
              spacingLeft: 'OUTERMEDIUM',
              spacingRight: 'OUTERMEDIUM',
            },
            id: 'container4',
          },
          {
            actionGroupExtractMode: 'ITEM',
            panelItems: [
              {
                caption: '列表',
                itemStyle: 'DEFAULT',
                itemType: 'CTRLPOS',
                layoutPos: {
                  shrink: 1,
                  layout: 'FLEX',
                },
                showCaption: true,
                id: 'simplelist',
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
            id: 'container5',
          },
        ],
        predefinedType: 'VIEWCONTENT',
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
        id: 'view_content',
      },
      {
        actionGroupExtractMode: 'ITEM',
        panelItems: [
          {
            actionType: 'UIACTION',
            buttonStyle: 'PRIMARY',
            buttonType: 'PANELBUTTON',
            uiactionId: 'ok',
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
            uiactionId: 'cancel',
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
    controls: [
      {
        embeddedAppDEViewId: 'plmweb.article_page_baseline_mpick_up_grid_view',
        codeName: 'baseline_mpick_up_view_pickupviewpanel',
        controlType: 'PICKUPVIEWPANEL',
        appDataEntityId: 'plmweb.article_page',
        controlParam: {
          id: 'pickupviewpanel',
        },
        name: 'pickupviewpanel',
        id: 'baseline_mpick_up_view_pickupviewpanel',
      },
      {
        xdataControlName: 'treeexpbar_tree',
        enableCounter: true,
        showTitleBar: true,
        autoLoad: true,
        showBusyIndicator: true,
        appViewRefs: [
          {
            realOpenMode: 'POPUPMODAL',
            realTitle: '基线规划页面多项选择视图',
            refAppViewId: 'plmweb.article_page_baseline_mpick_up_view',
            name: 'EXPITEM:node',
            id: 'expitem:node',
          },
          {
            realOpenMode: 'POPUPMODAL',
            realTitle: '基线规划页面多项选择视图',
            refAppViewId: 'plmweb.article_page_baseline_mpick_up_view',
            name: 'EXPITEM:node_1',
            id: 'expitem:node_1',
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
                id: '默认根节点 - 空间名称',
              },
              {
                childDETreeNodeId: 'node_1',
                parentDETreeNodeId: 'node',
                parentValueLevel: 1,
                searchMode: 3,
                id: '空间名称 - 全部',
              },
            ],
            detreeNodes: [
              {
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
                appDEDataSetId: 'fetch_current',
                textAppDEFieldId: 'name',
                navAppViewId: 'plmweb.article_page_baseline_mpick_up_view',
                nodeType: 'node',
                appDataEntityId: 'plmweb.space',
                treeNodeType: 'DE',
                hasDETreeNodeRSs: true,
                disableSelect: true,
                expanded: true,
                selected: true,
                name: '空间名称',
                id: 'node',
              },
              {
                text: '全部',
                navAppViewId: 'plmweb.article_page_baseline_mpick_up_view',
                nodeType: 'node_1',
                treeNodeType: 'STATIC',
                name: '全部',
                id: 'node_1',
              },
            ],
            outputIconDefault: true,
            createControlAction: {
              appDEMethodId: 'create',
              appDataEntityId: 'plmweb.article_page',
              id: 'create',
            },
            fetchControlAction: {
              appDataEntityId: 'plmweb.article_page',
              id: 'fetch',
            },
            getControlAction: {
              appDEMethodId: 'get',
              appDataEntityId: 'plmweb.article_page',
              id: 'load',
            },
            removeControlAction: {
              appDEMethodId: 'remove',
              appDataEntityId: 'plmweb.article_page',
              id: 'remove',
            },
            updateControlAction: {
              appDEMethodId: 'update',
              appDataEntityId: 'plmweb.article_page',
              id: 'update',
            },
            autoLoad: true,
            showBusyIndicator: true,
            codeName: 'baseline_mpick_up_view_tree_view',
            controlType: 'TREEVIEW',
            logicName: '基线规划页面多项选择视图_树视图',
            appDataEntityId: 'plmweb.article_page',
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
            modelId: '3CE81251-813C-4830-9B30-222E952B635A',
            modelType: 'PSDETREEVIEW',
            name: 'treeexpbar_tree',
            id: 'plmweb.article_page.baseline_mpick_up_view_tree_view',
          },
        ],
        codeName: 'baseline_mpick_up_view_treeexpbar',
        controlType: 'TREEEXPBAR',
        appDataEntityId: 'plmweb.article_page',
        controlParam: {
          id: 'treeexpbar',
        },
        modelId: 'cf1b851113e4e56c1703e55c0d28b6de_treeexpbar',
        modelType: 'PSEXPBAR',
        name: 'treeexpbar',
        id: 'baseline_mpick_up_view_treeexpbar',
      },
      {
        groupMode: 'NONE',
        delistDataItems: [
          {
            appDEFieldId: 'id',
            dataType: 25,
            id: 'srfkey',
          },
          {
            appDEFieldId: 'name',
            dataType: 25,
            id: 'srfmajortext',
          },
          {
            appDEFieldId: 'space_id',
            dataType: 25,
            id: 'space_id',
          },
          {
            appDEFieldId: 'parent_id',
            dataType: 25,
            id: 'parent_id',
          },
        ],
        pagingSize: 1000,
        showHeader: true,
        createControlAction: {
          appDEMethodId: 'create',
          appDataEntityId: 'plmweb.article_page',
          id: 'create',
        },
        fetchControlAction: {
          appDEMethodId: 'fetch_default',
          appDataEntityId: 'plmweb.article_page',
          id: 'fetch',
        },
        getControlAction: {
          appDEMethodId: 'get',
          appDataEntityId: 'plmweb.article_page',
          id: 'load',
        },
        removeControlAction: {
          appDEMethodId: 'remove',
          appDataEntityId: 'plmweb.article_page',
          id: 'remove',
        },
        updateControlAction: {
          appDEMethodId: 'update',
          appDataEntityId: 'plmweb.article_page',
          id: 'update',
        },
        autoLoad: true,
        showBusyIndicator: true,
        codeName: 'mob',
        controlType: 'LIST',
        logicName: 'MOB',
        appDataEntityId: 'plmweb.article_page',
        controlParam: {
          id: 'simplelist',
        },
        modelId: '2d84b1fd7b1c236074af70261d2c063c',
        modelType: 'PSDELIST',
        name: 'simplelist',
        id: 'plmweb.article_page.mob',
      },
      {
        capLanguageRes: {
          lanResTag: 'DE.LNAME.PAGE',
        },
        caption: '页面',
        codeName: 'baseline_mpick_up_view_captionbar',
        controlType: 'CAPTIONBAR',
        appDataEntityId: 'plmweb.article_page',
        controlParam: {},
        name: 'captionbar',
        id: 'baseline_mpick_up_view_captionbar',
      },
    ],
    codeName: 'usr0123151638',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: '多项选择视图(左右关系)布局面板(固定左侧树宽度)',
    appDataEntityId: 'plmweb.article_page',
    controlParam: {},
    modelId: '82218f671f3810568f77706c73381de7',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'usr0123151638',
  },
  title: '基线规划页面多项选择视图',
  viewStyle: 'DEFAULT',
  viewType: 'DEMPICKUPVIEW2',
  enableDP: true,
  showCaptionBar: false,
  modelId: 'cf1b851113e4e56c1703e55c0d28b6de',
  modelType: 'PSAPPDEVIEW',
  name: 'article_pagebaseline_mpick_up_view',
  id: 'plmweb.article_page_baseline_mpick_up_view',
};