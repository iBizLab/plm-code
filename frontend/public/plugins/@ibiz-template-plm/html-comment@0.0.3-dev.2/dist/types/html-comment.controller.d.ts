import { ControllerEvent, EditorController, EventBase } from '@ibiz-template/runtime';
import { IHtml } from '@ibiz/model-core';
import { IDomEditor } from '@wangeditor/editor';
import { Ref } from 'vue';
import { commentEvent } from './html-comment.event';
/**
 * html框编辑器控制器
 *
 * @export
 * @class HtmlCommentController
 * @extends {EditorController}
 */
export declare class HtmlCommentController extends EditorController<IHtml> {
    /**
     * 上传参数
     */
    uploadParams?: IParams;
    /**
     * 下载参数
     */
    exportParams?: IParams;
    /**
     * 最小高度
     *
     * @type {number}
     * @memberof HtmlCommentController
     */
    minHeight: number;
    /**
     * 最大高度
     *
     * @type {number}
     * @memberof HtmlCommentController
     */
    maxHeight: number;
    /**
     * 是否折叠
     *
     * @type {Ref<boolean>}
     * @memberof HtmlCommentController
     */
    collapsed: Ref<boolean>;
    /**
     * 是否隐藏
     *
     * @type {Ref<boolean>}
     * @memberof HtmlCommentController
     */
    hidden: Ref<boolean>;
    /**
     * 回复
     *
     * @type {string}
     * @memberof HtmlCommentController
     */
    reply: Ref<string>;
    /**
     * 回复脚本
     *
     * @type {string}
     * @memberof HtmlCommentController
     */
    replyScript: string;
    /**
     * 编辑器模式
     *
     * @type {('comment' | 'default')}
     * @memberof HtmlCommentController
     */
    mode: 'comment' | 'default';
    /**
     * 唯一标识
     *
     * @type {string}
     * @memberof HtmlCommentController
     */
    uuid: string;
    evt: ControllerEvent<commentEvent>;
    protected getEventArgs(): Omit<EventBase, 'eventName'>;
    protected onInit(): Promise<void>;
    /**
     * 注册自定义元素
     *
     * @private
     * @memberof HtmlCommentController
     */
    private registerCustomElem;
    /**
     * 初始化
     *
     * @param {IDomEditor} editor
     * @memberof HtmlCommentController
     */
    onCreated(editor: IDomEditor, data: IData, toolbarConfig: IData): void;
    /**
     * 组件销毁
     *
     * @memberof HtmlCollapseController
     */
    onDestroyed(): void;
    /**
     * 解析所有注册节点
     *
     * @param {string} value
     * @return {*}
     * @memberof HtmlCommentController
     */
    parseNode(value: string): string;
    /**
     * 设置html
     *
     * @param {string} value
     * @memberof HtmlCommentController
     */
    setValue(value: string): Promise<void>;
    /**
     * 设置回复,data: {name: string, content: string}
     *
     * @param {IData} data
     * @memberof HtmlCommentController
     */
    setReply(data: IData): void;
    /**
     * 删除回复
     *
     * @memberof HtmlCommentController
     */
    removeReply(): void;
    /**
     * 清空
     *
     * @memberof HtmlCommentController
     */
    clear(): void;
    /**
     * 请求url获取文件流，并用JS触发文件下载
     *
     * @author lxm
     * @date 2022-11-17 14:11:09
     * @param {string} url
     * @param {IData} file
     */
    fileDownload(file: {
        url: string;
        name: string;
    }): void;
    /**
     * 切换折叠
     *
     * @memberof HtmlCommentController
     */
    toggleCollapse(open?: boolean): void;
    getThemeVar(): string | null;
    isChineseCharacter(inputString: string): boolean;
    hasChineseAndEnglish(str: string): boolean;
    stringToHexColor(text: string): string;
    avatarName(text: string): string | undefined;
}
