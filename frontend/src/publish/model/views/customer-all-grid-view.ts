export default {
  gridRowActiveMode: 1,
  enableRowEdit: true,
  rowEditDefault: true,
  xdataControlName: 'grid',
  loadDefault: true,
  deviewCodeName: 'all_grid_view',
  deviewId: 'ff83056019ea41f8f4b318b12c0a1a97',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.CUSTOMER',
  },
  caption: '全部客户',
  codeName: 'customer_all_grid_view',
  appDataEntityId: 'plmweb.customer',
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
                    caption: '搜索栏',
                    itemStyle: 'DEFAULT',
                    itemType: 'CTRLPOS',
                    layoutPos: {
                      shrink: 1,
                      layout: 'FLEX',
                    },
                    showCaption: true,
                    id: 'searchbar',
                  },
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
            caption: '表格',
            itemStyle: 'DEFAULT',
            itemType: 'CTRLPOS',
            layoutPos: {
              grow: 1,
              shrink: 1,
              layout: 'FLEX',
            },
            showCaption: true,
            id: 'grid',
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
            refAppViewId: 'plmweb.customer_quick_create_view',
          },
          appUILogicRefViews: [
            {
              openMode: 'POPUPMODAL',
              refAppViewId: 'plmweb.customer_quick_create_view',
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
            refAppViewId: 'plmweb.customer_main_view',
          },
          editMode: true,
          appUILogicRefViews: [
            {
              openMode: 'INDEXVIEWTAB_POPUPMODAL',
              refAppViewId: 'plmweb.customer_main_view',
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
        realOpenMode: 'INDEXVIEWTAB_POPUPMODAL',
        realTitle: '客户实体主视图',
        refAppViewId: 'plmweb.customer_main_view',
        name: 'EDITDATA',
        id: 'editdata',
      },
      {
        realOpenMode: 'POPUPMODAL',
        realTitle: '新建客户',
        refAppViewId: 'plmweb.customer_quick_create_view',
        name: 'NEWDATA',
        id: 'newdata',
      },
    ],
    controls: [
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
            caption: '新建客户',
            itemType: 'DEUIACTION',
            sysImage: {
              cssClass: 'fa fa-plus',
              glyph: 'xf067@FontAwesome',
            },
            tooltip: '新建客户',
            tooltipLanguageRes: {
              lanResTag: 'TBB.TOOLTIP.*.NEW',
            },
            showCaption: true,
            showIcon: true,
            id: 'deuiaction4',
          },
          {
            detoolbarItems: [
              {
                actionLevel: 100,
                noPrivDisplayMode: 2,
                uiactionId: 'import',
                valid: true,
                caption: '导入客户',
                itemType: 'DEUIACTION',
                sysImage: {
                  cssClass: 'fa fa-upload',
                  glyph: 'xf093@FontAwesome',
                },
                tooltip: '导入客户',
                showCaption: true,
                showIcon: true,
                id: 'deuiaction2',
              },
              {
                actionLevel: 100,
                noPrivDisplayMode: 2,
                uiactionId: 'exportexcel',
                valid: true,
                capLanguageRes: {
                  lanResTag: 'TBB.TEXT.*.EXPORT',
                },
                caption: '导出客户',
                itemType: 'DEUIACTION',
                sysImage: {
                  cssClass: 'fa fa-file-excel-o',
                  glyph: 'xf1c3@FontAwesome',
                },
                tooltip: '导出客户',
                tooltipLanguageRes: {
                  lanResTag: 'TBB.TOOLTIP.*.EXPORT',
                },
                showCaption: true,
                showIcon: true,
                id: 'deuiaction3',
              },
            ],
            valid: true,
            itemType: 'ITEMS',
            sysImage: {
              cssClass: 'fa fa-list-ul',
              glyph: 'xf0ca@FontAwesome',
            },
            showCaption: true,
            showIcon: true,
            id: 'items1',
          },
        ],
        xdataControlName: 'grid',
        codeName: 'all_grid_view_toolbar',
        controlType: 'TOOLBAR',
        logicName: '新建客户',
        appDataEntityId: 'plmweb.customer',
        controlParam: {
          id: 'toolbar',
        },
        modelId: 'db86f9e6c4308aa824bc91a89950c482',
        modelType: 'PSDETOOLBAR',
        name: 'toolbar',
        id: 'all_grid_view_toolbar',
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
            excelCaption: '客户名称',
            appDEFieldId: 'name',
            deuiactionGroup: {
              uiactionGroupDetails: [
                {
                  actionLevel: 100,
                  afterItemType: 'NONE',
                  beforeItemType: 'NONE',
                  caption: '设置类别',
                  detailType: 'DEUIACTION',
                  uiactionId: 'add_categories@customer',
                  showCaption: true,
                  showIcon: true,
                  sysImage: {
                    cssClass: 'fa fa-edit',
                    glyph: 'xf044@FontAwesome',
                  },
                  id: 'u3b2b1f1',
                },
                {
                  actionLevel: 100,
                  afterItemType: 'NONE',
                  beforeItemType: 'NONE',
                  caption: '删除',
                  detailType: 'DEUIACTION',
                  uiactionId: 'delete_customer@customer',
                  showCaption: true,
                  showIcon: true,
                  sysImage: {
                    cssClass: 'fa fa-trash-o',
                    glyph: 'xf014@FontAwesome',
                  },
                  id: 'u40c2174',
                },
              ],
              appDataEntityId: 'plmweb.customer',
              uniqueTag: 'customer__Usr1220480172',
              name: '主表格操作列',
              id: 'usr1220480172',
            },
            valueType: 'SIMPLE',
            aggMode: 'NONE',
            align: 'LEFT',
            capLanguageRes: {
              lanResTag: 'DEF.LNAME.NAME',
            },
            caption: '客户名称',
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
            dataItemName: 'scale',
            excelCaption: '规模',
            appDEFieldId: 'scale',
            valueType: 'SIMPLE',
            enableRowEdit: true,
            aggMode: 'NONE',
            align: 'LEFT',
            caption: '规模',
            codeName: 'scale',
            columnType: 'DEFGRIDCOLUMN',
            noPrivDisplayMode: 1,
            width: 200,
            widthUnit: 'PX',
            enableSort: true,
            id: 'scale',
          },
          {
            clconvertMode: 'FRONT',
            dataItemName: 'grade_id',
            excelCaption: '等级',
            appCodeListId: 'plmweb.prodmgmt__customer_level',
            appDEFieldId: 'grade_id',
            valueType: 'SIMPLE',
            enableRowEdit: true,
            aggMode: 'NONE',
            align: 'LEFT',
            caption: '等级',
            codeName: 'grade_id',
            columnType: 'DEFGRIDCOLUMN',
            noPrivDisplayMode: 1,
            width: 100,
            widthUnit: 'PX',
            enableSort: true,
            id: 'grade_id',
          },
          {
            clconvertMode: 'FRONT',
            dataItemName: 'industry_id',
            excelCaption: '行业',
            appCodeListId: 'plmweb.prodmgmt__customer_sector',
            appDEFieldId: 'industry_id',
            valueType: 'SIMPLE',
            enableRowEdit: true,
            aggMode: 'NONE',
            align: 'LEFT',
            caption: '行业',
            codeName: 'industry_id',
            columnType: 'DEFGRIDCOLUMN',
            noPrivDisplayMode: 1,
            width: 100,
            widthUnit: 'PX',
            enableSort: true,
            id: 'industry_id',
          },
          {
            clconvertMode: 'FRONT',
            dataItemName: 'categories',
            excelCaption: '类别',
            appCodeListId: 'plmweb.prodmgmt__category',
            appDEFieldId: 'categories',
            valueType: 'SIMPLE',
            enableRowEdit: true,
            aggMode: 'NONE',
            align: 'LEFT',
            caption: '类别',
            codeName: 'categorys',
            columnType: 'DEFGRIDCOLUMN',
            noPrivDisplayMode: 1,
            width: 200,
            widthUnit: 'PX',
            enableSort: true,
            id: 'categorys',
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
            width: 200,
            widthUnit: 'PX',
            enableSort: true,
            id: 'assignee_name',
          },
          {
            clconvertMode: 'NONE',
            dataItemName: 'ticket_finish',
            excelCaption: '已完成工单数',
            appDEFieldId: 'ticket_finish',
            valueType: 'SIMPLE',
            aggMode: 'NONE',
            align: 'LEFT',
            caption: '已完成工单数',
            codeName: 'ticket_finish',
            columnType: 'DEFGRIDCOLUMN',
            noPrivDisplayMode: 1,
            width: 200,
            widthUnit: 'PX',
            enableSort: true,
            id: 'ticket_finish',
          },
          {
            clconvertMode: 'NONE',
            dataItemName: 'ticket_total',
            excelCaption: '工单总数',
            appDEFieldId: 'ticket_total',
            valueType: 'SIMPLE',
            aggMode: 'NONE',
            align: 'LEFT',
            caption: '工单总数',
            codeName: 'ticket_total',
            columnType: 'DEFGRIDCOLUMN',
            noPrivDisplayMode: 1,
            width: 200,
            widthUnit: 'PX',
            enableSort: true,
            id: 'ticket_total',
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
            appDEFieldId: 'scale',
            valueType: 'SIMPLE',
            dataType: 9,
            id: 'scale',
          },
          {
            appDEFieldId: 'grade_id',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'grade_id',
          },
          {
            appDEFieldId: 'industry_id',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'industry_id',
          },
          {
            appDEFieldId: 'categories',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'categories',
          },
          {
            appDEFieldId: 'assignee_name',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'assignee_name',
          },
          {
            appDEFieldId: 'ticket_finish',
            valueType: 'SIMPLE',
            dataType: 9,
            id: 'ticket_finish',
          },
          {
            appDEFieldId: 'ticket_total',
            valueType: 'SIMPLE',
            dataType: 9,
            id: 'ticket_total',
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
            caption: '规模',
            codeName: 'scale',
            enableCond: 3,
            appDEFieldId: 'scale',
            editor: {
              editorType: 'TEXTBOX',
              valueType: 'SIMPLE',
              editable: true,
              id: 'scale',
            },
            allowEmpty: true,
            id: 'scale',
          },
          {
            caption: '等级',
            codeName: 'grade_id',
            enableCond: 3,
            appDEFieldId: 'grade_id',
            editor: {
              singleSelect: true,
              appCodeListId: 'plmweb.prodmgmt__customer_level',
              editorType: 'DROPDOWNLIST',
              valueType: 'SIMPLE',
              editable: true,
              id: 'grade_id',
            },
            allowEmpty: true,
            needCodeListConfig: true,
            id: 'grade_id',
          },
          {
            caption: '行业',
            codeName: 'industry_id',
            enableCond: 3,
            appDEFieldId: 'industry_id',
            editor: {
              singleSelect: true,
              appCodeListId: 'plmweb.prodmgmt__customer_sector',
              editorType: 'DROPDOWNLIST',
              valueType: 'SIMPLE',
              editable: true,
              id: 'industry_id',
            },
            allowEmpty: true,
            needCodeListConfig: true,
            id: 'industry_id',
          },
          {
            caption: '类别',
            codeName: 'categorys',
            enableCond: 3,
            appDEFieldId: 'categories',
            editor: {
              appCodeListId: 'plmweb.prodmgmt__category',
              editorParams: {
                readonly: 'true',
              },
              editorType: 'MDROPDOWNLIST',
              valueType: 'SIMPLE',
              editable: true,
              readOnly: true,
              id: 'categorys',
            },
            allowEmpty: true,
            needCodeListConfig: true,
            id: 'categorys',
          },
          {
            caption: '负责人',
            codeName: 'assignee_name',
            enableCond: 3,
            appDEFieldId: 'assignee_name',
            editor: {
              singleSelect: true,
              handlerType: 'PickupText',
              appDEACModeId: 'member_select',
              appDEDataSetId: 'fetch_default',
              appDataEntityId: 'plmweb.product_member',
              uiactionGroup: {
                uiactionGroupDetails: [
                  {
                    actionLevel: 100,
                    afterItemType: 'NONE',
                    beforeItemType: 'NONE',
                    caption: '跳转至成员设置',
                    detailType: 'DEUIACTION',
                    uiactionId: 'jump_to_member_set@product_member',
                    tooltip: '跳转至成员设置',
                    showCaption: true,
                    showIcon: true,
                    sysImage: {
                      cssClass: 'fa fa-user-md',
                      glyph: 'xf0f0@FontAwesome',
                    },
                    id: 'u4befff7',
                  },
                ],
                appDataEntityId: 'plmweb.product_member',
                uniqueTag: 'product_member__Usr0311005787',
                name: '跳转至成员设置',
                id: 'usr0311005787',
              },
              enableAC: true,
              forceSelection: true,
              showTrigger: true,
              valueItemName: 'assignee_id',
              editorParams: {
                'SRFNAVPARAM.n_department_id_eq': '%srforgsectorid%',
                AC: 'TRUE',
                TRIGGER: 'TRUE',
                URL: 'products/${context.product}/product_members/fetch_default',
                PICKUPVIEW: 'FALSE',
                USERMETHOD: 'post',
                USERMAP: '{"id":"user_id","name":"name"}',
                DEPTMAP: '{"id":"id","name":"display_name"}',
                DEPTMETHOD: 'get',
                DEPTURL: '/users/fetch_default',
              },
              editorStyle: 'PERSONEL_SELECT_PRODUCT',
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
        pagingSize: 20,
        sortMode: 'REMOTE',
        enableCustomized: true,
        enablePagingBar: true,
        enableRowEdit: true,
        enableRowNew: true,
        createControlAction: {
          appDEMethodId: 'create',
          appDataEntityId: 'plmweb.customer',
          id: 'create',
        },
        fetchControlAction: {
          appDEMethodId: 'fetch_normal',
          appDataEntityId: 'plmweb.customer',
          id: 'fetch',
        },
        getDraftControlAction: {
          appDEMethodId: 'get_draft',
          appDataEntityId: 'plmweb.customer',
          id: 'loaddraft',
        },
        getControlAction: {
          appDEMethodId: 'get',
          appDataEntityId: 'plmweb.customer',
          id: 'load',
        },
        dedataImportId: 'import_customer',
        removeControlAction: {
          appDEMethodId: 'remove',
          appDataEntityId: 'plmweb.customer',
          id: 'remove',
        },
        updateControlAction: {
          appDEMethodId: 'update',
          appDataEntityId: 'plmweb.customer',
          id: 'update',
        },
        autoLoad: true,
        showBusyIndicator: true,
        controls: [
          {
            detoolbarItems: [
              {
                actionLevel: 100,
                noPrivDisplayMode: 2,
                uiactionId: 'add_categories@customer',
                uiactionTarget: 'MULTIKEY',
                valid: true,
                caption: '设置类别',
                itemType: 'DEUIACTION',
                sysImage: {
                  cssClass: 'fa fa-edit',
                  glyph: 'xf044@FontAwesome',
                },
                tooltip: '设置类别',
                showCaption: true,
                showIcon: true,
                id: 'deuiaction1',
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
            codeName: 'all_grid_view_grid_batchtoolbar',
            controlType: 'TOOLBAR',
            logicName: '客户批操作工具栏',
            appDataEntityId: 'plmweb.customer',
            controlParam: {
              id: 'grid_batchtoolbar',
            },
            modelId: 'e36afab8d7a6fa9a3baac0dd6536bfb0',
            modelType: 'PSDETOOLBAR',
            name: 'grid_batchtoolbar',
            id: 'all_grid_view_grid_batchtoolbar',
          },
        ],
        codeName: 'main',
        controlStyle: 'NUMBER_GRID',
        controlType: 'GRID',
        logicName: '主表格',
        appDataEntityId: 'plmweb.customer',
        controlParam: {
          id: 'grid',
        },
        sysPFPluginId: 'number_grid',
        modelId: '8a84394a0fc65c70fdebb64e06e707ab',
        modelType: 'PSDEGRID',
        name: 'grid',
        id: 'plmweb.customer.main',
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
                appDEFieldId: 'name',
                editor: {
                  editorType: 'TEXTBOX',
                  placeHolder: '请输入客户名称',
                  valueType: 'SIMPLE',
                  editable: true,
                  id: 'n_name_like',
                },
                allowEmpty: true,
                capLanguageRes: {
                  lanResTag: 'CONTROL.DEFSFITEM.CUSTOMER.N_NAME_LIKE',
                },
                caption: '客户名称',
                codeName: 'n_name_like',
                detailStyle: 'DEFAULT',
                detailType: 'FORMITEM',
                layoutPos: {
                  colLG: 8,
                  colMD: 8,
                  layout: 'TABLE_24COL',
                },
                id: 'n_name_like',
              },
            ],
            capLanguageRes: {
              lanResTag: 'CONTROL.DEFORM.CUSTOMER.DEFAULT.FORMPAGE.FORMPAGE1',
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
        appDataEntityId: 'plmweb.customer',
        controlParam: {
          id: 'searchform',
        },
        modelId: 'bdabe4f6b9237485d0f81f73f46df124',
        modelType: 'PSDEFORM_SEARCHFORM',
        name: 'searchform',
        id: 'plmweb.customer.default',
      },
      {
        groupMode: 'SINGLE',
        searchBarFilters: [
          {
            dataType: 9,
            labelPos: 'NONE',
            editor: {
              editorType: 'NUMBER',
              valueType: 'SIMPLE',
              editable: true,
              id: 'scale',
            },
            allowEmpty: true,
            itemType: 'FILTER',
            appDEFieldId: 'scale',
            id: 'scale',
          },
          {
            dataType: 25,
            labelPos: 'NONE',
            editor: {
              singleSelect: true,
              appCodeListId: 'plmweb.prodmgmt__customer_level',
              editorType: 'DROPDOWNLIST',
              valueType: 'SIMPLE',
              editable: true,
              id: 'grade_id',
            },
            allowEmpty: true,
            needCodeListConfig: true,
            itemType: 'FILTER',
            appDEFieldId: 'grade_id',
            id: 'grade_id',
          },
          {
            dataType: 25,
            labelPos: 'NONE',
            editor: {
              singleSelect: true,
              enableAC: true,
              forceSelection: true,
              showTrigger: true,
              valueItemName: 'assignee_id',
              editorParams: {
                ISADDSYMBOL: 'true',
                MULTIPLE: 'true',
                'SRFNAVPARAM.n_department_id_eq': '%srforgsectorid%',
                AC: 'TRUE',
                TRIGGER: 'TRUE',
                URL: 'products/${context.product}/product_members/fetch_default',
                PICKUPVIEW: 'FALSE',
                USERMETHOD: 'post',
                USERMAP: '{"id":"user_id","name":"name"}',
                DEPTMAP: '{"id":"id","name":"display_name"}',
                DEPTMETHOD: 'get',
                DEPTURL: '/users/fetch_default',
              },
              editorStyle: 'PERSONEL_SELECT_PRODUCT',
              editorType: 'PICKEREX_TRIGGER',
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
              id: 'assignee_id',
            },
            allowEmpty: true,
            caption: '负责人',
            itemType: 'FILTER',
            appDEFieldId: 'assignee_id',
            id: 'assignee_id',
          },
          {
            dataType: 25,
            labelPos: 'NONE',
            editor: {
              singleSelect: true,
              appCodeListId: 'plmweb.prodmgmt__customer_sector',
              editorType: 'DROPDOWNLIST',
              valueType: 'SIMPLE',
              editable: true,
              id: 'industry_id',
            },
            allowEmpty: true,
            needCodeListConfig: true,
            itemType: 'FILTER',
            appDEFieldId: 'industry_id',
            id: 'industry_id',
          },
        ],
        quickSearchMode: 1,
        enableFilter: true,
        enableQuickSearch: true,
        codeName: 'product_customer',
        controlType: 'SEARCHBAR',
        logicName: '产品下客户',
        appDataEntityId: 'plmweb.customer',
        controlParam: {
          id: 'searchbar',
        },
        modelId: '459c8dea97b668920b46f6dc260a0720',
        modelType: 'PSSYSSEARCHBAR',
        name: 'searchbar',
        id: 'plmweb.customer.product_customer',
      },
      {
        capLanguageRes: {
          lanResTag: 'DE.LNAME.CUSTOMER',
        },
        caption: '全部客户',
        codeName: 'all_grid_view_captionbar',
        controlType: 'CAPTIONBAR',
        appDataEntityId: 'plmweb.customer',
        controlParam: {},
        name: 'captionbar',
        id: 'all_grid_view_captionbar',
      },
    ],
    codeName: 'usr0205806150',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: 'all_grid_view表格视图布局',
    appDataEntityId: 'plmweb.customer',
    controlParam: {},
    modelId: '3b47e988adf32f0f2124063f2978f4ea',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'usr0205806150',
  },
  title: '全部客户',
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '0074777c49b9acb0c8b11f09f553231f',
  modelType: 'PSAPPDEVIEW',
  name: 'customerall_grid_view',
  id: 'plmweb.customer_all_grid_view',
};