export default {
  gridRowActiveMode: 1,
  xdataControlName: 'grid',
  loadDefault: true,
  funcViewMode: 'MDATAVIEW',
  deviewCodeName: 'GridView',
  deviewId: '231269aeac6d661aa29350017833edb3',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.PRODUCT_TAG',
  },
  caption: '产品标签',
  codeName: 'product_tagGridView',
  appDataEntityId: 'plmweb.product_tag',
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
          refAppViewId: 'plmweb.product_tageditview',
        },
        appUILogicRefViews: [
          {
            refAppViewId: 'plmweb.product_tageditview',
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
          refAppViewId: 'plmweb.product_tageditview',
        },
        editMode: true,
        appUILogicRefViews: [
          {
            refAppViewId: 'plmweb.product_tageditview',
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
      realTitle: '产品标签编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.PRODUCT_TAG.EDITVIEW',
      },
      refAppViewId: 'plmweb.product_tageditview',
      name: 'NEWDATA',
      id: 'newdata',
    },
    {
      realTitle: '产品标签编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.PRODUCT_TAG.EDITVIEW',
      },
      refAppViewId: 'plmweb.product_tageditview',
      name: 'EDITDATA',
      id: 'editdata',
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
          dataItemName: 'product_name',
          excelCaption: '产品名称',
          linkAppViewId: 'plmweb.productredirectview',
          linkValueItem: 'product_id',
          appDEFieldId: 'product_name',
          valueType: 'SIMPLE',
          enableLinkView: true,
          aggMode: 'NONE',
          align: 'LEFT',
          caption: '产品名称',
          codeName: 'product_name',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 100,
          widthUnit: 'STAR',
          enableSort: true,
          id: 'product_name',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'name',
          excelCaption: '标签名称',
          appDEFieldId: 'name',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.NAME',
          },
          caption: '标签名称',
          codeName: 'name',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 150,
          widthUnit: 'STAR',
          enableSort: true,
          id: 'name',
        },
      ],
      degridDataItems: [
        {
          appDEFieldId: 'product_name',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'product_name',
        },
        {
          appDEFieldId: 'name',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'name',
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
          appDEFieldId: 'product_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'product_id',
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
      pagingSize: 20,
      sortMode: 'REMOTE',
      enableCustomized: true,
      enablePagingBar: true,
      fetchControlAction: {
        appDEMethodId: 'fetchdefault',
        appDataEntityId: 'plmweb.product_tag',
        id: 'fetch',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.product_tag',
        id: 'remove',
      },
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'Main',
      controlType: 'GRID',
      logicName: '主表格',
      appDataEntityId: 'plmweb.product_tag',
      controlParam: {
        id: 'grid',
      },
      modelId: '35e8fd356a6dbe5991131f8d8e22b526',
      modelType: 'PSDEGRID',
      name: 'grid',
      id: 'plmweb.product_tag.main',
    },
    {
      searchButtonStyle: 'DEFAULT',
      deformPages: [
        {
          layout: {
            columnCount: 24,
            layout: 'TABLE_24COL',
          },
          capLanguageRes: {
            lanResTag: 'CONTROL.DEFORM.PRODUCT_TAG.DEFAULT.FORMPAGE.FORMPAGE1',
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
      codeName: 'Default',
      controlType: 'SEARCHFORM',
      logicName: '默认搜索表单',
      appDataEntityId: 'plmweb.product_tag',
      controlParam: {
        id: 'searchform',
      },
      modelId: 'dfb5b982179b12ebb946b4649fd65062',
      modelType: 'PSDEFORM_SEARCHFORM',
      name: 'searchform',
      id: 'plmweb.product_tag.default',
    },
    {
      detoolbarItems: [
        {
          actionLevel: 100,
          noPrivDisplayMode: 2,
          uiactionId: 'new',
          valid: true,
          capLanguageRes: {
            lanResTag: 'TBB.TEXT.*.NEW',
          },
          caption: '新建',
          itemType: 'DEUIACTION',
          sysImage: {
            cssClass: 'fa fa-file-text-o',
            glyph: 'xf0f6@FontAwesome',
          },
          tooltip: '新建',
          tooltipLanguageRes: {
            lanResTag: 'TBB.TOOLTIP.*.NEW',
          },
          showCaption: true,
          showIcon: true,
          id: 'tbitem3',
        },
        {
          actionLevel: 100,
          noPrivDisplayMode: 2,
          uiactionId: 'edit',
          uiactionTarget: 'SINGLEKEY',
          valid: true,
          capLanguageRes: {
            lanResTag: 'TBB.TEXT.*.EDIT',
          },
          caption: '编辑',
          itemType: 'DEUIACTION',
          sysImage: {
            cssClass: 'fa fa-edit',
            glyph: 'xf044@FontAwesome',
          },
          tooltip: '编辑',
          tooltipLanguageRes: {
            lanResTag: 'TBB.TOOLTIP.*.EDIT',
          },
          showCaption: true,
          showIcon: true,
          id: 'tbitem4',
        },
        {
          actionLevel: 100,
          noPrivDisplayMode: 2,
          uiactionId: 'copy',
          uiactionTarget: 'SINGLEKEY',
          valid: true,
          capLanguageRes: {
            lanResTag: 'TBB.TEXT.*.COPY',
          },
          caption: '复制',
          itemType: 'DEUIACTION',
          sysImage: {
            cssClass: 'fa fa-copy',
            glyph: 'xf0c5@FontAwesome',
          },
          tooltip: '复制',
          tooltipLanguageRes: {
            lanResTag: 'TBB.TOOLTIP.*.COPY',
          },
          showCaption: true,
          showIcon: true,
          id: 'tbitem6',
        },
        {
          itemType: 'SEPERATOR',
          id: 'tbitem7',
        },
        {
          actionLevel: 100,
          noPrivDisplayMode: 1,
          uiactionId: 'remove',
          uiactionTarget: 'MULTIKEY',
          valid: true,
          capLanguageRes: {
            lanResTag: 'TBB.TEXT.*.REMOVE',
          },
          caption: '删除',
          itemType: 'DEUIACTION',
          sysImage: {
            cssClass: 'fa fa-remove',
            glyph: 'xf00d@FontAwesome',
          },
          tooltip: '删除',
          tooltipLanguageRes: {
            lanResTag: 'TBB.TOOLTIP.*.REMOVE',
          },
          showCaption: true,
          showIcon: true,
          id: 'tbitem8',
        },
        {
          itemType: 'SEPERATOR',
          id: 'tbitem9',
        },
        {
          actionLevel: 100,
          noPrivDisplayMode: 2,
          uiactionId: 'exportexcel',
          valid: true,
          capLanguageRes: {
            lanResTag: 'TBB.TEXT.*.EXPORT',
          },
          caption: '导出',
          itemType: 'DEUIACTION',
          sysImage: {
            cssClass: 'fa fa-file-excel-o',
            glyph: 'xf1c3@FontAwesome',
          },
          tooltip: '导出',
          tooltipLanguageRes: {
            lanResTag: 'TBB.TOOLTIP.*.EXPORT',
          },
          showCaption: true,
          showIcon: true,
          id: 'tbitem13',
        },
        {
          itemType: 'SEPERATOR',
          id: 'tbitem10',
        },
        {
          detoolbarItems: [
            {
              actionLevel: 100,
              noPrivDisplayMode: 2,
              uiactionId: 'exportmodel',
              valid: true,
              capLanguageRes: {
                lanResTag: 'MENUITEM.CAPTION.*.EXPORTSRF',
              },
              caption: '导出数据模型',
              itemType: 'DEUIACTION',
              sysImage: {
                cssClass: 'fa fa-download',
                glyph: 'xf019@FontAwesome',
              },
              tooltip: '导出数据模型',
              showCaption: true,
              showIcon: true,
              id: 'tbitem21',
            },
            {
              actionLevel: 100,
              noPrivDisplayMode: 2,
              uiactionId: 'import',
              valid: true,
              caption: '数据导入',
              itemType: 'DEUIACTION',
              sysImage: {
                cssClass: 'fa fa-upload',
                glyph: 'xf093@FontAwesome',
              },
              tooltip: '数据导入',
              showCaption: true,
              showIcon: true,
              id: 'tbitem23',
            },
          ],
          valid: true,
          caption: '其它',
          itemType: 'ITEMS',
          tooltip: '其它',
          showCaption: true,
          showIcon: true,
          id: 'tbitem16',
        },
        {
          itemType: 'SEPERATOR',
          id: 'tbitem17',
        },
        {
          actionLevel: 100,
          noPrivDisplayMode: 2,
          uiactionId: 'togglefilter',
          enableToggleMode: true,
          valid: true,
          capLanguageRes: {
            lanResTag: 'TBB.TEXT.*.FILTER',
          },
          caption: '过滤',
          itemType: 'DEUIACTION',
          sysImage: {
            cssClass: 'fa fa-filter',
            glyph: 'xf0b0@FontAwesome',
          },
          tooltip: '过滤',
          tooltipLanguageRes: {
            lanResTag: 'TBB.TOOLTIP.*.FILTER',
          },
          showCaption: true,
          showIcon: true,
          id: 'tbitem19',
        },
        {
          actionLevel: 100,
          noPrivDisplayMode: 2,
          uiactionId: 'help',
          valid: true,
          capLanguageRes: {
            lanResTag: 'TBB.TEXT.*.HELP',
          },
          caption: '帮助',
          itemType: 'DEUIACTION',
          sysImage: {
            cssClass: 'fa fa-question',
            glyph: 'xf128@FontAwesome',
          },
          tooltip: '帮助',
          tooltipLanguageRes: {
            lanResTag: 'TBB.TOOLTIP.*.HELP',
          },
          showCaption: true,
          showIcon: true,
          id: 'tbitem18',
        },
      ],
      xdataControlName: 'grid',
      codeName: 'GridViewtoolbar',
      controlType: 'TOOLBAR',
      logicName: '工具栏模板（默认表格界面）',
      appDataEntityId: 'plmweb.product_tag',
      controlParam: {
        id: 'toolbar',
      },
      modelId: 'ec6fbb681f5e3e6783c2af57e5eefaaa',
      modelType: 'PSDETOOLBAR',
      name: 'toolbar',
      id: 'gridviewtoolbar',
    },
    {
      groupMode: 'SINGLE',
      quickSearchMode: 1,
      enableQuickSearch: true,
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.product_tag',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.PRODUCT_TAG',
      },
      caption: '产品标签',
      codeName: 'GridViewcaptionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.product_tag',
      controlParam: {},
      name: 'captionbar',
      id: 'gridviewcaptionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'Layoutpanel',
    controlStyle: 'APPDEGRIDVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.product_tag',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '产品标签表格视图',
  titleLanguageRes: {
    lanResTag: 'PAGE.TITLE.PRODUCT_TAG.GRIDVIEW',
  },
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '09592d4dcd500ebfd072dcf9247879d2',
  modelType: 'PSAPPDEVIEW',
  name: 'product_tagGridView',
  id: 'plmweb.product_taggridview',
};