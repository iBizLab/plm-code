export default {
  codeName: 'scrum_back_log_app_data_upload_view',
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
                            '<table style="border-collapse: collapse; width: 100%; height: 381px;" border="1">\n<tbody>\n<tr style="height: 21px;">\n<td style="width: 49.5098%; height: 21px;">属性（带"<span class="text-danger ng-star-inserted">*</span>"的为必填项）</td>\n<td style="width: 49.5098%; height: 21px;">填写规则</td>\n<td style="width: 9.59885%;">&nbsp;</td>\n</tr>\n<tr style="height: 30px;">\n<td style="width: 49.5098%; height: 30px;">工作项类型<span class="text-danger ng-star-inserted">*</span></td>\n<td style="width: 49.5098%; height: 30px;"><span class="text-danger ng-star-inserted">必填项，</span>可选值：史诗、特性、用户故事。</td>\n<td style="width: 9.59885%;">&nbsp;</td>\n</tr>\n<tr>\n<td style="width: 49.5098%;">标题<span class="text-danger ng-star-inserted">*</span></td>\n<td style="width: 49.5098%;"><span class="text-danger ng-star-inserted">必填项，</span>不可为空。存在父子关系时，按照子工作项标题在前加&ldquo;&rarr;&rdquo;；二级子工作项标题前加&ldquo;&rarr;&rarr;&rdquo;的格式填写，并且子工作项跟随父工作项。</td>\n<td style="width: 9.59885%;">&nbsp;</td>\n</tr>\n<tr style="height: 30px;">\n<td style="width: 49.5098%; height: 30px;">状态</td>\n<td style="width: 49.5098%; height: 30px;">填写需求状态：可选值为当前工作项类型可选的状态，为空时默认为初始状态。</td>\n<td style="width: 9.59885%;">&nbsp;</td>\n</tr>\n<tr style="height: 30px;">\n<td style="width: 49.5098%; height: 30px;">负责人</td>\n<td style="width: 49.5098%; height: 30px;">填写团队成员的姓名，若团队中有重名的成员默认随机选择其中一位成员。</td>\n<td style="width: 9.59885%;">&nbsp;</td>\n</tr>\n<tr style="height: 30px;">\n<td style="width: 49.5098%; height: 30px;">开始时间</td>\n<td style="width: 49.5098%; height: 30px;">填写格式为 YYYY-MM-DD TT:TT，如&ldquo;1945-09-02 09:00&rdquo;，具体时刻可选填。</td>\n<td style="width: 9.59885%;">&nbsp;</td>\n</tr>\n<tr style="height: 30px;">\n<td style="width: 49.5098%; height: 30px;">结束时间</td>\n<td style="width: 49.5098%; height: 30px;">填写格式为 YYYY-MM-DD TT:TT，如&ldquo;1949-10-01 14:00&rdquo;，具体时刻可选填。</td>\n<td style="width: 9.59885%;">&nbsp;</td>\n</tr>\n<tr style="height: 30px;">\n<td style="width: 49.5098%; height: 30px;">描述</td>\n<td style="width: 49.5098%; height: 30px;">文本。</td>\n<td style="width: 9.59885%;">&nbsp;</td>\n</tr>\n<tr style="height: 30px;">\n<td style="width: 49.5098%; height: 30px;">关注人</td>\n<td style="width: 49.5098%; height: 30px;">填写团队成员的姓名，若团队中有重名的成员默认随机选择其中一位成员，填写多个值时，请用"，"隔开。</td>\n<td style="width: 9.59885%;">&nbsp;</td>\n</tr>\n<tr style="height: 30px;">\n<td style="width: 49.5098%; height: 30px;">优先级</td>\n<td style="width: 49.5098%; height: 30px;">可选值：最高、较高、普通、较低、最低</td>\n<td style="width: 9.59885%;">&nbsp;</td>\n</tr>\n<tr style="height: 30px;">\n<td style="width: 49.5098%; height: 30px;">标签</td>\n<td style="width: 49.5098%; height: 30px;">标签支持多个导入，需要导入系统内存在的标签，并使用&ldquo;，&rdquo;隔开。</td>\n<td style="width: 9.59885%;">&nbsp;</td>\n</tr>\n<tr style="height: 30px;">\n<td style="width: 49.5098%; height: 30px;">风险</td>\n<td style="width: 49.5098%; height: 30px;">可选值：高、中、低。</td>\n<td style="width: 9.59885%;">&nbsp;</td>\n</tr>\n<tr style="height: 30px;">\n<td style="width: 49.5098%; height: 30px;">需求来源</td>\n<td style="width: 49.5098%; height: 30px;">可选值：产品规划、用户反馈、内部需求、竞品调研、其他。</td>\n<td style="width: 9.59885%;">&nbsp;</td>\n</tr>\n<tr>\n<td style="width: 49.5098%;">需求类型</td>\n<td style="width: 49.5098%;">可选值：技术需求、功能需求、安全需求、体验优化。</td>\n<td style="width: 9.59885%;">&nbsp;</td>\n</tr>\n<tr>\n<td style="width: 49.5098%;">迭代</td>\n<td style="width: 49.5098%;">仅用户故事填写有效，只能填写项目中未完成的迭代。</td>\n<td style="width: 9.59885%;">&nbsp;</td>\n</tr>\n</tbody>\n</table>',
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
    codeName: 'usr0423811806',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: 'ScrumBackLogAppDataUploadView',
    controlLogics: [
      {
        eventNames: 'onClick',
        itemName: 'dowmload_button',
        logicTag: 'layoutpanel',
        logicType: 'SCRIPT',
        scriptCode: 'view.downloadTemplate()',
        triggerType: 'CTRLEVENT',
        id: 'logic_download',
      },
      {
        eventNames: 'onClick',
        itemName: 'upload_raw',
        logicTag: 'layoutpanel',
        logicType: 'SCRIPT',
        scriptCode: 'view.selectAndImport()',
        triggerType: 'CTRLEVENT',
        id: 'logic_upload',
      },
    ],
    controlParam: {},
    modelId: '16ff752b6ddc10232c38c9451189fc85',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'usr0423811806',
  },
  title: 'Scrum需求应用数据导入视图',
  viewStyle: 'DEFAULT',
  viewType: 'APPDATAUPLOADVIEW',
  showCaptionBar: true,
  modelId: 'c5d51f96fff90ebe98be1950c12ffaa2',
  modelType: 'PSAPPUTILVIEW',
  name: 'ScrumBackLogAppDataUploadView',
  id: 'plmweb.scrum_back_log_app_data_upload_view',
};
