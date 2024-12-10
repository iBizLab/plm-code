import { EventBase, IViewEvent } from '@ibiz-template/runtime';
export interface X6DesignViewEvent extends IViewEvent {
    /**
     * 保存成功事件
     *
     * @author zhanghengfeng
     * @date 2024-01-12 09:01:36
     * @type {{
     *     event: EventBase;
     *     emitArgs: undefined;
     *   }}
     */
    onSaveSuccess: {
        event: EventBase;
        emitArgs: undefined;
    };
}
