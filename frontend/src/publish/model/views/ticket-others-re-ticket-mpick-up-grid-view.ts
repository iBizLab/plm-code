export default {
  gridRowActiveMode: 1,
  expandSearchForm: true,
  pickupMode: true,
  xdataControlName: 'grid',
  loadDefault: true,
  deviewCodeName: 'others_re_ticket_mpick_up_grid_view',
  deviewId: '3fd8f5619fee934e50b3f61277f235fa',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.TICKET',
  },
  caption: '工单',
  codeName: 'ticket_others_re_ticket_mpick_up_grid_view',
  appDataEntityId: 'plmweb.ticket',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'PickupGridView',
      id: 'engine',
    },
  ],
  appViewNavParams: [
    {
      key: 'target_type',
      value: 'target_type',
      id: 'target_type',
    },
    {
      key: 'principal_type',
      value: 'principal_type',
      id: 'principal_type',
    },
    {
      key: 'n_id_noteq',
      value: 'principal_id',
      id: 'n_id_noteq',
    },
    {
      key: 'principal_id',
      value: 'principal_id',
      id: 'principal_id',
    },
  ],
  controls: [
    {
      searchButtonStyle: 'NONE',
      enableAutoSearch: true,
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
              labelPos: 'NONE',
              noPrivDisplayMode: 1,
              appDEFieldId: 'show_identifier',
              editor: {
                editorType: 'TEXTBOX',
                placeHolder: '编号',
                valueType: 'SIMPLE',
                editable: true,
                id: 'n_show_identifier_like',
              },
              allowEmpty: true,
              caption: '编号',
              codeName: 'n_show_identifier_like',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colLG: 3,
                colMD: 3,
                layout: 'TABLE_24COL',
              },
              id: 'n_show_identifier_like',
            },
            {
              dataType: 25,
              enableCond: 3,
              labelPos: 'NONE',
              noPrivDisplayMode: 1,
              appDEFieldId: 'title',
              editor: {
                editorType: 'TEXTBOX',
                placeHolder: '标题',
                valueType: 'SIMPLE',
                editable: true,
                id: 'n_title_like',
              },
              allowEmpty: true,
              caption: '标题',
              codeName: 'n_title_like',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colLG: 3,
                colMD: 3,
                layout: 'TABLE_24COL',
              },
              id: 'n_title_like',
            },
            {
              dataType: 25,
              enableCond: 3,
              labelPos: 'NONE',
              noPrivDisplayMode: 1,
              appDEFieldId: 'state',
              editor: {
                singleSelect: true,
                appCodeListId: 'plmweb.prodmgmt__ticket_state',
                editorType: 'DROPDOWNLIST',
                placeHolder: '选择状态',
                valueType: 'SIMPLE',
                editable: true,
                id: 'n_state_eq',
              },
              allowEmpty: true,
              needCodeListConfig: true,
              caption: '状态',
              codeName: 'n_state_eq',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colLG: 3,
                colMD: 3,
                layout: 'TABLE_24COL',
              },
              id: 'n_state_eq',
            },
            {
              dataType: 25,
              enableCond: 3,
              labelPos: 'NONE',
              noPrivDisplayMode: 1,
              appDEFieldId: 'product_name',
              editor: {
                singleSelect: true,
                handlerType: 'PickupText',
                appDEACModeId: 'default',
                appDEDataSetId: 'fetch_main',
                appDataEntityId: 'plmweb.product',
                enableAC: true,
                forceSelection: true,
                showTrigger: true,
                valueItemName: 'n_product_id_eq',
                editorParams: {
                  AC: 'TRUE',
                  TRIGGER: 'TRUE',
                  PICKUPVIEW: 'FALSE',
                },
                editorType: 'PICKEREX_TRIGGER',
                editorItems: [
                  {
                    id: 'n_product_id_eq',
                  },
                ],
                placeHolder: '选择产品',
                valueType: 'SIMPLE',
                editable: true,
                id: 'n_product_name_eq',
              },
              allowEmpty: true,
              caption: '所属产品',
              codeName: 'n_product_name_eq',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colLG: 3,
                colMD: 3,
                layout: 'TABLE_24COL',
              },
              id: 'n_product_name_eq',
            },
            {
              dataType: 25,
              enableCond: 3,
              labelPos: 'LEFT',
              labelWidth: 130,
              noPrivDisplayMode: 1,
              editor: {
                editorType: 'HIDDEN',
                valueType: 'SIMPLE',
                editable: true,
                id: 'n_product_id_eq',
              },
              allowEmpty: true,
              hidden: true,
              codeName: 'n_product_id_eq',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colLG: 3,
                colMD: 3,
                layout: 'TABLE_24COL',
              },
              id: 'n_product_id_eq',
            },
          ],
          capLanguageRes: {
            lanResTag: 'CONTROL.DEFORM.TICKET.DEFAULT.FORMPAGE.FORMPAGE1',
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
      codeName: 'default',
      controlType: 'SEARCHFORM',
      logicName: '默认搜索表单',
      appDataEntityId: 'plmweb.ticket',
      controlParam: {
        id: 'searchform',
      },
      modelId: 'efcc0c209641a30316331a766e3d2193',
      modelType: 'PSDEFORM_SEARCHFORM',
      name: 'searchform',
      id: 'plmweb.ticket.default',
    },
    {
      aggMode: 'NONE',
      columnEnableFilter: 2,
      columnEnableLink: 2,
      groupMode: 'NONE',
      minorSortDir: 'DESC',
      minorSortAppDEFieldId: 'update_time',
      degridColumns: [
        {
          clconvertMode: 'NONE',
          dataItemName: 'title',
          excelCaption: '标题',
          appDEFieldId: 'title',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '标题',
          codeName: 'title',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 100,
          widthUnit: 'PX',
          enableSort: true,
          id: 'title',
        },
      ],
      degridDataItems: [
        {
          appDEFieldId: 'title',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'title',
        },
        {
          appDEFieldId: 'id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'id',
        },
        {
          appDEFieldId: 'identifier',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'identifier',
        },
        {
          appDEFieldId: 'state',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'state',
        },
        {
          appDEFieldId: 'priority',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'priority',
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
          appDEFieldId: 'assignee_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'assignee_id',
        },
        {
          appDEFieldId: 'product_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'product_id',
        },
        {
          appDEFieldId: 'customer_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'customer_id',
        },
        {
          appDEFieldId: 'title',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'srfmajortext',
        },
        {
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'srfmstag',
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
      fetchControlAction: {
        appDEMethodId: 'fetch_not_exsists_relation',
        appDataEntityId: 'plmweb.ticket',
        id: 'fetch',
      },
      dedataImportId: 'import_ticket',
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.ticket',
        id: 'remove',
      },
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'relation_mpick_up_grid',
      controlStyle: 'CHECKBOX_GRID',
      controlType: 'GRID',
      logicName: '关联工单多项选择视图_选择数据视图_表格',
      appDataEntityId: 'plmweb.ticket',
      controlParam: {
        id: 'grid',
      },
      sysPFPluginId: 'checkbox_grid',
      modelId: '0b5e145030c8968ac9d036c9058aab9e',
      modelType: 'PSDEGRID',
      name: 'grid',
      id: 'plmweb.ticket.relation_mpick_up_grid',
    },
    {
      groupMode: 'SINGLE',
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.ticket',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.TICKET',
      },
      caption: '工单',
      codeName: 'others_re_ticket_mpick_up_grid_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.ticket',
      controlParam: {},
      name: 'captionbar',
      id: 'others_re_ticket_mpick_up_grid_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEPICKUPGRIDVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.ticket',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '其他实体关联工单多项选择视图_选择数据视图',
  viewStyle: 'DEFAULT',
  viewType: 'DEPICKUPGRIDVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '6d711c3721cc8599daf2d060c7e7aca4',
  modelType: 'PSAPPDEVIEW',
  name: 'ticketothers_re_ticket_mpick_up_grid_view',
  id: 'plmweb.ticket_others_re_ticket_mpick_up_grid_view',
};