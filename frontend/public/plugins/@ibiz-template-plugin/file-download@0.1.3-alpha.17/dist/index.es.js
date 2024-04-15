var u = Object.defineProperty;
var U = (t, o, e) => o in t ? u(t, o, { enumerable: !0, configurable: !0, writable: !0, value: e }) : t[o] = e;
var a = (t, o, e) => (U(t, typeof o != "symbol" ? o + "" : o, e), e);
import { FrontUIActionProvider as h, registerUIActionProvider as D } from "@ibiz-template/runtime";
import { RuntimeError as n, downloadFileFromBlob as F } from "@ibiz-template/core";
class I extends h {
  constructor() {
    super(...arguments);
    /**
     * 文件下载路径
     *
     * @type {string}
     * @memberof FileDownloadUIActionProvider
     */
    a(this, "downloadUrl", "".concat(ibiz.env.downloadFileUrl, "/%fileId%"));
  }
  async execAction(e, i) {
    const { context: r, params: d, data: s } = i, { resultContext: w, resultParams: l, resultData: c } = await this.handleParams(
      e,
      r,
      s,
      d
    );
    if (!l.fileid)
      throw new n("未配置文件id");
    const f = ibiz.util.file.calcFileUpDownUrl(
      w,
      l,
      c
    );
    this.downloadUrl = f.downloadUrl;
    const m = this.downloadUrl.replace("%fileId%", l.fileid);
    return this.fileDownload({ url: m, name: l.filename || "下载文件" }), {};
  }
  /**
   * 请求url获取文件流，并用JS触发文件下载
   *
   * @author lxm
   * @date 2022-11-17 14:11:09
   * @param {string} url
   * @param {IData} file
   */
  fileDownload(e) {
    ibiz.net.request(e.url, {
      method: "get",
      responseType: "blob",
      baseURL: ""
      // 已经有baseURL了，这里无需再写
    }).then((i) => {
      if (i.status !== 200)
        throw new n("下载文件失败");
      if (i.data) {
        const r = e.name;
        F(i.data, r);
      } else
        throw new n("文件流数据不存在");
    });
  }
}
function b() {
  D(
    "DEUIACTION_FILE_DOWNLOAD",
    () => new I()
  );
}
const P = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install() {
    b();
  }
};
export {
  P as default,
  b as registerFileDownloadProvider
};
