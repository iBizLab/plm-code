import './style.css';
var re = Object.defineProperty;
var de = (e, p, t) => p in e ? re(e, p, { enumerable: !0, configurable: !0, writable: !0, value: t }) : e[p] = t;
var O = (e, p, t) => (de(e, typeof p != "symbol" ? p + "" : p, t), t);
import { TreeController as le, getChildNodeRSs as ce, calcDeCodeNameById as ue, handleAllSettled as fe, Srfuf as he, getControlPanel as pe, registerControlProvider as Ne } from "@ibiz-template/runtime";
import { useControlController as _e, useNamespace as me, withInstall as De } from "@ibiz-template/vue3-util";
import { ref as j, defineComponent as ye, reactive as ve, watch as X, computed as Ie, nextTick as ge, resolveComponent as g, onMounted as we, onUnmounted as xe, withDirectives as Ee, createVNode as f, resolveDirective as be, isVNode as Ce, createTextVNode as Y } from "vue";
import { createUUID as Z } from "qx-util";
import { debounce as te } from "lodash-es";
import { RuntimeError as $, RuntimeModelError as ee } from "@ibiz-template/core";
import { isNil as ne } from "ramda";
function w(e, p) {
  const t = p.state.items.find((o) => o._id === e);
  return t || p.state.items.find((o) => o._uuid === e);
}
function Te(e, p) {
  const t = () => {
    const d = e.value;
    if (!d)
      throw new $("找不到el-tree实例对象");
    return d;
  }, o = () => {
    var h;
    const d = e.value;
    if (!d) {
      setTimeout(() => {
        o();
      }, 200);
      return;
    }
    Object.values(d.store.nodesMap).forEach((l) => {
      const D = p.state.expandedKeys.includes(l.data._id);
      D !== l.expanded && (D ? l.expand() : l.collapse());
    }), p.state.singleSelect ? e.value.setCurrentKey(((h = p.state.selectedData[0]) == null ? void 0 : h._id) || void 0) : d.setCheckedKeys(p.state.selectedData.map((l) => l._id));
  }, s = te(o, 500);
  return { getTreeInstance: t, updateUI: s, triggerNodeExpand: (d) => {
    const h = t(), l = h == null ? void 0 : h.store.nodesMap[d];
    if (l)
      return l.expanded ? (l.collapse(), !1) : (l.expand(), !0);
  } };
}
function Me(e) {
  switch (e) {
    case "inner":
      return "inner";
    case "before":
      return "prev";
    case "after":
      return "next";
    default:
      throw new $("暂不支持dropType:".concat(e));
  }
}
class Re extends le {
  constructor() {
    super(...arguments);
    /**
     * 底部工具栏
     *
     * @type {(IControl | undefined)}
     * @memberof GroupTreeController
     */
    O(this, "bottomToolbar");
    /**
     * 隐藏节点id
     *
     * @type {string}
     * @memberof GroupTreeController
     */
    O(this, "hiddenNodeId", "");
    /**
     * 绘制模式
     *
     * @type {('tree' | 'listTree')}
     * @memberof GroupTreeController
     */
    O(this, "renderMode", "tree");
    /**
     * 是否正在过滤
     *
     * @memberof GroupTreeController
     */
    O(this, "isFilter", j(!1));
  }
  /**
   * 重新初始化
   *
   * @protected
   * @return {*}  {Promise<void>}
   * @memberof GroupTreeController
   */
  async onCreated() {
    var s;
    await super.onCreated();
    const t = ((s = this.view.model.viewLayoutPanel) == null ? void 0 : s.controls) || [];
    this.bottomToolbar = t.find((r) => r.name === "toolbar");
    const { ctrlParams: o = {} } = this.model.controlParam;
    o.HIDDENNODEID && (this.hiddenNodeId = o.HIDDENNODEID), o.RENDERMODE && (this.renderMode = o.RENDERMODE);
  }
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
      const s = [];
      ce(this.model, {
        parentId: o.id,
        hasQuery: !1
      }).forEach((d) => {
        var h;
        if ((h = d.parentDER1N) != null && h.pickupDEFName) {
          const l = this.getNodeModel(d.childDETreeNodeId);
          (l == null ? void 0 : l.treeNodeType) === "DE" && l.appDataEntityId && s.push({
            minorEntityId: l.appDataEntityId,
            pickupDEFName: d.parentDER1N.pickupDEFName.toLowerCase(),
            childDETreeNodeId: d.childDETreeNodeId,
            detreeNodeRSParams: d.detreeNodeRSParams
          });
        }
      }), s.length > 0 && this.dropNodeRss.set(o.id, s);
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
    const s = w(t, this), r = this.getNodeModel(s._nodeId);
    r != null && r.allowEditText && (this.state.editingNodeKey = s._id, this.state.editingNodeText = s._text, this.state.editingNodeDefault = o, this.state.newingNodeModel = null, this.state.newingNodeText = null, this.state.newingNodeDefault = null);
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
    const o = w(t, this), s = {
      context: this.context || {},
      params: this.params || {},
      data: [o]
    };
    this.onRemoveTreeNode(s);
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
    const s = this.getNodeModel(t);
    this.state.newingNodeModel = s, this.state.newingNodeDefault = o, this.state.editingNodeKey = null, this.state.editingNodeText = null, this.state.editingNodeDefault = null;
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
      t.map(async (s) => {
        const r = this.getNodeModel(s._nodeId), d = s._deData, h = this.context.clone();
        (await o.deService.exec(
          r.appDataEntityId,
          "create",
          h,
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
    const { textAppDEFieldId: t, id: o } = this.state.newingNodeModel, s = this.state.newingNodeText, r = { _deData: {} };
    Object.assign(r, { _nodeId: o, _text: s }), Object.assign(r._deData, { [t]: s }), this.state.newingNodeDefault && Object.assign(r._deData, this.state.newingNodeDefault), Object.assign(r._deData, { [t]: s }), await this.createDeNodeData([r]), this.state.newingNodeModel = null, this.state.newingNodeText = null, this.state.newingNodeDefault = null;
  }
  /**
   * 修改节点文本
   * @param nodeData 节点数据
   * @param _text 节点文本
   */
  async onModifyTreeNode(t, o) {
    const s = this.getNodeModel(t._nodeId);
    if (!s.allowEditText)
      throw new ee(s, "树节点没有配置编辑模式：名称");
    if (t._nodeType !== "DE")
      throw new $("不是实体树节点数据");
    if (t._text !== o) {
      if (t._text = o, this.state.editingNodeDefault) {
        const r = Object.keys(this.state.editingNodeDefault);
        r && r.length > 0 && r.forEach((d) => {
          ne(t._deData[d]) && (t._deData[d] = this.state.editingNodeDefault[d]);
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
    const { context: o, params: s, data: r } = this.handlerAbilityParams(t), d = this.getNodeModel(r[0]._nodeId);
    if ((t == null ? void 0 : t.silent) !== !0 && !await ibiz.confirm.error({
      title: "数据删除",
      desc: "确认删除数据？"
    }))
      return;
    await this._evt.emit("onBeforeRemove", void 0), await this.startLoading();
    let h = !1;
    try {
      const l = ue(
        d.appDataEntityId
      );
      await fe(
        r.map(async (D) => {
          if (D.srfuf !== he.CREATE) {
            const K = o.clone();
            K[l] = D.srfkey, await await ibiz.hub.getApp(d.appId).deService.exec(
              d.appDataEntityId,
              "remove",
              K,
              r,
              s
            ), h = !0;
          }
          this.afterRemove(D);
        })
      ), (t == null ? void 0 : t.silent) !== !0 && this.actionNotification("REMOVESUCCESS", {
        data: r,
        default: "数据[".concat(r.map((D) => D.srfmajortext).join("、"), "]删除成功!")
      }), h && !(t != null && t.notRefresh) && await this.refresh();
    } catch (l) {
      throw await this._evt.emit("onRemoveError", void 0), this.actionNotification("REMOVEERROR", {
        error: l,
        data: r
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
  calcAllowDrop(t, o, s) {
    var d, h;
    const r = this.getNodeModel(t._nodeId);
    if (s === "inner")
      return !!this.findDropNodeRS(
        o._nodeId,
        r.appDataEntityId
      );
    if (((d = t._parent) == null ? void 0 : d._id) === ((h = o._parent) == null ? void 0 : h._id)) {
      const l = this.getNodeModel(o._nodeId);
      return (l == null ? void 0 : l.allowOrder) === !0;
    }
    return o._parent ? o._parent && o._parent._id && this.getNodeModel(o._parent._nodeId).rootNode ? !0 : !!this.findDropNodeRS(
      o._parent._nodeId,
      r.appDataEntityId
    ) : !1;
  }
  /**
   * 处理节点拖入事件
   * @param draggingNode
   * @param dropNode
   * @param dropType
   */
  async onNodeDrop(t, o, s) {
    var P, L, T;
    s === "inner" && !o._leaf && o._children === void 0 && await this.expandNodeByKey([o._id]);
    const r = s !== "inner", d = [], h = this.getNodeModel(t._nodeId), l = s === "inner" ? o : o._parent;
    let D = !1;
    this.getNodeModel(l._nodeId).rootNode && (D = !0);
    const S = (l == null ? void 0 : l._id) !== ((P = t._parent) == null ? void 0 : P._id);
    let C = this.getNodeModel(o._nodeId);
    if (s === "inner" || ((L = o._parent) == null ? void 0 : L._id) !== ((T = t._parent) == null ? void 0 : T._id) || D) {
      const y = [];
      for (const m of this.dropNodeRss.values())
        y.push(
          ...m.filter((_) => (
            // 修复子关系情况，根上也存在当前实体数据
            _.minorEntityId === h.appDataEntityId
          ))
        );
      if (D && S)
        y && (y.forEach((m) => {
          t._deData[m.pickupDEFName] = null;
        }), d.push(t), C = this.getNodeModel(h.id));
      else {
        const m = this.findDropNodeRS(
          l._nodeId,
          h.appDataEntityId
        );
        m && (y && y.forEach((_) => {
          t._deData[_.pickupDEFName] = null;
        }), t._deData[m.pickupDEFName] = l._value, m.detreeNodeRSParams && m.detreeNodeRSParams.forEach((_) => {
          var R, M;
          _.name && _.value && ((R = t._deData) != null && R.hasOwnProperty(
            _.name.toLowerCase()
          )) && ((M = l._deData) != null && M.hasOwnProperty(_.value.toLowerCase())) && (t._deData[_.name.toLowerCase()] = l._deData[_.value.toLowerCase()]);
        }), d.push(t), C = this.getNodeModel(m.childDETreeNodeId));
      }
    }
    const B = t._parent._children;
    if (B.splice(B.indexOf(t), 1), s === "inner")
      o._children || (o._children = [], o._leaf = !0, this.state.expandedKeys.push(o._id)), o._children.push(t);
    else {
      let y = l._children.indexOf(o);
      s === "next" && (y += 1), l._children.splice(y, 0, t);
    }
    (s === "inner" || S) && (t._parent = l, t._nodeId = C.id, this.state.expandedKeys = this.calcExpandedKeys([l]));
    const { sortAppDEFieldId: A, sortDir: U, allowOrder: F } = C;
    if (F === !0) {
      if (!A)
        throw new ee(C, "缺少配置排序属性");
      const y = A.toLowerCase(), m = U === "ASC", _ = [...l._children].filter(
        (v) => v._nodeType === "DE"
      );
      m || _.reverse();
      const R = (v) => v + (100 - v % 100), M = (v) => v[y] || 0;
      let x;
      _.forEach((v, V) => {
        const k = v._deData;
        x === void 0 ? v === t && (V === 0 ? x = 100 : x = R(M(_[V - 1]._deData)), k[y] = x, d.indexOf(v) === -1 && d.push(v)) : (x >= M(k) && (k[y] = R(x), d.push(v)), x = M(k));
      });
    }
    await this.updateDeNodeData(d), this._evt.emit("onAfterNodeDrop", { isChangedParent: S }), this.refreshNodeChildren(o, r), this.state.selectedData = [];
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
    if (t.triggerKey === this.triggerKey)
      return;
    const o = t.data;
    if (t.subtype === "OBJECTCREATED") {
      this.state.items.find(
        (d) => d._nodeType === "DE" && d._deData && d._deData.srfdecodename === o.srfdecodename
      ) && this.refresh();
      return;
    }
    const s = this.state.items.find(
      (r) => r._nodeType === "DE" && r._deData && r._deData.srfdecodename === o.srfdecodename && r._deData.srfkey === o.srfkey
    );
    s && this.doNextActive(() => this.refreshNodeChildren(s, !0), {
      key: "refresh".concat(s._id)
    });
  }
  async afterLoad(t, o) {
    return super.afterLoad(t, o);
  }
  /**
   * 重写节点点击事件
   *
   * @param {ITreeNodeData} nodeData
   * @param {MouseEvent} event
   * @return {*}  {Promise<void>}
   * @memberof GroupTreeController
   */
  async onTreeNodeClick(t, o) {
    var r;
    const s = (r = this.contextMenuInfos[t._nodeId]) == null ? void 0 : r.clickTBUIActionItem;
    if (s)
      return this.doUIAction(
        s.uiactionId,
        t,
        o,
        s.appId
      );
    if (this.state.navigational) {
      const d = this.getNodeModel(t._nodeId);
      if (!(d != null && d.navAppViewId))
        return;
    }
    this.state.singleSelect && !t._disableSelect && this.setSelection([t]), this.state.mdctrlActiveMode === 1 && await this.setActive(t);
  }
  /**
   * 过滤节点
   *
   * @param {string} nodeTag
   * @memberof GroupTreeController
   */
  async changeTreeState(t) {
    t && t === "draft" ? (this.isFilter.value = !0, this.evt.emit("onFilterNode", { nodeTag: t })) : this.resetTreeState();
  }
  /**
   *  重置过滤状态
   *
   * @author tony001
   * @date 2024-04-12 15:04:44
   * @param {boolean} state
   */
  resetTreeState() {
    this.isFilter.value && (this.evt.emit("onResetSate", {}), this.isFilter.value = !1);
  }
  /**
   * 重写刷新
   *
   * @author tony001
   * @date 2024-04-12 15:04:53
   * @return {*}  {Promise<void>}
   */
  async refresh() {
    super.refresh(), this.resetTreeState();
  }
}
function ke(e) {
  return typeof e == "function" || Object.prototype.toString.call(e) === "[object Object]" && !Ce(e);
}
const H = /* @__PURE__ */ ye({
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
    const e = _e((...n) => new Re(...n)), p = ve({});
    e.evt.on("onCreated", () => {
      e.counter && e.counter.onChange((n) => {
        Object.assign(p, n);
      }, !0);
    });
    const t = me("control-group-tree"), o = j(null), s = j(null), r = j(""), d = j(null);
    X(() => d.value, (n) => {
      n && n.$el.getElementsByTagName("input")[0].focus();
    });
    const h = async () => {
      if (e.state.editingNodeKey)
        if (e.state.editingNodeText) {
          const n = w(e.state.editingNodeKey, e);
          await e.onModifyTreeNode(n, e.state.editingNodeText);
        } else
          e.state.editingNodeKey = null;
      e.state.newingNodeText ? e.onCreateTreeNode() : e.state.newingNodeModel = null;
    }, l = async () => {
      e.state.editingNodeKey && (e.state.editingNodeKey = null), e.state.newingNodeModel && (e.state.newingNodeModel = null, e.state.newingNodeText = "");
    }, {
      updateUI: D,
      triggerNodeExpand: K
    } = Te(o, e), S = (n) => n.map((i) => ({
      _id: i._id,
      _uuid: i._uuid,
      _leaf: i._leaf,
      _text: i._text
    }));
    e.evt.on("onAfterRefreshParent", (n) => {
      if (o.value) {
        const {
          parentNode: i,
          children: a
        } = n, c = S(a);
        o.value.updateKeyChildren(i._id, c), D();
      }
    }), e.evt.on("onAfterNodeDrop", (n) => {
      n.isChangedParent && (r.value = Z());
    });
    const C = Ie(() => e.state.isLoaded ? e.model.rootVisible ? e.state.rootNodes : e.state.rootNodes.reduce((n, i) => i._children ? n.concat(i._children) : n, []) : []);
    X(C, (n, i) => {
      n !== i && (r.value = Z());
    });
    const B = async (n, i) => {
      let a;
      if (n.level === 0)
        a = C.value, ibiz.log.debug("初始加载");
      else {
        const c = w(n.data._uuid, e);
        c._children ? (ibiz.log.debug("节点展开加载-本地", c), a = c._children) : (ibiz.log.debug("节点展开加载-远程", c), a = await e.loadNodes(c));
      }
      ibiz.log.debug("给树返回值", a), i(S(a)), D();
    };
    let A = !1;
    e.evt.on("onLoadSuccess", () => {
      A = !0, setTimeout(() => {
        A = !1;
      }, 200);
    }), e.evt.on("onSelectionChange", async () => {
      var n;
      A && await ge(), e.state.singleSelect ? o.value.setCurrentKey(((n = e.state.selectedData[0]) == null ? void 0 : n._id) || void 0) : o.value.setCheckedKeys(e.state.selectedData.map((i) => i._id));
    });
    const U = (n, i) => {
      const {
        checkedNodes: a
      } = i;
      e.setSelection(a);
    };
    let F = !1;
    const P = (n, i) => {
      var a, c, N;
      if (i.stopPropagation(), !F) {
        if (((a = o.value) == null ? void 0 : a.getCurrentKey()) === n._id) {
          const u = (c = o.value) == null ? void 0 : c.getCurrentKey();
          e.updateTreeNode({
            nodeKey: u,
            defaultValue: {}
          });
        }
        if (e.state.singleSelect || (N = o.value) == null || N.setCurrentKey(n._id), e.state.navigational) {
          const u = e.getNodeModel(n._nodeId);
          if (!(u != null && u.navAppViewId)) {
            const E = K(n._id);
            e.onExpandChange(n, E);
          }
        }
        e.onTreeNodeClick(n, i), F = !0, setTimeout(() => {
          F = !1;
        }, 200);
      }
    }, L = (n, i) => {
      i.stopPropagation(), e.onDbTreeNodeClick(n);
    };
    let T;
    e.evt.on("onMounted", () => {
      Object.values(e.contextMenus).length > 0 && (() => import("@imengyu/vue3-context-menu"))().then((i) => {
        T = i.default, T.default && !T.showContextMenu && (T = T.default);
      });
    });
    const y = g("IBizRawItem"), m = g("IBizIcon"), _ = (n, i, a, c) => {
      const N = [];
      return n.forEach((u) => {
        var z;
        if (u.itemType === "SEPERATOR") {
          N.push({
            divided: "self"
          });
          return;
        }
        const E = c[u.id];
        if (E && !E.visible || u.actionLevel > 100)
          return;
        const b = {};
        if (u.showCaption && u.caption && (b.label = u.caption), u.sysImage && u.showIcon && (b.icon = f(m, {
          icon: u.sysImage
        }, null)), u.itemType === "DEUIACTION") {
          b.disabled = E.disabled, b.clickClose = !0;
          const {
            uiactionId: I
          } = u;
          I && (b.onClick = () => {
            e.doUIAction(I, i, a, u.appId);
          });
        } else if (u.itemType === "RAWITEM") {
          const {
            rawItem: I
          } = u;
          I && (b.label = f(y, {
            rawItem: u
          }, null));
        } else
          u.itemType === "ITEMS" && (z = u.detoolbarItems) != null && z.length && (b.children = _(u.detoolbarItems, i, a, c));
        N.push(b);
      }), N;
    }, R = async (n, i) => {
      i.preventDefault(), i.stopPropagation();
      const a = e.getNodeModel(n._nodeId);
      if (!(a != null && a.decontextMenu))
        return;
      const c = e.contextMenus[a.decontextMenu.id];
      if (!c.model.detoolbarItems)
        return;
      await c.calcButtonState(n._deData || (n.srfkey ? n : void 0), a.appDataEntityId);
      const N = c.state.buttonsState, u = _(c.model.detoolbarItems, n, i, N);
      u.length && T.showContextMenu({
        x: i.x,
        y: i.y,
        customClass: t.b("context-menu"),
        items: u
      });
    }, M = (n, i) => {
      var c, N;
      if (!((N = (c = n == null ? void 0 : n.decontextMenu) == null ? void 0 : c.detoolbarItems) != null && N.length))
        return;
      const a = e.contextMenuInfos[n.id];
      return a.clickTBUIActionItem && a.onlyOneActionItem ? null : f(g("iBizContextMenuControl"), {
        modelData: n.decontextMenu,
        groupLevelKeys: [50, 100],
        nodeModel: n,
        nodeData: i,
        context: e.context,
        onActionClick: (u, E) => e.doUIAction(u.uiactionId, i, E, u.appId)
      }, null);
    }, x = (n, i) => {
      const a = w(n._uuid, e);
      if (!a)
        throw new $("没有找到_uuid为".concat(n._uuid, "的节点"));
      e.onExpandChange(a, i);
    }, v = te(() => {
      e.load();
    }, 500), V = (n) => {
      e.state.query = n, v();
    }, k = (n, i, a) => {
      const c = w(n.data._uuid, e), N = w(i.data._uuid, e);
      return e.calcAllowDrop(c, N, a);
    }, q = (n) => {
      const i = w(n.data._uuid, e);
      return e.calcAllowDrag(i);
    }, Q = (n, i, a) => {
      const c = Me(a), N = w(n.data._uuid, e), u = w(i.data._uuid, e);
      e.onNodeDrop(N, u, c);
    }, G = (n) => {
      (n.key === "Enter" || n.keyCode === 13) && (n.stopPropagation(), h()), (n.key === "Escape" || n.keyCode === 27) && (n.stopPropagation(), l());
    }, W = (n) => {
      var i;
      if (n.code === "F2" || n.code === "Enter") {
        const a = (i = o.value) == null ? void 0 : i.getCurrentKey();
        e.updateTreeNode(a);
      }
    }, oe = async () => {
      e.evt.emit("onBack", {}), e.isFilter.value = !1, o.value && o.value.filter("");
    };
    we(() => {
      var n;
      (n = s.value) == null || n.$el.addEventListener("keydown", W), e.evt.on("onFilterNode", async (i) => {
        const {
          nodeTag: a
        } = i;
        a && (e.isFilter.value = !0), o.value && o.value.filter("".concat(a, "@"));
      }), e.evt.on("onResetSate", async () => {
        e.evt.emit("onBack", {}), e.isFilter.value = !1, o.value && o.value.filter("");
      }), e.evt.on("onLoadSuccess", () => {
        e.isFilter.value ? e.evt.emit("onFilterNode", {
          nodeTag: "draft"
        }) : e.evt.emit("onResetSate", {});
      });
    }), xe(() => {
      var n;
      (n = s.value) == null || n.$el.removeEventListener("keydown", W);
    });
    const ie = (n, i) => (i._id || "").includes(n), se = (n) => n._id === "root:draft_parent" ? "draft_parent" : null, J = (n) => {
      if (n.counterId) {
        const i = p[n.counterId];
        return ne(i) || n.counterMode === 1 && i === 0 ? null : f("div", {
          class: t.em("counter", "box")
        }, [f("span", {
          class: t.e("dot")
        }, [Y("·")]), f(g("iBizBadge"), {
          class: t.e("counter"),
          value: i
        }, null)]);
      }
    }, ae = () => e.isFilter.value ? f("div", {
      class: t.b("filter")
    }, [f("div", {
      class: t.be("filter", "header"),
      onClick: oe
    }, [f(g("ion-icon"), {
      name: "arrow-back-outline"
    }, null), Y("返回")])]) : null;
    return {
      c: e,
      ns: t,
      treeRef: o,
      treeviewRef: s,
      treeNodeTextInputRef: d,
      treeData: C,
      treeRefreshKey: r,
      findNodeData: w,
      handleEditKeyDown: G,
      onCheck: U,
      onNodeClick: P,
      onNodeDbClick: L,
      onNodeContextmenu: R,
      loadData: B,
      renderContextMenu: M,
      renderCounter: J,
      updateNodeExpand: x,
      onInput: V,
      allowDrop: k,
      allowDrag: q,
      handleDrop: Q,
      onNodeTextEditBlur: h,
      renderTree: () => {
        var n, i;
        return f("div", {
          class: [t.b("content"), t.is("filter", e.isFilter.value)]
        }, [ae(), f("div", {
          class: [t.b("tree-box"), t.is("filter", e.isFilter.value)]
        }, [f(g("el-tree"), {
          ref: "treeRef",
          key: r.value,
          class: t.is("list-tree", e.renderMode === "listTree"),
          "node-key": "_id",
          "highlight-current": !0,
          "expand-on-click-node": !1,
          "auto-expand-parent": !1,
          "show-checkbox": !e.state.singleSelect,
          "check-strictly": !0,
          "default-expanded-keys": e.state.expandedKeys,
          props: {
            label: "_text",
            children: "_children",
            isLeaf: "_leaf",
            class: se
          },
          lazy: !0,
          load: B,
          onCheck: U,
          onNodeExpand: (a) => {
            x(a, !0);
          },
          onNodeCollapse: (a) => {
            x(a, !1);
          },
          draggable: !0,
          "allow-drop": k,
          "allow-drag": q,
          onNodeDrop: Q,
          "filter-node-method": ie
        }, {
          default: ({
            data: a
          }) => {
            var b, z;
            const c = w(a._uuid, e);
            if (!c)
              return null;
            const N = e.getNodeModel(c._nodeId);
            if (e.state.editingNodeKey === c._id)
              return f("div", {
                class: [t.b("node"), (b = N.sysCss) == null ? void 0 : b.cssName]
              }, [c._icon ? f(m, {
                class: t.be("node", "icon"),
                icon: c._icon
              }, null) : null, f(g("el-input"), {
                modelValue: e.state.editingNodeText,
                "onUpdate:modelValue": (I) => e.state.editingNodeText = I,
                ref: "treeNodeTextInputRef",
                class: t.b("editing-node"),
                onBlur: () => {
                  h();
                },
                onKeydown: (I) => {
                  G(I);
                }
              }, null)]);
            const u = pe(N);
            let E;
            return u ? E = f(g("iBizControlShell"), {
              data: c,
              modelData: u,
              context: e.context,
              params: e.params
            }, null) : E = [c._icon ? f(m, {
              class: t.be("node", "icon"),
              icon: c._icon
            }, null) : null, c._textHtml ? f("span", {
              class: t.be("node", "label"),
              innerHTML: c._textHtml
            }, null) : f("span", {
              class: t.be("node", "label")
            }, [c._text])], f("div", {
              onDblclick: (I) => L(c, I),
              onClick: (I) => P(c, I),
              onContextmenu: (I) => R(c, I),
              class: [t.b("node"), t.is("hidden", Object.is(e.hiddenNodeId, c._nodeId) && !e.isFilter.value), c._leaf ? t.be("node", "item") : t.be("node", "group"), (z = N.sysCss) == null ? void 0 : z.cssName]
            }, [E, J(N), M(N, c)]);
          }
        }), e.state.newingNodeModel ? f("div", {
          class: [t.be("node", "newing")]
        }, [(n = e.state.newingNodeModel) != null && n.sysImage ? f(m, {
          class: t.be("node", "icon"),
          icon: (i = e.state.newingNodeModel) == null ? void 0 : i.sysImage
        }, null) : null, f(g("el-input"), {
          modelValue: e.state.newingNodeText,
          "onUpdate:modelValue": (a) => e.state.newingNodeText = a,
          ref: "treeNodeTextInputRef",
          class: t.b("editing-node"),
          onBlur: h,
          onKeydown: (a) => {
            G(a);
          }
        }, null)]) : null])]);
      }
    };
  },
  render() {
    const e = {
      searchbar: () => this.c.enableQuickSearch ? f(g("el-input"), {
        "model-value": this.c.state.query,
        class: [this.ns.b("quick-search"), this.ns.b("quick-search")],
        placeholder: this.c.state.placeHolder,
        onInput: this.onInput
      }, {
        prefix: () => f(g("ion-icon"), {
          class: this.ns.e("search-icon"),
          name: "search"
        }, null)
      }) : null
    };
    this.c.bottomToolbar && (e.toolbar = () => f(g("iBizControlShell"), {
      modelData: this.c.bottomToolbar,
      context: this.c.context,
      params: this.c.params
    }, null));
    const p = this.c.controlPanel ? "tree" : "default";
    return e[p] = () => {
      if (this.c.state.isLoaded && this.treeRefreshKey)
        return this.renderTree();
    }, Ee(f(g("iBizControlBase"), {
      ref: "treeviewRef",
      controller: this.c
    }, ke(e) ? e : {
      default: () => [e]
    }), [[be("loading"), this.c.state.isLoading]]);
  }
});
class Se {
  constructor() {
    O(this, "component", "IBizGroupTreeControl");
  }
}
const Ue = De(
  H,
  function(e) {
    e.component(H.name, H), Ne(
      "TREE_RENDER_GROUP_TREE",
      () => new Se()
    );
  }
);
export {
  Ue as IBizGroupTreeControl,
  Ue as default
};
