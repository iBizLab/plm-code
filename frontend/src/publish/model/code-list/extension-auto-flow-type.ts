export default {
  codeListTag: 'extension__auto_flow_type',
  codeListType: 'STATIC',
  codeName: 'extension__auto_flow_type',
  emptyText: '未定义',
  appDataEntityId: 'plmweb.psdelogic',
  codeItems: [
    {
      codeName: 'eventhook',
      text: '事件处理',
      value: 'EVENTHOOK',
      id: 'eventhook',
    },
    {
      codeName: 'fieldchangehook',
      text: '属性变化处理',
      value: 'FIELDCHANGEHOOK',
      id: 'fieldchangehook',
    },
    {
      codeName: 'webhook',
      text: '收到WebHook',
      value: 'WEBHOOK',
      id: 'webhook',
    },
  ],
  enableCache: true,
  name: '自动化规则类型',
  id: 'plmweb.extension__auto_flow_type',
};
