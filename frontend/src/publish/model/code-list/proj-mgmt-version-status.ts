export default {
  codeListTag: 'ProjMgmt__Version_status',
  codeListType: 'STATIC',
  codeName: 'ProjMgmt__Version_status',
  emptyText: '未定义',
  appDataEntityId: 'plmweb.version',
  codeItems: [
    {
      codeName: 'Pending',
      text: '未开始',
      value: 'pending',
      id: 'pending',
    },
    {
      codeName: 'In_progress',
      text: '进行中',
      value: 'in_progress',
      id: 'in_progress',
    },
    {
      codeName: 'Completed',
      text: '已发布',
      value: 'completed',
      id: 'completed',
    },
    {
      codeName: 'Closed',
      text: '已关闭',
      value: 'closed',
      id: 'closed',
    },
  ],
  enableCache: true,
  name: '发布状态',
  id: 'plmweb.projmgmt__version_status',
};
