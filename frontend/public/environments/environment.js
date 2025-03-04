window.Environment = {
  // 是否为开发模式
  dev: true,
  // 日志输出级别, 支持: TRACE,DEBUG,INFO,WARN,ERROR,SILENT
  logLevel: 'ERROR',
  BaseUrl: '/api',
  pluginBaseUrl: './plugins',
  hub: true,
  enableMqtt: true,
  mqttUrl: '/portal/mqtt/mqtt',
  enableAnonymous: false,
  anonymousUser: '',
  anonymousPwd: '',
  marketAddress: '',
  environmentTag: 'development',
  appId: 'ibizplm__plmweb',
  mockDcSystemId: 'ibizplm',
  AppTitle: '应用首页',
  favicon: './favicon.ico',
};
