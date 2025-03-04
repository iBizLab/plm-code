import { IPreviewProvider } from '../interface';
export declare class DndPreViewFactory {
    /**
     * 单例变量声明
     *
     * @private
     * @static
     * @type {DndPreViewFactory}
     * @memberof DndPreViewFactory
     */
    private static DndPreViewFactory;
    /**
     * 预览providerMap
     *
     * @author tony001
     * @date 2024-09-04 12:09:55
     * @private
     * @type {Map<string, () => IPreviewProvider>}
     */
    private preViewProviderMap;
    /**
     * 获取 DndPreViewFactory 单例对象
     *
     * @static
     * @returns {DndPreViewFactory}
     * @memberof DndPreViewFactory
     */
    static getInstance(): DndPreViewFactory;
    /**
     * 注册provider
     *
     * @author tony001
     * @date 2024-09-04 12:09:01
     * @param {string} key
     * @param {() => IPreviewProvider} provider
     */
    registerProvider(key: string, provider: () => IPreviewProvider): void;
    /**
     * 获取provider
     *
     * @author tony001
     * @date 2024-09-04 12:09:41
     * @param {string} key
     * @return {*}  {IPreviewProvider}
     */
    getProvider(key: string): IPreviewProvider | undefined;
}
