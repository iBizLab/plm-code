export default {
  showDataInfoBar: true,
  loadDefault: true,
  deviewCodeName: 'tree_exp_view',
  deviewId: '8dca1dd21fd709281cdf8819aa3e8b85',
  accUserMode: 2,
  capLanguageRes: {
    lanResTag: 'DE.LNAME.DISCUSS_POST',
  },
  caption: '讨论',
  codeName: 'discuss_post_tree_exp_view',
  appDataEntityId: 'plmweb.discuss_post',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'TreeExpView',
      id: 'engine',
    },
  ],
  appViewLogics: [
    {
      logicTrigger: 'CUSTOM',
      logicType: 'APPUILOGIC',
      builtinAppUILogic: {
        actionAfterWizard: 'DEFAULT',
        builtinLogic: true,
        logicType: 'PREDEFINED',
        viewLogicType: 'APP_NEWDATA',
        id: '新建数据',
      },
      builtinLogic: true,
      id: 'newdata',
    },
    {
      logicTrigger: 'CUSTOM',
      logicType: 'APPUILOGIC',
      builtinAppUILogic: {
        editMode: true,
        builtinLogic: true,
        logicType: 'PREDEFINED',
        viewLogicType: 'APP_OPENDATA',
        id: '打开数据',
      },
      builtinLogic: true,
      id: 'opendata',
    },
  ],
  controls: [
    {
      xdataControlName: 'treeexpbar_tree',
      enableCounter: true,
      showTitleBar: true,
      autoLoad: true,
      showBusyIndicator: true,
      appViewRefs: [
        {
          realTitle: '讨论实体表格视图（全部讨论）',
          refAppViewId: 'plmweb.discuss_post_all_grid_view',
          name: 'EXPITEM:node',
          id: 'expitem:node',
        },
        {
          realTitle: '讨论实体表格视图 （我发起的）',
          refAppViewId: 'plmweb.discuss_post_my_create_grid_view',
          name: 'EXPITEM:node_1',
          id: 'expitem:node_1',
        },
        {
          realTitle: '讨论实体表格视图 （我回复的）',
          refAppViewId: 'plmweb.discuss_post_my_reply_grid_view',
          name: 'EXPITEM:node_2',
          id: 'expitem:node_2',
        },
        {
          realTitle: '讨论实体表格视图 （我关注的）',
          refAppViewId: 'plmweb.discuss_post_my_attention_grid_view',
          name: 'EXPITEM:node_3',
          id: 'expitem:node_3',
        },
        {
          realTitle: '最新回复列表视图',
          refAppViewId: 'plmweb.discuss_reply_latest_grid_view',
          name: 'EXPITEM:node_6',
          id: 'expitem:node_6',
        },
        {
          realTitle: '我的回复列表视图',
          refAppViewId: 'plmweb.discuss_reply_my_grid_view',
          name: 'EXPITEM:node_7',
          id: 'expitem:node_7',
        },
      ],
      controls: [
        {
          detreeNodeRSs: [
            {
              childDETreeNodeId: 'node_4',
              parentDETreeNodeId: 'root',
              parentValueLevel: 1,
              searchMode: 3,
              id: '默认根节点 - 讨论',
            },
            {
              childDETreeNodeId: 'node',
              parentDETreeNodeId: 'node_4',
              parentValueLevel: 1,
              searchMode: 3,
              id: '讨论 - 全部讨论',
            },
            {
              childDETreeNodeId: 'node_6',
              parentDETreeNodeId: 'node_5',
              parentValueLevel: 1,
              searchMode: 3,
              id: '回复 - 最新回复',
            },
            {
              childDETreeNodeId: 'node_5',
              parentDETreeNodeId: 'root',
              parentValueLevel: 1,
              searchMode: 3,
              id: '默认根节点 - 回复',
            },
            {
              childDETreeNodeId: 'node_1',
              parentDETreeNodeId: 'node_4',
              parentValueLevel: 1,
              searchMode: 3,
              id: '讨论 - 我发起的',
            },
            {
              childDETreeNodeId: 'node_7',
              parentDETreeNodeId: 'node_5',
              parentValueLevel: 1,
              searchMode: 3,
              id: '回复 - 我的回复',
            },
            {
              childDETreeNodeId: 'node_2',
              parentDETreeNodeId: 'node_4',
              parentValueLevel: 1,
              searchMode: 3,
              id: '讨论 - 我回复的',
            },
            {
              childDETreeNodeId: 'node_3',
              parentDETreeNodeId: 'node_4',
              parentValueLevel: 1,
              searchMode: 3,
              id: '讨论 - 我关注的',
            },
          ],
          detreeNodes: [
            {
              nodeValue: 'root',
              text: '默认根节点',
              nodeType: 'ROOT',
              treeNodeType: 'STATIC',
              hasDETreeNodeRSs: true,
              rootNode: true,
              name: '默认根节点',
              id: 'root',
            },
            {
              text: '全部讨论',
              navAppViewId: 'plmweb.discuss_post_all_grid_view',
              nodeType: 'node',
              sysImage: {
                height: 20,
                rawContent:
                  '<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" class="zfaoqr8zf__design-iconfont" width="18" height="18">\n  <path d="M8.25,4.75 C8.25,6.40685415 9.59314585,7.75 11.25,7.75 C12.9068546,7.75 14.25,6.40685415 14.25,4.75 C14.25,3.09314585 12.9068546,1.75 11.25,1.75 C9.59314585,1.75 8.25,3.09314585 8.25,4.75 Z M11.25,6.75 C12.3545694,6.75 13.25,5.85456944 13.25,4.75 C13.25,3.64543068 12.3545694,2.75 11.25,2.75 C10.1454306,2.75 9.25,3.64543068 9.25,4.75 C9.25,5.85456944 10.1454306,6.75 11.25,6.75 Z M3,2 L6.5,2 C7.05228472,2 7.5,2.44771528 7.5,3 L7.5,6.5 C7.5,7.05228472 7.05228472,7.5 6.5,7.5 L3,7.5 C2.44771528,7.5 2,7.05228472 2,6.5 L2,3 C2,2.44771528 2.44771528,2 3,2 Z M6.5,3 L6.5,6.5 L3,6.5 L3,3 L6.5,3 Z M3,8.5 L6.5,8.5 C7.05228472,8.5 7.5,8.94771528 7.5,9.5 L7.5,13 C7.5,13.5522842 7.05228472,14 6.5,14 L3,14 C2.44771528,14 2,13.5522842 2,13 L2,9.5 C2,8.94771528 2.44771528,8.5 3,8.5 Z M6.5,9.5 L6.5,13 L3,13 L3,9.5 L6.5,9.5 Z M9.5,8.5 L13,8.5 C13.5522842,8.5 14,8.94771528 14,9.5 L14,13 C14,13.5522842 13.5522842,14 13,14 L9.5,14 C8.94771528,14 8.5,13.5522842 8.5,13 L8.5,9.5 C8.5,8.94771528 8.94771528,8.5 9.5,8.5 Z M9.5,9.5 L13,9.5 L13,13 L9.5,13 L9.5,9.5 Z" fill-opacity=".89999998" fill-rule="evenodd" fill="#56AAFC"></path>\n</svg>',
                width: 20,
              },
              treeNodeType: 'STATIC',
              name: '全部讨论',
              id: 'node',
            },
            {
              text: '我发起的',
              navAppViewId: 'plmweb.discuss_post_my_create_grid_view',
              nodeType: 'node_1',
              sysImage: {
                rawContent:
                  '<?xml version="1.0" standalone="no"?><!DOCTYPE svg PUBLIC "-//W3C//DTD SVG 1.1//EN" "http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd"><svg t="1715823872557" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="1437" xmlns:xlink="http://www.w3.org/1999/xlink" width="200" height="200"><path d="M781.118801 610.6567a423.656786 423.656786 0 0 0-126.366593-73.044273h-2.191328a289.985766 289.985766 0 0 0 57.704976-452.874496 285.237888 285.237888 0 0 0-405.760939 0 289.985766 289.985766 0 0 0 57.704976 453.239717 428.404664 428.404664 0 0 0-162.158287 102.992426A438.265641 438.265641 0 0 0 72.589349 949.582129a36.522137 36.522137 0 0 0 17.165404 32.504702 33.235144 33.235144 0 0 0 36.522137 0 36.522137 36.522137 0 0 0 17.165404-31.774259 365.221367 365.221367 0 0 1 594.215164-285.60311 33.600366 33.600366 0 0 0 36.522137 6.208764 36.522137 36.522137 0 0 0 22.643725-27.756824 36.522137 36.522137 0 0 0-13.513191-33.600366M291.722169 288.896676a216.576271 216.576271 0 1 1 216.576271 219.13282 219.13282 219.13282 0 0 1-216.576271-219.13282" fill="#ffcd5d" p-id="1438"></path><path d="M499.167906 871.789978a36.522137 36.522137 0 0 0 8.400091 27.391602 32.869923 32.869923 0 0 0 26.295938 10.59142h296.194529l-57.339754 52.591877a33.965587 33.965587 0 0 0 11.321862 60.261525 34.330809 34.330809 0 0 0 33.600366-8.400091l121.618715-111.392517a43.826564 43.826564 0 0 0 0-58.070197L817.640938 730.449309a33.965587 33.965587 0 0 0-57.339755 17.530625 33.600366 33.600366 0 0 0 11.687084 32.869923l57.339755 52.591877h-295.464087a32.504702 32.504702 0 0 0-26.295938 10.59142 31.774259 31.774259 0 0 0-8.400091 26.295938" fill="#ffcd5d" p-id="1439"></path></svg>',
              },
              treeNodeType: 'STATIC',
              name: '我发起的',
              id: 'node_1',
            },
            {
              text: '我回复的',
              navAppViewId: 'plmweb.discuss_post_my_reply_grid_view',
              nodeType: 'node_2',
              sysImage: {
                rawContent:
                  '<svg xmlns="http://www.w3.org/2000/svg" class="icon design-iconfont" viewBox="0 0 1024 1024" width="128" height="128">\n  <path d="M933.875 723.25390625a70.13671875 70.13671875 0 0 1-70.13671875 69.97851563H576.12499999c-19.24804688 0-48.99023438 7.59375001-65.75976562 16.55859374l-217.58203123 116.54296876c-34.27734375 18.35156251-62.06835938 2.00390625-62.06835939-37.28320313v-60.5390625a35.17382813 35.17382813 0 0 0-35.49023437-35.27929687h-34.80468751A70.29492188 70.29492188 0 0 1 90.125 723.25390625V160.10351562C90.125 121.44921875 121.66015625 90.125 160.63085937 90.125h702.73828125C902.33984375 90.125 933.875 121.71289061 933.875 160.10351562v563.203125zM230.76757812 722.9375C269.58007812 722.9375 301.0625 754.578125 301.0625 793.07421874v17.92968751c0 19.35351564 13.7109375 26.89453125 30.32226563 17.0859375l147.76171874-87.27539063c16.76953125-9.86132814 45.984375-17.87695314 65.60156251-17.87695312h283.55273436c19.51171875 0 35.27929689-15.609375 35.27929689-35.17382813V195.59374999a35.33203125 35.33203125 0 0 0-34.91015624-35.22656249H195.33007811a34.96289063 34.96289063 0 0 0-34.91015623 35.22656251v492.11718749c0 19.40625001 15.609375 35.17382813 35.49023437 35.17382812h34.8046875zM301.0625 547.17382813A35.33203125 35.33203125 0 0 1 336.2890625 512h351.421875a35.12109375 35.12109375 0 1 1 0 70.29492188H336.2890625A35.12109375 35.12109375 0 0 1 301.0625 547.17382813z m0-210.93750001A35.33203125 35.33203125 0 0 1 336.2890625 301.0625h351.421875a35.12109375 35.12109375 0 1 1 0 70.29492188H336.2890625A35.12109375 35.12109375 0 0 1 301.0625 336.23632812z" fill="#73d897"></path>\n</svg>',
              },
              treeNodeType: 'STATIC',
              name: '我回复的',
              id: 'node_2',
            },
            {
              text: '我关注的',
              navAppViewId: 'plmweb.discuss_post_my_attention_grid_view',
              nodeType: 'node_3',
              sysImage: {
                rawContent:
                  '<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" class="design-iconfont" width="18" height="18">\n  <g fill="#F6C659" fill-rule="nonzero">\n    <path d="M8,1 C4.134375,1 1,4.134375 1,8 C1,11.865625 4.134375,15 8,15 C11.865625,15 15,11.865625 15,8 C15,4.134375 11.865625,1 8,1 Z M8,13.8125 C4.790625,13.8125 2.1875,11.209375 2.1875,8 C2.1875,4.790625 4.790625,2.1875 8,2.1875 C11.209375,2.1875 13.8125,4.790625 13.8125,8 C13.8125,11.209375 11.209375,13.8125 8,13.8125 Z"></path>\n    <path d="M7.5295078,2.94190234 C7.65897299,2.68297194 7.97357518,2.57658473 8.2326324,2.70447388 C8.33616834,2.75542013 8.41997049,2.83922228 8.47085272,2.94262826 L9.76537422,5.56738629 L12.6633702,5.98945009 C12.951458,6.03225095 13.1507318,6.29913552 13.1066955,6.58449445 C13.0903712,6.69876512 13.0366525,6.80407069 12.9539315,6.88513659 L10.8563742,8.92838629 L11.3528971,11.8147483 C11.3966515,12.0685238 11.2499485,12.3108363 11.0163783,12.3961071 L10.9249199,12.420438 C10.8108987,12.4402678 10.6927199,12.4217889 10.591524,12.3679244 L7.99937422,11.0053863 L5.4091279,12.3675796 C5.18157883,12.4886474 4.90456402,12.4236846 4.75133142,12.2280026 L4.70000986,12.1486024 C4.64578921,12.0467333 4.62731034,11.9285544 4.64708299,11.8148638 L5.14237422,8.92838629 L3.04599044,6.88506045 C2.86133196,6.70476398 2.83761673,6.42292606 2.97678923,6.21573793 L3.03661807,6.14188571 C3.11741368,6.05944122 3.22271926,6.00572258 3.33662984,5.98945009 L6.23337422,5.56738629 L7.5295078,2.94190234 Z M7.99937422,4.57338629 L7.02826381,6.54294046 L6.91532721,6.62500247 L4.74037422,6.94038629 L6.31409723,8.47502888 L6.35721265,8.60779962 L5.98437422,10.7723863 L7.93020467,9.75043034 L8.06974024,9.7504014 L10.0143742,10.7713863 L9.64278735,8.60662774 L9.68593882,8.47382187 L11.2583742,6.94038629 L9.08467279,6.62500247 L8.97173619,6.54294046 L7.99937422,4.57338629 Z"></path>\n  </g>\n</svg>',
              },
              treeNodeType: 'STATIC',
              name: '我关注的',
              id: 'node_3',
            },
            {
              text: '讨论',
              nodeType: 'node_4',
              treeNodeType: 'STATIC',
              hasDETreeNodeRSs: true,
              expanded: true,
              name: '讨论',
              id: 'node_4',
            },
            {
              text: '回复',
              nodeType: 'node_5',
              treeNodeType: 'STATIC',
              hasDETreeNodeRSs: true,
              expanded: true,
              name: '回复',
              id: 'node_5',
            },
            {
              text: '最新回复',
              navAppViewId: 'plmweb.discuss_reply_latest_grid_view',
              nodeType: 'node_6',
              sysImage: {
                rawContent:
                  '<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" class="design-iconfont" width="18" height="18">\n  <path d="M8,1 C4.134375,1 1,4.134375 1,8 C1,11.865625 4.134375,15 8,15 C11.865625,15 15,11.865625 15,8 C15,4.134375 11.865625,1 8,1 Z M8,13.8125 C4.790625,13.8125 2.1875,11.209375 2.1875,8 C2.1875,4.790625 4.790625,2.1875 8,2.1875 C11.209375,2.1875 13.8125,4.790625 13.8125,8 C13.8125,11.209375 11.209375,13.8125 8,13.8125 Z M10.7296875,9.978125 L8.5015625,8.3671875 L8.5015625,4.5 C8.5015625,4.43125 8.4453125,4.375 8.3765625,4.375 L7.625,4.375 C7.55625,4.375 7.5,4.43125 7.5,4.5 L7.5,8.803125 C7.5,8.84375 7.51875,8.88125 7.5515625,8.9046875 L10.1359375,10.7890625 C10.1921875,10.8296875 10.2703125,10.8171875 10.3109375,10.7625 L10.7578125,10.153125 C10.7984375,10.0953125 10.7859375,10.0171875 10.7296875,9.978125 L10.7296875,9.978125 Z" fill="#9A7EF4" fill-rule="nonzero"></path>\n</svg>',
              },
              treeNodeType: 'STATIC',
              name: '最新回复',
              id: 'node_6',
            },
            {
              text: '我的回复',
              navAppViewId: 'plmweb.discuss_reply_my_grid_view',
              nodeType: 'node_7',
              sysImage: {
                rawContent:
                  '<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16" class="design-iconfont" width="128" height="128">\n  <path d="M13.4140625,11.93125 C13.11875,11.23125 12.69375,10.603125 12.1546875,10.0640625 C11.615625,9.525 10.9875,9.1015625 10.2875,8.8046875 C10.28125,8.8015625 10.275,8.8 10.26875,8.796875 C11.2421875,8.09375 11.875,6.9484375 11.875,5.65625 C11.875,3.515625 10.140625,1.78125 8,1.78125 C5.859375,1.78125 4.125,3.515625 4.125,5.65625 C4.125,6.9484375 4.7578125,8.09375 5.73125,8.7984375 C5.725,8.8015625 5.71875,8.803125 5.7125,8.80625 C5.0125,9.1015625 4.384375,9.525 3.8453125,10.065625 C3.30625,10.6046875 2.8828125,11.2328125 2.5859375,11.9328125 C2.2953125,12.6171875 2.140625,13.34375 2.12496822,14.090625 C2.1234375,14.1609375 2.1796875,14.21875 2.25,14.21875 L3.1875,14.21875 C3.25625,14.21875 3.3109375,14.1640625 3.3125,14.096875 C3.34375,12.890625 3.828125,11.7609375 4.684375,10.9046875 C5.5703125,10.01875 6.746875,9.53125 8,9.53125 C9.253125,9.53125 10.4296875,10.01875 11.315625,10.9046875 C12.171875,11.7609375 12.65625,12.890625 12.6875,14.096875 C12.6890625,14.165625 12.74375,14.21875 12.8125,14.21875 L13.75,14.21875 C13.8203125,14.21875 13.8765625,14.1609375 13.8750318,14.090625 C13.859375,13.34375 13.7046875,12.6171875 13.4140625,11.93125 Z M8,8.34375 C7.2828125,8.34375 6.6078125,8.0640625 6.1,7.55625 C5.5921875,7.0484375 5.3125,6.3734375 5.3125,5.65625 C5.3125,4.9390625 5.5921875,4.2640625 6.1,3.75625 C6.6078125,3.2484375 7.2828125,2.96875 8,2.96875 C8.7171875,2.96875 9.3921875,3.2484375 9.9,3.75625 C10.4078125,4.2640625 10.6875,4.9390625 10.6875,5.65625 C10.6875,6.3734375 10.4078125,7.0484375 9.9,7.55625 C9.3921875,8.0640625 8.7171875,8.34375 8,8.34375 Z" fill="#F6C659" fill-rule="nonzero"></path>\n</svg>',
              },
              treeNodeType: 'STATIC',
              name: '我的回复',
              id: 'node_7',
            },
          ],
          outputIconDefault: true,
          navViewPos: 'NONE',
          createControlAction: {
            appDEMethodId: 'create',
            appDataEntityId: 'plmweb.discuss_post',
            id: 'create',
          },
          fetchControlAction: {
            appDataEntityId: 'plmweb.discuss_post',
            id: 'fetch',
          },
          getControlAction: {
            appDEMethodId: 'get',
            appDataEntityId: 'plmweb.discuss_post',
            id: 'load',
          },
          removeControlAction: {
            appDEMethodId: 'remove',
            appDataEntityId: 'plmweb.discuss_post',
            id: 'remove',
          },
          updateControlAction: {
            appDEMethodId: 'update',
            appDataEntityId: 'plmweb.discuss_post',
            id: 'update',
          },
          autoLoad: true,
          showBusyIndicator: true,
          codeName: 'tree_exp_view_tree_view',
          controlStyle: 'LIST_TREE',
          controlType: 'TREEVIEW',
          logicName: '讨论实体树导航视图_树视图',
          appDataEntityId: 'plmweb.discuss_post',
          controlLogics: [
            {
              eventNames: 'SELECTIONCHANGE',
              logicTag: 'treeexpbar_tree',
              logicType: 'CUSTOM',
              triggerType: 'CTRLEVENT',
              id: 'treeexpbar_selectionchange',
            },
            {
              eventNames: 'LOAD',
              logicTag: 'treeexpbar_tree',
              logicType: 'CUSTOM',
              triggerType: 'CTRLEVENT',
              id: 'treeexpbar_load',
            },
          ],
          controlParam: {
            id: 'treeexpbar_tree',
          },
          sysPFPluginId: 'list_tree',
          modelId: 'a11b4f7988e8abd99156dd534e48fa60',
          modelType: 'PSDETREEVIEW',
          name: 'treeexpbar_tree',
          id: 'plmweb.discuss_post.tree_exp_view_tree_view',
        },
      ],
      codeName: 'tree_exp_view_treeexpbar',
      controlType: 'TREEEXPBAR',
      appDataEntityId: 'plmweb.discuss_post',
      controlParam: {
        id: 'treeexpbar',
      },
      modelId: '4e950d0ddf85e5ea3e8bef07fd24bca4_treeexpbar',
      modelType: 'PSEXPBAR',
      name: 'treeexpbar',
      id: 'tree_exp_view_treeexpbar',
    },
    {
      groupMode: 'SINGLE',
      quickSearchMode: 1,
      enableQuickSearch: true,
      controlType: 'SEARCHBAR',
      appDataEntityId: 'plmweb.discuss_post',
      controlParam: {
        id: 'searchbar',
      },
      id: 'searchbar',
    },
    {
      capLanguageRes: {
        lanResTag: 'DE.LNAME.DISCUSS_POST',
      },
      caption: '讨论',
      codeName: 'tree_exp_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.discuss_post',
      controlParam: {},
      name: 'captionbar',
      id: 'tree_exp_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDETREEEXPVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.discuss_post',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '讨论实体树导航视图',
  viewStyle: 'DEFAULT',
  viewType: 'DETREEEXPVIEW',
  enableDP: true,
  showCaptionBar: true,
  modelId: '4e950d0ddf85e5ea3e8bef07fd24bca4',
  modelType: 'PSAPPDEVIEW',
  name: 'discuss_posttree_exp_view',
  id: 'plmweb.discuss_post_tree_exp_view',
};
