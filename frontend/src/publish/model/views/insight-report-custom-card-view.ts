export default {
  deviewCodeName: 'custom_card_view',
  deviewId: 'C5760B5F-1787-43F0-9B99-E71EF001C2F5',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.INSIGHT_REPORT',
  },
  caption: '模板报表',
  codeName: 'insight_report_custom_card_view',
  appDataEntityId: 'plmweb.insight_report',
  viewLayoutPanel: {
    viewProxyMode: true,
    layoutMode: 'FLEX',
    layout: {
      layout: 'FLEX',
    },
    rootPanelItems: [
      {
        actionGroupExtractMode: 'ITEM',
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
        id: 'page_container',
      },
      {
        caption: '数据视图',
        itemStyle: 'DEFAULT',
        itemType: 'CTRLPOS',
        layoutPos: {
          shrink: 1,
          layout: 'FLEX',
        },
        showCaption: true,
        id: 'dataview',
      },
    ],
    layoutPanel: true,
    controls: [
      {
        cardHeight: 180,
        cardWidth: 250,
        groupMode: 'NONE',
        itemLayoutPanel: {
          layoutMode: 'TABLE_24COL',
          layout: {
            columnCount: 24,
            layout: 'TABLE_24COL',
          },
          rootPanelItems: [
            {
              actionGroupExtractMode: 'ITEM',
              panelItems: [
                {
                  actionGroupExtractMode: 'ITEM',
                  panelItems: [
                    {
                      editor: {
                        editorType: 'HIDDEN',
                        predefinedType: 'FIELD_TEXT_DYNAMIC',
                        valueType: 'SIMPLE',
                        editable: true,
                        id: 'chart_type',
                      },
                      viewFieldName: 'chart_type',
                      allowEmpty: true,
                      hidden: true,
                      caption: '文本(动态)',
                      itemType: 'FIELD',
                      layoutPos: {
                        shrink: 1,
                        layout: 'FLEX',
                      },
                      id: 'chart_type',
                    },
                    {
                      rawItem: {
                        sysImage: {
                          rawContent:
                            '<?xml version="1.0" encoding="UTF-8"?>\n<svg width="200px" height="120px" viewBox="0 0 200 120" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">\n    <title>散点图</title>\n    <g id="散点图" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\n        <g transform="translate(26.000000, 19.000000)">\n            <line x1="0" y1="21.2009134" x2="148.017621" y2="21.2009134" id="直线-16" stroke="#CACACA" stroke-width="0.708411166" stroke-linecap="square" stroke-dasharray="3.230354669094086"></line>\n            <line x1="0" y1="0.712875366" x2="148.017621" y2="0.712875366" id="直线-16" stroke="#CACACA" stroke-width="0.708411166" stroke-linecap="square" stroke-dasharray="3.230354669094086"></line>\n            <line x1="5.1159077e-12" y1="39.7356729" x2="147.647577" y2="39.7356729" id="直线-16" stroke="#CACACA" stroke-width="0.708411166" stroke-linecap="square" stroke-dasharray="3.230354669094086"></line>\n            <line x1="5.1159077e-12" y1="59.6961831" x2="147.647577" y2="59.6961831" id="直线-16" stroke="#CACACA" stroke-width="0.708411166" stroke-linecap="square" stroke-dasharray="3.230354669094086"></line>\n            <line x1="5.1159077e-12" y1="79.6566934" x2="147.647577" y2="79.6566934" id="直线-16" stroke="#CACACA" stroke-width="0.708411166" stroke-linecap="square" stroke-dasharray="3.230354669094086"></line>\n            <g id="数据条" transform="translate(19.621029, 6.741587)">\n                <rect id="矩形" fill="#73D897" x="0" y="51.2352478" width="14" height="14" rx="7"></rect>\n                <path d="M39.9786939,50.7891424 C43.8446872,50.7891424 46.9786939,53.9231492 46.9786939,57.7891424 C46.9786939,61.6551357 43.8446872,64.7891424 39.9786939,64.7891424 C36.1127007,64.7891424 32.9786939,61.6551357 32.9786939,57.7891424 C32.9786939,53.9231492 36.1127007,50.7891424 39.9786939,50.7891424 Z" id="矩形备份" fill="#6698FF"></path>\n                <path d="M51.7761762,20.3627065 C55.6421695,20.3627065 58.7761762,23.4967133 58.7761762,27.3627065 C58.7761762,31.2286998 55.6421695,34.3627065 51.7761762,34.3627065 C47.910183,34.3627065 44.7761762,31.2286998 44.7761762,27.3627065 C44.7761762,23.4967133 47.910183,20.3627065 51.7761762,20.3627065 Z" id="矩形备份-3" fill="#73D897"></path>\n                <path d="M80.5736585,27.5538946 C84.4396518,27.5538946 87.5736585,30.6879013 87.5736585,34.5538946 C87.5736585,38.4198878 84.4396518,41.5538946 80.5736585,41.5538946 C76.7076653,41.5538946 73.5736585,38.4198878 73.5736585,34.5538946 C73.5736585,30.6879013 76.7076653,27.5538946 80.5736585,27.5538946 Z" id="矩形备份-4" fill="#6698FF"></path>\n                <path d="M97.3711408,0 C101.237134,-7.10171439e-16 104.371141,3.13400675 104.371141,7 C104.371141,10.8659932 101.237134,14 97.3711408,14 C93.5051476,14 90.3711408,10.8659932 90.3711408,7 C90.3711408,3.13400675 93.5051476,7.10171439e-16 97.3711408,0 Z" id="矩形备份-5" fill="#73D897"></path>\n            </g>\n            <path d="M46.1416477,80.5976951 L35.0403259,80.5976951 L46.1416477,80.5976951 Z" id="矩形" fill="#338FE5" fill-rule="nonzero"></path>\n        </g>\n    </g>\n</svg>',
                        },
                        contentType: 'IMAGE',
                        predefinedType: 'STATIC_IMAGE',
                        id: 'static_image2',
                      },
                      caption: '图表-散点',
                      itemStyle: 'DEFAULT',
                      itemType: 'RAWITEM',
                      layoutPos: {
                        shrink: 1,
                        layout: 'FLEX',
                      },
                      panelItemGroupLogics: [
                        {
                          logicCat: 'PANELVISIBLE',
                          relatedItemNames: ['chart_type'],
                          groupOP: 'AND',
                          panelItemLogics: [
                            {
                              condOp: 'EQ',
                              dstModelField: 'chart_type',
                              value: 'SCATTER',
                              logicType: 'SINGLE',
                              id: '逻辑项',
                            },
                          ],
                          logicType: 'GROUP',
                          id: '面板成员[static_image2][面板显示]逻辑',
                        },
                      ],
                      sysImage: {
                        rawContent:
                          '<?xml version="1.0" encoding="UTF-8"?>\n<svg width="200px" height="120px" viewBox="0 0 200 120" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">\n    <title>散点图</title>\n    <g id="散点图" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\n        <g transform="translate(26.000000, 19.000000)">\n            <line x1="0" y1="21.2009134" x2="148.017621" y2="21.2009134" id="直线-16" stroke="#CACACA" stroke-width="0.708411166" stroke-linecap="square" stroke-dasharray="3.230354669094086"></line>\n            <line x1="0" y1="0.712875366" x2="148.017621" y2="0.712875366" id="直线-16" stroke="#CACACA" stroke-width="0.708411166" stroke-linecap="square" stroke-dasharray="3.230354669094086"></line>\n            <line x1="5.1159077e-12" y1="39.7356729" x2="147.647577" y2="39.7356729" id="直线-16" stroke="#CACACA" stroke-width="0.708411166" stroke-linecap="square" stroke-dasharray="3.230354669094086"></line>\n            <line x1="5.1159077e-12" y1="59.6961831" x2="147.647577" y2="59.6961831" id="直线-16" stroke="#CACACA" stroke-width="0.708411166" stroke-linecap="square" stroke-dasharray="3.230354669094086"></line>\n            <line x1="5.1159077e-12" y1="79.6566934" x2="147.647577" y2="79.6566934" id="直线-16" stroke="#CACACA" stroke-width="0.708411166" stroke-linecap="square" stroke-dasharray="3.230354669094086"></line>\n            <g id="数据条" transform="translate(19.621029, 6.741587)">\n                <rect id="矩形" fill="#73D897" x="0" y="51.2352478" width="14" height="14" rx="7"></rect>\n                <path d="M39.9786939,50.7891424 C43.8446872,50.7891424 46.9786939,53.9231492 46.9786939,57.7891424 C46.9786939,61.6551357 43.8446872,64.7891424 39.9786939,64.7891424 C36.1127007,64.7891424 32.9786939,61.6551357 32.9786939,57.7891424 C32.9786939,53.9231492 36.1127007,50.7891424 39.9786939,50.7891424 Z" id="矩形备份" fill="#6698FF"></path>\n                <path d="M51.7761762,20.3627065 C55.6421695,20.3627065 58.7761762,23.4967133 58.7761762,27.3627065 C58.7761762,31.2286998 55.6421695,34.3627065 51.7761762,34.3627065 C47.910183,34.3627065 44.7761762,31.2286998 44.7761762,27.3627065 C44.7761762,23.4967133 47.910183,20.3627065 51.7761762,20.3627065 Z" id="矩形备份-3" fill="#73D897"></path>\n                <path d="M80.5736585,27.5538946 C84.4396518,27.5538946 87.5736585,30.6879013 87.5736585,34.5538946 C87.5736585,38.4198878 84.4396518,41.5538946 80.5736585,41.5538946 C76.7076653,41.5538946 73.5736585,38.4198878 73.5736585,34.5538946 C73.5736585,30.6879013 76.7076653,27.5538946 80.5736585,27.5538946 Z" id="矩形备份-4" fill="#6698FF"></path>\n                <path d="M97.3711408,0 C101.237134,-7.10171439e-16 104.371141,3.13400675 104.371141,7 C104.371141,10.8659932 101.237134,14 97.3711408,14 C93.5051476,14 90.3711408,10.8659932 90.3711408,7 C90.3711408,3.13400675 93.5051476,7.10171439e-16 97.3711408,0 Z" id="矩形备份-5" fill="#73D897"></path>\n            </g>\n            <path d="M46.1416477,80.5976951 L35.0403259,80.5976951 L46.1416477,80.5976951 Z" id="矩形" fill="#338FE5" fill-rule="nonzero"></path>\n        </g>\n    </g>\n</svg>',
                      },
                      showCaption: true,
                      id: 'static_image2',
                    },
                    {
                      rawItem: {
                        sysImage: {
                          rawContent:
                            '<?xml version="1.0" encoding="UTF-8"?>\n<svg width="200px" height="120px" viewBox="0 0 200 120" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">\n    <title>折线图</title>\n    <g id="折线图" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\n        <g id="编组-8" transform="translate(23.318524, 20.000000)">\n            <line x1="152.082357" y1="78.8341093" x2="0.681475603" y2="78.342702" id="路径-2" stroke="#CACACA" stroke-width="0.657763547" stroke-dasharray="2.631054139137268,1.315527069568634"></line>\n            <line x1="152.082357" y1="59.3534518" x2="0.681475603" y2="58.8620445" id="路径-2备份" stroke="#CACACA" stroke-width="0.657763547" stroke-dasharray="2.631054139137268,1.315527069568634"></line>\n            <line x1="152.082357" y1="39.8727943" x2="0.681475603" y2="39.381387" id="路径-2备份-2" stroke="#CACACA" stroke-width="0.657763547" stroke-dasharray="2.631054139137268,1.315527069568634"></line>\n            <line x1="152.082357" y1="20.3921368" x2="0.681475603" y2="19.9007295" id="路径-2备份-3" stroke="#CACACA" stroke-width="0.657763547" stroke-dasharray="2.631054139137268,1.315527069568634"></line>\n            <line x1="152.082357" y1="0.911479251" x2="0.681475603" y2="0.420071936" id="路径-2备份-4" stroke="#CACACA" stroke-width="0.657763547" stroke-dasharray="2.631054139137268,1.315527069568634"></line>\n            <path d="M0.681475603,48.1188226 L0.681475603,78.342702 L152.082357,78.8341093 L152.082357,16.0015276 C148.880421,19.8997232 145.18255,21.848821 140.988743,21.848821 C134.698032,21.848821 119.899899,13.1483701 111.863804,13.9783872 C103.827709,14.8084042 92.3958037,24.9790505 79.3920922,31.6279961 C66.3883807,38.2769418 47.6565241,20.4889434 34.3381622,27.4783872 C25.4592543,32.1380163 14.2403588,39.0181615 0.681475603,48.1188226 Z" id="路径-5" fill="#6698FF" opacity="0.0994567871"></path>\n            <path d="M0,15.0262855 L1.36295121,12.9304888 L10.8915654,19.1368788 L30.9255914,32.2327548 C37.3564325,36.4441975 42.5906497,36.7619505 49.6204862,34.3206451 L50.7918867,33.8996546 L51.6735911,33.5622058 L53.3676948,32.8731355 L55.5391619,31.9734866 C55.919919,31.815481 56.2931073,31.6623249 56.6592607,31.5139736 L57.7371501,31.0832904 C57.9134589,31.0138976 58.0881424,30.9456948 58.2612674,30.8786767 L59.2818494,30.4907385 C65.132378,28.3101686 69.2372516,27.5671192 74.457928,28.0236251 C82.6336858,28.7385289 87.3794713,31.3892812 93.6013464,37.3500347 L94.5228533,38.2439177 L95.5503449,39.2463766 L96.3043093,39.9710128 L97.0277895,40.6483913 C100.693287,44.0290876 103.283855,45.5870084 107.057908,46.3993656 C108.258474,46.657785 109.49614,46.8072898 110.773815,46.8533721 C115.569287,47.026332 120.361341,45.8746298 126.953846,43.3730899 L127.647564,43.1062347 L131.132526,41.7389505 L133.627242,40.7783055 L134.3837,40.498436 C136.762722,39.6520163 138.482122,39.2330259 139.921339,39.2330259 C144.301485,39.2330259 148.524733,41.1209158 152.565224,44.8359754 L152.943483,45.1896134 L151.22123,47.0017509 C147.502075,43.4670701 143.744898,41.7330259 139.921339,41.7330259 C138.968681,41.7330259 137.695743,42.015909 135.946963,42.6027877 L135.221703,42.8538023 L134.801174,43.0077959 L132.025934,44.073903 L128.476608,45.4672334 L127.187556,45.9562119 C120.635854,48.3983062 115.72614,49.5336148 110.683705,49.3517476 C109.262445,49.3004865 107.8791,49.1333844 106.531837,48.8433887 C101.837756,47.8329975 98.7884731,45.8261475 94.2154001,41.4329327 L92.2434031,39.5134933 C86.2053969,33.6558722 81.9106445,31.1848442 74.2401542,30.5141219 C69.1827064,30.071889 65.2268434,30.8635139 59.1572902,33.2127203 L58.1255755,33.6187323 L57.0514105,34.0539214 L52.8717725,35.7761958 L51.8696138,36.1662267 L50.8722251,36.529915 C42.9491473,39.3721815 36.8286203,39.086927 29.5559506,34.3241859 L12.3077163,23.0459971 L0,15.0262855 Z" id="路径-3" fill="#6698FF" fill-rule="nonzero" transform="translate(76.471742, 31.150537) scale(1, -1) translate(-76.471742, -31.150537) "></path>\n        </g>\n    </g>\n</svg>',
                        },
                        contentType: 'IMAGE',
                        predefinedType: 'STATIC_IMAGE',
                        id: 'static_image4',
                      },
                      caption: '图表-线条',
                      itemStyle: 'DEFAULT',
                      itemType: 'RAWITEM',
                      layoutPos: {
                        shrink: 1,
                        layout: 'FLEX',
                      },
                      panelItemGroupLogics: [
                        {
                          logicCat: 'PANELVISIBLE',
                          relatedItemNames: ['chart_type'],
                          groupOP: 'AND',
                          panelItemLogics: [
                            {
                              groupOP: 'OR',
                              panelItemLogics: [
                                {
                                  condOp: 'EQ',
                                  dstModelField: 'chart_type',
                                  value: 'MULTI_SERIES_BAR',
                                  logicType: 'SINGLE',
                                  id: '逻辑项',
                                },
                                {
                                  condOp: 'EQ',
                                  dstModelField: 'chart_type',
                                  value: 'MULTI_SERIES_LINE',
                                  logicType: 'SINGLE',
                                  id: '逻辑项',
                                },
                                {
                                  condOp: 'EQ',
                                  dstModelField: 'chart_type',
                                  value: 'ZONE_LINE',
                                  logicType: 'SINGLE',
                                  id: '逻辑项',
                                },
                                {
                                  condOp: 'EQ',
                                  dstModelField: 'chart_type',
                                  value: 'STACK_BAR',
                                  logicType: 'SINGLE',
                                  id: '逻辑项',
                                },
                              ],
                              logicType: 'GROUP',
                              id: '逻辑分组',
                            },
                          ],
                          logicType: 'GROUP',
                          id: '面板成员[static_image4][面板显示]逻辑',
                        },
                      ],
                      sysImage: {
                        rawContent:
                          '<?xml version="1.0" encoding="UTF-8"?>\n<svg width="200px" height="120px" viewBox="0 0 200 120" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">\n    <title>折线图</title>\n    <g id="折线图" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\n        <g id="编组-8" transform="translate(23.318524, 20.000000)">\n            <line x1="152.082357" y1="78.8341093" x2="0.681475603" y2="78.342702" id="路径-2" stroke="#CACACA" stroke-width="0.657763547" stroke-dasharray="2.631054139137268,1.315527069568634"></line>\n            <line x1="152.082357" y1="59.3534518" x2="0.681475603" y2="58.8620445" id="路径-2备份" stroke="#CACACA" stroke-width="0.657763547" stroke-dasharray="2.631054139137268,1.315527069568634"></line>\n            <line x1="152.082357" y1="39.8727943" x2="0.681475603" y2="39.381387" id="路径-2备份-2" stroke="#CACACA" stroke-width="0.657763547" stroke-dasharray="2.631054139137268,1.315527069568634"></line>\n            <line x1="152.082357" y1="20.3921368" x2="0.681475603" y2="19.9007295" id="路径-2备份-3" stroke="#CACACA" stroke-width="0.657763547" stroke-dasharray="2.631054139137268,1.315527069568634"></line>\n            <line x1="152.082357" y1="0.911479251" x2="0.681475603" y2="0.420071936" id="路径-2备份-4" stroke="#CACACA" stroke-width="0.657763547" stroke-dasharray="2.631054139137268,1.315527069568634"></line>\n            <path d="M0.681475603,48.1188226 L0.681475603,78.342702 L152.082357,78.8341093 L152.082357,16.0015276 C148.880421,19.8997232 145.18255,21.848821 140.988743,21.848821 C134.698032,21.848821 119.899899,13.1483701 111.863804,13.9783872 C103.827709,14.8084042 92.3958037,24.9790505 79.3920922,31.6279961 C66.3883807,38.2769418 47.6565241,20.4889434 34.3381622,27.4783872 C25.4592543,32.1380163 14.2403588,39.0181615 0.681475603,48.1188226 Z" id="路径-5" fill="#6698FF" opacity="0.0994567871"></path>\n            <path d="M0,15.0262855 L1.36295121,12.9304888 L10.8915654,19.1368788 L30.9255914,32.2327548 C37.3564325,36.4441975 42.5906497,36.7619505 49.6204862,34.3206451 L50.7918867,33.8996546 L51.6735911,33.5622058 L53.3676948,32.8731355 L55.5391619,31.9734866 C55.919919,31.815481 56.2931073,31.6623249 56.6592607,31.5139736 L57.7371501,31.0832904 C57.9134589,31.0138976 58.0881424,30.9456948 58.2612674,30.8786767 L59.2818494,30.4907385 C65.132378,28.3101686 69.2372516,27.5671192 74.457928,28.0236251 C82.6336858,28.7385289 87.3794713,31.3892812 93.6013464,37.3500347 L94.5228533,38.2439177 L95.5503449,39.2463766 L96.3043093,39.9710128 L97.0277895,40.6483913 C100.693287,44.0290876 103.283855,45.5870084 107.057908,46.3993656 C108.258474,46.657785 109.49614,46.8072898 110.773815,46.8533721 C115.569287,47.026332 120.361341,45.8746298 126.953846,43.3730899 L127.647564,43.1062347 L131.132526,41.7389505 L133.627242,40.7783055 L134.3837,40.498436 C136.762722,39.6520163 138.482122,39.2330259 139.921339,39.2330259 C144.301485,39.2330259 148.524733,41.1209158 152.565224,44.8359754 L152.943483,45.1896134 L151.22123,47.0017509 C147.502075,43.4670701 143.744898,41.7330259 139.921339,41.7330259 C138.968681,41.7330259 137.695743,42.015909 135.946963,42.6027877 L135.221703,42.8538023 L134.801174,43.0077959 L132.025934,44.073903 L128.476608,45.4672334 L127.187556,45.9562119 C120.635854,48.3983062 115.72614,49.5336148 110.683705,49.3517476 C109.262445,49.3004865 107.8791,49.1333844 106.531837,48.8433887 C101.837756,47.8329975 98.7884731,45.8261475 94.2154001,41.4329327 L92.2434031,39.5134933 C86.2053969,33.6558722 81.9106445,31.1848442 74.2401542,30.5141219 C69.1827064,30.071889 65.2268434,30.8635139 59.1572902,33.2127203 L58.1255755,33.6187323 L57.0514105,34.0539214 L52.8717725,35.7761958 L51.8696138,36.1662267 L50.8722251,36.529915 C42.9491473,39.3721815 36.8286203,39.086927 29.5559506,34.3241859 L12.3077163,23.0459971 L0,15.0262855 Z" id="路径-3" fill="#6698FF" fill-rule="nonzero" transform="translate(76.471742, 31.150537) scale(1, -1) translate(-76.471742, -31.150537) "></path>\n        </g>\n    </g>\n</svg>',
                      },
                      showCaption: true,
                      id: 'static_image4',
                    },
                    {
                      rawItem: {
                        sysImage: {
                          rawContent:
                            '<?xml version="1.0" encoding="UTF-8"?>\n<svg width="200px" height="120px" viewBox="0 0 200 120" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">\n    <title>表格</title>\n    <g id="表格" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\n        <g transform="translate(51.000000, 24.000000)" id="表格">\n            <polygon id="矩形" fill="#6698FF" points="0 0 98 0 98 14.2439024 0 14.2439024"></polygon>\n            <polygon id="矩形" fill="#E0EEFF" points="1.62370117e-14 21.3658537 45 21.3658537 45 43.6219512 1.62370117e-14 43.6219512"></polygon>\n            <polygon id="矩形" fill="#E0EEFF" points="53 21.2560976 98 21.2560976 98 28.3780488 53 28.3780488"></polygon>\n            <polygon id="矩形" fill="#E0EEFF" points="53 32.9390244 98 32.9390244 98 43.6219512 53 43.6219512"></polygon>\n            <polygon id="矩形" fill="#E0EEFF" points="53 50.7439024 98 50.7439024 98 57.8658537 53 57.8658537"></polygon>\n            <polygon id="矩形" fill="#E0EEFF" points="53 62.3170732 98 62.3170732 98 73 53 73"></polygon>\n            <polygon id="矩形" fill="#E0EEFF" points="1.62370117e-14 50.7439024 45 50.7439024 45 73 1.62370117e-14 73"></polygon>\n        </g>\n    </g>\n</svg>',
                        },
                        contentType: 'IMAGE',
                        predefinedType: 'STATIC_IMAGE',
                        id: 'static_image5',
                      },
                      caption: '图表-表格',
                      itemStyle: 'DEFAULT',
                      itemType: 'RAWITEM',
                      layoutPos: {
                        shrink: 1,
                        layout: 'FLEX',
                      },
                      panelItemGroupLogics: [
                        {
                          logicCat: 'PANELVISIBLE',
                          relatedItemNames: ['chart_type'],
                          groupOP: 'AND',
                          panelItemLogics: [
                            {
                              groupOP: 'OR',
                              panelItemLogics: [
                                {
                                  condOp: 'EQ',
                                  dstModelField: 'chart_type',
                                  value: 'GRID',
                                  logicType: 'SINGLE',
                                  id: '逻辑项',
                                },
                                {
                                  condOp: 'EQ',
                                  dstModelField: 'chart_type',
                                  value: 'CROSSTABLE',
                                  logicType: 'SINGLE',
                                  id: '逻辑项',
                                },
                              ],
                              logicType: 'GROUP',
                              id: '逻辑分组',
                            },
                          ],
                          logicType: 'GROUP',
                          id: '面板成员[static_image5][面板显示]逻辑',
                        },
                      ],
                      sysImage: {
                        rawContent:
                          '<?xml version="1.0" encoding="UTF-8"?>\n<svg width="200px" height="120px" viewBox="0 0 200 120" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">\n    <title>表格</title>\n    <g id="表格" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\n        <g transform="translate(51.000000, 24.000000)" id="表格">\n            <polygon id="矩形" fill="#6698FF" points="0 0 98 0 98 14.2439024 0 14.2439024"></polygon>\n            <polygon id="矩形" fill="#E0EEFF" points="1.62370117e-14 21.3658537 45 21.3658537 45 43.6219512 1.62370117e-14 43.6219512"></polygon>\n            <polygon id="矩形" fill="#E0EEFF" points="53 21.2560976 98 21.2560976 98 28.3780488 53 28.3780488"></polygon>\n            <polygon id="矩形" fill="#E0EEFF" points="53 32.9390244 98 32.9390244 98 43.6219512 53 43.6219512"></polygon>\n            <polygon id="矩形" fill="#E0EEFF" points="53 50.7439024 98 50.7439024 98 57.8658537 53 57.8658537"></polygon>\n            <polygon id="矩形" fill="#E0EEFF" points="53 62.3170732 98 62.3170732 98 73 53 73"></polygon>\n            <polygon id="矩形" fill="#E0EEFF" points="1.62370117e-14 50.7439024 45 50.7439024 45 73 1.62370117e-14 73"></polygon>\n        </g>\n    </g>\n</svg>',
                      },
                      showCaption: true,
                      id: 'static_image5',
                    },
                    {
                      rawItem: {
                        sysImage: {
                          rawContent:
                            '<?xml version="1.0" encoding="UTF-8"?>\n<svg width="200px" height="120px" viewBox="0 0 200 120" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">\n    <title>柱状图</title>\n    <g id="柱状图" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\n        <g id="编组-3" transform="translate(26.000000, 19.000000)">\n            <line x1="0" y1="21.2009134" x2="148.017621" y2="21.2009134" id="直线-16" stroke="#CACACA" stroke-width="0.708411166" stroke-linecap="square" stroke-dasharray="3.230354669094086"></line>\n            <line x1="0" y1="0.712875366" x2="148.017621" y2="0.712875366" id="直线-16" stroke="#CACACA" stroke-width="0.708411166" stroke-linecap="square" stroke-dasharray="3.230354669094086"></line>\n            <line x1="5.1159077e-12" y1="39.7356729" x2="147.647577" y2="39.7356729" id="直线-16" stroke="#CACACA" stroke-width="0.708411166" stroke-linecap="square" stroke-dasharray="3.230354669094086"></line>\n            <line x1="5.1159077e-12" y1="59.6961831" x2="147.647577" y2="59.6961831" id="直线-16" stroke="#CACACA" stroke-width="0.708411166" stroke-linecap="square" stroke-dasharray="3.230354669094086"></line>\n            <line x1="5.1159077e-12" y1="79.6566934" x2="147.647577" y2="79.6566934" id="直线-16" stroke="#CACACA" stroke-width="0.708411166" stroke-linecap="square" stroke-dasharray="3.230354669094086"></line>\n            <g id="数据条" transform="translate(11.385970, 13.141442)" fill-rule="nonzero">\n                <polygon id="矩形" fill="#6698FF" points="0 0.22812639 11.3859702 0.22812639 11.3859702 67.2281264 0 67.2281264"></polygon>\n                <polygon id="矩形" fill="#F6C659" points="37.5167714 24.227478 48.9027416 24.227478 48.9027416 67.000002 37.5167714 67.000002"></polygon>\n                <polygon id="矩形" fill="#5DCFFF" points="73.0979282 0 84.4838984 0 84.4838984 67 73.0979282 67"></polygon>\n                <polygon id="矩形" fill="#73D897" points="110.102331 9 121.488302 9 121.488302 67 110.102331 67"></polygon>\n            </g>\n            <path d="M46.1416477,80.5976951 L35.0403259,80.5976951 L46.1416477,80.5976951 Z" id="矩形" fill="#338FE5" fill-rule="nonzero"></path>\n        </g>\n    </g>\n</svg>',
                        },
                        contentType: 'IMAGE',
                        predefinedType: 'STATIC_IMAGE',
                        id: 'static_image3',
                      },
                      caption: '图表-柱状图',
                      itemStyle: 'DEFAULT',
                      itemType: 'RAWITEM',
                      layoutPos: {
                        shrink: 1,
                        layout: 'FLEX',
                      },
                      panelItemGroupLogics: [
                        {
                          logicCat: 'PANELVISIBLE',
                          relatedItemNames: ['chart_type'],
                          groupOP: 'AND',
                          panelItemLogics: [
                            {
                              groupOP: 'OR',
                              panelItemLogics: [
                                {
                                  condOp: 'EQ',
                                  dstModelField: 'chart_type',
                                  value: 'MULTI_SERIES_COL',
                                  logicType: 'SINGLE',
                                  id: '逻辑项',
                                },
                                {
                                  condOp: 'EQ',
                                  dstModelField: 'chart_type',
                                  value: 'STACK_COL',
                                  logicType: 'SINGLE',
                                  id: '逻辑项',
                                },
                                {
                                  condOp: 'EQ',
                                  dstModelField: 'chart_type',
                                  value: 'ZONE_COL',
                                  logicType: 'SINGLE',
                                  id: '逻辑项',
                                },
                                {
                                  condOp: 'EQ',
                                  dstModelField: 'chart_type',
                                  value: 'STACK_BAR',
                                  logicType: 'SINGLE',
                                  id: '逻辑项',
                                },
                              ],
                              logicType: 'GROUP',
                              id: '逻辑分组',
                            },
                          ],
                          logicType: 'GROUP',
                          id: '面板成员[static_image3][面板显示]逻辑',
                        },
                      ],
                      sysImage: {
                        rawContent:
                          '<?xml version="1.0" encoding="UTF-8"?>\n<svg width="200px" height="120px" viewBox="0 0 200 120" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">\n    <title>柱状图</title>\n    <g id="柱状图" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\n        <g id="编组-3" transform="translate(26.000000, 19.000000)">\n            <line x1="0" y1="21.2009134" x2="148.017621" y2="21.2009134" id="直线-16" stroke="#CACACA" stroke-width="0.708411166" stroke-linecap="square" stroke-dasharray="3.230354669094086"></line>\n            <line x1="0" y1="0.712875366" x2="148.017621" y2="0.712875366" id="直线-16" stroke="#CACACA" stroke-width="0.708411166" stroke-linecap="square" stroke-dasharray="3.230354669094086"></line>\n            <line x1="5.1159077e-12" y1="39.7356729" x2="147.647577" y2="39.7356729" id="直线-16" stroke="#CACACA" stroke-width="0.708411166" stroke-linecap="square" stroke-dasharray="3.230354669094086"></line>\n            <line x1="5.1159077e-12" y1="59.6961831" x2="147.647577" y2="59.6961831" id="直线-16" stroke="#CACACA" stroke-width="0.708411166" stroke-linecap="square" stroke-dasharray="3.230354669094086"></line>\n            <line x1="5.1159077e-12" y1="79.6566934" x2="147.647577" y2="79.6566934" id="直线-16" stroke="#CACACA" stroke-width="0.708411166" stroke-linecap="square" stroke-dasharray="3.230354669094086"></line>\n            <g id="数据条" transform="translate(11.385970, 13.141442)" fill-rule="nonzero">\n                <polygon id="矩形" fill="#6698FF" points="0 0.22812639 11.3859702 0.22812639 11.3859702 67.2281264 0 67.2281264"></polygon>\n                <polygon id="矩形" fill="#F6C659" points="37.5167714 24.227478 48.9027416 24.227478 48.9027416 67.000002 37.5167714 67.000002"></polygon>\n                <polygon id="矩形" fill="#5DCFFF" points="73.0979282 0 84.4838984 0 84.4838984 67 73.0979282 67"></polygon>\n                <polygon id="矩形" fill="#73D897" points="110.102331 9 121.488302 9 121.488302 67 110.102331 67"></polygon>\n            </g>\n            <path d="M46.1416477,80.5976951 L35.0403259,80.5976951 L46.1416477,80.5976951 Z" id="矩形" fill="#338FE5" fill-rule="nonzero"></path>\n        </g>\n    </g>\n</svg>',
                      },
                      showCaption: true,
                      id: 'static_image3',
                    },
                    {
                      rawItem: {
                        sysImage: {
                          rawContent:
                            '<?xml version="1.0" encoding="UTF-8"?>\n<svg width="200px" height="120px" viewBox="0 0 200 120" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">\n    <title>雷达图</title>\n    <g id="雷达图" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\n        <g id="缺陷年龄报告备份-2" transform="translate(27.000000, 17.000000)">\n            <g id="雷达图">\n                <path d="M43,0.577350269 L79.7390924,21.7886751 L79.7390924,64.2113249 L43,85.4226497 L6.26090764,64.2113249 L6.26090764,21.7886751 L43,0.577350269 Z" id="多边形" stroke="#DDDDDD"></path>\n                <path d="M43,13.1190169 L68.8776904,28.0595085 L68.8776904,57.9404915 L43,72.8809831 L17.1223096,57.9404915 L17.1223096,28.0595085 L43,13.1190169 Z" id="多边形" stroke="#DDDDDD"></path>\n                <path d="M43,28.839447 L55.2633986,35.9197235 L55.2633986,50.0802765 L43,57.160553 L30.7366014,50.0802765 L30.7366014,35.9197235 L43,28.839447 Z" id="多边形" stroke="#DDDDDD"></path>\n                <line x1="43" y1="0.80778272" x2="43" y2="85.2302141" id="直线" stroke="#DDDDDD" stroke-linecap="square"></line>\n                <line x1="6.71875" y1="21.9479167" x2="79.28125" y2="64.0520833" id="直线" stroke="#DDDDDD" stroke-linecap="square"></line>\n                <line x1="6.71875" y1="64.0520833" x2="79.642023" y2="22" id="直线" stroke="#DDDDDD" stroke-linecap="square"></line>\n                <path d="M28.623096,25.5070878 L43.3250545,18.8340289 C43.6033157,18.7077292 43.9266537,18.731252 44.1837052,18.8964955 L62.096365,30.4115114 C62.4562294,30.6428474 62.6035141,31.0955383 62.4486667,31.4943378 L55.1548767,50.279023 C55.0489281,50.5518866 54.8169006,50.7561815 54.5328188,50.8267305 L20.3083786,59.3260495 C19.8259754,59.4458498 19.337793,59.1519021 19.2179927,58.6694989 C19.1806379,58.5190814 19.1827602,58.3615663 19.2241539,58.2122098 L28.1277658,26.0862487 C28.1989597,25.8293671 28.3803645,25.617261 28.623096,25.5070878 Z" id="路径-2" stroke="#6698FF" stroke-width="2.5"></path>\n                <path d="M37.4828116,39.9021955 L54.116662,39.9021955 C54.4033489,39.9021955 54.6728848,40.0387785 54.8424227,40.269963 L66.4496187,56.0977213 C66.7435625,56.4985478 66.656917,57.0617706 66.2560904,57.3557144 C66.2035632,57.3942349 66.1470094,57.4269392 66.0874228,57.4532523 L45.3850709,66.5953164 C44.9303757,66.7961077 44.3989988,66.5902779 44.1982075,66.1355827 C44.1833412,66.1019177 44.1705537,66.0673726 44.1599172,66.032142 L36.6212227,41.0623197 C36.47756,40.5864773 36.7468449,40.0842692 37.2226873,39.9406066 C37.3070474,39.9151373 37.3946906,39.9021955 37.4828116,39.9021955 Z" id="路径-6" stroke="#73D897" stroke-width="2.5"></path>\n            </g>\n            <path d="M126.328817,22 L141.175,22 C142.814384,22 144.143368,23.328984 144.143368,24.9683688 L144.143368,24.9839034 C144.143368,26.6232882 142.814384,27.9522722 141.175,27.9522722 L126.328817,27.9522722 C124.689433,27.9522722 123.360449,26.6232882 123.360449,24.9839034 L123.360449,24.9683688 C123.360449,23.328984 124.689433,22 126.328817,22 Z" id="矩形" fill="#EEEEEE"></path>\n            <path d="M112.968369,22 L112.969608,22 C114.608993,22 115.937977,23.328984 115.937977,24.9683688 L115.937977,24.9839034 C115.937977,26.6232882 114.608993,27.9522722 112.969608,27.9522722 L112.968369,27.9522722 C111.328984,27.9522722 110,26.6232882 110,24.9839034 L110,24.9683688 C110,23.328984 111.328984,22 112.968369,22 Z" id="矩形" fill="#6698FF"></path>\n            <path d="M112.968369,39.8568167 L112.969608,39.8568167 C114.608993,39.8568167 115.937977,41.1858007 115.937977,42.8251855 L115.937977,42.8407201 C115.937977,44.4801049 114.608993,45.8090889 112.969608,45.8090889 L112.968369,45.8090889 C111.328984,45.8090889 110,44.4801049 110,42.8407201 L110,42.8251855 C110,41.1858007 111.328984,39.8568167 112.968369,39.8568167 Z" id="矩形" fill="#5DCFFF"></path>\n            <path d="M126.328817,39.8568167 L141.175,39.8568167 C142.814384,39.8568167 144.143368,41.1858007 144.143368,42.8251855 L144.143368,42.8407201 C144.143368,44.4801049 142.814384,45.8090889 141.175,45.8090889 L126.328817,45.8090889 C124.689433,45.8090889 123.360449,44.4801049 123.360449,42.8407201 L123.360449,42.8251855 C123.360449,41.1858007 124.689433,39.8568167 126.328817,39.8568167 Z" id="矩形" fill="#EEEEEE"></path>\n            <path d="M112.968369,59.8568167 L112.969608,59.8568167 C114.608993,59.8568167 115.937977,61.1858007 115.937977,62.8251855 L115.937977,62.8407201 C115.937977,64.4801049 114.608993,65.8090889 112.969608,65.8090889 L112.968369,65.8090889 C111.328984,65.8090889 110,64.4801049 110,62.8407201 L110,62.8251855 C110,61.1858007 111.328984,59.8568167 112.968369,59.8568167 Z" id="矩形" fill="#73D897"></path>\n            <path d="M126.328817,59.8568167 L141.175,59.8568167 C142.814384,59.8568167 144.143368,61.1858007 144.143368,62.8251855 L144.143368,62.8407201 C144.143368,64.4801049 142.814384,65.8090889 141.175,65.8090889 L126.328817,65.8090889 C124.689433,65.8090889 123.360449,64.4801049 123.360449,62.8407201 L123.360449,62.8251855 C123.360449,61.1858007 124.689433,59.8568167 126.328817,59.8568167 Z" id="矩形" fill="#EEEEEE"></path>\n        </g>\n    </g>\n</svg>',
                        },
                        contentType: 'IMAGE',
                        predefinedType: 'STATIC_IMAGE',
                        id: 'static_image6',
                      },
                      caption: '图表-雷达',
                      itemStyle: 'DEFAULT',
                      itemType: 'RAWITEM',
                      layoutPos: {
                        shrink: 1,
                        layout: 'FLEX',
                      },
                      panelItemGroupLogics: [
                        {
                          logicCat: 'PANELVISIBLE',
                          relatedItemNames: ['chart_type'],
                          groupOP: 'AND',
                          panelItemLogics: [
                            {
                              condOp: 'EQ',
                              dstModelField: 'chart_type',
                              value: 'RADAR',
                              logicType: 'SINGLE',
                              id: '逻辑项',
                            },
                          ],
                          logicType: 'GROUP',
                          id: '面板成员[static_image6][面板显示]逻辑',
                        },
                      ],
                      sysImage: {
                        rawContent:
                          '<?xml version="1.0" encoding="UTF-8"?>\n<svg width="200px" height="120px" viewBox="0 0 200 120" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">\n    <title>雷达图</title>\n    <g id="雷达图" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\n        <g id="缺陷年龄报告备份-2" transform="translate(27.000000, 17.000000)">\n            <g id="雷达图">\n                <path d="M43,0.577350269 L79.7390924,21.7886751 L79.7390924,64.2113249 L43,85.4226497 L6.26090764,64.2113249 L6.26090764,21.7886751 L43,0.577350269 Z" id="多边形" stroke="#DDDDDD"></path>\n                <path d="M43,13.1190169 L68.8776904,28.0595085 L68.8776904,57.9404915 L43,72.8809831 L17.1223096,57.9404915 L17.1223096,28.0595085 L43,13.1190169 Z" id="多边形" stroke="#DDDDDD"></path>\n                <path d="M43,28.839447 L55.2633986,35.9197235 L55.2633986,50.0802765 L43,57.160553 L30.7366014,50.0802765 L30.7366014,35.9197235 L43,28.839447 Z" id="多边形" stroke="#DDDDDD"></path>\n                <line x1="43" y1="0.80778272" x2="43" y2="85.2302141" id="直线" stroke="#DDDDDD" stroke-linecap="square"></line>\n                <line x1="6.71875" y1="21.9479167" x2="79.28125" y2="64.0520833" id="直线" stroke="#DDDDDD" stroke-linecap="square"></line>\n                <line x1="6.71875" y1="64.0520833" x2="79.642023" y2="22" id="直线" stroke="#DDDDDD" stroke-linecap="square"></line>\n                <path d="M28.623096,25.5070878 L43.3250545,18.8340289 C43.6033157,18.7077292 43.9266537,18.731252 44.1837052,18.8964955 L62.096365,30.4115114 C62.4562294,30.6428474 62.6035141,31.0955383 62.4486667,31.4943378 L55.1548767,50.279023 C55.0489281,50.5518866 54.8169006,50.7561815 54.5328188,50.8267305 L20.3083786,59.3260495 C19.8259754,59.4458498 19.337793,59.1519021 19.2179927,58.6694989 C19.1806379,58.5190814 19.1827602,58.3615663 19.2241539,58.2122098 L28.1277658,26.0862487 C28.1989597,25.8293671 28.3803645,25.617261 28.623096,25.5070878 Z" id="路径-2" stroke="#6698FF" stroke-width="2.5"></path>\n                <path d="M37.4828116,39.9021955 L54.116662,39.9021955 C54.4033489,39.9021955 54.6728848,40.0387785 54.8424227,40.269963 L66.4496187,56.0977213 C66.7435625,56.4985478 66.656917,57.0617706 66.2560904,57.3557144 C66.2035632,57.3942349 66.1470094,57.4269392 66.0874228,57.4532523 L45.3850709,66.5953164 C44.9303757,66.7961077 44.3989988,66.5902779 44.1982075,66.1355827 C44.1833412,66.1019177 44.1705537,66.0673726 44.1599172,66.032142 L36.6212227,41.0623197 C36.47756,40.5864773 36.7468449,40.0842692 37.2226873,39.9406066 C37.3070474,39.9151373 37.3946906,39.9021955 37.4828116,39.9021955 Z" id="路径-6" stroke="#73D897" stroke-width="2.5"></path>\n            </g>\n            <path d="M126.328817,22 L141.175,22 C142.814384,22 144.143368,23.328984 144.143368,24.9683688 L144.143368,24.9839034 C144.143368,26.6232882 142.814384,27.9522722 141.175,27.9522722 L126.328817,27.9522722 C124.689433,27.9522722 123.360449,26.6232882 123.360449,24.9839034 L123.360449,24.9683688 C123.360449,23.328984 124.689433,22 126.328817,22 Z" id="矩形" fill="#EEEEEE"></path>\n            <path d="M112.968369,22 L112.969608,22 C114.608993,22 115.937977,23.328984 115.937977,24.9683688 L115.937977,24.9839034 C115.937977,26.6232882 114.608993,27.9522722 112.969608,27.9522722 L112.968369,27.9522722 C111.328984,27.9522722 110,26.6232882 110,24.9839034 L110,24.9683688 C110,23.328984 111.328984,22 112.968369,22 Z" id="矩形" fill="#6698FF"></path>\n            <path d="M112.968369,39.8568167 L112.969608,39.8568167 C114.608993,39.8568167 115.937977,41.1858007 115.937977,42.8251855 L115.937977,42.8407201 C115.937977,44.4801049 114.608993,45.8090889 112.969608,45.8090889 L112.968369,45.8090889 C111.328984,45.8090889 110,44.4801049 110,42.8407201 L110,42.8251855 C110,41.1858007 111.328984,39.8568167 112.968369,39.8568167 Z" id="矩形" fill="#5DCFFF"></path>\n            <path d="M126.328817,39.8568167 L141.175,39.8568167 C142.814384,39.8568167 144.143368,41.1858007 144.143368,42.8251855 L144.143368,42.8407201 C144.143368,44.4801049 142.814384,45.8090889 141.175,45.8090889 L126.328817,45.8090889 C124.689433,45.8090889 123.360449,44.4801049 123.360449,42.8407201 L123.360449,42.8251855 C123.360449,41.1858007 124.689433,39.8568167 126.328817,39.8568167 Z" id="矩形" fill="#EEEEEE"></path>\n            <path d="M112.968369,59.8568167 L112.969608,59.8568167 C114.608993,59.8568167 115.937977,61.1858007 115.937977,62.8251855 L115.937977,62.8407201 C115.937977,64.4801049 114.608993,65.8090889 112.969608,65.8090889 L112.968369,65.8090889 C111.328984,65.8090889 110,64.4801049 110,62.8407201 L110,62.8251855 C110,61.1858007 111.328984,59.8568167 112.968369,59.8568167 Z" id="矩形" fill="#73D897"></path>\n            <path d="M126.328817,59.8568167 L141.175,59.8568167 C142.814384,59.8568167 144.143368,61.1858007 144.143368,62.8251855 L144.143368,62.8407201 C144.143368,64.4801049 142.814384,65.8090889 141.175,65.8090889 L126.328817,65.8090889 C124.689433,65.8090889 123.360449,64.4801049 123.360449,62.8407201 L123.360449,62.8251855 C123.360449,61.1858007 124.689433,59.8568167 126.328817,59.8568167 Z" id="矩形" fill="#EEEEEE"></path>\n        </g>\n    </g>\n</svg>',
                      },
                      showCaption: true,
                      id: 'static_image6',
                    },
                    {
                      rawItem: {
                        sysImage: {
                          rawContent:
                            '<?xml version="1.0" encoding="UTF-8"?>\n<svg width="200px" height="120px" viewBox="0 0 200 120" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">\n    <title>饼图</title>\n    <g id="饼图" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\n        <g id="编组-3" transform="translate(29.000000, 13.000000)">\n            <g id="编组" stroke="#FAFAFA" stroke-width="1.48418441">\n                <path d="M48.0374369,9.42051669 C58.1958835,9.61631972 67.3743424,13.8235279 74.062071,20.5273566 C80.9129187,27.394697 85.1501037,36.8818816 85.1501037,47.3610478 C85.1501037,57.840214 80.9129187,67.3273985 74.062071,74.194739 C67.2118684,81.0614328 57.748444,85.3087251 47.2953447,85.3087251 C36.9555707,85.3087251 27.5841207,81.1530341 20.7523301,74.4171423 C13.9083534,67.6692355 9.61295499,58.3319966 9.44573223,47.9948565 L9.448,48.103 L48.0374369,48.1033345 Z" id="形状结合" fill="#5DCFFF" transform="translate(47.295345, 47.361048) rotate(-195.000000) translate(-47.295345, -47.361048) "></path>\n                <path d="M65.1229138,11.284649 C71.5297735,14.3175298 76.9509333,19.0994744 80.7737147,25.0156411 C84.6074726,30.948795 86.8331634,38.0229752 86.8331634,45.6181885 C86.8331634,56.0973547 82.5959784,65.5845392 75.7451307,72.4518797 C68.894928,79.3185735 59.4315037,83.5658658 48.9784043,83.5658658 C38.6386304,83.5658658 29.2671803,79.4101748 22.4353897,72.674283 C15.591413,65.9263762 11.2960147,56.5891373 11.1287919,46.2519972 L11.131,46.36 L49.4597416,46.3604739 Z" id="形状结合" fill="#87DDA5" transform="translate(48.978404, 47.302274) rotate(-92.000000) translate(-48.978404, -47.302274) "></path>\n                <path d="M48.0374369,9.42051669 C58.1958835,9.61631972 67.3743424,13.8235279 74.062071,20.5273566 C80.9129187,27.394697 85.1501037,36.8818816 85.1501037,47.3610478 C85.1501037,57.840214 80.9129187,67.3273985 74.062071,74.194739 C67.2118684,81.0614328 57.748444,85.3087251 47.2953447,85.3087251 C39.7190765,85.3087251 32.6625854,83.0777574 26.7442863,79.2350774 C20.8410582,75.4021829 16.0699466,69.9663051 13.044459,63.5421845 L13.044459,63.5421845 L48.0374369,47.8416442 Z" id="形状结合" fill="#6698FF"></path>\n            </g>\n            <g id="编组-2" transform="translate(108.159610, 25.040218)">\n                <path d="M16.3288173,0 L31.1749996,0 C32.8143844,5.87028311e-16 34.1433684,1.32898399 34.1433684,2.96836883 L34.1433684,2.9839034 C34.1433684,4.62328824 32.8143844,5.95227223 31.1749996,5.95227223 L16.3288173,5.95227223 C14.6894325,5.95227223 13.3604485,4.62328824 13.3604485,2.9839034 L13.3604485,2.96836883 C13.3604485,1.32898399 14.6894325,1.18932853e-15 16.3288173,0 Z" id="矩形" fill="#EEEEEE"></path>\n                <path d="M16.3288173,38.6897695 L31.1749996,38.6897695 C32.8143844,38.6897695 34.1433684,40.0187535 34.1433684,41.6581383 L34.1433684,41.6736729 C34.1433684,43.3130578 32.8143844,44.6420417 31.1749996,44.6420417 L16.3288173,44.6420417 C14.6894325,44.6420417 13.3604485,43.3130578 13.3604485,41.6736729 L13.3604485,41.6581383 C13.3604485,40.0187535 14.6894325,38.6897695 16.3288173,38.6897695 Z" id="矩形" fill="#EEEEEE"></path>\n                <path d="M2.96836883,0 L2.96960829,0 C4.60899313,5.87028311e-16 5.93797712,1.32898399 5.93797712,2.96836883 L5.93797712,2.9839034 C5.93797712,4.62328824 4.60899313,5.95227223 2.96960829,5.95227223 L2.96836883,5.95227223 C1.32898399,5.95227223 2.00766739e-16,4.62328824 0,2.9839034 L0,2.96836883 C5.27266377e-16,1.32898399 1.32898399,1.18932853e-15 2.96836883,0 Z" id="矩形" fill="#6698FF"></path>\n                <path d="M2.96836883,38.6897695 L2.96960829,38.6897695 C4.60899313,38.6897695 5.93797712,40.0187535 5.93797712,41.6581383 L5.93797712,41.6736729 C5.93797712,43.3130578 4.60899313,44.6420417 2.96960829,44.6420417 L2.96836883,44.6420417 C1.32898399,44.6420417 -6.87411681e-16,43.3130578 0,41.6736729 L0,41.6581383 C-1.08894516e-15,40.0187535 1.32898399,38.6897695 2.96836883,38.6897695 Z" id="矩形" fill="#73D897"></path>\n                <path d="M2.96836883,17.8568167 L2.96960829,17.8568167 C4.60899313,17.8568167 5.93797712,19.1858007 5.93797712,20.8251855 L5.93797712,20.8407201 C5.93797712,22.4801049 4.60899313,23.8090889 2.96960829,23.8090889 L2.96836883,23.8090889 C1.32898399,23.8090889 2.00766739e-16,22.4801049 0,20.8407201 L0,20.8251855 C-2.00766739e-16,19.1858007 1.32898399,17.8568167 2.96836883,17.8568167 Z" id="矩形" fill="#5DCFFF"></path>\n                <path d="M16.3288173,17.8568167 L31.1749996,17.8568167 C32.8143844,17.8568167 34.1433684,19.1858007 34.1433684,20.8251855 L34.1433684,20.8407201 C34.1433684,22.4801049 32.8143844,23.8090889 31.1749996,23.8090889 L16.3288173,23.8090889 C14.6894325,23.8090889 13.3604485,22.4801049 13.3604485,20.8407201 L13.3604485,20.8251855 C13.3604485,19.1858007 14.6894325,17.8568167 16.3288173,17.8568167 Z" id="矩形" fill="#EEEEEE"></path>\n            </g>\n        </g>\n    </g>\n</svg>',
                        },
                        contentType: 'IMAGE',
                        predefinedType: 'STATIC_IMAGE',
                        id: 'static_image1',
                      },
                      caption: '图表-饼图',
                      itemStyle: 'DEFAULT',
                      itemType: 'RAWITEM',
                      layoutPos: {
                        shrink: 1,
                        layout: 'FLEX',
                      },
                      panelItemGroupLogics: [
                        {
                          logicCat: 'PANELVISIBLE',
                          relatedItemNames: ['chart_type'],
                          groupOP: 'AND',
                          panelItemLogics: [
                            {
                              condOp: 'EQ',
                              dstModelField: 'chart_type',
                              value: 'PIE',
                              logicType: 'SINGLE',
                              id: '逻辑项',
                            },
                          ],
                          logicType: 'GROUP',
                          id: '面板成员[static_image1][面板显示]逻辑',
                        },
                      ],
                      sysImage: {
                        rawContent:
                          '<?xml version="1.0" encoding="UTF-8"?>\n<svg width="200px" height="120px" viewBox="0 0 200 120" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">\n    <title>饼图</title>\n    <g id="饼图" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\n        <g id="编组-3" transform="translate(29.000000, 13.000000)">\n            <g id="编组" stroke="#FAFAFA" stroke-width="1.48418441">\n                <path d="M48.0374369,9.42051669 C58.1958835,9.61631972 67.3743424,13.8235279 74.062071,20.5273566 C80.9129187,27.394697 85.1501037,36.8818816 85.1501037,47.3610478 C85.1501037,57.840214 80.9129187,67.3273985 74.062071,74.194739 C67.2118684,81.0614328 57.748444,85.3087251 47.2953447,85.3087251 C36.9555707,85.3087251 27.5841207,81.1530341 20.7523301,74.4171423 C13.9083534,67.6692355 9.61295499,58.3319966 9.44573223,47.9948565 L9.448,48.103 L48.0374369,48.1033345 Z" id="形状结合" fill="#5DCFFF" transform="translate(47.295345, 47.361048) rotate(-195.000000) translate(-47.295345, -47.361048) "></path>\n                <path d="M65.1229138,11.284649 C71.5297735,14.3175298 76.9509333,19.0994744 80.7737147,25.0156411 C84.6074726,30.948795 86.8331634,38.0229752 86.8331634,45.6181885 C86.8331634,56.0973547 82.5959784,65.5845392 75.7451307,72.4518797 C68.894928,79.3185735 59.4315037,83.5658658 48.9784043,83.5658658 C38.6386304,83.5658658 29.2671803,79.4101748 22.4353897,72.674283 C15.591413,65.9263762 11.2960147,56.5891373 11.1287919,46.2519972 L11.131,46.36 L49.4597416,46.3604739 Z" id="形状结合" fill="#87DDA5" transform="translate(48.978404, 47.302274) rotate(-92.000000) translate(-48.978404, -47.302274) "></path>\n                <path d="M48.0374369,9.42051669 C58.1958835,9.61631972 67.3743424,13.8235279 74.062071,20.5273566 C80.9129187,27.394697 85.1501037,36.8818816 85.1501037,47.3610478 C85.1501037,57.840214 80.9129187,67.3273985 74.062071,74.194739 C67.2118684,81.0614328 57.748444,85.3087251 47.2953447,85.3087251 C39.7190765,85.3087251 32.6625854,83.0777574 26.7442863,79.2350774 C20.8410582,75.4021829 16.0699466,69.9663051 13.044459,63.5421845 L13.044459,63.5421845 L48.0374369,47.8416442 Z" id="形状结合" fill="#6698FF"></path>\n            </g>\n            <g id="编组-2" transform="translate(108.159610, 25.040218)">\n                <path d="M16.3288173,0 L31.1749996,0 C32.8143844,5.87028311e-16 34.1433684,1.32898399 34.1433684,2.96836883 L34.1433684,2.9839034 C34.1433684,4.62328824 32.8143844,5.95227223 31.1749996,5.95227223 L16.3288173,5.95227223 C14.6894325,5.95227223 13.3604485,4.62328824 13.3604485,2.9839034 L13.3604485,2.96836883 C13.3604485,1.32898399 14.6894325,1.18932853e-15 16.3288173,0 Z" id="矩形" fill="#EEEEEE"></path>\n                <path d="M16.3288173,38.6897695 L31.1749996,38.6897695 C32.8143844,38.6897695 34.1433684,40.0187535 34.1433684,41.6581383 L34.1433684,41.6736729 C34.1433684,43.3130578 32.8143844,44.6420417 31.1749996,44.6420417 L16.3288173,44.6420417 C14.6894325,44.6420417 13.3604485,43.3130578 13.3604485,41.6736729 L13.3604485,41.6581383 C13.3604485,40.0187535 14.6894325,38.6897695 16.3288173,38.6897695 Z" id="矩形" fill="#EEEEEE"></path>\n                <path d="M2.96836883,0 L2.96960829,0 C4.60899313,5.87028311e-16 5.93797712,1.32898399 5.93797712,2.96836883 L5.93797712,2.9839034 C5.93797712,4.62328824 4.60899313,5.95227223 2.96960829,5.95227223 L2.96836883,5.95227223 C1.32898399,5.95227223 2.00766739e-16,4.62328824 0,2.9839034 L0,2.96836883 C5.27266377e-16,1.32898399 1.32898399,1.18932853e-15 2.96836883,0 Z" id="矩形" fill="#6698FF"></path>\n                <path d="M2.96836883,38.6897695 L2.96960829,38.6897695 C4.60899313,38.6897695 5.93797712,40.0187535 5.93797712,41.6581383 L5.93797712,41.6736729 C5.93797712,43.3130578 4.60899313,44.6420417 2.96960829,44.6420417 L2.96836883,44.6420417 C1.32898399,44.6420417 -6.87411681e-16,43.3130578 0,41.6736729 L0,41.6581383 C-1.08894516e-15,40.0187535 1.32898399,38.6897695 2.96836883,38.6897695 Z" id="矩形" fill="#73D897"></path>\n                <path d="M2.96836883,17.8568167 L2.96960829,17.8568167 C4.60899313,17.8568167 5.93797712,19.1858007 5.93797712,20.8251855 L5.93797712,20.8407201 C5.93797712,22.4801049 4.60899313,23.8090889 2.96960829,23.8090889 L2.96836883,23.8090889 C1.32898399,23.8090889 2.00766739e-16,22.4801049 0,20.8407201 L0,20.8251855 C-2.00766739e-16,19.1858007 1.32898399,17.8568167 2.96836883,17.8568167 Z" id="矩形" fill="#5DCFFF"></path>\n                <path d="M16.3288173,17.8568167 L31.1749996,17.8568167 C32.8143844,17.8568167 34.1433684,19.1858007 34.1433684,20.8251855 L34.1433684,20.8407201 C34.1433684,22.4801049 32.8143844,23.8090889 31.1749996,23.8090889 L16.3288173,23.8090889 C14.6894325,23.8090889 13.3604485,22.4801049 13.3604485,20.8407201 L13.3604485,20.8251855 C13.3604485,19.1858007 14.6894325,17.8568167 16.3288173,17.8568167 Z" id="矩形" fill="#EEEEEE"></path>\n            </g>\n        </g>\n    </g>\n</svg>',
                      },
                      showCaption: true,
                      id: 'static_image1',
                    },
                    {
                      rawItem: {
                        sysImage: {
                          rawContent:
                            '<?xml version="1.0" encoding="UTF-8"?>\n<svg width="200px" height="120px" viewBox="0 0 200 120" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">\n    <title>个数</title>\n    <g id="个数" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\n        <g id="编组-7" transform="translate(54.235279, 14.763486)" fill="#333333">\n            <text id="24" font-family="Helvetica" font-size="69.5711444" font-weight="normal">\n                <tspan x="0" y="68">24</tspan>\n            </text>\n            <text id="个" font-family="PingFangSC-Medium, PingFang SC" font-size="19.4799204" font-weight="400">\n                <tspan x="86.31028" y="64.2786649">个</tspan>\n            </text>\n        </g>\n    </g>\n</svg>',
                        },
                        contentType: 'IMAGE',
                        predefinedType: 'STATIC_IMAGE',
                        id: 'static_image',
                      },
                      caption: '图表-数字',
                      itemStyle: 'DEFAULT',
                      itemType: 'RAWITEM',
                      layoutPos: {
                        shrink: 1,
                        layout: 'FLEX',
                      },
                      panelItemGroupLogics: [
                        {
                          logicCat: 'PANELVISIBLE',
                          relatedItemNames: ['chart_type'],
                          groupOP: 'AND',
                          panelItemLogics: [
                            {
                              condOp: 'EQ',
                              dstModelField: 'chart_type',
                              value: 'NUMBER',
                              logicType: 'SINGLE',
                              id: '逻辑项',
                            },
                          ],
                          logicType: 'GROUP',
                          id: '面板成员[static_image][面板显示]逻辑',
                        },
                      ],
                      sysImage: {
                        rawContent:
                          '<?xml version="1.0" encoding="UTF-8"?>\n<svg width="200px" height="120px" viewBox="0 0 200 120" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">\n    <title>个数</title>\n    <g id="个数" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\n        <g id="编组-7" transform="translate(54.235279, 14.763486)" fill="#333333">\n            <text id="24" font-family="Helvetica" font-size="69.5711444" font-weight="normal">\n                <tspan x="0" y="68">24</tspan>\n            </text>\n            <text id="个" font-family="PingFangSC-Medium, PingFang SC" font-size="19.4799204" font-weight="400">\n                <tspan x="86.31028" y="64.2786649">个</tspan>\n            </text>\n        </g>\n    </g>\n</svg>',
                      },
                      showCaption: true,
                      id: 'static_image',
                    },
                    {
                      rawItem: {
                        sysImage: {
                          rawContent:
                            '<?xml version="1.0" encoding="UTF-8"?>\n<svg width="200px" height="120px" viewBox="0 0 200 120" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">\n    <title>仪表盘</title>\n    <g id="仪表盘" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\n        <g id="编组-10" transform="translate(40.000000, 25.000000)">\n            <path d="M60,0 C92.8057141,0 119.462114,26.328343 119.991962,59.0077903 L120,60 L108,60 C108,33.490332 86.509668,12 60,12 C33.7554287,12 12.4303086,33.0626744 12.0064306,59.2062322 L12,60 L0,60 C0,26.862915 26.862915,0 60,0 Z" id="路径" fill="#F5F5F5" fill-rule="nonzero"></path>\n            <path d="M59.9151585,0 C70.8421095,0 81.3515459,2.93924903 90.5363294,8.41812344 L91.1334496,8.77903784 L84.8665504,19.0126088 C77.4142596,14.4489276 68.8516979,12 59.9151585,12 C33.7190679,12 12.4295898,33.0606063 12.0064199,59.2061702 L12,60 L0,60 C0,26.8650251 26.8228164,0 59.9151585,0 Z" id="路径" fill="#6698FF" fill-rule="nonzero"></path>\n            <text id="60%" font-family="PingFangSC-Medium, PingFang SC" font-size="26.8" font-weight="400" fill="#333333">\n                <tspan x="39" y="59">60</tspan>\n                <tspan x="71.16" y="59" font-size="14.8">%</tspan>\n            </text>\n            <text id="0" font-family="PingFangSC-Regular, PingFang SC" font-size="10" font-weight="normal" fill="#666666">\n                <tspan x="3" y="73">0</tspan>\n            </text>\n            <text id="100%" font-family="PingFangSC-Regular, PingFang SC" font-size="10" font-weight="normal" fill="#666666">\n                <tspan x="102" y="72">100%</tspan>\n            </text>\n        </g>\n    </g>\n</svg>',
                        },
                        contentType: 'IMAGE',
                        predefinedType: 'STATIC_IMAGE',
                        id: 'static_image7',
                      },
                      caption: '图片-仪表盘',
                      itemStyle: 'DEFAULT',
                      itemType: 'RAWITEM',
                      layoutPos: {
                        shrink: 1,
                        layout: 'FLEX',
                      },
                      panelItemGroupLogics: [
                        {
                          logicCat: 'PANELVISIBLE',
                          relatedItemNames: ['chart_type'],
                          groupOP: 'AND',
                          panelItemLogics: [
                            {
                              condOp: 'EQ',
                              dstModelField: 'chart_type',
                              value: 'GAUGE',
                              logicType: 'SINGLE',
                              id: '逻辑项',
                            },
                          ],
                          logicType: 'GROUP',
                          id: '面板成员[static_image7][面板显示]逻辑',
                        },
                      ],
                      sysImage: {
                        rawContent:
                          '<?xml version="1.0" encoding="UTF-8"?>\n<svg width="200px" height="120px" viewBox="0 0 200 120" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">\n    <title>仪表盘</title>\n    <g id="仪表盘" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\n        <g id="编组-10" transform="translate(40.000000, 25.000000)">\n            <path d="M60,0 C92.8057141,0 119.462114,26.328343 119.991962,59.0077903 L120,60 L108,60 C108,33.490332 86.509668,12 60,12 C33.7554287,12 12.4303086,33.0626744 12.0064306,59.2062322 L12,60 L0,60 C0,26.862915 26.862915,0 60,0 Z" id="路径" fill="#F5F5F5" fill-rule="nonzero"></path>\n            <path d="M59.9151585,0 C70.8421095,0 81.3515459,2.93924903 90.5363294,8.41812344 L91.1334496,8.77903784 L84.8665504,19.0126088 C77.4142596,14.4489276 68.8516979,12 59.9151585,12 C33.7190679,12 12.4295898,33.0606063 12.0064199,59.2061702 L12,60 L0,60 C0,26.8650251 26.8228164,0 59.9151585,0 Z" id="路径" fill="#6698FF" fill-rule="nonzero"></path>\n            <text id="60%" font-family="PingFangSC-Medium, PingFang SC" font-size="26.8" font-weight="400" fill="#333333">\n                <tspan x="39" y="59">60</tspan>\n                <tspan x="71.16" y="59" font-size="14.8">%</tspan>\n            </text>\n            <text id="0" font-family="PingFangSC-Regular, PingFang SC" font-size="10" font-weight="normal" fill="#666666">\n                <tspan x="3" y="73">0</tspan>\n            </text>\n            <text id="100%" font-family="PingFangSC-Regular, PingFang SC" font-size="10" font-weight="normal" fill="#666666">\n                <tspan x="102" y="72">100%</tspan>\n            </text>\n        </g>\n    </g>\n</svg>',
                      },
                      showCaption: true,
                      id: 'static_image7',
                    },
                    {
                      editor: {
                        halign: 'LEFT',
                        renderMode: 'TEXT_DYNAMIC',
                        valign: 'MIDDLE',
                        wrapMode: 'NOWRAP',
                        editorType: 'SPAN',
                        predefinedType: 'FIELD_TEXT_DYNAMIC',
                        valueType: 'SIMPLE',
                        editable: true,
                        id: 'name',
                      },
                      viewFieldName: 'name',
                      allowEmpty: true,
                      caption: '文本(动态)',
                      cssStyle: '    font-size: 18px;\n    font-weight: 600;',
                      itemStyle: 'DEFAULT',
                      itemType: 'FIELD',
                      layoutPos: {
                        shrink: 1,
                        layout: 'FLEX',
                      },
                      id: 'name',
                    },
                  ],
                  layout: {
                    align: 'center',
                    dir: 'column',
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
                  id: 'container',
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
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              id: 'page_container',
            },
          ],
          codeName: 'usr0708717469',
          controlType: 'PANEL',
          logicName: '模板报表卡片_卡片面板',
          appDataEntityId: 'plmweb.insight_report',
          controlParam: {},
          modelId: 'EE2621F8-26D9-456A-9963-042F976A2B86',
          modelType: 'PSSYSVIEWPANEL',
          name: 'itemlayoutpanel',
          id: 'plmweb.insight_report.usr0708717469',
        },
        dedataViewDataItems: [
          {
            appDEFieldId: 'id',
            dataType: 25,
            id: 'srfkey',
          },
          {
            appDEFieldId: 'name',
            dataType: 25,
            id: 'srfmajortext',
          },
          {
            appDEFieldId: 'view_id',
            dataType: 25,
            id: 'view_id',
          },
        ],
        pagingSize: 1000,
        appendDEItems: true,
        singleSelect: true,
        createControlAction: {
          appDEMethodId: 'create',
          appDataEntityId: 'plmweb.insight_report',
          id: 'create',
        },
        fetchControlAction: {
          appDEMethodId: 'fetch_is_system',
          appDataEntityId: 'plmweb.insight_report',
          id: 'fetch',
        },
        getControlAction: {
          appDEMethodId: 'get',
          appDataEntityId: 'plmweb.insight_report',
          id: 'load',
        },
        removeControlAction: {
          appDEMethodId: 'remove',
          appDataEntityId: 'plmweb.insight_report',
          id: 'remove',
        },
        updateControlAction: {
          appDEMethodId: 'update',
          appDataEntityId: 'plmweb.insight_report',
          id: 'update',
        },
        autoLoad: true,
        showBusyIndicator: true,
        codeName: 'templat_report_card',
        controlType: 'DATAVIEW',
        logicName: '模板报表卡片',
        appDataEntityId: 'plmweb.insight_report',
        controlParam: {
          id: 'dataview',
        },
        modelId: 'DE91B547-402A-41E1-9122-E8503C6DFEE9',
        modelType: 'PSDEDATAVIEW',
        name: 'dataview',
        id: 'plmweb.insight_report.templat_report_card',
      },
      {
        capLanguageRes: {
          lanResTag: 'DE.LNAME.INSIGHT_REPORT',
        },
        caption: '模板报表',
        codeName: 'custom_card_view_captionbar',
        controlType: 'CAPTIONBAR',
        appDataEntityId: 'plmweb.insight_report',
        controlParam: {},
        name: 'captionbar',
        id: 'custom_card_view_captionbar',
      },
    ],
    codeName: 'usr0708466061',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: '自定义模板报表卡片视图布局面板',
    appDataEntityId: 'plmweb.insight_report',
    controlParam: {},
    modelId: 'A95238B1-9D55-4D04-9BAE-DA355E726063',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'usr0708466061',
  },
  title: '模板报表',
  viewStyle: 'DEFAULT',
  viewType: 'DECUSTOMVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '4b51a2329d5a3236de5c26c06ac6d36a',
  modelType: 'PSAPPDEVIEW',
  name: 'insight_reportcustom_card_view',
  id: 'plmweb.insight_report_custom_card_view',
};