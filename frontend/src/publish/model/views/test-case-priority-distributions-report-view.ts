export default {
  enableSearch: true,
  loadDefault: true,
  deviewCodeName: 'priority_distributions_report_view',
  deviewId: '68d9fbfc10fc85b215cc42387a332ca5',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.TEST_CASE',
  },
  caption: '测试用例优先级分布',
  codeName: 'test_case_priority_distributions_report_view',
  appDataEntityId: 'plmweb.test_case',
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
                labelPos: 'TOP',
                labelWidth: 130,
                noPrivDisplayMode: 1,
                appDEFieldId: 'test_plan_name',
                editor: {
                  editorType: 'TEXTBOX',
                  valueType: 'SIMPLE',
                  editable: true,
                  id: 'n_test_plan_name_eq',
                },
                allowEmpty: true,
                caption: '测试计划名称',
                codeName: 'n_test_plan_name_eq',
                detailStyle: 'DEFAULT',
                detailType: 'FORMITEM',
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                showCaption: true,
                id: 'n_test_plan_name_eq',
              },
              {
                dataType: 25,
                enableCond: 3,
                labelPos: 'TOP',
                labelWidth: 130,
                noPrivDisplayMode: 1,
                appDEFieldId: 'executor_name',
                editor: {
                  editorType: 'TEXTBOX',
                  valueType: 'SIMPLE',
                  editable: true,
                  id: 'n_executor_name_eq',
                },
                allowEmpty: true,
                caption: '执行人',
                codeName: 'n_executor_name_eq',
                detailStyle: 'DEFAULT',
                detailType: 'FORMITEM',
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                showCaption: true,
                id: 'n_executor_name_eq',
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
        codeName: 'usr03202480_search_form',
        controlType: 'SEARCHFORM',
        logicName: '测试用例优先级分布_搜索表单',
        appDataEntityId: 'plmweb.test_case',
        controlParam: {
          id: 'searchform',
        },
        modelId: '470f41f948d356ef0d48e7bd61d3b38b',
        modelType: 'PSDEFORM_SEARCHFORM',
        name: 'searchform',
        id: 'plmweb.test_case.usr03202480_search_form',
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
          title: '测试用例优先级分布',
          id: '0',
        },
        chartDataSetGroups: [
          {
            appDEDataSetId: 'fetch_priority_distributions',
            appDataEntityId: 'plmweb.test_case',
            name: 'priorityDistributions',
            id: '0',
          },
        ],
        chartDataSets: [
          {
            chartDataSetFields: [
              {
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
            name: 'bar_0-priorityDistributions',
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
        fetchControlAction: {
          appDEMethodId: 'fetch_priority_distributions',
          appDataEntityId: 'plmweb.test_case',
          id: 'fetch',
        },
        readOnly: true,
        autoLoad: true,
        showBusyIndicator: true,
        codeName: 'priority_distributions',
        controlStyle: 'CHART_GRID',
        controlType: 'CHART',
        logicName: 'priorityDistributions',
        appDataEntityId: 'plmweb.test_case',
        controlParam: {
          id: 'chart',
        },
        sysPFPluginId: 'chart_grid',
        modelId: '09b0a7c07c75781a143301d98603899b',
        modelType: 'PSDECHART',
        userParam: {
          'EC.color':
            '["#5470c6","#91cc75","#fac858","#ee6666","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc","#5470c6","#91cc75"]',
        },
        name: 'chart',
        id: 'plmweb.test_case.priority_distributions',
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
        caption: '测试用例优先级分布',
        codeName: 'priority_distributions_report_view_captionbar',
        controlType: 'CAPTIONBAR',
        appDataEntityId: 'plmweb.test_case',
        controlParam: {},
        name: 'captionbar',
        id: 'priority_distributions_report_view_captionbar',
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
  title: '测试用例优先级分布',
  viewStyle: 'DEFAULT',
  viewType: 'DECHARTVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '56389bf72e2c91d75fd5ee506b0738cb',
  modelType: 'PSAPPDEVIEW',
  name: 'test_casepriority_distributions_report_view',
  id: 'plmweb.test_case_priority_distributions_report_view',
};