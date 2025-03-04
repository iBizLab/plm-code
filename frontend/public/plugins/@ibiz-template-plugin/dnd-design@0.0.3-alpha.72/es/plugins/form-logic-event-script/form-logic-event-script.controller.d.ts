import { EditorController, IAppDEService } from '@ibiz-template/runtime';
import { ICode } from '@ibiz/model-core';
/**
 * 表单逻辑（事件脚本）编辑器控制器
 *
 * @export
 * @class CodeEditorController
 * @extends {EditorController}
 */
export declare class FormLogicEventScriptEditorController extends EditorController<ICode> {
    /**
     * 语言类型
     *
     * @readonly
     * @type {string}
     * @memberof FormLogicEventScriptEditorController
     */
    get language(): string;
    /**
     * 主题
     *
     * @readonly
     * @type {string}
     * @memberof FormLogicEventScriptEditorController
     */
    get theme(): string;
    /**
     * 逻辑服务
     *
     * @type {(IAppDEService | null)}
     * @memberof FormLogicEventScriptEditorController
     */
    logicService: IAppDEService | null;
    /**
     * 逻辑数据
     *
     * @type {(IData | null)}
     * @memberof FormLogicEventScriptEditorController
     */
    logicData: IData | null;
    /**
     * 初始化
     *
     * @protected
     * @return {*}  {Promise<void>}
     * @memberof FormLogicEventScriptEditorController
     */
    protected onInit(): Promise<void>;
    /**
     * 初始化实体服务
     *
     * @protected
     * @return {*}  {Promise<void>}
     * @memberof FormLogicEventScriptEditorController
     */
    protected initService(): Promise<void>;
    /**
     * 加载脚本内容
     *
     * @return {*}  {(Promise<void>)}
     * @memberof FormLogicEventScriptEditorController
     */
    loadScriptContent(): Promise<void>;
    /**
     * 保存脚本内容
     *
     * @param {string} scriptCode
     * @return {*}  {Promise<void>}
     * @memberof FormLogicEventScriptEditorController
     */
    saveScriptContent(scriptCode: string): Promise<void>;
}
