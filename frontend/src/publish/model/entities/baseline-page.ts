export default {
  appDEACModes: [
    {
      actype: 'AUTOCOMPLETE',
      codeName: 'Default',
      logicName: 'DEFAULT',
      deacmodeDataItems: [
        {
          appDEFieldId: 'id',
          dataType: 25,
          id: 'value',
        },
        {
          appDEFieldId: 'name',
          dataType: 25,
          id: 'text',
        },
      ],
      pagingSize: 50,
      defaultMode: true,
      textAppDEFieldId: 'name',
      valueAppDEFieldId: 'id',
      name: 'DEFAULT',
      id: 'default',
    },
  ],
  appDEFields: [
    {
      codeName: 'principal_id',
      logicName: '关联主体标识',
      stdDataType: 25,
      stringLength: 100,
      name: 'PRINCIPAL_ID',
      id: 'principal_id',
    },
    {
      codeName: 'owner_type',
      logicName: '所属数据对象',
      stdDataType: 25,
      stringLength: 100,
      name: 'OWNER_TYPE',
      id: 'owner_type',
    },
    {
      codeName: 'principal_type',
      logicName: '关联主体类型',
      stdDataType: 25,
      stringLength: 100,
      name: 'PRINCIPAL_TYPE',
      id: 'principal_type',
    },
    {
      codeName: 'target_type',
      logicName: '关联目标类型',
      stdDataType: 25,
      stringLength: 100,
      name: 'TARGET_TYPE',
      id: 'target_type',
    },
    {
      codeName: 'target_id',
      logicName: '关联目标标识',
      stdDataType: 25,
      stringLength: 100,
      name: 'TARGET_ID',
      id: 'target_id',
    },
    {
      codeName: 'target_version_id',
      logicName: '目标对象版本标识',
      stdDataType: 25,
      stringLength: 100,
      name: 'TARGET_VERSION_ID',
      id: 'target_version_id',
    },
    {
      codeName: 'type',
      logicName: '页面类型',
      stdDataType: 25,
      stringLength: 200,
      name: 'TYPE',
      id: 'type',
    },
    {
      codeName: 'target_version',
      logicName: '关联目标版本',
      stdDataType: 21,
      stringLength: 1048576,
      name: 'TARGET_VERSION',
      id: 'target_version',
    },
    {
      codeName: 'baseline',
      logicName: '基线',
      stdDataType: 21,
      stringLength: 1048576,
      name: 'BASELINE',
      id: 'baseline',
    },
    {
      codeName: 'space_id',
      logicName: '空间标识',
      stdDataType: 25,
      stringLength: 100,
      name: 'SPACE_ID',
      id: 'space_id',
    },
    {
      codeName: 'cur_version_id',
      logicName: '当前版本标识',
      stdDataType: 25,
      stringLength: 100,
      name: 'CUR_VERSION_ID',
      id: 'cur_version_id',
    },
    {
      codeName: 'id',
      lnlanguageRes: {
        lanResTag: 'DEF.LNAME.ID',
      },
      logicName: '标识',
      stdDataType: 25,
      stringLength: 100,
      name: 'ID',
      id: 'id',
    },
    {
      codeName: 'name',
      lnlanguageRes: {
        lanResTag: 'DEF.LNAME.NAME',
      },
      logicName: '名称',
      stdDataType: 25,
      stringLength: 200,
      enableQuickSearch: true,
      name: 'NAME',
      id: 'name',
    },
    {
      codeName: 'create_man',
      lnlanguageRes: {
        lanResTag: 'DEF.LNAME.CREATE_MAN',
      },
      logicName: '建立人',
      stdDataType: 25,
      stringLength: 100,
      name: 'CREATE_MAN',
      id: 'create_man',
    },
    {
      codeName: 'create_time',
      lnlanguageRes: {
        lanResTag: 'DEF.LNAME.CREATE_TIME',
      },
      logicName: '建立时间',
      stdDataType: 5,
      valueFormat: 'YYYY-MM-DD HH:mm:ss',
      name: 'CREATE_TIME',
      id: 'create_time',
    },
    {
      codeName: 'update_man',
      lnlanguageRes: {
        lanResTag: 'DEF.LNAME.UPDATE_MAN',
      },
      logicName: '更新人',
      stdDataType: 25,
      stringLength: 100,
      name: 'UPDATE_MAN',
      id: 'update_man',
    },
    {
      codeName: 'update_time',
      lnlanguageRes: {
        lanResTag: 'DEF.LNAME.UPDATE_TIME',
      },
      logicName: '更新时间',
      stdDataType: 5,
      valueFormat: 'YYYY-MM-DD HH:mm:ss',
      name: 'UPDATE_TIME',
      id: 'update_time',
    },
  ],
  appDEMethodDTOs: [
    {
      codeName: 'baseline_page_dto',
      appDEMethodDTOFields: [
        {
          codeName: 'principal_id',
          logicName: '关联主体标识',
          appDEFieldId: 'principal_id',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'principal_id',
        },
        {
          codeName: 'owner_type',
          logicName: '所属数据对象',
          appDEFieldId: 'owner_type',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'owner_type',
        },
        {
          codeName: 'principal_type',
          logicName: '关联主体类型',
          appDEFieldId: 'principal_type',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'principal_type',
        },
        {
          codeName: 'target_type',
          logicName: '关联目标类型',
          appDEFieldId: 'target_type',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'target_type',
        },
        {
          codeName: 'target_id',
          logicName: '关联目标标识',
          appDEFieldId: 'target_id',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'target_id',
        },
        {
          codeName: 'target_version_id',
          logicName: '目标对象版本标识',
          appDEFieldId: 'target_version_id',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'target_version_id',
        },
        {
          codeName: 'type',
          logicName: '页面类型',
          appDEFieldId: 'type',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'type',
        },
        {
          codeName: 'target_version',
          logicName: '关联目标版本',
          appDEFieldId: 'target_version',
          refAppDEMethodDTOId: 'version_dto',
          refAppDataEntityId: 'plmweb.version',
          sourceType: 'DEFIELD',
          type: 'DTO',
          allowEmpty: true,
          id: 'target_version',
        },
        {
          codeName: 'baseline',
          logicName: '基线',
          appDEFieldId: 'baseline',
          refAppDEMethodDTOId: 'baseline_dto',
          refAppDataEntityId: 'plmweb.baseline',
          sourceType: 'DEFIELD',
          type: 'DTO',
          allowEmpty: true,
          id: 'baseline',
        },
        {
          codeName: 'space_id',
          logicName: '空间标识',
          appDEFieldId: 'space_id',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'space_id',
        },
        {
          codeName: 'cur_version_id',
          logicName: '当前版本标识',
          appDEFieldId: 'cur_version_id',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'cur_version_id',
        },
        {
          codeName: 'create_man',
          logicName: '建立人',
          appDEFieldId: 'create_man',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          id: 'create_man',
        },
        {
          codeName: 'create_time',
          jsonFormat: 'yyyy-MM-dd HH:mm:ss',
          logicName: '建立时间',
          appDEFieldId: 'create_time',
          sourceType: 'DEFIELD',
          stdDataType: 5,
          type: 'SIMPLE',
          id: 'create_time',
        },
        {
          codeName: 'id',
          logicName: '标识',
          appDEFieldId: 'id',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          id: 'id',
        },
        {
          codeName: 'name',
          logicName: '名称',
          appDEFieldId: 'name',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'name',
        },
        {
          codeName: 'update_man',
          logicName: '更新人',
          appDEFieldId: 'update_man',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          id: 'update_man',
        },
        {
          codeName: 'update_time',
          jsonFormat: 'yyyy-MM-dd HH:mm:ss',
          logicName: '更新时间',
          appDEFieldId: 'update_time',
          sourceType: 'DEFIELD',
          stdDataType: 5,
          type: 'SIMPLE',
          id: 'update_time',
        },
      ],
      sourceType: 'DE',
      type: 'DEFAULT',
      id: 'baseline_page_dto',
    },
    {
      codeName: 'baseline_page_filter_dto',
      appDEMethodDTOFields: [
        {
          codeName: 'n_id_eq',
          logicName: '标识',
          appDEFieldId: 'id',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'n_id_eq',
        },
        {
          codeName: 'n_name_like',
          logicName: '名称',
          appDEFieldId: 'name',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'n_name_like',
        },
        {
          codeName: 'n_principal_id_eq',
          logicName: '关联主体标识',
          appDEFieldId: 'principal_id',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'n_principal_id_eq',
        },
        {
          codeName: 'n_target_id_eq',
          logicName: '关联目标标识',
          appDEFieldId: 'target_id',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'n_target_id_eq',
        },
        {
          codeName: 'n_target_version_id_eq',
          logicName: '目标对象版本标识',
          appDEFieldId: 'target_version_id',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'n_target_version_id_eq',
        },
        {
          codeName: 'n_type_eq',
          logicName: '页面类型',
          appDEFieldId: 'type',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'n_type_eq',
        },
      ],
      sourceType: 'DE',
      type: 'DEFILTER',
      id: 'baseline_page_filter_dto',
    },
  ],
  appDEMethods: [
    {
      codeName: 'check_key',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'baseline_page_dto',
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
      requestPath: '/check_key',
      actionMode: 'CHECKKEY',
      actionTag: 'CheckKey',
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'CheckKey',
      id: 'check_key',
    },
    {
      codeName: 'create',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'baseline_page_dto',
        type: 'DTO',
        output: true,
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'baseline_page_dto',
        type: 'DTO',
        id: '返回对象',
      },
      requestMethod: 'POST',
      requestParamType: 'ENTITY',
      noServiceCodeName: true,
      actionMode: 'CREATE',
      actionTag: 'Create',
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'Create',
      id: 'create',
    },
    {
      codeName: 'get',
      methodType: 'DEACTION',
      appDEMethodInput: {
        keyAppDEFieldId: 'id',
        type: 'KEYFIELD',
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'baseline_page_dto',
        type: 'DTO',
        id: '返回对象',
      },
      requestField: 'ID',
      requestMethod: 'GET',
      requestParamType: 'FIELD',
      needResourceKey: true,
      noServiceCodeName: true,
      actionMode: 'READ',
      actionTag: 'Get',
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'Get',
      id: 'get',
    },
    {
      codeName: 'get_draft',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'baseline_page_dto',
        type: 'DTO',
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'baseline_page_dto',
        type: 'DTO',
        id: '返回对象',
      },
      requestMethod: 'GET',
      requestParamType: 'NONE',
      requestPath: '/get_draft',
      actionMode: 'GETDRAFT',
      actionTag: 'GetDraft',
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'GetDraft',
      id: 'get_draft',
    },
    {
      codeName: 'remove',
      methodType: 'DEACTION',
      appDEMethodInput: {
        keyAppDEFieldId: 'id',
        type: 'KEYFIELDS',
        id: '输入对象',
      },
      appDEMethodReturn: {
        type: 'VOID',
        id: '返回对象',
      },
      requestField: 'ID',
      requestMethod: 'DELETE',
      requestParamType: 'FIELD',
      needResourceKey: true,
      noServiceCodeName: true,
      actionMode: 'DELETE',
      actionTag: 'Remove',
      actionType: 'REMOTE',
      batchActionMode: 1,
      enableBatchAction: true,
      dataSetType: 'REMOTE',
      name: 'Remove',
      id: 'remove',
    },
    {
      codeName: 'save',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'baseline_page_dto',
        type: 'DTO',
        output: true,
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'baseline_page_dto',
        type: 'DTO',
        id: '返回对象',
      },
      requestMethod: 'POST',
      requestParamType: 'ENTITY',
      requestPath: '/save',
      actionMode: 'SAVE',
      actionTag: 'Save',
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'Save',
      id: 'save',
    },
    {
      codeName: 'shift_in_baseline',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'baseline_page_dto',
        type: 'DTO',
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'baseline_page_dto',
        type: 'DTO',
        id: '返回对象',
      },
      requestMethod: 'POST',
      requestParamType: 'ENTITY',
      requestPath: '/shift_in_baseline',
      actionMode: 'GETDRAFT',
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      id: 'shift_in_baseline',
    },
    {
      codeName: 'shift_out_baseline',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'baseline_page_dto',
        type: 'DTO',
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'baseline_page_dto',
        type: 'DTO',
        id: '返回对象',
      },
      requestMethod: 'POST',
      requestParamType: 'ENTITY',
      requestPath: '/shift_out_baseline',
      actionMode: 'GETDRAFT',
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      id: 'shift_out_baseline',
    },
    {
      codeName: 'update',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'baseline_page_dto',
        type: 'DTO',
        output: true,
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'baseline_page_dto',
        type: 'DTO',
        id: '返回对象',
      },
      requestMethod: 'PUT',
      requestParamType: 'ENTITY',
      needResourceKey: true,
      noServiceCodeName: true,
      actionMode: 'UPDATE',
      actionTag: 'Update',
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'Update',
      id: 'update',
    },
    {
      codeName: 'fetch_baseline_comparison',
      methodType: 'FETCH',
      appDEMethodInput: {
        appDEMethodDTOId: 'baseline_page_filter_dto',
        type: 'DTO',
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'baseline_page_dto',
        type: 'PAGE',
        id: '返回对象',
      },
      requestMethod: 'POST',
      requestParamType: 'ENTITY',
      requestPath: '/fetch_baseline_comparison',
      actionType: 'REMOTE',
      dataSetName: 'baseline_comparison',
      dataSetTag: 'baseline_comparison',
      dataSetType: 'REMOTE',
      id: 'fetch_baseline_comparison',
    },
    {
      codeName: 'fetch_default',
      methodType: 'FETCH',
      appDEMethodInput: {
        appDEMethodDTOId: 'baseline_page_filter_dto',
        type: 'DTO',
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'baseline_page_dto',
        type: 'PAGE',
        id: '返回对象',
      },
      requestMethod: 'POST',
      requestParamType: 'ENTITY',
      requestPath: '/fetch_default',
      actionType: 'REMOTE',
      dataSetName: 'DEFAULT',
      dataSetTag: 'Default',
      dataSetType: 'REMOTE',
      id: 'fetch_default',
    },
    {
      codeName: 'fetch_fill_version_data',
      methodType: 'FETCH',
      appDEMethodInput: {
        appDEMethodDTOId: 'baseline_page_filter_dto',
        type: 'DTO',
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'baseline_page_dto',
        type: 'PAGE',
        id: '返回对象',
      },
      requestMethod: 'POST',
      requestParamType: 'ENTITY',
      requestPath: '/fetch_fill_version_data',
      actionType: 'REMOTE',
      dataSetName: 'fill_version_data',
      dataSetTag: 'fill_version_data',
      dataSetType: 'REMOTE',
      id: 'fetch_fill_version_data',
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
  appDEUIActions: [
    {
      actionLevel: 100,
      actionTarget: 'NONE',
      caption: '基线规划页面',
      codeName: 'baseline_page',
      dataAccessAction: 'UPDATE',
      frontAppViewId: 'plmweb.article_page_baseline_mpick_up_view',
      fullCodeName: 'baseline_page_baseline_page',
      appDEMethodId: 'shift_in_baseline',
      deopprivId: 'update',
      navigateParams: [
        {
          key: 'baseline_id',
          value: 'baseline',
          id: 'baseline_id',
        },
      ],
      sysImage: {
        cssClass: 'fa fa-list-ol',
        glyph: 'xf0cb@FontAwesome',
      },
      refreshMode: 1,
      timeout: 60000,
      uiactionMode: 'BACKEND',
      uiactionTag: 'baseline_page',
      uiactionType: 'DEUIACTION',
      enableConfirm: true,
      reloadData: true,
      showBusyIndicator: true,
      noPrivDisplayMode: 2,
      appDataEntityId: 'plmweb.baseline_page',
      name: '基线规划页面',
      id: 'baseline_page@baseline_page',
    },
    {
      actionLevel: 100,
      actionTarget: 'MULTIKEY',
      caption: '移出',
      codeName: 'shift_out_baseline',
      confirmMsg: '确认此基线中移除？',
      dataAccessAction: 'UPDATE',
      fullCodeName: 'baseline_page_shift_out_baseline',
      appDEMethodId: 'shift_out_baseline',
      deopprivId: 'update',
      sysImage: {
        cssClass: 'fa fa-mail-reply',
        glyph: 'xf112@FontAwesome',
      },
      refreshMode: 1,
      successMsg: '移出成功',
      timeout: 60000,
      uiactionMode: 'BACKEND',
      uiactionTag: 'shift_out_baseline',
      uiactionType: 'DEUIACTION',
      enableConfirm: true,
      reloadData: true,
      showBusyIndicator: true,
      noPrivDisplayMode: 1,
      appDataEntityId: 'plmweb.baseline_page',
      name: '移出基线',
      id: 'shift_out_baseline@baseline_page',
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
  codeName: 'baseline_page',
  deapicodeName: 'baseline_page',
  deapicodeName2: 'baseline_pages',
  deapitag: 'BASELINE_PAGE',
  dataAccCtrlArch: 1,
  dataAccCtrlMode: 3,
  enableUIActions: 15,
  keyAppDEFieldId: 'id',
  lnlanguageRes: {
    lanResTag: 'DE.LNAME.BASELINE_PAGE',
  },
  logicName: '基线页面',
  majorAppDEFieldId: 'name',
  minorAppDERSs: [
    {
      actionRSMode: 1,
      codeName: 'baseline_pages',
      majorAppDataEntityId: 'plmweb.baseline',
      parentAppDEFieldId: 'principal_id',
      rsmode: 2,
      name: 'DERCUSTOM_BASELINE_PAGE_BASELINE',
      id: 'baseline_pages',
    },
  ],
  quickSearchAppDEFieldIds: ['name'],
  sysAPITag: 'ServiceAPI',
  unionKeyValueAppDEFieldIds: ['principal_id', 'target_id'],
  defaultMode: true,
  enableFilterActions: true,
  major: true,
  name: 'BASELINE_PAGE',
  id: 'plmweb.baseline_page',
  codeName2: 'baseline_pages',
  requestPaths: ['baselines/${baseline}/baseline_pages/${baseline_page}'],
};