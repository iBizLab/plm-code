export default {
  codeListTag: 'extension__enable_field_change',
  codeListType: 'STATIC',
  codeName: 'extension__enable_field_change',
  emptyText: '未定义',
  appDataEntityId: 'plmweb.psdelogic',
  codeItems: [
    {
      codeName: 'projmgmt_work_item_state',
      data: '{"is_dropdown_list": true ,"codelist_tag":"projmgmt__work_item_state2","allow_empty":"false"}',
      text: '变更工作项状态',
      value: 'ProjMgmt.work_item.state',
      id: 'projmgmt_work_item_state',
    },
    {
      codeName: 'item_3',
      data: '{"is_dropdown_list": false,"allow_empty":"true"}',
      codeItems: [
        {
          codeName: 'projmgmt_work_item_descript',
          text: '描述',
          value: 'ProjMgmt.work_item.descript',
          id: 'projmgmt_work_item_descript',
        },
      ],
      text: '变更工作项属性',
      value: 'ProjMgmt.work_item.*',
      id: 'item_3',
    },
  ],
  enableCache: true,
  name: '可供选择的属性变更',
  id: 'plmweb.extension__enable_field_change',
};
