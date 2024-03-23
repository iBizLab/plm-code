# 数据选择（管理）

数据选择（管理）是数据选择的扩展插件，其支持了自填模式-附加界面行为组、选择视图。且选中数据不会立即进行抛值，而是点击确定按钮进行抛值，点击取消将清空选中数据。**该插件隶属于编辑器自定义绘制插件（基于数据选择编辑器进行的扩展）。**

![image](./public/assets/images/scene.png)

已支持自填模式项布局面板

![image](./public/assets/images/itemlayoutpanel.png)

## 基本使用

在具体项目中，先通过模型导入前端界面插件，再导入编辑器插件，然后在具体的视图配置动态文本，然后将其编辑器类型改为数据选择，编辑器类型选择“数据选择（管理）”

然后配置关联实体与关联自填模式、选择界面视图，并在自填模式中配置附加界面行为组

## 附录：

### 编辑器插件

```json
[
  {
    "codename": "MANAGE",
    "pssyspfpluginid": "UsrPFPlugin1228363957",
    "repdefault": 0,
    "validflag": 1,
    "pssyseditorstylename": "数据选择（管理）",
    "pseditortypeid": "PICKER"
  }
]
```

### 前端界面插件

```
[
  {
    "plugintype": "EDITOR_CUSTOMSTYLE",
    "rtobjectrepo": "@ibiz-template-plugin/manage-mpicker@0.1.2-dev.0",
    "codename": "UsrPFPlugin1228363957",
    "plugintag": "MANAGE",
    "rtobjectmode": 2,
    "rtobjectname": "IBizManageMPicker",
    "pssyspfpluginname": "数据选择（管理）"
  }
]
```

