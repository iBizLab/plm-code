export default {
  deviewCodeName: 'idea_re_ticket_pick_up_view',
  deviewId: 'a94437df76bf25e1c6c0c400b7547dc5',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.TICKET',
  },
  caption: '工单',
  codeName: 'ticket_idea_re_ticket_pick_up_view',
  appDataEntityId: 'plmweb.ticket',
  controls: [
    {
      embeddedAppDEViewId: 'plmweb.ticket_others_re_ticket_mpick_up_grid_view',
      codeName: 'idea_re_ticket_pick_up_view_pickupviewpanel',
      controlType: 'PICKUPVIEWPANEL',
      appDataEntityId: 'plmweb.ticket',
      controlParam: {
        id: 'pickupviewpanel',
      },
      name: 'pickupviewpanel',
      id: 'idea_re_ticket_pick_up_view_pickupviewpanel',
    },
    {
      title: '选择工单',
      xdataControlName: 'treeexpbar_tree',
      enableCounter: true,
      showTitleBar: true,
      autoLoad: true,
      showBusyIndicator: true,
      appViewRefs: [
        {
          parentDataJO: {
            size: '10',
          },
          realTitle: '全部工单',
          refAppViewId: 'plmweb.ticket_all_grid_view',
          viewParamJO: {
            size: '10',
          },
          name: 'EXPITEM:node',
          id: 'expitem:node',
        },
        {
          realTitle: '全部工单',
          refAppViewId: 'plmweb.ticket_all_grid_view',
          name: 'EXPITEM:node_1',
          id: 'expitem:node_1',
        },
        {
          realTitle: '全部工单',
          refAppViewId: 'plmweb.ticket_all_grid_view',
          name: 'EXPITEM:node_2',
          id: 'expitem:node_2',
        },
        {
          realTitle: '全部工单',
          refAppViewId: 'plmweb.ticket_all_grid_view',
          name: 'EXPITEM:node_3',
          id: 'expitem:node_3',
        },
        {
          realTitle: '全部工单',
          refAppViewId: 'plmweb.ticket_all_grid_view',
          name: 'EXPITEM:node_4',
          id: 'expitem:node_4',
        },
        {
          parentDataJO: {
            n_state_eq: '40',
          },
          realTitle: '全部工单',
          refAppViewId: 'plmweb.ticket_all_grid_view',
          viewParamJO: {
            n_state_eq: '40',
          },
          name: 'EXPITEM:node_5',
          id: 'expitem:node_5',
        },
      ],
      controls: [
        {
          detreeNodeRSs: [
            {
              childDETreeNodeId: 'node',
              parentDETreeNodeId: 'node_6',
              parentValueLevel: 1,
              searchMode: 3,
              id: '产品 - 最近浏览',
            },
            {
              childDETreeNodeId: 'node_1',
              parentDETreeNodeId: 'node_6',
              parentValueLevel: 1,
              searchMode: 3,
              id: '产品 - 全部',
            },
            {
              childDETreeNodeId: 'node_2',
              parentDETreeNodeId: 'node_6',
              parentValueLevel: 1,
              searchMode: 3,
              id: '产品 - 我负责的',
            },
            {
              childDETreeNodeId: 'node_3',
              parentDETreeNodeId: 'node_6',
              parentValueLevel: 1,
              searchMode: 3,
              id: '产品 - 我关注的',
            },
            {
              childDETreeNodeId: 'node_4',
              parentDETreeNodeId: 'node_6',
              parentValueLevel: 1,
              searchMode: 3,
              id: '产品 - 打开的',
            },
            {
              childDETreeNodeId: 'node_5',
              parentDETreeNodeId: 'node_6',
              parentValueLevel: 1,
              searchMode: 3,
              id: '产品 - 已完成的',
            },
            {
              childDETreeNodeId: 'node_6',
              navigateParams: [
                {
                  key: 'n_id_eq',
                  value: 'product_id',
                  id: 'n_id_eq',
                },
              ],
              parentDETreeNodeId: 'root',
              parentValueLevel: 1,
              searchMode: 3,
              id: '默认根节点 - 产品',
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
              text: '最近浏览',
              navAppViewId: 'plmweb.ticket_all_grid_view',
              navViewParamJO: {
                size: '10',
              },
              nodeType: 'node',
              navigateParams: [
                {
                  key: 'size',
                  value: '10',
                  rawValue: true,
                  id: 'size',
                },
              ],
              sysImage: {
                cssClass: 'fa fa-align-right',
                glyph: 'xf038@FontAwesome',
              },
              treeNodeType: 'STATIC',
              name: '最近浏览',
              id: 'node',
            },
            {
              text: '全部',
              navAppViewId: 'plmweb.ticket_all_grid_view',
              nodeType: 'node_1',
              sysImage: {
                cssClass: 'fa fa-th-large',
                glyph: 'xf009@FontAwesome',
              },
              treeNodeType: 'STATIC',
              name: '全部',
              id: 'node_1',
            },
            {
              text: '我负责的',
              navAppViewId: 'plmweb.ticket_all_grid_view',
              nodeType: 'node_2',
              navigateParams: [
                {
                  key: 'n_assignee_id_eq',
                  value: 'srfpersonid',
                  id: 'n_assignee_id_eq',
                },
              ],
              sysImage: {
                cssClass: 'fa fa-user',
                glyph: 'xf007@FontAwesome',
              },
              treeNodeType: 'STATIC',
              name: '我负责的',
              id: 'node_2',
            },
            {
              text: '我关注的',
              navAppViewId: 'plmweb.ticket_all_grid_view',
              nodeType: 'node_3',
              sysImage: {
                cssClass: 'fa fa-user-plus',
                glyph: 'xf234@FontAwesome',
              },
              treeNodeType: 'STATIC',
              name: '我关注的',
              id: 'node_3',
            },
            {
              text: '打开的',
              navAppViewId: 'plmweb.ticket_all_grid_view',
              nodeType: 'node_4',
              navigateParams: [
                {
                  key: 'n_state_noteq',
                  value: '50',
                  rawValue: true,
                  id: 'n_state_noteq',
                },
              ],
              sysImage: {
                cssClass: 'fa fa-paper-plane-o',
                glyph: 'xf1d9@FontAwesome',
              },
              treeNodeType: 'STATIC',
              name: '打开的',
              id: 'node_4',
            },
            {
              text: '已完成的',
              navAppViewId: 'plmweb.ticket_all_grid_view',
              navViewParamJO: {
                n_state_eq: '40',
              },
              nodeType: 'node_5',
              navigateParams: [
                {
                  key: 'n_state_eq',
                  value: '40',
                  rawValue: true,
                  id: 'n_state_eq',
                },
              ],
              sysImage: {
                cssClass: 'fa fa-thumbs-up',
                glyph: 'xf164@FontAwesome',
              },
              treeNodeType: 'STATIC',
              name: '已完成的',
              id: 'node_5',
            },
            {
              idAppDEFieldId: 'id',
              appDEDataSetId: 'fetch_normal',
              textAppDEFieldId: 'name',
              nodeType: 'node_6',
              appDataEntityId: 'plmweb.product',
              treeNodeType: 'DE',
              hasDETreeNodeRSs: true,
              enableQuickSearch: true,
              expanded: true,
              name: '产品',
              id: 'node_6',
            },
          ],
          outputIconDefault: true,
          createControlAction: {
            appDEMethodId: 'create',
            appDataEntityId: 'plmweb.ticket',
            id: 'create',
          },
          fetchControlAction: {
            appDataEntityId: 'plmweb.ticket',
            id: 'fetch',
          },
          getControlAction: {
            appDEMethodId: 'get',
            appDataEntityId: 'plmweb.ticket',
            id: 'load',
          },
          dedataImportId: 'import_ticket',
          removeControlAction: {
            appDEMethodId: 'remove',
            appDataEntityId: 'plmweb.ticket',
            id: 'remove',
          },
          updateControlAction: {
            appDEMethodId: 'update',
            appDataEntityId: 'plmweb.ticket',
            id: 'update',
          },
          autoLoad: true,
          showBusyIndicator: true,
          codeName: 'this_product_ticket_tree',
          controlStyle: 'GROUP_TREE',
          controlType: 'TREEVIEW',
          logicName: '当前产品内工单树导航',
          appDataEntityId: 'plmweb.ticket',
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
          sysPFPluginId: 'group_tree',
          modelId: '3e488ee9f1b6d30c1b61183b6b1e3d8c',
          modelType: 'PSDETREEVIEW',
          name: 'treeexpbar_tree',
          id: 'plmweb.ticket.this_product_ticket_tree',
        },
      ],
      codeName: 'idea_re_ticket_pick_up_view_treeexpbar',
      controlType: 'TREEEXPBAR',
      appDataEntityId: 'plmweb.ticket',
      controlParam: {
        id: 'treeexpbar',
      },
      modelId: 'd0e377a0adea13b4670e0a9583456325_treeexpbar',
      modelType: 'PSEXPBAR',
      name: 'treeexpbar',
      id: 'idea_re_ticket_pick_up_view_treeexpbar',
    },
    {
      groupMode: 'NONE',
      itemLayoutPanel: {
        layoutMode: 'TABLE_24COL',
        layout: {
          columnCount: 24,
          layout: 'TABLE_24COL',
        },
        rootPanelItems: [
          {
            actionGroupExtractMode: 'ITEM',
            panelItems: [
              {
                editor: {
                  halign: 'LEFT',
                  renderMode: 'TEXT_DYNAMIC',
                  valign: 'MIDDLE',
                  wrapMode: 'NOWRAP',
                  editorType: 'SPAN',
                  predefinedType: 'FIELD_TEXT_DYNAMIC',
                  valueType: 'SIMPLE',
                  editable: true,
                  id: 'title',
                },
                viewFieldName: 'TITLE',
                allowEmpty: true,
                caption: '文本(动态)',
                itemStyle: 'DEFAULT',
                itemType: 'FIELD',
                layoutPos: {
                  shrink: 1,
                  layout: 'FLEX',
                },
                id: 'title',
              },
            ],
            layout: {
              dir: 'column',
              layout: 'FLEX',
            },
            dataRegionType: 'INHERIT',
            itemStyle: 'DEFAULT',
            itemType: 'CONTAINER',
            layoutPos: {
              colMD: 24,
              layout: 'TABLE_24COL',
            },
            id: 'page_container',
          },
        ],
        codeName: 'usr1225787442',
        controlType: 'PANEL',
        logicName: 'simplelist_列表项面板',
        appDataEntityId: 'plmweb.ticket',
        controlParam: {},
        modelId: 'eb3d08a33562859e5a0bafe3618b6627',
        modelType: 'PSSYSVIEWPANEL',
        name: 'simplelist_itempanel',
        id: 'plmweb.ticket.usr1225787442',
      },
      delistDataItems: [
        {
          appDEFieldId: 'id',
          dataType: 25,
          id: 'srfkey',
        },
        {
          appDEFieldId: 'title',
          dataType: 25,
          id: 'srfmajortext',
        },
        {
          appDEFieldId: 'assignee_id',
          dataType: 25,
          id: 'assignee_id',
        },
        {
          appDEFieldId: 'product_id',
          dataType: 25,
          id: 'product_id',
        },
        {
          appDEFieldId: 'customer_id',
          dataType: 25,
          id: 'customer_id',
        },
        {
          dataType: 25,
          id: 'srfmstag',
        },
      ],
      pagingSize: 1000,
      showHeader: true,
      createControlAction: {
        appDEMethodId: 'create',
        appDataEntityId: 'plmweb.ticket',
        id: 'create',
      },
      fetchControlAction: {
        appDEMethodId: 'fetch_default',
        appDataEntityId: 'plmweb.ticket',
        id: 'fetch',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.ticket',
        id: 'load',
      },
      dedataImportId: 'import_ticket',
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.ticket',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.ticket',
        id: 'update',
      },
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'simplelist',
      controlStyle: 'SAMPLE_LIST',
      controlType: 'LIST',
      logicName: 'simplelist',
      appDataEntityId: 'plmweb.ticket',
      controlParam: {
        id: 'simplelist',
      },
      sysPFPluginId: 'sample_list',
      modelId: 'e04b0e7b3bb3cba4388ddd4905bd1e12',
      modelType: 'PSDELIST',
      name: 'simplelist',
      id: 'plmweb.ticket.simplelist',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.TICKET',
      },
      caption: '工单',
      codeName: 'idea_re_ticket_pick_up_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.ticket',
      controlParam: {},
      name: 'captionbar',
      id: 'idea_re_ticket_pick_up_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutMode: 'Flex',
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
                rawItem: {
                  caption: '已选择：',
                  halign: 'LEFT',
                  renderMode: 'PARAGRAPH',
                  valign: 'MIDDLE',
                  wrapMode: 'NOWRAP',
                  contentType: 'RAW',
                  predefinedType: 'STATIC_LABEL',
                  id: 'static_label',
                },
                caption: '标签',
                itemStyle: 'DEFAULT',
                itemType: 'RAWITEM',
                layoutPos: {
                  shrink: 0,
                  layout: 'FLEX',
                  spacingRight: 'OUTERSMALL',
                },
                showCaption: true,
                id: 'static_label',
              },
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
              dir: 'row',
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
              widthMode: 'FULL',
            },
            width: 300,
            id: 'container5',
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
    codeName: 'ex_m_pickup_view2_layout',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: '多项数据选择视图(左右关系)布局面板(扩展)',
    appDataEntityId: 'plmweb.ticket',
    controlParam: {},
    modelId: '1846bc936df8e5bd158805cd594484b3',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'ex_m_pickup_view2_layout',
  },
  title: '产品关联工单多项选择视图',
  viewStyle: 'DEFAULT',
  viewType: 'DEMPICKUPVIEW2',
  enableDP: true,
  showCaptionBar: false,
  modelId: 'd0e377a0adea13b4670e0a9583456325',
  modelType: 'PSAPPDEVIEW',
  name: 'ticketidea_re_ticket_pick_up_view',
  id: 'plmweb.ticket_idea_re_ticket_pick_up_view',
};