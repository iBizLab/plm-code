import { EventBase, IViewEvent } from '@ibiz-template/runtime';

export interface IDesignViewEvent extends IViewEvent {
  /**
   * 更新成功
   *
   * @author tony001
   * @date 2024-09-10 15:09:14
   * @type {{
   *     event: EventBase;
   *     emitArgs: undefined;
   *   }}
   */
  onUpdateSuccess: {
    event: EventBase;
    emitArgs: undefined;
  };

  /**
   * 保存成功
   *
   * @author tony001
   * @date 2024-09-10 15:09:22
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
   * 删除成功
   *
   * @author tony001
   * @date 2024-09-10 15:09:30
   * @type {{
   *     event: EventBase;
   *     emitArgs: undefined;
   *   }}
   */
  onRemoveSuccess: {
    event: EventBase;
    emitArgs: undefined;
  };

  /**
   * 新建成功
   *
   * @author tony001
   * @date 2024-09-10 15:09:39
   * @type {{
   *     event: EventBase;
   *     emitArgs: undefined;
   *   }}
   */
  onCreateSuccess: {
    event: EventBase;
    emitArgs: undefined;
  };
}
