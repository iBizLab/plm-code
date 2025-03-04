import { EditorController, IAppDEService } from '@ibiz-template/runtime';
import { ICode } from '@ibiz/model-core';

/**
 * 表单逻辑（事件脚本）编辑器控制器
 *
 * @export
 * @class CodeEditorController
 * @extends {EditorController}
 */
export class FormLogicEventScriptEditorController extends EditorController<ICode> {
  /**
   * 语言类型
   *
   * @readonly
   * @type {string}
   * @memberof FormLogicEventScriptEditorController
   */
  get language(): string {
    return 'javascript';
  }

  /**
   * 主题
   *
   * @readonly
   * @type {string}
   * @memberof FormLogicEventScriptEditorController
   */
  get theme(): string {
    return this.editorParams.theme || 'vs-dark';
  }

  /**
   * 逻辑服务
   *
   * @type {(IAppDEService | null)}
   * @memberof FormLogicEventScriptEditorController
   */
  logicService: IAppDEService | null = null;

  /**
   * 逻辑数据
   *
   * @type {(IData | null)}
   * @memberof FormLogicEventScriptEditorController
   */
  logicData: IData | null = null;

  /**
   * 初始化
   *
   * @protected
   * @return {*}  {Promise<void>}
   * @memberof FormLogicEventScriptEditorController
   */
  protected async onInit(): Promise<void> {
    super.onInit();
    await this.initService();
    await this.loadScriptContent();
  }

  /**
   * 初始化实体服务
   *
   * @protected
   * @return {*}  {Promise<void>}
   * @memberof FormLogicEventScriptEditorController
   */
  protected async initService(): Promise<void> {
    const app = ibiz.hub.getApp(this.context.srfappid);
    const entity = await ibiz.hub.getAppDataEntity(
      'PSDEFDLogic',
      this.context.srfappid,
    );
    this.logicService = await app.deService.getService(
      this.context,
      entity.id!,
    );
  }

  /**
   * 加载脚本内容
   *
   * @return {*}  {(Promise<void>)}
   * @memberof FormLogicEventScriptEditorController
   */
  async loadScriptContent(): Promise<void> {
    const result = await this.logicService?.exec(
      'FetchCurRootItemsByLogicCat',
      this.context,
      {
        logiccat: (this.parent as IData).model.userTag,
      },
    );
    if (result?.ok && Array.isArray(result.data)) {
      this.logicData = result.data[0];
    }
  }

  /**
   * 保存脚本内容
   *
   * @param {string} scriptCode
   * @return {*}  {Promise<void>}
   * @memberof FormLogicEventScriptEditorController
   */
  async saveScriptContent(scriptCode: string): Promise<void> {
    const { model, data } = this.parent as IData;
    const item = {
      condvalue: scriptCode,
      logiccat: model.userTag,
      logictype: 'SINGLE',
      psdefdlogicid: this.logicData?.srfkey,
      psdeformdetailid: data.psdeformdetailid,
      psdeformdetailname: data.psdeformdetailname,
    };
    const result = await this.logicService?.exec(
      item.psdefdlogicid ? 'update' : 'create',
      this.context,
      item,
    );
    if (result?.ok && result.data) {
      this.logicData = result.data;
    }
  }
}
