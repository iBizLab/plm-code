export default {
  codeListTag: 'TestMgmt__test_plan_type',
  codeListType: 'STATIC',
  codeName: 'TestMgmt__test_plan_type',
  emptyText: '未定义',
  appDataEntityId: 'plmweb.test_plan',
  codeItems: [
    {
      codeName: 'item_10',
      iconCls: 'fa fa-cube',
      sysImage: {
        cssClass: 'fa fa-cube',
        glyph: 'xf1b2@FontAwesome',
      },
      text: '普通测试',
      value: '10',
      id: 'item_10',
    },
    {
      codeName: 'item_20',
      iconCls: 'fa fa-columns',
      sysImage: {
        cssClass: 'fa fa-columns',
        glyph: 'xf0db@FontAwesome',
      },
      text: '迭代测试',
      value: '20',
      id: 'item_20',
    },
    {
      codeName: 'item_30',
      iconCls: 'fa fa-leanpub',
      sysImage: {
        cssClass: 'fa fa-leanpub',
        glyph: 'xf212@FontAwesome',
      },
      text: '发布测试',
      value: '30',
      id: 'item_30',
    },
  ],
  enableCache: true,
  name: '测试分类',
  id: 'plmweb.testmgmt__test_plan_type',
};
