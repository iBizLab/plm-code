export default {
  codeListTag: 'ProjMgmt__notify_field',
  codeListType: 'STATIC',
  codeName: 'ProjMgmt__notify_field',
  emptyText: '未定义',
  appDataEntityId: 'plmweb.work_item',
  codeItems: [
    {
      codeName: 'projmgmt_work_item_assignee_id',
      text: '负责人',
      value: 'ProjMgmt.work_item.assignee_id',
      id: 'projmgmt_work_item_assignee_id',
    },
    {
      codeName: 'projmgmt_work_item_create_man',
      text: '建立人',
      value: 'ProjMgmt.work_item.create_man',
      id: 'projmgmt_work_item_create_man',
    },
  ],
  enableCache: true,
  name: '通知人员属性',
  id: 'plmweb.projmgmt__notify_field',
};
