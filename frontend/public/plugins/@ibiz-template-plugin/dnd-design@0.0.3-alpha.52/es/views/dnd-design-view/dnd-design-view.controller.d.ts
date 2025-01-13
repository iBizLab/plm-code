import { ViewController } from '@ibiz-template/runtime';
import { IAppDECustomView } from '@ibiz/model-core';
import { DndDesignViewState } from './interface/dnd-design-view.state';
import { DndDesignViewEvent } from './interface/dnd-design-view.event';
import { SelectState } from '../../utils';
import { IPreviewProvider } from '../../interface';
export declare class DndDesignViewController extends ViewController<IAppDECustomView, DndDesignViewState, DndDesignViewEvent> {
    /**
     * 视图中的选中数据
     *
     * @author chitanda
     * @date 2023-12-21 18:12:25
     */
    readonly select: SelectState<IData>;
    /**
     * 预览适配器
     *
     * @author tony001
     * @date 2024-09-06 15:09:59
     * @private
     * @type {IPreviewProvider}
     */
    private preViewProvider;
    /**
     * 获取预览区适配器
     *
     * @author tony001
     * @date 2024-09-06 15:09:07
     * @return {*}  {IPreviewProvider}
     */
    getPreViewProvider(): IPreviewProvider;
    /**
     * 生命周期-创建完成
     * - 将插件参数合入上下文中
     * @protected
     * @return {*}  {Promise<void>}
     * @memberof DndDesignViewController
     */
    protected onCreated(): Promise<void>;
    protected initEngines(): void;
}
