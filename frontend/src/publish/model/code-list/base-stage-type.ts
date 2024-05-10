export default {
  codeListTag: 'Base__stage_type',
  codeListType: 'STATIC',
  codeName: 'Base__stage_type',
  emptyText: '未定义',
  appDataEntityId: 'plmweb.dictionary_data',
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
      codeName: 'published',
      color: '#73D897',
      text: '已发布',
      value: 'published',
      id: 'published',
    },
  ],
  enableCache: true,
  name: '阶段类型',
  id: 'plmweb.base__stage_type',
};
