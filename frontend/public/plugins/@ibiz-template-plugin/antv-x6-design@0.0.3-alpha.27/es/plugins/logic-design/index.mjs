import { installCustomNode } from './custom-node/index.mjs';
import { installCustomEdge } from './custom-edge/index.mjs';
import '../../utils/index.mjs';
import { LinkProviderImpl } from './link.mjs';
import { LinkDataProviderImpl } from './link-data.mjs';
import { NodeProviderImpl } from './node.mjs';
import { NodeDataProviderImpl } from './node-data.mjs';
import './index.css';
import { x6ProviderRegister } from '../../utils/x6-provider-register/x6-provider-register.mjs';

"use strict";
var LogicDesignPlugin = {
  install() {
    installCustomNode();
    installCustomEdge();
    x6ProviderRegister.registerNode(
      "EDITFORM_RENDER_X6DesignNode",
      (node, link) => new NodeProviderImpl(node, link)
    );
    x6ProviderRegister.registerNodeData(
      "EDITFORM_RENDER_X6DesignNode_DataProvider",
      (data) => new NodeDataProviderImpl(data)
    );
    x6ProviderRegister.registerLink(
      "EDITFORM_RENDER_X6DesignLink",
      (node, link) => new LinkProviderImpl(node, link)
    );
    x6ProviderRegister.registerLinkData(
      "EDITFORM_RENDER_X6DesignLink_DataProvider",
      (data) => new LinkDataProviderImpl(data)
    );
  }
};

export { LogicDesignPlugin as default };
