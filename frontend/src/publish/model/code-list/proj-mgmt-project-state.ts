export default {
  codeListTag: 'ProjMgmt__Project_state',
  codeListType: 'STATIC',
  codeName: 'ProjMgmt__Project_state',
  emptyText: '未定义',
  appDataEntityId: 'plmweb.project',
  codeItems: [
    {
      codeName: 'Normal',
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
      codeName: 'Warning',
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
      codeName: 'Delay',
      color: '#FF1900',
      sysCss: {
        cssName: 'red-span',
      },
      text: '延期',
      textCls: 'red-span',
      value: 'delay',
      id: 'delay',
    },
  ],
  enableCache: true,
  name: '项目状态',
  id: 'plmweb.projmgmt__project_state',
};