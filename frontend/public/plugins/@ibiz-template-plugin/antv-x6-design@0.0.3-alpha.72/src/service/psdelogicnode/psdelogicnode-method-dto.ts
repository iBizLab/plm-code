/* eslint-disable no-await-in-loop */
import { RuntimeError, clone, recursiveIterate } from '@ibiz-template/core';
import { IDataEntity, MethodDto, findModelChild } from '@ibiz-template/runtime';

export class PSDELogicMethodDto extends MethodDto {
  condDto?: MethodDto;

  async get(
    context: IContext,
    data: IData,
    ignore: boolean = false,
  ): Promise<IData> {
    const _context = clone(context);

    if (data.psdelogicnodeid) {
      _context.psdelogicnode = data.psdelogicnodeid;
    }

    const result = await super.get(_context, data, ignore);

    const dto = await this.getCondDto(_context);

    const service = await this.app!.deService.getService(
      _context,
      'dataflowdesign.psdedfjoincond',
    );

    const res = await service.exec('FetchCurRootItems', _context, data);

    const items = res.data;

    // 写入数据的字段
    const writeKey =
      result.logicnodetype === 'DFJOINPROCESS' ? 'param5' : 'param6';

    if (items.length) {
      const arr = [];
      for (let j = 0; j < items.length; j++) {
        arr.push(await dto.get(_context, items[j], true));
      }

      result[writeKey] = JSON.stringify({
        op: 'AND',
        type: 'GROUP',
        items: arr,
      });
    } else {
      result[writeKey] = null;
    }

    return result;
  }

  async sets(context: IContext, data: IData[]): Promise<IDataEntity[]> {
    const dto = await this.getCondDto(context);
    await Promise.all(
      data.map(async datum => {
        const condstr = datum.param6 || datum.param5;
        let items: IData[] = [];
        try {
          items = condstr ? JSON.parse(condstr)?.items : [];
        } catch (error) {
          ibiz.log.error(error);
        }

        if (items && items.length > 0) {
          // !预处理，psdelogicnodeid会变，所以统一内部所有数据的psdelogicnodeid
          const pKey = datum.psdelogicnodeid;
          recursiveIterate(
            { items },
            (item: IData) => {
              item.psdelogicnodeid = pKey;
            },
            {
              childrenFields: ['items'],
            },
          );

          // 特殊处理，在子包内设置父对象标识
          items.forEach(item => {
            item.psdelogicnodeid = pKey;
          });
          await dto.sets(context, items);
        } else {
          await dto.sets(context, []);
        }
      }),
    );
    const arr = await super.sets(context, data);
    return arr;
  }

  protected async getCondDto(context: IContext): Promise<MethodDto> {
    if (this.condDto) {
      return this.condDto;
    }

    const service = await this.app!.deService.getService(
      context,
      'dataflowdesign.psdedfjoincond',
    );
    service.isLocalMode = true;

    const methodDto = findModelChild(
      (service as IData).model.appDEMethodDTOs || [],
      'psdedfjoinconddto',
    )!;

    if (!methodDto) {
      throw new RuntimeError('没有找到psdedfjoinconddto');
    }
    const dto = service.createMethodDto(methodDto, {
      isLocalMode: true,
    });
    this.condDto = dto;

    return dto;
  }

  /**
   * 递归计算当前 DTO 相关实体的父关系配置
   *
   * @author chitanda
   * @date 2023-12-26 16:12:13
   * @param {IContext} context
   * @param {number} [depth=0] 递归层级，避免进入死循环。最大递归层级为 10
   * @return {*}  {Promise<void>}
   */
  async calcRs(context: IContext, depth: number = 0): Promise<void> {
    await super.calcRs(context, depth);

    if (depth === 0) {
      await this.getCondDto(context);
    }
  }
}
