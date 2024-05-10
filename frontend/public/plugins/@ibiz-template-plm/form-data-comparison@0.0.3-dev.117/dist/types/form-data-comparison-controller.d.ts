import { IPortalMessage } from '@ibiz-template/core';
import { DataChangeEvent, EditFormService, FormController, FormSaveParams, IDataAbilityParams, IEditFormController, IEditFormEvent, IEditFormState, IEditViewEvent, IEditViewState, IViewController } from '@ibiz-template/runtime';
import { IAppDEEditView, IDEEditForm, IDEFormDetail } from '@ibiz/model-core';
export declare class FormDataComparisonController extends FormController<IDEEditForm, IEditFormState, IEditFormEvent> implements IEditFormController {
    /**
     * 编辑表单服务
     * @author lxm
     * @date 2023-05-15 11:03:34
     * @type {EditFormService}
     */
    service: EditFormService;
    get view(): IViewController<IAppDEEditView, IEditViewState, IEditViewEvent>;
    /**
     *   基础数据
     *
     * @author fangZhiHao
     * @date 2024-04-26 17:04:49
     * @type {IData}
     */
    baseResData: IData;
    /**
     *   对比数据
     *
     * @author fangZhiHao
     * @date 2024-04-26 17:04:49
     * @type {IData}
     */
    compareResData: IData;
    /**
     * 表单旧数据
     *
     * @author zk
     * @date 2023-12-20 11:12:43
     * @protected
     * @type {IData}
     * @memberof FormController
     */
    protected oldData: IData;
    /**
     * 初始化方法
     *
     * @author lxm
     * @date 2022-08-22 22:08:16
     * @protected
     * @returns {*}  {Promise<void>}
     */
    protected onCreated(): Promise<void>;
    /**
     * version数据
     *
     * @author fangZhiHao
     * @date 2024-04-26 16:04:37
     * @type {IData[]}
     */
    versionData: IData[];
    /**
     *  对比数据
     *
     * @author fangZhiHao
     * @date 2024-04-26 16:04:37
     * @type {IData[]}
     */
    comparisonArr: IData;
    /**
     *  关系界面数据
     *
     * @author fangZhiHao
     * @date 2024-04-30 10:04:33
     * @type {IData}
     */
    AlldruipartData: Map<any, any>;
    getVersion(): Promise<void>;
    gridData: IData[];
    AllGridData: IData[];
    removeSameGridData: IData[];
    protected onMounted(): Promise<void>;
    /**
     *  设置关系界面数据
     *
     * @author fangZhiHao
     * @date 2024-04-30 10:04:15
     * @param {string} version
     * @param {string} name
     * @param {IData} data
     */
    calcAlldruipartData(version: string, name: string, data: IData): void;
    druipartDataSize: number;
    newDruipartData: IData;
    setdruipartData(args: DataChangeEvent): void;
    duripartDifference(): IData;
    /**
     *  计算duriput样式
     *
     * @author fangZhiHao
     * @date 2024-04-26 18:04:56
     * @param {IData[]} data
     */
    calcCategorduriptData(data: IData[], result: IData): void;
    caleduriptCategory(codeName: string, result: IData): "added" | "modified" | "deleted" | "samed";
    /**
     *  计算属性类别
     *
     * @author fangZhiHao
     * @date 2024-04-26 18:04:42
     * @param {string} codeName
     * @return {*}
     */
    caleCategory(codeName: string): "added" | "modified" | "deleted" | "samed";
    /**
     *  计算表单分组
     *
     * @author fangZhiHao
     * @date 2024-04-26 18:04:07
     * @param {IDEFormDetail[]} data
     * @return {*}
     */
    calcGroupPanel(data: IDEFormDetail[]): IData[];
    /**
     *  计算表格
     *
     * @author fangZhiHao
     * @date 2024-04-26 18:04:07
     * @param {IDEFormDetail[]} data
     * @return {*}
     */
    calcGridData(data: IDEFormDetail[]): void;
    /**
     *  计算类别样式
     *
     * @author fangZhiHao
     * @date 2024-04-26 18:04:56
     * @param {IData[]} data
     */
    calcCategoryGridData(data: IData[]): void;
    /**
     *  去除相同项
     *
     * @author fangZhiHao
     * @date 2024-04-26 18:04:56
     * @param {IData[]} data
     */
    removeSame(data: IData[]): IData[];
    /**
     * 加载草稿行为
     * @author lxm
     * @date 2023-08-25 02:45:11
     * @return {*}  {Promise<IData>}
     */
    loadDraft(args?: IDataAbilityParams): Promise<IData>;
    /**
     * 拷贝模式加载数据
     *
     * @author chitanda
     * @date 2023-09-26 19:09:21
     * @return {*}  {Promise<IData>}
     */
    protected copy(): Promise<IData>;
    isFalseyButNotEmpty(value: string | IData[] | null | undefined): boolean;
    compareObjectValues(objA: IData, objB: IData): boolean;
    /**
     *  判断两个对象的差异
     *
     * @author fangZhiHao
     * @date 2024-04-26 13:04:59
     * @param {IData} oldObj
     * @param {IData} newObj
     * @return {*}
     */
    diffObjects(oldObj: IData, newObj: IData): {
        added: string[];
        modified: string[];
        deleted: string[];
    };
    /**
     * 部件加载数据行为
     *
     * @author lxm
     * @date 2022-08-19 14:08:50
     */
    load(args?: IDataAbilityParams): Promise<IData>;
    /**
     * 保存表单数据
     *
     * @author lxm
     * @date 2022-08-31 22:08:40
     */
    save(args?: FormSaveParams): Promise<IData>;
    /**
     * 删除表单数据
     *
     * @author lxm
     * @date 2022-09-01 09:09:36
     * @returns {*}
     */
    remove(args?: IDataAbilityParams): Promise<boolean>;
    /**
     * 执行返回行为
     *
     * @author lxm
     * @date 2022-09-01 09:09:36
     * @returns {*}
     */
    goBack(): Promise<IData>;
    /**
     * 表单项更新
     *
     * @author lxm
     * @date 2022-09-15 21:09:13
     * @param {string} methodName 更新实体方法
     * @param {string[]} updateItems 更新项名称集合
     */
    updateFormItem(formItemUpdateId: string): Promise<void>;
    /**
     * 工作流启动(调用前先确保调用保存)
     *
     * @author lxm
     * @date 2022-10-08 18:10:41
     * @param {IParams} [extraParams={}] 不走工作流启动视图时使用
     * @returns {*}  {Promise<void>}
     */
    wfStart(args?: IDataAbilityParams): Promise<void>;
    /**
     * 工作流提交(调用前先确保调用保存)
     *
     * @author lxm
     * @date 2022-10-08 18:10:56
     * @param {IParams} [extraParams={}] 不走工作流操作视图时使用
     * @returns {*}  {Promise<void>}
     */
    wfSubmit(args?: IDataAbilityParams): Promise<void>;
    dataChangeNotify(names: string[]): Promise<void>;
    /**
     * 自动保存
     * @author lxm
     * @date 2023-08-23 05:44:48
     * @return {*}  {Promise<void>}
     */
    autoSave(): Promise<void>;
    /**
     * 比较旧数据跟当前数据的差异返回差异数据
     *
     * @author zk
     * @date 2023-12-20 10:12:06
     * @protected
     * @return {*}  {IData}
     * @memberof EditFormController
     */
    protected getDiffData(): IData;
    /**
     * 设置simple模式的数据
     * @author lxm
     * @date 2023-11-22 07:11:21
     * @param {IData} data
     */
    setSimpleData(data: IData): void;
    /**
     * 检测实体数据变更
     *
     * @author tony001
     * @date 2024-03-28 18:03:14
     * @protected
     * @param {IPortalMessage} msg
     * @return {*}  {void}
     */
    protected onDEDataChange(msg: IPortalMessage): void;
}
