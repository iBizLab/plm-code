import { AppDataEntity } from '@ibiz-template/runtime';
import { IAppDataEntity, ICodeItem, ISysImage } from '@ibiz/model-core';
export declare class PSDEDFJoinCond extends AppDataEntity {
    _typeCodeItems: ICodeItem[];
    constructor(entity: IAppDataEntity, data: IData | PSDEDFJoinCond, typeCodeItems: ICodeItem[]);
    /**
     * 显示文本
     * @author lxm
     * @date 2023-12-27 05:20:00
     * @readonly
     */
    get srftext(): string;
    /**
     * 类型
     * @author lxm
     * @date 2023-12-27 05:20:06
     */
    get srftype(): any;
    set srftype(value: any);
    get srficon(): ISysImage | undefined;
    /**
     * 是否允许拖入
     * @author lxm
     * @date 2023-12-27 04:27:57
     * @readonly
     */
    get srfallowdrop(): boolean;
    /**
     * 克隆数据
     *
     * @author chitanda
     * @date 2022-10-11 00:10:15
     * @return {*}  {PSDEDFJoinCond}
     */
    clone(): PSDEDFJoinCond;
}
