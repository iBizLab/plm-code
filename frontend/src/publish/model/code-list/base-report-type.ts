export default {
  codeListTag: 'Base__report_type',
  codeListType: 'STATIC',
  codeName: 'Base__report_type',
  emptyText: '未定义',
  codeItems: [
    {
      codeName: 'item_10',
      iconCls: 'fa fa-bar-chart',
      sysImage: {
        cssClass: 'fa fa-bar-chart',
        glyph: 'xf080@FontAwesome',
      },
      text: '柱状图',
      value: '10',
      id: 'item_10',
    },
    {
      codeName: 'item_20',
      iconCls: 'fa fa-pie-chart',
      sysImage: {
        cssClass: 'fa fa-pie-chart',
        glyph: 'xf200@FontAwesome',
      },
      text: '饼状图',
      value: '20',
      id: 'item_20',
    },
    {
      codeName: 'item_30',
      iconCls: 'fa fa-line-chart',
      sysImage: {
        cssClass: 'fa fa-line-chart',
        glyph: 'xf201@FontAwesome',
      },
      text: '折线图',
      value: '30',
      id: 'item_30',
    },
    {
      codeName: 'item_40',
      iconCls: 'fa fa-area-chart',
      sysImage: {
        cssClass: 'fa fa-area-chart',
        glyph: 'xf1fe@FontAwesome',
      },
      text: '区域图',
      value: '40',
      id: 'item_40',
    },
  ],
  enableCache: true,
  name: '报表类型',
  id: 'plmweb.base__report_type',
};
