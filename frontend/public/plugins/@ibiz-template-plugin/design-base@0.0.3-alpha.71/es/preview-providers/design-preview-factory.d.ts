import { IDesignPreviewProvider } from '../interface';
export declare class DesignPreViewFactory {
    /**
     * 单例变量声明
     *
     * @private
     * @static
     * @type {DesignPreViewFactory}
     * @memberof DesignPreViewFactory
     */
    private static DesignPreViewFactory;
    /**
     * 预览适配器Map
     *
     * @author tony001
     * @date 2024-09-10 11:09:00
     * @private
     * @type {Map<string, () => IDesignPreviewProvider>}
     */
    private preViewProviderMap;
    /**
     * 获取 DesignPreViewFactory 单例对象
     *
     * @static
     * @returns {DesignPreViewFactory}
     * @memberof DesignPreViewFactory
     */
    static getInstance(): DesignPreViewFactory;
    /**
     * 注册预览适配器
     *
     * @author tony001
     * @date 2024-09-10 11:09:21
     * @param {string} key
     * @param {() => IDesignPreviewProvider} provider
     */
    registerProvider(key: string, provider: () => IDesignPreviewProvider): void;
    /**
     * 获取预览适配器
     *
     * @author tony001
     * @date 2024-09-10 11:09:34
     * @param {string} key
     * @return {*}  {(IDesignPreviewProvider | undefined)}
     */
    getProvider(key: string): IDesignPreviewProvider | undefined;
}
