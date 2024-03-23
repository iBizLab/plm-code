import './style.css';
var tt = Object.defineProperty;
var st = (r, t, e) => t in r ? tt(r, t, { enumerable: !0, configurable: !0, writable: !0, value: e }) : r[t] = e;
var a = (r, t, e) => (st(r, typeof t != "symbol" ? t + "" : t, e), e);
import { defineComponent as ue, ref as v, shallowRef as Be, watch as K, onBeforeUnmount as ve, onMounted as ce, createVNode as h, resolveComponent as k, createTextVNode as H, nextTick as N, onUnmounted as nt, computed as ze, withDirectives as qe, resolveDirective as me, h as Ve, defineAsyncComponent as rt } from "vue";
import { ScriptFactory as T, convertNavData as fe, EditorController as it, ControllerEvent as at, registerEditorProvider as ot } from "@ibiz-template/runtime";
import { getHtmlProps as Re, getEditorEmits as $e, useNamespace as de, withInstall as lt } from "@ibiz-template/vue3-util";
import { Editor as je, Toolbar as Je } from "@wangeditor/editor-for-vue";
import { SlateEditor as Ze, SlateElement as _e, Boot as V, DomEditor as Q } from "@wangeditor/editor";
import { getCookie as Ke, createUUID as ct } from "qx-util";
import { isNil as Qe } from "ramda";
import { CoreConst as We, awaitTimeout as ut, RuntimeError as j, listenJSEvent as ge, NOOP as O, downloadFileFromBlob as dt } from "@ibiz-template/core";
import { ElMessageBox as Ye } from "element-plus";
import { debounce as Ge } from "lodash-es";
const Xe = /* @__PURE__ */ ue({
  name: "IBizHtmlContent",
  props: Re(),
  emits: $e(),
  setup(r, {
    emit: t
  }) {
    const e = de("html"), s = r.controller, i = v(), o = v({});
    let c = null, f = 0;
    const d = v(), y = v(), g = Be(), S = v(), E = v(""), B = v({
      Authorization: "Bearer ".concat(Ke(We.TOKEN))
    }), M = v(""), F = v(""), L = v(!0), C = v(!1), u = v(!1), p = v(!1), w = v(!1), P = v(""), I = v([]), R = s.model;
    R.editorParams && (R.editorParams.enableEdit && (C.value = !0, u.value = !0, L.value = s.toBoolean(R.editorParams.enableEdit) && !r.readonly && !r.disabled), R.editorParams.enableFullScreen && (p.value = s.toBoolean(R.editorParams.enableFullScreen)));
    const J = (n) => {
      if (!g.value)
        return;
      const {
        eventArg: l
      } = n;
      l && (g.value.setHtml(l), t("focus"));
    }, $ = () => {
      g.value && (g.value.blur(), g.value.setHtml(""));
    }, W = () => {
      g.value && t("focus");
    };
    s.evt.on("setHtml", J), s.evt.on("clear", $), s.evt.on("onSetReply", W), K(() => r.data, (n) => {
      if (n) {
        const l = ibiz.util.file.calcFileUpDownUrl(s.context, s.params, n);
        M.value = l.uploadUrl, F.value = l.downloadUrl;
      }
    }, {
      immediate: !0,
      deep: !0
    });
    const Y = (n, l) => {
      if (l)
        return !0;
    }, Z = (n) => n, _ = {
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
    }, G = {
      placeholder: s.placeHolder,
      readOnly: C.value ? u.value : r.readonly,
      MENU_CONF: {
        // 图片上传
        uploadImage: {
          // 上传地址
          server: M.value,
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
          headers: B.value,
          // 跨域是否传递 cookie ，默认为 false
          withCredentials: !0,
          // 上传之前触发
          onBeforeUpload(n) {
            return n;
          },
          // 上传进度的回调函数
          onProgress(n) {
            console.log("progress", n);
          },
          // 单个文件上传成功之后
          onSuccess(n, l) {
            console.log("".concat(n.name, " 上传成功"), l);
          },
          // 单个文件上传失败
          onFailed(n, l) {
            console.log("".concat(n.name, " 上传失败"), l);
          },
          // 上传错误，或者触发 timeout 超时
          onError(n, l, m) {
            console.log("".concat(n.name, " 上传出错"), l, m);
          },
          // 自定义插入图片
          async customInsert(n, l) {
            const m = F.value.replace("%fileId%", n.id), b = n.filename;
            l(m, b, "");
          }
        },
        // 插入链接
        insertLink: {
          checkLink: Y,
          // 也支持 async 函数
          parseLinkUrl: Z
          // 也支持 async 函数
        },
        // 更新链接
        editLink: {
          checkLink: Y,
          // 也支持 async 函数
          parseLinkUrl: Z
          // 也支持 async 函数
        }
      }
    }, pe = async (n) => {
      const l = n.src;
      if (u.value)
        X(l);
      else {
        const m = Ze.nodes(g.value, {
          match: (b) => !!(_e.isElement(b) && b.type === "image"),
          universal: !0
        });
        if (m)
          for (const b of m) {
            const [x] = b;
            x.type === "image" && l.endsWith(x.src) && X(x.src);
          }
      }
    }, X = async (n) => {
      if (P.value = n, I.value = [n], await N(), S.value) {
        const {
          container: l
        } = S.value.$refs;
        l && l.children[0].click();
      }
    }, ye = (n) => {
      const l = n.getEditableContainer();
      l && l.querySelectorAll("img").forEach((b) => {
        b.onclick = (x) => {
          const le = x.target;
          le && pe(le);
        };
      });
    }, ee = (n) => {
      if (S.value) {
        const {
          container: l
        } = S.value.$refs;
        if (l) {
          const m = l.querySelector(".el-image-viewer__wrapper");
          m == null || m[n]("keydown", Ce);
        }
      }
    }, Ce = async (n) => {
      (n.key === "Escape" || n.keyCode === 27) && (n.stopPropagation(), n.preventDefault(), await N(), ee("removeEventListener"), I.value = []);
    }, we = async () => {
      await N(), ee("addEventListener");
    };
    ve(() => {
      const n = g.value;
      n != null && n.destroy();
    });
    const te = (n) => {
      g.value = n, n.setHtml(E.value), s.onCreated(g.value, r.data, _);
    }, se = (n) => {
      const l = n.getHtml();
      ye(n);
      const m = l === "<p><br></p>" ? "" : l;
      m === r.value || m === "" && Qe(r.value) || C.value || (t("change", m), s.evt.emit("onChange", {
        eventArg: m
      }));
    }, ne = (n) => {
      s.onDestroyed(), s.evt.off("setHtml", J), s.evt.off("clear", $), s.evt.off("onSetReply", W);
    }, re = () => {
      t("focus"), s.evt.emit("onFocus", {
        eventArg: r.value
      });
    }, ie = () => {
      t("blur"), s.evt.emit("onBlur", {
        eventArg: r.value
      });
    }, ae = (n, l) => {
      alert("【自定义提示】".concat(l, " - ").concat(n));
    }, oe = (n, l, m) => {
      m(!0);
    }, be = (n) => {
      const l = g.value;
      l != null && l.insertText(n);
    }, Ee = () => {
      const n = g.value;
      n != null && console.log(n.getHtml());
    }, D = () => {
      const n = g.value;
      n != null && n.disable();
    }, A = () => {
      const n = g.value;
      n != null && n.enable();
    }, Se = () => {
      if (i.value && d.value) {
        const n = i.value.offsetHeight;
        c = new ResizeObserver((l) => {
          const {
            height: m
          } = l[0].contentRect;
          if (m !== f) {
            const b = {
              height: "".concat(n - l[0].contentRect.height, "px")
            };
            o.value = e.cssVarBlock(b), f = m;
          }
        }), c.observe(d.value.selector);
      }
    }, xe = () => {
      var n, l;
      if (r.value) {
        const m = r.value.indexOf("</p>");
        if (m >= 0) {
          const b = (n = g.value.selection.anchor) == null ? void 0 : n.offset, x = (l = g.value.selection.anchor) == null ? void 0 : l.path;
          b === 0 && x.length > 0 && x[0] === 0 && g.value.move(m - 3);
        }
      }
    }, z = () => {
      u.value = !u.value, u.value ? D() : (A(), g.value.focus(), xe());
    }, Me = () => h("div", {
      class: e.be("message", "message-content")
    }, [h("p", null, [H("确定要取消编辑吗？")]), h("p", {
      class: e.bem("message", "message-content", "message-tip")
    }, [H("取消编辑将无法保存修改的内容，且不能找回。")])]), Pe = () => {
      r.value !== E.value ? Ye({
        title: "确认取消",
        type: "warning",
        customClass: e.b("message"),
        message: Me(),
        showCancelButton: !0,
        cancelButtonClass: e.be("message", "message-cancel"),
        confirmButtonClass: e.be("message", "message-comfire")
      }).then(() => {
        if (r.value) {
          const n = s.parseNode(r.value);
          E.value = n;
        } else
          E.value = "";
        z();
      }).catch(() => {
        g.value.focus();
      }) : z();
    }, Fe = () => {
      u.value = !0, g.value.disable(), t("change", E.value), w.value && (w.value = !1);
    }, Le = () => C.value ? h("div", {
      class: [e.b("footer"), {
        [e.b("footer-dialog")]: w.value
      }]
    }, [h("div", {
      class: e.be("footer", "cancel"),
      onClick: () => Pe()
    }, [H("取消")]), h("div", {
      class: e.be("footer", "save"),
      onClick: () => Fe()
    }, [H("保存")])]) : null, q = () => {
      w.value = !w.value, N(() => {
        u.value ? D() : (A(), g.value.focus());
      });
    }, ke = () => p.value ? w.value ? h("i", {
      class: "fa fa-compress",
      "aria-hidden": "true",
      onClick: () => q()
    }, null) : h("i", {
      class: "fa fa-expand",
      "aria-hidden": "true",
      onClick: () => q()
    }, null) : null, He = () => C.value || p.value ? h("div", {
      class: e.b("custom-toolbar")
    }, [C.value && L.value && u.value ? h("i", {
      class: "fa fa-edit",
      "aria-hidden": "true",
      onClick: () => z()
    }, null) : null, ke()]) : null, Ne = () => {
      if (s.reply.value) {
        const n = T.execScriptFn({
          value: s.reply.value
        }, s.replyScript, {
          singleRowReturn: !0,
          isAsync: !1
        });
        return h("div", {
          class: e.b("reply")
        }, [h("div", {
          class: e.be("reply", "content"),
          innerHTML: n
        }, null), h(k("ion-icon"), {
          name: "close-outline",
          onClick: () => s.removeReply()
        }, null)]);
      }
    }, Te = () => s.hidden.value ? null : h("div", {
      class: e.b("content"),
      ref: "htmlContent",
      style: o.value
    }, [h(je, {
      ref: "htmlRef",
      class: e.b("editor"),
      modelValue: E.value,
      "onUpdate:modelValue": (n) => E.value = n,
      "default-config": G,
      mode: "default",
      onOnCreated: te,
      onOnChange: se,
      onOnDestroyed: ne,
      onOnFocus: re,
      onOnBlur: ie,
      oncustomAlert: ae,
      oncustomPaste: oe
    }, null), Ne(), h(Je, {
      ref: "toolbarRef",
      editor: g.value,
      "default-config": _,
      mode: "default",
      class: e.b("toolbar")
    }, null)]), Ie = () => h(k("el-image"), {
      class: e.e("preview"),
      ref: "previewRef",
      "zoom-rate": 1.1,
      src: P.value,
      "preview-src-list": I.value,
      "hide-on-click-modal": !0,
      onShow: we,
      fit: "cover"
    }, null);
    return ce(() => {
      Se(), K(() => r.value, (n, l) => {
        n !== l && (typeof r.value == "string" || n == null) && (n == null ? E.value = "" : E.value = n);
      }, {
        immediate: !0
      }), K(() => r.disabled, (n, l) => {
        n !== l && (n === !0 ? D() : A());
      }, {
        immediate: !0
      });
    }), {
      ns: e,
      editorRef: g,
      previewRef: S,
      mode: "default",
      valueHtml: E,
      toolbarConfig: _,
      editorConfig: G,
      handleCreated: te,
      handleChange: se,
      handleDestroyed: ne,
      handleFocus: re,
      handleBlur: ie,
      customAlert: ae,
      customPaste: oe,
      insertText: be,
      printHtml: Ee,
      disable: D,
      enable: A,
      renderHeaserToolbar: He,
      renderEditorContent: Te,
      renderFooter: Le,
      htmlContent: i,
      hasEnableEdit: C,
      cssVars: o,
      toolbarRef: d,
      htmlRef: y,
      isFullScreen: w,
      readonlyState: u,
      changeFullScreenState: q,
      renderPreview: Ie
    };
  },
  render() {
    return this.isFullScreen ? h(k("el-dialog"), {
      modelValue: this.isFullScreen,
      "onUpdate:modelValue": (r) => this.isFullScreen = r,
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
}), ht = /* @__PURE__ */ Object.freeze(/* @__PURE__ */ Object.defineProperty({
  __proto__: null,
  default: Xe
}, Symbol.toStringTag, { value: "Module" })), mt = /* @__PURE__ */ ue({
  name: "IBizHtmlCollapse",
  props: Re(),
  emits: $e(),
  setup(r, {
    emit: t
  }) {
    const e = de("html"), s = r.controller, i = v(), o = v({});
    let c = null, f = 0;
    const d = v(), y = Be(), g = v(), S = v(), E = v(""), B = v({
      Authorization: "Bearer ".concat(Ke(We.TOKEN))
    }), M = v(""), F = v(""), L = v(!0), C = v(!1), u = v(!1), p = v(!1), w = v(!1), P = v(!0), I = v(!1), R = v(""), J = v([]), $ = s.model;
    $.editorParams && ($.editorParams.enableEdit && (C.value = !0, u.value = !0, L.value = s.toBoolean($.editorParams.enableEdit) && !r.readonly && !r.disabled), $.editorParams.enableFullScreen && (p.value = s.toBoolean($.editorParams.enableFullScreen))), K(() => r.data, (n) => {
      if (n) {
        const l = ibiz.util.file.calcFileUpDownUrl(s.context, s.params, n, s.editorParams);
        M.value = l.uploadUrl, F.value = l.downloadUrl;
      }
    }, {
      immediate: !0,
      deep: !0
    });
    const W = (n, l) => {
      if (l)
        return !0;
    }, Y = (n) => n, Z = {
      excludeKeys: ["group-video"],
      insertKeys: {
        index: 66,
        keys: ["marker"]
      }
    }, _ = {
      placeholder: s.placeHolder,
      readOnly: C.value ? u.value : r.readonly,
      MENU_CONF: {
        // 图片上传
        uploadImage: {
          // 上传地址
          server: M.value,
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
          headers: B.value,
          // 跨域是否传递 cookie ，默认为 false
          withCredentials: !0,
          // 上传之前触发
          onBeforeUpload(n) {
            return n;
          },
          // 上传进度的回调函数
          onProgress(n) {
            console.log("progress", n);
          },
          // 单个文件上传成功之后
          onSuccess(n, l) {
            console.log("".concat(n.name, " 上传成功"), l);
          },
          // 单个文件上传失败
          onFailed(n, l) {
            console.log("".concat(n.name, " 上传失败"), l);
          },
          // 上传错误，或者触发 timeout 超时
          onError(n, l, m) {
            console.log("".concat(n.name, " 上传出错"), l, m);
          },
          // 自定义插入图片
          async customInsert(n, l) {
            const m = F.value.replace("%fileId%", n.id), b = n.filename;
            l(m, b, "");
          }
        },
        // 插入链接
        insertLink: {
          checkLink: W,
          // 也支持 async 函数
          parseLinkUrl: Y
          // 也支持 async 函数
        },
        // 更新链接
        editLink: {
          checkLink: W,
          // 也支持 async 函数
          parseLinkUrl: Y
          // 也支持 async 函数
        }
      }
    };
    ve(() => {
      const n = y.value;
      n != null && n.destroy();
    });
    const G = async (n) => {
      if (s.maxHeight) {
        const l = n.getEditableContainer();
        I.value = l.offsetHeight > s.maxHeight;
      }
    }, pe = async (n) => {
      const l = n.src;
      if (u.value)
        X(l);
      else {
        const m = Ze.nodes(y.value, {
          match: (b) => !!(_e.isElement(b) && b.type === "image"),
          universal: !0
        });
        if (m)
          for (const b of m) {
            const [x] = b;
            x.type === "image" && l.endsWith(x.src) && X(x.src);
          }
      }
    }, X = async (n) => {
      if (R.value = n, J.value = [n], await N(), S.value) {
        const {
          container: l
        } = S.value.$refs;
        l && l.children[0].click();
      }
    }, ye = (n) => {
      const l = n.getEditableContainer();
      l && l.querySelectorAll("img").forEach((b) => {
        b.onload = () => {
          G(n);
        }, b.onclick = (x) => {
          const le = x.target;
          le && pe(le);
        };
      });
    }, ee = (n) => {
      if (S.value) {
        const {
          container: l
        } = S.value.$refs;
        if (l) {
          const m = l.querySelector(".el-image-viewer__wrapper");
          m == null || m[n]("keydown", Ce);
        }
      }
    }, Ce = async (n) => {
      (n.key === "Escape" || n.keyCode === 27) && (n.stopPropagation(), n.preventDefault(), await N(), ee("removeEventListener"), J.value = []);
    }, we = async () => {
      await N(), ee("addEventListener");
    }, te = (n) => {
      y.value = n, s.onCreated(y.value, r.data, Z);
      const l = s.parseNode(E.value);
      n.setHtml(l);
    }, se = (n) => {
      const l = n.getHtml();
      G(n), ye(n);
      const m = l === "<p><br></p>" ? "" : l;
      m === r.value || m === "" && Qe(r.value) || (!C.value && n.isFocused() && t("change", m), s.evt.emit("onChange", {
        eventArg: m
      }));
    }, ne = (n) => {
      s.onDestroyed();
    }, re = (n) => {
      t("focus"), s.evt.emit("onFocus", {
        eventArg: r.value
      });
    }, ie = (n) => {
      t("blur"), s.evt.emit("onBlur", {
        eventArg: r.value
      });
    }, ae = (n, l) => {
      alert("【自定义提示】".concat(l, " - ").concat(n));
    }, oe = (n, l, m) => {
      m(!0);
    }, be = (n) => {
      const l = y.value;
      l != null && l.insertText(n);
    }, Ee = () => {
      const n = y.value;
      n != null && console.log(n.getHtml());
    }, D = () => {
      const n = y.value;
      n != null && n.disable();
    }, A = () => {
      const n = y.value;
      n != null && n.enable();
    };
    ce(() => {
      K(() => r.value, (n, l) => {
        n !== l && (typeof r.value == "string" || n == null) && (n == null ? E.value = "" : E.value = n);
      }, {
        immediate: !0
      }), K(() => r.disabled, (n, l) => {
        n !== l && (n === !0 ? D() : A());
      }, {
        immediate: !0
      });
    });
    const Se = () => {
      ut(0, () => {
        if (i.value && d.value) {
          const n = i.value.offsetHeight;
          c = new ResizeObserver((l) => {
            const {
              height: m
            } = l[0].contentRect;
            if (m !== f) {
              const b = {
                height: "".concat(n - l[0].contentRect.height, "px")
              };
              o.value = e.cssVarBlock(b), f = m;
            }
          }), c.observe(d.value.selector);
        }
      });
    }, xe = () => {
      var n, l;
      if (r.value) {
        const m = r.value.indexOf("</p>");
        if (m >= 0) {
          const b = (n = y.value.selection.anchor) == null ? void 0 : n.offset, x = (l = y.value.selection.anchor) == null ? void 0 : l.path;
          b === 0 && x.length > 0 && x[0] === 0 && y.value.move(m - 3);
        }
      }
    }, z = () => {
      if (u.value = !u.value, !u.value)
        A(), y.value.focus(), xe(), P.value = !0;
      else {
        if (g.value) {
          const {
            box: n
          } = g.value.$refs;
          n.scroll(0, 0);
        }
        D();
      }
    }, Me = () => h("div", {
      class: e.be("message", "message-content")
    }, [h("p", null, [H("确定要取消编辑吗？")]), h("p", {
      class: e.bem("message", "message-content", "message-tip")
    }, [H("取消编辑将无法保存修改的内容，且不能找回。")])]), Pe = () => {
      r.value !== E.value ? Ye({
        title: "确认取消",
        type: "warning",
        customClass: e.b("message"),
        message: Me(),
        showCancelButton: !0,
        cancelButtonClass: e.be("message", "message-cancel"),
        confirmButtonClass: e.be("message", "message-comfire")
      }).then(() => {
        if (r.value) {
          const n = s.parseNode(r.value);
          E.value = n;
        } else
          E.value = "";
        z();
      }).catch(() => {
        y.value.focus();
      }) : z();
    }, Fe = () => {
      u.value = !0, y.value.disable(), t("change", E.value), w.value && (w.value = !1);
    }, Le = () => C.value ? h("div", {
      class: [e.b("footer"), {
        [e.b("footer-dialog")]: w.value
      }]
    }, [h("div", {
      class: e.be("footer", "cancel"),
      onClick: () => Pe()
    }, [H("取消")]), h("div", {
      class: e.be("footer", "save"),
      onClick: () => Fe()
    }, [H("保存")])]) : null, q = () => {
      w.value = !w.value, P.value = !w.value, N(() => {
        u.value ? D() : (A(), y.value.focus());
      });
    }, ke = () => p.value ? w.value ? h("i", {
      class: "fa fa-compress",
      "aria-hidden": "true",
      onClick: () => q()
    }, null) : h("i", {
      class: "fa fa-expand",
      "aria-hidden": "true",
      onClick: () => q()
    }, null) : null, He = () => C.value || p.value ? h("div", {
      class: e.b("custom-toolbar")
    }, [C.value && L.value && u.value ? h("i", {
      class: "fa fa-edit",
      "aria-hidden": "true",
      onClick: () => z()
    }, null) : null, ke()]) : null, Ne = () => I.value ? P.value ? h("div", {
      class: e.e("toggle"),
      onClick: () => {
        P.value = !P.value;
      }
    }, [H("展开更多 "), h(k("ion-icon"), {
      name: "arrow-down-outline"
    }, null)]) : h("div", {
      class: e.e("toggle"),
      onClick: () => {
        P.value = !P.value;
      }
    }, [H("收起更多 "), h(k("ion-icon"), {
      name: "arrow-up-outline"
    }, null)]) : null, Te = () => {
      const n = {
        ...o.value
      };
      return P.value && s.maxHeight && Object.assign(n, {
        maxHeight: "".concat(s.maxHeight, "px")
      }), h("div", {
        class: e.b("content"),
        ref: "htmlContent",
        style: n
      }, [h(Je, {
        ref: "toolbarRef",
        editor: y.value,
        "default-config": Z,
        mode: "default",
        class: e.b("toolbar")
      }, null), h(je, {
        ref: "htmlRef",
        class: e.b("editor"),
        modelValue: E.value,
        "onUpdate:modelValue": (l) => E.value = l,
        "default-config": _,
        mode: "default",
        onOnCreated: te,
        onOnChange: se,
        onOnDestroyed: ne,
        onOnFocus: re,
        onOnBlur: ie,
        oncustomAlert: ae,
        oncustomPaste: oe
      }, null)]);
    }, Ie = () => h(k("el-image"), {
      class: e.e("preview"),
      ref: "previewRef",
      "zoom-rate": 1.1,
      src: R.value,
      "preview-src-list": J.value,
      "hide-on-click-modal": !0,
      onShow: we,
      fit: "cover"
    }, null);
    return ce(() => {
      Se();
    }), nt(() => {
      c && c.disconnect();
    }), {
      ns: e,
      editorRef: y,
      previewRef: S,
      htmlRef: g,
      mode: "default",
      valueHtml: E,
      toolbarConfig: Z,
      editorConfig: _,
      handleCreated: te,
      handleChange: se,
      handleDestroyed: ne,
      handleFocus: re,
      handleBlur: ie,
      customAlert: ae,
      customPaste: oe,
      insertText: be,
      printHtml: Ee,
      disable: D,
      enable: A,
      renderHeaserToolbar: He,
      renderEditorContent: Te,
      renderToggle: Ne,
      renderFooter: Le,
      htmlContent: i,
      hasEnableEdit: C,
      cssVars: o,
      toolbarRef: d,
      isFullScreen: w,
      readonlyState: u,
      collapse: P,
      changeFullScreenState: q,
      renderPreview: Ie
    };
  },
  render() {
    return this.isFullScreen ? h(k("el-dialog"), {
      modelValue: this.isFullScreen,
      "onUpdate:modelValue": (r) => this.isFullScreen = r,
      width: "80%",
      top: "10vh",
      class: this.ns.b("dialog-full-screen"),
      onClose: () => this.changeFullScreenState()
    }, {
      default: () => [h("div", {
        class: [this.ns.b(), this.ns.b("collapse"), {
          [this.ns.b("editor-readonly")]: this.readonlyState
        }]
      }, [this.renderHeaserToolbar(), this.renderEditorContent(), this.hasEnableEdit && !this.readonlyState ? this.renderFooter() : null])]
    }) : h("div", {
      class: [this.ns.b(), this.ns.is("allow-collapse", !0), {
        [this.ns.b("editor-readonly")]: this.readonlyState
      }]
    }, [this.renderHeaserToolbar(), this.renderEditorContent(), this.readonlyState ? this.renderToggle() : null, this.hasEnableEdit && !this.readonlyState ? this.renderFooter() : null, this.renderPreview()]);
  }
});
const De = /* @__PURE__ */ ue({
  name: "HtmlComment",
  props: Re(),
  emits: $e(),
  setup(r, {
    emit: t
  }) {
    const e = de("html-comment"), s = r.controller, i = v(), o = v();
    return {
      ns: e,
      c: s,
      comment: i,
      editorRef: o,
      onChange: (g) => {
        t("change", g), g && s.collapsed.value && (s.collapsed.value = !1);
      },
      onFocus: () => {
        s.collapsed.value = !1, t("focus");
      },
      onBlur: () => {
        if (t("blur"), r.value)
          return null;
        s.collapsed.value = !0;
      },
      renderAvatar: () => {
        const g = s.stringToHexColor(s.context.srfusername), S = s.avatarName(s.context.srfusername);
        return s.context.srfusername ? h("div", {
          class: e.e("avatar-name"),
          style: "background: ".concat(g, ";")
        }, [S]) : h(k("el-avatar"), {
          class: e.e("avatar"),
          src: "./assets/images/user-avatar.png"
        }, null);
      }
    };
  },
  render() {
    return this.c.mode === "default" ? h(mt, {
      controller: this.c,
      data: this.data,
      value: this.value,
      onChange: this.onChange,
      onFocus: this.onFocus,
      onBlur: this.onBlur
    }, null) : h("div", {
      ref: "comment",
      class: [this.ns.b(), this.ns.is("collapse", this.c.collapsed.value)],
      style: {
        height: "".concat(this.c.collapsed.value ? this.c.minHeight : this.c.maxHeight, "px")
      }
    }, [this.renderAvatar(), h(Xe, {
      controller: this.c,
      data: this.data,
      value: this.value,
      onChange: this.onChange,
      onFocus: this.onFocus,
      onBlur: this.onBlur
    }, null)]);
  }
});
function Ue(r, t, e, s, i) {
  const o = t === void 0 ? void 0 : t.key;
  return { sel: r, data: t, children: e, text: s, elm: i, key: o };
}
const Oe = Array.isArray;
function Ae(r) {
  return typeof r == "string" || typeof r == "number" || r instanceof String || r instanceof Number;
}
function et(r, t, e) {
  if (r.ns = "http://www.w3.org/2000/svg", e !== "foreignObject" && t !== void 0)
    for (let s = 0; s < t.length; ++s) {
      const i = t[s];
      if (typeof i == "string")
        continue;
      const o = i.data;
      o !== void 0 && et(o, i.children, i.sel);
    }
}
function he(r, t, e) {
  let s = {}, i, o, c;
  if (e !== void 0 ? (t !== null && (s = t), Oe(e) ? i = e : Ae(e) ? o = e.toString() : e && e.sel && (i = [e])) : t != null && (Oe(t) ? i = t : Ae(t) ? o = t.toString() : t && t.sel ? i = [t] : s = t), i !== void 0)
    for (c = 0; c < i.length; ++c)
      Ae(i[c]) && (i[c] = Ue(void 0, void 0, void 0, i[c], void 0));
  return r[0] === "s" && r[1] === "v" && r[2] === "g" && (r.length === 3 || r[3] === "." || r[3] === "#") && et(s, i, r), Ue(r, s, i, o, void 0);
}
function ft(r) {
  const { script: t = "", data: e = {} } = r, s = T.execScriptFn({ data: e }, t, {
    singleRowReturn: !0,
    isAsync: !1
  });
  return "".concat(s);
}
const vt = {
  type: "attachments",
  elemToHtml: ft
};
function gt(r) {
  const t = decodeURIComponent(r.getAttribute("data-value") || ""), e = JSON.parse(t);
  return {
    type: "attachments",
    script: e.script,
    data: e,
    children: [{ text: "" }]
  };
}
const pt = {
  selector: 'span[data-w-e-type="attachments"]',
  parseElemHtml: gt
};
function yt(r) {
  const { data: t = {} } = r, e = {
    name: "".concat(t.name),
    id: t.id
  };
  return he(
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
const Ct = {
  type: "attachments",
  renderElem: yt
};
class wt {
  constructor() {
    a(this, "title", "本地文件");
    a(this, "tag", "button");
    a(this, "iconSvg", '<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="36px" height="36px" viewBox="0 0 36 36" version="1.1">\n    <title>附件</title>\n    <g id="附件" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\n        <g id="icon">\n            <rect id="矩形" stroke="#EEEEEE" fill="#FFFFFF" x="0.5" y="0.5" width="35" height="35" rx="4"/>\n            <g id="编组-28" transform="translate(2.997929, 8.001508)">\n                <path d="M13.9611058,12.6330155 C13.9611058,14.5460163 12.4108408,16.0968098 10.498492,16.0968098 C8.58614322,16.0968098 7.03587822,14.5460163 7.03590808,12.6393438 L7.03590808,12.6393438 L6.98338468,7.07669061 C6.97992133,6.70644889 7.27712693,6.40347538 7.64724246,6.39998034 C8.017358,6.39648531 8.32022824,6.69379224 8.32372209,7.06403396 L8.32372209,7.06403396 L8.37624485,12.6330155 C8.37624485,13.8054998 9.32640727,14.7559862 10.498492,14.7559862 C11.6705768,14.7559862 12.6207392,13.8054998 12.6207392,12.6330155 L12.6207392,12.6330155 L12.6207392,6.46506253 C12.6207392,4.69957562 11.0562006,3.24725012 9.10227678,3.24725012 C7.148353,3.24725012 5.58381437,4.69957562 5.58381437,6.46506253 L5.58381437,6.46506253 L5.58381437,12.8655397 C5.58381437,15.5621365 7.78332719,17.7497339 10.498492,17.7497339 C13.2136568,17.7497339 15.4131697,15.5621365 15.4131697,12.8655397 L15.4131697,12.8655397 L15.4131697,7.10001026 C15.4131697,6.72975204 15.713221,6.42959845 16.083353,6.42959845 C16.453485,6.42959845 16.7535363,6.72975204 16.7535363,7.10001026 L16.7535363,7.10001026 L16.7535363,12.8655397 C16.7535363,16.3043913 13.9521943,19.0905575 10.498492,19.0905575 C7.04478976,19.0905575 4.24344774,16.3043913 4.24344774,12.8655397 L4.24344774,12.8655397 L4.24344774,6.46506253 C4.24344774,3.93573556 6.42955024,1.90642651 9.10227678,1.90642651 C11.7750033,1.90642651 13.9611058,3.93573556 13.9611058,6.46506253 L13.9611058,6.46506253 Z" id="形状结合" fill="#DDDDDD" transform="translate(10.498492, 10.498492) rotate(-315.000000) translate(-10.498492, -10.498492) "/>\n                <path d="M21.6662931,9.87797441 L24.6096402,9.87797441 C24.9410111,9.87797441 25.2096402,10.1466036 25.2096402,10.4779744 C25.2096402,10.8093453 24.9410111,11.0779744 24.6096402,11.0779744 L21.6662931,11.0779744 C21.3349223,11.0779744 21.0662931,10.8093453 21.0662931,10.4779744 C21.0662931,10.1466036 21.3349223,9.87797441 21.6662931,9.87797441 Z" id="矩形备份-74" fill="#73D897"/>\n                <path d="M21.6662931,4.29120933 L27.4020707,4.29120933 C27.7334415,4.29120933 28.0020707,4.55983848 28.0020707,4.89120933 C28.0020707,5.22258018 27.7334415,5.49120933 27.4020707,5.49120933 L21.6662931,5.49120933 C21.3349223,5.49120933 21.0662931,5.22258018 21.0662931,4.89120933 C21.0662931,4.55983848 21.3349223,4.29120933 21.6662931,4.29120933 Z" id="矩形备份-75" fill="#6698FF"/>\n                <path d="M21.6662931,15.4647395 L27.4020707,15.4647395 C27.7334415,15.4647395 28.0020707,15.7333686 28.0020707,16.0647395 C28.0020707,16.3961103 27.7334415,16.6647395 27.4020707,16.6647395 L21.6662931,16.6647395 C21.3349223,16.6647395 21.0662931,16.3961103 21.0662931,16.0647395 C21.0662931,15.7333686 21.3349223,15.4647395 21.6662931,15.4647395 Z" id="矩形备份-77" fill="#FF7575"/>\n            </g>\n        </g>\n    </g>\n</svg>');
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
    throw new j("暂未支持上传本地文件！");
  }
}
const bt = {
  key: "attachments",
  factory() {
    return new wt();
  }
}, Et = {
  renderElems: [Ct],
  elemsToHtml: [vt],
  parseElemsHtml: [pt],
  menus: [bt]
};
class St {
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
    a(this, "model");
    /**
     * 上下文
     *
     * @type {IContext}
     */
    a(this, "context");
    /**
     * 视图参数
     *
     * @type {IParams}
     */
    a(this, "params");
    /**
     * 表单数据
     *
     * @type {IData}
     * @memberof AttachmentsController
     */
    a(this, "data", {});
    /**
     * 编辑器示例
     *
     * @type {IDomEditor}
     * @memberof AttachmentsController
     */
    a(this, "editor");
    /**
     * 编辑器参数
     *
     * @type {IData}
     * @memberof AttachmentsController
     */
    a(this, "editorParams");
    /**
     * 用户数据
     *
     * @type {IData[]}
     * @memberof AttachmentsController
     */
    a(this, "items", []);
    /**
     * 编辑器事件
     *
     * @type {ControllerEvent<commentEvent>}
     * @memberof AttachmentsController
     */
    a(this, "evt");
    /**
     * 是否正在执行
     *
     * @private
     * @type {boolean}
     * @memberof AttachmentsController
     */
    a(this, "execting", !1);
    this.registerNode();
  }
  registerNode() {
    window.attachmentsIsRegiter || (V.registerModule(Et), window.attachmentsIsRegiter = !0);
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
function xt(r) {
  const { script: t = "", data: e = {} } = r, s = T.execScriptFn({ data: e }, t, {
    singleRowReturn: !0,
    isAsync: !1
  });
  return "".concat(s);
}
const Mt = {
  type: "codesnippet",
  elemToHtml: xt
};
function Pt(r) {
  const t = decodeURIComponent(r.getAttribute("data-value") || ""), e = JSON.parse(t);
  return {
    type: "codesnippet",
    script: e.script,
    data: e,
    children: [{ text: "" }]
  };
}
const Ft = {
  selector: 'span[data-w-e-type="codesnippet"]',
  parseElemHtml: Pt
};
function Lt(r) {
  const { data: t = {} } = r, e = {
    name: "".concat(t.name),
    id: t.id
  };
  return he(
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
const kt = {
  type: "CodeSnippet",
  renderElem: Lt
};
class Ht {
  constructor() {
    a(this, "title", "代码段");
    a(this, "tag", "button");
    a(this, "iconSvg", '<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="36px" height="36px" viewBox="0 0 36 36" version="1.1">\n  <title>代码段</title>\n  <g id="代码段" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\n      <g id="icon备份">\n          <rect id="矩形" stroke="#EEEEEE" fill="#FFFFFF" x="0.5" y="0.5" width="35" height="35" rx="4"/>\n          <path d="M24.6642225,18.8794824 L27.6075695,18.8794824 C27.9389404,18.8794824 28.2075695,19.1481115 28.2075695,19.4794824 C28.2075695,19.8108532 27.9389404,20.0794824 27.6075695,20.0794824 L24.6642225,20.0794824 C24.3328516,20.0794824 24.0642225,19.8108532 24.0642225,19.4794824 C24.0642225,19.1481115 24.3328516,18.8794824 24.6642225,18.8794824 Z" id="矩形备份-74" fill="#73D897"/>\n          <path d="M24.6642225,13.2927173 L30.4,13.2927173 C30.7313708,13.2927173 31,13.5613465 31,13.8927173 C31,14.2240882 30.7313708,14.4927173 30.4,14.4927173 L24.6642225,14.4927173 C24.3328516,14.4927173 24.0642225,14.2240882 24.0642225,13.8927173 C24.0642225,13.5613465 24.3328516,13.2927173 24.6642225,13.2927173 Z" id="矩形备份-75" fill="#6698FF"/>\n          <path d="M24.6642225,24.4662475 L30.4,24.4662475 C30.7313708,24.4662475 31,24.7348766 31,25.0662475 C31,25.3976183 30.7313708,25.6662475 30.4,25.6662475 L24.6642225,25.6662475 C24.3328516,25.6662475 24.0642225,25.3976183 24.0642225,25.0662475 C24.0642225,24.7348766 24.3328516,24.4662475 24.6642225,24.4662475 Z" id="矩形备份-77" fill="#FF7575"/>\n          <g id="1.Base基础/1.icon图标/11.editor/header-1" transform="translate(5.000000, 11.000000)" fill="#DDDDDD">\n              <path d="M4.68266589,2.39258039 L1.51032474,7.44797324 L5.01586095,12.7216272 L4.05994646,13.3212428 L0.126424153,7.40475416 L3.68603474,1.72997946 L4.68266589,2.39258039 Z M11.3173341,12.6697762 L14.4896753,7.61438339 L10.984139,2.34072939 L11.9400535,1.7411138 L15.8735758,7.65760247 L12.3139653,13.3323772 L11.3173341,12.6697762 Z M8.86596086,1.31248434 L10.0376294,1.55020137 L7.19605832,13.6243456 L6.0243898,13.3866286 L8.86596086,1.31248434 Z" id="形状结合"/>\n          </g>\n      </g>\n  </g>\n</svg>');
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
    throw new j("暂未支持上传代码段！");
  }
}
const Nt = {
  key: "codesnippet",
  factory() {
    return new Ht();
  }
}, Tt = {
  renderElems: [kt],
  elemsToHtml: [Mt],
  parseElemsHtml: [Ft],
  menus: [Nt]
};
class It {
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
    a(this, "model");
    /**
     * 上下文
     *
     * @type {IContext}
     */
    a(this, "context");
    /**
     * 视图参数
     *
     * @type {IParams}
     */
    a(this, "params");
    /**
     * 表单数据
     *
     * @type {IData}
     * @memberof CodeSnippetController
     */
    a(this, "data", {});
    /**
     * 编辑器示例
     *
     * @type {IDomEditor}
     * @memberof CodeSnippetController
     */
    a(this, "editor");
    /**
     * 编辑器参数
     *
     * @type {IData}
     * @memberof CodeSnippetController
     */
    a(this, "editorParams");
    /**
     * 用户数据
     *
     * @type {IData[]}
     * @memberof CodeSnippetController
     */
    a(this, "items", []);
    /**
     * 编辑器事件
     *
     * @type {ControllerEvent<commentEvent>}
     * @memberof CodeSnippetController
     */
    a(this, "evt");
    /**
     * 是否正在执行
     *
     * @private
     * @type {boolean}
     * @memberof CodeSnippetController
     */
    a(this, "execting", !1);
    this.registerNode();
  }
  registerNode() {
    window.codesnippetIsRegiter || (V.registerModule(Tt), window.codesnippetIsRegiter = !0);
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
function Dt(r) {
  const { script: t = "", data: e = {} } = r, s = T.execScriptFn({ data: e }, t, {
    singleRowReturn: !0,
    isAsync: !1
  });
  return "".concat(s);
}
const At = {
  type: "marker",
  elemToHtml: Dt
};
function Rt(r) {
  const t = decodeURIComponent(r.getAttribute("data-value") || ""), e = JSON.parse(t);
  return {
    type: "marker",
    script: e.script,
    data: e,
    children: [{ text: "" }]
  };
}
const $t = {
  selector: 'span[data-w-e-type="marker"]',
  parseElemHtml: Rt
};
function Ut(r) {
  const { data: t = {} } = r;
  return he(
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
const Ot = {
  type: "marker",
  renderElem: Ut
};
let Bt = class {
  constructor() {
    a(this, "title", "提及工作项");
    a(this, "tag", "button");
    a(this, "iconSvg", '<svg t="1706259772097" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="6854" width="200" height="200"><path d="M929.28 625.664l-234.496 0.512 24.064-229.888 210.432-0.512c20.992 0 38.4-17.408 38.4-38.4s-17.408-38.4-38.4-38.4H727.04l29.184-275.456c2.048-20.992-13.312-39.936-34.304-41.984-20.992-2.048-39.936 13.312-41.984 34.304L650.24 318.976l-232.448 0.512 29.184-275.456c2.048-20.992-13.312-39.936-34.304-41.984-20.992-2.048-39.936 13.312-41.984 34.304l-29.696 283.648-246.272 0.512c-20.992 0-38.4 17.408-38.4 38.4s17.408 38.4 38.4 38.4l238.08-0.512-24.064 229.888-214.016 0.512c-20.992 0-38.4 17.408-38.4 38.4s17.408 38.4 38.4 38.4l205.824-0.512-29.184 276.992c-2.048 20.992 13.312 39.936 34.304 41.984h4.096c19.456 0 35.84-14.848 37.888-34.304l30.208-285.184 232.448-0.512-29.184 277.504c-2.048 20.992 13.312 39.936 34.304 41.984h4.096c19.456 0 35.84-14.848 38.4-34.304l30.208-285.184 242.688-0.512c20.992 0 38.4-17.408 38.4-38.4-1.536-20.992-18.944-37.888-39.936-37.888z m-544.256 0.512l24.064-229.888 232.448-0.512-24.064 229.888-232.448 0.512z" fill="#979797" p-id="6855"></path></svg>');
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
const zt = {
  key: "marker",
  factory() {
    return new Bt();
  }
}, qt = {
  renderElems: [Ot],
  elemsToHtml: [At],
  parseElemsHtml: [$t],
  menus: [zt]
};
const Vt = /* @__PURE__ */ ue({
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
  setup(r) {
    const t = de("mention"), e = r.controller, s = v(!1), i = v([]);
    let o = O;
    const c = v({}), f = v(0), d = (C) => {
      const {
        eventArg: u
      } = C;
      if (u) {
        !u.includes("@") && e.overlay && e.execting && e.overlay.dismiss();
        const p = u.match(new RegExp("(?<=\\@)([^\\@&^{]*?)(?=\\<)", "g")) || [];
        e.execting && (p.length === 0 && e.overlay.dismiss(), e.query = p.pop() || "", e.query && /\s$/.test(e.query) ? e.overlay.dismiss() : e.query && B({
          isInitialLoad: !0
        }));
      } else
        e.overlay && e.execting && e.overlay.dismiss();
    }, y = () => {
      e.evt && e.evt.on("onChange", d);
    }, g = (C = {}) => {
      s.value = !0, e.getUsers(C).then((u) => {
        (u.status !== 200 || !u.data) && (s.value = !1), u.headers["x-total"] && (f.value = Number(u.headers["x-total"])), C.isLoadMore === !0 ? i.value.push(...e.toUIData(u.data)) : (i.value = e.toUIData(u.data), i.value.length > 0 && (c.value = i.value[0])), s.value = !1;
      }).catch(() => {
        s.value = !1;
      });
    }, S = () => {
      g({
        isLoadMore: !0
      });
    }, E = ze(() => i.value.length >= f.value || s.value || f.value <= e.size), B = Ge(g, 300, {
      leading: !0
    });
    y(), g({
      isInitialLoad: !0
    });
    const M = (C) => {
      let u = i.value.findIndex((p) => p.id === c.value.id);
      switch (C) {
        case "up":
          u--, (u === -1 || u === -2) && (u = i.value.length - 1), c.value = i.value[u];
          break;
        case "down":
          u++, u === i.value.length && (u = 0), c.value = i.value[u];
          break;
        case "enter":
          F(c.value);
          break;
      }
    }, F = (C) => {
      var u;
      if (r.modal) {
        const p = {
          ok: !0,
          data: [C]
        };
        (u = r.modal) == null || u.dismiss(p);
      }
    }, L = (C) => {
      const u = C.name, p = e.stringToHexColor(u), w = e.avatarName(u);
      return h("div", {
        class: [t.e("item"), t.is("active", C.id === c.value.id)],
        onClick: () => F(C)
      }, [h("div", {
        class: t.e("avatar"),
        style: "background: ".concat(p, ";")
      }, [w]), h("div", {
        class: t.e("name"),
        title: u
      }, [u])]);
    };
    return ce(() => {
      o = ge(window, "keyup", (C) => {
        C.keyCode === 40 ? M("down") : C.keyCode === 38 ? M("up") : C.keyCode === 13 && M("enter");
      });
    }), ve(() => {
      o !== O && o(), e.evt.off("onChange", d);
    }), {
      ns: t,
      items: i,
      loading: s,
      isLodeMoreDisabled: E,
      renderItem: L,
      loadMore: S
    };
  },
  render() {
    return qe(h("div", {
      "infinite-scroll-distance": 10,
      "infinite-scroll-disabled": this.isLodeMoreDisabled,
      "infinite-scroll-immediate": !1,
      class: this.ns.b()
    }, [this.items.map((r) => this.renderItem(r)), this.items.length === 0 && h(k("iBizNoData"), {
      text: "暂未用户数据"
    }, null)]), [[me("infinite-scroll"), () => this.loadMore()], [me("loading"), this.loading]]);
  }
});
const jt = /* @__PURE__ */ ue({
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
  setup(r) {
    const t = de("marker"), e = r.controller, s = v(!1), i = v([]);
    let o = O;
    const c = v({}), f = v(0), d = (u) => {
      const {
        eventArg: p
      } = u;
      if (p) {
        !p.includes("#") && e.overlay && e.execting && e.overlay.dismiss();
        const w = /<svg((.|[\t\r\f\n\s])+?)<\/svg>/g, I = p.replace(w, "").match(new RegExp("(?<=\\#)([^\\#&^{]*?)(?=\\<)", "g")) || [];
        e.execting && (I.length === 0 && e.overlay.dismiss(), e.query = I.pop() || "", e.query && /\s$/.test(e.query) ? e.overlay.dismiss() : e.query && B({
          isInitialLoad: !0
        }));
      } else
        e.overlay && e.execting && e.overlay.dismiss();
    }, y = () => {
      e.evt && e.evt.on("onChange", d);
    }, g = (u = {}) => {
      s.value = !0, e.load(u).then((p) => {
        (p.status !== 200 || !p.data) && (s.value = !1), p.headers["x-total"] && (f.value = Number(p.headers["x-total"])), u.isLoadMore === !0 ? i.value.push(...e.toUIData(p.data)) : (i.value = e.toUIData(p.data), i.value.length > 0 && (c.value = i.value[0])), s.value = !1;
      }).catch(() => {
        s.value = !1;
      });
    }, S = () => {
      g({
        isLoadMore: !0
      });
    }, E = ze(() => i.value.length >= f.value || s.value || f.value <= e.size), B = Ge(g, 300, {
      leading: !0
    });
    y(), g({
      isInitialLoad: !0
    });
    const M = (u) => {
      let p = i.value.findIndex((w) => w.id === c.value.id);
      switch (u) {
        case "up":
          p--, (p === -1 || p === -2) && (p = i.value.length - 1), c.value = i.value[p];
          break;
        case "down":
          p++, p === i.value.length && (p = 0), c.value = i.value[p];
          break;
        case "enter":
          F(c.value);
          break;
      }
    }, F = (u) => {
      var p;
      if (r.modal) {
        const w = {
          ok: !0,
          data: [u]
        };
        (p = r.modal) == null || p.dismiss(w);
      }
    }, L = (u, p) => {
      if (e.quoteCodelistMap.has(u)) {
        const w = e.quoteCodelistMap.get(u);
        return h(k("iBizCodeList"), {
          codeListItems: w.codeListItems,
          codeList: w.codeList,
          value: p
        }, null);
      }
      return p;
    }, C = (u) => h("div", {
      class: [t.e("item"), t.is("active", u.id === c.value.id)],
      onClick: () => F(u)
    }, [h("div", {
      class: t.e("type")
    }, [L("type", u.type)]), h("div", {
      class: t.e("identifier")
    }, [L("identifier", u.identifier)]), h("div", {
      class: t.e("name"),
      title: u.name
    }, [L("name", u.name)])]);
    return ce(() => {
      o = ge(window, "keyup", (u) => {
        u.keyCode === 40 ? M("down") : u.keyCode === 38 ? M("up") : u.keyCode === 13 && M("enter");
      });
    }), ve(() => {
      o !== O && o(), e.evt.off("onChange", d);
    }), {
      ns: t,
      items: i,
      loading: s,
      isLodeMoreDisabled: E,
      renderItem: C,
      loadMore: S
    };
  },
  render() {
    return qe(h("div", {
      "infinite-scroll-distance": 10,
      "infinite-scroll-disabled": this.isLodeMoreDisabled,
      "infinite-scroll-immediate": !1,
      class: this.ns.b()
    }, [this.items.map((r) => this.renderItem(r)), this.items.length === 0 && h(k("iBizNoData"), {
      text: "暂未用户数据"
    }, null)]), [[me("infinite-scroll"), () => this.loadMore()], [me("loading"), this.loading]]);
  }
});
class Jt {
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
    a(this, "model");
    /**
     * 上下文
     *
     * @type {IContext}
     */
    a(this, "context");
    /**
     * 视图参数
     *
     * @type {IParams}
     */
    a(this, "params");
    /**
     * 表单数据
     *
     * @type {IData}
     * @memberof MarkerController
     */
    a(this, "data", {});
    /**
     * 编辑器示例
     *
     * @type {IDomEditor}
     * @memberof MarkerController
     */
    a(this, "editor");
    /**
     * 引用请求url
     *
     * @type {string}
     * @memberof MarkerController
     */
    a(this, "quoteUrl", "");
    /**
     * 人员UI转化
     */
    a(this, "quoteFieldMap", {
      id: "id",
      name: "name"
    });
    /**
     * 代码表map
     *
     * @type {IData}
     * @memberof MarkerController
     */
    a(this, "quoteCodelistMap", /* @__PURE__ */ new Map());
    /**
     * 请求方法
     *
     * @type {('post' | 'get')}
     * @memberof MarkerController
     */
    a(this, "quoteMethod", "post");
    /**
     * 请求参数
     *
     * @type {IData}
     * @memberof MarkerController
     */
    a(this, "quoteParams", {});
    /**
     * 转换脚本
     *
     * @type {string}
     * @memberof MenTionController
     */
    a(this, "quoteScript", "`#{id=${data.id},name=${data.name},identifier=${data.identifier},icon=${data.icon}}`");
    /**
     * 逆转换脚本
     *
     * @type {string}
     * @memberof MenTionController
     */
    a(this, "quoteInScript", "value.replaceAll(/#{id=(.+?),name=(.+?),identifier=(.+?),icon=((.|[\\t\\r\\f\\n\\s])+?)}/g,(x, id, name, identifier, icon) => {return controller.getNodeInfo({ id, name, identifier, icon })})");
    /**
     * 编辑器参数
     *
     * @type {IData}
     * @memberof MarkerController
     */
    a(this, "editorParams");
    /**
     * 用户数据
     *
     * @type {IData[]}
     * @memberof MarkerController
     */
    a(this, "items", []);
    /**
     * 气泡容器
     *
     * @type {IOverlayPopoverContainer}
     * @memberof MarkerController
     */
    a(this, "overlay", null);
    /**
     * 编辑器事件
     *
     * @type {ControllerEvent<commentEvent>}
     * @memberof MarkerController
     */
    a(this, "evt");
    /**
     * 是否正在执行
     *
     * @private
     * @type {boolean}
     * @memberof MarkerController
     */
    a(this, "execting", !1);
    /**
     * 搜索字段
     *
     * @type {string}
     * @memberof MarkerController
     */
    a(this, "query", "");
    /**
     * 当前页
     *
     * @type {number}
     * @memberof MarkerController
     */
    a(this, "curPage", 0);
    /**
     * 分页条数
     *
     * @type {number}
     * @memberof MarkerController
     */
    a(this, "size", 20);
    /**
     * 预定义阻止捕获事件code
     *
     * @type {number[]}
     * @memberof MarkerController
     */
    a(this, "presetPreventEvents", [13, 38, 40]);
    /**
     * 预定义阻止冒泡事件code
     *
     * @type {number[]}
     * @memberof MarkerController
     */
    a(this, "presetPreventPropEvents", [27]);
    /**
     * 删除回调
     *
     * @type {NOOP}
     * @memberof MarkerController
     */
    a(this, "cleanup", O);
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
    const { insertText: e, isInline: s, isVoid: i } = t;
    return t.insertText = (o) => {
      if (!this.editor) {
        e(o);
        return;
      }
      if (!this.editor.isFocused()) {
        e(o);
        return;
      }
      if (Q.getSelectedElems(t).some((d) => t.isVoid(d))) {
        e(o);
        return;
      }
      o === "#" && !this.execting && (this.query = "", this.showModal()), e(o);
    }, t.isInline = (o) => Q.getNodeType(o) === "marker" ? !0 : s(o), t.isVoid = (o) => Q.getNodeType(o) === "marker" ? !0 : i(o), t;
  }
  registerNode() {
    window.markerIsRegiter || (V.registerModule(qt), window.markerIsRegiter = !0), V.registerPlugin(this.markerPlugin.bind(this));
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
        QUOTEURL: i,
        QUOTEFIELDMAP: o,
        QUOTEMETHOD: c,
        QUOTESCRIPT: f,
        QUOTEINSCRIPT: d,
        QUOTEPARAMS: y,
        QUOTECODELISTMAP: g
      } = this.editorParams;
      if (i && (this.quoteUrl = i), o && (this.quoteFieldMap = JSON.parse(o)), c && (this.quoteMethod = c.toLowerCase()), y && (this.quoteParams = JSON.parse(y)), f && (this.quoteScript = f), d && (this.quoteInScript = d), g) {
        const S = JSON.parse(g);
        this.setCodeListMap(S);
      }
    }
    const s = this.editor.getEditableContainer();
    s && (this.cleanup = ge(s, "keydown", (i) => {
      var o;
      this.execting && this.presetPreventEvents.includes(i.keyCode) && i.preventDefault(), this.execting && this.presetPreventPropEvents.includes(i.keyCode) && (i.stopPropagation(), (o = this.overlay) == null || o.dismiss());
    }));
  }
  onDestroyed() {
    this.cleanup !== O && this.cleanup(), this.overlay && this.overlay.dismiss();
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
      throw new j("未配置提及工作项QUOTEURL编辑器参数！");
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
      const s = t.find((i) => i.value == e);
      if (s)
        return s;
      for (let i = 0; i < t.length; i++) {
        const o = this.findCodeListItem(
          t[i].children,
          e
        );
        if (o)
          return o;
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
      const s = this.quoteCodelistMap.get("type"), i = this.findCodeListItem(s.codeListItems, t.type);
      i && i.sysImage && Object.assign(t, {
        icon: i.sysImage.rawContent
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
    return T.execScriptFn(
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
    const { navigateContexts: i, navigateParams: o } = this.model;
    let c = {};
    i && t && (c = fe(i, t, s, e));
    const f = Object.assign(e.clone(), c);
    let d = {};
    return o && t && (d = fe(o, t, s, e)), { context: f, params: d };
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
    ), i = t.isInitialLoad === !0, o = t.isLoadMore === !0;
    i ? this.curPage = 0 : o && (this.curPage += 1);
    const c = T.execScriptFn(
      { data: this.data, context: e, params: s },
      this.quoteUrl,
      {
        singleRowReturn: !0,
        isAsync: !1
      }
    ), f = {
      ...s,
      query: this.query,
      size: this.size,
      page: this.curPage,
      ...this.quoteParams
    };
    return ibiz.net[this.quoteMethod](c, f);
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
      return Object.keys(this.quoteFieldMap).forEach((i) => {
        s[i] = e[this.quoteFieldMap[i]];
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
    return (t) => Ve(jt, {
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
    const e = ibiz.hub.getApp(this.context.srfappid), s = e.codeList.getCodeList(t), i = await e.codeList.get(
      t,
      this.context,
      this.params
    );
    return { codeList: s, codeListItems: i };
  }
}
function Zt(r) {
  const { script: t = "", data: e = {} } = r, s = T.execScriptFn({ data: e }, t, {
    singleRowReturn: !0,
    isAsync: !1
  });
  return "".concat(s);
}
const _t = {
  type: "mention",
  elemToHtml: Zt
};
function Kt(r) {
  const t = decodeURIComponent(r.getAttribute("data-value") || ""), e = JSON.parse(t);
  return {
    type: "mention",
    script: e.script,
    data: e,
    children: [{ text: "" }]
  };
}
const Qt = {
  selector: 'span[data-w-e-type="mention"]',
  parseElemHtml: Kt
};
function Wt(r) {
  const { data: t = {} } = r, e = {
    name: "@".concat(t.name),
    id: t.id
  };
  return he(
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
const Yt = {
  type: "mention",
  renderElem: Wt
};
class Gt {
  constructor() {
    a(this, "title", "提及成员");
    a(this, "tag", "button");
    a(this, "iconSvg", '<svg t="1705979200437" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4218" xmlns:xlink="http://www.w3.org/1999/xlink" width="200" height="200"><path d="M23.7 555c0-339.3 247-550 533.8-550 295.6 0 442.8 165.9 442.8 401.6 0 210.8-93.5 361.7-237 361.7-63.6 0-108.5-26.2-137.2-78.6-48.6 51.1-96 79.8-174.6 79.8-116 0-178.4-77.3-178.4-193.3 0-209.5 131-323 251.9-323 64.9 0 102.3 24.9 122.2 68.6l11.2-58.6 114.7 1.2L727 510.1c-7.5 36.2-11.2 63.6-11.2 81.1 0 44.9 22.5 71.1 56.1 71.1 63.6 0 106-89.8 106-243.2 0-205.8-114.7-300.6-323-300.6-220.8 0-405.4 163.4-405.4 436.5 0 238.2 132.2 350.5 390.4 350.5 94.8 0 174.6-12.5 255.7-36.2v109.8c-88.6 26.2-177.1 39.9-263.2 39.9-329.1 0-508.7-168.4-508.7-464z m585-44.9c3.7-20 6.2-39.9 6.2-53.6 0-56.1-15-96-83.6-96-83.6 0-133.5 108.5-133.5 212 0 44.9 13.7 88.6 77.3 88.6 73.7-0.1 114.9-57.4 133.6-151z" fill="#333333" p-id="4219"></path></svg>');
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
const Xt = {
  key: "mention",
  factory() {
    return new Gt();
  }
}, es = {
  renderElems: [Yt],
  elemsToHtml: [_t],
  parseElemsHtml: [Qt],
  menus: [Xt]
};
class ts {
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
    a(this, "model");
    /**
     * 上下文
     *
     * @type {IContext}
     */
    a(this, "context");
    /**
     * 视图参数
     *
     * @type {IParams}
     */
    a(this, "params");
    /**
     * 表单数据
     *
     * @type {IData}
     * @memberof MenTionController
     */
    a(this, "data", {});
    /**
     * 编辑器示例
     *
     * @type {IDomEditor}
     * @memberof MenTionController
     */
    a(this, "editor");
    /**
     * 用户请求url
     *
     * @type {string}
     * @memberof MenTionController
     */
    a(this, "userUrl", "");
    /**
     * 人员UI转化
     */
    a(this, "userFieldMap", {
      id: "id",
      name: "name"
    });
    /**
     * 请求方法
     *
     * @type {('post' | 'get')}
     * @memberof MenTionController
     */
    a(this, "userMethod", "post");
    /**
     * 转换脚本
     *
     * @type {string}
     * @memberof MenTionController
     */
    a(this, "userScript", "`@{userid=${data.id},name=${data.name}}`");
    /**
     * 逆转换脚本
     *
     * @type {string}
     * @memberof MenTionController
     */
    a(this, "userInScript", "value.replaceAll(/@{userid=(.+?),name=(.+?)}/g,(x, id, name) => {return controller.getNodeInfo({ id, name })})");
    /**
     * 编辑器参数
     *
     * @type {IData}
     * @memberof MenTionController
     */
    a(this, "editorParams");
    /**
     * 用户数据
     *
     * @type {IData[]}
     * @memberof MenTionController
     */
    a(this, "items", []);
    /**
     * 气泡容器
     *
     * @type {IOverlayPopoverContainer}
     * @memberof MenTionController
     */
    a(this, "overlay", null);
    /**
     * 编辑器事件
     *
     * @type {ControllerEvent<commentEvent>}
     * @memberof MenTionController
     */
    a(this, "evt");
    /**
     * 是否正在执行
     *
     * @private
     * @type {boolean}
     * @memberof MenTionController
     */
    a(this, "execting", !1);
    /**
     * 搜索字段
     *
     * @type {string}
     * @memberof MenTionController
     */
    a(this, "query", "");
    /**
     * 当前页
     *
     * @type {number}
     * @memberof MenTionController
     */
    a(this, "curPage", 0);
    /**
     * 分页条数
     *
     * @type {number}
     * @memberof MenTionController
     */
    a(this, "size", 20);
    /**
     * 预定义阻止捕获事件code
     *
     * @type {number[]}
     * @memberof MenTionController
     */
    a(this, "presetPreventEvents", [13, 38, 40]);
    /**
     * 预定义阻止冒泡事件code
     *
     * @type {number[]}
     * @memberof MenTionController
     */
    a(this, "presetPreventPropEvents", [27]);
    /**
     * 删除回调
     *
     * @type {NOOP}
     * @memberof MenTionController
     */
    a(this, "cleanup", O);
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
    const { insertText: e, isInline: s, isVoid: i } = t;
    return t.insertText = (o) => {
      if (!this.editor) {
        e(o);
        return;
      }
      if (!this.editor.isFocused()) {
        e(o);
        return;
      }
      if (Q.getSelectedElems(t).some((d) => t.isVoid(d))) {
        e(o);
        return;
      }
      o === "@" && !this.execting && (this.query = "", this.showModal()), e(o);
    }, t.isInline = (o) => Q.getNodeType(o) === "mention" ? !0 : s(o), t.isVoid = (o) => Q.getNodeType(o) === "mention" ? !0 : i(o), t;
  }
  registerNode() {
    window.mentionIsRegiter || (V.registerModule(es), window.mentionIsRegiter = !0), V.registerPlugin(this.mentionPlugin.bind(this));
  }
  /**
   * 初始化
   *
   * @param {IDomEditor} editor
   * @memberof MenTionController
   */
  async init(t, e) {
    if (this.model = e.model, this.context = e.context, this.params = e.params, this.evt = e.evt, this.data = e.data, this.editor = t, this.editorParams = this.model.editorParams, this.editorParams) {
      const { USERURL: i, USERFIELDMAP: o, USERMETHOD: c, USERSCRIPT: f, USERINSCRIPT: d } = this.editorParams;
      i && (this.userUrl = i), o && (this.userFieldMap = JSON.parse(o)), c && (this.userMethod = c.toLowerCase()), f && (this.userScript = f), d && (this.userInScript = d);
    }
    const s = this.editor.getEditableContainer();
    s && (this.cleanup = ge(s, "keydown", (i) => {
      var o;
      this.execting && this.presetPreventEvents.includes(i.keyCode) && i.preventDefault(), this.execting && this.presetPreventPropEvents.includes(i.keyCode) && (i.stopPropagation(), (o = this.overlay) == null || o.dismiss());
    }));
  }
  onDestroyed() {
    this.cleanup !== O && this.cleanup(), this.overlay && this.overlay.dismiss();
  }
  // 显示弹框
  showModal() {
    if (!this.userUrl)
      throw new j("未配置提及用户USERURL编辑器参数！");
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
    return T.execScriptFn(
      { value: t, controller: this },
      this.userInScript,
      {
        singleRowReturn: !0,
        isAsync: !1
      }
    );
  }
  // 获取主题色
  getThemeVar() {
    const t = document.documentElement;
    return t ? getComputedStyle(t).getPropertyValue("--ibiz-color-primary") : null;
  }
  // 是否包含中文字符
  isChineseCharacter(t) {
    return /[\u4e00-\u9fa5]/.test(t);
  }
  // 判断字符串是否同时存在英文和中文
  hasChineseAndEnglish(t) {
    return /[\u4e00-\u9fa5]+.*[a-zA-Z]+|[a-zA-Z]+.*[\u4e00-\u9fa5]+/.test(t);
  }
  // 字符串转16进制颜色
  stringToHexColor(t) {
    if (!t)
      return "";
    let e = 0;
    for (let d = 0; d < t.length; d++)
      if (this.isChineseCharacter(t))
        e = t.charCodeAt(d) + ((e << 5) - e), e = e & e;
      else {
        const y = t.charCodeAt(d);
        e += y.toString(16);
      }
    const s = String(e).substring(0, 6), i = parseInt(s.substring(0, 2), 16), o = parseInt(s.substring(2, 4), 16), c = parseInt(s.substring(4, 6), 16), f = "#".concat(i.toString(16).padStart(2, "0")).concat(o.toString(16).padStart(2, "0")).concat(c.toString(16).padStart(2, "0"));
    return f === "#FFFFFF" && this.getThemeVar() || f;
  }
  // 缩写名字
  avatarName(t) {
    if (t && t.toString().length < 2)
      return t;
    if (t && t.toString().length >= 2) {
      if (this.hasChineseAndEnglish(t)) {
        const o = t.split("").find((f) => /[a-zA-Z]/.test(f)) || "", c = t.split("").find((f) => /[\u4E00-\u9FA5]/.test(f)) || "";
        return "".concat(o).concat(c).toLowerCase();
      }
      return /[a-zA-Z]/.test(t) ? t.split("").filter((o) => /[a-zA-Z]/.test(o)).slice(0, 2).join("").toUpperCase() : /[\u4E00-\u9FA5]/.test(t) ? t.split("").filter((o) => /[\u4E00-\u9FA5]/.test(o)).slice(-2).join("") : t.replaceAll(" ", "").substring(0, 2);
    }
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
    const { navigateContexts: i, navigateParams: o } = this.model;
    let c = {};
    i && t && (c = fe(i, t, s, e));
    const f = Object.assign(e.clone(), c);
    let d = {};
    return o && t && (d = fe(o, t, s, e)), { context: f, params: d };
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
    ), i = t.isInitialLoad === !0, o = t.isLoadMore === !0;
    i ? this.curPage = 0 : o && (this.curPage += 1);
    const c = T.execScriptFn(
      { data: this.data, context: e, params: s },
      this.userUrl,
      {
        singleRowReturn: !0,
        isAsync: !1
      }
    ), f = {
      ...s,
      query: this.query,
      size: this.size,
      page: this.curPage
    };
    return ibiz.net[this.userMethod](c, f);
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
      return Object.keys(this.userFieldMap).forEach((i) => {
        s[i] = e[this.userFieldMap[i]];
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
    return (t) => Ve(Vt, {
      controller: this,
      modal: t
    });
  }
}
function ss(r) {
  const { script: t = "", data: e = {} } = r, s = T.execScriptFn({ data: e }, t, {
    singleRowReturn: !0,
    isAsync: !1
  });
  return "".concat(s);
}
const ns = {
  type: "page",
  elemToHtml: ss
};
function rs(r) {
  const t = decodeURIComponent(r.getAttribute("data-value") || ""), e = JSON.parse(t);
  return {
    type: "page",
    script: e.script,
    data: e,
    children: [{ text: "" }]
  };
}
const is = {
  selector: 'span[data-w-e-type="page"]',
  parseElemHtml: rs
};
function as(r) {
  const { data: t = {} } = r, e = {
    name: "".concat(t.name),
    id: t.id
  };
  return he(
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
const os = {
  type: "Page",
  renderElem: as
};
class ls {
  constructor() {
    a(this, "title", "页面");
    a(this, "tag", "button");
    a(this, "iconSvg", '<svg t="1707293566679" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="6103" width="200" height="200"><path d="M288 512l256 0C561.92 512 576 497.92 576 480 576 462.08 561.92 448 544 448l-256 0C270.08 448 256 462.08 256 480 256 497.92 270.08 512 288 512zM768 64 192 64C121.6 64 64 121.6 64 192l0 576c0 70.4 57.6 128 128 128l576 0c70.4 0 128-57.6 128-128L896 192C896 121.6 838.4 64 768 64zM832 768c0 35.2-28.8 64-64 64L192 832c-35.2 0-64-28.8-64-64L128 192c0-35.2 28.8-64 64-64l576 0c35.2 0 64 28.8 64 64L832 768zM672 256l-384 0C270.08 256 256 270.08 256 288 256 305.92 270.08 320 288 320l384 0C689.92 320 704 305.92 704 288 704 270.08 689.92 256 672 256zM608 640l-320 0C270.08 640 256 654.08 256 672l0 0C256 689.92 270.08 704 288 704l320 0c17.92 0 32-14.08 32-32l0 0C640 654.08 625.92 640 608 640z" p-id="6104"></path></svg>');
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
    throw new j("暂未支持上传页面！");
  }
}
const cs = {
  key: "page",
  factory() {
    return new ls();
  }
}, us = {
  renderElems: [os],
  elemsToHtml: [ns],
  parseElemsHtml: [is],
  menus: [cs]
};
class ds {
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
    a(this, "model");
    /**
     * 上下文
     *
     * @type {IContext}
     */
    a(this, "context");
    /**
     * 视图参数
     *
     * @type {IParams}
     */
    a(this, "params");
    /**
     * 表单数据
     *
     * @type {IData}
     * @memberof PageController
     */
    a(this, "data", {});
    /**
     * 编辑器示例
     *
     * @type {IDomEditor}
     * @memberof PageController
     */
    a(this, "editor");
    /**
     * 编辑器参数
     *
     * @type {IData}
     * @memberof PageController
     */
    a(this, "editorParams");
    /**
     * 用户数据
     *
     * @type {IData[]}
     * @memberof PageController
     */
    a(this, "items", []);
    /**
     * 编辑器事件
     *
     * @type {ControllerEvent<commentEvent>}
     * @memberof PageController
     */
    a(this, "evt");
    /**
     * 是否正在执行
     *
     * @private
     * @type {boolean}
     * @memberof PageController
     */
    a(this, "execting", !1);
    this.registerNode();
  }
  registerNode() {
    window.pageIsRegiter || (V.registerModule(us), window.pageIsRegiter = !0);
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
class U {
  /**
   * 初始化
   *
   * @static
   * @memberof CustomNodeFactory
   */
  static init(t) {
    this.registerMap.set("mention", ts), this.registerMap.set("marker", Jt), this.registerMap.set("attachments", St), this.registerMap.set("codesnippet", It), this.registerMap.set("page", ds), this.presetNodes.forEach((e) => {
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
    const i = this.registerMap.get(e);
    if (i) {
      const o = new i();
      return this.customNodeMap.set(s, o), o;
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
a(U, "customNodeMap", /* @__PURE__ */ new Map()), /**
 * 预置注册表
 *
 * @type {Map<string, any>}
 * @memberof CustomNodeFactory
 */
a(U, "registerMap", /* @__PURE__ */ new Map()), /**
 * 预置注册节点
 *
 * @static
 * @memberof CustomNodeFactory
 */
a(U, "presetNodes", [
  "mention",
  "marker",
  "attachments",
  "codesnippet",
  "page"
]);
class hs extends HTMLElement {
  // 监听的 attr
  static get observedAttributes() {
    return ["data-value"];
  }
  attributeChangedCallback(t, e, s) {
    if (t === "data-value") {
      if (s && e === s)
        return;
      const i = JSON.parse(s), o = this.attachShadow({ mode: "open" }), c = o.ownerDocument;
      if (i.icon) {
        const d = c.createElement("span");
        d.part.add("svg"), d.innerHTML = i.icon, o.appendChild(d);
      }
      if (i.identifier) {
        const d = c.createElement("span");
        d.part.add("identifier"), d.innerHTML = i.identifier, o.appendChild(d);
      }
      if (i.name) {
        const d = c.createElement("span");
        d.part.add("name"), d.innerHTML = i.name, o.appendChild(d);
      }
      const f = c.createElement("style");
      f.innerHTML = "\n      svg {\n        height: 1em;\n        width: 1em;\n      }\n    ", o.appendChild(f);
    }
  }
}
class ms extends it {
  constructor() {
    super(...arguments);
    /**
     * 上传参数
     */
    a(this, "uploadParams");
    /**
     * 下载参数
     */
    a(this, "exportParams");
    /**
     * 最小高度
     *
     * @type {number}
     * @memberof HtmlCommentController
     */
    a(this, "minHeight", 48);
    /**
     * 最大高度
     *
     * @type {number}
     * @memberof HtmlCommentController
     */
    a(this, "maxHeight", 315);
    /**
     * 是否折叠
     *
     * @type {Ref<boolean>}
     * @memberof HtmlCommentController
     */
    a(this, "collapsed", v(!0));
    /**
     * 是否隐藏
     *
     * @type {Ref<boolean>}
     * @memberof HtmlCommentController
     */
    a(this, "hidden", v(!1));
    /**
     * 回复
     *
     * @type {string}
     * @memberof HtmlCommentController
     */
    a(this, "reply", v(""));
    /**
     * 回复脚本
     *
     * @type {string}
     * @memberof HtmlCommentController
     */
    a(this, "replyScript", "");
    /**
     * 编辑器模式
     *
     * @type {('comment' | 'default')}
     * @memberof HtmlCommentController
     */
    a(this, "mode", "comment");
    /**
     * 唯一标识
     *
     * @type {string}
     * @memberof HtmlCommentController
     */
    a(this, "uuid", ct());
    a(this, "evt", new at(
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
        MINHEIGHT: i,
        MAXHEIGHT: o,
        REPLYSCRIPT: c,
        MODE: f
      } = this.editorParams;
      if (e)
        try {
          this.uploadParams = JSON.parse(e);
        } catch (d) {
          ibiz.log.error(
            "编辑器[".concat(ibiz.log.error(
              d
            ), "]编辑器参数 uploadParams 非 json 格式")
          );
        }
      if (s)
        try {
          this.exportParams = JSON.parse(s);
        } catch (d) {
          ibiz.log.error(
            "编辑器[".concat(ibiz.log.error(
              d
            ), "]编辑器参数 exportParams 非 json 格式")
          );
        }
      i && (this.minHeight = Number(i)), o && (this.maxHeight = Number(o)), c && (this.replyScript = c), f && (this.mode = f.toLowerCase());
    }
    U.init(this.uuid);
  }
  /**
   * 注册自定义元素
   *
   * @private
   * @memberof HtmlCommentController
   */
  registerCustomElem() {
    window.customElements.get("mention-elem") || window.customElements.define("mention-elem", hs);
  }
  /**
   * 初始化
   *
   * @param {IDomEditor} editor
   * @memberof HtmlCommentController
   */
  onCreated(e, s, i) {
    U.getPluginsById(this.uuid).forEach((c) => {
      c.init(e, {
        model: this.model,
        data: s,
        toolbarConfig: i,
        context: this.context,
        params: this.params,
        evt: this.evt
      });
    });
  }
  /**
   * 组件销毁
   *
   * @memberof HtmlCollapseController
   */
  onDestroyed() {
    U.getPluginsById(this.uuid).forEach((s) => {
      s.onDestroyed();
    }), U.destroy(this.uuid);
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
    return U.getPluginsById(this.uuid).forEach((o) => {
      s = o.parseNode(s);
    }), s;
  }
  /**
   * 设置html
   *
   * @param {string} value
   * @memberof HtmlCommentController
   */
  async setValue(e) {
    this.collapsed.value = !1, this.hidden.value = !0, await N(), this.hidden.value = !1, await N();
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
        throw new j("下载文件失败");
      if (s.data) {
        const i = e.name;
        dt(s.data, i);
      } else
        throw new j("文件流数据不存在");
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
  // 获取主题色
  getThemeVar() {
    const e = document.documentElement;
    return e ? getComputedStyle(e).getPropertyValue("--ibiz-color-primary") : null;
  }
  // 是否包含中文字符
  isChineseCharacter(e) {
    return /[\u4e00-\u9fa5]/.test(e);
  }
  // 判断字符串是否同时存在英文和中文
  hasChineseAndEnglish(e) {
    return /[\u4e00-\u9fa5]+.*[a-zA-Z]+|[a-zA-Z]+.*[\u4e00-\u9fa5]+/.test(e);
  }
  // 字符串转16进制颜色
  stringToHexColor(e) {
    if (!e)
      return "";
    let s = 0;
    for (let y = 0; y < e.length; y++)
      if (this.isChineseCharacter(e))
        s = e.charCodeAt(y) + ((s << 5) - s), s = s & s;
      else {
        const g = e.charCodeAt(y);
        s += g.toString(16);
      }
    const i = String(s).substring(0, 6), o = parseInt(i.substring(0, 2), 16), c = parseInt(i.substring(2, 4), 16), f = parseInt(i.substring(4, 6), 16), d = "#".concat(o.toString(16).padStart(2, "0")).concat(c.toString(16).padStart(2, "0")).concat(f.toString(16).padStart(2, "0"));
    return d === "#FFFFFF" && this.getThemeVar() || d;
  }
  // 缩写名字
  avatarName(e) {
    if (e && e.toString().length < 2)
      return e;
    if (e && e.toString().length >= 2) {
      if (this.hasChineseAndEnglish(e)) {
        const c = e.split("").find((d) => /[a-zA-Z]/.test(d)) || "", f = e.split("").find((d) => /[\u4E00-\u9FA5]/.test(d)) || "";
        return "".concat(c).concat(f).toLowerCase();
      }
      return /[a-zA-Z]/.test(e) ? e.split("").filter((c) => /[a-zA-Z]/.test(c)).slice(0, 2).join("").toUpperCase() : /[\u4E00-\u9FA5]/.test(e) ? e.split("").filter((c) => /[\u4E00-\u9FA5]/.test(c)).slice(-2).join("") : e.replaceAll(" ", "").substring(0, 2);
    }
  }
}
class fs {
  constructor() {
    a(this, "formEditor", "HtmlComment");
    a(this, "gridEditor", "HtmlComment");
  }
  async createController(t, e) {
    const s = new ms(t, e);
    return await s.init(), s;
  }
}
const vs = lt(De, function(r) {
  r.component(De.name, De), ot(
    "EDITOR_CUSTOMSTYLE_COMMENT",
    () => new fs()
  );
}), Ls = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(r) {
    r.use(vs), r.component(
      "IBizHtmlContent",
      rt(() => Promise.resolve().then(() => ht))
    );
  }
};
export {
  vs as IBizHtmlComment,
  Ls as default
};
