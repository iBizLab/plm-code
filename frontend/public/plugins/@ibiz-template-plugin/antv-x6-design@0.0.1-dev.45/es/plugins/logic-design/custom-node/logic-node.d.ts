import { Node, Shape } from '@antv/x6';
import { Namespace } from '@ibiz-template/core';
export declare function generateMarkup(ns: Namespace, text: string, smallText: string, drag: boolean, special: boolean): {
    tagName: string;
    selector: string;
    children: {
        ns: string;
        tagName: string;
        className: string;
        selector: string;
        children: ({
            tagName: string;
            className: string;
            selector: string;
            children?: undefined;
        } | {
            tagName: string;
            className: string;
            children: {
                tagName: string;
                className: string;
                textContent: string;
            }[];
            selector?: undefined;
        })[];
    }[];
};
export declare const specialType: string[];
export declare class LogicNode extends Shape.Rect {
    constructor(metadata?: Node.Metadata);
}
