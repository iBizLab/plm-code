export interface X6PanelItemTableLinkData {
    /**
     * 开始节点
     *
     * @author zhanghengfeng
     * @date 2024-01-25 15:01:21
     * @type {string}
     */
    source: string;
    /**
     * 目标节点
     *
     * @author zhanghengfeng
     * @date 2024-01-25 15:01:38
     * @type {string}
     */
    target: string;
    /**
     * 连线
     *
     * @author zhanghengfeng
     * @date 2024-01-25 15:01:11
     * @type {string}
     */
    link?: string;
    /**
     * 是否已连接
     *
     * @author zhanghengfeng
     * @date 2024-01-25 15:01:57
     * @type {boolean}
     */
    isConnected: boolean;
}
