export default {
  codeListTag: 'extension__enable_action',
  codeListType: 'STATIC',
  codeName: 'extension__enable_action',
  emptyText: '未定义',
  appDataEntityId: 'plmweb.psdelogic',
  codeItems: [
    {
      codeName: 'projmgmt_work_item_create_after',
      text: '创建工作项',
      value: 'ProjMgmt.work_item.create:AFTER',
      id: 'projmgmt_work_item_create_after',
    },
    {
      codeName: 'projmgmt_project_update_after',
      text: '更新项目信息',
      value: 'ProjMgmt.project.update:AFTER',
      id: 'projmgmt_project_update_after',
    },
    {
      codeName: 'testmgmt_run_save_run_history_after',
      text: '更新执行用例',
      value: 'TestMgmt.run.save_run_history.AFTER',
      id: 'testmgmt_run_save_run_history_after',
    },
  ],
  enableCache: true,
  name: '可供选择的触发器',
  id: 'plmweb.extension__enable_action',
};
