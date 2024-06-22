import { RuntimeModelError } from '@ibiz-template/core';
import { PanelItemController } from '@ibiz-template/runtime';
import {
  IAppCodeList,
  ICodeItem,
  ICodeListEditor,
  IPanelField,
} from '@ibiz/model-core';

export class X6PanelItemSwitchController extends PanelItemController<IPanelField> {
  items: ICodeItem[] = [];

  protected async onInit(): Promise<void> {
    await super.onInit();
    const { editor } = this.model;
    if (editor) {
      let codeList: IAppCodeList | null = null;
      const { appCodeListId } = editor as ICodeListEditor;
      if (appCodeListId) {
        const app = await ibiz.hub.getApp(this.model.appId);
        codeList = app.codeList.getCodeList(appCodeListId)!;
      }
      if (!codeList) {
        throw new RuntimeModelError(
          this.model,
          `未配置主状态设计呈现模式代码表`,
        );
      }
      this.items = codeList.codeItems || [];
    }
  }
}
