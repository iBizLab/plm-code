import { DEService } from '@ibiz-template/runtime';

"use strict";
class PSWFProcessService extends DEService {
  async exec(id, context, params, params2) {
    if (id === "Create" && params) {
      if (Array.isArray(params)) {
        await Promise.all(
          params.map((item) => {
            return this.fillDefault(context, item);
          })
        );
      } else {
        await this.fillDefault(context, params);
      }
    }
    return super.exec(id, context, params, params2);
  }
  async fillDefault(context, process) {
    if (!process.codename) {
      const res = await this.fetchDefault(context);
      if (res.ok) {
        const details = res.data;
        const codeNames = details.map((item) => item.codename);
        let num = 1;
        let codeName = "".concat(process.wfprocesstype, "_0").concat(num);
        while (codeNames.includes(codeName)) {
          num += 1;
          codeName = "".concat(process.wfprocesstype, "_0").concat(num);
        }
        process.codename = codeName;
      }
    }
  }
}

export { PSWFProcessService };
