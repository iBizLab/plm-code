export default {
  codeListTag: 'ProjMgmt__defect_property_distribution',
  codeListType: 'STATIC',
  codeName: 'ProjMgmt__defect_property_distribution',
  emptyText: '未定义',
  appDataEntityId: 'plmweb.work_item',
  codeItems: [
    {
      codeName: 'state',
      text: '工作项状态',
      value: 'state',
      id: 'state',
    },
    {
      codeName: 'state_type',
      text: '状态类型',
      value: 'state_type',
      id: 'state_type',
    },
    {
      codeName: 'priority',
      text: '优先级',
      value: 'priority',
      id: 'priority',
    },
    {
      codeName: 'severity',
      text: '严重程度',
      value: 'severity',
      id: 'severity',
    },
    {
      codeName: 'sprint_id',
      text: '迭代',
      value: 'sprint_id',
      id: 'sprint_id',
    },
    {
      codeName: 'reappear_probability',
      text: '复现概率',
      value: 'REAPPEAR_PROBABILITY',
      id: 'reappear_probability',
    },
  ],
  enableCache: true,
  name: '缺陷属性分布报表分组属性',
  id: 'plmweb.projmgmt__defect_property_distribution',
};
