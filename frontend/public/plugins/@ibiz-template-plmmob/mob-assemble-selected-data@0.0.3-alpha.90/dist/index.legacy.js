!function(){function t(){"use strict";/*! regenerator-runtime -- Copyright (c) 2014-present, Facebook, Inc. -- license (MIT): https://github.com/facebook/regenerator/blob/main/LICENSE */t=function(){return n};var r,n={},o=Object.prototype,i=o.hasOwnProperty,a=Object.defineProperty||function(t,e,r){t[e]=r.value},c="function"==typeof Symbol?Symbol:{},u=c.iterator||"@@iterator",f=c.asyncIterator||"@@asyncIterator",s=c.toStringTag||"@@toStringTag";function l(t,e,r){return Object.defineProperty(t,e,{value:r,enumerable:!0,configurable:!0,writable:!0}),t[e]}try{l({},"")}catch(r){l=function(t,e,r){return t[e]=r}}function h(t,e,r,n){var o=e&&e.prototype instanceof g?e:g,i=Object.create(o.prototype),c=new D(n||[]);return a(i,"_invoke",{value:k(t,r,c)}),i}function p(t,e,r){try{return{type:"normal",arg:t.call(e,r)}}catch(t){return{type:"throw",arg:t}}}n.wrap=h;var y="suspendedStart",v="suspendedYield",d="executing",b="completed",m={};function g(){}function w(){}function O(){}var x={};l(x,u,(function(){return this}));var E=Object.getPrototypeOf,P=E&&E(E(I([])));P&&P!==o&&i.call(P,u)&&(x=P);var j=O.prototype=g.prototype=Object.create(x);function L(t){["next","throw","return"].forEach((function(e){l(t,e,(function(t){return this._invoke(e,t)}))}))}function _(t,r){function n(o,a,c,u){var f=p(t[o],t,a);if("throw"!==f.type){var s=f.arg,l=s.value;return l&&"object"==e(l)&&i.call(l,"__await")?r.resolve(l.__await).then((function(t){n("next",t,c,u)}),(function(t){n("throw",t,c,u)})):r.resolve(l).then((function(t){s.value=t,c(s)}),(function(t){return n("throw",t,c,u)}))}u(f.arg)}var o;a(this,"_invoke",{value:function(t,e){function i(){return new r((function(r,o){n(t,e,r,o)}))}return o=o?o.then(i,i):i()}})}function k(t,e,n){var o=y;return function(i,a){if(o===d)throw Error("Generator is already running");if(o===b){if("throw"===i)throw a;return{value:r,done:!0}}for(n.method=i,n.arg=a;;){var c=n.delegate;if(c){var u=T(c,n);if(u){if(u===m)continue;return u}}if("next"===n.method)n.sent=n._sent=n.arg;else if("throw"===n.method){if(o===y)throw o=b,n.arg;n.dispatchException(n.arg)}else"return"===n.method&&n.abrupt("return",n.arg);o=d;var f=p(t,e,n);if("normal"===f.type){if(o=n.done?b:v,f.arg===m)continue;return{value:f.arg,done:n.done}}"throw"===f.type&&(o=b,n.method="throw",n.arg=f.arg)}}}function T(t,e){var n=e.method,o=t.iterator[n];if(o===r)return e.delegate=null,"throw"===n&&t.iterator.return&&(e.method="return",e.arg=r,T(t,e),"throw"===e.method)||"return"!==n&&(e.method="throw",e.arg=new TypeError("The iterator does not provide a '"+n+"' method")),m;var i=p(o,t.iterator,e.arg);if("throw"===i.type)return e.method="throw",e.arg=i.arg,e.delegate=null,m;var a=i.arg;return a?a.done?(e[t.resultName]=a.value,e.next=t.nextLoc,"return"!==e.method&&(e.method="next",e.arg=r),e.delegate=null,m):a:(e.method="throw",e.arg=new TypeError("iterator result is not an object"),e.delegate=null,m)}function S(t){var e={tryLoc:t[0]};1 in t&&(e.catchLoc=t[1]),2 in t&&(e.finallyLoc=t[2],e.afterLoc=t[3]),this.tryEntries.push(e)}function A(t){var e=t.completion||{};e.type="normal",delete e.arg,t.completion=e}function D(t){this.tryEntries=[{tryLoc:"root"}],t.forEach(S,this),this.reset(!0)}function I(t){if(t||""===t){var n=t[u];if(n)return n.call(t);if("function"==typeof t.next)return t;if(!isNaN(t.length)){var o=-1,a=function e(){for(;++o<t.length;)if(i.call(t,o))return e.value=t[o],e.done=!1,e;return e.value=r,e.done=!0,e};return a.next=a}}throw new TypeError(e(t)+" is not iterable")}return w.prototype=O,a(j,"constructor",{value:O,configurable:!0}),a(O,"constructor",{value:w,configurable:!0}),w.displayName=l(O,s,"GeneratorFunction"),n.isGeneratorFunction=function(t){var e="function"==typeof t&&t.constructor;return!!e&&(e===w||"GeneratorFunction"===(e.displayName||e.name))},n.mark=function(t){return Object.setPrototypeOf?Object.setPrototypeOf(t,O):(t.__proto__=O,l(t,s,"GeneratorFunction")),t.prototype=Object.create(j),t},n.awrap=function(t){return{__await:t}},L(_.prototype),l(_.prototype,f,(function(){return this})),n.AsyncIterator=_,n.async=function(t,e,r,o,i){void 0===i&&(i=Promise);var a=new _(h(t,e,r,o),i);return n.isGeneratorFunction(e)?a:a.next().then((function(t){return t.done?t.value:a.next()}))},L(j),l(j,s,"Generator"),l(j,u,(function(){return this})),l(j,"toString",(function(){return"[object Generator]"})),n.keys=function(t){var e=Object(t),r=[];for(var n in e)r.push(n);return r.reverse(),function t(){for(;r.length;){var n=r.pop();if(n in e)return t.value=n,t.done=!1,t}return t.done=!0,t}},n.values=I,D.prototype={constructor:D,reset:function(t){if(this.prev=0,this.next=0,this.sent=this._sent=r,this.done=!1,this.delegate=null,this.method="next",this.arg=r,this.tryEntries.forEach(A),!t)for(var e in this)"t"===e.charAt(0)&&i.call(this,e)&&!isNaN(+e.slice(1))&&(this[e]=r)},stop:function(){this.done=!0;var t=this.tryEntries[0].completion;if("throw"===t.type)throw t.arg;return this.rval},dispatchException:function(t){if(this.done)throw t;var e=this;function n(n,o){return c.type="throw",c.arg=t,e.next=n,o&&(e.method="next",e.arg=r),!!o}for(var o=this.tryEntries.length-1;o>=0;--o){var a=this.tryEntries[o],c=a.completion;if("root"===a.tryLoc)return n("end");if(a.tryLoc<=this.prev){var u=i.call(a,"catchLoc"),f=i.call(a,"finallyLoc");if(u&&f){if(this.prev<a.catchLoc)return n(a.catchLoc,!0);if(this.prev<a.finallyLoc)return n(a.finallyLoc)}else if(u){if(this.prev<a.catchLoc)return n(a.catchLoc,!0)}else{if(!f)throw Error("try statement without catch or finally");if(this.prev<a.finallyLoc)return n(a.finallyLoc)}}}},abrupt:function(t,e){for(var r=this.tryEntries.length-1;r>=0;--r){var n=this.tryEntries[r];if(n.tryLoc<=this.prev&&i.call(n,"finallyLoc")&&this.prev<n.finallyLoc){var o=n;break}}o&&("break"===t||"continue"===t)&&o.tryLoc<=e&&e<=o.finallyLoc&&(o=null);var a=o?o.completion:{};return a.type=t,a.arg=e,o?(this.method="next",this.next=o.finallyLoc,m):this.complete(a)},complete:function(t,e){if("throw"===t.type)throw t.arg;return"break"===t.type||"continue"===t.type?this.next=t.arg:"return"===t.type?(this.rval=this.arg=t.arg,this.method="return",this.next="end"):"normal"===t.type&&e&&(this.next=e),m},finish:function(t){for(var e=this.tryEntries.length-1;e>=0;--e){var r=this.tryEntries[e];if(r.finallyLoc===t)return this.complete(r.completion,r.afterLoc),A(r),m}},catch:function(t){for(var e=this.tryEntries.length-1;e>=0;--e){var r=this.tryEntries[e];if(r.tryLoc===t){var n=r.completion;if("throw"===n.type){var o=n.arg;A(r)}return o}}throw Error("illegal catch attempt")},delegateYield:function(t,e,n){return this.delegate={iterator:I(t),resultName:e,nextLoc:n},"next"===this.method&&(this.arg=r),m}},n}function e(t){return e="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t},e(t)}function r(t,e){var r=Object.keys(t);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(t);e&&(n=n.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),r.push.apply(r,n)}return r}function n(t){for(var e=1;e<arguments.length;e++){var n=null!=arguments[e]?arguments[e]:{};e%2?r(Object(n),!0).forEach((function(e){o(t,e,n[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(n)):r(Object(n)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(n,e))}))}return t}function o(t,e,r){return(e=c(e))in t?Object.defineProperty(t,e,{value:r,enumerable:!0,configurable:!0,writable:!0}):t[e]=r,t}function i(t,e,r,n,o,i,a){try{var c=t[i](a),u=c.value}catch(t){return void r(t)}c.done?e(u):Promise.resolve(u).then(n,o)}function a(t,e){for(var r=0;r<e.length;r++){var n=e[r];n.enumerable=n.enumerable||!1,n.configurable=!0,"value"in n&&(n.writable=!0),Object.defineProperty(t,c(n.key),n)}}function c(t){var r=function(t,r){if("object"!=e(t)||!t)return t;var n=t[Symbol.toPrimitive];if(void 0!==n){var o=n.call(t,r||"default");if("object"!=e(o))return o;throw new TypeError("@@toPrimitive must return a primitive value.")}return("string"===r?String:Number)(t)}(t,"string");return"symbol"==e(r)?r:r+""}function u(t,r,n){return r=s(r),function(t,r){if(r&&("object"==e(r)||"function"==typeof r))return r;if(void 0!==r)throw new TypeError("Derived constructors may only return object or undefined");return function(t){if(void 0===t)throw new ReferenceError("this hasn't been initialised - super() hasn't been called");return t}(t)}(t,f()?Reflect.construct(r,n||[],s(t).constructor):r.apply(t,n))}function f(){try{var t=!Boolean.prototype.valueOf.call(Reflect.construct(Boolean,[],(function(){})))}catch(t){}return(f=function(){return!!t})()}function s(t){return s=Object.setPrototypeOf?Object.getPrototypeOf.bind():function(t){return t.__proto__||Object.getPrototypeOf(t)},s(t)}function l(t,e){return l=Object.setPrototypeOf?Object.setPrototypeOf.bind():function(t,e){return t.__proto__=e,t},l(t,e)}System.register(["@ibiz-template/runtime","@ibiz-template/core"],(function(r,o){"use strict";var c,f,s,h,p,y;return{setters:[function(t){c=t.FrontUIActionProvider,f=t.OpenAppViewCommand,s=t.registerUIActionProvider},function(t){h=t.ModelError,p=t.RuntimeModelError,y=t.StringUtil}],execute:function(){var o=function(r){function o(){return function(t,e){if(!(t instanceof e))throw new TypeError("Cannot call a class as a function")}(this,o),u(this,o,arguments)}return function(t,e){if("function"!=typeof e&&null!==e)throw new TypeError("Super expression must either be null or a function");t.prototype=Object.create(e&&e.prototype,{constructor:{value:t,writable:!0,configurable:!0}}),Object.defineProperty(t,"prototype",{writable:!1}),e&&l(t,e)}(o,r),c=o,s=[{key:"execAction",value:(d=t().mark((function r(o,i){var a,c,u,s,l,v,d,b,m,g,w,O,x,E,P;return t().wrap((function(t){for(;;)switch(t.prev=t.next){case 0:a=i.context,c=i.params,u=i.data,s=i.event,l=i.noWaitRoute,v=i.view,d={},t.t0=o.frontProcessType,t.next="OPENHTMLPAGE"===t.t0?5:"TOP"===t.t0||"WIZARD"===t.t0?8:"PRINT"===t.t0?25:"DATAIMP"===t.t0?28:"DATAEXP"===t.t0?32:"OTHER"===t.t0?35:"EDITFORM"===t.t0?39:"QUICKEDIT"===t.t0?43:47;break;case 5:return b=y.fill(o.htmlPageUrl,a,null==u?void 0:u[0]),window.open(b,"_blank"),t.abrupt("break",48);case 8:if(m=o.frontAppViewId){t.next=11;break}throw new p(o,ibiz.i18n.t("runtime.uiAction.noConfiguredopenView"));case 11:return t.next=13,this.handleParams(o,a,u,c);case 13:return g=t.sent,w=g.resultContext,O=g.resultParams,(x=this.handleSelectedData(v))&&x.length&&(O.selecteddata=JSON.stringify(x)),E=this.handleViewOptionParams(O),t.next=21,ibiz.commands.execute(f.TAG,m,w,O,n({event:s,noWaitRoute:l},E));case 21:return null!=(P=t.sent)&&P.ok||(d.cancel=!0),null!=P&&P.ok&&P.data&&(Array.isArray(P.data)?d.data=P.data.map((function(t){var r;return"object"===e(t)&&((null===(r=t.getOrigin)||void 0===r?void 0:r.call(t))||t._deData)||t})):d.data=P.data,d.nextContext=w,d.nextParams=n(n({},c),O)),t.abrupt("break",48);case 25:return t.next=27,this.executePrint(o,i);case 27:case 34:return t.abrupt("break",48);case 28:return t.next=30,this.executeDataImport(o,i);case 30:case 37:case 41:case 45:return d=t.sent,t.abrupt("break",48);case 32:return t.next=34,this.executeDataExport(o,i);case 35:return t.next=37,this.doOther(o,i);case 39:return t.next=41,this.openEditForm(o,i);case 43:return t.next=45,this.openQuickEdit(o,i);case 47:throw new h(o,ibiz.i18n.t("runtime.uiAction.frontProcessingModes",{frontProcessType:o.frontProcessType}));case 48:return t.abrupt("return",d);case 49:case"end":return t.stop()}}),r,this)})),b=function(){var t=this,e=arguments;return new Promise((function(r,n){var o=d.apply(t,e);function a(t){i(o,r,n,a,c,"next",t)}function c(t){i(o,r,n,a,c,"throw",t)}a(void 0)}))},function(t,e){return b.apply(this,arguments)})},{key:"handleSelectedData",value:function(t){var e=[];if(t){var r=t.getController("mdctrl");r&&(e=r.state.items||[])}return e.map((function(t){return{srfkey:t.user_id||t[t.srfkeyfield],_id:t.user_id||t[t.srfkeyfield],srfmajortext:t[t.srfmajorfield]}}))}}],s&&a(c.prototype,s),v&&a(c,v),Object.defineProperty(c,"prototype",{writable:!1}),c;var c,s,v,d,b}(c);r("default",{install:function(){s("DEUIACTION_ASSEMBLE_SELECTED_DATA",(function(){return new o}))}})}}}))}();