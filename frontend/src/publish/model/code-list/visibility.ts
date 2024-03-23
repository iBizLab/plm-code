export default {
  codeListTag: 'Visibility',
  codeListType: 'STATIC',
  codeName: 'Visibility',
  emptyText: '未定义',
  codeItems: [
    {
      codeName: 'Private',
      text: '私有',
      tooltip: '仅成员可见及编辑',
      value: 'private',
      id: 'private',
    },
    {
      codeName: 'Public',
      text: '公开',
      tooltip: '组织全部成员可见，仅成员可编辑',
      value: 'public',
      id: 'public',
    },
  ],
  enableCache: true,
  name: '可见范围',
  id: 'plmweb.visibility',
};
