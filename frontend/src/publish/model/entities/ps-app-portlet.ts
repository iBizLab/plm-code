export default {
  appDEACModes: [
    {
      actype: 'AUTOCOMPLETE',
      codeName: 'Default',
      logicName: 'DEFAULT',
      deacmodeDataItems: [
        {
          appDEFieldId: 'psappportletid',
          dataType: 25,
          id: 'value',
        },
        {
          appDEFieldId: 'psappportletname',
          dataType: 25,
          id: 'text',
        },
      ],
      pagingSize: 50,
      defaultMode: true,
      textAppDEFieldId: 'psappportletname',
      valueAppDEFieldId: 'psappportletid',
      name: 'DEFAULT',
      id: 'default',
    },
  ],
  appDEFields: [
    {
      codeName: 'DynaModelFlag',
      logicName: '扩展模型',
      stdDataType: 9,
      name: 'DYNAMODELFLAG',
      id: 'dynamodelflag',
    },
    {
      codeName: 'PSAppPortletId',
      logicName: '应用门户部件标识',
      stdDataType: 25,
      stringLength: 100,
      name: 'PSAPPPORTLETID',
      id: 'psappportletid',
    },
    {
      codeName: 'PSAppPortletName',
      logicName: '应用门户部件名称',
      stdDataType: 25,
      stringLength: 200,
      enableQuickSearch: true,
      name: 'PSAPPPORTLETNAME',
      id: 'psappportletname',
    },
    {
      codeName: 'CodeName',
      logicName: '代码名称',
      stdDataType: 25,
      stringLength: 50,
      name: 'CODENAME',
      id: 'codename',
    },
    {
      codeName: 'Memo',
      logicName: '备注',
      stdDataType: 25,
      stringLength: 2000,
      name: 'MEMO',
      id: 'memo',
    },
    {
      codeName: 'ValidFlag',
      logicName: '是否启用',
      stdDataType: 9,
      name: 'VALIDFLAG',
      id: 'validflag',
    },
    {
      codeName: 'PortletType',
      logicName: '看板部件类型',
      stdDataType: 25,
      stringLength: 40,
      name: 'PORTLETTYPE',
      id: 'portlettype',
    },
    {
      codeName: 'PSDEName',
      logicName: '实体',
      stdDataType: 25,
      stringLength: 100,
      name: 'PSDENAME',
      id: 'psdename',
    },
    {
      codeName: 'PSDEReportId',
      logicName: '实体报表',
      stdDataType: 25,
      stringLength: 100,
      name: 'PSDEREPORTID',
      id: 'psdereportid',
    },
    {
      codeName: 'PSDEReportName',
      logicName: '实体报表',
      stdDataType: 25,
      stringLength: 100,
      name: 'PSDEREPORTNAME',
      id: 'psdereportname',
    },
    {
      codeName: 'PSDEId',
      logicName: '实体',
      stdDataType: 25,
      stringLength: 100,
      name: 'PSDEID',
      id: 'psdeid',
    },
    {
      codeName: 'PSDEListId',
      logicName: '实体列表',
      stdDataType: 25,
      stringLength: 100,
      name: 'PSDELISTID',
      id: 'psdelistid',
    },
    {
      codeName: 'PSDEListName',
      logicName: '实体列表',
      stdDataType: 25,
      stringLength: 100,
      name: 'PSDELISTNAME',
      id: 'psdelistname',
    },
    {
      codeName: 'PSDEToolbarName',
      logicName: '工具栏',
      stdDataType: 25,
      stringLength: 100,
      name: 'PSDETOOLBARNAME',
      id: 'psdetoolbarname',
    },
    {
      codeName: 'PSDEUAGroupId',
      logicName: '界面行为组',
      stdDataType: 25,
      stringLength: 100,
      name: 'PSDEUAGROUPID',
      id: 'psdeuagroupid',
    },
    {
      codeName: 'PSDEToolbarId',
      logicName: '工具栏',
      stdDataType: 25,
      stringLength: 100,
      name: 'PSDETOOLBARID',
      id: 'psdetoolbarid',
    },
    {
      codeName: 'PSDEUAGroupName',
      logicName: '界面行为组',
      stdDataType: 25,
      stringLength: 100,
      name: 'PSDEUAGROUPNAME',
      id: 'psdeuagroupname',
    },
    {
      codeName: 'PSSysCalendarName',
      logicName: '日历部件',
      stdDataType: 25,
      stringLength: 100,
      name: 'PSSYSCALENDARNAME',
      id: 'pssyscalendarname',
    },
    {
      codeName: 'PSSysCalendarId',
      logicName: '日历部件',
      stdDataType: 25,
      stringLength: 100,
      name: 'PSSYSCALENDARID',
      id: 'pssyscalendarid',
    },
    {
      codeName: 'ShowTitleBar',
      logicName: '显示标题栏',
      stdDataType: 9,
      name: 'SHOWTITLEBAR',
      id: 'showtitlebar',
    },
    {
      codeName: 'PSSysMapViewId',
      logicName: '地图部件',
      stdDataType: 25,
      stringLength: 100,
      name: 'PSSYSMAPVIEWID',
      id: 'pssysmapviewid',
    },
    {
      codeName: 'PSSysMapViewName',
      logicName: '地图部件',
      stdDataType: 25,
      stringLength: 100,
      name: 'PSSYSMAPVIEWNAME',
      id: 'pssysmapviewname',
    },
    {
      codeName: 'PSDEChartId',
      logicName: '实体图表',
      stdDataType: 25,
      stringLength: 100,
      name: 'PSDECHARTID',
      id: 'psdechartid',
    },
    {
      codeName: 'PSDEDataViewId',
      logicName: '实体数据视图',
      stdDataType: 25,
      stringLength: 100,
      name: 'PSDEDATAVIEWID',
      id: 'psdedataviewid',
    },
    {
      codeName: 'PSDEChartName',
      logicName: '实体图表',
      stdDataType: 25,
      stringLength: 100,
      name: 'PSDECHARTNAME',
      id: 'psdechartname',
    },
    {
      codeName: 'PSDEDataViewName',
      logicName: '实体数据视图',
      stdDataType: 25,
      stringLength: 100,
      name: 'PSDEDATAVIEWNAME',
      id: 'psdedataviewname',
    },
    {
      codeName: 'PSDEFormId',
      logicName: '实体表单',
      stdDataType: 25,
      stringLength: 100,
      userTag: 'RESERVEMODELV2',
      name: 'PSDEFORMID',
      id: 'psdeformid',
    },
    {
      codeName: 'PSDEViewId',
      logicName: '系统视图',
      stdDataType: 25,
      stringLength: 100,
      name: 'PSDEVIEWID',
      id: 'psdeviewid',
    },
    {
      codeName: 'PSDEFormName',
      logicName: '实体表单',
      stdDataType: 25,
      stringLength: 100,
      userTag: 'RESERVEMODELV2',
      name: 'PSDEFORMNAME',
      id: 'psdeformname',
    },
    {
      codeName: 'PSDEViewName',
      logicName: '系统视图',
      stdDataType: 25,
      stringLength: 100,
      name: 'PSDEVIEWNAME',
      id: 'psdeviewname',
    },
    {
      codeName: 'PSSysPortletCatName',
      logicName: '部件分类',
      stdDataType: 25,
      stringLength: 100,
      name: 'PSSYSPORTLETCATNAME',
      id: 'pssysportletcatname',
    },
    {
      codeName: 'PSSysPortletCatId',
      logicName: '部件分类',
      stdDataType: 25,
      stringLength: 100,
      name: 'PSSYSPORTLETCATID',
      id: 'pssysportletcatid',
    },
    {
      codeName: 'PSSysAppName',
      logicName: '系统应用',
      stdDataType: 25,
      stringLength: 100,
      name: 'PSSYSAPPNAME',
      id: 'pssysappname',
    },
    {
      codeName: 'PSSysAppId',
      logicName: '系统应用',
      stdDataType: 25,
      stringLength: 100,
      name: 'PSSYSAPPID',
      id: 'pssysappid',
    },
  ],
  appDEMethodDTOs: [
    {
      codeName: 'PSAppPortletDTO',
      appDEMethodDTOFields: [
        {
          codeName: 'DynaModelFlag',
          logicName: '扩展模型',
          appDEFieldId: 'dynamodelflag',
          sourceType: 'DEFIELD',
          stdDataType: 9,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'DynaModelFlag',
          id: 'dynamodelflag',
        },
        {
          codeName: 'CodeName',
          logicName: '代码名称',
          appDEFieldId: 'codename',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          name: 'CodeName',
          id: 'codename',
        },
        {
          codeName: 'Memo',
          logicName: '备注',
          appDEFieldId: 'memo',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'Memo',
          id: 'memo',
        },
        {
          codeName: 'PSAppPortletId',
          logicName: '应用门户部件标识',
          appDEFieldId: 'psappportletid',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          name: 'PSAppPortletId',
          id: 'psappportletid',
        },
        {
          codeName: 'PSAppPortletName',
          logicName: '应用门户部件名称',
          appDEFieldId: 'psappportletname',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          name: 'PSAppPortletName',
          id: 'psappportletname',
        },
        {
          codeName: 'PSDEChartId',
          logicName: '实体图表',
          appDEFieldId: 'psdechartid',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'PSDEChartId',
          id: 'psdechartid',
        },
        {
          codeName: 'PSDEChartName',
          logicName: '实体图表',
          appDEFieldId: 'psdechartname',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'PSDEChartName',
          id: 'psdechartname',
        },
        {
          codeName: 'PSDEDataViewId',
          logicName: '实体数据视图',
          appDEFieldId: 'psdedataviewid',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'PSDEDataViewId',
          id: 'psdedataviewid',
        },
        {
          codeName: 'PSDEDataViewName',
          logicName: '实体数据视图',
          appDEFieldId: 'psdedataviewname',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'PSDEDataViewName',
          id: 'psdedataviewname',
        },
        {
          codeName: 'PSDEFormId',
          logicName: '实体表单',
          appDEFieldId: 'psdeformid',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'PSDEFormId',
          id: 'psdeformid',
        },
        {
          codeName: 'PSDEFormName',
          logicName: '实体表单',
          appDEFieldId: 'psdeformname',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'PSDEFormName',
          id: 'psdeformname',
        },
        {
          codeName: 'PSDEId',
          logicName: '实体',
          appDEFieldId: 'psdeid',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'PSDEId',
          id: 'psdeid',
        },
        {
          codeName: 'PSDEListId',
          logicName: '实体列表',
          appDEFieldId: 'psdelistid',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'PSDEListId',
          id: 'psdelistid',
        },
        {
          codeName: 'PSDEListName',
          logicName: '实体列表',
          appDEFieldId: 'psdelistname',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'PSDEListName',
          id: 'psdelistname',
        },
        {
          codeName: 'PSDEName',
          logicName: '实体',
          appDEFieldId: 'psdename',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'PSDEName',
          id: 'psdename',
        },
        {
          codeName: 'PSDEReportId',
          logicName: '实体报表',
          appDEFieldId: 'psdereportid',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'PSDEReportId',
          id: 'psdereportid',
        },
        {
          codeName: 'PSDEReportName',
          logicName: '实体报表',
          appDEFieldId: 'psdereportname',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'PSDEReportName',
          id: 'psdereportname',
        },
        {
          codeName: 'PSDEToolbarId',
          logicName: '工具栏',
          appDEFieldId: 'psdetoolbarid',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'PSDEToolbarId',
          id: 'psdetoolbarid',
        },
        {
          codeName: 'PSDEToolbarName',
          logicName: '工具栏',
          appDEFieldId: 'psdetoolbarname',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'PSDEToolbarName',
          id: 'psdetoolbarname',
        },
        {
          codeName: 'PSDEUAGroupId',
          logicName: '界面行为组',
          appDEFieldId: 'psdeuagroupid',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'PSDEUAGroupId',
          id: 'psdeuagroupid',
        },
        {
          codeName: 'PSDEUAGroupName',
          logicName: '界面行为组',
          appDEFieldId: 'psdeuagroupname',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'PSDEUAGroupName',
          id: 'psdeuagroupname',
        },
        {
          codeName: 'PSDEViewId',
          logicName: '系统视图',
          appDEFieldId: 'psdeviewid',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'PSDEViewId',
          id: 'psdeviewid',
        },
        {
          codeName: 'PSDEViewName',
          logicName: '系统视图',
          appDEFieldId: 'psdeviewname',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'PSDEViewName',
          id: 'psdeviewname',
        },
        {
          codeName: 'PSSysAppId',
          logicName: '系统应用',
          appDEFieldId: 'pssysappid',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          name: 'PSSysAppId',
          id: 'pssysappid',
        },
        {
          codeName: 'PSSysAppName',
          logicName: '系统应用',
          appDEFieldId: 'pssysappname',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'PSSysAppName',
          id: 'pssysappname',
        },
        {
          codeName: 'PSSysCalendarId',
          logicName: '日历部件',
          appDEFieldId: 'pssyscalendarid',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'PSSysCalendarId',
          id: 'pssyscalendarid',
        },
        {
          codeName: 'PSSysCalendarName',
          logicName: '日历部件',
          appDEFieldId: 'pssyscalendarname',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'PSSysCalendarName',
          id: 'pssyscalendarname',
        },
        {
          codeName: 'PSSysMapViewId',
          logicName: '地图部件',
          appDEFieldId: 'pssysmapviewid',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'PSSysMapViewId',
          id: 'pssysmapviewid',
        },
        {
          codeName: 'PSSysMapViewName',
          logicName: '地图部件',
          appDEFieldId: 'pssysmapviewname',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'PSSysMapViewName',
          id: 'pssysmapviewname',
        },
        {
          codeName: 'PSSysPortletCatId',
          logicName: '部件分类',
          appDEFieldId: 'pssysportletcatid',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'PSSysPortletCatId',
          id: 'pssysportletcatid',
        },
        {
          codeName: 'PSSysPortletCatName',
          logicName: '部件分类',
          appDEFieldId: 'pssysportletcatname',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'PSSysPortletCatName',
          id: 'pssysportletcatname',
        },
        {
          codeName: 'PortletType',
          logicName: '看板部件类型',
          appDEFieldId: 'portlettype',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          name: 'PortletType',
          id: 'portlettype',
        },
        {
          codeName: 'ShowTitleBar',
          logicName: '显示标题栏',
          appDEFieldId: 'showtitlebar',
          sourceType: 'DEFIELD',
          stdDataType: 9,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'ShowTitleBar',
          id: 'showtitlebar',
        },
        {
          codeName: 'ValidFlag',
          logicName: '是否启用',
          appDEFieldId: 'validflag',
          sourceType: 'DEFIELD',
          stdDataType: 9,
          type: 'SIMPLE',
          name: 'ValidFlag',
          id: 'validflag',
        },
      ],
      sourceType: 'DE',
      type: 'DEFAULT',
      name: 'PSAppPortletDTO',
      id: 'psappportletdto',
    },
    {
      codeName: 'PSAppPortletFilterDTO',
      appDEMethodDTOFields: [
        {
          codeName: 'N_DYNAMODELFLAG_EQ',
          logicName: '扩展模型',
          appDEFieldId: 'dynamodelflag',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 9,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'N_DYNAMODELFLAG_EQ',
          id: 'n_dynamodelflag_eq',
        },
        {
          codeName: 'N_DYNAMODELFLAG_NOTEQ',
          logicName: '扩展模型',
          appDEFieldId: 'dynamodelflag',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 9,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'N_DYNAMODELFLAG_NOTEQ',
          id: 'n_dynamodelflag_noteq',
        },
        {
          codeName: 'N_PORTLETTYPE_EQ',
          logicName: '看板部件类型',
          appDEFieldId: 'portlettype',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'N_PORTLETTYPE_EQ',
          id: 'n_portlettype_eq',
        },
        {
          codeName: 'N_PSAPPPORTLETID_EQ',
          logicName: '应用门户部件标识',
          appDEFieldId: 'psappportletid',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'N_PSAPPPORTLETID_EQ',
          id: 'n_psappportletid_eq',
        },
        {
          codeName: 'N_PSAPPPORTLETID_IN',
          logicName: '应用门户部件标识',
          appDEFieldId: 'psappportletid',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLES',
          allowEmpty: true,
          name: 'N_PSAPPPORTLETID_IN',
          id: 'n_psappportletid_in',
        },
        {
          codeName: 'N_PSAPPPORTLETNAME_LIKE',
          logicName: '应用门户部件名称',
          appDEFieldId: 'psappportletname',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'N_PSAPPPORTLETNAME_LIKE',
          id: 'n_psappportletname_like',
        },
        {
          codeName: 'N_PSSYSAPPID_EQ',
          logicName: '系统应用',
          appDEFieldId: 'pssysappid',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'N_PSSYSAPPID_EQ',
          id: 'n_pssysappid_eq',
        },
      ],
      sourceType: 'DE',
      type: 'DEFILTER',
      name: 'PSAppPortletFilterDTO',
      id: 'psappportletfilterdto',
    },
  ],
  appDEMethods: [
    {
      codeName: 'CheckKey',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'psappportletdto',
        type: 'DTO',
        id: '输入对象',
      },
      appDEMethodReturn: {
        stdDataType: 9,
        type: 'SIMPLE',
        id: '返回对象',
      },
      requestMethod: 'POST',
      requestParamType: 'ENTITY',
      requestPath: '/checkkey',
      actionMode: 'CHECKKEY',
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'CheckKey',
      id: 'checkkey',
    },
    {
      codeName: 'Create',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'psappportletdto',
        type: 'DTO',
        output: true,
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'psappportletdto',
        type: 'DTO',
        id: '返回对象',
      },
      requestMethod: 'POST',
      requestParamType: 'ENTITY',
      noServiceCodeName: true,
      actionMode: 'CREATE',
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'Create',
      id: 'create',
    },
    {
      codeName: 'Get',
      methodType: 'DEACTION',
      appDEMethodInput: {
        keyAppDEFieldId: 'psappportletid',
        type: 'KEYFIELD',
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'psappportletdto',
        type: 'DTO',
        id: '返回对象',
      },
      requestField: 'PSAPPPORTLETID',
      requestMethod: 'GET',
      requestParamType: 'FIELD',
      needResourceKey: true,
      noServiceCodeName: true,
      actionMode: 'READ',
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'Get',
      id: 'get',
    },
    {
      codeName: 'GetDraft',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'psappportletdto',
        type: 'DTO',
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'psappportletdto',
        type: 'DTO',
        id: '返回对象',
      },
      requestMethod: 'GET',
      requestParamType: 'NONE',
      requestPath: '/getdraft',
      actionMode: 'GETDRAFT',
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'GetDraft',
      id: 'getdraft',
    },
    {
      codeName: 'Remove',
      methodType: 'DEACTION',
      appDEMethodInput: {
        keyAppDEFieldId: 'psappportletid',
        type: 'KEYFIELDS',
        id: '输入对象',
      },
      appDEMethodReturn: {
        type: 'VOID',
        id: '返回对象',
      },
      requestField: 'PSAPPPORTLETID',
      requestMethod: 'DELETE',
      requestParamType: 'FIELD',
      needResourceKey: true,
      noServiceCodeName: true,
      actionMode: 'DELETE',
      actionType: 'REMOTE',
      batchActionMode: 1,
      enableBatchAction: true,
      dataSetType: 'REMOTE',
      name: 'Remove',
      id: 'remove',
    },
    {
      codeName: 'Save',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'psappportletdto',
        type: 'DTO',
        output: true,
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'psappportletdto',
        type: 'DTO',
        id: '返回对象',
      },
      requestMethod: 'POST',
      requestParamType: 'ENTITY',
      requestPath: '/save',
      actionMode: 'SAVE',
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'Save',
      id: 'save',
    },
    {
      codeName: 'Update',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'psappportletdto',
        type: 'DTO',
        output: true,
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'psappportletdto',
        type: 'DTO',
        id: '返回对象',
      },
      requestMethod: 'PUT',
      requestParamType: 'ENTITY',
      needResourceKey: true,
      noServiceCodeName: true,
      actionMode: 'UPDATE',
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'Update',
      id: 'update',
    },
    {
      codeName: 'FetchDefault',
      methodType: 'FETCH',
      appDEMethodInput: {
        appDEMethodDTOId: 'psappportletfilterdto',
        type: 'DTO',
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'psappportletdto',
        type: 'PAGE',
        id: '返回对象',
      },
      requestMethod: 'POST',
      requestParamType: 'ENTITY',
      requestPath: '/fetchdefault',
      actionType: 'REMOTE',
      dataSetName: 'DEFAULT',
      dataSetTag: 'Default',
      dataSetType: 'REMOTE',
      name: 'FetchDefault',
      id: 'fetchdefault',
    },
    {
      codeName: 'FilterCreate',
      methodType: 'FILTERACTION',
      builtinMethod: true,
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'FILTERCREATE',
      id: 'filtercreate',
    },
    {
      codeName: 'FilterFetch',
      methodType: 'FILTERACTION',
      builtinMethod: true,
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'FILTERFETCH',
      id: 'filterfetch',
    },
    {
      codeName: 'FilterGet',
      methodType: 'FILTERACTION',
      builtinMethod: true,
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'FILTERGET',
      id: 'filterget',
    },
    {
      codeName: 'FilterGetDraft',
      methodType: 'FILTERACTION',
      builtinMethod: true,
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'FILTERGETDRAFT',
      id: 'filtergetdraft',
    },
    {
      codeName: 'FilterRemove',
      methodType: 'FILTERACTION',
      builtinMethod: true,
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'FILTERREMOVE',
      id: 'filterremove',
    },
    {
      codeName: 'FilterSearch',
      methodType: 'FILTERACTION',
      builtinMethod: true,
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'FILTERSEARCH',
      id: 'filtersearch',
    },
    {
      codeName: 'FilterUpdate',
      methodType: 'FILTERACTION',
      builtinMethod: true,
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'FILTERUPDATE',
      id: 'filterupdate',
    },
  ],
  deopprivs: [
    {
      logicName: '建立',
      name: 'CREATE',
      id: 'create',
    },
    {
      logicName: '删除',
      name: 'DELETE',
      id: 'delete',
    },
    {
      logicName: '读取',
      name: 'READ',
      id: 'read',
    },
    {
      logicName: '更新',
      name: 'UPDATE',
      id: 'update',
    },
  ],
  codeName: 'PSAppPortlet',
  deapicodeName: 'psappportlet',
  deapicodeName2: 'psappportlets',
  deapitag: 'PSAPPPORTLET',
  dataAccCtrlArch: 1,
  dataAccCtrlMode: 1,
  enableUIActions: 15,
  keyAppDEFieldId: 'psappportletid',
  lnlanguageRes: {
    lanResTag: 'DE.LNAME.PSAPPPORTLET',
  },
  logicName: '应用门户部件',
  majorAppDEFieldId: 'psappportletname',
  quickSearchAppDEFieldIds: ['psappportletname'],
  sysAPITag: 'ServiceAPI',
  defaultMode: true,
  enableFilterActions: true,
  major: true,
  name: 'PSAPPPORTLET',
  id: 'plmweb.psappportlet',
  codeName2: 'PSAppPortlets',
  requestPaths: [],
};