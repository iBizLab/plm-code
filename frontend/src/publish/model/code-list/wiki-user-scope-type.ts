export default {
  codeListTag: 'Wiki__user_scope_type',
  codeListType: 'STATIC',
  codeName: 'Wiki__user_scope_type',
  emptyText: '未定义',
  codeItems: [
    {
      codeName: 'organization',
      text: '组织',
      value: 'organization',
      id: 'organization',
    },
    {
      codeName: 'user_group',
      text: '团队',
      value: 'user_group',
      id: 'user_group',
    },
    {
      codeName: 'user',
      text: '个人',
      value: 'user',
      id: 'user',
    },
  ],
  enableCache: true,
  name: '所属类型（包含个人）',
  id: 'plmweb.wiki__user_scope_type',
};
