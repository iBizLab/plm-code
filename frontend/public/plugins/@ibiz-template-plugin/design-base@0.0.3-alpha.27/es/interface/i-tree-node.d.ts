/**
 * 树节点规范
 *
 * @export
 * @interface ITreeNode
 */
export interface ITreeNode {
    [key: string]: any;
    /**
     * 节点ID
     *
     * @type {string}
     * @memberof ITreeNode
     */
    id: string;
    /**
     * 节点文本
     *
     * @type {string}
     * @memberof ITreeNode
     */
    label: string;
    /**
     * 节点类型
     *
     * @type {string}
     * @memberof ITreeNode
     */
    type: string;
    /**
     * 显示图标
     *
     * @type {string}
     * @memberof ITreeNode
     */
    icon: string;
    /**
     * 节点数据
     *
     * @type {*}
     * @memberof ITreeNode
     */
    data: any;
    /**
     * 是否禁用
     *
     * @type {boolean}
     * @memberof ITreeNode
     */
    disabled?: boolean;
    /**
     * 子节点
     *
     * @type {any[]}
     * @memberof ITreeNode
     */
    children?: any[];
}
