export default {
  codeListTag: 'extension__Notify_event',
  codeListType: 'STATIC',
  codeName: 'extension__Notify_event',
  emptyText: '未定义',
  appDataEntityId: 'plmweb.psdenotify',
  codeItems: [
    {
      codeName: 'Projmgmt_work_item_create_after',
      text: '创建工作项',
      value: 'ProjMgmt.work_item.create:AFTER',
      id: 'projmgmt_work_item_create_after',
    },
    {
      codeName: 'Projmgmt_project_update_after',
      text: '更新项目信息',
      value: 'ProjMgmt.project.update:AFTER',
      id: 'projmgmt_project_update_after',
    },
  ],
  enableCache: true,
  name: '监听通知事件',
  id: 'plmweb.extension__notify_event',
};
