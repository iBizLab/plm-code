import { Node, Shape } from '@antv/x6';
import { Namespace } from '@ibiz-template/core';
export declare const port: {
    groups: {
        left: {
            position: {
                name: string;
            };
            attrs: {
                circle: {
                    r: number;
                    magnet: boolean;
                    fill: string;
                    stroke: string;
                    style: {
                        visibility: string;
                    };
                };
            };
        };
        right: {
            position: {
                name: string;
            };
            attrs: {
                circle: {
                    r: number;
                    magnet: boolean;
                    fill: string;
                    stroke: string;
                    style: {
                        visibility: string;
                    };
                };
            };
        };
        top: {
            position: {
                name: string;
            };
            attrs: {
                circle: {
                    r: number;
                    magnet: boolean;
                    fill: string;
                    stroke: string;
                    style: {
                        visibility: string;
                    };
                };
            };
        };
        bottom: {
            position: {
                name: string;
            };
            attrs: {
                circle: {
                    r: number;
                    magnet: boolean;
                    fill: string;
                    stroke: string;
                    style: {
                        visibility: string;
                    };
                };
            };
        };
        center: {
            position: {
                name: string;
            };
            attrs: {
                circle: {
                    r: number;
                    magnet: boolean;
                    fill: string;
                    stroke: string;
                    style: {
                        visibility: string;
                    };
                };
            };
        };
    };
    specialItems: {
        id: string;
        group: string;
    }[];
    items: {
        id: string;
        selector: string;
        group: string;
    }[];
};
export declare const nodeModel: Record<string, {
    width: number;
    height: number;
    type?: string;
    resize?: boolean;
}>;
export declare function calcRectPort(id: string, width: number, height: number): {
    x: number;
    y: number;
} | undefined;
export declare function generatePorts(type: string): import("@antv/x6/lib/model/port").PortManager.PortMetadata[];
export declare function generateMarkup(ns: Namespace, type: string, text: string): {
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
            textContent?: undefined;
        } | {
            tagName: string;
            className: string;
            textContent: string;
            selector?: undefined;
        })[];
    }[];
};
export declare class LogicNode extends Shape.Rect {
    constructor(metadata?: Node.Metadata);
}
