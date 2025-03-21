export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  deviewCodeName: 'setting_view',
  deviewId: '758c9178cd52e82d99d351af67055044',
  accUserMode: 2,
  caption: '项目配置',
  codeName: 'project_setting_view',
  appDataEntityId: 'plmweb.project',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'EditView2',
      id: 'engine',
    },
  ],
  controls: [
    {
      createControlAction: {
        appDEMethodId: 'create',
        appDataEntityId: 'plmweb.project',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.project',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'get_draft',
        appDataEntityId: 'plmweb.project',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.project',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.project',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.project',
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
      enableItemPrivilege: true,
      showBusyIndicator: true,
      codeName: 'overview',
      controlType: 'FORM',
      logicName: '项目概览_表单',
      appDataEntityId: 'plmweb.project',
      controlParam: {
        id: 'form',
      },
      modelId: '95ec38e6b1053586f6b5a0284e3c46d4',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.project.overview',
    },
    {
      dedrbarGroups: [
        {
          caption: '通用',
          name: '通用',
          id: 'usrdrgroup0319559229',
        },
        {
          caption: '流程',
          name: '流程',
          id: 'usrdrgroup0319892622',
        },
        {
          caption: '设置',
          name: '设置',
          id: 'usrdrgroup0319482876',
        },
      ],
      showTitle: true,
      dataRelationTag: 'setting_view_dr',
      editItemCaption: '项目',
      dedrctrlItems: [
        {
          dedrbarGroupId: 'usrdrgroup0319559229',
          caption: '项目成员',
          appViewId: 'plmweb.project_member_config_grid_view',
          id: 'member',
        },
        {
          dedrbarGroupId: 'usrdrgroup0319559229',
          caption: '回收站',
          dataAccessAction: 'UPDATE',
          enableMode: 'DEOPPRIV',
          appViewId: 'plmweb.work_item_recycle_bin_grid_view',
          id: 'recycle',
        },
        {
          dedrbarGroupId: 'usrdrgroup0319892622',
          caption: '工作项配置',
          dataAccessAction: 'UPDATE',
          enableMode: 'DEOPPRIV',
          appViewId: 'plmweb.work_item_type_setting_view_scrum',
          navigateParams: [
            {
              key: 'project_id',
              value: 'project',
              id: 'project_id',
            },
          ],
          id: 'workitem',
        },
        {
          dedrbarGroupId: 'usrdrgroup0319892622',
          caption: '项目组件',
          dataAccessAction: 'UPDATE',
          enableMode: 'DEOPPRIV',
          appViewId: 'plmweb.addon_project_setting_grid_view',
          navigateParams: [
            {
              key: 'n_owner_id_eq',
              value: 'project',
              id: 'n_owner_id_eq',
            },
            {
              key: 'n_owner_type_eq',
              value: 'project',
              rawValue: true,
              id: 'n_owner_type_eq',
            },
          ],
          id: 'addon',
        },
        {
          dedrbarGroupId: 'usrdrgroup0319482876',
          caption: '基本信息',
          dataAccessAction: 'UPDATE',
          enableMode: 'DEOPPRIV',
          appViewId: 'plmweb.project_base_information_edit_view',
          id: 'base',
        },
        {
          dedrbarGroupId: 'usrdrgroup0319892622',
          caption: '项目属性',
          dataAccessAction: 'UPDATE',
          enableMode: 'DEOPPRIV',
          appViewId: 'plmweb.psde_field_data_extend_grid_view',
          navigateContexts: [
            {
              key: 'PSDATAENTITY',
              value: '${project}@ProjMgmt.project',
              name: 'PSDATAENTITY',
              id: 'psdataentity',
            },
            {
              key: 'PSDENAME',
              value: 'PROJECT',
              rawValue: true,
              name: 'PSDENAME',
              id: 'psdename',
            },
          ],
          id: 'project_field',
        },
        {
          dedrbarGroupId: 'usrdrgroup0319482876',
          caption: '高级设置',
          dataAccessAction: 'UPDATE',
          enableMode: 'DEOPPRIV',
          appViewId: 'plmweb.project_advanced_setting_edit_view',
          id: 'adv',
        },
        {
          dedrbarGroupId: 'usrdrgroup0319892622',
          caption: '工作项属性',
          dataAccessAction: 'UPDATE',
          enableMode: 'DEOPPRIV',
          appViewId: 'plmweb.psde_field_work_item_extend_transmit_grid_view',
          navigateContexts: [
            {
              key: 'PSDATAENTITY',
              value: 'FIELD__PROJECT_ID__${project}@ProjMgmt.work_item',
              name: 'PSDATAENTITY',
              id: 'psdataentity',
            },
            {
              key: 'PSDENAME',
              value: 'WORK_ITEM',
              rawValue: true,
              name: 'PSDENAME',
              id: 'psdename',
            },
          ],
          id: 'work_item_field',
        },
      ],
      uniqueTag: 'project_setting_view__drbar',
      hideEditItem: true,
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'setting_view_dr',
      controlType: 'DRBAR',
      appDataEntityId: 'plmweb.project',
      controlParam: {
        ctrlParams: {
          SINGLEITEMGROUP: 'true',
        },
        id: 'drbar',
      },
      modelId: '2ba93ef61c04aec835beda7ea33ca140',
      modelType: 'PSDEDRBAR',
      name: 'drbar',
      id: 'setting_view_dr',
    },
    {
      codeName: 'setting_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.project',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'setting_view_datainfobar',
    },
    {
      caption: '项目配置',
      codeName: 'setting_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.project',
      controlParam: {},
      name: 'captionbar',
      id: 'setting_view_captionbar',
    },
  ],
  sysCss: {
    cssName: 'editview2-menu',
  },
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEEDITVIEW2',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.project',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '项目配置',
  viewStyle: 'DEFAULT',
  viewType: 'DEEDITVIEW2',
  enableDP: true,
  showCaptionBar: false,
  modelId: 'bb40a3c01e5882bee31e78ccd9b131ef',
  modelType: 'PSAPPDEVIEW',
  name: 'project_setting_view',
  id: 'plmweb.project_setting_view',
};
