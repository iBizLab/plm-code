export default {
  codeListTag: 'ProjMgmt__sprint_status',
  codeListType: 'STATIC',
  codeName: 'ProjMgmt__sprint_status',
  emptyText: '未定义',
  appDataEntityId: 'plmweb.sprint',
  codeItems: [
    {
      codeName: 'item_1',
      text: '未开始',
      value: '1',
      id: 'item_1',
    },
    {
      codeName: 'item_2',
      text: '进行中',
      value: '2',
      id: 'item_2',
    },
    {
      codeName: 'item_3',
      text: '已完成',
      value: '3',
      id: 'item_3',
    },
  ],
  enableCache: true,
  name: '迭代状态',
  id: 'plmweb.projmgmt__sprint_status',
};
