export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  deviewCodeName: 'conclude_edit_view',
  deviewId: 'A939EA58-CE48-40D4-957A-D3CC00AFAE40',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.TEST_PLAN',
  },
  caption: '测试计划',
  codeName: 'test_plan_conclude_edit_view',
  appDataEntityId: 'plmweb.test_plan',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'EditView',
      id: 'engine',
    },
  ],
  controls: [
    {
      autoSaveMode: 1,
      createControlAction: {
        appDEMethodId: 'create',
        appDataEntityId: 'plmweb.test_plan',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.test_plan',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'get_draft',
        appDataEntityId: 'plmweb.test_plan',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.test_plan',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.test_plan',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.test_plan',
        id: 'update',
      },
      enableAutoSave: true,
      deformPages: [
        {
          layout: {
            columnCount: 24,
            layout: 'TABLE_24COL',
          },
          deformDetails: [
            {
              dataType: 21,
              enableCond: 3,
              labelPos: 'NONE',
              noPrivDisplayMode: 1,
              appDEFieldId: 'summary',
              editor: {
                editorParams: {
                  USERINSCRIPT:
                    'value.replaceAll(/\\@\\{\\"(user)?id\\":\\"(.+?)\\",\\"name\\":\\"(.+?)\\"\\}/g,(x, user, id, name) => {return controller.getNodeInfo({ id, name })}).replaceAll(/\\@\\{userid=(.+?),name=(.+?)\\}/g,(x, id, name) => {return controller.getNodeInfo({ id, name })})',
                  MAXHEIGHT: '450',
                  QUOTECODELISTMAP: '{"type":"plmweb.base__recent_visite"}',
                  enableEdit: 'true',
                  QUOTEFIELDMAP:
                    '{"identifier":"show_identifier","name":"name","id":"id","type":"owner_subtype"}',
                  QUOTEPARAMS: '{"page":0,"size":20,"sort":"update_time,desc"}',
                  enableFullScreen: 'true',
                  MODE: 'default',
                  QUOTEINSCRIPT:
                    'value.replaceAll(/\\#\\{\\"id\\":\\"(.+?)\\",\\"name\\":\\"(.+?)\\",\\"identifier\\":\\"(.+?)\\",\\"icon\\":\\"((.|[\\t\\r\\f\\n\\s])+?)\\"\\}/g,(x, id, name, identifier, icon) => {return controller.getNodeInfo({ id, name, identifier, icon })}).replaceAll(/\\#\\{id=(.+?),name=(.+?),identifier=(.+?),icon=((.|[\\t\\r\\f\\n\\s])+?)\\}/g,(x, id, name, identifier, icon) => {return controller.getNodeInfo({ id, name, identifier, icon })})',
                  USERSCRIPT: '`@{"id":"${data.id}","name":"${data.name}"}`',
                  QUOTESCRIPT:
                    '`#{"id":"${data.id}","name":"${data.name}","identifier":"${data.identifier}","icon":"${data.icon}"}`',
                  USERURL:
                    "`${context.library ? `libraries/${context.library}/library_members/fetchdefault` : context.product ? `products/${context.product}/product_members/fetchdefault` : context.project ? `projects/${context.project}/project_members/fetchdefault` : ''}`",
                  USERFIELDMAP: '{"id":"user_id","name":"name"}',
                  INSERTKEYS:
                    '[{"index":66,"keys":["marker"]},{"index":5,"keys":["paintformat"]}]',
                  QUOTEURL: '`recents/fetchrecent_access`',
                },
                editorStyle: 'COLLAPSE',
                editorType: 'HTMLEDITOR',
                sysPFPluginId: 'comment',
                valueType: 'SIMPLE',
                editable: true,
                id: 'summary',
              },
              allowEmpty: true,
              caption: '测试报告概要',
              codeName: 'summary',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              id: 'summary',
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
              showCaption: true,
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
      codeName: 'report_conclude',
      controlType: 'FORM',
      logicName: '报告总结',
      appDataEntityId: 'plmweb.test_plan',
      controlParam: {
        ctrlParams: {
          EDITMODE: 'hover',
        },
        id: 'form',
      },
      sysCss: {
        cssName: 'html-readonly-bg-white',
      },
      modelId: 'C4F4EBFB-C29D-4ECB-9F88-659AFAF1F74D',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.test_plan.report_conclude',
    },
    {
      codeName: 'conclude_edit_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.test_plan',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'conclude_edit_view_datainfobar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.TEST_PLAN',
      },
      caption: '测试计划',
      codeName: 'conclude_edit_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.test_plan',
      controlParam: {},
      name: 'captionbar',
      id: 'conclude_edit_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEEDITVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.test_plan',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '报告总结',
  viewStyle: 'DEFAULT',
  viewType: 'DEEDITVIEW',
  enableDP: true,
  showCaptionBar: false,
  modelId: '6fe42ea9c04a963d5abd05747916af62',
  modelType: 'PSAPPDEVIEW',
  name: 'test_planconclude_edit_view',
  id: 'plmweb.test_plan_conclude_edit_view',
};