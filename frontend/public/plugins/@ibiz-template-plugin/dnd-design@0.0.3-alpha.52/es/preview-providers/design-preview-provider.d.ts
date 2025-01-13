import { IViewController } from '@ibiz-template/runtime';
import { IPreviewProvider } from '../interface';
export declare class DndDesignPreViewProvider implements IPreviewProvider {
    /**
     * 界面模式集合
     *
     * @author tony001
     * @date 2024-09-06 15:09:40
     * @type {IData[]}
     */
    uiModes: IData[];
    /**
     * 属性字段集合
     *
     * @author tony001
     * @date 2024-09-06 15:09:56
     * @type {IData[]}
     */
    fields: IData[];
    /**
     * 初始化
     *
     * @author tony001
     * @date 2024-09-06 15:09:09
     * @param {IViewController} view
     * @return {*}  {Promise<void>}
     */
    init(view: IViewController): Promise<void>;
    /**
     * 查找指定项界面模式
     *
     * @author tony001
     * @date 2024-09-06 15:09:39
     * @protected
     * @param {IData} item
     * @return {*}  {(IData | undefined)}
     */
    protected findUIMode(item: IData): IData | undefined;
    /**
     * 获取表单项预览数据
     *
     * @author tony001
     * @date 2024-09-06 15:09:06
     * @private
     * @param {IData} item
     * @return {*}  {IData}
     */
    private getFormItemPreviewData;
    /**
     * 通过源数据获取目标数据
     *
     * @author tony001
     * @date 2024-09-06 15:09:27
     * @param {('FORMDETAIL' | string)} type
     * @param {IData[]} source
     * @return {*}  {IData[]}
     */
    getTargetDataBySourceData(type: 'FORMDETAIL' | string, source: IData[]): IData[];
    getPropertyByTag(tag: string): IData[];
}
