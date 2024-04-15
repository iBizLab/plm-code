export default {
  codeListTag: 'ProdMgmt__ticket_advanced_search_field',
  codeListType: 'STATIC',
  codeName: 'ProdMgmt__ticket_advanced_search_field',
  emptyText: '未定义',
  appDataEntityId: 'plmweb.ticket',
  codeItems: [
    {
      codeName: 'n_title_like',
      text: '标题',
      value: 'n_title_like',
      default: true,
      id: 'n_title_like',
    },
    {
      codeName: 'n_identifier_like',
      text: '编号',
      value: 'n_identifier_like',
      id: 'n_identifier_like',
    },
    {
      codeName: 'n_description_like',
      text: '描述',
      value: 'n_description_like',
      id: 'n_description_like',
    },
  ],
  enableCache: true,
  name: '工单高级搜索属性',
  id: 'plmweb.prodmgmt__ticket_advanced_search_field',
};
