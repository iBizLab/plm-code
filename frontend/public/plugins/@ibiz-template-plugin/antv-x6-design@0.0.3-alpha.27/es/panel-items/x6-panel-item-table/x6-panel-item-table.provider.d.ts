import { IPanelItemController, IPanelItemProvider, IPanelController } from '@ibiz-template/runtime';
import { IPanelItem } from '@ibiz/model-core';
export declare class X6PanelItemTableProvider implements IPanelItemProvider {
    component: string;
    createController(panelItem: IPanelItem, panel: IPanelController, parent?: IPanelItemController): Promise<IPanelItemController>;
}
