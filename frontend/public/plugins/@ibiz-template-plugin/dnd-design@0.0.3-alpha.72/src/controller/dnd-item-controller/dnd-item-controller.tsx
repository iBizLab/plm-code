import { IDataEntity } from '@ibiz-template/runtime';
import { IDEForm } from '@ibiz/model-core';
import { clone } from 'lodash-es';
import {
  IActionItem,
  IDndDesignPanelItemController,
  IDndItemController,
} from '../../interface';
import { SelectState } from '../../utils';
import { resource } from '../../global';

/**
 * 拖拽项控制器
 *
 * @author chitanda
 * @date 2023-12-15 17:12:39
 * @export
 * @class DndItemController
 */
export class DndItemController implements IDndItemController {
  protected model!: IDEForm;

  readonly select!: SelectState<IData>;

  actions: IActionItem[] = [
    {
      icon: (
        <ion-icon src={resource.dir('./assets/svg/lightning.svg')}></ion-icon>
      ),
      text: '表单项逻辑',
      tooltip: '表单项逻辑',
      command: 'logic',
    },
    {
      icon: <ion-icon name='trash-outline'></ion-icon>,
      text: '删除',
      tooltip: '删除',
      command: 'delete',
    },
  ];

  constructor(
    protected c: IDndDesignPanelItemController,
    model: IDEForm,
    public data: IDataEntity,
  ) {
    this.model = model;
    this.select = c.view.select;
  }

  async onAction(_action: IActionItem): Promise<boolean> {
    return false;
  }

  destroy(): void {
    // todo
  }

  change(evt: IData, items: IDataEntity[], parent?: IDataEntity): void {
    this.c.change(evt, items, parent);
  }

  async remove(items: IDataEntity[], item: IDataEntity): Promise<boolean> {
    return this.c.remove(items, item);
  }

  getItemCaption(): string {
    const preViewProvider = this.c.view.getPreViewProvider();
    let data = clone(this.data);
    if (preViewProvider && this.data) {
      data = preViewProvider.getTargetDataBySourceData('FORMDETAIL', [
        data,
      ])[0] as IDataEntity;
    }
    return data.caption;
  }
}
