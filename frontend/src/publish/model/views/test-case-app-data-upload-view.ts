export default {
  codeName: 'test_case_app_data_upload_view',
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
                    '<p>下载模板</p>\n<p>下载用例导入模板，按照以下规则填写导入数据。</p>',
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
                            '<table style="border-collapse: collapse; width: 100%; height: 421px;" border="1">\n<tbody>\n<tr style="height: 21px;">\n<td style="width: 49.5098%; height: 21px;">属性（带"<span class="text-danger ng-star-inserted">*</span>"的为必填项）</td>\n<td style="width: 49.5098%; height: 21px;">填写规则</td>\n</tr>\n<tr style="height: 106px;">\n<td style="width: 49.5098%; height: 21px;">模块</td>\n<td style="width: 49.5098%; height: 21px;">选择当前测试库中已有的模块，未选择模块的用例归属于&ldquo;无模块用例中&rdquo;。</td>\n</tr>\n<tr style="height: 21px;">\n<td style="width: 49.5098%; height: 21px;">标题<span class="text-danger ng-star-inserted">*</span></td>\n<td style="width: 49.5098%; height: 21px;"><span class="text-danger ng-star-inserted">必填项，</span>不可为空。</td>\n</tr>\n<tr style="height: 21px;">\n<td style="width: 49.5098%; height: 21px;">维护人</td>\n<td style="width: 49.5098%; height: 21px;">填写成员的姓名或用户名，若有重名的成员默认随机选择其中一位成员。</td>\n</tr>\n<tr style="height: 21px;">\n<td style="width: 49.5098%; height: 21px;">用例类型</td>\n<td style="width: 49.5098%; height: 21px;">可选值：功能测试、性能测试、配置相关、安装部署、接口测试、安全相关、兼容性测试、UI测试、其他。</td>\n</tr>\n<tr style="height: 21px;">\n<td style="width: 49.5098%; height: 21px;">重要程度</td>\n<td style="width: 49.5098%; height: 21px;">可选值：P0、P1、P2、P3、P4。</td>\n</tr>\n<tr style="height: 21px;">\n<td style="width: 49.5098%; height: 21px;">测试类型</td>\n<td style="width: 49.5098%; height: 21px;">可选值：手动、自动。</td>\n</tr>\n<tr style="height: 21px;">\n<td style="width: 49.5098%; height: 21px;">预估工时</td>\n<td style="width: 49.5098%; height: 21px;">数值类型，如 10，可为空。</td>\n</tr>\n<tr style="height: 21px;">\n<td style="width: 49.5098%; height: 21px;">剩余时间</td>\n<td style="width: 49.5098%; height: 21px;">数值类型，如 10，可为空。</td>\n</tr>\n<tr style="height: 21px;">\n<td style="width: 49.5098%; height: 21px;">前置条件</td>\n<td style="width: 49.5098%; height: 21px;">文本。</td>\n</tr>\n<tr style="height: 21px;">\n<td style="width: 49.5098%; height: 21px;">步骤描述</td>\n<td style="width: 49.5098%; height: 21px;">文本，步骤请加编号填写，如1.xxx、2.xxx；分组填写，子步骤前加&ldquo;&rarr;&rdquo;，如1.xxx、&rarr;1.xxx；每个分组或步骤单元格内换行。</td>\n</tr>\n<tr style="height: 21px;">\n<td style="width: 49.5098%; height: 21px;">预期结果</td>\n<td style="width: 49.5098%; height: 21px;">文本，保持编号与步骤对应，如1.xxx、2.xxx；分组的预期结果不用填写，子预期前加&ldquo;&rarr;&rdquo;，如1. 空、&rarr;1.xxx，每个预期结果单元格内换行。</td>\n</tr>\n<tr style="height: 21px;">\n<td style="width: 49.5098%; height: 21px;">关注人</td>\n<td style="width: 49.5098%; height: 21px;">填写成员的姓名或用户名，若有重名的成员默认随机选择其中一位成员，填写多个值时，请用"|"隔开。</td>\n</tr>\n</tbody>\n</table>',
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
                    '<p>上传文件</p>\n<p>上传需要导入的 Excel 文件，上传文件的表头字段名必须与对应用例属性一致，仅支持 xls 、 xlsx 。</p>',
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
    codeName: 'usr0422501592',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: 'TestCaseAppDataUploadView',
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
    modelId: '21AD5C62-4677-46D0-AFE2-E14FAD22562B',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'usr0422501592',
  },
  title: '测试用例应用数据导入视图',
  viewStyle: 'DEFAULT',
  viewType: 'APPDATAUPLOADVIEW',
  showCaptionBar: true,
  modelId: '4FFD6A7B-3325-4873-86D4-78E6F0D454B7',
  modelType: 'PSAPPUTILVIEW',
  name: 'TestCaseAppDataUploadView',
  id: 'plmweb.test_case_app_data_upload_view',
};
