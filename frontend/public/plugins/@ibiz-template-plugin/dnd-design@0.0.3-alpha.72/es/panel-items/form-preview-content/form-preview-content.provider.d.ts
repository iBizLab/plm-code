import { IPanelItemController, IPanelItemProvider, IPanelController } from '@ibiz-template/runtime';
import { IPanelItem } from '@ibiz/model-core';
/**
 * 表单预览内容区适配器
 *
 * @export
 * @class FormPreviewContentProvider
 * @implements {IPanelItemProvider}
 */
export declare class FormPreviewContentProvider implements IPanelItemProvider {
    component: string;
    createController(panelItem: IPanelItem, panel: IPanelController, parent?: IPanelItemController): Promise<IPanelItemController>;
}
