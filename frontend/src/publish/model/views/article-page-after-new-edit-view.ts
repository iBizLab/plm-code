export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  openMode: 'POPUPMODAL',
  deviewCodeName: 'after_new_edit_view',
  deviewId: '6F0CABF6-0842-413C-9344-6B2DA17D7D7C',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.PAGE',
  },
  caption: '新建页面',
  codeName: 'article_page_after_new_edit_view',
  height: 90,
  appDataEntityId: 'plmweb.article_page',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'EditView',
      id: 'engine',
    },
  ],
  appViewLogics: [
    {
      eventNames: 'onMounted',
      logicTrigger: 'VIEWEVENT',
      logicType: 'SCRIPT',
      scriptCode:
        "view.modal.hooks.shouldDismiss.tapPromise(async context => {\r\n    const form = view.getController('form');\r\n    const uiDomain = ibiz.uiDomainManager.get(view.context.srfsessionid);\r\n    if (form.data.title !== null && form.data.title !== '' && form.data.title !== undefined) {\r\n        console.log('关闭');\r\n        console.log(form);\r\n        const isChange =\r\n            (form.state.modified || uiDomain.dataModification)\r\n        if (isChange && context.allowClose == null) {\r\n            if (form) {\r\n                await form.save({ silent: true });\r\n                context.allowClose = true;\r\n            }\r\n        }else {\r\n        console.log('删除===');\r\n        console.log(form);\r\n            if (form) {\r\n                await form.remove({ silent: true });\r\n                context.allowClose = true;\r\n            }\r\n        }\r\n    } \r\n});\r\n// 关闭前传递是否发布参数\r\nview.modal.hooks.beforeDismiss.tapPromise(async modalData => {\r\n    modalData.data = [{ is_published: !!view.is_published }];\r\n});",
      builtinLogic: true,
      name: 'LOGIC',
      id: 'logic',
    },
  ],
  appViewNavContexts: [
    {
      key: 'PAGE_ID',
      value: 'id',
      name: 'PAGE_ID',
      id: 'page_id',
    },
    {
      key: 'SPACE',
      value: 'space_id',
      name: 'SPACE',
      id: 'space',
    },
  ],
  controls: [
    {
      detoolbarItems: [
        {
          actionLevel: 100,
          noPrivDisplayMode: 2,
          uiactionId: 'release@article_page',
          uiactionTarget: 'SINGLEDATA',
          valid: true,
          caption: '发布',
          itemType: 'DEUIACTION',
          sysImage: {
            cssClass: 'fa fa-paper-plane-o',
            glyph: 'xf1d9@FontAwesome',
          },
          tooltip: '发布',
          showCaption: true,
          showIcon: true,
          id: 'deuiaction1',
        },
      ],
      xdataControlName: 'form',
      codeName: 'after_new_edit_view_toolbar',
      controlType: 'TOOLBAR',
      logicName: '快速新建后续视图_工具栏',
      appDataEntityId: 'plmweb.article_page',
      controlParam: {
        id: 'toolbar',
      },
      modelId: 'CC9D577A-32E9-496A-B41B-7A581EE9E2F1',
      modelType: 'PSDETOOLBAR',
      name: 'toolbar',
      id: 'after_new_edit_view_toolbar',
    },
    {
      createControlAction: {
        appDEMethodId: 'create',
        appDataEntityId: 'plmweb.article_page',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.article_page',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'get_draft',
        appDataEntityId: 'plmweb.article_page',
        id: 'loaddraft',
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
      deformPages: [
        {
          layout: {
            columnCount: 24,
            layout: 'TABLE_24COL',
          },
          deformDetails: [
            {
              layout: {
                align: 'flex-start',
                dir: 'row',
                layout: 'FLEX',
                valign: 'flex-end',
              },
              deformDetails: [
                {
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'name',
                  editor: {
                    maxLength: 200,
                    editorType: 'TEXTBOX',
                    placeHolder: '请输入标题',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'title',
                  },
                  capLanguageRes: {
                    lanResTag: 'DEF.LNAME.NAME',
                  },
                  caption: '标题',
                  codeName: 'title',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    grow: 1,
                    shrink: 1,
                    layout: 'FLEX',
                  },
                  showCaption: true,
                  id: 'title',
                },
              ],
              codeName: 'grouppanel4',
              detailStyle: 'DEFAULT',
              detailType: 'GROUPPANEL',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              id: 'grouppanel4',
            },
            {
              createDV: '1',
              dataType: 25,
              enableCond: 3,
              labelPos: 'TOP',
              labelWidth: 130,
              noPrivDisplayMode: 1,
              appDEFieldId: 'type',
              editor: {
                editorType: 'HIDDEN',
                valueType: 'SIMPLE',
                editable: true,
                id: 'type',
              },
              updateDV: '1',
              allowEmpty: true,
              hidden: true,
              caption: '类型',
              codeName: 'type',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colLG: 12,
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              id: 'type',
            },
            {
              createDV: 'format_type',
              createDVT: 'APPDATA',
              dataType: 25,
              enableCond: 3,
              labelPos: 'TOP',
              labelWidth: 130,
              noPrivDisplayMode: 1,
              appDEFieldId: 'format_type',
              editor: {
                appCodeListId: 'plmweb.codelist54',
                editorType: 'RADIOBUTTONLIST',
                valueType: 'SIMPLE',
                editable: true,
                id: 'format_type',
              },
              needCodeListConfig: true,
              caption: '正文格式',
              codeName: 'format_type',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colLG: 12,
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'format_type',
            },
            {
              layout: {
                dir: 'row',
                layout: 'FLEX',
              },
              deformDetails: [
                {
                  dataType: 21,
                  enableCond: 3,
                  ignoreInput: 12,
                  itemHeight: 600,
                  labelPos: 'NONE',
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'content',
                  editor: {
                    editorHeight: 600,
                    editorType: 'HTMLEDITOR',
                    placeHolder: '请输入内容',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'content',
                  },
                  resetItemNames: ['format_type'],
                  allowEmpty: true,
                  caption: '正文',
                  codeName: 'content',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  defdgroupLogics: [
                    {
                      logicCat: 'PANELVISIBLE',
                      relatedDetailNames: ['format_type'],
                      groupOP: 'AND',
                      defdlogics: [
                        {
                          condOP: 'EQ',
                          defdname: 'format_type',
                          value: 'HTML',
                          logicType: 'SINGLE',
                        },
                      ],
                      logicType: 'GROUP',
                      id: '表单成员[content][面板显示]逻辑',
                    },
                    {
                      logicCat: 'ITEMENABLE',
                      relatedDetailNames: ['format_type'],
                      groupOP: 'AND',
                      defdlogics: [
                        {
                          condOP: 'EQ',
                          defdname: 'format_type',
                          value: 'HTML',
                          logicType: 'SINGLE',
                        },
                      ],
                      logicType: 'GROUP',
                      id: '表单成员[content][表单项启用]逻辑',
                    },
                  ],
                  layoutPos: {
                    grow: 1,
                    shrink: 1,
                    layout: 'FLEX',
                  },
                  id: 'content',
                },
                {
                  dataType: 21,
                  enableCond: 3,
                  ignoreInput: 12,
                  itemHeight: 600,
                  labelPos: 'NONE',
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'content',
                  editor: {
                    mode: 'EDIT',
                    maxLength: 16777215,
                    showMaxLength: true,
                    editorHeight: 600,
                    editorType: 'MARKDOWN',
                    placeHolder: '请输入内容',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'formitem',
                  },
                  resetItemNames: ['format_type'],
                  allowEmpty: true,
                  caption: '正文',
                  codeName: 'formitem',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  defdgroupLogics: [
                    {
                      logicCat: 'PANELVISIBLE',
                      relatedDetailNames: ['format_type'],
                      groupOP: 'AND',
                      defdlogics: [
                        {
                          condOP: 'EQ',
                          defdname: 'format_type',
                          value: 'MD',
                          logicType: 'SINGLE',
                        },
                      ],
                      logicType: 'GROUP',
                      id: '表单成员[formitem][面板显示]逻辑',
                    },
                    {
                      logicCat: 'ITEMENABLE',
                      relatedDetailNames: ['format_type'],
                      groupOP: 'AND',
                      defdlogics: [
                        {
                          condOP: 'EQ',
                          defdname: 'format_type',
                          value: 'MD',
                          logicType: 'SINGLE',
                        },
                      ],
                      logicType: 'GROUP',
                      id: '表单成员[formitem][表单项启用]逻辑',
                    },
                  ],
                  layoutPos: {
                    grow: 1,
                    shrink: 1,
                    layout: 'FLEX',
                  },
                  id: 'formitem',
                },
                {
                  dataType: 21,
                  enableCond: 3,
                  ignoreInput: 12,
                  itemHeight: 600,
                  labelPos: 'NONE',
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'content',
                  editor: {
                    maxLength: 16777215,
                    showMaxLength: true,
                    editorHeight: 600,
                    editorStyle: 'LUCKYSHEET',
                    editorType: 'TEXTAREA',
                    sysPFPluginId: 'luckysheet',
                    placeHolder: '请输入内容',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'formitem1',
                  },
                  resetItemNames: ['format_type'],
                  allowEmpty: true,
                  caption: '正文',
                  codeName: 'formitem1',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  defdgroupLogics: [
                    {
                      logicCat: 'PANELVISIBLE',
                      relatedDetailNames: ['format_type'],
                      groupOP: 'AND',
                      defdlogics: [
                        {
                          condOP: 'EQ',
                          defdname: 'format_type',
                          value: 'EXCEL',
                          logicType: 'SINGLE',
                        },
                      ],
                      logicType: 'GROUP',
                      id: '表单成员[formitem1][面板显示]逻辑',
                    },
                    {
                      logicCat: 'ITEMENABLE',
                      relatedDetailNames: ['format_type'],
                      groupOP: 'AND',
                      defdlogics: [
                        {
                          condOP: 'EQ',
                          defdname: 'format_type',
                          value: 'EXCEL',
                          logicType: 'SINGLE',
                        },
                      ],
                      logicType: 'GROUP',
                      id: '表单成员[formitem1][表单项启用]逻辑',
                    },
                  ],
                  layoutPos: {
                    grow: 1,
                    shrink: 1,
                    layout: 'FLEX',
                  },
                  id: 'formitem1',
                },
              ],
              caption: '正文',
              codeName: 'grouppanel1',
              detailStyle: 'DEFAULT',
              detailType: 'GROUPPANEL',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'grouppanel1',
            },
            {
              createDV: 'space',
              createDVT: 'APPDATA',
              dataType: 25,
              enableCond: 3,
              labelPos: 'LEFT',
              labelWidth: 130,
              noPrivDisplayMode: 1,
              appDEFieldId: 'space_id',
              editor: {
                editorType: 'HIDDEN',
                valueType: 'SIMPLE',
                editable: true,
                id: 'space_id',
              },
              allowEmpty: true,
              hidden: true,
              caption: '空间标识',
              codeName: 'space_id',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              id: 'space_id',
            },
            {
              createDV: 'page_id',
              createDVT: 'APPDATA',
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
            {
              createDV: 'page_p',
              createDVT: 'APPDATA',
              dataType: 25,
              enableCond: 3,
              labelPos: 'LEFT',
              labelWidth: 130,
              noPrivDisplayMode: 1,
              appDEFieldId: 'parent_id',
              editor: {
                editorType: 'HIDDEN',
                valueType: 'SIMPLE',
                editable: true,
                id: 'parent_id',
              },
              updateDV: 'page_p',
              updateDVT: 'APPDATA',
              allowEmpty: true,
              hidden: true,
              caption: '父页面',
              codeName: 'parent_id',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              id: 'parent_id',
            },
            {
              rawItem: {
                contentType: 'DIVIDER',
                rawContent: '{"contentPosition":"center","html":""}',
                id: 'rawitem1',
              },
              codeName: 'rawitem1',
              detailStyle: 'DEFAULT',
              detailType: 'RAWITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'rawitem1',
            },
            {
              actionGroupExtractMode: 'ITEM',
              uiactionGroup: {
                uiactionGroupDetails: [
                  {
                    actionLevel: 100,
                    afterItemType: 'NONE',
                    beforeItemType: 'NONE',
                    caption: '添加附件',
                    detailType: 'DEUIACTION',
                    uiactionId: 'add_attachments@article_page',
                    showCaption: true,
                    showIcon: true,
                    sysImage: {
                      cssClass: 'fa fa-plus',
                      glyph: 'xf067@FontAwesome',
                    },
                    id: 'u7f64bbb',
                  },
                ],
                appDataEntityId: 'plmweb.article_page',
                uniqueTag: 'article_page__Usr0228516811',
                name: '添加附件',
                id: 'usr0228516811',
              },
              layout: {
                columnCount: 24,
                layout: 'TABLE_24COL',
              },
              deformDetails: [
                {
                  contentControl: {
                    aggMode: 'NONE',
                    columnEnableFilter: 2,
                    columnEnableLink: 2,
                    groupMode: 'NONE',
                    degridColumns: [
                      {
                        clconvertMode: 'NONE',
                        dataItemName: 'name',
                        excelCaption: '名称',
                        appDEFieldId: 'name',
                        valueType: 'SIMPLE',
                        enableRowEdit: true,
                        aggMode: 'NONE',
                        align: 'LEFT',
                        capLanguageRes: {
                          lanResTag: 'DEF.LNAME.NAME',
                        },
                        caption: '名称',
                        codeName: 'name',
                        columnType: 'DEFGRIDCOLUMN',
                        noPrivDisplayMode: 1,
                        width: 250,
                        widthUnit: 'STAR',
                        enableSort: true,
                        id: 'name',
                      },
                      {
                        clconvertMode: 'NONE',
                        dataItemName: 'create_time',
                        excelCaption: '上传时间',
                        appDEFieldId: 'create_time',
                        valueFormat: 'YYYY-MM-DD HH:mm:ss',
                        valueType: 'SIMPLE',
                        aggMode: 'NONE',
                        align: 'LEFT',
                        capLanguageRes: {
                          lanResTag: 'DEF.LNAME.CREATE_TIME',
                        },
                        caption: '上传时间',
                        codeName: 'create_time',
                        columnType: 'DEFGRIDCOLUMN',
                        noPrivDisplayMode: 1,
                        width: 200,
                        widthUnit: 'PX',
                        enableSort: true,
                        id: 'create_time',
                      },
                      {
                        clconvertMode: 'NONE',
                        dataItemName: 'owner_id',
                        excelCaption: '所属数据标识',
                        appDEFieldId: 'owner_id',
                        valueType: 'SIMPLE',
                        enableRowEdit: true,
                        aggMode: 'NONE',
                        align: 'LEFT',
                        caption: '所属数据标识',
                        codeName: 'owner_id',
                        columnType: 'DEFGRIDCOLUMN',
                        hideMode: 1,
                        noPrivDisplayMode: 1,
                        width: 100,
                        widthUnit: 'PX',
                        enableSort: true,
                        hideDefault: true,
                        id: 'owner_id',
                      },
                      {
                        deuiactionGroup: {
                          uiactionGroupDetails: [
                            {
                              actionLevel: 250,
                              afterItemType: 'NONE',
                              beforeItemType: 'NONE',
                              detailType: 'DEUIACTION',
                              uiactionId: 'download@attachment',
                              tooltip: '下载当前附件',
                              showIcon: true,
                              sysImage: {
                                cssClass: 'fa fa-download',
                                glyph: 'xf019@FontAwesome',
                              },
                              id: 'u73b8ba5',
                            },
                            {
                              actionLevel: 100,
                              afterItemType: 'NONE',
                              beforeItemType: 'NONE',
                              caption: '删除',
                              detailType: 'DEUIACTION',
                              uiactionId: 'delete@attachment',
                              tooltip: '删除',
                              showCaption: true,
                              showIcon: true,
                              sysImage: {
                                cssClass: 'fa fa-trash-o',
                                glyph: 'xf014@FontAwesome',
                              },
                              id: 'u44d00e2',
                            },
                          ],
                          appDataEntityId: 'plmweb.attachment',
                          uniqueTag: 'attachment__Usr0103721999',
                          name: '附件表格操作列',
                          id: 'usr0103721999',
                        },
                        aggMode: 'NONE',
                        align: 'RIGHT',
                        caption: '操作',
                        codeName: 'uagridcolumn1',
                        columnType: 'UAGRIDCOLUMN',
                        noPrivDisplayMode: 1,
                        width: 100,
                        widthUnit: 'PX',
                        id: 'uagridcolumn1',
                      },
                    ],
                    degridDataItems: [
                      {
                        appDEFieldId: 'name',
                        valueType: 'SIMPLE',
                        dataType: 25,
                        id: 'name',
                      },
                      {
                        format: 'YYYY-MM-DD HH:mm:ss',
                        appDEFieldId: 'create_time',
                        valueType: 'SIMPLE',
                        dataType: 5,
                        id: 'create_time',
                      },
                      {
                        appDEFieldId: 'owner_id',
                        valueType: 'SIMPLE',
                        dataType: 25,
                        id: 'owner_id',
                      },
                      {
                        appDEFieldId: 'file_id',
                        valueType: 'SIMPLE',
                        dataType: 25,
                        id: 'file_id',
                      },
                      {
                        appDEFieldId: 'id',
                        valueType: 'SIMPLE',
                        dataType: 25,
                        id: 'srfkey',
                      },
                      {
                        appDEFieldId: 'id',
                        valueType: 'SIMPLE',
                        dataType: 25,
                        id: 'srfdataaccaction',
                      },
                      {
                        appDEFieldId: 'name',
                        valueType: 'SIMPLE',
                        dataType: 25,
                        id: 'srfmajortext',
                      },
                    ],
                    degridEditItems: [
                      {
                        caption: '名称',
                        codeName: 'name',
                        enableCond: 3,
                        appDEFieldId: 'name',
                        editor: {
                          maxLength: 200,
                          editorType: 'TEXTBOX',
                          valueType: 'SIMPLE',
                          editable: true,
                          id: 'name',
                        },
                        allowEmpty: true,
                        id: 'name',
                      },
                      {
                        caption: '所属数据标识',
                        codeName: 'owner_id',
                        enableCond: 3,
                        appDEFieldId: 'owner_id',
                        editor: {
                          maxLength: 100,
                          editorType: 'TEXTBOX',
                          valueType: 'SIMPLE',
                          editable: true,
                          id: 'owner_id',
                        },
                        allowEmpty: true,
                        id: 'owner_id',
                      },
                      {
                        caption: '标识',
                        codeName: 'srfkey',
                        enableCond: 3,
                        appDEFieldId: 'id',
                        editor: {
                          editorType: 'HIDDEN',
                          valueType: 'SIMPLE',
                          editable: true,
                          id: 'srfkey',
                        },
                        allowEmpty: true,
                        id: 'srfkey',
                      },
                    ],
                    pagingSize: 20,
                    sortMode: 'REMOTE',
                    enableRowEdit: true,
                    enableRowNew: true,
                    singleSelect: true,
                    createControlAction: {
                      appDEMethodId: 'create',
                      appDataEntityId: 'plmweb.attachment',
                      id: 'create',
                    },
                    fetchControlAction: {
                      appDEMethodId: 'fetchdefault',
                      appDataEntityId: 'plmweb.attachment',
                      id: 'fetch',
                    },
                    getDraftControlAction: {
                      appDEMethodId: 'getdraft',
                      appDataEntityId: 'plmweb.attachment',
                      id: 'loaddraft',
                    },
                    getControlAction: {
                      appDEMethodId: 'get',
                      appDataEntityId: 'plmweb.attachment',
                      id: 'load',
                    },
                    removeControlAction: {
                      appDEMethodId: 'remove',
                      appDataEntityId: 'plmweb.attachment',
                      id: 'remove',
                    },
                    updateControlAction: {
                      appDEMethodId: 'update',
                      appDataEntityId: 'plmweb.attachment',
                      id: 'update',
                    },
                    autoLoad: true,
                    showBusyIndicator: true,
                    codeName: 'attach',
                    controlStyle: 'ATTACHMENT_GRID',
                    controlType: 'GRID',
                    logicName: '附件表格',
                    appDataEntityId: 'plmweb.attachment',
                    controlLogics: [
                      {
                        eventNames: 'onLoadSuccess',
                        logicTag: 'attachments_grid',
                        logicType: 'APPDEUILOGIC',
                        appDEUILogicId: 'calc_attachment_hidden',
                        appDataEntityId: 'plmweb.attachment',
                        triggerType: 'CTRLEVENT',
                        id: 'logic2',
                      },
                    ],
                    controlParam: {},
                    sysPFPluginId: 'attachment_grid',
                    modelId: '998d996121eae3cd01a2d8c20de49f02',
                    modelType: 'PSDEGRID',
                    name: 'attachments_grid',
                    id: 'plmweb.attachment.attach',
                  },
                  contentType: 'GRID',
                  layout: {
                    columnCount: 24,
                    layout: 'TABLE_24COL',
                  },
                  codeName: 'attachments',
                  detailStyle: 'DEFAULT',
                  detailType: 'MDCTRL',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'attachments',
                },
              ],
              caption: '附件',
              codeName: 'grouppanel2',
              detailStyle: 'DEFAULT',
              detailType: 'GROUPPANEL',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'grouppanel2',
            },
            {
              layout: {
                columnCount: 24,
                layout: 'TABLE_24COL',
              },
              deformDetails: [
                {
                  dataType: 21,
                  enableCond: 3,
                  labelPos: 'TOP',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'attentions',
                  editor: {
                    singleSelect: true,
                    handlerType: 'PickupText',
                    enableAC: true,
                    forceSelection: true,
                    showTrigger: true,
                    editorParams: {
                      MULTIPLE: 'true',
                      DEFAULTATNVALUE: '40',
                      'SRFNAVPARAM.n_department_id_eq': '%srforgsectorid%',
                      AC: 'TRUE',
                      DEFAULTSELCURUSER: 'true',
                      TRIGGER: 'TRUE',
                      SELFFILLMAP: '{"user_id":"user_id","user_name":"name"}',
                      URL: 'spaces/${context.space}/space_members/fetch_default',
                      PICKUPVIEW: 'FALSE',
                      USERMETHOD: 'post',
                      USERMAP: '{"id":"user_id","name":"name"}',
                      DEPTMAP: '{"id":"id","name":"display_name"}',
                      DEPTMETHOD: 'get',
                      DEPTURL: '/users/fetch_default',
                    },
                    editorStyle: 'PERSONEL_SELECT_SPACE',
                    editorType: 'PICKEREX_TRIGGER',
                    objectIdField: 'id',
                    objectNameField: 'name',
                    sysPFPluginId: 'person_select',
                    valueType: 'OBJECTS',
                    editable: true,
                    navigateParams: [
                      {
                        key: 'n_department_id_eq',
                        value: 'srforgsectorid',
                        id: 'n_department_id_eq',
                      },
                    ],
                    id: 'attentions',
                  },
                  allowEmpty: true,
                  caption: '关注人',
                  codeName: 'attentions',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colLG: 12,
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'attentions',
                },
              ],
              caption: '关注字段',
              codeName: 'grouppanel3',
              detailStyle: 'DEFAULT',
              detailType: 'GROUPPANEL',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              id: 'grouppanel3',
            },
          ],
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
      showBusyIndicator: true,
      codeName: 'after_new_edit_view_form',
      controlType: 'FORM',
      logicName: '快速新建后续视图_表单',
      appDataEntityId: 'plmweb.article_page',
      controlParam: {
        id: 'form',
      },
      ctrlMsg: {
        codeName: 'UsrCtrlMsg0228593610',
        ctrlMsgItems: [
          {
            name: 'BEFOREREMOVE_HIDDEN',
            id: 'beforeremove_hidden',
          },
          {
            name: 'CREATESUCCESS_HIDDEN',
            id: 'createsuccess_hidden',
          },
          {
            name: 'UPDATESUCCESS_HIDDEN',
            id: 'updatesuccess_hidden',
          },
        ],
        name: '编辑表单自定义消息(隐藏)',
        id: 'usrctrlmsg0228593610',
      },
      modelId: '379EEF3C-226B-4FFD-A753-AE9B9FB372AC',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.article_page.after_new_edit_view_form',
    },
    {
      codeName: 'after_new_edit_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.article_page',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'after_new_edit_view_datainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.PAGE',
      },
      caption: '新建页面',
      codeName: 'after_new_edit_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.article_page',
      controlParam: {},
      name: 'captionbar',
      id: 'after_new_edit_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEEDITVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.article_page',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '快速新建',
  viewStyle: 'DEFAULT',
  viewType: 'DEEDITVIEW',
  width: 90,
  enableDP: true,
  showCaptionBar: true,
  modelId: 'b6525a6ae1c3b049887bb062c0ffcc07',
  modelType: 'PSAPPDEVIEW',
  name: 'article_pageafter_new_edit_view',
  id: 'plmweb.article_page_after_new_edit_view',
};