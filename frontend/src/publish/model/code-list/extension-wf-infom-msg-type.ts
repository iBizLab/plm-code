export default {
  codeListTag: 'extension__WFInfomMsgType',
  codeListType: 'STATIC',
  codeName: 'extension__WFInfomMsgType',
  orMode: 'NUM',
  codeItems: [
    {
      codeName: 'INTERNAL',
      text: '系统消息',
      value: '1',
      id: 'internal',
    },
    {
      codeName: 'EMAIL',
      text: '电子邮件',
      value: '2',
      id: 'email',
    },
    {
      codeName: 'SMS',
      text: '手机短信',
      value: '4',
      id: 'sms',
    },
    {
      codeName: 'WT',
      text: '微信',
      value: '32',
      id: 'wt',
    },
    {
      codeName: 'DT',
      text: '钉钉',
      value: '64',
      id: 'dt',
    },
    {
      codeName: 'ENTWT',
      text: '企业微信',
      value: '128',
      id: 'entwt',
    },
  ],
  textSeparator: '、',
  codeItemValueNumber: true,
  enableCache: true,
  name: '通知消息类型',
  id: 'plmweb.extension__wfinfommsgtype',
};