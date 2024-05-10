export default {
  defaultPage: true,
  capLanguageRes: {
    lanResTag: 'PAGE.CAPTION.PLMWEB.APPINDEXVIEW',
  },
  caption: '产品生命周期管理系统',
  codeName: 'app_index_view',
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
                    rawItem: {
                      predefinedType: 'NAV_POS_INDEX',
                      id: 'nav_pos_index',
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
                    id: 'nav_pos_index',
                  },
                ],
                layout: {
                  layout: 'FLEX',
                },
                dataRegionType: 'INHERIT',
                caption: '容器',
                contentHeight: 100,
                itemStyle: 'DEFAULT',
                itemType: 'CONTAINER',
                layoutPos: {
                  layoutPos: 'CENTER',
                  height: 100,
                  heightMode: 'PERCENTAGE',
                  layout: 'BORDER',
                },
                id: 'container4',
              },
            ],
            predefinedType: 'CONTAINER_SCROLL_MAIN',
            layout: {
              layout: 'BORDER',
            },
            dataRegionType: 'INHERIT',
            caption: '面板容器',
            contentWidth: 100,
            itemStyle: 'DEFAULT',
            itemType: 'CONTAINER',
            layoutPos: {
              layoutPos: 'CENTER',
              layout: 'BORDER',
              width: 100,
              widthMode: 'PERCENTAGE',
            },
            showCaption: true,
            id: 'container_scroll_main',
          },
          {
            actionGroupExtractMode: 'ITEM',
            panelItems: [
              {
                actionGroupExtractMode: 'ITEM',
                panelItems: [
                  {
                    rawItem: {
                      predefinedType: 'APP_APPTITLE',
                      rawItemHeight: 90,
                      id: 'app_apptitle',
                    },
                    caption: '应用标题',
                    contentHeight: 90,
                    height: 90,
                    itemStyle: 'DEFAULT',
                    itemType: 'RAWITEM',
                    layoutPos: {
                      shrink: 0,
                      height: 90,
                      heightMode: 'PX',
                      layout: 'FLEX',
                      widthMode: 'FULL',
                    },
                    showCaption: true,
                    id: 'app_apptitle',
                  },
                  {
                    rawItem: {
                      rawItemParams: [
                        {
                          key: 'AVATAR',
                          value: 'avatar',
                        },
                        {
                          key: 'TITLE',
                          value: 'srfusername',
                        },
                        {
                          key: 'SUBTITLE',
                          value: 'loginname',
                        },
                        {
                          key: 'NAVVIEWNAME',
                          value: 'user_info_custom_view',
                        },
                      ],
                      predefinedType: 'AUTH_USERINFO',
                      rawItemHeight: 68,
                      id: 'auth_userinfo',
                    },
                    caption: '用户信息',
                    contentHeight: 68,
                    height: 68,
                    itemStyle: 'DEFAULT',
                    itemType: 'RAWITEM',
                    layoutPos: {
                      shrink: 0,
                      height: 68,
                      heightMode: 'PX',
                      layout: 'FLEX',
                      widthMode: 'FULL',
                    },
                    sysPFPluginId: 'custom_auth_userinfo',
                    showCaption: true,
                    id: 'auth_userinfo',
                  },
                  {
                    actionGroupExtractMode: 'ITEM',
                    panelItems: [
                      {
                        actionGroupExtractMode: 'ITEM',
                        panelItems: [
                          {
                            rawItem: {
                              sysImage: {
                                imagePath: 'svg/message.svg',
                                imagePathX: 'svg/message.svg',
                              },
                              contentType: 'IMAGE',
                              predefinedType: 'USERMESSAGE',
                              id: 'usermessage',
                            },
                            caption: '消息通知',
                            itemStyle: 'DEFAULT',
                            itemType: 'RAWITEM',
                            layoutPos: {
                              shrink: 1,
                              heightMode: 'FULL',
                              layout: 'FLEX',
                              widthMode: 'FULL',
                            },
                            sysImage: {
                              imagePath: 'svg/message.svg',
                              imagePathX: 'svg/message.svg',
                            },
                            showCaption: true,
                            id: 'usermessage',
                          },
                        ],
                        layout: {
                          layout: 'FLEX',
                        },
                        dataRegionType: 'INHERIT',
                        caption: '容器',
                        contentHeight: 48,
                        contentWidth: 48,
                        height: 48,
                        itemStyle: 'DEFAULT',
                        itemType: 'CONTAINER',
                        layoutPos: {
                          shrink: 1,
                          height: 48,
                          heightMode: 'PX',
                          layout: 'FLEX',
                          width: 48,
                          widthMode: 'PX',
                        },
                        width: 48,
                        id: 'container1',
                      },
                      {
                        actionGroupExtractMode: 'ITEM',
                        panelItems: [
                          {
                            rawItem: {
                              contentType: 'IMAGE',
                              predefinedType: 'SETTING',
                              id: 'setting',
                            },
                            caption: '设置',
                            itemStyle: 'DEFAULT',
                            itemType: 'RAWITEM',
                            layoutPos: {
                              shrink: 1,
                              heightMode: 'FULL',
                              layout: 'FLEX',
                              widthMode: 'FULL',
                            },
                            showCaption: true,
                            id: 'setting',
                          },
                        ],
                        layout: {
                          layout: 'FLEX',
                        },
                        dataRegionType: 'INHERIT',
                        caption: '容器',
                        contentHeight: 48,
                        contentWidth: 48,
                        height: 48,
                        itemStyle: 'DEFAULT',
                        itemType: 'CONTAINER',
                        layoutPos: {
                          shrink: 1,
                          height: 48,
                          heightMode: 'PX',
                          layout: 'FLEX',
                          width: 48,
                          widthMode: 'PX',
                        },
                        width: 48,
                        id: 'container2',
                      },
                      {
                        actionGroupExtractMode: 'ITEM',
                        panelItems: [
                          {
                            rawItem: {
                              contentType: 'IMAGE',
                              predefinedType: 'HELPER',
                              id: 'helper',
                            },
                            caption: '帮助',
                            itemStyle: 'DEFAULT',
                            itemType: 'RAWITEM',
                            layoutPos: {
                              shrink: 1,
                              heightMode: 'FULL',
                              layout: 'FLEX',
                              widthMode: 'FULL',
                            },
                            showCaption: true,
                            id: 'helper',
                          },
                        ],
                        layout: {
                          layout: 'FLEX',
                        },
                        dataRegionType: 'INHERIT',
                        caption: '容器',
                        contentHeight: 48,
                        contentWidth: 48,
                        height: 48,
                        itemStyle: 'DEFAULT',
                        itemType: 'CONTAINER',
                        layoutPos: {
                          shrink: 1,
                          height: 48,
                          heightMode: 'PX',
                          layout: 'FLEX',
                          width: 48,
                          widthMode: 'PX',
                        },
                        width: 48,
                        id: 'container3',
                      },
                      {
                        actionGroupExtractMode: 'ITEM',
                        panelItems: [
                          {
                            rawItem: {
                              contentType: 'IMAGE',
                              predefinedType: 'CUSTOM',
                              id: 'custom',
                            },
                            caption: '自定义',
                            itemStyle: 'DEFAULT',
                            itemType: 'RAWITEM',
                            layoutPos: {
                              shrink: 1,
                              heightMode: 'FULL',
                              layout: 'FLEX',
                              widthMode: 'FULL',
                            },
                            showCaption: true,
                            id: 'custom',
                          },
                        ],
                        layout: {
                          layout: 'FLEX',
                        },
                        dataRegionType: 'INHERIT',
                        caption: '容器',
                        contentHeight: 48,
                        contentWidth: 48,
                        height: 48,
                        itemStyle: 'DEFAULT',
                        itemType: 'CONTAINER',
                        layoutPos: {
                          shrink: 1,
                          height: 48,
                          heightMode: 'PX',
                          layout: 'FLEX',
                          width: 48,
                          widthMode: 'PX',
                        },
                        width: 48,
                        id: 'container5',
                      },
                    ],
                    predefinedType: 'INDEX_ACTIONS',
                    layout: {
                      align: 'space-around',
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
                      widthMode: 'FULL',
                    },
                    id: 'indexactions',
                  },
                  {
                    actionGroupExtractMode: 'ITEM',
                    panelItems: [
                      {
                        rawItem: {
                          caption: '文本内容',
                          halign: 'LEFT',
                          renderMode: 'TEXT',
                          valign: 'MIDDLE',
                          wrapMode: 'NOWRAP',
                          contentType: 'RAW',
                          predefinedType: 'INDEX_VIEW_SEARCH',
                          id: 'index_view_search',
                        },
                        caption: '搜索栏',
                        itemStyle: 'DEFAULT',
                        itemType: 'RAWITEM',
                        layoutPos: {
                          shrink: 1,
                          layout: 'FLEX',
                        },
                        showCaption: true,
                        id: 'index_view_search',
                      },
                    ],
                    layout: {
                      align: 'center',
                      layout: 'FLEX',
                      valign: 'center',
                    },
                    dataRegionType: 'INHERIT',
                    caption: '容器',
                    contentHeight: 52,
                    height: 52,
                    itemStyle: 'DEFAULT',
                    itemType: 'CONTAINER',
                    layoutPos: {
                      shrink: 0,
                      height: 52,
                      heightMode: 'PX',
                      layout: 'FLEX',
                      widthMode: 'FULL',
                    },
                    id: 'container',
                  },
                  {
                    caption: '首页菜单',
                    itemStyle: 'DEFAULT',
                    itemType: 'CTRLPOS',
                    layoutPos: {
                      grow: 1,
                      shrink: 1,
                      layout: 'FLEX',
                      widthMode: 'FULL',
                    },
                    showCaption: true,
                    id: 'appmenu',
                  },
                ],
                predefinedType: 'AppHeader',
                layout: {
                  dir: 'column',
                  layout: 'FLEX',
                },
                dataRegionType: 'INHERIT',
                caption: '容器',
                itemStyle: 'DEFAULT',
                itemType: 'CONTAINER',
                layoutPos: {
                  layoutPos: 'CENTER',
                  heightMode: 'FULL',
                  layout: 'BORDER',
                },
                id: 'app_header',
              },
            ],
            predefinedType: 'CONTAINER_SCROLL_LEFT',
            layout: {
              layout: 'BORDER',
            },
            dataRegionType: 'INHERIT',
            caption: '面板容器',
            contentWidth: 256,
            itemStyle: 'DEFAULT',
            itemType: 'CONTAINER',
            layoutPos: {
              layoutPos: 'WEST',
              layout: 'BORDER',
              width: 256,
              widthMode: 'PX',
            },
            width: 256,
            showCaption: true,
            id: 'container_scroll_left',
          },
        ],
        predefinedType: 'CONTAINER_SCROLL',
        layout: {
          layout: 'BORDER',
        },
        dataRegionType: 'INHERIT',
        caption: '滚动条容器',
        itemStyle: 'DEFAULT',
        itemType: 'CONTAINER',
        layoutPos: {
          shrink: 1,
          layout: 'FLEX',
        },
        id: 'container_scroll1',
      },
    ],
    layoutPanel: true,
    controls: [
      {
        layoutMode: 'TABLE_24COL',
        appMenuItems: [
          {
            accUserMode: 2,
            itemType: 'MENUITEM',
            appFuncId: 'usrappfunc0412219017',
            layout: {
              columnCount: 24,
              layout: 'TABLE_24COL',
            },
            layoutPos: {
              colMD: 24,
              layout: 'TABLE_24COL',
            },
            sysImage: {
              cssClass: 'fa fa-home',
              glyph: 'xf015@FontAwesome',
            },
            openDefault: true,
            valid: true,
            capLanguageRes: {
              lanResTag: 'CONTROL.APPMENUITEM.CAPTION.PLMWEB.PLMMENU.MENUITEM1',
            },
            caption: '工作台',
            tooltip: '工作台',
            id: 'menuitem1',
          },
          {
            accUserMode: 4,
            accessKey: 'PRODUCT',
            itemType: 'MENUITEM',
            appFuncId: 'usrappfunc1211697075',
            layout: {
              columnCount: 24,
              layout: 'TABLE_24COL',
            },
            layoutPos: {
              colMD: 24,
              layout: 'TABLE_24COL',
            },
            sysImage: {
              cssClass: 'fa fa-th-large',
              glyph: 'xf009@FontAwesome',
            },
            valid: true,
            capLanguageRes: {
              lanResTag: 'CONTROL.APPMENUITEM.CAPTION.PLMWEB.PLMMENU.MENUITEM2',
            },
            caption: '产品管理',
            tooltip: '产品管理',
            id: 'menuitem2',
          },
          {
            accUserMode: 4,
            accessKey: 'PROJECT',
            itemType: 'MENUITEM',
            appFuncId: 'usrappfunc1208133626',
            layout: {
              columnCount: 24,
              layout: 'TABLE_24COL',
            },
            layoutPos: {
              colMD: 24,
              layout: 'TABLE_24COL',
            },
            sysImage: {
              cssClass: 'fa fa-file-text-o',
              glyph: 'xf0f6@FontAwesome',
            },
            valid: true,
            capLanguageRes: {
              lanResTag: 'CONTROL.APPMENUITEM.CAPTION.PLMWEB.PLMMENU.MENUITEM3',
            },
            caption: '项目管理',
            tooltip: '项目管理',
            id: 'menuitem3',
          },
          {
            accUserMode: 4,
            accessKey: 'LIBRARY',
            itemType: 'MENUITEM',
            appFuncId: 'usrappfunc1212882454',
            layout: {
              columnCount: 24,
              layout: 'TABLE_24COL',
            },
            layoutPos: {
              colMD: 24,
              layout: 'TABLE_24COL',
            },
            sysImage: {
              cssClass: 'fa fa-bug',
              glyph: 'xf188@FontAwesome',
            },
            valid: true,
            capLanguageRes: {
              lanResTag: 'CONTROL.APPMENUITEM.CAPTION.PLMWEB.PLMMENU.MENUITEM4',
            },
            caption: '测试管理',
            tooltip: '测试管理',
            id: 'menuitem4',
          },
          {
            accUserMode: 4,
            accessKey: 'SPACE',
            itemType: 'MENUITEM',
            appFuncId: 'usrappfunc0226023975',
            layout: {
              columnCount: 24,
              layout: 'TABLE_24COL',
            },
            layoutPos: {
              colMD: 24,
              layout: 'TABLE_24COL',
            },
            sysImage: {
              cssClass: 'fa fa-book',
              glyph: 'xf02d@FontAwesome',
            },
            valid: true,
            capLanguageRes: {
              lanResTag: 'CONTROL.APPMENUITEM.CAPTION.PLMWEB.PLMMENU.MENUITEM5',
            },
            caption: '知识管理',
            tooltip: '知识管理',
            id: 'menuitem5',
          },
          {
            itemType: 'MENUITEM',
            layout: {
              columnCount: 24,
              layout: 'TABLE_24COL',
            },
            layoutPos: {
              colMD: 24,
              layout: 'TABLE_24COL',
            },
            hidden: true,
            valid: true,
            capLanguageRes: {
              lanResTag: 'CONTROL.APPMENUITEM.CAPTION.PLMWEB.PLMMENU.MENUITEM6',
            },
            caption: '效能度量',
            tooltip: '效能度量',
            id: 'menuitem6',
          },
          {
            itemType: 'MENUITEM',
            layout: {
              columnCount: 24,
              layout: 'TABLE_24COL',
            },
            layoutPos: {
              colMD: 24,
              layout: 'TABLE_24COL',
            },
            hidden: true,
            valid: true,
            capLanguageRes: {
              lanResTag: 'CONTROL.APPMENUITEM.CAPTION.PLMWEB.PLMMENU.MENUITEM7',
            },
            caption: '协作空间',
            tooltip: '协作空间',
            id: 'menuitem7',
          },
          {
            accUserMode: 2,
            itemType: 'MENUITEM',
            appFuncId: 'usrappfunc0322807078',
            layout: {
              columnCount: 24,
              layout: 'TABLE_24COL',
            },
            layoutPos: {
              colMD: 24,
              layout: 'TABLE_24COL',
            },
            hidden: true,
            valid: true,
            capLanguageRes: {
              lanResTag:
                'CONTROL.APPMENUITEM.CAPTION.PLMWEB.PLMMENU.INDEX_VIEW_SEARCH',
            },
            caption: '应用搜索匹配的菜单项（勿删）',
            tooltip: '应用搜索匹配的菜单项（勿删）',
            id: 'index_view_search',
          },
          {
            accUserMode: 4,
            accessKey: 'BASE',
            itemType: 'MENUITEM',
            appFuncId: 'management',
            layout: {
              columnCount: 24,
              layout: 'TABLE_24COL',
            },
            layoutPos: {
              colMD: 24,
              layout: 'TABLE_24COL',
            },
            sysImage: {
              cssClass: 'fa fa-gears',
              glyph: 'xf085@FontAwesome',
            },
            hidden: true,
            valid: true,
            capLanguageRes: {
              lanResTag: 'CONTROL.APPMENUITEM.CAPTION.PLMWEB.PLMMENU.SETTING',
            },
            caption: '管理后台',
            tooltip: '管理后台',
            id: 'setting',
          },
          {
            itemType: 'SEPERATOR',
            layout: {
              columnCount: 24,
              layout: 'TABLE_24COL',
            },
            layoutPos: {
              colMD: 24,
              layout: 'TABLE_24COL',
            },
            valid: true,
            id: 'seperator3',
          },
          {
            accUserMode: 4,
            accessKey: 'WORKLOAD',
            itemType: 'MENUITEM',
            appFuncId: 'usrappfunc0314268816',
            layout: {
              columnCount: 24,
              layout: 'TABLE_24COL',
            },
            layoutPos: {
              colMD: 24,
              layout: 'TABLE_24COL',
            },
            sysImage: {
              cssClass: 'fa fa-clock-o',
              glyph: 'xf017@FontAwesome',
            },
            valid: true,
            capLanguageRes: {
              lanResTag: 'CONTROL.APPMENUITEM.CAPTION.PLMWEB.PLMMENU.MENUITEM9',
            },
            caption: '工时管理',
            tooltip: '工时管理',
            id: 'menuitem9',
          },
          {
            accUserMode: 2,
            itemType: 'MENUITEM',
            appFuncId: 'usrappfunc0227630913',
            layout: {
              columnCount: 24,
              layout: 'TABLE_24COL',
            },
            layoutPos: {
              colMD: 24,
              layout: 'TABLE_24COL',
            },
            sysImage: {
              cssClass: 'fa fa-rocket',
              glyph: 'xf135@FontAwesome',
            },
            valid: true,
            capLanguageRes: {
              lanResTag: 'CONTROL.APPMENUITEM.CAPTION.PLMWEB.PLMMENU.MENUITEM8',
            },
            caption: '自动化',
            tooltip: '自动化',
            id: 'menuitem8',
          },
          {
            itemType: 'MENUITEM',
            appMenuItems: [
              {
                accUserMode: 2,
                itemType: 'MENUITEM',
                appFuncId: 'usrappfunc1227100845',
                layout: {
                  columnCount: 24,
                  layout: 'TABLE_24COL',
                },
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                valid: true,
                capLanguageRes: {
                  lanResTag:
                    'CONTROL.APPMENUITEM.CAPTION.PLMWEB.PLMMENU.MENUITEM20',
                },
                caption: '测试库主数据56',
                tooltip: '测试库主数据56',
                id: 'menuitem20',
              },
              {
                accUserMode: 2,
                itemType: 'MENUITEM',
                appFuncId: 'usrappfunc0104326573',
                layout: {
                  columnCount: 24,
                  layout: 'TABLE_24COL',
                },
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                valid: true,
                capLanguageRes: {
                  lanResTag:
                    'CONTROL.APPMENUITEM.CAPTION.PLMWEB.PLMMENU.MENUITEM22',
                },
                caption: '树表测试',
                tooltip: '树表测试',
                id: 'menuitem22',
              },
              {
                accUserMode: 2,
                itemType: 'MENUITEM',
                appFuncId: 'usrappfunc0124227761',
                layout: {
                  columnCount: 24,
                  layout: 'TABLE_24COL',
                },
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                valid: true,
                capLanguageRes: {
                  lanResTag:
                    'CONTROL.APPMENUITEM.CAPTION.PLMWEB.PLMMENU.MENUITEM30',
                },
                caption: '测试动态视图',
                tooltip: '测试动态视图',
                id: 'menuitem30',
              },
              {
                accUserMode: 2,
                itemType: 'MENUITEM',
                appFuncId: 'usrappfunc0412301639',
                layout: {
                  columnCount: 24,
                  layout: 'TABLE_24COL',
                },
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                valid: true,
                capLanguageRes: {
                  lanResTag:
                    'CONTROL.APPMENUITEM.CAPTION.PLMWEB.PLMMENU.MENUITEM52',
                },
                caption: '测试报告（测试）',
                tooltip: '测试报告（测试）',
                id: 'menuitem52',
              },
              {
                accUserMode: 2,
                itemType: 'MENUITEM',
                appFuncId: 'usrappfunc0314540704',
                layout: {
                  columnCount: 24,
                  layout: 'TABLE_24COL',
                },
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                valid: true,
                capLanguageRes: {
                  lanResTag:
                    'CONTROL.APPMENUITEM.CAPTION.PLMWEB.PLMMENU.MENUITEM37',
                },
                caption: '产品配置测试',
                tooltip: '产品配置测试',
                id: 'menuitem37',
              },
              {
                accUserMode: 2,
                itemType: 'MENUITEM',
                appFuncId: 'usrappfunc0314430777',
                layout: {
                  columnCount: 24,
                  layout: 'TABLE_24COL',
                },
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                valid: true,
                capLanguageRes: {
                  lanResTag:
                    'CONTROL.APPMENUITEM.CAPTION.PLMWEB.PLMMENU.MENUITEM38',
                },
                caption: '通知列表（测试）',
                tooltip: '通知列表（测试）',
                id: 'menuitem38',
              },
              {
                accUserMode: 2,
                itemType: 'MENUITEM',
                appFuncId: 'usrappfunc0314782045',
                layout: {
                  columnCount: 24,
                  layout: 'TABLE_24COL',
                },
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                valid: true,
                capLanguageRes: {
                  lanResTag:
                    'CONTROL.APPMENUITEM.CAPTION.PLMWEB.PLMMENU.MENUITEM39',
                },
                caption: '日志列表',
                tooltip: '日志列表',
                id: 'menuitem39',
              },
              {
                accUserMode: 2,
                itemType: 'MENUITEM',
                appFuncId: 'usrappfunc0318045890',
                layout: {
                  columnCount: 24,
                  layout: 'TABLE_24COL',
                },
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                valid: true,
                capLanguageRes: {
                  lanResTag:
                    'CONTROL.APPMENUITEM.CAPTION.PLMWEB.PLMMENU.MENUITEM41',
                },
                caption: '工单测试',
                tooltip: '工单测试',
                id: 'menuitem41',
              },
              {
                accUserMode: 2,
                itemType: 'MENUITEM',
                appFuncId: 'usrappfunc0319609703',
                layout: {
                  columnCount: 24,
                  layout: 'TABLE_24COL',
                },
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                valid: true,
                capLanguageRes: {
                  lanResTag:
                    'CONTROL.APPMENUITEM.CAPTION.PLMWEB.PLMMENU.MENUITEM45',
                },
                caption: '测试库配置测试',
                tooltip: '测试库配置测试',
                id: 'menuitem45',
              },
              {
                accUserMode: 2,
                itemType: 'MENUITEM',
                appFuncId: 'usrappfunc0319810552',
                layout: {
                  columnCount: 24,
                  layout: 'TABLE_24COL',
                },
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                valid: true,
                capLanguageRes: {
                  lanResTag:
                    'CONTROL.APPMENUITEM.CAPTION.PLMWEB.PLMMENU.MENUITEM46',
                },
                caption: '测试功能_空间配置',
                tooltip: '测试功能_空间配置',
                id: 'menuitem46',
              },
              {
                accUserMode: 2,
                itemType: 'MENUITEM',
                appFuncId: 'usrappfunc0319778232',
                layout: {
                  columnCount: 24,
                  layout: 'TABLE_24COL',
                },
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                valid: true,
                capLanguageRes: {
                  lanResTag:
                    'CONTROL.APPMENUITEM.CAPTION.PLMWEB.PLMMENU.MENUITEM47',
                },
                caption: '测试功能_项目配置',
                tooltip: '测试功能_项目配置',
                id: 'menuitem47',
              },
              {
                accUserMode: 2,
                itemType: 'MENUITEM',
                appFuncId: 'usrappfunc0319178498',
                layout: {
                  columnCount: 24,
                  layout: 'TABLE_24COL',
                },
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                valid: true,
                capLanguageRes: {
                  lanResTag:
                    'CONTROL.APPMENUITEM.CAPTION.PLMWEB.PLMMENU.MENUITEM48',
                },
                caption: '测试功能_项目集配置',
                tooltip: '测试功能_项目集配置',
                id: 'menuitem48',
              },
              {
                accUserMode: 2,
                itemType: 'MENUITEM',
                appFuncId: 'usrappfunc0326620973',
                layout: {
                  columnCount: 24,
                  layout: 'TABLE_24COL',
                },
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                valid: true,
                capLanguageRes: {
                  lanResTag:
                    'CONTROL.APPMENUITEM.CAPTION.PLMWEB.PLMMENU.MENUITEM40',
                },
                caption: '测试资源报表',
                tooltip: '测试资源报表',
                id: 'menuitem40',
              },
              {
                accUserMode: 2,
                itemType: 'MENUITEM',
                appFuncId: 'usrappfunc0408117104',
                layout: {
                  columnCount: 24,
                  layout: 'TABLE_24COL',
                },
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                valid: true,
                capLanguageRes: {
                  lanResTag:
                    'CONTROL.APPMENUITEM.CAPTION.PLMWEB.PLMMENU.MENUITEM49',
                },
                caption: '测试协同编辑',
                tooltip: '测试协同编辑',
                id: 'menuitem49',
              },
              {
                accUserMode: 2,
                itemType: 'MENUITEM',
                appFuncId: 'usrappfunc0102561422',
                layout: {
                  columnCount: 24,
                  layout: 'TABLE_24COL',
                },
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                valid: true,
                capLanguageRes: {
                  lanResTag:
                    'CONTROL.APPMENUITEM.CAPTION.PLMWEB.PLMMENU.MENUITEM51',
                },
                caption: '测试功能_工作台',
                tooltip: '测试功能_工作台',
                id: 'menuitem51',
              },
              {
                accUserMode: 2,
                itemType: 'MENUITEM',
                appFuncId: 'usrappfunc0418174025',
                layout: {
                  columnCount: 24,
                  layout: 'TABLE_24COL',
                },
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                valid: true,
                capLanguageRes: {
                  lanResTag:
                    'CONTROL.APPMENUITEM.CAPTION.PLMWEB.PLMMENU.MENUITEM16',
                },
                caption: '数据字典',
                tooltip: '数据字典',
                id: 'menuitem16',
              },
              {
                accUserMode: 2,
                itemType: 'MENUITEM',
                appFuncId: 'usrappfunc0418643340',
                layout: {
                  columnCount: 24,
                  layout: 'TABLE_24COL',
                },
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                valid: true,
                capLanguageRes: {
                  lanResTag:
                    'CONTROL.APPMENUITEM.CAPTION.PLMWEB.PLMMENU.MENUITEM32',
                },
                caption: '测试功能_系统参数',
                tooltip: '测试功能_系统参数',
                id: 'menuitem32',
              },
              {
                accUserMode: 2,
                itemType: 'MENUITEM',
                appFuncId: 'usrappfunc0322807078',
                layout: {
                  columnCount: 24,
                  layout: 'TABLE_24COL',
                },
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                valid: true,
                caption: '高级搜索',
                tooltip: '高级搜索',
                id: 'menuitem10',
              },
              {
                accUserMode: 2,
                itemType: 'MENUITEM',
                appFuncId: 'usrappfunc0424497791',
                layout: {
                  columnCount: 24,
                  layout: 'TABLE_24COL',
                },
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                valid: true,
                caption: '活动列表测试',
                tooltip: '活动列表测试',
                id: 'menuitem11',
              },
              {
                accUserMode: 2,
                itemType: 'MENUITEM',
                appFuncId: 'usrappfunc0425764043',
                layout: {
                  columnCount: 24,
                  layout: 'TABLE_24COL',
                },
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                valid: true,
                caption: '项目基线对比',
                tooltip: '项目基线对比',
                id: 'menuitem12',
              },
              {
                accUserMode: 2,
                itemType: 'MENUITEM',
                appFuncId: 'usrappfunc0425742725',
                layout: {
                  columnCount: 24,
                  layout: 'TABLE_24COL',
                },
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                valid: true,
                caption: '工作项版本对比',
                tooltip: '工作项版本对比',
                id: 'menuitem13',
              },
              {
                accUserMode: 2,
                itemType: 'MENUITEM',
                appFuncId: 'usrappfunc0425317037',
                layout: {
                  columnCount: 24,
                  layout: 'TABLE_24COL',
                },
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                valid: true,
                caption: '测试日志图表',
                tooltip: '测试日志图表',
                id: 'menuitem14',
              },
            ],
            layout: {
              columnCount: 24,
              layout: 'TABLE_24COL',
            },
            layoutPos: {
              colMD: 24,
              layout: 'TABLE_24COL',
            },
            hidden: true,
            valid: true,
            capLanguageRes: {
              lanResTag:
                'CONTROL.APPMENUITEM.CAPTION.PLMWEB.PLMMENU.MENUITEM17',
            },
            caption: '测试1',
            tooltip: '测试1',
            id: 'menuitem17',
          },
        ],
        autoLoad: true,
        showBusyIndicator: true,
        codeName: 'plm_menu',
        controlType: 'APPMENU',
        logicName: '应用首页视图菜单',
        controlParam: {},
        modelId: 'd6f3ee680dcba28fdf18ee2e0f3c8026',
        modelType: 'PSAPPMENU',
        name: 'appmenu',
        id: 'plm_menu',
      },
      {
        capLanguageRes: {
          lanResTag: 'PAGE.CAPTION.PLMWEB.APPINDEXVIEW',
        },
        caption: '产品生命周期管理系统',
        codeName: 'captionbar',
        controlType: 'CAPTIONBAR',
        controlParam: {},
        id: 'captionbar',
      },
    ],
    codeName: 'usr0318426854',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: 'AppIndexView',
    controlParam: {},
    modelId: '91d6e0fbfcf63c50a84de2fd32ba33d3',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'usr0318426854',
  },
  title: 'PLM',
  titleLanguageRes: {
    lanResTag: 'PAGE.TITLE.PLMWEB.APPINDEXVIEW',
  },
  viewStyle: 'DEFAULT',
  viewType: 'APPINDEXVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: 'be89e5c6d4c8e3a56288db68be66136a',
  modelType: 'PSAPPINDEXVIEW',
  name: 'AppIndexView',
  id: 'plmweb.app_index_view',
};
