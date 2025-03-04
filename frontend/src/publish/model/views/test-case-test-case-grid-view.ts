export default {
  gridRowActiveMode: 1,
  xdataControlName: 'grid',
  loadDefault: true,
  deviewCodeName: 'test_case_grid_view',
  deviewId: 'c6e9b8e52430cf5909d073239cf29c80',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.TEST_CASE',
  },
  caption: '测试用例列表',
  codeName: 'test_case_test_case_grid_view',
  appDataEntityId: 'plmweb.test_case',
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
              {
                actionGroupExtractMode: 'ITEM',
                panelItems: [
                  {
                    rawItem: {
                      content: '<p><span style="color: #ced4d9;">共</span></p>',
                      contentType: 'HTML',
                      predefinedType: 'STATIC_TEXT',
                      id: 'static_text1',
                    },
                    caption: '文本',
                    itemStyle: 'DEFAULT',
                    itemType: 'RAWITEM',
                    layoutPos: {
                      shrink: 1,
                      layout: 'FLEX',
                      spacingLeft: 'OUTERSMALL',
                    },
                    showCaption: true,
                    id: 'static_text1',
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
                      id: 'total',
                    },
                    viewFieldName: 'total',
                    allowEmpty: true,
                    caption: '文本(动态)',
                    itemStyle: 'DEFAULT',
                    itemType: 'FIELD',
                    layoutPos: {
                      shrink: 1,
                      layout: 'FLEX',
                      spacingLeft: 'OUTERSMALL',
                      spacingRight: 'OUTERSMALL',
                    },
                    id: 'total',
                  },
                  {
                    rawItem: {
                      content:
                        '<p><span style="color: #ced4d9;">个测试用例</span></p>',
                      contentType: 'HTML',
                      predefinedType: 'STATIC_TEXT',
                      id: 'static_text',
                    },
                    caption: '文本',
                    itemStyle: 'DEFAULT',
                    itemType: 'RAWITEM',
                    layoutPos: {
                      shrink: 1,
                      layout: 'FLEX',
                    },
                    showCaption: true,
                    id: 'static_text',
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
                  spacingBottom: 'OUTERSMALL',
                  spacingLeft: 'OUTERLARGE',
                },
                sysCss: {
                  cssName: 'dashboard_repair_style',
                },
                id: 'container',
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
        eventNames: 'onLoadSuccess',
        logicTrigger: 'VIEWEVENT',
        logicType: 'APPDEUILOGIC',
        appDEUILogicId: 'get_table_size',
        appDataEntityId: 'plmweb.product',
        builtinLogic: true,
        name: 'LOGIC',
        id: 'logic',
      },
      {
        logicTrigger: 'CUSTOM',
        logicType: 'APPUILOGIC',
        builtinAppUILogic: {
          actionAfterWizard: 'DEFAULT',
          newDataAppView: {
            refAppViewId: 'plmweb.test_case_edit_view',
          },
          appUILogicRefViews: [
            {
              refAppViewId: 'plmweb.test_case_edit_view',
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
            refAppViewId: 'plmweb.test_case_main_view',
          },
          editMode: true,
          appUILogicRefViews: [
            {
              openMode: 'INDEXVIEWTAB_POPUPMODAL',
              refAppViewId: 'plmweb.test_case_main_view',
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
        realTitle: '用例编辑视图',
        realTitleLanguageRes: {
          lanResTag: 'PAGE.TITLE.TEST_CASE.EDITVIEW',
        },
        refAppViewId: 'plmweb.test_case_edit_view',
        name: 'NEWDATA',
        id: 'newdata',
      },
      {
        openMode: 'INDEXVIEWTAB_POPUPMODAL',
        realOpenMode: 'INDEXVIEWTAB_POPUPMODAL',
        realTitle: '用例',
        refAppViewId: 'plmweb.test_case_main_view',
        name: 'EDITDATA',
        id: 'editdata',
      },
    ],
    controls: [
      {
        detoolbarItems: [
          {
            actionLevel: 100,
            buttonStyle: 'STYLE2',
            noPrivDisplayMode: 2,
            uiactionId: 'open_more_test_case@test_case',
            uiactionTarget: 'NONE',
            valid: true,
            caption: '更多',
            itemType: 'DEUIACTION',
            sysCss: {
              cssName: 'swap_icon_text',
            },
            sysImage: {
              rawContent:
                '<?xml version="1.0" standalone="no"?><!DOCTYPE svg PUBLIC "-//W3C//DTD SVG 1.1//EN" "http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd"><svg t="1732774437860" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="11278" width="12" height="12" xmlns:xlink="http://www.w3.org/1999/xlink"><path d="M767.369846 526.099692a47.261538 47.261538 0 0 0-13.705846-29.538461L328.940308 71.837538a47.419077 47.419077 0 1 0-67.032616 67.032616l391.640616 391.640615-391.640616 391.719385a47.419077 47.419077 0 1 0 66.953846 67.032615l424.802462-424.723692a47.261538 47.261538 0 0 0 13.705846-29.459692z" fill="#999999" p-id="11279"></path></svg>',
            },
            tooltip: '查看更多用例',
            showCaption: true,
            showIcon: true,
            id: 'deuiaction1',
          },
        ],
        xdataControlName: 'grid',
        codeName: 'test_case_grid_view_toolbar',
        controlType: 'TOOLBAR',
        logicName: '用例表格视图（仪表盘部件）_工具栏',
        appDataEntityId: 'plmweb.test_case',
        controlParam: {
          id: 'toolbar',
        },
        modelId: '1720bebcdfeaaca12f53de968381bdf3',
        modelType: 'PSDETOOLBAR',
        name: 'toolbar',
        id: 'test_case_grid_view_toolbar',
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
            dataItemName: 'show_identifier',
            excelCaption: '编号',
            appDEFieldId: 'show_identifier',
            valueType: 'SIMPLE',
            aggMode: 'NONE',
            align: 'LEFT',
            caption: '编号',
            codeName: 'show_identifier',
            columnType: 'DEFGRIDCOLUMN',
            noPrivDisplayMode: 1,
            width: 150,
            widthUnit: 'STAR',
            enableSort: true,
            id: 'show_identifier',
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
            width: 150,
            widthUnit: 'STAR',
            enableSort: true,
            id: 'title',
          },
          {
            clconvertMode: 'FRONT',
            dataItemName: 'state',
            excelCaption: '状态',
            appCodeListId: 'plmweb.testmgmt__case_state',
            appDEFieldId: 'state',
            valueType: 'SIMPLE',
            aggMode: 'NONE',
            align: 'LEFT',
            caption: '状态',
            codeName: 'state',
            columnType: 'DEFGRIDCOLUMN',
            noPrivDisplayMode: 1,
            width: 100,
            widthUnit: 'STAR',
            enableSort: true,
            id: 'state',
          },
          {
            clconvertMode: 'NONE',
            dataItemName: 'test_library_name',
            excelCaption: '所属测试库',
            linkAppViewId: 'plmweb.library_redirect_view',
            linkValueItem: 'test_library_id',
            appDEFieldId: 'test_library_name',
            valueType: 'SIMPLE',
            enableLinkView: true,
            aggMode: 'NONE',
            align: 'LEFT',
            caption: '所属测试库',
            codeName: 'test_library_name',
            columnType: 'DEFGRIDCOLUMN',
            noPrivDisplayMode: 1,
            width: 100,
            widthUnit: 'STAR',
            enableSort: true,
            id: 'test_library_name',
          },
        ],
        degridDataItems: [
          {
            appDEFieldId: 'show_identifier',
            scriptCode:
              'var svgIcon = `<span title="测试用例" style="display: flex;align-items: center;"><?xml version="1.0" standalone="no"?><!DOCTYPE svg PUBLIC "-//W3C//DTD SVG 1.1//EN" "http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd"><svg t="1731568581104" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="7114" width="24" height="24" xmlns:xlink="http://www.w3.org/1999/xlink"><path d="M512 1024c399.2 0 512-112.8 512-512S911.2 0 512 0 0 112.8 0 512s112.8 512 512 512z" fill="#5AD8A6" p-id="7115"></path><path d="M731.488 715.04L570.101333 448v-96h-126.933333v96l-161.386667 267.04a35.904 35.904 0 0 0 0.437334 35.392A35.306667 35.306667 0 0 0 312.693333 768h387.914667a35.306667 35.306667 0 0 0 30.506667-17.557333 35.904 35.904 0 0 0 0.426666-35.402667h-0.053333zM473.408 555.552l-74.869333 130.656a15.754667 15.754667 0 0 1-21.706667 5.856l-3.936-2.272a16.074667 16.074667 0 0 1-5.802667-21.856l74.858667-130.656a15.754667 15.754667 0 0 1 21.706667-5.856l3.946666 2.272a16.106667 16.106667 0 0 1 5.834667 21.856h-0.032z" fill="#FFFFFF" p-id="7116"></path><path d="M559.445333 256h-105.621333a10.666667 10.666667 0 0 0-10.666667 10.666667v53.333333h126.954667v-53.333333a10.666667 10.666667 0 0 0-10.666667-10.666667z" fill="#FFFFFF" opacity=".6" p-id="7117"></path></svg></span>`;\r\nreturn `<span style="display: flex; align-items: center;">` + svgIcon + `&nbsp;` + data.show_identifier + `</span>`;',
            valueType: 'SIMPLE',
            customCode: true,
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
            appDEFieldId: 'test_library_name',
            scriptCode:
              'var svgIcon = `<span title="测试库" style="display: flex;align-items: center;"><svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 24 24" class="design-iconfont" width="24" height="24">\r\n  <defs>\r\n    <path d="M9.01651185,3.27273154 C9.31543831,3.27189848 9.60227033,3.39300127 9.81307558,3.60905148 L12.1206744,5.96139483 C12.1627802,6.00466067 12.2201457,6.02891007 12.2799308,6.02871536 L21.2371542,6.02871536 C21.8590036,6.02942731 22.362938,6.54313302 22.3636364,7.17704017 L22.3636364,19.5789479 C22.362938,20.2128551 21.8590036,20.7265608 21.2371542,20.7272727 L2.76284584,20.7272727 C2.14099642,20.7265608 1.63706204,20.2128551 1.63636364,19.5789479 L1.63636364,4.42106066 C1.63706203,3.78715352 2.14099641,3.2734478 2.76284584,3.27273154 L9.01651185,3.27273154 Z M15.59375,9.09375 L8.40625,9.09375 C8.23339844,9.09375 8.09375,9.23339844 8.09375,9.40625 L8.09375,16.59375 C8.09375,16.7666016 8.23339844,16.90625 8.40625,16.90625 L15.59375,16.90625 C15.7666016,16.90625 15.90625,16.7666016 15.90625,16.59375 L15.90625,9.40625 C15.90625,9.23339844 15.7666016,9.09375 15.59375,9.09375 Z M15.203125,9.796875 L15.203125,16.203125 L8.796875,16.203125 L8.796875,9.796875 L15.203125,9.796875 Z M10.5269345,14.015625 C10.3111983,14.015625 10.1363095,14.1905138 10.1363095,14.40625 C10.1363095,14.6219862 10.3111983,14.796875 10.5269345,14.796875 C10.7426707,14.796875 10.9175595,14.6219862 10.9175595,14.40625 C10.9175595,14.1905138 10.7426707,14.015625 10.5269345,14.015625 Z M13.7385725,14.09375 L11.815997,14.09375 C11.7730282,14.09375 11.737872,14.1289063 11.737872,14.171875 L11.737872,14.640625 C11.737872,14.6835938 11.7730282,14.71875 11.815997,14.71875 L13.7385725,14.71875 C13.7815413,14.71875 13.8166975,14.6835938 13.8166975,14.640625 L13.8166975,14.171875 C13.8166975,14.1289063 13.7815413,14.09375 13.7385725,14.09375 Z M11.4557772,12.2446536 L11.272574,12.2446536 C11.216407,12.2446536 11.1634381,12.2717332 11.1307155,12.3175448 L10.5171659,13.1689369 L10.3201696,12.7829992 C10.2872103,12.7374055 10.2345871,12.7102786 10.1784334,12.7102786 L9.9952303,12.7102786 C9.92909044,12.7102786 9.89066344,12.7852672 9.92920487,12.8390224 L10.4160022,13.5141317 C10.4854914,13.6109791 10.6295786,13.6109791 10.6991361,13.5140367 L11.5217208,12.3735112 C11.560344,12.3196422 11.521917,12.2446536 11.4557772,12.2446536 Z M13.7385725,12.6875 L11.815997,12.6875 C11.7730282,12.6875 11.737872,12.7226563 11.737872,12.765625 L11.737872,13.234375 C11.737872,13.2773438 11.7730282,13.3125 11.815997,13.3125 L13.7385725,13.3125 C13.7815413,13.3125 13.8166975,13.2773438 13.8166975,13.234375 L13.8166975,12.765625 C13.8166975,12.7226563 13.7815413,12.6875 13.7385725,12.6875 Z M13.7385725,11.28125 L10.2635598,11.28125 C10.2205911,11.28125 10.1854348,11.3164063 10.1854348,11.359375 L10.1854348,11.828125 C10.1854348,11.8710938 10.2205911,11.90625 10.2635598,11.90625 L13.7385725,11.90625 C13.7815413,11.90625 13.8166975,11.8710937 13.8166975,11.828125 L13.8166975,11.359375 C13.8166975,11.3164062 13.7815413,11.28125 13.7385725,11.28125 Z" id="ybm2uil0m__0io7o8c6ia"></path>\r\n  </defs>\r\n  <use fill="#56AAFC" fill-rule="nonzero" xlink:href="#ybm2uil0m__0io7o8c6ia"></use>\r\n</svg></span>`;\r\nreturn `<span style="display: flex; align-items: center;">` + svgIcon + `&nbsp;` + data.test_library_name + `</span>`;',
            valueType: 'SIMPLE',
            customCode: true,
            dataType: 25,
            id: 'test_library_name',
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
            appDEFieldId: 'maintenance_id',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'maintenance_id',
          },
          {
            appDEFieldId: 'test_library_id',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'test_library_id',
          },
          {
            appDEFieldId: 'suite_id',
            valueType: 'SIMPLE',
            dataType: 25,
            id: 'suite_id',
          },
          {
            appDEFieldId: 'title',
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
        pagingSize: 10,
        sortMode: 'REMOTE',
        enableCustomized: true,
        forceFit: true,
        hideHeader: true,
        singleSelect: true,
        navViewPos: 'NONE',
        fetchControlAction: {
          appDEMethodId: 'fetch_normal',
          appDataEntityId: 'plmweb.test_case',
          id: 'fetch',
        },
        dedataImportId: 'import_test_case',
        removeControlAction: {
          appDEMethodId: 'remove',
          appDataEntityId: 'plmweb.test_case',
          id: 'remove',
        },
        autoLoad: true,
        showBusyIndicator: true,
        codeName: 'test_case_grid_view_grid',
        controlType: 'GRID',
        logicName: '用例表格视图（仪表盘部件）_表格',
        appDataEntityId: 'plmweb.test_case',
        controlParam: {
          id: 'grid',
        },
        modelId: '3e62f00599ccaf8befc877f1972923a7',
        modelType: 'PSDEGRID',
        name: 'grid',
        id: 'plmweb.test_case.test_case_grid_view_grid',
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
        codeName: 'test_case_grid_view_search_form',
        controlType: 'SEARCHFORM',
        logicName: '用例表格视图（仪表盘部件）_搜索表单',
        appDataEntityId: 'plmweb.test_case',
        controlParam: {
          id: 'searchform',
        },
        modelId: '93a00761b379cc5e675b17e54220d596',
        modelType: 'PSDEFORM_SEARCHFORM',
        name: 'searchform',
        id: 'plmweb.test_case.test_case_grid_view_search_form',
      },
      {
        groupMode: 'SINGLE',
        controlType: 'SEARCHBAR',
        appDataEntityId: 'plmweb.test_case',
        controlParam: {
          id: 'searchbar',
        },
        id: 'searchbar',
      },
      {
        capLanguageRes: {
          lanResTag: 'DE.LNAME.TEST_CASE',
        },
        caption: '测试用例列表',
        codeName: 'test_case_grid_view_captionbar',
        controlType: 'CAPTIONBAR',
        appDataEntityId: 'plmweb.test_case',
        controlParam: {},
        name: 'captionbar',
        id: 'test_case_grid_view_captionbar',
      },
    ],
    codeName: 'usr1112789424',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: 'test_case_grid_view表格视图布局',
    appDataEntityId: 'plmweb.test_case',
    controlParam: {},
    modelId: 'fb3c25335e61cdf97ea1ee74bb3558b6',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'usr1112789424',
  },
  title: '用例表格视图',
  viewStyle: 'DEFAULT',
  viewType: 'DEGRIDVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '6a6204d14370f467cba1710909aadf30',
  modelType: 'PSAPPDEVIEW',
  name: 'test_casetest_case_grid_view',
  id: 'plmweb.test_case_test_case_grid_view',
};
