export default {
  mdctrlActiveMode: 1,
  xdataControlName: 'gantt',
  loadDefault: true,
  deviewCodeName: 'gantt_view',
  deviewId: 'CFB02F24-8E86-4237-B78B-BA779993E1D8',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.BASELINE_WORK_ITEM',
  },
  caption: '规划快照',
  codeName: 'baseline_work_item_gantt_view',
  appDataEntityId: 'plmweb.baseline_work_item',
  appViewLogics: [
    {
      eventNames: 'onLoadSuccess',
      logicTrigger: 'VIEWEVENT',
      logicType: 'APPDEUILOGIC',
      appDEUILogicId: 'plan_snapshot_check',
      appDataEntityId: 'plmweb.baseline_work_item',
      builtinLogic: true,
      name: 'LOGIC',
      id: 'logic',
    },
  ],
  appViewNavParams: [
    {
      key: 'baseline',
      value: 'baseline',
      id: 'baseline',
    },
  ],
  controls: [
    {
      beginDataItemName: 'begin',
      endDataItemName: 'end',
      finishDataItemName: 'finish',
      prevDataItemName: 'prev',
      sndataItemName: 'sn',
      totalDataItemName: 'total',
      detreeColumns: [
        {
          caption: '编号',
          codeName: 'sn',
          columnType: 'DEFGRIDCOLUMN',
          width: 150,
          widthUnit: 'px',
          id: 'sn',
        },
        {
          caption: '标题',
          codeName: 'name',
          columnType: 'DEFGRIDCOLUMN',
          width: 250,
          widthUnit: 'px',
          id: 'name',
        },
        {
          caption: '开始时间',
          codeName: 'begin',
          columnType: 'DEFGRIDCOLUMN',
          width: 250,
          widthUnit: 'px',
          id: 'begin',
        },
        {
          caption: '结束时间',
          codeName: 'end',
          columnType: 'DEFGRIDCOLUMN',
          width: 250,
          widthUnit: 'px',
          id: 'end',
        },
      ],
      detreeNodeRSs: [
        {
          childDETreeNodeId: 'top_node',
          navigateParams: [
            {
              key: 'n_pid_isnull',
              value: '1',
              rawValue: true,
              id: 'n_pid_isnull',
            },
          ],
          parentDETreeNodeId: 'root',
          parentValueLevel: 1,
          searchMode: 3,
          id: '默认根节点 - 顶层节点',
        },
        {
          childDETreeNodeId: 'node',
          parentFilter: 'pid',
          parentDETreeNodeId: 'top_node',
          parentValueLevel: 1,
          searchMode: 3,
          id: '顶层节点 - 子节点',
        },
        {
          childDETreeNodeId: 'node',
          parentFilter: 'pid',
          parentDETreeNodeId: 'node',
          parentValueLevel: 1,
          searchMode: 3,
          id: '子节点 - 子节点',
        },
      ],
      detreeNodes: [
        {
          text: '默认根节点',
          nodeType: 'ROOT',
          treeNodeType: 'STATIC',
          hasDETreeNodeRSs: true,
          rootNode: true,
          name: '默认根节点',
          id: 'root',
        },
        {
          idAppDEFieldId: 'target_id',
          leafFlagAppDEFieldId: 'is_leaf',
          appDEDataSetId: 'fetch_fill_version_data',
          textAppDEFieldId: 'title',
          nodeType: 'NODE',
          appDataEntityId: 'plmweb.baseline_work_item',
          detreeNodeColumns: [
            {
              clconvertMode: 'NONE',
              dataItemName: 'end_at',
              appDEFieldId: 'end_at',
              valueFormat: 'YYYY-MM-DD',
              valueType: 'SIMPLE',
              codeName: 'end_at',
              columnType: 'DEFGRIDCOLUMN',
              noPrivDisplayMode: 1,
              detreeColumnId: 'end',
              id: 'end_at',
            },
            {
              clconvertMode: 'NONE',
              dataItemName: 'identifier',
              appDEFieldId: 'identifier',
              valueType: 'SIMPLE',
              codeName: 'identifier',
              columnType: 'DEFGRIDCOLUMN',
              noPrivDisplayMode: 1,
              detreeColumnId: 'sn',
              id: 'identifier',
            },
            {
              clconvertMode: 'NONE',
              dataItemName: 'start_at',
              appDEFieldId: 'start_at',
              valueFormat: 'YYYY-MM-DD',
              valueType: 'SIMPLE',
              codeName: 'start_at',
              columnType: 'DEFGRIDCOLUMN',
              noPrivDisplayMode: 1,
              detreeColumnId: 'begin',
              id: 'start_at',
            },
            {
              clconvertMode: 'NONE',
              dataItemName: 'title',
              appDEFieldId: 'title',
              valueType: 'SIMPLE',
              codeName: 'title',
              columnType: 'DEFGRIDCOLUMN',
              noPrivDisplayMode: 1,
              detreeColumnId: 'name',
              id: 'title',
            },
          ],
          detreeNodeDataItems: [
            {
              clconvertMode: 'NONE',
              appDEFieldId: 'end_at',
              detreeColumnId: 'end',
              valueType: 'SIMPLE',
              dataType: 5,
              id: 'end_at',
            },
            {
              clconvertMode: 'NONE',
              appDEFieldId: 'identifier',
              detreeColumnId: 'sn',
              valueType: 'SIMPLE',
              dataType: 25,
              id: 'identifier',
            },
            {
              clconvertMode: 'NONE',
              appDEFieldId: 'start_at',
              detreeColumnId: 'begin',
              valueType: 'SIMPLE',
              dataType: 5,
              id: 'start_at',
            },
            {
              clconvertMode: 'NONE',
              appDEFieldId: 'title',
              detreeColumnId: 'name',
              valueType: 'SIMPLE',
              dataType: 25,
              id: 'title',
            },
          ],
          treeNodeType: 'DE',
          hasDETreeNodeRSs: true,
          name: '子节点',
          id: 'node',
        },
        {
          idAppDEFieldId: 'target_id',
          leafFlagAppDEFieldId: 'is_leaf',
          appDEDataSetId: 'fetch_fill_version_data',
          textAppDEFieldId: 'title',
          nodeType: 'TOP_NODE',
          appDataEntityId: 'plmweb.baseline_work_item',
          detreeNodeColumns: [
            {
              clconvertMode: 'NONE',
              dataItemName: 'end_at',
              appDEFieldId: 'end_at',
              valueFormat: 'YYYY-MM-DD',
              valueType: 'SIMPLE',
              codeName: 'end_at',
              columnType: 'DEFGRIDCOLUMN',
              noPrivDisplayMode: 1,
              detreeColumnId: 'end',
              id: 'end_at',
            },
            {
              clconvertMode: 'NONE',
              dataItemName: 'identifier',
              appDEFieldId: 'identifier',
              valueType: 'SIMPLE',
              codeName: 'identifier',
              columnType: 'DEFGRIDCOLUMN',
              noPrivDisplayMode: 1,
              detreeColumnId: 'sn',
              id: 'identifier',
            },
            {
              clconvertMode: 'NONE',
              dataItemName: 'start_at',
              appDEFieldId: 'start_at',
              valueFormat: 'YYYY-MM-DD',
              valueType: 'SIMPLE',
              codeName: 'start_at',
              columnType: 'DEFGRIDCOLUMN',
              noPrivDisplayMode: 1,
              detreeColumnId: 'begin',
              id: 'start_at',
            },
            {
              clconvertMode: 'NONE',
              dataItemName: 'title',
              appDEFieldId: 'title',
              valueType: 'SIMPLE',
              codeName: 'title',
              columnType: 'DEFGRIDCOLUMN',
              noPrivDisplayMode: 1,
              detreeColumnId: 'name',
              id: 'title',
            },
          ],
          detreeNodeDataItems: [
            {
              clconvertMode: 'NONE',
              appDEFieldId: 'end_at',
              detreeColumnId: 'end',
              valueType: 'SIMPLE',
              dataType: 5,
              id: 'end_at',
            },
            {
              clconvertMode: 'NONE',
              appDEFieldId: 'identifier',
              detreeColumnId: 'sn',
              valueType: 'SIMPLE',
              dataType: 25,
              id: 'identifier',
            },
            {
              clconvertMode: 'NONE',
              appDEFieldId: 'start_at',
              detreeColumnId: 'begin',
              valueType: 'SIMPLE',
              dataType: 5,
              id: 'start_at',
            },
            {
              clconvertMode: 'NONE',
              appDEFieldId: 'title',
              detreeColumnId: 'name',
              valueType: 'SIMPLE',
              dataType: 25,
              id: 'title',
            },
          ],
          treeNodeType: 'DE',
          hasDETreeNodeRSs: true,
          enableEditData: true,
          enableNewData: true,
          enableRemoveData: true,
          enableViewData: true,
          name: '顶层节点',
          id: 'top_node',
        },
      ],
      treeGridMode: 2,
      outputIconDefault: true,
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'gantt',
      controlType: 'GANTT',
      logicName: '甘特图',
      appDataEntityId: 'plmweb.baseline_work_item',
      controlParam: {
        ctrlParams: {
          SLIDERDRAGGABLE: 'false',
        },
        id: 'gantt',
      },
      modelId: '0a760a0d63466da211ce49a8d5d4c153',
      modelType: 'PSDEGANTT',
      name: 'gantt',
      id: 'plmweb.baseline_work_item.gantt',
    },
    {
      detoolbarItems: [
        {
          actionLevel: 100,
          noPrivDisplayMode: 2,
          uiactionId: 'snapshot_set_baseline@baseline_work_item',
          uiactionTarget: 'NONE',
          valid: true,
          caption: '设立基线',
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
          tooltip: '设立基线',
          showCaption: true,
          showIcon: true,
          id: 'deuiaction1',
        },
      ],
      xdataControlName: 'gantt',
      codeName: 'gantt_view_toolbar',
      controlType: 'TOOLBAR',
      logicName: '规划快照_工具栏',
      appDataEntityId: 'plmweb.baseline_work_item',
      controlParam: {
        id: 'toolbar',
      },
      modelId: '42D8CF72-FA00-4FCE-984F-8E5634B336AD',
      modelType: 'PSDETOOLBAR',
      name: 'toolbar',
      id: 'gantt_view_toolbar',
    },
    {
      groupMode: 'SINGLE',
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.baseline_work_item',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.BASELINE_WORK_ITEM',
      },
      caption: '规划快照',
      codeName: 'gantt_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.baseline_work_item',
      controlParam: {},
      name: 'captionbar',
      id: 'gantt_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEGANTTVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.baseline_work_item',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '规划快照甘特图',
  viewStyle: 'DEFAULT',
  viewType: 'DEGANTTVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '384ecbd61af3c0dfbdbf9a5fe54b778a',
  modelType: 'PSAPPDEVIEW',
  name: 'baseline_work_itemgantt_view',
  id: 'plmweb.baseline_work_item_gantt_view',
};