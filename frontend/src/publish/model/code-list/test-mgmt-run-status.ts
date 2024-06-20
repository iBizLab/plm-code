export default {
  codeListTag: 'TestMgmt__run_status',
  codeListType: 'STATIC',
  codeName: 'TestMgmt__run_status',
  emptyText: '未设置',
  appDataEntityId: 'plmweb.run',
  codeItems: [
    {
      codeName: 'item_10',
      iconCls: 'fa fa-check-circle',
      sysCss: {
        cssName: 'green-span',
      },
      sysImage: {
        cssClass: 'fa fa-check-circle',
        glyph: 'xf058@FontAwesome',
      },
      text: '通过',
      textCls: 'green-span',
      value: '10',
      id: 'item_10',
    },
    {
      codeName: 'item_20',
      iconCls: 'fa fa-minus-circle',
      sysCss: {
        cssName: 'orange-span',
      },
      sysImage: {
        cssClass: 'fa fa-minus-circle',
        glyph: 'xf056@FontAwesome',
      },
      text: '受阻',
      textCls: 'orange-span',
      value: '20',
      id: 'item_20',
    },
    {
      codeName: 'item_30',
      iconCls: 'fa fa-times-circle-o',
      sysCss: {
        cssName: 'red-span',
      },
      sysImage: {
        cssClass: 'fa fa-times-circle-o',
        glyph: 'xf05c@FontAwesome',
      },
      text: '失败',
      textCls: 'red-span',
      value: '30',
      id: 'item_30',
    },
    {
      codeName: 'item_40',
      iconCls: 'fa fa-arrow-circle-right',
      sysCss: {
        cssName: 'grey-span',
      },
      sysImage: {
        cssClass: 'fa fa-arrow-circle-right',
        glyph: 'xf0a9@FontAwesome',
      },
      text: '跳过',
      textCls: 'grey-span',
      value: '40',
      id: 'item_40',
    },
  ],
  enableCache: true,
  name: '执行用例状态',
  id: 'plmweb.testmgmt__run_status',
};
