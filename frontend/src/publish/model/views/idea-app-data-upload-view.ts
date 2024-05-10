export default {
  codeName: 'idea_app_data_upload_view',
  sysCss: {
    cssName: 'data-upload-view',
  },
  viewLayoutPanel: {
    viewProxyMode: true,
    layoutMode: 'FLEX',
    layout: {
      layout: 'FLEX',
    },
    rootPanelItems: [
      {
        actionGroupExtractMode: 'ITEM',
        panelItems: [
          {
            actionGroupExtractMode: 'ITEM',
            panelItems: [
              {
                rawItem: {
                  content:
                    '<p>下载模板</p>\n<p>下载需求导入模板，按照以下规则填写导入数据。</p>',
                  contentType: 'HTML',
                  predefinedType: 'STATIC_TEXT',
                  id: 'download_description',
                },
                caption: '下载模板描述',
                itemStyle: 'DEFAULT',
                itemType: 'RAWITEM',
                layoutPos: {
                  shrink: 1,
                  layout: 'FLEX',
                },
                showCaption: true,
                id: 'download_description',
              },
              {
                actionType: 'NONE',
                buttonStyle: 'PRIMARY',
                buttonType: 'PANELBUTTON',
                renderMode: 'BUTTON',
                tooltip: '下载模板',
                uiactionTarget: 'NONE',
                caption: '下载模板',
                itemStyle: 'PRIMARY',
                itemType: 'BUTTON',
                layoutPos: {
                  shrink: 1,
                  layout: 'FLEX',
                },
                sysImage: {
                  cssClass: 'fa fa-download',
                  glyph: 'xf019@FontAwesome',
                },
                showCaption: true,
                id: 'dowmload_button',
              },
            ],
            layout: {
              align: 'space-between',
              dir: 'row',
              layout: 'FLEX',
              valign: 'center',
            },
            dataRegionType: 'INHERIT',
            caption: '容器',
            itemStyle: 'DEFAULT',
            itemType: 'CONTAINER',
            layoutPos: {
              shrink: 1,
              layout: 'FLEX',
            },
            id: 'view_header',
          },
          {
            actionGroupExtractMode: 'ITEM',
            panelItems: [
              {
                actionGroupExtractMode: 'ITEM',
                panelItems: [
                  {
                    actionGroupExtractMode: 'ITEM',
                    panelItems: [
                      {
                        rawItem: {
                          content:
                            '<table style="border-collapse: collapse; width: 100%; height: 359px;" border="1">\n<tbody>\n<tr style="height: 21px;">\n<td style="width: 49.5098%; height: 21px;">属性（带"<span class="text-danger ng-star-inserted">*</span>"的为必填项）</td>\n<td style="width: 49.5098%; height: 21px;">填写规则</td>\n</tr>\n<tr style="height: 21px;">\n<td style="width: 49.5098%; height: 21px;">标题<span class="text-danger ng-star-inserted">*</span></td>\n<td style="width: 49.5098%; height: 21px;"><span class="text-danger ng-star-inserted">必填项，</span>不可为空。</td>\n</tr>\n<tr style="height: 21px;">\n<td style="width: 49.5098%; height: 21px;">状态</td>\n<td style="width: 49.5098%; height: 21px;">填写需求状态：可选值为当前需求可选的状态，为空时默认为初始状态。</td>\n</tr>\n<tr class="cdk-drag thy-sortable-item cdk-drag-disabled ng-star-inserted" style="height: 42px;">\n<td class="ng-star-inserted" style="width: 49.5098%; height: 42px;">负责人</td>\n<td class="ng-star-inserted" style="width: 49.5098%; height: 42px;">填写组织成员的姓名，若组织中有重名的成员默认随机选择其中一位成员。</td>\n</tr>\n<tr class="cdk-drag thy-sortable-item cdk-drag-disabled ng-star-inserted" style="height: 42px;">\n<td class="ng-star-inserted" style="width: 49.5098%; height: 42px;">描述</td>\n<td class="ng-star-inserted" style="width: 49.5098%; height: 42px;">文本。</td>\n</tr>\n<tr class="cdk-drag thy-sortable-item cdk-drag-disabled ng-star-inserted" style="height: 21px;">\n<td class="ng-star-inserted" style="width: 49.5098%; height: 21px;">优先级</td>\n<td class="ng-star-inserted" style="width: 49.5098%; height: 21px;">可选值：P0、P1、P2、P3、P4。</td>\n</tr>\n<tr class="cdk-drag thy-sortable-item cdk-drag-disabled ng-star-inserted" style="height: 64px;">\n<td class="ng-star-inserted" style="width: 49.5098%; height: 64px;">需求来源</td>\n<td class="ng-star-inserted" style="width: 49.5098%; height: 64px;">可选值：产品规划、用户反馈、竞品调研、内部需求。</td>\n</tr>\n<tr class="cdk-drag thy-sortable-item cdk-drag-disabled ng-star-inserted" style="height: 42px;">\n<td class="ng-star-inserted" style="width: 49.5098%; height: 42px;">需求类型</td>\n<td class="ng-star-inserted" style="width: 49.5098%; height: 42px;">可选值：功能需求、体验优化、安全需求、技术需求。</td>\n</tr>\n<tr class="cdk-drag thy-sortable-item cdk-drag-disabled ng-star-inserted" style="height: 64px;">\n<td class="ng-star-inserted" style="width: 49.5098%; height: 64px;">关注人</td>\n<td class="ng-star-inserted" style="width: 49.5098%; height: 64px;">填写组织成员的姓名，若组织中有重名的成员默认随机选择其中一位成员，填写多个值时，请用"，"隔开。</td>\n</tr>\n</tbody>\n</table>',
                          contentType: 'HTML',
                          predefinedType: 'STATIC_LABEL',
                          id: 'template_rule',
                        },
                        caption: '模板规则',
                        itemStyle: 'DEFAULT',
                        itemType: 'RAWITEM',
                        layoutPos: {
                          layoutPos: 'CENTER',
                          layout: 'BORDER',
                        },
                        showCaption: true,
                        id: 'template_rule',
                      },
                    ],
                    predefinedType: 'CONTAINER_SCROLL_MAIN',
                    layout: {
                      layout: 'BORDER',
                    },
                    dataRegionType: 'INHERIT',
                    caption: '面板容器',
                    itemStyle: 'DEFAULT',
                    itemType: 'CONTAINER',
                    layoutPos: {
                      layoutPos: 'CENTER',
                      layout: 'BORDER',
                    },
                    showCaption: true,
                    id: 'container_scroll_main',
                  },
                ],
                predefinedType: 'CONTAINER_SCROLL',
                layout: {
                  layout: 'BORDER',
                },
                dataRegionType: 'INHERIT',
                caption: '滚动条容器',
                itemStyle: 'DEFAULT',
                itemType: 'CONTAINER',
                layoutPos: {
                  shrink: 1,
                  layout: 'FLEX',
                },
                id: 'container_scroll',
              },
              {
                rawItem: {
                  content:
                    '<p>上传文件</p>\n<p>上传需要导入的 Excel 文件，上传文件的表头字段名必须与对应需求属性一致，仅支持 xls 、 xlsx 。</p>',
                  contentType: 'HTML',
                  predefinedType: 'STATIC_TEXT',
                  id: 'upload_description',
                },
                caption: '上传文件描述',
                itemStyle: 'DEFAULT',
                itemType: 'RAWITEM',
                layoutPos: {
                  shrink: 1,
                  layout: 'FLEX',
                },
                showCaption: true,
                id: 'upload_description',
              },
              {
                rawItem: {
                  content:
                    '<p>点击此处&nbsp; &lt;a&gt;<a>上传文件&lt;/a&gt;</a></p>',
                  contentType: 'HTML',
                  predefinedType: 'STATIC_TEXT',
                  id: 'upload_raw',
                },
                caption: '文本',
                itemStyle: 'DEFAULT',
                itemType: 'RAWITEM',
                layoutPos: {
                  shrink: 1,
                  layout: 'FLEX',
                },
                showCaption: true,
                id: 'upload_raw',
              },
            ],
            predefinedType: 'CONTAINER',
            layout: {
              layout: 'FLEX',
            },
            dataRegionType: 'INHERIT',
            caption: '容器',
            itemStyle: 'DEFAULT',
            itemType: 'CONTAINER',
            layoutPos: {
              shrink: 1,
              layout: 'FLEX',
            },
            id: 'view_content',
          },
        ],
        layout: {
          layout: 'FLEX',
        },
        dataRegionType: 'INHERIT',
        itemStyle: 'DEFAULT',
        itemType: 'CONTAINER',
        layoutPos: {
          shrink: 1,
          layout: 'FLEX',
          spacingBottom: 'OUTERSMALL',
          spacingLeft: 'OUTERSMALL',
          spacingRight: 'OUTERSMALL',
          spacingTop: 'OUTERSMALL',
        },
        id: 'page_container',
      },
    ],
    layoutPanel: true,
    controls: [
      {
        codeName: 'captionbar',
        controlType: 'CAPTIONBAR',
        controlParam: {},
        id: 'captionbar',
      },
    ],
    codeName: 'usr0422485702',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: 'IdeaAppDataUploadView',
    controlLogics: [
      {
        eventNames: 'onClick',
        itemName: 'dowmload_button',
        logicTag: 'layoutpanel',
        logicType: 'SCRIPT',
        scriptCode: 'view.downloadTemplate()',
        triggerType: 'CTRLEVENT',
        id: 'logic',
      },
      {
        eventNames: 'onClick',
        itemName: 'upload_raw',
        logicTag: 'layoutpanel',
        logicType: 'SCRIPT',
        scriptCode:
          'view.selectAndImport().then(result=>{\r\n    console.log("上传结果",result);\r\n})',
        triggerType: 'CTRLEVENT',
        id: 'logic2',
      },
    ],
    controlParam: {},
    modelId: '0CF09E24-F54D-4164-854B-8825E5BE2CEC',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'usr0422485702',
  },
  title: '需求应用数据导入视图',
  viewStyle: 'DEFAULT',
  viewType: 'APPDATAUPLOADVIEW',
  showCaptionBar: true,
  modelId: 'D1784474-68A5-4095-9182-C98F2DEB7A07',
  modelType: 'PSAPPUTILVIEW',
  name: 'IdeaAppDataUploadView',
  id: 'plmweb.idea_app_data_upload_view',
};
