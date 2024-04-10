import './style.css';
var te = Object.defineProperty;
var ne = (e, t, o) => t in e ? te(e, t, { enumerable: !0, configurable: !0, writable: !0, value: o }) : e[t] = o;
var q = (e, t, o) => (ne(e, typeof t != "symbol" ? t + "" : t, o), o);
import { TreeController as oe, getChildNodeRSs as ie, calcDeCodeNameById as se, handleAllSettled as ae, Srfuf as de, getControlPanel as re, registerControlProvider as le } from "@ibiz-template/runtime";
import { useControlController as ce, useNamespace as ue, withInstall as he } from "@ibiz-template/vue3-util";
import { defineComponent as fe, reactive as pe, ref as L, watch as H, computed as Ne, nextTick as _e, resolveComponent as g, onMounted as De, onUnmounted as ye, withDirectives as xe, createVNode as p, resolveDirective as ge, isVNode as me, createTextVNode as we } from "vue";
import { createUUID as Q } from "qx-util";
import { debounce as J } from "lodash-es";
import { RuntimeError as j, RuntimeModelError as W } from "@ibiz-template/core";
import { isNil as F } from "ramda";
function I(e, t) {
  const o = t.state.items.find((i) => i._id === e);
  return o || t.state.items.find((i) => i._uuid === e);
}
function Ie(e, t) {
  const o = () => {
    const u = e.value;
    if (!u)
      throw new j("找不到el-tree实例对象");
    return u;
  }, i = () => {
    var r;
    const u = e.value;
    if (!u) {
      setTimeout(() => {
        i();
      }, 200);
      return;
    }
    Object.values(u.store.nodesMap).forEach((h) => {
      const w = t.state.expandedKeys.includes(h.data._id);
      w !== h.expanded && (w ? h.expand() : h.collapse());
    }), t.state.singleSelect ? e.value.setCurrentKey(((r = t.state.selectedData[0]) == null ? void 0 : r._id) || void 0) : u.setCheckedKeys(t.state.selectedData.map((h) => h._id));
  }, a = J(i, 500);
  return { getTreeInstance: o, updateUI: a, triggerNodeExpand: (u) => {
    const r = o(), h = r == null ? void 0 : r.store.nodesMap[u];
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
  onDataChange(t) {
  }
  /**
   *  初始化节点拖入关系处理
   */
  initDropNodeRss() {
    var t;
    (t = this.model.detreeNodes) == null || t.forEach((o) => {
      if (!o.allowDrop)
        return;
      const i = [];
      ie(this.model, {
        parentId: o.id,
        hasQuery: !1
      }).forEach((d) => {
        var u;
        if ((u = d.parentDER1N) != null && u.pickupDEFName) {
          const r = this.getNodeModel(d.childDETreeNodeId);
          (r == null ? void 0 : r.treeNodeType) === "DE" && r.appDataEntityId && i.push({
            minorEntityId: r.appDataEntityId,
            pickupDEFName: d.parentDER1N.pickupDEFName.toLowerCase(),
            childDETreeNodeId: d.childDETreeNodeId,
            detreeNodeRSParams: d.detreeNodeRSParams
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
    nodeKey: t,
    defaultValue: o
  }) {
    if (!t || t === this.state.editingNodeKey)
      return;
    const i = I(t, this), a = this.getNodeModel(i._nodeId);
    a != null && a.allowEditText && (this.state.editingNodeKey = i._id, this.state.editingNodeText = i._text, this.state.editingNodeDefault = o, this.state.newingNodeModel = null, this.state.newingNodeText = null, this.state.newingNodeDefault = null);
  }
  /**
   * 删除指定节点
   * @author ljx
   * @date 2023-12-27 05:46:02
   * @return {*}  {void}
   */
  removeTreeNode(t) {
    if (!t || t === this.state.editingNodeKey)
      return;
    const o = I(t, this), i = {
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
    nodeType: t,
    defaultValue: o = {}
  }) {
    const i = this.getNodeModel(t);
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
  async createDeNodeData(t) {
    const o = ibiz.hub.getApp(this.context.srfappid);
    await Promise.all(
      t.map(async (i) => {
        const a = this.getNodeModel(i._nodeId), d = i._deData, u = this.context.clone();
        (await o.deService.exec(
          a.appDataEntityId,
          "create",
          u,
          d
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
    const { textAppDEFieldId: t, id: o } = this.state.newingNodeModel, i = this.state.newingNodeText, a = { _deData: {} };
    Object.assign(a, { _nodeId: o, _text: i }), Object.assign(a._deData, { [t]: i }), this.state.newingNodeDefault && Object.assign(a._deData, this.state.newingNodeDefault), Object.assign(a._deData, { [t]: i }), await this.createDeNodeData([a]), this.state.newingNodeModel = null, this.state.newingNodeText = null, this.state.newingNodeDefault = null;
  }
  /**
   * 修改节点文本
   * @param nodeData 节点数据
   * @param _text 节点文本
   */
  async onModifyTreeNode(t, o) {
    const i = this.getNodeModel(t._nodeId);
    if (!i.allowEditText)
      throw new W(i, "树节点没有配置编辑模式：名称");
    if (t._nodeType !== "DE")
      throw new j("不是实体树节点数据");
    if (t._text !== o) {
      if (t._text = o, this.state.editingNodeDefault) {
        const a = Object.keys(this.state.editingNodeDefault);
        a && a.length > 0 && a.forEach((d) => {
          F(t._deData[d]) && (t._deData[d] = this.state.editingNodeDefault[d]);
        });
      }
      await this.updateDeNodeData([t]);
    }
    this.emitDEDataChange("update", t._deData), this.state.editingNodeKey = null, this.state.editingNodeText = null, this.state.editingNodeDefault = null;
  }
  /**
   * 删除树节点
   * @param args 参数
   * @returns
   */
  async onRemoveTreeNode(t) {
    const { context: o, params: i, data: a } = this.handlerAbilityParams(t), d = this.getNodeModel(a[0]._nodeId);
    if ((t == null ? void 0 : t.silent) !== !0 && !await ibiz.confirm.error({
      title: "数据删除",
      desc: "确认删除数据？"
    }))
      return;
    await this._evt.emit("onBeforeRemove", void 0), await this.startLoading();
    let u = !1;
    try {
      const r = se(
        d.appDataEntityId
      );
      await ae(
        a.map(async (h) => {
          if (h.srfuf !== de.CREATE) {
            const w = o.clone();
            w[r] = h.srfkey, await await ibiz.hub.getApp(d.appId).deService.exec(
              d.appDataEntityId,
              "remove",
              w,
              a,
              i
            ), u = !0;
          }
          this.afterRemove(h);
        })
      ), (t == null ? void 0 : t.silent) !== !0 && this.actionNotification("REMOVESUCCESS", {
        data: a,
        default: "数据[".concat(a.map((h) => h.srfmajortext).join("、"), "]删除成功!")
      }), u && !(t != null && t.notRefresh) && await this.refresh();
    } catch (r) {
      throw await this._evt.emit("onRemoveError", void 0), this.actionNotification("REMOVEERROR", {
        error: r,
        data: a
      }), r;
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
  calcAllowDrop(t, o, i) {
    var d, u;
    const a = this.getNodeModel(t._nodeId);
    if (i === "inner")
      return !!this.findDropNodeRS(
        o._nodeId,
        a.appDataEntityId
      );
    if (((d = t._parent) == null ? void 0 : d._id) === ((u = o._parent) == null ? void 0 : u._id)) {
      const r = this.getNodeModel(o._nodeId);
      return (r == null ? void 0 : r.allowOrder) === !0;
    }
    return o._parent ? o._parent && o._parent._id && this.getNodeModel(o._parent._nodeId).rootNode ? !0 : !!this.findDropNodeRS(
      o._parent._nodeId,
      a.appDataEntityId
    ) : !1;
  }
  /**
   * 处理节点拖入事件
   * @param draggingNode
   * @param dropNode
   * @param dropType
   */
  async onNodeDrop(t, o, i) {
    var k, A, O;
    i === "inner" && !o._leaf && o._children === void 0 && await this.expandNodeByKey([o._id]);
    const a = i !== "inner", d = [], u = this.getNodeModel(t._nodeId), r = i === "inner" ? o : o._parent;
    let h = !1;
    this.getNodeModel(r._nodeId).rootNode && (h = !0);
    const C = (r == null ? void 0 : r._id) !== ((k = t._parent) == null ? void 0 : k._id);
    let _ = this.getNodeModel(o._nodeId);
    if (i === "inner" || ((A = o._parent) == null ? void 0 : A._id) !== ((O = t._parent) == null ? void 0 : O._id) || h) {
      const N = [];
      for (const m of this.dropNodeRss.values())
        N.push(
          ...m.filter((D) => (
            // 修复子关系情况，根上也存在当前实体数据
            D.minorEntityId === u.appDataEntityId
          ))
        );
      if (h && C)
        N && (N.forEach((m) => {
          t._deData[m.pickupDEFName] = null;
        }), d.push(t), _ = this.getNodeModel(u.id));
      else {
        const m = this.findDropNodeRS(
          r._nodeId,
          u.appDataEntityId
        );
        m && (N && N.forEach((D) => {
          t._deData[D.pickupDEFName] = null;
        }), t._deData[m.pickupDEFName] = r._value, m.detreeNodeRSParams && m.detreeNodeRSParams.forEach((D) => {
          var v, b;
          D.name && D.value && ((v = t._deData) != null && v.hasOwnProperty(
            D.name.toLowerCase()
          )) && ((b = r._deData) != null && b.hasOwnProperty(D.value.toLowerCase())) && (t._deData[D.name.toLowerCase()] = r._deData[D.value.toLowerCase()]);
        }), d.push(t), _ = this.getNodeModel(m.childDETreeNodeId));
      }
    }
    const R = t._parent._children;
    if (R.splice(R.indexOf(t), 1), i === "inner")
      o._children || (o._children = [], o._leaf = !0, this.state.expandedKeys.push(o._id)), o._children.push(t);
    else {
      let N = r._children.indexOf(o);
      i === "next" && (N += 1), r._children.splice(N, 0, t);
    }
    (i === "inner" || C) && (t._parent = r, t._nodeId = _.id, this.state.expandedKeys = this.calcExpandedKeys([r]));
    const { sortAppDEFieldId: B, sortDir: K, allowOrder: U } = _;
    if (U === !0) {
      if (!B)
        throw new W(_, "缺少配置排序属性");
      const N = B.toLowerCase(), m = K === "ASC", D = [...r._children].filter(
        (x) => x._nodeType === "DE"
      );
      m || D.reverse();
      const v = (x) => x + (100 - x % 100), b = (x) => x[N] || 0;
      let E;
      D.forEach((x, P) => {
        const S = x._deData;
        E === void 0 ? x === t && (P === 0 ? E = 100 : E = v(b(D[P - 1]._deData)), S[N] = E, d.indexOf(x) === -1 && d.push(x)) : (E >= b(S) && (S[N] = v(E), d.push(x)), E = b(S));
      });
    }
    await this.updateDeNodeData(d), this._evt.emit("onAfterNodeDrop", { isChangedParent: C }), this.refreshNodeChildren(o, a), this.setSelection([]);
  }
  /**
   * 检测实体数据变更
   *
   * @author tony001
   * @date 2024-03-29 11:03:30
   * @protected
   * @param {IPortalMessage} msg
   * @return {*}  {void}
   */
  onDEDataChange(t) {
    if (!F(t.triggerKey) && t.triggerKey === this.triggerKey || t.subtype === "OBJECTCREATED")
      return;
    const o = t.data, i = this.state.items.find(
      (a) => a._nodeType === "DE" && a._deData && a._deData.srfdecodename === o.srfdecodename && a._deData.srfkey === o.srfkey
    );
    i && this.doNextActive(() => this.refreshNodeChildren(i, !0), {
      key: "refresh".concat(i._id)
    });
  }
}
function ve(e) {
  return typeof e == "function" || Object.prototype.toString.call(e) === "[object Object]" && !me(e);
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
    const e = ce((...n) => new Ce(...n)), t = pe({});
    e.evt.on("onCreated", () => {
      e.counter && e.counter.onChange((n) => {
        Object.assign(t, n);
      }, !0);
    });
    const o = ue("control-group-tree"), i = L(null), a = L(null), d = L(""), u = L(null);
    H(() => u.value, (n) => {
      n && n.$el.getElementsByTagName("input")[0].focus();
    });
    const r = async () => {
      if (e.state.editingNodeKey)
        if (e.state.editingNodeText) {
          const n = I(e.state.editingNodeKey, e);
          await e.onModifyTreeNode(n, e.state.editingNodeText);
        } else
          e.state.editingNodeKey = null;
      e.state.newingNodeText ? e.onCreateTreeNode() : e.state.newingNodeModel = null;
    }, h = async () => {
      e.state.editingNodeKey && (e.state.editingNodeKey = null), e.state.newingNodeModel && (e.state.newingNodeModel = null, e.state.newingNodeText = "");
    }, {
      updateUI: w,
      triggerNodeExpand: C
    } = Ie(i, e), _ = (n) => n.map((s) => ({
      _id: s._id,
      _uuid: s._uuid,
      _leaf: s._leaf,
      _text: s._text
    }));
    e.evt.on("onAfterRefreshParent", (n) => {
      if (i.value) {
        const {
          parentNode: s,
          children: l
        } = n, f = _(l);
        i.value.updateKeyChildren(s._id, f), w();
      }
    }), e.evt.on("onAfterNodeDrop", (n) => {
      n.isChangedParent && (d.value = Q());
    });
    const R = Ne(() => e.state.isLoaded ? e.model.rootVisible ? e.state.rootNodes : e.state.rootNodes.reduce((n, s) => s._children ? n.concat(s._children) : n, []) : []);
    H(R, (n, s) => {
      n !== s && (d.value = Q());
    });
    const B = async (n, s) => {
      let l;
      if (n.level === 0)
        l = R.value, ibiz.log.debug("初始加载");
      else {
        const f = I(n.data._uuid, e);
        f._children ? (ibiz.log.debug("节点展开加载-本地", f), l = f._children) : (ibiz.log.debug("节点展开加载-远程", f), l = await e.loadNodes(f));
      }
      ibiz.log.debug("给树返回值", l), s(_(l)), w();
    };
    let K = !1;
    e.evt.on("onLoadSuccess", () => {
      K = !0, setTimeout(() => {
        K = !1;
      }, 200);
    }), e.evt.on("onSelectionChange", async () => {
      var n;
      K && await _e(), e.state.singleSelect ? i.value.setCurrentKey(((n = e.state.selectedData[0]) == null ? void 0 : n._id) || void 0) : i.value.setCheckedKeys(e.state.selectedData.map((s) => s._id));
    });
    const U = (n, s) => {
      const {
        checkedNodes: l
      } = s;
      e.setSelection(l);
    };
    let k = !1;
    const A = (n, s) => {
      var l, f, y;
      if (s.stopPropagation(), !k) {
        if (((l = i.value) == null ? void 0 : l.getCurrentKey()) === n._id) {
          const c = (f = i.value) == null ? void 0 : f.getCurrentKey();
          e.updateTreeNode({
            nodeKey: c,
            defaultValue: {}
          });
        }
        if (e.state.singleSelect || (y = i.value) == null || y.setCurrentKey(n._id), e.state.navigational) {
          const c = e.getNodeModel(n._nodeId);
          if (!(c != null && c.navAppViewId)) {
            const M = C(n._id);
            e.onExpandChange(n, M);
          }
        }
        e.onTreeNodeClick(n, s), k = !0, setTimeout(() => {
          k = !1;
        }, 200);
      }
    }, O = (n, s) => {
      s.stopPropagation(), e.onDbTreeNodeClick(n);
    };
    let N;
    e.evt.on("onMounted", () => {
      Object.values(e.contextMenus).length > 0 && (() => import("@imengyu/vue3-context-menu"))().then((s) => {
        N = s.default, N.default && !N.showContextMenu && (N = N.default);
      });
    });
    const m = g("IBizRawItem"), D = g("IBizIcon"), v = (n, s, l, f) => {
      const y = [];
      return n.forEach((c) => {
        var $;
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
            e.doUIAction(z, s, l, c.appId);
          });
        } else if (c.itemType === "RAWITEM") {
          const {
            rawItem: z
          } = c;
          z && (T.label = p(m, {
            rawItem: c
          }, null));
        } else
          c.itemType === "ITEMS" && ($ = c.detoolbarItems) != null && $.length && (T.children = v(c.detoolbarItems, s, l, f));
        y.push(T);
      }), y;
    }, b = async (n, s) => {
      s.preventDefault(), s.stopPropagation();
      const l = e.getNodeModel(n._nodeId);
      if (!(l != null && l.decontextMenu))
        return;
      const f = e.contextMenus[l.decontextMenu.id];
      if (!f.model.detoolbarItems)
        return;
      await f.calcButtonState(n._deData || (n.srfkey ? n : void 0), l.appDataEntityId);
      const y = f.state.buttonsState, c = v(f.model.detoolbarItems, n, s, y);
      c.length && N.showContextMenu({
        x: s.x,
        y: s.y,
        customClass: o.b("context-menu"),
        items: c
      });
    }, E = (n, s) => {
      var f, y;
      if (!((y = (f = n == null ? void 0 : n.decontextMenu) == null ? void 0 : f.detoolbarItems) != null && y.length))
        return;
      const l = e.contextMenuInfos[n.id];
      return l.clickTBUIActionItem && l.onlyOneActionItem ? null : p(g("iBizContextMenuControl"), {
        modelData: n.decontextMenu,
        groupLevelKeys: [50, 100],
        nodeModel: n,
        nodeData: s,
        context: e.context,
        onActionClick: (c, M) => e.doUIAction(c.uiactionId, s, M, c.appId)
      }, null);
    }, x = (n, s) => {
      const l = I(n._uuid, e);
      if (!l)
        throw new j("没有找到_uuid为".concat(n._uuid, "的节点"));
      e.onExpandChange(l, s);
    }, P = J(() => {
      e.load();
    }, 500), S = (n) => {
      e.state.query = n, P();
    }, X = (n, s, l) => {
      const f = I(n.data._uuid, e), y = I(s.data._uuid, e);
      return e.calcAllowDrop(f, y, l);
    }, Y = (n) => {
      const s = I(n.data._uuid, e);
      return e.calcAllowDrag(s);
    }, Z = (n, s, l) => {
      const f = Ee(l), y = I(n.data._uuid, e), c = I(s.data._uuid, e);
      e.onNodeDrop(y, c, f);
    }, ee = (n) => {
      (n.key === "Enter" || n.keyCode === 13) && (n.stopPropagation(), r()), (n.key === "Escape" || n.keyCode === 27) && (n.stopPropagation(), h());
    }, G = (n) => {
      var s;
      if (n.code === "F2" || n.code === "Enter") {
        const l = (s = i.value) == null ? void 0 : s.getCurrentKey();
        e.updateTreeNode(l);
      }
    };
    return De(() => {
      var n;
      (n = a.value) == null || n.$el.addEventListener("keydown", G);
    }), ye(() => {
      var n;
      (n = a.value) == null || n.$el.removeEventListener("keydown", G);
    }), {
      c: e,
      ns: o,
      treeRef: i,
      treeviewRef: a,
      treeNodeTextInputRef: u,
      treeData: R,
      treeRefreshKey: d,
      findNodeData: I,
      handleEditKeyDown: ee,
      onCheck: U,
      onNodeClick: A,
      onNodeDbClick: O,
      onNodeContextmenu: b,
      loadData: B,
      renderContextMenu: E,
      renderCounter: (n) => {
        if (n.counterId) {
          const s = t[n.counterId];
          return F(s) || n.counterMode === 1 && s === 0 ? null : p("div", {
            class: o.em("counter", "box")
          }, [p("span", {
            class: o.e("dot")
          }, [we("·")]), p(g("iBizBadge"), {
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
      onNodeTextEditBlur: r
    };
  },
  render() {
    const e = {
      searchbar: () => this.c.enableQuickSearch ? p(g("el-input"), {
        "model-value": this.c.state.query,
        class: [this.ns.b("quick-search"), this.ns.b("quick-search")],
        placeholder: this.c.state.placeHolder,
        onInput: this.onInput
      }, {
        prefix: () => p(g("ion-icon"), {
          class: this.ns.e("search-icon"),
          name: "search"
        }, null)
      }) : null
    }, t = this.c.controlPanel ? "tree" : "default";
    return e[t] = () => {
      var o, i;
      if (this.c.state.isLoaded && this.treeRefreshKey)
        return p("div", {
          class: this.ns.b("tree-box")
        }, [p(g("el-tree"), {
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
          onNodeExpand: (a) => {
            this.updateNodeExpand(a, !0);
          },
          onNodeCollapse: (a) => {
            this.updateNodeExpand(a, !1);
          },
          draggable: !0,
          "allow-drop": this.allowDrop,
          "allow-drag": this.allowDrag,
          onNodeDrop: this.handleDrop
        }, {
          default: ({
            data: a
          }) => {
            var w, C;
            const d = this.findNodeData(a._uuid, this.c);
            if (!d)
              return null;
            const u = this.c.getNodeModel(d._nodeId);
            if (this.c.state.editingNodeKey === d._id)
              return p("div", {
                class: [this.ns.b("node"), (w = u.sysCss) == null ? void 0 : w.cssName]
              }, [d._icon ? p(g("iBizIcon"), {
                class: this.ns.be("node", "icon"),
                icon: d._icon
              }, null) : null, p(g("el-input"), {
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
            const r = re(u);
            let h;
            return r ? h = p(g("iBizControlShell"), {
              data: d,
              modelData: r,
              context: this.c.context,
              params: this.c.params
            }, null) : h = [d._icon ? p(g("iBizIcon"), {
              class: this.ns.be("node", "icon"),
              icon: d._icon
            }, null) : null, d._textHtml ? p("span", {
              class: this.ns.be("node", "label"),
              innerHTML: d._textHtml
            }, null) : p("span", {
              class: this.ns.be("node", "label")
            }, [d._text])], p("div", {
              onDblclick: (_) => this.onNodeDbClick(d, _),
              onClick: (_) => this.onNodeClick(d, _),
              onContextmenu: (_) => this.onNodeContextmenu(d, _),
              class: [this.ns.b("node"), (C = u.sysCss) == null ? void 0 : C.cssName]
            }, [h, this.renderCounter(u), this.renderContextMenu(u, d)]);
          }
        }), this.c.state.newingNodeModel ? p("div", {
          class: [this.ns.be("node", "newing")]
        }, [(o = this.c.state.newingNodeModel) != null && o.sysImage ? p(g("iBizIcon"), {
          class: this.ns.be("node", "icon"),
          icon: (i = this.c.state.newingNodeModel) == null ? void 0 : i.sysImage
        }, null) : null, p(g("el-input"), {
          modelValue: this.c.state.newingNodeText,
          "onUpdate:modelValue": (a) => this.c.state.newingNodeText = a,
          ref: "treeNodeTextInputRef",
          class: this.ns.b("editing-node"),
          onBlur: this.onNodeTextEditBlur,
          onKeydown: (a) => {
            this.handleEditKeyDown(a);
          }
        }, null)]) : null]);
    }, xe(p(g("iBizControlBase"), {
      ref: "treeviewRef",
      controller: this.c
    }, ve(e) ? e : {
      default: () => [e]
    }), [[ge("loading"), this.c.state.isLoading]]);
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
    e.component(V.name, V), le(
      "TREE_RENDER_GROUP_TREE",
      () => new be()
    );
  }
);
export {
  Pe as IBizGroupTreeControl,
  Pe as default
};
