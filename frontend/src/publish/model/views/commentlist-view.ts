export default {
  xdataControlName: 'list',
  loadDefault: true,
  deviewCodeName: 'list_view',
  deviewId: '2cd57b81d6d3e24a97d721002d13a493',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.COMMENT',
  },
  caption: '评论',
  codeName: 'commentlist_view',
  appDataEntityId: 'plmweb.comment',
  appViewNavParams: [
    {
      key: 'n_owner_type_eq',
      value: 'principal_type',
      id: 'n_owner_type_eq',
    },
    {
      key: 'n_principal_id_eq',
      value: 'principal_id',
      id: 'n_principal_id_eq',
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
        logicTrigger: 'CUSTOM',
        logicType: 'APPUILOGIC',
        builtinAppUILogic: {
          actionAfterWizard: 'DEFAULT',
          newDataAppView: {
            refAppViewId: 'plmweb.commenteditview',
          },
          appUILogicRefViews: [
            {
              refAppViewId: 'plmweb.commenteditview',
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
            refAppViewId: 'plmweb.commenteditview',
          },
          editMode: true,
          appUILogicRefViews: [
            {
              refAppViewId: 'plmweb.commenteditview',
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
        realTitle: '评论编辑视图',
        realTitleLanguageRes: {
          lanResTag: 'PAGE.TITLE.COMMENT.EDITVIEW',
        },
        refAppViewId: 'plmweb.commenteditview',
        name: 'NEWDATA',
        id: 'newdata',
      },
      {
        realTitle: '评论编辑视图',
        realTitleLanguageRes: {
          lanResTag: 'PAGE.TITLE.COMMENT.EDITVIEW',
        },
        refAppViewId: 'plmweb.commenteditview',
        name: 'EDITDATA',
        id: 'editdata',
      },
    ],
    controls: [
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
              panelItems: [
                {
                  panelItems: [
                    {
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
                            id: 'user_name',
                          },
                          viewFieldName: 'CREATE_MAN',
                          allowEmpty: true,
                          convertToCodeItemText: true,
                          caption: '文本(动态)',
                          itemStyle: 'DEFAULT',
                          itemType: 'FIELD',
                          layoutPos: {
                            shrink: 1,
                            layout: 'FLEX',
                          },
                          id: 'user_name',
                        },
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
                            id: 'time',
                          },
                          viewFieldName: 'CREATE_TIME',
                          allowEmpty: true,
                          caption: '文本(动态)',
                          cssStyle:
                            'line-height: var(--ibiz-height-control-default);',
                          itemStyle: 'DEFAULT',
                          itemType: 'FIELD',
                          layoutPos: {
                            shrink: 1,
                            layout: 'FLEX',
                            spacingLeft: 'OUTERSMALL',
                          },
                          sysCss: {
                            cssName: 'transition-time',
                          },
                          id: 'time',
                        },
                        {
                          editor: {
                            editorType: 'HIDDEN',
                            predefinedType: 'FIELD_TEXT_DYNAMIC',
                            valueType: 'SIMPLE',
                            editable: true,
                            id: 'field_text_dynamic3',
                          },
                          viewFieldName: 'ID',
                          allowEmpty: true,
                          hidden: true,
                          caption: '文本(动态)',
                          itemStyle: 'DEFAULT',
                          itemType: 'FIELD',
                          layoutPos: {
                            shrink: 1,
                            layout: 'FLEX',
                          },
                          id: 'field_text_dynamic3',
                        },
                        {
                          editor: {
                            editorType: 'HIDDEN',
                            predefinedType: 'FIELD_TEXT_DYNAMIC',
                            valueType: 'SIMPLE',
                            editable: true,
                            id: 'pid',
                          },
                          viewFieldName: 'PID',
                          allowEmpty: true,
                          hidden: true,
                          caption: '文本(动态)',
                          itemStyle: 'DEFAULT',
                          itemType: 'FIELD',
                          layoutPos: {
                            shrink: 1,
                            layout: 'FLEX',
                          },
                          id: 'pid',
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
                        shrink: 1,
                        layout: 'FLEX',
                      },
                      id: 'container1',
                    },
                    {
                      panelItems: [
                        {
                          actionType: 'UIACTION',
                          buttonStyle: 'STYLE2',
                          buttonType: 'PANELBUTTON',
                          uiactionId:
                            'panel_usr0103471499_button_calluilogic2_click@comment',
                          renderMode: 'BUTTON',
                          tooltip: '回复',
                          uiactionTarget: 'SINGLEDATA',
                          caption: '回复',
                          itemStyle: 'STYLE2',
                          itemType: 'BUTTON',
                          layoutPos: {
                            shrink: 1,
                            layout: 'FLEX',
                          },
                          sysImage: {
                            cssClass: 'fa fa-comment-o',
                            glyph: 'xf0e5@FontAwesome',
                          },
                          id: 'button_calluilogic2',
                        },
                        {
                          actionType: 'UIACTION',
                          buttonStyle: 'STYLE2',
                          buttonType: 'PANELBUTTON',
                          uiactionId:
                            'panel_usr0103471499_button_calluilogic1_click@comment',
                          renderMode: 'BUTTON',
                          tooltip: '编辑',
                          uiactionTarget: 'SINGLEDATA',
                          caption: '编辑',
                          itemStyle: 'STYLE2',
                          itemType: 'BUTTON',
                          controlLogics: [
                            {
                              itemName: 'BUTTON_CALLUILOGIC1',
                              logicTag: 'list_itempanel',
                              logicType: 'SCRIPT',
                              scriptCode:
                                'data?.create_man === context?.srfuserid',
                              triggerType: 'ITEMVISIBLE',
                              id: 'logic_edit',
                            },
                          ],
                          layoutPos: {
                            shrink: 1,
                            layout: 'FLEX',
                          },
                          sysImage: {
                            cssClass: 'fa fa-edit',
                            glyph: 'xf044@FontAwesome',
                          },
                          id: 'button_calluilogic1',
                        },
                        {
                          actionType: 'UIACTION',
                          buttonStyle: 'STYLE2',
                          buttonType: 'PANELBUTTON',
                          uiactionId: 'del_comment@comment',
                          renderMode: 'BUTTON',
                          tooltip: '删除',
                          uiactionTarget: 'SINGLEKEY',
                          caption: '删除',
                          itemStyle: 'STYLE2',
                          itemType: 'BUTTON',
                          controlLogics: [
                            {
                              itemName: 'BUTTON_CALLUILOGIC',
                              logicTag: 'list_itempanel',
                              logicType: 'SCRIPT',
                              scriptCode:
                                'data?.create_man === context?.srfuserid',
                              triggerType: 'ITEMVISIBLE',
                              id: 'logic_dele',
                            },
                          ],
                          layoutPos: {
                            shrink: 1,
                            layout: 'FLEX',
                          },
                          sysImage: {
                            cssClass: 'fa fa-trash',
                            glyph: 'xf1f8@FontAwesome',
                          },
                          id: 'button_calluilogic',
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
                        shrink: 1,
                        layout: 'FLEX',
                      },
                      panelItemGroupLogics: [
                        {
                          logicCat: 'PANELVISIBLE',
                          relatedItemNames: ['field_text_dynamic2'],
                          groupOP: 'AND',
                          panelItemLogics: [
                            {
                              condOp: 'NOTEQ',
                              dstModelField: 'FIELD_TEXT_DYNAMIC2',
                              value: '<p><del>该评论已删除</del></p>',
                              logicType: 'SINGLE',
                              id: '逻辑项',
                            },
                          ],
                          logicType: 'GROUP',
                          id: '面板成员[container2][面板显示]逻辑',
                        },
                      ],
                      id: 'container2',
                    },
                  ],
                  layout: {
                    align: 'space-between',
                    dir: 'row',
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
                  panelItems: [
                    {
                      editor: {
                        contentType: 'HTML',
                        editorParams: {
                          contenttype: 'HTML',
                          SCRIPTCODE:
                            'data.content?.replace(/@{[^,]*,"name":"(.*?)"}/g,"<span class=\'comment-tag\'>@$1</span>").replace(/@{[^,]*,name=(.*?)}/g,"<span class=\'comment-tag\'>@$1</span>").replace(/#{"id":"(.+?)","name":"(.+?)","identifier":"(.+?)","icon":"((.|[\\t\\r\\f\\n\\s])+?)"}/g, "<span class=\'comment-tag\'>$4 $3 $2</span>").replace(/#{id=(.+?),name=(.+?),identifier=(.+?),icon=((.|[\\t\\r\\f\\n\\s])+?)}/g, "<span class=\'comment-tag\'>$4 $3 $2</span>")',
                        },
                        editorStyle: 'COMMENT_ITEM',
                        editorType: 'RAW',
                        sysPFPluginId: 'comment_item',
                        predefinedType: 'FIELD_TEXT_DYNAMIC',
                        valueType: 'SIMPLE',
                        editable: true,
                        id: 'field_text_dynamic2',
                      },
                      viewFieldName: 'CONTENT',
                      allowEmpty: true,
                      caption: '文本(动态)',
                      itemStyle: 'DEFAULT',
                      itemType: 'FIELD',
                      layoutPos: {
                        shrink: 1,
                        layout: 'FLEX',
                      },
                      id: 'field_text_dynamic2',
                    },
                    {
                      panelItems: [
                        {
                          editor: {
                            halign: 'LEFT',
                            renderMode: 'TEXT_DYNAMIC',
                            valign: 'MIDDLE',
                            wrapMode: 'NOWRAP',
                            appCodeListId: 'plmweb.sysoperator',
                            editorType: 'SPAN',
                            predefinedType: 'FIELD_TEXT_DYNAMIC',
                            valueType: 'SIMPLE',
                            editable: true,
                            id: 'pcreate_man',
                          },
                          viewFieldName: 'PCREATE_MAN',
                          allowEmpty: true,
                          convertToCodeItemText: true,
                          caption: '文本(动态)',
                          itemStyle: 'DEFAULT',
                          itemType: 'FIELD',
                          layoutPos: {
                            shrink: 0,
                            layout: 'FLEX',
                          },
                          id: 'pcreate_man',
                        },
                        {
                          rawItem: {
                            caption: '：',
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
                          },
                          showCaption: true,
                          id: 'static_label',
                        },
                        {
                          editor: {
                            contentType: 'HTML',
                            editorParams: {
                              contenttype: 'HTML',
                            },
                            editorType: 'RAW',
                            predefinedType: 'FIELD_TEXT_DYNAMIC',
                            valueType: 'SIMPLE',
                            editable: true,
                            id: 'pcontent',
                          },
                          viewFieldName: 'PCONTENT',
                          allowEmpty: true,
                          caption: '文本(动态)',
                          itemStyle: 'DEFAULT',
                          itemType: 'FIELD',
                          controlRenders: [
                            {
                              layoutPanelModel:
                                'data.pcontent?.replace(/@{[^,]*,"name":"(.*?)"}/g,"<span class=\'comment-tag\'>@$1</span>").replace(/@{[^,]*,name=(.*?)}/g,"<span class=\'comment-tag\'>@$1</span>").replace(/#{"id":"(.+?)","name":"(.+?)","identifier":"(.+?)","icon":"((.|[\\t\\r\\f\\n\\s])+?)"}/g, "<span class=\'comment-tag\'>$4 $3 $2</span>").replace(/#{id=(.+?),name=(.+?),identifier=(.+?),icon=((.|[\\t\\r\\f\\n\\s])+?)}/g, "<span class=\'comment-tag\'>$4 $3 $2</span>")',
                              renderType: 'LAYOUTPANEL_MODEL',
                              id: 'logic1',
                            },
                          ],
                          layoutPos: {
                            grow: 1,
                            shrink: 1,
                            layout: 'FLEX',
                          },
                          id: 'pcontent',
                        },
                      ],
                      layout: {
                        align: 'flex-start',
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
                      panelItemGroupLogics: [
                        {
                          logicCat: 'PANELVISIBLE',
                          relatedItemNames: ['pid'],
                          groupOP: 'AND',
                          panelItemLogics: [
                            {
                              condOp: 'ISNOTNULL',
                              dstModelField: 'PID',
                              logicType: 'SINGLE',
                              id: '逻辑项',
                            },
                          ],
                          logicType: 'GROUP',
                          id: '面板成员[container3][面板显示]逻辑',
                        },
                      ],
                      sysCss: {
                        cssName: 'comment-replay',
                      },
                      id: 'container3',
                    },
                  ],
                  layout: {
                    layout: 'FLEX',
                  },
                  dataRegionType: 'INHERIT',
                  caption: '容器',
                  cssStyle: 'padding-left: 36px;',
                  itemStyle: 'DEFAULT',
                  itemType: 'CONTAINER',
                  layoutPos: {
                    shrink: 1,
                    layout: 'FLEX',
                  },
                  id: 'container4',
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
          codeName: 'Usr0103471499',
          controlType: 'PANEL',
          logicName: 'list_列表项面板',
          appDataEntityId: 'plmweb.comment',
          controlLogics: [
            {
              eventNames: 'onClick',
              itemName: 'BUTTON_CALLUILOGIC2',
              logicTag: 'list_itempanel',
              logicType: 'SCRIPT',
              scriptCode:
                'const panelItems = view.layoutPanel.panelItems;\r\n panelItems.container_comment.state.visible = true;',
              triggerType: 'CTRLEVENT',
              id: 'logic',
            },
          ],
          controlParam: {},
          modelId: 'ee886f58af63fee0ca6e9603df7aaa8e',
          modelType: 'PSSYSVIEWPANEL',
          name: 'list_itempanel',
          id: 'plmweb.comment.usr0103471499',
        },
        minorSortDir: 'ASC',
        minorSortAppDEFieldId: 'create_time',
        delistDataItems: [
          {
            appDEFieldId: 'pcontent',
            dataType: 21,
            id: 'pcontent',
          },
          {
            appDEFieldId: 'id',
            dataType: 25,
            id: 'id',
          },
          {
            appDEFieldId: 'create_man',
            frontCodeListId: 'plmweb.sysoperator',
            dataType: 25,
            id: 'create_man',
          },
          {
            appDEFieldId: 'create_time',
            dataType: 5,
            format: 'YYYY-MM-DD HH:mm:ss',
            id: 'create_time',
          },
          {
            appDEFieldId: 'content',
            dataType: 21,
            id: 'content',
          },
          {
            appDEFieldId: 'pcreate_man',
            frontCodeListId: 'plmweb.sysoperator',
            dataType: 25,
            id: 'pcreate_man',
          },
          {
            appDEFieldId: 'pid',
            dataType: 25,
            id: 'pid',
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
        ],
        pagingSize: 1000,
        showHeader: true,
        createControlAction: {
          appDEMethodId: 'create',
          appDataEntityId: 'plmweb.comment',
          id: 'create',
        },
        fetchControlAction: {
          appDEMethodId: 'fetchdefault',
          appDataEntityId: 'plmweb.comment',
          id: 'fetch',
        },
        getControlAction: {
          appDEMethodId: 'get',
          appDataEntityId: 'plmweb.comment',
          id: 'load',
        },
        removeControlAction: {
          appDEMethodId: 'remove',
          appDataEntityId: 'plmweb.comment',
          id: 'remove',
        },
        updateControlAction: {
          appDEMethodId: 'update',
          appDataEntityId: 'plmweb.comment',
          id: 'update',
        },
        autoLoad: true,
        showBusyIndicator: true,
        codeName: 'List',
        controlType: 'LIST',
        logicName: 'list',
        appDataEntityId: 'plmweb.comment',
        controlParam: {
          id: 'list',
        },
        sysCss: {
          cssName: 'comment-list-height-auto',
        },
        modelId: '9b4452e60e1fe2c3e394cd0199c78969',
        modelType: 'PSDELIST',
        name: 'list',
        id: 'plmweb.comment.list',
      },
      {
        groupMode: 'SINGLE',
        controlType: 'SEARCHBAR',
        appDataEntityId: 'plmweb.comment',
        controlParam: {
          id: 'searchbar',
        },
        id: 'searchbar',
      },
      {
        capLanguageRes: {
          lanResTag: 'DE.LNAME.COMMENT',
        },
        caption: '评论',
        codeName: 'list_viewcaptionbar',
        controlType: 'CAPTIONBAR',
        appDataEntityId: 'plmweb.comment',
        controlParam: {},
        name: 'captionbar',
        id: 'list_viewcaptionbar',
      },
    ],
    codeName: 'Usr0103274907',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: 'list_view列表视图布局面板',
    appDataEntityId: 'plmweb.comment',
    controlParam: {},
    modelId: 'ec74278f1f5a797ebc942e090298d91c',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'usr0103274907',
  },
  title: '评论列表视图',
  viewStyle: 'DEFAULT',
  viewType: 'DELISTVIEW',
  enableDP: true,
  showCaptionBar: false,
  modelId: 'eac2aa8e4fe80453d257341ab278a79a',
  modelType: 'PSAPPDEVIEW',
  name: 'commentlist_view',
  id: 'plmweb.commentlist_view',
};