import { ControlController, IDRTabController, IDRTabEvent, IDRTabState, IDRTabPagesState, IEditFormController, IPanelItemNavPosController, AppCounter } from '@ibiz-template/runtime';
import { IDEDRCtrlItem, IDEDRTab } from '@ibiz/model-core';
import { Router } from 'vue-router';
/**
 * 数据关系栏控制器
 *
 * @export
 * @class DRTabController
 * @extends {ControlController<IDEDRTab, IDRTabState, IDRTabEvent>}
 * @implements {IDRTabController}
 */
export declare class DRTabController extends ControlController<IDEDRTab, IDRTabState, IDRTabEvent> implements IDRTabController {
    /**
     * 计数器对象
     * @author lxm
     * @date 2024-01-18 05:12:35
     * @type {AppCounter}
     */
    counter?: AppCounter;
    /**
     * 导航占位控制器
     *
     * @readonly
     * @memberof DRTabController
     */
    get navPos(): IPanelItemNavPosController;
    /**
     * 表单部件
     *
     * @readonly
     * @memberof DRTabController
     */
    get form(): IEditFormController;
    /**
     * 路由层级
     *
     * @readonly
     * @type {(number | undefined)}
     * @memberof DRTabController
     */
    get routeDepth(): number | undefined;
    /**
     * Router 对象
     *
     * @type {Router}
     * @memberof DRTabController
     */
    router: Router;
    /**
     * 设置 Router 对象
     *
     * @param {Router} router
     * @memberof DRTabController
     */
    setRouter(router: Router): void;
    /**
     * 获取数据
     *
     * @return {*}  {IData[]}
     * @memberof DRTabController
     */
    getData(): IData[];
    /**
     * 初始化state的属性
     *
     * @protected
     * @memberof DRTabController
     */
    protected initState(): void;
    /**
     * 创建完成
     *
     * @return {*}  {Promise<void>}
     * @memberof DRTabController
     */
    onCreated(): Promise<void>;
    /**
     * 加载完成
     *
     * @return {*}  {Promise<void>}
     * @memberof DRTabController
     */
    onMounted(): Promise<void>;
    /**
     * 处理表单数据变更
     *
     * @memberof DRTabController
     */
    handleFormChange(): void;
    /**
     * 设置关系分页状态
     *
     * @param {IDRTabPagesState[]} drTabPages 关系分页
     * @param {boolean} disabled 禁用状态
     * @memberof DRTabController
     */
    setDRTabPagesState(drTabPages: IDRTabPagesState[], disabled: boolean): void;
    /**
     * 初始化关系分页数据
     *
     * @memberof DRTabController
     */
    initDRTabPages(): void;
    /**
     * 处理分页改变
     *
     * @author lxm
     * @date 2023-12-21 05:31:59
     * @param {boolean} [isRoutePushed=false] 是否是路由已经跳转过了
     */
    handleTabChange(isRoutePushed?: boolean): void;
    /**
     * 设置显示状态
     *
     * @param {('form' | 'navPos')} ctrlName 显示的部件名称
     * @memberof DRTabController
     */
    setVisible(ctrlName: 'form' | 'navPos'): void;
    /**
     * 准备参数
     *
     * @param {IDEDRCtrlItem} drTabPages 关系分页
     * @return {*}
     * @memberof DRTabController
     */
    prepareParams(drTabPages: IDEDRCtrlItem): {
        context: IContext;
        params: IParams;
    };
    /**
     * 打开导航占位视图
     *
     * @author lxm
     * @date 2023-12-21 05:40:07
     * @param {IDEDRCtrlItem} drTabPages
     * @param {boolean} [isRoutePushed=false]
     * @return {*}  {Promise<void>}
     */
    openNavPosView(drTabPages: IDEDRCtrlItem, isRoutePushed?: boolean): Promise<void>;
    /**
     * 初始化计数器
     * @author lxm
     * @date 2024-01-18 05:12:02
     * @protected
     * @return {*}  {Promise<void>}
     */
    protected initCounter(): Promise<void>;
}
