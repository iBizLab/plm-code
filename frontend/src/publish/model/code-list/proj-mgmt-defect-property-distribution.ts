export default {
  codeListTag: 'ProjMgmt__Defect_property_distribution',
  codeListType: 'STATIC',
  codeName: 'ProjMgmt__Defect_property_distribution',
  emptyText: '未定义',
  appDataEntityId: 'plmweb.work_item',
  codeItems: [
    {
      codeName: 'State',
      text: '工作项状态',
      value: 'state',
      id: 'state',
    },
    {
      codeName: 'State_type',
      text: '状态类型',
      value: 'state_type',
      id: 'state_type',
    },
    {
      codeName: 'Priority',
      text: '优先级',
      value: 'priority',
      id: 'priority',
    },
    {
      codeName: 'Severity',
      text: '严重程度',
      value: 'severity',
      id: 'severity',
    },
    {
      codeName: 'Sprint_id',
      text: '迭代',
      value: 'sprint_id',
      id: 'sprint_id',
    },
    {
      codeName: 'Reappear_probability',
      text: '复现概率',
      value: 'REAPPEAR_PROBABILITY',
      id: 'reappear_probability',
    },
  ],
  enableCache: true,
  name: '缺陷属性分布报表分组属性',
  id: 'plmweb.projmgmt__defect_property_distribution',
};
