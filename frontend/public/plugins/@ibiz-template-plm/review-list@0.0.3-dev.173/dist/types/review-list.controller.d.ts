import { ListController } from '@ibiz-template/runtime';
export declare class ReviewListController extends ListController {
    /**
     * 头像属性
     *
     * @type {string}
     * @memberof ReviewListController
     */
    avatarField: string;
    /**
     * 用户信息
     *
     * @public
     * @type {IData}
     * @memberof ReviewListController
     */
    userInfo: IData;
    protected onCreated(): Promise<void>;
    /**
     * 解析头像数据
     *
     * @param {string} avatar
     * @return {string | undefined}
     * @memberof ReviewListController
     */
    parseAvatar(avatar: string): string | void;
}
