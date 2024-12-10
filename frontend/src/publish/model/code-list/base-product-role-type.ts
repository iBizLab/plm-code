export default {
  codeListTag: 'Base__product_role_type',
  codeListType: 'STATIC',
  codeName: 'Base__product_role_type',
  emptyText: '未定义',
  appDataEntityId: 'plmweb.product',
  codeItems: [
    {
      codeName: 'admin',
      text: '管理员',
      value: 'admin',
      id: 'admin',
    },
    {
      codeName: 'user',
      text: '普通成员',
      value: 'user',
      id: 'user',
    },
    {
      codeName: 'reader',
      text: '只读成员',
      value: 'reader',
      id: 'reader',
    },
    {
      codeName: 'customer',
      text: '特定成员',
      value: 'customer',
      id: 'customer',
    },
  ],
  enableCache: true,
  name: '产品角色类型',
  id: 'plmweb.base__product_role_type',
};
