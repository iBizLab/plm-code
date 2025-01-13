import { EditFormController, findChildFormDetails } from '@ibiz-template/runtime';
import { clone } from 'ramda';

"use strict";
class MemoEditFormController extends EditFormController {
  constructor(model, context, params, ctx) {
    const cloneModel = clone(model);
    const attachTriggerMode = (details) => {
      details.forEach((item) => {
        if (item.detailType === "FORMITEM") {
          const formItem = item;
          if (formItem.editor) {
            if (!formItem.editor.editorParams) {
              formItem.editor.editorParams = {};
            }
            Object.assign(formItem.editor.editorParams, {
              triggerMode: "input"
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

export { MemoEditFormController };
