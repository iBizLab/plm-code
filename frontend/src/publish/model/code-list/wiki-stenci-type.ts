export default {
  codeListTag: 'Wiki__stenci_type',
  codeListType: 'STATIC',
  codeName: 'Wiki__stenci_type',
  emptyText: '未定义',
  codeItems: [
    {
      codeName: 'space_stencil',
      data: '{"n_space_id_eq":"%stencil_space%"}',
      text: '空间',
      value: 'space_stencil',
      id: 'space_stencil',
    },
    {
      codeName: 'org_stencil',
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
