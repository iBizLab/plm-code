export default {
  codeListTag: 'extension__notify_event',
  codeListType: 'STATIC',
  codeName: 'extension__notify_event',
  emptyText: '未定义',
  appDataEntityId: 'plmweb.psdenotify',
  codeItems: [
    {
      codeName: 'projmgmt_work_item_create_after',
      text: '创建工作项',
      value: 'ProjMgmt.work_item.create:AFTER',
      id: 'projmgmt_work_item_create_after',
    },
    {
      codeName: 'projmgmt_work_item_delete_after',
      text: '删除工作项',
      value: 'ProjMgmt.work_item.delete:AFTER',
      id: 'projmgmt_work_item_delete_after',
    },
    {
      codeName: 'projmgmt_work_item_archive_after',
      text: '归档工作项',
      value: 'ProjMgmt.work_item.archive:AFTER',
      id: 'projmgmt_work_item_archive_after',
    },
  ],
  enableCache: true,
  name: '监听通知事件',
  id: 'plmweb.extension__notify_event',
};
