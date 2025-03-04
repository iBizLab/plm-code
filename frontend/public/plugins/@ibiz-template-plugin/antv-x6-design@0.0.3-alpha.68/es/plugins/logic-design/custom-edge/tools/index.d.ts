import { Cell } from '@antv/x6';
export declare const boundary: () => Cell.ToolItem;
export declare const sourceArrowhead: () => Cell.ToolItem;
export declare const targetArrowhead: () => Cell.ToolItem;
export declare const vertices: () => Cell.ToolItem;
export declare const shiftButton: (status: boolean, className: {
    svg_shift_wrapper: string;
    svg_shift1: string;
    svg_shift2: string;
}, onClick: () => void) => Cell.ToolItem;
export declare const loopIcon: () => Cell.ToolItem;
