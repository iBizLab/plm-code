export default {
  codeListTag: 'TestMgmt__review_type',
  codeListType: 'STATIC',
  codeName: 'TestMgmt__review_type',
  emptyText: '未定义',
  appDEDataSetId: 'fetch_under_library',
  appDataEntityId: 'plmweb.guideline',
  codeItems: [
    {
      codeName: 'test_case',
      text: '用例评审',
      value: 'TEST_CASE',
      id: 'test_case',
    },
    {
      codeName: 'baseline',
      text: '基线评审',
      value: 'BASELINE',
      id: 'baseline',
    },
  ],
  textAppDEFieldId: 'name',
  valueAppDEFieldId: 'id',
  enableCache: true,
  name: '评审类型',
  id: 'plmweb.testmgmt__review_type',
};
