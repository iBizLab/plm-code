export default {
  gridRowActiveMode: 1,
  xdataControlName: 'grid',
  loadDefault: true,
  funcViewMode: 'MDATAVIEW',
  deviewCodeName: 'GridView',
  deviewId: 'cf1b70066b3590eeb7f9cba2d8337e91',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.WORK_ITEM',
  },
  caption: '工作项',
  codeName: 'work_item_grid_view',
  appDataEntityId: 'plmweb.work_item',
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
          refAppViewId: 'plmweb.work_item_edit_view',
        },
        wizardAppView: {
          refAppViewId: 'plmweb.work_item_edit_view',
        },
        enableWizardAdd: true,
        appUILogicRefViews: [
          {
            refAppViewId: 'plmweb.work_item_edit_view',
          },
          {
            refAppViewId: 'plmweb.work_item_edit_view',
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
          openMode: 'POPUPMODAL',
          refAppViewId: 'plmweb.work_item_test_follow_edit_view',
        },
        editMode: true,
        appUILogicRefViews: [
          {
            openMode: 'POPUPMODAL',
            refAppViewId: 'plmweb.work_item_test_follow_edit_view',
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
      realOpenMode: 'POPUPMODAL',
      realTitle: '测试关注编辑视图',
      refAppViewId: 'plmweb.work_item_test_follow_edit_view',
      name: 'EDITDATA',
      id: 'editdata',
    },
    {
      realTitle: '工作项编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.WORK_ITEM.EDITVIEW',
      },
      refAppViewId: 'plmweb.work_item_edit_view',
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
      orderValueAppDEFieldId: 'sequence',
      degridColumns: [
        {
          clconvertMode: 'NONE',
          dataItemName: 'identifier',
          excelCaption: '编号',
          appDEFieldId: 'identifier',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '编号',
          codeName: 'identifier',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 80,
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
          dataItemName: 'work_item_type_id',
          excelCaption: '类型',
          appCodeListId: 'plmweb.projmgmt__work_item_type',
          appDEFieldId: 'work_item_type_id',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '类型',
          codeName: 'work_item_type_id',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 150,
          widthUnit: 'PX',
          enableSort: true,
          id: 'work_item_type_id',
        },
        {
          clconvertMode: 'FRONT',
          dataItemName: 'state',
          excelCaption: '状态',
          appCodeListId: 'plmweb.projmgmt__work_item_state',
          appDEFieldId: 'state',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
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
          linkAppViewId: 'plmweb.user_redirect_view',
          linkValueItem: 'assignee_id',
          appDEFieldId: 'assignee_name',
          valueType: 'SIMPLE',
          enableLinkView: true,
          enableRowEdit: true,
          aggMode: 'NONE',
          align: 'LEFT',
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
          appCodeListId: 'plmweb.projmgmt__work_item_priority',
          appDEFieldId: 'priority',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '优先级',
          codeName: 'priority',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 150,
          widthUnit: 'PX',
          enableSort: true,
          id: 'priority',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'ptitle',
          excelCaption: '父工作项',
          appDEFieldId: 'ptitle',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '父工作项',
          codeName: 'ptitle',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 150,
          widthUnit: 'PX',
          enableSort: true,
          id: 'ptitle',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'start_at',
          excelCaption: '开始时间',
          appDEFieldId: 'start_at',
          valueFormat: 'YYYY-MM-DD',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '开始时间',
          codeName: 'start_at',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 150,
          widthUnit: 'PX',
          enableSort: true,
          id: 'start_at',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'end_at',
          excelCaption: '截止时间',
          appDEFieldId: 'end_at',
          valueFormat: 'YYYY-MM-DD',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '截止时间',
          codeName: 'end_at',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 150,
          widthUnit: 'PX',
          enableSort: true,
          id: 'end_at',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'assignee_id',
          excelCaption: '负责人',
          appDEFieldId: 'assignee_id',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '负责人',
          codeName: 'assignee_id',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 100,
          widthUnit: 'PX',
          enableSort: true,
          id: 'assignee_id',
        },
      ],
      degridDataItems: [
        {
          appDEFieldId: 'identifier',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'identifier',
        },
        {
          appDEFieldId: 'title',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'title',
        },
        {
          appDEFieldId: 'work_item_type_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'work_item_type_id',
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
          appDEFieldId: 'ptitle',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'ptitle',
        },
        {
          format: 'YYYY-MM-DD',
          appDEFieldId: 'start_at',
          valueType: 'SIMPLE',
          dataType: 5,
          id: 'start_at',
        },
        {
          format: 'YYYY-MM-DD',
          appDEFieldId: 'end_at',
          valueType: 'SIMPLE',
          dataType: 5,
          id: 'end_at',
        },
        {
          appDEFieldId: 'assignee_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'assignee_id',
        },
        {
          appDEFieldId: 'id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'id',
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
          appDEFieldId: 'project_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'project_id',
        },
        {
          appDEFieldId: 'work_item_type_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'srfdatatype',
        },
        {
          appDEFieldId: 'pid',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'pid',
        },
        {
          appDEFieldId: 'sprint_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'sprint_id',
        },
        {
          appDEFieldId: 'board_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'board_id',
        },
        {
          appDEFieldId: 'entry_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'entry_id',
        },
        {
          appDEFieldId: 'swimlane_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'swimlane_id',
        },
        {
          appDEFieldId: 'top_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'top_id',
        },
        {
          appDEFieldId: 'release_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'release_id',
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
          caption: '负责人',
          codeName: 'assignee_name',
          enableCond: 3,
          appDEFieldId: 'assignee_name',
          editor: {
            singleSelect: true,
            appDEACModeId: 'member_select',
            appDEDataSetId: 'fetch_default',
            appDataEntityId: 'plmweb.project_member',
            uiactionGroup: {
              uiactionGroupDetails: [
                {
                  actionLevel: 100,
                  afterItemType: 'NONE',
                  beforeItemType: 'NONE',
                  caption: '跳转至成员设置',
                  detailType: 'DEUIACTION',
                  uiactionId: 'jump_to_member_set@project_member',
                  tooltip: '跳转至成员设置',
                  showCaption: true,
                  showIcon: true,
                  sysImage: {
                    cssClass: 'fa fa-user-md',
                    glyph: 'xf0f0@FontAwesome',
                  },
                  id: 'uc5eeb4c',
                },
              ],
              appDataEntityId: 'plmweb.project_member',
              uniqueTag: 'project_member__Usr0104465165',
              name: '跳转至成员配置',
              id: 'usr0104465165',
            },
            enableAC: true,
            forceSelection: true,
            showTrigger: true,
            valueItemName: 'assignee_id',
            editorParams: {
              'SRFNAVPARAM.n_department_id_eq': '%srforgsectorid%',
              AC: 'TRUE',
              TRIGGER: 'TRUE',
              URL: 'projects/${context.project}/project_members/fetch_default',
              PICKUPVIEW: 'FALSE',
              USERMETHOD: 'post',
              USERMAP: '{"id":"user_id","name":"name"}',
              DEPTMAP: '{"id":"id","name":"display_name"}',
              DEPTMETHOD: 'get',
              DEPTURL: '/users/fetch_default',
            },
            editorStyle: 'PERSONEL_SELECT_PROJECT',
            editorType: 'PICKEREX_TRIGGER',
            editorItems: [{}],
            sysPFPluginId: 'person_select',
            valueType: 'SIMPLE',
            editable: true,
            navigateParams: [
              {
                key: 'n_department_id_eq',
                value: 'srforgsectorid',
                id: 'n_department_id_eq',
              },
            ],
            id: 'assignee_name',
          },
          allowEmpty: true,
          id: 'assignee_name',
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
        {
          enableCond: 3,
          appDEFieldId: 'assignee_id',
          editor: {
            editorType: 'HIDDEN',
            valueType: 'SIMPLE',
            editable: true,
          },
          allowEmpty: true,
          id: 'assignee_id',
        },
      ],
      pagingMode: 1,
      pagingSize: 20,
      sortMode: 'REMOTE',
      enableCustomized: true,
      enablePagingBar: true,
      fetchControlAction: {
        appDEMethodId: 'fetch_normal',
        appDataEntityId: 'plmweb.work_item',
        id: 'fetch',
      },
      dedataImportId: 'import_work_item_waterfall',
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.work_item',
        id: 'remove',
      },
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'main',
      controlType: 'GRID',
      logicName: '主表格',
      appDataEntityId: 'plmweb.work_item',
      controlParam: {
        id: 'grid',
      },
      modelId: 'f04abb50a4417e123cc2a119b2012aba',
      modelType: 'PSDEGRID',
      name: 'grid',
      id: 'plmweb.work_item.main',
    },
    {
      searchButtonStyle: 'DEFAULT',
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
              appDEFieldId: 'identifier',
              editor: {
                editorType: 'TEXTBOX',
                placeHolder: '请输入查询编号',
                valueType: 'SIMPLE',
                editable: true,
                id: 'n_identifier_like',
              },
              allowEmpty: true,
              caption: '编号',
              codeName: 'n_identifier_like',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colLG: 8,
                colMD: 8,
                layout: 'TABLE_24COL',
              },
              id: 'n_identifier_like',
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
                colLG: 8,
                colMD: 8,
                layout: 'TABLE_24COL',
              },
              id: 'n_title_like',
            },
          ],
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
      appDataEntityId: 'plmweb.work_item',
      controlParam: {
        id: 'searchform',
      },
      modelId: 'ca044c4879a63d30121ff19610f25e6a',
      modelType: 'PSDEFORM_SEARCHFORM',
      name: 'searchform',
      id: 'plmweb.work_item.default',
    },
    {
      detoolbarItems: [
        {
          actionLevel: 100,
          detoolbarItems: [
            {
              actionLevel: 100,
              noPrivDisplayMode: 2,
              uiactionId:
                'toolbar_grid_view_toolbar_deuiaction1_click@work_item',
              uiactionTarget: 'SINGLEDATA',
              valid: true,
              caption: '工作项',
              itemType: 'DEUIACTION',
              tooltip: '工作项',
              showCaption: true,
              showIcon: true,
              id: 'deuiaction1',
            },
            {
              actionLevel: 100,
              noPrivDisplayMode: 2,
              uiactionId: 'new_work_item_test@work_item',
              uiactionTarget: 'NONE',
              valid: true,
              caption: '新建工作项',
              itemType: 'DEUIACTION',
              tooltip: '新建工作项',
              showCaption: true,
              showIcon: true,
              id: 'deuiaction2',
            },
          ],
          valid: true,
          caption: '新建工作项',
          itemType: 'ITEMS',
          sysImage: {
            cssClass: 'fa fa-plus',
            glyph: 'xf067@FontAwesome',
          },
          tooltip: '新建工作项',
          showCaption: true,
          showIcon: true,
          id: 'items1',
        },
      ],
      xdataControlName: 'grid',
      codeName: 'grid_view_toolbar',
      controlType: 'TOOLBAR',
      logicName: '工作项表格测试_工具栏',
      appDataEntityId: 'plmweb.work_item',
      controlParam: {
        id: 'toolbar',
      },
      modelId: '0e0852e15a7c480a6fad5737d85393f1',
      modelType: 'PSDETOOLBAR',
      name: 'toolbar',
      id: 'grid_view_toolbar',
    },
    {
      groupMode: 'SINGLE',
      quickSearchMode: 1,
      enableQuickSearch: true,
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.work_item',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.WORK_ITEM',
      },
      caption: '工作项',
      codeName: 'grid_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.work_item',
      controlParam: {},
      name: 'captionbar',
      id: 'grid_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEGRIDVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.work_item',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '工作项表格视图',
  titleLanguageRes: {
    lanResTag: 'PAGE.TITLE.WORK_ITEM.GRIDVIEW',
  },
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '99baf2ddfb1637825ff211280d0b5b70',
  modelType: 'PSAPPDEVIEW',
  name: 'work_itemGridView',
  id: 'plmweb.work_item_grid_view',
};