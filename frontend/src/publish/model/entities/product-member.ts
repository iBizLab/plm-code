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
    {
      actype: 'AUTOCOMPLETE',
      codeName: 'Member_select',
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
            uiactionId: 'jump_to_member_set@product_member',
            tooltip: '跳转至成员设置',
            showCaption: true,
            showIcon: true,
            sysImage: {
              cssClass: 'fa fa-user-md',
              glyph: 'xf0f0@FontAwesome',
            },
            id: 'u4befff7',
          },
        ],
        uniqueTag: 'Product_member__Usr0311005787',
        name: '跳转至成员设置',
        id: 'usr0311005787',
      },
      pagingSize: 50,
      textAppDEFieldId: 'name',
      valueAppDEFieldId: 'user_id',
      id: 'member_select',
    },
  ],
  appDEFields: [
    {
      codeName: 'User_id',
      logicName: '登录名',
      stdDataType: 25,
      stringLength: 100,
      enableQuickSearch: true,
      name: 'USER_ID',
      id: 'user_id',
    },
    {
      codeName: 'Role_id',
      logicName: '角色',
      stdDataType: 25,
      stringLength: 60,
      name: 'ROLE_ID',
      id: 'role_id',
    },
    {
      codeName: 'Product_name',
      logicName: '产品名称',
      stdDataType: 25,
      stringLength: 200,
      name: 'PRODUCT_NAME',
      id: 'product_name',
    },
    {
      codeName: 'Product_identifier',
      logicName: '产品编号',
      stdDataType: 25,
      stringLength: 15,
      name: 'PRODUCT_IDENTIFIER',
      id: 'product_identifier',
    },
    {
      codeName: 'Id',
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
      codeName: 'Name',
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
      codeName: 'Update_time',
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
      codeName: 'Create_man',
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
      codeName: 'Update_man',
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
      codeName: 'Create_time',
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
      codeName: 'Product_id',
      logicName: '产品标识',
      stdDataType: 25,
      stringLength: 100,
      name: 'PRODUCT_ID',
      id: 'product_id',
    },
  ],
  appDEMethodDTOs: [
    {
      codeName: 'Product_memberDTO',
      appDEMethodDTOFields: [
        {
          codeName: 'User_id',
          logicName: '登录名',
          appDEFieldId: 'user_id',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'User_id',
          id: 'user_id',
        },
        {
          codeName: 'Role_id',
          logicName: '角色',
          appDEFieldId: 'role_id',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'Role_id',
          id: 'role_id',
        },
        {
          codeName: 'Product_name',
          logicName: '产品名称',
          appDEFieldId: 'product_name',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'Product_name',
          id: 'product_name',
        },
        {
          codeName: 'Product_identifier',
          logicName: '产品编号',
          appDEFieldId: 'product_identifier',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'Product_identifier',
          id: 'product_identifier',
        },
        {
          codeName: 'Create_man',
          logicName: '建立人',
          appDEFieldId: 'create_man',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          name: 'Create_man',
          id: 'create_man',
        },
        {
          codeName: 'Create_time',
          jsonFormat: 'yyyy-MM-dd HH:mm:ss',
          logicName: '建立时间',
          appDEFieldId: 'create_time',
          sourceType: 'DEFIELD',
          stdDataType: 5,
          type: 'SIMPLE',
          name: 'Create_time',
          id: 'create_time',
        },
        {
          codeName: 'Id',
          logicName: '标识',
          appDEFieldId: 'id',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          name: 'Id',
          id: 'id',
        },
        {
          codeName: 'Name',
          logicName: '姓名',
          appDEFieldId: 'name',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'Name',
          id: 'name',
        },
        {
          codeName: 'Product_id',
          logicName: '产品标识',
          appDEFieldId: 'product_id',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'Product_id',
          id: 'product_id',
        },
        {
          codeName: 'Update_man',
          logicName: '更新人',
          appDEFieldId: 'update_man',
          sourceType: 'DEFIELD',
          stdDataType: 25,
          type: 'SIMPLE',
          name: 'Update_man',
          id: 'update_man',
        },
        {
          codeName: 'Update_time',
          jsonFormat: 'yyyy-MM-dd HH:mm:ss',
          logicName: '更新时间',
          appDEFieldId: 'update_time',
          sourceType: 'DEFIELD',
          stdDataType: 5,
          type: 'SIMPLE',
          name: 'Update_time',
          id: 'update_time',
        },
      ],
      sourceType: 'DE',
      type: 'DEFAULT',
      name: 'Product_memberDTO',
      id: 'product_memberdto',
    },
    {
      codeName: 'Product_memberFilterDTO',
      appDEMethodDTOFields: [
        {
          codeName: 'N_ID_EQ',
          logicName: '标识',
          appDEFieldId: 'id',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'N_ID_EQ',
          id: 'n_id_eq',
        },
        {
          codeName: 'N_NAME_LIKE',
          logicName: '姓名',
          appDEFieldId: 'name',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'N_NAME_LIKE',
          id: 'n_name_like',
        },
        {
          codeName: 'N_PRODUCT_ID_EQ',
          logicName: '产品标识',
          appDEFieldId: 'product_id',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'N_PRODUCT_ID_EQ',
          id: 'n_product_id_eq',
        },
        {
          codeName: 'N_PRODUCT_NAME_EQ',
          logicName: '产品名称',
          appDEFieldId: 'product_name',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'N_PRODUCT_NAME_EQ',
          id: 'n_product_name_eq',
        },
        {
          codeName: 'N_PRODUCT_NAME_LIKE',
          logicName: '产品名称',
          appDEFieldId: 'product_name',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'N_PRODUCT_NAME_LIKE',
          id: 'n_product_name_like',
        },
        {
          codeName: 'N_ROLE_ID_EQ',
          logicName: '角色',
          appDEFieldId: 'role_id',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'N_ROLE_ID_EQ',
          id: 'n_role_id_eq',
        },
        {
          codeName: 'N_USER_ID_EQ',
          logicName: '登录名',
          appDEFieldId: 'user_id',
          sourceType: 'DEFSEARCHMODE',
          stdDataType: 25,
          type: 'SIMPLE',
          allowEmpty: true,
          name: 'N_USER_ID_EQ',
          id: 'n_user_id_eq',
        },
      ],
      sourceType: 'DE',
      type: 'DEFILTER',
      name: 'Product_memberFilterDTO',
      id: 'product_memberfilterdto',
    },
  ],
  appDEMethods: [
    {
      codeName: 'CheckKey',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'product_memberdto',
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
        appDEMethodDTOId: 'product_memberdto',
        type: 'DTO',
        output: true,
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'product_memberdto',
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
      codeName: 'Create_product_member',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'product_memberdto',
        type: 'DTO',
        output: true,
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'product_memberdto',
        type: 'DTO',
        id: '返回对象',
      },
      requestMethod: 'POST',
      requestParamType: 'ENTITY',
      requestPath: '/create_product_member',
      actionMode: 'CREATE',
      actionName: 'create_product_member',
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'Create_product_member',
      id: 'create_product_member',
    },
    {
      codeName: 'Get',
      methodType: 'DEACTION',
      appDEMethodInput: {
        keyAppDEFieldId: 'id',
        type: 'KEYFIELD',
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'product_memberdto',
        type: 'DTO',
        id: '返回对象',
      },
      requestField: 'ID',
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
        appDEMethodDTOId: 'product_memberdto',
        type: 'DTO',
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'product_memberdto',
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
        appDEMethodDTOId: 'product_memberdto',
        type: 'DTO',
        id: '输入对象',
      },
      appDEMethodReturn: {
        type: 'VOID',
        id: '返回对象',
      },
      requestMethod: 'POST',
      requestParamType: 'ENTITY',
      requestPath: '/save',
      needResourceKey: true,
      actionMode: 'UNKNOWN',
      actionType: 'REMOTE',
      dataSetType: 'REMOTE',
      name: 'Save',
      id: 'save',
    },
    {
      codeName: 'Update',
      methodType: 'DEACTION',
      appDEMethodInput: {
        appDEMethodDTOId: 'product_memberdto',
        type: 'DTO',
        output: true,
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'product_memberdto',
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
      codeName: 'FetchCur_product',
      methodType: 'FETCH',
      appDEMethodInput: {
        appDEMethodDTOId: 'product_memberfilterdto',
        type: 'DTO',
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'product_memberdto',
        type: 'PAGE',
        id: '返回对象',
      },
      requestMethod: 'POST',
      requestParamType: 'ENTITY',
      requestPath: '/fetchcur_product',
      actionType: 'REMOTE',
      addedqconditions: [
        {
          condOp: 'EQ',
          condValue: 'product_id',
          fieldName: 'PRODUCT_ID',
          vartypeId: 'DATACONTEXT',
          ignoreEmpty: true,
          condType: 'SINGLE',
          name: '(PRODUCT_ID) 等于(=) 数据上下文 product_id',
          id: '(product_id) 等于(=) 数据上下文 product_id',
        },
        {
          condOp: 'EQ',
          condValue: 'id',
          fieldName: 'PRODUCT_ID',
          vartypeId: 'DATACONTEXT',
          condType: 'SINGLE',
          name: '(PRODUCT_ID) 等于(=) 数据上下文 id',
          id: '(product_id) 等于(=) 数据上下文 id',
        },
      ],
      dataSetName: 'cur_product',
      dataSetTag: 'Cur_product',
      dataSetType: 'REMOTE',
      name: 'FetchCur_product',
      id: 'fetchcur_product',
    },
    {
      codeName: 'FetchDefault',
      methodType: 'FETCH',
      appDEMethodInput: {
        appDEMethodDTOId: 'product_memberfilterdto',
        type: 'DTO',
        id: '输入对象',
      },
      appDEMethodReturn: {
        appDEMethodDTOId: 'product_memberdto',
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
  appDEUIActions: [
    {
      actionLevel: 100,
      actionTarget: 'NONE',
      caption: '跳转至成员设置',
      codeName: 'jump_to_member_set',
      frontProcessType: 'OTHER',
      fullCodeName: 'Product_member_jump_to_member_set',
      sysImage: {
        cssClass: 'fa fa-user-md',
        glyph: 'xf0f0@FontAwesome',
      },
      scriptCode:
        'ibiz.openView.push(`/-/index/project=${context.project}/projectRedirectView/-/projectsetting_view/srfnavctx=%7B"project"%3A"${context.project}"%2C"srfdefaulttoroutedepth"%3A"3"%7D;srfnav=root%3Anormal%3Amember/project_membergrid_view_config/-`);',
      timeout: 60000,
      tooltip: '跳转至成员设置',
      uiactionMode: 'FRONT',
      uiactionTag: 'jump_to_member_set',
      uiactionType: 'DEUIACTION',
      uilogicAttachMode: 'REPLACE',
      showBusyIndicator: true,
      noPrivDisplayMode: 2,
      appDEUILogicId: 'jump_to_member_set',
      appDataEntityId: 'plmweb.product_member',
      name: '跳转至成员设置',
      id: 'jump_to_member_set@product_member',
    },
    {
      actionLevel: 100,
      actionTarget: 'SINGLEKEY',
      caption: '移除成员',
      codeName: 'remove_member',
      confirmMsg: '确认删除该成员？',
      fullCodeName: 'Product_member_remove_member',
      appDEMethodId: 'remove',
      refreshMode: 1,
      successMsg: '删除成功',
      timeout: 60000,
      uiactionMode: 'BACKEND',
      uiactionTag: 'remove_member',
      uiactionType: 'DEUIACTION',
      enableConfirm: true,
      reloadData: true,
      showBusyIndicator: true,
      noPrivDisplayMode: 2,
      appDataEntityId: 'plmweb.product_member',
      name: '移除成员',
      id: 'remove_member@product_member',
    },
  ],
  appDEUILogics: [
    {
      codeName: 'create_default_temp_members',
      defaultParamName: 'Default',
      logicName: '新建产品默认临时成员',
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
          codeName: 'END1',
          leftPos: 910,
          logicNodeType: 'END',
          topPos: 200,
          name: '结束',
          id: 'end1',
        },
        {
          code: "ibiz.hub.getApp(context.srfappid).deService.exec(\r\n    'plmweb.product_member',\r\n    'Create',\r\n    context,\r\n    uiLogic.user,\r\n);",
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
            {
              dstFieldName: 'library_id',
              dstDEUILogicParamId: 'user',
              paramAction: 'SETPARAMVALUE',
              srcFieldName: 'library',
              srcValueType: 'DATACONTEXT',
              id: '数据上下文[library] ==> user[library_id]',
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
      name: '新建产品默认临时成员',
      id: 'create_default_temp_members',
    },
    {
      codeName: 'create_product_member',
      defaultParamName: 'Default',
      logicName: '建立产品成员',
      deuilogicNodes: [
        {
          codeName: 'Begin',
          leftPos: 200,
          logicNodeType: 'BEGIN',
          deuilogicLinks: [
            {
              dstDEUILogicNodeId: 'rawjscode1',
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
          codeName: 'PREPAREJSPARAM1',
          leftPos: 160,
          logicNodeType: 'PREPAREJSPARAM',
          deuilogicLinks: [
            {
              dstDEUILogicNodeId: 'deaction1',
              srcDEUILogicNodeId: 'preparejsparam1',
              id: '连接名称',
            },
          ],
          deuilogicNodeParams: [
            {
              dstFieldName: 'product_id',
              dstDEUILogicParamId: 'temp_obj',
              paramAction: 'SETPARAMVALUE',
              srcFieldName: 'product',
              srcDEUILogicParamId: 'ctx',
              srcValueType: 'SRCDLPARAM',
              id: 'ctx[product] ==> temp_obj[product_id]',
            },
          ],
          topPos: 572,
          name: '准备参数',
          id: 'preparejsparam1',
        },
        {
          code: 'let selecteddata=uiLogic.view.ctx.controllersMap.get("user_pickupgridview_user").ctx.controllersMap.get("grid").state.selectedData;\r\nif (selecteddata.length > 0) {\r\n    uiLogic.temp_obj.selectdata = selecteddata;\r\n}',
          codeName: 'RAWJSCODE1',
          leftPos: 160,
          logicNodeType: 'RAWJSCODE',
          deuilogicLinks: [
            {
              dstDEUILogicNodeId: 'preparejsparam1',
              srcDEUILogicNodeId: 'rawjscode1',
              id: '连接名称',
            },
          ],
          topPos: 430,
          name: '获取选中数据',
          id: 'rawjscode1',
        },
        {
          dstAppDEActionId: 'create_product_member',
          dstAppDataEntityId: 'plmweb.product_member',
          codeName: 'DEACTION1',
          dstDEUILogicParamId: 'temp_obj',
          leftPos: 160,
          logicNodeType: 'DEACTION',
          deuilogicLinks: [
            {
              dstDEUILogicNodeId: 'viewctrlinvoke1',
              srcDEUILogicNodeId: 'deaction1',
              id: '连接名称',
            },
          ],
          topPos: 705,
          name: '生成产品成员',
          id: 'deaction1',
        },
        {
          invokeCtrlId: 'view',
          invokeMethod: 'closeView',
          invokeParamId: 'default',
          codeName: 'VIEWCTRLINVOKE1',
          leftPos: 160,
          logicNodeType: 'VIEWCTRLINVOKE',
          topPos: 843,
          name: '关闭选择视图',
          id: 'viewctrlinvoke1',
        },
      ],
      deuilogicParams: [
        {
          codeName: 'Default',
          default: true,
          entityParam: true,
          name: '传入变量',
          id: 'default',
        },
        {
          codeName: 'ctx',
          navContextParam: true,
          name: '应用上下文参数',
          id: 'ctx',
        },
        {
          codeName: 'view',
          activeViewParam: true,
          name: '当前视图',
          id: 'view',
        },
        {
          codeName: 'temp_obj',
          entityParam: true,
          name: '临时变量',
          id: 'temp_obj',
        },
      ],
      startDEUILogicNodeId: 'begin',
      name: '建立产品成员',
      id: 'create_product_member',
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
          code: "// 如果当前视图打开方式为普通模态，则先关闭模态再跳转\r\nif (view.modal && view.modal.mode === 'MODAL') {\r\n\tview.modal.ignoreDismissCheck = true\r\n\tview.closeView({ ok: true })\r\n}\r\nibiz.openView.push(`/-/index/product=${context.product}/productindex_view/srfnav=usrdrgroup1228809432/productdetails_setting_view/srfnav=root%3Anormal%3Amember/product_membergrid_view_config/-`);",
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
      ],
      deuilogicParams: [
        {
          codeName: 'project',
          entityParam: true,
          name: '项目标识',
          id: 'project',
        },
        {
          codeName: 'view',
          activeViewParam: true,
          name: '视图',
          id: 'view',
        },
        {
          codeName: 'lastReturn',
          lastReturnParam: true,
          name: '上一次返回参数',
          id: 'lastreturn',
        },
        {
          codeName: 'Default',
          default: true,
          entityParam: true,
          name: '传入变量',
          id: 'default',
        },
        {
          codeName: 'msg',
          entityParam: true,
          name: '消息确认标识',
          id: 'msg',
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
      mapDEName: 'PRODUCT',
      mapDEOPPrivName: 'UPDATE',
      name: 'CREATE',
      id: 'product__create',
    },
    {
      logicName: '建立',
      name: 'CREATE',
      id: 'create',
    },
    {
      logicName: '删除',
      mapDEName: 'PRODUCT',
      mapDEOPPrivName: 'DELETE',
      name: 'DELETE',
      id: 'product__delete',
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
      logicName: '读取',
      mapDEName: 'PRODUCT',
      mapDEOPPrivName: 'READ',
      name: 'READ',
      id: 'product__read',
    },
    {
      logicName: '更新',
      name: 'UPDATE',
      id: 'update',
    },
    {
      logicName: '更新',
      mapDEName: 'PRODUCT',
      mapDEOPPrivName: 'UPDATE',
      name: 'UPDATE',
      id: 'product__update',
    },
  ],
  codeName: 'Product_member',
  deapicodeName: 'product_member',
  deapicodeName2: 'product_members',
  deapitag: 'PRODUCT_MEMBER',
  dataAccCtrlArch: 1,
  dataAccCtrlMode: 3,
  enableUIActions: 15,
  keyAppDEFieldId: 'id',
  lnlanguageRes: {
    lanResTag: 'DE.LNAME.PRODUCT_MEMBER',
  },
  logicName: '产品成员',
  majorAppDEFieldId: 'name',
  minorAppDERSs: [
    {
      actionRSMode: 1,
      codeName: 'product_members',
      majorAppDataEntityId: 'plmweb.product',
      parentAppDEFieldId: 'product_id',
      rsmode: 2,
      name: 'DER1N_PRODUCT_MEMBER_PRODUCT_PRODUCT_ID',
      id: 'product_members',
    },
    {
      actionRSMode: 1,
      codeName: 'product_members',
      majorAppDataEntityId: 'plmweb.user',
      parentAppDEFieldId: 'user_id',
      rsmode: 2,
      name: 'DER1N_PRODUCT_MEMBER_USER_USER_ID',
      id: 'product_members',
    },
  ],
  quickSearchAppDEFieldIds: ['user_id', 'name'],
  sysAPITag: 'ServiceAPI',
  unionKeyValueAppDEFieldIds: ['product_id', 'user_id'],
  defaultMode: true,
  enableFilterActions: true,
  major: true,
  name: 'PRODUCT_MEMBER',
  id: 'plmweb.product_member',
  codeName2: 'Product_members',
  requestPaths: [
    'products/${product}/product_members/${product_member}',
    'users/${user}/product_members/${product_member}',
  ],
};