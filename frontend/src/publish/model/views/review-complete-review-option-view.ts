export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  openMode: 'POPUPMODAL',
  deviewCodeName: 'complete_review_option_view',
  deviewId: '925A4CA6-BBD4-4BDD-92E0-BFAF75B7B83D',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.REVIEW',
  },
  caption: '完成评审',
  codeName: 'review_complete_review_option_view',
  height: 300,
  appDataEntityId: 'plmweb.review',
  appViewNavParams: [
    {
      key: 'stage_id',
      value: 'curstage_id',
      id: 'stage_id',
    },
    {
      key: 'review_id',
      value: 'review',
      id: 'review_id',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
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
            caption: '表单',
            itemStyle: 'DEFAULT',
            itemType: 'CTRLPOS',
            layoutPos: {
              shrink: 1,
              layout: 'FLEX',
            },
            showCaption: true,
            id: 'form',
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
      {
        actionGroupExtractMode: 'ITEM',
        panelItems: [
          {
            actionType: 'UIACTION',
            buttonStyle: 'PRIMARY',
            buttonType: 'PANELBUTTON',
            uiactionId: 'ok',
            renderMode: 'BUTTON',
            tooltip: '确认并完成评审',
            caption: '确认并完成评审',
            itemStyle: 'PRIMARY',
            itemType: 'BUTTON',
            layoutPos: {
              shrink: 1,
              layout: 'FLEX',
            },
            showCaption: true,
            id: 'button_okaction',
          },
          {
            actionType: 'UIACTION',
            buttonStyle: 'INFO',
            buttonType: 'PANELBUTTON',
            uiactionId: 'cancel',
            renderMode: 'BUTTON',
            tooltip: '取消',
            caption: '取消',
            itemStyle: 'INFO',
            itemType: 'BUTTON',
            layoutPos: {
              shrink: 1,
              layout: 'FLEX',
            },
            showCaption: true,
            id: 'button_cancelaction',
          },
        ],
        layout: {
          dir: 'row-reverse',
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
        id: 'view_footer',
      },
    ],
    layoutPanel: true,
    appViewEngines: [
      {
        engineCat: 'VIEW',
        engineType: 'OptionView',
        id: 'engine',
      },
    ],
    controls: [
      {
        createControlAction: {
          appDEMethodId: 'nothing',
          appDataEntityId: 'plmweb.review',
          id: 'create',
        },
        getDraftFromControlAction: {
          appDataEntityId: 'plmweb.review',
          id: 'loaddraftfrom',
        },
        getDraftControlAction: {
          appDEMethodId: 'fill_cureent_stage_info',
          appDataEntityId: 'plmweb.review',
          id: 'loaddraft',
        },
        getControlAction: {
          appDEMethodId: 'fill_cureent_stage_info',
          appDataEntityId: 'plmweb.review',
          id: 'load',
        },
        removeControlAction: {
          appDEMethodId: 'remove',
          appDataEntityId: 'plmweb.review',
          id: 'remove',
        },
        updateControlAction: {
          appDEMethodId: 'nothing',
          appDataEntityId: 'plmweb.review',
          id: 'update',
        },
        deformPages: [
          {
            layout: {
              columnCount: 24,
              layout: 'TABLE_24COL',
            },
            deformDetails: [
              {
                layout: {
                  columnCount: 24,
                  layout: 'TABLE_24COL',
                },
                deformDetails: [
                  {
                    layout: {
                      dir: 'row',
                      layout: 'FLEX',
                    },
                    deformDetails: [
                      {
                        dataType: 25,
                        enableCond: 3,
                        labelPos: 'NONE',
                        noPrivDisplayMode: 1,
                        editor: {
                          halign: 'LEFT',
                          valign: 'MIDDLE',
                          wrapMode: 'NOWRAP',
                          editorType: 'SPAN',
                          valueType: 'SIMPLE',
                          editable: true,
                          id: 'prefix',
                        },
                        updateDV: '确认要完成阶段',
                        allowEmpty: true,
                        codeName: 'prefix',
                        detailStyle: 'DEFAULT',
                        detailType: 'FORMITEM',
                        layoutPos: {
                          shrink: 1,
                          layout: 'FLEX',
                        },
                        id: 'prefix',
                      },
                      {
                        dataType: 25,
                        enableCond: 3,
                        labelPos: 'NONE',
                        noPrivDisplayMode: 1,
                        editor: {
                          halign: 'LEFT',
                          valign: 'MIDDLE',
                          wrapMode: 'NOWRAP',
                          editorType: 'SPAN',
                          valueType: 'SIMPLE',
                          editable: true,
                          id: 'stage_name1',
                        },
                        allowEmpty: true,
                        codeName: 'stage_name1',
                        detailStyle: 'DEFAULT',
                        detailType: 'FORMITEM',
                        layoutPos: {
                          shrink: 1,
                          layout: 'FLEX',
                        },
                        id: 'stage_name1',
                      },
                      {
                        dataType: 25,
                        enableCond: 3,
                        labelPos: 'NONE',
                        noPrivDisplayMode: 1,
                        editor: {
                          halign: 'LEFT',
                          valign: 'MIDDLE',
                          wrapMode: 'NOWRAP',
                          editorType: 'SPAN',
                          valueType: 'SIMPLE',
                          editable: true,
                          id: 'suffix',
                        },
                        updateDV: '吗？',
                        allowEmpty: true,
                        codeName: 'suffix',
                        detailStyle: 'DEFAULT',
                        detailType: 'FORMITEM',
                        layoutPos: {
                          shrink: 1,
                          layout: 'FLEX',
                        },
                        id: 'suffix',
                      },
                    ],
                    codeName: 'grouppanel2',
                    detailStyle: 'DEFAULT',
                    detailType: 'GROUPPANEL',
                    layoutPos: {
                      colMD: 24,
                      layout: 'TABLE_24COL',
                    },
                    id: 'grouppanel2',
                  },
                  {
                    dataType: 25,
                    enableCond: 3,
                    labelPos: 'NONE',
                    noPrivDisplayMode: 1,
                    editor: {
                      halign: 'LEFT',
                      valign: 'MIDDLE',
                      wrapMode: 'NOWRAP',
                      editorType: 'SPAN',
                      valueType: 'SIMPLE',
                      editable: true,
                      id: 'info',
                    },
                    updateDV:
                      '该阶段评审已完成，完成后评审结果及意见不可再修改。',
                    allowEmpty: true,
                    codeName: 'info',
                    detailStyle: 'DEFAULT',
                    detailType: 'FORMITEM',
                    layoutPos: {
                      colMD: 24,
                      layout: 'TABLE_24COL',
                    },
                    id: 'info',
                  },
                ],
                codeName: 'group',
                detailStyle: 'DEFAULT',
                detailType: 'GROUPPANEL',
                defdgroupLogics: [
                  {
                    logicCat: 'PANELVISIBLE',
                    relatedDetailNames: ['case_number'],
                    groupOP: 'AND',
                    defdlogics: [
                      {
                        condOP: 'EQ',
                        defdname: 'case_number',
                        value: '0',
                        logicType: 'SINGLE',
                      },
                    ],
                    logicType: 'GROUP',
                    id: '表单成员[group][面板显示]逻辑',
                  },
                ],
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                id: 'group',
              },
              {
                layout: {
                  columnCount: 24,
                  layout: 'TABLE_24COL',
                },
                deformDetails: [
                  {
                    layout: {
                      dir: 'row',
                      layout: 'FLEX',
                    },
                    deformDetails: [
                      {
                        dataType: 25,
                        enableCond: 3,
                        labelPos: 'NONE',
                        noPrivDisplayMode: 1,
                        editor: {
                          halign: 'LEFT',
                          valign: 'MIDDLE',
                          wrapMode: 'NOWRAP',
                          editorType: 'SPAN',
                          valueType: 'SIMPLE',
                          editable: true,
                          id: 'prefix2',
                        },
                        updateDV: '阶段',
                        allowEmpty: true,
                        codeName: 'prefix2',
                        detailStyle: 'DEFAULT',
                        detailType: 'FORMITEM',
                        layoutPos: {
                          shrink: 1,
                          layout: 'FLEX',
                        },
                        id: 'prefix2',
                      },
                      {
                        dataType: 25,
                        enableCond: 3,
                        fieldName: 'stage_name2',
                        labelPos: 'NONE',
                        noPrivDisplayMode: 1,
                        editor: {
                          halign: 'LEFT',
                          valign: 'MIDDLE',
                          wrapMode: 'NOWRAP',
                          editorType: 'SPAN',
                          valueType: 'SIMPLE',
                          editable: true,
                          id: 'stage_name2',
                        },
                        allowEmpty: true,
                        codeName: 'stage_name2',
                        detailStyle: 'DEFAULT',
                        detailType: 'FORMITEM',
                        layoutPos: {
                          shrink: 1,
                          layout: 'FLEX',
                        },
                        id: 'stage_name2',
                      },
                      {
                        dataType: 25,
                        enableCond: 3,
                        labelPos: 'NONE',
                        noPrivDisplayMode: 1,
                        editor: {
                          halign: 'LEFT',
                          valign: 'MIDDLE',
                          wrapMode: 'NOWRAP',
                          editorType: 'SPAN',
                          valueType: 'SIMPLE',
                          editable: true,
                          id: 'infix',
                        },
                        updateDV: '仍有',
                        allowEmpty: true,
                        codeName: 'infix',
                        detailStyle: 'DEFAULT',
                        detailType: 'FORMITEM',
                        layoutPos: {
                          shrink: 1,
                          layout: 'FLEX',
                        },
                        id: 'infix',
                      },
                      {
                        dataType: 25,
                        enableCond: 3,
                        labelPos: 'NONE',
                        noPrivDisplayMode: 1,
                        editor: {
                          halign: 'LEFT',
                          valign: 'MIDDLE',
                          wrapMode: 'NOWRAP',
                          editorType: 'SPAN',
                          valueType: 'SIMPLE',
                          editable: true,
                          id: 'case_number',
                        },
                        updateDV: 'case_number',
                        updateDVT: 'APPDATA',
                        allowEmpty: true,
                        codeName: 'case_number',
                        detailStyle: 'DEFAULT',
                        detailType: 'FORMITEM',
                        layoutPos: {
                          shrink: 1,
                          layout: 'FLEX',
                        },
                        id: 'case_number',
                      },
                      {
                        dataType: 25,
                        enableCond: 3,
                        labelPos: 'NONE',
                        noPrivDisplayMode: 1,
                        editor: {
                          halign: 'LEFT',
                          valign: 'MIDDLE',
                          wrapMode: 'NOWRAP',
                          editorType: 'SPAN',
                          valueType: 'SIMPLE',
                          editable: true,
                          id: 'suffix2',
                        },
                        updateDV: '个用例没有评审，将他们：',
                        allowEmpty: true,
                        codeName: 'suffix2',
                        detailStyle: 'DEFAULT',
                        detailType: 'FORMITEM',
                        layoutPos: {
                          shrink: 1,
                          layout: 'FLEX',
                        },
                        id: 'suffix2',
                      },
                    ],
                    codeName: 'grouppanel4',
                    detailStyle: 'DEFAULT',
                    detailType: 'GROUPPANEL',
                    layoutPos: {
                      colMD: 24,
                      layout: 'TABLE_24COL',
                    },
                    id: 'grouppanel4',
                  },
                  {
                    createDV: '10',
                    dataType: 25,
                    enableCond: 3,
                    fieldName: 'result',
                    labelPos: 'NONE',
                    noPrivDisplayMode: 1,
                    editor: {
                      appCodeListId:
                        'plmweb.testmgmt__complete_review_state_passordenial',
                      editorType: 'RADIOBUTTONLIST',
                      valueType: 'SIMPLE',
                      editable: true,
                      id: 'result',
                    },
                    updateDV: '10',
                    allowEmpty: true,
                    needCodeListConfig: true,
                    codeName: 'result',
                    detailStyle: 'DEFAULT',
                    detailType: 'FORMITEM',
                    layoutPos: {
                      colMD: 24,
                      layout: 'TABLE_24COL',
                    },
                    id: 'result',
                  },
                ],
                codeName: 'grouppanel3',
                detailStyle: 'DEFAULT',
                detailType: 'GROUPPANEL',
                defdgroupLogics: [
                  {
                    logicCat: 'PANELVISIBLE',
                    relatedDetailNames: ['case_number'],
                    groupOP: 'AND',
                    defdlogics: [
                      {
                        condOP: 'GT',
                        defdname: 'case_number',
                        value: '0',
                        logicType: 'SINGLE',
                      },
                    ],
                    logicType: 'GROUP',
                    id: '表单成员[grouppanel3][面板显示]逻辑',
                  },
                ],
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                id: 'grouppanel3',
              },
              {
                createDV: 'curstage_id',
                createDVT: 'APPDATA',
                dataType: 25,
                enableCond: 3,
                fieldName: 'stage_id',
                labelPos: 'NONE',
                noPrivDisplayMode: 1,
                editor: {
                  editorType: 'HIDDEN',
                  valueType: 'SIMPLE',
                  editable: true,
                  id: 'stage_id',
                },
                updateDV: 'curstage_id',
                updateDVT: 'APPDATA',
                allowEmpty: true,
                hidden: true,
                codeName: 'stage_id',
                detailStyle: 'DEFAULT',
                detailType: 'FORMITEM',
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                id: 'stage_id',
              },
              {
                dataType: 25,
                enableCond: 3,
                labelPos: 'LEFT',
                labelWidth: 130,
                noPrivDisplayMode: 1,
                appDEFieldId: 'id',
                editor: {
                  editorType: 'HIDDEN',
                  valueType: 'SIMPLE',
                  editable: true,
                  id: 'id',
                },
                allowEmpty: true,
                hidden: true,
                capLanguageRes: {
                  lanResTag: 'DEF.LNAME.ID',
                },
                caption: '标识',
                codeName: 'id',
                detailStyle: 'DEFAULT',
                detailType: 'FORMITEM',
                layoutPos: {
                  colMD: 24,
                  layout: 'TABLE_24COL',
                },
                id: 'id',
              },
            ],
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
        codeName: 'usr06200376_form',
        controlType: 'FORM',
        logicName: '评审内容完成评审操作视图_表单',
        appDataEntityId: 'plmweb.review',
        controlParam: {
          id: 'form',
        },
        modelId: 'B3BE566F-A753-4CF1-B779-18196B26E192',
        modelType: 'PSDEFORM_EDITFORM',
        name: 'form',
        id: 'plmweb.review.usr06200376_form',
      },
      {
        codeName: 'complete_review_option_view_datainfobar',
        controlType: 'DATAINFOBAR',
        appDataEntityId: 'plmweb.review',
        controlParam: {
          id: 'datainfobar',
        },
        name: 'datainfobar',
        id: 'complete_review_option_view_datainfobar',
      },
      {
        capLanguageRes: {
          lanResTag: 'DE.LNAME.REVIEW',
        },
        caption: '完成评审',
        codeName: 'complete_review_option_view_captionbar',
        controlType: 'CAPTIONBAR',
        appDataEntityId: 'plmweb.review',
        controlParam: {},
        name: 'captionbar',
        id: 'complete_review_option_view_captionbar',
      },
    ],
    codeName: 'usr0625737408',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: 'complete_review_option_view选项操作视图布局面',
    appDataEntityId: 'plmweb.review',
    controlParam: {},
    modelId: '753D59EF-6EC3-4F99-B20F-BAECC5744981',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'usr0625737408',
  },
  title: '完成评审',
  viewStyle: 'DEFAULT',
  viewType: 'DEOPTVIEW',
  width: 400,
  enableDP: true,
  showCaptionBar: true,
  modelId: '7010e9ffe171803011667202e000ba02',
  modelType: 'PSAPPDEVIEW',
  name: 'reviewcomplete_review_option_view',
  id: 'plmweb.review_complete_review_option_view',
};