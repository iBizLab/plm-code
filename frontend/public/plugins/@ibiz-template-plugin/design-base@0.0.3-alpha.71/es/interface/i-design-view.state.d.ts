import { IDataEntity, IViewState } from '@ibiz-template/runtime';
export interface IDesignViewState extends IViewState {
    /**
     * 主数据
     *
     * @author tony001
     * @date 2024-09-10 10:09:05
     * @type {IDataEntity}
     */
    data: IDataEntity;
}
