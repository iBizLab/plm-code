export default {
  codeListTag: 'ProjMgmt__Work_item_type_group',
  codeListType: 'STATIC',
  codeName: 'ProjMgmt__Work_item_type_group',
  emptyText: '未定义',
  appDataEntityId: 'plmweb.work_item_type',
  codeItems: [
    {
      codeName: 'Requirement',
      text: '需求',
      value: 'requirement',
      id: 'requirement',
    },
    {
      codeName: 'Task',
      text: '任务',
      value: 'task',
      id: 'task',
    },
    {
      codeName: 'Bug',
      text: '缺陷',
      value: 'bug',
      id: 'bug',
    },
    {
      codeName: 'Issue',
      text: '事务',
      value: 'issue',
      id: 'issue',
    },
    {
      codeName: 'Plan',
      text: '计划',
      value: 'plan',
      id: 'plan',
    },
  ],
  enableCache: true,
  name: '工作项类型分组',
  id: 'plmweb.projmgmt__work_item_type_group',
};