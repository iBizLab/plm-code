export default {
  openMode: 'POPUPMODAL',
  deviewCodeName: 'project_resource_mpick_up_view',
  deviewId: 'e06118ec585ebf4008b44a5af68fcb6d',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.MEMBER',
  },
  caption: '成员设置',
  codeName: 'member_project_resource_mpick_up_view',
  appDataEntityId: 'plmweb.member',
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
                uiactionId: 'util_addselection',
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
                uiactionId: 'util_addall',
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
                uiactionId: 'util_removeall',
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
                uiactionId: 'util_removeselection',
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
            uiactionId: 'view_okaction',
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
            uiactionId: 'view_cancelaction',
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
          'plmweb.member_project_resource_mpick_up_grid_view',
        codeName: 'project_resource_mpick_up_view_pickupviewpanel',
        controlType: 'PICKUPVIEWPANEL',
        appDataEntityId: 'plmweb.member',
        controlParam: {
          id: 'pickupviewpanel',
        },
        name: 'pickupviewpanel',
        id: 'project_resource_mpick_up_view_pickupviewpanel',
      },
      {
        title: '成员管理',
        xdataControlName: 'treeexpbar_tree',
        enableCounter: true,
        showTitleBar: true,
        autoLoad: true,
        showBusyIndicator: true,
        controls: [
          {
            detreeNodeRSs: [
              {
                childDETreeNodeId: 'node',
                parentDETreeNodeId: 'root',
                parentValueLevel: 1,
                searchMode: 3,
                id: '默认根节点 - 成员',
              },
              {
                childDETreeNodeId: 'node_2',
                parentDETreeNodeId: 'node_3',
                parentValueLevel: 1,
                searchMode: 3,
                id: '团队 - 团队（动态）',
              },
              {
                childDETreeNodeId: 'node_1',
                parentDETreeNodeId: 'root',
                parentValueLevel: 1,
                searchMode: 3,
                id: '默认根节点 - 部门',
              },
              {
                childDETreeNodeId: 'node_3',
                parentDETreeNodeId: 'root',
                parentValueLevel: 1,
                searchMode: 3,
                id: '默认根节点 - 团队',
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
                text: '成员',
                nodeType: 'node',
                navigateParams: [
                  {
                    key: 'cur_project',
                    value: 'project',
                    id: 'cur_project',
                  },
                ],
                treeNodeType: 'STATIC',
                name: '成员',
                id: 'node',
              },
              {
                text: '部门',
                nodeType: 'node_1',
                navigateParams: [
                  {
                    key: 'n_department_id_eq',
                    value: 'srforgsectorid',
                    id: 'n_department_id_eq',
                  },
                ],
                treeNodeType: 'STATIC',
                name: '部门',
                id: 'node_1',
              },
              {
                dataSourceType: 'DEDATASET',
                idAppDEFieldId: 'id',
                appDEDataSetId: 'fetch_default',
                textAppDEFieldId: 'name',
                nodeType: 'node_2',
                appDataEntityId: 'plmweb.group',
                navigateParams: [
                  {
                    key: 'user_group',
                    value: 'id',
                    id: 'user_group',
                  },
                ],
                treeNodeType: 'DE',
                name: '团队（动态）',
                id: 'node_2',
              },
              {
                text: '团队',
                nodeType: 'node_3',
                treeNodeType: 'STATIC',
                hasDETreeNodeRSs: true,
                disableSelect: true,
                expanded: true,
                name: '团队',
                id: 'node_3',
              },
            ],
            outputIconDefault: true,
            navViewPos: 'NONE',
            createControlAction: {
              appDEMethodId: 'create',
              appDataEntityId: 'plmweb.member',
              id: 'create',
            },
            fetchControlAction: {
              appDataEntityId: 'plmweb.member',
              id: 'fetch',
            },
            getControlAction: {
              appDEMethodId: 'get',
              appDataEntityId: 'plmweb.member',
              id: 'load',
            },
            removeControlAction: {
              appDEMethodId: 'remove',
              appDataEntityId: 'plmweb.member',
              id: 'remove',
            },
            updateControlAction: {
              appDEMethodId: 'update',
              appDataEntityId: 'plmweb.member',
              id: 'update',
            },
            autoLoad: true,
            showBusyIndicator: true,
            codeName: 'project_resource_mpick_up_tree_view',
            controlStyle: 'GROUP_TREE',
            controlType: 'TREEVIEW',
            logicName: '项目资源成员多项选择视图_树视图',
            appDataEntityId: 'plmweb.member',
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
            modelId: 'fc95c526572150d5cae383847e3c5d54',
            modelType: 'PSDETREEVIEW',
            name: 'treeexpbar_tree',
            id: 'plmweb.member.project_resource_mpick_up_tree_view',
          },
        ],
        codeName: 'project_resource_mpick_up_view_treeexpbar',
        controlType: 'TREEEXPBAR',
        appDataEntityId: 'plmweb.member',
        controlParam: {
          id: 'treeexpbar',
        },
        modelId: '266543a4f3e0fde3313888352b337e2a_treeexpbar',
        modelType: 'PSEXPBAR',
        name: 'treeexpbar',
        id: 'project_resource_mpick_up_view_treeexpbar',
      },
      {
        groupMode: 'NONE',
        groupStyle: 'DEFAULT',
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
                    id: 'name',
                  },
                  viewFieldName: 'NAME',
                  allowEmpty: true,
                  caption: '文本(动态)',
                  itemStyle: 'DEFAULT',
                  itemType: 'FIELD',
                  layoutPos: {
                    shrink: 1,
                    layout: 'FLEX',
                  },
                  id: 'name',
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
          codeName: 'usr0530102091',
          controlType: 'PANEL',
          logicName: 'list_列表项面板',
          appDataEntityId: 'plmweb.member',
          controlParam: {},
          modelId: '2a1b8a6e629ca0de1395d4148a27f353',
          modelType: 'PSSYSVIEWPANEL',
          name: 'simplelist_itempanel',
          id: 'plmweb.member.usr0530102091',
        },
        delistDataItems: [
          {
            appDEFieldId: 'name',
            dataType: 25,
            id: 'name',
          },
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
            appDEFieldId: 'user_id',
            dataType: 25,
            id: 'user_id',
          },
          {
            appDEFieldId: 'position_id',
            dataType: 25,
            id: 'position_id',
          },
        ],
        pagingSize: 1000,
        showHeader: true,
        navViewPos: 'NONE',
        createControlAction: {
          appDEMethodId: 'create',
          appDataEntityId: 'plmweb.member',
          id: 'create',
        },
        fetchControlAction: {
          appDEMethodId: 'fetch_default',
          appDataEntityId: 'plmweb.member',
          id: 'fetch',
        },
        getControlAction: {
          appDEMethodId: 'get',
          appDataEntityId: 'plmweb.member',
          id: 'load',
        },
        removeControlAction: {
          appDEMethodId: 'remove',
          appDataEntityId: 'plmweb.member',
          id: 'remove',
        },
        updateControlAction: {
          appDEMethodId: 'update',
          appDataEntityId: 'plmweb.member',
          id: 'update',
        },
        autoLoad: true,
        showBusyIndicator: true,
        codeName: 'list',
        controlType: 'LIST',
        logicName: 'list',
        appDataEntityId: 'plmweb.member',
        controlParam: {
          id: 'simplelist',
        },
        modelId: '8887cbd965b1aaa8a2077da6e9f7e9d8',
        modelType: 'PSDELIST',
        name: 'simplelist',
        id: 'plmweb.member.list',
      },
      {
        capLanguageRes: {
          lanResTag: 'DE.LNAME.MEMBER',
        },
        caption: '成员设置',
        codeName: 'project_resource_mpick_up_view_captionbar',
        controlType: 'CAPTIONBAR',
        appDataEntityId: 'plmweb.member',
        controlParam: {},
        name: 'captionbar',
        id: 'project_resource_mpick_up_view_captionbar',
      },
    ],
    codeName: 'usr0123151638',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: '多项选择视图(左右关系)布局面板(固定左侧树宽度)',
    appDataEntityId: 'plmweb.member',
    controlParam: {},
    modelId: '82218f671f3810568f77706c73381de7',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'usr0123151638',
  },
  title: '资源成员多项选择视图',
  viewStyle: 'DEFAULT',
  viewType: 'DEMPICKUPVIEW2',
  width: 60,
  enableDP: true,
  showCaptionBar: false,
  modelId: '266543a4f3e0fde3313888352b337e2a',
  modelType: 'PSAPPDEVIEW',
  name: 'memberproject_resource_mpick_up_view',
  id: 'plmweb.member_project_resource_mpick_up_view',
};
