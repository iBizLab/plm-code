# 附件表格表格

附件表格是表格部件的扩展插件，扩展标识为【NUMBER_GRID】
## 页面展示
![image](./public/assets/images/scene.png)

## 功能说明

### 添加附件

- 直接调用表格实体的create方法存储数据，而不是新建行后进行保存
- 数据存储之后应刷新数据
- 数据添加之后应通知表单保存成功，触发表单自动保存

### 操作列增强

- 操作列中区别界面行为级别，关键操作平铺展示，非关键操作下拉展示
- 只点击下拉时应提前选中数据

## 附录

### 附件表格插件

```json
[
  {
    "plugintype": "GRID_RENDER",
    "rtobjectrepo": "@ibiz-template-plm/attachment-grid@0.0.2-dev.41",
    "codename": "UsrPFPlugin0103853920",
    "plugintag": "ATTACHMENT_GRID",
    "rtobjectmode": 2,
    "rtobjectname": "IBizAttachmentGridControl",
    "pssyspfpluginname": "附件表格"
  }
]
```

