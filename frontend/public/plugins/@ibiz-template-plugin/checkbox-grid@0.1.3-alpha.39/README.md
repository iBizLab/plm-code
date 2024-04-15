# 多选框表格

该插件是表格的插件，其目的将表格样式改为多选框样式，在选择视图中使用。**该插件隶属于部件插件（基于标准表格部件进行扩展）**。

![插件配置位置](./public/assets/images/plugin-config-location.png)

## 页面展示

![场景](./public/assets/images/scene.png)

## 基本使用

在具体项目中，先通过模型导入多选框表格插件，然后在具体的多选视图中给表格部件选择对应的前端应用插件即可复用，无其他配置，其中多选框表格插件的具体数据参见附录。

## 附录：

### 多选框表格插件

```json
[
  {
    "plugintype": "GRID_RENDER",
    "rtobjectrepo": "@ibiz-template-plugin/checkbox-grid@0.1.0",
    "codename": "UsrPFPlugin1031350626",
    "plugintag": "CHECKBOX_GRID",
    "rtobjectmode": 2,
    "memo": "1",
    "rtobjectname": "IBizCheckboxGrid",
    "pssyspfpluginname": "多选框表格插件",
    "previewhtml": "<p>插件标识: CHECKBOX_GRID</p>\n<p>运行时插件名称：IBizProcessHistory</p>\n<p>&nbsp;运行时插件仓库配置: @ibiz-template-plugin/checkbox-grid@0.0.1</p>"
  }
]
```
