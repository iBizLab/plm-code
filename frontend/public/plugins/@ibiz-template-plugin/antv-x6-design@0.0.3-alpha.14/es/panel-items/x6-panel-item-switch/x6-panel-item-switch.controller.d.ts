import { PanelItemController } from '@ibiz-template/runtime';
import { ICodeItem, IPanelField } from '@ibiz/model-core';
export declare class X6PanelItemSwitchController extends PanelItemController<IPanelField> {
    items: ICodeItem[];
    protected onInit(): Promise<void>;
}
