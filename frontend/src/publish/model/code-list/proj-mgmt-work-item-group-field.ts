export default {
  codeListTag: 'ProjMgmt__Work_item_group_field',
  codeListType: 'STATIC',
  codeName: 'ProjMgmt__Work_item_group_field',
  emptyText: '未定义',
  appDataEntityId: 'plmweb.work_item',
  codeItems: [
    {
      codeName: 'State',
      text: '状态',
      value: 'state',
      id: 'state',
    },
    {
      codeName: 'Priority',
      text: '优先级',
      value: 'priority',
      id: 'priority',
    },
    {
      codeName: 'Risk',
      text: '风险',
      value: 'risk',
      id: 'risk',
    },
    {
      codeName: 'Backlog_type',
      text: '需求类型',
      value: 'backlog_type',
      id: 'backlog_type',
    },
    {
      codeName: 'Backlog_from',
      text: '需求来源',
      value: 'backlog_from',
      id: 'backlog_from',
    },
    {
      codeName: 'Sprint_name',
      text: '迭代',
      value: 'sprint_name',
      id: 'sprint_name',
    },
  ],
  enableCache: true,
  name: '需求属性分布',
  id: 'plmweb.projmgmt__work_item_group_field',
};