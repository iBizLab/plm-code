export default {
  codeListTag: 'extension__DELogicNodeType_MS',
  codeListType: 'STATIC',
  codeName: 'extension__DELogicNodeType_MS',
  emptyText: '无匹配节点',
  emptyTextLanguageRes: {
    lanResTag: 'CL.ITEM.LNAME.DELOGICNODETYPE_MS._EMTPY_',
  },
  appDataEntityId: 'plmweb.psdelogicnode',
  codeItems: [
    {
      codeName: 'base',
      codeItems: [
        {
          codeName: 'mainstate',
          data: '{"logicnodetype": "MAINSTATE","psdelogicnodename": "主状态"}',
          iconPath: './assets/img/entity_status.svg',
          sysImage: {
            imagePath: './assets/img/entity_status.svg',
            rawContent:
              '<?xml version="1.0" encoding="UTF-8"?>\n<svg width="14px" height="14px" viewBox="0 0 14 14" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink">\n    \n    <g id="资源控制中心" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">\n        <g id="403" transform="translate(-581.000000, -698.000000)">\n            <g id="主状态" transform="translate(581.000000, 698.000000)">\n                <rect id="矩形" x="0" y="0" width="14" height="14"></rect>\n                <polygon id="路径" fill="#52D456" fill-rule="nonzero" points="9.7242879 5.17708333 3.89095456 1.16666667 3.89095456 12.8333333 4.72058419 12.8333333 4.72058419 8.6171875"></polygon>\n            </g>\n        </g>\n    </g>\n</svg>',
          },
          text: '主状态',
          value: 'MAINSTATE',
          id: 'mainstate',
        },
      ],
      text: '基础',
      value: 'base',
      id: 'base',
    },
  ],
  enableCache: true,
  name: '云实体主状态逻辑处理节点类型(设计)',
  id: 'plmweb.extension__delogicnodetype_ms',
};
