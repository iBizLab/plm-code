export default {
  gridRowActiveMode: 1,
  xdataControlName: 'grid',
  loadDefault: true,
  funcViewMode: 'MDATAVIEW',
  deviewCodeName: 'GridView',
  deviewId: '3a36341419bde5409d8572f8d9eb5275',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.SPACE',
  },
  caption: '空间',
  codeName: 'spaceGridView',
  appDataEntityId: 'plmweb.space',
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
          refAppViewId: 'plmweb.spaceeditview',
        },
        appUILogicRefViews: [
          {
            refAppViewId: 'plmweb.spaceeditview',
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
          refAppViewId: 'plmweb.space_setting_view',
        },
        editMode: true,
        appUILogicRefViews: [
          {
            refAppViewId: 'plmweb.space_setting_view',
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
      realTitle: '空间配置',
      refAppViewId: 'plmweb.space_setting_view',
      name: 'EDITDATA',
      id: 'editdata',
    },
    {
      realTitle: '空间编辑视图',
      realTitleLanguageRes: {
        lanResTag: 'PAGE.TITLE.SPACE.EDITVIEW',
      },
      refAppViewId: 'plmweb.spaceeditview',
      name: 'NEWDATA',
      id: 'newdata',
    },
  ],
  controls: [
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
              labelPos: 'LEFT',
              labelWidth: 130,
              noPrivDisplayMode: 1,
              appDEFieldId: 'name',
              editor: {
                editorType: 'TEXTBOX',
                valueType: 'SIMPLE',
                editable: true,
                id: 'n_name_like',
              },
              allowEmpty: true,
              capLanguageRes: {
                lanResTag: 'CONTROL.DEFSFITEM.SPACE.N_NAME_LIKE',
              },
              caption: '空间名称',
              codeName: 'n_name_like',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colLG: 4,
                colMD: 4,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'n_name_like',
            },
          ],
          capLanguageRes: {
            lanResTag: 'CONTROL.DEFORM.SPACE.DEFAULT.FORMPAGE.FORMPAGE1',
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
      appDataEntityId: 'plmweb.space',
      controlParam: {
        id: 'searchform',
      },
      modelId: 'cd986fdbda38298747776b3da594d1c3',
      modelType: 'PSDEFORM_SEARCHFORM',
      name: 'searchform',
      id: 'plmweb.space.default',
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
      appDataEntityId: 'plmweb.space',
      controlParam: {
        id: 'toolbar',
      },
      modelId: 'ec6fbb681f5e3e6783c2af57e5eefaaa',
      modelType: 'PSDETOOLBAR',
      name: 'toolbar',
      id: 'gridviewtoolbar',
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
          dataItemName: 'name',
          excelCaption: '空间',
          appDEFieldId: 'name',
          deuiactionGroup: {
            uiactionGroupDetails: [
              {
                actionLevel: 200,
                afterItemType: 'NONE',
                beforeItemType: 'NONE',
                detailType: 'DEUIACTION',
                uiactionId: 'add_favorite@space',
                tooltip: '星标',
                showIcon: true,
                sysImage: {
                  rawContent:
                    '<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" class="design-iconfont" width="16" height="16">\n  <path d="M9.54013,6.48742551 L8,3.36677551 L6.45987,6.48742551 L3.01604,6.98784551 L5.50802,9.41692551 L4.91975,12.8468255 L8,11.2274255 L11.08025,12.8468255 L10.49195,9.41692551 L12.98395,6.98784551 L9.54013,6.48742551 Z M14.53135,6.20219551 C14.77745,6.23794551 14.87565,6.54033551 14.69765,6.71389551 L11.56645,9.76604551 L12.30565,14.0757255 C12.34765,14.3208255 12.09045,14.5077255 11.87035,14.3920255 L8,12.3572255 L4.12966,14.3920255 C3.90957,14.5077255 3.65234,14.3208255 3.69437,14.0757255 L4.43354,9.76604551 L1.30237,6.71389551 C1.12431,6.54033551 1.22256,6.23794551 1.46863,6.20219551 L5.79581,5.57341551 L7.73098,1.65232551 C7.84103,1.42934551 8.15898,1.42935551 8.26902,1.65232551 L10.20415,5.57341551 L14.53135,6.20219551 Z" fill-opacity=".9" fill="#557DA5" fill-rule="nonzero"></path>\n</svg>',
                },
                id: 'u18c8e7f',
              },
              {
                actionLevel: 250,
                afterItemType: 'NONE',
                beforeItemType: 'NONE',
                detailType: 'DEUIACTION',
                uiactionId: 'cancel_favorite@space',
                tooltip: '取消星标',
                showIcon: true,
                sysImage: {
                  rawContent:
                    '<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" class="design-iconfont" width="16" height="16">\n  <path d="M14.53135,6.20219551 C14.77745,6.23794551 14.87565,6.54033551 14.69765,6.71389551 L11.56645,9.76604551 L12.30565,14.0757255 C12.34765,14.3208255 12.09045,14.5077255 11.87035,14.3920255 L8,12.3572255 L4.12966,14.3920255 C3.90957,14.5077255 3.65234,14.3208255 3.69437,14.0757255 L4.43354,9.76604551 L1.30237,6.71389551 C1.12431,6.54033551 1.22256,6.23794551 1.46863,6.20219551 L5.79581,5.57341551 L7.73098,1.65232551 C7.84103,1.42934551 8.15898,1.42935551 8.26902,1.65232551 L10.20415,5.57341551 L14.53135,6.20219551 Z" fill-opacity=".9" fill="#FFB31A" fill-rule="nonzero"></path>\n</svg>',
                },
                id: 'u94d997a',
              },
              {
                actionLevel: 100,
                afterItemType: 'NONE',
                beforeItemType: 'NONE',
                caption: '空间信息',
                detailType: 'DEUIACTION',
                uiactionId: 'space_info@space',
                showCaption: true,
                showIcon: true,
                sysImage: {
                  cssClass: 'fa fa-info-circle',
                  glyph: 'xf05a@FontAwesome',
                },
                id: 'u63cd4ae',
              },
              {
                actionLevel: 100,
                afterItemType: 'NONE',
                beforeItemType: 'NONE',
                caption: '空间成员',
                detailType: 'DEUIACTION',
                uiactionId: 'open_space_member@space',
                showCaption: true,
                showIcon: true,
                sysImage: {
                  cssClass: 'fa fa-users',
                  glyph: 'xf0c0@FontAwesome',
                },
                id: 'uf9c141d',
              },
              {
                actionLevel: 100,
                afterItemType: 'NONE',
                beforeItemType: 'NONE',
                caption: '编辑基本信息',
                detailType: 'DEUIACTION',
                uiactionId: 'edit_space_info@space',
                showCaption: true,
                showIcon: true,
                sysImage: {
                  cssClass: 'fa fa-edit',
                  glyph: 'xf044@FontAwesome',
                },
                id: 'uecc4a08',
              },
              {
                actionLevel: 100,
                afterItemType: 'NONE',
                beforeItemType: 'NONE',
                caption: '更多设置',
                detailType: 'DEUIACTION',
                uiactionId: 'more_setting@space',
                showCaption: true,
                showIcon: true,
                sysImage: {
                  cssClass: 'fa fa-th-list',
                  glyph: 'xf00b@FontAwesome',
                },
                id: 'u5890174',
              },
              {
                actionLevel: 100,
                afterItemType: 'NONE',
                beforeItemType: 'NONE',
                caption: '回收站',
                detailType: 'DEUIACTION',
                uiactionId: 'open_deleted_view@space',
                showCaption: true,
                showIcon: true,
                sysImage: {
                  cssClass: 'fa fa-trash-o',
                  glyph: 'xf014@FontAwesome',
                },
                id: 'u57c9a6e',
              },
              {
                actionLevel: 200,
                afterItemType: 'NONE',
                beforeItemType: 'NONE',
                detailType: 'DEUIACTION',
                uiactionId: 'open_new@space',
                tooltip: '新窗口打开',
                showIcon: true,
                sysImage: {
                  rawContent:
                    '<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" class="design-iconfont" width="16" height="16">\n  <path d="M7.875,1.75 C7.94375,1.75 8,1.80625 8,1.875 L8,2.75 C8,2.81875 7.94375,2.875 7.875,2.875 L2.875,2.875 L2.875,13.125 L13.125,13.125 L13.125,8.125 C13.125,8.05625 13.18125,8 13.25,8 L14.125,8 C14.19375,8 14.25,8.05625 14.25,8.125 L14.25,13.75 C14.25,14.0265625 14.0265625,14.25 13.75,14.25 L2.25,14.25 C1.9734375,14.25 1.75,14.0265625 1.75,13.75 L1.75,2.25 C1.75,1.9734375 1.9734375,1.75 2.25,1.75 Z M12.7666777,2.4349185 C12.7666777,2.333356 12.8838652,2.277106 12.9635527,2.339606 L14.9635527,3.917731 C15.0260527,3.9661685 15.0260527,4.0599185 14.9635527,4.1099185 L12.9619902,5.689606 C12.8823027,5.752106 12.7651152,5.695856 12.7651152,5.5942935 L12.7651152,4.595856 C12.5635527,4.5974185 12.3619902,4.6099185 12.1588652,4.6349185 C11.4994902,4.7161685 10.8760527,4.9192935 10.2979277,5.2411685 C9.70261522,5.570856 9.18542772,6.0161685 8.76042772,6.558356 C8.33699022,7.1005435 8.03074022,7.708356 7.85261522,8.367731 C7.68074022,9.0036685 7.63386522,9.6599185 7.71355272,10.317731 C7.72449022,10.402106 7.73699022,10.486481 7.75105272,10.5692935 L6.58074022,10.5692935 C6.35261522,8.9474185 6.76042772,7.2380435 7.84792772,5.8442935 C9.07917772,4.2692935 10.9104277,3.442731 12.7635527,3.4349185 Z" fill="#557DA5" fill-rule="nonzero"></path>\n</svg>',
                },
                id: 'uea69d99',
              },
            ],
            uniqueTag: 'Space__Usr0227253924',
            name: '空间操作列',
            id: 'usr0227253924',
          },
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'CONTROL.DEGRID.SPACE.MAIN.DEFGRIDCOLUMN.NAME',
          },
          caption: '空间',
          codeName: 'name',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 300,
          widthUnit: 'STAR',
          enableSort: true,
          id: 'name',
        },
        {
          clconvertMode: 'NONE',
          dataItemName: 'identifier',
          excelCaption: '标识',
          appDEFieldId: 'identifier',
          valueType: 'SIMPLE',
          aggMode: 'NONE',
          align: 'LEFT',
          capLanguageRes: {
            lanResTag: 'DEF.LNAME.SPACE.IDENTIFIER',
          },
          caption: '标识',
          codeName: 'identifier',
          columnType: 'DEFGRIDCOLUMN',
          noPrivDisplayMode: 1,
          width: 200,
          widthUnit: 'PX',
          id: 'identifier',
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
          appDEFieldId: 'identifier',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'identifier',
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
          appDEFieldId: 'category_id',
          valueType: 'SIMPLE',
          dataType: 25,
          id: 'category_id',
        },
        {
          appDEFieldId: 'name',
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
      enableCustomized: true,
      enablePagingBar: true,
      fetchControlAction: {
        appDEMethodId: 'fetchdefault',
        appDataEntityId: 'plmweb.space',
        id: 'fetch',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.space',
        id: 'remove',
      },
      autoLoad: true,
      showBusyIndicator: true,
      controls: [
        {
          detoolbarItems: [
            {
              actionLevel: 100,
              noPrivDisplayMode: 2,
              uiactionId: 'move_out_category@space',
              uiactionTarget: 'MULTIKEY',
              valid: true,
              caption: '移除',
              itemType: 'DEUIACTION',
              sysImage: {
                cssClass: 'fa fa-mail-reply',
                glyph: 'xf112@FontAwesome',
              },
              tooltip: '移除',
              showCaption: true,
              showIcon: true,
              id: 'deuiaction1',
            },
          ],
          codeName: 'GridViewgrid_batchtoolbar',
          controlType: 'TOOLBAR',
          logicName: '分类下空间工具栏',
          appDataEntityId: 'plmweb.space',
          controlParam: {
            id: 'grid_batchtoolbar',
          },
          modelId: '2d63581c6ba4dabc275de95d3780fa3f',
          modelType: 'PSDETOOLBAR',
          name: 'grid_batchtoolbar',
          id: 'gridviewgrid_batchtoolbar',
        },
      ],
      codeName: 'Main',
      controlType: 'GRID',
      logicName: '主表格',
      appDataEntityId: 'plmweb.space',
      controlParam: {
        id: 'grid',
      },
      modelId: 'f465e063a4a325e393b1291fd7afca8e',
      modelType: 'PSDEGRID',
      name: 'grid',
      id: 'plmweb.space.main',
    },
    {
      groupMode: 'SINGLE',
      quickSearchMode: 1,
      enableQuickSearch: true,
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.space',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.SPACE',
      },
      caption: '空间',
      codeName: 'GridViewcaptionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.space',
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
    appDataEntityId: 'plmweb.space',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '空间表格视图',
  titleLanguageRes: {
    lanResTag: 'PAGE.TITLE.SPACE.GRIDVIEW',
  },
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '5fbec923af6c87a596133c00ea731001',
  modelType: 'PSAPPDEVIEW',
  name: 'spaceGridView',
  id: 'plmweb.spacegridview',
};