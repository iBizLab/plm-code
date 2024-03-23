export default {
  codeListTag: 'Base__Role_type',
  codeListType: 'STATIC',
  codeName: 'Base__Role_type',
  emptyText: '未定义',
  appDataEntityId: 'plmweb.product',
  codeItems: [
    {
      codeName: 'Admin',
      text: '管理员',
      value: 'admin',
      id: 'admin',
    },
    {
      codeName: 'User',
      text: '普通成员',
      value: 'user',
      id: 'user',
    },
    {
      codeName: 'Reader',
      text: '只读成员',
      value: 'reader',
      id: 'reader',
    },
  ],
  enableCache: true,
  name: '角色类型',
  id: 'plmweb.base__role_type',
};
