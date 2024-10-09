import { IDEEditForm } from '@ibiz/model-core';
/* eslint-disable no-param-reassign */
import {
  X6LinkDataProvider,
  X6LinkServiceProvider,
  X6NodeDataProvider,
  X6NodeServiceProvider,
} from '../../interface';

export type registerNode = (
  node: IDEEditForm,
  link: IDEEditForm,
) => X6NodeServiceProvider;
export type registerLink = (
  node: IDEEditForm,
  link: IDEEditForm,
) => X6LinkServiceProvider;
export type registerNodeData<T> = (data: T) => X6NodeDataProvider<T>;
export type registerLinkData<T> = (data: T) => X6LinkDataProvider<T>;

/**
 * x6适配器注册中心
 *
 * @author chitanda
 * @date 2023-11-21 10:11:40
 * @class X6ProviderRegister
 */
class X6ProviderRegister {
  /**
   * 节点适配器
   *
   * @author chitanda
   * @date 2023-11-21 11:11:47
   * @protected
   * @type {Map<string, registerNode>}
   */
  protected nodeProviderMap: Map<string, registerNode> = new Map();

  /**
   * 连线适配器
   *
   * @author chitanda
   * @date 2023-11-21 11:11:52
   * @protected
   * @type {Map<string, registerLink>}
   */
  protected linkProviderMap: Map<string, registerLink> = new Map();

  /**
   * 节点数据适配器
   *
   * @author chitanda
   * @date 2023-11-21 11:11:00
   * @protected
   * @type {Map<string, registerNodeData<unknown>>}
   */
  protected nodeDataProviderMap: Map<string, registerNodeData<unknown>> =
    new Map();

  /**
   * 连线数据适配器
   *
   * @author chitanda
   * @date 2023-11-21 11:11:07
   * @protected
   * @type {Map<string, registerLinkData<unknown>>}
   */
  protected linkDataProviderMap: Map<string, registerLinkData<unknown>> =
    new Map();

  /**
   * 注册节点适配器
   *
   * @author chitanda
   * @date 2023-11-21 11:11:49
   * @param {string} tag
   * @param {registerNode} provider
   */
  registerNode(tag: string, provider: registerNode): void {
    this.nodeProviderMap.set(tag.toUpperCase(), provider);
  }

  /**
   * 注册连线适配器
   *
   * @author chitanda
   * @date 2023-11-21 11:11:57
   * @param {string} tag
   * @param {registerLink} provider
   */
  registerLink(tag: string, provider: registerLink): void {
    this.linkProviderMap.set(tag.toUpperCase(), provider);
  }

  /**
   * 注册节点数据适配器
   *
   * @author chitanda
   * @date 2023-11-21 11:11:05
   * @param {string} tag
   * @param {registerNodeData} provider
   */
  registerNodeData<T = IData>(
    tag: string,
    provider: registerNodeData<T>,
  ): void {
    this.nodeDataProviderMap.set(
      tag.toUpperCase(),
      provider as registerNodeData<unknown>,
    );
  }

  /**
   * 注册连线数据适配器
   *
   * @author chitanda
   * @date 2023-11-21 11:11:13
   * @param {string} tag
   * @param {registerLinkData} provider
   */
  registerLinkData<T = IData>(
    tag: string,
    provider: registerLinkData<T>,
  ): void {
    this.linkDataProviderMap.set(
      tag.toUpperCase(),
      provider as registerLinkData<unknown>,
    );
  }

  /**
   * 获取节点适配器对象
   *
   * @author chitanda
   * @date 2023-11-21 11:11:19
   * @param {string} tag
   * @return {*}  {registerNode}
   */
  getNode(tag: string): registerNode {
    tag = tag.toUpperCase();
    if (this.nodeProviderMap.has(tag)) {
      return this.nodeProviderMap.get(tag)!;
    }
    throw new Error(`未找到节点适配器：${tag}`);
  }

  /**
   * 获取连线适配器对象
   *
   * @author chitanda
   * @date 2023-11-21 11:11:29
   * @param {string} tag
   * @return {*}  {registerLink}
   */
  getLink(tag: string): registerLink {
    tag = tag.toUpperCase();
    if (this.linkProviderMap.has(tag)) {
      return this.linkProviderMap.get(tag)!;
    }
    throw new Error(`未找到连线适配器：${tag}`);
  }

  /**
   * 获取节点数据适配器对象
   *
   * @author chitanda
   * @date 2023-11-21 11:11:13
   * @template T
   * @param {string} tag
   * @return {*}  {registerNodeData<T>}
   */
  getNodeData<T = IData>(tag: string): registerNodeData<T> {
    tag = tag.toUpperCase();
    if (this.nodeDataProviderMap.has(tag)) {
      return this.nodeDataProviderMap.get(tag)! as registerNodeData<T>;
    }
    throw new Error(`未找到节点数据适配器：${tag}`);
  }

  /**
   * 获取连线数据适配器对象
   *
   * @author chitanda
   * @date 2023-11-21 11:11:20
   * @template T
   * @param {string} tag
   * @return {*}  {registerLinkData<T>}
   */
  getLinkData<T = IData>(tag: string): registerLinkData<T> {
    tag = tag.toUpperCase();
    if (this.linkDataProviderMap.has(tag)) {
      return this.linkDataProviderMap.get(tag)! as registerLinkData<T>;
    }
    throw new Error(`未找到连线数据适配器：${tag}`);
  }
}

/**
 * x6适配器注册中心
 */
export const x6ProviderRegister = new X6ProviderRegister();
