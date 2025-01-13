import { IAppDEService } from '@ibiz-template/runtime';
export declare class LinkUtil {
    /**
     * 根据源节点获取连线类型
     *
     * @author zhanghengfeng
     * @date 2023-12-07 09:12:26
     * @param {IContext} context
     * @param {IAppDEService} service
     * @return {*}
     */
    getLinkType(context: IContext, service: IAppDEService): Promise<"IAACTION" | "WFRETURN" | "ROUTE">;
    /**
     * 根据连线类型获取默认连线名称
     *
     * @author zhanghengfeng
     * @date 2023-12-07 09:12:07
     * @param {IContext} context
     * @param {string} type
     * @param {IAppDEService} service
     * @return {*}
     */
    getLinkName(context: IContext, type: string, service: IAppDEService): Promise<string>;
    /**
     * 改变连接桩显示状态
     *
     * @author zhanghengfeng
     * @date 2024-01-22 18:01:11
     * @param {boolean} visible
     * @param {HTMLElement} container
     * @return {*}  {void}
     */
    changePortsVisible(visible: boolean, container: HTMLElement): void;
    /**
     * 生成切换按钮Markup
     *
     * @author zhanghengfeng
     * @date 2024-01-31 18:01:20
     * @param {{
     *       svg_shift_wrapper: string;
     *       svg_shift1: string;
     *       svg_shift2: string;
     *     }} className
     * @param {boolean} status
     * @return {*}  {Record<string, unknown>[]}
     */
    generateShiftButtonMarkup(className: {
        svg_shift_wrapper: string;
        svg_shift1: string;
        svg_shift2: string;
    }, status: boolean): Record<string, unknown>[];
}
export declare const linkUtil: LinkUtil;
