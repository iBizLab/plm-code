'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

var index$1 = require('./panel-items/index.cjs');
require('./style/index.css');

"use strict";
var index = {
  install(app) {
    app.use(index$1.default);
  }
};

exports.default = index;
