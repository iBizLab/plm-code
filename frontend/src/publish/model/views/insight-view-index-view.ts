export default {
  loadDefault: true,
  deviewCodeName: 'index_view',
  deviewId: 'CCE52FBF-F78E-49CC-8351-6AC8D7F0BE17',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'PAGE.CAPTION.INSIGHT_VIEW.INDEX_VIEW_2',
  },
  caption: '效能度量',
  codeName: 'insight_view_index_view',
  appDataEntityId: 'plmweb.insight_view',
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
                caption: '表单',
                itemStyle: 'DEFAULT',
                itemType: 'CTRLPOS',
                layoutPos: {
                  shrink: 1,
                  layout: 'FLEX',
                },
                showCaption: true,
                id: 'form',
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
              shrink: 0,
              layout: 'FLEX',
            },
            id: 'view_form',
          },
          {
            actionGroupExtractMode: 'ITEM',
            panelItems: [
              {
                actionGroupExtractMode: 'ITEM',
                panelItems: [
                  {
                    actionType: 'UIACTION',
                    buttonStyle: 'DEFAULT',
                    buttonType: 'PANELBUTTON',
                    uiactionId: 'open_insight_view_exp_page@insight_view',
                    renderMode: 'LINK',
                    tooltip: '首页',
                    uiactionTarget: 'NONE',
                    caption: '首页',
                    itemStyle: 'DEFAULT',
                    itemType: 'BUTTON',
                    layoutPos: {
                      shrink: 0,
                      layout: 'FLEX',
                    },
                    sysCss: {
                      cssName: 'big-icon',
                    },
                    sysImage: {
                      cssClass: 'fa fa-home',
                      glyph: 'xf015@FontAwesome',
                    },
                    id: 'button_calluilogic',
                  },
                  {
                    rawItem: {
                      sysImage: {
                        cssClass: 'fa fa-chevron-right',
                        glyph: 'xf054@FontAwesome',
                      },
                      contentType: 'IMAGE',
                      predefinedType: 'STATIC_IMAGE',
                      id: 'static_image',
                    },
                    caption: '图片',
                    itemStyle: 'DEFAULT',
                    itemType: 'RAWITEM',
                    layoutPos: {
                      shrink: 0,
                      layout: 'FLEX',
                      spacingLeft: 'INNERSMALL',
                      spacingRight: 'INNERSMALL',
                    },
                    sysImage: {
                      cssClass: 'fa fa-chevron-right',
                      glyph: 'xf054@FontAwesome',
                    },
                    showCaption: true,
                    id: 'static_image',
                  },
                  {
                    editor: {
                      enablePickupView: true,
                      singleSelect: true,
                      appDEACModeId: 'default',
                      appDEDataSetId: 'fetch_main',
                      appDataEntityId: 'plmweb.insight_view',
                      enableAC: true,
                      forceSelection: true,
                      showTrigger: true,
                      editorParams: {
                        ENABLESEARCH: 'TRUE',
                        AC: 'TRUE',
                        SUFFIX: 'chevron-expand-outline',
                        PICKUPVIEW: 'TRUE',
                      },
                      editorStyle: 'ROUTE',
                      editorType: 'PICKER',
                      sysPFPluginId: 'route',
                      predefinedType: 'FIELD_TEXT_DYNAMIC',
                      valueType: 'SIMPLE',
                      editable: true,
                      id: 'route_picker',
                    },
                    allowEmpty: true,
                    caption: '文本(动态)',
                    itemStyle: 'DEFAULT',
                    itemType: 'FIELD',
                    layoutPos: {
                      shrink: 1,
                      layout: 'FLEX',
                    },
                    id: 'route_picker',
                  },
                  {
                    rawItem: {
                      contentType: 'DIVIDER',
                      sysCss: {
                        cssName: 'vertical-divider',
                      },
                      predefinedType: 'DIVIDER',
                      id: 'divider',
                    },
                    caption: '分割线',
                    itemStyle: 'DEFAULT',
                    itemType: 'RAWITEM',
                    layoutPos: {
                      shrink: 0,
                      layout: 'FLEX',
                      spacingLeft: 'INNERSMALL',
                      spacingRight: 'INNERSMALL',
                    },
                    sysCss: {
                      cssName: 'vertical-divider',
                    },
                    showCaption: true,
                    id: 'divider',
                  },
                  {
                    caption: '工具栏',
                    itemStyle: 'DEFAULT',
                    itemType: 'CTRLPOS',
                    layoutPos: {
                      shrink: 1,
                      layout: 'FLEX',
                    },
                    sysCss: {
                      cssName: 'star_css',
                    },
                    showCaption: true,
                    id: 'toolbar',
                  },
                  {
                    rawItem: {
                      contentType: 'DIVIDER',
                      sysCss: {
                        cssName: 'vertical-divider',
                      },
                      predefinedType: 'DIVIDER',
                      id: 'divider1',
                    },
                    caption: '分割线',
                    itemStyle: 'DEFAULT',
                    itemType: 'RAWITEM',
                    layoutPos: {
                      shrink: 0,
                      layout: 'FLEX',
                      spacingLeft: 'INNERSMALL',
                      spacingRight: 'INNERSMALL',
                    },
                    sysCss: {
                      cssName: 'vertical-divider',
                    },
                    showCaption: true,
                    id: 'divider1',
                  },
                ],
                layout: {
                  dir: 'row',
                  layout: 'FLEX',
                  valign: 'center',
                },
                dataRegionType: 'INHERIT',
                caption: '容器',
                contentHeight: 40,
                height: 40,
                itemStyle: 'DEFAULT',
                itemType: 'CONTAINER',
                layoutPos: {
                  shrink: 0,
                  height: 40,
                  heightMode: 'PX',
                  layout: 'FLEX',
                },
                id: 'container',
              },
              {
                caption: '数据关系栏',
                itemStyle: 'DEFAULT',
                itemType: 'CTRLPOS',
                layoutPos: {
                  shrink: 1,
                  heightMode: 'FULL',
                  layout: 'FLEX',
                  widthMode: 'FULL',
                },
                showCaption: true,
                id: 'drbar',
              },
            ],
            layout: {
              dir: 'row',
              layout: 'FLEX',
            },
            dataRegionType: 'INHERIT',
            caption: '容器',
            contentHeight: 50,
            height: 50,
            itemStyle: 'DEFAULT',
            itemType: 'CONTAINER',
            layoutPos: {
              shrink: 0,
              height: 50,
              heightMode: 'PX',
              layout: 'FLEX',
            },
            sysCss: {
              cssName: 'drbar-ex-underline',
            },
            id: 'view_drbar',
          },
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
                  heightMode: 'FULL',
                  layout: 'FLEX',
                  widthMode: 'FULL',
                },
                showCaption: true,
                id: 'nav_pos',
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
            id: 'view_nav_pos',
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
    layoutPanel: true,
    appViewLogics: [
      {
        eventNames: 'onActivated',
        logicTrigger: 'VIEWEVENT',
        logicType: 'APPDEUILOGIC',
        appDEUILogicId: 'choose_template',
        appDataEntityId: 'plmweb.insight_view',
        builtinLogic: true,
        name: 'CHOOSE_TEMPLATE',
        id: 'choose_template',
      },
      {
        eventNames: 'onCreated',
        logicTrigger: 'VIEWEVENT',
        logicType: 'APPDEUILOGIC',
        appDEUILogicId: 'choose_template',
        appDataEntityId: 'plmweb.insight_view',
        builtinLogic: true,
        name: 'CHOOSE_TEMPLATE2',
        id: 'choose_template2',
      },
      {
        eventNames: 'onCreated',
        logicTrigger: 'VIEWEVENT',
        logicType: 'SCRIPT',
        scriptCode:
          "view.ctx.evt.on('onRegister', (name, c) => {\r\n    if (name === 'insight_viewcustom_view') {\r\n        if (!c.context.dyna_dashboard) {\r\n            c.context.dyna_dashboard = view.context.dyna_dashboard;\r\n        }\r\n        if (!c.context.srfdynadashboardid) {\r\n            c.context.srfdynadashboardid = view.context.srfdynadashboardid;\r\n        }\r\n    }\r\n});",
        builtinLogic: true,
        name: 'ONREGISTER',
        id: 'onregister',
      },
    ],
    controls: [
      {
        dedrbarGroups: [
          {
            caption: '仪表盘',
            name: '仪表盘',
            id: 'usrdrgroup0517936766',
          },
          {
            caption: '报表',
            name: '报表',
            id: 'usrdrgroup0517029090',
          },
        ],
        showTitle: true,
        dataRelationTag: 'index_view_DR',
        editItemCapLanguageRes: {
          lanResTag: 'DE.LNAME.INSIGHT_VIEW',
        },
        editItemCaption: '效能视图',
        dedrctrlItems: [
          {
            dedrbarGroupId: 'usrdrgroup0517936766',
            caption: '仪表盘',
            appViewId: 'plmweb.insight_view_custom_view',
            navigateContexts: [
              {
                key: 'DYNA_DASHBOARD',
                value: 'dyna_dashboard',
                name: 'DYNA_DASHBOARD',
                id: 'dyna_dashboard',
              },
            ],
            navigateParams: [
              {
                key: 'srfdynadashboardid',
                value: 'dyna_dashboard',
                id: 'srfdynadashboardid',
              },
            ],
            id: 'broad',
          },
          {
            dedrbarGroupId: 'usrdrgroup0517029090',
            caption: '报表',
            appViewId: 'plmweb.insight_report_report_tree_exp_view',
            id: 'report',
          },
        ],
        uniqueTag: 'insight_view_index_view__drbar',
        autoLoad: true,
        showBusyIndicator: true,
        codeName: 'index_view_dr',
        controlStyle: 'DRBAR_EX',
        controlType: 'DRBAR',
        appDataEntityId: 'plmweb.insight_view',
        controlParam: {
          id: 'drbar',
        },
        sysPFPluginId: 'drbar_ex',
        modelId: 'ED78DD83-E6B5-4E26-BDFA-086D0AA1F480',
        modelType: 'PSDEDRBAR',
        name: 'drbar',
        id: 'index_view_dr',
      },
      {
        createControlAction: {
          appDEMethodId: 'create',
          appDataEntityId: 'plmweb.insight_view',
          id: 'create',
        },
        getDraftFromControlAction: {
          appDataEntityId: 'plmweb.insight_view',
          id: 'loaddraftfrom',
        },
        getDraftControlAction: {
          appDEMethodId: 'get_draft',
          appDataEntityId: 'plmweb.insight_view',
          id: 'loaddraft',
        },
        getControlAction: {
          appDEMethodId: 'get',
          appDataEntityId: 'plmweb.insight_view',
          id: 'load',
        },
        removeControlAction: {
          appDEMethodId: 'remove',
          appDataEntityId: 'plmweb.insight_view',
          id: 'remove',
        },
        updateControlAction: {
          appDEMethodId: 'update',
          appDataEntityId: 'plmweb.insight_view',
          id: 'update',
        },
        deformPages: [
          {
            layout: {
              columnCount: 24,
              layout: 'TABLE_24COL',
            },
            deformDetails: [
              {
                dataType: 25,
                enableCond: 3,
                labelPos: 'LEFT',
                labelWidth: 130,
                noPrivDisplayMode: 1,
                appDEFieldId: 'id',
                editor: {
                  editorType: 'HIDDEN',
                  valueType: 'SIMPLE',
                  editable: true,
                  id: 'id',
                },
                allowEmpty: true,
                hidden: true,
                capLanguageRes: {
                  lanResTag: 'DEF.LNAME.ID',
                },
                caption: '标识',
                codeName: 'id',
                detailStyle: 'DEFAULT',
                detailType: 'FORMITEM',
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                id: 'id',
              },
            ],
            capLanguageRes: {
              lanResTag:
                'CONTROL.DEFORM.INSIGHT_VIEW.INDEX_VIEW_2_FORM.FORMPAGE.FORMPAGE1',
            },
            caption: '基本信息',
            codeName: 'formpage1',
            detailStyle: 'DEFAULT',
            detailType: 'FORMPAGE',
            id: 'formpage1',
          },
        ],
        layout: {
          columnCount: 24,
          layout: 'TABLE_24COL',
        },
        tabHeaderPos: 'TOP',
        noTabHeader: true,
        autoLoad: true,
        enableItemPrivilege: true,
        showBusyIndicator: true,
        codeName: 'index_view2_form',
        controlType: 'FORM',
        logicName: '效能度量首页视图_表单',
        appDataEntityId: 'plmweb.insight_view',
        controlParam: {
          id: 'form',
        },
        modelId: 'E250BF07-E8DF-4F49-BA92-F04DBBF57748',
        modelType: 'PSDEFORM_EDITFORM',
        name: 'form',
        id: 'plmweb.insight_view.index_view2_form',
      },
      {
        detoolbarItems: [
          {
            actionLevel: 200,
            noPrivDisplayMode: 2,
            uiactionId: 'add_favorite@insight_view',
            uiactionTarget: 'SINGLEKEY',
            valid: true,
            caption: '设置星标',
            itemType: 'DEUIACTION',
            controlLogics: [
              {
                itemName: 'deuiaction1',
                logicTag: 'toolbar',
                logicType: 'SCRIPT',
                scriptCode: 'data.is_favorite == 0',
                triggerType: 'ITEMVISIBLE',
                id: 'deuiaction1',
              },
            ],
            sysImage: {
              rawContent:
                '<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" class="design-iconfont" width="16" height="16">\n  <path d="M9.54013,6.48742551 L8,3.36677551 L6.45987,6.48742551 L3.01604,6.98784551 L5.50802,9.41692551 L4.91975,12.8468255 L8,11.2274255 L11.08025,12.8468255 L10.49195,9.41692551 L12.98395,6.98784551 L9.54013,6.48742551 Z M14.53135,6.20219551 C14.77745,6.23794551 14.87565,6.54033551 14.69765,6.71389551 L11.56645,9.76604551 L12.30565,14.0757255 C12.34765,14.3208255 12.09045,14.5077255 11.87035,14.3920255 L8,12.3572255 L4.12966,14.3920255 C3.90957,14.5077255 3.65234,14.3208255 3.69437,14.0757255 L4.43354,9.76604551 L1.30237,6.71389551 C1.12431,6.54033551 1.22256,6.23794551 1.46863,6.20219551 L5.79581,5.57341551 L7.73098,1.65232551 C7.84103,1.42934551 8.15898,1.42935551 8.26902,1.65232551 L10.20415,5.57341551 L14.53135,6.20219551 Z" fill-opacity=".9" fill="#557DA5" fill-rule="nonzero"></path>\n</svg>',
            },
            tooltip: '星标',
            showIcon: true,
            id: 'deuiaction1',
          },
          {
            actionLevel: 250,
            noPrivDisplayMode: 2,
            uiactionId: 'cancel_favorite@insight_view',
            uiactionTarget: 'SINGLEKEY',
            valid: true,
            caption: '取消星标',
            itemType: 'DEUIACTION',
            controlLogics: [
              {
                itemName: 'deuiaction2',
                logicTag: 'toolbar',
                logicType: 'SCRIPT',
                scriptCode: 'data.is_favorite == 1',
                triggerType: 'ITEMVISIBLE',
                id: 'deuiaction2',
              },
            ],
            sysImage: {
              rawContent:
                '<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" class="design-iconfont" width="16" height="16">\n  <path d="M14.53135,6.20219551 C14.77745,6.23794551 14.87565,6.54033551 14.69765,6.71389551 L11.56645,9.76604551 L12.30565,14.0757255 C12.34765,14.3208255 12.09045,14.5077255 11.87035,14.3920255 L8,12.3572255 L4.12966,14.3920255 C3.90957,14.5077255 3.65234,14.3208255 3.69437,14.0757255 L4.43354,9.76604551 L1.30237,6.71389551 C1.12431,6.54033551 1.22256,6.23794551 1.46863,6.20219551 L5.79581,5.57341551 L7.73098,1.65232551 C7.84103,1.42934551 8.15898,1.42935551 8.26902,1.65232551 L10.20415,5.57341551 L14.53135,6.20219551 Z" fill-opacity=".9" fill="#FFB31A" fill-rule="nonzero"></path>\n</svg>',
            },
            tooltip: '取消星标',
            showIcon: true,
            id: 'deuiaction2',
          },
          {
            actionLevel: 100,
            detoolbarItems: [
              {
                actionLevel: 100,
                noPrivDisplayMode: 2,
                uiactionId: 'open_show_view@insight_view',
                uiactionTarget: 'SINGLEKEY',
                valid: true,
                caption: '视图信息',
                itemType: 'DEUIACTION',
                sysImage: {
                  cssClass: 'fa fa-info-circle',
                  glyph: 'xf05a@FontAwesome',
                },
                tooltip: '视图信息',
                showCaption: true,
                showIcon: true,
                id: 'deuiaction3',
              },
              {
                actionLevel: 100,
                noPrivDisplayMode: 2,
                uiactionId: 'open_insight_member@insight_view',
                uiactionTarget: 'SINGLEKEY',
                valid: true,
                caption: '视图成员',
                itemType: 'DEUIACTION',
                sysImage: {
                  cssClass: 'fa fa-users',
                  glyph: 'xf0c0@FontAwesome',
                },
                tooltip: '视图成员',
                showCaption: true,
                showIcon: true,
                id: 'deuiaction4',
              },
              {
                actionLevel: 100,
                noPrivDisplayMode: 2,
                uiactionId: 'open_edit_view@insight_view',
                uiactionTarget: 'SINGLEKEY',
                valid: true,
                caption: '编辑基本信息',
                itemType: 'DEUIACTION',
                sysImage: {
                  cssClass: 'fa fa-edit',
                  glyph: 'xf044@FontAwesome',
                },
                tooltip: '编辑基本信息',
                showCaption: true,
                showIcon: true,
                id: 'deuiaction5',
              },
              {
                actionLevel: 100,
                noPrivDisplayMode: 2,
                uiactionId: 'copy_view@insight_view',
                uiactionTarget: 'SINGLEKEY',
                hiddenItem: true,
                valid: true,
                caption: '复制视图',
                itemType: 'DEUIACTION',
                sysImage: {
                  cssClass: 'fa fa-copy',
                  glyph: 'xf0c5@FontAwesome',
                },
                tooltip: '复制视图',
                showCaption: true,
                showIcon: true,
                id: 'deuiaction6',
              },
              {
                actionLevel: 100,
                noPrivDisplayMode: 2,
                uiactionId: 'open_setting_view@insight_view',
                uiactionTarget: 'SINGLEKEY',
                valid: true,
                caption: '更多设置',
                itemType: 'DEUIACTION',
                sysImage: {
                  cssClass: 'fa fa-th-list',
                  glyph: 'xf00b@FontAwesome',
                },
                tooltip: '更多设置',
                showCaption: true,
                showIcon: true,
                id: 'deuiaction7',
              },
            ],
            valid: true,
            caption: '更多',
            itemType: 'ITEMS',
            sysImage: {
              cssClass: 'fa fa-exchange',
              glyph: 'xf0ec@FontAwesome',
            },
            tooltip: '更多',
            showIcon: true,
            id: 'items1',
          },
        ],
        toolbarStyle: 'USER',
        codeName: 'index_view_toolbar',
        controlType: 'TOOLBAR',
        logicName: '效能度量视图主视图工具栏',
        appDataEntityId: 'plmweb.insight_view',
        controlParam: {
          id: 'toolbar',
        },
        modelId: '9D6065D4-DBB1-4A23-B3B4-4C24036F3801',
        modelType: 'PSDETOOLBAR',
        name: 'toolbar',
        id: 'index_view_toolbar',
      },
      {
        capLanguageRes: {
          lanResTag: 'PAGE.CAPTION.INSIGHT_VIEW.INDEX_VIEW_2',
        },
        caption: '效能度量',
        codeName: 'index_view_captionbar',
        controlType: 'CAPTIONBAR',
        appDataEntityId: 'plmweb.insight_view',
        controlParam: {},
        name: 'captionbar',
        id: 'index_view_captionbar',
      },
    ],
    codeName: 'de_custom_index_view_layout_insight',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: '自定义实体首页视图布局面板（页面）',
    appDataEntityId: 'plmweb.insight_view',
    controlParam: {},
    modelId: 'd91026ed94da821c0132ca3b9d0b5fc8',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'de_custom_index_view_layout_insight',
  },
  title: '效能度量首页',
  titleLanguageRes: {
    lanResTag: 'PAGE.TITLE.INSIGHT_VIEW.INDEX_VIEW_2',
  },
  viewStyle: 'DEFAULT',
  viewType: 'DEINDEXVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: 'd6857dec5552af27a5188cbfbdab3046',
  modelType: 'PSAPPDEVIEW',
  name: 'insight_viewindex_view',
  id: 'plmweb.insight_view_index_view',
};