import { IAppView } from '@ibiz/model-core';
import { ViewController } from '@ibiz-template/runtime';
import { IDesignPreviewProvider, IPreviewViewEvent, IPreviewViewState } from '../../interface';
/**
 * 预览视图控制器基类
 *
 * @export
 * @class PreviewViewControllerBase
 * @extends {ViewController<M, S, E>}
 * @template M
 * @template S
 * @template E
 */
export declare class PreviewViewControllerBase<M extends IAppView, S extends IPreviewViewState, E extends IPreviewViewEvent> extends ViewController<M, S, E> {
    /**
     * 预览适配器
     *
     * @public
     * @type {IDesignPreviewProvider}
     * @memberof PreviewViewControllerBase
     */
    preViewProvider: IDesignPreviewProvider;
    /**
     * 获取预览区适配器
     *
     * @return {*}  {IDesignPreviewProvider}
     * @memberof PreviewViewControllerBase
     */
    getPreViewProvider(): IDesignPreviewProvider;
    /**
     * 生命周期-创建完成
     *
     * @protected
     * @return {*}  {Promise<void>}
     * @memberof PreviewViewControllerBase
     */
    protected onCreated(): Promise<void>;
    /**
     * 初始化预览视图引擎
     *
     * @protected
     * @memberof PreviewViewControllerBase
     */
    protected initEngines(): void;
    /**
     * 初始化预览编辑器
     *
     * @protected
     * @return {*}  {Promise<void>}
     * @memberof PreviewViewControllerBase
     */
    protected initPreViewProvider(): Promise<void>;
}
