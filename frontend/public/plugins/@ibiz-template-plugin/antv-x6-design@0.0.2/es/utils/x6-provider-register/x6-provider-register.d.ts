import { IDEEditForm } from '@ibiz/model-core';
import { X6LinkDataProvider, X6LinkServiceProvider, X6NodeDataProvider, X6NodeServiceProvider } from '../../interface';
export type registerNode = (node: IDEEditForm, link: IDEEditForm) => X6NodeServiceProvider;
export type registerLink = (node: IDEEditForm, link: IDEEditForm) => X6LinkServiceProvider;
export type registerNodeData<T> = (data: T) => X6NodeDataProvider<T>;
export type registerLinkData<T> = (data: T) => X6LinkDataProvider<T>;
/**
 * x6适配器注册中心
 *
 * @author chitanda
 * @date 2023-11-21 10:11:40
 * @class X6ProviderRegister
 */
declare class X6ProviderRegister {
    /**
     * 节点适配器
     *
     * @author chitanda
     * @date 2023-11-21 11:11:47
     * @protected
     * @type {Map<string, registerNode>}
     */
    protected nodeProviderMap: Map<string, registerNode>;
    /**
     * 连线适配器
     *
     * @author chitanda
     * @date 2023-11-21 11:11:52
     * @protected
     * @type {Map<string, registerLink>}
     */
    protected linkProviderMap: Map<string, registerLink>;
    /**
     * 节点数据适配器
     *
     * @author chitanda
     * @date 2023-11-21 11:11:00
     * @protected
     * @type {Map<string, registerNodeData<unknown>>}
     */
    protected nodeDataProviderMap: Map<string, registerNodeData<unknown>>;
    /**
     * 连线数据适配器
     *
     * @author chitanda
     * @date 2023-11-21 11:11:07
     * @protected
     * @type {Map<string, registerLinkData<unknown>>}
     */
    protected linkDataProviderMap: Map<string, registerLinkData<unknown>>;
    /**
     * 注册节点适配器
     *
     * @author chitanda
     * @date 2023-11-21 11:11:49
     * @param {string} tag
     * @param {registerNode} provider
     */
    registerNode(tag: string, provider: registerNode): void;
    /**
     * 注册连线适配器
     *
     * @author chitanda
     * @date 2023-11-21 11:11:57
     * @param {string} tag
     * @param {registerLink} provider
     */
    registerLink(tag: string, provider: registerLink): void;
    /**
     * 注册节点数据适配器
     *
     * @author chitanda
     * @date 2023-11-21 11:11:05
     * @param {string} tag
     * @param {registerNodeData} provider
     */
    registerNodeData<T = IData>(tag: string, provider: registerNodeData<T>): void;
    /**
     * 注册连线数据适配器
     *
     * @author chitanda
     * @date 2023-11-21 11:11:13
     * @param {string} tag
     * @param {registerLinkData} provider
     */
    registerLinkData<T = IData>(tag: string, provider: registerLinkData<T>): void;
    /**
     * 获取节点适配器对象
     *
     * @author chitanda
     * @date 2023-11-21 11:11:19
     * @param {string} tag
     * @return {*}  {registerNode}
     */
    getNode(tag: string): registerNode;
    /**
     * 获取连线适配器对象
     *
     * @author chitanda
     * @date 2023-11-21 11:11:29
     * @param {string} tag
     * @return {*}  {registerLink}
     */
    getLink(tag: string): registerLink;
    /**
     * 获取节点数据适配器对象
     *
     * @author chitanda
     * @date 2023-11-21 11:11:13
     * @template T
     * @param {string} tag
     * @return {*}  {registerNodeData<T>}
     */
    getNodeData<T = IData>(tag: string): registerNodeData<T>;
    /**
     * 获取连线数据适配器对象
     *
     * @author chitanda
     * @date 2023-11-21 11:11:20
     * @template T
     * @param {string} tag
     * @return {*}  {registerLinkData<T>}
     */
    getLinkData<T = IData>(tag: string): registerLinkData<T>;
}
/**
 * x6适配器注册中心
 */
export declare const x6ProviderRegister: X6ProviderRegister;
export {};
