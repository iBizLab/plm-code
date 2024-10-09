import { DEService, IDataEntity } from '@ibiz-template/runtime';
import { isNilOrEmpty, notNilEmpty } from 'qx-util';
import { IHttpResponse } from '@ibiz-template/core';
import { PSDEFormDetail } from '../../entity';

/**
 * 表单项服务对象
 *
 * @author chitanda
 * @date 2023-12-23 18:12:50
 * @export
 * @class PSDEFormDetailService
 * @extends {DEService}
 */
export class PSDEFormDetailService extends DEService {
  async exec(
    id: string,
    context: IContext,
    params?: PSDEFormDetail | PSDEFormDetail[],
    params2?: IParams,
  ): Promise<IHttpResponse<IData>> {
    if (id === 'Create' && params) {
      if (Array.isArray(params)) {
        await Promise.all(
          params.map(item => {
            return this.calcDefault(context, item);
          }),
        );
      } else {
        await this.calcDefault(context, params);
      }
    }
    return super.exec(id, context, params, params2);
  }

  protected async calcDefault(
    context: IContext,
    entity: PSDEFormDetail,
  ): Promise<void> {
    // 填充默认名称
    let nStartIndex = 1;
    const strDetailType = entity.detailtype;
    let strRootName: string = strDetailType!;
    if (strDetailType === 'FORMITEM') {
      nStartIndex = 0;
      // 表单项
      strRootName = entity.detailtype;
      if (entity.psdefname) {
        strRootName = entity.psdefname;
      }
      if (entity.formtype === 'SEARCHFORM') {
        strRootName = entity.psdefsfitemname;
      }
      if (isNilOrEmpty(strRootName)) {
        strRootName = entity.srfdecodename!;
      }
    }
    if (isNilOrEmpty(strRootName)) {
      return;
    }

    strRootName = strRootName.toLowerCase();
    const res = await this.fetchTempDefault(context);
    if (res.ok && res.data) {
      const details = res.data as PSDEFormDetail[];
      const detailMap: Map<string, PSDEFormDetail> = new Map();
      const detailMap2: Map<string, PSDEFormDetail> = new Map();
      details.forEach(item => {
        if (notNilEmpty(item.psdeformdetailname)) {
          detailMap.set(item.psdeformdetailname.toLowerCase(), item);
        }
        if (notNilEmpty(item.psdeformdetailid)) {
          detailMap2.set(item.psdeformdetailid.toLowerCase(), item);
        }
      });
      // eslint-disable-next-line no-constant-condition
      while (true) {
        const strDefaultName =
          strRootName + (nStartIndex === 0 ? '' : nStartIndex);
        if (!detailMap.has(strDefaultName) && !detailMap2.has(strDefaultName)) {
          entity.psdeformdetailname = strDefaultName;
          entity.psdeformdetailid = strDefaultName;
          break;
        }
        nStartIndex += 1;
      }
    }

    // 填充 logicname
    if (isNilOrEmpty(entity.srfdecodename) && isNilOrEmpty(entity.logicname)) {
      if (strDetailType === 'FORMPAGE') {
        entity.logicname = '表单分页';
      } else if (strDetailType === 'GROUPPANEL') {
        entity.logicname = '分组面板';
      } else if (strDetailType === 'TABPAGE') {
        entity.logicname = '分页';
      } else if (strDetailType === 'BUTTON') {
        entity.logicname = '按钮';
      } else if (strDetailType === 'USERCONTROL') {
        entity.logicname = '自定义部件';
      } else if (strDetailType === 'RAWITEM') {
        entity.logicname = '直接内容';
      } else if (strDetailType === 'DRUIPART') {
        entity.logicname = '关系界面';
      } else if (strDetailType === 'FORMITEM') {
        entity.logicname = '表单项';
      } else if (strDetailType === 'FORMITEMEX') {
        entity.logicname = '复合表单项';
      } else if (strDetailType === 'FORMPART') {
        entity.logicname = '表单部件';
      } else if (strDetailType === 'IFRAME') {
        entity.logicname = '嵌入页面(iframe)';
      } else if (strDetailType === 'TABPANEL') {
        entity.logicname = '分页面板';
      } else if (strDetailType === 'DATAGRID') {
        entity.logicname = '数据表格';
      }
    }
  }

  protected newEntity(data: IData | IDataEntity): IDataEntity {
    if (data instanceof PSDEFormDetail) {
      return data.clone();
    }
    return new PSDEFormDetail(this.model, data);
  }
}
