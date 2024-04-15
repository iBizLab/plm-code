export default {
  codeListTag: 'Wiki__page_type',
  codeListType: 'STATIC',
  codeName: 'Wiki__page_type',
  emptyText: '未定义',
  appDataEntityId: 'plmweb.article_page',
  codeItems: [
    {
      codeName: 'item_1',
      color: '#997AB5',
      iconCls: 'fa fa-file-text-o',
      sysImage: {
        cssClass: 'fa fa-file-text-o',
        glyph: 'xf0f6@FontAwesome',
      },
      text: '文档',
      value: '1',
      id: 'item_1',
    },
    {
      codeName: 'item_2',
      color: '#FFE65A',
      iconCls: 'fa fa-folder',
      sysImage: {
        cssClass: 'fa fa-folder',
        glyph: 'xf07b@FontAwesome',
      },
      text: '分组',
      value: '2',
      id: 'item_2',
    },
    {
      codeName: 'item_3',
      color: '#F27C7C',
      iconCls: 'fa fa-newspaper-o',
      sysImage: {
        cssClass: 'fa fa-newspaper-o',
        glyph: 'xf1ea@FontAwesome',
      },
      text: '画板',
      value: '3',
      id: 'item_3',
    },
  ],
  enableCache: true,
  name: '页面类型',
  id: 'plmweb.wiki__page_type',
};
