export default {
  openMode: 'INDEXVIEWTAB_POPUPMODAL',
  deviewCodeName: 'MSLogicDesign_Custom',
  deviewId: '841a533bd787e96c974ff5b097313835',
  accUserMode: 2,
  caption: '主状态逻辑设计',
  codeName: 'psdems_logic_ms_logic_design_custom',
  height: 90,
  appDataEntityId: 'plmweb.psdemslogic',
  appViewNavContexts: [
    {
      rawValue: true,
      key: 'PSDEMSLOGIC',
      value:
        'FIELD__PROJECT_ID__ee11e5a96002f4f3937ddba025ec7d44@ProjMgmt.work_item.scrum_epic',
      name: 'PSDEMSLOGIC',
      id: 'psdemslogic',
    },
    {
      rawValue: true,
      key: 'PSMODULE',
      name: 'PSMODULE',
      id: 'psmodule',
    },
    {
      rawValue: true,
      key: 'SRFAPPDEMAPPING',
      value: 'true',
      name: 'SRFAPPDEMAPPING',
      id: 'srfappdemapping',
    },
    {
      key: 'PSDELOGIC',
      value: 'psdemslogic',
      name: 'PSDELOGIC',
      id: 'psdelogic',
    },
    {
      rawValue: true,
      key: 'SRFAPPMAPPINGMAP',
      value: 'logicdesign__logicdesign:ibizplm__plmweb',
      name: 'SRFAPPMAPPINGMAP',
      id: 'srfappmappingmap',
    },
  ],
  appViewRefs: [
    {
      realTitle: '属性视图',
      refAppViewId: 'plmweb.psdemslogicdesigneditview_ms',
      name: 'EDITDATA:PSDEMSLOGIC',
      id: 'editdata:psdemslogic',
    },
    {
      realTitle: '主状态逻辑节点(设计)',
      refAppViewId: 'plmweb.psdelogicnodedesignview_msnode2',
      name: 'EDITDATA:PSDELOGICNODE:MAINSTATE',
      id: 'editdata:psdelogicnode:mainstate',
    },
    {
      realTitle: '属性视图',
      refAppViewId: 'plmweb.psdemslogicdesigneditview_ms',
      name: 'EDITDATA:PSDELOGIC',
      id: 'editdata:psdelogic',
    },
    {
      realTitle: '主状态处理逻辑节点连接(设计)',
      refAppViewId: 'plmweb.psdelogiclinkdesigneditview_ms',
      name: 'EDITDATA:PSDELOGICLINK',
      id: 'editdata:psdelogiclink',
    },
    {
      realTitle: '主状态逻辑节点(设计)',
      refAppViewId: 'plmweb.psdelogicnodedesignview_msnode2',
      name: 'EDITDATA:PSDELOGICNODE',
      id: 'editdata:psdelogicnode',
    },
  ],
  controls: [
    {
      detoolbarItems: [
        {
          actionLevel: 100,
          noPrivDisplayMode: 2,
          uiactionId: 'save',
          valid: true,
          capLanguageRes: {
            lanResTag: 'TBB.TEXT.*.SAVE',
          },
          caption: '保存',
          itemType: 'DEUIACTION',
          sysImage: {
            cssClass: 'fa fa-save',
            glyph: 'xf0c7@FontAwesome',
          },
          tooltip: '保存',
          tooltipLanguageRes: {
            lanResTag: 'TBB.TOOLTIP.*.SAVE',
          },
          showCaption: true,
          showIcon: true,
          id: 'tbitem1',
        },
      ],
      codeName: 'ms_logic_design_custom_toolbar',
      controlType: 'TOOLBAR',
      logicName: '工具栏模板（嵌入编辑表单，只有一个保存按钮）',
      appDataEntityId: 'plmweb.psdemslogic',
      controlParam: {
        id: 'toolbar',
      },
      modelId: '25823041a044e2dfc60cdebdb06ebd82',
      modelType: 'PSDETOOLBAR',
      name: 'toolbar',
      id: 'ms_logic_design_custom_toolbar',
    },
    {
      createControlAction: {
        appDEMethodId: 'createtemp',
        appDataEntityId: 'plmweb.psdelogicnode',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.psdelogicnode',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'getdrafttemp',
        appDataEntityId: 'plmweb.psdelogicnode',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'gettemp',
        appDataEntityId: 'plmweb.psdelogicnode',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'removetemp',
        appDataEntityId: 'plmweb.psdelogicnode',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'updatetemp',
        appDataEntityId: 'plmweb.psdelogicnode',
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
              actionType: 'UIACTION',
              uiactionId: 'addstatus@psdelogicnode',
              tooltip: '添加状态',
              uiactionTarget: 'NONE',
              caption: '添加状态',
              codeName: 'addstatusbutton',
              detailStyle: 'DEFAULT',
              detailType: 'BUTTON',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'addstatusbutton',
            },
            {
              dataType: 25,
              enableCond: 3,
              labelPos: 'LEFT',
              labelWidth: 130,
              noPrivDisplayMode: 1,
              editor: {
                singleSelect: true,
                appCodeListId: 'plmweb.extension__delogicnodetype_ms',
                editorType: 'DROPDOWNLIST',
                valueType: 'SIMPLE',
                editable: true,
                id: 'type',
              },
              allowEmpty: true,
              needCodeListConfig: true,
              codeName: 'type',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'type',
            },
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
                  appDEFieldId: 'psdelogicnodename',
                  editor: {
                    maxLength: 200,
                    editorType: 'TEXTBOX',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'psdelogicnodename',
                  },
                  capLanguageRes: {
                    lanResTag: 'DEF.LNAME.PSDELOGICNODENAME',
                  },
                  caption: '逻辑处理名称',
                  codeName: 'psdelogicnodename',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'psdelogicnodename',
                },
              ],
              caption: '实体处理逻辑节点基本信息',
              codeName: 'group1',
              detailStyle: 'DEFAULT',
              detailType: 'GROUPPANEL',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'group1',
            },
            {
              dataType: 25,
              labelPos: 'LEFT',
              labelWidth: 130,
              noPrivDisplayMode: 1,
              appDEFieldId: 'psdelogicnodeid',
              editor: {
                editorType: 'HIDDEN',
                valueType: 'SIMPLE',
                editable: true,
                id: 'psdelogicnodeid',
              },
              allowEmpty: true,
              hidden: true,
              capLanguageRes: {
                lanResTag: 'DEF.LNAME.PSDELOGICNODEID',
              },
              caption: '实体处理逻辑节点标识',
              codeName: 'psdelogicnodeid',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              id: 'psdelogicnodeid',
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
      codeName: 'api',
      controlStyle: 'X6DesignNode',
      controlType: 'FORM',
      logicName: '接口表单',
      appDataEntityId: 'plmweb.psdelogicnode',
      controlParam: {
        id: 'node',
      },
      sysPFPluginId: 'x6designnode',
      modelId: '1ac4e9fcab71b2e9018cdaae86aae22c',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'node',
      id: 'plmweb.psdelogicnode.api',
    },
    {
      createControlAction: {
        appDEMethodId: 'createtemp',
        appDataEntityId: 'plmweb.psdelogiclink',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.psdelogiclink',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'getdrafttemp',
        appDataEntityId: 'plmweb.psdelogiclink',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'gettemp',
        appDataEntityId: 'plmweb.psdelogiclink',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'removetemp',
        appDataEntityId: 'plmweb.psdelogiclink',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'updatetemp',
        appDataEntityId: 'plmweb.psdelogiclink',
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
              capLanguageRes: {
                lanResTag:
                  'CONTROL.DEFORM.PSDELOGICLINK.MAIN.GROUPPANEL.GROUP1',
              },
              caption: '实体处理逻辑链接基本信息',
              codeName: 'group1',
              detailStyle: 'DEFAULT',
              detailType: 'GROUPPANEL',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'group1',
            },
            {
              dataType: 25,
              labelPos: 'LEFT',
              labelWidth: 130,
              noPrivDisplayMode: 1,
              appDEFieldId: 'psdelogiclinkid',
              editor: {
                editorType: 'HIDDEN',
                valueType: 'SIMPLE',
                editable: true,
                id: 'psdelogiclinkid',
              },
              allowEmpty: true,
              hidden: true,
              capLanguageRes: {
                lanResTag: 'DEF.LNAME.PSDELOGICLINKID',
              },
              caption: '实体处理逻辑链接标识',
              codeName: 'psdelogiclinkid',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              id: 'psdelogiclinkid',
            },
          ],
          capLanguageRes: {
            lanResTag: 'CONTROL.DEFORM.PSDELOGICLINK.MAIN.FORMPAGE.FORMPAGE1',
          },
          caption: '基本信息',
          codeName: 'formpage1',
          detailStyle: 'DEFAULT',
          detailType: 'FORMPAGE',
          id: 'formpage1',
        },
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
              capLanguageRes: {
                lanResTag:
                  'CONTROL.DEFORM.PSDELOGICLINK.MAIN.GROUPPANEL.GROUP2',
              },
              caption: '操作信息',
              codeName: 'group2',
              detailStyle: 'DEFAULT',
              detailType: 'GROUPPANEL',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'group2',
            },
          ],
          capLanguageRes: {
            lanResTag: 'CONTROL.DEFORM.PSDELOGICLINK.MAIN.FORMPAGE.FORMPAGE2',
          },
          caption: '其它',
          codeName: 'formpage2',
          detailStyle: 'DEFAULT',
          detailType: 'FORMPAGE',
          id: 'formpage2',
        },
      ],
      layout: {
        columnCount: 24,
        layout: 'TABLE_24COL',
      },
      tabHeaderPos: 'TOP',
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'main',
      controlStyle: 'X6DesignLink',
      controlType: 'FORM',
      logicName: '主编辑表单',
      appDataEntityId: 'plmweb.psdelogiclink',
      controlParam: {
        id: 'link',
      },
      sysPFPluginId: 'x6designlink',
      modelId: '9d6a9c6668843b5b5a3c6a368f20f966',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'link',
      id: 'plmweb.psdelogiclink.main',
    },
    {
      createControlAction: {
        appDEMethodId: 'create',
        appDataEntityId: 'plmweb.psdemslogic',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.psdemslogic',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'getdraft',
        appDataEntityId: 'plmweb.psdemslogic',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.psdemslogic',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.psdemslogic',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.psdemslogic',
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
                  dataType: 25,
                  enableCond: 3,
                  labelPos: 'LEFT',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'psdelogicname',
                  editor: {
                    maxLength: 200,
                    editorType: 'TEXTBOX',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'psdelogicname',
                  },
                  allowEmpty: true,
                  caption: '实体处理逻辑名称',
                  codeName: 'psdelogicname',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'psdelogicname',
                },
              ],
              caption: '实体主状态迁移逻辑基本信息',
              codeName: 'group1',
              detailStyle: 'DEFAULT',
              detailType: 'GROUPPANEL',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'group1',
            },
            {
              dataType: 25,
              enableCond: 3,
              labelPos: 'LEFT',
              labelWidth: 130,
              noPrivDisplayMode: 1,
              appDEFieldId: 'psdelogicid',
              editor: {
                editorType: 'HIDDEN',
                valueType: 'SIMPLE',
                editable: true,
                id: 'psdelogicid',
              },
              allowEmpty: true,
              hidden: true,
              caption: '实体处理逻辑标识',
              codeName: 'psdelogicid',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              id: 'psdelogicid',
            },
          ],
          caption: '基本信息',
          codeName: 'formpage1',
          detailStyle: 'DEFAULT',
          detailType: 'FORMPAGE',
          id: 'formpage1',
        },
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
                  dataType: 25,
                  enableCond: 3,
                  ignoreInput: 3,
                  labelPos: 'LEFT',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'createman',
                  editor: {
                    halign: 'LEFT',
                    valign: 'MIDDLE',
                    wrapMode: 'NOWRAP',
                    appCodeListId: 'plmweb.sysoperator',
                    editorType: 'SPAN',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'createman',
                  },
                  allowEmpty: true,
                  convertToCodeItemText: true,
                  capLanguageRes: {
                    lanResTag: 'DEF.LNAME.CREATEMAN',
                  },
                  caption: '建立人',
                  codeName: 'createman',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'createman',
                },
                {
                  dataType: 5,
                  enableCond: 3,
                  ignoreInput: 3,
                  labelPos: 'LEFT',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'createdate',
                  editor: {
                    halign: 'LEFT',
                    valign: 'MIDDLE',
                    wrapMode: 'NOWRAP',
                    editorType: 'SPAN',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'createdate',
                  },
                  valueFormat: 'YYYY-MM-DD HH:mm:ss',
                  allowEmpty: true,
                  capLanguageRes: {
                    lanResTag: 'DEF.LNAME.CREATEDATE',
                  },
                  caption: '建立时间',
                  codeName: 'createdate',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'createdate',
                },
                {
                  dataType: 25,
                  enableCond: 3,
                  ignoreInput: 3,
                  labelPos: 'LEFT',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'updateman',
                  editor: {
                    halign: 'LEFT',
                    valign: 'MIDDLE',
                    wrapMode: 'NOWRAP',
                    appCodeListId: 'plmweb.sysoperator',
                    editorType: 'SPAN',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'updateman',
                  },
                  allowEmpty: true,
                  convertToCodeItemText: true,
                  capLanguageRes: {
                    lanResTag: 'DEF.LNAME.UPDATEMAN',
                  },
                  caption: '更新人',
                  codeName: 'updateman',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'updateman',
                },
                {
                  dataType: 5,
                  enableCond: 3,
                  ignoreInput: 3,
                  labelPos: 'LEFT',
                  labelWidth: 130,
                  noPrivDisplayMode: 1,
                  appDEFieldId: 'updatedate',
                  editor: {
                    halign: 'LEFT',
                    valign: 'MIDDLE',
                    wrapMode: 'NOWRAP',
                    editorType: 'SPAN',
                    valueType: 'SIMPLE',
                    editable: true,
                    id: 'updatedate',
                  },
                  valueFormat: 'YYYY-MM-DD HH:mm:ss',
                  allowEmpty: true,
                  capLanguageRes: {
                    lanResTag: 'DEF.LNAME.UPDATEDATE',
                  },
                  caption: '更新时间',
                  codeName: 'updatedate',
                  detailStyle: 'DEFAULT',
                  detailType: 'FORMITEM',
                  layoutPos: {
                    colMD: 24,
                    layout: 'TABLE_24COL',
                  },
                  showCaption: true,
                  id: 'updatedate',
                },
              ],
              caption: '操作信息',
              codeName: 'group2',
              detailStyle: 'DEFAULT',
              detailType: 'GROUPPANEL',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              showCaption: true,
              id: 'group2',
            },
          ],
          caption: '其它',
          codeName: 'formpage2',
          detailStyle: 'DEFAULT',
          detailType: 'FORMPAGE',
          id: 'formpage2',
        },
      ],
      layout: {
        columnCount: 24,
        layout: 'TABLE_24COL',
      },
      tabHeaderPos: 'TOP',
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'api',
      controlType: 'FORM',
      logicName: '接口表单',
      appDataEntityId: 'plmweb.psdemslogic',
      controlParam: {
        id: 'form',
      },
      modelId: 'A8DFD167-811E-45DA-AF3C-29EE07BB7A5A',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.psdemslogic.api',
    },
    {
      caption: '主状态逻辑设计',
      codeName: 'ms_logic_design_custom_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.psdemslogic',
      controlParam: {},
      name: 'captionbar',
      id: 'ms_logic_design_custom_captionbar',
    },
  ],
  sysPFPluginId: 'x6designview',
  viewLayoutPanel: {
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
                caption: '标题',
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
            id: 'container4',
          },
          {
            actionGroupExtractMode: 'ITEM',
            panelItems: [
              {
                editor: {
                  halign: 'LEFT',
                  renderMode: 'TEXT_DYNAMIC',
                  valign: 'MIDDLE',
                  wrapMode: 'NOWRAP',
                  appCodeListId: 'plmweb.extension__mslogicdesignmode',
                  editorType: 'SPAN',
                  predefinedType: 'X6_PANEL_ITEM_SWITCH',
                  valueType: 'SIMPLE',
                  editable: true,
                  id: 'x6_panel_item_switch',
                },
                allowEmpty: true,
                convertToCodeItemText: true,
                caption: '文本(动态)',
                itemStyle: 'DEFAULT',
                itemType: 'FIELD',
                layoutPos: {
                  grow: 1,
                  shrink: 1,
                  layout: 'FLEX',
                },
                id: 'x6_panel_item_switch',
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
            contentWidth: 154,
            itemStyle: 'DEFAULT',
            itemType: 'CONTAINER',
            layoutPos: {
              shrink: 1,
              heightMode: 'PERCENTAGE',
              layout: 'FLEX',
              width: 154,
              widthMode: 'PX',
            },
            width: 154,
            id: 'container9',
          },
          {
            actionGroupExtractMode: 'ITEM',
            panelItems: [
              {
                actionGroupExtractMode: 'ITEM',
                panelItems: [
                  {
                    editor: {
                      halign: 'LEFT',
                      renderMode: 'TEXT_DYNAMIC',
                      valign: 'MIDDLE',
                      wrapMode: 'NOWRAP',
                      editorType: 'SPAN',
                      predefinedType: 'ACTIVE_HOME_BUTTON',
                      valueType: 'SIMPLE',
                      editable: true,
                      id: 'field_text_dynamic',
                    },
                    allowEmpty: true,
                    caption: '文本(动态)',
                    itemStyle: 'DEFAULT',
                    itemType: 'FIELD',
                    layoutPos: {
                      shrink: 1,
                      layout: 'FLEX',
                    },
                    id: 'field_text_dynamic',
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
                  layout: 'FLEX',
                },
                id: 'container6',
              },
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
                  align: 'flex-end',
                  dir: 'row',
                  layout: 'FLEX',
                },
                dataRegionType: 'INHERIT',
                caption: '容器',
                contentWidth: 350,
                itemStyle: 'DEFAULT',
                itemType: 'CONTAINER',
                layoutPos: {
                  shrink: 1,
                  layout: 'FLEX',
                  width: 350,
                  widthMode: 'PX',
                },
                width: 350,
                id: 'container8',
              },
            ],
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
              shrink: 1,
              heightMode: 'FULL',
              layout: 'FLEX',
            },
            id: 'container5',
          },
        ],
        layout: {
          align: 'space-between',
          dir: 'row',
          layout: 'FLEX',
        },
        dataRegionType: 'INHERIT',
        caption: '容器',
        contentHeight: 48,
        height: 48,
        itemStyle: 'DEFAULT',
        itemType: 'CONTAINER',
        layoutPos: {
          shrink: 0,
          height: 48,
          heightMode: 'PX',
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
                    editor: {
                      halign: 'LEFT',
                      renderMode: 'TEXT_DYNAMIC',
                      valign: 'MIDDLE',
                      wrapMode: 'NOWRAP',
                      appCodeListId: 'plmweb.extension__delogicnodetype_ms',
                      editorType: 'SPAN',
                      predefinedType: 'X6_PANEL_ITEM_STENCIL',
                      valueType: 'SIMPLE',
                      editable: true,
                      id: 'x6_panel_item_stencil',
                    },
                    allowEmpty: true,
                    convertToCodeItemText: true,
                    caption: '文本(动态)',
                    itemStyle: 'DEFAULT',
                    itemType: 'FIELD',
                    layoutPos: {
                      grow: 1,
                      shrink: 1,
                      heightMode: 'FULL',
                      layout: 'FLEX',
                    },
                    id: 'x6_panel_item_stencil',
                  },
                ],
                layout: {
                  dir: 'column',
                  layout: 'FLEX',
                },
                dataRegionType: 'INHERIT',
                caption: '容器',
                contentWidth: 300,
                itemStyle: 'DEFAULT',
                itemType: 'CONTAINER',
                layoutPos: {
                  shrink: 0,
                  heightMode: 'FULL',
                  layout: 'FLEX',
                  width: 300,
                  widthMode: 'PX',
                },
                width: 300,
                id: 'container1',
              },
              {
                actionGroupExtractMode: 'ITEM',
                panelItems: [
                  {
                    rawItem: {
                      contentType: 'USER',
                      predefinedType: 'X6_PANEL_ITEM',
                      id: 'x6_panel_item',
                    },
                    caption: 'X6设计器',
                    itemStyle: 'DEFAULT',
                    itemType: 'RAWITEM',
                    layoutPos: {
                      grow: 1,
                      shrink: 1,
                      heightMode: 'FULL',
                      layout: 'FLEX',
                    },
                    showCaption: true,
                    id: 'x6_panel_item',
                  },
                ],
                layout: {
                  dir: 'column',
                  layout: 'FLEX',
                },
                dataRegionType: 'INHERIT',
                caption: '容器',
                itemStyle: 'DEFAULT',
                itemType: 'CONTAINER',
                layoutPos: {
                  grow: 1,
                  shrink: 1,
                  heightMode: 'FULL',
                  layout: 'FLEX',
                },
                id: 'container2',
              },
            ],
            layout: {
              dir: 'row',
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
            panelItemGroupLogics: [
              {
                logicCat: 'PANELVISIBLE',
                relatedItemNames: ['x6_panel_item_switch'],
                groupOP: 'AND',
                panelItemLogics: [
                  {
                    condOp: 'EQ',
                    dstModelField: 'X6_PANEL_ITEM_SWITCH',
                    value: 'graph',
                    logicType: 'SINGLE',
                    id: '逻辑项',
                  },
                ],
                logicType: 'GROUP',
                id: '面板成员[container_graph][面板显示]逻辑',
              },
            ],
            id: 'container_graph',
          },
          {
            actionGroupExtractMode: 'ITEM',
            panelItems: [
              {
                editor: {
                  halign: 'LEFT',
                  renderMode: 'TEXT_DYNAMIC',
                  valign: 'MIDDLE',
                  wrapMode: 'NOWRAP',
                  editorType: 'SPAN',
                  predefinedType: 'X6_PANEL_ITEM_TABLE',
                  valueType: 'SIMPLE',
                  editable: true,
                  id: 'x6_panel_item_table',
                },
                allowEmpty: true,
                caption: '文本(动态)',
                itemStyle: 'DEFAULT',
                itemType: 'FIELD',
                layoutPos: {
                  shrink: 1,
                  layout: 'FLEX',
                },
                id: 'x6_panel_item_table',
              },
            ],
            layout: {
              dir: 'column',
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
            panelItemGroupLogics: [
              {
                logicCat: 'PANELVISIBLE',
                relatedItemNames: ['x6_panel_item_switch'],
                groupOP: 'AND',
                panelItemLogics: [
                  {
                    condOp: 'EQ',
                    dstModelField: 'X6_PANEL_ITEM_SWITCH',
                    value: 'table',
                    logicType: 'SINGLE',
                    id: '逻辑项',
                  },
                ],
                logicType: 'GROUP',
                id: '面板成员[container_table][面板显示]逻辑',
              },
            ],
            id: 'container_table',
          },
          {
            actionGroupExtractMode: 'ITEM',
            panelItems: [
              {
                rawItem: {
                  rawItemParams: [
                    {
                      key: 'EXPCACHE',
                      value: 'NO_CACHE',
                    },
                    {
                      key: 'EXPMODE',
                      value: 'NO_ROUTE',
                    },
                  ],
                  predefinedType: 'NAV_POS',
                  id: 'nav_pos',
                },
                caption: '导航区占位',
                itemStyle: 'DEFAULT',
                itemType: 'RAWITEM',
                layoutPos: {
                  grow: 1,
                  shrink: 1,
                  heightMode: 'FULL',
                  layout: 'FLEX',
                },
                showCaption: true,
                id: 'nav_pos',
              },
            ],
            layout: {
              dir: 'column',
              layout: 'FLEX',
            },
            dataRegionType: 'INHERIT',
            caption: '容器',
            contentWidth: 300,
            itemStyle: 'DEFAULT',
            itemType: 'CONTAINER',
            layoutPos: {
              shrink: 0,
              heightMode: 'FULL',
              layout: 'FLEX',
              width: 300,
              widthMode: 'PX',
            },
            width: 300,
            id: 'container3',
          },
        ],
        layout: {
          dir: 'row',
          layout: 'FLEX',
        },
        dataRegionType: 'INHERIT',
        caption: '容器',
        itemStyle: 'DEFAULT',
        itemType: 'CONTAINER',
        layoutPos: {
          grow: 1,
          shrink: 1,
          heightMode: 'FULL',
          layout: 'FLEX',
        },
        id: 'container',
      },
    ],
    layoutPanel: true,
    codeName: 'ms_logic_design_layout',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: '主状态逻辑设计布局面板',
    appDataEntityId: 'plmweb.psdemslogic',
    controlParam: {},
    modelId: 'c4e15af4ff590fdafe18f8f246124fcc',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'ms_logic_design_layout',
  },
  priority: 30,
  title: '主状态逻辑设计',
  viewStyle: 'X6DesignView',
  viewType: 'DECUSTOMVIEW',
  width: 90,
  enableDP: true,
  showCaptionBar: true,
  modelId: '6efb451291688840684d1fb8386d7d7e',
  modelType: 'PSAPPDEVIEW',
  name: 'PSDEMSLogicMSLogicDesign_Custom',
  id: 'plmweb.psdems_logic_ms_logic_design_custom',
};