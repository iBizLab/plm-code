import { ViewController } from '@ibiz-template/runtime';
import { IAppView } from '@ibiz/model-core';
import { SelectState } from '../utils';
import { IDesignPreviewProvider, IDesignViewEvent, IDesignViewState } from '../interface';
export declare class DesignViewControllerBase<M extends IAppView, S extends IDesignViewState, E extends IDesignViewEvent> extends ViewController<M, S, E> {
    /**
     * 选中数据
     *
     * @author tony001
     * @date 2024-09-10 10:09:14
     */
    readonly select: SelectState<IData>;
    /**
     * 预览适配器
     *
     * @author tony001
     * @date 2024-09-10 10:09:18
     * @protected
     * @type {IDesignPreviewProvider}
     */
    protected preViewProvider: IDesignPreviewProvider;
    /**
     * 获取预览区适配器
     *
     * @author tony001
     * @date 2024-09-10 10:09:33
     * @return {*}  {IDesignPreviewProvider}
     */
    getPreViewProvider(): IDesignPreviewProvider;
    /**
     * 生命周期-创建完成(将插件参数合入上下文中)
     *
     * @author tony001
     * @date 2024-09-10 10:09:15
     * @protected
     * @return {*}  {Promise<void>}
     */
    protected onCreated(): Promise<void>;
    /**
     * 初始化预览适配器
     *
     * @author tony001
     * @date 2024-09-10 10:09:56
     * @protected
     * @return {*}  {Promise<void>}
     */
    protected initPreViewProvider(): Promise<void>;
}
