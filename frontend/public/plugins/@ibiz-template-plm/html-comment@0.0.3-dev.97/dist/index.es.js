import './style.css';
var pt = Object.defineProperty;
var vt = (a, t, e) => t in a ? pt(a, t, { enumerable: !0, configurable: !0, writable: !0, value: e }) : a[t] = e;
var r = (a, t, e) => (vt(a, typeof t != "symbol" ? t + "" : t, e), e);
import { defineComponent as ge, ref as b, shallowRef as Xe, watch as ne, onBeforeUnmount as Fe, onMounted as Ne, createVNode as p, resolveComponent as D, createTextVNode as A, nextTick as U, onUnmounted as gt, computed as et, withDirectives as tt, resolveDirective as Le, h as st, defineAsyncComponent as yt } from "vue";
import { ScriptFactory as z, convertNavData as He, EditorController as bt, ControllerEvent as Ct, registerEditorProvider as wt } from "@ibiz-template/runtime";
import { getHtmlProps as Ke, getEditorEmits as Ze, useNamespace as ye, useClickOutside as Et, withInstall as kt } from "@ibiz-template/vue3-util";
import { Editor as nt, Toolbar as at } from "@wangeditor/editor-for-vue";
import { SlateEditor as se, SlateElement as it, SlateRange as Oe, SlateTransforms as xe, SlateNode as Pe, SlateText as ve, Boot as I, DomEditor as _, createEditor as St } from "@wangeditor/editor";
import { getCookie as rt, createUUID as Mt } from "qx-util";
import { isNil as ot } from "ramda";
import { CoreConst as lt, debounce as ct, awaitTimeout as xt, RuntimeError as G, listenJSEvent as Te, NOOP as K, downloadFileFromBlob as Pt } from "@ibiz-template/core";
import { ElMessageBox as dt } from "element-plus";
import { debounce as ut, toNumber as Lt } from "lodash-es";
class ht {
  constructor(t, e) {
    /**
     * 模态实例
     * @memberof ModalUtil
     */
    r(this, "modalOrPanel");
    /**
     * 富文本Ref
     * @memberof ModalUtil
     */
    r(this, "htmlRef");
    this.modalOrPanel = t, this.htmlRef = e, this.calcModalPosition(), window.addEventListener("resize", this.handleResize.bind(this));
  }
  /**
   * 计算模态定位
   * @memberof ModalUtil
   */
  calcModalPosition() {
    if (!["dropPanel"].includes(this.modalOrPanel.type))
      return;
    const { $elem: e } = this.modalOrPanel, s = e[0], n = this.htmlRef.$el, i = n.querySelector(".w-e-bar"), l = s.previousElementSibling, d = l.getAttribute("data-menu-key"), h = s.parentNode.parentNode.parentNode;
    if (!["bgColor", "color"].includes(d) || !n || !i || !l || h.getAttribute("data-w-e-toolbar") === "true")
      return;
    const f = s.clientWidth, C = s.clientHeight, E = i.clientHeight, k = l.getBoundingClientRect(), P = k.bottom, T = k.right, F = k.top, L = k.left, m = "".concat(F + E, "px"), u = "".concat(L, "px"), w = "".concat(P - C - E, "px"), H = "".concat(T - f, "px"), x = { position: "fixed", left: u, top: m }, R = window.innerWidth, Z = window.innerHeight;
    R - L < f && Object.assign(x, { left: H }), Z - F - E < C && Object.assign(x, { top: w }), Object.assign(s.style, { top: "", bottom: "", left: "", right: "" }), Object.assign(s.style, x);
  }
  /**
   * 监听窗口变化
   * @memberof ModalUtil
   */
  handleResize() {
    this.calcModalPosition();
  }
  /**
   * 销毁
   * @memberof ModalUtil
   */
  destroy() {
    window.removeEventListener("resize", this.handleResize);
  }
}
const mt = /* @__PURE__ */ ge({
  name: "IBizHtmlContent",
  props: Ke(),
  emits: Ze(),
  setup(a, {
    emit: t
  }) {
    const e = ye("html"), s = a.controller, n = b(), i = b({});
    let l = null, d = 0;
    const h = b(), g = b(), f = Xe(), C = b(), E = b(""), k = b({
      Authorization: "Bearer ".concat(rt(lt.TOKEN))
    }), P = b(""), T = b(""), F = b(!0), L = b(!1), m = b(!1), u = b(!1), w = b(!1), H = b(""), x = b([]), R = s.model;
    R.editorParams && (R.editorParams.enableEdit && (L.value = !0, m.value = !0, F.value = s.toBoolean(R.editorParams.enableEdit) && !a.readonly && !a.disabled), R.editorParams.enableFullScreen && (u.value = s.toBoolean(R.editorParams.enableFullScreen)));
    const Z = (c) => {
      if (!f.value)
        return;
      const {
        eventArg: y
      } = c;
      y && (f.value.setHtml(y), t("focus"));
    }, W = () => {
      f.value && (f.value.blur(), f.value.setHtml(""));
    }, X = () => {
      f.value && t("focus");
    };
    s.evt.on("setHtml", Z), s.evt.on("clear", W), s.evt.on("onSetReply", X), ne(() => a.data, (c) => {
      if (c) {
        const y = ibiz.util.file.calcFileUpDownUrl(s.context, s.params, c);
        P.value = y.uploadUrl, T.value = y.downloadUrl;
      }
    }, {
      immediate: !0,
      deep: !0
    });
    const B = (c, y) => {
      if (y)
        return !0;
    }, re = (c) => c, ee = {
      toolbarKeys: [{
        key: "group-add-style",
        // 必填，要以 group 开头
        title: "添加",
        // 必填
        iconSvg: '<svg viewBox="0 0 16 16" xmlns="http://www.w3.org/2000/svg" fit="" height="1em" width="1em" preserveAspectRatio="xMidYMid meet" focusable="false"><g id="arvaction/plus-circle-fill" stroke-width="1" fill-rule="evenodd"><path d="M8 16A8 8 0 1 1 8 0a8 8 0 0 1 0 16zm-.6-8.6H4v1.2h3.4V12h1.2V8.6H12V7.4H8.6V4H7.4v3.4z" id="arv形状结合"></path></g></svg>',
        // 可选
        menuKeys: ["attachments", "codesnippet", "page"]
      }, "|", {
        key: "group-inline-style",
        // 必填，要以 group 开头
        title: "文本格式",
        // 必填
        iconSvg: '<svg viewBox="0 0 16 16" xmlns="http://www.w3.org/2000/svg" fit="" height="1em" width="1em" preserveAspectRatio="xMidYMid meet" focusable="false"><g id="ahdeditor/color-tt" stroke-width="1" fill-rule="evenodd"><path id="ahdsecondary-color" d="M1.999 15.011h11.998V13.81H1.999z"></path><path d="M6.034 7.59h4.104L8.086 2.297 6.034 7.59zm-.465 1.2l-1.437 3.707H2.845L7.301 1h1.287l-.001.004h.286l4.454 11.492h-1.288L10.603 8.79H5.569z" id="ahd合并形状"></path></g></svg>',
        // 可选
        menuKeys: ["bold", "italic", "underline", "through", "code", "numberedList", "bulletedList", "insertLink"]
      }, "codeBlock", "mention", "marker", "emotion"]
    }, $ = {
      placeholder: s.placeHolder,
      readOnly: L.value ? m.value : a.readonly,
      MENU_CONF: {
        // 图片上传
        uploadImage: {
          // 上传地址
          server: P.value,
          // form-data fieldName ，默认值 'wangeditor-uploaded-image'
          fieldName: "file",
          // 单个文件的最大体积限制，默认为 2M
          maxFileSize: 10 * 1024 * 1024,
          // 10M
          // 最多可上传几个文件，默认为 100
          maxNumberOfFiles: 10,
          // 选择文件时的类型限制，默认为 ['image/*'] 。如不想限制，则设置为 []
          allowedFileTypes: [],
          // 自定义增加 http  header
          headers: k.value,
          // 跨域是否传递 cookie ，默认为 false
          withCredentials: !0,
          // 上传之前触发
          onBeforeUpload(c) {
            return c;
          },
          // 上传进度的回调函数
          onProgress(c) {
            console.log("progress", c);
          },
          // 单个文件上传成功之后
          onSuccess(c, y) {
            console.log("".concat(c.name, " 上传成功"), y);
          },
          // 单个文件上传失败
          onFailed(c, y) {
            console.log("".concat(c.name, " 上传失败"), y);
          },
          // 上传错误，或者触发 timeout 超时
          onError(c, y, M) {
            console.log("".concat(c.name, " 上传出错"), y, M);
          },
          // 自定义插入图片
          async customInsert(c, y) {
            const M = T.value.replace("%fileId%", c.id), N = c.filename;
            y(M, N, "");
          }
        },
        // 插入链接
        insertLink: {
          checkLink: B,
          // 也支持 async 函数
          parseLinkUrl: re
          // 也支持 async 函数
        },
        // 更新链接
        editLink: {
          checkLink: B,
          // 也支持 async 函数
          parseLinkUrl: re
          // 也支持 async 函数
        }
      }
    }, be = async (c) => {
      const y = c.src;
      if (m.value)
        oe(y);
      else {
        const M = se.nodes(f.value, {
          match: (N) => !!(it.isElement(N) && N.type === "image"),
          universal: !0
        });
        if (M)
          for (const N of M) {
            const [o] = N;
            o.type === "image" && y.endsWith(o.src) && oe(o.src);
          }
      }
    }, oe = async (c) => {
      if (H.value = c, x.value = [c], await U(), C.value) {
        const {
          container: y
        } = C.value.$refs;
        y && y.children[0].click();
      }
    }, Re = (c) => {
      const y = c.getEditableContainer();
      y && y.querySelectorAll("img").forEach((N) => {
        N.onclick = (o) => {
          const v = o.target;
          v && be(v);
        };
      });
    }, le = (c) => {
      if (C.value) {
        const {
          container: y
        } = C.value.$refs;
        if (y) {
          const M = y.querySelector(".el-image-viewer__wrapper");
          M == null || M[c]("keydown", De);
        }
      }
    }, De = async (c) => {
      (c.key === "Escape" || c.keyCode === 27) && (c.stopPropagation(), c.preventDefault(), await U(), le("removeEventListener"), x.value = []);
    }, Ce = async () => {
      await U(), le("addEventListener");
    };
    Fe(() => {
      const c = f.value;
      c != null && c.destroy();
    });
    const we = (c) => {
      f.value = c;
      let y;
      c.on("modalOrPanelShow", (M) => {
        y = new ht(M, g.value);
      }), c.on("modalOrPanelHide", () => {
        y && y.destroy();
      }), c.setHtml(E.value), s.onCreated(f.value, a.data, ee);
    }, Ee = (c) => {
      const y = c.getHtml();
      Re(c);
      let M = y === "<p><br></p>" ? "" : y;
      M === a.value || M === "" && ot(a.value) || L.value || (M = M.replaceAll('class="rich-html-table"', "").replace(/<table/g, '<table class="rich-html-table"'), t("change", M), s.evt.emit("onChange", {
        eventArg: M
      }));
    }, ce = (c) => {
      s.onDestroyed(), s.evt.off("setHtml", Z), s.evt.off("clear", W), s.evt.off("onSetReply", X);
    }, ke = () => {
      t("focus"), s.evt.emit("onFocus", {
        eventArg: a.value
      });
    }, de = () => {
      t("blur"), s.evt.emit("onBlur", {
        eventArg: a.value
      });
    }, ue = (c, y) => {
      alert("【自定义提示】".concat(y, " - ").concat(c));
    }, he = (c, y, M) => {
      M(!0);
    }, Se = (c) => {
      const y = f.value;
      y != null && y.insertText(c);
    }, Me = () => {
      const c = f.value;
      c != null && console.log(c.getHtml());
    }, Q = () => {
      const c = f.value;
      c != null && c.disable();
    }, Y = () => {
      const c = f.value;
      c != null && c.enable();
    }, Ie = () => {
      if (n.value && h.value) {
        const c = n.value.offsetHeight;
        l = new ResizeObserver((y) => {
          const {
            height: M
          } = y[0].contentRect;
          if (M !== d) {
            const N = {
              height: "".concat(c - y[0].contentRect.height, "px")
            };
            i.value = e.cssVarBlock(N), d = M;
          }
        }), l.observe(h.value.selector);
      }
    }, Ae = () => {
      var c, y;
      if (a.value) {
        const M = a.value.indexOf("</p>");
        if (M >= 0) {
          const N = (c = f.value.selection.anchor) == null ? void 0 : c.offset, o = (y = f.value.selection.anchor) == null ? void 0 : y.path;
          N === 0 && o.length > 0 && o[0] === 0 && f.value.move(M - 3);
        }
      }
    }, V = () => {
      m.value = !m.value, m.value ? Q() : (Y(), f.value.focus(), Ae());
    }, te = () => p("div", {
      class: e.be("message", "message-content")
    }, [p("p", null, [A("确定要取消编辑吗？")]), p("p", {
      class: e.bem("message", "message-content", "message-tip")
    }, [A("取消编辑将无法保存修改的内容，且不能找回。")])]), Ue = () => {
      a.value !== E.value ? dt({
        title: "确认取消",
        type: "warning",
        customClass: e.b("message"),
        message: te(),
        showCancelButton: !0,
        cancelButtonClass: e.be("message", "message-cancel"),
        confirmButtonClass: e.be("message", "message-comfire")
      }).then(() => {
        if (a.value) {
          const c = s.parseNode(a.value);
          E.value = c;
        } else
          E.value = "";
        V();
      }).catch(() => {
        f.value.focus();
      }) : V();
    }, ze = () => {
      m.value = !0, f.value.disable();
      const c = E.value.replaceAll('class="rich-html-table"', "").replace(/<table/g, '<table class="rich-html-table"');
      t("change", c), w.value && (w.value = !1);
    }, me = () => L.value ? p("div", {
      class: [e.b("footer"), {
        [e.b("footer-dialog")]: w.value
      }]
    }, [p("div", {
      class: e.be("footer", "cancel"),
      onClick: () => Ue()
    }, [A("取消")]), p("div", {
      class: e.be("footer", "save"),
      onClick: () => ze()
    }, [A("保存")])]) : null, fe = () => {
      w.value = !w.value, U(() => {
        m.value ? Q() : (Y(), f.value.focus());
      });
    }, Be = () => u.value ? w.value ? p("i", {
      class: "fa fa-compress",
      "aria-hidden": "true",
      onClick: () => fe()
    }, null) : p("i", {
      class: "fa fa-expand",
      "aria-hidden": "true",
      onClick: () => fe()
    }, null) : null, $e = () => L.value || u.value ? p("div", {
      class: e.b("custom-toolbar")
    }, [L.value && F.value && m.value ? p("i", {
      class: "fa fa-edit",
      "aria-hidden": "true",
      onClick: () => V()
    }, null) : null, Be()]) : null, Ve = () => {
      if (s.reply.value) {
        const c = z.execScriptFn({
          value: s.reply.value
        }, s.replyScript, {
          singleRowReturn: !0,
          isAsync: !1
        });
        return p("div", {
          class: e.b("reply")
        }, [p("div", {
          class: e.be("reply", "content"),
          innerHTML: c
        }, null), p(D("ion-icon"), {
          name: "close-outline",
          onClick: () => s.removeReply()
        }, null)]);
      }
    }, pe = () => s.hidden.value ? null : p("div", {
      class: e.b("content"),
      ref: "htmlContent",
      style: i.value
    }, [p(nt, {
      ref: "htmlRef",
      class: e.b("editor"),
      modelValue: E.value,
      "onUpdate:modelValue": (c) => E.value = c,
      "default-config": $,
      mode: "default",
      onOnCreated: we,
      onOnChange: Ee,
      onOnDestroyed: ce,
      onOnFocus: ke,
      onOnBlur: de,
      oncustomAlert: ue,
      oncustomPaste: he
    }, null), Ve(), p(at, {
      ref: "toolbarRef",
      editor: f.value,
      "default-config": ee,
      mode: "default",
      class: e.b("toolbar")
    }, null)]), qe = () => p(D("el-image"), {
      class: e.e("preview"),
      ref: "previewRef",
      "zoom-rate": 1.1,
      src: H.value,
      "preview-src-list": x.value,
      "hide-on-click-modal": !0,
      onShow: Ce,
      fit: "cover"
    }, null);
    return Ne(() => {
      Ie(), ne(() => a.value, (c, y) => {
        c !== y && (typeof a.value == "string" || c == null) && (c == null ? E.value = "" : E.value = c);
      }, {
        immediate: !0
      }), ne(() => a.disabled, (c, y) => {
        c !== y && (c === !0 ? Q() : Y());
      }, {
        immediate: !0
      });
    }), {
      ns: e,
      editorRef: f,
      previewRef: C,
      mode: "default",
      valueHtml: E,
      toolbarConfig: ee,
      editorConfig: $,
      handleCreated: we,
      handleChange: Ee,
      handleDestroyed: ce,
      handleFocus: ke,
      handleBlur: de,
      customAlert: ue,
      customPaste: he,
      insertText: Se,
      printHtml: Me,
      disable: Q,
      enable: Y,
      renderHeaserToolbar: $e,
      renderEditorContent: pe,
      renderFooter: me,
      htmlContent: n,
      hasEnableEdit: L,
      cssVars: i,
      toolbarRef: h,
      htmlRef: g,
      isFullScreen: w,
      readonlyState: m,
      changeFullScreenState: fe,
      renderPreview: qe
    };
  },
  render() {
    return this.isFullScreen ? p(D("el-dialog"), {
      modelValue: this.isFullScreen,
      "onUpdate:modelValue": (a) => this.isFullScreen = a,
      width: "80%",
      top: "10vh",
      class: this.ns.b("dialog-full-screen"),
      onClose: () => this.changeFullScreenState()
    }, {
      default: () => [p("div", {
        class: [this.ns.b(), {
          [this.ns.b("editor-readonly")]: this.readonlyState
        }]
      }, [this.renderHeaserToolbar(), this.renderEditorContent(), this.hasEnableEdit && !this.readonlyState ? this.renderFooter() : null])]
    }) : p("div", {
      class: [this.ns.b(), {
        [this.ns.b("editor-readonly")]: this.readonlyState
      }]
    }, [this.renderHeaserToolbar(), this.renderEditorContent(), this.renderPreview(), this.hasEnableEdit && !this.readonlyState ? this.renderFooter() : null]);
  }
}), Ht = /* @__PURE__ */ Object.freeze(/* @__PURE__ */ Object.defineProperty({
  __proto__: null,
  default: mt
}, Symbol.toStringTag, { value: "Module" })), Ot = [
  "headerSelect",
  "blockquote",
  "|",
  "bold",
  "underline",
  "italic",
  {
    key: "group-more-style",
    title: "更多",
    iconSvg: '<svg viewBox="0 0 1024 1024"><path d="M204.8 505.6m-76.8 0a76.8 76.8 0 1 0 153.6 0 76.8 76.8 0 1 0-153.6 0Z"></path><path d="M505.6 505.6m-76.8 0a76.8 76.8 0 1 0 153.6 0 76.8 76.8 0 1 0-153.6 0Z"></path><path d="M806.4 505.6m-76.8 0a76.8 76.8 0 1 0 153.6 0 76.8 76.8 0 1 0-153.6 0Z"></path></svg>',
    menuKeys: ["through", "code", "sup", "sub", "clearStyle"]
  },
  "color",
  "bgColor",
  "|",
  "fontSize",
  "fontFamily",
  "lineHeight",
  "|",
  "bulletedList",
  "numberedList",
  "todo",
  {
    key: "group-justify",
    title: "对齐",
    iconSvg: '<svg viewBox="0 0 1024 1024"><path d="M768 793.6v102.4H51.2v-102.4h716.8z m204.8-230.4v102.4H51.2v-102.4h921.6z m-204.8-230.4v102.4H51.2v-102.4h716.8zM972.8 102.4v102.4H51.2V102.4h921.6z"></path></svg>',
    menuKeys: [
      "justifyLeft",
      "justifyRight",
      "justifyCenter",
      "justifyJustify"
    ]
  },
  {
    key: "group-indent",
    title: "缩进",
    iconSvg: '<svg viewBox="0 0 1024 1024"><path d="M0 64h1024v128H0z m384 192h640v128H384z m0 192h640v128H384z m0 192h640v128H384zM0 832h1024v128H0z m0-128V320l256 192z"></path></svg>',
    menuKeys: ["indent", "delIndent"]
  },
  "|",
  "emotion",
  "insertLink",
  {
    key: "group-image",
    title: "图片",
    iconSvg: '<svg viewBox="0 0 1024 1024"><path d="M959.877 128l0.123 0.123v767.775l-0.123 0.122H64.102l-0.122-0.122V128.123l0.122-0.123h895.775zM960 64H64C28.795 64 0 92.795 0 128v768c0 35.205 28.795 64 64 64h896c35.205 0 64-28.795 64-64V128c0-35.205-28.795-64-64-64zM832 288.01c0 53.023-42.988 96.01-96.01 96.01s-96.01-42.987-96.01-96.01S682.967 192 735.99 192 832 234.988 832 288.01zM896 832H128V704l224.01-384 256 320h64l224.01-192z"></path></svg>',
    menuKeys: ["insertImage", "uploadImage"]
  },
  {
    key: "group-video",
    title: "视频",
    iconSvg: '<svg viewBox="0 0 1024 1024"><path d="M981.184 160.096C837.568 139.456 678.848 128 512 128S186.432 139.456 42.816 160.096C15.296 267.808 0 386.848 0 512s15.264 244.16 42.816 351.904C186.464 884.544 345.152 896 512 896s325.568-11.456 469.184-32.096C1008.704 756.192 1024 637.152 1024 512s-15.264-244.16-42.816-351.904zM384 704V320l320 192-320 192z"></path></svg>',
    menuKeys: ["insertVideo", "uploadVideo"]
  },
  "insertTable",
  "codeBlock",
  "divider",
  "|",
  "undo",
  "redo"
], je = /<span class='personnel-marker'>(.*?)<\/span>/, Ft = /* @__PURE__ */ ge({
  name: "IBizHtmlCollapse",
  props: Ke(),
  emits: Ze(),
  setup(a, {
    emit: t
  }) {
    const e = ye("html"), s = a.controller, n = b(), i = b({});
    let l = null, d = 0;
    const h = b(), g = Xe(), f = b(), C = b(), E = b(), k = b(""), P = b({
      Authorization: "Bearer ".concat(rt(lt.TOKEN))
    }), T = b(""), F = b(""), L = b(!0), m = b(!1), u = b(!1), w = b(!1), H = b(!1), x = b(!0), R = b(!1), Z = b("");
    let W;
    const X = b([]), B = s.model;
    B.editorParams && (B.editorParams.enableEdit && (m.value = !0, u.value = !0, L.value = s.toBoolean(B.editorParams.enableEdit) && !a.readonly && !a.disabled), B.editorParams.enableFullScreen && (w.value = s.toBoolean(B.editorParams.enableFullScreen))), a.readonly && (m.value = !1, u.value = !0), ne(() => a.data, (o) => {
      if (o) {
        const v = ibiz.util.file.calcFileUpDownUrl(s.context, s.params, o, s.editorParams);
        T.value = v.uploadUrl, F.value = v.downloadUrl;
      }
    }, {
      immediate: !0,
      deep: !0
    });
    const re = (o, v) => {
      if (v)
        return !0;
    }, ee = (o) => o, $ = {
      toolbarKeys: Ot
    };
    s.insertKeys.length > 0 && $.toolbarKeys && s.insertKeys.forEach((o) => {
      o.keys && o.keys.forEach((v, S) => {
        $.toolbarKeys.splice(o.index + S, 0, v);
      });
    });
    const be = {
      placeholder: s.placeHolder,
      readOnly: m.value ? u.value : a.readonly,
      MENU_CONF: {
        // 图片上传
        uploadImage: {
          // 上传地址
          server: T.value,
          // form-data fieldName ，默认值 'wangeditor-uploaded-image'
          fieldName: "file",
          // 单个文件的最大体积限制，默认为 2M
          maxFileSize: 10 * 1024 * 1024,
          // 10M
          // 最多可上传几个文件，默认为 100
          maxNumberOfFiles: 10,
          // 选择文件时的类型限制，默认为 ['image/*'] 。如不想限制，则设置为 []
          allowedFileTypes: [],
          // 自定义增加 http  header
          headers: P.value,
          // 跨域是否传递 cookie ，默认为 false
          withCredentials: !0,
          // 上传之前触发
          onBeforeUpload(o) {
            return o;
          },
          // 上传进度的回调函数
          onProgress(o) {
            console.log("progress", o);
          },
          // 单个文件上传成功之后
          onSuccess(o, v) {
            console.log("".concat(o.name, " 上传成功"), v);
          },
          // 单个文件上传失败
          onFailed(o, v) {
            console.log("".concat(o.name, " 上传失败"), v);
          },
          // 上传错误，或者触发 timeout 超时
          onError(o, v, S) {
            console.log("".concat(o.name, " 上传出错"), v, S);
          },
          // 自定义插入图片
          async customInsert(o, v) {
            const S = F.value.replace("%fileId%", o.id), O = o.filename;
            v(S, O, "");
          }
        },
        // 插入链接
        insertLink: {
          checkLink: re,
          // 也支持 async 函数
          parseLinkUrl: ee
          // 也支持 async 函数
        },
        // 更新链接
        editLink: {
          checkLink: re,
          // 也支持 async 函数
          parseLinkUrl: ee
          // 也支持 async 函数
        }
      }
    };
    Fe(() => {
      const o = g.value;
      o != null && o.destroy();
    });
    const oe = async (o) => {
      if (s.maxHeight) {
        const v = o.getEditableContainer();
        R.value = v.offsetHeight > s.maxHeight;
      }
    }, Re = async (o) => {
      const v = o.src;
      if (u.value)
        le(v);
      else {
        const S = se.nodes(g.value, {
          match: (O) => !!(it.isElement(O) && O.type === "image"),
          universal: !0
        });
        if (S)
          for (const O of S) {
            const [q] = O;
            q.type === "image" && v.endsWith(q.src) && le(q.src);
          }
      }
    }, le = async (o) => {
      if (Z.value = o, X.value = [o], await U(), C.value) {
        const {
          container: v
        } = C.value.$refs;
        v && v.children[0].click();
      }
    }, De = (o) => {
      const v = o.getEditableContainer();
      v && v.querySelectorAll("img").forEach((O) => {
        O.onload = () => {
          oe(o);
        }, O.onclick = (q) => {
          const We = q.target;
          We && Re(We);
        };
      });
    }, Ce = (o) => {
      if (C.value) {
        const {
          container: v
        } = C.value.$refs;
        if (v) {
          const S = v.querySelector(".el-image-viewer__wrapper");
          S == null || S[o]("keydown", we);
        }
      }
    }, we = async (o) => {
      (o.key === "Escape" || o.keyCode === 27) && (o.stopPropagation(), o.preventDefault(), await U(), Ce("removeEventListener"), X.value = []);
    }, Ee = async () => {
      await U(), Ce("addEventListener");
    }, ce = () => {
      let o = k.value;
      if (o = o.replace(je, "").replaceAll('class="rich-html-table"', "").replace(/<table/g, '<table class="rich-html-table"'), s.renderMode === "JSON") {
        const v = g.value;
        o = s.toJson(v.children);
      }
      a.value !== o && t("change", o);
    }, ke = ct(ce, s.saveInterval), de = (o) => {
      g.value = o;
      const v = s.parseNode(k.value);
      o.setHtml(v), s.onCreated(g.value, a.data, $);
      let S;
      o.on("modalOrPanelShow", (O) => {
        S = new ht(O, f.value);
      }), o.on("modalOrPanelHide", () => {
        S && S.destroy();
      });
    }, ue = (o) => {
      const v = o.getHtml().replace(je, "");
      oe(o), De(o);
      let S = v === "<p><br></p>" ? "" : v;
      S === a.value || S === "" && ot(a.value) || (S = S.replaceAll('class="rich-html-table"', "").replace(/<table/g, '<table class="rich-html-table"'), !m.value && o.isFocused() && (s.emitMode === "AUTOMATIC" ? ke() : ce()), s.evt.emit("onChange", {
        eventArg: S
      }));
    }, he = (o) => {
      s.onDestroyed();
    }, Se = (o) => {
      t("focus"), s.evt.emit("onFocus", {
        eventArg: a.value
      });
    }, Me = (o) => {
      t("blur"), s.evt.emit("onBlur", {
        eventArg: a.value
      });
    }, Q = (o, v) => {
      alert("【自定义提示】".concat(v, " - ").concat(o));
    }, Y = (o, v, S) => {
      S(!0);
    }, Ie = (o) => {
      const v = g.value;
      v != null && v.insertText(o);
    }, Ae = () => {
      g.value != null;
    }, V = () => {
      const o = g.value;
      o != null && o.disable();
    }, te = () => {
      const o = g.value;
      o != null && o.enable();
    }, Ue = () => {
      xt(0, () => {
        if (n.value && h.value) {
          const o = n.value.offsetHeight;
          l = new ResizeObserver((v) => {
            const {
              height: S
            } = v[0].contentRect;
            if (S !== d) {
              const O = {
                height: "".concat(o - v[0].contentRect.height, "px")
              };
              i.value = e.cssVarBlock(O), d = S;
            }
          }), l.observe(h.value.selector);
        }
      });
    }, ze = () => {
      var o, v;
      if (a.value) {
        const S = a.value.indexOf("</p>");
        if (S >= 0) {
          const O = (o = g.value.selection.anchor) == null ? void 0 : o.offset, q = (v = g.value.selection.anchor) == null ? void 0 : v.path;
          O === 0 && q.length > 0 && q[0] === 0 && g.value.move(S - 3);
        }
      }
    }, me = () => {
      if (u.value = !u.value, !u.value)
        te(), g.value.focus(), ze(), x.value = !0;
      else {
        if (f.value) {
          const {
            box: o
          } = f.value.$refs;
          o.scroll(0, 0);
        }
        V();
      }
    }, fe = () => p("div", {
      class: e.be("message", "message-content")
    }, [p("p", null, [A("确定要取消编辑吗？")]), p("p", {
      class: e.bem("message", "message-content", "message-tip")
    }, [A("取消编辑将无法保存修改的内容，且不能找回。")])]), Be = () => {
      a.value !== k.value ? dt({
        title: "确认取消",
        type: "warning",
        customClass: e.b("message"),
        message: fe(),
        showCancelButton: !0,
        cancelButtonClass: e.be("message", "message-cancel"),
        confirmButtonClass: e.be("message", "message-comfire")
      }).then(() => {
        if (a.value) {
          const o = s.parseNode(a.value);
          k.value = o;
        } else
          k.value = "";
        me();
      }).catch(() => {
        g.value.focus();
      }) : me();
    }, $e = () => {
      u.value = !0, g.value.disable();
      const o = k.value.replace(je, "").replaceAll('class="rich-html-table"', "").replace(/<table/g, '<table class="rich-html-table"');
      s.renderMode !== "JSON" && t("change", o), H.value && (H.value = !1);
    }, Ve = () => m.value && s.emitMode !== "AUTOMATIC" ? p("div", {
      class: [e.b("footer"), {
        [e.b("footer-dialog")]: H.value
      }]
    }, [p("div", {
      class: e.be("footer", "cancel"),
      onClick: () => Be()
    }, [A("取消")]), p("div", {
      class: e.be("footer", "save"),
      onClick: () => $e()
    }, [A("保存")])]) : null, pe = () => {
      H.value = !H.value, x.value = !H.value, U(() => {
        u.value ? V() : (te(), g.value.focus());
      });
    }, qe = () => w.value ? H.value ? p("i", {
      class: "fa fa-compress",
      "aria-hidden": "true",
      onClick: () => pe()
    }, null) : p("i", {
      class: "fa fa-expand",
      "aria-hidden": "true",
      onClick: () => pe()
    }, null) : null, c = () => m.value || w.value ? p("div", {
      class: e.b("custom-toolbar")
    }, [m.value && L.value && u.value ? p("i", {
      class: "fa fa-edit",
      "aria-hidden": "true",
      onClick: () => me()
    }, null) : null, qe()]) : null, y = () => R.value ? x.value ? p("div", {
      class: e.e("toggle"),
      onClick: () => {
        x.value = !x.value;
      }
    }, [A("展开更多 "), p(D("ion-icon"), {
      name: "arrow-down-outline"
    }, null)]) : p("div", {
      class: e.e("toggle"),
      onClick: () => {
        x.value = !x.value;
      }
    }, [A("收起更多 "), p(D("ion-icon"), {
      name: "arrow-up-outline"
    }, null)]) : null, M = () => {
      const o = {
        ...i.value
      };
      return x.value && s.maxHeight && Object.assign(o, {
        maxHeight: "".concat(s.maxHeight, "px")
      }), p("div", {
        class: e.b("content"),
        ref: "htmlContent",
        style: o
      }, [p(at, {
        ref: "toolbarRef",
        editor: g.value,
        "default-config": $,
        mode: "default",
        class: e.b("toolbar")
      }, null), p(nt, {
        ref: "htmlRef",
        class: e.b("editor"),
        modelValue: k.value,
        "onUpdate:modelValue": (v) => k.value = v,
        "default-config": be,
        mode: "default",
        onOnCreated: de,
        onOnChange: ue,
        onOnDestroyed: he,
        onOnFocus: Se,
        onOnBlur: Me,
        oncustomAlert: Q,
        oncustomPaste: Y
      }, null)]);
    }, N = () => p(D("el-image"), {
      class: e.e("preview"),
      ref: "previewRef",
      "zoom-rate": 1.1,
      src: Z.value,
      "preview-src-list": X.value,
      "hide-on-click-modal": !0,
      onShow: Ee,
      fit: "cover"
    }, null);
    return Ne(() => {
      E.value && (W = Et(E, async () => {
        g.value && g.value.emit("clickOutside");
      })), Ue(), ne(() => a.value, (o, v) => {
        o !== v && (typeof a.value == "string" || o == null) && (o == null ? k.value = "" : k.value || (s.renderMode === "JSON" ? k.value = s.jsonToHtml(o) : k.value = o));
      }, {
        immediate: !0
      }), ne(() => a.disabled, (o, v) => {
        o !== v && (o === !0 ? V() : te());
      }, {
        immediate: !0
      });
    }), gt(() => {
      l && l.disconnect(), W && W.stop && W.stop();
    }), {
      ns: e,
      editorRef: g,
      previewRef: C,
      containerRef: E,
      htmlRef: f,
      mode: "default",
      valueHtml: k,
      toolbarConfig: $,
      editorConfig: be,
      handleCreated: de,
      handleChange: ue,
      handleDestroyed: he,
      handleFocus: Se,
      handleBlur: Me,
      customAlert: Q,
      customPaste: Y,
      insertText: Ie,
      printHtml: Ae,
      disable: V,
      enable: te,
      renderHeaserToolbar: c,
      renderEditorContent: M,
      renderToggle: y,
      renderFooter: Ve,
      htmlContent: n,
      hasEnableEdit: m,
      cssVars: i,
      toolbarRef: h,
      isFullScreen: H,
      readonlyState: u,
      collapse: x,
      changeFullScreenState: pe,
      renderPreview: N
    };
  },
  render() {
    return this.isFullScreen ? p(D("el-dialog"), {
      modelValue: this.isFullScreen,
      "onUpdate:modelValue": (a) => this.isFullScreen = a,
      width: "80%",
      top: "10vh",
      class: this.ns.b("dialog-full-screen"),
      onClose: () => this.changeFullScreenState()
    }, {
      default: () => [p("div", {
        ref: "containerRef",
        class: [this.ns.b(), this.ns.b("collapse"), {
          [this.ns.b("editor-readonly")]: this.readonlyState
        }]
      }, [this.renderHeaserToolbar(), this.renderEditorContent(), this.hasEnableEdit && !this.readonlyState ? this.renderFooter() : null])]
    }) : p("div", {
      ref: "containerRef",
      class: [this.ns.b(), this.ns.is("allow-collapse", !0), {
        [this.ns.b("editor-readonly")]: this.readonlyState
      }]
    }, [this.renderHeaserToolbar(), this.renderEditorContent(), this.readonlyState ? this.renderToggle() : null, this.hasEnableEdit && !this.readonlyState ? this.renderFooter() : null, this.renderPreview()]);
  }
});
class ae {
  /**
   * 获取主题
   * @returns
   */
  static getThemeVar() {
    const t = document.documentElement;
    return t ? getComputedStyle(t).getPropertyValue("--ibiz-color-primary") : null;
  }
  /**
   * 是否包含中文字符
   * @param inputString
   * @returns
   */
  static isChineseCharacter(t) {
    return /[\u4e00-\u9fa5]/.test(t);
  }
  /**
   * 判断字符串是否同时存在英文和中文
   * @param str
   * @returns
   */
  static hasChineseAndEnglish(t) {
    return /[\u4e00-\u9fa5]+.*[a-zA-Z]+|[a-zA-Z]+.*[\u4e00-\u9fa5]+/.test(t);
  }
  /**
   * 字符串转16进制颜色
   * @param text
   * @returns
   */
  static stringToHexColor(t) {
    if (!t)
      return "";
    let e = 0;
    for (let h = 0; h < t.length; h++)
      if (this.isChineseCharacter(t))
        e = t.charCodeAt(h) + ((e << 5) - e), e = e & e;
      else {
        const g = t.charCodeAt(h);
        e += g.toString(16);
      }
    const s = String(e).substring(0, 6), n = parseInt(s.substring(0, 2), 16), i = parseInt(s.substring(2, 4), 16), l = parseInt(s.substring(4, 6), 16), d = "#".concat(n.toString(16).padStart(2, "0")).concat(i.toString(16).padStart(2, "0")).concat(l.toString(16).padStart(2, "0"));
    return d === "#FFFFFF" && this.getThemeVar() || d;
  }
  /**
   * 缩写名字
   * @param text
   * @returns
   */
  static avatarName(t) {
    if (t && t.toString().length < 2)
      return t;
    if (t && t.toString().length >= 2) {
      if (this.hasChineseAndEnglish(t)) {
        const i = t.split("").find((d) => /[a-zA-Z]/.test(d)) || "", l = t.split("").find((d) => /[\u4E00-\u9FA5]/.test(d)) || "";
        return "".concat(i).concat(l).toLowerCase();
      }
      return /[a-zA-Z]/.test(t) ? t.split("").filter((i) => /[a-zA-Z]/.test(i)).slice(0, 2).join("").toUpperCase() : /[\u4E00-\u9FA5]/.test(t) ? t.split("").filter((i) => /[\u4E00-\u9FA5]/.test(i)).slice(-2).join("") : t.replaceAll(" ", "").substring(0, 2);
    }
  }
}
function Qe(a, t) {
  a.data == null && (a.data = {});
  const e = a.data;
  e.style == null && (e.style = {}), Object.assign(e.style, t);
}
function Nt(a, t) {
  const { backgroundColor: e, bgColor: s } = a;
  let n = t;
  return e && Qe(n, { backgroundColor: e }), s && Qe(n, { backgroundColor: s }), n;
}
class j {
  /**
   * 添加标记
   * @param editor 编辑器
   * @param op 标记信息
   */
  static addMarks(t, e) {
    const { selection: s, mark: n } = e, i = (d, h) => {
      if (!ve.isText(d))
        return !1;
      const [g, f] = se.parent(t, h);
      return !t.isVoid(g);
    };
    if (Oe.isExpanded(s))
      xe.setNodes(t, n, {
        match: i,
        at: s,
        split: !0,
        voids: !0
      });
    else {
      const d = {
        ...se.marks(t) || {},
        ...n
      };
      t.marks = d;
    }
  }
  /**
   * 删除标记
   * @param editor 编辑器
   * @param op 标记信息
   */
  static removeMarks(t, e) {
    const { selection: s, keys: n } = e, i = (d, h) => {
      if (!ve.isText(d))
        return !1;
      const [g, f] = se.parent(t, h);
      return !t.isVoid(g);
    };
    if (Oe.isExpanded(s))
      xe.unsetNodes(t, n, {
        match: i,
        at: s,
        split: !0,
        voids: !0
      });
    else {
      const d = { ...se.marks(t) || {} };
      n.forEach((h) => {
        delete d[h];
      }), t.marks = d;
    }
  }
  /**
   * 移动用户光标节点
   * @param editor
   * @param options
   */
  static movePersNode(t, e) {
    const { param: s, node: n } = e, { id: i, cursor: l, preCursor: d } = s, { position: h, newPosition: g, selectionRange: f } = l;
    if (!f && (d != null && d.selectionRange)) {
      const C = d.selectionRange;
      this.removeMarks(t, {
        keys: ["backgroundColor"],
        selection: {
          anchor: this.calcPointByOffset(t, C.anchor),
          focus: this.calcPointByOffset(t, C.focus)
        }
      });
    }
    if (h) {
      const E = Pe.parent(t, h.path).children.findIndex((k) => k.id === i);
      E > -1 && xe.removeNodes(t, { at: [h.path[0], E] });
    }
    if (g) {
      f && this.addMarks(t, {
        mark: {
          backgroundColor: ae.stringToHexColor(i)
        },
        selection: {
          anchor: this.calcPointByOffset(t, f.anchor),
          focus: this.calcPointByOffset(t, f.focus)
        }
      });
      const C = this.calcPointByOffset(t, g);
      xe.insertNodes(t, [n], {
        at: C
      });
    }
  }
  /**
   * 根据偏移量计算位置
   * @param editor
   * @param item
   */
  static calcPointByOffset(t, e) {
    const s = Pe.parent(t, e.path);
    let n = 0, i = 0;
    s.children.forEach((d, h) => {
      ve.isText(d) && i < e.offset && (i += d.text.length || 1, n = h);
    });
    const l = s.children[n].text.length - (i - e.offset);
    return { path: [e.path[0], n], offset: l };
  }
  /**
   * 根据点位置计算偏移量
   * @param editor
   * @param point
   */
  static calcOffsetByPoint(t, e) {
    let s = e.offset;
    const n = Pe.parent(t, e.path), i = Pe.get(t, e.path);
    return ve.isText(i) && i.text.length === 0 && s === 0 && (s = 1), n.children.forEach((l, d) => {
      ve.isText(l) && d < e.path[1] && (s += l.text.length || 1);
    }), s;
  }
}
const Je = /* @__PURE__ */ ge({
  name: "HtmlComment",
  props: Ke(),
  emits: Ze(),
  setup(a, {
    emit: t
  }) {
    const e = ye("html-comment"), s = a.controller, n = b(), i = b();
    return {
      ns: e,
      c: s,
      comment: n,
      editorRef: i,
      onChange: (f) => {
        t("change", f), f && s.collapsed.value && (s.collapsed.value = !1);
      },
      onFocus: () => {
        s.collapsed.value = !1, t("focus");
      },
      onBlur: () => {
        if (t("blur"), a.value)
          return null;
        s.collapsed.value = !0;
      },
      renderAvatar: () => {
        if (s.userAvatar) {
          const E = JSON.parse(s.userAvatar);
          if (E.length === 0)
            return null;
          const {
            downloadUrl: k
          } = ibiz.util.file.calcFileUpDownUrl(s.context, s.params, a.data, s.editorParams), P = k.replace("%fileId%", E[0].id);
          return p("div", {
            class: e.e("avatar-name")
          }, [p("img", {
            src: P,
            alt: ""
          }, null)]);
        }
        const f = ae.stringToHexColor(s.context.srfusername), C = ae.avatarName(s.context.srfusername);
        return s.context.srfusername ? p("div", {
          class: e.e("avatar-name"),
          style: "background: ".concat(f, ";")
        }, [C]) : p(D("el-avatar"), {
          class: e.e("avatar"),
          src: "./assets/images/user-avatar.png"
        }, null);
      }
    };
  },
  render() {
    return this.c.mode === "default" ? p(Ft, {
      controller: this.c,
      data: this.data,
      value: this.value,
      readonly: this.readonly,
      onChange: this.onChange,
      onFocus: this.onFocus,
      onBlur: this.onBlur
    }, null) : p("div", {
      ref: "comment",
      class: [this.ns.b(), this.ns.is("collapse", this.c.collapsed.value)],
      style: {
        height: "".concat(this.c.collapsed.value ? this.c.minHeight : this.c.maxHeight, "px")
      }
    }, [this.renderAvatar(), p(mt, {
      controller: this.c,
      data: this.data,
      value: this.value,
      onChange: this.onChange,
      onFocus: this.onFocus,
      onBlur: this.onBlur
    }, null)]);
  }
});
function Ye(a, t, e, s, n) {
  const i = t === void 0 ? void 0 : t.key;
  return { sel: a, data: t, children: e, text: s, elm: n, key: i };
}
const Ge = Array.isArray;
function _e(a) {
  return typeof a == "string" || typeof a == "number" || a instanceof String || a instanceof Number;
}
function ft(a, t, e) {
  if (a.ns = "http://www.w3.org/2000/svg", e !== "foreignObject" && t !== void 0)
    for (let s = 0; s < t.length; ++s) {
      const n = t[s];
      if (typeof n == "string")
        continue;
      const i = n.data;
      i !== void 0 && ft(i, n.children, n.sel);
    }
}
function ie(a, t, e) {
  let s = {}, n, i, l;
  if (e !== void 0 ? (t !== null && (s = t), Ge(e) ? n = e : _e(e) ? i = e.toString() : e && e.sel && (n = [e])) : t != null && (Ge(t) ? n = t : _e(t) ? i = t.toString() : t && t.sel ? n = [t] : s = t), n !== void 0)
    for (l = 0; l < n.length; ++l)
      _e(n[l]) && (n[l] = Ye(void 0, void 0, void 0, n[l], void 0));
  return a[0] === "s" && a[1] === "v" && a[2] === "g" && (a.length === 3 || a[3] === "." || a[3] === "#") && ft(s, n, a), Ye(a, s, n, i, void 0);
}
function Tt(a) {
  const { script: t = "", data: e = {} } = a, s = z.execScriptFn({ data: e }, t, {
    singleRowReturn: !0,
    isAsync: !1
  });
  return "".concat(s);
}
const Rt = {
  type: "attachments",
  elemToHtml: Tt
};
function Dt(a) {
  const t = decodeURIComponent(a.getAttribute("data-value") || ""), e = JSON.parse(t);
  return {
    type: "attachments",
    script: e.script,
    data: e,
    children: [{ text: "" }]
  };
}
const It = {
  selector: 'span[data-w-e-type="attachments"]',
  parseElemHtml: Dt
};
function At(a) {
  const { data: t = {} } = a, e = {
    name: "".concat(t.name),
    id: t.id
  };
  return ie(
    "mention-elem",
    {
      dataset: { value: JSON.stringify(e) },
      props: {
        contentEditable: !1
        // 不可编辑
      }
    },
    []
  );
}
const Ut = {
  type: "attachments",
  renderElem: At
};
class zt {
  constructor() {
    r(this, "title", "本地文件");
    r(this, "tag", "button");
    r(this, "iconSvg", '<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="36px" height="36px" viewBox="0 0 36 36" version="1.1">\n    <title>附件</title>\n    <g id="附件" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\n        <g id="icon">\n            <rect id="矩形" stroke="#EEEEEE" fill="#FFFFFF" x="0.5" y="0.5" width="35" height="35" rx="4"/>\n            <g id="编组-28" transform="translate(2.997929, 8.001508)">\n                <path d="M13.9611058,12.6330155 C13.9611058,14.5460163 12.4108408,16.0968098 10.498492,16.0968098 C8.58614322,16.0968098 7.03587822,14.5460163 7.03590808,12.6393438 L7.03590808,12.6393438 L6.98338468,7.07669061 C6.97992133,6.70644889 7.27712693,6.40347538 7.64724246,6.39998034 C8.017358,6.39648531 8.32022824,6.69379224 8.32372209,7.06403396 L8.32372209,7.06403396 L8.37624485,12.6330155 C8.37624485,13.8054998 9.32640727,14.7559862 10.498492,14.7559862 C11.6705768,14.7559862 12.6207392,13.8054998 12.6207392,12.6330155 L12.6207392,12.6330155 L12.6207392,6.46506253 C12.6207392,4.69957562 11.0562006,3.24725012 9.10227678,3.24725012 C7.148353,3.24725012 5.58381437,4.69957562 5.58381437,6.46506253 L5.58381437,6.46506253 L5.58381437,12.8655397 C5.58381437,15.5621365 7.78332719,17.7497339 10.498492,17.7497339 C13.2136568,17.7497339 15.4131697,15.5621365 15.4131697,12.8655397 L15.4131697,12.8655397 L15.4131697,7.10001026 C15.4131697,6.72975204 15.713221,6.42959845 16.083353,6.42959845 C16.453485,6.42959845 16.7535363,6.72975204 16.7535363,7.10001026 L16.7535363,7.10001026 L16.7535363,12.8655397 C16.7535363,16.3043913 13.9521943,19.0905575 10.498492,19.0905575 C7.04478976,19.0905575 4.24344774,16.3043913 4.24344774,12.8655397 L4.24344774,12.8655397 L4.24344774,6.46506253 C4.24344774,3.93573556 6.42955024,1.90642651 9.10227678,1.90642651 C11.7750033,1.90642651 13.9611058,3.93573556 13.9611058,6.46506253 L13.9611058,6.46506253 Z" id="形状结合" fill="#DDDDDD" transform="translate(10.498492, 10.498492) rotate(-315.000000) translate(-10.498492, -10.498492) "/>\n                <path d="M21.6662931,9.87797441 L24.6096402,9.87797441 C24.9410111,9.87797441 25.2096402,10.1466036 25.2096402,10.4779744 C25.2096402,10.8093453 24.9410111,11.0779744 24.6096402,11.0779744 L21.6662931,11.0779744 C21.3349223,11.0779744 21.0662931,10.8093453 21.0662931,10.4779744 C21.0662931,10.1466036 21.3349223,9.87797441 21.6662931,9.87797441 Z" id="矩形备份-74" fill="#73D897"/>\n                <path d="M21.6662931,4.29120933 L27.4020707,4.29120933 C27.7334415,4.29120933 28.0020707,4.55983848 28.0020707,4.89120933 C28.0020707,5.22258018 27.7334415,5.49120933 27.4020707,5.49120933 L21.6662931,5.49120933 C21.3349223,5.49120933 21.0662931,5.22258018 21.0662931,4.89120933 C21.0662931,4.55983848 21.3349223,4.29120933 21.6662931,4.29120933 Z" id="矩形备份-75" fill="#6698FF"/>\n                <path d="M21.6662931,15.4647395 L27.4020707,15.4647395 C27.7334415,15.4647395 28.0020707,15.7333686 28.0020707,16.0647395 C28.0020707,16.3961103 27.7334415,16.6647395 27.4020707,16.6647395 L21.6662931,16.6647395 C21.3349223,16.6647395 21.0662931,16.3961103 21.0662931,16.0647395 C21.0662931,15.7333686 21.3349223,15.4647395 21.6662931,15.4647395 Z" id="矩形备份-77" fill="#FF7575"/>\n            </g>\n        </g>\n    </g>\n</svg>');
  }
  // 菜单是否需要激活（如选中加粗文本，“加粗”菜单会激活），用不到则返回 false
  isActive(t) {
    return !1;
  }
  // 获取菜单执行时的 value ，用不到则返回空 字符串或 false
  getValue(t) {
    return "";
  }
  // 菜单是否需要禁用（如选中 H1 ，“引用”菜单被禁用），用不到则返回 false
  isDisabled(t) {
    return !1;
  }
  // 点击菜单时触发的函数
  exec(t, e) {
    throw new G("暂未支持上传本地文件！");
  }
}
const Bt = {
  key: "attachments",
  factory() {
    return new zt();
  }
}, $t = {
  renderElems: [Ut],
  elemsToHtml: [Rt],
  parseElemsHtml: [It],
  menus: [Bt]
};
class Vt {
  /**
   * Creates an instance of AttachmentsController.
   * @param {IData} option
   * @memberof AttachmentsController
   */
  constructor() {
    /**
     * 模型
     *
     * @type {IEditor}
     * @memberof AttachmentsController
     */
    r(this, "model");
    /**
     * 上下文
     *
     * @type {IContext}
     */
    r(this, "context");
    /**
     * 视图参数
     *
     * @type {IParams}
     */
    r(this, "params");
    /**
     * 表单数据
     *
     * @type {IData}
     * @memberof AttachmentsController
     */
    r(this, "data", {});
    /**
     * 编辑器示例
     *
     * @type {IDomEditor}
     * @memberof AttachmentsController
     */
    r(this, "editor");
    /**
     * 编辑器参数
     *
     * @type {IData}
     * @memberof AttachmentsController
     */
    r(this, "editorParams");
    /**
     * 用户数据
     *
     * @type {IData[]}
     * @memberof AttachmentsController
     */
    r(this, "items", []);
    /**
     * 编辑器事件
     *
     * @type {ControllerEvent<commentEvent>}
     * @memberof AttachmentsController
     */
    r(this, "evt");
    /**
     * 是否正在执行
     *
     * @private
     * @type {boolean}
     * @memberof AttachmentsController
     */
    r(this, "execting", !1);
    this.registerNode();
  }
  registerNode() {
    window.attachmentsIsRegiter || (I.registerModule($t), window.attachmentsIsRegiter = !0);
  }
  /**
   * 初始化
   *
   * @param {IDomEditor} editor
   * @memberof AttachmentsController
   */
  async init(t, e) {
    this.model = e.model, this.context = e.context, this.params = e.params, this.evt = e.evt, this.data = e.data, this.editor = t, this.editorParams = this.model.editorParams;
  }
  /**
   * 控制器销毁
   *
   * @memberof AttachmentsController
   */
  onDestroyed() {
  }
  /**
   * 插入节点
   *
   * @param {IDomEditor} editor
   * @memberof AttachmentsController
   */
  insertNode(t) {
  }
  /**
   * 解析mention节点
   *
   * @param {string} value
   * @return {*}
   * @memberof AttachmentsController
   */
  parseNode(t) {
    return t;
  }
}
function qt(a) {
  const { script: t = "", data: e = {} } = a, s = z.execScriptFn({ data: e }, t, {
    singleRowReturn: !0,
    isAsync: !1
  });
  return "".concat(s);
}
const jt = {
  type: "codesnippet",
  elemToHtml: qt
};
function Jt(a) {
  const t = decodeURIComponent(a.getAttribute("data-value") || ""), e = JSON.parse(t);
  return {
    type: "codesnippet",
    script: e.script,
    data: e,
    children: [{ text: "" }]
  };
}
const _t = {
  selector: 'span[data-w-e-type="codesnippet"]',
  parseElemHtml: Jt
};
function Kt(a) {
  const { data: t = {} } = a, e = {
    name: "".concat(t.name),
    id: t.id
  };
  return ie(
    "mention-elem",
    {
      dataset: { value: JSON.stringify(e) },
      props: {
        contentEditable: !1
        // 不可编辑
      }
    },
    []
  );
}
const Zt = {
  type: "CodeSnippet",
  renderElem: Kt
};
class Wt {
  constructor() {
    r(this, "title", "代码段");
    r(this, "tag", "button");
    r(this, "iconSvg", '<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="36px" height="36px" viewBox="0 0 36 36" version="1.1">\n  <title>代码段</title>\n  <g id="代码段" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\n      <g id="icon备份">\n          <rect id="矩形" stroke="#EEEEEE" fill="#FFFFFF" x="0.5" y="0.5" width="35" height="35" rx="4"/>\n          <path d="M24.6642225,18.8794824 L27.6075695,18.8794824 C27.9389404,18.8794824 28.2075695,19.1481115 28.2075695,19.4794824 C28.2075695,19.8108532 27.9389404,20.0794824 27.6075695,20.0794824 L24.6642225,20.0794824 C24.3328516,20.0794824 24.0642225,19.8108532 24.0642225,19.4794824 C24.0642225,19.1481115 24.3328516,18.8794824 24.6642225,18.8794824 Z" id="矩形备份-74" fill="#73D897"/>\n          <path d="M24.6642225,13.2927173 L30.4,13.2927173 C30.7313708,13.2927173 31,13.5613465 31,13.8927173 C31,14.2240882 30.7313708,14.4927173 30.4,14.4927173 L24.6642225,14.4927173 C24.3328516,14.4927173 24.0642225,14.2240882 24.0642225,13.8927173 C24.0642225,13.5613465 24.3328516,13.2927173 24.6642225,13.2927173 Z" id="矩形备份-75" fill="#6698FF"/>\n          <path d="M24.6642225,24.4662475 L30.4,24.4662475 C30.7313708,24.4662475 31,24.7348766 31,25.0662475 C31,25.3976183 30.7313708,25.6662475 30.4,25.6662475 L24.6642225,25.6662475 C24.3328516,25.6662475 24.0642225,25.3976183 24.0642225,25.0662475 C24.0642225,24.7348766 24.3328516,24.4662475 24.6642225,24.4662475 Z" id="矩形备份-77" fill="#FF7575"/>\n          <g id="1.Base基础/1.icon图标/11.editor/header-1" transform="translate(5.000000, 11.000000)" fill="#DDDDDD">\n              <path d="M4.68266589,2.39258039 L1.51032474,7.44797324 L5.01586095,12.7216272 L4.05994646,13.3212428 L0.126424153,7.40475416 L3.68603474,1.72997946 L4.68266589,2.39258039 Z M11.3173341,12.6697762 L14.4896753,7.61438339 L10.984139,2.34072939 L11.9400535,1.7411138 L15.8735758,7.65760247 L12.3139653,13.3323772 L11.3173341,12.6697762 Z M8.86596086,1.31248434 L10.0376294,1.55020137 L7.19605832,13.6243456 L6.0243898,13.3866286 L8.86596086,1.31248434 Z" id="形状结合"/>\n          </g>\n      </g>\n  </g>\n</svg>');
  }
  // 菜单是否需要激活（如选中加粗文本，“加粗”菜单会激活），用不到则返回 false
  isActive(t) {
    return !1;
  }
  // 获取菜单执行时的 value ，用不到则返回空 字符串或 false
  getValue(t) {
    return "";
  }
  // 菜单是否需要禁用（如选中 H1 ，“引用”菜单被禁用），用不到则返回 false
  isDisabled(t) {
    return !1;
  }
  // 点击菜单时触发的函数
  exec(t, e) {
    throw new G("暂未支持上传代码段！");
  }
}
const Qt = {
  key: "codesnippet",
  factory() {
    return new Wt();
  }
}, Yt = {
  renderElems: [Zt],
  elemsToHtml: [jt],
  parseElemsHtml: [_t],
  menus: [Qt]
};
class Gt {
  /**
   * Creates an instance of CodeSnippetController.
   * @param {IData} option
   * @memberof CodeSnippetController
   */
  constructor() {
    /**
     * 模型
     *
     * @type {IEditor}
     * @memberof CodeSnippetController
     */
    r(this, "model");
    /**
     * 上下文
     *
     * @type {IContext}
     */
    r(this, "context");
    /**
     * 视图参数
     *
     * @type {IParams}
     */
    r(this, "params");
    /**
     * 表单数据
     *
     * @type {IData}
     * @memberof CodeSnippetController
     */
    r(this, "data", {});
    /**
     * 编辑器示例
     *
     * @type {IDomEditor}
     * @memberof CodeSnippetController
     */
    r(this, "editor");
    /**
     * 编辑器参数
     *
     * @type {IData}
     * @memberof CodeSnippetController
     */
    r(this, "editorParams");
    /**
     * 用户数据
     *
     * @type {IData[]}
     * @memberof CodeSnippetController
     */
    r(this, "items", []);
    /**
     * 编辑器事件
     *
     * @type {ControllerEvent<commentEvent>}
     * @memberof CodeSnippetController
     */
    r(this, "evt");
    /**
     * 是否正在执行
     *
     * @private
     * @type {boolean}
     * @memberof CodeSnippetController
     */
    r(this, "execting", !1);
    this.registerNode();
  }
  registerNode() {
    window.codesnippetIsRegiter || (I.registerModule(Yt), window.codesnippetIsRegiter = !0);
  }
  /**
   * 初始化
   *
   * @param {IDomEditor} editor
   * @memberof CodeSnippetController
   */
  async init(t, e) {
    this.model = e.model, this.context = e.context, this.params = e.params, this.evt = e.evt, this.data = e.data, this.editor = t, this.editorParams = this.model.editorParams;
  }
  /**
   * 控制器销毁
   *
   * @memberof CodeSnippetController
   */
  onDestroyed() {
  }
  /**
   * 插入节点
   *
   * @param {IDomEditor} editor
   * @memberof CodeSnippetController
   */
  insertNode(t) {
  }
  /**
   * 解析mention节点
   *
   * @param {string} value
   * @return {*}
   * @memberof CodeSnippetController
   */
  parseNode(t) {
    return t;
  }
}
function Xt(a) {
  const { script: t = "", data: e = {} } = a, s = z.execScriptFn({ data: e }, t, {
    singleRowReturn: !0,
    isAsync: !1
  });
  return "".concat(s);
}
const es = {
  type: "marker",
  elemToHtml: Xt
};
function ts(a) {
  const t = decodeURIComponent(a.getAttribute("data-value") || ""), e = JSON.parse(t);
  return {
    type: "marker",
    script: e.script,
    data: e,
    children: [{ text: "" }]
  };
}
const ss = {
  selector: 'span[data-w-e-type="marker"]',
  parseElemHtml: ts
};
function ns(a) {
  const { data: t = {} } = a;
  return ie(
    "mention-elem",
    {
      dataset: { value: JSON.stringify(t) },
      props: {
        contentEditable: !1
        // 不可编辑
      }
    },
    []
  );
}
const as = {
  type: "marker",
  renderElem: ns
};
let is = class {
  constructor() {
    r(this, "title", "提及工作项");
    r(this, "tag", "button");
    r(this, "iconSvg", '<svg t="1706259772097" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="6854" width="200" height="200"><path d="M929.28 625.664l-234.496 0.512 24.064-229.888 210.432-0.512c20.992 0 38.4-17.408 38.4-38.4s-17.408-38.4-38.4-38.4H727.04l29.184-275.456c2.048-20.992-13.312-39.936-34.304-41.984-20.992-2.048-39.936 13.312-41.984 34.304L650.24 318.976l-232.448 0.512 29.184-275.456c2.048-20.992-13.312-39.936-34.304-41.984-20.992-2.048-39.936 13.312-41.984 34.304l-29.696 283.648-246.272 0.512c-20.992 0-38.4 17.408-38.4 38.4s17.408 38.4 38.4 38.4l238.08-0.512-24.064 229.888-214.016 0.512c-20.992 0-38.4 17.408-38.4 38.4s17.408 38.4 38.4 38.4l205.824-0.512-29.184 276.992c-2.048 20.992 13.312 39.936 34.304 41.984h4.096c19.456 0 35.84-14.848 37.888-34.304l30.208-285.184 232.448-0.512-29.184 277.504c-2.048 20.992 13.312 39.936 34.304 41.984h4.096c19.456 0 35.84-14.848 38.4-34.304l30.208-285.184 242.688-0.512c20.992 0 38.4-17.408 38.4-38.4-1.536-20.992-18.944-37.888-39.936-37.888z m-544.256 0.512l24.064-229.888 232.448-0.512-24.064 229.888-232.448 0.512z" fill="#979797" p-id="6855"></path></svg>');
  }
  // 菜单是否需要激活（如选中加粗文本，“加粗”菜单会激活），用不到则返回 false
  isActive(t) {
    return !1;
  }
  // 获取菜单执行时的 value ，用不到则返回空 字符串或 false
  getValue(t) {
    return "";
  }
  // 菜单是否需要禁用（如选中 H1 ，“引用”菜单被禁用），用不到则返回 false
  isDisabled(t) {
    return !1;
  }
  // 点击菜单时触发的函数
  exec(t, e) {
    t.insertText("#");
  }
};
const rs = {
  key: "marker",
  factory() {
    return new is();
  }
}, os = {
  renderElems: [as],
  elemsToHtml: [es],
  parseElemsHtml: [ss],
  menus: [rs]
};
const ls = /* @__PURE__ */ ge({
  name: "MenTion",
  props: {
    controller: {
      type: Object,
      required: !0
    },
    modal: {
      type: Object
    }
  },
  setup(a) {
    const t = ye("mention"), e = a.controller, s = b(!1), n = b([]);
    let i = K;
    const l = b({}), d = b(0), h = (m) => {
      const {
        eventArg: u
      } = m;
      if (u) {
        !u.includes("@") && e.overlay && e.execting && e.overlay.dismiss();
        const w = u.match(new RegExp("(?<=\\@)([^\\@&^{]*?)(?=\\<)", "g")) || [];
        e.execting && (w.length === 0 && e.overlay.dismiss(), e.query = w.pop() || "", e.query && /\s$/.test(e.query) ? e.overlay.dismiss() : e.query && k({
          isInitialLoad: !0
        }));
      } else
        e.overlay && e.execting && e.overlay.dismiss();
    }, g = () => {
      e.evt && e.evt.on("onChange", h);
    }, f = (m = {}) => {
      s.value = !0, e.getUsers(m).then((u) => {
        (u.status !== 200 || !u.data) && (s.value = !1), u.headers["x-total"] && (d.value = Number(u.headers["x-total"])), m.isLoadMore === !0 ? n.value.push(...e.toUIData(u.data)) : (n.value = e.toUIData(u.data), n.value.length > 0 && (l.value = n.value[0])), s.value = !1;
      }).catch(() => {
        s.value = !1;
      });
    }, C = () => {
      f({
        isLoadMore: !0
      });
    }, E = et(() => n.value.length >= d.value || s.value || d.value <= e.size), k = ut(f, 300, {
      leading: !0
    });
    g(), f({
      isInitialLoad: !0
    });
    const P = (m) => {
      let u = n.value.findIndex((w) => w.id === l.value.id);
      switch (m) {
        case "up":
          u--, (u === -1 || u === -2) && (u = n.value.length - 1), l.value = n.value[u];
          break;
        case "down":
          u++, u === n.value.length && (u = 0), l.value = n.value[u];
          break;
        case "enter":
          T(l.value);
          break;
      }
    }, T = (m) => {
      var u;
      if (a.modal) {
        const w = {
          ok: !0,
          data: [m]
        };
        (u = a.modal) == null || u.dismiss(w);
      }
    }, F = (m) => {
      if (!m)
        return null;
      const u = JSON.parse(m);
      if (u.length === 0)
        return null;
      const {
        downloadUrl: w
      } = ibiz.util.file.calcFileUpDownUrl(e.context, e.params, e.editorParams);
      return w.replace("%fileId%", u[0].id);
    }, L = (m) => {
      const u = m.name, w = ae.stringToHexColor(u), H = ae.avatarName(u);
      let x = "";
      if (e.operatorMap.has(m.id)) {
        const R = e.operatorMap.get(m.id);
        R.data.iconurl && (x = F(R.data.iconurl) || "");
      }
      return p("div", {
        class: [t.e("item"), t.is("active", m.id === l.value.id)],
        onClick: () => T(m)
      }, [p("div", {
        class: t.e("avatar"),
        style: "background: ".concat(w, ";")
      }, [x ? p("img", {
        src: x
      }, null) : H]), p("div", {
        class: t.e("name"),
        title: u
      }, [u])]);
    };
    return Ne(() => {
      i = Te(window, "keyup", (m) => {
        m.keyCode === 40 ? P("down") : m.keyCode === 38 ? P("up") : m.keyCode === 13 && P("enter");
      });
    }), Fe(() => {
      i !== K && i(), e.evt.off("onChange", h);
    }), {
      ns: t,
      items: n,
      loading: s,
      isLodeMoreDisabled: E,
      renderItem: L,
      loadMore: C
    };
  },
  render() {
    return tt(p("div", {
      "infinite-scroll-distance": 10,
      "infinite-scroll-disabled": this.isLodeMoreDisabled,
      "infinite-scroll-immediate": !1,
      class: this.ns.b()
    }, [this.items.map((a) => this.renderItem(a)), this.items.length === 0 && p(D("iBizNoData"), {
      text: "暂未用户数据"
    }, null)]), [[Le("infinite-scroll"), () => this.loadMore()], [Le("loading"), this.loading]]);
  }
});
const cs = /* @__PURE__ */ ge({
  name: "Marker",
  props: {
    controller: {
      type: Object,
      required: !0
    },
    modal: {
      type: Object
    }
  },
  setup(a) {
    const t = ye("marker"), e = a.controller, s = b(!1), n = b([]);
    let i = K;
    const l = b({}), d = b(0), h = (m) => {
      const {
        eventArg: u
      } = m;
      if (u) {
        !u.includes("#") && e.overlay && e.execting && e.overlay.dismiss();
        const w = /<svg((.|[\t\r\f\n\s])+?)<\/svg>/g, x = u.replace(w, "").match(new RegExp("(?<=\\#)([^\\#&^{]*?)(?=\\<)", "g")) || [];
        e.execting && (x.length === 0 && e.overlay.dismiss(), e.query = x.pop() || "", e.query && /\s$/.test(e.query) ? e.overlay.dismiss() : e.query && k({
          isInitialLoad: !0
        }));
      } else
        e.overlay && e.execting && e.overlay.dismiss();
    }, g = () => {
      e.evt && e.evt.on("onChange", h);
    }, f = (m = {}) => {
      s.value = !0, e.load(m).then((u) => {
        (u.status !== 200 || !u.data) && (s.value = !1), u.headers["x-total"] && (d.value = Number(u.headers["x-total"])), m.isLoadMore === !0 ? n.value.push(...e.toUIData(u.data)) : (n.value = e.toUIData(u.data), n.value.length > 0 && (l.value = n.value[0])), s.value = !1;
      }).catch(() => {
        s.value = !1;
      });
    }, C = () => {
      f({
        isLoadMore: !0
      });
    }, E = et(() => n.value.length >= d.value || s.value || d.value <= e.size), k = ut(f, 300, {
      leading: !0
    });
    g(), f({
      isInitialLoad: !0
    });
    const P = (m) => {
      let u = n.value.findIndex((w) => w.id === l.value.id);
      switch (m) {
        case "up":
          u--, (u === -1 || u === -2) && (u = n.value.length - 1), l.value = n.value[u];
          break;
        case "down":
          u++, u === n.value.length && (u = 0), l.value = n.value[u];
          break;
        case "enter":
          T(l.value);
          break;
      }
    }, T = (m) => {
      var u;
      if (a.modal) {
        const w = {
          ok: !0,
          data: [m]
        };
        (u = a.modal) == null || u.dismiss(w);
      }
    }, F = (m, u) => {
      if (e.quoteCodelistMap.has(m)) {
        const w = e.quoteCodelistMap.get(m);
        return p(D("iBizCodeList"), {
          codeListItems: w.codeListItems,
          codeList: w.codeList,
          value: u
        }, null);
      }
      return u;
    }, L = (m) => p("div", {
      class: [t.e("item"), t.is("active", m.id === l.value.id)],
      onClick: () => T(m)
    }, [p("div", {
      class: t.e("type")
    }, [F("type", m.type)]), p("div", {
      class: t.e("identifier")
    }, [F("identifier", m.identifier)]), p("div", {
      class: t.e("name"),
      title: m.name
    }, [F("name", m.name)])]);
    return Ne(() => {
      i = Te(window, "keyup", (m) => {
        m.keyCode === 40 ? P("down") : m.keyCode === 38 ? P("up") : m.keyCode === 13 && P("enter");
      });
    }), Fe(() => {
      i !== K && i(), e.evt.off("onChange", h);
    }), {
      ns: t,
      items: n,
      loading: s,
      isLodeMoreDisabled: E,
      renderItem: L,
      loadMore: C
    };
  },
  render() {
    return tt(p("div", {
      "infinite-scroll-distance": 10,
      "infinite-scroll-disabled": this.isLodeMoreDisabled,
      "infinite-scroll-immediate": !1,
      class: this.ns.b()
    }, [this.items.map((a) => this.renderItem(a)), this.items.length === 0 && p(D("iBizNoData"), {
      text: "暂未用户数据"
    }, null)]), [[Le("infinite-scroll"), () => this.loadMore()], [Le("loading"), this.loading]]);
  }
});
class ds {
  /**
   * Creates an instance of MarkerController.
   * @param {IData} option
   * @memberof MarkerController
   */
  constructor() {
    /**
     * 模型
     *
     * @type {IEditor}
     * @memberof MarkerController
     */
    r(this, "model");
    /**
     * 上下文
     *
     * @type {IContext}
     */
    r(this, "context");
    /**
     * 视图参数
     *
     * @type {IParams}
     */
    r(this, "params");
    /**
     * 表单数据
     *
     * @type {IData}
     * @memberof MarkerController
     */
    r(this, "data", {});
    /**
     * 编辑器示例
     *
     * @type {IDomEditor}
     * @memberof MarkerController
     */
    r(this, "editor");
    /**
     * 引用请求url
     *
     * @type {string}
     * @memberof MarkerController
     */
    r(this, "quoteUrl", "");
    /**
     * 人员UI转化
     */
    r(this, "quoteFieldMap", {
      id: "id",
      name: "name"
    });
    /**
     * 代码表map
     *
     * @type {IData}
     * @memberof MarkerController
     */
    r(this, "quoteCodelistMap", /* @__PURE__ */ new Map());
    /**
     * 请求方法
     *
     * @type {('post' | 'get')}
     * @memberof MarkerController
     */
    r(this, "quoteMethod", "post");
    /**
     * 请求参数
     *
     * @type {IData}
     * @memberof MarkerController
     */
    r(this, "quoteParams", {});
    /**
     * 转换脚本
     *
     * @type {string}
     * @memberof MenTionController
     */
    r(this, "quoteScript", "`#{id=${data.id},name=${data.name},identifier=${data.identifier},icon=${data.icon}}`");
    /**
     * 逆转换脚本
     *
     * @type {string}
     * @memberof MenTionController
     */
    r(this, "quoteInScript", "value.replaceAll(/#{id=(.+?),name=(.+?),identifier=(.+?),icon=((.|[\\t\\r\\f\\n\\s])+?)}/g,(x, id, name, identifier, icon) => {return controller.getNodeInfo({ id, name, identifier, icon })})");
    /**
     * 编辑器参数
     *
     * @type {IData}
     * @memberof MarkerController
     */
    r(this, "editorParams");
    /**
     * 用户数据
     *
     * @type {IData[]}
     * @memberof MarkerController
     */
    r(this, "items", []);
    /**
     * 气泡容器
     *
     * @type {IOverlayPopoverContainer}
     * @memberof MarkerController
     */
    r(this, "overlay", null);
    /**
     * 编辑器事件
     *
     * @type {ControllerEvent<commentEvent>}
     * @memberof MarkerController
     */
    r(this, "evt");
    /**
     * 是否正在执行
     *
     * @private
     * @type {boolean}
     * @memberof MarkerController
     */
    r(this, "execting", !1);
    /**
     * 搜索字段
     *
     * @type {string}
     * @memberof MarkerController
     */
    r(this, "query", "");
    /**
     * 当前页
     *
     * @type {number}
     * @memberof MarkerController
     */
    r(this, "curPage", 0);
    /**
     * 分页条数
     *
     * @type {number}
     * @memberof MarkerController
     */
    r(this, "size", 20);
    /**
     * 预定义阻止捕获事件code
     *
     * @type {number[]}
     * @memberof MarkerController
     */
    r(this, "presetPreventEvents", [13, 38, 40]);
    /**
     * 预定义阻止冒泡事件code
     *
     * @type {number[]}
     * @memberof MarkerController
     */
    r(this, "presetPreventPropEvents", [27]);
    /**
     * 删除回调
     *
     * @type {NOOP}
     * @memberof MarkerController
     */
    r(this, "cleanup", K);
    this.registerNode();
  }
  /**
   * 声明'@'插件
   *
   * @template T
   * @param {T} editor
   * @return {*}
   * @memberof MarkerController
   */
  markerPlugin(t) {
    const { insertText: e, isInline: s, isVoid: n } = t;
    return t.insertText = (i) => {
      if (!this.editor) {
        e(i);
        return;
      }
      if (!this.editor.isFocused()) {
        e(i);
        return;
      }
      if (_.getSelectedElems(t).some((h) => t.isVoid(h))) {
        e(i);
        return;
      }
      i === "#" && !this.execting && (this.query = "", this.showModal()), e(i);
    }, t.isInline = (i) => _.getNodeType(i) === "marker" ? !0 : s(i), t.isVoid = (i) => _.getNodeType(i) === "marker" ? !0 : n(i), t;
  }
  registerNode() {
    window.markerIsRegiter || (I.registerModule(os), window.markerIsRegiter = !0), I.registerPlugin(this.markerPlugin.bind(this));
  }
  /**
   * 初始化
   *
   * @param {IDomEditor} editor
   * @memberof MarkerController
   */
  async init(t, e) {
    if (this.model = e.model, this.context = e.context, this.params = e.params, this.evt = e.evt, this.data = e.data, this.editor = t, this.editorParams = this.model.editorParams, this.editorParams) {
      const {
        QUOTEURL: n,
        QUOTEFIELDMAP: i,
        QUOTEMETHOD: l,
        QUOTESCRIPT: d,
        QUOTEINSCRIPT: h,
        QUOTEPARAMS: g,
        QUOTECODELISTMAP: f
      } = this.editorParams;
      if (n && (this.quoteUrl = n), i && (this.quoteFieldMap = JSON.parse(i)), l && (this.quoteMethod = l.toLowerCase()), g && (this.quoteParams = JSON.parse(g)), d && (this.quoteScript = d), h && (this.quoteInScript = h), f) {
        const C = JSON.parse(f);
        this.setCodeListMap(C);
      }
    }
    const s = this.editor.getEditableContainer();
    s && (this.cleanup = Te(s, "keydown", (n) => {
      var i;
      this.execting && this.presetPreventEvents.includes(n.keyCode) && n.preventDefault(), this.execting && this.presetPreventPropEvents.includes(n.keyCode) && (n.stopPropagation(), (i = this.overlay) == null || i.dismiss());
    }));
  }
  onDestroyed() {
    this.cleanup !== K && this.cleanup(), this.overlay && this.overlay.dismiss();
  }
  // 设置代码表map
  async setCodeListMap(t) {
    for (const e in t) {
      const s = await this.loadCodeList(t[e]);
      s && this.quoteCodelistMap.set(e, s);
    }
  }
  // 显示弹框
  showModal() {
    if (!this.quoteUrl)
      throw new G("未配置提及工作项QUOTEURL编辑器参数！");
    const t = document.getSelection();
    if (!t)
      return;
    const { focusNode: e } = t;
    e && this.openPopover(e.parentNode).then(
      (s) => {
        s.length > 0 && this.insertNode(s[0]);
      }
    );
  }
  findCodeListItem(t, e) {
    if (t) {
      const s = t.find((n) => n.value == e);
      if (s)
        return s;
      for (let n = 0; n < t.length; n++) {
        const i = this.findCodeListItem(
          t[n].children,
          e
        );
        if (i)
          return i;
      }
    }
  }
  /**
   * 插入@
   *
   * @param {IDomEditor} editor
   * @memberof MarkerController
   */
  insertNode(t) {
    if (this.quoteCodelistMap.has("type") && t.type) {
      const s = this.quoteCodelistMap.get("type"), n = this.findCodeListItem(s.codeListItems, t.type);
      n && n.sysImage && Object.assign(t, {
        icon: n.sysImage.rawContent
      });
    }
    const e = {
      type: "marker",
      script: this.quoteScript,
      data: t,
      children: [{ text: "" }]
    };
    this.editor.restoreSelection(), this.editor.deleteBackward("character");
    for (let s = 0; s < this.query.length; s++)
      this.editor.deleteBackward("character");
    this.editor.insertNode(e), this.editor.move(1);
  }
  /**
   * 获取节点信息
   *
   * @param {IData} data
   * @memberof MenTionController
   */
  getNodeInfo(t) {
    return Object.assign(t, { script: this.quoteScript }), '<span data-w-e-type="marker" data-w-e-is-void data-w-e-is-inline data-value="'.concat(encodeURIComponent(
      JSON.stringify(t)
    ), '"></span>');
  }
  /**
   * 解析marker节点
   *
   * @param {string} value
   * @return {*}
   * @memberof MarkerController
   */
  parseNode(t) {
    return z.execScriptFn(
      { value: t, controller: this },
      this.quoteInScript,
      {
        singleRowReturn: !0,
        isAsync: !1
      }
    );
  }
  /**
   * 处理公共参数
   *
   * @param {IData} data
   * @param {IContext} context
   * @param {IParams} params
   * @return {*}  {{ context: IContext; params: IParams }}
   * @memberof MarkerController
   */
  handlePublicParams(t, e, s) {
    const { navigateContexts: n, navigateParams: i } = this.model;
    let l = {};
    n && t && (l = He(n, t, s, e));
    const d = Object.assign(e.clone(), l);
    let h = {};
    return i && t && (h = He(i, t, s, e)), { context: d, params: h };
  }
  /**
   * 获取工作项信息
   *
   * @param {IData} data
   * @return {*}  {Promise<IData[]>}
   * @memberof MarkerController
   */
  load(t = {}) {
    const { context: e, params: s } = this.handlePublicParams(
      this.data,
      this.context,
      this.params
    ), n = t.isInitialLoad === !0, i = t.isLoadMore === !0;
    n ? this.curPage = 0 : i && (this.curPage += 1);
    const l = z.execScriptFn(
      { data: this.data, context: e, params: s },
      this.quoteUrl,
      {
        singleRowReturn: !0,
        isAsync: !1
      }
    ), d = {
      ...s,
      query: this.query,
      size: this.size,
      page: this.curPage,
      ...this.quoteParams
    };
    return ibiz.net[this.quoteMethod](l, d);
  }
  /**
   * 转换ui数据
   *
   * @param {IData[]} data
   * @return {*}  {IData[]}
   * @memberof MarkerController
   */
  toUIData(t) {
    return t.map((e) => {
      const s = {};
      return Object.keys(this.quoteFieldMap).forEach((n) => {
        s[n] = e[this.quoteFieldMap[n]];
      }), s;
    });
  }
  /**
   * 打开用户列表气泡框
   *
   * @param {HTMLElement} event
   * @memberof MarkerController
   */
  async openPopover(t) {
    this.overlay = ibiz.overlay.createPopover(
      this.createOverlayView(),
      void 0,
      {
        placement: "bottom-start",
        autoClose: !0,
        width: "300px",
        noArrow: !0
      }
    ), await this.overlay.present(t), this.execting = !0;
    const e = await this.overlay.onWillDismiss();
    return this.execting = !1, e.data || [];
  }
  createOverlayView() {
    return (t) => st(cs, {
      controller: this,
      modal: t
    });
  }
  /**
   * 加载代码表
   *
   * @param {string} appCodeListId
   * @return {*}  {(Promise<IData | undefined>)}
   * @memberof MarkerController
   */
  async loadCodeList(t) {
    const e = ibiz.hub.getApp(this.context.srfappid), s = e.codeList.getCodeList(t), n = await e.codeList.get(
      t,
      this.context,
      this.params
    );
    return { codeList: s, codeListItems: n };
  }
}
function us(a) {
  const { script: t = "", data: e = {} } = a, s = z.execScriptFn({ data: e }, t, {
    singleRowReturn: !0,
    isAsync: !1
  });
  return "".concat(s);
}
const hs = {
  type: "mention",
  elemToHtml: us
};
function ms(a) {
  const t = decodeURIComponent(a.getAttribute("data-value") || ""), e = JSON.parse(t);
  return {
    type: "mention",
    script: e.script,
    data: e,
    children: [{ text: "" }]
  };
}
const fs = {
  selector: 'span[data-w-e-type="mention"]',
  parseElemHtml: ms
};
function ps(a) {
  const { data: t = {} } = a, e = {
    name: "@".concat(t.name),
    id: t.id
  };
  return ie(
    "mention-elem",
    {
      dataset: { value: JSON.stringify(e) },
      props: {
        contentEditable: !1
        // 不可编辑
      }
    },
    []
  );
}
const vs = {
  type: "mention",
  renderElem: ps
};
class gs {
  constructor() {
    r(this, "title", "提及成员");
    r(this, "tag", "button");
    r(this, "iconSvg", '<svg t="1705979200437" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4218" xmlns:xlink="http://www.w3.org/1999/xlink" width="200" height="200"><path d="M23.7 555c0-339.3 247-550 533.8-550 295.6 0 442.8 165.9 442.8 401.6 0 210.8-93.5 361.7-237 361.7-63.6 0-108.5-26.2-137.2-78.6-48.6 51.1-96 79.8-174.6 79.8-116 0-178.4-77.3-178.4-193.3 0-209.5 131-323 251.9-323 64.9 0 102.3 24.9 122.2 68.6l11.2-58.6 114.7 1.2L727 510.1c-7.5 36.2-11.2 63.6-11.2 81.1 0 44.9 22.5 71.1 56.1 71.1 63.6 0 106-89.8 106-243.2 0-205.8-114.7-300.6-323-300.6-220.8 0-405.4 163.4-405.4 436.5 0 238.2 132.2 350.5 390.4 350.5 94.8 0 174.6-12.5 255.7-36.2v109.8c-88.6 26.2-177.1 39.9-263.2 39.9-329.1 0-508.7-168.4-508.7-464z m585-44.9c3.7-20 6.2-39.9 6.2-53.6 0-56.1-15-96-83.6-96-83.6 0-133.5 108.5-133.5 212 0 44.9 13.7 88.6 77.3 88.6 73.7-0.1 114.9-57.4 133.6-151z" fill="#333333" p-id="4219"></path></svg>');
  }
  // 菜单是否需要激活（如选中加粗文本，“加粗”菜单会激活），用不到则返回 false
  isActive(t) {
    return !1;
  }
  // 获取菜单执行时的 value ，用不到则返回空 字符串或 false
  getValue(t) {
    return "";
  }
  // 菜单是否需要禁用（如选中 H1 ，“引用”菜单被禁用），用不到则返回 false
  isDisabled(t) {
    return !1;
  }
  // 点击菜单时触发的函数
  exec(t, e) {
    t.insertText("@");
  }
}
const ys = {
  key: "mention",
  factory() {
    return new gs();
  }
}, bs = {
  renderElems: [vs],
  elemsToHtml: [hs],
  parseElemsHtml: [fs],
  menus: [ys]
};
class Cs {
  /**
   * Creates an instance of MenTionController.
   * @param {IData} option
   * @memberof MenTionController
   */
  constructor() {
    /**
     *云系统操作者Map
     *
     * @memberof MenTionController
     */
    r(this, "operatorMap", /* @__PURE__ */ new Map());
    /**
     * 模型
     *
     * @type {IEditor}
     * @memberof MenTionController
     */
    r(this, "model");
    /**
     * 上下文
     *
     * @type {IContext}
     */
    r(this, "context");
    /**
     * 视图参数
     *
     * @type {IParams}
     */
    r(this, "params");
    /**
     * 表单数据
     *
     * @type {IData}
     * @memberof MenTionController
     */
    r(this, "data", {});
    /**
     * 编辑器示例
     *
     * @type {IDomEditor}
     * @memberof MenTionController
     */
    r(this, "editor");
    /**
     * 用户请求url
     *
     * @type {string}
     * @memberof MenTionController
     */
    r(this, "userUrl", "");
    /**
     * 人员UI转化
     */
    r(this, "userFieldMap", {
      id: "id",
      name: "name"
    });
    /**
     * 请求方法
     *
     * @type {('post' | 'get')}
     * @memberof MenTionController
     */
    r(this, "userMethod", "post");
    /**
     * 转换脚本
     *
     * @type {string}
     * @memberof MenTionController
     */
    r(this, "userScript", "`@{userid=${data.id},name=${data.name}}`");
    /**
     * 逆转换脚本
     *
     * @type {string}
     * @memberof MenTionController
     */
    r(this, "userInScript", "value.replaceAll(/@{userid=(.+?),name=(.+?)}/g,(x, id, name) => {return controller.getNodeInfo({ id, name })})");
    /**
     * 编辑器参数
     *
     * @type {IData}
     * @memberof MenTionController
     */
    r(this, "editorParams");
    /**
     * 用户数据
     *
     * @type {IData[]}
     * @memberof MenTionController
     */
    r(this, "items", []);
    /**
     * 气泡容器
     *
     * @type {IOverlayPopoverContainer}
     * @memberof MenTionController
     */
    r(this, "overlay", null);
    /**
     * 编辑器事件
     *
     * @type {ControllerEvent<commentEvent>}
     * @memberof MenTionController
     */
    r(this, "evt");
    /**
     * 是否正在执行
     *
     * @private
     * @type {boolean}
     * @memberof MenTionController
     */
    r(this, "execting", !1);
    /**
     * 搜索字段
     *
     * @type {string}
     * @memberof MenTionController
     */
    r(this, "query", "");
    /**
     * 当前页
     *
     * @type {number}
     * @memberof MenTionController
     */
    r(this, "curPage", 0);
    /**
     * 分页条数
     *
     * @type {number}
     * @memberof MenTionController
     */
    r(this, "size", 20);
    /**
     * 预定义阻止捕获事件code
     *
     * @type {number[]}
     * @memberof MenTionController
     */
    r(this, "presetPreventEvents", [13, 38, 40]);
    /**
     * 预定义阻止冒泡事件code
     *
     * @type {number[]}
     * @memberof MenTionController
     */
    r(this, "presetPreventPropEvents", [27]);
    /**
     * 删除回调
     *
     * @type {NOOP}
     * @memberof MenTionController
     */
    r(this, "cleanup", K);
    this.registerNode();
  }
  /**
   * 声明'@'插件
   *
   * @template T
   * @param {T} editor
   * @return {*}
   * @memberof MenTionController
   */
  mentionPlugin(t) {
    const { insertText: e, isInline: s, isVoid: n } = t;
    return t.insertText = (i) => {
      if (!this.editor) {
        e(i);
        return;
      }
      if (!this.editor.isFocused()) {
        e(i);
        return;
      }
      if (_.getSelectedElems(t).some((h) => t.isVoid(h))) {
        e(i);
        return;
      }
      i === "@" && !this.execting && (this.query = "", this.showModal()), e(i);
    }, t.isInline = (i) => _.getNodeType(i) === "mention" ? !0 : s(i), t.isVoid = (i) => _.getNodeType(i) === "mention" ? !0 : n(i), t;
  }
  registerNode() {
    window.mentionIsRegiter || (I.registerModule(bs), window.mentionIsRegiter = !0), I.registerPlugin(this.mentionPlugin.bind(this));
  }
  /**
   * 初始化
   *
   * @param {IDomEditor} editor
   * @memberof MenTionController
   */
  async init(t, e) {
    if (this.model = e.model, this.context = e.context, this.params = e.params, this.evt = e.evt, this.data = e.data, this.editor = t, this.editorParams = this.model.editorParams, this.editorParams) {
      const { USERURL: n, USERFIELDMAP: i, USERMETHOD: l, USERSCRIPT: d, USERINSCRIPT: h } = this.editorParams;
      n && (this.userUrl = n), i && (this.userFieldMap = JSON.parse(i)), l && (this.userMethod = l.toLowerCase()), d && (this.userScript = d), h && (this.userInScript = h);
    }
    const s = this.editor.getEditableContainer();
    s && (this.cleanup = Te(s, "keydown", (n) => {
      var i;
      this.execting && this.presetPreventEvents.includes(n.keyCode) && n.preventDefault(), this.execting && this.presetPreventPropEvents.includes(n.keyCode) && (n.stopPropagation(), (i = this.overlay) == null || i.dismiss());
    })), await this.getOperatorUserList();
  }
  /**
   * 获取云系统操作者
   *
   * @memberof MenTionController
   */
  async getOperatorUserList() {
    const t = await ibiz.hub.getApp(this.context.srfappid);
    let e = [];
    e = await t.codeList.get(
      "SysOperator",
      this.context,
      this.params
    ), this.operatorMap = new Map(
      e.map((s) => [s.value, s])
    );
  }
  onDestroyed() {
    this.cleanup !== K && this.cleanup(), this.overlay && this.overlay.dismiss();
  }
  // 显示弹框
  showModal() {
    if (!this.userUrl)
      throw new G("未配置提及用户USERURL编辑器参数！");
    const t = document.getSelection();
    if (!t)
      return;
    const { focusNode: e } = t;
    e && this.openUserPopover(e.parentNode).then(
      (s) => {
        s.length > 0 && this.insertNode(s[0]);
      }
    );
  }
  /**
   * 插入@
   *
   * @param {IDomEditor} editor
   * @memberof MenTionController
   */
  insertNode(t) {
    const e = {
      type: "mention",
      script: this.userScript,
      data: t,
      children: [{ text: "" }]
    };
    this.editor.restoreSelection(), this.editor.deleteBackward("character");
    for (let s = 0; s < this.query.length; s++)
      this.editor.deleteBackward("character");
    this.editor.insertNode(e), this.editor.move(1);
  }
  /**
   * 获取节点信息
   *
   * @param {IData} data
   * @memberof MenTionController
   */
  getNodeInfo(t) {
    return Object.assign(t, { script: this.userScript }), '<span data-w-e-type="mention" data-w-e-is-void data-w-e-is-inline data-value="'.concat(encodeURIComponent(
      JSON.stringify(t)
    ), '"></span>');
  }
  /**
   * 解析mention节点
   *
   * @param {string} value
   * @return {*}
   * @memberof MenTionController
   */
  parseNode(t) {
    return z.execScriptFn(
      { value: t, controller: this },
      this.userInScript,
      {
        singleRowReturn: !0,
        isAsync: !1
      }
    );
  }
  /**
   * 处理公共参数
   *
   * @param {IData} data
   * @param {IContext} context
   * @param {IParams} params
   * @return {*}  {{ context: IContext; params: IParams }}
   * @memberof MenTionController
   */
  handlePublicParams(t, e, s) {
    const { navigateContexts: n, navigateParams: i } = this.model;
    let l = {};
    n && t && (l = He(n, t, s, e));
    const d = Object.assign(e.clone(), l);
    let h = {};
    return i && t && (h = He(i, t, s, e)), { context: d, params: h };
  }
  /**
   * 获取用户信息
   *
   * @param {IData} data
   * @return {*}  {Promise<IData[]>}
   * @memberof MenTionController
   */
  getUsers(t = {}) {
    const { context: e, params: s } = this.handlePublicParams(
      this.data,
      this.context,
      this.params
    ), n = t.isInitialLoad === !0, i = t.isLoadMore === !0;
    n ? this.curPage = 0 : i && (this.curPage += 1);
    const l = z.execScriptFn(
      { data: this.data, context: e, params: s },
      this.userUrl,
      {
        singleRowReturn: !0,
        isAsync: !1
      }
    ), d = {
      ...s,
      query: this.query,
      size: this.size,
      page: this.curPage
    };
    return ibiz.net[this.userMethod](l, d);
  }
  /**
   * 转换ui数据
   *
   * @param {IData[]} data
   * @return {*}  {IData[]}
   * @memberof MenTionController
   */
  toUIData(t) {
    return t.map((e) => {
      const s = {};
      return Object.keys(this.userFieldMap).forEach((n) => {
        s[n] = e[this.userFieldMap[n]];
      }), s;
    });
  }
  /**
   * 打开用户列表气泡框
   *
   * @param {HTMLElement} event
   * @memberof MenTionController
   */
  async openUserPopover(t) {
    this.overlay = ibiz.overlay.createPopover(
      this.createOverlayView(),
      void 0,
      {
        placement: "bottom-start",
        autoClose: !0,
        width: "300px",
        noArrow: !0
      }
    ), await this.overlay.present(t), this.execting = !0;
    const e = await this.overlay.onWillDismiss();
    return this.execting = !1, e.data || [];
  }
  createOverlayView() {
    return (t) => st(ls, {
      controller: this,
      modal: t
    });
  }
}
function ws(a) {
  const { script: t = "", data: e = {} } = a, s = z.execScriptFn({ data: e }, t, {
    singleRowReturn: !0,
    isAsync: !1
  });
  return "".concat(s);
}
const Es = {
  type: "page",
  elemToHtml: ws
};
function ks(a) {
  const t = decodeURIComponent(a.getAttribute("data-value") || ""), e = JSON.parse(t);
  return {
    type: "page",
    script: e.script,
    data: e,
    children: [{ text: "" }]
  };
}
const Ss = {
  selector: 'span[data-w-e-type="page"]',
  parseElemHtml: ks
};
function Ms(a) {
  const { data: t = {} } = a, e = {
    name: "".concat(t.name),
    id: t.id
  };
  return ie(
    "mention-elem",
    {
      dataset: { value: JSON.stringify(e) },
      props: {
        contentEditable: !1
        // 不可编辑
      }
    },
    []
  );
}
const xs = {
  type: "Page",
  renderElem: Ms
};
class Ps {
  constructor() {
    r(this, "title", "页面");
    r(this, "tag", "button");
    r(this, "iconSvg", '<svg t="1707293566679" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="6103" width="200" height="200"><path d="M288 512l256 0C561.92 512 576 497.92 576 480 576 462.08 561.92 448 544 448l-256 0C270.08 448 256 462.08 256 480 256 497.92 270.08 512 288 512zM768 64 192 64C121.6 64 64 121.6 64 192l0 576c0 70.4 57.6 128 128 128l576 0c70.4 0 128-57.6 128-128L896 192C896 121.6 838.4 64 768 64zM832 768c0 35.2-28.8 64-64 64L192 832c-35.2 0-64-28.8-64-64L128 192c0-35.2 28.8-64 64-64l576 0c35.2 0 64 28.8 64 64L832 768zM672 256l-384 0C270.08 256 256 270.08 256 288 256 305.92 270.08 320 288 320l384 0C689.92 320 704 305.92 704 288 704 270.08 689.92 256 672 256zM608 640l-320 0C270.08 640 256 654.08 256 672l0 0C256 689.92 270.08 704 288 704l320 0c17.92 0 32-14.08 32-32l0 0C640 654.08 625.92 640 608 640z" p-id="6104"></path></svg>');
  }
  // 菜单是否需要激活（如选中加粗文本，“加粗”菜单会激活），用不到则返回 false
  isActive(t) {
    return !1;
  }
  // 获取菜单执行时的 value ，用不到则返回空 字符串或 false
  getValue(t) {
    return "";
  }
  // 菜单是否需要禁用（如选中 H1 ，“引用”菜单被禁用），用不到则返回 false
  isDisabled(t) {
    return !1;
  }
  // 点击菜单时触发的函数
  exec(t, e) {
    throw new G("暂未支持上传页面！");
  }
}
const Ls = {
  key: "page",
  factory() {
    return new Ps();
  }
}, Hs = {
  renderElems: [xs],
  elemsToHtml: [Es],
  parseElemsHtml: [Ss],
  menus: [Ls]
};
class Os {
  /**
   * Creates an instance of PageController.
   * @param {IData} option
   * @memberof PageController
   */
  constructor() {
    /**
     * 模型
     *
     * @type {IEditor}
     * @memberof PageController
     */
    r(this, "model");
    /**
     * 上下文
     *
     * @type {IContext}
     */
    r(this, "context");
    /**
     * 视图参数
     *
     * @type {IParams}
     */
    r(this, "params");
    /**
     * 表单数据
     *
     * @type {IData}
     * @memberof PageController
     */
    r(this, "data", {});
    /**
     * 编辑器示例
     *
     * @type {IDomEditor}
     * @memberof PageController
     */
    r(this, "editor");
    /**
     * 编辑器参数
     *
     * @type {IData}
     * @memberof PageController
     */
    r(this, "editorParams");
    /**
     * 用户数据
     *
     * @type {IData[]}
     * @memberof PageController
     */
    r(this, "items", []);
    /**
     * 编辑器事件
     *
     * @type {ControllerEvent<commentEvent>}
     * @memberof PageController
     */
    r(this, "evt");
    /**
     * 是否正在执行
     *
     * @private
     * @type {boolean}
     * @memberof PageController
     */
    r(this, "execting", !1);
    this.registerNode();
  }
  registerNode() {
    window.pageIsRegiter || (I.registerModule(Hs), window.pageIsRegiter = !0);
  }
  /**
   * 初始化
   *
   * @param {IDomEditor} editor
   * @memberof PageController
   */
  async init(t, e) {
    this.model = e.model, this.context = e.context, this.params = e.params, this.evt = e.evt, this.data = e.data, this.editor = t, this.editorParams = this.model.editorParams;
  }
  /**
   * 控制器销毁
   *
   * @memberof PageController
   */
  onDestroyed() {
  }
  /**
   * 插入节点
   *
   * @param {IDomEditor} editor
   * @memberof PageController
   */
  insertNode(t) {
  }
  /**
   * 解析mention节点
   *
   * @param {string} value
   * @return {*}
   * @memberof PageController
   */
  parseNode(t) {
    return t;
  }
}
class J {
  /**
   * 初始化
   *
   * @static
   * @memberof CustomNodeFactory
   */
  static init(t) {
    this.registerMap.set("mention", Cs), this.registerMap.set("marker", ds), this.registerMap.set("attachments", Vt), this.registerMap.set("codesnippet", Gt), this.registerMap.set("page", Os), this.presetNodes.forEach((e) => {
      this.registerPlugin({
        type: e,
        id: "".concat(e).concat(t)
      });
    });
  }
  /**
   * 注册节点适配器
   *
   * @public
   * @memberof CustomNodeFactory
   */
  static registerPlugin(t) {
    const { type: e, id: s } = t;
    if (this.customNodeMap.has(s))
      return this.customNodeMap.get(s);
    const n = this.registerMap.get(e);
    if (n) {
      const i = new n();
      return this.customNodeMap.set(s, i), i;
    }
  }
  /**
   * 根据uuid获取注册插件
   *
   * @static
   * @param {string} id
   * @return {*}
   * @memberof CustomNodeFactory
   */
  static getPluginsById(t) {
    const e = [];
    return this.presetNodes.forEach((s) => {
      this.customNodeMap.has("".concat(s).concat(t)) && e.push(this.customNodeMap.get("".concat(s).concat(t)));
    }), e;
  }
  /**
   * 卸载节点适配器
   *
   * @public
   * @memberof CustomNodeFactory
   */
  static unregisterPlugin(t) {
    const { id: e } = t;
    this.customNodeMap.has(e) && this.customNodeMap.delete(e);
  }
  /**
   * 初始化
   *
   * @static
   * @memberof CustomNodeFactory
   */
  static destroy(t) {
    this.presetNodes.forEach((e) => {
      this.unregisterPlugin({
        id: "".concat(e).concat(t)
      });
    }), this.registerMap.delete("mention"), this.registerMap.delete("marker"), this.registerMap.delete("attachments"), this.registerMap.delete("codesnippet"), this.registerMap.delete("page");
  }
}
/**
 * 自定义节点
 *
 * @static
 * @type {IData}
 * @memberof CustomNodeFactory
 */
r(J, "customNodeMap", /* @__PURE__ */ new Map()), /**
 * 预置注册表
 *
 * @type {Map<string, any>}
 * @memberof CustomNodeFactory
 */
r(J, "registerMap", /* @__PURE__ */ new Map()), /**
 * 预置注册节点
 *
 * @static
 * @memberof CustomNodeFactory
 */
r(J, "presetNodes", [
  "mention",
  "marker",
  "attachments",
  "codesnippet",
  "page"
]);
class Fs extends HTMLElement {
  // 监听的 attr
  static get observedAttributes() {
    return ["data-value"];
  }
  attributeChangedCallback(t, e, s) {
    if (t === "data-value") {
      if (s && e === s)
        return;
      const n = JSON.parse(s), i = this.attachShadow({ mode: "open" }), l = i.ownerDocument;
      if (n.icon) {
        const h = l.createElement("span");
        h.part.add("svg"), h.innerHTML = n.icon, i.appendChild(h);
      }
      if (n.identifier) {
        const h = l.createElement("span");
        h.part.add("identifier"), h.innerHTML = n.identifier, i.appendChild(h);
      }
      if (n.name) {
        const h = l.createElement("span");
        h.part.add("name"), h.innerHTML = n.name, i.appendChild(h);
      }
      const d = l.createElement("style");
      d.innerHTML = "\n      svg {\n        height: 1em;\n        width: 1em;\n      }\n    ", i.appendChild(d);
    }
  }
}
class Ns extends HTMLElement {
  // 监听的 attr
  static get observedAttributes() {
    return ["data-value"];
  }
  attributeChangedCallback(t, e, s) {
    if (t === "data-value") {
      if (s && e === s)
        return;
      const n = JSON.parse(s), i = this.attachShadow({ mode: "open" }), l = i.ownerDocument, d = l.createElement("div");
      d.part.add("box"), d.classList.add("personnel-marker_box");
      let h = "";
      if (n.name) {
        h = ae.stringToHexColor(n.name);
        const C = l.createElement("div");
        C.part.add("name"), C.classList.add("personnel-marker_name"), C.style.backgroundColor = h, C.innerHTML = n.name, d.appendChild(C);
      }
      const g = l.createElement("div");
      g.part.add("line"), g.classList.add("personnel-marker_line"), g.style.backgroundColor = h, d.appendChild(g), i.appendChild(d);
      const f = l.createElement("style");
      d.appendChild(f);
    }
  }
}
class Ts {
  constructor() {
    r(this, "title", "格式刷");
    r(this, "tag", "button");
    r(this, "fragment", []);
    r(this, "format", {});
    r(this, "editor", null);
    r(this, "excting", !1);
    r(this, "iconSvg", '<svg viewBox="0 0 16 16" xmlns="http://www.w3.org/2000/svg" fit="" height="1em" width="1em" preserveAspectRatio="xMidYMid meet" focusable="false"><g id="aqseditor/paintformat" stroke-width="1" fill-rule="evenodd"><path d="M3 5.24h10V2H3v3.24zM13.299 1H2.701A.701.701 0 0 0 2 1.701v3.838c0 .387.314.701.701.701h6.236L7.621 7.438h-.002v2.233h-.768v5.184L9.404 13.1V9.671h-.585V7.97l1.9-1.73h2.58A.701.701 0 0 0 14 5.539V1.701A.701.701 0 0 0 13.299 1z" id="aqsFill-1"></path></g></svg>');
    r(this, "setPaintFormat", () => {
      if (!this.editor)
        return;
      const t = this.editor.getSelectionText();
      if (t && Object.keys(this.format).length > 0) {
        const e = { ...this.format, text: t };
        this.editor.insertNode(e), this.excting || this.clearFormat();
      }
    });
    r(this, "onPaintFormat", ct(this.setPaintFormat, 500, !1));
    r(this, "throttleHandle", this.throttle(this.handle, 300));
  }
  // 菜单是否需要激活（如选中加粗文本，“加粗”菜单会激活），用不到则返回 false
  isActive(t) {
    return Object.keys(this.format).length > 0;
  }
  // 获取菜单执行时的 value ，用不到则返回空 字符串或 false
  getValue(t) {
    return "";
  }
  // 菜单是否需要禁用（如选中 H1 ，“引用”菜单被禁用），用不到则返回 false
  isDisabled(t) {
    return !1;
  }
  calcFormat(t) {
    if (t.length > 0) {
      const { children: e } = t[0];
      e.forEach((s) => {
        Object.assign(this.format, s);
      });
    }
  }
  clearFormat() {
    this.format = {};
    const t = this.editor.getEditableContainer();
    t && t.classList.remove("is-paint-format");
  }
  throttle(t, e) {
    let s = null;
    return function(...n) {
      s || (s = setTimeout(() => {
        t.apply(this, n), s = null, this.excting = !0;
      }, e));
    };
  }
  handle(t) {
    const e = t.getFragment();
    this.calcFormat(e), this.editor = t;
    const s = this.editor.getEditableContainer();
    s && s.classList.add("is-paint-format"), t.deselect(), t.on("change", this.onPaintFormat), t.on("clickOutside", () => {
      this.clearFormat(), this.excting = !1;
    });
  }
  // 点击菜单时触发的函数
  exec(t) {
    this.throttleHandle(t);
  }
}
const Rs = {
  key: "paintformat",
  factory() {
    return new Ts();
  }
};
function Ds(a) {
  const { data: t = {} } = a;
  return "<span class='personnel-marker'>".concat(t == null ? void 0 : t.name, "</span>");
}
const Is = {
  type: "personnel-marker",
  elemToHtml: Ds
};
function As(a) {
  const t = decodeURIComponent(a.getAttribute("data-value") || "");
  return {
    type: "personnel-marker",
    data: JSON.parse(t),
    children: [{ text: "" }]
  };
}
const Us = {
  selector: 'span[data-w-e-type="personnel-marker"]',
  parseElemHtml: As
};
function zs(a) {
  const { data: t = {} } = a, e = {
    name: "".concat(t.name),
    id: t.id
  };
  return ie(
    "personnel-marker-elem",
    {
      dataset: { value: JSON.stringify(e) },
      props: {
        contentEditable: !1
        // 不可编辑
      }
    },
    []
  );
}
const Bs = {
  type: "personnel-marker",
  renderElem: zs
}, $s = {
  renderElems: [Bs],
  elemsToHtml: [Is],
  parseElemsHtml: [Us]
}, Vs = (a) => {
  const { isInline: t, isVoid: e, deleteBackward: s } = a;
  return a.deleteBackward = (n) => {
    const { selection: i } = a;
    if (i && i.focus.offset === 0) {
      const [l, d] = i.focus.path;
      let h = d, g = l, f = !1;
      d === 0 && l !== 0 ? (g = g - 1, f = !0) : d > 0 && (h = h - 1);
      const C = a.children[g].children[f ? a.children[g].children.length - 1 : h];
      (C == null ? void 0 : C.type) === "personnel-marker" && a.moveReverse(1);
    }
    s(n);
  }, a.isInline = (n) => _.getNodeType(n) === "personnel-marker" ? !0 : t(n), a.isVoid = (n) => _.getNodeType(n) === "personnel-marker" ? !1 : e(n), a;
};
class qs extends bt {
  constructor() {
    super(...arguments);
    /**
     * 用户头像数据
     *
     * @type {string}
     * @memberof HtmlCommentController
     */
    r(this, "userAvatar", "");
    /**
     * 上传参数
     */
    r(this, "uploadParams");
    /**
     * 下载参数
     */
    r(this, "exportParams");
    /**
     * 最小高度
     *
     * @type {number}
     * @memberof HtmlCommentController
     */
    r(this, "minHeight", 48);
    /**
     * 最大高度
     *
     * @type {number}
     * @memberof HtmlCommentController
     */
    r(this, "maxHeight", 315);
    /**
     * 是否折叠
     *
     * @type {Ref<boolean>}
     * @memberof HtmlCommentController
     */
    r(this, "collapsed", b(!0));
    /**
     * 是否隐藏
     *
     * @type {Ref<boolean>}
     * @memberof HtmlCommentController
     */
    r(this, "hidden", b(!1));
    /**
     * 回复
     *
     * @type {string}
     * @memberof HtmlCommentController
     */
    r(this, "reply", b(""));
    /**
     * 回复脚本
     *
     * @type {string}
     * @memberof HtmlCommentController
     */
    r(this, "replyScript", "");
    /**
     * 编辑器模式
     *
     * @type {('comment' | 'default')}
     * @memberof HtmlCommentController
     */
    r(this, "mode", "comment");
    /**
     * 插入工具栏项
     *
     * @type {IData[]}
     * @memberof HtmlCommentController
     */
    r(this, "insertKeys", []);
    /**
     * 绘制模式
     *
     * @type {IData[]}
     * @memberof HtmlCommentController
     */
    r(this, "renderMode", "HTML");
    /**
     * 保存间隔
     *
     * @type {IData[]}
     * @memberof HtmlCommentController
     */
    r(this, "saveInterval", 3e3);
    /**
     * 抛值模式
     *
     * @type {IData[]}
     * @memberof HtmlCommentController
     */
    r(this, "emitMode", "BUTTON");
    /**
     * 唯一标识
     *
     * @type {string}
     * @memberof HtmlCommentController
     */
    r(this, "uuid", Mt());
    /**
     * 实时编辑（协同编辑）
     */
    r(this, "enableRealtime", !1);
    /**
     * 编辑器实例
     */
    r(this, "editor");
    /**
     * 是否在处理中
     */
    r(this, "processing", b(!1));
    /**
     * 用户标记数据map
     */
    r(this, "persMarkMap", /* @__PURE__ */ new Map());
    /**
     * 消息信息
     */
    r(this, "msg");
    /**
     * 是否已监听
     */
    r(this, "hasSubscribe", !1);
    r(this, "evt", new Ct(
      this.getEventArgs.bind(this)
    ));
  }
  getEventArgs() {
    return {
      context: this.context,
      params: this.params,
      data: [],
      eventArg: "",
      targetName: this.model.name,
      view: this.parent.view
    };
  }
  async onInit() {
    if (await super.onInit(), await this.getCurrentUserAvatar(), this.registerCustomElem(), this.editorParams) {
      const {
        uploadParams: e,
        exportParams: s,
        MINHEIGHT: n,
        MAXHEIGHT: i,
        REPLYSCRIPT: l,
        MODE: d,
        INSERTKEYS: h,
        RENDERMODE: g,
        SAVEINTERVAL: f,
        EMITMODE: C,
        DEFAULTCOLLAPSE: E,
        ENABLEREALTIME: k
      } = this.editorParams;
      if (e)
        try {
          this.uploadParams = JSON.parse(e);
        } catch (P) {
          ibiz.log.error(
            "编辑器[".concat(ibiz.log.error(
              P
            ), "]编辑器参数 uploadParams 非 json 格式")
          );
        }
      if (s)
        try {
          this.exportParams = JSON.parse(s);
        } catch (P) {
          ibiz.log.error(
            "编辑器[".concat(ibiz.log.error(
              P
            ), "]编辑器参数 exportParams 非 json 格式")
          );
        }
      n && (this.minHeight = Number(n)), i && (this.maxHeight = Number(i)), l && (this.replyScript = l), d && (this.mode = d.toLowerCase()), h && (this.insertKeys = JSON.parse(h)), g && (this.renderMode = g), f && (this.saveInterval = Lt(f)), C && (this.emitMode = C), E && (this.collapsed.value = !Object.is(E, "TRUE") && !Object.is(E, "true")), k && (this.enableRealtime = Object.is(k, "TRUE") || Object.is(k, "true"));
    }
    J.init(this.uuid), this.evt.on("onChange", () => {
      if (this.parent.form)
        return;
      const e = ibiz.uiDomainManager.get(this.context.srfsessionid);
      e && e.dataChange();
    }), this.initMarkOpenData();
  }
  /**
   * 注册自定义元素
   *
   * @private
   * @memberof HtmlCommentController
   */
  registerCustomElem() {
    window.customElements.get("mention-elem") || window.customElements.define("mention-elem", Fs), window.customElements.get("personnel-marker-elem") || window.customElements.define(
      "personnel-marker-elem",
      Ns
    ), window.paintFormatIsRegiter || (I.registerMenu(Rs), window.paintFormatIsRegiter = !0), window.personnelMarkerIsRegiter || (I.registerModule($s), window.personnelMarkerIsRegiter = !0), I.registerRenderStyle((e, s) => Nt(e, s)), I.registerPlugin(Vs);
  }
  /**
   * 初始化
   *
   * @param {IDomEditor} editor
   * @memberof HtmlCommentController
   */
  onCreated(e, s, n) {
    this.editor = e, this.onLineEditing(e, s), J.getPluginsById(this.uuid).forEach((l) => {
      l.init(e, {
        model: this.model,
        data: s,
        toolbarConfig: n,
        context: this.context,
        params: this.params,
        evt: this.evt
      });
    });
  }
  /**
   * 处理编辑
   * @param item
   */
  handleEdit(e) {
    const { data: s } = e;
    if (s) {
      this.processing.value = !0;
      let n = this.persMarkMap.get(e.username);
      s.type === "set_selection" ? this.drawPersonnelMarker({
        id: e.username,
        cursor: s.cursor
      }) : s.type === "set_node" && (n != null && n.cursor.selectionRange) ? this.setPersSelectionMark({
        persMarkData: n,
        mark: s.newProperties
      }) : this.editor.apply(s), this.processing.value = !1;
    }
  }
  /**
   * 处理查看
   * @param item
   */
  handleView(e) {
  }
  /**
   * 处理更新
   * @param item
   */
  handleUpdate(e) {
  }
  /**
   * 处理关闭
   * @param item
   */
  handleClose(e) {
  }
  /**
   * 标记打开数据回调
   * @param msg
   */
  markOpenDataCallback(e) {
    const { action: s, data: n } = e;
    if (this.enableRealtime)
      switch (s) {
        case "VIEW":
          this.handleView(e);
          break;
        case "EDIT":
          this.handleEdit(e);
          break;
        case "UPDATE":
          this.handleUpdate(e);
          break;
        case "CLOSE":
          this.handleClose(e);
          break;
      }
  }
  /**
   * 初始化MarkOpenData逻辑
   */
  initMarkOpenData() {
    if (this.markOpenDataCallback = this.markOpenDataCallback.bind(this), this.enableRealtime) {
      const e = this.parent.form || this.parent.grid;
      e && (e.evt.on("onLoadSuccess", (s) => {
        const n = s.data[0];
        this.msg = { deName: n.srfdecodename, srfkey: n.srfkey }, ibiz.markOpenData.action(this.msg.deName, this.msg.srfkey, "VIEW"), this.hasSubscribe || ibiz.markOpenData.subscribe(
          this.msg.deName,
          this.msg.srfkey,
          this.markOpenDataCallback
        );
      }), e.evt.on("onSaveSuccess", () => {
        this.msg.srfkey && ibiz.markOpenData.action(
          this.msg.deName,
          this.msg.srfkey,
          "UPDATE"
        );
      }), e.view.evt.on("onCloseView", () => {
        this.msg.srfkey && ibiz.markOpenData.action(this.msg.deName, this.msg.srfkey, "CLOSE");
      }));
    }
  }
  /**
   * 在线编辑
   * @param editor
   * @param item
   */
  onLineEditing(e, s) {
    const { apply: n } = e;
    e.apply = (i) => {
      if (n(i), this.enableRealtime && !this.processing.value) {
        const l = { ...i };
        if (i.type === "set_selection") {
          const d = this.handleCursor(i);
          Object.assign(l, { cursor: d });
        }
        ibiz.markOpenData.send(this.msg.deName, this.msg.srfkey, "EDIT", l);
      }
    };
  }
  /**
   * 处理光标信息
   * @param op
   * @returns
   */
  handleCursor(e) {
    const s = {};
    e.properties && (s.position = {
      path: e.properties.focus.path,
      offset: j.calcOffsetByPoint(this.editor, e.properties.focus)
    }), e.newProperties && (s.newPosition = {
      path: e.newProperties.focus.path,
      offset: j.calcOffsetByPoint(
        this.editor,
        e.newProperties.focus
      )
    });
    const { selection: n } = this.editor;
    return !Oe.isRange(e.newProperties) && !Oe.isRange(e.properties) && n && (s.selectionRange = {
      anchor: {
        path: n.anchor.path,
        offset: j.calcOffsetByPoint(this.editor, n.anchor)
      },
      focus: {
        path: n.focus.path,
        offset: j.calcOffsetByPoint(this.editor, n.focus)
      }
    }), s;
  }
  /**
   * 组件销毁
   *
   * @memberof HtmlCollapseController
   */
  onDestroyed() {
    J.getPluginsById(this.uuid).forEach((s) => {
      s.onDestroyed();
    }), J.destroy(this.uuid), this.enableRealtime && ibiz.markOpenData.unsubscribe(
      this.msg.deName,
      this.msg.srfkey,
      this.markOpenDataCallback
    );
  }
  /**
   * 解析所有注册节点
   *
   * @param {string} value
   * @return {*}
   * @memberof HtmlCommentController
   */
  parseNode(e) {
    let s = e;
    return J.getPluginsById(this.uuid).forEach((i) => {
      s = i.parseNode(s);
    }), s;
  }
  /**
   * 设置html
   *
   * @param {string} value
   * @memberof HtmlCommentController
   */
  async setValue(e) {
    this.collapsed.value = !1, this.hidden.value = !0, await U(), this.hidden.value = !1, await U();
    const s = this.parseNode(e);
    this.evt.emit("setHtml", {
      eventArg: s
    });
  }
  /**
   * 设置回复,data: {name: string, content: string}
   *
   * @param {IData} data
   * @memberof HtmlCommentController
   */
  setReply(e) {
    this.reply.value = "".concat(e.name, ": ").concat(e.content), this.evt.emit("onSetReply", {
      eventArg: this.reply.value
    });
  }
  /**
   * 删除回复
   *
   * @memberof HtmlCommentController
   */
  removeReply() {
    this.reply.value = "", this.evt.emit("onRemoveReply", {
      eventArg: this.reply.value
    });
  }
  /**
   * 清空
   *
   * @memberof HtmlCommentController
   */
  clear() {
    this.reply.value = "", this.evt.emit("onRemoveReply", {
      eventArg: this.reply.value
    }), this.evt.emit("clear", {
      eventArg: ""
    }), this.collapsed.value = !0;
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
    }).then((s) => {
      if (s.status !== 200)
        throw new G("下载文件失败");
      if (s.data) {
        const n = e.name;
        Pt(s.data, n);
      } else
        throw new G("文件流数据不存在");
    });
  }
  /**
   * 切换折叠
   *
   * @memberof HtmlCommentController
   */
  toggleCollapse(e) {
    this.collapsed.value = !e && !this.collapsed.value;
  }
  /**
   * 绘制模式为json时，需要将返回数据的json内容转html
   *
   * @author ljx
   * @date 2024-03-09 15:11:09
   * @param {string} url
   * @param {IData} file
   */
  jsonToHtml(e) {
    let s = "";
    try {
      const n = JSON.parse(e);
      s = St({
        content: n
      }).getHtml();
    } catch (n) {
      s = e, ibiz.log.error("JSON字符串转换错误", n);
    }
    return s;
  }
  /**
   * 绘制模式为json时，处理抛值数据
   *
   * @author ljx
   * @date 2024-03-09 15:11:09
   * @param {string} url
   * @param {IData} file
   */
  toJson(e = []) {
    let s = "";
    try {
      s = JSON.stringify(e);
    } catch (n) {
      ibiz.log.error("JSON字符串转换错误");
    }
    return s;
  }
  /**
   * 绘制正在编辑人员标记
   * @param item 用户标记数据
   */
  drawPersonnelMarker(e) {
    var l;
    const { id: s } = e, n = {
      type: "personnel-marker",
      data: { name: s },
      children: [{ text: "" }],
      id: s
    };
    let i = (l = this.persMarkMap.get(s)) == null ? void 0 : l.cursor;
    Object.assign(e, { preCursor: i }), j.movePersNode(this.editor, {
      node: n,
      param: e
    }), this.persMarkMap.set(s, e);
  }
  /**
   * 设置人员选区标记
   * @param item
   */
  setPersSelectionMark(e) {
    const { persMarkData: s, mark: n } = e, i = s.cursor.selectionRange;
    i && j.addMarks(this.editor, {
      mark: n,
      selection: {
        anchor: j.calcPointByOffset(this.editor, i.anchor),
        focus: j.calcPointByOffset(this.editor, i.focus)
      }
    });
  }
  /**
   * 获取当前用户头像
   *
   * @memberof HtmlCommentController
   */
  async getCurrentUserAvatar() {
    var n, i;
    const e = await ibiz.hub.getApp(this.context.srfappid);
    let s = [];
    if (s = await e.codeList.get(
      "SysOperator",
      this.context,
      this.params
    ), this.context.srfuserid) {
      const l = s.filter((d) => d.value === this.context.srfuserid);
      l && l.length > 0 && (this.userAvatar = ((i = (n = l[0]) == null ? void 0 : n.data) == null ? void 0 : i.iconurl) || "");
    }
  }
}
class js {
  constructor() {
    r(this, "formEditor", "HtmlComment");
    r(this, "gridEditor", "HtmlComment");
  }
  async createController(t, e) {
    const s = new qs(t, e);
    return await s.init(), s;
  }
}
const Js = kt(Je, function(a) {
  a.component(Je.name, Je), wt(
    "EDITOR_CUSTOMSTYLE_COMMENT",
    () => new js()
  );
}), an = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(a) {
    a.use(Js), a.component(
      "IBizHtmlContent",
      yt(() => Promise.resolve().then(() => Ht))
    );
  }
};
export {
  Js as IBizHtmlComment,
  an as default
};
