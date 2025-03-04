import {
  CTX,
  EditFormController,
  findChildFormDetails,
} from '@ibiz-template/runtime';
import { IDEEditForm, IDEFormDetail, IDEFormItem } from '@ibiz/model-core';
import { clone } from 'ramda';

export class MemoEditFormController extends EditFormController {
  constructor(
    model: IDEEditForm,
    context: IContext,
    params: IParams,
    ctx: CTX,
  ) {
    const cloneModel = clone(model);
    const attachTriggerMode = (details: IDEFormDetail[]) => {
      details.forEach(item => {
        if (item.detailType === 'FORMITEM') {
          const formItem = item as IDEFormItem;
          if (formItem.editor) {
            if (!formItem.editor.editorParams) {
              formItem.editor.editorParams = {};
            }
            Object.assign(formItem.editor.editorParams, {
              triggerMode: 'input',
            });
          }
        }

        const childDetails = findChildFormDetails(item);
        if (childDetails.length) {
          attachTriggerMode(childDetails);
        }
      });
    };
    attachTriggerMode(cloneModel.deformPages || []);
    super(cloneModel, context, params, ctx);
  }
}
