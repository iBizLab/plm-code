export default {
  gridRowActiveMode: 1,
  expandSearchForm: true,
  xdataControlName: 'grid',
  loadDefault: true,
  deviewCodeName: 'my_created_grid_view',
  deviewId: '4103a3b9fc881298198f93d2d8eb10ab',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.IDEA',
  },
  caption: '需求',
  codeName: 'ideamy_created_grid_view',
  appDataEntityId: 'plmweb.idea',
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
          openMode: 'POPUPMODAL',
          refAppViewId: 'plmweb.ideaeditview',
        },
        appUILogicRefViews: [
          {
            openMode: 'POPUPMODAL',
            refAppViewId: 'plmweb.ideaeditview',
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
          openMode: 'INDEXVIEWTAB_POPUPMODAL',
          navigateContexts: [
            {
              key: 'PRODUCT',
              value: 'product_id',
              name: 'PRODUCT',
              id: 'product',
            },
          ],
          refAppViewId: 'plmweb.ideamain_view',
        },
        editMode: true,
        appUILogicRefViews: [
          {
            openMode: 'INDEXVIEWTAB_POPUPMODAL',
            navigateContexts: [
              {
                key: 'PRODUCT',
                value: 'product_id',
                name: 'PRODUCT',
                id: 'product',
              },
            ],
            refAppViewId: 'plmweb.ideamain_view',
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
      openMode: 'INDEXVIEWTAB_POPUPMODAL',
      navigateContexts: [
        {
          key: 'PRODUCT',
          value: 'product_id',
          name: 'PRODUCT',
          id: 'product',
        },
      ],
      realOpenMode: 'INDEXVIEWTAB_POPUPMODAL',
      realTitle: '需求',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.IDEA.MAIN_VIEW',
      },
      refAppViewId: 'plmweb.ideamain_view',
      name: 'EDITDATA',
      id: 'editdata',
    },
    {
      realOpenMode: 'POPUPMODAL',
      realTitle: '需求编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.IDEA.EDITVIEW',
      },
      refAppViewId: 'plmweb.ideaeditview',
      name: 'NEWDATA',
      id: 'newdata',
    },
  ],
  controls: [
    {
      aggMode: 'NONE',
      columnEnableFilter: 2,
      columnEnableLink: 2,
      groupMode: 'NONE',
      degridColumns: [
        {
          clconvertMode: 'NONE',
          dataItemName: 'show_identifier',
          excelCaption: '编号',
          appDEFieldId: 'show_identifier',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.SHOW_IDENTIFIER',
          },
          caption: '编号',
          codeName: 'identifier',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 150,
          widthUnit: 'PX',
          enableSort: true,
          id: 'identifier',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'title',
          excelCaption: '标题',
          appDEFieldId: 'title',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.TITLE',
          },
          caption: '标题',
          codeName: 'title',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 100,
          widthUnit: 'STAR',
          enableSort: true,
          id: 'title',
        },
        {
          clconvertMode: 'FRONT',
          dataItemName: 'state',
          excelCaption: '状态',
          appCodeListId: 'plmweb.prodmgmt__idea_state',
          appDEFieldId: 'state',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.STATE',
          },
          caption: '状态',
          codeName: 'state',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 150,
          widthUnit: 'PX',
          enableSort: true,
          id: 'state',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'assignee_name',
          excelCaption: '负责人',
          appDEFieldId: 'assignee_name',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.ASSIGNEE_NAME',
          },
          caption: '负责人',
          codeName: 'assignee_name',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 150,
          widthUnit: 'PX',
          enableSort: true,
          id: 'assignee_name',
        },
        {
          clconvertMode: 'FRONT',
          dataItemName: 'priority',
          excelCaption: '优先级',
          appCodeListId: 'plmweb.prodmgmt__idea_priority',
          appDEFieldId: 'priority',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.PRIORITY',
          },
          caption: '优先级',
          codeName: 'priority',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 150,
          widthUnit: 'PX',
          enableSort: true,
          id: 'priority',
        },
      ],
      degridDataItems: [
        {
          appDEFieldId: 'show_identifier',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'show_identifier',
        },
        {
          appDEFieldId: 'title',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'title',
        },
        {
          appDEFieldId: 'state',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'state',
        },
        {
          appDEFieldId: 'assignee_name',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'assignee_name',
        },
        {
          appDEFieldId: 'priority',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'priority',
        },
        {
          format: 'YYYY-MM-DD',
          appDEFieldId: 'create_time',
          valueType: 'SIMPLE',
          dataType: 5,
          id: 'create_time',
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
          appDEFieldId: 'category_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'category_id',
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
      pagingSize: 20,
      sortMode: 'REMOTE',
      singleSelect: true,
      fetchControlAction: {
        appDEMethodId: 'fetchmy_created',
        appDataEntityId: 'plmweb.idea',
        id: 'fetch',
      },
      dedataImportId: 'import_idea',
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.idea',
        id: 'remove',
      },
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'Idea_re_idea_grid',
      controlType: 'GRID',
      logicName: '需求关联需求表格',
      appDataEntityId: 'plmweb.idea',
      controlParam: {
        id: 'grid',
      },
      modelId: '6a26f4af9a8fca306f0c9d135a5c1e3a',
      modelType: 'PSDEGRID',
      name: 'grid',
      id: 'plmweb.idea.idea_re_idea_grid',
    },
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
              capLanguageRes: {
                lanResTag:
                  'CONTROL.DEFORM.IDEA.USR12263500_SEARCHFORM.FORMITEM.N_SHOW_IDENTIFIER_LIKE',
              },
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
              capLanguageRes: {
                lanResTag:
                  'CONTROL.DEFORM.IDEA.USR12263500_SEARCHFORM.FORMITEM.N_TITLE_LIKE',
              },
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
                appCodeListId: 'plmweb.prodmgmt__idea_state',
                editorType: 'DROPDOWNLIST',
                placeHolder: '选择状态',
                valueType: 'SIMPLE',
                editable: true,
                id: 'n_state_eq',
              },
              allowEmpty: true,
              needCodeListConfig: true,
              capLanguageRes: {
                lanResTag:
                  'CONTROL.DEFORM.IDEA.USR12263500_SEARCHFORM.FORMITEM.N_STATE_EQ',
              },
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
                appDEDataSetId: 'fetchnormal',
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
              capLanguageRes: {
                lanResTag:
                  'CONTROL.DEFORM.IDEA.USR12263500_SEARCHFORM.FORMITEM.N_PRODUCT_NAME_EQ',
              },
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
              showCaption: true,
              id: 'n_product_id_eq',
            },
          ],
          capLanguageRes: {
            lanResTag:
              'CONTROL.DEFORM.IDEA.USR12263500_SEARCHFORM.FORMPAGE.FORMPAGE1',
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
      codeName: 'Usr12263500_SearchForm',
      controlType: 'SEARCHFORM',
      logicName: '关联多项数据选择视图（工作项关联）_选择数据视图_搜索表单',
      appDataEntityId: 'plmweb.idea',
      controlParam: {
        id: 'searchform',
      },
      modelId: '205868a8309156105483df42deb57400',
      modelType: 'PSDEFORM_SEARCHFORM',
      name: 'searchform',
      id: 'plmweb.idea.usr12263500_searchform',
    },
    {
      groupMode: 'SINGLE',
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.idea',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.IDEA',
      },
      caption: '需求',
      codeName: 'my_created_grid_viewcaptionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.idea',
      controlParam: {},
      name: 'captionbar',
      id: 'my_created_grid_viewcaptionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'Layoutpanel',
    controlStyle: 'APPDEGRIDVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.idea',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '我创建的需求',
  titleLanguageRes: {
    lanResTag: 'PAGE.TITLE.IDEA.MY_CREATED_GRID_VIEW',
  },
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  enableDP: true,
  showCaptionBar: false,
  modelId: '5e1625ba2fe5e0d739369604079801dd',
  modelType: 'PSAPPDEVIEW',
  name: 'ideamy_created_grid_view',
  id: 'plmweb.ideamy_created_grid_view',
};