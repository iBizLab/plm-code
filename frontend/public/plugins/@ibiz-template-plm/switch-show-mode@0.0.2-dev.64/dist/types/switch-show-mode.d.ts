import { IPanelButton } from '@ibiz/model-core';
import { PropType } from 'vue';
import { SwitchShowModeController } from './switch-show-mode.controller';
export declare const SwitchShowMode: import("vue").DefineComponent<{
    modelData: {
        type: PropType<IPanelButton>;
        required: true;
    };
    controller: {
        type: typeof SwitchShowModeController;
        required: true;
    };
}, {
    ns: import("@ibiz-template/core").Namespace;
    isText: boolean;
    buttonType: import("vue").ComputedRef<"info" | "primary" | "success" | "warning" | "danger" | null>;
    codeName: string | undefined;
    state: import("./switch-show-mode.state").SwitchShowModeState;
    dropdownItems: import("vue").Ref<({
        _icon: {
            htmlStr?: undefined;
            cssClass?: undefined;
        };
        _text: string;
        _showCaption: boolean;
        _className: string;
        showMode?: undefined;
        selected?: undefined;
    } | {
        _icon: {
            htmlStr: string;
            cssClass?: undefined;
        };
        _text: string;
        showMode: string;
        _showCaption: boolean;
        selected: boolean;
        _className?: undefined;
    } | {
        _icon: {
            cssClass: string;
            htmlStr?: undefined;
        };
        _text: string;
        showMode: string;
        _showCaption: boolean;
        selected: boolean;
        _className?: undefined;
    })[]>;
    selected: import("vue").Ref<IParams>;
    handleButtonClick: (event: MouseEvent, params: IParams) => Promise<void>;
    renderContentItem: (_args: IParams) => JSX.Element;
}, unknown, {}, {}, import("vue").ComponentOptionsMixin, import("vue").ComponentOptionsMixin, {}, string, import("vue").VNodeProps & import("vue").AllowedComponentProps & import("vue").ComponentCustomProps, Readonly<import("vue").ExtractPropTypes<{
    modelData: {
        type: PropType<IPanelButton>;
        required: true;
    };
    controller: {
        type: typeof SwitchShowModeController;
        required: true;
    };
}>>, {}, {}>;
export default SwitchShowMode;
