import './style.css';
var te = Object.defineProperty;
var ne = (e, n, o) => n in e ? te(e, n, { enumerable: !0, configurable: !0, writable: !0, value: o }) : e[n] = o;
var q = (e, n, o) => (ne(e, typeof n != "symbol" ? n + "" : n, o), o);
import { TreeController as oe, getChildNodeRSs as ie, calcDeCodeNameById as se, handleAllSettled as ae, Srfuf as de, getControlPanel as le, registerControlProvider as re } from "@ibiz-template/runtime";
import { useControlController as ce, useNamespace as ue, withInstall as he } from "@ibiz-template/vue3-util";
import { defineComponent as fe, reactive as pe, ref as L, watch as $, computed as Ne, nextTick as _e, resolveComponent as m, onMounted as De, onUnmounted as ye, withDirectives as xe, createVNode as p, resolveDirective as me, isVNode as we, createTextVNode as ge } from "vue";
import { createUUID as H } from "qx-util";
import { debounce as W } from "lodash-es";
import { RuntimeError as j, RuntimeModelError as Q } from "@ibiz-template/core";
import { isNil as J } from "ramda";
function I(e, n) {
  const o = n.state.items.find((i) => i._id === e);
  return o || n.state.items.find((i) => i._uuid === e);
}
function Ie(e, n) {
  const o = () => {
    const u = e.value;
    if (!u)
      throw new j("找不到el-tree实例对象");
    return u;
  }, i = () => {
    var l;
    const u = e.value;
    if (!u) {
      setTimeout(() => {
        i();
      }, 200);
      return;
    }
    Object.values(u.store.nodesMap).forEach((h) => {
      const g = n.state.expandedKeys.includes(h.data._id);
      g !== h.expanded && (g ? h.expand() : h.collapse());
    }), n.state.singleSelect ? e.value.setCurrentKey(((l = n.state.selectedData[0]) == null ? void 0 : l._id) || void 0) : u.setCheckedKeys(n.state.selectedData.map((h) => h._id));
  }, d = W(i, 500);
  return { getTreeInstance: o, updateUI: d, triggerNodeExpand: (u) => {
    const l = o(), h = l == null ? void 0 : l.store.nodesMap[u];
    if (h)
      return h.expanded ? (h.collapse(), !1) : (h.expand(), !0);
  } };
}
function Ee(e) {
  switch (e) {
    case "inner":
      return "inner";
    case "before":
      return "prev";
    case "after":
      return "next";
    default:
      throw new j("暂不支持dropType:".concat(e));
  }
}
class Ce extends oe {
  initState() {
    super.initState(), this.state.newingNodeModel = null, this.state.newingNodeText = null, this.state.newingNodeDefault = null, this.state.editingNodeKey = null, this.state.editingNodeText = null, this.state.editingNodeDefault = null;
  }
  /**
   * 临时取消监听
   *
   * @protected
   * @param {IData} msg
   * @memberof GroupTreeController
   */
  onDataChange(n) {
  }
  /**
   *  初始化节点拖入关系处理
   */
  initDropNodeRss() {
    var n;
    (n = this.model.detreeNodes) == null || n.forEach((o) => {
      if (!o.allowDrop)
        return;
      const i = [];
      ie(this.model, {
        parentId: o.id,
        hasQuery: !1
      }).forEach((a) => {
        var u;
        if ((u = a.parentDER1N) != null && u.pickupDEFName) {
          const l = this.getNodeModel(a.childDETreeNodeId);
          (l == null ? void 0 : l.treeNodeType) === "DE" && l.appDataEntityId && i.push({
            minorEntityId: l.appDataEntityId,
            pickupDEFName: a.parentDER1N.pickupDEFName.toLowerCase(),
            childDETreeNodeId: a.childDETreeNodeId,
            detreeNodeRSParams: a.detreeNodeRSParams
          });
        }
      }), i.length > 0 && this.dropNodeRss.set(o.id, i);
    });
  }
  /**
   * 编辑指定节点的文本
   * @author ljx
   * @date 2023-12-27 05:46:02
   * @return {*}  {void}
   */
  updateTreeNode({
    nodeKey: n,
    defaultValue: o
  }) {
    if (!n || n === this.state.editingNodeKey)
      return;
    const i = I(n, this), d = this.getNodeModel(i._nodeId);
    d != null && d.allowEditText && (this.state.editingNodeKey = i._id, this.state.editingNodeText = i._text, this.state.editingNodeDefault = o, this.state.newingNodeModel = null, this.state.newingNodeText = null, this.state.newingNodeDefault = null);
  }
  /**
   * 删除指定节点
   * @author ljx
   * @date 2023-12-27 05:46:02
   * @return {*}  {void}
   */
  removeTreeNode(n) {
    if (!n || n === this.state.editingNodeKey)
      return;
    const o = I(n, this), i = {
      context: this.context || {},
      params: this.params || {},
      data: [o]
    };
    this.onRemoveTreeNode(i);
  }
  /**
   * 新建树节点
   * @author ljx
   * @date 2023-12-27 05:46:02
   * @return {*}  {void}
   */
  newTreeNode({
    nodeType: n,
    defaultValue: o = {}
  }) {
    const i = this.getNodeModel(n);
    this.state.newingNodeModel = i, this.state.newingNodeDefault = o, this.state.editingNodeKey = null, this.state.editingNodeText = null, this.state.editingNodeDefault = null;
  }
  /**
   * 创建实体节点数据
   * @author ljx
   * @date 2023-12-27 04:19:36
   * @protected
   * @param {ITreeNodeData[]} nodeDatas 节点数据集合
   * @return {*}  {Promise<void>}
   */
  async createDeNodeData(n) {
    const o = ibiz.hub.getApp(this.context.srfappid);
    await Promise.all(
      n.map(async (i) => {
        const d = this.getNodeModel(i._nodeId), a = i._deData, u = this.context.clone();
        (await o.deService.exec(
          d.appDataEntityId,
          "create",
          u,
          a
        )).data && this.refresh();
      })
    );
  }
  /**
   * 创建树节点
   * @author ljx
   * @date 2023-12-27 04:32:52
   * @return {*}  {Promise<void>}
   */
  async onCreateTreeNode() {
    const { textAppDEFieldId: n, id: o } = this.state.newingNodeModel, i = this.state.newingNodeText, d = { _deData: {} };
    Object.assign(d, { _nodeId: o, _text: i }), Object.assign(d._deData, { [n]: i }), this.state.newingNodeDefault && Object.assign(d._deData, this.state.newingNodeDefault), Object.assign(d._deData, { [n]: i }), await this.createDeNodeData([d]), this.state.newingNodeModel = null, this.state.newingNodeText = null, this.state.newingNodeDefault = null;
  }
  /**
   * 修改节点文本
   * @param nodeData 节点数据
   * @param _text 节点文本
   */
  async onModifyTreeNode(n, o) {
    const i = this.getNodeModel(n._nodeId);
    if (!i.allowEditText)
      throw new Q(i, "树节点没有配置编辑模式：名称");
    if (n._nodeType !== "DE")
      throw new j("不是实体树节点数据");
    if (n._text = o, this.state.editingNodeDefault) {
      const d = Object.keys(this.state.editingNodeDefault);
      d && d.length > 0 && d.forEach((a) => {
        J(n._deData[a]) && (n._deData[a] = this.state.editingNodeDefault[a]);
      });
    }
    await this.updateDeNodeData([n]), this.state.editingNodeKey = null, this.state.editingNodeText = null, this.state.editingNodeDefault = null;
  }
  /**
   * 删除树节点
   * @param args 参数
   * @returns
   */
  async onRemoveTreeNode(n) {
    const { context: o, params: i, data: d } = this.handlerAbilityParams(n), a = this.getNodeModel(d[0]._nodeId);
    if ((n == null ? void 0 : n.silent) !== !0 && !await ibiz.confirm.error({
      title: "数据删除",
      desc: "确认删除数据？"
    }))
      return;
    await this._evt.emit("onBeforeRemove", void 0), await this.startLoading();
    let u = !1;
    try {
      const l = se(
        a.appDataEntityId
      );
      await ae(
        d.map(async (h) => {
          if (h.srfuf !== de.CREATE) {
            const g = o.clone();
            g[l] = h.srfkey, await await ibiz.hub.getApp(a.appId).deService.exec(
              a.appDataEntityId,
              "remove",
              g,
              d,
              i
            ), u = !0;
          }
          this.afterRemove(h);
        })
      ), (n == null ? void 0 : n.silent) !== !0 && this.actionNotification("REMOVESUCCESS", {
        data: d,
        default: "数据[".concat(d.map((h) => h.srfmajortext).join("、"), "]删除成功!")
      }), u && !(n != null && n.notRefresh) && await this.refresh();
    } catch (l) {
      throw await this._evt.emit("onRemoveError", void 0), this.actionNotification("REMOVEERROR", {
        error: l,
        data: d
      }), l;
    } finally {
      await this.endLoading();
    }
    this.state.selectedData = [], await this._evt.emit("onRemoveSuccess", void 0);
  }
  /**
   * 计算是否允许拖入
   * @param draggingNode
   * @param dropNode
   * @param type
   * @returns
   */
  calcAllowDrop(n, o, i) {
    var a, u;
    const d = this.getNodeModel(n._nodeId);
    if (i === "inner")
      return !!this.findDropNodeRS(
        o._nodeId,
        d.appDataEntityId
      );
    if (((a = n._parent) == null ? void 0 : a._id) === ((u = o._parent) == null ? void 0 : u._id)) {
      const l = this.getNodeModel(o._nodeId);
      return (l == null ? void 0 : l.allowOrder) === !0;
    }
    return o._parent ? o._parent && o._parent._id && this.getNodeModel(o._parent._nodeId).rootNode ? !0 : !!this.findDropNodeRS(
      o._parent._nodeId,
      d.appDataEntityId
    ) : !1;
  }
  /**
   * 处理节点拖入事件
   * @param draggingNode
   * @param dropNode
   * @param dropType
   */
  async onNodeDrop(n, o, i) {
    var k, A, O;
    i === "inner" && !o._leaf && o._children === void 0 && await this.expandNodeByKey([o._id]);
    const d = i !== "inner", a = [], u = this.getNodeModel(n._nodeId), l = i === "inner" ? o : o._parent;
    let h = !1;
    this.getNodeModel(l._nodeId).rootNode && (h = !0);
    const C = (l == null ? void 0 : l._id) !== ((k = n._parent) == null ? void 0 : k._id);
    let _ = this.getNodeModel(o._nodeId);
    if (i === "inner" || ((A = o._parent) == null ? void 0 : A._id) !== ((O = n._parent) == null ? void 0 : O._id) || h) {
      const N = [];
      for (const w of this.dropNodeRss.values())
        N.push(
          ...w.filter((D) => (
            // 修复子关系情况，根上也存在当前实体数据
            D.minorEntityId === u.appDataEntityId
          ))
        );
      if (h && C)
        N && (N.forEach((w) => {
          n._deData[w.pickupDEFName] = null;
        }), a.push(n), _ = this.getNodeModel(u.id));
      else {
        const w = this.findDropNodeRS(
          l._nodeId,
          u.appDataEntityId
        );
        w && (N && N.forEach((D) => {
          n._deData[D.pickupDEFName] = null;
        }), n._deData[w.pickupDEFName] = l._value, w.detreeNodeRSParams && w.detreeNodeRSParams.forEach((D) => {
          var v, b;
          D.name && D.value && ((v = n._deData) != null && v.hasOwnProperty(
            D.name.toLowerCase()
          )) && ((b = l._deData) != null && b.hasOwnProperty(D.value.toLowerCase())) && (n._deData[D.name.toLowerCase()] = l._deData[D.value.toLowerCase()]);
        }), a.push(n), _ = this.getNodeModel(w.childDETreeNodeId));
      }
    }
    const R = n._parent._children;
    if (R.splice(R.indexOf(n), 1), i === "inner")
      o._children || (o._children = [], o._leaf = !0, this.state.expandedKeys.push(o._id)), o._children.push(n);
    else {
      let N = l._children.indexOf(o);
      i === "next" && (N += 1), l._children.splice(N, 0, n);
    }
    (i === "inner" || C) && (n._parent = l, n._nodeId = _.id, this.state.expandedKeys = this.calcExpandedKeys([l]));
    const { sortAppDEFieldId: B, sortDir: K, allowOrder: U } = _;
    if (U === !0) {
      if (!B)
        throw new Q(_, "缺少配置排序属性");
      const N = B.toLowerCase(), w = K === "ASC", D = [...l._children].filter(
        (x) => x._nodeType === "DE"
      );
      w || D.reverse();
      const v = (x) => x + (100 - x % 100), b = (x) => x[N] || 0;
      let E;
      D.forEach((x, P) => {
        const S = x._deData;
        E === void 0 ? x === n && (P === 0 ? E = 100 : E = v(b(D[P - 1]._deData)), S[N] = E, a.indexOf(x) === -1 && a.push(x)) : (E >= b(S) && (S[N] = v(E), a.push(x)), E = b(S));
      });
    }
    await this.updateDeNodeData(a), this._evt.emit("onAfterNodeDrop", { isChangedParent: C }), this.refreshNodeChildren(o, d), this.setSelection([]);
  }
}
function ve(e) {
  return typeof e == "function" || Object.prototype.toString.call(e) === "[object Object]" && !we(e);
}
const V = /* @__PURE__ */ fe({
  name: "IBizGroupTreeControl",
  props: {
    modelData: {
      type: Object,
      required: !0
    },
    context: {
      type: Object,
      required: !0
    },
    params: {
      type: Object,
      default: () => ({})
    },
    provider: {
      type: Object
    },
    /**
     * 部件行数据默认激活模式
     * - 0 不激活
     * - 1 单击激活
     * - 2 双击激活(默认值)
     *
     * @type {(number | 0 | 1 | 2)}
     */
    mdctrlActiveMode: {
      type: Number,
      default: void 0
    },
    /**
     * 是否为单选
     * - true 单选
     * - false 多选
     *
     * @type {(Boolean)}
     */
    singleSelect: {
      type: Boolean,
      default: void 0
    },
    navigational: {
      type: Boolean,
      default: void 0
    },
    defaultExpandedKeys: {
      type: Array
    },
    loadDefault: {
      type: Boolean,
      default: !0
    }
  },
  setup() {
    const e = ce((...t) => new Ce(...t)), n = pe({});
    e.evt.on("onCreated", () => {
      e.counter && e.counter.onChange((t) => {
        Object.assign(n, t);
      }, !0);
    });
    const o = ue("control-group-tree"), i = L(null), d = L(null), a = L(""), u = L(null);
    $(() => u.value, (t) => {
      t && t.$el.getElementsByTagName("input")[0].focus();
    });
    const l = async () => {
      if (e.state.editingNodeKey)
        if (e.state.editingNodeText) {
          const t = I(e.state.editingNodeKey, e);
          await e.onModifyTreeNode(t, e.state.editingNodeText);
        } else
          e.state.editingNodeKey = null;
      e.state.newingNodeText ? e.onCreateTreeNode() : e.state.newingNodeModel = null;
    }, h = async () => {
      e.state.editingNodeKey && (e.state.editingNodeKey = null), e.state.newingNodeModel && (e.state.newingNodeModel = null, e.state.newingNodeText = "");
    }, {
      updateUI: g,
      triggerNodeExpand: C
    } = Ie(i, e), _ = (t) => t.map((s) => ({
      _id: s._id,
      _uuid: s._uuid,
      _leaf: s._leaf,
      _text: s._text
    }));
    e.evt.on("onAfterRefreshParent", (t) => {
      if (i.value) {
        const {
          parentNode: s,
          children: r
        } = t, f = _(r);
        i.value.updateKeyChildren(s._id, f), g();
      }
    }), e.evt.on("onAfterNodeDrop", (t) => {
      t.isChangedParent && (a.value = H());
    });
    const R = Ne(() => e.state.isLoaded ? e.model.rootVisible ? e.state.rootNodes : e.state.rootNodes.reduce((t, s) => s._children ? t.concat(s._children) : t, []) : []);
    $(R, (t, s) => {
      t !== s && (a.value = H());
    });
    const B = async (t, s) => {
      let r;
      if (t.level === 0)
        r = R.value, ibiz.log.debug("初始加载");
      else {
        const f = I(t.data._uuid, e);
        f._children ? (ibiz.log.debug("节点展开加载-本地", f), r = f._children) : (ibiz.log.debug("节点展开加载-远程", f), r = await e.loadNodes(f));
      }
      ibiz.log.debug("给树返回值", r), s(_(r)), g();
    };
    let K = !1;
    e.evt.on("onLoadSuccess", () => {
      K = !0, setTimeout(() => {
        K = !1;
      }, 200);
    }), e.evt.on("onSelectionChange", async () => {
      var t;
      K && await _e(), e.state.singleSelect ? i.value.setCurrentKey(((t = e.state.selectedData[0]) == null ? void 0 : t._id) || void 0) : i.value.setCheckedKeys(e.state.selectedData.map((s) => s._id));
    });
    const U = (t, s) => {
      const {
        checkedNodes: r
      } = s;
      e.setSelection(r);
    };
    let k = !1;
    const A = (t, s) => {
      var r, f, y;
      if (s.stopPropagation(), !k) {
        if (((r = i.value) == null ? void 0 : r.getCurrentKey()) === t._id) {
          const c = (f = i.value) == null ? void 0 : f.getCurrentKey();
          e.updateTreeNode({
            nodeKey: c,
            defaultValue: {}
          });
        }
        if (e.state.singleSelect || (y = i.value) == null || y.setCurrentKey(t._id), e.state.navigational) {
          const c = e.getNodeModel(t._nodeId);
          if (!(c != null && c.navAppViewId)) {
            const M = C(t._id);
            e.onExpandChange(t, M);
          }
        }
        e.onTreeNodeClick(t, s), k = !0, setTimeout(() => {
          k = !1;
        }, 200);
      }
    }, O = (t, s) => {
      s.stopPropagation(), e.onDbTreeNodeClick(t);
    };
    let N;
    e.evt.on("onMounted", () => {
      Object.values(e.contextMenus).length > 0 && (() => import("@imengyu/vue3-context-menu"))().then((s) => {
        N = s.default, N.default && !N.showContextMenu && (N = N.default);
      });
    });
    const w = m("IBizRawItem"), D = m("IBizIcon"), v = (t, s, r, f) => {
      const y = [];
      return t.forEach((c) => {
        var G;
        if (c.itemType === "SEPERATOR") {
          y.push({
            divided: "self"
          });
          return;
        }
        const M = f[c.id];
        if (M && !M.visible || c.actionLevel > 100)
          return;
        const T = {};
        if (c.showCaption && c.caption && (T.label = c.caption), c.sysImage && c.showIcon && (T.icon = p(D, {
          icon: c.sysImage
        }, null)), c.itemType === "DEUIACTION") {
          T.disabled = M.disabled, T.clickClose = !0;
          const {
            uiactionId: z
          } = c;
          z && (T.onClick = () => {
            e.doUIAction(z, s, r, c.appId);
          });
        } else if (c.itemType === "RAWITEM") {
          const {
            rawItem: z
          } = c;
          z && (T.label = p(w, {
            rawItem: c
          }, null));
        } else
          c.itemType === "ITEMS" && (G = c.detoolbarItems) != null && G.length && (T.children = v(c.detoolbarItems, s, r, f));
        y.push(T);
      }), y;
    }, b = async (t, s) => {
      s.preventDefault(), s.stopPropagation();
      const r = e.getNodeModel(t._nodeId);
      if (!(r != null && r.decontextMenu))
        return;
      const f = e.contextMenus[r.decontextMenu.id];
      if (!f.model.detoolbarItems)
        return;
      await f.calcButtonState(t._deData || (t.srfkey ? t : void 0), r.appDataEntityId);
      const y = f.state.buttonsState, c = v(f.model.detoolbarItems, t, s, y);
      c.length && N.showContextMenu({
        x: s.x,
        y: s.y,
        customClass: o.b("context-menu"),
        items: c
      });
    }, E = (t, s) => {
      var f, y;
      if (!((y = (f = t == null ? void 0 : t.decontextMenu) == null ? void 0 : f.detoolbarItems) != null && y.length))
        return;
      const r = e.contextMenuInfos[t.id];
      return r.clickTBUIActionItem && r.onlyOneActionItem ? null : p(m("iBizContextMenuControl"), {
        modelData: t.decontextMenu,
        groupLevelKeys: [50, 100],
        nodeModel: t,
        nodeData: s,
        context: e.context,
        onActionClick: (c, M) => e.doUIAction(c.uiactionId, s, M, c.appId)
      }, null);
    }, x = (t, s) => {
      const r = I(t._uuid, e);
      if (!r)
        throw new j("没有找到_uuid为".concat(t._uuid, "的节点"));
      e.onExpandChange(r, s);
    }, P = W(() => {
      e.load();
    }, 500), S = (t) => {
      e.state.query = t, P();
    }, X = (t, s, r) => {
      const f = I(t.data._uuid, e), y = I(s.data._uuid, e);
      return e.calcAllowDrop(f, y, r);
    }, Y = (t) => {
      const s = I(t.data._uuid, e);
      return e.calcAllowDrag(s);
    }, Z = (t, s, r) => {
      const f = Ee(r), y = I(t.data._uuid, e), c = I(s.data._uuid, e);
      e.onNodeDrop(y, c, f);
    }, ee = (t) => {
      (t.key === "Enter" || t.keyCode === 13) && (t.stopPropagation(), l()), (t.key === "Escape" || t.keyCode === 27) && (t.stopPropagation(), h());
    }, F = (t) => {
      var s;
      if (t.code === "F2" || t.code === "Enter") {
        const r = (s = i.value) == null ? void 0 : s.getCurrentKey();
        e.updateTreeNode(r);
      }
    };
    return De(() => {
      var t;
      (t = d.value) == null || t.$el.addEventListener("keydown", F);
    }), ye(() => {
      var t;
      (t = d.value) == null || t.$el.removeEventListener("keydown", F);
    }), {
      c: e,
      ns: o,
      treeRef: i,
      treeviewRef: d,
      treeNodeTextInputRef: u,
      treeData: R,
      treeRefreshKey: a,
      findNodeData: I,
      handleEditKeyDown: ee,
      onCheck: U,
      onNodeClick: A,
      onNodeDbClick: O,
      onNodeContextmenu: b,
      loadData: B,
      renderContextMenu: E,
      renderCounter: (t) => {
        if (t.counterId) {
          const s = n[t.counterId];
          return J(s) || t.counterMode === 1 && s === 0 ? null : p("div", {
            class: o.em("counter", "box")
          }, [p("span", {
            class: o.e("dot")
          }, [ge("·")]), p(m("iBizBadge"), {
            class: o.e("counter"),
            value: s
          }, null)]);
        }
      },
      updateNodeExpand: x,
      onInput: S,
      allowDrop: X,
      allowDrag: Y,
      handleDrop: Z,
      onNodeTextEditBlur: l
    };
  },
  render() {
    const e = {
      searchbar: () => this.c.enableQuickSearch ? p(m("el-input"), {
        "model-value": this.c.state.query,
        class: [this.ns.b("quick-search"), this.ns.b("quick-search")],
        placeholder: this.c.state.placeHolder,
        onInput: this.onInput
      }, {
        prefix: () => p(m("ion-icon"), {
          class: this.ns.e("search-icon"),
          name: "search"
        }, null)
      }) : null
    }, n = this.c.controlPanel ? "tree" : "default";
    return e[n] = () => {
      var o, i;
      if (this.c.state.isLoaded && this.treeRefreshKey)
        return p("div", {
          class: this.ns.b("tree-box")
        }, [p(m("el-tree"), {
          ref: "treeRef",
          key: this.treeRefreshKey,
          "node-key": "_id",
          "highlight-current": !0,
          "expand-on-click-node": !1,
          "auto-expand-parent": !1,
          "show-checkbox": !this.c.state.singleSelect,
          "check-strictly": !0,
          "default-expanded-keys": this.c.state.expandedKeys,
          props: {
            label: "_text",
            children: "_children",
            isLeaf: "_leaf"
          },
          lazy: !0,
          load: this.loadData,
          onCheck: this.onCheck,
          onNodeExpand: (d) => {
            this.updateNodeExpand(d, !0);
          },
          onNodeCollapse: (d) => {
            this.updateNodeExpand(d, !1);
          },
          draggable: !0,
          "allow-drop": this.allowDrop,
          "allow-drag": this.allowDrag,
          onNodeDrop: this.handleDrop
        }, {
          default: ({
            data: d
          }) => {
            var g, C;
            const a = this.findNodeData(d._uuid, this.c);
            if (!a)
              return null;
            const u = this.c.getNodeModel(a._nodeId);
            if (this.c.state.editingNodeKey === a._id)
              return p("div", {
                class: [this.ns.b("node"), (g = u.sysCss) == null ? void 0 : g.cssName]
              }, [a._icon ? p(m("iBizIcon"), {
                class: this.ns.be("node", "icon"),
                icon: a._icon
              }, null) : null, p(m("el-input"), {
                modelValue: this.c.state.editingNodeText,
                "onUpdate:modelValue": (_) => this.c.state.editingNodeText = _,
                ref: "treeNodeTextInputRef",
                class: this.ns.b("editing-node"),
                onBlur: () => {
                  this.onNodeTextEditBlur();
                },
                onKeydown: (_) => {
                  this.handleEditKeyDown(_);
                }
              }, null)]);
            const l = le(u);
            let h;
            return l ? h = p(m("iBizControlShell"), {
              data: a,
              modelData: l,
              context: this.c.context,
              params: this.c.params
            }, null) : h = [a._icon ? p(m("iBizIcon"), {
              class: this.ns.be("node", "icon"),
              icon: a._icon
            }, null) : null, a._textHtml ? p("span", {
              class: this.ns.be("node", "label"),
              innerHTML: a._textHtml
            }, null) : p("span", {
              class: this.ns.be("node", "label")
            }, [a._text])], p("div", {
              onDblclick: (_) => this.onNodeDbClick(a, _),
              onClick: (_) => this.onNodeClick(a, _),
              onContextmenu: (_) => this.onNodeContextmenu(a, _),
              class: [this.ns.b("node"), (C = u.sysCss) == null ? void 0 : C.cssName]
            }, [h, this.renderCounter(u), this.renderContextMenu(u, a)]);
          }
        }), this.c.state.newingNodeModel ? p("div", {
          class: [this.ns.be("node", "newing")]
        }, [(o = this.c.state.newingNodeModel) != null && o.sysImage ? p(m("iBizIcon"), {
          class: this.ns.be("node", "icon"),
          icon: (i = this.c.state.newingNodeModel) == null ? void 0 : i.sysImage
        }, null) : null, p(m("el-input"), {
          modelValue: this.c.state.newingNodeText,
          "onUpdate:modelValue": (d) => this.c.state.newingNodeText = d,
          ref: "treeNodeTextInputRef",
          class: this.ns.b("editing-node"),
          onBlur: this.onNodeTextEditBlur,
          onKeydown: (d) => {
            this.handleEditKeyDown(d);
          }
        }, null)]) : null]);
    }, xe(p(m("iBizControlBase"), {
      ref: "treeviewRef",
      controller: this.c
    }, ve(e) ? e : {
      default: () => [e]
    }), [[me("loading"), this.c.state.isLoading]]);
  }
});
class be {
  constructor() {
    q(this, "component", "IBizGroupTreeControl");
  }
}
const Pe = he(
  V,
  function(e) {
    e.component(V.name, V), re(
      "TREE_RENDER_GROUP_TREE",
      () => new be()
    );
  }
);
export {
  Pe as IBizGroupTreeControl,
  Pe as default
};
