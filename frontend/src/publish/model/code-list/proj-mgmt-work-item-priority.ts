export default {
  codeListTag: 'ProjMgmt__Work_item_priority',
  codeListType: 'STATIC',
  codeName: 'ProjMgmt__Work_item_priority',
  emptyText: '未定义',
  appDataEntityId: 'plmweb.work_item',
  codeItems: [
    {
      codeName: 'Item_10',
      color: '#10691B',
      sysCss: {
        cssName: 'green-span',
      },
      text: '低',
      textCls: 'green-span',
      value: '10',
      id: 'item_10',
    },
    {
      codeName: 'Item_20',
      color: '#002FFF',
      sysCss: {
        cssName: 'blue-span',
      },
      text: '中',
      textCls: 'blue-span',
      value: '20',
      id: 'item_20',
    },
    {
      codeName: 'Item_30',
      color: '#D58A3A',
      sysCss: {
        cssName: 'orange-span',
      },
      text: '高',
      textCls: 'orange-span',
      value: '30',
      id: 'item_30',
    },
    {
      codeName: 'Item_40',
      color: '#FF1900',
      sysCss: {
        cssName: 'red-span',
      },
      text: '紧急',
      textCls: 'red-span',
      value: '40',
      id: 'item_40',
    },
  ],
  enableCache: true,
  name: '优先级',
  id: 'plmweb.projmgmt__work_item_priority',
};