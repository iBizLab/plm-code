export default {
  loadDefault: true,
  deviewCodeName: 'index_view',
  deviewId: '4c02e76fa434536d2d6a06791d12bbb0',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'PAGE.CAPTION.SPACE.INDEX_VIEW',
  },
  caption: '空间',
  codeName: 'space_index_view',
  appDataEntityId: 'plmweb.space',
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
                    uiactionId: 'open_space_exp_page@space',
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
                      appDEDataSetId: 'fetch_normal',
                      appDataEntityId: 'plmweb.space',
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
    controls: [
      {
        createControlAction: {
          appDEMethodId: 'create',
          appDataEntityId: 'plmweb.space',
          id: 'create',
        },
        getDraftFromControlAction: {
          appDataEntityId: 'plmweb.space',
          id: 'loaddraftfrom',
        },
        getDraftControlAction: {
          appDEMethodId: 'get_draft',
          appDataEntityId: 'plmweb.space',
          id: 'loaddraft',
        },
        getControlAction: {
          appDEMethodId: 'get',
          appDataEntityId: 'plmweb.space',
          id: 'load',
        },
        removeControlAction: {
          appDEMethodId: 'remove',
          appDataEntityId: 'plmweb.space',
          id: 'remove',
        },
        updateControlAction: {
          appDEMethodId: 'update',
          appDataEntityId: 'plmweb.space',
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
                showCaption: true,
                id: 'id',
              },
            ],
            capLanguageRes: {
              lanResTag:
                'CONTROL.DEFORM.SPACE.INDEX_VIEW_FORM.FORMPAGE.FORMPAGE1',
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
        codeName: 'index_view_form',
        controlType: 'FORM',
        logicName: '空间首页视图_表单',
        appDataEntityId: 'plmweb.space',
        controlParam: {
          id: 'form',
        },
        modelId: 'a44417119f08e4a0d9d8208f6fb163f1',
        modelType: 'PSDEFORM_EDITFORM',
        name: 'form',
        id: 'plmweb.space.index_view_form',
      },
      {
        dedrbarGroups: [
          {
            caption: '页面',
            name: '页面',
            id: 'drgroup',
          },
        ],
        showTitle: true,
        editItemCapLanguageRes: {
          lanResTag: 'DE.LNAME.SPACE',
        },
        editItemCaption: '空间',
        dedrctrlItems: [
          {
            dedrbarGroupId: 'drgroup',
            caption: '页面',
            appViewId: 'plmweb.article_page_tree_exp_view',
            id: 'page',
          },
        ],
        uniqueTag: 'space_index_view__drbar',
        autoLoad: true,
        showBusyIndicator: true,
        codeName: 'index_view_dr',
        controlStyle: 'DRBAR_EX',
        controlType: 'DRBAR',
        appDataEntityId: 'plmweb.space',
        controlParam: {
          id: 'drbar',
        },
        sysPFPluginId: 'drbar_ex',
        modelId: '648f1e540a676cae9b83c11faf38ea5d',
        modelType: 'PSDEDRBAR',
        name: 'drbar',
        id: 'index_view_dr',
      },
      {
        detoolbarItems: [
          {
            actionLevel: 100,
            noPrivDisplayMode: 2,
            uiactionId: 'add_favorite@space',
            uiactionTarget: 'SINGLEKEY',
            valid: true,
            caption: '设置星标',
            itemType: 'DEUIACTION',
            controlLogics: [
              {
                itemName: 'deuiaction1',
                logicTag: 'toolbar',
                logicType: 'SCRIPT',
                scriptCode: 'data.is_favorite == 0\r\n',
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
            actionLevel: 100,
            noPrivDisplayMode: 2,
            uiactionId: 'cancel_favorite@space',
            uiactionTarget: 'SINGLEKEY',
            valid: true,
            caption: '取消星标',
            itemType: 'DEUIACTION',
            controlLogics: [
              {
                itemName: 'deuiaction2',
                logicTag: 'toolbar',
                logicType: 'SCRIPT',
                scriptCode: 'data.is_favorite == 1\r\n',
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
            detoolbarItems: [
              {
                actionLevel: 100,
                noPrivDisplayMode: 2,
                uiactionId: 'space_info@space',
                uiactionTarget: 'SINGLEKEY',
                valid: true,
                caption: '空间信息',
                itemType: 'DEUIACTION',
                sysImage: {
                  cssClass: 'fa fa-info-circle',
                  glyph: 'xf05a@FontAwesome',
                },
                tooltip: '空间信息',
                showCaption: true,
                showIcon: true,
                id: 'deuiaction3',
              },
              {
                actionLevel: 100,
                noPrivDisplayMode: 2,
                uiactionId: 'open_space_member@space',
                uiactionTarget: 'SINGLEKEY',
                valid: true,
                caption: '空间成员',
                itemType: 'DEUIACTION',
                sysImage: {
                  cssClass: 'fa fa-users',
                  glyph: 'xf0c0@FontAwesome',
                },
                tooltip: '空间成员',
                showCaption: true,
                showIcon: true,
                id: 'deuiaction4',
              },
              {
                actionLevel: 100,
                noPrivDisplayMode: 2,
                uiactionId: 'more_setting@space',
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
              {
                actionLevel: 100,
                noPrivDisplayMode: 2,
                uiactionId: 'open_deleted_view@space',
                uiactionTarget: 'SINGLEKEY',
                valid: true,
                caption: '回收站',
                itemType: 'DEUIACTION',
                sysImage: {
                  cssClass: 'fa fa-trash-o',
                  glyph: 'xf014@FontAwesome',
                },
                tooltip: '回收站',
                showCaption: true,
                showIcon: true,
                id: 'deuiaction8',
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
        codeName: 'index_view_toolbar',
        controlType: 'TOOLBAR',
        logicName: '空间主视图工具栏',
        appDataEntityId: 'plmweb.space',
        controlParam: {
          id: 'toolbar',
        },
        modelId: '6ff68b4ec59796dc91f8b16b542df42b',
        modelType: 'PSDETOOLBAR',
        name: 'toolbar',
        id: 'index_view_toolbar',
      },
      {
        capLanguageRes: {
          lanResTag: 'PAGE.CAPTION.SPACE.INDEX_VIEW',
        },
        caption: '空间',
        codeName: 'index_view_captionbar',
        controlType: 'CAPTIONBAR',
        appDataEntityId: 'plmweb.space',
        controlParam: {},
        name: 'captionbar',
        id: 'index_view_captionbar',
      },
    ],
    codeName: 'de_custom_index_view_layout_space',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: '自定义实体首页视图布局面板（知识）',
    appDataEntityId: 'plmweb.space',
    controlParam: {},
    modelId: 'b4e29cc8a99c1f75b6287d586b0e1d1e',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'de_custom_index_view_layout_space',
  },
  title: '空间',
  titleLanguageRes: {
    lanResTag: 'PAGE.TITLE.SPACE.INDEX_VIEW',
  },
  viewStyle: 'DEFAULT',
  viewType: 'DEINDEXVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: 'ff44a252dae60d878838b788688c4184',
  modelType: 'PSAPPDEVIEW',
  name: 'spaceindex_view',
  id: 'plmweb.space_index_view',
};