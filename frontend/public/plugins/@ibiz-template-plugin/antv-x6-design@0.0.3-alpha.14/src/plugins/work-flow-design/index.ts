import { IDataEntity } from '@ibiz-template/runtime';
import { installCustomNode } from './custom-node';
import { installCustomEdge } from './custom-edge';
import { x6ProviderRegister } from '../../utils';
import { LinkProviderImpl } from './link';
import { LinkDataProviderImpl } from './link-data';
import { NodeProviderImpl } from './node';
import { NodeDataProviderImpl } from './node-data';
import './index.scss';

export default {
  install() {
    installCustomNode();
    installCustomEdge();
    x6ProviderRegister.registerNode(
      'EDITFORM_RENDER_X6WFDesignNode',
      (node, link) => new NodeProviderImpl(node, link),
    );
    x6ProviderRegister.registerNodeData<IDataEntity>(
      'EDITFORM_RENDER_X6WFDesignNode_DataProvider',
      data => new NodeDataProviderImpl(data),
    );
    x6ProviderRegister.registerLink(
      'EDITFORM_RENDER_X6WFDesignLink',
      (node, link) => new LinkProviderImpl(node, link),
    );
    x6ProviderRegister.registerLinkData<IDataEntity>(
      'EDITFORM_RENDER_X6WFDesignLink_DataProvider',
      data => new LinkDataProviderImpl(data),
    );
  },
};
