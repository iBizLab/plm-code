import { EventBase, IComponentEvent } from '@ibiz-template/runtime';

export interface X6ControllerEvent extends IComponentEvent {
  onBeforeLoad: {
    event: EventBase;
    emitArgs: undefined;
  };
  onLoadSuccess: {
    event: EventBase;
    emitArgs: undefined;
  };
}
