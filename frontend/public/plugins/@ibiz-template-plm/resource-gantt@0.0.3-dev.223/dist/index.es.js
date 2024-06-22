import './style.css';
var ke = Object.defineProperty;
var Se = (a, t, e) => t in a ? ke(a, t, { enumerable: !0, configurable: !0, writable: !0, value: e }) : a[t] = e;
var $ = (a, t, e) => (Se(a, typeof t != "symbol" ? t + "" : t, e), e);
import { TreeGridExRowState as ae, TreeGridExFieldColumnController as Ne, GanttService as Re, getChildNodeRSs as Te, GanttController as Ee, calcDeCodeNameById as Z, Srfuf as Le, TreeGridExNotifyState as Me, isValueChange as Ae, registerPanelItemProvider as Oe, registerControlProvider as Ve } from "@ibiz-template/runtime";
import { useNamespace as A, PanelRawItemController as ze, withInstall as oe, useControlController as Be } from "@ibiz-template/vue3-util";
import { defineComponent as B, createVNode as i, ref as k, computed as T, watch as se, createTextVNode as Pe, resolveComponent as x, isVNode as je, getCurrentInstance as Ge, onMounted as qe, withDirectives as $e, resolveDirective as We, h as He } from "vue";
import { createUUID as Fe } from "qx-util";
import _ from "dayjs";
import { isObject as Ye } from "lodash-es";
import { isNotNil as Ue } from "ramda";
import { ModelError as Ke, RuntimeError as ee, awaitTimeout as Je } from "@ibiz-template/core";
function Qe(a, t, e) {
  const n = _(a), s = _(t), o = _(e);
  if (!(n instanceof _) || !(s instanceof _) || !(o instanceof _))
    throw new Error("All arguments must be dayjs objects");
  return n.isAfter(s) && n.isBefore(o) || n.isSame(s) || n.isSame(o);
}
const Xe = (a) => {
  const t = new Date(a), e = _(t).day();
  return [
    "星期日",
    "星期一",
    "星期二",
    "星期三",
    "星期四",
    "星期五",
    "星期六"
  ][e];
}, Ze = (a, t) => _(a).format(t), et = (a) => {
  const t = new Date(a), e = _(t), n = _();
  return e.isSame(n, "day");
}, tt = (a, t, e) => _(a).isSame(_(t), e), F = (a, t) => a.replace(/\${(.*?)}/g, (e, n) => {
  const [s, o] = n.split("."), d = t[s] || "";
  return Ye(d) ? d[o] ? d[o] : "" : d;
}), ie = (a, t) => {
  const n = _(a).day();
  return t.includes(n);
}, te = (a, t) => {
  let e = [], n = 0;
  const s = F(
    t,
    a.data && a.data._deData ? a.data._deData : {}
  ), o = JSON.parse(s);
  return o.weekdays && (e = o.weekdays.split("").map((d) => Number(d))), o.dayCapacityVal && (n = Number(o.dayCapacityVal)), { weekdays: e, dayCapacity: n };
}, re = (a, t = []) => {
  const e = _(a).startOf("day");
  return t.filter((n) => {
    const s = n._beginDataItemValue ? _(n._beginDataItemValue).startOf("day") : null, o = n._endDataItemValue ? _(n._endDataItemValue).startOf("day") : null;
    return s && o && s.isAfter(o) ? !1 : !s && o && e.isSame(o, "day") || s && !o && e.isSame(s, "day") || s && o && Qe(e, s, o);
  }).length;
};
const nt = /* @__PURE__ */ B({
  name: "TopLevelCell",
  props: {
    cellData: {
      type: Object,
      required: !0,
      default: () => {
      }
    },
    showText: {
      type: Boolean,
      required: !0,
      default: !0
    },
    capacityCalc: {
      type: Object,
      required: !0,
      default: () => {
      }
    },
    weekdays: {
      type: Array,
      default: () => []
    },
    dayCapacity: {
      type: Number,
      default: 0
    }
  },
  emits: ["cellClick"],
  setup(a, {
    emit: t
  }) {
    const e = A("top-level-cell"), n = (p) => {
      p.stopPropagation(), t("cellClick", a.cellData);
    }, s = (p, y, g = 100) => {
      const b = p / y * g, I = g - b;
      return "polygon(0px ".concat(I, "%, 100% ").concat(I, "%, 100% ").concat(g, "%, 0px ").concat(g, "%)");
    }, o = (p, y) => {
      const g = {};
      return p < y && Object.assign(g, {
        "clip-path": s(p, y)
      }), g;
    }, d = (p, y) => {
      let g = [];
      return p === 0 ? [] : (p > y && (g = [e.em("caption", "exceed")]), p === y && (g = [e.em("caption", "saturation")]), p < y && (g = [e.em("caption", "standard")]), g);
    }, l = () => {
      const {
        column: p,
        row: y
      } = a.cellData;
      switch (a.capacityCalc.calcType) {
        case "WORKITEMCOUNT":
          return re(p.date, y.data._children);
      }
    };
    return {
      ns: e,
      renderContent: () => {
        const {
          column: p
        } = a.cellData;
        if (!p)
          return "";
        const y = l() || 0, g = o(y, a.dayCapacity), b = d(y, a.dayCapacity);
        return i("div", {
          class: [e.e("caption"), ...b],
          onClick: (I) => n(I)
        }, [a.showText ? i("span", {
          class: [e.em("caption", "text")]
        }, [String(y)]) : "", i("div", {
          class: [e.em("caption", "bkg")],
          style: g
        }, null)]);
      }
    };
  },
  render() {
    return i("div", {
      class: this.ns.b()
    }, [this.renderContent()]);
  }
});
const at = /* @__PURE__ */ B({
  name: "TotalProgress",
  props: {
    row: {
      type: ae,
      required: !0
    },
    weekdays: {
      type: Array,
      default: () => []
    },
    dayCapacity: {
      type: Number,
      default: 0
    },
    capacityCalc: {
      type: Object,
      required: !0,
      default: () => {
      }
    },
    dateRange: {
      type: Object,
      required: !0,
      default: () => {
      }
    }
  },
  setup(a) {
    const t = A("total-progress"), e = k(0), n = k(0), s = T(() => e.value / n.value * 100), o = (l, h) => {
      const {
        start: p,
        end: y
      } = a.dateRange;
      let g = 0, b = 0, I = 0;
      if (h.length > 0) {
        const S = new Date(p);
        for (; S <= new Date(y); )
          ie(S, a.weekdays) && (g += 1, b += re(S, h)), S.setDate(S.getDate() + 1);
        I = g * l;
      }
      return {
        numerator: b,
        denominator: I
      };
    }, d = () => {
      switch (a.capacityCalc.calcType) {
        case "WORKITEMCOUNT":
          return o(a.dayCapacity, a.row.data._children);
        default:
          return {
            numerator: 0,
            denominator: 0
          };
      }
    };
    return se(() => a.row, () => {
      const l = d();
      e.value = l.numerator, n.value = l.denominator;
    }, {
      immediate: !0,
      deep: !0
    }), {
      ns: t,
      numerator: e,
      denominator: n,
      percentage: s
    };
  },
  render() {
    return i("div", {
      class: this.ns.b()
    }, [i("span", {
      class: this.ns.e("caption")
    }, [this.numerator, Pe(" / "), this.denominator]), i(x("el-progress"), {
      percentage: this.percentage
    }, null)]);
  }
});
const ot = /* @__PURE__ */ B({
  name: "IBizResourceGanttExFieldColumn",
  props: {
    controller: {
      type: Ne,
      required: !0
    },
    row: {
      type: ae,
      required: !0
    },
    parentRow: {
      type: Object
    },
    column: {
      type: Object
    },
    weekdays: {
      type: Array,
      default: () => []
    },
    dayCapacity: {
      type: Number,
      default: 0
    },
    capacityCalc: {
      type: Object,
      required: !0,
      default: () => {
      }
    },
    groupConfig: {
      type: Object,
      required: !0,
      default: () => {
      }
    },
    dateRange: {
      type: Object,
      required: !0,
      default: () => {
      }
    },
    level: {
      type: Number,
      default: 0
    }
  },
  setup(a) {
    const t = A("tree-grid-ex-field-column"), e = A("resource-gantt-ex-field-column"), n = T(() => a.controller.nodeColumnControllerMap.get(a.row.data._nodeId)), s = T(() => a.row.data._nodeType !== "DE" && a.controller.isFirstShowColumn ? a.row.data._text : a.row.data[a.controller.name]), o = k(""), d = (C) => {
      o.value = C;
    }, l = T(() => {
      const C = n.value;
      return C ? C.nodeEditItem ? void 0 : C.codeList ? o.value : C.formatValue(s.value) + (C.unitName || "") : s.value;
    }), h = T(() => {
      if (a.controller.treeGrid.overflowMode === "ellipsis" && Ue(s.value) && s.value !== "")
        return l.value;
    }), p = T(() => s.value && n.value && (n.value.isLinkColumn || n.value.hasClickAction)), y = (C) => {
      var u;
      (u = n.value) == null || u.onTextClick(a.row, C);
    }, g = async (C, u) => {
      var D;
      await ((D = n.value) == null ? void 0 : D.onActionClick(C, a.row, u));
    }, b = (C, u, D) => {
      const {
        data: N
      } = C;
      if (N && N._children && N._children.length > 1) {
        const E = N._children.find((L) => u.data && L._deData && u.data._deData && L._deData[D.groupField] === u.data._deData[D.groupField]);
        return E && u.data._id === E._id;
      }
      return !1;
    }, I = (C, u, D) => {
      const {
        data: N
      } = C;
      return N && N._children && N._children.length > 1 ? N._children.reduce((E, L) => u.data && L._deData && u.data._deData && L._deData[D.groupField] === u.data._deData[D.groupField] ? E + 1 : E, 0) : 0;
    }, S = T(() => {
      let C = "";
      const {
        parentRow: u,
        row: D,
        level: N
      } = a;
      return N > 1 && u && I(u, D, a.groupConfig) > 1 && (C = b(u, D, a.groupConfig) ? "first-index" : "no-first-index"), C;
    }), v = T(() => {
      const C = {}, {
        level: u,
        parentRow: D,
        row: N
      } = a;
      if (u && u > 1 && D) {
        const E = I(D, N, a.groupConfig);
        if (E > 1) {
          const q = 46 * E - 5;
          Object.assign(C, {
            height: "".concat(q, "px")
          });
        }
      }
      return C;
    });
    return {
      ns: t,
      ns2: e,
      nodeColumn: n,
      fieldValue: s,
      showText: l,
      clickable: p,
      tooltip: h,
      calcMergeClass: S,
      calcMergeStyle: v,
      onInfoTextChange: d,
      onTextClick: y,
      onActionClick: g
    };
  },
  render() {
    var n, s, o, d, l, h, p;
    let a = null;
    (n = this.nodeColumn) != null && n.nodeEditItem ? a = i(x("iBizTreeGridExEditColumn"), {
      controller: this.nodeColumn,
      row: this.row
    }, null) : (s = this.nodeColumn) != null && s.codeList ? a = i(x("iBizCodeList"), {
      class: this.ns.e("text"),
      codeListItems: this.nodeColumn.codeListItems,
      codeList: this.nodeColumn.codeList,
      value: this.fieldValue,
      onClick: this.onTextClick,
      onInfoTextChange: this.onInfoTextChange,
      title: this.tooltip
    }, null) : a = i("span", {
      class: this.ns.e("text"),
      title: this.tooltip,
      onClick: this.onTextClick
    }, [this.showText]);
    let t;
    this.$slots.actions ? t = this.$slots.actions() : this.row.columnActionsStates[this.controller.name] && (t = i(ut, {
      class: this.ns.e("toolbar"),
      actionDetails: (o = this.nodeColumn) == null ? void 0 : o.nodeColumn.deuiactionGroup.uiactionGroupDetails,
      actionsState: this.row.columnActionsStates[this.controller.name],
      mode: "dropdown",
      popperClass: this.ns2.b("popper"),
      groupLevelKeys: [],
      onActionClick: this.onActionClick
    }, null));
    let e = null;
    return this.level === 1 && (e = i(at, {
      row: this.row,
      weekdays: this.weekdays,
      dayCapacity: this.dayCapacity,
      capacityCalc: this.capacityCalc,
      dateRange: this.dateRange
    }, null)), i("div", {
      class: [this.ns.b(), this.ns2.b(), this.clickable && this.ns.m("clickable"), this.ns.m(this.controller.treeGrid.overflowMode), (d = this.controller.model.cellSysCss) == null ? void 0 : d.cssName, this.ns.is("has-action", !!t), (l = this.row) != null && l.data._children && ((p = (h = this.row) == null ? void 0 : h.data._children) == null ? void 0 : p.length) === 0 ? "no-children" : "", this.calcMergeClass],
      style: this.calcMergeStyle
    }, [i("div", {
      class: [this.ns.b("text-container"), this.ns2.b("text-container")]
    }, [a]), t, e]);
  }
}), ne = () => i("svg", {
  viewBox: "0 0 16 16",
  xmlns: "http://www.w3.org/2000/svg",
  height: "1em",
  width: "1em",
  focusable: "false"
}, [i("g", {
  "stroke-width": "1",
  "fill-rule": "evenodd"
}, [i("path", {
  d: "M6.751 12.303A5.557 5.557 0 0 1 1.2 6.751C1.2 3.691 3.69 1.2 6.751 1.2a5.558 5.558 0 0 1 5.551 5.551 5.557 5.557 0 0 1-5.551 5.552M6.751 0a6.751 6.751 0 1 0 4.309 11.949l3.855 3.855a.6.6 0 1 0 .849-.849l-3.854-3.853A6.751 6.751 0 0 0 6.751 0"
}, null)])]), st = () => i("svg", {
  viewBox: "0 0 16 16",
  xmlns: "http://www.w3.org/2000/svg",
  height: "1em",
  width: "1em",
  focusable: "false"
}, [i("g", {
  "stroke-width": "1",
  "fill-rule": "evenodd"
}, [i("g", {
  transform: "translate(3.347 1.67)"
}, [i("path", {
  d: "M8.31 4.544l-3.858-3.01L.757 4.537 0 3.606 4.435 0l4.613 3.598-.738.946zM.778 7.934l3.805 3.077L8.33 8.074l.74.944-4.497 3.528-4.55-3.679.755-.933z"
}, null)])])]), it = () => i("svg", {
  viewBox: "0 0 16 16",
  xmlns: "http://www.w3.org/2000/svg",
  height: "1em",
  width: "1em",
  focusable: "false"
}, [i("g", {
  "stroke-width": "1",
  "fill-rule": "evenodd"
}, [i("g", {
  transform: "translate(3.347 1.67)"
}, [i("path", {
  d: "M.738 0l3.858 3.01L8.291.008l.757.93-4.435 3.606L0 .946.738 0zM8.31 12.544l-3.858-3.01-3.695 3.003L0 11.606 4.435 8l4.613 3.598-.738.946z"
}, null)])])]), rt = () => i("svg", {
  xmlns: "http://www.w3.org/2000/svg",
  viewBox: "0 0 1024 1024",
  height: "1em",
  width: "1em",
  "data-v-6fbb019e": ""
}, [i("path", {
  fill: "currentColor",
  d: "M764.288 214.592 512 466.88 259.712 214.592a31.936 31.936 0 0 0-45.12 45.12L466.752 512 214.528 764.224a31.936 31.936 0 1 0 45.12 45.184L512 557.184l252.288 252.288a31.936 31.936 0 0 0 45.12-45.12L557.12 512.064l252.288-252.352a31.936 31.936 0 1 0-45.12-45.184z"
}, null)]);
class lt extends Re {
  /**
   * 通过节点类型加载节点数据
   *
   * @author tony001
   * @date 2023-12-11 18:12:35
   * @protected
   * @param {IDETreeNode} nodeModel
   * @param {(IDETreeNodeRS | undefined)} nodeRS
   * @param {(ITreeNodeData | undefined)} parentNodeData
   * @param {ResourceGanttFetchOpts} opts
   * @return {*}  {Promise<IGanttNodeData[]>}
   */
  async fetchNodeDatasByType(t, e, n, s) {
    const o = Te(this.model, {
      parentId: t.id,
      hasQuery: s.hasQuery
    }).length === 0, d = { ...s, leaf: o };
    let l = [];
    if (!n && !this.model.rootVisible)
      l = [await this.getStaticGanttNodeData(
        t,
        e,
        n,
        d
      )];
    else
      switch (t.treeNodeType) {
        case "STATIC":
          l = [await this.getStaticGanttNodeData(
            t,
            e,
            n,
            d
          )];
          break;
        case "DE":
          l = await this.getDEGanttNodeDatas(
            t,
            e,
            n,
            d
          );
          break;
        case "CODELIST":
          l = await this.getCodeListGanttNodeDatas(
            t,
            e,
            n,
            d
          );
          break;
        default:
          throw new Ke(
            t,
            ibiz.i18n.t("runtime.controller.control.gantt.noSupport", {
              treeNodeType: t.treeNodeType
            })
          );
      }
    const { expandFirstOnly: h, expanded: p, rootNode: y } = t, g = y && !this.model.rootVisible;
    return o || await Promise.all(
      l.map(async (b, I) => {
        if (p && // 全展开合只展开首节点expanded都为true
        (!h || h && I === 0) || g) {
          const S = await this.fetchChildNodes(
            b,
            s
          );
          b._children = S;
        }
      })
    ), l == null || l.forEach((b) => {
      b._beginDataItemValue || (b._beginDataItemValue = b._endDataItemValue), b._endDataItemValue || (b._endDataItemValue = b._beginDataItemValue);
    }), l = this.groupSort(l || [], s.groupField), l;
  }
  /**
   * 获取子节点数据
   *
   * @param {(IGanttNodeData | undefined)} parentNodeData
   * @param {ResourceGanttFetchOpts} opts
   * @return {*}  {(Promise<IGanttNodeData[] | undefined>)}
   */
  async fetchChildNodes(t, e) {
    return super.fetchChildNodes(t, e);
  }
  /**
   * 分组排序
   *
   * @param {(IGanttNodeData[] | undefined)} parentNodeData
   * @param {string} groupField
   */
  groupSort(t, e) {
    const n = {};
    let s = 0;
    return t.forEach((o) => {
      const d = o._deData && o._deData[e] ? o._deData[e] : "";
      d in n || (n[d] = s, s += 1);
    }), t.sort((o, d) => {
      const l = o._deData && o._deData[e] ? n[o._deData[e]] : -1, h = d._deData && d._deData[e] ? n[d._deData[e]] : -1;
      return l - h;
    }), t;
  }
}
class le extends Ee {
  constructor() {
    super(...arguments);
    /**
     * 初始加载
     */
    $(this, "isInitialLoad", !0);
  }
  get _evt() {
    return this.evt;
  }
  /**
   * 初始化对应类型的部件服务
   *
   * @protected
   * @return {*}  {Promise<void>}
   * @memberof GanttController
   */
  async initService() {
    this.service = new lt(this.model), await this.service.init(this.context);
  }
  initState() {
    super.initState(), this.state.showCapacity = !0, this.state.onlyTopNodes = !1, this.state.showWeekdays = [], this.state.capacityCalc = {
      calcType: "WORKITEMCOUNT",
      fieldName: ""
    }, this.state.capacityConfig = JSON.stringify({
      weekdays: "${weekday}",
      dayCapacityVal: "${day_capacity.work_item_count}"
    }), this.state.sliderDraggable = !0, this.state.sliderShowContent = '"${show_identifier}  ${title}"', this.state.groupConfig = { groupField: "project_id" }, this.state.contextMap = JSON.stringify({
      project: "${project_id}"
    }), this.state.sliderLimit = !0, this.state.expandAll = !1, this.calcDataRange();
  }
  /**
   * 部件参数解析
   *
   * @protected
   * @memberof ControlController
   */
  handleControlParams() {
    if (super.handleControlParams(), this.controlParams.sliderdraggable && (this.state.sliderDraggable = this.controlParams.sliderdraggable === "true"), this.controlParams.slidershowcontent && (this.state.sliderShowContent = this.controlParams.slidershowcontent), this.controlParams.groupconfig)
      try {
        this.state.groupConfig = JSON.parse(this.controlParams.groupconfig);
      } catch (e) {
        this.state.groupConfig = {};
      }
    this.controlParams.sliderlimit && (this.state.sliderLimit = this.controlParams.sliderlimit === "true"), this.controlParams.expandall && (this.state.expandAll = this.controlParams.expandall === "true"), this.controlParams.contextmap && (this.state.contextMap = this.controlParams.contextmap);
  }
  /**
   * 设置时间范围
   *
   * @memberof ResourceGanttController
   */
  setDateRange(e) {
    this.state.dateRange = e;
  }
  /**
   * 设置容量数值显示
   *
   * @memberof ResourceGanttController
   */
  showCapacityChange(e) {
    this.state.showCapacity = e;
  }
  /**
   * 全屏切换
   *
   * @memberof ResourceGanttController
   */
  fullscreenChange() {
    this._evt.emit("onFullscreenChange", {});
  }
  /**
   * 不显示周六及周天
   *
   * @memberof ResourceGanttController
   */
  noWeekendDays(e) {
    e ? this.state.showWeekdays = [1, 2, 3, 4, 5] : this.state.showWeekdays = [0, 1, 2, 3, 4, 5, 6];
  }
  /**
   * 容量计算切换
   *
   * @memberof ResourceGanttController
   */
  capacityCalcChange(e) {
    this.state.capacityCalc = e;
  }
  /**
   * 仅显示顶部节点
   *
   * @memberof ResourceGanttController
   */
  onlyTopNodesChange(e) {
    this.state.onlyTopNodes = e;
  }
  /**
   * 计算时间范围
   */
  calcDataRange() {
    const e = this.view.getController("searchform");
    if (e) {
      const { data: n } = e.state;
      this.state.dateRange = {
        start: n.n_date_scope_gtandeq,
        end: n.n_date_scope_ltandeq
      };
    } else {
      const n = /* @__PURE__ */ new Date();
      this.state.dateRange = {
        start: _(n.getTime() - 6048e5).format("YYYY-MM-DD"),
        end: _(n).format("YYYY-MM-DD")
      };
    }
  }
  /**
   * 根据节点id获取节点数据
   *
   * @param {string} key
   * @return {*}  {IData[]}
   * @memberof ResourceGanttController
   */
  getNodeDataByNodeId(e) {
    return this.state.items.filter((s) => s._nodeId === e).map((s) => {
      let o = {};
      return s._deData && (o = { ...s._deData, srfkey: s._deData.srfkey }), o;
    });
  }
  /**
   * 部件加载
   *
   * @param {MDCtrlLoadParams} [args={}]
   * @return {*}  {Promise<ITreeNodeData[]>}
   * @memberof ResourceGanttController
   */
  async load(e = {}) {
    return this.calcDataRange(), this.isInitialLoad = e.isInitialLoad === !0, super.load(e);
  }
  /**
   * 加载子节点数据
   *
   * @param {(ITreeNodeData | undefined)} parentNode
   * @returns {*}
   * @memberof TreeController
   */
  async loadNodes(e) {
    const n = await this.getFetchParams(), s = !!n.query;
    this.state.isLoading = !this.isInitialLoad;
    let o;
    try {
      o = await this.service.fetchChildNodes(e, {
        context: this.context.clone(),
        params: n,
        hasQuery: s,
        groupField: this.state.groupConfig.groupField,
        defaultExpandedKeys: this.state.expandedKeys
      }) || [];
    } finally {
      this.state.isLoading = !1;
    }
    return e ? e._children = o : this.state.rootNodes = o, await this.afterLoadNodes(o), o;
  }
  /**
   * 开始加载
   *
   * @return {*}  {Promise<void>}
   */
  async startLoading() {
    this.ctx.startLoading();
  }
  /**
   * 打开编辑数据视图
   *
   * @param {IGanttNodeData} item
   * @memberof GanttController
   */
  async openData({
    data: e,
    context: n,
    params: s
  }) {
    var y, g;
    const o = e[0], d = this.getNodeModel(o._nodeId), { appDataEntityId: l } = d, h = Z(l);
    n[h.toLowerCase()] = (y = o._deData) == null ? void 0 : y.srfkey;
    const p = await ((g = this.viewScheduler) == null ? void 0 : g.triggerCustom(
      "".concat(d.id.toLowerCase(), "_opendata"),
      {
        context: n,
        params: s,
        data: e,
        event: void 0,
        view: this.view,
        ctrl: this
      }
    ));
    if (p === -1)
      throw new Error(
        ibiz.i18n.t("runtime.controller.control.calendar.missingViewLogic", {
          itemType: d.id.toLowerCase()
        })
      );
    return {
      cancel: !p.ok
    };
  }
  /**
   * 保存
   *
   * @param {IGanttNodeData} nodeData
   * @return {*}  {Promise<void>}
   * @memberof GanttController
   */
  async save(e) {
    if (this.state.isSimple) {
      ibiz.log.debug(ibiz.i18n.t("runtime.controller.common.md.simpleMode"));
      return;
    }
    if (e._nodeType !== "DE")
      throw new ee(
        ibiz.i18n.t("runtime.controller.control.gantt.nonentity")
      );
    const n = this.state.rows[e._uuid];
    if (!n)
      throw new ee(
        ibiz.i18n.t("runtime.controller.common.md.rowData")
      );
    if (!n.modified) {
      ibiz.log.debug(ibiz.i18n.t("runtime.controller.common.md.noChange"));
      return;
    }
    if (n.processing) {
      await Je(500, this.save.bind(this), [e]);
      return;
    }
    const s = this.getNodeModel(e._nodeId), { appDataEntityId: o } = s, d = e._deData.srfuf === Le.CREATE, l = Z(o), h = this.context.clone();
    h[l] = e._deData.srfkey;
    const p = F(this.state.contextMap, e._deData || {}) || "{}";
    Object.assign(h, JSON.parse(p));
    const y = ibiz.hub.getApp(this.context.srfappid);
    let g;
    try {
      g = await y.deService.exec(
        o,
        d ? "create" : "update",
        h,
        e._deData
      );
    } catch (b) {
      throw await this.evt.emit("onSaveError", void 0), this.actionNotification("".concat(d ? "CREATE" : "UPDATE", "ERROR"), {
        error: b,
        data: n.data
      }), b;
    }
    n.data._deData = g.data, n.modified = !1, this.gridStateNotify(n, Me.SAVE), await this.evt.emit("onSaveSuccess", void 0);
  }
  /**
   * 设置行属性的值
   *
   * @param {TreeGridExRowState} row
   * @param {string} name
   * @param {unknown} value
   * @return {*}  {Promise<void>}
   * @memberof GanttController
   */
  async setRowValue(e, n, s) {
    const { beginDataItemName: o, endDataItemName: d } = this.model;
    if (!(Object.prototype.hasOwnProperty.call(e.data, n) && !Ae(e.data[n], s)) && !((n === o || n === d) && tt(e.data[n], s, "day"))) {
      e.data[n] = s, n === o ? e.data._beginDataItemValue = s : n === d && (e.data._endDataItemValue = s), e.modified = !0, e.processing = !0;
      try {
        await this.dataChangeNotify(e, [n]);
      } finally {
        e.processing = !1;
      }
    }
  }
}
const ct = /* @__PURE__ */ B({
  name: "ResourceGanttColumnHead",
  props: {
    controller: {
      type: le,
      required: !0,
      default: () => {
      }
    },
    model: {
      type: Object,
      required: !0,
      default: () => {
      }
    },
    expandAll: {
      type: Boolean,
      required: !0,
      default: !1
    },
    titleData: {
      type: Object,
      required: !0,
      default: () => {
      }
    }
  },
  emits: ["expandAllChange", "headSearch"],
  setup(a, {
    emit: t
  }) {
    const e = a.controller, n = A("resource-gantt-column-head"), s = k(!1), o = k(!1), d = k(""), l = T(() => a.titleData.label);
    se(() => a.expandAll, (u) => {
      s.value = u;
    }, {
      immediate: !0
    });
    const h = () => {
      s.value = !s.value, t("expandAllChange", s.value);
    }, p = () => {
      t("headSearch", d.value);
    }, y = (u) => {
      u.preventDefault(), u.stopPropagation(), o.value = !1, t("headSearch", "");
    }, g = (u, D) => {
      D.stopPropagation(), o.value = !0;
    }, b = async (u, D) => {
      await a.controller.doUIAction(u.uiactionId, {}, D, u.appId);
    }, I = (u) => {
      u.preventDefault(), u.stopPropagation();
    }, S = () => i(x("el-input"), {
      modelValue: d.value,
      "onUpdate:modelValue": (u) => d.value = u,
      class: n.b("search"),
      onInput: p,
      placeholder: "搜索成员"
    }, {
      prefix: () => i(ne, null, null),
      suffix: () => i(x("el-button"), {
        class: n.be("search", "suffix"),
        onClick: y
      }, {
        default: () => [i(rt, null, null)]
      })
    }), v = () => {
      var E, L;
      const u = e.getNodeModel("root"), D = e.state.selectedData;
      if (!((L = (E = u == null ? void 0 : u.decontextMenu) == null ? void 0 : E.detoolbarItems) != null && L.length))
        return;
      const N = e.contextMenuInfos[u.id];
      return N.clickTBUIActionItem && N.onlyOneActionItem ? null : i(x("iBizContextMenuControl"), {
        modelData: u.decontextMenu,
        groupLevelKeys: [50],
        nodeModel: u,
        nodeData: D,
        context: e.context,
        onActionClick: (G, q) => b(G, q)
      }, null);
    };
    return {
      c: e,
      ns: n,
      label: l,
      isHeadSearch: o,
      expand: s,
      renderHeadSearch: S,
      onColumnHeadClick: I,
      onExpandAllChange: h,
      renderContent: () => o.value ? S() : i("div", {
        class: n.b("box")
      }, [i("div", {
        class: n.be("box", "left")
      }, [i(x("el-button"), {
        class: n.bem("box", "left", "icon"),
        title: s.value ? "全部收起" : "全部展开",
        onClick: h
      }, {
        default: () => [s.value ? i(it, null, null) : i(st, null, null)]
      }), i("div", {
        class: n.bem("box", "left", "caption")
      }, [l.value])]), i("div", {
        class: n.be("box", "right")
      }, [i(x("el-button"), {
        size: "small",
        title: "搜索成员",
        class: [n.e("item")],
        onClick: (u) => g("search_personal", u)
      }, {
        icon: () => i("div", {
          class: n.e("icon")
        }, [i(ne, null, null)])
      }), v()])])
    };
  },
  render() {
    return i("div", {
      class: this.ns.b()
    }, [this.renderContent()]);
  }
});
function dt(a) {
  return typeof a == "function" || Object.prototype.toString.call(a) === "[object Object]" && !je(a);
}
const ut = /* @__PURE__ */ B({
  name: "IBizResourceActionToolbar",
  props: {
    actionDetails: {
      type: Array,
      required: !0
    },
    actionsState: {
      type: Object,
      required: !0
    },
    caption: String,
    mode: {
      type: String,
      default: "buttons"
    },
    // 分组的行为级别
    groupLevelKeys: {
      type: Object,
      default: [50]
    },
    zIndex: {
      type: Number
    },
    popperClass: String
  },
  emits: ["actionClick"],
  setup(a, {
    emit: t
  }) {
    var S;
    const e = A("action-toolbar"), n = A("resource-action-toolbar"), s = k(), o = k(!1), d = k(!1);
    (S = a.actionDetails) == null || S.forEach((v) => {
      v.capLanguageRes && v.capLanguageRes.lanResTag && (v.caption = ibiz.i18n.t(v.capLanguageRes.lanResTag, v.caption)), v.tooltipLanguageRes && v.tooltipLanguageRes.lanResTag && (v.tooltip = ibiz.i18n.t(v.tooltipLanguageRes.lanResTag, v.tooltip));
    });
    const l = (v) => {
      d.value = v;
    }, h = async (v, C) => {
      C.stopPropagation(), a.mode === "buttons" ? o.value = !1 : s.value && s.value.handleClose(), t("actionClick", v, C);
    }, p = k([]), y = k([]);
    a.actionDetails && a.actionDetails.forEach((v) => {
      a.groupLevelKeys.findIndex((C) => C === v.actionLevel) !== -1 ? y.value.push(v) : p.value.push(v);
    });
    const g = k(), b = (v) => {
      const {
        actionLevel: C
      } = v;
      return [e.e("item"), e.is("disabled", !1), e.em("item", "level-".concat(C))];
    }, I = a.zIndex;
    return {
      ns: e,
      ns2: n,
      dropdownRef: s,
      popoverIndex: I,
      expandDetails: p,
      groupDetails: y,
      groupButtonRef: g,
      popoverVisible: o,
      dropdownVisible: d,
      handleClick: h,
      calcActionItemClass: b,
      onVisibleChange: l
    };
  },
  render() {
    var s;
    const a = this.actionDetails || [], t = (o) => i(x("el-divider"), {
      class: this.ns.e("separator"),
      "border-style": "double",
      direction: o ? "vertical" : "horizontal"
    }, null), e = (o, d = !0) => o.map((l) => this.actionsState[l.id].visible ? [l.addSeparator && t(d), i(x("el-button"), {
      text: !0,
      size: "small",
      onClick: (h) => this.handleClick(l, h),
      title: l.tooltip,
      disabled: this.actionsState[l.id].disabled,
      class: this.calcActionItemClass(l)
    }, {
      default: () => [i("div", {
        class: this.ns.em("item", "icon")
      }, [l.showIcon && l.sysImage && i(x("iBizIcon"), {
        icon: l.sysImage
      }, null)]), i("div", {
        class: this.ns.em("item", "label")
      }, [l.showCaption ? l.caption : ""])]
    })] : null), n = () => {
      let o;
      if (this.groupDetails.length === 0 || !(this.groupDetails.findIndex((h) => this.actionsState[h.id].visible === !0) !== -1))
        return null;
      const l = this.groupDetails.findIndex((h) => this.actionsState[h.id].disabled === !1) === -1;
      return [i(x("el-button"), {
        size: "small",
        text: !0,
        disabled: l,
        ref: "groupButtonRef",
        class: [this.ns.e("item"), this.ns.is("expand", this.popoverVisible)]
      }, {
        icon: () => i(x("ion-icon"), {
          class: this.ns.e("icon"),
          name: "ellipsis-vertical-outline",
          title: ibiz.i18n.t("component.actionToolbar.more")
        }, null)
      }), i(x("el-popover"), {
        placement: "bottom-start",
        "virtual-ref": this.groupButtonRef,
        trigger: "click",
        visible: this.popoverVisible,
        "onUpdate:visible": (h) => this.popoverVisible = h,
        "popper-class": this.ns.e("popover"),
        "virtual-triggering": !0,
        "popper-style": "z-index:".concat(this.popoverIndex)
      }, dt(o = e(this.groupDetails, !1)) ? o : {
        default: () => [o]
      })];
    };
    if ((s = this.actionsState) != null && s.visible)
      return this.mode === "buttons" ? i("div", {
        class: [this.ns.b(), this.ns.m("buttons")],
        onClick: (o) => o.stopPropagation()
      }, [e(this.expandDetails), n()]) : i(x("el-dropdown"), {
        ref: "dropdownRef",
        onCommand: (o) => this.handleClick(o, new MouseEvent("click")),
        trigger: "click",
        class: [this.ns.b(), this.ns.m("dropdown"), this.dropdownVisible ? this.ns2.e("open") : ""],
        placement: "bottom-start",
        "popper-class": this.popperClass,
        onVisibleChange: this.onVisibleChange
      }, {
        default: () => i("span", {
          class: this.ns.e("caption")
        }, [this.caption, i(x("ion-icon"), {
          class: this.ns.e("caption-icon"),
          name: "ellipsis-vertical-outline"
        }, null)]),
        dropdown: () => i(x("el-dropdown-menu"), null, {
          default: () => [a.length > 0 && a.map((o) => this.actionsState[o.id].visible ? i(x("el-dropdown-item"), {
            class: [this.ns.e("item"), this.ns.is("disabled", !1)],
            title: o.tooltip,
            disabled: this.actionsState[o.id].disabled,
            command: o
          }, {
            default: () => [o.showIcon && o.sysImage && i(x("iBizIcon"), {
              icon: o.sysImage
            }, null), o.showCaption ? o.caption : ""]
          }) : null)]
        })
      });
  }
});
class ce extends ze {
}
const W = /* @__PURE__ */ B({
  name: "IBizPanelResourceState",
  props: {
    modelData: {
      type: Object,
      required: !0
    },
    controller: {
      type: ce,
      required: !0
    }
  },
  setup(a) {
    const t = A("panel-rawitem"), e = A("panel-resource-state"), n = k(""), s = [{
      tag: "standard",
      name: "标准"
    }, {
      tag: "saturation",
      name: "饱和"
    }, {
      tag: "exceed",
      name: "超出"
    }], {
      rawItem: o
    } = a.modelData;
    o && o.cssStyle && (n.value = o.cssStyle);
    const d = T(() => {
      const {
        id: h
      } = a.modelData, p = [t.b(), e.b(), t.m(h)];
      return p.push(...a.controller.containerClass), p;
    });
    return {
      ns: t,
      classArr: d,
      tempStyle: n,
      renderContent: () => s.map((h) => i("div", {
        class: [e.e("content"), e.e(h.tag)]
      }, [i("div", {
        class: [e.em("content", "star")]
      }, null), i("div", {
        class: e.em("content", "caption")
      }, [h.name])]))
    };
  },
  render() {
    if (this.controller.state.visible)
      return i("div", {
        class: this.classArr,
        style: this.tempStyle,
        onClick: () => {
          this.controller.onClick();
        }
      }, [this.renderContent()]);
  }
});
class ht {
  constructor() {
    $(this, "component", "IBizPanelResourceState");
  }
  async createController(t, e, n) {
    const s = new ce(t, e, n);
    return await s.init(), s;
  }
}
const pt = oe(
  W,
  function(a) {
    a.component(W.name, W), Oe("CUSTOM_RESOURCE_STATE", () => new ht());
  }
), H = /* @__PURE__ */ B({
  name: "IBizResourceGanttControl",
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
    loadDefault: {
      type: Boolean,
      default: !0
    },
    mdctrlActiveMode: {
      type: Number,
      default: void 0
    },
    singleSelect: {
      type: Boolean,
      default: void 0
    }
  },
  setup(a) {
    var Q;
    const t = Be((...r) => new le(...r)), e = k(), n = k(), s = k(!1), o = A("control-".concat(t.model.controlType.toLowerCase())), d = A("control-resource-gantt"), l = k(), h = k(!1), p = k();
    p.value = Fe();
    const y = x("IBizRawItem"), g = x("IBizIcon");
    let b = !1;
    const I = [], S = ["blue", "light-blue", "blue-cyan", "pink", "purple", "violet", "indigo", "cyan", "teal", "green", "light-green", "lime", "yellow", "amber", "orange", "grey", "sky-blue"], v = (Q = Ge()) == null ? void 0 : Q.appContext.app;
    qe(() => {
      (() => import("@ibiz-template-plugin/gantt"))().then((c) => {
        const f = c.default;
        v == null || v.use(f), s.value = !0;
      });
    });
    const C = (r) => {
      const c = document.documentElement;
      return getComputedStyle(c).getPropertyValue(r);
    }, u = T(() => {
      var c, f;
      return {
        primaryColor: ((c = t.state.ganttStyle) == null ? void 0 : c.primaryColor) || C("--ibiz-color-bg-0"),
        textColor: ((f = t.state.ganttStyle) == null ? void 0 : f.textColor) || C("--ibiz-color-text-2")
      };
    }), D = T(() => {
      var c;
      const r = {};
      return (c = t.model.detreeNodes) == null || c.forEach((f, m) => {
        const R = m % S.length;
        r[f.id] = "rgba(".concat(C("--ibiz-".concat(S[R], "-0")), ", 1)");
      }), r;
    }), N = () => {
      var c;
      let r = t.state.rootNodes;
      return t.model.rootVisible || (r = ((c = t.state.rootNodes[0]) == null ? void 0 : c._children) || []), r.map((f) => {
        const m = {};
        return Object.assign(m, f), m._children && (m._children = null), m;
      });
    }, E = T(() => t.state.isLoaded ? t.state.isLoading : !1), L = T(() => {
      var r, c;
      return t.state.onlyTopNodes ? N() : t.model.rootVisible ? t.state.rootNodes : (c = (r = t.state.rootNodes[0]) == null ? void 0 : r._children) == null ? void 0 : c.filter((f) => !l.value || f.name.includes(l.value));
    }), G = T(() => {
      const r = [];
      return t.state.columnStates.forEach((c) => {
        var m;
        const f = (m = t.columns[c.key]) == null ? void 0 : m.model;
        !c.hidden && f && r.push(f);
      }), r;
    }), q = T(() => ibiz.i18n.getLang().toLowerCase()), de = (r, c) => {
      if (r)
        I.push(c);
      else {
        const f = I.findIndex((m) => m._id === c._id);
        f > -1 && I.splice(f, 1);
      }
      t.setSelection(I);
    }, Y = (r, c) => {
      if (b || h.value) {
        h.value = !1;
        return;
      }
      t.onTreeNodeClick(r, c), b = !0, setTimeout(() => {
        b = !1;
      }, 200);
    }, U = (r) => {
      t.onDbTreeNodeClick(r);
    }, ue = (r) => {
      t.onExpandChange(r, !0), r && !r._children && t.refreshNodeChildren(r);
    }, he = (r) => {
      t.onExpandChange(r, !1);
    };
    t.evt.on("onNewRow", (r) => {
      if (e.value) {
        const c = r.row.data;
        e.value.setExpand(c);
      }
    });
    const K = () => {
      var r;
      (r = e.value) == null || r.fullscreenChange();
    };
    t._evt.on("onFullscreenChange", (r) => {
      K();
    });
    const pe = (r) => {
      l.value = r;
    }, me = (r) => {
      t.state.expandAll = r;
    }, fe = (r) => {
      console.log("抛值内容", r);
    }, ge = (r) => {
      var m;
      const c = (m = r[0]) == null ? void 0 : m.row, f = {
        begin: c._beginDataItemValue ? _(c._beginDataItemValue).format("YYYY-MM-DD HH:mm:ss") : void 0,
        end: c._endDataItemValue ? _(c._endDataItemValue).format("YYYY-MM-DD HH:mm:ss") : void 0
      };
      h.value = !0, t.modifyNodeTime(c, f);
    }, J = (r, c, f, m) => {
      const R = [];
      return r.forEach((w) => {
        var z;
        if (w.itemType === "SEPERATOR") {
          R.push({
            divided: "self"
          });
          return;
        }
        const V = m[w.id];
        if (V && !V.visible)
          return;
        const M = {};
        if (w.showCaption && w.caption && (M.label = w.caption), w.sysImage && w.showIcon && (M.icon = i(g, {
          icon: w.sysImage
        }, null)), w.itemType === "DEUIACTION") {
          M.disabled = V.disabled, M.clickClose = !0;
          const {
            uiactionId: O
          } = w;
          O && (M.onClick = () => {
            t.doUIAction(O, c, f, w.appId);
          });
        } else if (w.itemType === "RAWITEM") {
          const {
            rawItem: O
          } = w;
          O && (M.label = i(y, {
            rawItem: w
          }, null));
        } else
          w.itemType === "ITEMS" && (z = w.detoolbarItems) != null && z.length && (M.children = J(w.detoolbarItems, c, f, m));
        R.push(M);
      }), R;
    };
    let P;
    t.evt.on("onMounted", () => {
      Object.values(t.contextMenus).length > 0 && (() => import("@imengyu/vue3-context-menu"))().then((c) => {
        P = c.default, P.default && !P.showContextMenu && (P = P.default);
      });
    });
    const Ce = async (r, c) => {
      c.stopPropagation(), c.preventDefault();
      const f = t.getNodeModel(r._nodeId);
      if (!(f != null && f.decontextMenu))
        return;
      const m = t.contextMenus[f.decontextMenu.id];
      if (!m.model.detoolbarItems)
        return;
      await m.calcButtonState(r._deData || (r.srfkey ? r : void 0), f.appDataEntityId);
      const R = m.state.buttonsState, w = J(m.model.detoolbarItems, r, c, R);
      w.length && P.showContextMenu({
        x: c.x,
        y: c.y,
        customClass: o.b("context-menu"),
        items: w
      });
    }, ye = () => {
      const {
        isLoaded: r
      } = t.state;
      return r && i(x("iBizNoData"), {
        text: t.model.emptyText,
        emptyTextLanguageRes: t.model.emptyTextLanguageRes
      }, null);
    }, be = (r, c) => {
      const {
        caption: f,
        codeName: m,
        width: R,
        headerSysCss: w,
        align: V
      } = r, M = t.columns[m];
      return i(x("x-gantt-column"), {
        label: f,
        prop: m,
        width: R && R > 30 ? R : 30,
        center: (V == null ? void 0 : V.toLowerCase()) === "center"
      }, {
        title: (z) => {
          const {
            label: O
          } = z;
          return m === "name" ? i(ct, {
            key: m,
            model: r,
            controller: t,
            titleData: z,
            expandAll: t.state.expandAll,
            class: w == null ? void 0 : w.cssName,
            onExpandAllChange: me,
            onHeadSearch: pe
          }, null) : i("div", {
            class: w == null ? void 0 : w.cssName
          }, [O]);
        },
        default: (z) => {
          const {
            row: O,
            column: ve,
            level: xe
          } = z, j = t.getRowState(O._id);
          if (j) {
            if (m === "name") {
              const {
                weekdays: Ie,
                dayCapacity: _e
              } = te(j, t.state.capacityConfig);
              let X;
              return O._parent && (X = t.getRowState(O._parent._id)), i(ot, {
                controller: M,
                weekdays: Ie,
                dayCapacity: _e,
                capacityCalc: t.state.capacityCalc,
                dateRange: t.state.dateRange,
                groupConfig: t.state.groupConfig,
                row: j,
                parentRow: X,
                column: ve,
                level: xe,
                key: j.data._uuid + m
              }, null);
            }
            const De = x(t.providers[m].component);
            return He(De, {
              controller: M,
              row: j,
              key: j.data._uuid + m
            });
          }
          return null;
        }
      });
    }, we = () => i(x("x-gantt-slider"), {
      "allow-link": !1,
      move: t.state.sliderDraggable,
      "resize-left": t.state.sliderDraggable,
      "resize-right": t.state.sliderDraggable,
      "move-by-unit": !0,
      "slider-limit": t.state.sliderLimit
    }, {
      content: ({
        row: r,
        level: c,
        left: f
      }) => {
        if (c !== 1) {
          const m = F(t.state.sliderShowContent, r._deData || {}).replace(/^"(.*?)"$/, "$1"), R = f < 0 ? "".concat(-f, "px") : "";
          return i("div", {
            class: [o.e("slider"), d.e("slider")],
            style: {
              background: D.value[r._nodeId]
            },
            onClick: (w) => Y(r, w),
            onDblclick: () => U(r),
            onContextmenu: (w) => Ce(r, w)
          }, [m && i("div", {
            class: d.em("slider", "caption"),
            style: {
              marginLeft: R
            },
            title: m,
            innerHTML: m
          }, null)]);
        }
      }
    });
    return {
      c: t,
      ns: o,
      ns2: d,
      fullscreenChange: K,
      ganttRef: e,
      ganttBoxRef: n,
      isInited: s,
      ganttId: p,
      data: L,
      locale: q,
      columns: G,
      onCheck: de,
      loading: E,
      ganttStyle: u,
      onNodeClick: Y,
      onNodeDbClick: U,
      onNodeExpand: ue,
      onNodeCollapse: he,
      renderContent: () => {
        const r = G.value.map((f, m) => be(f)), c = we();
        return [...r, c];
      },
      renderGanttCell: (r) => {
        if (r.level === 1) {
          const c = t.getRowState(r.row._id) || {}, {
            weekdays: f,
            dayCapacity: m
          } = te(c, t.state.capacityConfig);
          if (ie(r.column.date, f)) {
            const R = {};
            return Object.assign(R, {
              ...r,
              row: c
            }), i(nt, {
              cellData: R,
              showText: t.state.showCapacity,
              capacityCalc: t.state.capacityCalc,
              weekdays: f,
              dayCapacity: m,
              onCellClick: fe
            }, null);
          }
        }
      },
      renderGanttTitle: (r) => {
        const {
          column: c
        } = r, f = Xe(c.date), m = Ze(c.date, "MM/DD");
        return i("div", {
          class: [o.b("column-title"), et(c.date) ? o.be("column-title", "today") : ""]
        }, [i("div", {
          class: o.be("column-title", "top")
        }, [f]), i("div", {
          class: o.be("column-title", "bottom")
        }, [m])]);
      },
      onSliderMove: ge,
      renderNoData: ye
    };
  },
  render() {
    var a;
    return this.isInited ? $e(i(x("iBizControlBase"), {
      ref: "ganttBoxRef",
      controller: this.c,
      class: [this.ns.b(), this.ns2.b(), (a = this.data) != null && a.length ? "" : this.ns.m("empty")]
    }, {
      default: () => [i(x("x-gantt"), {
        ref: "ganttRef",
        id: this.ganttId,
        "data-id": "_id",
        data: this.data,
        "row-height": 46,
        "show-expand": !0,
        "expand-all": this.c.state.expandAll,
        "start-key": "_beginDataItemValue",
        "end-key": "_endDataItemValue",
        children: "_children",
        leaf: "_leaf",
        dateRange: this.c.state.dateRange,
        showWeekdays: this.c.state.showWeekdays,
        locale: this.locale,
        "header-height": 46,
        showCheckbox: !this.c.state.singleSelect,
        showToday: !1,
        showWeekend: !1,
        onNodeExpand: this.onNodeExpand,
        onNodeCollapse: this.onNodeCollapse,
        onRowClick: this.onNodeClick,
        onRowDblClick: this.onNodeDbClick,
        onRowChecked: this.onCheck,
        onMoveSlider: this.onSliderMove,
        primaryColor: this.ganttStyle.primaryColor,
        headerStyle: {
          textColor: this.ganttStyle.textColor
        }
      }, {
        default: () => this.renderContent(),
        ganttCell: (t) => this.renderGanttCell(t),
        ganttTitle: (t) => this.renderGanttTitle(t),
        empty: () => this.renderNoData()
      })]
    }), [[We("loading"), this.loading]]) : null;
  }
});
class mt {
  constructor() {
    $(this, "component", "IBizResourceGanttControl");
  }
}
const ft = oe(
  H,
  function(a) {
    a.component(H.name, H), Ve(
      "TREE_RENDER_RESOURCE_GANTT",
      () => new mt()
    );
  }
), Nt = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(a) {
    a.use(ft), a.use(pt);
  }
};
export {
  ft as IBizResourceGanttControl,
  Nt as default
};
