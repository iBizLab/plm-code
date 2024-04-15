import { IErrorHandler } from '@ibiz-template/runtime';
export declare class ErrorHandler implements IErrorHandler {
    handle(error: unknown): boolean | undefined;
}
