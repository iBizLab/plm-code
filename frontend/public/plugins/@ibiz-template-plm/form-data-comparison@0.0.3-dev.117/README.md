# 表单数据对比插件

该插件基于编辑表单组件增强，主要是实现数据不同版本之间对比差异。


## 页面展示

![scene](./public/assets/images/scene.png)


## 主要逻辑

1. 部件初始化时会请求下拉版本数据，并由表单分页模型计算出表格模型。
2. 部件请求数据，分别请求基础版本数据及对比版本数据。随后计算各属性是否修改，新增，删除生成属性差异数组。
3. 根据计算出的表格模型及属性差异数组计算出表格完全数据。
4. 根据表格完全数据去除相同数据项。


## 附录

### 表单数据对比插件

```json
[
  {
    "plugintype": "EDITFORM_RENDER",
    "codename": "UsrPFPlugin0425122898",
    "plugintag": "FORM_DATA_COMPARISON",
    "pssyspfpluginname": "编辑表单数据对比"
  }
]
```
