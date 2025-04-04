export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  openMode: 'POPUPMODAL',
  deviewCodeName: 'project_capacity_view',
  deviewId: '3a26b60bb8cc8d2c971547ce002bb333',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.ADDON_RESOURCE',
  },
  caption: '容量设置',
  codeName: 'addon_resource_project_capacity_view',
  height: 550,
  appDataEntityId: 'plmweb.addon_resource',
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
        appDEMethodId: 'create',
        appDataEntityId: 'plmweb.addon_resource',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.addon_resource',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'get_draft',
        appDataEntityId: 'plmweb.addon_resource',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.addon_resource',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.addon_resource',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.addon_resource',
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
                  rawItem: {
                    caption: '成员',
                    halign: 'LEFT',
                    valign: 'MIDDLE',
                    wrapMode: 'NOWRAP',
                    contentType: 'RAW',
                    id: 'rawitem1',
                  },
                  codeName: 'rawitem1',
                  detailStyle: 'DEFAULT',
                  detailType: 'RAWITEM',
                  layoutPos: {
                    colLG: 4,
                    colMD: 4,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'rawitem1',
                },
                {
                  rawItem: {
                    caption: '工作日',
                    halign: 'LEFT',
                    valign: 'MIDDLE',
                    wrapMode: 'NOWRAP',
                    contentType: 'RAW',
                    id: 'rawitem2',
                  },
                  codeName: 'rawitem2',
                  detailStyle: 'DEFAULT',
                  detailType: 'RAWITEM',
                  layoutPos: {
                    colLG: 8,
                    colMD: 8,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'rawitem2',
                },
                {
                  rawItem: {
                    caption: '每日工作项数量',
                    halign: 'LEFT',
                    valign: 'MIDDLE',
                    wrapMode: 'NOWRAP',
                    contentType: 'RAW',
                    id: 'rawitem3',
                  },
                  codeName: 'rawitem3',
                  detailStyle: 'DEFAULT',
                  detailType: 'RAWITEM',
                  layoutPos: {
                    colLG: 4,
                    colMD: 4,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'rawitem3',
                },
                {
                  rawItem: {
                    caption: '每日预估工时',
                    halign: 'LEFT',
                    valign: 'MIDDLE',
                    wrapMode: 'NOWRAP',
                    contentType: 'RAW',
                    id: 'rawitem4',
                  },
                  codeName: 'rawitem4',
                  detailStyle: 'DEFAULT',
                  detailType: 'RAWITEM',
                  layoutPos: {
                    colLG: 4,
                    colMD: 4,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'rawitem4',
                },
                {
                  rawItem: {
                    caption: '每日剩余工时',
                    halign: 'LEFT',
                    valign: 'MIDDLE',
                    wrapMode: 'NOWRAP',
                    contentType: 'RAW',
                    id: 'rawitem5',
                  },
                  codeName: 'rawitem5',
                  detailStyle: 'DEFAULT',
                  detailType: 'RAWITEM',
                  layoutPos: {
                    colLG: 4,
                    colMD: 4,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'rawitem5',
                },
              ],
              codeName: 'header',
              detailStyle: 'DEFAULT',
              detailType: 'GROUPPANEL',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              id: 'header',
            },
            {
              layout: {
                columnCount: 24,
                layout: 'TABLE_24COL',
              },
              deformDetails: [
                {
                  buildInActions: 2,
                  contentType: 'REPEATER',
                  fieldName: 'members',
                  appDEFieldId: 'members',
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
                      editor: {
                        singleSelect: true,
                        enableAC: true,
                        forceSelection: true,
                        showTrigger: true,
                        valueItemName: 'user_id',
                        editorParams: {
                          readonly: 'true',
                          AC: 'TRUE',
                          TRIGGER: 'TRUE',
                          PICKUPVIEW: 'FALSE',
                        },
                        editorStyle: 'PERSONEL_SELECT',
                        editorType: 'PICKEREX_TRIGGER',
                        sysPFPluginId: 'person_select',
                        valueType: 'SIMPLE',
                        editable: true,
                        readOnly: true,
                        id: 'name',
                      },
                      allowEmpty: true,
                      caption: '成员名称',
                      codeName: 'name',
                      detailStyle: 'DEFAULT',
                      detailType: 'FORMITEM',
                      layoutPos: {
                        colLG: 4,
                        colMD: 4,
                        layout: 'TABLE_24COL',
                      },
                      repeatContent: true,
                      id: 'name',
                    },
                    {
                      dataType: 25,
                      enableCond: 3,
                      labelPos: 'NONE',
                      noPrivDisplayMode: 1,
                      editor: {
                        appCodeListId: 'plmweb.projmgmt__weekday',
                        editorType: 'MDROPDOWNLIST',
                        valueType: 'SIMPLE',
                        editable: true,
                        id: 'weekday',
                      },
                      allowEmpty: true,
                      needCodeListConfig: true,
                      caption: '工作日',
                      codeName: 'weekday',
                      detailStyle: 'DEFAULT',
                      detailType: 'FORMITEM',
                      controlAttributes: [
                        {
                          attrName: 'collapseTags',
                          attrValue: 'true',
                          name: 'collapseTags',
                          id: 'collapsetags',
                        },
                        {
                          attrName: 'collapseTagsTooltip',
                          attrValue: 'true',
                          name: 'collapseTagsTooltip',
                          id: 'collapsetagstooltip',
                        },
                        {
                          attrName: 'maxCollapseTags',
                          attrValue: '2',
                          name: 'maxCollapseTags',
                          id: 'maxcollapsetags',
                        },
                      ],
                      layoutPos: {
                        colLG: 8,
                        colMD: 8,
                        layout: 'TABLE_24COL',
                      },
                      repeatContent: true,
                      id: 'weekday',
                    },
                    {
                      buildInActions: 7,
                      contentType: 'REPEATER',
                      fieldName: 'day_capacity',
                      layout: {
                        columnCount: 12,
                        layout: 'TABLE_12COL',
                      },
                      deformDetails: [
                        {
                          dataType: 25,
                          enableCond: 3,
                          labelPos: 'NONE',
                          noPrivDisplayMode: 1,
                          editor: {
                            maxValue: 100,
                            editorParams: {
                              minvalue: '0',
                              maxvalue: '100',
                            },
                            editorType: 'NUMBER',
                            valueType: 'SIMPLE',
                            editable: true,
                            id: 'work_item_count',
                          },
                          allowEmpty: true,
                          caption: '工作项数量',
                          codeName: 'work_item_count',
                          detailStyle: 'DEFAULT',
                          detailType: 'FORMITEM',
                          layoutPos: {
                            colLG: 4,
                            colMD: 4,
                            layout: 'TABLE_12COL',
                          },
                          repeatContent: true,
                          id: 'work_item_count',
                        },
                        {
                          dataType: 25,
                          enableCond: 3,
                          labelPos: 'NONE',
                          noPrivDisplayMode: 1,
                          editor: {
                            maxValue: 24,
                            editorParams: {
                              minvalue: '0',
                              maxvalue: '24',
                            },
                            editorType: 'NUMBER',
                            valueType: 'SIMPLE',
                            editable: true,
                            id: 'estimated_workload',
                          },
                          allowEmpty: true,
                          caption: '预估工时',
                          codeName: 'estimated_workload',
                          detailStyle: 'DEFAULT',
                          detailType: 'FORMITEM',
                          layoutPos: {
                            colLG: 4,
                            colMD: 4,
                            layout: 'TABLE_12COL',
                          },
                          repeatContent: true,
                          id: 'estimated_workload',
                        },
                        {
                          dataType: 25,
                          enableCond: 3,
                          labelPos: 'NONE',
                          noPrivDisplayMode: 1,
                          editor: {
                            maxValue: 24,
                            editorParams: {
                              minvalue: '0',
                              maxvalue: '24',
                            },
                            editorType: 'NUMBER',
                            valueType: 'SIMPLE',
                            editable: true,
                            id: 'remaining_workload',
                          },
                          allowEmpty: true,
                          caption: '剩余工时',
                          codeName: 'remaining_workload',
                          detailStyle: 'DEFAULT',
                          detailType: 'FORMITEM',
                          layoutPos: {
                            colLG: 4,
                            colMD: 4,
                            layout: 'TABLE_12COL',
                          },
                          repeatContent: true,
                          id: 'remaining_workload',
                        },
                        {
                          dataType: 25,
                          enableCond: 3,
                          fieldName: 'id',
                          labelPos: 'NONE',
                          noPrivDisplayMode: 1,
                          editor: {
                            editorType: 'HIDDEN',
                            valueType: 'SIMPLE',
                            editable: true,
                            id: 'formitem',
                          },
                          allowEmpty: true,
                          hidden: true,
                          codeName: 'formitem',
                          detailStyle: 'DEFAULT',
                          detailType: 'FORMITEM',
                          layoutPos: {
                            colLG: 4,
                            colMD: 4,
                            layout: 'TABLE_12COL',
                          },
                          repeatContent: true,
                          id: 'formitem',
                        },
                      ],
                      codeName: 'mdctrl2',
                      detailStyle: 'STYLE3',
                      detailType: 'MDCTRL',
                      layoutPos: {
                        colLG: 12,
                        colMD: 12,
                        layout: 'TABLE_24COL',
                      },
                      repeatContent: true,
                      showCaption: true,
                      id: 'mdctrl2',
                    },
                    {
                      dataType: 25,
                      enableCond: 3,
                      labelPos: 'NONE',
                      noPrivDisplayMode: 1,
                      editor: {
                        editorType: 'HIDDEN',
                        valueType: 'SIMPLE',
                        editable: true,
                        id: 'user_id',
                      },
                      allowEmpty: true,
                      hidden: true,
                      caption: '成员标识',
                      codeName: 'user_id',
                      detailStyle: 'DEFAULT',
                      detailType: 'FORMITEM',
                      layoutPos: {
                        colLG: 4,
                        colMD: 4,
                        layout: 'TABLE_24COL',
                      },
                      repeatContent: true,
                      id: 'user_id',
                    },
                    {
                      dataType: 25,
                      enableCond: 3,
                      labelPos: 'NONE',
                      noPrivDisplayMode: 1,
                      editor: {
                        editorType: 'HIDDEN',
                        valueType: 'SIMPLE',
                        editable: true,
                        id: 'id',
                      },
                      allowEmpty: true,
                      hidden: true,
                      codeName: 'id',
                      detailStyle: 'DEFAULT',
                      detailType: 'FORMITEM',
                      layoutPos: {
                        colLG: 4,
                        colMD: 4,
                        layout: 'TABLE_24COL',
                      },
                      repeatContent: true,
                      id: 'id',
                    },
                  ],
                  codeName: 'mdctrl1',
                  detailStyle: 'DEFAULT',
                  detailType: 'MDCTRL',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'mdctrl1',
                },
              ],
              caption: '资源组件基本信息',
              codeName: 'body',
              detailStyle: 'DEFAULT',
              detailType: 'GROUPPANEL',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              id: 'body',
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
          caption: '基本信息',
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
      codeName: 'capacity_form',
      controlType: 'FORM',
      logicName: '容量设置表单',
      appDataEntityId: 'plmweb.addon_resource',
      controlParam: {
        id: 'form',
      },
      modelId: 'd093f37399ab0fb6ca2079675c61f54d',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.addon_resource.capacity_form',
    },
    {
      codeName: 'project_capacity_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.addon_resource',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'project_capacity_view_datainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.ADDON_RESOURCE',
      },
      caption: '容量设置',
      codeName: 'project_capacity_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.addon_resource',
      controlParam: {},
      name: 'captionbar',
      id: 'project_capacity_view_captionbar',
    },
  ],
  sysCss: {
    cssName: 'resource-capacity-view',
  },
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEOPTVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.addon_resource',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '项目资源组件容量设置',
  viewStyle: 'DEFAULT',
  viewType: 'DEOPTVIEW',
  width: 1000,
  enableDP: true,
  showCaptionBar: true,
  modelId: '864622b5c7e9c21869d3711974b1b3fc',
  modelType: 'PSAPPDEVIEW',
  name: 'addon_resourceproject_capacity_view',
  id: 'plmweb.addon_resource_project_capacity_view',
};
