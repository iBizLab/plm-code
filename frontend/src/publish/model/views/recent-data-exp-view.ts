export default {
  sideBarLayout: 'LEFT',
  showDataInfoBar: true,
  loadDefault: true,
  deviewCodeName: 'data_exp_view',
  deviewId: '29d681adf5808d5d568813aba2c85502',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.RECENT',
  },
  caption: '最近使用',
  codeName: 'recent_data_exp_view',
  appDataEntityId: 'plmweb.recent',
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
            caption: '数据视图',
            itemStyle: 'DEFAULT',
            itemType: 'CTRLPOS',
            layoutPos: {
              shrink: 1,
              layout: 'FLEX',
            },
            showCaption: true,
            id: 'dataview',
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
          shrink: 1,
          layout: 'FLEX',
        },
        id: 'page_container',
      },
    ],
    layoutPanel: true,
    appViewEngines: [
      {
        engineCat: 'VIEW',
        engineType: 'DataViewExpView',
        id: 'engine',
      },
    ],
    appViewLogics: [
      {
        logicTrigger: 'CUSTOM',
        logicType: 'APPUILOGIC',
        builtinAppUILogic: {
          actionAfterWizard: 'DEFAULT',
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
          editMode: true,
          builtinLogic: true,
          logicType: 'PREDEFINED',
          viewLogicType: 'APP_OPENDATA',
          id: '打开数据',
        },
        builtinLogic: true,
        id: 'opendata',
      },
    ],
    controls: [
      {
        xdataControlName: 'dataviewexpbar_dataview',
        enableCounter: true,
        showTitleBar: true,
        autoLoad: true,
        showBusyIndicator: true,
        controls: [
          {
            groupMode: 'NONE',
            pagingSize: 1000,
            createControlAction: {
              appDEMethodId: 'create',
              appDataEntityId: 'plmweb.recent',
              id: 'create',
            },
            fetchControlAction: {
              appDEMethodId: 'fetch_default',
              appDataEntityId: 'plmweb.recent',
              id: 'fetch',
            },
            getControlAction: {
              appDEMethodId: 'get',
              appDataEntityId: 'plmweb.recent',
              id: 'load',
            },
            removeControlAction: {
              appDEMethodId: 'remove',
              appDataEntityId: 'plmweb.recent',
              id: 'remove',
            },
            updateControlAction: {
              appDEMethodId: 'update',
              appDataEntityId: 'plmweb.recent',
              id: 'update',
            },
            autoLoad: true,
            showBusyIndicator: true,
            codeName: 'dataviewexpbar_dataview',
            controlType: 'DATAVIEW',
            appDataEntityId: 'plmweb.recent',
            controlLogics: [
              {
                eventNames: 'SELECTIONCHANGE',
                logicTag: 'dataviewexpbar_dataview',
                logicType: 'CUSTOM',
                triggerType: 'CTRLEVENT',
                id: 'dataviewexpbar_selectionchange',
              },
              {
                eventNames: 'LOAD',
                logicTag: 'dataviewexpbar_dataview',
                logicType: 'CUSTOM',
                triggerType: 'CTRLEVENT',
                id: 'dataviewexpbar_load',
              },
            ],
            controlParam: {
              id: 'dataviewexpbar_dataview',
            },
            modelId: 'c581a85580fdcff8cdca92da4ce7ab3a_dataviewexpbar_dataview',
            modelType: 'PSDEDATAVIEW',
            name: 'dataviewexpbar_dataview',
            id: 'plmweb.recent.dataviewexpbar_dataview',
          },
        ],
        codeName: 'data_exp_view_dataviewexpbar',
        controlType: 'DATAVIEWEXPBAR',
        appDataEntityId: 'plmweb.recent',
        controlParam: {
          id: 'dataviewexpbar',
        },
        modelId: 'c581a85580fdcff8cdca92da4ce7ab3a_dataviewexpbar',
        modelType: 'PSEXPBAR',
        name: 'dataviewexpbar',
        id: 'data_exp_view_dataviewexpbar',
      },
      {
        cardHeight: 120,
        cardWidth: 150,
        groupMode: 'NONE',
        itemLayoutPanel: {
          layoutMode: 'FLEX',
          layout: {
            layout: 'FLEX',
          },
          rootPanelItems: [
            {
              actionGroupExtractMode: 'ITEM',
              panelItems: [
                {
                  editor: {
                    halign: 'LEFT',
                    valign: 'MIDDLE',
                    wrapMode: 'NOWRAP',
                    appCodeListId: 'plmweb.base__recent_use',
                    editorHeight: 20,
                    editorType: 'SPAN',
                    predefinedType: 'FIELD_IMAGE',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'owner_subtype',
                  },
                  viewFieldName: 'owner_subtype',
                  allowEmpty: true,
                  convertToCodeItemText: true,
                  caption: '图片(动态)',
                  contentHeight: 20,
                  height: 20,
                  itemStyle: 'DEFAULT',
                  itemType: 'FIELD',
                  layoutPos: {
                    shrink: 1,
                    height: 20,
                    heightMode: 'PX',
                    layout: 'FLEX',
                  },
                  id: 'owner_subtype',
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
                    id: 'name',
                  },
                  viewFieldName: 'name',
                  allowEmpty: true,
                  caption: '文本(动态)',
                  itemStyle: 'DEFAULT',
                  itemType: 'FIELD',
                  controlRenders: [
                    {
                      layoutPanelModel:
                        "`<div class='ibiz-span' title='${data?.name}'>${data?.name}</div>`",
                      renderType: 'LAYOUTPANEL_MODEL',
                      id: 'logic',
                    },
                  ],
                  layoutPos: {
                    shrink: 1,
                    layout: 'FLEX',
                  },
                  id: 'name',
                },
                {
                  editor: {
                    halign: 'LEFT',
                    renderMode: 'TEXT_DYNAMIC',
                    valign: 'MIDDLE',
                    wrapMode: 'NOWRAP',
                    appCodeListId: 'plmweb.base__recent_type',
                    editorType: 'SPAN',
                    predefinedType: 'FIELD_TEXT_DYNAMIC',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'owner_type',
                  },
                  viewFieldName: 'owner_type',
                  allowEmpty: true,
                  convertToCodeItemText: true,
                  caption: '文本(动态)',
                  itemStyle: 'DEFAULT',
                  itemType: 'FIELD',
                  layoutPos: {
                    shrink: 1,
                    layout: 'FLEX',
                  },
                  id: 'owner_type',
                },
              ],
              layout: {
                layout: 'FLEX',
              },
              dataRegionType: 'INHERIT',
              itemStyle: 'DEFAULT',
              itemType: 'CONTAINER',
              layoutPos: {
                shrink: 1,
                layout: 'FLEX',
              },
              id: 'container1',
            },
          ],
          layoutPanel: true,
          codeName: 'usr0103233849',
          controlType: 'PANEL',
          logicName: 'data_view_card卡片视图',
          appDataEntityId: 'plmweb.recent',
          controlParam: {},
          modelId: '6d73f3e6ea69e7999c4fc03af95a49b5',
          modelType: 'PSSYSVIEWPANEL',
          name: 'itemlayoutpanel',
          id: 'plmweb.recent.usr0103233849',
        },
        dedataViewDataItems: [
          {
            appDEFieldId: 'id',
            dataType: 25,
            id: 'srfkey',
          },
          {
            appDEFieldId: 'name',
            dataType: 25,
            id: 'srfmajortext',
          },
        ],
        pagingSize: 1000,
        appendDEItems: true,
        createControlAction: {
          appDEMethodId: 'create',
          appDataEntityId: 'plmweb.recent',
          id: 'create',
        },
        fetchControlAction: {
          appDEMethodId: 'fetch_recent_use',
          appDataEntityId: 'plmweb.recent',
          id: 'fetch',
        },
        getControlAction: {
          appDEMethodId: 'get',
          appDataEntityId: 'plmweb.recent',
          id: 'load',
        },
        controlNavParams: [
          {
            key: 'size',
            value: '8',
            rawValue: true,
            id: 'size',
          },
        ],
        removeControlAction: {
          appDEMethodId: 'remove',
          appDataEntityId: 'plmweb.recent',
          id: 'remove',
        },
        updateControlAction: {
          appDEMethodId: 'update',
          appDataEntityId: 'plmweb.recent',
          id: 'update',
        },
        autoLoad: true,
        showBusyIndicator: true,
        codeName: 'data_view_card',
        controlType: 'DATAVIEW',
        logicName: '最近使用',
        appDataEntityId: 'plmweb.recent',
        controlParam: {
          ctrlParams: {
            'SRFNAVPARAM.SIZE': '8',
          },
          id: 'dataview',
        },
        sysCss: {
          cssName: 'recentdata-screen-auto-item',
        },
        modelId: 'd59f398379dc14c0c0758de4c7186e4a',
        modelType: 'PSDEDATAVIEW',
        name: 'dataview',
        id: 'plmweb.recent.data_view_card',
      },
      {
        groupMode: 'SINGLE',
        quickSearchMode: 1,
        enableQuickSearch: true,
        controlType: 'SEARCHBAR',
        appDataEntityId: 'plmweb.recent',
        controlParam: {
          id: 'searchbar',
        },
        id: 'searchbar',
      },
      {
        capLanguageRes: {
          lanResTag: 'DE.LNAME.RECENT',
        },
        caption: '最近使用',
        codeName: 'data_exp_view_captionbar',
        controlType: 'CAPTIONBAR',
        appDataEntityId: 'plmweb.recent',
        controlParam: {},
        name: 'captionbar',
        id: 'data_exp_view_captionbar',
      },
    ],
    codeName: 'usr0222063198',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: 'data_view_exp_view实体卡片视图导航视图布局面板',
    appDataEntityId: 'plmweb.recent',
    controlParam: {},
    modelId: '5c0b68d26a8515f0d2b27becb16ef7a9',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'usr0222063198',
  },
  title: '最近使用卡片视图',
  viewStyle: 'DEFAULT',
  viewType: 'DEDATAVIEWEXPVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: 'c581a85580fdcff8cdca92da4ce7ab3a',
  modelType: 'PSAPPDEVIEW',
  name: 'recentdata_exp_view',
  id: 'plmweb.recent_data_exp_view',
};