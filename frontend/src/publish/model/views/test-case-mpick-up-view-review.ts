export default {
  openMode: 'POPUPMODAL',
  deviewCodeName: 'mpick_up_view_review',
  deviewId: 'e6f8c7f60c896a35b3acafdd3b2e3cb4',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.TEST_CASE',
  },
  caption: '选择用例',
  codeName: 'test_case_mpick_up_view_review',
  appDataEntityId: 'plmweb.test_case',
  appViewNavParams: [
    {
      key: 'testplanid',
      value: 'test_plan',
      id: 'testplanid',
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
    appViewEngines: [
      {
        engineCat: 'VIEW',
        engineType: 'MPickupView',
        id: 'engine',
      },
    ],
    controls: [
      {
        embeddedAppDEViewId:
          'plmweb.test_case_not_add_pick_up_grid_view_review',
        codeName: 'mpick_up_view_review_pickupviewpanel',
        controlType: 'PICKUPVIEWPANEL',
        appDataEntityId: 'plmweb.test_case',
        controlParam: {
          id: 'pickupviewpanel',
        },
        name: 'pickupviewpanel',
        id: 'mpick_up_view_review_pickupviewpanel',
      },
      {
        groupMode: 'NONE',
        groupStyle: 'DEFAULT',
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
            appDEFieldId: 'maintenance_id',
            dataType: 25,
            id: 'maintenance_id',
          },
          {
            appDEFieldId: 'test_library_id',
            dataType: 25,
            id: 'test_library_id',
          },
          {
            appDEFieldId: 'suite_id',
            dataType: 25,
            id: 'suite_id',
          },
        ],
        pagingSize: 1000,
        showHeader: true,
        navViewPos: 'NONE',
        createControlAction: {
          appDEMethodId: 'create',
          appDataEntityId: 'plmweb.test_case',
          id: 'create',
        },
        fetchControlAction: {
          appDEMethodId: 'fetch_default',
          appDataEntityId: 'plmweb.test_case',
          id: 'fetch',
        },
        getControlAction: {
          appDEMethodId: 'get',
          appDataEntityId: 'plmweb.test_case',
          id: 'load',
        },
        dedataImportId: 'import_test_case',
        removeControlAction: {
          appDEMethodId: 'remove',
          appDataEntityId: 'plmweb.test_case',
          id: 'remove',
        },
        updateControlAction: {
          appDEMethodId: 'update',
          appDataEntityId: 'plmweb.test_case',
          id: 'update',
        },
        autoLoad: true,
        showBusyIndicator: true,
        codeName: 'mob',
        controlType: 'LIST',
        logicName: 'MOB',
        appDataEntityId: 'plmweb.test_case',
        controlParam: {
          id: 'simplelist',
        },
        modelId: '095add87b4538d8804c8433f32248a93',
        modelType: 'PSDELIST',
        name: 'simplelist',
        id: 'plmweb.test_case.mob',
      },
      {
        title: '选择用例',
        xdataControlName: 'treeexpbar_tree',
        enableCounter: true,
        showTitleBar: true,
        autoLoad: true,
        showBusyIndicator: true,
        appViewRefs: [
          {
            realTitle: '全部用例',
            refAppViewId: 'plmweb.test_case_all_grid_view',
            name: 'EXPITEM:node',
            id: 'expitem:node',
          },
          {
            parentDataJO: {
              srfparentdefname: 'suite_id',
            },
            realTitle: '全部用例',
            refAppViewId: 'plmweb.test_case_all_grid_view',
            name: 'EXPITEM:node_2',
            id: 'expitem:node_2',
          },
          {
            parentDataJO: {
              srfparentdefname: 'suite_id',
            },
            realTitle: '全部用例',
            refAppViewId: 'plmweb.test_case_all_grid_view',
            name: 'EXPITEM:node_3',
            id: 'expitem:node_3',
          },
          {
            realTitle: '无模块用例表格',
            refAppViewId: 'plmweb.test_case_nosuite_test_case_grid_view',
            name: 'EXPITEM:node_4',
            id: 'expitem:node_4',
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
                id: '默认根节点 - 全部用例',
              },
              {
                childDETreeNodeId: 'node_2',
                parentDETreeNodeId: 'node_1',
                parentValueLevel: 1,
                searchMode: 3,
                id: '用例模块 - 主模块',
              },
              {
                childDETreeNodeId: 'node_3',
                parentAppDEFieldId: 'pid',
                parentDER1N: {
                  masterRS: 48,
                  pickupDEFName: 'PID',
                  removeActionType: 1,
                  recursiveRS: true,
                  codeName: 'test_suite',
                  dertype: 'DER1N',
                  logicName: '模块',
                  minorCodeName: 'test_suites',
                  minorServiceCodeName: 'test_suites',
                  orderValue: 100,
                  serviceCodeName: 'test_suite',
                  name: 'DER1N_TEST_SUITE_TEST_SUITE_PID',
                  id: 'testmgmt.test_suite.der1n_test_suite_test_suite_pid',
                },
                parentDETreeNodeId: 'node_2',
                parentValueLevel: 1,
                searchMode: 3,
                id: '主模块 - 子模块',
              },
              {
                childDETreeNodeId: 'node_1',
                parentDETreeNodeId: 'root',
                parentValueLevel: 1,
                searchMode: 3,
                id: '默认根节点 - 用例模块',
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
                text: '全部用例',
                navAppViewId: 'plmweb.test_case_all_grid_view',
                nodeType: 'node',
                sysImage: {
                  cssClass: 'fa fa-list-alt',
                  glyph: 'xf022@FontAwesome',
                },
                treeNodeType: 'STATIC',
                name: '全部用例',
                id: 'node',
              },
              {
                text: '用例模块',
                nodeType: 'node_1',
                sysImage: {
                  cssClass: 'fa fa-th',
                  glyph: 'xf00a@FontAwesome',
                },
                treeNodeType: 'STATIC',
                hasDETreeNodeRSs: true,
                expandFirstOnly: true,
                expanded: true,
                name: '用例模块',
                id: 'node_1',
              },
              {
                dataSourceType: 'DEDATASET',
                idAppDEFieldId: 'id',
                appDEDataSetId: 'fetch_root',
                textAppDEFieldId: 'name',
                navFilter: 'suite_id',
                navAppViewId: 'plmweb.test_case_all_grid_view',
                nodeType: 'node_2',
                appDataEntityId: 'plmweb.test_suite',
                treeNodeType: 'DE',
                hasDETreeNodeRSs: true,
                name: '主模块',
                id: 'node_2',
              },
              {
                dataSourceType: 'DEDATASET',
                idAppDEFieldId: 'id',
                appDEDataSetId: 'fetch_default',
                textAppDEFieldId: 'name',
                navFilter: 'suite_id',
                navAppViewId: 'plmweb.test_case_all_grid_view',
                nodeType: 'node_3',
                appDataEntityId: 'plmweb.test_suite',
                sysImage: {
                  cssClass: 'fa fa-navicon',
                  glyph: 'xf0c9@FontAwesome',
                },
                treeNodeType: 'DE',
                name: '子模块',
                id: 'node_3',
              },
              {
                text: '无模块用例',
                navAppViewId: 'plmweb.test_case_nosuite_test_case_grid_view',
                nodeType: 'node_4',
                appDataEntityId: 'plmweb.test_case',
                treeNodeType: 'STATIC',
                name: '无模块用例',
                id: 'node_4',
              },
            ],
            outputIconDefault: true,
            navViewPos: 'NONE',
            createControlAction: {
              appDEMethodId: 'create',
              appDataEntityId: 'plmweb.test_case',
              id: 'create',
            },
            fetchControlAction: {
              appDataEntityId: 'plmweb.test_case',
              id: 'fetch',
            },
            getControlAction: {
              appDEMethodId: 'get',
              appDataEntityId: 'plmweb.test_case',
              id: 'load',
            },
            dedataImportId: 'import_test_case',
            removeControlAction: {
              appDEMethodId: 'remove',
              appDataEntityId: 'plmweb.test_case',
              id: 'remove',
            },
            updateControlAction: {
              appDEMethodId: 'update',
              appDataEntityId: 'plmweb.test_case',
              id: 'update',
            },
            autoLoad: true,
            showBusyIndicator: true,
            codeName: 'choose_case_tree_exp_view',
            controlStyle: 'GROUP_TREE',
            controlType: 'TREEVIEW',
            logicName: '计划关联用例多选树导航',
            appDataEntityId: 'plmweb.test_case',
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
            modelId: '74da436714f3d00de3e4a48286b1c1c1',
            modelType: 'PSDETREEVIEW',
            name: 'treeexpbar_tree',
            id: 'plmweb.test_case.choose_case_tree_exp_view',
          },
        ],
        codeName: 'mpick_up_view_review_treeexpbar',
        controlType: 'TREEEXPBAR',
        appDataEntityId: 'plmweb.test_case',
        controlParam: {
          id: 'treeexpbar',
        },
        modelId: '7f1e564cd3b4ce94119a8e7ba8040ece_treeexpbar',
        modelType: 'PSEXPBAR',
        name: 'treeexpbar',
        id: 'mpick_up_view_review_treeexpbar',
      },
      {
        capLanguageRes: {
          lanResTag: 'DE.LNAME.TEST_CASE',
        },
        caption: '选择用例',
        codeName: 'mpick_up_view_review_captionbar',
        controlType: 'CAPTIONBAR',
        appDataEntityId: 'plmweb.test_case',
        controlParam: {},
        name: 'captionbar',
        id: 'mpick_up_view_review_captionbar',
      },
    ],
    codeName: 'usr0123151638',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: '多项选择视图(左右关系)布局面板(固定左侧树宽度)',
    appDataEntityId: 'plmweb.test_case',
    controlParam: {},
    modelId: '82218f671f3810568f77706c73381de7',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'usr0123151638',
  },
  title: '用例数据多项选择视图',
  viewStyle: 'DEFAULT',
  viewType: 'DEMPICKUPVIEW',
  enableDP: true,
  showCaptionBar: false,
  modelId: '7f1e564cd3b4ce94119a8e7ba8040ece',
  modelType: 'PSAPPDEVIEW',
  name: 'test_casempick_up_view_review',
  id: 'plmweb.test_case_mpick_up_view_review',
};
