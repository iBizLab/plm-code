import { RuntimeModelError } from '@ibiz-template/core';
import {
  ITreeNodeData,
  MDCtrlLoadParams,
  MDCtrlRemoveParams,
  TreeController,
  UIActionUtil,
} from '@ibiz-template/runtime';
import { IDETreeDataSetNode, IDETreeStaticNode } from '@ibiz/model-core';
import { isNil } from 'lodash-es';
import { LogicDesignTreeService } from './tree.service';

export class LogicTreeDesignTreeController extends TreeController {
  declare service: LogicDesignTreeService;

  protected async initService(): Promise<void> {
    this.service = new LogicDesignTreeService(this.model);
    await this.service.init(this.context);
  }

  /**
   * @description 下一步选中数据
   * @type {string}
   * @memberof LogicTreeDesignTreeController
   */
  toSelectSrfkey: string = '';

  /**
   * @description 设置下一步选中数据
   * @memberof LogicTreeDesignTreeController
   */
  setToSelectData() {
    if (!this.toSelectSrfkey) {
      return;
    }
    const toActiveNode = this.state.items.find(
      item => item.srfkey === this.toSelectSrfkey,
    );
    if (toActiveNode) {
      // eslint-disable-next-line @typescript-eslint/no-explicit-any
      this.onTreeNodeClick(toActiveNode, {} as any);
      this.toSelectSrfkey = '';
    }
  }

  protected async onCreated(): Promise<void> {
    this.model.detreeNodes?.forEach((node: IDETreeStaticNode) => {
      if (node.rootNode) {
        node.allowDrop = true;
      }
    });
    await super.onCreated();
  }

  async afterLoad(args: MDCtrlLoadParams, items: IData[]): Promise<IData[]> {
    this.setToSelectData();
    return items;
  }

  /**
   * 当数据放生变更时，若为当前应用实体数据。则多数据部件进行刷新
   *
   * @author chitanda
   * @date 2023-09-13 17:09:04
   * @protected
   * @param {IData} msg
   */
  protected onDataChange(msg: IData): void {
    if (msg.data && msg.data.srfdecodename === this.dataEntity.codeName) {
      if (this.state.activated) {
        const findNode = this.state.items.find(
          item => item.srfkey === msg.data.srfkey,
        );
        if (findNode) {
          findNode._deData = msg.data;
        }
      }
    }
  }

  calcAllowDrop(
    draggingNode: ITreeNodeData,
    dropNode: ITreeNodeData,
    type: 'inner' | 'prev' | 'next',
  ): boolean {
    // 如果被拖入的节点是实体节点，且有srfallowdrop属性，能否拖入看这个属性
    const dropInNode = type === 'inner' ? dropNode : dropNode._parent!;
    if (dropInNode?._deData && !isNil(dropInNode._deData.srfallowdrop)) {
      return dropInNode._deData.srfallowdrop;
    }
    const result = super.calcAllowDrop(draggingNode, dropNode, type);
    return result;
  }

  async onNodeDrop(
    draggingNode: ITreeNodeData,
    dropNode: ITreeNodeData,
    dropType: 'inner' | 'prev' | 'next',
  ): Promise<void> {
    if (
      dropType === 'inner' &&
      !dropNode._leaf &&
      dropNode._children === undefined
    ) {
      await this.expandNodeByKey([dropNode._id]);
    }

    /** 修改的树节点数据 */
    const modifiedNodeDatas: ITreeNodeData[] = [];
    const draggingNodeModel = this.getNodeModel(draggingNode._nodeId)!;
    const dropInNode = dropType === 'inner' ? dropNode : dropNode._parent!;
    const isChangedParent = dropNode?._id !== draggingNode._parent?._id;
    let orderNodeModel = this.getNodeModel(dropNode._nodeId)!;

    // * 处理切换父节点
    if (
      dropType === 'inner' ||
      dropNode._parent?._id !== draggingNode._parent?._id
    ) {
      const dropNodeRs = this.findDropNodeRS(
        dropInNode._nodeId,
        draggingNodeModel.appDataEntityId!,
      );
      if (dropNodeRs) {
        // 修改关系属性的值为父节点的主键和树节点id
        draggingNode._deData![dropNodeRs.pickupDEFName] = isNil(
          dropInNode._value,
        )
          ? null
          : dropInNode._value;
        modifiedNodeDatas.push(draggingNode);
        orderNodeModel = this.getNodeModel(dropNodeRs.childDETreeNodeId)!;
      }
    }

    // *修改节点数据
    // 所有情况都先从原来的父的子集合里删除自己
    const originArr = draggingNode._parent!._children!;
    originArr.splice(originArr.indexOf(draggingNode), 1);

    if (dropType === 'inner') {
      // 移入时放到最后
      if (!dropNode._children) {
        dropNode._children = [];
        dropNode._leaf = true;
        this.state.expandedKeys.push(dropNode._id);
      }

      dropNode._children.push(draggingNode);
    } else {
      // 非插入时，放入指定节点前后
      let insertIndex = dropInNode._children!.indexOf(dropNode);
      if (dropType === 'next') {
        insertIndex += 1;
      }
      dropInNode._children!.splice(insertIndex, 0, draggingNode);
    }

    //* 变更父节点后的，拖动节点调整
    if (dropType === 'inner' || isChangedParent) {
      // 更改父节点
      draggingNode._parent = dropInNode;
      // 修改指向的节点模型
      draggingNode._nodeId = orderNodeModel.id!;
      // 维护拖拽的节点和其子孙的展开，维护拖入节点的展开
      this.state.expandedKeys = this.calcExpandedKeys([dropInNode]);
    }

    // *处理排序
    const { sortAppDEFieldId, sortDir, allowOrder } =
      orderNodeModel as IDETreeDataSetNode;
    if (allowOrder === true) {
      // 有排序属性才处理排序
      if (!sortAppDEFieldId) {
        throw new RuntimeModelError(orderNodeModel, '缺少配置排序属性');
      }
      const sortField = sortAppDEFieldId.toLowerCase();
      const isAsc = sortDir === 'ASC';

      const changedArr = [...dropInNode._children!];

      // 降序把数组反转,保证两个数组都是从小到大排
      if (!isAsc) {
        changedArr.reverse();
      }

      /**
       * 获取下一个100的倍数
       * @author lxm
       * @date 2023-09-11 10:03:46
       * @param {number} num
       * @return {*}  {number}
       */
      const getNextSort = (num: number): number => {
        return num + (100 - (num % 100));
      };

      const getSort = (deData: IData): number => {
        return (deData[sortField] as number) || 0;
      };

      let lastSort: number;
      changedArr.forEach((item, index) => {
        const deData = item._deData!;
        if (lastSort === undefined) {
          // 第一次出现要调整顺序的时候一定是从拖拽节点开始
          if (item === draggingNode) {
            // 如果时第一个，则排序值为100
            if (index === 0) {
              lastSort = 100;
            } else {
              // 最后一个时，把前一个的排序值加100
              lastSort = getNextSort(getSort(changedArr[index - 1]._deData!));
            }
            deData[sortField] = lastSort;

            // 修改父的时候可能已经加入进去了
            if (modifiedNodeDatas.indexOf(item) === -1) {
              modifiedNodeDatas.push(item);
            }
          }
        } else {
          if (lastSort >= getSort(deData)) {
            deData[sortField] = getNextSort(lastSort);
            modifiedNodeDatas.push(item);
          }
          // 更新上一个排序值
          lastSort = getSort(deData);
        }
      });
    }

    await this.updateDeNodeData(modifiedNodeDatas);

    // *通知界面修改移入的父节点的子节点数据
    this._evt.emit('onAfterNodeDrop', { isChangedParent });
  }

  /**
   * 删除强制静默，其他不变
   * @author lxm
   * @date 2023-12-27 03:32:36
   * @param {MDCtrlRemoveParams} [args]
   * @return {*}  {Promise<void>}
   */
  remove(args?: MDCtrlRemoveParams): Promise<void> {
    const _args: MDCtrlRemoveParams = args || {};
    _args.silent = true;
    return super.remove(args);
  }

  /**
   * 执行界面行为
   *
   * @author chitanda
   * @date 2023-12-07 15:12:26
   * @param {string} uiActionId
   * @param {ITreeNodeData} nodeData
   * @param {MouseEvent} event
   * @param {string} appId
   * @return {*}  {Promise<void>}
   */
  async doUIAction(
    uiActionId: string,
    nodeData: ITreeNodeData,
    event: MouseEvent,
    appId: string,
  ): Promise<void> {
    const eventArgs = this.getEventArgs();
    const nodeParams = this.parseTreeNodeData(nodeData);
    const result = await UIActionUtil.exec(
      uiActionId!,
      {
        ...eventArgs,
        ...nodeParams,
        event,
      },
      appId,
    );

    if (result.closeView) {
      this.view.closeView();
    } else if (result.refresh) {
      switch (result.refreshMode) {
        // 刷新当前节点的子
        case 1:
          await this.refreshNodeChildren(nodeData);
          break;
        // 刷新当前节点的父节点的子
        case 2:
          await this.refreshNodeChildren(nodeData, true);
          break;
        // 刷新所有节点数据
        case 3:
          await this.refresh();
          break;
        default:
      }
    }

    // 选中节点
    const { toSelectSrfkey } = result as IData;
    if (toSelectSrfkey) {
      this.toSelectSrfkey = toSelectSrfkey;
      this.setToSelectData();
    }
  }
}
