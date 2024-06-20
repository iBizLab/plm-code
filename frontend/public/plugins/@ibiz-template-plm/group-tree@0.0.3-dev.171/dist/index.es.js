import './style.css';
var ue = Object.defineProperty;
var fe = (e, N, t) => N in e ? ue(e, N, { enumerable: !0, configurable: !0, writable: !0, value: t }) : e[N] = t;
var A = (e, N, t) => (fe(e, typeof N != "symbol" ? N + "" : N, t), t);
import { TreeController as he, getChildNodeRSs as pe, calcDeCodeNameById as Z, handleAllSettled as Ne, Srfuf as _e, getControlPanel as me, registerControlProvider as ye } from "@ibiz-template/runtime";
import { useControlController as De, useNamespace as ee, withInstall as ve } from "@ibiz-template/vue3-util";
import { ref as L, defineComponent as Ie, reactive as ge, watch as te, computed as we, nextTick as xe, resolveComponent as g, onMounted as Ee, onUnmounted as be, withDirectives as Ce, createVNode as h, resolveDirective as Te, isVNode as Me, createTextVNode as ne } from "vue";
import { createUUID as oe } from "qx-util";
import { debounce as se } from "lodash-es";
import { RuntimeError as V, RuntimeModelError as ie } from "@ibiz-template/core";
import { isNil as ae } from "ramda";
function w(e, N) {
  const t = N.state.items.find((i) => i._id === e);
  return t || N.state.items.find((i) => i._uuid === e);
}
function Re(e, N) {
  const t = () => {
    const r = e.value;
    if (!r)
      throw new V("找不到el-tree实例对象");
    return r;
  }, i = () => {
    var f;
    const r = e.value;
    if (!r) {
      setTimeout(() => {
        i();
      }, 200);
      return;
    }
    Object.values(r.store.nodesMap).forEach((a) => {
      const v = N.state.expandedKeys.includes(a.data._id);
      v !== a.expanded && (v ? a.expand() : a.collapse());
    }), N.state.singleSelect ? e.value.setCurrentKey(((f = N.state.selectedData[0]) == null ? void 0 : f._id) || void 0) : r.setCheckedKeys(N.state.selectedData.map((a) => a._id));
  }, s = se(i, 500);
  return { getTreeInstance: t, updateUI: s, triggerNodeExpand: (r) => {
    const f = t(), a = f == null ? void 0 : f.store.nodesMap[r];
    if (a)
      return a.expanded ? (a.collapse(), !1) : (a.expand(), !0);
  } };
}
function ke(e) {
  switch (e) {
    case "inner":
      return "inner";
    case "before":
      return "prev";
    case "after":
      return "next";
    default:
      throw new V("暂不支持dropType:".concat(e));
  }
}
class Se extends he {
  constructor() {
    super(...arguments);
    /**
     * 底部工具栏
     *
     * @type {(IControl | undefined)}
     * @memberof GroupTreeController
     */
    A(this, "bottomToolbar");
    /**
     * 隐藏节点id
     *
     * @type {string}
     * @memberof GroupTreeController
     */
    A(this, "hiddenNodeId", "");
    /**
     * 绘制模式
     *
     * @type {('tree' | 'listTree')}
     * @memberof GroupTreeController
     */
    A(this, "renderMode", "tree");
    /**
     * 是否正在过滤
     *
     * @memberof GroupTreeController
     */
    A(this, "isFilter", L(!1));
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
    this.bottomToolbar = t.find((l) => l.name === "toolbar");
    const { ctrlParams: i = {} } = this.model.controlParam;
    i.HIDDENNODEID && (this.hiddenNodeId = i.HIDDENNODEID), i.RENDERMODE && (this.renderMode = i.RENDERMODE);
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
    (t = this.model.detreeNodes) == null || t.forEach((i) => {
      if (!i.allowDrop)
        return;
      const s = [];
      pe(this.model, {
        parentId: i.id,
        hasQuery: !1
      }).forEach((r) => {
        var f;
        if ((f = r.parentDER1N) != null && f.pickupDEFName) {
          const a = this.getNodeModel(r.childDETreeNodeId);
          (a == null ? void 0 : a.treeNodeType) === "DE" && a.appDataEntityId && s.push({
            minorEntityId: a.appDataEntityId,
            pickupDEFName: r.parentDER1N.pickupDEFName.toLowerCase(),
            childDETreeNodeId: r.childDETreeNodeId,
            detreeNodeRSParams: r.detreeNodeRSParams
          });
        }
      }), s.length > 0 && this.dropNodeRss.set(i.id, s);
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
    defaultValue: i
  }) {
    if (!t || t === this.state.editingNodeKey)
      return;
    const s = w(t, this), l = this.getNodeModel(s._nodeId);
    l != null && l.allowEditText && (this.state.editingNodeKey = s._id, this.state.editingNodeText = s._text, this.state.editingNodeDefault = i, this.state.newingNodeModel = null, this.state.newingNodeText = null, this.state.newingNodeDefault = null);
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
    const i = w(t, this), s = {
      context: this.context || {},
      params: this.params || {},
      data: [i]
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
    defaultValue: i = {}
  }) {
    const s = this.getNodeModel(t);
    this.state.newingNodeModel = s, this.state.newingNodeDefault = i, this.state.editingNodeKey = null, this.state.editingNodeText = null, this.state.editingNodeDefault = null;
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
    const i = ibiz.hub.getApp(this.context.srfappid);
    await Promise.all(
      t.map(async (s) => {
        const l = this.getNodeModel(s._nodeId), r = s._deData, f = this.context.clone();
        (await i.deService.exec(
          l.appDataEntityId,
          "create",
          f,
          r
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
    const { textAppDEFieldId: t, id: i } = this.state.newingNodeModel, s = this.state.newingNodeText, l = { _deData: {} };
    Object.assign(l, { _nodeId: i, _text: s }), Object.assign(l._deData, { [t]: s }), this.state.newingNodeDefault && Object.assign(l._deData, this.state.newingNodeDefault), Object.assign(l._deData, { [t]: s }), await this.createDeNodeData([l]), this.state.newingNodeModel = null, this.state.newingNodeText = null, this.state.newingNodeDefault = null;
  }
  /**
   * 修改节点文本
   * @param nodeData 节点数据
   * @param _text 节点文本
   */
  async onModifyTreeNode(t, i) {
    const s = this.getNodeModel(t._nodeId);
    if (!s.allowEditText)
      throw new ie(s, "树节点没有配置编辑模式：名称");
    if (t._nodeType !== "DE")
      throw new V("不是实体树节点数据");
    if (t._text !== i) {
      if (t._text = i, this.state.editingNodeDefault) {
        const l = Object.keys(this.state.editingNodeDefault);
        l && l.length > 0 && l.forEach((r) => {
          ae(t._deData[r]) && (t._deData[r] = this.state.editingNodeDefault[r]);
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
    const { context: i, params: s, data: l } = this.handlerAbilityParams(t), r = this.getNodeModel(l[0]._nodeId);
    if ((t == null ? void 0 : t.silent) !== !0 && !await ibiz.confirm.error({
      title: "数据删除",
      desc: "确认删除数据？"
    }))
      return;
    await this._evt.emit("onBeforeRemove", void 0), await this.startLoading();
    let f = !1;
    try {
      const a = Z(
        r.appDataEntityId
      );
      await Ne(
        l.map(async (v) => {
          if (v.srfuf !== _e.CREATE) {
            const M = i.clone();
            M[a] = v.srfkey, await await ibiz.hub.getApp(r.appId).deService.exec(
              r.appDataEntityId,
              "remove",
              M,
              l,
              s
            ), f = !0;
          }
          this.afterRemove(v);
        })
      ), (t == null ? void 0 : t.silent) !== !0 && this.actionNotification("REMOVESUCCESS", {
        data: l,
        default: "数据[".concat(l.map((v) => v.srfmajortext).join("、"), "]删除成功!")
      }), f && !(t != null && t.notRefresh) && await this.refresh();
    } catch (a) {
      throw await this._evt.emit("onRemoveError", void 0), this.actionNotification("REMOVEERROR", {
        error: a,
        data: l
      }), a;
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
  calcAllowDrop(t, i, s) {
    var r, f;
    const l = this.getNodeModel(t._nodeId);
    if (s === "inner")
      return !!this.findDropNodeRS(
        i._nodeId,
        l.appDataEntityId
      );
    if (((r = t._parent) == null ? void 0 : r._id) === ((f = i._parent) == null ? void 0 : f._id)) {
      const a = this.getNodeModel(i._nodeId);
      return (a == null ? void 0 : a.allowOrder) === !0;
    }
    return i._parent ? i._parent && i._parent._id && this.getNodeModel(i._parent._nodeId).rootNode ? !0 : !!this.findDropNodeRS(
      i._parent._nodeId,
      l.appDataEntityId
    ) : !1;
  }
  /**
   * 处理节点拖入事件
   * @param draggingNode
   * @param dropNode
   * @param dropType
   */
  async onNodeDrop(t, i, s) {
    var k, F, P;
    s === "inner" && !i._leaf && i._children === void 0 && await this.expandNodeByKey([i._id]);
    const l = s !== "inner", r = [], f = this.getNodeModel(t._nodeId), a = s === "inner" ? i : i._parent;
    let v = !1;
    this.getNodeModel(a._nodeId).rootNode && (v = !0);
    const O = (a == null ? void 0 : a._id) !== ((k = t._parent) == null ? void 0 : k._id);
    let C = this.getNodeModel(i._nodeId);
    if (s === "inner" || ((F = i._parent) == null ? void 0 : F._id) !== ((P = t._parent) == null ? void 0 : P._id) || v) {
      const _ = [];
      for (const I of this.dropNodeRss.values())
        _.push(
          ...I.filter((m) => (
            // 修复子关系情况，根上也存在当前实体数据
            m.minorEntityId === f.appDataEntityId
          ))
        );
      if (v && O)
        _ && (_.forEach((I) => {
          t._deData[I.pickupDEFName] = null;
        }), r.push(t), C = this.getNodeModel(f.id));
      else {
        const I = this.findDropNodeRS(
          a._nodeId,
          f.appDataEntityId
        );
        I && (_ && _.forEach((m) => {
          t._deData[m.pickupDEFName] = null;
        }), t._deData[I.pickupDEFName] = a._value, I.detreeNodeRSParams && I.detreeNodeRSParams.forEach((m) => {
          var T, b;
          m.name && m.value && ((T = t._deData) != null && T.hasOwnProperty(
            m.name.toLowerCase()
          )) && ((b = a._deData) != null && b.hasOwnProperty(m.value.toLowerCase())) && (t._deData[m.name.toLowerCase()] = a._deData[m.value.toLowerCase()]);
        }), r.push(t), C = this.getNodeModel(I.childDETreeNodeId));
      }
    }
    const R = t._parent._children;
    if (R.splice(R.indexOf(t), 1), s === "inner")
      i._children || (i._children = [], i._leaf = !0, this.state.expandedKeys.push(i._id)), i._children.push(t);
    else {
      let _ = a._children.indexOf(i);
      s === "next" && (_ += 1), a._children.splice(_, 0, t);
    }
    (s === "inner" || O) && (t._parent = a, t._nodeId = C.id, this.state.expandedKeys = this.calcExpandedKeys([a]));
    const { sortAppDEFieldId: K, sortDir: B, allowOrder: z } = C;
    if (z === !0) {
      if (!K)
        throw new ie(C, "缺少配置排序属性");
      const _ = K.toLowerCase(), I = B === "ASC", m = [...a._children].filter(
        (D) => D._nodeType === "DE"
      );
      I || m.reverse();
      const T = (D) => D + (100 - D % 100), b = (D) => D[_] || 0;
      let x;
      m.forEach((D, j) => {
        const S = D._deData;
        x === void 0 ? D === t && (j === 0 ? x = 100 : x = T(b(m[j - 1]._deData)), S[_] = x, r.indexOf(D) === -1 && r.push(D)) : (x >= b(S) && (S[_] = T(x), r.push(D)), x = b(S));
      });
    }
    await this.updateDeNodeData(r), this._evt.emit("onAfterNodeDrop", { isChangedParent: O }), this.refreshNodeChildren(i, l), this.state.selectedData = [];
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
    var l;
    if (t.triggerKey === this.triggerKey)
      return;
    const i = t.data;
    if (t.subtype === "OBJECTCREATED") {
      ((l = this.model.detreeNodes) == null ? void 0 : l.find((f) => {
        if (f.appDataEntityId) {
          const a = Z(f.appDataEntityId);
          if (i.srfdecodename === a)
            return !0;
        }
        return !1;
      })) && this.refresh();
      return;
    }
    const s = this.state.items.find(
      (r) => r._nodeType === "DE" && r._deData && r._deData.srfdecodename === i.srfdecodename && r._deData.srfkey === i.srfkey
    );
    s && this.doNextActive(() => this.refreshNodeChildren(s, !0), {
      key: "refresh".concat(s._id)
    });
  }
  async afterLoad(t, i) {
    return super.afterLoad(t, i);
  }
  /**
   * 重写节点点击事件
   *
   * @param {ITreeNodeData} nodeData
   * @param {MouseEvent} event
   * @return {*}  {Promise<void>}
   * @memberof GroupTreeController
   */
  async onTreeNodeClick(t, i) {
    var l;
    const s = (l = this.contextMenuInfos[t._nodeId]) == null ? void 0 : l.clickTBUIActionItem;
    if (s)
      return this.doUIAction(
        s.uiactionId,
        t,
        i,
        s.appId
      );
    if (this.state.navigational) {
      const r = this.getNodeModel(t._nodeId);
      if (!(r != null && r.navAppViewId))
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
function Ae(e) {
  return typeof e == "function" || Object.prototype.toString.call(e) === "[object Object]" && !Me(e);
}
const G = /* @__PURE__ */ Ie({
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
    const e = De((...n) => new Se(...n)), N = ge({});
    e.evt.on("onCreated", () => {
      e.counter && e.counter.onChange((n) => {
        Object.assign(N, n);
      }, !0);
    });
    const t = ee("control-group-tree"), i = ee("control-".concat(e.model.controlType.toLowerCase())), s = L(null), l = L(null), r = L(""), f = L(null);
    te(() => f.value, (n) => {
      n && n.$el.getElementsByTagName("input")[0].focus();
    });
    const a = async () => {
      if (e.state.editingNodeKey)
        if (e.state.editingNodeText) {
          const n = w(e.state.editingNodeKey, e);
          await e.onModifyTreeNode(n, e.state.editingNodeText);
        } else
          e.state.editingNodeKey = null;
      e.state.newingNodeText ? e.onCreateTreeNode() : e.state.newingNodeModel = null;
    }, v = async () => {
      e.state.editingNodeKey && (e.state.editingNodeKey = null), e.state.newingNodeModel && (e.state.newingNodeModel = null, e.state.newingNodeText = "");
    }, {
      updateUI: M,
      triggerNodeExpand: O
    } = Re(s, e), C = (n) => n.map((o) => ({
      _id: o._id,
      _uuid: o._uuid,
      _leaf: o._leaf,
      _text: o._text
    }));
    e.evt.on("onAfterRefreshParent", (n) => {
      if (s.value) {
        const {
          parentNode: o,
          children: d
        } = n, u = C(d);
        s.value.updateKeyChildren(o._id, u), M();
      }
    }), e.evt.on("onAfterNodeDrop", (n) => {
      n.isChangedParent && (r.value = oe());
    });
    const R = we(() => e.state.isLoaded ? e.model.rootVisible ? e.state.rootNodes : e.state.rootNodes.reduce((n, o) => o._children ? n.concat(o._children) : n, []) : []);
    te(R, (n, o) => {
      n !== o && (r.value = oe());
    });
    const K = async (n, o) => {
      let d;
      if (n.level === 0)
        d = R.value, ibiz.log.debug("初始加载");
      else {
        const u = w(n.data._uuid, e);
        u._children ? (ibiz.log.debug("节点展开加载-本地", u), d = u._children) : (ibiz.log.debug("节点展开加载-远程", u), d = await e.loadNodes(u));
      }
      ibiz.log.debug("给树返回值", d), o(C(d)), M();
    };
    let B = !1;
    e.evt.on("onLoadSuccess", () => {
      B = !0, setTimeout(() => {
        B = !1;
      }, 200);
    }), e.evt.on("onSelectionChange", async () => {
      var n;
      B && await xe(), e.state.singleSelect ? s.value.setCurrentKey(((n = e.state.selectedData[0]) == null ? void 0 : n._id) || void 0) : s.value.setCheckedKeys(e.state.selectedData.map((o) => o._id));
    });
    const z = (n, o) => {
      const {
        checkedNodes: d
      } = o;
      e.setSelection(d);
    };
    let k = !1;
    const F = (n, o) => {
      var d, u, p;
      if (o.stopPropagation(), !k) {
        if (((d = s.value) == null ? void 0 : d.getCurrentKey()) === n._id) {
          const c = (u = s.value) == null ? void 0 : u.getCurrentKey();
          e.updateTreeNode({
            nodeKey: c,
            defaultValue: {}
          });
        }
        if (e.state.singleSelect || (p = s.value) == null || p.setCurrentKey(n._id), e.state.navigational) {
          const c = e.getNodeModel(n._nodeId);
          if (!(c != null && c.navAppViewId)) {
            const E = O(n._id);
            e.onExpandChange(n, E);
          }
        }
        e.onTreeNodeClick(n, o), k = !0, setTimeout(() => {
          k = !1;
        }, 200);
      }
    }, P = (n, o) => {
      o.stopPropagation(), e.onDbTreeNodeClick(n);
    };
    let _;
    e.evt.on("onMounted", () => {
      Object.values(e.contextMenus).length > 0 && (() => import("@imengyu/vue3-context-menu"))().then((o) => {
        _ = o.default, _.default && !_.showContextMenu && (_ = _.default);
      });
    });
    const I = g("IBizRawItem"), m = g("IBizIcon"), T = (n, o, d, u) => {
      const p = [];
      return n.forEach((c) => {
        var Y;
        if (c.itemType === "SEPERATOR") {
          p.push({
            divided: "self"
          });
          return;
        }
        const E = u[c.id];
        if (E && !E.visible || c.actionLevel > 100)
          return;
        const y = {};
        if (c.showCaption && c.caption && (y.label = c.caption), c.sysImage && c.showIcon && (y.icon = h(m, {
          icon: c.sysImage
        }, null)), c.itemType === "DEUIACTION") {
          y.disabled = E.disabled, y.clickClose = !0;
          const {
            uiactionId: U
          } = c;
          U && (y.onClick = () => {
            e.doUIAction(U, o, d, c.appId);
          });
        } else if (c.itemType === "RAWITEM") {
          const {
            rawItem: U
          } = c;
          U && (y.label = h(I, {
            rawItem: c
          }, null));
        } else
          c.itemType === "ITEMS" && (Y = c.detoolbarItems) != null && Y.length && (y.children = T(c.detoolbarItems, o, d, u));
        p.push(y);
      }), p;
    }, b = async (n, o) => {
      o.preventDefault(), o.stopPropagation();
      const d = e.getNodeModel(n._nodeId);
      if (!(d != null && d.decontextMenu))
        return;
      const u = e.contextMenus[d.decontextMenu.id];
      if (!u.model.detoolbarItems)
        return;
      await u.calcButtonState(n._deData || (n.srfkey ? n : void 0), d.appDataEntityId);
      const p = u.state.buttonsState, c = T(u.model.detoolbarItems, n, o, p);
      c.length && _.showContextMenu({
        x: o.x,
        y: o.y,
        customClass: t.b("context-menu"),
        items: c
      });
    }, x = (n, o) => {
      var u, p;
      if (!((p = (u = n == null ? void 0 : n.decontextMenu) == null ? void 0 : u.detoolbarItems) != null && p.length))
        return;
      const d = e.contextMenuInfos[n.id];
      return d.clickTBUIActionItem && d.onlyOneActionItem ? null : h(g("iBizContextMenuControl"), {
        modelData: n.decontextMenu,
        groupLevelKeys: [50, 100],
        nodeModel: n,
        nodeData: o,
        context: e.context,
        onActionClick: (c, E) => e.doUIAction(c.uiactionId, o, E, c.appId)
      }, null);
    }, D = (n, o) => {
      const d = w(n._uuid, e);
      if (!d)
        throw new V("没有找到_uuid为".concat(n._uuid, "的节点"));
      e.onExpandChange(d, o);
    }, j = se(() => {
      e.load();
    }, 500), S = (n) => {
      e.state.query = n, j();
    }, H = (n, o, d) => {
      const u = w(n.data._uuid, e), p = w(o.data._uuid, e);
      return e.calcAllowDrop(u, p, d);
    }, q = (n) => {
      const o = w(n.data._uuid, e);
      return e.calcAllowDrag(o);
    }, Q = (n, o, d) => {
      const u = ke(d), p = w(n.data._uuid, e), c = w(o.data._uuid, e);
      e.onNodeDrop(p, c, u);
    }, $ = (n) => {
      (n.key === "Enter" || n.keyCode === 13) && (n.stopPropagation(), a()), (n.key === "Escape" || n.keyCode === 27) && (n.stopPropagation(), v());
    }, W = (n) => {
      var o;
      if (n.code === "F2" || n.code === "Enter") {
        const d = (o = s.value) == null ? void 0 : o.getCurrentKey();
        e.updateTreeNode(d);
      }
    }, re = async () => {
      e.evt.emit("onBack", {}), e.isFilter.value = !1, s.value && s.value.filter("");
    };
    Ee(() => {
      var n;
      (n = l.value) == null || n.$el.addEventListener("keydown", W), e.evt.on("onFilterNode", async (o) => {
        const {
          nodeTag: d
        } = o;
        d && (e.isFilter.value = !0), s.value && s.value.filter("".concat(d, "@"));
      }), e.evt.on("onResetSate", async () => {
        e.evt.emit("onBack", {}), e.isFilter.value = !1, s.value && s.value.filter("");
      }), e.evt.on("onLoadSuccess", () => {
        e.isFilter.value ? e.evt.emit("onFilterNode", {
          nodeTag: "draft"
        }) : e.evt.emit("onResetSate", {});
      });
    }), be(() => {
      var n;
      (n = l.value) == null || n.$el.removeEventListener("keydown", W);
    });
    const de = (n, o) => (o._id || "").includes(n), le = (n) => n._id === "root:draft_parent" ? "draft_parent" : null, J = (n) => {
      if (n.counterId) {
        const o = N[n.counterId];
        return ae(o) || n.counterMode === 1 && o === 0 ? null : h("div", {
          class: t.em("counter", "box")
        }, [h("span", {
          class: t.e("dot")
        }, [ne("·")]), h(g("iBizBadge"), {
          class: t.e("counter"),
          value: o
        }, null)]);
      }
    }, ce = () => e.isFilter.value ? h("div", {
      class: t.b("filter")
    }, [h("div", {
      class: t.be("filter", "header"),
      onClick: re
    }, [h(g("ion-icon"), {
      name: "arrow-back-outline"
    }, null), ne("返回")])]) : null, X = (n) => {
      var d, u;
      if (!e.state.newingNodeModel)
        return null;
      const {
        parent_id: o
      } = e.state.newingNodeDefault || {};
      if (o) {
        if (!n)
          return null;
        const {
          _value: p
        } = n || {};
        if (p !== o)
          return null;
      }
      return !o && n ? null : h("div", {
        class: [t.be("node", "newing")]
      }, [(d = e.state.newingNodeModel) != null && d.sysImage ? h(m, {
        class: t.be("node", "icon"),
        icon: (u = e.state.newingNodeModel) == null ? void 0 : u.sysImage
      }, null) : null, h(g("el-input"), {
        modelValue: e.state.newingNodeText,
        "onUpdate:modelValue": (p) => e.state.newingNodeText = p,
        ref: "treeNodeTextInputRef",
        class: t.b("editing-node"),
        onBlur: a,
        onKeydown: (p) => {
          $(p);
        }
      }, null)]);
    };
    return {
      c: e,
      ns: t,
      treeRef: s,
      treeviewRef: l,
      treeNodeTextInputRef: f,
      treeData: R,
      treeRefreshKey: r,
      findNodeData: w,
      handleEditKeyDown: $,
      onCheck: z,
      onNodeClick: F,
      onNodeDbClick: P,
      onNodeContextmenu: b,
      loadData: K,
      renderContextMenu: x,
      renderCounter: J,
      updateNodeExpand: D,
      onInput: S,
      allowDrop: H,
      allowDrag: q,
      handleDrop: Q,
      onNodeTextEditBlur: a,
      renderTree: () => h("div", {
        class: [t.b("content"), t.is("filter", e.isFilter.value)]
      }, [ce(), h("div", {
        class: [t.b("tree-box"), t.is("filter", e.isFilter.value)]
      }, [h(g("el-tree"), {
        ref: "treeRef",
        key: r.value,
        class: [i.b("tree"), t.is("list-tree", e.renderMode === "listTree")],
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
          class: le
        },
        lazy: !0,
        load: K,
        onCheck: z,
        onNodeExpand: (n) => {
          D(n, !0);
        },
        onNodeCollapse: (n) => {
          D(n, !1);
        },
        draggable: !0,
        "allow-drop": H,
        "allow-drag": q,
        onNodeDrop: Q,
        "filter-node-method": de
      }, {
        default: ({
          data: n
        }) => {
          var c, E;
          const o = w(n._uuid, e);
          if (!o)
            return null;
          const d = e.getNodeModel(o._nodeId);
          if (e.state.editingNodeKey === o._id)
            return h("div", {
              class: [t.b("node"), (c = d.sysCss) == null ? void 0 : c.cssName]
            }, [o._icon ? h(m, {
              class: t.be("node", "icon"),
              icon: o._icon
            }, null) : null, h(g("el-input"), {
              modelValue: e.state.editingNodeText,
              "onUpdate:modelValue": (y) => e.state.editingNodeText = y,
              ref: "treeNodeTextInputRef",
              class: t.b("editing-node"),
              onBlur: () => {
                a();
              },
              onKeydown: (y) => {
                $(y);
              }
            }, null)]);
          const u = me(d);
          let p;
          return u ? p = h(g("iBizControlShell"), {
            data: o,
            modelData: u,
            context: e.context,
            params: e.params
          }, null) : p = [o._icon ? h(m, {
            class: t.be("node", "icon"),
            icon: o._icon
          }, null) : null, o._textHtml ? h("span", {
            class: t.be("node", "label"),
            innerHTML: o._textHtml
          }, null) : h("span", {
            class: t.be("node", "label")
          }, [o._text])], [h("div", {
            onDblclick: (y) => P(o, y),
            onClick: (y) => F(o, y),
            onContextmenu: (y) => b(o, y),
            class: [t.b("node"), t.is("hidden", Object.is(e.hiddenNodeId, o._nodeId) && !e.isFilter.value), o._leaf ? t.be("node", "item") : t.be("node", "group"), (E = d.sysCss) == null ? void 0 : E.cssName]
          }, [p, J(d), x(d, o)]), X(o)];
        }
      }), X()])])
    };
  },
  render() {
    const e = {
      searchbar: () => this.c.enableQuickSearch ? h(g("el-input"), {
        "model-value": this.c.state.query,
        class: this.ns.b("quick-search"),
        placeholder: this.c.state.placeHolder,
        onInput: this.onInput
      }, {
        prefix: () => h(g("ion-icon"), {
          class: this.ns.e("search-icon"),
          name: "search"
        }, null)
      }) : null
    };
    this.c.bottomToolbar && (e.toolbar = () => h(g("iBizControlShell"), {
      modelData: this.c.bottomToolbar,
      context: this.c.context,
      params: this.c.params
    }, null));
    const N = this.c.controlPanel ? "tree" : "default";
    return e[N] = () => {
      if (this.c.state.isLoaded && this.treeRefreshKey)
        return this.renderTree();
    }, Ce(h(g("iBizControlBase"), {
      ref: "treeviewRef",
      controller: this.c
    }, Ae(e) ? e : {
      default: () => [e]
    }), [[Te("loading"), this.c.state.isLoading]]);
  }
});
class Oe {
  constructor() {
    A(this, "component", "IBizGroupTreeControl");
  }
}
const $e = ve(
  G,
  function(e) {
    e.component(G.name, G), ye(
      "TREE_RENDER_GROUP_TREE",
      () => new Oe()
    );
  }
);
export {
  $e as IBizGroupTreeControl,
  $e as default
};
