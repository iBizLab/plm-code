export interface IActionItem {
    /**
     * 行为类型
     *
     * @type {string}
     * @memberof IActionItem
     */
    type: string;
    /**
     * 行为图标
     *
     * @type {string}
     * @memberof IActionItem
     */
    icon: string;
    /**
     * 提示信息
     *
     * @type {string}
     * @memberof IActionItem
     */
    tooltip?: string;
    /**
     * 默认显示
     *
     * @type {boolean}
     * @memberof IActionItem
     */
    visible?: boolean;
}
