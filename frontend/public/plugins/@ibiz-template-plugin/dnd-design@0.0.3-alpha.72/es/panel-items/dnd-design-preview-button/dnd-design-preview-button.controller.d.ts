import { PanelItemController } from '@ibiz-template/runtime';
import { IPanelField } from '@ibiz/model-core';
import { DndDesignPreviewButtonState } from './dnd-design-preview-button.state';
import { DndDesignViewController } from '../../views';
export declare class DndDesignPreviewButtonController extends PanelItemController<IPanelField> {
    /**
     * 面板项状态
     *
     * @author zhanghengfeng
     * @date 2025-02-14 20:02:26
     * @type {DndDesignPreviewButtonState}
     */
    state: DndDesignPreviewButtonState;
    /**
     * 创建面板状态对象
     *
     * @author zhanghengfeng
     * @date 2025-02-14 20:02:36
     * @protected
     * @return {*}  {DndDesignPreviewButtonState}
     */
    protected createState(): DndDesignPreviewButtonState;
    /**
     * 视图控制器
     *
     * @author zhanghengfeng
     * @date 2025-02-14 20:02:43
     * @readonly
     * @type {DndDesignViewController}
     */
    get view(): DndDesignViewController;
    /**
     * 处理按钮点击
     *
     * @author zhanghengfeng
     * @date 2025-02-14 20:02:05
     */
    handleButtonClick(): void;
}
