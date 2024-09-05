import { AppDataEntity } from '@ibiz-template/runtime';
export declare class PSDEFormDetail extends AppDataEntity {
    get srftext(): any;
    get srftype(): any;
    set srftype(value: any);
    get srfpkey(): any;
    set srfpkey(value: any);
    get srfordervalue(): any;
    set srfordervalue(value: any);
    /**
     * 克隆数据
     *
     * @author chitanda
     * @date 2022-10-11 00:10:15
     * @return {*}  {PSDEFormDetail}
     */
    clone(): PSDEFormDetail;
}
