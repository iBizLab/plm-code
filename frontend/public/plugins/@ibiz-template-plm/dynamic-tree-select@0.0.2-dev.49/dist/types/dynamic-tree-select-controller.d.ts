import { IHttpResponse } from '@ibiz-template/core';
import { EditorController, IViewConfig } from '@ibiz-template/runtime';
import { IAppDEACMode, IDEACModeDataItem, IPicker } from '@ibiz/model-core';
export declare class DynamicTreeSelectController extends EditorController<IPicker> {
    /**
     * 是否多选
     */
    multiple: boolean;
    /**
     *选择视图相关参数
     */
    pickupView: IViewConfig | null;
    /**
     *链接视图相关参数
     */
    linkView: IViewConfig | null;
    /**
     *值项
     */
    valueItem: string;
    /**
     * 主键属性名称
     */
    keyName: string;
    /**
     * 主文本属性名称
     */
    textName: string;
    /**
     * 数据集codeName
     */
    interfaceName: string;
    /**
     * 自填模式sort排序
     */
    sort: string | undefined;
    /**
     * 不支持AC（根据编辑器类型得）
     */
    noAC: boolean;
    /**
     * 不支持按钮（根据编辑器类型得）
     */
    noButton: boolean;
    /**
     * 实体自填模式模型
     */
    deACMode: IAppDEACMode | undefined;
    /**
     * 自填数据项集合（已排除了value和text)
     */
    dataItems: IDEACModeDataItem[];
    objectIdField: string | undefined;
    objectNameField: string | undefined;
    objectValueField: string | undefined;
    filterMap: IData;
    copyData: IData[];
    url: string;
    method: 'post' | 'get';
    pvalue: string;
    protected onInit(): Promise<void>;
    /**
     * 初始化noAc和noButton
     */
    initParams(): void;
    /**
     * 加载实体数据集数据
     *
     * @param {string} query 模糊匹配字符串
     * @param {IData} data 表单数据
     * @returns {*}  {Promise<IHttpResponse<IData[]>>}
     * @memberof PickerEditorController
     */
    getServiceData(query: string, data: IData): Promise<IHttpResponse<IData[]>>;
    /**
     * 计算回填数据
     *
     * @author lxm
     * @date 2022-10-24 16:10:24
     * @param {IData} data 选中数据
     * @returns {*}  {Promise<Array<{ id: string; value: any }>>}
     */
    calcFillDataItems(data: IData): Promise<Array<{
        id: string;
        value: any;
    }>>;
    /**
     * 处理对象数据类型抛值
     * @param {IData} select
     * @return {*}
     * @author: zhujiamin
     * @Date: 2023-08-22 15:58:56
     */
    handleObjectParams(select: IData): IData;
    /**
     * 处理请求回来的数据
     * @param items 数据源
     */
    handleTreeData(res: IData): any;
    /**
     * 组装树形数据
     * @param items
     * @returns
     */
    protected prepareTreeData(items: IData[]): IData[];
}
