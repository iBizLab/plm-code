export default {
  tabLayout: 'TOP',
  loadDefault: true,
  showDataInfoBar: true,
  deviewCodeName: 'management_tab_search_view',
  deviewId: '21232b75e9c5f0ea42b1ec5d1c2a822f',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.WORKLOAD',
  },
  caption: '工时',
  codeName: 'workloadmanagement_tab_search_view',
  appDataEntityId: 'plmweb.workload',
  appViewNavParams: [
    {
      rawValue: true,
      key: 'showmode',
      value: 'ICONANDSHORTWORD',
      id: 'showmode',
    },
  ],
  sysCss: {
    cssName: 'workload-tab-head',
  },
  viewLayoutPanel: {
    viewProxyMode: true,
    layoutMode: 'FLEX',
    layout: {
      layout: 'FLEX',
    },
    rootPanelItems: [
      {
        panelItems: [
          {
            panelItems: [
              {
                panelItems: [
                  {
                    caption: '页面标题',
                    itemStyle: 'DEFAULT',
                    itemType: 'CTRLPOS',
                    layoutPos: {
                      shrink: 1,
                      layout: 'FLEX',
                    },
                    showCaption: true,
                    id: 'captionbar',
                  },
                ],
                layout: {
                  align: 'center',
                  layout: 'FLEX',
                },
                dataRegionType: 'INHERIT',
                caption: '容器',
                itemStyle: 'DEFAULT',
                itemType: 'CONTAINER',
                layoutPos: {
                  shrink: 1,
                  heightMode: 'FULL',
                  layout: 'FLEX',
                },
                id: 'view_captionbar',
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
              heightMode: 'FULL',
              layout: 'FLEX',
            },
            id: 'view_header_left',
          },
          {
            panelItems: [
              {
                panelItems: [
                  {
                    caption: '工具栏',
                    itemStyle: 'DEFAULT',
                    itemType: 'CTRLPOS',
                    layoutPos: {
                      shrink: 1,
                      layout: 'FLEX',
                    },
                    showCaption: true,
                    id: 'toolbar',
                  },
                ],
                layout: {
                  align: 'center',
                  layout: 'FLEX',
                },
                dataRegionType: 'INHERIT',
                caption: '容器',
                itemStyle: 'DEFAULT',
                itemType: 'CONTAINER',
                layoutPos: {
                  shrink: 1,
                  heightMode: 'FULL',
                  layout: 'FLEX',
                },
                id: 'view_toolbar',
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
              heightMode: 'FULL',
              layout: 'FLEX',
            },
            id: 'view_header_right',
          },
        ],
        predefinedType: 'VIEWHEADER',
        layout: {
          align: 'space-between',
          dir: 'row',
          layout: 'FLEX',
          valign: 'center',
        },
        dataRegionType: 'INHERIT',
        caption: '容器',
        cssStyle: 'border:none;\nheight:0',
        itemStyle: 'DEFAULT',
        itemType: 'CONTAINER',
        layoutPos: {
          shrink: 0,
          heightMode: 'PX',
          layout: 'FLEX',
        },
        id: 'view_header',
      },
      {
        panelItems: [
          {
            panelItems: [
              {
                caption: '关系分页部件',
                itemStyle: 'DEFAULT',
                itemType: 'CTRLPOS',
                layoutPos: {
                  shrink: 1,
                  layout: 'FLEX',
                },
                showCaption: true,
                id: 'tabexppanel',
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
              shrink: 0,
              layout: 'FLEX',
            },
            id: 'view_tabexppanel',
          },
          {
            panelItems: [
              {
                caption: '搜索栏',
                itemStyle: 'DEFAULT',
                itemType: 'CTRLPOS',
                layoutPos: {
                  shrink: 1,
                  layout: 'FLEX',
                },
                showCaption: true,
                id: 'searchbar',
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
              shrink: 0,
              layout: 'FLEX',
            },
            id: 'view_searchbar',
          },
          {
            panelItems: [
              {
                rawItem: {
                  predefinedType: 'NAV_POS',
                  id: 'nav_pos',
                },
                caption: '导航区占位',
                itemStyle: 'DEFAULT',
                itemType: 'RAWITEM',
                layoutPos: {
                  shrink: 1,
                  layout: 'FLEX',
                },
                showCaption: true,
                id: 'nav_pos',
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
              grow: 1,
              shrink: 1,
              layout: 'FLEX',
            },
            id: 'view_nav_pos',
          },
        ],
        predefinedType: 'VIEWCONTENT',
        layout: {
          layout: 'FLEX',
        },
        dataRegionType: 'INHERIT',
        caption: '容器',
        cssStyle: 'padding:0',
        itemStyle: 'DEFAULT',
        itemType: 'CONTAINER',
        layoutPos: {
          grow: 1,
          shrink: 1,
          layout: 'FLEX',
        },
        id: 'view_content',
      },
    ],
    layoutPanel: true,
    controls: [
      {
        tabExpPageIds: [
          'member',
          'work_item',
          'project',
          'idea',
          'product',
          'test_case',
          'library',
          'work_type',
        ],
        tabLayout: 'TOP',
        uniqueTag: 'workloadmanagement_tab_search_view__tabexppanel',
        appViewRefs: [
          {
            realTitle: '工时日历人员维度表格视图（管理）',
            refAppViewId: 'plmweb.workloadmanagement_member_calendar_grid_view',
            name: 'EXPITEM:member',
            id: 'expitem:member',
          },
          {
            realTitle: '工时日历工作项维度表格视图（管理）',
            refAppViewId:
              'plmweb.workloadcalendar_work_item_management_grid_view',
            name: 'EXPITEM:work_item',
            id: 'expitem:work_item',
          },
          {
            realTitle: '工时日历项目维度表格视图（管理）',
            refAppViewId: 'plmweb.workloadmanagement_project_grid_view',
            name: 'EXPITEM:project',
            id: 'expitem:project',
          },
          {
            realTitle: '工时日历需求维度表格视图（管理）',
            refAppViewId: 'plmweb.workloadcalendar_idea_management_grid_view',
            name: 'EXPITEM:idea',
            id: 'expitem:idea',
          },
          {
            realTitle: '工时日历项目维度表格视图（管理）',
            refAppViewId: 'plmweb.workloadmanagement_product_grid_view',
            name: 'EXPITEM:product',
            id: 'expitem:product',
          },
          {
            realTitle: '工时日历用例维度表格视图（管理）',
            refAppViewId:
              'plmweb.workloadcalendar_test_case_management_grid_view',
            name: 'EXPITEM:test_case',
            id: 'expitem:test_case',
          },
          {
            realTitle: '工时日历测试库维度表格视图（管理）',
            refAppViewId: 'plmweb.workloadmanagement_library_grid_view',
            name: 'EXPITEM:library',
            id: 'expitem:library',
          },
          {
            realTitle: '工时日历工作类别维度表格视图（管理）',
            refAppViewId: 'plmweb.workloadmanagement_work_type_grid_view',
            name: 'EXPITEM:work_type',
            id: 'expitem:work_type',
          },
        ],
        controls: [
          {
            sysImage: {
              rawContent:
                '<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" class="design-iconfont" width="18" height="18">\n  <path d="M13.4140625,11.93125 C13.11875,11.23125 12.69375,10.603125 12.1546875,10.0640625 C11.615625,9.525 10.9875,9.1015625 10.2875,8.8046875 C10.28125,8.8015625 10.275,8.8 10.26875,8.796875 C11.2421875,8.09375 11.875,6.9484375 11.875,5.65625 C11.875,3.515625 10.140625,1.78125 8,1.78125 C5.859375,1.78125 4.125,3.515625 4.125,5.65625 C4.125,6.9484375 4.7578125,8.09375 5.73125,8.7984375 C5.725,8.8015625 5.71875,8.803125 5.7125,8.80625 C5.0125,9.1015625 4.384375,9.525 3.8453125,10.065625 C3.30625,10.6046875 2.8828125,11.2328125 2.5859375,11.9328125 C2.2953125,12.6171875 2.140625,13.34375 2.12496822,14.090625 C2.1234375,14.1609375 2.1796875,14.21875 2.25,14.21875 L3.1875,14.21875 C3.25625,14.21875 3.3109375,14.1640625 3.3125,14.096875 C3.34375,12.890625 3.828125,11.7609375 4.684375,10.9046875 C5.5703125,10.01875 6.746875,9.53125 8,9.53125 C9.253125,9.53125 10.4296875,10.01875 11.315625,10.9046875 C12.171875,11.7609375 12.65625,12.890625 12.6875,14.096875 C12.6890625,14.165625 12.74375,14.21875 12.8125,14.21875 L13.75,14.21875 C13.8203125,14.21875 13.8765625,14.1609375 13.8750318,14.090625 C13.859375,13.34375 13.7046875,12.6171875 13.4140625,11.93125 Z M8,8.34375 C7.2828125,8.34375 6.6078125,8.0640625 6.1,7.55625 C5.5921875,7.0484375 5.3125,6.3734375 5.3125,5.65625 C5.3125,4.9390625 5.5921875,4.2640625 6.1,3.75625 C6.6078125,3.2484375 7.2828125,2.96875 8,2.96875 C8.7171875,2.96875 9.3921875,3.2484375 9.9,3.75625 C10.4078125,4.2640625 10.6875,4.9390625 10.6875,5.65625 C10.6875,6.3734375 10.4078125,7.0484375 9.9,7.55625 C9.3921875,8.0640625 8.7171875,8.34375 8,8.34375 Z" fill="#42D175" fill-rule="nonzero"></path>\n</svg>',
            },
            caption: '人员',
            embeddedAppDEViewId:
              'plmweb.workloadmanagement_member_calendar_grid_view',
            codeName: 'management_tab_search_viewmember',
            controlType: 'TABVIEWPANEL',
            appDataEntityId: 'plmweb.workload',
            controlParam: {
              id: 'member',
            },
            modelId: '242d75abc2100c0ca89c9d8afcdece5d_member',
            modelType: 'PSVIEWPANEL',
            name: 'member',
            id: 'management_tab_search_viewmember',
          },
          {
            sysImage: {
              rawContent:
                '<?xml version="1.0" encoding="UTF-8"?>\n<svg width="18px" height="18px" viewBox="0 0 18 18" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">\n    <title>工作项</title>\n    <g id="页面-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\n        <g id="产品生命周期管理系统" transform="translate(-836, -547)" fill-rule="nonzero">\n            <g id="工作项" transform="translate(836, 547)">\n                <rect id="矩形" fill="#000000" opacity="0" x="0" y="0" width="18" height="18"></rect>\n                <path d="M15.0222656,5.07304688 L11.2394531,1.29023438 C11.1339844,1.18476563 10.9916016,1.125 10.8421875,1.125 L3.375,1.125 C3.06386719,1.125 2.8125,1.37636719 2.8125,1.6875 L2.8125,16.3125 C2.8125,16.6236328 3.06386719,16.875 3.375,16.875 L14.625,16.875 C14.9361328,16.875 15.1875,16.6236328 15.1875,16.3125 L15.1875,5.47207031 C15.1875,5.32265625 15.1277344,5.17851563 15.0222656,5.07304688 Z M11.7046165,8.55 C11.851812,8.55 11.9440255,8.70762096 11.8500315,8.82244978 L9.01460931,12.2659698 C8.81360846,12.5113434 8.40347753,12.5113434 8.20259192,12.2661101 L6.52483049,10.2280526 C6.4309745,10.1133919 6.52318804,9.95577089 6.67038346,9.95577089 L7.30185051,9.95577089 C7.46181297,9.95577089 7.61269089,10.0238963 7.70848832,10.1399721 L8.6085,11.23425 L10.6663051,8.73445337 C10.7454613,8.63738596 10.8640657,8.57400495 10.9940314,8.55557426 L11.0731495,8.55 L11.7046165,8.55 Z M13.8902344,5.73046875 L10.5820312,5.73046875 L10.5820312,2.42226562 L13.8902344,5.73046875 Z M13.921875,15.609375 L4.078125,15.609375 L4.078125,2.390625 L9.38671875,2.390625 L9.38671875,6.1875 C9.38671875,6.5953125 9.7171875,6.92578125 10.125,6.92578125 L13.921875,6.92578125 L13.921875,15.609375 Z" id="形状" fill="#56AAFC"></path>\n            </g>\n        </g>\n    </g>\n</svg>',
            },
            caption: '工作项',
            embeddedAppDEViewId:
              'plmweb.workloadcalendar_work_item_management_grid_view',
            codeName: 'management_tab_search_viewwork_item',
            controlType: 'TABVIEWPANEL',
            appDataEntityId: 'plmweb.workload',
            controlParam: {
              id: 'work_item',
            },
            modelId: '242d75abc2100c0ca89c9d8afcdece5d_work_item',
            modelType: 'PSVIEWPANEL',
            name: 'work_item',
            id: 'management_tab_search_viewwork_item',
          },
          {
            sysImage: {
              rawContent:
                '<?xml version="1.0" encoding="UTF-8"?>\n<svg width="18px" height="18px" viewBox="0 0 18 18" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">\n    <title>项目</title>\n    <g id="页面-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\n        <g id="产品生命周期管理系统" transform="translate(-921, -553)">\n            <g id="项目" transform="translate(921, 553)">\n                <rect id="矩形" x="0" y="0" width="18" height="18"></rect>\n                <path d="M6.374172,1.89198008 C6.7509115,1.89100092 7.11171523,2.0433366 7.3747106,2.31287836 L8.98862844,3.95829866 L14.9057668,3.95903689 C15.6476618,3.95988627 16.2515749,4.53953638 16.3081535,5.27130721 L16.3124841,5.38216041 L16.3124841,14.6848307 C16.3116212,15.4680427 15.6847566,16.1070623 14.9051228,16.1079542 L3.07149039,16.1079542 C2.29250065,16.1070623 1.66563597,15.4680427 1.66477273,14.684211 L1.66477273,3.31517578 C1.66563595,2.53196525 2.29249833,1.89294628 3.07213438,1.89198008 L6.374172,1.89198008 Z M6.3757396,3.01699181 L3.07278228,3.01699181 C2.9189953,3.01722542 2.78995709,3.14876603 2.78977239,3.3157955 L2.78977239,14.6835912 C2.78995709,14.8512399 2.91899398,14.9827788 3.07213438,14.9829545 L14.9044788,14.9829545 C15.0582632,14.9827788 15.1873001,14.8512399 15.1874848,14.684211 L15.1874848,5.38339985 C15.1873001,5.21575114 15.0582632,5.08421222 14.9051228,5.08403652 L8.82513582,5.08403354 C8.62740492,5.08467752 8.43837214,5.00477 8.30231331,4.86495638 L6.57055792,3.09961922 C6.5184031,3.04616676 6.44895939,3.01684679 6.3757396,3.01699181 Z M14.2453125,7.87675781 C14.3595703,7.87675781 14.4263672,8.00683594 14.3595703,8.1 L11.4591797,12.1201172 C11.3466797,12.2748047 11.1181641,12.2748047 11.0056641,12.1201172 L9,9.33925781 C8.93320312,9.24609375 9,9.11601563 9.11425781,9.11601563 L10.0792969,9.11601563 C10.1689453,9.11601563 10.2533203,9.15820313 10.3060547,9.23203125 L11.2341797,10.5169922 L13.0552734,7.99101562 C13.1080078,7.91894531 13.1923828,7.875 13.2802734,7.87675781 Z M7.63769531,11.109375 C7.71503906,11.109375 7.77832031,11.1726563 7.77832031,11.25 L7.77832031,12.09375 C7.77832031,12.1710938 7.71503906,12.234375 7.63769531,12.234375 L4.40332031,12.234375 C4.32597656,12.234375 4.26269531,12.1710938 4.26269531,12.09375 L4.26269531,11.25 C4.26269531,11.1726563 4.32597656,11.109375 4.40332031,11.109375 Z M7.63769531,8.71875 C7.71503906,8.71875 7.77832031,8.78203125 7.77832031,8.859375 L7.77832031,9.703125 C7.77832031,9.78046875 7.71503906,9.84375 7.63769531,9.84375 L4.40332031,9.84375 C4.32597656,9.84375 4.26269531,9.78046875 4.26269531,9.703125 L4.26269531,8.859375 C4.26269531,8.78203125 4.32597656,8.71875 4.40332031,8.71875 Z" id="形状结合" fill="#56AAFC" fill-rule="nonzero"></path>\n            </g>\n        </g>\n    </g>\n</svg>',
            },
            caption: '项目',
            embeddedAppDEViewId: 'plmweb.workloadmanagement_project_grid_view',
            codeName: 'management_tab_search_viewproject',
            controlType: 'TABVIEWPANEL',
            appDataEntityId: 'plmweb.workload',
            controlParam: {
              id: 'project',
            },
            modelId: '242d75abc2100c0ca89c9d8afcdece5d_project',
            modelType: 'PSVIEWPANEL',
            name: 'project',
            id: 'management_tab_search_viewproject',
          },
          {
            sysImage: {
              rawContent:
                '<?xml version="1.0" encoding="UTF-8"?>\n<svg width="18px" height="18px" viewBox="0 0 18 18" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">\n    <title>产品需求</title>\n    <g id="页面-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\n        <g id="产品生命周期管理系统" transform="translate(-834, -486)" fill-rule="nonzero">\n            <g id="产品需求" transform="translate(834, 486)">\n                <rect id="矩形" fill="#000000" opacity="0" x="0" y="0" width="18" height="18"></rect>\n                <path d="M14.625,1.125 L3.375,1.125 C3.06386719,1.125 2.8125,1.37636719 2.8125,1.6875 L2.8125,16.3125 C2.8125,16.6236328 3.06386719,16.875 3.375,16.875 L14.625,16.875 C14.9361328,16.875 15.1875,16.6236328 15.1875,16.3125 L15.1875,1.6875 C15.1875,1.37636719 14.9361328,1.125 14.625,1.125 Z M13.921875,15.609375 L4.078125,15.609375 L4.078125,12.0761719 L5.79902344,12.0761719 C6.00292969,12.6527344 6.36152344,13.1712891 6.83789062,13.5650391 C7.44433594,14.0660156 8.2125,14.34375 9,14.34375 C9.7875,14.34375 10.5556641,14.0677734 11.1621094,13.5650391 C11.6384766,13.1712891 11.9970703,12.6527344 12.2009766,12.0761719 L13.921875,12.0761719 L13.921875,10.96875 L11.3132812,10.96875 L11.221875,11.4029297 C11.0109375,12.4541016 10.0757813,13.21875 9,13.21875 C7.92421875,13.21875 6.9890625,12.4541016 6.77636719,11.4029297 L6.68496094,10.96875 L4.078125,10.96875 L4.078125,2.390625 L13.921875,2.390625 L13.921875,15.609375 Z M5.625,5.99414062 L12.375,5.99414062 C12.4523438,5.99414062 12.515625,5.93085937 12.515625,5.85351562 L12.515625,5.00976562 C12.515625,4.93242188 12.4523438,4.86914062 12.375,4.86914062 L5.625,4.86914062 C5.54765625,4.86914062 5.484375,4.93242188 5.484375,5.00976562 L5.484375,5.85351562 C5.484375,5.93085937 5.54765625,5.99414062 5.625,5.99414062 Z M5.625,8.80664062 L12.375,8.80664062 C12.4523438,8.80664062 12.515625,8.74335938 12.515625,8.66601562 L12.515625,7.82226562 C12.515625,7.74492188 12.4523438,7.68164062 12.375,7.68164062 L5.625,7.68164062 C5.54765625,7.68164062 5.484375,7.74492188 5.484375,7.82226562 L5.484375,8.66601562 C5.484375,8.74335938 5.54765625,8.80664062 5.625,8.80664062 Z" id="形状" fill="#FF877B"></path>\n            </g>\n        </g>\n    </g>\n</svg>',
            },
            caption: '产品需求',
            embeddedAppDEViewId:
              'plmweb.workloadcalendar_idea_management_grid_view',
            codeName: 'management_tab_search_viewidea',
            controlType: 'TABVIEWPANEL',
            appDataEntityId: 'plmweb.workload',
            controlParam: {
              id: 'idea',
            },
            modelId: '242d75abc2100c0ca89c9d8afcdece5d_idea',
            modelType: 'PSVIEWPANEL',
            name: 'idea',
            id: 'management_tab_search_viewidea',
          },
          {
            sysImage: {
              rawContent:
                '<?xml version="1.0" encoding="UTF-8"?>\n<svg width="18px" height="18px" viewBox="0 0 18 18" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">\n    <title>产品</title>\n    <g id="页面-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\n        <g id="产品生命周期管理系统" transform="translate(-905, -486)" fill="#FF877B" fill-rule="nonzero">\n            <g id="产品" transform="translate(905, 486)">\n                <rect id="矩形" opacity="0" x="0" y="0" width="18" height="18"></rect>\n                <path d="M5.484375,2.53125 C3.8534091,2.53125 2.53125,3.8534091 2.53125,5.484375 C2.53125,7.1153409 3.8534091,8.4375 5.484375,8.4375 L8.15625,8.4375 L8.15625,8.4375 C8.3109375,8.4375 8.4375,8.3109375 8.4375,8.15625 L8.4375,5.484375 C8.4375,3.8534091 7.1153409,2.53125 5.484375,2.53125 Z M7.2421875,7.2421875 L5.484375,7.2421875 C4.51356196,7.2421875 3.7265625,6.45518804 3.7265625,5.484375 C3.7265625,4.51356196 4.51356196,3.7265625 5.484375,3.7265625 C6.45518804,3.7265625 7.2421875,4.51356196 7.2421875,5.484375 L7.2421875,7.2421875 L7.2421875,7.2421875 Z M12.515625,2.53125 C10.8846591,2.53125 9.5625,3.8534091 9.5625,5.484375 L9.5625,8.15625 L9.5625,8.15625 C9.5625,8.3109375 9.6890625,8.4375 9.84375,8.4375 L12.515625,8.4375 C14.1465909,8.4375 15.46875,7.1153409 15.46875,5.484375 C15.46875,3.8534091 14.1465909,2.53125 12.515625,2.53125 Z M12.515625,7.2421875 L10.7578125,7.2421875 L10.7578125,7.2421875 L10.7578125,5.484375 C10.7578125,4.51356196 11.544812,3.7265625 12.515625,3.7265625 C13.486438,3.7265625 14.2734375,4.51356196 14.2734375,5.484375 C14.2734375,6.45518804 13.486438,7.2421875 12.515625,7.2421875 Z M8.15625,9.5625 L5.484375,9.5625 C3.8534091,9.5625 2.53125,10.8846591 2.53125,12.515625 C2.53125,14.1465909 3.8534091,15.46875 5.484375,15.46875 C7.1153409,15.46875 8.4375,14.1465909 8.4375,12.515625 L8.4375,9.84375 L8.4375,9.84375 C8.4375,9.6890625 8.3109375,9.5625 8.15625,9.5625 Z M5.484375,14.2734375 C4.51356196,14.2734375 3.7265625,13.486438 3.7265625,12.515625 C3.7265625,11.544812 4.51356196,10.7578125 5.484375,10.7578125 L7.2421875,10.7578125 L7.2421875,10.7578125 L7.2421875,12.515625 C7.2421875,13.486438 6.45518804,14.2734375 5.484375,14.2734375 Z M12.515625,9.5625 L9.84375,9.5625 L9.84375,9.5625 C9.6890625,9.5625 9.5625,9.6890625 9.5625,9.84375 L9.5625,12.515625 C9.5625,14.1465909 10.8846591,15.46875 12.515625,15.46875 C14.1465909,15.46875 15.46875,14.1465909 15.46875,12.515625 C15.46875,10.8846591 14.1465909,9.5625 12.515625,9.5625 Z M12.515625,14.2734375 C11.544812,14.2734375 10.7578125,13.486438 10.7578125,12.515625 L10.7578125,10.7578125 L10.7578125,10.7578125 L12.515625,10.7578125 C13.486438,10.7578125 14.2734375,11.544812 14.2734375,12.515625 C14.2734375,13.486438 13.486438,14.2734375 12.515625,14.2734375 Z" id="形状"></path>\n            </g>\n        </g>\n    </g>\n</svg>',
            },
            caption: '产品',
            embeddedAppDEViewId: 'plmweb.workloadmanagement_product_grid_view',
            codeName: 'management_tab_search_viewproduct',
            controlType: 'TABVIEWPANEL',
            appDataEntityId: 'plmweb.workload',
            controlParam: {
              id: 'product',
            },
            modelId: '242d75abc2100c0ca89c9d8afcdece5d_product',
            modelType: 'PSVIEWPANEL',
            name: 'product',
            id: 'management_tab_search_viewproduct',
          },
          {
            sysImage: {
              rawContent:
                '<?xml version="1.0" encoding="UTF-8"?>\n<svg width="18px" height="18px" viewBox="0 0 18 18" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">\n    <title>测试用例</title>\n    <g id="页面-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\n        <g id="产品生命周期管理系统" transform="translate(-836, -608)">\n            <g id="测试用例" transform="translate(836, 608)">\n                <rect id="矩形" x="0" y="0" width="18" height="18"></rect>\n                <g id="编组-3" transform="translate(1.5, 4.3944)" fill-rule="nonzero">\n                    <path d="M7.5,0.105624544 C8.08851772,0.105624544 8.6612034,0.153074044 9.21067553,0.242805984 C9.0910382,0.617770812 9.01981308,1.01412421 9.00357413,1.42461261 C8.52390001,1.34694143 8.02058616,1.30562454 7.5,1.30562454 C3.94793423,1.30562454 1.2,3.22917851 1.2,5.35562454 C1.2,7.48207058 3.94793423,9.40562454 7.5,9.40562454 C10.6299696,9.40562454 13.1355645,7.9120647 13.6868522,6.10220646 L13.5,6.10562454 C14.0128358,6.10562454 14.5056351,6.01983783 14.9648303,5.86183191 C14.601914,8.52373033 11.3982802,10.6056245 7.5,10.6056245 C3.35786438,10.6056245 0,8.25511948 0,5.35562454 C0,2.45612961 3.35786438,0.105624544 7.5,0.105624544 Z" id="形状结合" fill="#73D897"></path>\n                    <polygon id="路径" fill="#F7867E" points="12.7171481 1.75007856 14.4672267 0 14.9671481 0.499921435 13.2170696 2.25 14.9671481 4.00007856 14.4672267 4.5 12.7171481 2.74992144 10.9670696 4.5 10.4671481 4.00007856 12.2172267 2.25 10.4671481 0.499921435 10.9670696 0"></polygon>\n                </g>\n            </g>\n        </g>\n    </g>\n</svg>',
            },
            caption: '测试用例',
            embeddedAppDEViewId:
              'plmweb.workloadcalendar_test_case_management_grid_view',
            codeName: 'management_tab_search_viewtest_case',
            controlType: 'TABVIEWPANEL',
            appDataEntityId: 'plmweb.workload',
            controlParam: {
              id: 'test_case',
            },
            modelId: '242d75abc2100c0ca89c9d8afcdece5d_test_case',
            modelType: 'PSVIEWPANEL',
            name: 'test_case',
            id: 'management_tab_search_viewtest_case',
          },
          {
            sysImage: {
              rawContent:
                '<?xml version="1.0" encoding="UTF-8"?>\n<svg width="18px" height="18px" viewBox="0 0 18 18" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">\n    <title>测试库</title>\n    <g id="页面-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\n        <g id="产品生命周期管理系统" transform="translate(-906, -608)" fill-rule="nonzero">\n            <g id="测试库" transform="translate(906, 608)">\n                <rect fill="#000000" opacity="0" x="0" y="0" width="18" height="18"></rect>\n                <path d="M15.46875,2.30696309 L12.515625,2.30696309 L12.515625,1.18196309 C12.515625,1.10461934 12.4523437,1.04133809 12.375,1.04133809 L11.390625,1.04133809 C11.3132812,1.04133809 11.25,1.10461934 11.25,1.18196309 L11.25,2.30696309 L6.75,2.30696309 L6.75,1.18196309 C6.75,1.10461934 6.68671875,1.04133809 6.609375,1.04133809 L5.625,1.04133809 C5.54765625,1.04133809 5.484375,1.10461934 5.484375,1.18196309 L5.484375,2.30696309 L2.53125,2.30696309 C2.22011719,2.30696309 1.96875,2.55833028 1.96875,2.86946309 L1.96875,16.4477668 C1.96875,16.7588996 2.22011719,17.0102668 2.53125,17.0102668 L15.46875,17.0102668 C15.7798828,17.0102668 16.03125,16.7588996 16.03125,16.4477668 L16.03125,2.86946309 C16.03125,2.55833028 15.7798828,2.30696309 15.46875,2.30696309 Z M14.765625,15.7446418 L3.234375,15.7446418 L3.234375,3.57258809 L5.484375,3.57258809 L5.484375,4.41633809 C5.484375,4.49368184 5.54765625,4.55696309 5.625,4.55696309 L6.609375,4.55696309 C6.68671875,4.55696309 6.75,4.49368184 6.75,4.41633809 L6.75,3.57258809 L11.25,3.57258809 L11.25,4.41633809 C11.25,4.49368184 11.3132812,4.55696309 11.390625,4.55696309 L12.375,4.55696309 C12.4523437,4.55696309 12.515625,4.49368184 12.515625,4.41633809 L12.515625,3.57258809 L14.765625,3.57258809 L14.765625,15.7446418 Z M4.415625,8.30273438 L5.625,8.30273438 L5.625,9.51210938 C5.625,9.54375 5.65664063,9.56835938 5.6953125,9.56835938 L6.5390625,9.56835938 C6.57773437,9.56835938 6.609375,9.54375 6.609375,9.51035156 L6.609375,8.30273438 L7.81875,8.30273438 C7.85039063,8.30273438 7.875,8.27109375 7.875,8.23242188 L7.875,7.38867188 C7.875,7.35 7.85039062,7.31835938 7.81699219,7.31835938 L6.609375,7.31835938 L6.609375,6.10898438 C6.609375,6.07734375 6.57773437,6.05273438 6.5390625,6.05273438 L5.6953125,6.05273438 C5.65664063,6.05273438 5.625,6.07734375 5.625,6.10898438 L5.625,7.31835938 L4.415625,7.31835938 C4.38398438,7.31835938 4.359375,7.35 4.359375,7.38867188 L4.359375,8.23242188 C4.359375,8.27109375 4.38398438,8.30273438 4.415625,8.30273438 Z M9.34531902,8.30273438 L13.584375,8.30273438 C13.6160156,8.30273438 13.640625,8.27109375 13.640625,8.23242188 L13.640625,7.38867188 C13.640625,7.35 13.6160156,7.31835938 13.5826172,7.31835938 L9.34531902,7.31835938 C9.31367839,7.31835938 9.28906902,7.35 9.28906902,7.38867188 L9.28906902,8.23242188 C9.28906902,8.27109375 9.31367839,8.30273438 9.34531902,8.30273438 Z M9.34531902,13.7109375 L13.584375,13.7109375 C13.6160156,13.7109375 13.640625,13.6792969 13.640625,13.640625 L13.640625,12.796875 C13.640625,12.7582031 13.6160156,12.7265625 13.5826172,12.7265625 L9.34531902,12.7265625 C9.31367839,12.7265625 9.28906902,12.7582031 9.28906902,12.796875 L9.28906902,13.640625 C9.28906902,13.6792969 9.31367839,13.7109375 9.34531902,13.7109375 Z M7.81699219,12.0486328 C7.89257812,11.9572266 7.82929687,11.8183594 7.71328125,11.8183594 L6.8203125,11.8183594 C6.77988281,11.8183594 6.74121094,11.8359375 6.71660156,11.8693359 L6.11894531,12.6005859 L5.52128906,11.8693359 C5.49492187,11.8376953 5.45625,11.8183594 5.41757812,11.8183594 L4.52285156,11.8183594 C4.40683594,11.8183594 4.34355469,11.9572266 4.41914062,12.0486328 L5.49492187,13.3652344 L4.39277344,14.7152344 C4.31542969,14.8066406 4.37871094,14.9455078 4.49472656,14.9455078 L5.38769531,14.9455078 C5.428125,14.9455078 5.46679687,14.9279297 5.49140625,14.8945313 L6.11542969,14.1298828 L6.73945312,14.8945313 C6.76582031,14.9261719 6.80449219,14.9455078 6.84316406,14.9455078 L7.73613281,14.9455078 C7.85214844,14.9455078 7.91542969,14.8066406 7.83984375,14.7152344 L6.74121094,13.3652344 L7.81699219,12.0486328 Z" id="形状" fill="#73D897"></path>\n            </g>\n        </g>\n    </g>\n</svg>',
            },
            caption: '测试库',
            embeddedAppDEViewId: 'plmweb.workloadmanagement_library_grid_view',
            codeName: 'management_tab_search_viewlibrary',
            controlType: 'TABVIEWPANEL',
            appDataEntityId: 'plmweb.workload',
            controlParam: {
              id: 'library',
            },
            modelId: '242d75abc2100c0ca89c9d8afcdece5d_library',
            modelType: 'PSVIEWPANEL',
            name: 'library',
            id: 'management_tab_search_viewlibrary',
          },
          {
            sysImage: {
              rawContent:
                '<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 18 18" class="design-iconfont" width="18" height="18">\n  <path d="M16.03125,3.375 L5.765625,3.375 C5.68828125,3.375 5.625,3.43828125 5.625,3.515625 L5.625,4.5 C5.625,4.57734375 5.68828125,4.640625 5.765625,4.640625 L16.03125,4.640625 C16.1085937,4.640625 16.171875,4.57734375 16.171875,4.5 L16.171875,3.515625 C16.171875,3.43828125 16.1085937,3.375 16.03125,3.375 Z M16.03125,8.3671875 L5.765625,8.3671875 C5.68828125,8.3671875 5.625,8.43046875 5.625,8.5078125 L5.625,9.4921875 C5.625,9.56953125 5.68828125,9.6328125 5.765625,9.6328125 L16.03125,9.6328125 C16.1085937,9.6328125 16.171875,9.56953125 16.171875,9.4921875 L16.171875,8.5078125 C16.171875,8.43046875 16.1085937,8.3671875 16.03125,8.3671875 Z M16.03125,13.359375 L5.765625,13.359375 C5.68828125,13.359375 5.625,13.4226563 5.625,13.5 L5.625,14.484375 C5.625,14.5617187 5.68828125,14.625 5.765625,14.625 L16.03125,14.625 C16.1085937,14.625 16.171875,14.5617187 16.171875,14.484375 L16.171875,13.5 C16.171875,13.4226563 16.1085937,13.359375 16.03125,13.359375 Z M1.828125,4.0078125 C1.828125,4.35949582 2.01574581,4.68446461 2.3203125,4.86030627 C2.62487918,5.03614793 3.00012082,5.03614793 3.3046875,4.86030627 C3.60925419,4.68446461 3.796875,4.35949582 3.796875,4.0078125 C3.796875,3.65612918 3.60925419,3.33116039 3.3046875,3.15531873 C3.00012082,2.97947707 2.62487918,2.97947707 2.3203125,3.15531873 C2.01574581,3.33116039 1.828125,3.65612918 1.828125,4.0078125 L1.828125,4.0078125 Z M1.828125,9 C1.828125,9.35168332 2.01574581,9.67665211 2.3203125,9.85249377 C2.62487918,10.0283354 3.00012082,10.0283354 3.3046875,9.85249377 C3.60925419,9.67665211 3.796875,9.35168332 3.796875,9 C3.796875,8.64831668 3.60925419,8.32334789 3.3046875,8.14750623 C3.00012082,7.97166457 2.62487918,7.97166457 2.3203125,8.14750623 C2.01574581,8.32334789 1.828125,8.64831668 1.828125,9 L1.828125,9 Z M1.828125,13.9921875 C1.828125,14.3438708 2.01574581,14.6688396 2.3203125,14.8446813 C2.62487918,15.0205229 3.00012082,15.0205229 3.3046875,14.8446813 C3.60925419,14.6688396 3.796875,14.3438708 3.796875,13.9921875 C3.796875,13.6405042 3.60925419,13.3155354 3.3046875,13.1396937 C3.00012082,12.9638521 2.62487918,12.9638521 2.3203125,13.1396937 C2.01574581,13.3155354 1.828125,13.6405042 1.828125,13.9921875 L1.828125,13.9921875 Z" fill="#EB9B3E" fill-rule="nonzero"></path>\n</svg>',
            },
            caption: '工作类别',
            embeddedAppDEViewId:
              'plmweb.workloadmanagement_work_type_grid_view',
            codeName: 'management_tab_search_viewwork_type',
            controlType: 'TABVIEWPANEL',
            appDataEntityId: 'plmweb.workload',
            controlParam: {
              id: 'work_type',
            },
            modelId: '242d75abc2100c0ca89c9d8afcdece5d_work_type',
            modelType: 'PSVIEWPANEL',
            name: 'work_type',
            id: 'management_tab_search_viewwork_type',
          },
        ],
        codeName: 'management_tab_search_viewtabexppanel',
        controlStyle: 'TAB_EXP_SELECT',
        controlType: 'TABEXPPANEL',
        appDataEntityId: 'plmweb.workload',
        controlParam: {},
        sysPFPluginId: 'tab_exp_select',
        modelId: '242d75abc2100c0ca89c9d8afcdece5d_tabexppanel',
        modelType: 'PSTABEXPPANEL',
        name: 'tabexppanel',
        id: 'management_tab_search_viewtabexppanel',
      },
      {
        capLanguageRes: {
          lanResTag: 'DE.LNAME.WORKLOAD',
        },
        caption: '工时',
        codeName: 'management_tab_search_viewcaptionbar',
        controlType: 'CAPTIONBAR',
        appDataEntityId: 'plmweb.workload',
        controlParam: {},
        name: 'captionbar',
        id: 'management_tab_search_viewcaptionbar',
      },
    ],
    codeName: 'Usr0322959688',
    controlType: 'VIEWLAYOUTPANEL',
    logicName: 'management_tab_search_view分页搜索视图布局面板',
    appDataEntityId: 'plmweb.workload',
    controlParam: {},
    modelId: '7419ab3324ec14cc2dc8e70236b77677',
    modelType: 'PSSYSVIEWLAYOUTPANEL',
    name: 'layoutpanel',
    id: 'usr0322959688',
  },
  title: '工时日历分页搜索视图（管理）',
  viewStyle: 'DEFAULT',
  viewType: 'DETABSEARCHVIEW',
  enableDP: true,
  showCaptionBar: false,
  modelId: '242d75abc2100c0ca89c9d8afcdece5d',
  modelType: 'PSAPPDEVIEW',
  name: 'workloadmanagement_tab_search_view',
  id: 'plmweb.workloadmanagement_tab_search_view',
};