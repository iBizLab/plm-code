import { Node, Shape } from '@antv/x6';
/**
 * 素材区节点呈现
 *
 * @author chitanda
 * @date 2023-11-24 14:11:41
 * @export
 * @class MaterialNode
 * @extends {Shape.Edge}
 */
export declare class MaterialNode extends Shape.Rect {
    getNodeSize(): {
        width: number;
        height: number;
    };
    constructor(metadata?: Node.Metadata);
}
