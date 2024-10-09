/* eslint-disable array-callback-return */
/* eslint-disable @typescript-eslint/no-unused-vars */
import { isNilOrEmpty, notNilEmpty } from 'qx-util';
import { getControl, IViewController } from '@ibiz-template/runtime';
import { IAppView } from '@ibiz/model-core';
import { IPreviewProvider } from '../interface';

export class DndDesignPreViewProvider implements IPreviewProvider {
  /**
   * 界面模式集合
   *
   * @author tony001
   * @date 2024-09-06 15:09:40
   * @type {IData[]}
   */
  uiModes: IData[] = [];

  /**
   * 属性字段集合
   *
   * @author tony001
   * @date 2024-09-06 15:09:56
   * @type {IData[]}
   */
  fields: IData[] = [];

  /**
   * 初始化
   *
   * @author tony001
   * @date 2024-09-06 15:09:09
   * @param {IViewController} view
   * @return {*}  {Promise<void>}
   */
  async init(view: IViewController): Promise<void> {
    const viewModel: IAppView = view.model;
    const app = ibiz.hub.getApp(viewModel.appId);
    const psdeid = view.context.psdataentity;
    // 根据uimode接口表单初始化界面模式服务
    const uimode = getControl(viewModel, 'uimode');
    if (uimode) {
      const uiModeService = await app.deService.getService(
        view.context,
        uimode.appDataEntityId!,
      );
      const uiModeResult = await uiModeService.fetchDefault(view.context, {
        n_psdeid_eq: psdeid,
        size: 1000,
      });
      if (uiModeResult.ok && uiModeResult.data) {
        this.uiModes = uiModeResult.data as IData[];
      }
    }
    // 根据field接口表单初始化实体属性服务
    const field = getControl(viewModel, 'field');
    if (field) {
      const deFieldService = await app.deService.getService(
        view.context,
        field.appDataEntityId!,
      );
      const deFieldResult = await deFieldService.fetchDefault(view.context, {
        size: 1000,
      });
      if (deFieldResult.ok && deFieldResult.data) {
        this.fields = deFieldResult.data as IData[];
      }
    }
  }

  /**
   * 查找指定项界面模式
   *
   * @author tony001
   * @date 2024-09-06 15:09:39
   * @protected
   * @param {IData} item
   * @return {*}  {(IData | undefined)}
   */
  protected findUIMode(item: IData): IData | undefined {
    const psdefuimode = this.uiModes.find((uiModel: IData) => {
      if (uiModel.psdefid === item.psdefid) {
        return uiModel;
      }
    });
    return psdefuimode;
  }

  /**
   * 获取表单项预览数据
   *
   * @author tony001
   * @date 2024-09-06 15:09:06
   * @private
   * @param {IData} item
   * @return {*}  {IData}
   */
  private getFormItemPreviewData(item: IData): IData {
    if (
      item.detailtype === 'FORMITEM' &&
      item.formtype === 'SEARCHFORM' &&
      !item.caption &&
      item.logicname
    ) {
      item.caption = item.logicname;
    }

    if (item.detailtype === 'FORMITEM' && notNilEmpty(item.psdefid)) {
      // 查找界面模式，根据界面模式填充一些属性数据用于预览
      const psDEFUIMode = this.findUIMode(item);
      if (psDEFUIMode) {
        if (isNilOrEmpty(item.caption) && psDEFUIMode.caption) {
          item.caption = psDEFUIMode.caption;
        }
        if (isNilOrEmpty(item.editortype) && psDEFUIMode.editortype) {
          item.editortype = psDEFUIMode.editortype;
        }
        if (isNilOrEmpty(item.ctrlheight) && psDEFUIMode.ctrlheight) {
          item.ctrlheight = psDEFUIMode.ctrlheight;
        }
        if (isNilOrEmpty(item.ctrlwidth) && psDEFUIMode.ctrlwidth) {
          item.ctrlwidth = psDEFUIMode.ctrlwidth;
        }
      }
      if (!isNilOrEmpty(item.editortype) && !isNilOrEmpty(item.caption)) {
        return item;
      }

      const psDEField = this.fields.find((psdefield: IData) => {
        if (psdefield.psdefieldid === item.psdefid) {
          return psdefield;
        }
      })!;
      if (psDEField) {
        if (isNilOrEmpty(item.caption)) {
          item.caption = psDEField.logicname;
        }
      }
    }

    return item;
  }

  /**
   * 通过源数据获取目标数据
   *
   * @author tony001
   * @date 2024-09-06 15:09:27
   * @param {('FORMDETAIL' | string)} type
   * @param {IData[]} source
   * @return {*}  {IData[]}
   */
  public getTargetDataBySourceData(
    type: 'FORMDETAIL' | string,
    source: IData[],
  ): IData[] {
    if (type === 'FORMDETAIL') {
      return source.map(item => {
        return this.getFormItemPreviewData(item);
      });
    }
    return source;
  }
}
