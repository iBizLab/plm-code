export default {
  xdataControlName: 'list',
  loadDefault: true,
  deviewCodeName: 'shared_page_list_view',
  deviewId: 'a0dee16f7ce6dbfa096d04a88a4ce85a',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.MEMBER',
  },
  caption: '成员',
  codeName: 'member_shared_page_list_view',
  appDataEntityId: 'plmweb.member',
  appViewNavParams: [
    {
      key: 'shared_page',
      value: 'article_page',
      id: 'shared_page',
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
            caption: '搜索表单',
            itemStyle: 'DEFAULT',
            itemType: 'CTRLPOS',
            layoutPos: {
              shrink: 1,
              layout: 'FLEX',
            },
            showCaption: true,
            id: 'searchform',
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
          shrink: 0,
          layout: 'FLEX',
        },
        id: 'view_searchform',
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
                    editor: {
                      singleSelect: true,
                      enableAC: true,
                      forceSelection: true,
                      showTrigger: true,
                      valueItemName: 'choose_member_ids',
                      editorParams: {
                        ISSHOWTAB: 'false',
                        MULTIPLE: 'true',
                        'srfnavparam.shared_page': '%article_page%',
                        'srfnavparam.space_id': '%space_id%',
                        AC: 'TRUE',
                        TRIGGER: 'TRUE',
                        URL: '/users/fetch_not_space_mmeber',
                        PICKUPVIEW: 'FALSE',
                        USERMETHOD: 'post',
                        USERMAP: '{"id":"id","name":"display_name"}',
                      },
                      editorStyle: 'NOT_SPACE_MEMBER_SELECT',
                      editorType: 'PICKEREX_TRIGGER',
                      sysPFPluginId: 'person_select',
                      placeHolder: '选择成员',
                      predefinedType: 'FIELD_TEXT_DYNAMIC',
                      valueType: 'SIMPLE',
                      editable: true,
                      navigateParams: [
                        {
                          key: 'shared_page',
                          value: 'article_page',
                          id: 'shared_page',
                        },
                        {
                          key: 'space_id',
                          value: 'space_id',
                          id: 'space_id',
                        },
                      ],
                      id: 'choose_member',
                    },
                    viewFieldName: 'CHOOSE_MEMBER',
                    allowEmpty: true,
                    caption: '面板属性',
                    itemStyle: 'DEFAULT',
                    itemType: 'FIELD',
                    layoutPos: {
                      colMD: 24,
                      layout: 'TABLE_24COL',
                      spacingTop: 'OUTERSMALL',
                      valignSelf: 'MIDDLE',
                    },
                    id: 'choose_member',
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
                  grow: 8,
                  shrink: 1,
                  layout: 'SIMPLEFLEX',
                },
                id: 'container1',
              },
              {
                actionGroupExtractMode: 'ITEM',
                panelItems: [
                  {
                    editor: {
                      singleSelect: true,
                      appCodeListId: 'plmweb.wiki__shared_page_check_type',
                      editorType: 'DROPDOWNLIST',
                      valueType: 'SIMPLE',
                      editable: true,
                      id: 'check_type',
                    },
                    viewFieldName: 'check_type',
                    allowEmpty: true,
                    caption: '面板属性',
                    itemStyle: 'DEFAULT',
                    itemType: 'FIELD',
                    layoutPos: {
                      colMD: 24,
                      layout: 'TABLE_24COL',
                      spacingTop: 'OUTERSMALL',
                      valignSelf: 'MIDDLE',
                    },
                    id: 'check_type',
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
                  grow: 2,
                  shrink: 1,
                  layout: 'SIMPLEFLEX',
                },
                id: 'container2',
              },
              {
                actionGroupExtractMode: 'ITEM',
                panelItems: [
                  {
                    actionType: 'NONE',
                    buttonStyle: 'DEFAULT',
                    buttonType: 'PANELBUTTON',
                    renderMode: 'BUTTON',
                    tooltip: '添加',
                    uiactionTarget: 'NONE',
                    caption: '添加',
                    itemStyle: 'DEFAULT',
                    itemType: 'BUTTON',
                    layoutPos: {
                      colMD: 24,
                      layout: 'TABLE_24COL',
                      spacingBottom: 'OUTERSMALL',
                    },
                    showCaption: true,
                    id: 'button_calluilogic',
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
                  grow: 2,
                  shrink: 1,
                  layout: 'SIMPLEFLEX',
                },
                id: 'container3',
              },
            ],
            predefinedType: 'CONTAINER_GRID',
            layout: {
              layout: 'SIMPLEFLEX',
            },
            dataRegionType: 'INHERIT',
            caption: '栅格容器',
            itemStyle: 'DEFAULT',
            itemType: 'CONTAINER',
            layoutPos: {
              shrink: 1,
              layout: 'FLEX',
            },
            id: 'container_grid',
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
        id: 'container',
      },
      {
        actionGroupExtractMode: 'ITEM',
        panelItems: [
          {
            caption: '列表',
            itemStyle: 'DEFAULT',
            itemType: 'CTRLPOS',
            layoutPos: {
              grow: 1,
              shrink: 1,
              layout: 'FLEX',
            },
            showCaption: true,
            id: 'list',
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
    appViewEngines: [
      {
        engineCat: 'VIEW',
        engineType: 'ListView',
        id: 'engine',
      },
    ],
    appViewLogics: [
      {
        eventNames: 'onMounted',
        logicTrigger: 'VIEWEVENT',
        logicType: 'SCRIPT',
        scriptCode:
          "view.layoutPanel.panelItems.check_type.setDataValue('reader');\r\n",
        builtinLogic: true,
        name: 'LOGIC',
        id: 'logic',
      },
      {
        logicTrigger: 'CUSTOM',
        logicType: 'APPUILOGIC',
        builtinAppUILogic: {
          actionAfterWizard: 'DEFAULT',
          newDataAppView: {
            refAppViewId: 'plmweb.member_edit_view',
          },
          appUILogicRefViews: [
            {
              refAppViewId: 'plmweb.member_edit_view',
            },
          ],
          builtinLogic: true,
          logicType: 'PREDEFINED',
          viewLogicType: 'APP_NEWDATA',
          id: '新建数据',
        },
        builtinLogic: true,
        id: 'newdata',
      },
      {
        logicTrigger: 'CUSTOM',
        logicType: 'APPUILOGIC',
        builtinAppUILogic: {
          openDataAppView: {
            refAppViewId: 'plmweb.member_edit_view',
          },
          editMode: true,
          appUILogicRefViews: [
            {
              refAppViewId: 'plmweb.member_edit_view',
            },
          ],
          builtinLogic: true,
          logicType: 'PREDEFINED',
          viewLogicType: 'APP_OPENDATA',
          id: '打开数据',
        },
        builtinLogic: true,
        id: 'opendata',
      },
    ],
    appViewRefs: [
      {
        realTitle: '成员编辑视图',
        realTitleLanguageRes: {
          lanResTag: 'PAGE.TITLE.MEMBER.EDITVIEW',
        },
        refAppViewId: 'plmweb.member_edit_view',
        name: 'NEWDATA',
        id: 'newdata',
      },
      {
        realTitle: '成员编辑视图',
        realTitleLanguageRes: {
          lanResTag: 'PAGE.TITLE.MEMBER.EDITVIEW',
        },
        refAppViewId: 'plmweb.member_edit_view',
        name: 'EDITDATA',
        id: 'editdata',
      },
    ],
    controls: [
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
                  actionGroupExtractMode: 'ITEM',
                  panelItems: [
                    {
                      editor: {
                        halign: 'LEFT',
                        renderMode: 'TEXT_DYNAMIC',
                        valign: 'MIDDLE',
                        wrapMode: 'NOWRAP',
                        appCodeListId: 'plmweb.sysoperator',
                        editorStyle: 'PERSONNEL_INFO',
                        editorType: 'SPAN',
                        sysPFPluginId: 'personnel_info',
                        predefinedType: 'FIELD_TEXT_DYNAMIC',
                        valueType: 'SIMPLE',
                        editable: true,
                        id: 'user_id',
                      },
                      viewFieldName: 'USER_ID',
                      allowEmpty: true,
                      convertToCodeItemText: true,
                      caption: '文本(动态)',
                      itemStyle: 'DEFAULT',
                      itemType: 'FIELD',
                      layoutPos: {
                        shrink: 1,
                        layout: 'FLEX',
                      },
                      id: 'user_id',
                    },
                    {
                      actionGroupExtractMode: 'ITEM',
                      panelItems: [
                        {
                          editor: {
                            halign: 'LEFT',
                            renderMode: 'TEXT_DYNAMIC',
                            valign: 'MIDDLE',
                            wrapMode: 'NOWRAP',
                            appCodeListId:
                              'plmweb.wiki__shared_page_check_type',
                            editorType: 'SPAN',
                            predefinedType: 'FIELD_TEXT_DYNAMIC',
                            valueType: 'SIMPLE',
                            editable: true,
                            id: 'role_id',
                          },
                          viewFieldName: 'ROLE_ID',
                          allowEmpty: true,
                          convertToCodeItemText: true,
                          caption: '文本(动态)',
                          itemStyle: 'DEFAULT',
                          itemType: 'FIELD',
                          layoutPos: {
                            shrink: 1,
                            layout: 'FLEX',
                          },
                          id: 'role_id',
                        },
                        {
                          actionType: 'NONE',
                          buttonStyle: 'DEFAULT',
                          buttonType: 'PANELBUTTON',
                          renderMode: 'BUTTON',
                          tooltip: '删除',
                          uiactionTarget: 'NONE',
                          caption: '删除',
                          itemStyle: 'DEFAULT',
                          itemType: 'BUTTON',
                          layoutPos: {
                            shrink: 1,
                            layout: 'FLEX',
                          },
                          sysImage: {
                            cssClass: 'fa fa-trash-o',
                            glyph: 'xf014@FontAwesome',
                          },
                          showCaption: true,
                          id: 'button_calluilogic',
                        },
                      ],
                      layout: {
                        align: 'center',
                        dir: 'row',
                        layout: 'FLEX',
                        valign: 'center',
                      },
                      dataRegionType: 'INHERIT',
                      caption: '容器',
                      itemStyle: 'DEFAULT',
                      itemType: 'CONTAINER',
                      layoutPos: {
                        shrink: 1,
                        layout: 'FLEX',
                      },
                      id: 'container1',
                    },
                  ],
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
                    shrink: 1,
                    layout: 'FLEX',
                  },
                  id: 'container',
                },
                {
                  rawItem: {
                    contentType: 'DIVIDER',
                    predefinedType: 'STATIC_LABEL',
                    rawContent: '标签',
                    id: 'static_label',
                  },
                  caption: '标签',
                  itemStyle: 'DEFAULT',
                  itemType: 'RAWITEM',
                  layoutPos: {
                    shrink: 1,
                    layout: 'FLEX',
                  },
                  showCaption: true,
                  id: 'static_label',
                },
                {
                  editor: {
                    editorType: 'HIDDEN',
                    predefinedType: 'FIELD_TEXT_DYNAMIC',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'id',
                  },
                  viewFieldName: 'ID',
                  allowEmpty: true,
                  hidden: true,
                  caption: '文本(动态)',
                  itemType: 'FIELD',
                  layoutPos: {
                    shrink: 1,
                    layout: 'FLEX',
                  },
                  id: 'id',
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
          codeName: 'usr0701843143',
          controlType: 'PANEL',
          logicName: 'shared_member_列表项面板',
          appDataEntityId: 'plmweb.member',
          controlLogics: [
            {
              eventNames: 'onClick',
              itemName: 'BUTTON_CALLUILOGIC',
              logicTag: 'list_itempanel',
              logicType: 'APPDEUIACTION',
              appDEUIActionId: 'del_shared_member@member',
              triggerType: 'CTRLEVENT',
              id: 'logic',
            },
          ],
          controlParam: {},
          modelId: '0e19f571973046453cf42a6caaeb460a',
          modelType: 'PSSYSVIEWPANEL',
          name: 'list_itempanel',
          id: 'plmweb.member.usr0701843143',
        },
        delistDataItems: [
          {
            appDEFieldId: 'id',
            dataType: 25,
            id: 'id',
          },
          {
            appDEFieldId: 'name',
            dataType: 25,
            id: 'name',
          },
          {
            appDEFieldId: 'role_id',
            frontCodeListId: 'plmweb.base__user_group_role_type',
            dataType: 25,
            id: 'role_id',
          },
          {
            appDEFieldId: 'user_id',
            dataType: 25,
            id: 'user_id',
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
          appDEMethodId: 'fetch_shared_page_member',
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
        codeName: 'shared_member',
        controlType: 'LIST',
        logicName: 'shared_member',
        appDataEntityId: 'plmweb.member',
        controlParam: {
          id: 'list',
        },
        modelId: 'ae402d34bc79ed0c6b56a0b5c28c5053',
        modelType: 'PSDELIST',
        name: 'list',
        id: 'plmweb.member.shared_member',
      },
      {
        groupMode: 'SINGLE',
        controlType: 'SEARCHBAR',
        appDataEntityId: 'plmweb.member',
        controlParam: {
          id: 'searchbar',
        },
        id: 'searchbar',
      },
      {
        capLanguageRes: {
          lanResTag: 'DE.LNAME.MEMBER',
        },
        caption: '成员',
        codeName: 'shared_page_list_view_captionbar',
        controlType: 'CAPTIONBAR',
        appDataEntityId: 'plmweb.member',
        controlParam: {},
        name: 'captionbar',
        id: 'shared_page_list_view_captionbar',
      },
    ],
    codeName: 'usr0701901658',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: 'shared_page_list_view列表视图布局面板',
    appDataEntityId: 'plmweb.member',
    controlLogics: [
      {
        eventNames: 'onClick',
        itemName: 'BUTTON_CALLUILOGIC',
        logicTag: 'layoutpanel',
        logicType: 'APPDEUIACTION',
        appDEUIActionId: 'add_shared_mmeber@member',
        appDEUILogicId: 'add_shared_member',
        appDataEntityId: 'plmweb.member',
        triggerType: 'CTRLEVENT',
        id: 'logic',
      },
    ],
    controlParam: {},
    modelId: '75e8892e6721a0c1a7163fa41ea3a19f',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'usr0701901658',
  },
  title: '成员',
  viewStyle: 'DEFAULT',
  viewType: 'DELISTVIEW',
  enableDP: true,
  showCaptionBar: false,
  modelId: '6a51b76e218665a271d6b70694a504c4',
  modelType: 'PSAPPDEVIEW',
  name: 'membershared_page_list_view',
  id: 'plmweb.member_shared_page_list_view',
};
