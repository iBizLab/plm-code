import { Shape, Edge, Cell } from '@antv/x6';
import { IDataEntity } from '@ibiz-template/runtime';
import { X6LinkDataProvider } from '../../../interface';
export declare const lightningTool: {
    name: string;
    args: {
        markup: {
            tagName: string;
            selector: string;
            attrs: {
                d: string;
                fill: string;
                stroke: string;
                'stroke-width': number;
                cursor: string;
            };
        }[];
        distance: string;
        offset: {
            x: number;
            y: number;
        };
        zIndex: number;
        name: string;
    };
};
export declare const verticesTool: {
    name: string;
    args: {
        attrs: {
            fill: string;
        };
    };
};
export declare const edgeToolbar: {
    text: string;
    key: string;
    icon: string;
}[];
export declare const boundaryTool: {
    name: string;
    args: {
        useCellGeometry: boolean;
        padding: number;
        attrs: {
            fill: string;
            stroke: string;
            strokeWidth: number;
            fillOpacity: number;
        };
    };
};
/**
 * 逻辑连线
 *
 * @author chitanda
 * @date 2023-11-24 14:11:16
 * @export
 * @class LogicLink
 * @extends {Shape.Edge}
 */
export declare class LogicLink extends Shape.Edge {
    shiftButtonStatus: boolean;
    setLightningTool(dataProvider: X6LinkDataProvider<IDataEntity>): void;
    constructor(metadata?: Edge.Metadata);
    generateToolbarButton(): Cell.ToolItem[];
}
