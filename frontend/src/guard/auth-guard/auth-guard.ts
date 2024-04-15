import { AuthGuard } from '@ibiz-template/vue3-components';
import { ModelLoader } from '@/model/model-loader';
import { registerCodeList } from '@/publish/model';
import { initViewConfig } from '@/publish/model/view-config';

export class StaticAuthGuard extends AuthGuard {
  hasModelInit: boolean = false;

  async initModel(_permission: boolean = true): Promise<void> {
    if (this.hasModelInit) {
      return;
    }
    ibiz.hub.registerModelLoaderProvider(new ModelLoader());
    await initViewConfig();
    const app = await ibiz.hub.getAppAsync(ibiz.env.appId);
    await registerCodeList(app.codeList);

    const appModel = app.model;
    await this.initEnvironment(appModel);
    ibiz.env.isMob = appModel.mobileApp === true;
    if (ibiz.env.isEnableMultiLan) {
      // todo 多语言
      // const lang = ibiz.i18n.getLang();
      // const m = await helper.getPSAppLang(lang.replace('-', '_').toUpperCase());
      // const items = m.languageItems || [];
      // // eslint-disable-next-line @typescript-eslint/no-explicit-any
      // const data: any = {};
      // items.forEach(item => {
      //   data[item.lanResTag!] = item.content;
      // });
      // i18n.global.mergeLocaleMessage(lang, data);
    }
    await this.initTheme(appModel);
    this.hasModelInit = true;
  }
}
