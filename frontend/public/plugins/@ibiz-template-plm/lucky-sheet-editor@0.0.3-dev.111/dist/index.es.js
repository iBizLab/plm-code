import './style.css';
var T = Object.defineProperty;
var O = (c, t, e) => t in c ? T(c, t, { enumerable: !0, configurable: !0, writable: !0, value: e }) : c[t] = e;
var m = (c, t, e) => (O(c, typeof t != "symbol" ? t + "" : t, e), e);
import { EditorController as x, PluginStaticResource as H, registerEditorProvider as j } from "@ibiz-template/runtime";
import { getInputProps as B, getEditorEmits as I, useNamespace as P, withInstall as z } from "@ibiz-template/vue3-util";
import { defineComponent as N, ref as p, watch as M, onMounted as U, onBeforeUnmount as A, createVNode as D, withDirectives as F, resolveDirective as J } from "vue";
import { createUUID as W } from "qx-util";
class $ extends x {
}
class G {
  constructor() {
    m(this, "formEditor", "IBizLuckySheet");
    m(this, "gridEditor", "IBizLuckySheet");
  }
  async createController(t, e) {
    const s = new $(t, e);
    return await s.init(), s;
  }
}
const r = new H(import.meta.url);
class u {
  /**
   * @description 获取Luckysheet对象
   * @static
   * @return {*}  {*}
   * @memberof SheetUtil
   */
  static getLuckySheet() {
    return window.luckysheet;
  }
  /**
   * 动态加载脚本
   *
   * @static
   * @return {*}
   * @memberof SheetUtil
   */
  static loadScript(t) {
    return new Promise((e, s) => {
      const i = document.createElement("script");
      i.src = t, i.onload = e, i.onerror = s, document.head.appendChild(i);
    });
  }
  /**
   * 动态加载样式
   *
   * @static
   * @return {*}
   * @memberof SheetUtil
   */
  static loadStyle(t) {
    return new Promise((e, s) => {
      const i = document.createElement("link");
      i.rel = "stylesheet", i.href = t, i.onload = e, i.onerror = s, document.head.appendChild(i);
    });
  }
  /**
   * 加载LuckySheet
   *
   * @static
   * @return {*}
   * @memberof SheetUtil
   */
  static loadLuckySheet() {
    return new Promise((t, e) => {
      if (this.getLuckySheet())
        t();
      else {
        const i = [
          this.loadStyle(
            r.dir("assets/luckysheet/plugins/css/pluginsCss.css")
          ),
          this.loadStyle(r.dir("assets/luckysheet/plugins/plugins.css")),
          this.loadStyle(r.dir("assets/luckysheet/css/luckysheet.css")),
          this.loadStyle(
            r.dir("assets/luckysheet/assets/iconfont/iconfont.css")
          ),
          this.loadScript(
            r.dir("assets/luckysheet/plugins/js/plugin.js")
          ),
          this.loadScript(r.dir("assets/luckysheet/luckysheet.umd.js"))
        ];
        Promise.all(i).then(() => {
          t();
        }).catch(() => {
          ibiz.message.error(
            "加载luckySheet静态资源失败,请确认静态资源是否存在！"
          ), e();
        });
      }
    });
  }
  /**
   * 更新Luckysheet
   *
   * @static
   * @memberof SheetUtil
   */
  static updateSheet() {
    const t = this.getLuckySheet(), e = this.getSheetData();
    t && e && t.updataSheet(e);
  }
  /**
   * @description 获取Luckysheet当前工作表
   * @return {*}
   * @memberof SheetUtil
   */
  static getSheet() {
    return window.luckysheet.getSheet();
  }
  /**
   * @description 创建luckysheet
   * @static
   * @param {*} options luckysheet配置
   * @memberof SheetUtil
   */
  static create(t) {
    const e = this.getLuckySheet();
    e && t && e.create(t);
  }
  /**
   * 初始化分页器
   *
   * @static
   * @param {*} config
   * @memberof SheetUtil
   */
  static pagerInit(t) {
    const e = this.getLuckySheet();
    e && e.pagerInit(t);
  }
  /**
   * 退出编辑模式
   *
   * @static
   * @return {*}
   * @memberof SheetUtil
   */
  static exitEditMode() {
    const t = this.getLuckySheet();
    if (t)
      return t.exitEditMode();
  }
  /**
   * @description 销毁
   * @static
   * @memberof SheetUtil
   */
  static destroy() {
    const t = this.getLuckySheet();
    t && t.destroy();
  }
  /**
   * @description 刷新
   * @static
   * @memberof SheetUtil
   */
  static refresh() {
    const t = this.getLuckySheet();
    t && t.refresh();
  }
  /**
   * @description 撤销
   * @static
   * @memberof SheetUtil
   */
  static undo() {
    const t = this.getLuckySheet();
    t && t.undo();
  }
  /**
   * @description 获取报表数据
   * @static
   * @memberof SheetUtil
   */
  static getSheetData() {
    const t = this.getLuckySheet();
    if (t)
      return t.getSheetData();
  }
  /**
   * @description 获取报表索引
   * @static
   * @memberof SheetUtil
   */
  static getSheetIndex(t) {
    const e = this.getLuckySheet();
    if (e)
      return e;
  }
  /**
   * @description 获取报表索引
   * @static
   * @memberof SheetUtil
   */
  static transToCellData(t) {
    const e = this.getLuckySheet();
    if (e)
      return e.transToCellData(t);
  }
  /**
   * 获取表格数据
   *
   * @static
   * @return {*}
   * @memberof SheetUtil
   */
  static getGridData() {
    let t = [];
    const e = this.getLuckySheet();
    return e && (t = e.getSheetData().map((i) => i.map((o) => o ? o.v : null))), t;
  }
  /**
   * @description 设置工作表配置
   * @param {*} config
   * @memberof SheetUtil
   */
  static setConfig(t, e = !1) {
    const s = this.getLuckySheet();
    if (e) {
      const i = Object.assign(s.getConfig(), t);
      s.setConfig(i);
    } else
      s.setConfig(t);
  }
  /**
   * @description 获取当前工作表配置
   * @static
   * @return {*}
   * @memberof SheetUtil
   */
  static getConfig() {
    const t = this.getLuckySheet();
    if (t)
      return t.getConfig();
  }
  /**
   * 设置单元格值
   *
   * @static
   * @param {number} row 行
   * @param {number} col 列
   * @param {*} value 单元格值
   * @param {boolean} [isRefresh=false] 是否刷新界面；默认为true；用于多个单元格赋值时候控制节流，前面单元格赋值的时候应设置为 false，最后一个单元格赋值时设置为true
   * @memberof SheetUtil
   */
  static setCellValue(t, e, s, i = !1) {
    const o = this.getLuckySheet();
    o && o.setCellValue(t, e, s, { isRefresh: i });
  }
  /**
   * @description 指定工作表选区是否高亮
   * @static
   * @param {*} range 选区
   * @param {*} [opt] 配置 { show: boolean, order: number, success: Function }
   * @memberof SheetUtil
   */
  static setRangeShow(t, e) {
    const s = this.getLuckySheet();
    s && s.setRangeShow(t, e);
  }
  /**
   * @description 获取列宽度
   * @static
   * @param {IParams[]} columnInfo 列下标数组
   * @param {*} [opt]
   * @memberof SheetUtil
   */
  static getColumnWidth(t, e) {
    const s = this.getLuckySheet();
    if (s && t.length > 0)
      return s.getColumnWidth(t, e);
  }
  /**
   * @description 获取行高度
   * @static
   * @param {IParams[]} rowInfo 行下标数组
   * @param {*} [opt]
   * @memberof SheetUtil
   */
  static getRowHeight(t, e) {
    const s = this.getLuckySheet();
    if (s && t.length > 0)
      return s.getRowHeight(t, e);
  }
  /**
   * @description 获取默认行高
   * @static
   * @memberof SheetUtil
   */
  static getDefaultRowHeight() {
    const t = this.getLuckySheet();
    return t ? t.getDefaultRowHeight() : 20;
  }
  /**
   * @description 清空所有
   * @static
   * @memberof SheetUtil
   */
  static clearAll() {
    const t = this.getLuckySheet();
    if (t) {
      const e = u.getTotalRow(), s = u.getTotalColumn();
      t.clearRange({
        range: { row: [0, e - 1], column: [0, s - 1] }
      });
    }
  }
  /**
   * @description 获取元素
   * @static
   * @param {string} tag 元素标识
   * @return {*}
   * @memberof SheetUtil
   */
  static getElement(t) {
    return window.$("".concat(t));
  }
  /**
   * 设置列
   *
   * @param {IParams} sheetOps
   * @param {IParams} columnOpt
   * @memberof SheetUtil
   */
  static setColumn(t, e) {
    const s = t.data[0];
    Object.assign(s, e);
  }
  /**
   * 设置头部单元格数据
   *
   * @param {IParams} sheetOps
   * @param {IParams[]} headers
   * @memberof SheetUtil
   */
  static setHeaderCell(t, e) {
    const { data: s } = t.data[0];
    s[0] = e;
  }
  /**
   * 添加钩子
   *
   * @static
   * @param {*} config
   * @param {*} hook
   * @memberof SheetUtil
   */
  static addHook(t, e) {
    Object.assign(t.hook, e);
  }
  /**
   * 添加自定义事件
   *
   * @static
   * @param {string} tag
   * @param {string} action
   * @param {*} callback
   * @memberof SheetUtil
   */
  static addCustomEvent(t, e, s) {
    const i = document.querySelector(t);
    i && i.addEventListener(e, s);
  }
  /**
   * 获取总列数
   *
   * @static
   * @memberof SheetUtil
   */
  static getTotalColumn() {
    let t = 60;
    const e = this.getLuckySheet();
    if (e) {
      const s = e.getSheetData();
      s && s[0] && (t = s[0].length);
    }
    return t;
  }
  /**
   * 获取总行数
   *
   * @static
   * @return {*}
   * @memberof SheetUtil
   */
  static getTotalRow() {
    let t = 85;
    const e = this.getLuckySheet();
    if (e) {
      const s = e.getSheetData();
      s && (t = s.length);
    }
    return t;
  }
  /**
   * 获取对应类型数据
   *
   * @static
   * @param {*} value
   * @param {string} type
   * @memberof SheetUtil
   */
  static getValueByType(t, e) {
    if (!t)
      return t;
    switch (e) {
      case "string":
        return t.toString();
      case "number":
        return Number(t);
      case "boolean":
        return !!t;
      default:
        return t;
    }
  }
  /**
   * 设置筛选范围
   *
   * @static
   * @memberof SheetUtil
   */
  static setRangeFilter(t, e) {
    const s = this.getLuckySheet();
    s && s.setRangeFilter("open", {
      range: { row: [0, t], column: [0, e] }
    });
  }
  /**
   * 获取sheet文件
   *
   * @static
   * @return {*}
   * @memberof SheetUtil
   */
  static getLuckysheetFile() {
    const t = this.getLuckySheet();
    if (t)
      return t.getLuckysheetfile()[0];
  }
  /**
   * @description 插入行
   * @static
   * @param {number} index
   * @return {*}
   * @memberof SheetUtil
   */
  static insertRow(t) {
    const e = this.getLuckySheet();
    if (e)
      return e.insertRow(t);
  }
  /**
   * @description 删除行
   * @static
   * @param {number} start
   * @param {number} end
   * @memberof SheetUtil
   */
  static deleteRow(t, e) {
    const s = this.getLuckySheet();
    if (s)
      return s.deleteRow(t, e);
  }
  /**
   * @description 设置行背景
   * @static
   * @memberof SheetUtil
   */
  static setRangeBg(t, e) {
    const { row: s, column: i } = t, o = this.getSheetData();
    if (o)
      for (let a = s[0]; a <= s[1]; a++)
        o[a].forEach((d, h) => {
          h >= i[0] && h <= i[1] && d && (Object.assign(d, { bg: e }), this.setCellValue(
            a,
            h,
            d,
            a === s[1] && h === i[1]
          ));
        });
  }
}
function V(c) {
  return { all: c = c || /* @__PURE__ */ new Map(), on: function(t, e) {
    var s = c.get(t);
    s ? s.push(e) : c.set(t, [e]);
  }, off: function(t, e) {
    var s = c.get(t);
    s && (e ? s.splice(s.indexOf(e) >>> 0, 1) : c.set(t, []));
  }, emit: function(t, e) {
    var s = c.get(t);
    s && s.slice().map(function(i) {
      i(e);
    }), (s = c.get("*")) && s.slice().map(function(i) {
      i(t, e);
    });
  } };
}
const R = V(), L = /* @__PURE__ */ N({
  name: "IBizLuckySheet",
  props: B(),
  emits: I(),
  setup(c, {
    emit: t
  }) {
    const e = c.controller, s = P("lucky-sheet-editor"), i = p(!0), o = p(""), a = "lucky-sheet-editor-".concat(W()), S = JSON.stringify([{
      name: "sheet1",
      // 工作表名称
      color: "",
      // 工作表颜色
      index: 0,
      // 工作表索引
      status: 1,
      // 激活状态
      order: 0,
      // 工作表的下标
      hide: 0,
      // 是否隐藏
      row: 100,
      // 行数
      column: 20,
      // 列数
      defaultRowHeight: 19,
      // 自定义行高
      defaultColWidth: 73,
      // 自定义列宽
      celldata: []
    }]), E = ((n, l) => {
      let g = 0, w;
      return (...C) => {
        const y = Date.now();
        y - g >= l ? (g = y, n.apply(this, C)) : (clearTimeout(w), w = setTimeout(() => {
          g = y, n.apply(this, C);
        }, l - (y - g)));
      };
    })(() => {
      if (c.readonly || c.disabled)
        return;
      const l = u.getLuckySheet().getAllSheets();
      t("change", JSON.stringify(l));
    }, 1e3), k = {
      container: a,
      // 设定DOM容器的id
      lang: "zh",
      // 设定表格语言showtoolbar: false,
      data: [],
      hook: {},
      allowEdit: !c.readonly && !c.disabled,
      // 是否允许编辑
      showtoolbar: !c.readonly && !c.disabled
      // 工具栏在只读或禁用下不显示
    }, b = () => {
      u.loadLuckySheet().then(() => {
        Object.assign(k, {
          data: JSON.parse(o.value)
        }), u.create(k), i.value = !1;
      }).catch(() => {
      });
    }, v = () => {
      u.addHook(k, {
        cellRenderAfter: () => {
          E();
        }
      });
    }, f = () => {
      i.value = !0, v(), b();
    };
    return f(), M(() => c.value, (n, l) => {
      n !== l ? (n ? o.value = n : o.value = S, (c.readonly || c.disabled) && f()) : n === void 0 && l === void 0 && (o.value = S);
    }, {
      immediate: !0
    }), U(() => {
      window.luckySheetList || (window.luckySheetList = []);
      const n = window.luckySheetList;
      n.push(a), R.on("luckysheet", () => {
        n && n.length > 0 && n[n.length - 1] === a && f();
      });
    }), A(() => {
      const n = window.luckySheetList.indexOf(a);
      n > -1 && window.luckySheetList.splice(n, 1), R.emit("luckysheet");
    }), {
      c: e,
      ns: s,
      uuid: a,
      loading: i
    };
  },
  render() {
    return D("div", {
      class: [this.ns.b("container")]
    }, [F(D("div", {
      class: this.ns.b(),
      id: this.uuid
    }, null), [[J("loading"), this.loading]])]);
  }
}), Y = z(L, function(c) {
  c.component(L.name, L), j(
    "EDITOR_CUSTOMSTYLE_LUCKYSHEET",
    () => new G()
  );
}), Z = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(c) {
    c.use(Y);
  }
};
export {
  Y as IBizLuckySheet,
  Z as default
};
