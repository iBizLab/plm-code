export default {
  xdataControlName: 'grid',
  loadDefault: true,
  deviewCodeName: 'config_grid_view',
  deviewId: 'd451485de5fa8f6401073938b1bff360',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.INSIGHT_MEMBER',
  },
  caption: '视图成员',
  codeName: 'insight_member_config_grid_view',
  appDataEntityId: 'plmweb.insight_member',
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
        batchAddAppViews: [
          {
            openMode: 'POPUPMODAL',
            refMode: 'USER',
            refAppViewId: 'plmweb.user_choose_mpick_up_view',
          },
        ],
        newDataAppView: {
          refAppViewId: 'plmweb.insight_member_edit_view',
        },
        enableBatchAdd: true,
        appDataEntityId: 'plmweb.insight_member',
        appUILogicRefViews: [
          {
            refAppViewId: 'plmweb.insight_member_edit_view',
          },
          {
            openMode: 'POPUPMODAL',
            refMode: 'USER',
            refAppViewId: 'plmweb.user_choose_mpick_up_view',
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
          refAppViewId: 'plmweb.insight_member_redirect_view',
        },
        editMode: true,
        appUILogicRefViews: [
          {
            refAppViewId: 'plmweb.insight_member_redirect_view',
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
  appViewParams: [
    {
      key: 'PROPERTYMAP',
      value: 'display_name:name',
      name: 'PROPERTYMAP',
      id: 'propertymap',
    },
  ],
  appViewRefs: [
    {
      realTitle: '效能成员数据重定向视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.INSIGHT_MEMBER.REDIRECTVIEW',
      },
      refAppViewId: 'plmweb.insight_member_redirect_view',
      name: 'EDITDATA',
      id: 'editdata',
    },
    {
      realTitle: '效能成员编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.INSIGHT_MEMBER.EDITVIEW',
      },
      refAppViewId: 'plmweb.insight_member_edit_view',
      name: 'NEWDATA',
      id: 'newdata',
    },
    {
      name: 'MPICKUPVIEW:INSIGHT_VIEW',
      id: 'mpickupview:insight_view',
    },
    {
      realOpenMode: 'POPUPMODAL',
      realTitle: '选择成员',
      refAppViewId: 'plmweb.user_choose_mpick_up_view',
      name: 'MPICKUPVIEW:USER',
      id: 'mpickupview:user',
    },
  ],
  controls: [
    {
      detoolbarItems: [
        {
          actionLevel: 100,
          noPrivDisplayMode: 2,
          uiactionId: 'add_insight_view_member',
          uiactionTarget: 'NONE',
          valid: true,
          caption: '添加成员',
          itemType: 'DEUIACTION',
          controlLogics: [
            {
              itemName: 'deuiaction1',
              logicTag: 'toolbar',
              logicType: 'SCRIPT',
              scriptCode: 'context.srfreadonly != true',
              triggerType: 'ITEMVISIBLE',
              id: 'deuiaction1',
            },
          ],
          sysImage: {
            cssClass: 'fa fa-plus',
            glyph: 'xf067@FontAwesome',
          },
          tooltip: '添加成员',
          showCaption: true,
          showIcon: true,
          id: 'deuiaction1',
        },
      ],
      xdataControlName: 'grid',
      codeName: 'config_grid_view_toolbar',
      controlType: 'TOOLBAR',
      logicName: '视图成员配置_工具栏',
      appDataEntityId: 'plmweb.insight_member',
      controlParam: {
        id: 'toolbar',
      },
      modelId: '903e745d415daa9531bc31c2fec2d9ca',
      modelType: 'PSDETOOLBAR',
      name: 'toolbar',
      id: 'config_grid_view_toolbar',
    },
    {
      aggMode: 'NONE',
      columnEnableFilter: 2,
      columnEnableLink: 2,
      groupMode: 'NONE',
      groupStyle: 'DEFAULT',
      degridColumns: [
        {
          clconvertMode: 'NONE',
          dataItemName: 'name',
          excelCaption: '姓名',
          appDEFieldId: 'name',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.NAME',
          },
          caption: '姓名',
          codeName: 'name',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'STAR',
          enableSort: true,
          id: 'name',
        },
        {
          clconvertMode: 'FRONT',
          dataItemName: 'role_id',
          excelCaption: '角色',
          appCodeListId: 'plmweb.base__role_type',
          appDEFieldId: 'role_id',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.ROLE_ID',
          },
          caption: '角色',
          codeName: 'role_id',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 100,
          widthUnit: 'PX',
          enableSort: true,
          id: 'role_id',
        },
        {
          clconvertMode: 'FRONT',
          dataItemName: 'title',
          excelCaption: '职位',
          appCodeListId: 'plmweb.base__position',
          appDEFieldId: 'title',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '职位',
          codeName: 'title',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 150,
          widthUnit: 'PX',
          enableSort: true,
          id: 'title',
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
          width: 150,
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
      ],
      degridDataItems: [
        {
          appDEFieldId: 'name',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'name',
        },
        {
          appDEFieldId: 'role_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'role_id',
        },
        {
          appDEFieldId: 'title',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'title',
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
          appDEFieldId: 'user_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'user_id',
        },
        {
          appDEFieldId: 'owner_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'owner_id',
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
      navViewPos: 'NONE',
      fetchControlAction: {
        appDEMethodId: 'fetch_default',
        appDataEntityId: 'plmweb.insight_member',
        id: 'fetch',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.insight_member',
        id: 'remove',
      },
      autoLoad: true,
      enableItemPrivilege: true,
      showBusyIndicator: true,
      controls: [
        {
          detoolbarItems: [
            {
              actionLevel: 100,
              noPrivDisplayMode: 1,
              uiactionId: 'setting_role@insight_member',
              uiactionTarget: 'MULTIKEY',
              valid: true,
              caption: '角色',
              itemType: 'DEUIACTION',
              sysImage: {
                cssClass: 'fa fa-sun-o',
                glyph: 'xf185@FontAwesome',
              },
              tooltip: '设置角色',
              showCaption: true,
              showIcon: true,
              id: 'deuiaction1',
            },
            {
              actionLevel: 100,
              noPrivDisplayMode: 1,
              uiactionId: 'choose_position@insight_member',
              uiactionTarget: 'MULTIKEY',
              valid: true,
              caption: '职位',
              itemType: 'DEUIACTION',
              sysImage: {
                cssClass: 'fa fa-users',
                glyph: 'xf0c0@FontAwesome',
              },
              tooltip: '变更选中成员的职位',
              showCaption: true,
              showIcon: true,
              id: 'deuiaction3',
            },
            {
              actionLevel: 100,
              noPrivDisplayMode: 1,
              uiactionId: 'gridview_removeaction',
              uiactionTarget: 'MULTIKEY',
              valid: true,
              capLanguageRes: {
                lanResTag: 'TBB.TEXT.*.REMOVE',
              },
              caption: '删除',
              itemType: 'DEUIACTION',
              sysImage: {
                cssClass: 'fa fa-trash-o',
                glyph: 'xf014@FontAwesome',
              },
              tooltip: '删除',
              tooltipLanguageRes: {
                lanResTag: 'TBB.TOOLTIP.*.REMOVE',
              },
              showCaption: true,
              showIcon: true,
              id: 'deuiaction2',
            },
          ],
          codeName: 'config_grid_view_grid_batchtoolbar',
          controlType: 'TOOLBAR',
          logicName: '删除&&设置角色',
          appDataEntityId: 'plmweb.insight_member',
          controlParam: {
            id: 'grid_batchtoolbar',
          },
          modelId: '7ae75df030dfb65c3154f2e87c2267cc',
          modelType: 'PSDETOOLBAR',
          name: 'grid_batchtoolbar',
          id: 'config_grid_view_grid_batchtoolbar',
        },
      ],
      codeName: 'config_grdi_view_grid',
      controlType: 'GRID',
      logicName: '视图成员配置_表格',
      appDataEntityId: 'plmweb.insight_member',
      controlParam: {
        id: 'grid',
      },
      modelId: 'f7ef56db0f675d4859dce3f8524a1646',
      modelType: 'PSDEGRID',
      name: 'grid',
      id: 'plmweb.insight_member.config_grdi_view_grid',
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
      codeName: 'config_grdi_view_search_form',
      controlType: 'SEARCHFORM',
      logicName: '视图成员配置_搜索表单',
      appDataEntityId: 'plmweb.insight_member',
      controlParam: {
        id: 'searchform',
      },
      modelId: 'f7ed84c322dc93434e31a5e75779d0af',
      modelType: 'PSDEFORM_SEARCHFORM',
      name: 'searchform',
      id: 'plmweb.insight_member.config_grdi_view_search_form',
    },
    {
      groupMode: 'SINGLE',
      quickSearchMode: 1,
      enableQuickSearch: true,
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.insight_member',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.INSIGHT_MEMBER',
      },
      caption: '视图成员',
      codeName: 'config_grid_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.insight_member',
      controlParam: {},
      name: 'captionbar',
      id: 'config_grid_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEGRIDVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.insight_member',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '视图成员',
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '06494c42bd74f0a4b6f2f9d4b539e7ca',
  modelType: 'PSAPPDEVIEW',
  name: 'insight_memberconfig_grid_view',
  id: 'plmweb.insight_member_config_grid_view',
};
