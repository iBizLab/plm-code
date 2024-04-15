export default {
  codeListTag: 'TestMgmt__test_plan_status',
  codeListType: 'STATIC',
  codeName: 'TestMgmt__test_plan_status',
  emptyText: '未定义',
  appDataEntityId: 'plmweb.test_plan',
  codeItems: [
    {
      codeName: 'pending',
      color: '#FF1900',
      sysCss: {
        cssName: 'red-span',
      },
      text: '未开始',
      textCls: 'red-span',
      value: 'pending',
      id: 'pending',
    },
    {
      codeName: 'in_progress',
      color: '#D58A3A',
      sysCss: {
        cssName: 'orange-span',
      },
      text: '进行中',
      textCls: 'orange-span',
      value: 'in_progress',
      id: 'in_progress',
    },
    {
      codeName: 'completed',
      color: '#10691B',
      sysCss: {
        cssName: 'green-span',
      },
      text: '已完成',
      textCls: 'green-span',
      value: 'completed',
      id: 'completed',
    },
  ],
  enableCache: true,
  name: '测试计划状态',
  id: 'plmweb.testmgmt__test_plan_status',
};
