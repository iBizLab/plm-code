export default {
  codeListTag: 'Base__insight_group',
  codeListType: 'STATIC',
  codeName: 'Base__insight_group',
  emptyText: '未定义',
  appDataEntityId: 'plmweb.insight',
  codeItems: [
    {
      codeName: 'board',
      iconCls: 'fa fa-columns',
      sysImage: {
        cssClass: 'fa fa-columns',
        glyph: 'xf0db@FontAwesome',
      },
      text: '看板报表',
      value: 'board',
      id: 'board',
    },
    {
      codeName: 'backlog',
      iconCls: 'fa fa-puzzle-piece',
      sysImage: {
        cssClass: 'fa fa-puzzle-piece',
        glyph: 'xf12e@FontAwesome',
      },
      text: '需求报表',
      value: 'backlog',
      id: 'backlog',
    },
    {
      codeName: 'defect',
      iconCls: 'fa fa-bug',
      sysImage: {
        cssClass: 'fa fa-bug',
        glyph: 'xf188@FontAwesome',
      },
      text: '缺陷报表',
      value: 'defect',
      id: 'defect',
    },
    {
      codeName: 'sprint',
      iconCls: 'fa fa-life-saver',
      sysImage: {
        cssClass: 'fa fa-life-saver',
        glyph: 'xf1cd@FontAwesome',
      },
      text: '迭代报表',
      value: 'sprint',
      id: 'sprint',
    },
    {
      codeName: 'project',
      iconCls: 'fa fa-cube',
      sysImage: {
        cssClass: 'fa fa-cube',
        glyph: 'xf1b2@FontAwesome',
      },
      text: '项目报表',
      value: 'project',
      id: 'project',
    },
    {
      codeName: 'test_case',
      iconCls: 'fa fa-bug',
      sysImage: {
        cssClass: 'fa fa-bug',
        glyph: 'xf188@FontAwesome',
      },
      text: '测试用例',
      value: 'test_case',
      id: 'test_case',
    },
    {
      codeName: 'run_case',
      iconCls: 'fa fa-flag-o',
      sysImage: {
        cssClass: 'fa fa-flag-o',
        glyph: 'xf11d@FontAwesome',
      },
      text: '执行情况',
      value: 'run_case',
      id: 'run_case',
    },
  ],
  enableCache: true,
  name: '报表组别',
  id: 'plmweb.base__insight_group',
};
