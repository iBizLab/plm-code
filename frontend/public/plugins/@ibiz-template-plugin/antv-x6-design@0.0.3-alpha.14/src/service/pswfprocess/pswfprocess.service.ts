import { DEService, IDataEntity } from '@ibiz-template/runtime';
import { IHttpResponse } from '@ibiz-template/core';

/**
 * 表单项服务对象
 *
 * @author chitanda
 * @date 2024-01-17 11:01:28
 * @export
 * @class PSWFProcessService
 * @extends {DEService}
 */
export class PSWFProcessService extends DEService {
  async exec(
    id: string,
    context: IContext,
    params?: IData | IData[],
    params2?: IParams,
  ): Promise<IHttpResponse<IData>> {
    if (id === 'Create' && params) {
      if (Array.isArray(params)) {
        await Promise.all(
          params.map(item => {
            return this.fillDefault(context, item);
          }),
        );
      } else {
        await this.fillDefault(context, params as IDataEntity);
      }
    }
    return super.exec(id, context, params, params2);
  }

  protected async fillDefault(context: IContext, process: IDataEntity) {
    if (!process.codename) {
      const res = await this.fetchDefault(context);
      if (res.ok) {
        const details = res.data;
        const codeNames = details.map((item: IDataEntity) => item.codename);
        let num = 1;
        let codeName = `${process.wfprocesstype}_0${num}`;
        while (codeNames.includes(codeName)) {
          num += 1;
          codeName = `${process.wfprocesstype}_0${num}`;
        }
        process.codename = codeName;
      }
    }
  }
}
