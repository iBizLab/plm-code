export default {
  enableDirtyChecking: true,
  showDataInfoBar: true,
  xdataControlName: 'form',
  loadDefault: true,
  openMode: 'POPUPMODAL',
  deviewCodeName: 'quick_create_view',
  deviewId: '5be4338ef7db7a711f0962aa0cb81d49',
  accUserMode: 2,
  caption: '项目快速建立',
  codeName: 'project_quick_create_view',
  appDataEntityId: 'plmweb.project',
  appViewEngines: [
    {
      engineCat: 'VIEW',
      engineType: 'OptionView',
      id: 'engine',
    },
  ],
  controls: [
    {
      createControlAction: {
        appDEMethodId: 'create',
        appDataEntityId: 'plmweb.project',
        id: 'create',
      },
      getDraftFromControlAction: {
        appDataEntityId: 'plmweb.project',
        id: 'loaddraftfrom',
      },
      getDraftControlAction: {
        appDEMethodId: 'get_draft',
        appDataEntityId: 'plmweb.project',
        id: 'loaddraft',
      },
      getControlAction: {
        appDEMethodId: 'get',
        appDataEntityId: 'plmweb.project',
        id: 'load',
      },
      removeControlAction: {
        appDEMethodId: 'remove',
        appDataEntityId: 'plmweb.project',
        id: 'remove',
      },
      updateControlAction: {
        appDEMethodId: 'update',
        appDataEntityId: 'plmweb.project',
        id: 'update',
      },
      deformPages: [
        {
          layout: {
            columnCount: 24,
            layout: 'TABLE_24COL',
          },
          deformDetails: [
            {
              layout: {
                columnCount: 24,
                layout: 'TABLE_24COL',
              },
              deformDetails: [
                {
                  layout: {
                    columnCount: 24,
                    layout: 'TABLE_24COL',
                  },
                  deformDetails: [
                    {
                      rawItem: {
                        sysImage: {
                          rawContent:
                            '<?xml version="1.0" encoding="UTF-8"?>\n<svg width="275px" height="205px" viewBox="0 0 275 205" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">\n    <title>动态实体编辑视图（左右关系）</title>\n    <g id="动态实体编辑视图（左右关系）" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\n        <g id="新建视图部件/表格" transform="translate(-11, 0)">\n            <rect id="矩形" fill="#FAFAFA" x="0" y="0" width="286" height="206"></rect>\n            <g id="编组-2" transform="translate(18, 32)">\n                <rect id="矩形" fill="#FFFFFF" x="0" y="0" width="261" height="164"></rect>\n                <g id="新建视图/表单窄" transform="translate(84, 3.835)">\n                    <rect id="矩形" fill="#FFFFFF" x="0" y="0" width="176" height="152"></rect>\n                    <g id="新建视图部件/表单" transform="translate(12, 24.1351)" fill="#F3F3F3">\n                        <g id="编组-5">\n                            <path d="M1,0 L65.8221217,0 C66.3744065,-1.01453063e-16 66.8221217,0.44771525 66.8221217,1 L66.8221217,7.91891892 C66.8221217,8.47120367 66.3744065,8.91891892 65.8221217,8.91891892 L1,8.91891892 C0.44771525,8.91891892 6.76353751e-17,8.47120367 0,7.91891892 L0,1 C-6.76353751e-17,0.44771525 0.44771525,1.01453063e-16 1,0 Z" id="矩形备份-10"></path>\n                        </g>\n                        <g id="编组-5备份" transform="translate(0, 19.6216)">\n                            <path d="M1,0 L65.8221217,0 C66.3744065,-1.01453063e-16 66.8221217,0.44771525 66.8221217,1 L66.8221217,7.91891892 C66.8221217,8.47120367 66.3744065,8.91891892 65.8221217,8.91891892 L1,8.91891892 C0.44771525,8.91891892 6.76353751e-17,8.47120367 0,7.91891892 L-2.22044605e-16,1 C-2.8967998e-16,0.44771525 0.44771525,1.01453063e-16 1,0 Z" id="矩形备份-10"></path>\n                        </g>\n                        <g id="编组-5备份-2" transform="translate(0, 39.2432)">\n                            <path d="M1,0 L65.8221217,0 C66.3744065,-1.01453063e-16 66.8221217,0.44771525 66.8221217,1 L66.8221217,7.91891892 C66.8221217,8.47120367 66.3744065,8.91891892 65.8221217,8.91891892 L1,8.91891892 C0.44771525,8.91891892 6.76353751e-17,8.47120367 0,7.91891892 L-1.11022302e-16,1 C-1.78657678e-16,0.44771525 0.44771525,1.01453063e-16 1,0 Z" id="矩形备份-10"></path>\n                        </g>\n                    </g>\n                    <g id="编组-5" transform="translate(12, 19)">\n                        <rect id="矩形备份-10" fill="#F3F3F3" x="0" y="63.1351351" width="148" height="48" rx="1"></rect>\n                        <polygon id="路径" fill="#F1FBF4" fill-rule="nonzero" points="89 0 147 0 147 58 89 58"></polygon>\n                        <polygon id="路径" fill="#73D897" fill-rule="nonzero" points="94 52 142 52 129.960866 33.7037148 122.134005 39.3053856 111.233323 24 94 52"></polygon>\n                        <path d="M127.998122,22 C129.78445,22.0007378 131.435443,20.9531258 132.329188,19.2517891 C133.222933,17.5504524 133.223649,15.4538644 132.331066,13.7517895 C131.438483,12.0497146 129.788206,11.0007385 128.001878,11 C125.240455,10.9988593 123.001038,13.460368 123,16.4979339 C122.998963,19.5354998 125.236698,21.9988585 127.998122,22 L127.998122,22 Z" id="路径" fill="#73D897" fill-rule="nonzero"></path>\n                    </g>\n                </g>\n                <g id="新建视图部件/树形控件" transform="translate(13, 3.835)">\n                    <rect id="矩形备份-4" stroke="#F3F3F3" fill="#FFFFFF" x="65.5" y="0.5" width="1" height="151"></rect>\n                    <g id="编组-4" transform="translate(0, 13)">\n                        <rect id="矩形备份-11" fill="#56ABFB" x="3" y="1" width="2" height="120" rx="1"></rect>\n                        <g id="编组-3" transform="translate(3, 16)">\n                            <rect id="矩形备份-16" fill="#56ABFB" x="0" y="2" width="28" height="2" rx="1"></rect>\n                            <rect id="矩形备份-8" fill="#F3F3F3" x="8" y="0" width="45" height="6" rx="3"></rect>\n                        </g>\n                        <g id="编组-3备份-3" transform="translate(3, 80)">\n                            <rect id="矩形备份-16" fill="#56ABFB" x="0" y="2" width="28" height="2" rx="1"></rect>\n                            <rect id="矩形备份-8" fill="#F3F3F3" x="8" y="0" width="45" height="6" rx="3"></rect>\n                        </g>\n                        <g id="编组-3备份" transform="translate(3, 32)">\n                            <rect id="矩形备份-16" fill="#56ABFB" x="0" y="2" width="28" height="2" rx="1"></rect>\n                            <rect id="矩形备份-8" fill="#F3F3F3" x="8" y="0" width="45" height="6" rx="3"></rect>\n                        </g>\n                        <g id="编组-3备份-4" transform="translate(3, 96)">\n                            <rect id="矩形备份-16" fill="#56ABFB" x="0" y="2" width="28" height="2" rx="1"></rect>\n                            <rect id="矩形备份-8" fill="#F3F3F3" x="8" y="0" width="45" height="6" rx="3"></rect>\n                        </g>\n                        <g id="编组-3备份-2" transform="translate(3, 48)">\n                            <rect id="矩形备份-16" fill="#56ABFB" x="0" y="2" width="28" height="2" rx="1"></rect>\n                            <rect id="矩形备份-8" fill="#F3F3F3" x="8" y="0" width="45" height="6" rx="3"></rect>\n                        </g>\n                        <g id="编组-3备份-5" transform="translate(3, 112)">\n                            <rect id="矩形备份-16" fill="#56ABFB" x="0" y="2" width="28" height="2" rx="1"></rect>\n                            <rect id="矩形备份-8" fill="#F3F3F3" x="8" y="0" width="45" height="6" rx="3"></rect>\n                        </g>\n                        <g id="编组" fill="#F3F3F3">\n                            <rect id="矩形备份-6" x="0" y="0" width="46" height="6" rx="3"></rect>\n                        </g>\n                        <g id="编组备份" transform="translate(0, 64)" fill="#F3F3F3">\n                            <rect id="矩形备份-6" x="0" y="0" width="46" height="6" rx="3"></rect>\n                        </g>\n                    </g>\n                </g>\n            </g>\n            <g id="新建视图部件/按钮" transform="translate(217, 12.065)">\n                <rect id="矩形备份-2" fill="#EDF1FC" x="0" y="0" width="26.8487421" height="11.055" rx="1"></rect>\n                <rect id="矩形备份-3" fill="#F3F3F3" x="35.1512579" y="0" width="26.8487421" height="11.055" rx="1"></rect>\n            </g>\n            <rect id="矩形" fill="#F3F3F3" x="21" y="13.07" width="41" height="8.04" rx="4"></rect>\n        </g>\n    </g>\n</svg>',
                        },
                        contentType: 'IMAGE',
                        id: 'rawitem_image',
                      },
                      codeName: 'rawitem_image',
                      detailStyle: 'DEFAULT',
                      detailType: 'RAWITEM',
                      layoutPos: {
                        colLG: 14,
                        colLGOffset: 5,
                        colMD: 14,
                        colMDOffset: 5,
                        colSM: 14,
                        colSMOffset: 5,
                        colXS: 14,
                        colXSOffset: 5,
                        layout: 'TABLE_24COL',
                      },
                      sysImage: {
                        rawContent:
                          '<?xml version="1.0" encoding="UTF-8"?>\n<svg width="275px" height="205px" viewBox="0 0 275 205" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">\n    <title>动态实体编辑视图（左右关系）</title>\n    <g id="动态实体编辑视图（左右关系）" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\n        <g id="新建视图部件/表格" transform="translate(-11, 0)">\n            <rect id="矩形" fill="#FAFAFA" x="0" y="0" width="286" height="206"></rect>\n            <g id="编组-2" transform="translate(18, 32)">\n                <rect id="矩形" fill="#FFFFFF" x="0" y="0" width="261" height="164"></rect>\n                <g id="新建视图/表单窄" transform="translate(84, 3.835)">\n                    <rect id="矩形" fill="#FFFFFF" x="0" y="0" width="176" height="152"></rect>\n                    <g id="新建视图部件/表单" transform="translate(12, 24.1351)" fill="#F3F3F3">\n                        <g id="编组-5">\n                            <path d="M1,0 L65.8221217,0 C66.3744065,-1.01453063e-16 66.8221217,0.44771525 66.8221217,1 L66.8221217,7.91891892 C66.8221217,8.47120367 66.3744065,8.91891892 65.8221217,8.91891892 L1,8.91891892 C0.44771525,8.91891892 6.76353751e-17,8.47120367 0,7.91891892 L0,1 C-6.76353751e-17,0.44771525 0.44771525,1.01453063e-16 1,0 Z" id="矩形备份-10"></path>\n                        </g>\n                        <g id="编组-5备份" transform="translate(0, 19.6216)">\n                            <path d="M1,0 L65.8221217,0 C66.3744065,-1.01453063e-16 66.8221217,0.44771525 66.8221217,1 L66.8221217,7.91891892 C66.8221217,8.47120367 66.3744065,8.91891892 65.8221217,8.91891892 L1,8.91891892 C0.44771525,8.91891892 6.76353751e-17,8.47120367 0,7.91891892 L-2.22044605e-16,1 C-2.8967998e-16,0.44771525 0.44771525,1.01453063e-16 1,0 Z" id="矩形备份-10"></path>\n                        </g>\n                        <g id="编组-5备份-2" transform="translate(0, 39.2432)">\n                            <path d="M1,0 L65.8221217,0 C66.3744065,-1.01453063e-16 66.8221217,0.44771525 66.8221217,1 L66.8221217,7.91891892 C66.8221217,8.47120367 66.3744065,8.91891892 65.8221217,8.91891892 L1,8.91891892 C0.44771525,8.91891892 6.76353751e-17,8.47120367 0,7.91891892 L-1.11022302e-16,1 C-1.78657678e-16,0.44771525 0.44771525,1.01453063e-16 1,0 Z" id="矩形备份-10"></path>\n                        </g>\n                    </g>\n                    <g id="编组-5" transform="translate(12, 19)">\n                        <rect id="矩形备份-10" fill="#F3F3F3" x="0" y="63.1351351" width="148" height="48" rx="1"></rect>\n                        <polygon id="路径" fill="#F1FBF4" fill-rule="nonzero" points="89 0 147 0 147 58 89 58"></polygon>\n                        <polygon id="路径" fill="#73D897" fill-rule="nonzero" points="94 52 142 52 129.960866 33.7037148 122.134005 39.3053856 111.233323 24 94 52"></polygon>\n                        <path d="M127.998122,22 C129.78445,22.0007378 131.435443,20.9531258 132.329188,19.2517891 C133.222933,17.5504524 133.223649,15.4538644 132.331066,13.7517895 C131.438483,12.0497146 129.788206,11.0007385 128.001878,11 C125.240455,10.9988593 123.001038,13.460368 123,16.4979339 C122.998963,19.5354998 125.236698,21.9988585 127.998122,22 L127.998122,22 Z" id="路径" fill="#73D897" fill-rule="nonzero"></path>\n                    </g>\n                </g>\n                <g id="新建视图部件/树形控件" transform="translate(13, 3.835)">\n                    <rect id="矩形备份-4" stroke="#F3F3F3" fill="#FFFFFF" x="65.5" y="0.5" width="1" height="151"></rect>\n                    <g id="编组-4" transform="translate(0, 13)">\n                        <rect id="矩形备份-11" fill="#56ABFB" x="3" y="1" width="2" height="120" rx="1"></rect>\n                        <g id="编组-3" transform="translate(3, 16)">\n                            <rect id="矩形备份-16" fill="#56ABFB" x="0" y="2" width="28" height="2" rx="1"></rect>\n                            <rect id="矩形备份-8" fill="#F3F3F3" x="8" y="0" width="45" height="6" rx="3"></rect>\n                        </g>\n                        <g id="编组-3备份-3" transform="translate(3, 80)">\n                            <rect id="矩形备份-16" fill="#56ABFB" x="0" y="2" width="28" height="2" rx="1"></rect>\n                            <rect id="矩形备份-8" fill="#F3F3F3" x="8" y="0" width="45" height="6" rx="3"></rect>\n                        </g>\n                        <g id="编组-3备份" transform="translate(3, 32)">\n                            <rect id="矩形备份-16" fill="#56ABFB" x="0" y="2" width="28" height="2" rx="1"></rect>\n                            <rect id="矩形备份-8" fill="#F3F3F3" x="8" y="0" width="45" height="6" rx="3"></rect>\n                        </g>\n                        <g id="编组-3备份-4" transform="translate(3, 96)">\n                            <rect id="矩形备份-16" fill="#56ABFB" x="0" y="2" width="28" height="2" rx="1"></rect>\n                            <rect id="矩形备份-8" fill="#F3F3F3" x="8" y="0" width="45" height="6" rx="3"></rect>\n                        </g>\n                        <g id="编组-3备份-2" transform="translate(3, 48)">\n                            <rect id="矩形备份-16" fill="#56ABFB" x="0" y="2" width="28" height="2" rx="1"></rect>\n                            <rect id="矩形备份-8" fill="#F3F3F3" x="8" y="0" width="45" height="6" rx="3"></rect>\n                        </g>\n                        <g id="编组-3备份-5" transform="translate(3, 112)">\n                            <rect id="矩形备份-16" fill="#56ABFB" x="0" y="2" width="28" height="2" rx="1"></rect>\n                            <rect id="矩形备份-8" fill="#F3F3F3" x="8" y="0" width="45" height="6" rx="3"></rect>\n                        </g>\n                        <g id="编组" fill="#F3F3F3">\n                            <rect id="矩形备份-6" x="0" y="0" width="46" height="6" rx="3"></rect>\n                        </g>\n                        <g id="编组备份" transform="translate(0, 64)" fill="#F3F3F3">\n                            <rect id="矩形备份-6" x="0" y="0" width="46" height="6" rx="3"></rect>\n                        </g>\n                    </g>\n                </g>\n            </g>\n            <g id="新建视图部件/按钮" transform="translate(217, 12.065)">\n                <rect id="矩形备份-2" fill="#EDF1FC" x="0" y="0" width="26.8487421" height="11.055" rx="1"></rect>\n                <rect id="矩形备份-3" fill="#F3F3F3" x="35.1512579" y="0" width="26.8487421" height="11.055" rx="1"></rect>\n            </g>\n            <rect id="矩形" fill="#F3F3F3" x="21" y="13.07" width="41" height="8.04" rx="4"></rect>\n        </g>\n    </g>\n</svg>',
                      },
                      showCaption: true,
                      id: 'rawitem_image',
                    },
                    {
                      rawItem: {
                        content:
                          '<p></p>\n<h1>Scrum 项目</h1>\n<p>Scrum 是一种敏捷开发方法，强调团队合作、迭代开发和及时反馈。</p>\n<ul>\n<li>迭代开发</li>\n<li>团队合作</li>\n<li>灵活性和可适应性</li>\n</ul>',
                        contentType: 'HTML',
                        id: 'rawitem1',
                      },
                      codeName: 'rawitem1',
                      detailStyle: 'DEFAULT',
                      detailType: 'RAWITEM',
                      defdgroupLogics: [
                        {
                          logicCat: 'PANELVISIBLE',
                          relatedDetailNames: ['type'],
                          groupOP: 'AND',
                          defdlogics: [
                            {
                              condOP: 'EQ',
                              defdname: 'type',
                              value: 'scrum',
                              logicType: 'SINGLE',
                            },
                          ],
                          logicType: 'GROUP',
                        },
                      ],
                      layoutPos: {
                        colMD: 24,
                        layout: 'TABLE_24COL',
                      },
                      showCaption: true,
                      id: 'rawitem1',
                    },
                    {
                      rawItem: {
                        content:
                          '<p>&nbsp;</p>\n<h1>Kanban 项目</h1>\n<p>Kanban 是一种项目管理方法，注重于可视化工作流程和限制在工作中的工作量。</p>\n<ul>\n<li>可视化工作流程</li>\n<li>任务卡片</li>\n<li>实时监控</li>\n</ul>',
                        contentType: 'HTML',
                        id: 'rawitem2',
                      },
                      codeName: 'rawitem2',
                      detailStyle: 'DEFAULT',
                      detailType: 'RAWITEM',
                      defdgroupLogics: [
                        {
                          logicCat: 'PANELVISIBLE',
                          relatedDetailNames: ['type'],
                          groupOP: 'AND',
                          defdlogics: [
                            {
                              condOP: 'EQ',
                              defdname: 'type',
                              value: 'kanban',
                              logicType: 'SINGLE',
                            },
                          ],
                          logicType: 'GROUP',
                        },
                      ],
                      layoutPos: {
                        colMD: 24,
                        layout: 'TABLE_24COL',
                      },
                      showCaption: true,
                      id: 'rawitem2',
                    },
                    {
                      rawItem: {
                        content:
                          '<p>&nbsp;</p>\n<h1>瀑布 项目</h1>\n<p>瀑布模型是一种传统的项目管理方法，将项目划分为一系列线性的阶段，每个阶段依赖于上一个阶段的完成。</p>\n<ul>\n<li>线性阶段</li>\n<li>详细规划</li>\n<li>阶段依赖</li>\n</ul>',
                        contentType: 'HTML',
                        id: 'rawitem3',
                      },
                      codeName: 'rawitem3',
                      detailStyle: 'DEFAULT',
                      detailType: 'RAWITEM',
                      defdgroupLogics: [
                        {
                          logicCat: 'PANELVISIBLE',
                          relatedDetailNames: ['type'],
                          groupOP: 'AND',
                          defdlogics: [
                            {
                              condOP: 'EQ',
                              defdname: 'type',
                              value: 'waterfall',
                              logicType: 'SINGLE',
                            },
                          ],
                          logicType: 'GROUP',
                        },
                      ],
                      layoutPos: {
                        colMD: 24,
                        layout: 'TABLE_24COL',
                      },
                      showCaption: true,
                      id: 'rawitem3',
                    },
                  ],
                  codeName: 'grouppanel1',
                  detailStyle: 'DEFAULT',
                  detailType: 'GROUPPANEL',
                  layoutPos: {
                    colLG: 12,
                    colMD: 12,
                    layout: 'TABLE_24COL',
                  },
                  id: 'grouppanel1',
                },
                {
                  layout: {
                    columnCount: 24,
                    layout: 'TABLE_24COL',
                  },
                  deformDetails: [
                    {
                      createDV: 'srforgname',
                      createDVT: 'SESSION',
                      dataType: 25,
                      labelPos: 'TOP',
                      labelWidth: 130,
                      noPrivDisplayMode: 1,
                      editor: {
                        editorType: 'TEXTBOX',
                        valueType: 'SIMPLE',
                        editable: true,
                        id: 'belong',
                      },
                      caption: '所属',
                      codeName: 'belong',
                      detailStyle: 'DEFAULT',
                      detailType: 'FORMITEM',
                      layoutPos: {
                        colMD: 24,
                        layout: 'TABLE_24COL',
                      },
                      showCaption: true,
                      id: 'belong',
                    },
                    {
                      dataType: 25,
                      enableCond: 3,
                      labelPos: 'TOP',
                      labelWidth: 130,
                      noPrivDisplayMode: 1,
                      appDEFieldId: 'name',
                      editor: {
                        maxLength: 200,
                        editorType: 'TEXTBOX',
                        valueType: 'SIMPLE',
                        editable: true,
                        id: 'name',
                      },
                      capLanguageRes: {
                        lanResTag: 'DEF.LNAME.NAME',
                      },
                      caption: '项目名称',
                      codeName: 'name',
                      detailStyle: 'DEFAULT',
                      detailType: 'FORMITEM',
                      layoutPos: {
                        colMD: 24,
                        layout: 'TABLE_24COL',
                      },
                      showCaption: true,
                      id: 'name',
                    },
                    {
                      createDV: 'scrum',
                      dataType: 25,
                      enableCond: 3,
                      labelPos: 'TOP',
                      labelWidth: 130,
                      noPrivDisplayMode: 1,
                      appDEFieldId: 'type',
                      editor: {
                        appCodeListId: 'plmweb.projmgmt__project_type',
                        editorType: 'RADIOBUTTONLIST',
                        valueType: 'SIMPLE',
                        editable: true,
                        id: 'type',
                      },
                      updateDV: 'scrum',
                      needCodeListConfig: true,
                      capLanguageRes: {
                        lanResTag: 'DEF.LNAME.TYPE',
                      },
                      caption: '项目类型',
                      codeName: 'type',
                      detailStyle: 'DEFAULT',
                      detailType: 'FORMITEM',
                      layoutPos: {
                        colMD: 24,
                        layout: 'TABLE_24COL',
                      },
                      showCaption: true,
                      id: 'type',
                    },
                    {
                      dataType: 25,
                      enableCond: 3,
                      labelPos: 'TOP',
                      labelWidth: 130,
                      noPrivDisplayMode: 1,
                      appDEFieldId: 'identifier',
                      editor: {
                        maxLength: 15,
                        sysValueRule: {
                          codeName: 'UsrValueRule0312488358',
                          regExCode: '^[A-Z0-9]{1,15}$',
                          ruleInfo: '请填写大写字母和数字',
                          ruleType: 'REGEX',
                          uniqueTag: 'UsrValueRule0312488358',
                          name: '大写字母和数字',
                          id: 'plmweb.usrvaluerule0312488358',
                        },
                        editorType: 'TEXTBOX',
                        placeHolder: '大写字母和数字，15个字符范围内',
                        valueType: 'SIMPLE',
                        editable: true,
                        id: 'identifier',
                      },
                      capLanguageRes: {
                        lanResTag: 'DEF.LNAME.IDENTIFIER',
                      },
                      caption: '项目标识',
                      codeName: 'identifier',
                      detailStyle: 'DEFAULT',
                      detailType: 'FORMITEM',
                      layoutPos: {
                        colMD: 24,
                        layout: 'TABLE_24COL',
                      },
                      showCaption: true,
                      id: 'identifier',
                    },
                    {
                      dataType: 25,
                      enableCond: 3,
                      itemHeight: 220,
                      labelPos: 'TOP',
                      labelWidth: 130,
                      noPrivDisplayMode: 1,
                      appDEFieldId: 'description',
                      editor: {
                        maxLength: 2000,
                        showMaxLength: true,
                        editorHeight: 200,
                        editorParams: {
                          HEIGHT: '200',
                        },
                        editorType: 'TEXTAREA_10',
                        valueType: 'SIMPLE',
                        editable: true,
                        id: 'description',
                      },
                      allowEmpty: true,
                      capLanguageRes: {
                        lanResTag: 'DEF.LNAME.DESCRIPTION',
                      },
                      caption: '描述',
                      codeName: 'description',
                      detailStyle: 'DEFAULT',
                      detailType: 'FORMITEM',
                      layoutPos: {
                        colMD: 24,
                        layout: 'TABLE_24COL',
                      },
                      showCaption: true,
                      id: 'description',
                    },
                  ],
                  codeName: 'grouppanel2',
                  detailStyle: 'DEFAULT',
                  detailType: 'GROUPPANEL',
                  layoutPos: {
                    colLG: 12,
                    colMD: 12,
                    layout: 'TABLE_24COL',
                  },
                  id: 'grouppanel2',
                },
              ],
              capLanguageRes: {
                lanResTag:
                  'CONTROL.DEFORM.PROJECT.WIZARD_CREATE.GROUPPANEL.GROUP1',
              },
              caption: '项目基本信息',
              codeName: 'group1',
              detailStyle: 'DEFAULT',
              detailType: 'GROUPPANEL',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              id: 'group1',
            },
            {
              dataType: 25,
              enableCond: 3,
              labelPos: 'LEFT',
              labelWidth: 130,
              noPrivDisplayMode: 1,
              appDEFieldId: 'id',
              editor: {
                editorType: 'HIDDEN',
                valueType: 'SIMPLE',
                editable: true,
                id: 'id',
              },
              allowEmpty: true,
              hidden: true,
              capLanguageRes: {
                lanResTag: 'DEF.LNAME.ID',
              },
              caption: '标识',
              codeName: 'id',
              detailStyle: 'DEFAULT',
              detailType: 'FORMITEM',
              layoutPos: {
                colMD: 24,
                layout: 'TABLE_24COL',
              },
              id: 'id',
            },
          ],
          capLanguageRes: {
            lanResTag:
              'CONTROL.DEFORM.PROJECT.WIZARD_CREATE.FORMPAGE.FORMPAGE1',
          },
          caption: '基本信息',
          codeName: 'formpage1',
          detailStyle: 'DEFAULT',
          detailType: 'FORMPAGE',
          id: 'formpage1',
        },
      ],
      layout: {
        columnCount: 24,
        layout: 'TABLE_24COL',
      },
      tabHeaderPos: 'TOP',
      noTabHeader: true,
      autoLoad: true,
      showBusyIndicator: true,
      codeName: 'create',
      controlType: 'FORM',
      logicName: '常规新建表单',
      appDataEntityId: 'plmweb.project',
      controlParam: {
        id: 'form',
      },
      modelId: '9d444e4403161b442d9bd04302beb923',
      modelType: 'PSDEFORM_EDITFORM',
      name: 'form',
      id: 'plmweb.project.create',
    },
    {
      codeName: 'quick_create_view_datainfobar',
      controlType: 'DATAINFOBAR',
      appDataEntityId: 'plmweb.project',
      controlParam: {
        id: 'datainfobar',
      },
      name: 'datainfobar',
      id: 'quick_create_view_datainfobar',
    },
    {
      caption: '项目快速建立',
      codeName: 'quick_create_view_captionbar',
      controlType: 'CAPTIONBAR',
      appDataEntityId: 'plmweb.project',
      controlParam: {},
      name: 'captionbar',
      id: 'quick_create_view_captionbar',
    },
  ],
  viewLayoutPanel: {
    layoutBodyOnly: true,
    useDefaultLayout: true,
    layoutPanel: true,
    codeName: 'layoutpanel',
    controlStyle: 'APPDEOPTVIEW',
    controlType: 'VIEWLAYOUTPANEL',
    appDataEntityId: 'plmweb.project',
    controlParam: {},
    id: 'layoutpanel',
  },
  title: '项目快速建立',
  viewStyle: 'DEFAULT',
  viewType: 'DEOPTVIEW',
  width: 1024,
  enableDP: true,
  showCaptionBar: true,
  modelId: '120df740905acebd29b67bfbf87e1617',
  modelType: 'PSAPPDEVIEW',
  name: 'projectquick_create_view',
  id: 'plmweb.project_quick_create_view',
};
