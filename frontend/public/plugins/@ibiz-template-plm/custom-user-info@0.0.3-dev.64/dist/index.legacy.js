!function(){function t(e){return t="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t},t(e)}function e(t){return function(t){if(Array.isArray(t))return r(t)}(t)||function(t){if("undefined"!=typeof Symbol&&null!=t[Symbol.iterator]||null!=t["@@iterator"])return Array.from(t)}(t)||function(t,e){if(!t)return;if("string"==typeof t)return r(t,e);var n=Object.prototype.toString.call(t).slice(8,-1);"Object"===n&&t.constructor&&(n=t.constructor.name);if("Map"===n||"Set"===n)return Array.from(t);if("Arguments"===n||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n))return r(t,e)}(t)||function(){throw new TypeError("Invalid attempt to spread non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}()}function r(t,e){(null==e||e>t.length)&&(e=t.length);for(var r=0,n=new Array(e);r<e;r++)n[r]=t[r];return n}function n(){"use strict";/*! regenerator-runtime -- Copyright (c) 2014-present, Facebook, Inc. -- license (MIT): https://github.com/facebook/regenerator/blob/main/LICENSE */n=function(){return r};var e,r={},o=Object.prototype,i=o.hasOwnProperty,a=Object.defineProperty||function(t,e,r){t[e]=r.value},u="function"==typeof Symbol?Symbol:{},s=u.iterator||"@@iterator",c=u.asyncIterator||"@@asyncIterator",l=u.toStringTag||"@@toStringTag";function f(t,e,r){return Object.defineProperty(t,e,{value:r,enumerable:!0,configurable:!0,writable:!0}),t[e]}try{f({},"")}catch(e){f=function(t,e,r){return t[e]=r}}function h(t,e,r,n){var o=e&&e.prototype instanceof b?e:b,i=Object.create(o.prototype),u=new F(n||[]);return a(i,"_invoke",{value:L(t,r,u)}),i}function p(t,e,r){try{return{type:"normal",arg:t.call(e,r)}}catch(t){return{type:"throw",arg:t}}}r.wrap=h;var v="suspendedStart",d="suspendedYield",y="executing",m="completed",g={};function b(){}function w(){}function x(){}var I={};f(I,s,(function(){return this}));var O=Object.getPrototypeOf,E=O&&O(O(T([])));E&&E!==o&&i.call(E,s)&&(I=E);var A=x.prototype=b.prototype=Object.create(I);function P(t){["next","throw","return"].forEach((function(e){f(t,e,(function(t){return this._invoke(e,t)}))}))}function j(e,r){function n(o,a,u,s){var c=p(e[o],e,a);if("throw"!==c.type){var l=c.arg,f=l.value;return f&&"object"==t(f)&&i.call(f,"__await")?r.resolve(f.__await).then((function(t){n("next",t,u,s)}),(function(t){n("throw",t,u,s)})):r.resolve(f).then((function(t){l.value=t,u(l)}),(function(t){return n("throw",t,u,s)}))}s(c.arg)}var o;a(this,"_invoke",{value:function(t,e){function i(){return new r((function(r,o){n(t,e,r,o)}))}return o=o?o.then(i,i):i()}})}function L(t,r,n){var o=v;return function(i,a){if(o===y)throw new Error("Generator is already running");if(o===m){if("throw"===i)throw a;return{value:e,done:!0}}for(n.method=i,n.arg=a;;){var u=n.delegate;if(u){var s=S(u,n);if(s){if(s===g)continue;return s}}if("next"===n.method)n.sent=n._sent=n.arg;else if("throw"===n.method){if(o===v)throw o=m,n.arg;n.dispatchException(n.arg)}else"return"===n.method&&n.abrupt("return",n.arg);o=y;var c=p(t,r,n);if("normal"===c.type){if(o=n.done?m:d,c.arg===g)continue;return{value:c.arg,done:n.done}}"throw"===c.type&&(o=m,n.method="throw",n.arg=c.arg)}}}function S(t,r){var n=r.method,o=t.iterator[n];if(o===e)return r.delegate=null,"throw"===n&&t.iterator.return&&(r.method="return",r.arg=e,S(t,r),"throw"===r.method)||"return"!==n&&(r.method="throw",r.arg=new TypeError("The iterator does not provide a '"+n+"' method")),g;var i=p(o,t.iterator,r.arg);if("throw"===i.type)return r.method="throw",r.arg=i.arg,r.delegate=null,g;var a=i.arg;return a?a.done?(r[t.resultName]=a.value,r.next=t.nextLoc,"return"!==r.method&&(r.method="next",r.arg=e),r.delegate=null,g):a:(r.method="throw",r.arg=new TypeError("iterator result is not an object"),r.delegate=null,g)}function C(t){var e={tryLoc:t[0]};1 in t&&(e.catchLoc=t[1]),2 in t&&(e.finallyLoc=t[2],e.afterLoc=t[3]),this.tryEntries.push(e)}function k(t){var e=t.completion||{};e.type="normal",delete e.arg,t.completion=e}function F(t){this.tryEntries=[{tryLoc:"root"}],t.forEach(C,this),this.reset(!0)}function T(r){if(r||""===r){var n=r[s];if(n)return n.call(r);if("function"==typeof r.next)return r;if(!isNaN(r.length)){var o=-1,a=function t(){for(;++o<r.length;)if(i.call(r,o))return t.value=r[o],t.done=!1,t;return t.value=e,t.done=!0,t};return a.next=a}}throw new TypeError(t(r)+" is not iterable")}return w.prototype=x,a(A,"constructor",{value:x,configurable:!0}),a(x,"constructor",{value:w,configurable:!0}),w.displayName=f(x,l,"GeneratorFunction"),r.isGeneratorFunction=function(t){var e="function"==typeof t&&t.constructor;return!!e&&(e===w||"GeneratorFunction"===(e.displayName||e.name))},r.mark=function(t){return Object.setPrototypeOf?Object.setPrototypeOf(t,x):(t.__proto__=x,f(t,l,"GeneratorFunction")),t.prototype=Object.create(A),t},r.awrap=function(t){return{__await:t}},P(j.prototype),f(j.prototype,c,(function(){return this})),r.AsyncIterator=j,r.async=function(t,e,n,o,i){void 0===i&&(i=Promise);var a=new j(h(t,e,n,o),i);return r.isGeneratorFunction(e)?a:a.next().then((function(t){return t.done?t.value:a.next()}))},P(A),f(A,l,"Generator"),f(A,s,(function(){return this})),f(A,"toString",(function(){return"[object Generator]"})),r.keys=function(t){var e=Object(t),r=[];for(var n in e)r.push(n);return r.reverse(),function t(){for(;r.length;){var n=r.pop();if(n in e)return t.value=n,t.done=!1,t}return t.done=!0,t}},r.values=T,F.prototype={constructor:F,reset:function(t){if(this.prev=0,this.next=0,this.sent=this._sent=e,this.done=!1,this.delegate=null,this.method="next",this.arg=e,this.tryEntries.forEach(k),!t)for(var r in this)"t"===r.charAt(0)&&i.call(this,r)&&!isNaN(+r.slice(1))&&(this[r]=e)},stop:function(){this.done=!0;var t=this.tryEntries[0].completion;if("throw"===t.type)throw t.arg;return this.rval},dispatchException:function(t){if(this.done)throw t;var r=this;function n(n,o){return u.type="throw",u.arg=t,r.next=n,o&&(r.method="next",r.arg=e),!!o}for(var o=this.tryEntries.length-1;o>=0;--o){var a=this.tryEntries[o],u=a.completion;if("root"===a.tryLoc)return n("end");if(a.tryLoc<=this.prev){var s=i.call(a,"catchLoc"),c=i.call(a,"finallyLoc");if(s&&c){if(this.prev<a.catchLoc)return n(a.catchLoc,!0);if(this.prev<a.finallyLoc)return n(a.finallyLoc)}else if(s){if(this.prev<a.catchLoc)return n(a.catchLoc,!0)}else{if(!c)throw new Error("try statement without catch or finally");if(this.prev<a.finallyLoc)return n(a.finallyLoc)}}}},abrupt:function(t,e){for(var r=this.tryEntries.length-1;r>=0;--r){var n=this.tryEntries[r];if(n.tryLoc<=this.prev&&i.call(n,"finallyLoc")&&this.prev<n.finallyLoc){var o=n;break}}o&&("break"===t||"continue"===t)&&o.tryLoc<=e&&e<=o.finallyLoc&&(o=null);var a=o?o.completion:{};return a.type=t,a.arg=e,o?(this.method="next",this.next=o.finallyLoc,g):this.complete(a)},complete:function(t,e){if("throw"===t.type)throw t.arg;return"break"===t.type||"continue"===t.type?this.next=t.arg:"return"===t.type?(this.rval=this.arg=t.arg,this.method="return",this.next="end"):"normal"===t.type&&e&&(this.next=e),g},finish:function(t){for(var e=this.tryEntries.length-1;e>=0;--e){var r=this.tryEntries[e];if(r.finallyLoc===t)return this.complete(r.completion,r.afterLoc),k(r),g}},catch:function(t){for(var e=this.tryEntries.length-1;e>=0;--e){var r=this.tryEntries[e];if(r.tryLoc===t){var n=r.completion;if("throw"===n.type){var o=n.arg;k(r)}return o}}throw new Error("illegal catch attempt")},delegateYield:function(t,r,n){return this.delegate={iterator:T(t),resultName:r,nextLoc:n},"next"===this.method&&(this.arg=e),g}},r}function o(t,e,r,n,o,i,a){try{var u=t[i](a),s=u.value}catch(c){return void r(c)}u.done?e(s):Promise.resolve(s).then(n,o)}function i(t){return function(){var e=this,r=arguments;return new Promise((function(n,i){var a=t.apply(e,r);function u(t){o(a,n,i,u,s,"next",t)}function s(t){o(a,n,i,u,s,"throw",t)}u(void 0)}))}}function a(){return a="undefined"!=typeof Reflect&&Reflect.get?Reflect.get.bind():function(t,e,r){var n=function(t,e){for(;!Object.prototype.hasOwnProperty.call(t,e)&&null!==(t=l(t)););return t}(t,e);if(n){var o=Object.getOwnPropertyDescriptor(n,e);return o.get?o.get.call(arguments.length<3?t:r):o.value}},a.apply(this,arguments)}function u(t,e){return u=Object.setPrototypeOf?Object.setPrototypeOf.bind():function(t,e){return t.__proto__=e,t},u(t,e)}function s(e){var r=function(){if("undefined"==typeof Reflect||!Reflect.construct)return!1;if(Reflect.construct.sham)return!1;if("function"==typeof Proxy)return!0;try{return Boolean.prototype.valueOf.call(Reflect.construct(Boolean,[],(function(){}))),!0}catch(t){return!1}}();return function(){var n,o=l(e);if(r){var i=l(this).constructor;n=Reflect.construct(o,arguments,i)}else n=o.apply(this,arguments);return function(e,r){if(r&&("object"===t(r)||"function"==typeof r))return r;if(void 0!==r)throw new TypeError("Derived constructors may only return object or undefined");return c(e)}(this,n)}}function c(t){if(void 0===t)throw new ReferenceError("this hasn't been initialised - super() hasn't been called");return t}function l(t){return l=Object.setPrototypeOf?Object.getPrototypeOf.bind():function(t){return t.__proto__||Object.getPrototypeOf(t)},l(t)}function f(t,e){if(!(t instanceof e))throw new TypeError("Cannot call a class as a function")}function h(t,e){for(var r=0;r<e.length;r++){var n=e[r];n.enumerable=n.enumerable||!1,n.configurable=!0,"value"in n&&(n.writable=!0),Object.defineProperty(t,d(n.key),n)}}function p(t,e,r){return e&&h(t.prototype,e),r&&h(t,r),Object.defineProperty(t,"prototype",{writable:!1}),t}function v(t,e,r){return(e=d(e))in t?Object.defineProperty(t,e,{value:r,enumerable:!0,configurable:!0,writable:!0}):t[e]=r,t}function d(e){var r=function(e,r){if("object"!==t(e)||null===e)return e;var n=e[Symbol.toPrimitive];if(void 0!==n){var o=n.call(e,r||"default");if("object"!==t(o))return o;throw new TypeError("@@toPrimitive must return a primitive value.")}return("string"===r?String:Number)(e)}(e,"string");return"symbol"===t(r)?r:String(r)}System.register(["@ibiz-template/vue3-util","@ibiz-template/runtime","vue","vue-router","@ibiz-template/core","lodash-es","@ibiz-template/vue3-components"],(function(t,r){"use strict";var o,h,d,y,m,g,b,w,x,I,O,E,A,P,j,L,S,C,k,F,T,_,z;return{setters:[function(t){o=t.useNamespace,h=t.withInstall},function(t){d=t.PanelItemController,y=t.registerPanelItemProvider,m=t.registerErrorViewProvider},function(t){g=t.defineComponent,b=t.createVNode,w=t.h,x=t.resolveComponent,I=t.createTextVNode,O=t.inject,E=t.ref,A=t.onBeforeUnmount,P=t.onMounted,j=t.computed},function(t){L=t.useRouter,S=t.useRoute},function(t){C=t.NOOP,k=t.listenJSEvent,F=t.RuntimeError,T=t.HttpError},function(t){_=t.isArray},function(t){z=t.AppRouter}],execute:function(){var r,R=function(){function t(){f(this,t)}return p(t,null,[{key:"getThemeVar",value:function(){var t=document.documentElement;return t?getComputedStyle(t).getPropertyValue("--ibiz-color-primary"):null}},{key:"isChineseChart",value:function(t){return/[\u4E00-\u9FA5]/.test(t)}},{key:"hasChineseAndEnglish",value:function(t){return/[\u4e00-\u9fa5]+.*[a-zA-Z]+|[a-zA-Z]+.*[\u4e00-\u9fa5]+/.test(t)}},{key:"calcTextPhoto",value:function(t){if(t&&t.toString().length<2)return t;if(t&&t.toString().length>=2){if(this.hasChineseAndEnglish(t)){var e=t.split("").find((function(t){return/[a-zA-Z]/.test(t)}))||"",r=t.split("").find((function(t){return/[\u4E00-\u9FA5]/.test(t)}))||"";return"".concat(e).concat(r).toLowerCase()}return/[a-zA-Z]/.test(t)?t.split("").filter((function(t){return/[a-zA-Z]/.test(t)})).slice(0,2).join("").toUpperCase():/[\u4E00-\u9FA5]/.test(t)?t.split("").filter((function(t){return/[\u4E00-\u9FA5]/.test(t)})).slice(-2).join(""):t.replaceAll(" ","").substring(0,2)}}}]),t}();r=R,v(R,"calcColorPhoto",(function(t){if(!t)return"";for(var e=0,n=0;n<t.length;n++){if(r.isChineseChart(t))e=t.charCodeAt(n)+((e<<5)-e),e&=e;else e+=t.charCodeAt(n).toString(16)}var o=String(e).substring(0,6),i=parseInt(o.substring(0,2),16),a=parseInt(o.substring(2,4),16),u=parseInt(o.substring(4,6),16);i<0&&(i=10),a<0&&(a=10),u<0&&(u=10);var s="#".concat(i.toString(16).padStart(2,"0")).concat(a.toString(16).padStart(2,"0")).concat(u.toString(16).padStart(2,"0"));return"#FFFFFF"===s&&r.getThemeVar()||s}));var V=g({name:"Avatar",props:{label:{type:String,required:!0},img:{type:String},readOnly:{type:Boolean,default:!1}},setup:function(t){var e=o("custom-avatar");return{ns:e,renderAvatar:function(){return t.img?b("img",{class:e.e("user-avatar"),src:t.img},null):b("div",{class:e.e("default-avatar"),style:"background-color: ".concat(R.calcColorPhoto(t.label))},[R.calcTextPhoto(t.label)])}}},render:function(){return b("div",{class:this.ns.b()},[this.renderAvatar()])}}),N=g({name:"UserInfoPopover",props:{controller:{type:Object,required:!0},context:{type:Object,required:!0},params:{type:Object,default:function(){return{}}},viewId:{type:String},modal:{type:Object}},setup:function(t){var e=o("user-info-popover"),r=t.controller;return{ns:e,renderContent:function(){return t.viewId?w(x("IBizViewShell"),{context:t.context,params:t.params,viewId:t.viewId,modal:t.modal}):[b("div",{class:e.e("header")},[b("img",{src:"./assets/images/login-header.png"},null)]),b("div",{class:e.e("content")},[b("div",{class:e.em("content","avatar-container")},[b(V,{class:e.em("content","avatar"),label:r.userInfo.srfusername,img:r.userInfo.avatar},null)]),b("div",{class:e.em("content","info")},[b("div",{class:"user-name"},[r.userInfo.srfusername]),b("div",{class:"description"},[r.userInfo.srfpersonname])])]),b(x("el-divider"),{class:e.e("divider"),"content-position":"center"},null),b("div",{class:e.e("footer")},[b(x("el-button"),{class:e.e("log-out"),onClick:function(){return r.onLogOut()},text:!0},{default:function(){return[b(x("iBizIcon"),{class:e.em("log-out","icon"),icon:{cssClass:"fa fa-sign-out"}},null),b("span",{class:e.em("log-out","text")},[I("退出登录")])]}})])]}}},render:function(){return b("div",{class:[this.ns.b()]},[this.renderContent()])}}),U=function(t){!function(t,e){if("function"!=typeof e&&null!==e)throw new TypeError("Super expression must either be null or a function");t.prototype=Object.create(e&&e.prototype,{constructor:{value:t,writable:!0,configurable:!0}}),Object.defineProperty(t,"prototype",{writable:!1}),e&&u(t,e)}(d,t);var e,r,o,h=s(d);function d(){var t;f(this,d);for(var e=arguments.length,r=new Array(e),n=0;n<e;n++)r[n]=arguments[n];return v(c(t=h.call.apply(h,[this].concat(r))),"navViewName",""),v(c(t),"avatarField",""),v(c(t),"titlField",""),v(c(t),"subTitleField",""),v(c(t),"router",void 0),v(c(t),"overlay",null),v(c(t),"ctx",O("ctx",void 0)),v(c(t),"userInfoView",void 0),v(c(t),"userInfo",void 0),v(c(t),"cleanup",C),t}return p(d,[{key:"isCollapse",get:function(){return this.panel.view.state.isCollapse}},{key:"menuAlign",get:function(){var t;return null!==(t=this.ctx)&&void 0!==t&&t.view&&this.ctx.view.model.mainMenuAlign||"LEFT"}},{key:"onInit",value:(o=i(n().mark((function t(){var e,r,o,i,u,s=this;return n().wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.next=2,a(l(d.prototype),"onInit",this).call(this);case 2:return this.initRawItemParams(),t.prev=3,r=(null===(e=ibiz.appData)||void 0===e?void 0:e.context)||{},o=r.srfusername,i=void 0===o?"游客":o,u=r.srfpersonname,this.userInfo={srfusername:i,srfpersonname:u},this.avatarField&&r[this.avatarField]&&Object.assign(this.userInfo,{avatar:this.parseAvatar(r[this.avatarField])}),this.titlField&&r[this.titlField]&&Object.assign(this.userInfo,{srfusername:r[this.titlField]}),this.subTitleField&&r[this.subTitleField]&&Object.assign(this.userInfo,{srfpersonname:r[this.subTitleField]}),t.next=12,ibiz.hub.config.view.get(this.navViewName);case 12:this.userInfoView=t.sent,t.next=18;break;case 15:t.prev=15,t.t0=t.catch(3),ibiz.log.error(t.t0);case 18:this.cleanup=k(window,"keydown",(function(t){var e;27===t.keyCode&&(null===(e=s.overlay)||void 0===e||e.dismiss())}));case 19:case"end":return t.stop()}}),t,this,[[3,15]])}))),function(){return o.apply(this,arguments)})},{key:"parseAvatar",value:function(t){try{var e=JSON.parse(t);if(e){var r=_(e)?e[0]:e;return ibiz.util.file.calcFileUpDownUrl(this.panel.context,this.panel.params).downloadUrl.replace("%fileId%",r.id)}}catch(n){throw new F("头像数据解析异常")}}},{key:"initRawItemParams",value:function(){var t,e=this,r=null===(t=this.model)||void 0===t?void 0:t.rawItem;_(null==r?void 0:r.rawItemParams)&&(null==r||r.rawItemParams.forEach((function(t){var r=t.key,n=t.value;"NAVVIEWNAME"===r&&(e.navViewName=n),"AVATAR"===r&&(e.avatarField=n.toLowerCase()),"TITLE"===r&&(e.titlField=n.toLowerCase()),"SUBTITLE"===r&&(e.subTitleField=n.toLowerCase())})))}},{key:"setRouter",value:function(t){this.router=t}},{key:"onLogOut",value:(r=i(n().mark((function t(){var e;return n().wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return null===(e=this.overlay)||void 0===e||e.dismiss(),t.next=3,ibiz.confirm.info({title:"退出登录",desc:"您确定要退出登录吗？"});case 3:if(!t.sent){t.next=13;break}return t.next=7,ibiz.hub.controller.logout();case 7:if(!t.sent){t.next=13;break}return t.next=11,this.router.push("/login?ru=".concat(encodeURIComponent(window.location.hash.replace("#/","/"))));case 11:ibiz.util.showAppLoading(),window.location.reload();case 13:case"end":return t.stop()}}),t,this)}))),function(){return r.apply(this,arguments)})},{key:"openUserInfoPopover",value:(e=i(n().mark((function t(e){var r,o,i=this;return n().wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return this.overlay=ibiz.overlay.createPopover((function(t){var e;return w(N,{context:i.panel.context.clone(),params:i.panel.params,modal:t,controller:i,viewId:null===(e=i.userInfoView)||void 0===e?void 0:e.id})}),void 0,{placement:"LEFT"===this.menuAlign?"right-start":"bottom",autoClose:!0,noArrow:!0,width:(null===(r=this.userInfoView)||void 0===r?void 0:r.width)||320,height:null===(o=this.userInfoView)||void 0===o?void 0:o.height}),t.next=3,this.overlay.present(e);case 3:return t.next=5,this.overlay.onWillDismiss();case 5:return t.abrupt("return",t.sent);case 6:case"end":return t.stop()}}),t,this)}))),function(t){return e.apply(this,arguments)})},{key:"onDestroyed",value:function(){var t;this.cleanup!==C&&this.cleanup(),null===(t=this.overlay)||void 0===t||t.dismiss()}}]),d}(d),B=g({name:"CustomUserInfo",props:{modelData:{type:Object,required:!0},controller:{type:U,required:!0}},setup:function(t){var e=o("custom-user-info"),r=t.controller,n=E({}),i=L();r.setRouter(i);return A((function(){r.onDestroyed()})),{c:r,ns:e,userInfo:n,onOpenUserInfoPopover:function(){r.openUserInfoPopover(n.value)}}},render:function(){return b("div",{ref:"userInfo",class:[this.ns.b(),this.ns.m(this.modelData.id)].concat(e(this.c.containerClass),[this.ns.is("left","LEFT"===this.c.menuAlign),this.ns.is("top","TOP"===this.c.menuAlign),this.ns.is("collapse",this.c.isCollapse)]),onClick:this.onOpenUserInfoPopover},[b(V,{class:this.ns.e("avatar"),label:this.c.userInfo.srfusername,img:this.c.userInfo.avatar,readOnly:!0},null),!this.c.isCollapse&&b("div",{class:this.ns.e("info")},[b("div",{class:this.ns.em("info","user-name")},[this.c.userInfo.srfusername]),"LEFT"===this.c.menuAlign&&b("div",{class:this.ns.em("info","description")},[this.c.userInfo.srfpersonname])])])}}),D=function(){function t(){f(this,t),v(this,"component","CustomUserInfo")}var e;return p(t,[{key:"createController",value:(e=i(n().mark((function t(e,r,o){var i;return n().wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return i=new U(e,r,o),t.next=3,i.init();case 3:return t.abrupt("return",i);case 4:case"end":return t.stop()}}),t)}))),function(t,r,n){return e.apply(this,arguments)})}]),t}(),G=function(){function t(){f(this,t)}return p(t,[{key:"handle",value:function(t){if(t instanceof T&&403===t.status)return z.getRouter().push({name:"errorView2",params:{code:"403"}}),!0}}]),t}(),M=g({name:"IBizView403",setup:function(){var t=o("403-view"),e=L(),r=S(),a=function(){var t=i(n().mark((function t(){return n().wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.next=2,e.push("/");case 2:window.location.reload();case 3:case"end":return t.stop()}}),t)})));return function(){return t.apply(this,arguments)}}();return P((function(){return ibiz.util.hiddenAppLoading()})),{ns:t,isTop:j((function(){return r&&!r.params.view1})),gotoIndexView:a}},render:function(){return b("div",{class:[this.ns.b(),this.ns.is("top",this.isTop)]},[b("img",{class:this.ns.b("img"),src:"./assets/images/404.png"},null),b("div",{class:this.ns.b("text")},[b("div",{class:this.ns.be("text","text1")},[I("抱歉，您没有访问该页面的权限")])])])}}),q=t("IBizCustomUserInfo",h(B,(function(t){t.component(B.name,B),y("CUSTOM_CUSTOM_AUTH_USERINFO",(function(){return new D}))})));t("default",{install:function(t){t.use(q),ibiz.util.error.register(new G),m("403",(function(){return{component:M}}))}})}}}))}();