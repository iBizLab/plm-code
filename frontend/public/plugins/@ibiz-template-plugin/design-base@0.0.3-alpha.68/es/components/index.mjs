import IBizDesignTree from './design-tree/design-tree.mjs';

"use strict";
var Components = {
  install(app) {
    app.component("IBizDesignTree", IBizDesignTree);
  }
};

export { Components as default };
