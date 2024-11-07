export default {
  codeListTag: 'ProjMgmt__project_state',
  codeListType: 'STATIC',
  codeName: 'ProjMgmt__project_state',
  emptyText: '未定义',
  appDataEntityId: 'plmweb.project',
  codeItems: [
    {
      codeName: 'pending',
      color: '#001EFF',
      sysCss: {
        cssName: 'blue-span',
      },
      text: '未开始',
      textCls: 'blue-span',
      value: 'pending',
      id: 'pending',
    },
    {
      codeName: 'normal',
      color: '#10691B',
      sysCss: {
        cssName: 'green-span',
      },
      text: '正常',
      textCls: 'green-span',
      value: 'normal',
      id: 'normal',
    },
    {
      codeName: 'warning',
      color: '#D58A3A',
      sysCss: {
        cssName: 'orange-span',
      },
      text: '预警',
      textCls: 'orange-span',
      value: 'warning',
      id: 'warning',
    },
    {
      codeName: 'delay',
      color: '#FF1900',
      sysCss: {
        cssName: 'red-span',
      },
      text: '延期',
      textCls: 'red-span',
      value: 'delay',
      id: 'delay',
    },
    {
      codeName: 'end',
      color: '#10691B',
      sysCss: {
        cssName: 'green-span',
      },
      text: '结束',
      textCls: 'green-span',
      value: 'end',
      id: 'end',
    },
  ],
  enableCache: true,
  name: '项目状态',
  id: 'plmweb.projmgmt__project_state',
};
