var U = Object.defineProperty;
var h = (o, a, e) => a in o ? U(o, a, { enumerable: !0, configurable: !0, writable: !0, value: e }) : o[a] = e;
var l = (o, a, e) => (h(o, typeof a != "symbol" ? a + "" : a, e), e);
import { FrontUIActionProvider as F, registerUIActionProvider as f } from "@ibiz-template/runtime";
import { createUUID as w } from "qx-util";
class I extends F {
  constructor() {
    super(...arguments);
    /**
     * 文件上传路径
     *
     * @type {string}
     * @memberof FileUploadUIActionProvider
     */
    l(this, "uploadUrl", ibiz.env.uploadFileUrl);
    /**
     * 选择文件改变
     *
     * @params
     * @memberof NetDiskTree
     */
    l(this, "uploadFiles", (e, t) => {
      this.handleUploadFile(e.target.files, t);
    });
    /**
     * 处理上传文件事件
     *
     * @memberof NetDiskTree
     */
    l(this, "handleUploadFile", async (e, t) => {
      const r = [];
      for (let i = 0; i < e.length; i++) {
        const s = await this.uploadRequest(e[i]);
        r.push(s);
      }
      const n = await Promise.all(r);
      n && t({
        data: n.map((i) => ({
          uuid: w(),
          ...i.data
        }))
      });
    });
    l(this, "uploadRequest", async (e) => {
      const t = new FormData();
      return t.append("file", e), await ibiz.net.request(this.uploadUrl, {
        method: "post",
        baseURL: "",
        data: t,
        headers: { "Content-Type": "multipart/form-data" }
      });
    });
  }
  async execAction(e, t) {
    const { context: r, params: n, data: i } = t, { resultContext: s, resultParams: c, resultData: p } = await this.handleParams(
      e,
      r,
      i,
      n
    ), u = ibiz.util.file.calcFileUpDownUrl(
      s,
      c,
      p
    );
    return this.uploadUrl = u.uploadUrl, new Promise((m) => {
      this.createFileInput((d) => {
        Object.assign(i, d.data), m(d);
      });
    });
  }
  createFileInput(e) {
    const t = document.createElement("input");
    t.type = "file", t.webkitdirectory = !1, t.addEventListener("change", (r) => {
      this.uploadFiles(r, e);
    }), document.body.appendChild(t), t.click(), document.body.removeChild(t);
  }
}
function P() {
  f(
    "DEUIACTION_FILE_UPLOAD",
    () => new I()
  );
}
const g = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install() {
    P();
  }
};
export {
  g as default,
  P as registerFileUploadProvider
};
