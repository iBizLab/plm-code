export default {
  codeListTag: 'ProjMgmt__project_state_type',
  codeListType: 'STATIC',
  codeName: 'ProjMgmt__project_state_type',
  emptyText: '未定义',
  appDataEntityId: 'plmweb.project_state',
  codeItems: [
    {
      codeName: 'pending',
      color: '#56ABFB',
      text: '未开始',
      value: 'pending',
      id: 'pending',
    },
    {
      codeName: 'in_progress',
      color: '#F6C659',
      text: '进行中',
      value: 'in_progress',
      id: 'in_progress',
    },
    {
      codeName: 'completed',
      color: '#73D897',
      text: '已完成',
      value: 'completed',
      id: 'completed',
    },
  ],
  enableCache: true,
  name: '项目状态类型',
  id: 'plmweb.projmgmt__project_state_type',
};
