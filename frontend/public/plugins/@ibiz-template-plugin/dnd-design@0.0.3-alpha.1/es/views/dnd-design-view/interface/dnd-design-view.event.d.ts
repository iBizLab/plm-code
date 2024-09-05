import { PartialWithObject } from '@ibiz-template/core';
import { EventBase, IViewEvent } from '@ibiz-template/runtime';
export interface DndDesignViewEvent extends IViewEvent {
    /**
     * 保存成功事件
     *
     * @author zhanghengfeng
     * @date 2024-01-04 18:01:46
     * @type {{
     *     event: EventBase;
     *     emitArgs: undefined;
     *   }}
     */
    onSaveSuccess: {
        event: EventBase;
        emitArgs: undefined;
    };
    /**
     * 素材搜索事件
     *
     * @author zhanghengfeng
     * @date 2024-01-11 19:01:54
     * @type {{
     *     event: EventBase;
     *     emitArgs: PartialWithObject<EventBase, EventBase>;
     *   }}
     */
    onStencilSearch: {
        event: EventBase;
        emitArgs: PartialWithObject<EventBase, EventBase>;
    };
}
