export default {
  appDEACModes: [
    {
      actype: 'AUTOCOMPLETE',
      codeName: 'member_select',
      logicName: 'member_select',
      deacmodeDataItems: [
        {
          appDEFieldId: 'user_id',
          dataType: 25,
          id: 'value',
        },
        {
          appDEFieldId: 'name',
          dataType: 25,
          id: 'text',
        },
      ],
      deuiactionGroup: {
        uiactionGroupDetails: [
          {
            actionLevel: 100,
            afterItemType: 'NONE',
            beforeItemType: 'NONE',
            caption: '跳转至成员设置',
            detailType: 'DEUIACTION',
            uiactionId: 'jump_to_member_set@library_member',
            tooltip: '跳转至成员设置',
            showCaption: true,
            showIcon: true,
            sysImage: {
              cssClass: 'fa fa-user-md',
              glyph: 'xf0f0@FontAwesome',
            },
            id: 'u23c0102',
          },
        ],
        appDataEntityId: 'plmweb.library_member',
        uniqueTag: 'library_member__Usr0311619181',
        name: '跳转至成员设置',
        id: 'usr0311619181',
      },
      pagingSize: 50,
      textAppDEFieldId: 'name',
      valueAppDEFieldId: 'user_id',
      id: 'member_select',
    },
  ],
  appDEFields: [
    {
      codeName: 'user_id',
      logicName: '登录名',
      stdDataType: 25,
      stringLength: 100,
      enableQuickSearch: true,
      name: 'USER_ID',
      id: 'user_id',
    },
    {
      codeName: 'role_id',
      logicName: '角色',
      stdDataType: 25,
      stringLength: 60,
      name: 'ROLE_ID',
      id: 'role_id',
    },
    {
      codeName: 'library_name',
      logicName: '测试库名称',
      stdDataType: 25,
      stringLength: 200,
      name: 'LIBRARY_NAME',
      id: 'library_name',
    },
    {
      codeName: 'library_identifier',
      logicName: '测试库编号',
      stdDataType: 25,
      stringLength: 15,
      name: 'LIBRARY_IDENTIFIER',
      id: 'library_identifier',
    },
    {
      codeName: 'title',
      logicName: '职位',
      stdDataType: 25,
      stringLength: 100,
      name: 'TITLE',
      id: 'title',
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
      logicName: '姓名',
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
    {
      codeName: 'library_id',
      logicName: '测试库标识',
      stdDataType: 25,
      stringLength: 100,
      name: 'LIBRARY_ID',
      id: 'library_id',
    },
  ],
  appDELogics: [
    {
      codeName: 'nothing',
      defaultParamName: 'Default',
      logicName: '无操作',
      logicSubType: 'NONE',
      delogicNodes: [
        {
          codeName: 'Begin',
          leftPos: 200,
          logicNodeType: 'BEGIN',
          topPos: 200,
          parallelOutput: true,
          name: '开始',
          id: 'begin',
        },
      ],
      delogicParams: [
        {
          codeName: 'Default',
          default: true,
          entityParam: true,
          paramAppDataEntityId: 'plmweb.library_member',
          name: '传入变量',
          id: 'default',
        },
      ],
      startDELogicNodeId: 'begin',
      valid: true,
      name: '无操作',
      id: 'nothing',
    },
  ],
  appDEMethodDTOs: [
    {
      codeName: 'library_member_dto',
      appDEMethodDTOFields: [
        {
          codeName: 'user_id',
          logicName: '登录名',
          appDEFieldId: 'user_id',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'user_id',
        },
        {
          codeName: 'role_id',
          logicName: '角色',
          appDEFieldId: 'role_id',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'role_id',
        },
        {
          codeName: 'library_name',
          logicName: '测试库名称',
          appDEFieldId: 'library_name',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'library_name',
        },
        {
          codeName: 'library_identifier',
          logicName: '测试库编号',
          appDEFieldId: 'library_identifier',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'library_identifier',
        },
        {
          codeName: 'title',
          logicName: '职位',
          appDEFieldId: 'title',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'title',
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
          codeName: 'library_id',
          logicName: '测试库标识',
          appDEFieldId: 'library_id',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'library_id',
        },
        {
          codeName: 'name',
          logicName: '姓名',
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
      id: 'library_member_dto',
    },
    {
      codeName: 'library_member_filter_dto',
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
          codeName: 'n_library_id_eq',
          logicName: '测试库标识',
          appDEFieldId: 'library_id',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'n_library_id_eq',
        },
        {
          codeName: 'n_library_name_eq',
          logicName: '测试库名称',
          appDEFieldId: 'library_name',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'n_library_name_eq',
        },
        {
          codeName: 'n_library_name_like',
          logicName: '测试库名称',
          appDEFieldId: 'library_name',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'n_library_name_like',
        },
        {
          codeName: 'n_name_like',
          logicName: '姓名',
          appDEFieldId: 'name',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'n_name_like',
        },
        {
          codeName: 'n_role_id_eq',
          logicName: '角色',
          appDEFieldId: 'role_id',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'n_role_id_eq',
        },
        {
          codeName: 'n_user_id_eq',
          logicName: '登录名',
          appDEFieldId: 'user_id',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          id: 'n_user_id_eq',
        },
      ],
      sourceType: 'DE',
      type: 'DEFILTER',
      id: 'library_member_filter_dto',
    },
  ],
  appDEMethods: [
    {
      codeName: 'change_position',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'library_member_dto',
        type: 'DTO',
        id: '输入对象',
      },
      appDEMethodReturn: {
        type: 'VOID',
        id: '返回对象',
      },
      requestMethod: 'POST',
      requestParamType: 'ENTITY',
      requestPath: '/change_position',
      needResourceKey: true,
      actionMode: 'CUSTOM',
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      id: 'change_position',
    },
    {
      codeName: 'change_role',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'library_member_dto',
        type: 'DTO',
        id: '输入对象',
      },
      appDEMethodReturn: {
        type: 'VOID',
        id: '返回对象',
      },
      requestMethod: 'POST',
      requestParamType: 'ENTITY',
      requestPath: '/change_role',
      needResourceKey: true,
      actionMode: 'CUSTOM',
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      id: 'change_role',
    },
    {
      codeName: 'check_key',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'library_member_dto',
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
        appDEMethodDTOId: 'library_member_dto',
        type: 'DTO',
        output: true,
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'library_member_dto',
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
      codeName: 'create_library_member',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'library_member_dto',
        type: 'DTO',
        output: true,
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'library_member_dto',
        type: 'DTO',
        id: '返回对象',
      },
      requestMethod: 'POST',
      requestParamType: 'ENTITY',
      requestPath: '/create_library_member',
      actionMode: 'CREATE',
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      id: 'create_library_member',
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
        appDEMethodDTOId: 'library_member_dto',
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
        appDEMethodDTOId: 'library_member_dto',
        type: 'DTO',
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'library_member_dto',
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
      codeName: 'nothing',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'library_member_dto',
        type: 'DTO',
        name: 'NothingInput',
        id: 'nothinginput',
      },
      appDEMethodReturn: {
        type: 'VOID',
        name: 'NothingResult',
        id: 'nothingresult',
      },
      actionMode: 'CUSTOM',
      actionType: 'DELOGIC',
      appDELogicId: 'nothing',
      dataSetType: 'REMOTE',
      id: 'nothing',
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
        appDEMethodDTOId: 'library_member_dto',
        type: 'DTO',
        output: true,
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'library_member_dto',
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
      codeName: 'update',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'library_member_dto',
        type: 'DTO',
        output: true,
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'library_member_dto',
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
      codeName: 'fetch_cur_library_member',
      methodType: 'FETCH',
      appDEMethodInput: {
        appDEMethodDTOId: 'library_member_filter_dto',
        type: 'DTO',
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'library_member_dto',
        type: 'PAGE',
        id: '返回对象',
      },
      requestMethod: 'POST',
      requestParamType: 'ENTITY',
      requestPath: '/fetch_cur_library_member',
      actionType: 'REMOTE',
      addedqconditions: [
        {
          condOp: 'EQ',
          condValue: 'library_id',
          fieldName: 'LIBRARY_ID',
          vartypeId: 'DATACONTEXT',
          ignoreEmpty: true,
          condType: 'SINGLE',
          name: '(LIBRARY_ID) 等于(=) 数据上下文 library_id',
          id: '(library_id) 等于(=) 数据上下文 library_id',
        },
        {
          condOp: 'EQ',
          condValue: 'id',
          fieldName: 'LIBRARY_ID',
          vartypeId: 'DATACONTEXT',
          condType: 'SINGLE',
          name: '(LIBRARY_ID) 等于(=) 数据上下文 id',
          id: '(library_id) 等于(=) 数据上下文 id',
        },
      ],
      dataSetName: 'cur_library_member',
      dataSetTag: 'cur_library_member',
      dataSetType: 'REMOTE',
      id: 'fetch_cur_library_member',
    },
    {
      codeName: 'fetch_default',
      methodType: 'FETCH',
      appDEMethodInput: {
        appDEMethodDTOId: 'library_member_filter_dto',
        type: 'DTO',
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'library_member_dto',
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
      codeName: 'fetch_mob_cur_member',
      methodType: 'FETCH',
      appDEMethodInput: {
        appDEMethodDTOId: 'library_member_filter_dto',
        type: 'DTO',
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'library_member_dto',
        type: 'PAGE',
        id: '返回对象',
      },
      requestMethod: 'POST',
      requestParamType: 'ENTITY',
      requestPath: '/fetch_mob_cur_member',
      actionType: 'REMOTE',
      dataSetName: 'mob_cur_member',
      dataSetTag: 'mob_cur_member',
      dataSetType: 'REMOTE',
      id: 'fetch_mob_cur_member',
    },
    {
      codeName: 'fetch_no_attention',
      methodType: 'FETCH',
      appDEMethodInput: {
        appDEMethodDTOId: 'library_member_filter_dto',
        type: 'DTO',
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'library_member_dto',
        type: 'PAGE',
        id: '返回对象',
      },
      requestMethod: 'POST',
      requestParamType: 'ENTITY',
      requestPath: '/fetch_no_attention',
      actionType: 'REMOTE',
      dataSetName: 'no_attention',
      dataSetTag: 'no_attention',
      dataSetType: 'REMOTE',
      id: 'fetch_no_attention',
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
      actionTarget: 'MULTIKEY',
      caption: '变更职位',
      codeName: 'change_position',
      dataAccessAction: 'UPDATE',
      frontAppViewId: 'plmweb.library_member_choose_position_option_view',
      fullCodeName: 'library_member_change_position',
      appDEMethodId: 'change_position',
      deopprivId: 'library__update',
      sysImage: {
        cssClass: 'fa fa-users',
        glyph: 'xf0c0@FontAwesome',
      },
      refreshMode: 1,
      successMsg: '职位变更成功',
      timeout: 60000,
      tooltip: '变更选中成员职位',
      uiactionMode: 'BACKEND',
      uiactionTag: 'change_position',
      uiactionType: 'DEUIACTION',
      enableConfirm: true,
      reloadData: true,
      showBusyIndicator: true,
      noPrivDisplayMode: 1,
      appDataEntityId: 'plmweb.library_member',
      name: '变更职位',
      id: 'change_position@library_member',
    },
    {
      actionLevel: 100,
      actionTarget: 'SINGLEKEY',
      caption: '删除成员',
      codeName: 'delete_member',
      confirmMsg: '确认删除该成员？',
      fullCodeName: 'library_member_delete_member',
      appDEMethodId: 'remove',
      refreshMode: 1,
      successMsg: '删除成功',
      timeout: 60000,
      uiactionMode: 'BACKEND',
      uiactionTag: 'delete_member',
      uiactionType: 'DEUIACTION',
      enableConfirm: true,
      reloadData: true,
      showBusyIndicator: true,
      noPrivDisplayMode: 2,
      appDataEntityId: 'plmweb.library_member',
      name: '删除成员',
      id: 'delete_member@library_member',
    },
    {
      actionLevel: 100,
      actionTarget: 'NONE',
      caption: '跳转至成员设置',
      codeName: 'jump_to_member_set',
      frontProcessType: 'OTHER',
      fullCodeName: 'library_member_jump_to_member_set',
      sysImage: {
        cssClass: 'fa fa-user-md',
        glyph: 'xf0f0@FontAwesome',
      },
      scriptCode:
        'ibiz.openView.push(`/-/index/project=${context.project}/projectRedirectView/-/project_setting_view/srfnavctx=%7B"project"%3A"${context.project}"%2C"srfdefaulttoroutedepth"%3A"3"%7D;srfnav=root%3Anormal%3Amember/project_member_config_grid_view/-`);',
      tooltip: '跳转至成员设置',
      uiactionMode: 'FRONT',
      uiactionTag: 'jump_to_member_set',
      uiactionType: 'DEUIACTION',
      uilogicAttachMode: 'REPLACE',
      showBusyIndicator: true,
      noPrivDisplayMode: 2,
      appDEUILogicId: 'jump_to_member_set',
      appDataEntityId: 'plmweb.library_member',
      name: '跳转至成员设置',
      id: 'jump_to_member_set@library_member',
    },
    {
      actionLevel: 100,
      actionTarget: 'MULTIKEY',
      caption: '设置角色',
      codeName: 'setting_role',
      dataAccessAction: 'UPDATE',
      frontAppViewId: 'plmweb.library_member_role_edit_view',
      frontProcessType: 'WIZARD',
      fullCodeName: 'library_member_setting_role',
      appDEMethodId: 'change_role',
      deopprivId: 'update',
      sysImage: {
        cssClass: 'fa fa-sun-o',
        glyph: 'xf185@FontAwesome',
      },
      refreshMode: 1,
      successMsg: '变更角色成功',
      timeout: 60000,
      tooltip: '设置角色',
      uiactionMode: 'BACKEND',
      uiactionTag: 'setting_role',
      uiactionType: 'DEUIACTION',
      enableConfirm: true,
      reloadData: true,
      showBusyIndicator: true,
      noPrivDisplayMode: 1,
      appDataEntityId: 'plmweb.library_member',
      name: '设置角色',
      id: 'setting_role@library_member',
    },
  ],
  appDEUILogics: [
    {
      codeName: 'create_default_temp_members',
      defaultParamName: 'Default',
      logicName: '新建测试库默认临时成员',
      deuilogicNodes: [
        {
          codeName: 'Begin',
          leftPos: 200,
          logicNodeType: 'BEGIN',
          deuilogicLinks: [
            {
              dstDEUILogicNodeId: 'preparejsparam1',
              srcDEUILogicNodeId: 'begin',
              id: '连接名称',
            },
          ],
          topPos: 200,
          parallelOutput: true,
          name: '开始',
          id: 'begin',
        },
        {
          code: "ibiz.hub.getApp(context.srfappid).deService.exec(\r\n    'plmweb.library_member',\r\n    'Create',\r\n    context,\r\n    uiLogic.user,\r\n);",
          codeName: 'RAWJSCODE1',
          leftPos: 649,
          logicNodeType: 'RAWJSCODE',
          deuilogicLinks: [
            {
              dstDEUILogicNodeId: 'end1',
              srcDEUILogicNodeId: 'rawjscode1',
              id: '连接名称',
            },
          ],
          topPos: 208,
          name: '创建临时数据',
          id: 'rawjscode1',
        },
        {
          codeName: 'END1',
          leftPos: 910,
          logicNodeType: 'END',
          topPos: 200,
          name: '结束',
          id: 'end1',
        },
        {
          codeName: 'PREPAREJSPARAM1',
          leftPos: 392,
          logicNodeType: 'PREPAREJSPARAM',
          deuilogicLinks: [
            {
              dstDEUILogicNodeId: 'rawjscode1',
              srcDEUILogicNodeId: 'preparejsparam1',
              id: '连接名称',
            },
          ],
          deuilogicNodeParams: [
            {
              dstFieldName: 'name',
              dstDEUILogicParamId: 'user',
              paramAction: 'SETPARAMVALUE',
              srcFieldName: 'srfusername',
              srcValueType: 'DATACONTEXT',
              id: '数据上下文[srfusername] ==> user[name]',
            },
            {
              dstFieldName: 'role_id',
              dstDEUILogicParamId: 'user',
              paramAction: 'SETPARAMVALUE',
              srcValue: 'admin',
              srcValueType: 'SRCVALUE',
              id: '直接值[admin] ==> user[role_id]',
            },
            {
              dstFieldName: 'user_id',
              dstDEUILogicParamId: 'user',
              paramAction: 'SETPARAMVALUE',
              srcFieldName: 'srfuserid',
              srcValueType: 'DATACONTEXT',
              id: '数据上下文[srfuserid] ==> user[user_id]',
            },
          ],
          topPos: 208,
          name: '获取当前用户数据',
          id: 'preparejsparam1',
        },
      ],
      deuilogicParams: [
        {
          codeName: 'user',
          entityParam: true,
          name: '当前人员',
          id: 'user',
        },
        {
          codeName: 'Default',
          default: true,
          entityParam: true,
          name: '传入变量',
          id: 'default',
        },
      ],
      startDEUILogicNodeId: 'begin',
      name: '新建测试库默认临时成员',
      id: 'create_default_temp_members',
    },
    {
      codeName: 'jump_to_member_set',
      defaultParamName: 'Default',
      logicName: '跳转至成员设置',
      deuilogicNodes: [
        {
          codeName: 'Begin',
          leftPos: -90,
          logicNodeType: 'BEGIN',
          deuilogicLinks: [
            {
              dstDEUILogicNodeId: 'preparejsparam1',
              srcDEUILogicNodeId: 'begin',
              id: '连接名称',
            },
          ],
          topPos: 200,
          parallelOutput: true,
          name: '开始',
          id: 'begin',
        },
        {
          codeName: 'END1',
          leftPos: 1169,
          logicNodeType: 'END',
          topPos: 200,
          name: '结束',
          id: 'end1',
        },
        {
          codeName: 'PREPAREJSPARAM1',
          leftPos: 74,
          logicNodeType: 'PREPAREJSPARAM',
          deuilogicLinks: [
            {
              dstDEUILogicNodeId: 'msgbox1',
              srcDEUILogicNodeId: 'preparejsparam1',
              id: '连接名称',
            },
          ],
          deuilogicNodeParams: [
            {
              dstFieldName: 'ok',
              dstDEUILogicParamId: 'msg',
              paramAction: 'SETPARAMVALUE',
              srcValue: 'ok',
              srcValueType: 'SRCVALUE',
              id: '直接值[ok] ==> msg[ok]',
            },
          ],
          topPos: 208,
          name: '设置确认信息',
          id: 'preparejsparam1',
        },
        {
          code: "// 如果当前视图打开方式为普通模态，则先关闭模态再跳转\r\nif (view.modal && view.modal.mode === 'MODAL') {\r\n\tview.modal.ignoreDismissCheck = true\r\n\tview.closeView({ ok: true })\r\n}\r\nibiz.openView.push(`/-/index/library=${context.library}/library_index_view/srfnav=usrdrgroup1227882118/library_details_setting_tree_exp_view/srfnav=root%3Anormal%3Amember/library_member_config_grid_view/-`);",
          codeName: 'RAWJSCODE1',
          leftPos: 699,
          logicNodeType: 'RAWJSCODE',
          deuilogicLinks: [
            {
              dstDEUILogicNodeId: 'end1',
              srcDEUILogicNodeId: 'rawjscode1',
              id: '连接名称',
            },
          ],
          topPos: 208,
          name: '设置路由',
          id: 'rawjscode1',
        },
        {
          buttonsType: 'OKCANCEL',
          message: '是否要跳转至成员设置',
          msgBoxType: 'QUESTION',
          codeName: 'MSGBOX1',
          leftPos: 355,
          logicNodeType: 'MSGBOX',
          deuilogicLinks: [
            {
              dstDEUILogicNodeId: 'rawjscode1',
              deuilogicLinkGroupCond: {
                groupOP: 'AND',
                deuilogicLinkConds: [
                  {
                    condOP: 'EQ',
                    dstLogicParamId: 'lastreturn',
                    paramType: 'SRCENTITYFIELD',
                    paramValue: 'ok',
                    srcLogicParamId: 'msg',
                    value: 'ok',
                    logicType: 'SINGLE',
                    name: 'lastReturn 等于(=) ok',
                    id: 'lastreturn 等于(=) ok',
                  },
                ],
                logicType: 'GROUP',
              },
              srcDEUILogicNodeId: 'msgbox1',
              id: '连接名称',
            },
          ],
          topPos: 208,
          name: '操作提示',
          id: 'msgbox1',
        },
      ],
      deuilogicParams: [
        {
          codeName: 'msg',
          entityParam: true,
          name: '消息确认标识',
          id: 'msg',
        },
        {
          codeName: 'lastReturn',
          lastReturnParam: true,
          name: '上一次返回参数',
          id: 'lastreturn',
        },
        {
          codeName: 'project',
          entityParam: true,
          name: '项目标识',
          id: 'project',
        },
        {
          codeName: 'Default',
          default: true,
          entityParam: true,
          name: '传入变量',
          id: 'default',
        },
        {
          codeName: 'view',
          activeViewParam: true,
          name: '视图',
          id: 'view',
        },
      ],
      startDEUILogicNodeId: 'begin',
      name: '跳转至成员设置',
      id: 'jump_to_member_set',
    },
  ],
  deopprivs: [
    {
      logicName: '建立',
      name: 'CREATE',
      id: 'create',
    },
    {
      logicName: '建立',
      mapDEName: 'LIBRARY',
      mapDEOPPrivName: 'UPDATE',
      name: 'CREATE',
      id: 'library__create',
    },
    {
      logicName: '删除',
      mapDEName: 'LIBRARY',
      mapDEOPPrivName: 'DELETE',
      name: 'DELETE',
      id: 'library__delete',
    },
    {
      logicName: '删除',
      name: 'DELETE',
      id: 'delete',
    },
    {
      logicName: '读取',
      mapDEName: 'LIBRARY',
      mapDEOPPrivName: 'READ',
      name: 'READ',
      id: 'library__read',
    },
    {
      logicName: '读取',
      name: 'READ',
      id: 'read',
    },
    {
      logicName: '更新',
      mapDEName: 'LIBRARY',
      mapDEOPPrivName: 'UPDATE',
      name: 'UPDATE',
      id: 'library__update',
    },
    {
      logicName: '更新',
      name: 'UPDATE',
      id: 'update',
    },
  ],
  codeName: 'library_member',
  deapicodeName: 'library_member',
  deapicodeName2: 'library_members',
  deapitag: 'LIBRARY_MEMBER',
  dataAccCtrlArch: 1,
  dataAccCtrlMode: 3,
  enableUIActions: 15,
  keyAppDEFieldId: 'id',
  lnlanguageRes: {
    lanResTag: 'DE.LNAME.LIBRARY_MEMBER',
  },
  logicName: '测试库成员',
  majorAppDEFieldId: 'name',
  minorAppDERSs: [
    {
      actionRSMode: 1,
      codeName: 'library_members',
      majorAppDataEntityId: 'plmweb.library',
      parentAppDEFieldId: 'library_id',
      rsmode: 2,
      name: 'DER1N_LIBRARY_MEMBER_LIBRARY_LIBRARY_ID',
      id: 'library_members',
    },
    {
      actionRSMode: 1,
      codeName: 'library_members',
      majorAppDataEntityId: 'plmweb.user',
      parentAppDEFieldId: 'user_id',
      rsmode: 2,
      name: 'DER1N_LIBRARY_MEMBER_USER_USER_ID',
      id: 'library_members',
    },
  ],
  quickSearchAppDEFieldIds: ['user_id', 'name'],
  sysAPITag: 'ServiceAPI',
  unionKeyValueAppDEFieldIds: ['library_id', 'user_id'],
  defaultMode: true,
  enableFilterActions: true,
  major: true,
  name: 'LIBRARY_MEMBER',
  id: 'plmweb.library_member',
  codeName2: 'library_members',
  requestPaths: [
    'libraries/${library}/library_members/${library_member}',
    'users/${user}/library_members/${library_member}',
  ],
};
