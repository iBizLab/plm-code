import './style.css';
var q = Object.defineProperty;
var J = (c, f, a) => f in c ? q(c, f, { enumerable: !0, configurable: !0, writable: !0, value: a }) : c[f] = a;
var y = (c, f, a) => (J(c, typeof f != "symbol" ? f + "" : f, a), a);
import { useNamespace as K, useControlController as W, withInstall as Q } from "@ibiz-template/vue3-util";
import { FormController as H, ControlVO as O, EditFormService as X, ScriptFactory as M, FormNotifyState as A, calcDeCodeNameById as V, hasDeCodeName as Y, Srfuf as U, calcNavParams as Z, registerControlProvider as tt } from "@ibiz-template/runtime";
import { defineComponent as at, ref as b, watch as F, reactive as et, createVNode as r, createTextVNode as I, resolveComponent as g, isVNode as it, h as B } from "vue";
import { debounce as st, clone as S, isNil as ot } from "lodash-es";
import { awaitTimeout as rt, RuntimeError as P, mergeInLeft as G, IBizContext as nt, isElementSame as dt } from "@ibiz-template/core";
class ct {
  constructor() {
    y(this, "component", "IBizFormDataComparison");
  }
}
class lt extends H {
  constructor() {
    super(...arguments);
    /**
     * 编辑表单服务
     * @author lxm
     * @date 2023-05-15 11:03:34
     * @type {EditFormService}
     */
    y(this, "service");
    /**
     *   基础数据
     *
     * @author fangZhiHao
     * @date 2024-04-26 17:04:49
     * @type {IData}
     */
    y(this, "baseResData", []);
    /**
     *   对比数据
     *
     * @author fangZhiHao
     * @date 2024-04-26 17:04:49
     * @type {IData}
     */
    y(this, "compareResData", []);
    /**
     * 表单旧数据
     *
     * @author zk
     * @date 2023-12-20 11:12:43
     * @protected
     * @type {IData}
     * @memberof FormController
     */
    y(this, "oldData", new O());
    /**
     * version数据
     *
     * @author fangZhiHao
     * @date 2024-04-26 16:04:37
     * @type {IData[]}
     */
    y(this, "versionData", []);
    /**
     *  对比数据
     *
     * @author fangZhiHao
     * @date 2024-04-26 16:04:37
     * @type {IData[]}
     */
    y(this, "comparisonArr", {});
    /**
     *  关系界面数据
     *
     * @author fangZhiHao
     * @date 2024-04-30 10:04:33
     * @type {IData}
     */
    y(this, "AlldruipartData", /* @__PURE__ */ new Map());
    // 基础表格数据
    y(this, "gridData", []);
    // 展示完全数据
    y(this, "AllGridData", []);
    // 去除相同数据
    y(this, "removeSameGridData", []);
    y(this, "druipartDataSize", 0);
    y(this, "newDruipartData", {});
  }
  get view() {
    return this.ctx.view;
  }
  /**
   * 初始化方法
   *
   * @author lxm
   * @date 2022-08-22 22:08:16
   * @protected
   * @returns {*}  {Promise<void>}
   */
  async onCreated() {
    await super.onCreated(), this.service = new X(this.model), await this.service.init(this.context), this.autoSave = st(this.autoSave.bind(this), 500, {
      trailing: !0
    });
  }
  async getVersion() {
    var l;
    const { REQUESTMETHOD: a, REQUESTPARAMS: t, REQUESTURL: e, RESPONSEMAP: i } = (l = this.model.controlParam) == null ? void 0 : l.ctrlParams, s = a || "post", o = M.execScriptFn(
      { context: this.context, params: this.params },
      t,
      { singleRowReturn: !0 }
    ), h = await ibiz.net[s](e, {
      n_owner_id_eq: o
    }), d = JSON.parse(i), w = [];
    h.data.forEach((u) => {
      const R = {};
      for (const C in d)
        R[C] = u[d[C]];
      w.push(R);
    }), this.versionData = w;
  }
  async onMounted() {
    await super.onMounted(), await this.getVersion(), this.model.deformPages && this.model.deformPages[0].deformDetails && this.calcGridData(this.model.deformPages[0].deformDetails), !this.state.isSimple && this.state.loadDefault && this.load();
  }
  /**
   *  设置关系界面数据
   *
   * @author fangZhiHao
   * @date 2024-04-30 10:04:15
   * @param {string} version
   * @param {string} name
   * @param {IData} data
   */
  calcAlldruipartData(a, t, e) {
    this.AlldruipartData.set("".concat(a).concat(t), e);
  }
  setdruipartData(a) {
    const t = "".concat(a.context.version).concat(a.context.versionItemName);
    if (this.AlldruipartData.get(t)) {
      this.druipartDataSize += 1;
      const e = this.AlldruipartData.get(t).getController("list"), { version: i } = a.context;
      this.newDruipartData[a.context.versionItemName] ? Object.assign(this.newDruipartData[a.context.versionItemName], {
        [i]: e.state.items
      }) : (this.newDruipartData[a.context.versionItemName] = {}, Object.assign(this.newDruipartData[a.context.versionItemName], {
        [i]: e.state.items
      }));
    }
    if (this.druipartDataSize === this.AlldruipartData.size) {
      console.log("计算关系界面的差异");
      const e = this.duripartDifference();
      this.calcCategorduriptData(this.AllGridData, e);
      const i = S(this.AllGridData);
      this.removeSameGridData = this.removeSame(i);
    }
  }
  duripartDifference() {
    const a = { added: [], deleted: [], modified: [] };
    for (const t in this.newDruipartData) {
      const e = this.newDruipartData[t], { base: i, compare: s } = e;
      this.isFalseyButNotEmpty(i) ? this.isFalseyButNotEmpty(s) || a.added.push(t) : this.isFalseyButNotEmpty(i) || (this.isFalseyButNotEmpty(s) ? this.isFalseyButNotEmpty(s) && a.deleted.push(t) : JSON.stringify(i) !== JSON.stringify(s) && a.modified.push(t));
    }
    return a;
  }
  /**
   *  计算duriput样式
   *
   * @author fangZhiHao
   * @date 2024-04-26 18:04:56
   * @param {IData[]} data
   */
  calcCategorduriptData(a, t) {
    a.forEach((e) => {
      if (e.detailType === "DRUIPART") {
        const i = this.caleduriptCategory(e.name, t);
        e.category = i;
      }
      e.detailType === "GROUPPANEL" && e.slot.length > 0 && this.calcCategorduriptData(e.slot, t);
    });
  }
  caleduriptCategory(a, t) {
    return t.added.includes(a) ? "added" : t.modified.includes(a) ? "modified" : t.deleted.includes(a) ? "deleted" : "samed";
  }
  /**
   *  计算属性类别
   *
   * @author fangZhiHao
   * @date 2024-04-26 18:04:42
   * @param {string} codeName
   * @return {*}
   */
  caleCategory(a) {
    return this.comparisonArr.added.includes(a) ? "added" : this.comparisonArr.modified.includes(a) ? "modified" : this.comparisonArr.deleted.includes(a) ? "deleted" : "samed";
  }
  /**
   *  计算表单分组
   *
   * @author fangZhiHao
   * @date 2024-04-26 18:04:07
   * @param {IDEFormDetail[]} data
   * @return {*}
   */
  calcGroupPanel(a) {
    const t = [];
    return a.forEach((e) => {
      e.hidden !== !0 && (e.detailType === "FORMITEM" && t.push({
        detailType: e.detailType,
        caption: e.caption,
        name: e.codeName,
        oldItem: e,
        newItem: e
      }), e.detailType === "DRUIPART" && t.push({
        detailType: e.detailType,
        caption: e.caption,
        name: e.codeName,
        oldItem: e,
        newItem: e
      }), e.detailType === "MDCTRL" && t.push({
        detailType: e.detailType,
        caption: e.caption,
        name: e.codeName,
        oldItem: e,
        newItem: e
      }));
    }), t;
  }
  /**
   *  计算表格
   *
   * @author fangZhiHao
   * @date 2024-04-26 18:04:07
   * @param {IDEFormDetail[]} data
   * @return {*}
   */
  calcGridData(a) {
    a.forEach((t) => {
      if (t.hidden !== !0) {
        if (t.detailType === "FORMITEM" && this.gridData.push({
          detailType: t.detailType,
          caption: t.caption,
          name: t.codeName,
          oldItem: t,
          newItem: t
        }), t.detailType === "GROUPPANEL") {
          let e = null;
          t.deformDetails && (e = this.calcGroupPanel(t.deformDetails)), this.gridData.push({
            detailType: t.detailType,
            caption: t.caption,
            slot: e
          });
        }
        t.detailType === "DRUIPART" && this.gridData.push({
          detailType: t.detailType,
          caption: t.caption,
          name: t.codeName,
          oldItem: t,
          newItem: t
        });
      }
    });
  }
  /**
   *  计算类别样式
   *
   * @author fangZhiHao
   * @date 2024-04-26 18:04:56
   * @param {IData[]} data
   */
  calcCategoryGridData(a) {
    a.forEach((t) => {
      if (t.detailType === "FORMITEM") {
        const e = this.caleCategory(t.name);
        t.category = e;
      }
      if (t.detailType === "GROUPPANEL" && t.slot.length > 0 && this.calcCategoryGridData(t.slot), t.detailType === "MDCTRL") {
        const e = this.caleCategory(t.name);
        t.category = e;
      }
    });
  }
  /**
   *  去除相同项
   *
   * @author fangZhiHao
   * @date 2024-04-26 18:04:56
   * @param {IData[]} data
   */
  removeSame(a) {
    const t = [];
    return a.forEach((e) => {
      if (e.detailType === "FORMITEM" && e.category !== "samed" && t.push(e), e.detailType === "GROUPPANEL") {
        const i = [];
        e.slot.length > 0 && e.slot.forEach((s) => {
          (s.detailType === "FORMITEM" && s.category !== "samed" || s.detailType === "MDCTRL" && s.category !== "samed" || s.detailType === "DRUIPART" && s.category !== "samed") && i.push(s);
        }), i.length > 0 && t.push({
          caption: e.caption,
          detailType: e.detailType,
          slot: i
        });
      }
    }), t;
  }
  /**
   * 加载草稿行为
   * @author lxm
   * @date 2023-08-25 02:45:11
   * @return {*}  {Promise<IData>}
   */
  async loadDraft(a) {
    const { context: t, params: e } = this.handlerAbilityParams(a);
    let i;
    try {
      await this.startLoading(), await this.evt.emit("onBeforeLoadDraft", { params: e }), i = await this.service.getDraft(t, e);
    } catch (s) {
      throw await this.evt.emit("onLoadDraftError", void 0), this.actionNotification("GETDRAFTERROR", {
        error: s
      }), s;
    } finally {
      await this.endLoading();
    }
    return this.state.data = i.data, this.formStateNotify(A.DRAFT), await this.evt.emit("onLoadDraftSuccess", void 0), this.actionNotification("GETDRAFTSUCCESS"), this.state.isLoaded = !0, this.data;
  }
  /**
   * 拷贝模式加载数据
   *
   * @author chitanda
   * @date 2023-09-26 19:09:21
   * @return {*}  {Promise<IData>}
   */
  async copy() {
    const a = S(this.context), t = S(this.params), i = (await ibiz.hub.getAppDataEntity(
      this.model.appDataEntityId,
      this.model.appId
    )).keyAppDEFieldId;
    if (i && this.params[i]) {
      const o = V(this.model.appDataEntityId);
      a[o] = this.params[i], delete t[i], delete this.params[i], delete t.srfcopymode, delete this.params.srfcopymode;
    }
    let s;
    try {
      await this.startLoading(), await this.evt.emit("onBeforeLoad", { args: t }), s = await this.service.get(a, t);
    } catch (o) {
      throw await this.evt.emit("onLoadError", { args: o }), this.actionNotification("GETERROR", {
        error: o
      }), o;
    } finally {
      await this.endLoading();
    }
    return s.data.srfkey = void 0, s.data.tempsrfkey = ht(), this.state.modified = !1, this.state.data = s.data, this.formStateNotify(A.LOAD), await this.evt.emit("onLoadSuccess", { args: s.data }), this.actionNotification("GETSUCCESS"), this.state.isLoaded = !0, this.data;
  }
  isFalseyButNotEmpty(a) {
    return a == null || typeof a == "string" && a === "" || Array.isArray(a) && a.length === 0 || typeof a == "object" && Object.keys(a).length === 0;
  }
  compareObjectValues(a, t) {
    return JSON.stringify(a) !== JSON.stringify(t);
  }
  /**
   *  判断两个对象的差异
   *
   * @author fangZhiHao
   * @date 2024-04-26 13:04:59
   * @param {IData} oldObj
   * @param {IData} newObj
   * @return {*}
   */
  diffObjects(a, t) {
    const e = [], i = [], s = [];
    for (const o in t) {
      const h = a[o], d = t[o];
      this.isFalseyButNotEmpty(h) && !this.isFalseyButNotEmpty(d) && e.push(o);
    }
    for (const o in t) {
      const h = a[o], d = t[o];
      !this.isFalseyButNotEmpty(h) && !this.isFalseyButNotEmpty(d) && this.compareObjectValues(h, d) && i.push(o);
    }
    for (const o in a)
      if (!Object.prototype.hasOwnProperty.call(t, o) || this.isFalseyButNotEmpty(t[o])) {
        const h = a[o];
        this.isFalseyButNotEmpty(h) || s.push(o);
      }
    return {
      added: e,
      modified: i,
      deleted: s
    };
  }
  /**
   * 部件加载数据行为
   *
   * @author lxm
   * @date 2022-08-19 14:08:50
   */
  async load(a) {
    this.druipartDataSize = 0, this.newDruipartData = {}, this.AlldruipartData = /* @__PURE__ */ new Map();
    const t = this.params.srfcopymode;
    let e = "", i = "";
    const { base_version: s, compare_version: o } = this.params;
    if (e = a && a.data && a.data.baseVersion || s, i = a && a.data && a.data.compareVersion || o, this.state.isLoaded = !1, t)
      return this.copy();
    if (!Y(
      this.context,
      V(this.model.appDataEntityId)
    ))
      return this.loadDraft();
    const { context: d, params: w } = this.handlerAbilityParams(a), l = S(w);
    let u, R;
    try {
      await this.startLoading(), await this.evt.emit("onBeforeLoad", { args: l }), u = await this.service.get(
        d,
        Object.assign(l, { srfversionid: e })
      ), R = await this.service.get(
        d,
        Object.assign(l, { srfversionid: i })
      );
      const N = this.diffObjects(u.data, R.data);
      this.comparisonArr = N;
    } catch (N) {
      throw await this.evt.emit("onLoadError", { args: N }), this.actionNotification("GETERROR", {
        error: N
      }), N;
    } finally {
      await this.endLoading();
    }
    this.state.modified = !1, this.state.data = u.data, this.baseResData = u.data, this.compareResData = R.data, this.oldData = this.data.clone(), this.formStateNotify(A.LOAD), await this.evt.emit("onLoadSuccess", { args: u.data }), this.actionNotification("GETSUCCESS"), this.state.isLoaded = !0, this.AllGridData = S(this.gridData), this.calcCategoryGridData(this.AllGridData);
    const C = S(this.AllGridData);
    return this.removeSameGridData = this.removeSame(C), this.data;
  }
  /**
   * 保存表单数据
   *
   * @author lxm
   * @date 2022-08-31 22:08:40
   */
  async save(a) {
    const t = (a == null ? void 0 : a.silent) === !0;
    if (this.state.processing)
      return await rt(500, this.save.bind(this), [a]);
    if (!await this.validate())
      throw new P("请检查表单填写！");
    t || await this.startLoading();
    const { context: i, data: s } = this.handlerAbilityParams(a), o = s[0], h = o.srfuf === U.CREATE;
    let d;
    try {
      await this.evt.emit("onBeforeSave", { args: o }), d = h ? await this.service.create(i, o) : await this.service.update(i, o);
    } catch (l) {
      throw await this.evt.emit("onSaveError", { args: l }), this.actionNotification("".concat(h ? "CREATE" : "UPDATE", "ERROR"), {
        error: l
      }), l;
    } finally {
      t || await this.endLoading();
    }
    const w = (a == null ? void 0 : a.noFillBack) === !0;
    return d.data && (w ? (this.data.updatedate = d.data.updatedate, this.data.srfkey = d.data.srfkey) : G(this.data, d.data), this.oldData = this.data.clone(), this.data.tempsrfkey = this.data.srfkey), this.state.modified = !1, await this.evt.emit("onSaveSuccess", { args: d.data }), this.view.state.isClosing || this.formStateNotify(A.SAVE), t || this.actionNotification("".concat(h ? "CREATE" : "UPDATE", "SUCCESS"), {
      default: "".concat(this.data.srfmajortext || "", "保存成功")
    }), this.emitDEDataChange(h ? "create" : "update", d.data), this.data;
  }
  /**
   * 删除表单数据
   *
   * @author lxm
   * @date 2022-09-01 09:09:36
   * @returns {*}
   */
  async remove(a) {
    const { context: t, params: e } = this.handlerAbilityParams(a);
    let i, s = !1;
    if (await this.evt.emit("onBeforeRemove", { args: this.data }), this.data.srfuf === U.UPDATE) {
      if (s = await ibiz.modal.confirm({
        title: "提示",
        desc: "确认删除吗？"
      }), !s)
        return !1;
      await this.startLoading();
      try {
        i = await this.service.remove(t, e);
      } catch (o) {
        throw await this.evt.emit("onRemoveError", { args: o }), this.actionNotification("REMOVEERROR", {
          error: o
        }), o;
      } finally {
        await this.endLoading();
      }
      s = i.ok;
    }
    return this.emitDEDataChange("remove", this.data), this.state.data = new O(), this.state.modified = !1, await this.evt.emit("onRemoveSuccess", { args: this.data }), this.actionNotification("REMOVESUCCESS"), s;
  }
  /**
   * 执行返回行为
   *
   * @author lxm
   * @date 2022-09-01 09:09:36
   * @returns {*}
   */
  async goBack() {
    await this.startLoading();
    let a;
    try {
      a = await this.service.goBack(this.context, this.data);
    } finally {
      await this.endLoading();
    }
    return a.data && G(this.data, a.data), this.data;
  }
  /**
   * 表单项更新
   *
   * @author lxm
   * @date 2022-09-15 21:09:13
   * @param {string} methodName 更新实体方法
   * @param {string[]} updateItems 更新项名称集合
   */
  async updateFormItem(a) {
    var w;
    const t = (w = this.model.deformItemUpdates) == null ? void 0 : w.find(
      (l) => l.id === a
    );
    if (!t)
      throw new P("没找到".concat(a, "表单项更新"));
    const {
      appDEMethodId: e,
      defiupdateDetails: i,
      customCode: s,
      scriptCode: o,
      showBusyIndicator: h
    } = t, d = i == null ? void 0 : i.map((l) => l.id);
    try {
      h && this.startLoading();
      let l;
      if (s && o)
        l = M.execScriptFn(
          {
            ...this.getEventArgs(),
            data: this.data
          },
          o,
          {
            isAsync: !1
          }
        );
      else {
        const u = { ...this.params, ...this.data.getOrigin() };
        l = (await this.service.updateFormItem(
          e,
          this.context,
          u
        )).data;
      }
      l && (d != null && d.length) && await Promise.all(
        d.map(
          (u) => this.setDataValue(u, l[u])
        )
      );
    } finally {
      h && this.endLoading();
    }
  }
  /**
   * 工作流启动(调用前先确保调用保存)
   *
   * @author lxm
   * @date 2022-10-08 18:10:41
   * @param {IParams} [extraParams={}] 不走工作流启动视图时使用
   * @returns {*}  {Promise<void>}
   */
  async wfStart(a) {
    if (!await this.validate())
      throw new P("请检查表单填写！");
    await this.startLoading();
    const { context: e, params: i } = this.handlerAbilityParams(a);
    try {
      await this.service.wfStart(e, i, this.data), this.emitDEDataChange("update", this.data), this.emitDEDataChange("update", { srfdecodename: "SysTodo" });
    } catch (s) {
      throw this.actionNotification("WFSTARTERROR", {
        error: s
      }), s;
    } finally {
      await this.endLoading();
    }
    this.actionNotification("WFSTARTSUCCESS", { default: "流程启动成功" });
  }
  /**
   * 工作流提交(调用前先确保调用保存)
   *
   * @author lxm
   * @date 2022-10-08 18:10:56
   * @param {IParams} [extraParams={}] 不走工作流操作视图时使用
   * @returns {*}  {Promise<void>}
   */
  async wfSubmit(a) {
    if (!await this.validate())
      throw new P("请检查表单填写！");
    await this.startLoading();
    const { context: e, params: i } = this.handlerAbilityParams(a);
    try {
      await this.service.wfSubmit(e, i, this.data), this.emitDEDataChange("update", this.data), this.emitDEDataChange("update", { srfdecodename: "SysTodo" });
    } catch (s) {
      throw this.actionNotification("WFSUBMITERROR", {
        error: s
      }), s;
    } finally {
      await this.endLoading();
    }
    this.actionNotification("WFSUBMITSUCCESS", { default: "流程提交成功" });
  }
  async dataChangeNotify(a) {
    await super.dataChangeNotify(a), this.autoSave();
  }
  /**
   * 自动保存
   * @author lxm
   * @date 2023-08-23 05:44:48
   * @return {*}  {Promise<void>}
   */
  async autoSave() {
    if (!this.model.enableAutoSave)
      return;
    const { autoSaveMode: a } = this.model, t = { silent: !0, noFillBack: !0 };
    switch (a) {
      case 3:
        t.data = this.getDiffData(), t.context = nt.create({ srfsimple: !0 });
        break;
    }
    try {
      await this.save(t);
    } catch (e) {
      ibiz.log.error(e);
    }
  }
  /**
   * 比较旧数据跟当前数据的差异返回差异数据
   *
   * @author zk
   * @date 2023-12-20 10:12:06
   * @protected
   * @return {*}  {IData}
   * @memberof EditFormController
   */
  getDiffData() {
    const { data: a } = this.state, t = {};
    return Object.keys(a).forEach((e) => {
      Array.isArray(a[e]) ? dt(a[e], this.oldData[e]) || (t[e] = a[e]) : (a[e] !== this.oldData[e] || e === a.srfkeyfield) && (t[e] = a[e]);
    }), t.srfuf = a.srfuf, new O(t, this.oldData.$dataUIMap);
  }
  /**
   * 设置simple模式的数据
   * @author lxm
   * @date 2023-11-22 07:11:21
   * @param {IData} data
   */
  setSimpleData(a) {
    const e = this.service.toUIData(a).clone();
    this.formItems.forEach((i) => {
      Object.prototype.hasOwnProperty.call(e, i.name) || (e[i.name] = null);
    }), this.state.modified = !1, this.state.data = e, this.state.isLoaded ? this.dataChangeNotify(Object.keys(this.state.data)) : (this.formStateNotify(A.LOAD), this.state.isLoaded = !0);
  }
  /**
   * 检测实体数据变更
   *
   * @author tony001
   * @date 2024-03-28 18:03:14
   * @protected
   * @param {IPortalMessage} msg
   * @return {*}  {void}
   */
  onDEDataChange(a) {
    var t;
    if (a.subtype === "OBJECTUPDATED" && !(!ot(a.triggerKey) && a.triggerKey === this.triggerKey) && this.model.appDataEntityId) {
      const e = V(this.model.appDataEntityId);
      if (!a.data || ((t = a.data.srfdecodename) == null ? void 0 : t.toLowerCase()) !== e || a.data.srfkey !== this.data.srfkey)
        return;
      this.doNextActive(() => this.load(), { key: "load" });
    }
  }
}
function ht() {
  throw new Error("Function not implemented.");
}
function L(c) {
  return typeof c == "function" || Object.prototype.toString.call(c) === "[object Object]" && !it(c);
}
const x = /* @__PURE__ */ at({
  name: "IBizFormDataComparison",
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
    isSimple: {
      type: Boolean,
      required: !1
    },
    data: {
      type: Object,
      required: !1
    },
    loadDefault: {
      type: Boolean,
      default: !0
    }
  },
  setup(c) {
    const f = K("form-data-comparison"), a = [], t = W((...n) => new lt(...n), {
      excludePropsKeys: ["data"]
    }), e = b(""), i = b(""), {
      base_version: s,
      compare_version: o
    } = c.params;
    s && (e.value = s), o && (i.value = o), c.isSimple && (t.evt.on("onMounted", () => {
      t.setSimpleData(c.data || {});
    }), F(() => c.data, (n) => {
      const D = n || {};
      Object.keys(t.data).find((m) => D[m] !== t.data[m]) && t.setSimpleData(D);
    }, {
      deep: !0
    })), t.evt.on("onCreated", () => {
      Object.keys(t.details).forEach((D) => {
        const p = t.details[D];
        p.state = et(p.state);
      });
    });
    const h = b(!1), d = b([]), w = b([]), l = (n, D) => {
      const p = t.formItems.find((v) => v.name === n.codeName);
      let m = "";
      n.codeName && (m = D[n.codeName]);
      let E = null;
      if (p) {
        const v = {
          value: m,
          data: t.data,
          controller: p.editor,
          readonly: !0
        };
        if (p.editorProvider) {
          const T = g(p.editorProvider.formEditor);
          E = B(T, {
            ...v
          });
        }
      }
      return E;
    };
    F(() => e.value, () => {
      t.load({
        data: {
          baseVersion: e.value,
          compareVersion: i.value
        }
      });
    }), F(() => i.value, () => {
      t.load({
        data: {
          baseVersion: e.value,
          compareVersion: i.value
        }
      });
    });
    const u = (n, D, p, m) => {
      const {
        navigateContexts: E,
        navigateParams: v
      } = n, T = {
        navContexts: E,
        navParams: v
      }, k = {
        context: p,
        params: m,
        data: D
      }, {
        resultContext: j,
        resultParams: z
      } = Z(T, k), _ = Object.assign(p.clone(), j, {
        currentSrfNav: n.id
      }), $ = {
        ...m,
        ...z
      };
      return {
        newContext: _,
        newParams: $
      };
    }, R = (n) => {
      t.calcAlldruipartData(n.context.version, n.context.versionItemName, n.view);
    }, C = (n) => {
      t.setdruipartData(n);
    };
    return {
      baseVersion: e,
      compareVersion: i,
      switchValue: h,
      c: t,
      ns: f,
      gridData: w,
      formItems: a,
      activeNames: d,
      renderEditor: l,
      renderDruipart: (n, D, p) => {
        const m = t.context.clone(), E = S(D);
        Object.assign(m, E);
        const {
          newContext: v,
          newParams: T
        } = u(n, E, m, {});
        return Object.assign(v, {
          version: p
        }, {
          versionItemName: n.codeName
        }), B(g("IBizViewShell"), {
          context: v,
          params: T,
          key: n.id,
          viewId: n.appViewId,
          onCreated: R,
          onDataChange: C
        });
      },
      renderMdctrl: (n, D) => {
        const p = t.formMDCtrls.find((v) => n.codeName === v.name), m = S(p), {
          codeName: E
        } = n;
        return n.contentType === "REPEATER" ? r("div", null, [D[E] && D[E].map((v) => r("div", null, [n.deformDetails && n.deformDetails.map((T) => r("div", null, [v[T.codeName]]))]))]) : r(g("iBizFormMDCtrl"), {
          modelData: m.model,
          controller: m
        }, null);
      }
    };
  },
  render() {
    let c, f, a;
    if (this.c.state.isLoaded)
      this.switchValue ? this.gridData = this.c.removeSameGridData : this.gridData = this.c.AllGridData;
    else
      return null;
    return r("div", {
      class: [this.ns.b()]
    }, [r("div", {
      class: this.ns.e("top-hidesame-content")
    }, [r("div", {
      class: this.ns.e("top-hidesame-content-left")
    }, [I("隐藏相同项 "), r(g("el-switch"), {
      modelValue: this.switchValue,
      "onUpdate:modelValue": (t) => this.switchValue = t
    }, null)]), r("div", {
      class: this.ns.e("top-hidesame-content-right")
    }, [r("div", {
      class: this.ns.e("top-hidesame-content-right-item")
    }, [I("新增"), r("div", {
      class: this.ns.e("top-hidesame-content-right-item-add")
    }, null)]), r("div", {
      class: this.ns.e("top-hidesame-content-right-item")
    }, [I("修改"), r("div", {
      class: this.ns.e("top-hidesame-content-right-item-change")
    }, null)]), r("div", {
      class: this.ns.e("top-hidesame-content-right-item")
    }, [I("删除"), r("div", {
      class: this.ns.e("top-hidesame-content-right-item-delete")
    }, null)])])]), r("div", {
      class: this.ns.e("top-content")
    }, [r("div", {
      class: this.ns.e("top-content-left")
    }, [r("div", {
      class: this.ns.e("top-content-left-attribute")
    }, [I("属性")]), r("div", {
      class: this.ns.e("top-content-left-version")
    }, [I("版本号")])]), r("div", {
      class: [this.ns.e("top-content-choose"), this.baseVersion !== this.compareVersion ? "modified" : ""]
    }, [r(g("el-select"), {
      modelValue: this.baseVersion,
      "onUpdate:modelValue": (t) => this.baseVersion = t,
      size: "large",
      class: this.ns.e("top-content-choose-select")
    }, L(c = this.c.versionData.map((t) => r(g("el-option"), {
      key: t.id,
      label: t.label,
      value: t.id
    }, null))) ? c : {
      default: () => [c]
    })]), r("div", {
      class: [this.ns.e("top-content-choose"), this.baseVersion !== this.compareVersion ? "modified" : ""]
    }, [r(g("el-select"), {
      modelValue: this.compareVersion,
      "onUpdate:modelValue": (t) => this.compareVersion = t,
      size: "large",
      class: this.ns.e("top-content-choose-select")
    }, L(f = this.c.versionData.map((t) => r(g("el-option"), {
      key: t.id,
      label: t.label,
      value: t.id
    }, null))) ? f : {
      default: () => [f]
    })])]), r(g("el-collapse"), {
      modelValue: this.activeNames,
      "onUpdate:modelValue": (t) => this.activeNames = t
    }, L(a = this.gridData.map((t) => {
      if (t.detailType === "FORMITEM")
        return r("div", {
          class: [this.ns.e("mid-content"), t.category]
        }, [r("div", {
          class: this.ns.e("mid-content-left")
        }, [t.caption]), r("div", {
          class: this.ns.e("mid-content-item")
        }, [this.renderEditor(t.oldItem, this.c.baseResData)]), r("div", {
          class: this.ns.e("mid-content-item")
        }, [this.renderEditor(t.newItem, this.c.compareResData)])]);
      if (t.detailType === "GROUPPANEL")
        return r(g("el-collapse-item"), {
          class: this.ns.e("collapse-item"),
          title: t.caption
        }, {
          default: () => [t.slot && t.slot.map((e) => r("div", {
            class: [this.ns.e("mid-content"), "slot", e.category]
          }, [r("div", {
            class: [this.ns.e("mid-content-left"), "slot"]
          }, [e.caption]), r("div", {
            class: this.ns.e("mid-content-item")
          }, [e.detailType === "FORMITEM" && this.renderEditor(e.oldItem, this.c.baseResData), e.detailType === "DRUIPART" && this.renderDruipart(e.oldItem, this.c.baseResData, "base"), e.detailType === "MDCTRL" && this.renderMdctrl(e.oldItem, this.c.baseResData)]), r("div", {
            class: this.ns.e("mid-content-item")
          }, [e.detailType === "FORMITEM" && this.renderEditor(e.newItem, this.c.compareResData), e.detailType === "DRUIPART" && this.renderDruipart(e.newItem, this.c.compareResData, "compare"), e.detailType === "MDCTRL" && this.renderMdctrl(e.newItem, this.c.compareResData)])]))]
        });
    })) ? a : {
      default: () => [a]
    })]);
  }
}), pt = Q(
  x,
  // eslint-disable-next-line func-names
  function(c) {
    c.component(x.name, x), tt(
      "EDITFORM_RENDER_FORM_DATA_COMPARISON",
      () => new ct()
    );
  }
), Et = {
  // eslint-disable-next-line @typescript-eslint/explicit-module-boundary-types, @typescript-eslint/explicit-function-return-type
  install(c) {
    c.use(pt);
  }
};
export {
  pt as IBizFormDataComparison,
  Et as default
};
