export default {
  gridRowActiveMode: 1,
  xdataControlName: 'grid',
  loadDefault: true,
  deviewCodeName: 'all_report_grid_view',
  deviewId: '12CF953D-E7CA-4BB8-BA23-C1A096B21ED5',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.INSIGHT_REPORT',
  },
  caption: '全部报表',
  codeName: 'insight_report_all_report_grid_view',
  appDataEntityId: 'plmweb.insight_report',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'GridView',
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
          refAppViewId: 'plmweb.insight_report_edit_view',
        },
        appUILogicRefViews: [
          {
            refAppViewId: 'plmweb.insight_report_edit_view',
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
          refAppViewId: 'plmweb.insight_report_bi_report_content_panel_view',
        },
        editMode: true,
        appUILogicRefViews: [
          {
            refAppViewId: 'plmweb.insight_report_bi_report_content_panel_view',
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
      realTitle: '效能报表编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.INSIGHT_REPORT.EDITVIEW',
      },
      refAppViewId: 'plmweb.insight_report_edit_view',
      name: 'NEWDATA',
      id: 'newdata',
    },
    {
      realTitle: 'BI报表呈现态面板视图',
      refAppViewId: 'plmweb.insight_report_bi_report_content_panel_view',
      name: 'EDITDATA',
      id: 'editdata',
    },
    {
      realTitle: 'BI报表呈现态面板视图',
      refAppViewId: 'plmweb.insight_report_bi_report_content_panel_view',
      name: 'OPENDATA',
      id: 'opendata',
    },
  ],
  controls: [
    {
      detoolbarItems: [
        {
          actionLevel: 100,
          groupExtractMode: 'ITEMS',
          uiactionGroup: {
            uiactionGroupDetails: [
              {
                actionLevel: 100,
                afterItemType: 'NONE',
                beforeItemType: 'NONE',
                caption: '新建报表',
                detailType: 'DEUIACTION',
                uiactionId: 'create_report@insight_report',
                showCaption: true,
                showIcon: true,
                sysImage: {
                  cssClass: 'fa fa-plus',
                  glyph: 'xf067@FontAwesome',
                },
                id: 'u2de96d0',
              },
              {
                actionLevel: 100,
                afterItemType: 'NONE',
                beforeItemType: 'NONE',
                caption: '从模板新建',
                detailType: 'DEUIACTION',
                uiactionId: 'create_from_templat@insight_report',
                showCaption: true,
                showIcon: true,
                sysImage: {
                  cssClass: 'fa fa-plus',
                  glyph: 'xf067@FontAwesome',
                },
                id: 'ub29136b',
              },
            ],
            appDataEntityId: 'plmweb.insight_report',
            uniqueTag: 'insight_report__Usr0710258619',
            name: '新建行为组',
            id: 'usr0710258619',
          },
          valid: true,
          caption: '添加',
          itemType: 'ITEMS',
          controlLogics: [
            {
              itemName: 'items1',
              logicTag: 'toolbar',
              logicType: 'SCRIPT',
              scriptCode: 'context.srfreadonly != true',
              triggerType: 'ITEMVISIBLE',
              id: 'items1',
            },
          ],
          sysImage: {
            cssClass: 'fa fa-plus',
            glyph: 'xf067@FontAwesome',
          },
          tooltip: '添加',
          showCaption: true,
          showIcon: true,
          id: 'items1',
        },
      ],
      xdataControlName: 'grid',
      codeName: 'all_report_grid_view_toolbar',
      controlType: 'TOOLBAR',
      logicName: '全部报表表格视图_工具栏',
      appDataEntityId: 'plmweb.insight_report',
      controlParam: {
        id: 'toolbar',
      },
      modelId: '1397327B-D059-4ED1-B6E9-E2571FB8E1FE',
      modelType: 'PSDETOOLBAR',
      name: 'toolbar',
      id: 'all_report_grid_view_toolbar',
    },
    {
      aggMode: 'NONE',
      columnEnableFilter: 2,
      columnEnableLink: 2,
      groupMode: 'NONE',
      degridColumns: [
        {
          clconvertMode: 'NONE',
          dataItemName: 'name',
          excelCaption: '报表名称',
          appDEFieldId: 'name',
          deuiactionGroup: {
            uiactionGroupDetails: [
              {
                actionLevel: 100,
                afterItemType: 'NONE',
                beforeItemType: 'NONE',
                caption: '设置类别',
                detailType: 'DEUIACTION',
                uiactionId: 'set_category@insight_report',
                showCaption: true,
                showIcon: true,
                sysImage: {
                  cssClass: 'fa fa-gears',
                  glyph: 'xf085@FontAwesome',
                },
                id: 'u00a9337',
              },
              {
                actionLevel: 100,
                afterItemType: 'NONE',
                beforeItemType: 'NONE',
                caption: '设计',
                detailType: 'DEUIACTION',
                uiactionId: 'open_report_design_view@insight_report',
                showCaption: true,
                showIcon: true,
                sysImage: {
                  cssClass: 'fa fa-wrench',
                  glyph: 'xf0ad@FontAwesome',
                },
                id: 'u08c3f78',
              },
              {
                actionLevel: 100,
                afterItemType: 'NONE',
                beforeItemType: 'NONE',
                caption: '删除',
                detailType: 'DEUIACTION',
                uiactionId: 'delete_report@insight_report',
                showCaption: true,
                showIcon: true,
                sysImage: {
                  cssClass: 'fa fa-remove',
                  glyph: 'xf00d@FontAwesome',
                },
                id: 'u58bf5f1',
              },
            ],
            appDataEntityId: 'plmweb.insight_report',
            uniqueTag: 'insight_report__Usr0520490033',
            name: '主表格操作列',
            id: 'usr0520490033',
          },
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.NAME',
          },
          caption: '报表名称',
          codeName: 'name',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          controlRenders: [
            {
              layoutPanel: {
                layoutMode: 'Flex',
                layout: {
                  layout: 'FLEX',
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
                          appCodeListId: 'plmweb.insight__bi_chart_type2',
                          editorType: 'SPAN',
                          predefinedType: 'FIELD_TEXT_DYNAMIC',
                          valueType: 'SIMPLE',
                          editable: true,
                          id: 'chart_type',
                        },
                        viewFieldName: 'chart_type',
                        allowEmpty: true,
                        convertToCodeItemText: true,
                        caption: '文本(动态)',
                        cssStyle: '--ibiz-form-item-font-size: 0;',
                        itemStyle: 'DEFAULT',
                        itemType: 'FIELD',
                        layoutPos: {
                          shrink: 1,
                          layout: 'FLEX',
                        },
                        id: 'chart_type',
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
                          id: 'name',
                        },
                        viewFieldName: 'name',
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
                    id: 'container',
                  },
                ],
                layoutPanel: true,
                codeName: 'usr0713866980',
                controlType: 'PANEL',
                logicName: 'bi报表表格列绘制器',
                appDataEntityId: 'plmweb.insight_report',
                controlParam: {},
                modelId: '6CDFBAD5-C1ED-49F3-B5F3-A898C38BDE49',
                modelType: 'PSSYSVIEWPANEL',
                name: 'layout',
                id: 'plmweb.insight_report.usr0713866980',
              },
              renderType: 'LAYOUTPANEL',
              id: 'layout',
            },
          ],
          width: 200,
          widthUnit: 'STAR',
          enableSort: true,
          id: 'name',
        },
        {
          clconvertMode: 'FRONT',
          dataItemName: 'group',
          excelCaption: '数据集',
          appCodeListId: 'plmweb.insight__report_group_bi',
          appDEFieldId: 'group',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '数据集',
          codeName: 'group',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'PX',
          enableSort: true,
          id: 'group',
        },
        {
          clconvertMode: 'FRONT',
          dataItemName: 'categories',
          excelCaption: '类别',
          appCodeListId: 'plmweb.prodmgmt__category',
          appDEFieldId: 'categories',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '类别',
          codeName: 'categories_name',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'PX',
          enableSort: true,
          id: 'categories_name',
        },
        {
          clconvertMode: 'FRONT',
          dataItemName: 'update_man',
          excelCaption: '更新人',
          appCodeListId: 'plmweb.sysoperator',
          appDEFieldId: 'update_man',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.UPDATE_MAN',
          },
          caption: '更新人',
          codeName: 'update_man',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'PX',
          enableSort: true,
          id: 'update_man',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'update_time',
          excelCaption: '更新时间',
          appDEFieldId: 'update_time',
          valueFormat: 'YYYY-MM-DD HH:mm:ss',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.UPDATE_TIME',
          },
          caption: '更新时间',
          codeName: 'update_time',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'PX',
          enableSort: true,
          id: 'update_time',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'desc',
          excelCaption: '描述',
          appDEFieldId: 'desc',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '描述',
          codeName: 'desc',
          columnType: 'DEFGRIDCOLUMN',
          hideMode: 1,
          noPrivDisplayMode: 1,
          width: 100,
          widthUnit: 'PX',
          hideDefault: true,
          id: 'desc',
        },
      ],
      degridDataItems: [
        {
          appDEFieldId: 'name',
          scriptCode:
            'const app = ibiz.hub.getApp(context.srfappid);\r\nconst dataItems = await app.codeList.get(\r\n\'plmweb.insight__bi_chart_type2\',\r\ncontext,\r\nparams,\r\n);\r\nconst item =dataItems.find(x => x.value === data.chart_type);\r\nif (item && item.sysImage) {\r\n    return \'<div class="ibiz-code-list__item" style="height: 36px;line-height: 36px;"><div class="ibiz-icon" style="height: 100%;padding-right: 8px;">\' + item.sysImage.rawContent + \'</div>\' + data.name + \'</div>\';\r\n}\r\nreturn data.name;',
          valueType: 'SIMPLE',
          customCode: true,
          dataType: 25,
          id: 'name',
        },
        {
          appDEFieldId: 'group',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'group',
        },
        {
          appDEFieldId: 'categories',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'categories',
        },
        {
          appDEFieldId: 'update_man',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'update_man',
        },
        {
          format: 'YYYY-MM-DD HH:mm:ss',
          appDEFieldId: 'update_time',
          valueType: 'SIMPLE',
          dataType: 5,
          id: 'update_time',
        },
        {
          appDEFieldId: 'desc',
          valueType: 'SIMPLE',
          dataType: 21,
          id: 'desc',
        },
        {
          appDEFieldId: 'chart_type',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'chart_type',
        },
        {
          appDEFieldId: 'is_system',
          valueType: 'SIMPLE',
          dataType: 9,
          id: 'is_system',
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
          appDEFieldId: 'view_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'view_id',
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
      pagingMode: 1,
      pagingSize: 20,
      sortMode: 'REMOTE',
      enableCustomized: true,
      enablePagingBar: true,
      singleSelect: true,
      fetchControlAction: {
        appDEMethodId: 'fetch_normal',
        appDataEntityId: 'plmweb.insight_report',
        id: 'fetch',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.insight_report',
        id: 'remove',
      },
      autoLoad: true,
      enableItemPrivilege: true,
      showBusyIndicator: true,
      codeName: 'all_report_grid_view_grid',
      controlType: 'GRID',
      logicName: '全部报表表格视图_表格',
      appDataEntityId: 'plmweb.insight_report',
      controlParam: {
        id: 'grid',
      },
      modelId: '6B955A14-2EC0-49AA-8309-FAFC3F09AAA7',
      modelType: 'PSDEGRID',
      name: 'grid',
      id: 'plmweb.insight_report.all_report_grid_view_grid',
    },
    {
      searchButtonStyle: 'DEFAULT',
      deformPages: [
        {
          layout: {
            columnCount: 24,
            layout: 'TABLE_24COL',
          },
          caption: '常规条件',
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
      codeName: 'usr05200683_search_form',
      controlType: 'SEARCHFORM',
      logicName: '全部报表表格视图_搜索表单',
      appDataEntityId: 'plmweb.insight_report',
      controlParam: {
        id: 'searchform',
      },
      modelId: '5466781D-9298-4D2F-A6D8-C543C32815F3',
      modelType: 'PSDEFORM_SEARCHFORM',
      name: 'searchform',
      id: 'plmweb.insight_report.usr05200683_search_form',
    },
    {
      groupMode: 'SINGLE',
      quickSearchMode: 1,
      enableQuickSearch: true,
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.insight_report',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.INSIGHT_REPORT',
      },
      caption: '全部报表',
      codeName: 'all_report_grid_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.insight_report',
      controlParam: {},
      name: 'captionbar',
      id: 'all_report_grid_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEGRIDVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.insight_report',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '全部报表表格',
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: 'cf2b1f8ea13b6ff5a199e4de00b895ae',
  modelType: 'PSAPPDEVIEW',
  name: 'insight_reportall_report_grid_view',
  id: 'plmweb.insight_report_all_report_grid_view',
};