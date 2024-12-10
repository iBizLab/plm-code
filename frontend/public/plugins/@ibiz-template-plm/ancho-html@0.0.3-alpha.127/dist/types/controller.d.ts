import { EditorController } from '@ibiz-template/runtime';
import { IRaw } from '@ibiz/model-core';
/**
 * 直接内容编辑器控制器
 *
 * @export
 * @class RawEditorController
 * @extends {EditorController}
 */
export declare class RawEditorController extends EditorController<IRaw> {
    /**
     * @description 链接视图id
     * @type {string}
     * @memberof RawEditorController
     */
    linkViewId: string;
    protected onInit(): Promise<void>;
    /**
     * @description 处理点击事件
     * @param {MouseEvent} event
     * @param {IData} item
     * @return {*}  {void}
     * @memberof RawEditorController
     */
    handleClick(event: MouseEvent, item: IData): void;
}
