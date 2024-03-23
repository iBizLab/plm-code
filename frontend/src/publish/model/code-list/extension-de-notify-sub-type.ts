export default {
  codeListTag: 'extension__DENotifySubType',
  codeListType: 'STATIC',
  codeName: 'extension__DENotifySubType',
  emptyText: '未定义',
  appDataEntityId: 'plmweb.psdenotify',
  codeItems: [
    {
      codeName: 'None',
      text: '无',
      value: 'NONE',
      default: true,
      id: 'none',
    },
    {
      codeName: 'Eventhook',
      text: '事件通知',
      value: 'EVENTHOOK',
      id: 'eventhook',
    },
    {
      codeName: 'Fieldchangehook',
      text: '属性变更通知',
      value: 'FIELDCHANGEHOOK',
      id: 'fieldchangehook',
    },
  ],
  enableCache: true,
  name: '通知子类',
  id: 'plmweb.extension__denotifysubtype',
};
