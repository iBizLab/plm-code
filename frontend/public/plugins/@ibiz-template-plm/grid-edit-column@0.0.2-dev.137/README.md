# 表格列界面行为组支持获取编辑列插件

该编辑器主要是通过popover下拉的形式展示当前列配置的界面行为组以及当前行的编辑列，并允许直接使用各自的编辑器更改这些列的数据。隶属于**表格列绘制插件**。

![image-20231225115426830](./public/assets/images/image-20231225115426830.png)

![配置](./public/assets/images/image-20231225134024565.png)

## 基本使用

在具体的项目中，需要先通过模型导入该插件的数据，然后在界面行为中导入指定界面行为或者新建一个指定行为标识【GET_EDITOR_COLUMN】的界面行为，接着新建一个界面行为组，包含这个指定的界面行为，最后在具体的表格列中配置该插件以及列界面行为组即可完成复用，如果行为组中没有包含指定的界面行为，则不会获取所有的编辑列，只会展示当前列的界面行为，具体的插件数据参见附录。

## 新增输入

| 名称     | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| SAVEMODE | 列自定义参数，指定列的保存模式，可选值为【BLUR | ENTER】，未配置时默认为 ENTER |

## 行为级别判断

[界面行为行为级别] {50：不常用、 100：一般操作、 200：常用操作、 250：关键操作 }

根据行为级别显示按钮，关键操作直接显示，常用操作不显示，一般操作及不常用在下拉菜单中显示。在此插件中当前表格类型不为树表格时显示常用操作。

## 附录

### 插件数据

```
[
  {
    "plugintype": "GRID_COLRENDER",
    "rtobjectrepo": "@ibiz-template-plm/grid-edit-column@0.0.2-alpha.20",
    "codename": "UsrPFPlugin1225164493",
    "plugintag": "COLUMN_ACTION_EDIT",
    "rtobjectmode": 2,
    "rtobjectname": "IBizGridEditColumn",
    "pssyspfpluginname": "表格列界面行为支持获取编辑列"
  }
]
```

### 界面行为

```
[
  {
    "actiontarget": "NONE",
    "codename": "GET_EDITOR_COLUMN",
    "memo": "该界面行为的标识固定为【GET_EDITOR_COLUMN】，同时，该界面行为是配置插件【表格列界面行为支持获取编辑列 】共同使用",
    "psdeuiactionname": "界面行为支持获取编辑列",
    "caption": "界面行为支持获取编辑列",
    "frontprotype": "OTHER",
    "uiactiontype": "FRONT",
    "templmode": 0
  }
]
```

