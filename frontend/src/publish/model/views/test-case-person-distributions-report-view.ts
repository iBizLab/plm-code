export default {
  enableSearch: true,
  loadDefault: true,
  deviewCodeName: 'person_distributions_report_view',
  deviewId: '7916c73c80def40446cab02c11079797',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.TEST_CASE',
  },
  caption: '测试用例维护人分布',
  codeName: 'test_case_person_distributions_report_view',
  appDataEntityId: 'plmweb.test_case',
  appViewNavContexts: [
    {
      rawValue: true,
      key: 'SRFREADONLY',
      value: 'false',
      name: 'SRFREADONLY',
      id: 'srfreadonly',
    },
  ],
  viewLayoutPanel: {
    viewProxyMode: true,
    layoutMode: 'Flex',
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
                actionGroupExtractMode: 'ITEM',
                panelItems: [
                  {
                    actionGroupExtractMode: 'ITEM',
                    panelItems: [
                      {
                        caption: 'CHART',
                        contentHeight: 100,
                        height: 100,
                        itemStyle: 'DEFAULT',
                        itemType: 'CTRLPOS',
                        layoutPos: {
                          shrink: 1,
                          height: 100,
                          heightMode: 'PERCENTAGE',
                          layout: 'FLEX',
                        },
                        showCaption: true,
                        id: 'chart',
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
                      layoutPos: 'CENTER',
                      heightMode: 'FULL',
                      layout: 'BORDER',
                    },
                    id: 'container3',
                  },
                ],
                predefinedType: 'CONTAINER_SCROLL_MAIN',
                layout: {
                  layout: 'BORDER',
                },
                dataRegionType: 'INHERIT',
                caption: '面板容器',
                itemStyle: 'DEFAULT',
                itemType: 'CONTAINER',
                layoutPos: {
                  layoutPos: 'CENTER',
                  layout: 'BORDER',
                },
                showCaption: true,
                id: 'container_scroll_main',
              },
              {
                actionGroupExtractMode: 'ITEM',
                panelItems: [
                  {
                    actionGroupExtractMode: 'ITEM',
                    panelItems: [
                      {
                        caption: 'SEARCHFORM',
                        itemStyle: 'DEFAULT',
                        itemType: 'CTRLPOS',
                        layoutPos: {
                          shrink: 1,
                          heightMode: 'FULL',
                          layout: 'FLEX',
                        },
                        showCaption: true,
                        id: 'searchform',
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
                      layoutPos: 'CENTER',
                      layout: 'BORDER',
                    },
                    id: 'container',
                  },
                ],
                predefinedType: 'CONTAINER_SCROLL_LEFT',
                layout: {
                  layout: 'BORDER',
                },
                dataRegionType: 'INHERIT',
                caption: '面板容器',
                contentWidth: 450,
                itemStyle: 'DEFAULT',
                itemType: 'CONTAINER',
                layoutPos: {
                  layoutPos: 'WEST',
                  layout: 'BORDER',
                  width: 450,
                  widthMode: 'PX',
                },
                width: 450,
                showCaption: true,
                id: 'container_scroll_left',
              },
            ],
            predefinedType: 'CONTAINER_SCROLL',
            layout: {
              layout: 'BORDER',
            },
            dataRegionType: 'INHERIT',
            caption: '滚动条容器',
            itemStyle: 'DEFAULT',
            itemType: 'CONTAINER',
            layoutPos: {
              shrink: 1,
              layout: 'FLEX',
            },
            id: 'container_scroll',
          },
        ],
        predefinedType: 'CONTAINER',
        layout: {
          dir: 'column',
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
        id: 'page_container',
      },
    ],
    layoutPanel: true,
    appViewEngines: [
      {
        engineCat: 'VIEW',
        engineType: 'ChartView',
        id: 'engine',
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
                labelPos: 'TOP',
                labelWidth: 130,
                noPrivDisplayMode: 1,
                appDEFieldId: 'type',
                editor: {
                  singleSelect: true,
                  appCodeListId: 'plmweb.testmgmt__test_case_type',
                  editorType: 'DROPDOWNLIST',
                  placeHolder: '选择用例类型',
                  valueType: 'SIMPLE',
                  editable: true,
                  id: 'n_type_eq',
                },
                allowEmpty: true,
                needCodeListConfig: true,
                caption: '用例类型',
                codeName: 'n_type_eq',
                detailStyle: 'DEFAULT',
                detailType: 'FORMITEM',
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                showCaption: true,
                id: 'n_type_eq',
              },
              {
                dataType: 25,
                enableCond: 3,
                labelPos: 'TOP',
                labelWidth: 130,
                noPrivDisplayMode: 1,
                appDEFieldId: 'level',
                editor: {
                  singleSelect: true,
                  appCodeListId: 'plmweb.testmgmt__test_case_level',
                  editorType: 'DROPDOWNLIST',
                  placeHolder: '选择重要程度',
                  valueType: 'SIMPLE',
                  editable: true,
                  id: 'n_level_eq',
                },
                allowEmpty: true,
                needCodeListConfig: true,
                caption: '重要程度',
                codeName: 'n_level_eq',
                detailStyle: 'DEFAULT',
                detailType: 'FORMITEM',
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                showCaption: true,
                id: 'n_level_eq',
              },
              {
                dataType: 25,
                enableCond: 3,
                labelPos: 'TOP',
                labelWidth: 130,
                noPrivDisplayMode: 1,
                appDEFieldId: 'maintenance_id',
                editor: {
                  singleSelect: true,
                  appCodeListId: 'plmweb.testmgmt__cur_library_member',
                  editorType: 'DROPDOWNLIST',
                  placeHolder: '选择维护人',
                  valueType: 'SIMPLE',
                  editable: true,
                  id: 'n_maintenance_id_eq',
                },
                allowEmpty: true,
                needCodeListConfig: true,
                caption: '维护人',
                codeName: 'n_maintenance_id_eq',
                detailStyle: 'DEFAULT',
                detailType: 'FORMITEM',
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                showCaption: true,
                id: 'n_maintenance_id_eq',
              },
              {
                dataType: 25,
                enableCond: 3,
                labelPos: 'TOP',
                labelWidth: 130,
                noPrivDisplayMode: 1,
                appDEFieldId: 'create_man',
                editor: {
                  singleSelect: true,
                  appCodeListId: 'plmweb.testmgmt__cur_library_member',
                  editorType: 'DROPDOWNLIST',
                  placeHolder: '选择创建人',
                  valueType: 'SIMPLE',
                  editable: true,
                  id: 'n_create_man_eq',
                },
                allowEmpty: true,
                needCodeListConfig: true,
                caption: '创建人',
                codeName: 'n_create_man_eq',
                detailStyle: 'DEFAULT',
                detailType: 'FORMITEM',
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                showCaption: true,
                id: 'n_create_man_eq',
              },
              {
                dataType: 25,
                enableCond: 3,
                labelPos: 'TOP',
                labelWidth: 130,
                noPrivDisplayMode: 1,
                appDEFieldId: 'test_type',
                editor: {
                  singleSelect: true,
                  appCodeListId: 'plmweb.testmgmt__test_case_test_type',
                  editorType: 'DROPDOWNLIST',
                  placeHolder: '选择测试类型',
                  valueType: 'SIMPLE',
                  editable: true,
                  id: 'n_test_type_eq',
                },
                allowEmpty: true,
                needCodeListConfig: true,
                caption: '测试类型',
                codeName: 'n_test_type_eq',
                detailStyle: 'DEFAULT',
                detailType: 'FORMITEM',
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                showCaption: true,
                id: 'n_test_type_eq',
              },
              {
                dataType: 25,
                enableCond: 3,
                labelPos: 'TOP',
                labelWidth: 130,
                noPrivDisplayMode: 1,
                appDEFieldId: 'state',
                editor: {
                  singleSelect: true,
                  appCodeListId: 'plmweb.testmgmt__case_state',
                  editorType: 'DROPDOWNLIST',
                  placeHolder: '选择评审状态',
                  valueType: 'SIMPLE',
                  editable: true,
                  id: 'n_state_eq',
                },
                allowEmpty: true,
                needCodeListConfig: true,
                caption: '评审状态',
                codeName: 'n_state_eq',
                detailStyle: 'DEFAULT',
                detailType: 'FORMITEM',
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                showCaption: true,
                id: 'n_state_eq',
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
        codeName: 'person_distributions_search_form',
        controlType: 'SEARCHFORM',
        logicName: '测试用例维护人分布_搜索表单',
        appDataEntityId: 'plmweb.test_case',
        controlParam: {
          id: 'searchform',
        },
        modelId: '54b815164e026cb34a007799a09fc07e',
        modelType: 'PSDEFORM_SEARCHFORM',
        name: 'searchform',
        id: 'plmweb.test_case.person_distributions_search_form',
      },
      {
        coordinateSystem: 'XY',
        chartCoordinateSystems: [
          {
            chartGrid: {
              chartGridXAxis0Id: '0',
              chartGridYAxis0Id: '0',
              chartCoordinateSystemId: '0',
              type: 'grid',
              name: '[bar_0]直角坐标系[0]',
              id: '0',
            },
            echartsType: 'cartesian2d',
            type: 'XY',
            name: '[bar_0]直角坐标系[0]',
            id: '0',
          },
        ],
        dechartDataGrid: {
          id: '0',
        },
        dechartLegend: {
          legendPos: 'RIGHT',
          showLegend: true,
          id: '0',
        },
        dechartSerieses: [
          {
            catalogField: 'filter_type',
            catalogCodeListId: 'plmweb.testmgmt__cur_library_member',
            echartsType: 'bar',
            chartCoordinateSystemId: '0',
            chartDataSetId: '0',
            chartSeriesEncode: {
              chartXAxisId: '0',
              chartYAxisId: '0',
              x: ['filter_type'],
              y: ['count'],
              type: 'XY',
              name: '坐标系编码',
              id: '0',
            },
            seriesLayoutBy: 'column',
            seriesType: 'bar',
            valueField: 'count',
            enableChartDataSet: true,
            id: 'bar_0',
          },
        ],
        dechartTitle: {
          title: '维护人分布',
          id: '0',
        },
        chartDataSetGroups: [
          {
            appDEDataSetId: 'fetch_person_distributions',
            appDataEntityId: 'plmweb.test_case',
            name: 'PersonDistributions',
            id: '0',
          },
        ],
        chartDataSets: [
          {
            chartDataSetFields: [
              {
                codeListId: 'plmweb.testmgmt__cur_library_member',
                groupField: true,
                name: 'filter_type',
                id: '0',
              },
              {
                index: 1,
                name: 'count',
                id: '1',
              },
            ],
            name: 'bar_0-PersonDistributions',
            id: '0',
          },
        ],
        chartGrids: [
          {
            chartGridXAxis0Id: '0',
            chartGridYAxis0Id: '0',
            chartCoordinateSystemId: '0',
            type: 'grid',
            name: '[bar_0]直角坐标系[0]',
            id: '0',
          },
        ],
        chartXAxises: [
          {
            echartsPos: 'xAxis',
            echartsType: 'category',
            position: 'bottom',
            type: 'category',
            name: 'axis_xAxis_0',
            id: '0',
          },
        ],
        chartYAxises: [
          {
            echartsPos: 'yAxis',
            echartsType: 'value',
            position: 'left',
            type: 'numeric',
            name: 'axis_yAxis_0',
            id: '0',
          },
        ],
        navViewPos: 'NONE',
        fetchControlAction: {
          appDEMethodId: 'fetch_person_distributions',
          appDataEntityId: 'plmweb.test_case',
          id: 'fetch',
        },
        readOnly: true,
        autoLoad: true,
        showBusyIndicator: true,
        codeName: 'person_distributions',
        controlStyle: 'CHART_GRID',
        controlType: 'CHART',
        logicName: 'PersonDistributions',
        appDataEntityId: 'plmweb.test_case',
        controlParam: {
          id: 'chart',
        },
        sysPFPluginId: 'chart_grid',
        modelId: '4c43fec0cca0a453fa24df3b59295626',
        modelType: 'PSDECHART',
        userParam: {
          'EC.dataZoom':
            '[{"type":"slider","xAxisIndex":0,"start":0,"end":20}]',
          'EC.gridHeaders':
            '[{"id":"filter_type","name":"维护人"},{"id":"count","name":"维护用例数量"}]',
          'EC.color':
            '["#5470c6","#91cc75","#fac858","#ee6666","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc","#5470c6","#91cc75"]',
        },
        name: 'chart',
        id: 'plmweb.test_case.person_distributions',
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
        caption: '测试用例维护人分布',
        codeName: 'person_distributions_report_view_captionbar',
        controlType: 'CAPTIONBAR',
        appDataEntityId: 'plmweb.test_case',
        controlParam: {},
        name: 'captionbar',
        id: 'person_distributions_report_view_captionbar',
      },
    ],
    codeName: 'report_view',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: '通用报表视图布局面板',
    appDataEntityId: 'plmweb.test_case',
    controlParam: {},
    modelId: '64446d4c924adc770427ab67db31a6a5',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'report_view',
  },
  title: '测试用例维护人分布',
  viewStyle: 'DEFAULT',
  viewType: 'DECHARTVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '17a84db7d8b5b30f7914e18a077e3dff',
  modelType: 'PSAPPDEVIEW',
  name: 'test_caseperson_distributions_report_view',
  id: 'plmweb.test_case_person_distributions_report_view',
};
