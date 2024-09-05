export default {
  caption: '导入文档',
  codeName: 'article_page_upload_view',
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
                actionGroupExtractMode: 'ITEM',
                panelItems: [
                  {
                    actionGroupExtractMode: 'ITEM',
                    panelItems: [
                      {
                        rawItem: {
                          sysImage: {
                            rawContent:
                              'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACQAAAAkCAIAAABuYg/PAAACKklEQVRIDe1XvU4bQRCeHZ/5iR3JuHAKqBwUCRmlskKEKUKCKKFxlQfgGfIEeYrU1CmQUBoqFClpgqIoCogCW5ZiZAPhPzr7djPrQ/fnu9sV5lxEHl0xN+uZb77ZufEuM02TczC7YAkQAh5cGIMUgzEDEMEgpNtOIjB23kSgK8DqwGQakDglQShQIYIgIKTqDUcICIdAy6knDoeWjTICe5BqG/FRjlpsey9Vb7OoPprKiKU5XnnG4+PYqwqw3X08v4blEkcWHq1xwj7tpRZmuaGx+wqweou9KvHF6MQvbtj7j0bzD5vJqz9YRT5cMJpsMYJMYtDM0xEFMyfE7i/82fBlls+K6kvL+YGO4vOPcaCxHZC/3YBB/doXI8LlxSynJ2JR16zLLCoepqBYEBPpqHWfXZcZdV37UnoWciI77oZ4NAYbK7oF1QXb+obfa7IM5ae8uuD2xddDpL5fK7sWN5E+TRfsbcWip88dTq5Y4zT24/D4DLpnNMbolKEpuswC4Q6b7MOO6/tuU3bI63m++jyEvePrOjgmr/J4UhyfyyERyH46LzbeyL740tuz9d6e5bJe1xBdATY3LXZ+4OcDX7Wp16kDi0/koNr/DWfXYOsh4f0mBdjKvFUs8Jr8i3G55TLqmetHuXtjpxdm6EISRl99kgDwxhyBeatxb/0/LqP+ZLt39WxHAsL488yAAF53AkI6XAyBHEH0Lp8o74R0xEwIksJScHntRPgHlwCdRhGDYTsAAAAASUVORK5CYII=',
                          },
                          contentType: 'IMAGE',
                          predefinedType: 'STATIC_IMAGE',
                          rawItemHeight: 64,
                          rawItemWidth: 64,
                          id: 'static_image',
                        },
                        caption: '图片',
                        contentHeight: 64,
                        contentWidth: 64,
                        height: 64,
                        itemStyle: 'DEFAULT',
                        itemType: 'RAWITEM',
                        layoutPos: {
                          shrink: 1,
                          height: 64,
                          heightMode: 'PX',
                          layout: 'FLEX',
                          spacingBottom: 'OUTERLARGE',
                          spacingLeft: 'OUTERLARGE',
                          spacingRight: 'OUTERLARGE',
                          spacingTop: 'OUTERLARGE',
                          width: 64,
                          widthMode: 'PX',
                        },
                        sysImage: {
                          rawContent:
                            'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACQAAAAkCAIAAABuYg/PAAACKklEQVRIDe1XvU4bQRCeHZ/5iR3JuHAKqBwUCRmlskKEKUKCKKFxlQfgGfIEeYrU1CmQUBoqFClpgqIoCogCW5ZiZAPhPzr7djPrQ/fnu9sV5lxEHl0xN+uZb77ZufEuM02TczC7YAkQAh5cGIMUgzEDEMEgpNtOIjB23kSgK8DqwGQakDglQShQIYIgIKTqDUcICIdAy6knDoeWjTICe5BqG/FRjlpsey9Vb7OoPprKiKU5XnnG4+PYqwqw3X08v4blEkcWHq1xwj7tpRZmuaGx+wqweou9KvHF6MQvbtj7j0bzD5vJqz9YRT5cMJpsMYJMYtDM0xEFMyfE7i/82fBlls+K6kvL+YGO4vOPcaCxHZC/3YBB/doXI8LlxSynJ2JR16zLLCoepqBYEBPpqHWfXZcZdV37UnoWciI77oZ4NAYbK7oF1QXb+obfa7IM5ae8uuD2xddDpL5fK7sWN5E+TRfsbcWip88dTq5Y4zT24/D4DLpnNMbolKEpuswC4Q6b7MOO6/tuU3bI63m++jyEvePrOjgmr/J4UhyfyyERyH46LzbeyL740tuz9d6e5bJe1xBdATY3LXZ+4OcDX7Wp16kDi0/koNr/DWfXYOsh4f0mBdjKvFUs8Jr8i3G55TLqmetHuXtjpxdm6EISRl99kgDwxhyBeatxb/0/LqP+ZLt39WxHAsL488yAAF53AkI6XAyBHEH0Lp8o74R0xEwIksJScHntRPgHlwCdRhGDYTsAAAAASUVORK5CYII=',
                        },
                        width: 64,
                        showCaption: true,
                        id: 'static_image',
                      },
                      {
                        rawItem: {
                          content:
                            '<div style="text-align: center;"><strong>word</strong></div>\n<div style="text-align: center;">.doc</div>',
                          contentType: 'HTML',
                          id: 'static_label',
                        },
                        caption: 'word',
                        itemStyle: 'DEFAULT',
                        itemType: 'RAWITEM',
                        layoutPos: {
                          shrink: 1,
                          layout: 'FLEX',
                        },
                        showCaption: true,
                        id: 'static_label',
                      },
                    ],
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
                    id: 'container2',
                  },
                  {
                    actionGroupExtractMode: 'ITEM',
                    panelItems: [
                      {
                        rawItem: {
                          sysImage: {
                            rawContent:
                              'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACQAAAAkCAIAAABuYg/PAAAC1UlEQVRIDe2Xz28SQRTHZ2a3IL9RMPwwGGsDNL1o2saG9qIXE5OejD+P/kfeTPRujLHxx6EHY3rxF9b6I0bjr7RCq1haiiBUZNmd8SEUYdnObBPhYJyQMOy8/X7ee8x7u4MVRaEUKSrSGGIM/fWBMZIwssiIECQDqVLrCabhNwSgMqTVkG0AEYipFwHpMgQIABHIXn8GgEgfwmrlk/QnrAbl34XJ5tO4tIaXsmQ5h+HjcbCIjx3ws5EItVvMauD8d0VoW/iBb85LKzkcC9Hgbhb0snIFrxZwOoc3ynh6VBsdpEIRMBDDXqTIzBNpv4+dn1JdNr3mow9k9rkU8bMLx1SLpF/V/RbAciV8cVaeGKLTYxo0HsORLeArc/LwPnpqQjM0aF3k7UYowWsPpaCHcUggFPCy0wl1YZG8/7qNO1s0Hmwxi1eL+NxUR0zJj+TOgj5f8RAbG6T33+qvb1Ga3zxYah3HQ9Tv6mhoGyX85ZtBBIk4TeUMrrfzeLD0Ogl42415c8i2qvIMYI0H+5zHe90dYXHEZAntcQiMeUXtsLLNnwb6UGGX7zVv9LvZySPNTViuCtLIg0H9Zrr+nliYWgf+eOC2NaOBIoEnFn/wYGEve7Wsz3M0yKJBg3rK5LHME6u7oddqd238IMuX8buMIDlwi6qhuTdkMipoWjyY285OHNauPpChAbY70T2/kZSqNXT8kEHE7cY8GNglYjTgYZfuylDg7be15jUNXX8svUyTs5OaLBAz0Yjh3WsmKb1eIUdH6PgQ9blYA1tVETwHbj2VKgqGdjUcFux78E/QiFsRPPtEbs9LioagnqB+S1VU3KxDYyF2JqE6d7UMeROzMNDQKIL9DVtmrYjsVgT17ncyZ9dDh0PbAYyjYnJJ9J+alDFn9h9mLk8Cq/6mcbvXGIGTO18GEIGTWn8GgAicCfsQHCB+Hz5J/UwIPbRHSJAF8fqxk6BfU20FYNrFnxYAAAAASUVORK5CYII=',
                          },
                          contentType: 'IMAGE',
                          predefinedType: 'STATIC_IMAGE',
                          rawItemHeight: 64,
                          rawItemWidth: 64,
                          id: 'static_image1',
                        },
                        caption: '图片',
                        contentHeight: 64,
                        contentWidth: 64,
                        height: 64,
                        itemStyle: 'DEFAULT',
                        itemType: 'RAWITEM',
                        layoutPos: {
                          shrink: 1,
                          height: 64,
                          heightMode: 'PX',
                          layout: 'FLEX',
                          spacingBottom: 'OUTERLARGE',
                          spacingLeft: 'OUTERLARGE',
                          spacingRight: 'OUTERLARGE',
                          spacingTop: 'OUTERLARGE',
                          width: 64,
                          widthMode: 'PX',
                        },
                        sysImage: {
                          rawContent:
                            'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACQAAAAkCAIAAABuYg/PAAAC1UlEQVRIDe2Xz28SQRTHZ2a3IL9RMPwwGGsDNL1o2saG9qIXE5OejD+P/kfeTPRujLHxx6EHY3rxF9b6I0bjr7RCq1haiiBUZNmd8SEUYdnObBPhYJyQMOy8/X7ee8x7u4MVRaEUKSrSGGIM/fWBMZIwssiIECQDqVLrCabhNwSgMqTVkG0AEYipFwHpMgQIABHIXn8GgEgfwmrlk/QnrAbl34XJ5tO4tIaXsmQ5h+HjcbCIjx3ws5EItVvMauD8d0VoW/iBb85LKzkcC9Hgbhb0snIFrxZwOoc3ynh6VBsdpEIRMBDDXqTIzBNpv4+dn1JdNr3mow9k9rkU8bMLx1SLpF/V/RbAciV8cVaeGKLTYxo0HsORLeArc/LwPnpqQjM0aF3k7UYowWsPpaCHcUggFPCy0wl1YZG8/7qNO1s0Hmwxi1eL+NxUR0zJj+TOgj5f8RAbG6T33+qvb1Ga3zxYah3HQ9Tv6mhoGyX85ZtBBIk4TeUMrrfzeLD0Ogl42415c8i2qvIMYI0H+5zHe90dYXHEZAntcQiMeUXtsLLNnwb6UGGX7zVv9LvZySPNTViuCtLIg0H9Zrr+nliYWgf+eOC2NaOBIoEnFn/wYGEve7Wsz3M0yKJBg3rK5LHME6u7oddqd238IMuX8buMIDlwi6qhuTdkMipoWjyY285OHNauPpChAbY70T2/kZSqNXT8kEHE7cY8GNglYjTgYZfuylDg7be15jUNXX8svUyTs5OaLBAz0Yjh3WsmKb1eIUdH6PgQ9blYA1tVETwHbj2VKgqGdjUcFux78E/QiFsRPPtEbs9LioagnqB+S1VU3KxDYyF2JqE6d7UMeROzMNDQKIL9DVtmrYjsVgT17ncyZ9dDh0PbAYyjYnJJ9J+alDFn9h9mLk8Cq/6mcbvXGIGTO18GEIGTWn8GgAicCfsQHCB+Hz5J/UwIPbRHSJAF8fqxk6BfU20FYNrFnxYAAAAASUVORK5CYII=',
                        },
                        width: 64,
                        showCaption: true,
                        id: 'static_image1',
                      },
                      {
                        rawItem: {
                          content:
                            '<div style="text-align: center;"><strong>MarkDown</strong></div>\n<div style="text-align: center;"><span style="color: #7e8c8d;">.markdown .md .txt</span></div>',
                          contentType: 'HTML',
                          id: 'static_label1',
                        },
                        caption: 'MarkDown',
                        itemStyle: 'DEFAULT',
                        itemType: 'RAWITEM',
                        layoutPos: {
                          shrink: 1,
                          layout: 'FLEX',
                        },
                        showCaption: true,
                        id: 'static_label1',
                      },
                    ],
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
                    id: 'container3',
                  },
                ],
                layout: {
                  align: 'space-around',
                  dir: 'row',
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
                id: 'container',
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
        layout: {
          dir: 'column',
          layout: 'FLEX',
        },
        dataRegionType: 'INHERIT',
        itemStyle: 'DEFAULT',
        itemType: 'CONTAINER',
        layoutPos: {
          shrink: 1,
          layout: 'FLEX',
        },
        id: 'container1',
      },
    ],
    layoutPanel: true,
    controls: [
      {
        caption: '导入文档',
        codeName: 'captionbar',
        controlType: 'CAPTIONBAR',
        controlParam: {},
        id: 'captionbar',
      },
    ],
    codeName: 'usr0801795784',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: 'page_upload_view',
    controlLogics: [
      {
        eventNames: 'onClick',
        itemName: 'STATIC_IMAGE',
        logicTag: 'layoutpanel',
        logicType: 'SCRIPT',
        scriptCode: 'view.selectAndImport()',
        triggerType: 'CTRLEVENT',
        id: 'logic',
      },
      {
        eventNames: 'onClick',
        itemName: 'STATIC_IMAGE1',
        logicTag: 'layoutpanel',
        logicType: 'SCRIPT',
        scriptCode: 'view.selectAndImport()',
        triggerType: 'CTRLEVENT',
        id: 'logic2',
      },
    ],
    controlParam: {},
    modelId: '96D839B9-8047-42ED-91E1-55E5189C7F84',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'usr0801795784',
  },
  title: '应用数据导入视图',
  viewStyle: 'DEFAULT',
  viewType: 'APPDATAUPLOADVIEW',
  showCaptionBar: true,
  modelId: '893F8D60-7BC0-4B4C-8333-8B963718C9F3',
  modelType: 'PSAPPUTILVIEW',
  name: 'article_page_upload_view',
  id: 'plmweb.article_page_upload_view',
};
