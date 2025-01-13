import './style.css';
var j = Object.defineProperty;
var G = (a, e, l) => e in a ? j(a, e, { enumerable: !0, configurable: !0, writable: !0, value: l }) : a[e] = l;
var k = (a, e, l) => (G(a, typeof e != "symbol" ? e + "" : e, l), l);
import { TreeService as O, AppDataEntity as P, TreeDataSetNodeData as $, TreeController as V, getControlPanel as Y, registerControlProvider as Z } from "@ibiz-template/runtime";
import { useControlController as q, useNamespace as K, withInstall as U } from "@ibiz-template/vue3-util";
import { createVNode as n, defineComponent as W, ref as A, computed as D, resolveComponent as u, withDirectives as H, resolveDirective as J, isVNode as Q, createTextVNode as T } from "vue";
const X = () => n("svg", {
  viewBox: "0 0 16 16",
  xmlns: "http://www.w3.org/2000/svg",
  height: "1em",
  width: "1em",
  preserveAspectRatio: "xMidYMid meet",
  focusable: "false"
}, [n("g", {
  id: "abbnavigation/angle-down",
  "stroke-width": "1",
  "fill-rule": "evenodd"
}, [n("path", {
  d: "M7.978 11.997l-.005.006L2.3 6.33l.83-.831 4.848 4.848L12.826 5.5l.83.83-5.673 5.673-.005-.006z",
  id: "abb形状结合"
}, null)])]), ee = () => n("svg", {
  viewBox: "0 0 16 16",
  xmlns: "http://www.w3.org/2000/svg",
  height: "1em",
  width: "1em",
  preserveAspectRatio: "xMidYMid meet",
  focusable: "false"
}, [n("g", {
  id: "arc1.Base基础/1.icon图标/2.normal/open",
  "stroke-width": "1",
  "fill-rule": "evenodd"
}, [n("g", {
  id: "arc全部展开收起",
  transform: "translate(3.347 1.67)"
}, [n("path", {
  d: "M8.31 4.544l-3.858-3.01L.757 4.537 0 3.606 4.435 0l4.613 3.598-.738.946zM.778 7.934l3.805 3.077L8.33 8.074l.74.944-4.497 3.528-4.55-3.679.755-.933z",
  id: "arc形状结合"
}, null)])])]), te = () => n("svg", {
  viewBox: "0 0 16 16",
  xmlns: "http://www.w3.org/2000/svg",
  height: "1em",
  width: "1em",
  preserveAspectRatio: "xMidYMid meet",
  focusable: "false"
}, [n("g", {
  id: "awy1.Base基础/1.icon图标/2.normal/Stow",
  "stroke-width": "1",
  "fill-rule": "evenodd"
}, [n("g", {
  id: "awy全部展开收起",
  transform: "translate(3.347 1.67)"
}, [n("path", {
  d: "M.738 0l3.858 3.01L8.291.008l.757.93-4.435 3.606L0 .946.738 0zM8.31 12.544l-3.858-3.01-3.695 3.003L0 11.606 4.435 8l4.613 3.598-.738.946z",
  id: "awy形状结合"
}, null)])])]), ne = () => n("svg", {
  viewBox: "0 0 16 16",
  version: "1.1",
  xmlns: "http://www.w3.org/2000/svg",
  height: "1em",
  width: "1em",
  preserveAspectRatio: "xMidYMid meet",
  focusable: "false"
}, [n("g", {
  id: "dn1.Base基础/1.icon图标/0.应用/管理后台-Access",
  "stroke-width": "1",
  "fill-rule": "evenodd"
}, [n("path", {
  d: "M8.41753643,2.1073169 C9.21754831,1.30730502 10.347797,0.907140068 11.4814793,1.01825753 L11.4814793,1.01825753 L11.7537056,1.05650161 L11.8726431,1.08729861 C12.1934057,1.19279667 12.4459313,1.44446973 12.5515077,1.76690595 C12.6573616,2.09018943 12.6011653,2.44439808 12.3744262,2.75536488 L12.3744262,2.75536488 L12.2867034,2.85429866 L11.5656961,3.5522516 L11.7359101,4.13639499 L12.3384288,4.34142545 L13.0623345,3.61850979 C13.3135022,3.36734208 13.6706084,3.26064694 14.0150375,3.327078 L14.0150375,3.327078 L14.1433724,3.36016091 C14.5220826,3.48416334 14.7994519,3.80921292 14.8630469,4.20418276 C15.0541392,5.40889509 14.6583168,6.63738663 13.8015713,7.4941322 C12.8298435,8.46585999 11.4283909,8.83606549 10.127502,8.45516139 L10.228,8.481 L10.3055325,8.50102928 L9.337,9.469 L10.368,10.5 L10.4258034,10.4441286 C10.7591418,10.1107902 11.2866316,10.0869804 11.6477059,10.372699 L11.7279125,10.4441286 L13.750956,12.1837029 C13.9241849,12.3569318 14.019844,12.5882668 14.019844,12.8347575 C14.019844,13.0460353 13.9495638,13.2461782 13.820395,13.4081388 L13.750956,13.4858121 L12.8016659,14.5788409 C12.6269422,14.7521085 12.2131151,15 11.9668445,15 C11.7555667,15 11.5554238,14.9297151 11.3934565,14.8005397 L11.3157794,14.7310967 L9.51698605,12.6550551 C9.34375717,12.4818262 9.24809807,12.2504913 9.24809807,12.0040005 C9.24809807,11.7927228 9.31837823,11.5925799 9.44754701,11.4306192 L9.51698605,11.352946 L9.548,11.32 L8.517,10.289 L4.64682864,14.1603419 C4.36004018,14.4471304 3.9959385,14.6343361 3.60364668,14.7033762 L3.43393891,14.7256761 L3.26163857,14.7331816 C2.74277904,14.7331816 2.24632778,14.5288309 1.87783875,14.1603419 C1.5089955,13.7914986 1.30499906,13.2980072 1.30499906,12.7751518 C1.30499906,12.3202886 1.46026317,11.885301 1.76551184,11.5132621 L1.76551184,11.5132621 L1.87911011,11.3886943 L5.758,7.533 L4.512,6.296 L4.45216908,6.35833488 C4.26692601,6.54856043 4.01915293,6.65594705 3.75345625,6.6605848 C3.52551265,6.66456357 3.30825873,6.59250872 3.13108266,6.45619393 L3.0459705,6.38273606 L1.40251514,4.59530613 C1.21235954,4.41167501 1.10479826,4.16389354 1.10015637,3.89795935 C1.0961776,3.67001575 1.16823245,3.45276183 1.30454017,3.27559306 L1.3779939,3.19048519 L2.19742679,2.41198409 C2.55078187,2.0460742 3.1194323,2.0104525 3.51436918,2.31190919 L3.60224773,2.38746285 L5.39116982,3.9557583 C5.58132542,4.13938943 5.6888867,4.38717089 5.69352859,4.65310509 C5.69750736,4.88104869 5.62545251,5.0983026 5.48914479,5.27547137 L5.41569106,5.36057924 L5.318,5.46 L6.581,6.715 L7.45928412,5.84240316 L7.39768974,5.60313038 C7.13474167,4.41746721 7.45216521,3.17456023 8.27480181,2.25796028 L8.27480181,2.25796028 Z M11.075716,11.1522373 L10.1974919,11.9745493 L11.9374157,14.0491962 L13.0704607,12.8628318 L11.075716,11.1522373 Z M11.186214,2.16169797 C10.4589969,2.14038789 9.74896207,2.4171565 9.23816905,2.92794951 C8.48712202,3.67899655 8.26359155,4.79160805 8.66414874,5.78019251 L8.66414874,5.78019251 L8.80902108,6.1377408 L2.71888377,12.1891119 L2.64536855,12.2695234 C2.5281396,12.4128192 2.46554883,12.5881733 2.46554883,12.7751518 C2.46554883,12.990509 2.54748544,13.1887233 2.69847137,13.3397093 C2.84865823,13.4898961 3.04965697,13.5726318 3.26163857,13.5726318 C3.47488445,13.5726318 3.6759101,13.4899952 3.82619602,13.3397093 L3.82619602,13.3397093 L9.97923798,7.18666732 L10.4698177,7.34637783 C11.3438406,7.60211651 12.306658,7.34778018 12.9809386,6.67349958 C13.4894571,6.16498112 13.764623,5.46378445 13.7492211,4.74650046 L13.7492211,4.74650046 L13.7397927,4.58223953 L12.6490643,5.67304518 L10.791336,5.04227537 L10.2569246,3.20532075 L11.3277834,2.17023024 Z M2.91194003,3.16369604 L2.12388477,3.84830602 L3.70380062,5.63533479 L4.66978566,4.70127266 L2.91194003,3.16369604 Z",
  id: "dn形状结合备份-2"
}, null)])]);
class re extends O {
  /**
   * 获取实体数据集数据
   *
   * @protected
   * @param {TreeNodeRSModel} nodeRS
   * @param {TreeFetchOpts} opts
   * @returns {*}
   * @memberof TreeService
   */
  async getDENodeDatas(e, l, c, o) {
    const { appDEDataSetId: C, appDataEntityId: g, appId: h } = e, { context: v, params: p, navContext: E, navParams: L } = l ? this.getNodeRSFilterParams(l, c, o) : {
      context: o.context,
      params: o.params,
      navContext: {},
      navParams: {}
    };
    p.size = e.maxSize || 1e3, e.sortAppDEFieldId && Object.assign(p, {
      sort: "".concat(e.sortAppDEFieldId.toLowerCase(), ",").concat(e.sortDir ? e.sortDir.toLowerCase() : "asc")
    }), v.srfappid = h;
    let i;
    if (e.userTag === "CUSTOM" && e.treeNodeType === "DE") {
      const m = await ibiz.hub.getAppDataEntity(
        g,
        h
      );
      m && (i = c && c._deData ? c._deData["".concat(e.id)].content || [] : [], i = i.map((f) => new P(m, f)));
    } else
      i = (await this.app.deService.exec(
        g,
        C,
        v,
        p
      )).data;
    return i && i.length > 0 ? i.map((f, b) => {
      const y = this.calcExpand(e, b);
      return new $(e, c, {
        data: f,
        leaf: !!o.leaf,
        navContext: E,
        navParams: L,
        defaultExpand: y
      });
    }) : [];
  }
}
class ae extends V {
  /**
   * 初始化对应类型的部件服务
   * @author lxm
   * @date 2023-12-21 11:25:33
   * @protected
   * @return {*}  {Promise<void>}
   */
  async initService() {
    this.service = new re(this.model), await this.service.init(this.context);
  }
}
function S(a) {
  return typeof a == "function" || Object.prototype.toString.call(a) === "[object Object]" && !Q(a);
}
const _ = /* @__PURE__ */ W({
  name: "IBizTrackTreeGridControl",
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
    },
    checkStrictly: {
      type: Boolean,
      default: !0
    },
    isSimple: {
      type: Boolean,
      default: !1
    },
    data: {
      type: Array,
      required: !1
    }
  },
  emits: ["nodeClick"],
  setup() {
    var B;
    const a = q((...t) => new ae(...t)), e = K("track-tree-grid"), l = A(!1), c = D(() => a.state.isLoaded ? a.state.rootNodes.reduce((t, r) => r._children ? t.concat(r._children) : t, []) : []), o = A([]);
    a.model.detreeNodes && (o.value = (B = a.model.detreeNodes) == null ? void 0 : B.filter((t) => t.treeNodeType === "STATIC" && !t.rootNode).map((t) => {
      let r = !1;
      if (t.userTag) {
        const [s, d] = t.userTag.split("=");
        s === "ENABLESETTING" && (r = d === "true");
      }
      return {
        ...t,
        enableSetting: r,
        visible: !0
      };
    }));
    const C = D(() => (c.value[0] || {})._children || []), g = (t, r) => {
      r.stopPropagation(), !t._disableSelect && a.onTreeNodeClick(t, r);
    }, h = (t, r) => {
      r.stopPropagation(), !t._disableSelect && a.onDbTreeNodeClick(t);
    }, v = (t) => {
      var r;
      Object.assign(t, {
        _expanded: !t._expanded
      }), (r = t._children) == null || r.forEach((s) => {
        v(s);
      });
    }, p = (t) => {
      var r;
      Object.assign(t, {
        _expanded: l.value
      }), (r = t._children) == null || r.forEach((s) => {
        p(s);
      });
    }, E = () => {
      l.value = !l.value, p(c.value[0] || {});
    }, L = (t) => {
      const r = a.getNodeModel(t._nodeId) || {}, s = Y(r);
      return s ? n(u("iBizControlShell"), {
        data: {
          ...t._deData,
          expanded: !!t._expanded
        },
        modelData: s,
        context: a.context,
        params: a.params
      }, null) : null;
    }, i = (t) => n("div", {
      class: [e.e("expand-item")]
    }, [L(t) || t._text]), m = (t) => {
      const {
        _text: r,
        _children: s = [],
        _expanded: d
      } = t, x = s ? s.length : 0;
      let w = L({
        ...s[0],
        _expanded: d,
        _deData: {
          sum: x
        }
      }) || [n("span", {
        class: e.em("default-cell", "num")
      }, [x]), n("span", {
        class: e.em("default-cell", "caption")
      }, ["个".concat(r)])];
      return d && (w = s.map((M) => i(M))), n("div", {
        class: [e.e("default-cell")]
      }, [w]);
    }, f = (t) => n("div", {
      class: [e.e("first-cell")]
    }, [L(t) || n("span", {
      class: e.em("first-cell", "text")
    }, [t._text])]), b = (t, r = !1) => n("div", {
      class: [e.e("cell"), e.is("expand", t._expanded)],
      onDblclick: (s) => h(t, s),
      onClick: (s) => g(t, s)
    }, [r ? f(t) : m(t)]), y = (t, r) => {
      const s = r._children || [];
      return n("div", {
        class: [e.e("row"), e.is("expand", r._expanded)]
      }, [n("div", {
        class: e.em("row", "header")
      }, [n("div", {
        class: e.em("row", "expand")
      }, [n("span", {
        class: e.em("row", "expand-icon"),
        onClick: () => v(r)
      }, [X()])]), b(r, !0)]), n("div", {
        class: e.em("row", "body")
      }, [t.map((d) => {
        const x = s.find((w) => w._nodeId === d.id) || {};
        return d.visible && d.enableSetting && b(x);
      })])]);
    }, I = (t, r) => n("div", {
      class: e.e("table-body"),
      style: {
        minWidth: "".concat(t.length * 20, "rem")
      }
    }, [n("div", {
      class: e.em("table-body", "scollor")
    }, [r.map((s) => y(t, s))])]), F = (t) => n("div", {
      class: e.e("header"),
      style: {
        minWidth: "".concat(t.length * 20, "rem")
      }
    }, [t.map((r, s) => r.visible && n("div", {
      class: e.em("header", "cell")
    }, [!s && n("div", {
      class: e.em("header", "expand-switch"),
      title: l.value ? "全部收起" : "全部展开",
      onClick: E
    }, [l.value ? te() : ee()]), n("div", {
      class: e.em("header", "caption")
    }, [r.text])]))]), N = () => n("div", {
      class: e.e("table")
    }, [F(o.value), I(o.value, C.value)]), z = () => n(u("el-dropdown"), {
      trigger: "click",
      placement: "bottom-start",
      class: e.b("cloum-setting"),
      "popper-class": e.be("cloum-setting", "popper")
    }, {
      default: () => n("span", {
        class: e.be("cloum-setting", "content")
      }, [n("span", {
        class: e.bem("cloum-setting", "content", "icon")
      }, [ne()]), n("span", {
        class: e.bem("cloum-setting", "content", "text")
      }, [T("设置")])]),
      dropdown: () => {
        let t;
        return n(u("el-dropdown-menu"), null, S(t = o.value.map((r) => r.enableSetting && n(u("el-dropdown-item"), null, {
          default: () => [n("div", {
            class: e.bem("cloum-setting", "popper", "content")
          }, [r.sysImage && n(u("iBizIcon"), {
            icon: r.sysImage,
            class: e.bem("cloum-setting", "popper", "icon")
          }, null), n("span", {
            class: e.bem("cloum-setting", "popper", "text")
          }, [r.text]), n(u("el-switch"), {
            class: e.bem("cloum-setting", "popper", "switch"),
            modelValue: r.visible,
            "onUpdate:modelValue": (s) => r.visible = s
          }, null)])]
        }))) ? t : {
          default: () => [t]
        });
      }
    }), R = () => n("div", {
      class: e.e("toolbar")
    }, [n("div", {
      class: e.em("toolbar", "item")
    }, [z()]), n("div", {
      class: e.em("toolbar", "item")
    }, [n("div", {
      class: e.em("total")
    }, [n("span", {
      class: e.em("total", "sum")
    }, [C.value.length]), n("span", {
      class: e.em("total", "caption")
    }, [T("个需求")])])])]);
    return {
      c: a,
      ns: e,
      renderContent: () => n("div", {
        class: e.b()
      }, [R(), T(" "), N()])
    };
  },
  render() {
    const a = {}, e = "default";
    return a[e] = () => {
      if (this.c.state.isLoaded)
        return this.renderContent();
    }, n(u("iBizControlNavigation"), {
      controller: this.c
    }, {
      default: () => [H(n(u("iBizControlBase"), {
        ref: "treeviewRef",
        controller: this.c
      }, S(a) ? a : {
        default: () => [a]
      }), [[J("loading"), this.c.state.isLoading]])]
    });
  }
});
class se {
  constructor() {
    k(this, "component", "IBizTrackTreeGridControl");
  }
}
const le = U(
  _,
  function(a) {
    a.component(_.name, _), Z(
      "TREE_RENDER_TRACK_TREE_GRID",
      () => new se()
    );
  }
), pe = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(a) {
    a.use(le);
  }
};
export {
  le as IBizTrackTreeGridControl,
  pe as default
};
