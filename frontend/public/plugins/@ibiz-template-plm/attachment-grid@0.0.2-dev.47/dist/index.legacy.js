!function(){function t(e,n,r){return t=a()?Reflect.construct.bind():function(t,e,n){var r=[null];r.push.apply(r,e);var i=new(Function.bind.apply(t,r));return n&&o(i,n.prototype),i},t.apply(null,arguments)}function e(t,e){if(!(t instanceof e))throw new TypeError("Cannot call a class as a function")}function n(t,e){for(var n=0;n<e.length;n++){var r=e[n];r.enumerable=r.enumerable||!1,r.configurable=!0,"value"in r&&(r.writable=!0),Object.defineProperty(t,d(r.key),r)}}function r(t,e,r){return e&&n(t.prototype,e),r&&n(t,r),Object.defineProperty(t,"prototype",{writable:!1}),t}function o(t,e){return o=Object.setPrototypeOf?Object.setPrototypeOf.bind():function(t,e){return t.__proto__=e,t},o(t,e)}function i(t){var e=a();return function(){var n,r=c(t);if(e){var o=c(this).constructor;n=Reflect.construct(r,arguments,o)}else n=r.apply(this,arguments);return function(t,e){if(e&&("object"===u(e)||"function"==typeof e))return e;if(void 0!==e)throw new TypeError("Derived constructors may only return object or undefined");return function(t){if(void 0===t)throw new ReferenceError("this hasn't been initialised - super() hasn't been called");return t}(t)}(this,n)}}function a(){if("undefined"==typeof Reflect||!Reflect.construct)return!1;if(Reflect.construct.sham)return!1;if("function"==typeof Proxy)return!0;try{return Boolean.prototype.valueOf.call(Reflect.construct(Boolean,[],(function(){}))),!0}catch(t){return!1}}function c(t){return c=Object.setPrototypeOf?Object.getPrototypeOf.bind():function(t){return t.__proto__||Object.getPrototypeOf(t)},c(t)}function u(t){return u="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t},u(t)}function l(t,e){var n=Object.keys(t);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(t);e&&(r=r.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),n.push.apply(n,r)}return n}function s(t){for(var e=1;e<arguments.length;e++){var n=null!=arguments[e]?arguments[e]:{};e%2?l(Object(n),!0).forEach((function(e){f(t,e,n[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(n)):l(Object(n)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(n,e))}))}return t}function f(t,e,n){return(e=d(e))in t?Object.defineProperty(t,e,{value:n,enumerable:!0,configurable:!0,writable:!0}):t[e]=n,t}function d(t){var e=function(t,e){if("object"!==u(t)||null===t)return t;var n=t[Symbol.toPrimitive];if(void 0!==n){var r=n.call(t,e||"default");if("object"!==u(r))return r;throw new TypeError("@@toPrimitive must return a primitive value.")}return("string"===e?String:Number)(t)}(t,"string");return"symbol"===u(e)?e:String(e)}function h(t){return function(t){if(Array.isArray(t))return y(t)}(t)||function(t){if("undefined"!=typeof Symbol&&null!=t[Symbol.iterator]||null!=t["@@iterator"])return Array.from(t)}(t)||m(t)||function(){throw new TypeError("Invalid attempt to spread non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}()}function p(){"use strict";/*! regenerator-runtime -- Copyright (c) 2014-present, Facebook, Inc. -- license (MIT): https://github.com/facebook/regenerator/blob/main/LICENSE */p=function(){return e};var t,e={},n=Object.prototype,r=n.hasOwnProperty,o=Object.defineProperty||function(t,e,n){t[e]=n.value},i="function"==typeof Symbol?Symbol:{},a=i.iterator||"@@iterator",c=i.asyncIterator||"@@asyncIterator",l=i.toStringTag||"@@toStringTag";function s(t,e,n){return Object.defineProperty(t,e,{value:n,enumerable:!0,configurable:!0,writable:!0}),t[e]}try{s({},"")}catch(t){s=function(t,e,n){return t[e]=n}}function f(t,e,n,r){var i=e&&e.prototype instanceof w?e:w,a=Object.create(i.prototype),c=new j(r||[]);return o(a,"_invoke",{value:P(t,n,c)}),a}function d(t,e,n){try{return{type:"normal",arg:t.call(e,n)}}catch(t){return{type:"throw",arg:t}}}e.wrap=f;var h="suspendedStart",v="suspendedYield",m="executing",y="completed",g={};function w(){}function b(){}function x(){}var C={};s(C,a,(function(){return this}));var S=Object.getPrototypeOf,R=S&&S(S(N([])));R&&R!==n&&r.call(R,a)&&(C=R);var k=x.prototype=w.prototype=Object.create(C);function E(t){["next","throw","return"].forEach((function(e){s(t,e,(function(t){return this._invoke(e,t)}))}))}function O(t,e){function n(o,i,a,c){var l=d(t[o],t,i);if("throw"!==l.type){var s=l.arg,f=s.value;return f&&"object"==u(f)&&r.call(f,"__await")?e.resolve(f.__await).then((function(t){n("next",t,a,c)}),(function(t){n("throw",t,a,c)})):e.resolve(f).then((function(t){s.value=t,a(s)}),(function(t){return n("throw",t,a,c)}))}c(l.arg)}var i;o(this,"_invoke",{value:function(t,r){function o(){return new e((function(e,o){n(t,r,e,o)}))}return i=i?i.then(o,o):o()}})}function P(e,n,r){var o=h;return function(i,a){if(o===m)throw new Error("Generator is already running");if(o===y){if("throw"===i)throw a;return{value:t,done:!0}}for(r.method=i,r.arg=a;;){var c=r.delegate;if(c){var u=L(c,r);if(u){if(u===g)continue;return u}}if("next"===r.method)r.sent=r._sent=r.arg;else if("throw"===r.method){if(o===h)throw o=y,r.arg;r.dispatchException(r.arg)}else"return"===r.method&&r.abrupt("return",r.arg);o=m;var l=d(e,n,r);if("normal"===l.type){if(o=r.done?y:v,l.arg===g)continue;return{value:l.arg,done:r.done}}"throw"===l.type&&(o=y,r.method="throw",r.arg=l.arg)}}}function L(e,n){var r=n.method,o=e.iterator[r];if(o===t)return n.delegate=null,"throw"===r&&e.iterator.return&&(n.method="return",n.arg=t,L(e,n),"throw"===n.method)||"return"!==r&&(n.method="throw",n.arg=new TypeError("The iterator does not provide a '"+r+"' method")),g;var i=d(o,e.iterator,n.arg);if("throw"===i.type)return n.method="throw",n.arg=i.arg,n.delegate=null,g;var a=i.arg;return a?a.done?(n[e.resultName]=a.value,n.next=e.nextLoc,"return"!==n.method&&(n.method="next",n.arg=t),n.delegate=null,g):a:(n.method="throw",n.arg=new TypeError("iterator result is not an object"),n.delegate=null,g)}function D(t){var e={tryLoc:t[0]};1 in t&&(e.catchLoc=t[1]),2 in t&&(e.finallyLoc=t[2],e.afterLoc=t[3]),this.tryEntries.push(e)}function T(t){var e=t.completion||{};e.type="normal",delete e.arg,t.completion=e}function j(t){this.tryEntries=[{tryLoc:"root"}],t.forEach(D,this),this.reset(!0)}function N(e){if(e||""===e){var n=e[a];if(n)return n.call(e);if("function"==typeof e.next)return e;if(!isNaN(e.length)){var o=-1,i=function n(){for(;++o<e.length;)if(r.call(e,o))return n.value=e[o],n.done=!1,n;return n.value=t,n.done=!0,n};return i.next=i}}throw new TypeError(u(e)+" is not iterable")}return b.prototype=x,o(k,"constructor",{value:x,configurable:!0}),o(x,"constructor",{value:b,configurable:!0}),b.displayName=s(x,l,"GeneratorFunction"),e.isGeneratorFunction=function(t){var e="function"==typeof t&&t.constructor;return!!e&&(e===b||"GeneratorFunction"===(e.displayName||e.name))},e.mark=function(t){return Object.setPrototypeOf?Object.setPrototypeOf(t,x):(t.__proto__=x,s(t,l,"GeneratorFunction")),t.prototype=Object.create(k),t},e.awrap=function(t){return{__await:t}},E(O.prototype),s(O.prototype,c,(function(){return this})),e.AsyncIterator=O,e.async=function(t,n,r,o,i){void 0===i&&(i=Promise);var a=new O(f(t,n,r,o),i);return e.isGeneratorFunction(n)?a:a.next().then((function(t){return t.done?t.value:a.next()}))},E(k),s(k,l,"Generator"),s(k,a,(function(){return this})),s(k,"toString",(function(){return"[object Generator]"})),e.keys=function(t){var e=Object(t),n=[];for(var r in e)n.push(r);return n.reverse(),function t(){for(;n.length;){var r=n.pop();if(r in e)return t.value=r,t.done=!1,t}return t.done=!0,t}},e.values=N,j.prototype={constructor:j,reset:function(e){if(this.prev=0,this.next=0,this.sent=this._sent=t,this.done=!1,this.delegate=null,this.method="next",this.arg=t,this.tryEntries.forEach(T),!e)for(var n in this)"t"===n.charAt(0)&&r.call(this,n)&&!isNaN(+n.slice(1))&&(this[n]=t)},stop:function(){this.done=!0;var t=this.tryEntries[0].completion;if("throw"===t.type)throw t.arg;return this.rval},dispatchException:function(e){if(this.done)throw e;var n=this;function o(r,o){return c.type="throw",c.arg=e,n.next=r,o&&(n.method="next",n.arg=t),!!o}for(var i=this.tryEntries.length-1;i>=0;--i){var a=this.tryEntries[i],c=a.completion;if("root"===a.tryLoc)return o("end");if(a.tryLoc<=this.prev){var u=r.call(a,"catchLoc"),l=r.call(a,"finallyLoc");if(u&&l){if(this.prev<a.catchLoc)return o(a.catchLoc,!0);if(this.prev<a.finallyLoc)return o(a.finallyLoc)}else if(u){if(this.prev<a.catchLoc)return o(a.catchLoc,!0)}else{if(!l)throw new Error("try statement without catch or finally");if(this.prev<a.finallyLoc)return o(a.finallyLoc)}}}},abrupt:function(t,e){for(var n=this.tryEntries.length-1;n>=0;--n){var o=this.tryEntries[n];if(o.tryLoc<=this.prev&&r.call(o,"finallyLoc")&&this.prev<o.finallyLoc){var i=o;break}}i&&("break"===t||"continue"===t)&&i.tryLoc<=e&&e<=i.finallyLoc&&(i=null);var a=i?i.completion:{};return a.type=t,a.arg=e,i?(this.method="next",this.next=i.finallyLoc,g):this.complete(a)},complete:function(t,e){if("throw"===t.type)throw t.arg;return"break"===t.type||"continue"===t.type?this.next=t.arg:"return"===t.type?(this.rval=this.arg=t.arg,this.method="return",this.next="end"):"normal"===t.type&&e&&(this.next=e),g},finish:function(t){for(var e=this.tryEntries.length-1;e>=0;--e){var n=this.tryEntries[e];if(n.finallyLoc===t)return this.complete(n.completion,n.afterLoc),T(n),g}},catch:function(t){for(var e=this.tryEntries.length-1;e>=0;--e){var n=this.tryEntries[e];if(n.tryLoc===t){var r=n.completion;if("throw"===r.type){var o=r.arg;T(n)}return o}}throw new Error("illegal catch attempt")},delegateYield:function(e,n,r){return this.delegate={iterator:N(e),resultName:n,nextLoc:r},"next"===this.method&&(this.arg=t),g}},e}function v(t,e){return function(t){if(Array.isArray(t))return t}(t)||function(t,e){var n=null==t?null:"undefined"!=typeof Symbol&&t[Symbol.iterator]||t["@@iterator"];if(null!=n){var r,o,i,a,c=[],u=!0,l=!1;try{if(i=(n=n.call(t)).next,0===e){if(Object(n)!==n)return;u=!1}else for(;!(u=(r=i.call(n)).done)&&(c.push(r.value),c.length!==e);u=!0);}catch(t){l=!0,o=t}finally{try{if(!u&&null!=n.return&&(a=n.return(),Object(a)!==a))return}finally{if(l)throw o}}return c}}(t,e)||m(t,e)||function(){throw new TypeError("Invalid attempt to destructure non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}()}function m(t,e){if(t){if("string"==typeof t)return y(t,e);var n=Object.prototype.toString.call(t).slice(8,-1);return"Object"===n&&t.constructor&&(n=t.constructor.name),"Map"===n||"Set"===n?Array.from(t):"Arguments"===n||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)?y(t,e):void 0}}function y(t,e){(null==e||e>t.length)&&(e=t.length);for(var n=0,r=new Array(e);n<e;n++)r[n]=t[n];return r}function g(t,e,n,r,o,i,a){try{var c=t[i](a),u=c.value}catch(l){return void n(l)}c.done?e(u):Promise.resolve(u).then(r,o)}function w(t){return function(){var e=this,n=arguments;return new Promise((function(r,o){var i=t.apply(e,n);function a(t){g(i,r,o,a,c,"next",t)}function c(t){g(i,r,o,a,c,"throw",t)}a(void 0)}))}}System.register(["@ibiz-template/vue3-util","@ibiz-template/runtime","vue","@ibiz-template/core"],(function(n,a){"use strict";var c,l,d,m,y,g,b,x,C,S,R,k,E,O,P,L,D,T,j;return{setters:[function(t){c=t.useControlController,l=t.useNamespace,d=t.withInstall},function(t){m=t.GridRowState,y=t.ControlVO,g=t.GridController,b=t.registerControlProvider,x=t.ControlType},function(t){C=t.ref,S=t.watch,R=t.computed,k=t.reactive,E=t.createVNode,O=t.resolveComponent,P=t.defineComponent,L=t.createTextVNode,D=t.mergeProps,T=t.h},function(t){j=t.RuntimeError}],execute:function(){var a=function(t){t.stopPropagation()},N=function(){var t=w(p().mark((function t(e,n,r,o){return p().wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return r.grid.setSelection([o.data]),t.next=3,r.onActionClick(e,o,n);case 3:case"end":return t.stop()}}),t)})));return function(e,n,r,o){return t.apply(this,arguments)}}(),_=Math.min,A=Math.max,B=Math.round,G=function(t){return{x:t,y:t}};function z(t){return t.split("-")[0]}function I(t){return["top","bottom"].includes(z(t))?"y":"x"}function M(t){return s(s({},t),{},{top:t.y,left:t.x,right:t.x+t.width,bottom:t.y+t.height})}function F(t,e,n){var r,o=t.reference,i=t.floating,a=I(e),c=function(t){return"x"===I(t)?"y":"x"}(e),u="y"===c?"height":"width",l=z(e),s="y"===a,f=o.x+o.width/2-i.width/2,d=o.y+o.height/2-i.height/2,h=o[u]/2-i[u]/2;switch(l){case"top":r={x:f,y:o.y-i.height};break;case"bottom":r={x:f,y:o.y+o.height};break;case"right":r={x:o.x+o.width,y:d};break;case"left":r={x:o.x-i.width,y:d};break;default:r={x:o.x,y:o.y}}switch(function(t){return t.split("-")[1]}(e)){case"start":r[c]-=h*(n&&s?-1:1);break;case"end":r[c]+=h*(n&&s?-1:1)}return r}var H=function(){var t=w(p().mark((function t(e,n,r){var o,i,a,c,l,d,h,v,m,y,g,w,b,x,C,S,R,k,E,O,P,L,D,T,j,N;return p().wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return o=r.placement,i=void 0===o?"bottom":o,a=r.strategy,c=void 0===a?"absolute":a,l=r.middleware,d=void 0===l?[]:l,h=r.platform,v=d.filter(Boolean),t.next=4,null==h.isRTL?void 0:h.isRTL(n);case 4:return m=t.sent,t.next=7,h.getElementRects({reference:e,floating:n,strategy:c});case 7:y=t.sent,g=F(y,i,m),w=g.x,b=g.y,x=i,C={},S=0,R=0;case 13:if(!(R<v.length)){t.next=46;break}return k=v[R],E=k.name,O=k.fn,t.next=17,O({x:w,y:b,initialPlacement:i,placement:x,strategy:c,middlewareData:C,rects:y,platform:h,elements:{reference:e,floating:n}});case 17:if(P=t.sent,L=P.x,D=P.y,T=P.data,j=P.reset,w=null!=L?L:w,b=null!=D?D:b,C=s(s({},C),{},f({},E,s(s({},C[E]),T))),!(j&&S<=50)){t.next=43;break}if(S++,"object"!==u(j)){t.next=41;break}if(j.placement&&(x=j.placement),!j.rects){t.next=38;break}if(!0!==j.rects){t.next=36;break}return t.next=33,h.getElementRects({reference:e,floating:n,strategy:c});case 33:t.t0=t.sent,t.next=37;break;case 36:t.t0=j.rects;case 37:y=t.t0;case 38:N=F(y,x,m),w=N.x,b=N.y;case 41:return R=-1,t.abrupt("continue",43);case 43:R++,t.next=13;break;case 46:return t.abrupt("return",{x:w,y:b,placement:x,strategy:c,middlewareData:C});case 47:case"end":return t.stop()}}),t)})));return function(e,n,r){return t.apply(this,arguments)}}();function V(t){return U(t)?(t.nodeName||"").toLowerCase():"#document"}function W(t){var e;return(null==t||null==(e=t.ownerDocument)?void 0:e.defaultView)||window}function q(t){var e;return null==(e=(U(t)?t.ownerDocument:t.document)||window.document)?void 0:e.documentElement}function U(t){return t instanceof Node||t instanceof W(t).Node}function $(t){return t instanceof Element||t instanceof W(t).Element}function Y(t){return t instanceof HTMLElement||t instanceof W(t).HTMLElement}function Q(t){return"undefined"!=typeof ShadowRoot&&(t instanceof ShadowRoot||t instanceof W(t).ShadowRoot)}function X(t){var e=et(t),n=e.overflow,r=e.overflowX,o=e.overflowY,i=e.display;return/auto|scroll|overlay|hidden|clip/.test(n+o+r)&&!["inline","contents"].includes(i)}function J(t){return["table","td","th"].includes(V(t))}function K(t){var e=Z(),n=et(t);return"none"!==n.transform||"none"!==n.perspective||!!n.containerType&&"normal"!==n.containerType||!e&&!!n.backdropFilter&&"none"!==n.backdropFilter||!e&&!!n.filter&&"none"!==n.filter||["transform","perspective","filter"].some((function(t){return(n.willChange||"").includes(t)}))||["paint","layout","strict","content"].some((function(t){return(n.contain||"").includes(t)}))}function Z(){return!("undefined"==typeof CSS||!CSS.supports)&&CSS.supports("-webkit-backdrop-filter","none")}function tt(t){return["html","body","#document"].includes(V(t))}function et(t){return W(t).getComputedStyle(t)}function nt(t){return $(t)?{scrollLeft:t.scrollLeft,scrollTop:t.scrollTop}:{scrollLeft:t.pageXOffset,scrollTop:t.pageYOffset}}function rt(t){if("html"===V(t))return t;var e=t.assignedSlot||t.parentNode||Q(t)&&t.host||q(t);return Q(e)?e.host:e}function ot(t){var e=rt(t);return tt(e)?t.ownerDocument?t.ownerDocument.body:t.body:Y(e)&&X(e)?e:ot(e)}function it(t,e,n){var r;void 0===e&&(e=[]),void 0===n&&(n=!0);var o=ot(t),i=o===(null==(r=t.ownerDocument)?void 0:r.body),a=W(o);return i?e.concat(a,a.visualViewport||[],X(o)?o:[],a.frameElement&&n?it(a.frameElement):[]):e.concat(o,it(o,[],n))}function at(t){var e=et(t),n=parseFloat(e.width)||0,r=parseFloat(e.height)||0,o=Y(t),i=o?t.offsetWidth:n,a=o?t.offsetHeight:r,c=B(n)!==i||B(r)!==a;return c&&(n=i,r=a),{width:n,height:r,$:c}}function ct(t){return $(t)?t:t.contextElement}function ut(t){var e=ct(t);if(!Y(e))return G(1);var n=e.getBoundingClientRect(),r=at(e),o=r.width,i=r.height,a=r.$,c=(a?B(n.width):n.width)/o,u=(a?B(n.height):n.height)/i;return c&&Number.isFinite(c)||(c=1),u&&Number.isFinite(u)||(u=1),{x:c,y:u}}var lt=G(0);function st(t){var e=W(t);return Z()&&e.visualViewport?{x:e.visualViewport.offsetLeft,y:e.visualViewport.offsetTop}:lt}function ft(t,e,n,r){void 0===e&&(e=!1),void 0===n&&(n=!1);var o=t.getBoundingClientRect(),i=ct(t),a=G(1);e&&(r?$(r)&&(a=ut(r)):a=ut(t));var c=function(t,e,n){return void 0===e&&(e=!1),!(!n||e&&n!==W(t))&&e}(i,n,r)?st(i):G(0),u=(o.left+c.x)/a.x,l=(o.top+c.y)/a.y,s=o.width/a.x,f=o.height/a.y;if(i)for(var d=W(i),h=r&&$(r)?W(r):r,p=d.frameElement;p&&r&&h!==d;){var v=ut(p),m=p.getBoundingClientRect(),y=et(p),g=m.left+(p.clientLeft+parseFloat(y.paddingLeft))*v.x,w=m.top+(p.clientTop+parseFloat(y.paddingTop))*v.y;u*=v.x,l*=v.y,s*=v.x,f*=v.y,u+=g,l+=w,p=W(p).frameElement}return M({width:s,height:f,x:u,y:l})}function dt(t){return ft(q(t)).left+nt(t).scrollLeft}function ht(t,e,n){var r;if("viewport"===e)r=function(t,e){var n=W(t),r=q(t),o=n.visualViewport,i=r.clientWidth,a=r.clientHeight,c=0,u=0;if(o){i=o.width,a=o.height;var l=Z();(!l||l&&"fixed"===e)&&(c=o.offsetLeft,u=o.offsetTop)}return{width:i,height:a,x:c,y:u}}(t,n);else if("document"===e)r=function(t){var e=q(t),n=nt(t),r=t.ownerDocument.body,o=A(e.scrollWidth,e.clientWidth,r.scrollWidth,r.clientWidth),i=A(e.scrollHeight,e.clientHeight,r.scrollHeight,r.clientHeight),a=-n.scrollLeft+dt(t),c=-n.scrollTop;return"rtl"===et(r).direction&&(a+=A(e.clientWidth,r.clientWidth)-o),{width:o,height:i,x:a,y:c}}(q(t));else if($(e))r=function(t,e){var n=ft(t,!0,"fixed"===e),r=n.top+t.clientTop,o=n.left+t.clientLeft,i=Y(t)?ut(t):G(1);return{width:t.clientWidth*i.x,height:t.clientHeight*i.y,x:o*i.x,y:r*i.y}}(e,n);else{var o=st(t);r=s(s({},e),{},{x:e.x-o.x,y:e.y-o.y})}return M(r)}function pt(t,e){var n=rt(t);return!(n===e||!$(n)||tt(n))&&("fixed"===et(n).position||pt(n,e))}function vt(t,e,n){var r=Y(e),o=q(e),i="fixed"===n,a=ft(t,!0,i,e),c={scrollLeft:0,scrollTop:0},u=G(0);if(r||!r&&!i)if(("body"!==V(e)||X(o))&&(c=nt(e)),r){var l=ft(e,!0,i,e);u.x=l.x+e.clientLeft,u.y=l.y+e.clientTop}else o&&(u.x=dt(o));return{x:a.left+c.scrollLeft-u.x,y:a.top+c.scrollTop-u.y,width:a.width,height:a.height}}function mt(t,e){return Y(t)&&"fixed"!==et(t).position?e?e(t):t.offsetParent:null}function yt(t,e){var n=W(t);if(!Y(t))return n;for(var r=mt(t,e);r&&J(r)&&"static"===et(r).position;)r=mt(r,e);return r&&("html"===V(r)||"body"===V(r)&&"static"===et(r).position&&!K(r))?n:r||function(t){for(var e=rt(t);Y(e)&&!tt(e);){if(K(e))return e;e=rt(e)}return null}(t)||n}var gt=function(){var t=w(p().mark((function t(e){var n,r,o,i,a;return p().wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return n=e.reference,r=e.floating,o=e.strategy,i=this.getOffsetParent||yt,a=this.getDimensions,t.t0=vt,t.t1=n,t.next=7,i(r);case 7:return t.t2=t.sent,t.t3=o,t.t4=(0,t.t0)(t.t1,t.t2,t.t3),t.t5=s,t.t6={x:0,y:0},t.next=14,a(r);case 14:return t.t7=t.sent,t.t8=(0,t.t5)(t.t6,t.t7),t.abrupt("return",{reference:t.t4,floating:t.t8});case 17:case"end":return t.stop()}}),t,this)})));return function(e){return t.apply(this,arguments)}}();var wt={convertOffsetParentRelativeRectToViewportRelativeRect:function(t){var e=t.rect,n=t.offsetParent,r=t.strategy,o=Y(n),i=q(n);if(n===i)return e;var a={scrollLeft:0,scrollTop:0},c=G(1),u=G(0);if((o||!o&&"fixed"!==r)&&(("body"!==V(n)||X(i))&&(a=nt(n)),Y(n))){var l=ft(n);c=ut(n),u.x=l.x+n.clientLeft,u.y=l.y+n.clientTop}return{width:e.width*c.x,height:e.height*c.y,x:e.x*c.x-a.scrollLeft*c.x+u.x,y:e.y*c.y-a.scrollTop*c.y+u.y}},getDocumentElement:q,getClippingRect:function(t){var e=t.element,n=t.boundary,r=t.rootBoundary,o=t.strategy,i="clippingAncestors"===n?function(t,e){var n=e.get(t);if(n)return n;for(var r=it(t,[],!1).filter((function(t){return $(t)&&"body"!==V(t)})),o=null,i="fixed"===et(t).position,a=i?rt(t):t;$(a)&&!tt(a);){var c=et(a),u=K(a);u||"fixed"!==c.position||(o=null),(i?!u&&!o:!u&&"static"===c.position&&o&&["absolute","fixed"].includes(o.position)||X(a)&&!u&&pt(t,a))?r=r.filter((function(t){return t!==a})):o=c,a=rt(a)}return e.set(t,r),r}(e,this._c):[].concat(n),a=[].concat(h(i),[r]),c=a[0],u=a.reduce((function(t,n){var r=ht(e,n,o);return t.top=A(r.top,t.top),t.right=_(r.right,t.right),t.bottom=_(r.bottom,t.bottom),t.left=A(r.left,t.left),t}),ht(e,c,o));return{width:u.right-u.left,height:u.bottom-u.top,x:u.left,y:u.top}},getOffsetParent:yt,getElementRects:gt,getClientRects:function(t){return Array.from(t.getClientRects())},getDimensions:function(t){return at(t)},getScale:ut,isElement:$,isRTL:function(t){return"rtl"===et(t).direction}};var bt=function(t){!function(t,e){if("function"!=typeof e&&null!==e)throw new TypeError("Super expression must either be null or a function");t.prototype=Object.create(e&&e.prototype,{constructor:{value:t,writable:!0,configurable:!0}}),Object.defineProperty(t,"prototype",{writable:!1}),e&&o(t,e)}(c,t);var n,a=i(c);function c(){return e(this,c),a.apply(this,arguments)}return r(c,[{key:"addAttachMent",value:(n=w(p().mark((function t(e){var n,r;return p().wrap((function(t){for(;;)switch(t.prev=t.next){case 0:if(!(n=this.model.appDataEntityId)){t.next=9;break}return r=ibiz.hub.getApp(this.context.srfappid),t.next=5,r.deService.exec(n,"create",this.context,e);case 5:return t.next=7,this.refresh();case 7:return t.next=9,this.evt.emit("onSaveSuccess",void 0);case 9:case"end":return t.stop()}}),t,this)}))),function(t){return n.apply(this,arguments)})}]),c}(g);function xt(t,e,n,r){if("GROUPGRIDCOLUMN"===e.columnType){var o,i,c=(null===(o=e.degridColumns)||void 0===o?void 0:o.filter((function(t){return!t.hideDefault})))||[],u=e.width,s=(null===(i=e.align)||void 0===i?void 0:i.toLowerCase())||"center";return E(O("el-table-column"),{prop:e.codeName,label:e.caption,"min-width":u,align:s},{default:function(){return c.map((function(e,r){return xt(t,e,n,r)}))}})}return function(t,e,n,r){var o;if(e.hideDefault)return null;var i=e.codeName,c=e.width,u=t.columns[i],s=t.state.columnStates.find((function(t){return t.key===i})),d=u.isAdaptiveColumn||!t.hasAdaptiveColumn&&r===n.length-1?"min-width":"width",h="";return"UAGRIDCOLUMN"===e.columnType&&(h="attachment-ua-column"),E(O("el-table-column"),D({label:e.caption,prop:i,"class-name":h,"label-class-name":h},f({},d,c),{fixed:s.fixed,sortable:!!e.enableSort&&"custom",align:(null===(o=e.align)||void 0===o?void 0:o.toLowerCase())||"center"}),{default:function(n){var r=n.row,o=r;r.isGroupData&&(o=r.first);var c=t.findRowState(o);if(c){if("UAGRIDCOLUMN"===e.columnType){var s,f,d=l("grid-ua-column"),h=(null===(s=u.model.deuiactionGroup)||void 0===s?void 0:s.uiactionGroupDetails)||[],p=h.filter((function(t){return 250!==t.actionLevel})),v=h.filter((function(t){return 250===t.actionLevel}));return E("div",{class:[d.b(),null===(f=u.model.cellSysCss)||void 0===f?void 0:f.cssName]},[v.length&&E(O("iBizActionToolbar"),{onDblclick:a,onClick:a,"action-details":v,"actions-state":c.uaColStates[u.model.codeName],onActionClick:function(t,e){N(t,e,u,c)}},null),p.length&&E(O("iBizActionToolbar"),{onDblclick:a,onClick:a,mode:"dropdown",caption:"· · ·","action-details":p,"actions-state":c.uaColStates[u.model.codeName],onActionClick:function(t,e){N(t,e,u,c)}},null)])}var m=O(t.providers[i].component);return T(m,{controller:u,row:c,key:o.tempsrfkey+i})}return null}})}(t,e,n,r)}var Ct=P({name:"AttachmentGridControl",props:{modelData:{type:Object,required:!0},context:{type:Object,required:!0},params:{type:Object,default:function(){return{}}},provider:{type:Object},mdctrlActiveMode:{type:Number,default:void 0},singleSelect:{type:Boolean,default:void 0},rowEditOpen:{type:Boolean,default:void 0},isSimple:{type:Boolean,required:!1},data:{type:Array,required:!1},loadDefault:{type:Boolean,default:!0}},setup:function(e){var n=c((function(){for(var e=arguments.length,n=new Array(e),r=0;r<e;r++)n[r]=arguments[r];return t(bt,n)})),r=l("control-".concat(n.model.controlType.toLowerCase())),o=function(t){var e=C(),n=!1;function r(){return(r=w(p().mark((function e(n,r,o){var i;return p().wrap((function(e){for(;;)switch(e.prev=e.next){case 0:if("row"!==ibiz.config.grid.editShowMode||!t.model.enableRowEdit){e.next=7;break}if(!(i=t.findRowState(n))||!0===i.showRowEdit){e.next=5;break}return e.next=5,t.switchRowEdit(i,!0);case 5:e.next=8;break;case 7:t.onRowClick(n);case 8:case"end":return e.stop()}}),e)})))).apply(this,arguments)}return S([function(){return e.value},function(){return t.state.isLoaded},function(){return t.state.selectedData}],(function(r){var o=v(r,3),i=o[0],a=o[1],c=o[2];a&&i&&(t.state.singleSelect?c[0]?e.value.setCurrentRow(c[0],!0):e.value.setCurrentRow():(n=!0,e.value.clearSelection(),c.forEach((function(t){return e.value.toggleRowSelection(t,!0)})),n=!1))})),S((function(){return t.state.sortQuery}),(function(n){if(n){var r=t.state.sortQuery.split(",")[0],o=t.state.sortQuery.split(",")[1];if(e.value&&r&&o){var i="desc"===o?"descending":"ascending";setTimeout((function(){var t;null===(t=e.value)||void 0===t||t.sort(r,i)}))}}})),{tableRef:e,onRowClick:function(t,e,n){return r.apply(this,arguments)},onDbRowClick:function(e){t.onDbRowClick(e)},onSelectionChange:function(e){n||t.setSelection(e)},onSortChange:function(e){var n,r=e.prop,o=e.order,i=t.fieldColumns[r].model.appDEFieldId;"ascending"===o?n="asc":"descending"===o&&(n="desc"),t.setSort(i,n),t.load()},handleRowClassName:function(e){var n=e.row,r="";t.state.selectedData.length>0&&t.state.selectedData.forEach((function(t){t===n&&(r="current-row")}));var o=t.findRowState(n);return null!=o&&o.showRowEdit&&(r+=" editing-row"),n.srfkey&&(r+=" id-".concat(n.srfkey)),r},handleHeaderCellClassName:function(e){e._row;var n,r=e.column,o=(e._rowIndex,e._columnIndex,null===(n=t.model.degridColumns)||void 0===n?void 0:n.find((function(t){return t.codeName===r.property})));return o&&o.headerSysCss&&o.headerSysCss.cssName?o.headerSysCss.cssName:""}}}(n),i=o.tableRef,a=o.onRowClick,u=o.onDbRowClick,f=o.onSelectionChange,d=o.onSortChange,g=o.handleRowClassName,b=o.handleHeaderCellClassName,x=function(t){return{onPageChange:function(e){e&&e!==t.state.curPage&&(t.state.curPage=e,t.load())},onPageSizeChange:function(e){e&&e!==t.state.size&&(t.state.size=e,1===t.state.curPage&&t.load())},onPageRefresh:function(){t.load()}}}(n),P=x.onPageChange,D=x.onPageRefresh,T=x.onPageSizeChange,N=function(t,e){var n=function(){e.data&&(t.state.items=e.data,t.state.rows=e.data.map((function(e){return new m(new y(e),t)})))},r=R((function(){var e,n=Object.values(t.fieldColumns).find((function(e){return e.model.appDEFieldId===t.model.minorSortAppDEFieldId}));return{prop:null==n?void 0:n.model.codeName,order:"desc"===(null===(e=t.model.minorSortDir)||void 0===e?void 0:e.toLowerCase())?"descending":"ascending"}}));return t.evt.on("onCreated",w(p().mark((function r(){return p().wrap((function(r){for(;;)switch(r.prev=r.next){case 0:e.isSimple&&(n(),t.state.isLoaded=!0);case 1:case"end":return r.stop()}}),r)})))),S((function(){return e.data}),(function(){e.isSimple&&n()}),{deep:!0}),{tableData:R((function(){var e=t.state;if(t.model.enableGroup){var n=[];return e.groups.forEach((function(t){if(t.children.length){var e=h(t.children),r=e.shift();n.push({srfkey:(null==r?void 0:r.srfkey)||t.caption,isGroupData:!0,caption:t.caption,first:r,children:e})}})),n}return e.rows.map((function(t){return t.data}))})),renderColumns:R((function(){if(t.isMultistageHeader)return t.model.degridColumns||[];var e=[];return t.state.columnStates.forEach((function(n){var r,o;if(!n.hidden){var i=(null===(r=t.fieldColumns[n.key])||void 0===r?void 0:r.model)||(null===(o=t.uaColumns[n.key])||void 0===o?void 0:o.model);i&&e.push(i)}})),e})),defaultSort:r,summaryMethod:function(e){return e.columns.map((function(e,n){return 0===n?t.aggTitle:t.state.aggResult[e.property]}))}}}(n,e),_=N.tableData,A=N.renderColumns,B=N.defaultSort,G=N.summaryMethod,z=function(t,e){var n,r=C(!1),o=C(),i=k({}),a=function(e){if(!t.value)throw new j("找不到表格组件引用");var n=t.value.$el,r=".el-table__row";e.data.srfkey&&(r+=".id-".concat(e.data.srfkey));var o=n.querySelector(r);if(!o)throw new j("找不到对应的表格行dom元素");return o},c=function(){var t=w(p().mark((function t(e){var c,u,l,f,d;return p().wrap((function(t){for(;;)switch(t.prev=t.next){case 0:if(c=a(e),n){t.next=3;break}throw new j("拿不到pop组件的实例");case 3:return u=n.$el,t.next=6,h=c,p=u,v={placement:"bottom"},m=void 0,y=void 0,g=void 0,m=new Map,y=s({platform:wt},v),g=s(s({},y.platform),{},{_c:m}),H(h,p,s(s({},y),{},{platform:g}));case 6:l=t.sent,f=l.x,d=l.y,Object.assign(i,{top:"".concat(d,"px"),left:"".concat(f,"px")}),o.value=e,r.value=!0;case 12:case"end":return t.stop()}var h,p,v,m,y,g}),t)})));return function(e){return t.apply(this,arguments)}}(),u=function(){var t=w(p().mark((function t(){return p().wrap((function(t){for(;;)switch(t.prev=t.next){case 0:o.value&&e.switchRowEdit(o.value,!1,!0);case 1:case"end":return t.stop()}}),t)})));return function(){return t.apply(this,arguments)}}(),l=function(){var t=w(p().mark((function t(){return p().wrap((function(t){for(;;)switch(t.prev=t.next){case 0:o.value&&e.switchRowEdit(o.value,!1,!1);case 1:case"end":return t.stop()}}),t)})));return function(){return t.apply(this,arguments)}}();return e.evt.on("onRowEditChange",(function(t){t.row.showRowEdit?setTimeout((function(){c(t.row)}),0):(o.value=void 0,r.value=!1,Object.assign(i,{top:void 0,left:void 0}))})),{renderPopover:function(){var t=r.value&&e.state.rows[e.state.rows.length-1].showRowEdit;return[E("div",{class:"row-edit-popover__placeholder",style:{display:t?"block":"none"}},null),E(O("iBizRowEditPopover"),{ref:function(t){n=t},style:i,show:r.value,onConfirm:u,onCancel:l},null)]}}}(i,n),I=z.renderPopover;return{c:n,ns:r,tableRef:i,tableData:_,renderColumns:A,onDbRowClick:u,onRowClick:a,onSelectionChange:f,onSortChange:d,onPageChange:P,onPageSizeChange:T,onPageRefresh:D,handleRowClassName:g,handleHeaderCellClassName:b,renderNoData:function(){if(n.state.isLoaded){var t,e=null===(t=n.model.controls)||void 0===t?void 0:t.find((function(t){return t.name==="".concat(n.model.name,"_quicktoolbar")}));return e?E(O("iBizToolbarControl"),{modelData:e,context:n.context,params:n.params,class:r.b("quick-toolbar")},null):E(O("iBizNoData"),{text:n.model.emptyText,emptyTextLanguageRes:n.model.emptyTextLanguageRes},null)}return null},summaryMethod:G,renderPopover:I,defaultSort:B,onColumnStateClick:function(t){n.setColumnVisible(t)},renderBatchToolBar:function(){var t,e=null===(t=n.model.controls)||void 0===t?void 0:t.find((function(t){return t.name==="".concat(n.model.name,"_batchtoolbar")}));if(e&&!n.state.singleSelect)return E("div",{class:[r.b("batch-toolbar"),r.is("show",n.state.selectedData.length>0)]},[E("div",{class:r.b("batch-toolbar-content")},[E("div",{class:r.b("batch-toolbar-text")},[L("已选中"),n.state.selectedData.length,L("项")]),E("div",{class:r.b("batch-toolbar-separator")},[L("|")]),E(O("iBizToolbarControl"),{modelData:e,context:n.context,params:n.params,class:r.b("batch-toolbar-items")},null)])])}}},render:function(){var t=this;if(this.c.state.isCreated){var e=this.c.state,n=this.c.model,r=n.hideHeader,o=n.enablePagingBar;return E(O("iBizControlBase"),{class:[this.ns.is("show-header",!r),this.ns.is("enable-page",o),this.ns.is("enable-group",this.c.model.enableGroup)],controller:this.c},{default:function(){return[E(O("el-table"),{ref:"tableRef",class:[t.ns.e("table"),t.ns.is("attachment",!0)],"default-sort":t.defaultSort,border:!0,"show-header":!r,"show-summary":t.c.enableAgg,"summary-method":t.summaryMethod,"highlight-current-row":e.singleSelect,"row-class-name":t.handleRowClassName,"header-cell-class-name":t.handleHeaderCellClassName,"row-key":"tempsrfkey",data:t.tableData,onRowClick:t.onRowClick,onRowDblclick:t.onDbRowClick,onSelectionChange:t.onSelectionChange,onSortChange:t.onSortChange,"tooltip-effect":"light"},{empty:t.renderNoData,default:function(){return[!e.singleSelect&&E(O("el-table-column"),{"class-name":t.ns.e("selection"),type:"selection",width:"55"},null),t.renderColumns.map((function(e,n){return xt(t.c,e,t.renderColumns,n)}))]},append:function(){return t.renderPopover()}}),o&&E(O("iBizPagination"),{total:e.total,curPage:e.curPage,size:e.size,onChange:t.onPageChange,onPageSizeChange:t.onPageSizeChange,onPageRefresh:t.onPageRefresh},null),t.c.model.enableCustomized&&!r&&E("div",{class:t.ns.b("setting-box")},[E(O("iBizGridSetting"),{columnStates:e.columnStates,controller:t.c},null)]),t.renderBatchToolBar()]}})}}}),St=r((function t(){e(this,t),f(this,"component","AttachmentGridControl")})),Rt=n("IBizAttachmentGridControl",d(Ct,(function(t){t.component(Ct.name,Ct),b("".concat(x.GRID,"_RENDER_ATTACHMENT_GRID"),(function(){return new St}))})));n("default",{install:function(t){t.use(Rt)}})}}}))}();