export default {
  openMode: 'POPUPMODAL',
  deviewCodeName: 'plan_work_item_pickview',
  deviewId: 'b1033a714d6c6ff3e06d4e4c8e2a128f',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.WORK_ITEM',
  },
  caption: '工作项',
  codeName: 'work_itemplan_work_item_pickview',
  appDataEntityId: 'plmweb.work_item',
  appViewNavParams: [
    {
      key: 'project',
      value: 'project',
      id: 'project',
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
        panelItems: [
          {
            panelItems: [
              {
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
            panelItems: [
              {
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
        panelItems: [
          {
            panelItems: [
              {
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
        embeddedAppDEViewId:
          'plmweb.work_itemplan_work_item_pickview_pickupgridview',
        codeName: 'plan_work_item_pickviewpickupviewpanel',
        controlType: 'PICKUPVIEWPANEL',
        appDataEntityId: 'plmweb.work_item',
        controlParam: {
          id: 'pickupviewpanel',
        },
        name: 'pickupviewpanel',
        id: 'plan_work_item_pickviewpickupviewpanel',
      },
      {
        title: '选择工作项',
        xdataControlName: 'treeexpbar_tree',
        enableCounter: true,
        showTitleBar: true,
        autoLoad: true,
        showBusyIndicator: true,
        appViewRefs: [
          {
            realTitle: '工作项变更父工作项选择视图_选择数据视图',
            refAppViewId: 'plmweb.work_itemparent_pick_up_view_pickupgridview',
            name: 'EXPITEM:node',
            id: 'expitem:node',
          },
        ],
        controls: [
          {
            detreeNodeRSs: [
              {
                childDETreeNodeId: 'node_1',
                parentDETreeNodeId: 'node',
                parentValueLevel: 1,
                searchMode: 3,
                id: '项目名称 - 最近浏览',
              },
              {
                childDETreeNodeId: 'node',
                parentDETreeNodeId: 'root',
                parentValueLevel: 1,
                searchMode: 3,
                id: '默认根节点 - 项目名称',
              },
              {
                childDETreeNodeId: 'node_2',
                parentDETreeNodeId: 'node',
                parentValueLevel: 1,
                searchMode: 3,
                id: '项目名称 - 全部',
              },
              {
                childDETreeNodeId: 'node_3',
                parentDETreeNodeId: 'node',
                parentValueLevel: 1,
                searchMode: 3,
                id: '项目名称 - 我负责的',
              },
              {
                childDETreeNodeId: 'node_5',
                parentDETreeNodeId: 'node',
                parentValueLevel: 1,
                searchMode: 3,
                id: '项目名称 - 打开的',
              },
              {
                childDETreeNodeId: 'node_6',
                parentDETreeNodeId: 'node',
                parentValueLevel: 1,
                searchMode: 3,
                id: '项目名称 - 已完成的',
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
                idAppDEFieldId: 'id',
                appDEDataSetId: 'fetchcurrent',
                textAppDEFieldId: 'name',
                navAppViewId:
                  'plmweb.work_itemparent_pick_up_view_pickupgridview',
                nodeType: 'node',
                appDataEntityId: 'plmweb.project',
                treeNodeType: 'DE',
                hasDETreeNodeRSs: true,
                expanded: true,
                selected: true,
                name: '项目名称',
                id: 'node',
              },
              {
                text: '最近浏览',
                nodeType: 'node_1',
                navigateParams: [
                  {
                    key: 'query_recent',
                    value: '1',
                    rawValue: true,
                    id: 'query_recent',
                  },
                ],
                treeNodeType: 'STATIC',
                name: '最近浏览',
                id: 'node_1',
              },
              {
                text: '全部',
                nodeType: 'node_2',
                treeNodeType: 'STATIC',
                name: '全部',
                id: 'node_2',
              },
              {
                text: '我负责的',
                nodeType: 'node_3',
                navigateParams: [
                  {
                    key: 'n_assignee_id_eq',
                    value: 'srfpersonid',
                    id: 'n_assignee_id_eq',
                  },
                ],
                treeNodeType: 'STATIC',
                name: '我负责的',
                id: 'node_3',
              },
              {
                text: '我关注的',
                nodeType: 'node_4',
                treeNodeType: 'STATIC',
                name: '我关注的',
                id: 'node_4',
              },
              {
                text: '打开的',
                nodeType: 'node_5',
                navigateParams: [
                  {
                    key: 'n_state_eq',
                    value: '10',
                    rawValue: true,
                    id: 'n_state_eq',
                  },
                ],
                treeNodeType: 'STATIC',
                name: '打开的',
                id: 'node_5',
              },
              {
                text: '已完成的',
                nodeType: 'node_6',
                navigateParams: [
                  {
                    key: 'n_state_eq',
                    value: '40',
                    rawValue: true,
                    id: 'n_state_eq',
                  },
                ],
                treeNodeType: 'STATIC',
                name: '已完成的',
                id: 'node_6',
              },
            ],
            outputIconDefault: true,
            createControlAction: {
              appDEMethodId: 'create',
              appDataEntityId: 'plmweb.work_item',
              id: 'create',
            },
            fetchControlAction: {
              appDataEntityId: 'plmweb.work_item',
              id: 'fetch',
            },
            getControlAction: {
              appDEMethodId: 'get',
              appDataEntityId: 'plmweb.work_item',
              id: 'load',
            },
            dedataImportId: 'import_work_item_waterfall',
            removeControlAction: {
              appDEMethodId: 'remove',
              appDataEntityId: 'plmweb.work_item',
              id: 'remove',
            },
            updateControlAction: {
              appDEMethodId: 'update',
              appDataEntityId: 'plmweb.work_item',
              id: 'update',
            },
            autoLoad: true,
            showBusyIndicator: true,
            codeName: 'Plan_work_item_view_TreeView',
            controlType: 'TREEVIEW',
            logicName: '规划工作项选择视图_树视图',
            appDataEntityId: 'plmweb.work_item',
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
            modelId: '0fd79d62dc9a007ecd2463c2a8774273',
            modelType: 'PSDETREEVIEW',
            name: 'treeexpbar_tree',
            id: 'plmweb.work_item.plan_work_item_view_treeview',
          },
        ],
        codeName: 'plan_work_item_pickviewtreeexpbar',
        controlType: 'TREEEXPBAR',
        appDataEntityId: 'plmweb.work_item',
        controlParam: {
          id: 'treeexpbar',
        },
        modelId: '747631dca7e56838468abd0361664612_treeexpbar',
        modelType: 'PSEXPBAR',
        name: 'treeexpbar',
        id: 'plan_work_item_pickviewtreeexpbar',
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
            appDEFieldId: 'title',
            dataType: 25,
            id: 'srfmajortext',
          },
          {
            appDEFieldId: 'state',
            dataType: 25,
            id: 'state',
          },
          {
            appDEFieldId: 'assignee_id',
            dataType: 25,
            id: 'assignee_id',
          },
          {
            appDEFieldId: 'project_id',
            dataType: 25,
            id: 'project_id',
          },
          {
            appDEFieldId: 'work_item_type_id',
            frontCodeListId: 'plmweb.projmgmt__work_item_type',
            dataType: 25,
            id: 'srfdatatype',
          },
          {
            appDEFieldId: 'work_item_type_id',
            frontCodeListId: 'plmweb.projmgmt__work_item_type',
            dataType: 25,
            id: 'work_item_type_id',
          },
          {
            appDEFieldId: 'pid',
            dataType: 25,
            id: 'pid',
          },
          {
            appDEFieldId: 'sprint_id',
            dataType: 25,
            id: 'sprint_id',
          },
          {
            appDEFieldId: 'board_id',
            dataType: 25,
            id: 'board_id',
          },
          {
            appDEFieldId: 'entry_id',
            dataType: 25,
            id: 'entry_id',
          },
          {
            appDEFieldId: 'swimlane_id',
            dataType: 25,
            id: 'swimlane_id',
          },
          {
            appDEFieldId: 'top_id',
            dataType: 25,
            id: 'top_id',
          },
          {
            appDEFieldId: 'release_id',
            dataType: 25,
            id: 'release_id',
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
          appDataEntityId: 'plmweb.work_item',
          id: 'create',
        },
        fetchControlAction: {
          appDEMethodId: 'fetchdefault',
          appDataEntityId: 'plmweb.work_item',
          id: 'fetch',
        },
        getControlAction: {
          appDEMethodId: 'get',
          appDataEntityId: 'plmweb.work_item',
          id: 'load',
        },
        dedataImportId: 'import_work_item_waterfall',
        removeControlAction: {
          appDEMethodId: 'remove',
          appDataEntityId: 'plmweb.work_item',
          id: 'remove',
        },
        updateControlAction: {
          appDEMethodId: 'update',
          appDataEntityId: 'plmweb.work_item',
          id: 'update',
        },
        autoLoad: true,
        showBusyIndicator: true,
        codeName: 'Mob',
        controlType: 'LIST',
        logicName: 'MOB',
        appDataEntityId: 'plmweb.work_item',
        controlParam: {
          id: 'simplelist',
        },
        modelId: 'b356a04867aaa17fa5e51470e1006708',
        modelType: 'PSDELIST',
        name: 'simplelist',
        id: 'plmweb.work_item.mob',
      },
      {
        capLanguageRes: {
          lanResTag: 'DE.LNAME.WORK_ITEM',
        },
        caption: '工作项',
        codeName: 'plan_work_item_pickviewcaptionbar',
        controlType: 'CAPTIONBAR',
        appDataEntityId: 'plmweb.work_item',
        controlParam: {},
        name: 'captionbar',
        id: 'plan_work_item_pickviewcaptionbar',
      },
    ],
    codeName: 'Usr0123151638',
    controlType: 'VIEWLAYOUTPANEL',
    logicName:
      'test_plan_re_test_case_prickup_view多项选择视图(左右关系)布局面板',
    appDataEntityId: 'plmweb.work_item',
    controlParam: {},
    modelId: '82218f671f3810568f77706c73381de7',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'usr0123151638',
  },
  title: '规划工作项多项选择视图',
  viewStyle: 'DEFAULT',
  viewType: 'DEMPICKUPVIEW2',
  enableDP: true,
  showCaptionBar: false,
  modelId: '747631dca7e56838468abd0361664612',
  modelType: 'PSAPPDEVIEW',
  name: 'work_itemplan_work_item_pickview',
  id: 'plmweb.work_itemplan_work_item_pickview',
};