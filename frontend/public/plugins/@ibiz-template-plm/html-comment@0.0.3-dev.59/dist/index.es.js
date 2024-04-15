import './style.css';
var ct = Object.defineProperty;
var dt = (i, t, e) => t in i ? ct(i, t, { enumerable: !0, configurable: !0, writable: !0, value: e }) : i[t] = e;
var r = (i, t, e) => (dt(i, typeof t != "symbol" ? t + "" : t, e), e);
import { defineComponent as fe, ref as y, shallowRef as Ke, watch as te, onBeforeUnmount as ke, onMounted as xe, createVNode as h, resolveComponent as D, createTextVNode as I, nextTick as A, onUnmounted as ut, computed as _e, withDirectives as Ze, resolveDirective as Me, h as Qe, defineAsyncComponent as mt } from "vue";
import { ScriptFactory as U, convertNavData as Se, EditorController as ht, ControllerEvent as ft, registerEditorProvider as vt } from "@ibiz-template/runtime";
import { getHtmlProps as ze, getEditorEmits as Be, useNamespace as ve, useClickOutside as pt, withInstall as gt } from "@ibiz-template/vue3-util";
import { Editor as We, Toolbar as Ye } from "@wangeditor/editor-for-vue";
import { SlateEditor as Ge, SlateElement as Xe, Boot as $, DomEditor as J, createEditor as yt, SlateTransforms as Ve } from "@wangeditor/editor";
import { getCookie as et, createUUID as bt } from "qx-util";
import { isNil as tt } from "ramda";
import { CoreConst as st, debounce as nt, awaitTimeout as Ct, RuntimeError as Y, listenJSEvent as Pe, NOOP as K, downloadFileFromBlob as wt } from "@ibiz-template/core";
import { ElMessageBox as it } from "element-plus";
import { debounce as rt, toNumber as Et } from "lodash-es";
class at {
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
    const { $elem: e } = this.modalOrPanel, s = e[0], n = this.htmlRef.$el, a = n.querySelector(".w-e-bar"), c = s.previousElementSibling, m = c.getAttribute("data-menu-key"), u = s.parentNode.parentNode.parentNode;
    if (!["bgColor", "color"].includes(m) || !n || !a || !c || u.getAttribute("data-w-e-toolbar") === "true")
      return;
    const v = s.clientWidth, C = s.clientHeight, k = a.clientHeight, S = c.getBoundingClientRect(), L = S.bottom, O = S.right, F = S.top, w = S.left, d = "".concat(F + k, "px"), p = "".concat(w, "px"), x = "".concat(L - C - k, "px"), N = "".concat(O - v, "px"), P = { position: "fixed", left: p, top: d }, R = window.innerWidth, _ = window.innerHeight;
    R - w < v && Object.assign(P, { left: N }), _ - F - k < C && Object.assign(P, { top: x }), Object.assign(s.style, { top: "", bottom: "", left: "", right: "" }), Object.assign(s.style, P);
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
const ot = /* @__PURE__ */ fe({
  name: "IBizHtmlContent",
  props: ze(),
  emits: Be(),
  setup(i, {
    emit: t
  }) {
    const e = ve("html"), s = i.controller, n = y(), a = y({});
    let c = null, m = 0;
    const u = y(), b = y(), v = Ke(), C = y(), k = y(""), S = y({
      Authorization: "Bearer ".concat(et(st.TOKEN))
    }), L = y(""), O = y(""), F = y(!0), w = y(!1), d = y(!1), p = y(!1), x = y(!1), N = y(""), P = y([]), R = s.model;
    R.editorParams && (R.editorParams.enableEdit && (w.value = !0, d.value = !0, F.value = s.toBoolean(R.editorParams.enableEdit) && !i.readonly && !i.disabled), R.editorParams.enableFullScreen && (p.value = s.toBoolean(R.editorParams.enableFullScreen)));
    const _ = (l) => {
      if (!v.value)
        return;
      const {
        eventArg: g
      } = l;
      g && (v.value.setHtml(g), t("focus"));
    }, Z = () => {
      v.value && (v.value.blur(), v.value.setHtml(""));
    }, G = () => {
      v.value && t("focus");
    };
    s.evt.on("setHtml", _), s.evt.on("clear", Z), s.evt.on("onSetReply", G), te(() => i.data, (l) => {
      if (l) {
        const g = ibiz.util.file.calcFileUpDownUrl(s.context, s.params, l);
        L.value = g.uploadUrl, O.value = g.downloadUrl;
      }
    }, {
      immediate: !0,
      deep: !0
    });
    const z = (l, g) => {
      if (g)
        return !0;
    }, ne = (l) => l, X = {
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
    }, B = {
      placeholder: s.placeHolder,
      readOnly: w.value ? d.value : i.readonly,
      MENU_CONF: {
        // 图片上传
        uploadImage: {
          // 上传地址
          server: L.value,
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
          headers: S.value,
          // 跨域是否传递 cookie ，默认为 false
          withCredentials: !0,
          // 上传之前触发
          onBeforeUpload(l) {
            return l;
          },
          // 上传进度的回调函数
          onProgress(l) {
            console.log("progress", l);
          },
          // 单个文件上传成功之后
          onSuccess(l, g) {
            console.log("".concat(l.name, " 上传成功"), g);
          },
          // 单个文件上传失败
          onFailed(l, g) {
            console.log("".concat(l.name, " 上传失败"), g);
          },
          // 上传错误，或者触发 timeout 超时
          onError(l, g, M) {
            console.log("".concat(l.name, " 上传出错"), g, M);
          },
          // 自定义插入图片
          async customInsert(l, g) {
            const M = O.value.replace("%fileId%", l.id), T = l.filename;
            g(M, T, "");
          }
        },
        // 插入链接
        insertLink: {
          checkLink: z,
          // 也支持 async 函数
          parseLinkUrl: ne
          // 也支持 async 函数
        },
        // 更新链接
        editLink: {
          checkLink: z,
          // 也支持 async 函数
          parseLinkUrl: ne
          // 也支持 async 函数
        }
      }
    }, pe = async (l) => {
      const g = l.src;
      if (d.value)
        ie(g);
      else {
        const M = Ge.nodes(v.value, {
          match: (T) => !!(Xe.isElement(T) && T.type === "image"),
          universal: !0
        });
        if (M)
          for (const T of M) {
            const [o] = T;
            o.type === "image" && g.endsWith(o.src) && ie(o.src);
          }
      }
    }, ie = async (l) => {
      if (N.value = l, P.value = [l], await A(), C.value) {
        const {
          container: g
        } = C.value.$refs;
        g && g.children[0].click();
      }
    }, Le = (l) => {
      const g = l.getEditableContainer();
      g && g.querySelectorAll("img").forEach((T) => {
        T.onclick = (o) => {
          const f = o.target;
          f && pe(f);
        };
      });
    }, re = (l) => {
      if (C.value) {
        const {
          container: g
        } = C.value.$refs;
        if (g) {
          const M = g.querySelector(".el-image-viewer__wrapper");
          M == null || M[l]("keydown", He);
        }
      }
    }, He = async (l) => {
      (l.key === "Escape" || l.keyCode === 27) && (l.stopPropagation(), l.preventDefault(), await A(), re("removeEventListener"), P.value = []);
    }, ge = async () => {
      await A(), re("addEventListener");
    };
    ke(() => {
      const l = v.value;
      l != null && l.destroy();
    });
    const ye = (l) => {
      v.value = l;
      let g;
      l.on("modalOrPanelShow", (M) => {
        g = new at(M, b.value);
      }), l.on("modalOrPanelHide", () => {
        g && g.destroy();
      }), l.setHtml(k.value), s.onCreated(v.value, i.data, X);
    }, be = (l) => {
      const g = l.getHtml();
      Le(l);
      let M = g === "<p><br></p>" ? "" : g;
      M === i.value || M === "" && tt(i.value) || w.value || (M = M.replaceAll('class="rich-html-table"', "").replace(/<table/g, '<table class="rich-html-table"'), t("change", M), s.evt.emit("onChange", {
        eventArg: M
      }));
    }, ae = (l) => {
      s.onDestroyed(), s.evt.off("setHtml", _), s.evt.off("clear", Z), s.evt.off("onSetReply", G);
    }, Ce = () => {
      t("focus"), s.evt.emit("onFocus", {
        eventArg: i.value
      });
    }, oe = () => {
      t("blur"), s.evt.emit("onBlur", {
        eventArg: i.value
      });
    }, le = (l, g) => {
      alert("【自定义提示】".concat(g, " - ").concat(l));
    }, ce = (l, g, M) => {
      M(!0);
    }, we = (l) => {
      const g = v.value;
      g != null && g.insertText(l);
    }, Ee = () => {
      const l = v.value;
      l != null && console.log(l.getHtml());
    }, Q = () => {
      const l = v.value;
      l != null && l.disable();
    }, W = () => {
      const l = v.value;
      l != null && l.enable();
    }, Fe = () => {
      if (n.value && u.value) {
        const l = n.value.offsetHeight;
        c = new ResizeObserver((g) => {
          const {
            height: M
          } = g[0].contentRect;
          if (M !== m) {
            const T = {
              height: "".concat(l - g[0].contentRect.height, "px")
            };
            a.value = e.cssVarBlock(T), m = M;
          }
        }), c.observe(u.value.selector);
      }
    }, Ne = () => {
      var l, g;
      if (i.value) {
        const M = i.value.indexOf("</p>");
        if (M >= 0) {
          const T = (l = v.value.selection.anchor) == null ? void 0 : l.offset, o = (g = v.value.selection.anchor) == null ? void 0 : g.path;
          T === 0 && o.length > 0 && o[0] === 0 && v.value.move(M - 3);
        }
      }
    }, q = () => {
      d.value = !d.value, d.value ? Q() : (W(), v.value.focus(), Ne());
    }, ee = () => h("div", {
      class: e.be("message", "message-content")
    }, [h("p", null, [I("确定要取消编辑吗？")]), h("p", {
      class: e.bem("message", "message-content", "message-tip")
    }, [I("取消编辑将无法保存修改的内容，且不能找回。")])]), Te = () => {
      i.value !== k.value ? it({
        title: "确认取消",
        type: "warning",
        customClass: e.b("message"),
        message: ee(),
        showCancelButton: !0,
        cancelButtonClass: e.be("message", "message-cancel"),
        confirmButtonClass: e.be("message", "message-comfire")
      }).then(() => {
        if (i.value) {
          const l = s.parseNode(i.value);
          k.value = l;
        } else
          k.value = "";
        q();
      }).catch(() => {
        v.value.focus();
      }) : q();
    }, Oe = () => {
      d.value = !0, v.value.disable();
      const l = k.value.replaceAll('class="rich-html-table"', "").replace(/<table/g, '<table class="rich-html-table"');
      t("change", l), x.value && (x.value = !1);
    }, de = () => w.value ? h("div", {
      class: [e.b("footer"), {
        [e.b("footer-dialog")]: x.value
      }]
    }, [h("div", {
      class: e.be("footer", "cancel"),
      onClick: () => Te()
    }, [I("取消")]), h("div", {
      class: e.be("footer", "save"),
      onClick: () => Oe()
    }, [I("保存")])]) : null, ue = () => {
      x.value = !x.value, A(() => {
        d.value ? Q() : (W(), v.value.focus());
      });
    }, De = () => p.value ? x.value ? h("i", {
      class: "fa fa-compress",
      "aria-hidden": "true",
      onClick: () => ue()
    }, null) : h("i", {
      class: "fa fa-expand",
      "aria-hidden": "true",
      onClick: () => ue()
    }, null) : null, Re = () => w.value || p.value ? h("div", {
      class: e.b("custom-toolbar")
    }, [w.value && F.value && d.value ? h("i", {
      class: "fa fa-edit",
      "aria-hidden": "true",
      onClick: () => q()
    }, null) : null, De()]) : null, Ie = () => {
      if (s.reply.value) {
        const l = U.execScriptFn({
          value: s.reply.value
        }, s.replyScript, {
          singleRowReturn: !0,
          isAsync: !1
        });
        return h("div", {
          class: e.b("reply")
        }, [h("div", {
          class: e.be("reply", "content"),
          innerHTML: l
        }, null), h(D("ion-icon"), {
          name: "close-outline",
          onClick: () => s.removeReply()
        }, null)]);
      }
    }, me = () => s.hidden.value ? null : h("div", {
      class: e.b("content"),
      ref: "htmlContent",
      style: a.value
    }, [h(We, {
      ref: "htmlRef",
      class: e.b("editor"),
      modelValue: k.value,
      "onUpdate:modelValue": (l) => k.value = l,
      "default-config": B,
      mode: "default",
      onOnCreated: ye,
      onOnChange: be,
      onOnDestroyed: ae,
      onOnFocus: Ce,
      onOnBlur: oe,
      oncustomAlert: le,
      oncustomPaste: ce
    }, null), Ie(), h(Ye, {
      ref: "toolbarRef",
      editor: v.value,
      "default-config": X,
      mode: "default",
      class: e.b("toolbar")
    }, null)]), Ae = () => h(D("el-image"), {
      class: e.e("preview"),
      ref: "previewRef",
      "zoom-rate": 1.1,
      src: N.value,
      "preview-src-list": P.value,
      "hide-on-click-modal": !0,
      onShow: ge,
      fit: "cover"
    }, null);
    return xe(() => {
      Fe(), te(() => i.value, (l, g) => {
        l !== g && (typeof i.value == "string" || l == null) && (l == null ? k.value = "" : k.value = l);
      }, {
        immediate: !0
      }), te(() => i.disabled, (l, g) => {
        l !== g && (l === !0 ? Q() : W());
      }, {
        immediate: !0
      });
    }), {
      ns: e,
      editorRef: v,
      previewRef: C,
      mode: "default",
      valueHtml: k,
      toolbarConfig: X,
      editorConfig: B,
      handleCreated: ye,
      handleChange: be,
      handleDestroyed: ae,
      handleFocus: Ce,
      handleBlur: oe,
      customAlert: le,
      customPaste: ce,
      insertText: we,
      printHtml: Ee,
      disable: Q,
      enable: W,
      renderHeaserToolbar: Re,
      renderEditorContent: me,
      renderFooter: de,
      htmlContent: n,
      hasEnableEdit: w,
      cssVars: a,
      toolbarRef: u,
      htmlRef: b,
      isFullScreen: x,
      readonlyState: d,
      changeFullScreenState: ue,
      renderPreview: Ae
    };
  },
  render() {
    return this.isFullScreen ? h(D("el-dialog"), {
      modelValue: this.isFullScreen,
      "onUpdate:modelValue": (i) => this.isFullScreen = i,
      width: "80%",
      top: "10vh",
      class: this.ns.b("dialog-full-screen"),
      onClose: () => this.changeFullScreenState()
    }, {
      default: () => [h("div", {
        class: [this.ns.b(), {
          [this.ns.b("editor-readonly")]: this.readonlyState
        }]
      }, [this.renderHeaserToolbar(), this.renderEditorContent(), this.hasEnableEdit && !this.readonlyState ? this.renderFooter() : null])]
    }) : h("div", {
      class: [this.ns.b(), {
        [this.ns.b("editor-readonly")]: this.readonlyState
      }]
    }, [this.renderHeaserToolbar(), this.renderEditorContent(), this.renderPreview(), this.hasEnableEdit && !this.readonlyState ? this.renderFooter() : null]);
  }
}), Mt = /* @__PURE__ */ Object.freeze(/* @__PURE__ */ Object.defineProperty({
  __proto__: null,
  default: ot
}, Symbol.toStringTag, { value: "Module" })), St = [
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
], kt = /* @__PURE__ */ fe({
  name: "IBizHtmlCollapse",
  props: ze(),
  emits: Be(),
  setup(i, {
    emit: t
  }) {
    const e = ve("html"), s = i.controller, n = y(), a = y({});
    let c = null, m = 0;
    const u = y(), b = Ke(), v = y(), C = y(), k = y(), S = y(""), L = y({
      Authorization: "Bearer ".concat(et(st.TOKEN))
    }), O = y(""), F = y(""), w = y(!0), d = y(!1), p = y(!1), x = y(!1), N = y(!1), P = y(!0), R = y(!1), _ = y("");
    let Z;
    const G = y([]), z = s.model;
    z.editorParams && (z.editorParams.enableEdit && (d.value = !0, p.value = !0, w.value = s.toBoolean(z.editorParams.enableEdit) && !i.readonly && !i.disabled), z.editorParams.enableFullScreen && (x.value = s.toBoolean(z.editorParams.enableFullScreen))), i.readonly && (d.value = !1, p.value = !0), te(() => i.data, (o) => {
      if (o) {
        const f = ibiz.util.file.calcFileUpDownUrl(s.context, s.params, o, s.editorParams);
        O.value = f.uploadUrl, F.value = f.downloadUrl;
      }
    }, {
      immediate: !0,
      deep: !0
    });
    const ne = (o, f) => {
      if (f)
        return !0;
    }, X = (o) => o, B = {
      toolbarKeys: St
    };
    s.insertKeys.length > 0 && B.toolbarKeys && s.insertKeys.forEach((o) => {
      o.keys && o.keys.forEach((f, E) => {
        B.toolbarKeys.splice(o.index + E, 0, f);
      });
    });
    const pe = {
      placeholder: s.placeHolder,
      readOnly: d.value ? p.value : i.readonly,
      MENU_CONF: {
        // 图片上传
        uploadImage: {
          // 上传地址
          server: O.value,
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
          headers: L.value,
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
          onSuccess(o, f) {
            console.log("".concat(o.name, " 上传成功"), f);
          },
          // 单个文件上传失败
          onFailed(o, f) {
            console.log("".concat(o.name, " 上传失败"), f);
          },
          // 上传错误，或者触发 timeout 超时
          onError(o, f, E) {
            console.log("".concat(o.name, " 上传出错"), f, E);
          },
          // 自定义插入图片
          async customInsert(o, f) {
            const E = F.value.replace("%fileId%", o.id), H = o.filename;
            f(E, H, "");
          }
        },
        // 插入链接
        insertLink: {
          checkLink: ne,
          // 也支持 async 函数
          parseLinkUrl: X
          // 也支持 async 函数
        },
        // 更新链接
        editLink: {
          checkLink: ne,
          // 也支持 async 函数
          parseLinkUrl: X
          // 也支持 async 函数
        }
      }
    };
    ke(() => {
      const o = b.value;
      o != null && o.destroy();
    });
    const ie = async (o) => {
      if (s.maxHeight) {
        const f = o.getEditableContainer();
        R.value = f.offsetHeight > s.maxHeight;
      }
    }, Le = async (o) => {
      const f = o.src;
      if (p.value)
        re(f);
      else {
        const E = Ge.nodes(b.value, {
          match: (H) => !!(Xe.isElement(H) && H.type === "image"),
          universal: !0
        });
        if (E)
          for (const H of E) {
            const [V] = H;
            V.type === "image" && f.endsWith(V.src) && re(V.src);
          }
      }
    }, re = async (o) => {
      if (_.value = o, G.value = [o], await A(), C.value) {
        const {
          container: f
        } = C.value.$refs;
        f && f.children[0].click();
      }
    }, He = (o) => {
      const f = o.getEditableContainer();
      f && f.querySelectorAll("img").forEach((H) => {
        H.onload = () => {
          ie(o);
        }, H.onclick = (V) => {
          const qe = V.target;
          qe && Le(qe);
        };
      });
    }, ge = (o) => {
      if (C.value) {
        const {
          container: f
        } = C.value.$refs;
        if (f) {
          const E = f.querySelector(".el-image-viewer__wrapper");
          E == null || E[o]("keydown", ye);
        }
      }
    }, ye = async (o) => {
      (o.key === "Escape" || o.keyCode === 27) && (o.stopPropagation(), o.preventDefault(), await A(), ge("removeEventListener"), G.value = []);
    }, be = async () => {
      await A(), ge("addEventListener");
    }, ae = () => {
      let o = S.value;
      if (o = o.replaceAll('class="rich-html-table"', "").replace(/<table/g, '<table class="rich-html-table"'), s.renderMode === "JSON") {
        const f = b.value;
        o = s.toJson(f.children);
      }
      i.value !== o && t("change", o);
    }, Ce = nt(ae, s.saveInterval), oe = (o) => {
      b.value = o;
      const f = s.parseNode(S.value);
      o.setHtml(f), s.onCreated(b.value, i.data, B);
      let E;
      o.on("modalOrPanelShow", (H) => {
        E = new at(H, v.value);
      }), o.on("modalOrPanelHide", () => {
        E && E.destroy();
      });
    }, le = (o) => {
      const f = o.getHtml();
      ie(o), He(o);
      let E = f === "<p><br></p>" ? "" : f;
      E === i.value || E === "" && tt(i.value) || (E = E.replaceAll('class="rich-html-table"', "").replace(/<table/g, '<table class="rich-html-table"'), !d.value && o.isFocused() && (s.emitMode === "AUTOMATIC" ? Ce() : ae()), s.evt.emit("onChange", {
        eventArg: E
      }));
    }, ce = (o) => {
      s.onDestroyed();
    }, we = (o) => {
      t("focus"), s.evt.emit("onFocus", {
        eventArg: i.value
      });
    }, Ee = (o) => {
      t("blur"), s.evt.emit("onBlur", {
        eventArg: i.value
      });
    }, Q = (o, f) => {
      alert("【自定义提示】".concat(f, " - ").concat(o));
    }, W = (o, f, E) => {
      E(!0);
    }, Fe = (o) => {
      const f = b.value;
      f != null && f.insertText(o);
    }, Ne = () => {
      const o = b.value;
      o != null && console.log(o.getHtml());
    }, q = () => {
      const o = b.value;
      o != null && o.disable();
    }, ee = () => {
      const o = b.value;
      o != null && o.enable();
    }, Te = () => {
      Ct(0, () => {
        if (n.value && u.value) {
          const o = n.value.offsetHeight;
          c = new ResizeObserver((f) => {
            const {
              height: E
            } = f[0].contentRect;
            if (E !== m) {
              const H = {
                height: "".concat(o - f[0].contentRect.height, "px")
              };
              a.value = e.cssVarBlock(H), m = E;
            }
          }), c.observe(u.value.selector);
        }
      });
    }, Oe = () => {
      var o, f;
      if (i.value) {
        const E = i.value.indexOf("</p>");
        if (E >= 0) {
          const H = (o = b.value.selection.anchor) == null ? void 0 : o.offset, V = (f = b.value.selection.anchor) == null ? void 0 : f.path;
          H === 0 && V.length > 0 && V[0] === 0 && b.value.move(E - 3);
        }
      }
    }, de = () => {
      if (p.value = !p.value, !p.value)
        ee(), b.value.focus(), Oe(), P.value = !0;
      else {
        if (v.value) {
          const {
            box: o
          } = v.value.$refs;
          o.scroll(0, 0);
        }
        q();
      }
    }, ue = () => h("div", {
      class: e.be("message", "message-content")
    }, [h("p", null, [I("确定要取消编辑吗？")]), h("p", {
      class: e.bem("message", "message-content", "message-tip")
    }, [I("取消编辑将无法保存修改的内容，且不能找回。")])]), De = () => {
      i.value !== S.value ? it({
        title: "确认取消",
        type: "warning",
        customClass: e.b("message"),
        message: ue(),
        showCancelButton: !0,
        cancelButtonClass: e.be("message", "message-cancel"),
        confirmButtonClass: e.be("message", "message-comfire")
      }).then(() => {
        if (i.value) {
          const o = s.parseNode(i.value);
          S.value = o;
        } else
          S.value = "";
        de();
      }).catch(() => {
        b.value.focus();
      }) : de();
    }, Re = () => {
      p.value = !0, b.value.disable();
      const o = S.value.replaceAll('class="rich-html-table"', "").replace(/<table/g, '<table class="rich-html-table"');
      s.renderMode !== "JSON" && t("change", o), N.value && (N.value = !1);
    }, Ie = () => d.value && s.emitMode !== "AUTOMATIC" ? h("div", {
      class: [e.b("footer"), {
        [e.b("footer-dialog")]: N.value
      }]
    }, [h("div", {
      class: e.be("footer", "cancel"),
      onClick: () => De()
    }, [I("取消")]), h("div", {
      class: e.be("footer", "save"),
      onClick: () => Re()
    }, [I("保存")])]) : null, me = () => {
      N.value = !N.value, P.value = !N.value, A(() => {
        p.value ? q() : (ee(), b.value.focus());
      });
    }, Ae = () => x.value ? N.value ? h("i", {
      class: "fa fa-compress",
      "aria-hidden": "true",
      onClick: () => me()
    }, null) : h("i", {
      class: "fa fa-expand",
      "aria-hidden": "true",
      onClick: () => me()
    }, null) : null, l = () => d.value || x.value ? h("div", {
      class: e.b("custom-toolbar")
    }, [d.value && w.value && p.value ? h("i", {
      class: "fa fa-edit",
      "aria-hidden": "true",
      onClick: () => de()
    }, null) : null, Ae()]) : null, g = () => R.value ? P.value ? h("div", {
      class: e.e("toggle"),
      onClick: () => {
        P.value = !P.value;
      }
    }, [I("展开更多 "), h(D("ion-icon"), {
      name: "arrow-down-outline"
    }, null)]) : h("div", {
      class: e.e("toggle"),
      onClick: () => {
        P.value = !P.value;
      }
    }, [I("收起更多 "), h(D("ion-icon"), {
      name: "arrow-up-outline"
    }, null)]) : null, M = () => {
      const o = {
        ...a.value
      };
      return P.value && s.maxHeight && Object.assign(o, {
        maxHeight: "".concat(s.maxHeight, "px")
      }), h("div", {
        class: e.b("content"),
        ref: "htmlContent",
        style: o
      }, [h(Ye, {
        ref: "toolbarRef",
        editor: b.value,
        "default-config": B,
        mode: "default",
        class: e.b("toolbar")
      }, null), h(We, {
        ref: "htmlRef",
        class: e.b("editor"),
        modelValue: S.value,
        "onUpdate:modelValue": (f) => S.value = f,
        "default-config": pe,
        mode: "default",
        onOnCreated: oe,
        onOnChange: le,
        onOnDestroyed: ce,
        onOnFocus: we,
        onOnBlur: Ee,
        oncustomAlert: Q,
        oncustomPaste: W
      }, null)]);
    }, T = () => h(D("el-image"), {
      class: e.e("preview"),
      ref: "previewRef",
      "zoom-rate": 1.1,
      src: _.value,
      "preview-src-list": G.value,
      "hide-on-click-modal": !0,
      onShow: be,
      fit: "cover"
    }, null);
    return xe(() => {
      k.value && (Z = pt(k, async () => {
        b.value && b.value.emit("clickOutside");
      })), Te(), te(() => i.value, (o, f) => {
        o !== f && (typeof i.value == "string" || o == null) && (o == null ? S.value = "" : s.renderMode === "JSON" ? S.value = s.jsonToHtml(o) : S.value = o);
      }, {
        immediate: !0
      }), te(() => i.disabled, (o, f) => {
        o !== f && (o === !0 ? q() : ee());
      }, {
        immediate: !0
      });
    }), ut(() => {
      c && c.disconnect(), Z && Z.stop && Z.stop();
    }), {
      ns: e,
      editorRef: b,
      previewRef: C,
      containerRef: k,
      htmlRef: v,
      mode: "default",
      valueHtml: S,
      toolbarConfig: B,
      editorConfig: pe,
      handleCreated: oe,
      handleChange: le,
      handleDestroyed: ce,
      handleFocus: we,
      handleBlur: Ee,
      customAlert: Q,
      customPaste: W,
      insertText: Fe,
      printHtml: Ne,
      disable: q,
      enable: ee,
      renderHeaserToolbar: l,
      renderEditorContent: M,
      renderToggle: g,
      renderFooter: Ie,
      htmlContent: n,
      hasEnableEdit: d,
      cssVars: a,
      toolbarRef: u,
      isFullScreen: N,
      readonlyState: p,
      collapse: P,
      changeFullScreenState: me,
      renderPreview: T
    };
  },
  render() {
    return this.isFullScreen ? h(D("el-dialog"), {
      modelValue: this.isFullScreen,
      "onUpdate:modelValue": (i) => this.isFullScreen = i,
      width: "80%",
      top: "10vh",
      class: this.ns.b("dialog-full-screen"),
      onClose: () => this.changeFullScreenState()
    }, {
      default: () => [h("div", {
        ref: "containerRef",
        class: [this.ns.b(), this.ns.b("collapse"), {
          [this.ns.b("editor-readonly")]: this.readonlyState
        }]
      }, [this.renderHeaserToolbar(), this.renderEditorContent(), this.hasEnableEdit && !this.readonlyState ? this.renderFooter() : null])]
    }) : h("div", {
      ref: "containerRef",
      class: [this.ns.b(), this.ns.is("allow-collapse", !0), {
        [this.ns.b("editor-readonly")]: this.readonlyState
      }]
    }, [this.renderHeaserToolbar(), this.renderEditorContent(), this.readonlyState ? this.renderToggle() : null, this.hasEnableEdit && !this.readonlyState ? this.renderFooter() : null, this.renderPreview()]);
  }
});
class he {
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
    for (let u = 0; u < t.length; u++)
      if (this.isChineseCharacter(t))
        e = t.charCodeAt(u) + ((e << 5) - e), e = e & e;
      else {
        const b = t.charCodeAt(u);
        e += b.toString(16);
      }
    const s = String(e).substring(0, 6), n = parseInt(s.substring(0, 2), 16), a = parseInt(s.substring(2, 4), 16), c = parseInt(s.substring(4, 6), 16), m = "#".concat(n.toString(16).padStart(2, "0")).concat(a.toString(16).padStart(2, "0")).concat(c.toString(16).padStart(2, "0"));
    return m === "#FFFFFF" && this.getThemeVar() || m;
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
        const a = t.split("").find((m) => /[a-zA-Z]/.test(m)) || "", c = t.split("").find((m) => /[\u4E00-\u9FA5]/.test(m)) || "";
        return "".concat(a).concat(c).toLowerCase();
      }
      return /[a-zA-Z]/.test(t) ? t.split("").filter((a) => /[a-zA-Z]/.test(a)).slice(0, 2).join("").toUpperCase() : /[\u4E00-\u9FA5]/.test(t) ? t.split("").filter((a) => /[\u4E00-\u9FA5]/.test(a)).slice(-2).join("") : t.replaceAll(" ", "").substring(0, 2);
    }
  }
}
const $e = /* @__PURE__ */ fe({
  name: "HtmlComment",
  props: ze(),
  emits: Be(),
  setup(i, {
    emit: t
  }) {
    const e = ve("html-comment"), s = i.controller, n = y(), a = y();
    return {
      ns: e,
      c: s,
      comment: n,
      editorRef: a,
      onChange: (v) => {
        t("change", v), v && s.collapsed.value && (s.collapsed.value = !1);
      },
      onFocus: () => {
        s.collapsed.value = !1, t("focus");
      },
      onBlur: () => {
        if (t("blur"), i.value)
          return null;
        s.collapsed.value = !0;
      },
      renderAvatar: () => {
        const v = he.stringToHexColor(s.context.srfusername), C = he.avatarName(s.context.srfusername);
        return s.context.srfusername ? h("div", {
          class: e.e("avatar-name"),
          style: "background: ".concat(v, ";")
        }, [C]) : h(D("el-avatar"), {
          class: e.e("avatar"),
          src: "./assets/images/user-avatar.png"
        }, null);
      }
    };
  },
  render() {
    return this.c.mode === "default" ? h(kt, {
      controller: this.c,
      data: this.data,
      value: this.value,
      readonly: this.readonly,
      onChange: this.onChange,
      onFocus: this.onFocus,
      onBlur: this.onBlur
    }, null) : h("div", {
      ref: "comment",
      class: [this.ns.b(), this.ns.is("collapse", this.c.collapsed.value)],
      style: {
        height: "".concat(this.c.collapsed.value ? this.c.minHeight : this.c.maxHeight, "px")
      }
    }, [this.renderAvatar(), h(ot, {
      controller: this.c,
      data: this.data,
      value: this.value,
      onChange: this.onChange,
      onFocus: this.onFocus,
      onBlur: this.onBlur
    }, null)]);
  }
});
function je(i, t, e, s, n) {
  const a = t === void 0 ? void 0 : t.key;
  return { sel: i, data: t, children: e, text: s, elm: n, key: a };
}
const Je = Array.isArray;
function Ue(i) {
  return typeof i == "string" || typeof i == "number" || i instanceof String || i instanceof Number;
}
function lt(i, t, e) {
  if (i.ns = "http://www.w3.org/2000/svg", e !== "foreignObject" && t !== void 0)
    for (let s = 0; s < t.length; ++s) {
      const n = t[s];
      if (typeof n == "string")
        continue;
      const a = n.data;
      a !== void 0 && lt(a, n.children, n.sel);
    }
}
function se(i, t, e) {
  let s = {}, n, a, c;
  if (e !== void 0 ? (t !== null && (s = t), Je(e) ? n = e : Ue(e) ? a = e.toString() : e && e.sel && (n = [e])) : t != null && (Je(t) ? n = t : Ue(t) ? a = t.toString() : t && t.sel ? n = [t] : s = t), n !== void 0)
    for (c = 0; c < n.length; ++c)
      Ue(n[c]) && (n[c] = je(void 0, void 0, void 0, n[c], void 0));
  return i[0] === "s" && i[1] === "v" && i[2] === "g" && (i.length === 3 || i[3] === "." || i[3] === "#") && lt(s, n, i), je(i, s, n, a, void 0);
}
function xt(i) {
  const { script: t = "", data: e = {} } = i, s = U.execScriptFn({ data: e }, t, {
    singleRowReturn: !0,
    isAsync: !1
  });
  return "".concat(s);
}
const Pt = {
  type: "attachments",
  elemToHtml: xt
};
function Lt(i) {
  const t = decodeURIComponent(i.getAttribute("data-value") || ""), e = JSON.parse(t);
  return {
    type: "attachments",
    script: e.script,
    data: e,
    children: [{ text: "" }]
  };
}
const Ht = {
  selector: 'span[data-w-e-type="attachments"]',
  parseElemHtml: Lt
};
function Ft(i) {
  const { data: t = {} } = i, e = {
    name: "".concat(t.name),
    id: t.id
  };
  return se(
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
const Nt = {
  type: "attachments",
  renderElem: Ft
};
class Tt {
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
    throw new Y("暂未支持上传本地文件！");
  }
}
const Ot = {
  key: "attachments",
  factory() {
    return new Tt();
  }
}, Dt = {
  renderElems: [Nt],
  elemsToHtml: [Pt],
  parseElemsHtml: [Ht],
  menus: [Ot]
};
class Rt {
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
    window.attachmentsIsRegiter || ($.registerModule(Dt), window.attachmentsIsRegiter = !0);
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
function It(i) {
  const { script: t = "", data: e = {} } = i, s = U.execScriptFn({ data: e }, t, {
    singleRowReturn: !0,
    isAsync: !1
  });
  return "".concat(s);
}
const At = {
  type: "codesnippet",
  elemToHtml: It
};
function $t(i) {
  const t = decodeURIComponent(i.getAttribute("data-value") || ""), e = JSON.parse(t);
  return {
    type: "codesnippet",
    script: e.script,
    data: e,
    children: [{ text: "" }]
  };
}
const Ut = {
  selector: 'span[data-w-e-type="codesnippet"]',
  parseElemHtml: $t
};
function zt(i) {
  const { data: t = {} } = i, e = {
    name: "".concat(t.name),
    id: t.id
  };
  return se(
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
const Bt = {
  type: "CodeSnippet",
  renderElem: zt
};
class qt {
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
    throw new Y("暂未支持上传代码段！");
  }
}
const Vt = {
  key: "codesnippet",
  factory() {
    return new qt();
  }
}, jt = {
  renderElems: [Bt],
  elemsToHtml: [At],
  parseElemsHtml: [Ut],
  menus: [Vt]
};
class Jt {
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
    window.codesnippetIsRegiter || ($.registerModule(jt), window.codesnippetIsRegiter = !0);
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
function Kt(i) {
  const { script: t = "", data: e = {} } = i, s = U.execScriptFn({ data: e }, t, {
    singleRowReturn: !0,
    isAsync: !1
  });
  return "".concat(s);
}
const _t = {
  type: "marker",
  elemToHtml: Kt
};
function Zt(i) {
  const t = decodeURIComponent(i.getAttribute("data-value") || ""), e = JSON.parse(t);
  return {
    type: "marker",
    script: e.script,
    data: e,
    children: [{ text: "" }]
  };
}
const Qt = {
  selector: 'span[data-w-e-type="marker"]',
  parseElemHtml: Zt
};
function Wt(i) {
  const { data: t = {} } = i;
  return se(
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
const Yt = {
  type: "marker",
  renderElem: Wt
};
let Gt = class {
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
const Xt = {
  key: "marker",
  factory() {
    return new Gt();
  }
}, es = {
  renderElems: [Yt],
  elemsToHtml: [_t],
  parseElemsHtml: [Qt],
  menus: [Xt]
};
const ts = /* @__PURE__ */ fe({
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
  setup(i) {
    const t = ve("mention"), e = i.controller, s = y(!1), n = y([]);
    let a = K;
    const c = y({}), m = y(0), u = (w) => {
      const {
        eventArg: d
      } = w;
      if (d) {
        !d.includes("@") && e.overlay && e.execting && e.overlay.dismiss();
        const p = d.match(new RegExp("(?<=\\@)([^\\@&^{]*?)(?=\\<)", "g")) || [];
        e.execting && (p.length === 0 && e.overlay.dismiss(), e.query = p.pop() || "", e.query && /\s$/.test(e.query) ? e.overlay.dismiss() : e.query && S({
          isInitialLoad: !0
        }));
      } else
        e.overlay && e.execting && e.overlay.dismiss();
    }, b = () => {
      e.evt && e.evt.on("onChange", u);
    }, v = (w = {}) => {
      s.value = !0, e.getUsers(w).then((d) => {
        (d.status !== 200 || !d.data) && (s.value = !1), d.headers["x-total"] && (m.value = Number(d.headers["x-total"])), w.isLoadMore === !0 ? n.value.push(...e.toUIData(d.data)) : (n.value = e.toUIData(d.data), n.value.length > 0 && (c.value = n.value[0])), s.value = !1;
      }).catch(() => {
        s.value = !1;
      });
    }, C = () => {
      v({
        isLoadMore: !0
      });
    }, k = _e(() => n.value.length >= m.value || s.value || m.value <= e.size), S = rt(v, 300, {
      leading: !0
    });
    b(), v({
      isInitialLoad: !0
    });
    const L = (w) => {
      let d = n.value.findIndex((p) => p.id === c.value.id);
      switch (w) {
        case "up":
          d--, (d === -1 || d === -2) && (d = n.value.length - 1), c.value = n.value[d];
          break;
        case "down":
          d++, d === n.value.length && (d = 0), c.value = n.value[d];
          break;
        case "enter":
          O(c.value);
          break;
      }
    }, O = (w) => {
      var d;
      if (i.modal) {
        const p = {
          ok: !0,
          data: [w]
        };
        (d = i.modal) == null || d.dismiss(p);
      }
    }, F = (w) => {
      const d = w.name, p = he.stringToHexColor(d), x = he.avatarName(d);
      return h("div", {
        class: [t.e("item"), t.is("active", w.id === c.value.id)],
        onClick: () => O(w)
      }, [h("div", {
        class: t.e("avatar"),
        style: "background: ".concat(p, ";")
      }, [x]), h("div", {
        class: t.e("name"),
        title: d
      }, [d])]);
    };
    return xe(() => {
      a = Pe(window, "keyup", (w) => {
        w.keyCode === 40 ? L("down") : w.keyCode === 38 ? L("up") : w.keyCode === 13 && L("enter");
      });
    }), ke(() => {
      a !== K && a(), e.evt.off("onChange", u);
    }), {
      ns: t,
      items: n,
      loading: s,
      isLodeMoreDisabled: k,
      renderItem: F,
      loadMore: C
    };
  },
  render() {
    return Ze(h("div", {
      "infinite-scroll-distance": 10,
      "infinite-scroll-disabled": this.isLodeMoreDisabled,
      "infinite-scroll-immediate": !1,
      class: this.ns.b()
    }, [this.items.map((i) => this.renderItem(i)), this.items.length === 0 && h(D("iBizNoData"), {
      text: "暂未用户数据"
    }, null)]), [[Me("infinite-scroll"), () => this.loadMore()], [Me("loading"), this.loading]]);
  }
});
const ss = /* @__PURE__ */ fe({
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
  setup(i) {
    const t = ve("marker"), e = i.controller, s = y(!1), n = y([]);
    let a = K;
    const c = y({}), m = y(0), u = (d) => {
      const {
        eventArg: p
      } = d;
      if (p) {
        !p.includes("#") && e.overlay && e.execting && e.overlay.dismiss();
        const x = /<svg((.|[\t\r\f\n\s])+?)<\/svg>/g, P = p.replace(x, "").match(new RegExp("(?<=\\#)([^\\#&^{]*?)(?=\\<)", "g")) || [];
        e.execting && (P.length === 0 && e.overlay.dismiss(), e.query = P.pop() || "", e.query && /\s$/.test(e.query) ? e.overlay.dismiss() : e.query && S({
          isInitialLoad: !0
        }));
      } else
        e.overlay && e.execting && e.overlay.dismiss();
    }, b = () => {
      e.evt && e.evt.on("onChange", u);
    }, v = (d = {}) => {
      s.value = !0, e.load(d).then((p) => {
        (p.status !== 200 || !p.data) && (s.value = !1), p.headers["x-total"] && (m.value = Number(p.headers["x-total"])), d.isLoadMore === !0 ? n.value.push(...e.toUIData(p.data)) : (n.value = e.toUIData(p.data), n.value.length > 0 && (c.value = n.value[0])), s.value = !1;
      }).catch(() => {
        s.value = !1;
      });
    }, C = () => {
      v({
        isLoadMore: !0
      });
    }, k = _e(() => n.value.length >= m.value || s.value || m.value <= e.size), S = rt(v, 300, {
      leading: !0
    });
    b(), v({
      isInitialLoad: !0
    });
    const L = (d) => {
      let p = n.value.findIndex((x) => x.id === c.value.id);
      switch (d) {
        case "up":
          p--, (p === -1 || p === -2) && (p = n.value.length - 1), c.value = n.value[p];
          break;
        case "down":
          p++, p === n.value.length && (p = 0), c.value = n.value[p];
          break;
        case "enter":
          O(c.value);
          break;
      }
    }, O = (d) => {
      var p;
      if (i.modal) {
        const x = {
          ok: !0,
          data: [d]
        };
        (p = i.modal) == null || p.dismiss(x);
      }
    }, F = (d, p) => {
      if (e.quoteCodelistMap.has(d)) {
        const x = e.quoteCodelistMap.get(d);
        return h(D("iBizCodeList"), {
          codeListItems: x.codeListItems,
          codeList: x.codeList,
          value: p
        }, null);
      }
      return p;
    }, w = (d) => h("div", {
      class: [t.e("item"), t.is("active", d.id === c.value.id)],
      onClick: () => O(d)
    }, [h("div", {
      class: t.e("type")
    }, [F("type", d.type)]), h("div", {
      class: t.e("identifier")
    }, [F("identifier", d.identifier)]), h("div", {
      class: t.e("name"),
      title: d.name
    }, [F("name", d.name)])]);
    return xe(() => {
      a = Pe(window, "keyup", (d) => {
        d.keyCode === 40 ? L("down") : d.keyCode === 38 ? L("up") : d.keyCode === 13 && L("enter");
      });
    }), ke(() => {
      a !== K && a(), e.evt.off("onChange", u);
    }), {
      ns: t,
      items: n,
      loading: s,
      isLodeMoreDisabled: k,
      renderItem: w,
      loadMore: C
    };
  },
  render() {
    return Ze(h("div", {
      "infinite-scroll-distance": 10,
      "infinite-scroll-disabled": this.isLodeMoreDisabled,
      "infinite-scroll-immediate": !1,
      class: this.ns.b()
    }, [this.items.map((i) => this.renderItem(i)), this.items.length === 0 && h(D("iBizNoData"), {
      text: "暂未用户数据"
    }, null)]), [[Me("infinite-scroll"), () => this.loadMore()], [Me("loading"), this.loading]]);
  }
});
class ns {
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
    return t.insertText = (a) => {
      if (!this.editor) {
        e(a);
        return;
      }
      if (!this.editor.isFocused()) {
        e(a);
        return;
      }
      if (J.getSelectedElems(t).some((u) => t.isVoid(u))) {
        e(a);
        return;
      }
      a === "#" && !this.execting && (this.query = "", this.showModal()), e(a);
    }, t.isInline = (a) => J.getNodeType(a) === "marker" ? !0 : s(a), t.isVoid = (a) => J.getNodeType(a) === "marker" ? !0 : n(a), t;
  }
  registerNode() {
    window.markerIsRegiter || ($.registerModule(es), window.markerIsRegiter = !0), $.registerPlugin(this.markerPlugin.bind(this));
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
        QUOTEFIELDMAP: a,
        QUOTEMETHOD: c,
        QUOTESCRIPT: m,
        QUOTEINSCRIPT: u,
        QUOTEPARAMS: b,
        QUOTECODELISTMAP: v
      } = this.editorParams;
      if (n && (this.quoteUrl = n), a && (this.quoteFieldMap = JSON.parse(a)), c && (this.quoteMethod = c.toLowerCase()), b && (this.quoteParams = JSON.parse(b)), m && (this.quoteScript = m), u && (this.quoteInScript = u), v) {
        const C = JSON.parse(v);
        this.setCodeListMap(C);
      }
    }
    const s = this.editor.getEditableContainer();
    s && (this.cleanup = Pe(s, "keydown", (n) => {
      var a;
      this.execting && this.presetPreventEvents.includes(n.keyCode) && n.preventDefault(), this.execting && this.presetPreventPropEvents.includes(n.keyCode) && (n.stopPropagation(), (a = this.overlay) == null || a.dismiss());
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
      throw new Y("未配置提及工作项QUOTEURL编辑器参数！");
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
        const a = this.findCodeListItem(
          t[n].children,
          e
        );
        if (a)
          return a;
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
    return U.execScriptFn(
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
    const { navigateContexts: n, navigateParams: a } = this.model;
    let c = {};
    n && t && (c = Se(n, t, s, e));
    const m = Object.assign(e.clone(), c);
    let u = {};
    return a && t && (u = Se(a, t, s, e)), { context: m, params: u };
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
    ), n = t.isInitialLoad === !0, a = t.isLoadMore === !0;
    n ? this.curPage = 0 : a && (this.curPage += 1);
    const c = U.execScriptFn(
      { data: this.data, context: e, params: s },
      this.quoteUrl,
      {
        singleRowReturn: !0,
        isAsync: !1
      }
    ), m = {
      ...s,
      query: this.query,
      size: this.size,
      page: this.curPage,
      ...this.quoteParams
    };
    return ibiz.net[this.quoteMethod](c, m);
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
    return (t) => Qe(ss, {
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
function is(i) {
  const { script: t = "", data: e = {} } = i, s = U.execScriptFn({ data: e }, t, {
    singleRowReturn: !0,
    isAsync: !1
  });
  return "".concat(s);
}
const rs = {
  type: "mention",
  elemToHtml: is
};
function as(i) {
  const t = decodeURIComponent(i.getAttribute("data-value") || ""), e = JSON.parse(t);
  return {
    type: "mention",
    script: e.script,
    data: e,
    children: [{ text: "" }]
  };
}
const os = {
  selector: 'span[data-w-e-type="mention"]',
  parseElemHtml: as
};
function ls(i) {
  const { data: t = {} } = i, e = {
    name: "@".concat(t.name),
    id: t.id
  };
  return se(
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
const cs = {
  type: "mention",
  renderElem: ls
};
class ds {
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
const us = {
  key: "mention",
  factory() {
    return new ds();
  }
}, ms = {
  renderElems: [cs],
  elemsToHtml: [rs],
  parseElemsHtml: [os],
  menus: [us]
};
class hs {
  /**
   * Creates an instance of MenTionController.
   * @param {IData} option
   * @memberof MenTionController
   */
  constructor() {
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
    return t.insertText = (a) => {
      if (!this.editor) {
        e(a);
        return;
      }
      if (!this.editor.isFocused()) {
        e(a);
        return;
      }
      if (J.getSelectedElems(t).some((u) => t.isVoid(u))) {
        e(a);
        return;
      }
      a === "@" && !this.execting && (this.query = "", this.showModal()), e(a);
    }, t.isInline = (a) => J.getNodeType(a) === "mention" ? !0 : s(a), t.isVoid = (a) => J.getNodeType(a) === "mention" ? !0 : n(a), t;
  }
  registerNode() {
    window.mentionIsRegiter || ($.registerModule(ms), window.mentionIsRegiter = !0), $.registerPlugin(this.mentionPlugin.bind(this));
  }
  /**
   * 初始化
   *
   * @param {IDomEditor} editor
   * @memberof MenTionController
   */
  async init(t, e) {
    if (this.model = e.model, this.context = e.context, this.params = e.params, this.evt = e.evt, this.data = e.data, this.editor = t, this.editorParams = this.model.editorParams, this.editorParams) {
      const { USERURL: n, USERFIELDMAP: a, USERMETHOD: c, USERSCRIPT: m, USERINSCRIPT: u } = this.editorParams;
      n && (this.userUrl = n), a && (this.userFieldMap = JSON.parse(a)), c && (this.userMethod = c.toLowerCase()), m && (this.userScript = m), u && (this.userInScript = u);
    }
    const s = this.editor.getEditableContainer();
    s && (this.cleanup = Pe(s, "keydown", (n) => {
      var a;
      this.execting && this.presetPreventEvents.includes(n.keyCode) && n.preventDefault(), this.execting && this.presetPreventPropEvents.includes(n.keyCode) && (n.stopPropagation(), (a = this.overlay) == null || a.dismiss());
    }));
  }
  onDestroyed() {
    this.cleanup !== K && this.cleanup(), this.overlay && this.overlay.dismiss();
  }
  // 显示弹框
  showModal() {
    if (!this.userUrl)
      throw new Y("未配置提及用户USERURL编辑器参数！");
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
    return U.execScriptFn(
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
    const { navigateContexts: n, navigateParams: a } = this.model;
    let c = {};
    n && t && (c = Se(n, t, s, e));
    const m = Object.assign(e.clone(), c);
    let u = {};
    return a && t && (u = Se(a, t, s, e)), { context: m, params: u };
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
    ), n = t.isInitialLoad === !0, a = t.isLoadMore === !0;
    n ? this.curPage = 0 : a && (this.curPage += 1);
    const c = U.execScriptFn(
      { data: this.data, context: e, params: s },
      this.userUrl,
      {
        singleRowReturn: !0,
        isAsync: !1
      }
    ), m = {
      ...s,
      query: this.query,
      size: this.size,
      page: this.curPage
    };
    return ibiz.net[this.userMethod](c, m);
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
    return (t) => Qe(ts, {
      controller: this,
      modal: t
    });
  }
}
function fs(i) {
  const { script: t = "", data: e = {} } = i, s = U.execScriptFn({ data: e }, t, {
    singleRowReturn: !0,
    isAsync: !1
  });
  return "".concat(s);
}
const vs = {
  type: "page",
  elemToHtml: fs
};
function ps(i) {
  const t = decodeURIComponent(i.getAttribute("data-value") || ""), e = JSON.parse(t);
  return {
    type: "page",
    script: e.script,
    data: e,
    children: [{ text: "" }]
  };
}
const gs = {
  selector: 'span[data-w-e-type="page"]',
  parseElemHtml: ps
};
function ys(i) {
  const { data: t = {} } = i, e = {
    name: "".concat(t.name),
    id: t.id
  };
  return se(
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
const bs = {
  type: "Page",
  renderElem: ys
};
class Cs {
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
    throw new Y("暂未支持上传页面！");
  }
}
const ws = {
  key: "page",
  factory() {
    return new Cs();
  }
}, Es = {
  renderElems: [bs],
  elemsToHtml: [vs],
  parseElemsHtml: [gs],
  menus: [ws]
};
class Ms {
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
    window.pageIsRegiter || ($.registerModule(Es), window.pageIsRegiter = !0);
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
class j {
  /**
   * 初始化
   *
   * @static
   * @memberof CustomNodeFactory
   */
  static init(t) {
    this.registerMap.set("mention", hs), this.registerMap.set("marker", ns), this.registerMap.set("attachments", Rt), this.registerMap.set("codesnippet", Jt), this.registerMap.set("page", Ms), this.presetNodes.forEach((e) => {
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
      const a = new n();
      return this.customNodeMap.set(s, a), a;
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
r(j, "customNodeMap", /* @__PURE__ */ new Map()), /**
 * 预置注册表
 *
 * @type {Map<string, any>}
 * @memberof CustomNodeFactory
 */
r(j, "registerMap", /* @__PURE__ */ new Map()), /**
 * 预置注册节点
 *
 * @static
 * @memberof CustomNodeFactory
 */
r(j, "presetNodes", [
  "mention",
  "marker",
  "attachments",
  "codesnippet",
  "page"
]);
class Ss extends HTMLElement {
  // 监听的 attr
  static get observedAttributes() {
    return ["data-value"];
  }
  attributeChangedCallback(t, e, s) {
    if (t === "data-value") {
      if (s && e === s)
        return;
      const n = JSON.parse(s), a = this.attachShadow({ mode: "open" }), c = a.ownerDocument;
      if (n.icon) {
        const u = c.createElement("span");
        u.part.add("svg"), u.innerHTML = n.icon, a.appendChild(u);
      }
      if (n.identifier) {
        const u = c.createElement("span");
        u.part.add("identifier"), u.innerHTML = n.identifier, a.appendChild(u);
      }
      if (n.name) {
        const u = c.createElement("span");
        u.part.add("name"), u.innerHTML = n.name, a.appendChild(u);
      }
      const m = c.createElement("style");
      m.innerHTML = "\n      svg {\n        height: 1em;\n        width: 1em;\n      }\n    ", a.appendChild(m);
    }
  }
}
class ks extends HTMLElement {
  // 监听的 attr
  static get observedAttributes() {
    return ["data-value"];
  }
  attributeChangedCallback(t, e, s) {
    if (t === "data-value") {
      if (s && e === s)
        return;
      const n = JSON.parse(s), a = this.attachShadow({ mode: "open" }), c = a.ownerDocument, m = c.createElement("div");
      m.part.add("box"), m.classList.add("personnel-marker_box");
      let u = "";
      if (n.name) {
        u = he.stringToHexColor(n.name);
        const C = c.createElement("div");
        C.part.add("name"), C.classList.add("personnel-marker_name"), C.style.backgroundColor = u, C.innerHTML = n.name, m.appendChild(C);
      }
      const b = c.createElement("div");
      b.part.add("line"), b.classList.add("personnel-marker_line"), b.style.backgroundColor = u, m.appendChild(b), a.appendChild(m);
      const v = c.createElement("style");
      m.appendChild(v);
    }
  }
}
class xs {
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
    r(this, "onPaintFormat", nt(this.setPaintFormat, 500, !1));
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
const Ps = {
  key: "paintformat",
  factory() {
    return new xs();
  }
};
function Ls(i) {
  const { data: t = {} } = i;
  return "<span>".concat(t == null ? void 0 : t.name, "</span>");
}
const Hs = {
  type: "personnel-marker",
  elemToHtml: Ls
};
function Fs(i) {
  const t = decodeURIComponent(i.getAttribute("data-value") || "");
  return {
    type: "personnel-marker",
    data: JSON.parse(t),
    children: [{ text: "" }]
  };
}
const Ns = {
  selector: 'span[data-w-e-type="personnel-marker"]',
  parseElemHtml: Fs
};
function Ts(i) {
  const { data: t = {} } = i, e = {
    name: "".concat(t.name),
    id: t.id
  };
  return se(
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
const Os = {
  type: "personnel-marker",
  renderElem: Ts
}, Ds = {
  renderElems: [Os],
  elemsToHtml: [Hs],
  parseElemsHtml: [Ns]
}, Rs = (i) => {
  const { isInline: t, isVoid: e, deleteBackward: s } = i;
  return i.deleteBackward = (n) => {
    const { selection: a } = i;
    if (a && a.focus.offset === 0) {
      const [c, m] = a.focus.path;
      let u = m, b = c, v = !1;
      m === 0 && c !== 0 ? (b = b - 1, v = !0) : m > 0 && (u = u - 1);
      const C = i.children[b].children[v ? i.children[b].children.length - 1 : u];
      (C == null ? void 0 : C.type) === "personnel-marker" && i.moveReverse(1);
    }
    s(n);
  }, i.isInline = (n) => J.getNodeType(n) === "personnel-marker" ? !0 : t(n), i.isVoid = (n) => J.getNodeType(n) === "personnel-marker" ? !1 : e(n), i;
};
class Is extends ht {
  constructor() {
    super(...arguments);
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
    r(this, "collapsed", y(!0));
    /**
     * 是否隐藏
     *
     * @type {Ref<boolean>}
     * @memberof HtmlCommentController
     */
    r(this, "hidden", y(!1));
    /**
     * 回复
     *
     * @type {string}
     * @memberof HtmlCommentController
     */
    r(this, "reply", y(""));
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
    r(this, "uuid", bt());
    /**
     * 实时编辑（协同编辑）
     */
    r(this, "enableRealtime", !1);
    /**
     * 编辑器实例
     */
    r(this, "editor");
    /**
     * 编辑器实例原本的 apply（重要）
     */
    r(this, "apply");
    /**
     * 消息信息
     */
    r(this, "msg");
    /**
     * 是否在处理中
     */
    r(this, "processing", y(!1));
    r(this, "evt", new ft(
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
    if (await super.onInit(), this.registerCustomElem(), this.editorParams) {
      const {
        uploadParams: e,
        exportParams: s,
        MINHEIGHT: n,
        MAXHEIGHT: a,
        REPLYSCRIPT: c,
        MODE: m,
        INSERTKEYS: u,
        RENDERMODE: b,
        SAVEINTERVAL: v,
        EMITMODE: C,
        DEFAULTCOLLAPSE: k,
        ENABLEREALTIME: S
      } = this.editorParams;
      if (e)
        try {
          this.uploadParams = JSON.parse(e);
        } catch (L) {
          ibiz.log.error(
            "编辑器[".concat(ibiz.log.error(
              L
            ), "]编辑器参数 uploadParams 非 json 格式")
          );
        }
      if (s)
        try {
          this.exportParams = JSON.parse(s);
        } catch (L) {
          ibiz.log.error(
            "编辑器[".concat(ibiz.log.error(
              L
            ), "]编辑器参数 exportParams 非 json 格式")
          );
        }
      n && (this.minHeight = Number(n)), a && (this.maxHeight = Number(a)), c && (this.replyScript = c), m && (this.mode = m.toLowerCase()), u && (this.insertKeys = JSON.parse(u)), b && (this.renderMode = b), v && (this.saveInterval = Et(v)), C && (this.emitMode = C), k && (this.collapsed.value = !Object.is(k, "TRUE") && !Object.is(k, "true")), S && (this.enableRealtime = Object.is(S, "TRUE") || Object.is(S, "true"));
    }
    j.init(this.uuid), this.evt.on("onChange", () => {
      if (this.parent.form)
        return;
      const e = ibiz.uiDomainManager.get(this.context.srfsessionid);
      e && e.dataChange();
    });
  }
  /**
   * 注册自定义元素
   *
   * @private
   * @memberof HtmlCommentController
   */
  registerCustomElem() {
    window.customElements.get("mention-elem") || window.customElements.define("mention-elem", Ss), window.customElements.get("personnel-marker-elem") || window.customElements.define(
      "personnel-marker-elem",
      ks
    ), window.paintFormatIsRegiter || ($.registerMenu(Ps), window.paintFormatIsRegiter = !0), window.personnelMarkerIsRegiter || ($.registerModule(Ds), window.personnelMarkerIsRegiter = !0), $.registerPlugin(Rs);
  }
  /**
   * 初始化
   *
   * @param {IDomEditor} editor
   * @memberof HtmlCommentController
   */
  onCreated(e, s, n) {
    this.editor = e, this.initMarkOpenData(e, s), j.getPluginsById(this.uuid).forEach((c) => {
      c.init(e, {
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
   * 标记打开数据回调
   * @param msg
   */
  markOpenDataCallback(e) {
    const { action: s, data: n } = e;
    this.enableRealtime && s === "EDIT" && n && (n.type === "set_selection" ? (this.processing.value = !0, this.drawPersonnelMarker(e), this.processing.value = !1) : this.apply(n));
  }
  /**
   * 处理标记打开数据相关逻辑
   * @param editor
   * @param item
   */
  initMarkOpenData(e, s) {
    const { apply: n } = e;
    this.apply = n, this.msg = { deName: s.srfdecodename, srfkey: s.srfkey }, this.markOpenDataCallback = this.markOpenDataCallback.bind(this), e.apply = (a) => {
      !this.processing.value && this.enableRealtime && ibiz.markOpenData.send(
        this.msg.deName,
        this.msg.srfkey,
        "EDIT",
        a
      ), n(a);
    }, ibiz.markOpenData.subscribe(
      this.msg.deName,
      this.msg.srfkey,
      this.markOpenDataCallback
    );
  }
  /**
   * 组件销毁
   *
   * @memberof HtmlCollapseController
   */
  onDestroyed() {
    j.getPluginsById(this.uuid).forEach((s) => {
      s.onDestroyed();
    }), j.destroy(this.uuid), ibiz.markOpenData.unsubscribe(
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
    return j.getPluginsById(this.uuid).forEach((a) => {
      s = a.parseNode(s);
    }), s;
  }
  /**
   * 设置html
   *
   * @param {string} value
   * @memberof HtmlCommentController
   */
  async setValue(e) {
    this.collapsed.value = !1, this.hidden.value = !0, await A(), this.hidden.value = !1, await A();
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
        throw new Y("下载文件失败");
      if (s.data) {
        const n = e.name;
        wt(s.data, n);
      } else
        throw new Y("文件流数据不存在");
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
      s = yt({
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
   * @param item 消息
   */
  drawPersonnelMarker(e) {
    const { username: s, data: n } = e, { properties: a, newProperties: c } = n, m = {
      type: "personnel-marker",
      data: { name: s },
      children: [{ text: "" }]
    };
    if (a) {
      const { focus: u } = a;
      Ve.removeNodes(this.editor, {
        at: [u.path[0], u.path[1] + 1]
      });
    }
    if (c) {
      const { focus: u } = c;
      Ve.insertNodes(this.editor, [m], {
        at: u
      });
    }
  }
}
class As {
  constructor() {
    r(this, "formEditor", "HtmlComment");
    r(this, "gridEditor", "HtmlComment");
  }
  async createController(t, e) {
    const s = new Is(t, e);
    return await s.init(), s;
  }
}
const $s = gt($e, function(i) {
  i.component($e.name, $e), vt(
    "EDITOR_CUSTOMSTYLE_COMMENT",
    () => new As()
  );
}), Ys = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(i) {
    i.use($s), i.component(
      "IBizHtmlContent",
      mt(() => Promise.resolve().then(() => Mt))
    );
  }
};
export {
  $s as IBizHtmlComment,
  Ys as default
};
