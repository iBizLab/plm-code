export default {
  codeListTag: 'FTR__search_menu',
  codeListType: 'STATIC',
  codeName: 'FTR__search_menu',
  emptyText: '未定义',
  appDataEntityId: 'plmweb.search_hub',
  codeItems: [
    {
      codeName: 'product',
      iconCls: 'fa fa-th-large',
      sysImage: {
        cssClass: 'fa fa-th-large',
        glyph: 'xf009@FontAwesome',
      },
      text: '产品管理',
      value: 'product',
      id: 'product',
    },
    {
      codeName: 'project',
      iconCls: 'fa fa-file-text-o',
      sysImage: {
        cssClass: 'fa fa-file-text-o',
        glyph: 'xf0f6@FontAwesome',
      },
      text: '项目管理',
      value: 'project',
      id: 'project',
    },
    {
      codeName: 'library',
      iconCls: 'fa fa-bug',
      sysImage: {
        cssClass: 'fa fa-bug',
        glyph: 'xf188@FontAwesome',
      },
      text: '测试管理',
      value: 'library',
      id: 'library',
    },
    {
      codeName: 'space',
      iconCls: 'fa fa-book',
      sysImage: {
        cssClass: 'fa fa-book',
        glyph: 'xf02d@FontAwesome',
      },
      text: '知识管理',
      value: 'space',
      id: 'space',
    },
  ],
  enableCache: true,
  name: '搜索所属菜单',
  id: 'plmweb.ftr__search_menu',
};
