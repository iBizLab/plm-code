export default {
  codeListTag: 'Wiki__Stenci_type',
  codeListType: 'STATIC',
  codeName: 'Wiki__Stenci_type',
  emptyText: '未定义',
  codeItems: [
    {
      codeName: 'Space_stencil',
      data: '{"n_space_id_eq":"%space%"}',
      text: '空间',
      value: 'space_stencil',
      id: 'space_stencil',
    },
    {
      codeName: 'Org_stencil',
      data: '{"n_space_id_isnull":true}',
      text: '组织',
      value: 'org_stencil',
      id: 'org_stencil',
    },
  ],
  enableCache: true,
  name: '模板分组',
  id: 'plmweb.wiki__stenci_type',
};
