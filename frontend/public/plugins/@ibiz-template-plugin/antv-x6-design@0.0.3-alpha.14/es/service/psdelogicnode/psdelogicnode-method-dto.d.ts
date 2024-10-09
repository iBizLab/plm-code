import { IDataEntity, MethodDto } from '@ibiz-template/runtime';
export declare class PSDELogicMethodDto extends MethodDto {
    condDto?: MethodDto;
    get(context: IContext, data: IData, ignore?: boolean): Promise<IData>;
    sets(context: IContext, data: IData[]): Promise<IDataEntity[]>;
    protected getCondDto(context: IContext): Promise<MethodDto>;
    /**
     * 递归计算当前 DTO 相关实体的父关系配置
     *
     * @author chitanda
     * @date 2023-12-26 16:12:13
     * @param {IContext} context
     * @param {number} [depth=0] 递归层级，避免进入死循环。最大递归层级为 10
     * @return {*}  {Promise<void>}
     */
    calcRs(context: IContext, depth?: number): Promise<void>;
}
