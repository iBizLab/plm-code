import './style.css';
var ue = Object.defineProperty;
var ce = (e, i, a) => i in e ? ue(e, i, { enumerable: !0, configurable: !0, writable: !0, value: a }) : e[i] = a;
var V = (e, i, a) => (ce(e, typeof i != "symbol" ? i + "" : i, a), a);
import { EditorController as de, registerEditorProvider as pe } from "@ibiz-template/runtime";
import { defineComponent as re, ref as D, watch as ie, createVNode as I, resolveComponent as q, nextTick as J, computed as ge } from "vue";
import { useNamespace as se, getRawProps as fe, getEditorEmits as be } from "@ibiz-template/vue3-util";
import { createUUID as te } from "qx-util";
var ne = typeof globalThis < "u" ? globalThis : typeof window < "u" ? window : typeof global < "u" ? global : typeof self < "u" ? self : {};
function he(e) {
  return e && e.__esModule && Object.prototype.hasOwnProperty.call(e, "default") ? e.default : e;
}
var oe = { exports: {} };
(function(e) {
  var i = typeof window < "u" ? window : typeof WorkerGlobalScope < "u" && self instanceof WorkerGlobalScope ? self : {};
  /**
   * Prism: Lightweight, robust, elegant syntax highlighting
   *
   * @license MIT <https://opensource.org/licenses/MIT>
   * @author Lea Verou <https://lea.verou.me>
   * @namespace
   * @public
   */
  var a = function(s) {
    var f = /(?:^|\s)lang(?:uage)?-([\w-]+)(?=\s|$)/i, E = 0, w = {}, o = {
      /**
       * By default, Prism will attempt to highlight all code elements (by calling {@link Prism.highlightAll}) on the
       * current page after the page finished loading. This might be a problem if e.g. you wanted to asynchronously load
       * additional languages or plugins yourself.
       *
       * By setting this value to `true`, Prism will not automatically highlight all code elements on the page.
       *
       * You obviously have to change this value before the automatic highlighting started. To do this, you can add an
       * empty Prism object into the global scope before loading the Prism script like this:
       *
       * ```js
       * window.Prism = window.Prism || {};
       * Prism.manual = true;
       * // add a new <script> to load Prism's script
       * ```
       *
       * @default false
       * @type {boolean}
       * @memberof Prism
       * @public
       */
      manual: s.Prism && s.Prism.manual,
      /**
       * By default, if Prism is in a web worker, it assumes that it is in a worker it created itself, so it uses
       * `addEventListener` to communicate with its parent instance. However, if you're using Prism manually in your
       * own worker, you don't want it to do this.
       *
       * By setting this value to `true`, Prism will not add its own listeners to the worker.
       *
       * You obviously have to change this value before Prism executes. To do this, you can add an
       * empty Prism object into the global scope before loading the Prism script like this:
       *
       * ```js
       * window.Prism = window.Prism || {};
       * Prism.disableWorkerMessageHandler = true;
       * // Load Prism's script
       * ```
       *
       * @default false
       * @type {boolean}
       * @memberof Prism
       * @public
       */
      disableWorkerMessageHandler: s.Prism && s.Prism.disableWorkerMessageHandler,
      /**
       * A namespace for utility methods.
       *
       * All function in this namespace that are not explicitly marked as _public_ are for __internal use only__ and may
       * change or disappear at any time.
       *
       * @namespace
       * @memberof Prism
       */
      util: {
        encode: function n(t) {
          return t instanceof g ? new g(t.type, n(t.content), t.alias) : Array.isArray(t) ? t.map(n) : t.replace(/&/g, "&amp;").replace(/</g, "&lt;").replace(/\u00a0/g, " ");
        },
        /**
         * Returns the name of the type of the given value.
         *
         * @param {any} o
         * @returns {string}
         * @example
         * type(null)      === 'Null'
         * type(undefined) === 'Undefined'
         * type(123)       === 'Number'
         * type('foo')     === 'String'
         * type(true)      === 'Boolean'
         * type([1, 2])    === 'Array'
         * type({})        === 'Object'
         * type(String)    === 'Function'
         * type(/abc+/)    === 'RegExp'
         */
        type: function(n) {
          return Object.prototype.toString.call(n).slice(8, -1);
        },
        /**
         * Returns a unique number for the given object. Later calls will still return the same number.
         *
         * @param {Object} obj
         * @returns {number}
         */
        objId: function(n) {
          return n.__id || Object.defineProperty(n, "__id", { value: ++E }), n.__id;
        },
        /**
         * Creates a deep clone of the given object.
         *
         * The main intended use of this function is to clone language definitions.
         *
         * @param {T} o
         * @param {Record<number, any>} [visited]
         * @returns {T}
         * @template T
         */
        clone: function n(t, r) {
          r = r || {};
          var l, u;
          switch (o.util.type(t)) {
            case "Object":
              if (u = o.util.objId(t), r[u])
                return r[u];
              l = /** @type {Record<string, any>} */
              {}, r[u] = l;
              for (var h in t)
                t.hasOwnProperty(h) && (l[h] = n(t[h], r));
              return (
                /** @type {any} */
                l
              );
            case "Array":
              return u = o.util.objId(t), r[u] ? r[u] : (l = [], r[u] = l, /** @type {Array} */
              /** @type {any} */
              t.forEach(function(_, m) {
                l[m] = n(_, r);
              }), /** @type {any} */
              l);
            default:
              return t;
          }
        },
        /**
         * Returns the Prism language of the given element set by a `language-xxxx` or `lang-xxxx` class.
         *
         * If no language is set for the element or the element is `null` or `undefined`, `none` will be returned.
         *
         * @param {Element} element
         * @returns {string}
         */
        getLanguage: function(n) {
          for (; n; ) {
            var t = f.exec(n.className);
            if (t)
              return t[1].toLowerCase();
            n = n.parentElement;
          }
          return "none";
        },
        /**
         * Sets the Prism `language-xxxx` class of the given element.
         *
         * @param {Element} element
         * @param {string} language
         * @returns {void}
         */
        setLanguage: function(n, t) {
          n.className = n.className.replace(RegExp(f, "gi"), ""), n.classList.add("language-" + t);
        },
        /**
         * Returns the script element that is currently executing.
         *
         * This does __not__ work for line script element.
         *
         * @returns {HTMLScriptElement | null}
         */
        currentScript: function() {
          if (typeof document > "u")
            return null;
          if ("currentScript" in document && 1 < 2)
            return (
              /** @type {any} */
              document.currentScript
            );
          try {
            throw new Error();
          } catch (l) {
            var n = (/at [^(\r\n]*\((.*):[^:]+:[^:]+\)$/i.exec(l.stack) || [])[1];
            if (n) {
              var t = document.getElementsByTagName("script");
              for (var r in t)
                if (t[r].src == n)
                  return t[r];
            }
            return null;
          }
        },
        /**
         * Returns whether a given class is active for `element`.
         *
         * The class can be activated if `element` or one of its ancestors has the given class and it can be deactivated
         * if `element` or one of its ancestors has the negated version of the given class. The _negated version_ of the
         * given class is just the given class with a `no-` prefix.
         *
         * Whether the class is active is determined by the closest ancestor of `element` (where `element` itself is
         * closest ancestor) that has the given class or the negated version of it. If neither `element` nor any of its
         * ancestors have the given class or the negated version of it, then the default activation will be returned.
         *
         * In the paradoxical situation where the closest ancestor contains __both__ the given class and the negated
         * version of it, the class is considered active.
         *
         * @param {Element} element
         * @param {string} className
         * @param {boolean} [defaultActivation=false]
         * @returns {boolean}
         */
        isActive: function(n, t, r) {
          for (var l = "no-" + t; n; ) {
            var u = n.classList;
            if (u.contains(t))
              return !0;
            if (u.contains(l))
              return !1;
            n = n.parentElement;
          }
          return !!r;
        }
      },
      /**
       * This namespace contains all currently loaded languages and the some helper functions to create and modify languages.
       *
       * @namespace
       * @memberof Prism
       * @public
       */
      languages: {
        /**
         * The grammar for plain, unformatted text.
         */
        plain: w,
        plaintext: w,
        text: w,
        txt: w,
        /**
         * Creates a deep copy of the language with the given id and appends the given tokens.
         *
         * If a token in `redef` also appears in the copied language, then the existing token in the copied language
         * will be overwritten at its original position.
         *
         * ## Best practices
         *
         * Since the position of overwriting tokens (token in `redef` that overwrite tokens in the copied language)
         * doesn't matter, they can technically be in any order. However, this can be confusing to others that trying to
         * understand the language definition because, normally, the order of tokens matters in Prism grammars.
         *
         * Therefore, it is encouraged to order overwriting tokens according to the positions of the overwritten tokens.
         * Furthermore, all non-overwriting tokens should be placed after the overwriting ones.
         *
         * @param {string} id The id of the language to extend. This has to be a key in `Prism.languages`.
         * @param {Grammar} redef The new tokens to append.
         * @returns {Grammar} The new language created.
         * @public
         * @example
         * Prism.languages['css-with-colors'] = Prism.languages.extend('css', {
         *     // Prism.languages.css already has a 'comment' token, so this token will overwrite CSS' 'comment' token
         *     // at its original position
         *     'comment': { ... },
         *     // CSS doesn't have a 'color' token, so this token will be appended
         *     'color': /\b(?:red|green|blue)\b/
         * });
         */
        extend: function(n, t) {
          var r = o.util.clone(o.languages[n]);
          for (var l in t)
            r[l] = t[l];
          return r;
        },
        /**
         * Inserts tokens _before_ another token in a language definition or any other grammar.
         *
         * ## Usage
         *
         * This helper method makes it easy to modify existing languages. For example, the CSS language definition
         * not only defines CSS highlighting for CSS documents, but also needs to define highlighting for CSS embedded
         * in HTML through `<style>` elements. To do this, it needs to modify `Prism.languages.markup` and add the
         * appropriate tokens. However, `Prism.languages.markup` is a regular JavaScript object literal, so if you do
         * this:
         *
         * ```js
         * Prism.languages.markup.style = {
         *     // token
         * };
         * ```
         *
         * then the `style` token will be added (and processed) at the end. `insertBefore` allows you to insert tokens
         * before existing tokens. For the CSS example above, you would use it like this:
         *
         * ```js
         * Prism.languages.insertBefore('markup', 'cdata', {
         *     'style': {
         *         // token
         *     }
         * });
         * ```
         *
         * ## Special cases
         *
         * If the grammars of `inside` and `insert` have tokens with the same name, the tokens in `inside`'s grammar
         * will be ignored.
         *
         * This behavior can be used to insert tokens after `before`:
         *
         * ```js
         * Prism.languages.insertBefore('markup', 'comment', {
         *     'comment': Prism.languages.markup.comment,
         *     // tokens after 'comment'
         * });
         * ```
         *
         * ## Limitations
         *
         * The main problem `insertBefore` has to solve is iteration order. Since ES2015, the iteration order for object
         * properties is guaranteed to be the insertion order (except for integer keys) but some browsers behave
         * differently when keys are deleted and re-inserted. So `insertBefore` can't be implemented by temporarily
         * deleting properties which is necessary to insert at arbitrary positions.
         *
         * To solve this problem, `insertBefore` doesn't actually insert the given tokens into the target object.
         * Instead, it will create a new object and replace all references to the target object with the new one. This
         * can be done without temporarily deleting properties, so the iteration order is well-defined.
         *
         * However, only references that can be reached from `Prism.languages` or `insert` will be replaced. I.e. if
         * you hold the target object in a variable, then the value of the variable will not change.
         *
         * ```js
         * var oldMarkup = Prism.languages.markup;
         * var newMarkup = Prism.languages.insertBefore('markup', 'comment', { ... });
         *
         * assert(oldMarkup !== Prism.languages.markup);
         * assert(newMarkup === Prism.languages.markup);
         * ```
         *
         * @param {string} inside The property of `root` (e.g. a language id in `Prism.languages`) that contains the
         * object to be modified.
         * @param {string} before The key to insert before.
         * @param {Grammar} insert An object containing the key-value pairs to be inserted.
         * @param {Object<string, any>} [root] The object containing `inside`, i.e. the object that contains the
         * object to be modified.
         *
         * Defaults to `Prism.languages`.
         * @returns {Grammar} The new grammar object.
         * @public
         */
        insertBefore: function(n, t, r, l) {
          l = l || /** @type {any} */
          o.languages;
          var u = l[n], h = {};
          for (var _ in u)
            if (u.hasOwnProperty(_)) {
              if (_ == t)
                for (var m in r)
                  r.hasOwnProperty(m) && (h[m] = r[m]);
              r.hasOwnProperty(_) || (h[_] = u[_]);
            }
          var O = l[n];
          return l[n] = h, o.languages.DFS(o.languages, function(L, F) {
            F === O && L != n && (this[L] = h);
          }), h;
        },
        // Traverse a language definition with Depth First Search
        DFS: function n(t, r, l, u) {
          u = u || {};
          var h = o.util.objId;
          for (var _ in t)
            if (t.hasOwnProperty(_)) {
              r.call(t, _, t[_], l || _);
              var m = t[_], O = o.util.type(m);
              O === "Object" && !u[h(m)] ? (u[h(m)] = !0, n(m, r, null, u)) : O === "Array" && !u[h(m)] && (u[h(m)] = !0, n(m, r, _, u));
            }
        }
      },
      plugins: {},
      /**
       * This is the most high-level function in Prism’s API.
       * It fetches all the elements that have a `.language-xxxx` class and then calls {@link Prism.highlightElement} on
       * each one of them.
       *
       * This is equivalent to `Prism.highlightAllUnder(document, async, callback)`.
       *
       * @param {boolean} [async=false] Same as in {@link Prism.highlightAllUnder}.
       * @param {HighlightCallback} [callback] Same as in {@link Prism.highlightAllUnder}.
       * @memberof Prism
       * @public
       */
      highlightAll: function(n, t) {
        o.highlightAllUnder(document, n, t);
      },
      /**
       * Fetches all the descendants of `container` that have a `.language-xxxx` class and then calls
       * {@link Prism.highlightElement} on each one of them.
       *
       * The following hooks will be run:
       * 1. `before-highlightall`
       * 2. `before-all-elements-highlight`
       * 3. All hooks of {@link Prism.highlightElement} for each element.
       *
       * @param {ParentNode} container The root element, whose descendants that have a `.language-xxxx` class will be highlighted.
       * @param {boolean} [async=false] Whether each element is to be highlighted asynchronously using Web Workers.
       * @param {HighlightCallback} [callback] An optional callback to be invoked on each element after its highlighting is done.
       * @memberof Prism
       * @public
       */
      highlightAllUnder: function(n, t, r) {
        var l = {
          callback: r,
          container: n,
          selector: 'code[class*="language-"], [class*="language-"] code, code[class*="lang-"], [class*="lang-"] code'
        };
        o.hooks.run("before-highlightall", l), l.elements = Array.prototype.slice.apply(l.container.querySelectorAll(l.selector)), o.hooks.run("before-all-elements-highlight", l);
        for (var u = 0, h; h = l.elements[u++]; )
          o.highlightElement(h, t === !0, l.callback);
      },
      /**
       * Highlights the code inside a single element.
       *
       * The following hooks will be run:
       * 1. `before-sanity-check`
       * 2. `before-highlight`
       * 3. All hooks of {@link Prism.highlight}. These hooks will be run by an asynchronous worker if `async` is `true`.
       * 4. `before-insert`
       * 5. `after-highlight`
       * 6. `complete`
       *
       * Some the above hooks will be skipped if the element doesn't contain any text or there is no grammar loaded for
       * the element's language.
       *
       * @param {Element} element The element containing the code.
       * It must have a class of `language-xxxx` to be processed, where `xxxx` is a valid language identifier.
       * @param {boolean} [async=false] Whether the element is to be highlighted asynchronously using Web Workers
       * to improve performance and avoid blocking the UI when highlighting very large chunks of code. This option is
       * [disabled by default](https://prismjs.com/faq.html#why-is-asynchronous-highlighting-disabled-by-default).
       *
       * Note: All language definitions required to highlight the code must be included in the main `prism.js` file for
       * asynchronous highlighting to work. You can build your own bundle on the
       * [Download page](https://prismjs.com/download.html).
       * @param {HighlightCallback} [callback] An optional callback to be invoked after the highlighting is done.
       * Mostly useful when `async` is `true`, since in that case, the highlighting is done asynchronously.
       * @memberof Prism
       * @public
       */
      highlightElement: function(n, t, r) {
        var l = o.util.getLanguage(n), u = o.languages[l];
        o.util.setLanguage(n, l);
        var h = n.parentElement;
        h && h.nodeName.toLowerCase() === "pre" && o.util.setLanguage(h, l);
        var _ = n.textContent, m = {
          element: n,
          language: l,
          grammar: u,
          code: _
        };
        function O(F) {
          m.highlightedCode = F, o.hooks.run("before-insert", m), m.element.innerHTML = m.highlightedCode, o.hooks.run("after-highlight", m), o.hooks.run("complete", m), r && r.call(m.element);
        }
        if (o.hooks.run("before-sanity-check", m), h = m.element.parentElement, h && h.nodeName.toLowerCase() === "pre" && !h.hasAttribute("tabindex") && h.setAttribute("tabindex", "0"), !m.code) {
          o.hooks.run("complete", m), r && r.call(m.element);
          return;
        }
        if (o.hooks.run("before-highlight", m), !m.grammar) {
          O(o.util.encode(m.code));
          return;
        }
        if (t && s.Worker) {
          var L = new Worker(o.filename);
          L.onmessage = function(F) {
            O(F.data);
          }, L.postMessage(JSON.stringify({
            language: m.language,
            code: m.code,
            immediateClose: !0
          }));
        } else
          O(o.highlight(m.code, m.grammar, m.language));
      },
      /**
       * Low-level function, only use if you know what you’re doing. It accepts a string of text as input
       * and the language definitions to use, and returns a string with the HTML produced.
       *
       * The following hooks will be run:
       * 1. `before-tokenize`
       * 2. `after-tokenize`
       * 3. `wrap`: On each {@link Token}.
       *
       * @param {string} text A string with the code to be highlighted.
       * @param {Grammar} grammar An object containing the tokens to use.
       *
       * Usually a language definition like `Prism.languages.markup`.
       * @param {string} language The name of the language definition passed to `grammar`.
       * @returns {string} The highlighted HTML.
       * @memberof Prism
       * @public
       * @example
       * Prism.highlight('var foo = true;', Prism.languages.javascript, 'javascript');
       */
      highlight: function(n, t, r) {
        var l = {
          code: n,
          grammar: t,
          language: r
        };
        if (o.hooks.run("before-tokenize", l), !l.grammar)
          throw new Error('The language "' + l.language + '" has no grammar.');
        return l.tokens = o.tokenize(l.code, l.grammar), o.hooks.run("after-tokenize", l), g.stringify(o.util.encode(l.tokens), l.language);
      },
      /**
       * This is the heart of Prism, and the most low-level function you can use. It accepts a string of text as input
       * and the language definitions to use, and returns an array with the tokenized code.
       *
       * When the language definition includes nested tokens, the function is called recursively on each of these tokens.
       *
       * This method could be useful in other contexts as well, as a very crude parser.
       *
       * @param {string} text A string with the code to be highlighted.
       * @param {Grammar} grammar An object containing the tokens to use.
       *
       * Usually a language definition like `Prism.languages.markup`.
       * @returns {TokenStream} An array of strings and tokens, a token stream.
       * @memberof Prism
       * @public
       * @example
       * let code = `var foo = 0;`;
       * let tokens = Prism.tokenize(code, Prism.languages.javascript);
       * tokens.forEach(token => {
       *     if (token instanceof Prism.Token && token.type === 'number') {
       *         console.log(`Found numeric literal: ${token.content}`);
       *     }
       * });
       */
      tokenize: function(n, t) {
        var r = t.rest;
        if (r) {
          for (var l in r)
            t[l] = r[l];
          delete t.rest;
        }
        var u = new d();
        return S(u, u.head, n), b(n, u, t, u.head, 0), A(u);
      },
      /**
       * @namespace
       * @memberof Prism
       * @public
       */
      hooks: {
        all: {},
        /**
         * Adds the given callback to the list of callbacks for the given hook.
         *
         * The callback will be invoked when the hook it is registered for is run.
         * Hooks are usually directly run by a highlight function but you can also run hooks yourself.
         *
         * One callback function can be registered to multiple hooks and the same hook multiple times.
         *
         * @param {string} name The name of the hook.
         * @param {HookCallback} callback The callback function which is given environment variables.
         * @public
         */
        add: function(n, t) {
          var r = o.hooks.all;
          r[n] = r[n] || [], r[n].push(t);
        },
        /**
         * Runs a hook invoking all registered callbacks with the given environment variables.
         *
         * Callbacks will be invoked synchronously and in the order in which they were registered.
         *
         * @param {string} name The name of the hook.
         * @param {Object<string, any>} env The environment variables of the hook passed to all callbacks registered.
         * @public
         */
        run: function(n, t) {
          var r = o.hooks.all[n];
          if (!(!r || !r.length))
            for (var l = 0, u; u = r[l++]; )
              u(t);
        }
      },
      Token: g
    };
    s.Prism = o;
    function g(n, t, r, l) {
      this.type = n, this.content = t, this.alias = r, this.length = (l || "").length | 0;
    }
    g.stringify = function n(t, r) {
      if (typeof t == "string")
        return t;
      if (Array.isArray(t)) {
        var l = "";
        return t.forEach(function(O) {
          l += n(O, r);
        }), l;
      }
      var u = {
        type: t.type,
        content: n(t.content, r),
        tag: "span",
        classes: ["token", t.type],
        attributes: {},
        language: r
      }, h = t.alias;
      h && (Array.isArray(h) ? Array.prototype.push.apply(u.classes, h) : u.classes.push(h)), o.hooks.run("wrap", u);
      var _ = "";
      for (var m in u.attributes)
        _ += " " + m + '="' + (u.attributes[m] || "").replace(/"/g, "&quot;") + '"';
      return "<" + u.tag + ' class="' + u.classes.join(" ") + '"' + _ + ">" + u.content + "</" + u.tag + ">";
    };
    function y(n, t, r, l) {
      n.lastIndex = t;
      var u = n.exec(r);
      if (u && l && u[1]) {
        var h = u[1].length;
        u.index += h, u[0] = u[0].slice(h);
      }
      return u;
    }
    function b(n, t, r, l, u, h) {
      for (var _ in r)
        if (!(!r.hasOwnProperty(_) || !r[_])) {
          var m = r[_];
          m = Array.isArray(m) ? m : [m];
          for (var O = 0; O < m.length; ++O) {
            if (h && h.cause == _ + "," + O)
              return;
            var L = m[O], F = L.inside, M = !!L.lookbehind, B = !!L.greedy, W = L.alias;
            if (B && !L.pattern.global) {
              var z = L.pattern.toString().match(/[imsuy]*$/)[0];
              L.pattern = RegExp(L.pattern.source, z + "g");
            }
            for (var H = L.pattern || L, C = l.next, x = u; C !== t.tail && !(h && x >= h.reach); x += C.value.length, C = C.next) {
              var p = C.value;
              if (t.length > n.length)
                return;
              if (!(p instanceof g)) {
                var c = 1, k;
                if (B) {
                  if (k = y(H, x, n, M), !k || k.index >= n.length)
                    break;
                  var j = k.index, G = k.index + k[0].length, P = x;
                  for (P += C.value.length; j >= P; )
                    C = C.next, P += C.value.length;
                  if (P -= C.value.length, x = P, C.value instanceof g)
                    continue;
                  for (var U = C; U !== t.tail && (P < G || typeof U.value == "string"); U = U.next)
                    c++, P += U.value.length;
                  c--, p = n.slice(x, P), k.index -= x;
                } else if (k = y(H, 0, p, M), !k)
                  continue;
                var j = k.index, $ = k[0], Z = p.slice(0, j), ee = p.slice(j + $.length), Y = x + p.length;
                h && Y > h.reach && (h.reach = Y);
                var X = C.prev;
                Z && (X = S(t, X, Z), x += Z.length), v(t, X, c);
                var le = new g(_, F ? o.tokenize($, F) : $, W, $);
                if (C = S(t, X, le), ee && S(t, C, ee), c > 1) {
                  var K = {
                    cause: _ + "," + O,
                    reach: Y
                  };
                  b(n, t, r, C.prev, x, K), h && K.reach > h.reach && (h.reach = K.reach);
                }
              }
            }
          }
        }
    }
    function d() {
      var n = { value: null, prev: null, next: null }, t = { value: null, prev: n, next: null };
      n.next = t, this.head = n, this.tail = t, this.length = 0;
    }
    function S(n, t, r) {
      var l = t.next, u = { value: r, prev: t, next: l };
      return t.next = u, l.prev = u, n.length++, u;
    }
    function v(n, t, r) {
      for (var l = t.next, u = 0; u < r && l !== n.tail; u++)
        l = l.next;
      t.next = l, l.prev = t, n.length -= u;
    }
    function A(n) {
      for (var t = [], r = n.head.next; r !== n.tail; )
        t.push(r.value), r = r.next;
      return t;
    }
    if (!s.document)
      return s.addEventListener && (o.disableWorkerMessageHandler || s.addEventListener("message", function(n) {
        var t = JSON.parse(n.data), r = t.language, l = t.code, u = t.immediateClose;
        s.postMessage(o.highlight(l, o.languages[r], r)), u && s.close();
      }, !1)), o;
    var T = o.util.currentScript();
    T && (o.filename = T.src, T.hasAttribute("data-manual") && (o.manual = !0));
    function N() {
      o.manual || o.highlightAll();
    }
    if (!o.manual) {
      var R = document.readyState;
      R === "loading" || R === "interactive" && T && T.defer ? document.addEventListener("DOMContentLoaded", N) : window.requestAnimationFrame ? window.requestAnimationFrame(N) : window.setTimeout(N, 16);
    }
    return o;
  }(i);
  e.exports && (e.exports = a), typeof ne < "u" && (ne.Prism = a);
})(oe);
var me = oe.exports;
const ye = /* @__PURE__ */ he(me);
Prism.languages.markup = {
  comment: {
    pattern: /<!--(?:(?!<!--)[\s\S])*?-->/,
    greedy: !0
  },
  prolog: {
    pattern: /<\?[\s\S]+?\?>/,
    greedy: !0
  },
  doctype: {
    // https://www.w3.org/TR/xml/#NT-doctypedecl
    pattern: /<!DOCTYPE(?:[^>"'[\]]|"[^"]*"|'[^']*')+(?:\[(?:[^<"'\]]|"[^"]*"|'[^']*'|<(?!!--)|<!--(?:[^-]|-(?!->))*-->)*\]\s*)?>/i,
    greedy: !0,
    inside: {
      "internal-subset": {
        pattern: /(^[^\[]*\[)[\s\S]+(?=\]>$)/,
        lookbehind: !0,
        greedy: !0,
        inside: null
        // see below
      },
      string: {
        pattern: /"[^"]*"|'[^']*'/,
        greedy: !0
      },
      punctuation: /^<!|>$|[[\]]/,
      "doctype-tag": /^DOCTYPE/i,
      name: /[^\s<>'"]+/
    }
  },
  cdata: {
    pattern: /<!\[CDATA\[[\s\S]*?\]\]>/i,
    greedy: !0
  },
  tag: {
    pattern: /<\/?(?!\d)[^\s>\/=$<%]+(?:\s(?:\s*[^\s>\/=]+(?:\s*=\s*(?:"[^"]*"|'[^']*'|[^\s'">=]+(?=[\s>]))|(?=[\s/>])))+)?\s*\/?>/,
    greedy: !0,
    inside: {
      tag: {
        pattern: /^<\/?[^\s>\/]+/,
        inside: {
          punctuation: /^<\/?/,
          namespace: /^[^\s>\/:]+:/
        }
      },
      "special-attr": [],
      "attr-value": {
        pattern: /=\s*(?:"[^"]*"|'[^']*'|[^\s'">=]+)/,
        inside: {
          punctuation: [
            {
              pattern: /^=/,
              alias: "attr-equals"
            },
            {
              pattern: /^(\s*)["']|["']$/,
              lookbehind: !0
            }
          ]
        }
      },
      punctuation: /\/?>/,
      "attr-name": {
        pattern: /[^\s>\/]+/,
        inside: {
          namespace: /^[^\s>\/:]+:/
        }
      }
    }
  },
  entity: [
    {
      pattern: /&[\da-z]{1,8};/i,
      alias: "named-entity"
    },
    /&#x?[\da-f]{1,8};/i
  ]
};
Prism.languages.markup.tag.inside["attr-value"].inside.entity = Prism.languages.markup.entity;
Prism.languages.markup.doctype.inside["internal-subset"].inside = Prism.languages.markup;
Prism.hooks.add("wrap", function(e) {
  e.type === "entity" && (e.attributes.title = e.content.replace(/&amp;/, "&"));
});
Object.defineProperty(Prism.languages.markup.tag, "addInlined", {
  /**
   * Adds an inlined language to markup.
   *
   * An example of an inlined language is CSS with `<style>` tags.
   *
   * @param {string} tagName The name of the tag that contains the inlined language. This name will be treated as
   * case insensitive.
   * @param {string} lang The language key.
   * @example
   * addInlined('style', 'css');
   */
  value: function(i, a) {
    var s = {};
    s["language-" + a] = {
      pattern: /(^<!\[CDATA\[)[\s\S]+?(?=\]\]>$)/i,
      lookbehind: !0,
      inside: Prism.languages[a]
    }, s.cdata = /^<!\[CDATA\[|\]\]>$/i;
    var f = {
      "included-cdata": {
        pattern: /<!\[CDATA\[[\s\S]*?\]\]>/i,
        inside: s
      }
    };
    f["language-" + a] = {
      pattern: /[\s\S]+/,
      inside: Prism.languages[a]
    };
    var E = {};
    E[i] = {
      pattern: RegExp(/(<__[^>]*>)(?:<!\[CDATA\[(?:[^\]]|\](?!\]>))*\]\]>|(?!<!\[CDATA\[)[\s\S])*?(?=<\/__>)/.source.replace(/__/g, function() {
        return i;
      }), "i"),
      lookbehind: !0,
      greedy: !0,
      inside: f
    }, Prism.languages.insertBefore("markup", "cdata", E);
  }
});
Object.defineProperty(Prism.languages.markup.tag, "addAttribute", {
  /**
   * Adds an pattern to highlight languages embedded in HTML attributes.
   *
   * An example of an inlined language is CSS with `style` attributes.
   *
   * @param {string} attrName The name of the tag that contains the inlined language. This name will be treated as
   * case insensitive.
   * @param {string} lang The language key.
   * @example
   * addAttribute('style', 'css');
   */
  value: function(e, i) {
    Prism.languages.markup.tag.inside["special-attr"].push({
      pattern: RegExp(
        /(^|["'\s])/.source + "(?:" + e + ")" + /\s*=\s*(?:"[^"]*"|'[^']*'|[^\s'">=]+(?=[\s>]))/.source,
        "i"
      ),
      lookbehind: !0,
      inside: {
        "attr-name": /^[^\s=]+/,
        "attr-value": {
          pattern: /=[\s\S]+/,
          inside: {
            value: {
              pattern: /(^=\s*(["']|(?!["'])))\S[\s\S]*(?=\2$)/,
              lookbehind: !0,
              alias: [i, "language-" + i],
              inside: Prism.languages[i]
            },
            punctuation: [
              {
                pattern: /^=/,
                alias: "attr-equals"
              },
              /"|'/
            ]
          }
        }
      }
    });
  }
});
Prism.languages.html = Prism.languages.markup;
Prism.languages.mathml = Prism.languages.markup;
Prism.languages.svg = Prism.languages.markup;
Prism.languages.xml = Prism.languages.extend("markup", {});
Prism.languages.ssml = Prism.languages.xml;
Prism.languages.atom = Prism.languages.xml;
Prism.languages.rss = Prism.languages.xml;
(function(e) {
  var i = /(?:"(?:\\(?:\r\n|[\s\S])|[^"\\\r\n])*"|'(?:\\(?:\r\n|[\s\S])|[^'\\\r\n])*')/;
  e.languages.css = {
    comment: /\/\*[\s\S]*?\*\//,
    atrule: {
      pattern: RegExp("@[\\w-](?:" + /[^;{\s"']|\s+(?!\s)/.source + "|" + i.source + ")*?" + /(?:;|(?=\s*\{))/.source),
      inside: {
        rule: /^@[\w-]+/,
        "selector-function-argument": {
          pattern: /(\bselector\s*\(\s*(?![\s)]))(?:[^()\s]|\s+(?![\s)])|\((?:[^()]|\([^()]*\))*\))+(?=\s*\))/,
          lookbehind: !0,
          alias: "selector"
        },
        keyword: {
          pattern: /(^|[^\w-])(?:and|not|only|or)(?![\w-])/,
          lookbehind: !0
        }
        // See rest below
      }
    },
    url: {
      // https://drafts.csswg.org/css-values-3/#urls
      pattern: RegExp("\\burl\\((?:" + i.source + "|" + /(?:[^\\\r\n()"']|\\[\s\S])*/.source + ")\\)", "i"),
      greedy: !0,
      inside: {
        function: /^url/i,
        punctuation: /^\(|\)$/,
        string: {
          pattern: RegExp("^" + i.source + "$"),
          alias: "url"
        }
      }
    },
    selector: {
      pattern: RegExp("(^|[{}\\s])[^{}\\s](?:[^{};\"'\\s]|\\s+(?![\\s{])|" + i.source + ")*(?=\\s*\\{)"),
      lookbehind: !0
    },
    string: {
      pattern: i,
      greedy: !0
    },
    property: {
      pattern: /(^|[^-\w\xA0-\uFFFF])(?!\s)[-_a-z\xA0-\uFFFF](?:(?!\s)[-\w\xA0-\uFFFF])*(?=\s*:)/i,
      lookbehind: !0
    },
    important: /!important\b/i,
    function: {
      pattern: /(^|[^-a-z0-9])[-a-z0-9]+(?=\()/i,
      lookbehind: !0
    },
    punctuation: /[(){};:,]/
  }, e.languages.css.atrule.inside.rest = e.languages.css;
  var a = e.languages.markup;
  a && (a.tag.addInlined("style", "css"), a.tag.addAttribute("style", "css"));
})(Prism);
Prism.languages.clike = {
  comment: [
    {
      pattern: /(^|[^\\])\/\*[\s\S]*?(?:\*\/|$)/,
      lookbehind: !0,
      greedy: !0
    },
    {
      pattern: /(^|[^\\:])\/\/.*/,
      lookbehind: !0,
      greedy: !0
    }
  ],
  string: {
    pattern: /(["'])(?:\\(?:\r\n|[\s\S])|(?!\1)[^\\\r\n])*\1/,
    greedy: !0
  },
  "class-name": {
    pattern: /(\b(?:class|extends|implements|instanceof|interface|new|trait)\s+|\bcatch\s+\()[\w.\\]+/i,
    lookbehind: !0,
    inside: {
      punctuation: /[.\\]/
    }
  },
  keyword: /\b(?:break|catch|continue|do|else|finally|for|function|if|in|instanceof|new|null|return|throw|try|while)\b/,
  boolean: /\b(?:false|true)\b/,
  function: /\b\w+(?=\()/,
  number: /\b0x[\da-f]+\b|(?:\b\d+(?:\.\d*)?|\B\.\d+)(?:e[+-]?\d+)?/i,
  operator: /[<>]=?|[!=]=?=?|--?|\+\+?|&&?|\|\|?|[?*/~^%]/,
  punctuation: /[{}[\];(),.:]/
};
Prism.languages.javascript = Prism.languages.extend("clike", {
  "class-name": [
    Prism.languages.clike["class-name"],
    {
      pattern: /(^|[^$\w\xA0-\uFFFF])(?!\s)[_$A-Z\xA0-\uFFFF](?:(?!\s)[$\w\xA0-\uFFFF])*(?=\.(?:constructor|prototype))/,
      lookbehind: !0
    }
  ],
  keyword: [
    {
      pattern: /((?:^|\})\s*)catch\b/,
      lookbehind: !0
    },
    {
      pattern: /(^|[^.]|\.\.\.\s*)\b(?:as|assert(?=\s*\{)|async(?=\s*(?:function\b|\(|[$\w\xA0-\uFFFF]|$))|await|break|case|class|const|continue|debugger|default|delete|do|else|enum|export|extends|finally(?=\s*(?:\{|$))|for|from(?=\s*(?:['"]|$))|function|(?:get|set)(?=\s*(?:[#\[$\w\xA0-\uFFFF]|$))|if|implements|import|in|instanceof|interface|let|new|null|of|package|private|protected|public|return|static|super|switch|this|throw|try|typeof|undefined|var|void|while|with|yield)\b/,
      lookbehind: !0
    }
  ],
  // Allow for all non-ASCII characters (See http://stackoverflow.com/a/2008444)
  function: /#?(?!\s)[_$a-zA-Z\xA0-\uFFFF](?:(?!\s)[$\w\xA0-\uFFFF])*(?=\s*(?:\.\s*(?:apply|bind|call)\s*)?\()/,
  number: {
    pattern: RegExp(
      /(^|[^\w$])/.source + "(?:" + // constant
      (/NaN|Infinity/.source + "|" + // binary integer
      /0[bB][01]+(?:_[01]+)*n?/.source + "|" + // octal integer
      /0[oO][0-7]+(?:_[0-7]+)*n?/.source + "|" + // hexadecimal integer
      /0[xX][\dA-Fa-f]+(?:_[\dA-Fa-f]+)*n?/.source + "|" + // decimal bigint
      /\d+(?:_\d+)*n/.source + "|" + // decimal number (integer or float) but no bigint
      /(?:\d+(?:_\d+)*(?:\.(?:\d+(?:_\d+)*)?)?|\.\d+(?:_\d+)*)(?:[Ee][+-]?\d+(?:_\d+)*)?/.source) + ")" + /(?![\w$])/.source
    ),
    lookbehind: !0
  },
  operator: /--|\+\+|\*\*=?|=>|&&=?|\|\|=?|[!=]==|<<=?|>>>?=?|[-+*/%&|^!=<>]=?|\.{3}|\?\?=?|\?\.?|[~:]/
});
Prism.languages.javascript["class-name"][0].pattern = /(\b(?:class|extends|implements|instanceof|interface|new)\s+)[\w.\\]+/;
Prism.languages.insertBefore("javascript", "keyword", {
  regex: {
    pattern: RegExp(
      // lookbehind
      // eslint-disable-next-line regexp/no-dupe-characters-character-class
      /((?:^|[^$\w\xA0-\uFFFF."'\])\s]|\b(?:return|yield))\s*)/.source + // Regex pattern:
      // There are 2 regex patterns here. The RegExp set notation proposal added support for nested character
      // classes if the `v` flag is present. Unfortunately, nested CCs are both context-free and incompatible
      // with the only syntax, so we have to define 2 different regex patterns.
      /\//.source + "(?:" + /(?:\[(?:[^\]\\\r\n]|\\.)*\]|\\.|[^/\\\[\r\n])+\/[dgimyus]{0,7}/.source + "|" + // `v` flag syntax. This supports 3 levels of nested character classes.
      /(?:\[(?:[^[\]\\\r\n]|\\.|\[(?:[^[\]\\\r\n]|\\.|\[(?:[^[\]\\\r\n]|\\.)*\])*\])*\]|\\.|[^/\\\[\r\n])+\/[dgimyus]{0,7}v[dgimyus]{0,7}/.source + ")" + // lookahead
      /(?=(?:\s|\/\*(?:[^*]|\*(?!\/))*\*\/)*(?:$|[\r\n,.;:})\]]|\/\/))/.source
    ),
    lookbehind: !0,
    greedy: !0,
    inside: {
      "regex-source": {
        pattern: /^(\/)[\s\S]+(?=\/[a-z]*$)/,
        lookbehind: !0,
        alias: "language-regex",
        inside: Prism.languages.regex
      },
      "regex-delimiter": /^\/|\/$/,
      "regex-flags": /^[a-z]+$/
    }
  },
  // This must be declared before keyword because we use "function" inside the look-forward
  "function-variable": {
    pattern: /#?(?!\s)[_$a-zA-Z\xA0-\uFFFF](?:(?!\s)[$\w\xA0-\uFFFF])*(?=\s*[=:]\s*(?:async\s*)?(?:\bfunction\b|(?:\((?:[^()]|\([^()]*\))*\)|(?!\s)[_$a-zA-Z\xA0-\uFFFF](?:(?!\s)[$\w\xA0-\uFFFF])*)\s*=>))/,
    alias: "function"
  },
  parameter: [
    {
      pattern: /(function(?:\s+(?!\s)[_$a-zA-Z\xA0-\uFFFF](?:(?!\s)[$\w\xA0-\uFFFF])*)?\s*\(\s*)(?!\s)(?:[^()\s]|\s+(?![\s)])|\([^()]*\))+(?=\s*\))/,
      lookbehind: !0,
      inside: Prism.languages.javascript
    },
    {
      pattern: /(^|[^$\w\xA0-\uFFFF])(?!\s)[_$a-z\xA0-\uFFFF](?:(?!\s)[$\w\xA0-\uFFFF])*(?=\s*=>)/i,
      lookbehind: !0,
      inside: Prism.languages.javascript
    },
    {
      pattern: /(\(\s*)(?!\s)(?:[^()\s]|\s+(?![\s)])|\([^()]*\))+(?=\s*\)\s*=>)/,
      lookbehind: !0,
      inside: Prism.languages.javascript
    },
    {
      pattern: /((?:\b|\s|^)(?!(?:as|async|await|break|case|catch|class|const|continue|debugger|default|delete|do|else|enum|export|extends|finally|for|from|function|get|if|implements|import|in|instanceof|interface|let|new|null|of|package|private|protected|public|return|set|static|super|switch|this|throw|try|typeof|undefined|var|void|while|with|yield)(?![$\w\xA0-\uFFFF]))(?:(?!\s)[_$a-zA-Z\xA0-\uFFFF](?:(?!\s)[$\w\xA0-\uFFFF])*\s*)\(\s*|\]\s*\(\s*)(?!\s)(?:[^()\s]|\s+(?![\s)])|\([^()]*\))+(?=\s*\)\s*\{)/,
      lookbehind: !0,
      inside: Prism.languages.javascript
    }
  ],
  constant: /\b[A-Z](?:[A-Z_]|\dx?)*\b/
});
Prism.languages.insertBefore("javascript", "string", {
  hashbang: {
    pattern: /^#!.*/,
    greedy: !0,
    alias: "comment"
  },
  "template-string": {
    pattern: /`(?:\\[\s\S]|\$\{(?:[^{}]|\{(?:[^{}]|\{[^}]*\})*\})+\}|(?!\$\{)[^\\`])*`/,
    greedy: !0,
    inside: {
      "template-punctuation": {
        pattern: /^`|`$/,
        alias: "string"
      },
      interpolation: {
        pattern: /((?:^|[^\\])(?:\\{2})*)\$\{(?:[^{}]|\{(?:[^{}]|\{[^}]*\})*\})+\}/,
        lookbehind: !0,
        inside: {
          "interpolation-punctuation": {
            pattern: /^\$\{|\}$/,
            alias: "punctuation"
          },
          rest: Prism.languages.javascript
        }
      },
      string: /[\s\S]+/
    }
  },
  "string-property": {
    pattern: /((?:^|[,{])[ \t]*)(["'])(?:\\(?:\r\n|[\s\S])|(?!\2)[^\\\r\n])*\2(?=\s*:)/m,
    lookbehind: !0,
    greedy: !0,
    alias: "property"
  }
});
Prism.languages.insertBefore("javascript", "operator", {
  "literal-property": {
    pattern: /((?:^|[,{])[ \t]*)(?!\s)[_$a-zA-Z\xA0-\uFFFF](?:(?!\s)[$\w\xA0-\uFFFF])*(?=\s*:)/m,
    lookbehind: !0,
    alias: "property"
  }
});
Prism.languages.markup && (Prism.languages.markup.tag.addInlined("script", "javascript"), Prism.languages.markup.tag.addAttribute(
  /on(?:abort|blur|change|click|composition(?:end|start|update)|dblclick|error|focus(?:in|out)?|key(?:down|up)|load|mouse(?:down|enter|leave|move|out|over|up)|reset|resize|scroll|select|slotchange|submit|unload|wheel)/.source,
  "javascript"
));
Prism.languages.js = Prism.languages.javascript;
(function(e) {
  var i = /(?:\\.|[^\\\n\r]|(?:\n|\r\n?)(?![\r\n]))/.source;
  function a(b) {
    return b = b.replace(/<inner>/g, function() {
      return i;
    }), RegExp(/((?:^|[^\\])(?:\\{2})*)/.source + "(?:" + b + ")");
  }
  var s = /(?:\\.|``(?:[^`\r\n]|`(?!`))+``|`[^`\r\n]+`|[^\\|\r\n`])+/.source, f = /\|?__(?:\|__)+\|?(?:(?:\n|\r\n?)|(?![\s\S]))/.source.replace(/__/g, function() {
    return s;
  }), E = /\|?[ \t]*:?-{3,}:?[ \t]*(?:\|[ \t]*:?-{3,}:?[ \t]*)+\|?(?:\n|\r\n?)/.source;
  e.languages.markdown = e.languages.extend("markup", {}), e.languages.insertBefore("markdown", "prolog", {
    "front-matter-block": {
      pattern: /(^(?:\s*[\r\n])?)---(?!.)[\s\S]*?[\r\n]---(?!.)/,
      lookbehind: !0,
      greedy: !0,
      inside: {
        punctuation: /^---|---$/,
        "front-matter": {
          pattern: /\S+(?:\s+\S+)*/,
          alias: ["yaml", "language-yaml"],
          inside: e.languages.yaml
        }
      }
    },
    blockquote: {
      // > ...
      pattern: /^>(?:[\t ]*>)*/m,
      alias: "punctuation"
    },
    table: {
      pattern: RegExp("^" + f + E + "(?:" + f + ")*", "m"),
      inside: {
        "table-data-rows": {
          pattern: RegExp("^(" + f + E + ")(?:" + f + ")*$"),
          lookbehind: !0,
          inside: {
            "table-data": {
              pattern: RegExp(s),
              inside: e.languages.markdown
            },
            punctuation: /\|/
          }
        },
        "table-line": {
          pattern: RegExp("^(" + f + ")" + E + "$"),
          lookbehind: !0,
          inside: {
            punctuation: /\||:?-{3,}:?/
          }
        },
        "table-header-row": {
          pattern: RegExp("^" + f + "$"),
          inside: {
            "table-header": {
              pattern: RegExp(s),
              alias: "important",
              inside: e.languages.markdown
            },
            punctuation: /\|/
          }
        }
      }
    },
    code: [
      {
        // Prefixed by 4 spaces or 1 tab and preceded by an empty line
        pattern: /((?:^|\n)[ \t]*\n|(?:^|\r\n?)[ \t]*\r\n?)(?: {4}|\t).+(?:(?:\n|\r\n?)(?: {4}|\t).+)*/,
        lookbehind: !0,
        alias: "keyword"
      },
      {
        // ```optional language
        // code block
        // ```
        pattern: /^```[\s\S]*?^```$/m,
        greedy: !0,
        inside: {
          "code-block": {
            pattern: /^(```.*(?:\n|\r\n?))[\s\S]+?(?=(?:\n|\r\n?)^```$)/m,
            lookbehind: !0
          },
          "code-language": {
            pattern: /^(```).+/,
            lookbehind: !0
          },
          punctuation: /```/
        }
      }
    ],
    title: [
      {
        // title 1
        // =======
        // title 2
        // -------
        pattern: /\S.*(?:\n|\r\n?)(?:==+|--+)(?=[ \t]*$)/m,
        alias: "important",
        inside: {
          punctuation: /==+$|--+$/
        }
      },
      {
        // # title 1
        // ###### title 6
        pattern: /(^\s*)#.+/m,
        lookbehind: !0,
        alias: "important",
        inside: {
          punctuation: /^#+|#+$/
        }
      }
    ],
    hr: {
      // ***
      // ---
      // * * *
      // -----------
      pattern: /(^\s*)([*-])(?:[\t ]*\2){2,}(?=\s*$)/m,
      lookbehind: !0,
      alias: "punctuation"
    },
    list: {
      // * item
      // + item
      // - item
      // 1. item
      pattern: /(^\s*)(?:[*+-]|\d+\.)(?=[\t ].)/m,
      lookbehind: !0,
      alias: "punctuation"
    },
    "url-reference": {
      // [id]: http://example.com "Optional title"
      // [id]: http://example.com 'Optional title'
      // [id]: http://example.com (Optional title)
      // [id]: <http://example.com> "Optional title"
      pattern: /!?\[[^\]]+\]:[\t ]+(?:\S+|<(?:\\.|[^>\\])+>)(?:[\t ]+(?:"(?:\\.|[^"\\])*"|'(?:\\.|[^'\\])*'|\((?:\\.|[^)\\])*\)))?/,
      inside: {
        variable: {
          pattern: /^(!?\[)[^\]]+/,
          lookbehind: !0
        },
        string: /(?:"(?:\\.|[^"\\])*"|'(?:\\.|[^'\\])*'|\((?:\\.|[^)\\])*\))$/,
        punctuation: /^[\[\]!:]|[<>]/
      },
      alias: "url"
    },
    bold: {
      // **strong**
      // __strong__
      // allow one nested instance of italic text using the same delimiter
      pattern: a(/\b__(?:(?!_)<inner>|_(?:(?!_)<inner>)+_)+__\b|\*\*(?:(?!\*)<inner>|\*(?:(?!\*)<inner>)+\*)+\*\*/.source),
      lookbehind: !0,
      greedy: !0,
      inside: {
        content: {
          pattern: /(^..)[\s\S]+(?=..$)/,
          lookbehind: !0,
          inside: {}
          // see below
        },
        punctuation: /\*\*|__/
      }
    },
    italic: {
      // *em*
      // _em_
      // allow one nested instance of bold text using the same delimiter
      pattern: a(/\b_(?:(?!_)<inner>|__(?:(?!_)<inner>)+__)+_\b|\*(?:(?!\*)<inner>|\*\*(?:(?!\*)<inner>)+\*\*)+\*/.source),
      lookbehind: !0,
      greedy: !0,
      inside: {
        content: {
          pattern: /(^.)[\s\S]+(?=.$)/,
          lookbehind: !0,
          inside: {}
          // see below
        },
        punctuation: /[*_]/
      }
    },
    strike: {
      // ~~strike through~~
      // ~strike~
      // eslint-disable-next-line regexp/strict
      pattern: a(/(~~?)(?:(?!~)<inner>)+\2/.source),
      lookbehind: !0,
      greedy: !0,
      inside: {
        content: {
          pattern: /(^~~?)[\s\S]+(?=\1$)/,
          lookbehind: !0,
          inside: {}
          // see below
        },
        punctuation: /~~?/
      }
    },
    "code-snippet": {
      // `code`
      // ``code``
      pattern: /(^|[^\\`])(?:``[^`\r\n]+(?:`[^`\r\n]+)*``(?!`)|`[^`\r\n]+`(?!`))/,
      lookbehind: !0,
      greedy: !0,
      alias: ["code", "keyword"]
    },
    url: {
      // [example](http://example.com "Optional title")
      // [example][id]
      // [example] [id]
      pattern: a(/!?\[(?:(?!\])<inner>)+\](?:\([^\s)]+(?:[\t ]+"(?:\\.|[^"\\])*")?\)|[ \t]?\[(?:(?!\])<inner>)+\])/.source),
      lookbehind: !0,
      greedy: !0,
      inside: {
        operator: /^!/,
        content: {
          pattern: /(^\[)[^\]]+(?=\])/,
          lookbehind: !0,
          inside: {}
          // see below
        },
        variable: {
          pattern: /(^\][ \t]?\[)[^\]]+(?=\]$)/,
          lookbehind: !0
        },
        url: {
          pattern: /(^\]\()[^\s)]+/,
          lookbehind: !0
        },
        string: {
          pattern: /(^[ \t]+)"(?:\\.|[^"\\])*"(?=\)$)/,
          lookbehind: !0
        }
      }
    }
  }), ["url", "bold", "italic", "strike"].forEach(function(b) {
    ["url", "bold", "italic", "strike", "code-snippet"].forEach(function(d) {
      b !== d && (e.languages.markdown[b].inside.content.inside[d] = e.languages.markdown[d]);
    });
  }), e.hooks.add("after-tokenize", function(b) {
    if (b.language !== "markdown" && b.language !== "md")
      return;
    function d(S) {
      if (!(!S || typeof S == "string"))
        for (var v = 0, A = S.length; v < A; v++) {
          var T = S[v];
          if (T.type !== "code") {
            d(T.content);
            continue;
          }
          var N = T.content[1], R = T.content[3];
          if (N && R && N.type === "code-language" && R.type === "code-block" && typeof N.content == "string") {
            var n = N.content.replace(/\b#/g, "sharp").replace(/\b\+\+/g, "pp");
            n = (/[a-z][\w-]*/i.exec(n) || [""])[0].toLowerCase();
            var t = "language-" + n;
            R.alias ? typeof R.alias == "string" ? R.alias = [R.alias, t] : R.alias.push(t) : R.alias = [t];
          }
        }
    }
    d(b.tokens);
  }), e.hooks.add("wrap", function(b) {
    if (b.type === "code-block") {
      for (var d = "", S = 0, v = b.classes.length; S < v; S++) {
        var A = b.classes[S], T = /language-(.+)/.exec(A);
        if (T) {
          d = T[1];
          break;
        }
      }
      var N = e.languages[d];
      if (N)
        b.content = e.highlight(y(b.content), N, d);
      else if (d && d !== "none" && e.plugins.autoloader) {
        var R = "md-" + (/* @__PURE__ */ new Date()).valueOf() + "-" + Math.floor(Math.random() * 1e16);
        b.attributes.id = R, e.plugins.autoloader.loadLanguages(d, function() {
          var n = document.getElementById(R);
          n && (n.innerHTML = e.highlight(n.textContent, e.languages[d], d));
        });
      }
    }
  });
  var w = RegExp(e.languages.markup.tag.pattern.source, "gi"), o = {
    amp: "&",
    lt: "<",
    gt: ">",
    quot: '"'
  }, g = String.fromCodePoint || String.fromCharCode;
  function y(b) {
    var d = b.replace(w, "");
    return d = d.replace(/&(\w{1,8}|#x?[\da-f]{1,8});/gi, function(S, v) {
      if (v = v.toLowerCase(), v[0] === "#") {
        var A;
        return v[1] === "x" ? A = parseInt(v.slice(2), 16) : A = Number(v.slice(1)), g(A);
      } else {
        var T = o[v];
        return T || S;
      }
    }), d;
  }
  e.languages.md = e.languages.markdown;
})(Prism);
Prism.languages.sql = {
  comment: {
    pattern: /(^|[^\\])(?:\/\*[\s\S]*?\*\/|(?:--|\/\/|#).*)/,
    lookbehind: !0
  },
  variable: [
    {
      pattern: /@(["'`])(?:\\[\s\S]|(?!\1)[^\\])+\1/,
      greedy: !0
    },
    /@[\w.$]+/
  ],
  string: {
    pattern: /(^|[^@\\])("|')(?:\\[\s\S]|(?!\2)[^\\]|\2\2)*\2/,
    greedy: !0,
    lookbehind: !0
  },
  identifier: {
    pattern: /(^|[^@\\])`(?:\\[\s\S]|[^`\\]|``)*`/,
    greedy: !0,
    lookbehind: !0,
    inside: {
      punctuation: /^`|`$/
    }
  },
  function: /\b(?:AVG|COUNT|FIRST|FORMAT|LAST|LCASE|LEN|MAX|MID|MIN|MOD|NOW|ROUND|SUM|UCASE)(?=\s*\()/i,
  // Should we highlight user defined functions too?
  keyword: /\b(?:ACTION|ADD|AFTER|ALGORITHM|ALL|ALTER|ANALYZE|ANY|APPLY|AS|ASC|AUTHORIZATION|AUTO_INCREMENT|BACKUP|BDB|BEGIN|BERKELEYDB|BIGINT|BINARY|BIT|BLOB|BOOL|BOOLEAN|BREAK|BROWSE|BTREE|BULK|BY|CALL|CASCADED?|CASE|CHAIN|CHAR(?:ACTER|SET)?|CHECK(?:POINT)?|CLOSE|CLUSTERED|COALESCE|COLLATE|COLUMNS?|COMMENT|COMMIT(?:TED)?|COMPUTE|CONNECT|CONSISTENT|CONSTRAINT|CONTAINS(?:TABLE)?|CONTINUE|CONVERT|CREATE|CROSS|CURRENT(?:_DATE|_TIME|_TIMESTAMP|_USER)?|CURSOR|CYCLE|DATA(?:BASES?)?|DATE(?:TIME)?|DAY|DBCC|DEALLOCATE|DEC|DECIMAL|DECLARE|DEFAULT|DEFINER|DELAYED|DELETE|DELIMITERS?|DENY|DESC|DESCRIBE|DETERMINISTIC|DISABLE|DISCARD|DISK|DISTINCT|DISTINCTROW|DISTRIBUTED|DO|DOUBLE|DROP|DUMMY|DUMP(?:FILE)?|DUPLICATE|ELSE(?:IF)?|ENABLE|ENCLOSED|END|ENGINE|ENUM|ERRLVL|ERRORS|ESCAPED?|EXCEPT|EXEC(?:UTE)?|EXISTS|EXIT|EXPLAIN|EXTENDED|FETCH|FIELDS|FILE|FILLFACTOR|FIRST|FIXED|FLOAT|FOLLOWING|FOR(?: EACH ROW)?|FORCE|FOREIGN|FREETEXT(?:TABLE)?|FROM|FULL|FUNCTION|GEOMETRY(?:COLLECTION)?|GLOBAL|GOTO|GRANT|GROUP|HANDLER|HASH|HAVING|HOLDLOCK|HOUR|IDENTITY(?:COL|_INSERT)?|IF|IGNORE|IMPORT|INDEX|INFILE|INNER|INNODB|INOUT|INSERT|INT|INTEGER|INTERSECT|INTERVAL|INTO|INVOKER|ISOLATION|ITERATE|JOIN|KEYS?|KILL|LANGUAGE|LAST|LEAVE|LEFT|LEVEL|LIMIT|LINENO|LINES|LINESTRING|LOAD|LOCAL|LOCK|LONG(?:BLOB|TEXT)|LOOP|MATCH(?:ED)?|MEDIUM(?:BLOB|INT|TEXT)|MERGE|MIDDLEINT|MINUTE|MODE|MODIFIES|MODIFY|MONTH|MULTI(?:LINESTRING|POINT|POLYGON)|NATIONAL|NATURAL|NCHAR|NEXT|NO|NONCLUSTERED|NULLIF|NUMERIC|OFF?|OFFSETS?|ON|OPEN(?:DATASOURCE|QUERY|ROWSET)?|OPTIMIZE|OPTION(?:ALLY)?|ORDER|OUT(?:ER|FILE)?|OVER|PARTIAL|PARTITION|PERCENT|PIVOT|PLAN|POINT|POLYGON|PRECEDING|PRECISION|PREPARE|PREV|PRIMARY|PRINT|PRIVILEGES|PROC(?:EDURE)?|PUBLIC|PURGE|QUICK|RAISERROR|READS?|REAL|RECONFIGURE|REFERENCES|RELEASE|RENAME|REPEAT(?:ABLE)?|REPLACE|REPLICATION|REQUIRE|RESIGNAL|RESTORE|RESTRICT|RETURN(?:ING|S)?|REVOKE|RIGHT|ROLLBACK|ROUTINE|ROW(?:COUNT|GUIDCOL|S)?|RTREE|RULE|SAVE(?:POINT)?|SCHEMA|SECOND|SELECT|SERIAL(?:IZABLE)?|SESSION(?:_USER)?|SET(?:USER)?|SHARE|SHOW|SHUTDOWN|SIMPLE|SMALLINT|SNAPSHOT|SOME|SONAME|SQL|START(?:ING)?|STATISTICS|STATUS|STRIPED|SYSTEM_USER|TABLES?|TABLESPACE|TEMP(?:ORARY|TABLE)?|TERMINATED|TEXT(?:SIZE)?|THEN|TIME(?:STAMP)?|TINY(?:BLOB|INT|TEXT)|TOP?|TRAN(?:SACTIONS?)?|TRIGGER|TRUNCATE|TSEQUAL|TYPES?|UNBOUNDED|UNCOMMITTED|UNDEFINED|UNION|UNIQUE|UNLOCK|UNPIVOT|UNSIGNED|UPDATE(?:TEXT)?|USAGE|USE|USER|USING|VALUES?|VAR(?:BINARY|CHAR|CHARACTER|YING)|VIEW|WAITFOR|WARNINGS|WHEN|WHERE|WHILE|WITH(?: ROLLUP|IN)?|WORK|WRITE(?:TEXT)?|YEAR)\b/i,
  boolean: /\b(?:FALSE|NULL|TRUE)\b/i,
  number: /\b0x[\da-f]+\b|\b\d+(?:\.\d*)?|\B\.\d+\b/i,
  operator: /[-+*\/=%^~]|&&?|\|\|?|!=?|<(?:=>?|<|>)?|>[>=]?|\b(?:AND|BETWEEN|DIV|ILIKE|IN|IS|LIKE|NOT|OR|REGEXP|RLIKE|SOUNDS LIKE|XOR)\b/i,
  punctuation: /[;[\]()`,.]/
};
(function(e) {
  e.languages.typescript = e.languages.extend("javascript", {
    "class-name": {
      pattern: /(\b(?:class|extends|implements|instanceof|interface|new|type)\s+)(?!keyof\b)(?!\s)[_$a-zA-Z\xA0-\uFFFF](?:(?!\s)[$\w\xA0-\uFFFF])*(?:\s*<(?:[^<>]|<(?:[^<>]|<[^<>]*>)*>)*>)?/,
      lookbehind: !0,
      greedy: !0,
      inside: null
      // see below
    },
    builtin: /\b(?:Array|Function|Promise|any|boolean|console|never|number|string|symbol|unknown)\b/
  }), e.languages.typescript.keyword.push(
    /\b(?:abstract|declare|is|keyof|readonly|require)\b/,
    // keywords that have to be followed by an identifier
    /\b(?:asserts|infer|interface|module|namespace|type)\b(?=\s*(?:[{_$a-zA-Z\xA0-\uFFFF]|$))/,
    // This is for `import type *, {}`
    /\btype\b(?=\s*(?:[\{*]|$))/
  ), delete e.languages.typescript.parameter, delete e.languages.typescript["literal-property"];
  var i = e.languages.extend("typescript", {});
  delete i["class-name"], e.languages.typescript["class-name"].inside = i, e.languages.insertBefore("typescript", "function", {
    decorator: {
      pattern: /@[$\w\xA0-\uFFFF]+/,
      inside: {
        at: {
          pattern: /^@/,
          alias: "operator"
        },
        function: /^[\s\S]+/
      }
    },
    "generic-function": {
      // e.g. foo<T extends "bar" | "baz">( ...
      pattern: /#?(?!\s)[_$a-zA-Z\xA0-\uFFFF](?:(?!\s)[$\w\xA0-\uFFFF])*\s*<(?:[^<>]|<(?:[^<>]|<[^<>]*>)*>)*>(?=\s*\()/,
      greedy: !0,
      inside: {
        function: /^#?(?!\s)[_$a-zA-Z\xA0-\uFFFF](?:(?!\s)[$\w\xA0-\uFFFF])*/,
        generic: {
          pattern: /<[\s\S]+/,
          // everything after the first <
          alias: "class-name",
          inside: i
        }
      }
    }
  }), e.languages.ts = e.languages.typescript;
})(Prism);
(function(e) {
  var i = /\b(?:abstract|assert|boolean|break|byte|case|catch|char|class|const|continue|default|do|double|else|enum|exports|extends|final|finally|float|for|goto|if|implements|import|instanceof|int|interface|long|module|native|new|non-sealed|null|open|opens|package|permits|private|protected|provides|public|record(?!\s*[(){}[\]<>=%~.:,;?+\-*/&|^])|requires|return|sealed|short|static|strictfp|super|switch|synchronized|this|throw|throws|to|transient|transitive|try|uses|var|void|volatile|while|with|yield)\b/, a = /(?:[a-z]\w*\s*\.\s*)*(?:[A-Z]\w*\s*\.\s*)*/.source, s = {
    pattern: RegExp(/(^|[^\w.])/.source + a + /[A-Z](?:[\d_A-Z]*[a-z]\w*)?\b/.source),
    lookbehind: !0,
    inside: {
      namespace: {
        pattern: /^[a-z]\w*(?:\s*\.\s*[a-z]\w*)*(?:\s*\.)?/,
        inside: {
          punctuation: /\./
        }
      },
      punctuation: /\./
    }
  };
  e.languages.java = e.languages.extend("clike", {
    string: {
      pattern: /(^|[^\\])"(?:\\.|[^"\\\r\n])*"/,
      lookbehind: !0,
      greedy: !0
    },
    "class-name": [
      s,
      {
        // variables, parameters, and constructor references
        // this to support class names (or generic parameters) which do not contain a lower case letter (also works for methods)
        pattern: RegExp(/(^|[^\w.])/.source + a + /[A-Z]\w*(?=\s+\w+\s*[;,=()]|\s*(?:\[[\s,]*\]\s*)?::\s*new\b)/.source),
        lookbehind: !0,
        inside: s.inside
      },
      {
        // class names based on keyword
        // this to support class names (or generic parameters) which do not contain a lower case letter (also works for methods)
        pattern: RegExp(/(\b(?:class|enum|extends|implements|instanceof|interface|new|record|throws)\s+)/.source + a + /[A-Z]\w*\b/.source),
        lookbehind: !0,
        inside: s.inside
      }
    ],
    keyword: i,
    function: [
      e.languages.clike.function,
      {
        pattern: /(::\s*)[a-z_]\w*/,
        lookbehind: !0
      }
    ],
    number: /\b0b[01][01_]*L?\b|\b0x(?:\.[\da-f_p+-]+|[\da-f_]+(?:\.[\da-f_p+-]+)?)\b|(?:\b\d[\d_]*(?:\.[\d_]*)?|\B\.\d[\d_]*)(?:e[+-]?\d[\d_]*)?[dfl]?/i,
    operator: {
      pattern: /(^|[^.])(?:<<=?|>>>?=?|->|--|\+\+|&&|\|\||::|[?:~]|[-+*/%&|^!=<>]=?)/m,
      lookbehind: !0
    },
    constant: /\b[A-Z][A-Z_\d]+\b/
  }), e.languages.insertBefore("java", "string", {
    "triple-quoted-string": {
      // http://openjdk.java.net/jeps/355#Description
      pattern: /"""[ \t]*[\r\n](?:(?:"|"")?(?:\\.|[^"\\]))*"""/,
      greedy: !0,
      alias: "string"
    },
    char: {
      pattern: /'(?:\\.|[^'\\\r\n]){1,6}'/,
      greedy: !0
    }
  }), e.languages.insertBefore("java", "class-name", {
    annotation: {
      pattern: /(^|[^.])@\w+(?:\s*\.\s*\w+)*/,
      lookbehind: !0,
      alias: "punctuation"
    },
    generics: {
      pattern: /<(?:[\w\s,.?]|&(?!&)|<(?:[\w\s,.?]|&(?!&)|<(?:[\w\s,.?]|&(?!&)|<(?:[\w\s,.?]|&(?!&))*>)*>)*>)*>/,
      inside: {
        "class-name": s,
        keyword: i,
        punctuation: /[<>(),.:]/,
        operator: /[?&|]/
      }
    },
    import: [
      {
        pattern: RegExp(/(\bimport\s+)/.source + a + /(?:[A-Z]\w*|\*)(?=\s*;)/.source),
        lookbehind: !0,
        inside: {
          namespace: s.inside.namespace,
          punctuation: /\./,
          operator: /\*/,
          "class-name": /\w+/
        }
      },
      {
        pattern: RegExp(/(\bimport\s+static\s+)/.source + a + /(?:\w+|\*)(?=\s*;)/.source),
        lookbehind: !0,
        alias: "static",
        inside: {
          namespace: s.inside.namespace,
          static: /\b\w+$/,
          punctuation: /\./,
          operator: /\*/,
          "class-name": /\w+/
        }
      }
    ],
    namespace: {
      pattern: RegExp(
        /(\b(?:exports|import(?:\s+static)?|module|open|opens|package|provides|requires|to|transitive|uses|with)\s+)(?!<keyword>)[a-z]\w*(?:\.[a-z]\w*)*\.?/.source.replace(/<keyword>/g, function() {
          return i.source;
        })
      ),
      lookbehind: !0,
      inside: {
        punctuation: /\./
      }
    }
  });
})(Prism);
(function(e) {
  function i(a, s) {
    return "___" + a.toUpperCase() + s + "___";
  }
  Object.defineProperties(e.languages["markup-templating"] = {}, {
    buildPlaceholders: {
      /**
       * Tokenize all inline templating expressions matching `placeholderPattern`.
       *
       * If `replaceFilter` is provided, only matches of `placeholderPattern` for which `replaceFilter` returns
       * `true` will be replaced.
       *
       * @param {object} env The environment of the `before-tokenize` hook.
       * @param {string} language The language id.
       * @param {RegExp} placeholderPattern The matches of this pattern will be replaced by placeholders.
       * @param {(match: string) => boolean} [replaceFilter]
       */
      value: function(a, s, f, E) {
        if (a.language === s) {
          var w = a.tokenStack = [];
          a.code = a.code.replace(f, function(o) {
            if (typeof E == "function" && !E(o))
              return o;
            for (var g = w.length, y; a.code.indexOf(y = i(s, g)) !== -1; )
              ++g;
            return w[g] = o, y;
          }), a.grammar = e.languages.markup;
        }
      }
    },
    tokenizePlaceholders: {
      /**
       * Replace placeholders with proper tokens after tokenizing.
       *
       * @param {object} env The environment of the `after-tokenize` hook.
       * @param {string} language The language id.
       */
      value: function(a, s) {
        if (a.language !== s || !a.tokenStack)
          return;
        a.grammar = e.languages[s];
        var f = 0, E = Object.keys(a.tokenStack);
        function w(o) {
          for (var g = 0; g < o.length && !(f >= E.length); g++) {
            var y = o[g];
            if (typeof y == "string" || y.content && typeof y.content == "string") {
              var b = E[f], d = a.tokenStack[b], S = typeof y == "string" ? y : y.content, v = i(s, b), A = S.indexOf(v);
              if (A > -1) {
                ++f;
                var T = S.substring(0, A), N = new e.Token(s, e.tokenize(d, a.grammar), "language-" + s, d), R = S.substring(A + v.length), n = [];
                T && n.push.apply(n, w([T])), n.push(N), R && n.push.apply(n, w([R])), typeof y == "string" ? o.splice.apply(o, [g, 1].concat(n)) : y.content = n;
              }
            } else
              y.content && w(y.content);
          }
          return o;
        }
        w(a.tokens);
      }
    }
  });
})(Prism);
(function(e) {
  var i = /\/\*[\s\S]*?\*\/|\/\/.*|#(?!\[).*/, a = [
    {
      pattern: /\b(?:false|true)\b/i,
      alias: "boolean"
    },
    {
      pattern: /(::\s*)\b[a-z_]\w*\b(?!\s*\()/i,
      greedy: !0,
      lookbehind: !0
    },
    {
      pattern: /(\b(?:case|const)\s+)\b[a-z_]\w*(?=\s*[;=])/i,
      greedy: !0,
      lookbehind: !0
    },
    /\b(?:null)\b/i,
    /\b[A-Z_][A-Z0-9_]*\b(?!\s*\()/
  ], s = /\b0b[01]+(?:_[01]+)*\b|\b0o[0-7]+(?:_[0-7]+)*\b|\b0x[\da-f]+(?:_[\da-f]+)*\b|(?:\b\d+(?:_\d+)*\.?(?:\d+(?:_\d+)*)?|\B\.\d+)(?:e[+-]?\d+)?/i, f = /<?=>|\?\?=?|\.{3}|\??->|[!=]=?=?|::|\*\*=?|--|\+\+|&&|\|\||<<|>>|[?~]|[/^|%*&<>.+-]=?/, E = /[{}\[\](),:;]/;
  e.languages.php = {
    delimiter: {
      pattern: /\?>$|^<\?(?:php(?=\s)|=)?/i,
      alias: "important"
    },
    comment: i,
    variable: /\$+(?:\w+\b|(?=\{))/,
    package: {
      pattern: /(namespace\s+|use\s+(?:function\s+)?)(?:\\?\b[a-z_]\w*)+\b(?!\\)/i,
      lookbehind: !0,
      inside: {
        punctuation: /\\/
      }
    },
    "class-name-definition": {
      pattern: /(\b(?:class|enum|interface|trait)\s+)\b[a-z_]\w*(?!\\)\b/i,
      lookbehind: !0,
      alias: "class-name"
    },
    "function-definition": {
      pattern: /(\bfunction\s+)[a-z_]\w*(?=\s*\()/i,
      lookbehind: !0,
      alias: "function"
    },
    keyword: [
      {
        pattern: /(\(\s*)\b(?:array|bool|boolean|float|int|integer|object|string)\b(?=\s*\))/i,
        alias: "type-casting",
        greedy: !0,
        lookbehind: !0
      },
      {
        pattern: /([(,?]\s*)\b(?:array(?!\s*\()|bool|callable|(?:false|null)(?=\s*\|)|float|int|iterable|mixed|object|self|static|string)\b(?=\s*\$)/i,
        alias: "type-hint",
        greedy: !0,
        lookbehind: !0
      },
      {
        pattern: /(\)\s*:\s*(?:\?\s*)?)\b(?:array(?!\s*\()|bool|callable|(?:false|null)(?=\s*\|)|float|int|iterable|mixed|never|object|self|static|string|void)\b/i,
        alias: "return-type",
        greedy: !0,
        lookbehind: !0
      },
      {
        pattern: /\b(?:array(?!\s*\()|bool|float|int|iterable|mixed|object|string|void)\b/i,
        alias: "type-declaration",
        greedy: !0
      },
      {
        pattern: /(\|\s*)(?:false|null)\b|\b(?:false|null)(?=\s*\|)/i,
        alias: "type-declaration",
        greedy: !0,
        lookbehind: !0
      },
      {
        pattern: /\b(?:parent|self|static)(?=\s*::)/i,
        alias: "static-context",
        greedy: !0
      },
      {
        // yield from
        pattern: /(\byield\s+)from\b/i,
        lookbehind: !0
      },
      // `class` is always a keyword unlike other keywords
      /\bclass\b/i,
      {
        // https://www.php.net/manual/en/reserved.keywords.php
        //
        // keywords cannot be preceded by "->"
        // the complex lookbehind means `(?<!(?:->|::)\s*)`
        pattern: /((?:^|[^\s>:]|(?:^|[^-])>|(?:^|[^:]):)\s*)\b(?:abstract|and|array|as|break|callable|case|catch|clone|const|continue|declare|default|die|do|echo|else|elseif|empty|enddeclare|endfor|endforeach|endif|endswitch|endwhile|enum|eval|exit|extends|final|finally|fn|for|foreach|function|global|goto|if|implements|include|include_once|instanceof|insteadof|interface|isset|list|match|namespace|never|new|or|parent|print|private|protected|public|readonly|require|require_once|return|self|static|switch|throw|trait|try|unset|use|var|while|xor|yield|__halt_compiler)\b/i,
        lookbehind: !0
      }
    ],
    "argument-name": {
      pattern: /([(,]\s*)\b[a-z_]\w*(?=\s*:(?!:))/i,
      lookbehind: !0
    },
    "class-name": [
      {
        pattern: /(\b(?:extends|implements|instanceof|new(?!\s+self|\s+static))\s+|\bcatch\s*\()\b[a-z_]\w*(?!\\)\b/i,
        greedy: !0,
        lookbehind: !0
      },
      {
        pattern: /(\|\s*)\b[a-z_]\w*(?!\\)\b/i,
        greedy: !0,
        lookbehind: !0
      },
      {
        pattern: /\b[a-z_]\w*(?!\\)\b(?=\s*\|)/i,
        greedy: !0
      },
      {
        pattern: /(\|\s*)(?:\\?\b[a-z_]\w*)+\b/i,
        alias: "class-name-fully-qualified",
        greedy: !0,
        lookbehind: !0,
        inside: {
          punctuation: /\\/
        }
      },
      {
        pattern: /(?:\\?\b[a-z_]\w*)+\b(?=\s*\|)/i,
        alias: "class-name-fully-qualified",
        greedy: !0,
        inside: {
          punctuation: /\\/
        }
      },
      {
        pattern: /(\b(?:extends|implements|instanceof|new(?!\s+self\b|\s+static\b))\s+|\bcatch\s*\()(?:\\?\b[a-z_]\w*)+\b(?!\\)/i,
        alias: "class-name-fully-qualified",
        greedy: !0,
        lookbehind: !0,
        inside: {
          punctuation: /\\/
        }
      },
      {
        pattern: /\b[a-z_]\w*(?=\s*\$)/i,
        alias: "type-declaration",
        greedy: !0
      },
      {
        pattern: /(?:\\?\b[a-z_]\w*)+(?=\s*\$)/i,
        alias: ["class-name-fully-qualified", "type-declaration"],
        greedy: !0,
        inside: {
          punctuation: /\\/
        }
      },
      {
        pattern: /\b[a-z_]\w*(?=\s*::)/i,
        alias: "static-context",
        greedy: !0
      },
      {
        pattern: /(?:\\?\b[a-z_]\w*)+(?=\s*::)/i,
        alias: ["class-name-fully-qualified", "static-context"],
        greedy: !0,
        inside: {
          punctuation: /\\/
        }
      },
      {
        pattern: /([(,?]\s*)[a-z_]\w*(?=\s*\$)/i,
        alias: "type-hint",
        greedy: !0,
        lookbehind: !0
      },
      {
        pattern: /([(,?]\s*)(?:\\?\b[a-z_]\w*)+(?=\s*\$)/i,
        alias: ["class-name-fully-qualified", "type-hint"],
        greedy: !0,
        lookbehind: !0,
        inside: {
          punctuation: /\\/
        }
      },
      {
        pattern: /(\)\s*:\s*(?:\?\s*)?)\b[a-z_]\w*(?!\\)\b/i,
        alias: "return-type",
        greedy: !0,
        lookbehind: !0
      },
      {
        pattern: /(\)\s*:\s*(?:\?\s*)?)(?:\\?\b[a-z_]\w*)+\b(?!\\)/i,
        alias: ["class-name-fully-qualified", "return-type"],
        greedy: !0,
        lookbehind: !0,
        inside: {
          punctuation: /\\/
        }
      }
    ],
    constant: a,
    function: {
      pattern: /(^|[^\\\w])\\?[a-z_](?:[\w\\]*\w)?(?=\s*\()/i,
      lookbehind: !0,
      inside: {
        punctuation: /\\/
      }
    },
    property: {
      pattern: /(->\s*)\w+/,
      lookbehind: !0
    },
    number: s,
    operator: f,
    punctuation: E
  };
  var w = {
    pattern: /\{\$(?:\{(?:\{[^{}]+\}|[^{}]+)\}|[^{}])+\}|(^|[^\\{])\$+(?:\w+(?:\[[^\r\n\[\]]+\]|->\w+)?)/,
    lookbehind: !0,
    inside: e.languages.php
  }, o = [
    {
      pattern: /<<<'([^']+)'[\r\n](?:.*[\r\n])*?\1;/,
      alias: "nowdoc-string",
      greedy: !0,
      inside: {
        delimiter: {
          pattern: /^<<<'[^']+'|[a-z_]\w*;$/i,
          alias: "symbol",
          inside: {
            punctuation: /^<<<'?|[';]$/
          }
        }
      }
    },
    {
      pattern: /<<<(?:"([^"]+)"[\r\n](?:.*[\r\n])*?\1;|([a-z_]\w*)[\r\n](?:.*[\r\n])*?\2;)/i,
      alias: "heredoc-string",
      greedy: !0,
      inside: {
        delimiter: {
          pattern: /^<<<(?:"[^"]+"|[a-z_]\w*)|[a-z_]\w*;$/i,
          alias: "symbol",
          inside: {
            punctuation: /^<<<"?|[";]$/
          }
        },
        interpolation: w
      }
    },
    {
      pattern: /`(?:\\[\s\S]|[^\\`])*`/,
      alias: "backtick-quoted-string",
      greedy: !0
    },
    {
      pattern: /'(?:\\[\s\S]|[^\\'])*'/,
      alias: "single-quoted-string",
      greedy: !0
    },
    {
      pattern: /"(?:\\[\s\S]|[^\\"])*"/,
      alias: "double-quoted-string",
      greedy: !0,
      inside: {
        interpolation: w
      }
    }
  ];
  e.languages.insertBefore("php", "variable", {
    string: o,
    attribute: {
      pattern: /#\[(?:[^"'\/#]|\/(?![*/])|\/\/.*$|#(?!\[).*$|\/\*(?:[^*]|\*(?!\/))*\*\/|"(?:\\[\s\S]|[^\\"])*"|'(?:\\[\s\S]|[^\\'])*')+\](?=\s*[a-z$#])/im,
      greedy: !0,
      inside: {
        "attribute-content": {
          pattern: /^(#\[)[\s\S]+(?=\]$)/,
          lookbehind: !0,
          // inside can appear subset of php
          inside: {
            comment: i,
            string: o,
            "attribute-class-name": [
              {
                pattern: /([^:]|^)\b[a-z_]\w*(?!\\)\b/i,
                alias: "class-name",
                greedy: !0,
                lookbehind: !0
              },
              {
                pattern: /([^:]|^)(?:\\?\b[a-z_]\w*)+/i,
                alias: [
                  "class-name",
                  "class-name-fully-qualified"
                ],
                greedy: !0,
                lookbehind: !0,
                inside: {
                  punctuation: /\\/
                }
              }
            ],
            constant: a,
            number: s,
            operator: f,
            punctuation: E
          }
        },
        delimiter: {
          pattern: /^#\[|\]$/,
          alias: "punctuation"
        }
      }
    }
  }), e.hooks.add("before-tokenize", function(g) {
    if (/<\?/.test(g.code)) {
      var y = /<\?(?:[^"'/#]|\/(?![*/])|("|')(?:\\[\s\S]|(?!\1)[^\\])*\1|(?:\/\/|#(?!\[))(?:[^?\n\r]|\?(?!>))*(?=$|\?>|[\r\n])|#\[|\/\*(?:[^*]|\*(?!\/))*(?:\*\/|$))*?(?:\?>|$)/g;
      e.languages["markup-templating"].buildPlaceholders(g, "php", y);
    }
  }), e.hooks.add("after-tokenize", function(g) {
    e.languages["markup-templating"].tokenizePlaceholders(g, "php");
  });
})(Prism);
(function(e) {
  var i = e.util.clone(e.languages.javascript), a = /(?:\s|\/\/.*(?!.)|\/\*(?:[^*]|\*(?!\/))\*\/)/.source, s = /(?:\{(?:\{(?:\{[^{}]*\}|[^{}])*\}|[^{}])*\})/.source, f = /(?:\{<S>*\.{3}(?:[^{}]|<BRACES>)*\})/.source;
  function E(g, y) {
    return g = g.replace(/<S>/g, function() {
      return a;
    }).replace(/<BRACES>/g, function() {
      return s;
    }).replace(/<SPREAD>/g, function() {
      return f;
    }), RegExp(g, y);
  }
  f = E(f).source, e.languages.jsx = e.languages.extend("markup", i), e.languages.jsx.tag.pattern = E(
    /<\/?(?:[\w.:-]+(?:<S>+(?:[\w.:$-]+(?:=(?:"(?:\\[\s\S]|[^\\"])*"|'(?:\\[\s\S]|[^\\'])*'|[^\s{'"/>=]+|<BRACES>))?|<SPREAD>))*<S>*\/?)?>/.source
  ), e.languages.jsx.tag.inside.tag.pattern = /^<\/?[^\s>\/]*/, e.languages.jsx.tag.inside["attr-value"].pattern = /=(?!\{)(?:"(?:\\[\s\S]|[^\\"])*"|'(?:\\[\s\S]|[^\\'])*'|[^\s'">]+)/, e.languages.jsx.tag.inside.tag.inside["class-name"] = /^[A-Z]\w*(?:\.[A-Z]\w*)*$/, e.languages.jsx.tag.inside.comment = i.comment, e.languages.insertBefore("inside", "attr-name", {
    spread: {
      pattern: E(/<SPREAD>/.source),
      inside: e.languages.jsx
    }
  }, e.languages.jsx.tag), e.languages.insertBefore("inside", "special-attr", {
    script: {
      // Allow for two levels of nesting
      pattern: E(/=<BRACES>/.source),
      alias: "language-javascript",
      inside: {
        "script-punctuation": {
          pattern: /^=(?=\{)/,
          alias: "punctuation"
        },
        rest: e.languages.jsx
      }
    }
  }, e.languages.jsx.tag);
  var w = function(g) {
    return g ? typeof g == "string" ? g : typeof g.content == "string" ? g.content : g.content.map(w).join("") : "";
  }, o = function(g) {
    for (var y = [], b = 0; b < g.length; b++) {
      var d = g[b], S = !1;
      if (typeof d != "string" && (d.type === "tag" && d.content[0] && d.content[0].type === "tag" ? d.content[0].content[0].content === "</" ? y.length > 0 && y[y.length - 1].tagName === w(d.content[0].content[1]) && y.pop() : d.content[d.content.length - 1].content === "/>" || y.push({
        tagName: w(d.content[0].content[1]),
        openedBraces: 0
      }) : y.length > 0 && d.type === "punctuation" && d.content === "{" ? y[y.length - 1].openedBraces++ : y.length > 0 && y[y.length - 1].openedBraces > 0 && d.type === "punctuation" && d.content === "}" ? y[y.length - 1].openedBraces-- : S = !0), (S || typeof d == "string") && y.length > 0 && y[y.length - 1].openedBraces === 0) {
        var v = w(d);
        b < g.length - 1 && (typeof g[b + 1] == "string" || g[b + 1].type === "plain-text") && (v += w(g[b + 1]), g.splice(b + 1, 1)), b > 0 && (typeof g[b - 1] == "string" || g[b - 1].type === "plain-text") && (v = w(g[b - 1]) + v, g.splice(b - 1, 1), b--), g[b] = new e.Token("plain-text", v, null, v);
      }
      d.content && typeof d.content != "string" && o(d.content);
    }
  };
  e.hooks.add("after-tokenize", function(g) {
    g.language !== "jsx" && g.language !== "tsx" || o(g.tokens);
  });
})(Prism);
Prism.languages.go = Prism.languages.extend("clike", {
  string: {
    pattern: /(^|[^\\])"(?:\\.|[^"\\\r\n])*"|`[^`]*`/,
    lookbehind: !0,
    greedy: !0
  },
  keyword: /\b(?:break|case|chan|const|continue|default|defer|else|fallthrough|for|func|go(?:to)?|if|import|interface|map|package|range|return|select|struct|switch|type|var)\b/,
  boolean: /\b(?:_|false|iota|nil|true)\b/,
  number: [
    // binary and octal integers
    /\b0(?:b[01_]+|o[0-7_]+)i?\b/i,
    // hexadecimal integers and floats
    /\b0x(?:[a-f\d_]+(?:\.[a-f\d_]*)?|\.[a-f\d_]+)(?:p[+-]?\d+(?:_\d+)*)?i?(?!\w)/i,
    // decimal integers and floats
    /(?:\b\d[\d_]*(?:\.[\d_]*)?|\B\.\d[\d_]*)(?:e[+-]?[\d_]+)?i?(?!\w)/i
  ],
  operator: /[*\/%^!=]=?|\+[=+]?|-[=-]?|\|[=|]?|&(?:=|&|\^=?)?|>(?:>=?|=)?|<(?:<=?|=|-)?|:=|\.\.\./,
  builtin: /\b(?:append|bool|byte|cap|close|complex|complex(?:64|128)|copy|delete|error|float(?:32|64)|u?int(?:8|16|32|64)?|imag|len|make|new|panic|print(?:ln)?|real|recover|rune|string|uintptr)\b/
});
Prism.languages.insertBefore("go", "string", {
  char: {
    pattern: /'(?:\\.|[^'\\\r\n]){0,10}'/,
    greedy: !0
  }
});
delete Prism.languages.go["class-name"];
Prism.languages.c = Prism.languages.extend("clike", {
  comment: {
    pattern: /\/\/(?:[^\r\n\\]|\\(?:\r\n?|\n|(?![\r\n])))*|\/\*[\s\S]*?(?:\*\/|$)/,
    greedy: !0
  },
  string: {
    // https://en.cppreference.com/w/c/language/string_literal
    pattern: /"(?:\\(?:\r\n|[\s\S])|[^"\\\r\n])*"/,
    greedy: !0
  },
  "class-name": {
    pattern: /(\b(?:enum|struct)\s+(?:__attribute__\s*\(\([\s\S]*?\)\)\s*)?)\w+|\b[a-z]\w*_t\b/,
    lookbehind: !0
  },
  keyword: /\b(?:_Alignas|_Alignof|_Atomic|_Bool|_Complex|_Generic|_Imaginary|_Noreturn|_Static_assert|_Thread_local|__attribute__|asm|auto|break|case|char|const|continue|default|do|double|else|enum|extern|float|for|goto|if|inline|int|long|register|return|short|signed|sizeof|static|struct|switch|typedef|typeof|union|unsigned|void|volatile|while)\b/,
  function: /\b[a-z_]\w*(?=\s*\()/i,
  number: /(?:\b0x(?:[\da-f]+(?:\.[\da-f]*)?|\.[\da-f]+)(?:p[+-]?\d+)?|(?:\b\d+(?:\.\d*)?|\B\.\d+)(?:e[+-]?\d+)?)[ful]{0,4}/i,
  operator: />>=?|<<=?|->|([-+&|:])\1|[?:~]|[-+*/%&|^!=<>]=?/
});
Prism.languages.insertBefore("c", "string", {
  char: {
    // https://en.cppreference.com/w/c/language/character_constant
    pattern: /'(?:\\(?:\r\n|[\s\S])|[^'\\\r\n]){0,32}'/,
    greedy: !0
  }
});
Prism.languages.insertBefore("c", "string", {
  macro: {
    // allow for multiline macro definitions
    // spaces after the # character compile fine with gcc
    pattern: /(^[\t ]*)#\s*[a-z](?:[^\r\n\\/]|\/(?!\*)|\/\*(?:[^*]|\*(?!\/))*\*\/|\\(?:\r\n|[\s\S]))*/im,
    lookbehind: !0,
    greedy: !0,
    alias: "property",
    inside: {
      string: [
        {
          // highlight the path of the include statement as a string
          pattern: /^(#\s*include\s*)<[^>]+>/,
          lookbehind: !0
        },
        Prism.languages.c.string
      ],
      char: Prism.languages.c.char,
      comment: Prism.languages.c.comment,
      "macro-name": [
        {
          pattern: /(^#\s*define\s+)\w+\b(?!\()/i,
          lookbehind: !0
        },
        {
          pattern: /(^#\s*define\s+)\w+\b(?=\()/i,
          lookbehind: !0,
          alias: "function"
        }
      ],
      // highlight macro directives as keywords
      directive: {
        pattern: /^(#\s*)[a-z]+/,
        lookbehind: !0,
        alias: "keyword"
      },
      "directive-hash": /^#/,
      punctuation: /##|\\(?=[\r\n])/,
      expression: {
        pattern: /\S[\s\S]*/,
        inside: Prism.languages.c
      }
    }
  }
});
Prism.languages.insertBefore("c", "function", {
  // highlight predefined macros as constants
  constant: /\b(?:EOF|NULL|SEEK_CUR|SEEK_END|SEEK_SET|__DATE__|__FILE__|__LINE__|__TIMESTAMP__|__TIME__|__func__|stderr|stdin|stdout)\b/
});
delete Prism.languages.c.boolean;
(function(e) {
  var i = /\b(?:alignas|alignof|asm|auto|bool|break|case|catch|char|char16_t|char32_t|char8_t|class|co_await|co_return|co_yield|compl|concept|const|const_cast|consteval|constexpr|constinit|continue|decltype|default|delete|do|double|dynamic_cast|else|enum|explicit|export|extern|final|float|for|friend|goto|if|import|inline|int|int16_t|int32_t|int64_t|int8_t|long|module|mutable|namespace|new|noexcept|nullptr|operator|override|private|protected|public|register|reinterpret_cast|requires|return|short|signed|sizeof|static|static_assert|static_cast|struct|switch|template|this|thread_local|throw|try|typedef|typeid|typename|uint16_t|uint32_t|uint64_t|uint8_t|union|unsigned|using|virtual|void|volatile|wchar_t|while)\b/, a = /\b(?!<keyword>)\w+(?:\s*\.\s*\w+)*\b/.source.replace(/<keyword>/g, function() {
    return i.source;
  });
  e.languages.cpp = e.languages.extend("c", {
    "class-name": [
      {
        pattern: RegExp(/(\b(?:class|concept|enum|struct|typename)\s+)(?!<keyword>)\w+/.source.replace(/<keyword>/g, function() {
          return i.source;
        })),
        lookbehind: !0
      },
      // This is intended to capture the class name of method implementations like:
      //   void foo::bar() const {}
      // However! The `foo` in the above example could also be a namespace, so we only capture the class name if
      // it starts with an uppercase letter. This approximation should give decent results.
      /\b[A-Z]\w*(?=\s*::\s*\w+\s*\()/,
      // This will capture the class name before destructors like:
      //   Foo::~Foo() {}
      /\b[A-Z_]\w*(?=\s*::\s*~\w+\s*\()/i,
      // This also intends to capture the class name of method implementations but here the class has template
      // parameters, so it can't be a namespace (until C++ adds generic namespaces).
      /\b\w+(?=\s*<(?:[^<>]|<(?:[^<>]|<[^<>]*>)*>)*>\s*::\s*\w+\s*\()/
    ],
    keyword: i,
    number: {
      pattern: /(?:\b0b[01']+|\b0x(?:[\da-f']+(?:\.[\da-f']*)?|\.[\da-f']+)(?:p[+-]?[\d']+)?|(?:\b[\d']+(?:\.[\d']*)?|\B\.[\d']+)(?:e[+-]?[\d']+)?)[ful]{0,4}/i,
      greedy: !0
    },
    operator: />>=?|<<=?|->|--|\+\+|&&|\|\||[?:~]|<=>|[-+*/%&|^!=<>]=?|\b(?:and|and_eq|bitand|bitor|not|not_eq|or|or_eq|xor|xor_eq)\b/,
    boolean: /\b(?:false|true)\b/
  }), e.languages.insertBefore("cpp", "string", {
    module: {
      // https://en.cppreference.com/w/cpp/language/modules
      pattern: RegExp(
        /(\b(?:import|module)\s+)/.source + "(?:" + // header-name
        /"(?:\\(?:\r\n|[\s\S])|[^"\\\r\n])*"|<[^<>\r\n]*>/.source + "|" + // module name or partition or both
        /<mod-name>(?:\s*:\s*<mod-name>)?|:\s*<mod-name>/.source.replace(/<mod-name>/g, function() {
          return a;
        }) + ")"
      ),
      lookbehind: !0,
      greedy: !0,
      inside: {
        string: /^[<"][\s\S]+/,
        operator: /:/,
        punctuation: /\./
      }
    },
    "raw-string": {
      pattern: /R"([^()\\ ]{0,16})\([\s\S]*?\)\1"/,
      alias: "string",
      greedy: !0
    }
  }), e.languages.insertBefore("cpp", "keyword", {
    "generic-function": {
      pattern: /\b(?!operator\b)[a-z_]\w*\s*<(?:[^<>]|<[^<>]*>)*>(?=\s*\()/i,
      inside: {
        function: /^\w+/,
        generic: {
          pattern: /<[\s\S]+/,
          alias: "class-name",
          inside: e.languages.cpp
        }
      }
    }
  }), e.languages.insertBefore("cpp", "operator", {
    "double-colon": {
      pattern: /::/,
      alias: "punctuation"
    }
  }), e.languages.insertBefore("cpp", "class-name", {
    // the base clause is an optional list of parent classes
    // https://en.cppreference.com/w/cpp/language/class
    "base-clause": {
      pattern: /(\b(?:class|struct)\s+\w+\s*:\s*)[^;{}"'\s]+(?:\s+[^;{}"'\s]+)*(?=\s*[;{])/,
      lookbehind: !0,
      greedy: !0,
      inside: e.languages.extend("cpp", {})
    }
  }), e.languages.insertBefore("inside", "double-colon", {
    // All untokenized words that are not namespaces should be class names
    "class-name": /\b[a-z_]\w*\b(?!\s*::)/i
  }, e.languages.cpp["base-clause"]);
})(Prism);
(function(e) {
  function i(x, p) {
    return x.replace(/<<(\d+)>>/g, function(c, k) {
      return "(?:" + p[+k] + ")";
    });
  }
  function a(x, p, c) {
    return RegExp(i(x, p), c || "");
  }
  function s(x, p) {
    for (var c = 0; c < p; c++)
      x = x.replace(/<<self>>/g, function() {
        return "(?:" + x + ")";
      });
    return x.replace(/<<self>>/g, "[^\\s\\S]");
  }
  var f = {
    // keywords which represent a return or variable type
    type: "bool byte char decimal double dynamic float int long object sbyte short string uint ulong ushort var void",
    // keywords which are used to declare a type
    typeDeclaration: "class enum interface record struct",
    // contextual keywords
    // ("var" and "dynamic" are missing because they are used like types)
    contextual: "add alias and ascending async await by descending from(?=\\s*(?:\\w|$)) get global group into init(?=\\s*;) join let nameof not notnull on or orderby partial remove select set unmanaged value when where with(?=\\s*{)",
    // all other keywords
    other: "abstract as base break case catch checked const continue default delegate do else event explicit extern finally fixed for foreach goto if implicit in internal is lock namespace new null operator out override params private protected public readonly ref return sealed sizeof stackalloc static switch this throw try typeof unchecked unsafe using virtual volatile while yield"
  };
  function E(x) {
    return "\\b(?:" + x.trim().replace(/ /g, "|") + ")\\b";
  }
  var w = E(f.typeDeclaration), o = RegExp(E(f.type + " " + f.typeDeclaration + " " + f.contextual + " " + f.other)), g = E(f.typeDeclaration + " " + f.contextual + " " + f.other), y = E(f.type + " " + f.typeDeclaration + " " + f.other), b = s(/<(?:[^<>;=+\-*/%&|^]|<<self>>)*>/.source, 2), d = s(/\((?:[^()]|<<self>>)*\)/.source, 2), S = /@?\b[A-Za-z_]\w*\b/.source, v = i(/<<0>>(?:\s*<<1>>)?/.source, [S, b]), A = i(/(?!<<0>>)<<1>>(?:\s*\.\s*<<1>>)*/.source, [g, v]), T = /\[\s*(?:,\s*)*\]/.source, N = i(/<<0>>(?:\s*(?:\?\s*)?<<1>>)*(?:\s*\?)?/.source, [A, T]), R = i(/[^,()<>[\];=+\-*/%&|^]|<<0>>|<<1>>|<<2>>/.source, [b, d, T]), n = i(/\(<<0>>+(?:,<<0>>+)+\)/.source, [R]), t = i(/(?:<<0>>|<<1>>)(?:\s*(?:\?\s*)?<<2>>)*(?:\s*\?)?/.source, [n, A, T]), r = {
    keyword: o,
    punctuation: /[<>()?,.:[\]]/
  }, l = /'(?:[^\r\n'\\]|\\.|\\[Uux][\da-fA-F]{1,8})'/.source, u = /"(?:\\.|[^\\"\r\n])*"/.source, h = /@"(?:""|\\[\s\S]|[^\\"])*"(?!")/.source;
  e.languages.csharp = e.languages.extend("clike", {
    string: [
      {
        pattern: a(/(^|[^$\\])<<0>>/.source, [h]),
        lookbehind: !0,
        greedy: !0
      },
      {
        pattern: a(/(^|[^@$\\])<<0>>/.source, [u]),
        lookbehind: !0,
        greedy: !0
      }
    ],
    "class-name": [
      {
        // Using static
        // using static System.Math;
        pattern: a(/(\busing\s+static\s+)<<0>>(?=\s*;)/.source, [A]),
        lookbehind: !0,
        inside: r
      },
      {
        // Using alias (type)
        // using Project = PC.MyCompany.Project;
        pattern: a(/(\busing\s+<<0>>\s*=\s*)<<1>>(?=\s*;)/.source, [S, t]),
        lookbehind: !0,
        inside: r
      },
      {
        // Using alias (alias)
        // using Project = PC.MyCompany.Project;
        pattern: a(/(\busing\s+)<<0>>(?=\s*=)/.source, [S]),
        lookbehind: !0
      },
      {
        // Type declarations
        // class Foo<A, B>
        // interface Foo<out A, B>
        pattern: a(/(\b<<0>>\s+)<<1>>/.source, [w, v]),
        lookbehind: !0,
        inside: r
      },
      {
        // Single catch exception declaration
        // catch(Foo)
        // (things like catch(Foo e) is covered by variable declaration)
        pattern: a(/(\bcatch\s*\(\s*)<<0>>/.source, [A]),
        lookbehind: !0,
        inside: r
      },
      {
        // Name of the type parameter of generic constraints
        // where Foo : class
        pattern: a(/(\bwhere\s+)<<0>>/.source, [S]),
        lookbehind: !0
      },
      {
        // Casts and checks via as and is.
        // as Foo<A>, is Bar<B>
        // (things like if(a is Foo b) is covered by variable declaration)
        pattern: a(/(\b(?:is(?:\s+not)?|as)\s+)<<0>>/.source, [N]),
        lookbehind: !0,
        inside: r
      },
      {
        // Variable, field and parameter declaration
        // (Foo bar, Bar baz, Foo[,,] bay, Foo<Bar, FooBar<Bar>> bax)
        pattern: a(/\b<<0>>(?=\s+(?!<<1>>|with\s*\{)<<2>>(?:\s*[=,;:{)\]]|\s+(?:in|when)\b))/.source, [t, y, S]),
        inside: r
      }
    ],
    keyword: o,
    // https://docs.microsoft.com/en-us/dotnet/csharp/language-reference/language-specification/lexical-structure#literals
    number: /(?:\b0(?:x[\da-f_]*[\da-f]|b[01_]*[01])|(?:\B\.\d+(?:_+\d+)*|\b\d+(?:_+\d+)*(?:\.\d+(?:_+\d+)*)?)(?:e[-+]?\d+(?:_+\d+)*)?)(?:[dflmu]|lu|ul)?\b/i,
    operator: />>=?|<<=?|[-=]>|([-+&|])\1|~|\?\?=?|[-+*/%&|^!=<>]=?/,
    punctuation: /\?\.?|::|[{}[\];(),.:]/
  }), e.languages.insertBefore("csharp", "number", {
    range: {
      pattern: /\.\./,
      alias: "operator"
    }
  }), e.languages.insertBefore("csharp", "punctuation", {
    "named-parameter": {
      pattern: a(/([(,]\s*)<<0>>(?=\s*:)/.source, [S]),
      lookbehind: !0,
      alias: "punctuation"
    }
  }), e.languages.insertBefore("csharp", "class-name", {
    namespace: {
      // namespace Foo.Bar {}
      // using Foo.Bar;
      pattern: a(/(\b(?:namespace|using)\s+)<<0>>(?:\s*\.\s*<<0>>)*(?=\s*[;{])/.source, [S]),
      lookbehind: !0,
      inside: {
        punctuation: /\./
      }
    },
    "type-expression": {
      // default(Foo), typeof(Foo<Bar>), sizeof(int)
      pattern: a(/(\b(?:default|sizeof|typeof)\s*\(\s*(?!\s))(?:[^()\s]|\s(?!\s)|<<0>>)*(?=\s*\))/.source, [d]),
      lookbehind: !0,
      alias: "class-name",
      inside: r
    },
    "return-type": {
      // Foo<Bar> ForBar(); Foo IFoo.Bar() => 0
      // int this[int index] => 0; T IReadOnlyList<T>.this[int index] => this[index];
      // int Foo => 0; int Foo { get; set } = 0;
      pattern: a(/<<0>>(?=\s+(?:<<1>>\s*(?:=>|[({]|\.\s*this\s*\[)|this\s*\[))/.source, [t, A]),
      inside: r,
      alias: "class-name"
    },
    "constructor-invocation": {
      // new List<Foo<Bar[]>> { }
      pattern: a(/(\bnew\s+)<<0>>(?=\s*[[({])/.source, [t]),
      lookbehind: !0,
      inside: r,
      alias: "class-name"
    },
    /*'explicit-implementation': {
    	// int IFoo<Foo>.Bar => 0; void IFoo<Foo<Foo>>.Foo<T>();
    	pattern: replace(/\b<<0>>(?=\.<<1>>)/, className, methodOrPropertyDeclaration),
    	inside: classNameInside,
    	alias: 'class-name'
    },*/
    "generic-method": {
      // foo<Bar>()
      pattern: a(/<<0>>\s*<<1>>(?=\s*\()/.source, [S, b]),
      inside: {
        function: a(/^<<0>>/.source, [S]),
        generic: {
          pattern: RegExp(b),
          alias: "class-name",
          inside: r
        }
      }
    },
    "type-list": {
      // The list of types inherited or of generic constraints
      // class Foo<F> : Bar, IList<FooBar>
      // where F : Bar, IList<int>
      pattern: a(
        /\b((?:<<0>>\s+<<1>>|record\s+<<1>>\s*<<5>>|where\s+<<2>>)\s*:\s*)(?:<<3>>|<<4>>|<<1>>\s*<<5>>|<<6>>)(?:\s*,\s*(?:<<3>>|<<4>>|<<6>>))*(?=\s*(?:where|[{;]|=>|$))/.source,
        [w, v, S, t, o.source, d, /\bnew\s*\(\s*\)/.source]
      ),
      lookbehind: !0,
      inside: {
        "record-arguments": {
          pattern: a(/(^(?!new\s*\()<<0>>\s*)<<1>>/.source, [v, d]),
          lookbehind: !0,
          greedy: !0,
          inside: e.languages.csharp
        },
        keyword: o,
        "class-name": {
          pattern: RegExp(t),
          greedy: !0,
          inside: r
        },
        punctuation: /[,()]/
      }
    },
    preprocessor: {
      pattern: /(^[\t ]*)#.*/m,
      lookbehind: !0,
      alias: "property",
      inside: {
        // highlight preprocessor directives as keywords
        directive: {
          pattern: /(#)\b(?:define|elif|else|endif|endregion|error|if|line|nullable|pragma|region|undef|warning)\b/,
          lookbehind: !0,
          alias: "keyword"
        }
      }
    }
  });
  var _ = u + "|" + l, m = i(/\/(?![*/])|\/\/[^\r\n]*[\r\n]|\/\*(?:[^*]|\*(?!\/))*\*\/|<<0>>/.source, [_]), O = s(i(/[^"'/()]|<<0>>|\(<<self>>*\)/.source, [m]), 2), L = /\b(?:assembly|event|field|method|module|param|property|return|type)\b/.source, F = i(/<<0>>(?:\s*\(<<1>>*\))?/.source, [A, O]);
  e.languages.insertBefore("csharp", "class-name", {
    attribute: {
      // Attributes
      // [Foo], [Foo(1), Bar(2, Prop = "foo")], [return: Foo(1), Bar(2)], [assembly: Foo(Bar)]
      pattern: a(/((?:^|[^\s\w>)?])\s*\[\s*)(?:<<0>>\s*:\s*)?<<1>>(?:\s*,\s*<<1>>)*(?=\s*\])/.source, [L, F]),
      lookbehind: !0,
      greedy: !0,
      inside: {
        target: {
          pattern: a(/^<<0>>(?=\s*:)/.source, [L]),
          alias: "keyword"
        },
        "attribute-arguments": {
          pattern: a(/\(<<0>>*\)/.source, [O]),
          inside: e.languages.csharp
        },
        "class-name": {
          pattern: RegExp(A),
          inside: {
            punctuation: /\./
          }
        },
        punctuation: /[:,]/
      }
    }
  });
  var M = /:[^}\r\n]+/.source, B = s(i(/[^"'/()]|<<0>>|\(<<self>>*\)/.source, [m]), 2), W = i(/\{(?!\{)(?:(?![}:])<<0>>)*<<1>>?\}/.source, [B, M]), z = s(i(/[^"'/()]|\/(?!\*)|\/\*(?:[^*]|\*(?!\/))*\*\/|<<0>>|\(<<self>>*\)/.source, [_]), 2), H = i(/\{(?!\{)(?:(?![}:])<<0>>)*<<1>>?\}/.source, [z, M]);
  function C(x, p) {
    return {
      interpolation: {
        pattern: a(/((?:^|[^{])(?:\{\{)*)<<0>>/.source, [x]),
        lookbehind: !0,
        inside: {
          "format-string": {
            pattern: a(/(^\{(?:(?![}:])<<0>>)*)<<1>>(?=\}$)/.source, [p, M]),
            lookbehind: !0,
            inside: {
              punctuation: /^:/
            }
          },
          punctuation: /^\{|\}$/,
          expression: {
            pattern: /[\s\S]+/,
            alias: "language-csharp",
            inside: e.languages.csharp
          }
        }
      },
      string: /[\s\S]+/
    };
  }
  e.languages.insertBefore("csharp", "string", {
    "interpolation-string": [
      {
        pattern: a(/(^|[^\\])(?:\$@|@\$)"(?:""|\\[\s\S]|\{\{|<<0>>|[^\\{"])*"/.source, [W]),
        lookbehind: !0,
        greedy: !0,
        inside: C(W, B)
      },
      {
        pattern: a(/(^|[^@\\])\$"(?:\\.|\{\{|<<0>>|[^\\"{])*"/.source, [H]),
        lookbehind: !0,
        greedy: !0,
        inside: C(H, z)
      }
    ],
    char: {
      pattern: RegExp(l),
      greedy: !0
    }
  }), e.languages.dotnet = e.languages.cs = e.languages.csharp;
})(Prism);
Prism.languages.python = {
  comment: {
    pattern: /(^|[^\\])#.*/,
    lookbehind: !0,
    greedy: !0
  },
  "string-interpolation": {
    pattern: /(?:f|fr|rf)(?:("""|''')[\s\S]*?\1|("|')(?:\\.|(?!\2)[^\\\r\n])*\2)/i,
    greedy: !0,
    inside: {
      interpolation: {
        // "{" <expression> <optional "!s", "!r", or "!a"> <optional ":" format specifier> "}"
        pattern: /((?:^|[^{])(?:\{\{)*)\{(?!\{)(?:[^{}]|\{(?!\{)(?:[^{}]|\{(?!\{)(?:[^{}])+\})+\})+\}/,
        lookbehind: !0,
        inside: {
          "format-spec": {
            pattern: /(:)[^:(){}]+(?=\}$)/,
            lookbehind: !0
          },
          "conversion-option": {
            pattern: /![sra](?=[:}]$)/,
            alias: "punctuation"
          },
          rest: null
        }
      },
      string: /[\s\S]+/
    }
  },
  "triple-quoted-string": {
    pattern: /(?:[rub]|br|rb)?("""|''')[\s\S]*?\1/i,
    greedy: !0,
    alias: "string"
  },
  string: {
    pattern: /(?:[rub]|br|rb)?("|')(?:\\.|(?!\1)[^\\\r\n])*\1/i,
    greedy: !0
  },
  function: {
    pattern: /((?:^|\s)def[ \t]+)[a-zA-Z_]\w*(?=\s*\()/g,
    lookbehind: !0
  },
  "class-name": {
    pattern: /(\bclass\s+)\w+/i,
    lookbehind: !0
  },
  decorator: {
    pattern: /(^[\t ]*)@\w+(?:\.\w+)*/m,
    lookbehind: !0,
    alias: ["annotation", "punctuation"],
    inside: {
      punctuation: /\./
    }
  },
  keyword: /\b(?:_(?=\s*:)|and|as|assert|async|await|break|case|class|continue|def|del|elif|else|except|exec|finally|for|from|global|if|import|in|is|lambda|match|nonlocal|not|or|pass|print|raise|return|try|while|with|yield)\b/,
  builtin: /\b(?:__import__|abs|all|any|apply|ascii|basestring|bin|bool|buffer|bytearray|bytes|callable|chr|classmethod|cmp|coerce|compile|complex|delattr|dict|dir|divmod|enumerate|eval|execfile|file|filter|float|format|frozenset|getattr|globals|hasattr|hash|help|hex|id|input|int|intern|isinstance|issubclass|iter|len|list|locals|long|map|max|memoryview|min|next|object|oct|open|ord|pow|property|range|raw_input|reduce|reload|repr|reversed|round|set|setattr|slice|sorted|staticmethod|str|sum|super|tuple|type|unichr|unicode|vars|xrange|zip)\b/,
  boolean: /\b(?:False|None|True)\b/,
  number: /\b0(?:b(?:_?[01])+|o(?:_?[0-7])+|x(?:_?[a-f0-9])+)\b|(?:\b\d+(?:_\d+)*(?:\.(?:\d+(?:_\d+)*)?)?|\B\.\d+(?:_\d+)*)(?:e[+-]?\d+(?:_\d+)*)?j?(?!\w)/i,
  operator: /[-+%=]=?|!=|:=|\*\*?=?|\/\/?=?|<[<=>]?|>[=>]?|[&|^~]/,
  punctuation: /[{}[\];(),.:]/
};
Prism.languages.python["string-interpolation"].inside.interpolation.inside.rest = Prism.languages.python;
Prism.languages.py = Prism.languages.python;
Prism.languages.c = Prism.languages.extend("clike", {
  comment: {
    pattern: /\/\/(?:[^\r\n\\]|\\(?:\r\n?|\n|(?![\r\n])))*|\/\*[\s\S]*?(?:\*\/|$)/,
    greedy: !0
  },
  string: {
    // https://en.cppreference.com/w/c/language/string_literal
    pattern: /"(?:\\(?:\r\n|[\s\S])|[^"\\\r\n])*"/,
    greedy: !0
  },
  "class-name": {
    pattern: /(\b(?:enum|struct)\s+(?:__attribute__\s*\(\([\s\S]*?\)\)\s*)?)\w+|\b[a-z]\w*_t\b/,
    lookbehind: !0
  },
  keyword: /\b(?:_Alignas|_Alignof|_Atomic|_Bool|_Complex|_Generic|_Imaginary|_Noreturn|_Static_assert|_Thread_local|__attribute__|asm|auto|break|case|char|const|continue|default|do|double|else|enum|extern|float|for|goto|if|inline|int|long|register|return|short|signed|sizeof|static|struct|switch|typedef|typeof|union|unsigned|void|volatile|while)\b/,
  function: /\b[a-z_]\w*(?=\s*\()/i,
  number: /(?:\b0x(?:[\da-f]+(?:\.[\da-f]*)?|\.[\da-f]+)(?:p[+-]?\d+)?|(?:\b\d+(?:\.\d*)?|\B\.\d+)(?:e[+-]?\d+)?)[ful]{0,4}/i,
  operator: />>=?|<<=?|->|([-+&|:])\1|[?:~]|[-+*/%&|^!=<>]=?/
});
Prism.languages.insertBefore("c", "string", {
  char: {
    // https://en.cppreference.com/w/c/language/character_constant
    pattern: /'(?:\\(?:\r\n|[\s\S])|[^'\\\r\n]){0,32}'/,
    greedy: !0
  }
});
Prism.languages.insertBefore("c", "string", {
  macro: {
    // allow for multiline macro definitions
    // spaces after the # character compile fine with gcc
    pattern: /(^[\t ]*)#\s*[a-z](?:[^\r\n\\/]|\/(?!\*)|\/\*(?:[^*]|\*(?!\/))*\*\/|\\(?:\r\n|[\s\S]))*/im,
    lookbehind: !0,
    greedy: !0,
    alias: "property",
    inside: {
      string: [
        {
          // highlight the path of the include statement as a string
          pattern: /^(#\s*include\s*)<[^>]+>/,
          lookbehind: !0
        },
        Prism.languages.c.string
      ],
      char: Prism.languages.c.char,
      comment: Prism.languages.c.comment,
      "macro-name": [
        {
          pattern: /(^#\s*define\s+)\w+\b(?!\()/i,
          lookbehind: !0
        },
        {
          pattern: /(^#\s*define\s+)\w+\b(?=\()/i,
          lookbehind: !0,
          alias: "function"
        }
      ],
      // highlight macro directives as keywords
      directive: {
        pattern: /^(#\s*)[a-z]+/,
        lookbehind: !0,
        alias: "keyword"
      },
      "directive-hash": /^#/,
      punctuation: /##|\\(?=[\r\n])/,
      expression: {
        pattern: /\S[\s\S]*/,
        inside: Prism.languages.c
      }
    }
  }
});
Prism.languages.insertBefore("c", "function", {
  // highlight predefined macros as constants
  constant: /\b(?:EOF|NULL|SEEK_CUR|SEEK_END|SEEK_SET|__DATE__|__FILE__|__LINE__|__TIMESTAMP__|__TIME__|__func__|stderr|stdin|stdout)\b/
});
delete Prism.languages.c.boolean;
Prism.languages["visual-basic"] = {
  comment: {
    pattern: /(?:['‘’]|REM\b)(?:[^\r\n_]|_(?:\r\n?|\n)?)*/i,
    inside: {
      keyword: /^REM/i
    }
  },
  directive: {
    pattern: /#(?:Const|Else|ElseIf|End|ExternalChecksum|ExternalSource|If|Region)(?:\b_[ \t]*(?:\r\n?|\n)|.)+/i,
    alias: "property",
    greedy: !0
  },
  string: {
    pattern: /\$?["“”](?:["“”]{2}|[^"“”])*["“”]C?/i,
    greedy: !0
  },
  date: {
    pattern: /#[ \t]*(?:\d+([/-])\d+\1\d+(?:[ \t]+(?:\d+[ \t]*(?:AM|PM)|\d+:\d+(?::\d+)?(?:[ \t]*(?:AM|PM))?))?|\d+[ \t]*(?:AM|PM)|\d+:\d+(?::\d+)?(?:[ \t]*(?:AM|PM))?)[ \t]*#/i,
    alias: "number"
  },
  number: /(?:(?:\b\d+(?:\.\d+)?|\.\d+)(?:E[+-]?\d+)?|&[HO][\dA-F]+)(?:[FRD]|U?[ILS])?/i,
  boolean: /\b(?:False|Nothing|True)\b/i,
  keyword: /\b(?:AddHandler|AddressOf|Alias|And(?:Also)?|As|Boolean|ByRef|Byte|ByVal|Call|Case|Catch|C(?:Bool|Byte|Char|Date|Dbl|Dec|Int|Lng|Obj|SByte|Short|Sng|Str|Type|UInt|ULng|UShort)|Char|Class|Const|Continue|Currency|Date|Decimal|Declare|Default|Delegate|Dim|DirectCast|Do|Double|Each|Else(?:If)?|End(?:If)?|Enum|Erase|Error|Event|Exit|Finally|For|Friend|Function|Get(?:Type|XMLNamespace)?|Global|GoSub|GoTo|Handles|If|Implements|Imports|In|Inherits|Integer|Interface|Is|IsNot|Let|Lib|Like|Long|Loop|Me|Mod|Module|Must(?:Inherit|Override)|My(?:Base|Class)|Namespace|Narrowing|New|Next|Not(?:Inheritable|Overridable)?|Object|Of|On|Operator|Option(?:al)?|Or(?:Else)?|Out|Overloads|Overridable|Overrides|ParamArray|Partial|Private|Property|Protected|Public|RaiseEvent|ReadOnly|ReDim|RemoveHandler|Resume|Return|SByte|Select|Set|Shadows|Shared|short|Single|Static|Step|Stop|String|Structure|Sub|SyncLock|Then|Throw|To|Try|TryCast|Type|TypeOf|U(?:Integer|Long|Short)|Until|Using|Variant|Wend|When|While|Widening|With(?:Events)?|WriteOnly|Xor)\b/i,
  operator: /[+\-*/\\^<=>&#@$%!]|\b_(?=[ \t]*[\r\n])/,
  punctuation: /[{}().,:?]/
};
Prism.languages.vb = Prism.languages["visual-basic"];
Prism.languages.vba = Prism.languages["visual-basic"];
(function(e) {
  e.languages.ruby = e.languages.extend("clike", {
    comment: {
      pattern: /#.*|^=begin\s[\s\S]*?^=end/m,
      greedy: !0
    },
    "class-name": {
      pattern: /(\b(?:class|module)\s+|\bcatch\s+\()[\w.\\]+|\b[A-Z_]\w*(?=\s*\.\s*new\b)/,
      lookbehind: !0,
      inside: {
        punctuation: /[.\\]/
      }
    },
    keyword: /\b(?:BEGIN|END|alias|and|begin|break|case|class|def|define_method|defined|do|each|else|elsif|end|ensure|extend|for|if|in|include|module|new|next|nil|not|or|prepend|private|protected|public|raise|redo|require|rescue|retry|return|self|super|then|throw|undef|unless|until|when|while|yield)\b/,
    operator: /\.{2,3}|&\.|===|<?=>|[!=]?~|(?:&&|\|\||<<|>>|\*\*|[+\-*/%<>!^&|=])=?|[?:]/,
    punctuation: /[(){}[\].,;]/
  }), e.languages.insertBefore("ruby", "operator", {
    "double-colon": {
      pattern: /::/,
      alias: "punctuation"
    }
  });
  var i = {
    pattern: /((?:^|[^\\])(?:\\{2})*)#\{(?:[^{}]|\{[^{}]*\})*\}/,
    lookbehind: !0,
    inside: {
      content: {
        pattern: /^(#\{)[\s\S]+(?=\}$)/,
        lookbehind: !0,
        inside: e.languages.ruby
      },
      delimiter: {
        pattern: /^#\{|\}$/,
        alias: "punctuation"
      }
    }
  };
  delete e.languages.ruby.function;
  var a = "(?:" + [
    /([^a-zA-Z0-9\s{(\[<=])(?:(?!\1)[^\\]|\\[\s\S])*\1/.source,
    /\((?:[^()\\]|\\[\s\S]|\((?:[^()\\]|\\[\s\S])*\))*\)/.source,
    /\{(?:[^{}\\]|\\[\s\S]|\{(?:[^{}\\]|\\[\s\S])*\})*\}/.source,
    /\[(?:[^\[\]\\]|\\[\s\S]|\[(?:[^\[\]\\]|\\[\s\S])*\])*\]/.source,
    /<(?:[^<>\\]|\\[\s\S]|<(?:[^<>\\]|\\[\s\S])*>)*>/.source
  ].join("|") + ")", s = /(?:"(?:\\.|[^"\\\r\n])*"|(?:\b[a-zA-Z_]\w*|[^\s\0-\x7F]+)[?!]?|\$.)/.source;
  e.languages.insertBefore("ruby", "keyword", {
    "regex-literal": [
      {
        pattern: RegExp(/%r/.source + a + /[egimnosux]{0,6}/.source),
        greedy: !0,
        inside: {
          interpolation: i,
          regex: /[\s\S]+/
        }
      },
      {
        pattern: /(^|[^/])\/(?!\/)(?:\[[^\r\n\]]+\]|\\.|[^[/\\\r\n])+\/[egimnosux]{0,6}(?=\s*(?:$|[\r\n,.;})#]))/,
        lookbehind: !0,
        greedy: !0,
        inside: {
          interpolation: i,
          regex: /[\s\S]+/
        }
      }
    ],
    variable: /[@$]+[a-zA-Z_]\w*(?:[?!]|\b)/,
    symbol: [
      {
        pattern: RegExp(/(^|[^:]):/.source + s),
        lookbehind: !0,
        greedy: !0
      },
      {
        pattern: RegExp(/([\r\n{(,][ \t]*)/.source + s + /(?=:(?!:))/.source),
        lookbehind: !0,
        greedy: !0
      }
    ],
    "method-definition": {
      pattern: /(\bdef\s+)\w+(?:\s*\.\s*\w+)?/,
      lookbehind: !0,
      inside: {
        function: /\b\w+$/,
        keyword: /^self\b/,
        "class-name": /^\w+/,
        punctuation: /\./
      }
    }
  }), e.languages.insertBefore("ruby", "string", {
    "string-literal": [
      {
        pattern: RegExp(/%[qQiIwWs]?/.source + a),
        greedy: !0,
        inside: {
          interpolation: i,
          string: /[\s\S]+/
        }
      },
      {
        pattern: /("|')(?:#\{[^}]+\}|#(?!\{)|\\(?:\r\n|[\s\S])|(?!\1)[^\\#\r\n])*\1/,
        greedy: !0,
        inside: {
          interpolation: i,
          string: /[\s\S]+/
        }
      },
      {
        pattern: /<<[-~]?([a-z_]\w*)[\r\n](?:.*[\r\n])*?[\t ]*\1/i,
        alias: "heredoc-string",
        greedy: !0,
        inside: {
          delimiter: {
            pattern: /^<<[-~]?[a-z_]\w*|\b[a-z_]\w*$/i,
            inside: {
              symbol: /\b\w+/,
              punctuation: /^<<[-~]?/
            }
          },
          interpolation: i,
          string: /[\s\S]+/
        }
      },
      {
        pattern: /<<[-~]?'([a-z_]\w*)'[\r\n](?:.*[\r\n])*?[\t ]*\1/i,
        alias: "heredoc-string",
        greedy: !0,
        inside: {
          delimiter: {
            pattern: /^<<[-~]?'[a-z_]\w*'|\b[a-z_]\w*$/i,
            inside: {
              symbol: /\b\w+/,
              punctuation: /^<<[-~]?'|'$/
            }
          },
          string: /[\s\S]+/
        }
      }
    ],
    "command-literal": [
      {
        pattern: RegExp(/%x/.source + a),
        greedy: !0,
        inside: {
          interpolation: i,
          command: {
            pattern: /[\s\S]+/,
            alias: "string"
          }
        }
      },
      {
        pattern: /`(?:#\{[^}]+\}|#(?!\{)|\\(?:\r\n|[\s\S])|[^\\`#\r\n])*`/,
        greedy: !0,
        inside: {
          interpolation: i,
          command: {
            pattern: /[\s\S]+/,
            alias: "string"
          }
        }
      }
    ]
  }), delete e.languages.ruby.string, e.languages.insertBefore("ruby", "number", {
    builtin: /\b(?:Array|Bignum|Binding|Class|Continuation|Dir|Exception|FalseClass|File|Fixnum|Float|Hash|IO|Integer|MatchData|Method|Module|NilClass|Numeric|Object|Proc|Range|Regexp|Stat|String|Struct|Symbol|TMS|Thread|ThreadGroup|Time|TrueClass)\b/,
    constant: /\b[A-Z][A-Z0-9_]*(?:[?!]|\b)/
  }), e.languages.rb = e.languages.ruby;
})(Prism);
Prism.languages.swift = {
  comment: {
    // Nested comments are supported up to 2 levels
    pattern: /(^|[^\\:])(?:\/\/.*|\/\*(?:[^/*]|\/(?!\*)|\*(?!\/)|\/\*(?:[^*]|\*(?!\/))*\*\/)*\*\/)/,
    lookbehind: !0,
    greedy: !0
  },
  "string-literal": [
    // https://docs.swift.org/swift-book/LanguageGuide/StringsAndCharacters.html
    {
      pattern: RegExp(
        /(^|[^"#])/.source + "(?:" + /"(?:\\(?:\((?:[^()]|\([^()]*\))*\)|\r\n|[^(])|[^\\\r\n"])*"/.source + "|" + /"""(?:\\(?:\((?:[^()]|\([^()]*\))*\)|[^(])|[^\\"]|"(?!""))*"""/.source + ")" + /(?!["#])/.source
      ),
      lookbehind: !0,
      greedy: !0,
      inside: {
        interpolation: {
          pattern: /(\\\()(?:[^()]|\([^()]*\))*(?=\))/,
          lookbehind: !0,
          inside: null
          // see below
        },
        "interpolation-punctuation": {
          pattern: /^\)|\\\($/,
          alias: "punctuation"
        },
        punctuation: /\\(?=[\r\n])/,
        string: /[\s\S]+/
      }
    },
    {
      pattern: RegExp(
        /(^|[^"#])(#+)/.source + "(?:" + /"(?:\\(?:#+\((?:[^()]|\([^()]*\))*\)|\r\n|[^#])|[^\\\r\n])*?"/.source + "|" + /"""(?:\\(?:#+\((?:[^()]|\([^()]*\))*\)|[^#])|[^\\])*?"""/.source + ")\\2"
      ),
      lookbehind: !0,
      greedy: !0,
      inside: {
        interpolation: {
          pattern: /(\\#+\()(?:[^()]|\([^()]*\))*(?=\))/,
          lookbehind: !0,
          inside: null
          // see below
        },
        "interpolation-punctuation": {
          pattern: /^\)|\\#+\($/,
          alias: "punctuation"
        },
        string: /[\s\S]+/
      }
    }
  ],
  directive: {
    // directives with conditions
    pattern: RegExp(
      /#/.source + "(?:" + (/(?:elseif|if)\b/.source + "(?:[ 	]*" + /(?:![ \t]*)?(?:\b\w+\b(?:[ \t]*\((?:[^()]|\([^()]*\))*\))?|\((?:[^()]|\([^()]*\))*\))(?:[ \t]*(?:&&|\|\|))?/.source + ")+") + "|" + /(?:else|endif)\b/.source + ")"
    ),
    alias: "property",
    inside: {
      "directive-name": /^#\w+/,
      boolean: /\b(?:false|true)\b/,
      number: /\b\d+(?:\.\d+)*\b/,
      operator: /!|&&|\|\||[<>]=?/,
      punctuation: /[(),]/
    }
  },
  literal: {
    pattern: /#(?:colorLiteral|column|dsohandle|file(?:ID|Literal|Path)?|function|imageLiteral|line)\b/,
    alias: "constant"
  },
  "other-directive": {
    pattern: /#\w+\b/,
    alias: "property"
  },
  attribute: {
    pattern: /@\w+/,
    alias: "atrule"
  },
  "function-definition": {
    pattern: /(\bfunc\s+)\w+/,
    lookbehind: !0,
    alias: "function"
  },
  label: {
    // https://docs.swift.org/swift-book/LanguageGuide/ControlFlow.html#ID141
    pattern: /\b(break|continue)\s+\w+|\b[a-zA-Z_]\w*(?=\s*:\s*(?:for|repeat|while)\b)/,
    lookbehind: !0,
    alias: "important"
  },
  keyword: /\b(?:Any|Protocol|Self|Type|actor|as|assignment|associatedtype|associativity|async|await|break|case|catch|class|continue|convenience|default|defer|deinit|didSet|do|dynamic|else|enum|extension|fallthrough|fileprivate|final|for|func|get|guard|higherThan|if|import|in|indirect|infix|init|inout|internal|is|isolated|lazy|left|let|lowerThan|mutating|none|nonisolated|nonmutating|open|operator|optional|override|postfix|precedencegroup|prefix|private|protocol|public|repeat|required|rethrows|return|right|safe|self|set|some|static|struct|subscript|super|switch|throw|throws|try|typealias|unowned|unsafe|var|weak|where|while|willSet)\b/,
  boolean: /\b(?:false|true)\b/,
  nil: {
    pattern: /\bnil\b/,
    alias: "constant"
  },
  "short-argument": /\$\d+\b/,
  omit: {
    pattern: /\b_\b/,
    alias: "keyword"
  },
  number: /\b(?:[\d_]+(?:\.[\de_]+)?|0x[a-f0-9_]+(?:\.[a-f0-9p_]+)?|0b[01_]+|0o[0-7_]+)\b/i,
  // A class name must start with an upper-case letter and be either 1 letter long or contain a lower-case letter.
  "class-name": /\b[A-Z](?:[A-Z_\d]*[a-z]\w*)?\b/,
  function: /\b[a-z_]\w*(?=\s*\()/i,
  constant: /\b(?:[A-Z_]{2,}|k[A-Z][A-Za-z_]+)\b/,
  // Operators are generic in Swift. Developers can even create new operators (e.g. +++).
  // https://docs.swift.org/swift-book/ReferenceManual/zzSummaryOfTheGrammar.html#ID481
  // This regex only supports ASCII operators.
  operator: /[-+*/%=!<>&|^~?]+|\.[.\-+*/%=!<>&|^~?]+/,
  punctuation: /[{}[\]();,.:\\]/
};
Prism.languages.swift["string-literal"].forEach(function(e) {
  e.inside.interpolation.inside = Prism.languages.swift;
});
(function(e) {
  var i = "\\b(?:BASH|BASHOPTS|BASH_ALIASES|BASH_ARGC|BASH_ARGV|BASH_CMDS|BASH_COMPLETION_COMPAT_DIR|BASH_LINENO|BASH_REMATCH|BASH_SOURCE|BASH_VERSINFO|BASH_VERSION|COLORTERM|COLUMNS|COMP_WORDBREAKS|DBUS_SESSION_BUS_ADDRESS|DEFAULTS_PATH|DESKTOP_SESSION|DIRSTACK|DISPLAY|EUID|GDMSESSION|GDM_LANG|GNOME_KEYRING_CONTROL|GNOME_KEYRING_PID|GPG_AGENT_INFO|GROUPS|HISTCONTROL|HISTFILE|HISTFILESIZE|HISTSIZE|HOME|HOSTNAME|HOSTTYPE|IFS|INSTANCE|JOB|LANG|LANGUAGE|LC_ADDRESS|LC_ALL|LC_IDENTIFICATION|LC_MEASUREMENT|LC_MONETARY|LC_NAME|LC_NUMERIC|LC_PAPER|LC_TELEPHONE|LC_TIME|LESSCLOSE|LESSOPEN|LINES|LOGNAME|LS_COLORS|MACHTYPE|MAILCHECK|MANDATORY_PATH|NO_AT_BRIDGE|OLDPWD|OPTERR|OPTIND|ORBIT_SOCKETDIR|OSTYPE|PAPERSIZE|PATH|PIPESTATUS|PPID|PS1|PS2|PS3|PS4|PWD|RANDOM|REPLY|SECONDS|SELINUX_INIT|SESSION|SESSIONTYPE|SESSION_MANAGER|SHELL|SHELLOPTS|SHLVL|SSH_AUTH_SOCK|TERM|UID|UPSTART_EVENTS|UPSTART_INSTANCE|UPSTART_JOB|UPSTART_SESSION|USER|WINDOWID|XAUTHORITY|XDG_CONFIG_DIRS|XDG_CURRENT_DESKTOP|XDG_DATA_DIRS|XDG_GREETER_DATA_DIR|XDG_MENU_PREFIX|XDG_RUNTIME_DIR|XDG_SEAT|XDG_SEAT_PATH|XDG_SESSION_DESKTOP|XDG_SESSION_ID|XDG_SESSION_PATH|XDG_SESSION_TYPE|XDG_VTNR|XMODIFIERS)\\b", a = {
    pattern: /(^(["']?)\w+\2)[ \t]+\S.*/,
    lookbehind: !0,
    alias: "punctuation",
    // this looks reasonably well in all themes
    inside: null
    // see below
  }, s = {
    bash: a,
    environment: {
      pattern: RegExp("\\$" + i),
      alias: "constant"
    },
    variable: [
      // [0]: Arithmetic Environment
      {
        pattern: /\$?\(\([\s\S]+?\)\)/,
        greedy: !0,
        inside: {
          // If there is a $ sign at the beginning highlight $(( and )) as variable
          variable: [
            {
              pattern: /(^\$\(\([\s\S]+)\)\)/,
              lookbehind: !0
            },
            /^\$\(\(/
          ],
          number: /\b0x[\dA-Fa-f]+\b|(?:\b\d+(?:\.\d*)?|\B\.\d+)(?:[Ee]-?\d+)?/,
          // Operators according to https://www.gnu.org/software/bash/manual/bashref.html#Shell-Arithmetic
          operator: /--|\+\+|\*\*=?|<<=?|>>=?|&&|\|\||[=!+\-*/%<>^&|]=?|[?~:]/,
          // If there is no $ sign at the beginning highlight (( and )) as punctuation
          punctuation: /\(\(?|\)\)?|,|;/
        }
      },
      // [1]: Command Substitution
      {
        pattern: /\$\((?:\([^)]+\)|[^()])+\)|`[^`]+`/,
        greedy: !0,
        inside: {
          variable: /^\$\(|^`|\)$|`$/
        }
      },
      // [2]: Brace expansion
      {
        pattern: /\$\{[^}]+\}/,
        greedy: !0,
        inside: {
          operator: /:[-=?+]?|[!\/]|##?|%%?|\^\^?|,,?/,
          punctuation: /[\[\]]/,
          environment: {
            pattern: RegExp("(\\{)" + i),
            lookbehind: !0,
            alias: "constant"
          }
        }
      },
      /\$(?:\w+|[#?*!@$])/
    ],
    // Escape sequences from echo and printf's manuals, and escaped quotes.
    entity: /\\(?:[abceEfnrtv\\"]|O?[0-7]{1,3}|U[0-9a-fA-F]{8}|u[0-9a-fA-F]{4}|x[0-9a-fA-F]{1,2})/
  };
  e.languages.bash = {
    shebang: {
      pattern: /^#!\s*\/.*/,
      alias: "important"
    },
    comment: {
      pattern: /(^|[^"{\\$])#.*/,
      lookbehind: !0
    },
    "function-name": [
      // a) function foo {
      // b) foo() {
      // c) function foo() {
      // but not “foo {”
      {
        // a) and c)
        pattern: /(\bfunction\s+)[\w-]+(?=(?:\s*\(?:\s*\))?\s*\{)/,
        lookbehind: !0,
        alias: "function"
      },
      {
        // b)
        pattern: /\b[\w-]+(?=\s*\(\s*\)\s*\{)/,
        alias: "function"
      }
    ],
    // Highlight variable names as variables in for and select beginnings.
    "for-or-select": {
      pattern: /(\b(?:for|select)\s+)\w+(?=\s+in\s)/,
      alias: "variable",
      lookbehind: !0
    },
    // Highlight variable names as variables in the left-hand part
    // of assignments (“=” and “+=”).
    "assign-left": {
      pattern: /(^|[\s;|&]|[<>]\()\w+(?:\.\w+)*(?=\+?=)/,
      inside: {
        environment: {
          pattern: RegExp("(^|[\\s;|&]|[<>]\\()" + i),
          lookbehind: !0,
          alias: "constant"
        }
      },
      alias: "variable",
      lookbehind: !0
    },
    // Highlight parameter names as variables
    parameter: {
      pattern: /(^|\s)-{1,2}(?:\w+:[+-]?)?\w+(?:\.\w+)*(?=[=\s]|$)/,
      alias: "variable",
      lookbehind: !0
    },
    string: [
      // Support for Here-documents https://en.wikipedia.org/wiki/Here_document
      {
        pattern: /((?:^|[^<])<<-?\s*)(\w+)\s[\s\S]*?(?:\r?\n|\r)\2/,
        lookbehind: !0,
        greedy: !0,
        inside: s
      },
      // Here-document with quotes around the tag
      // → No expansion (so no “inside”).
      {
        pattern: /((?:^|[^<])<<-?\s*)(["'])(\w+)\2\s[\s\S]*?(?:\r?\n|\r)\3/,
        lookbehind: !0,
        greedy: !0,
        inside: {
          bash: a
        }
      },
      // “Normal” string
      {
        // https://www.gnu.org/software/bash/manual/html_node/Double-Quotes.html
        pattern: /(^|[^\\](?:\\\\)*)"(?:\\[\s\S]|\$\([^)]+\)|\$(?!\()|`[^`]+`|[^"\\`$])*"/,
        lookbehind: !0,
        greedy: !0,
        inside: s
      },
      {
        // https://www.gnu.org/software/bash/manual/html_node/Single-Quotes.html
        pattern: /(^|[^$\\])'[^']*'/,
        lookbehind: !0,
        greedy: !0
      },
      {
        // https://www.gnu.org/software/bash/manual/html_node/ANSI_002dC-Quoting.html
        pattern: /\$'(?:[^'\\]|\\[\s\S])*'/,
        greedy: !0,
        inside: {
          entity: s.entity
        }
      }
    ],
    environment: {
      pattern: RegExp("\\$?" + i),
      alias: "constant"
    },
    variable: s.variable,
    function: {
      pattern: /(^|[\s;|&]|[<>]\()(?:add|apropos|apt|apt-cache|apt-get|aptitude|aspell|automysqlbackup|awk|basename|bash|bc|bconsole|bg|bzip2|cal|cargo|cat|cfdisk|chgrp|chkconfig|chmod|chown|chroot|cksum|clear|cmp|column|comm|composer|cp|cron|crontab|csplit|curl|cut|date|dc|dd|ddrescue|debootstrap|df|diff|diff3|dig|dir|dircolors|dirname|dirs|dmesg|docker|docker-compose|du|egrep|eject|env|ethtool|expand|expect|expr|fdformat|fdisk|fg|fgrep|file|find|fmt|fold|format|free|fsck|ftp|fuser|gawk|git|gparted|grep|groupadd|groupdel|groupmod|groups|grub-mkconfig|gzip|halt|head|hg|history|host|hostname|htop|iconv|id|ifconfig|ifdown|ifup|import|install|ip|java|jobs|join|kill|killall|less|link|ln|locate|logname|logrotate|look|lpc|lpr|lprint|lprintd|lprintq|lprm|ls|lsof|lynx|make|man|mc|mdadm|mkconfig|mkdir|mke2fs|mkfifo|mkfs|mkisofs|mknod|mkswap|mmv|more|most|mount|mtools|mtr|mutt|mv|nano|nc|netstat|nice|nl|node|nohup|notify-send|npm|nslookup|op|open|parted|passwd|paste|pathchk|ping|pkill|pnpm|podman|podman-compose|popd|pr|printcap|printenv|ps|pushd|pv|quota|quotacheck|quotactl|ram|rar|rcp|reboot|remsync|rename|renice|rev|rm|rmdir|rpm|rsync|scp|screen|sdiff|sed|sendmail|seq|service|sftp|sh|shellcheck|shuf|shutdown|sleep|slocate|sort|split|ssh|stat|strace|su|sudo|sum|suspend|swapon|sync|sysctl|tac|tail|tar|tee|time|timeout|top|touch|tr|traceroute|tsort|tty|umount|uname|unexpand|uniq|units|unrar|unshar|unzip|update-grub|uptime|useradd|userdel|usermod|users|uudecode|uuencode|v|vcpkg|vdir|vi|vim|virsh|vmstat|wait|watch|wc|wget|whereis|which|who|whoami|write|xargs|xdg-open|yarn|yes|zenity|zip|zsh|zypper)(?=$|[)\s;|&])/,
      lookbehind: !0
    },
    keyword: {
      pattern: /(^|[\s;|&]|[<>]\()(?:case|do|done|elif|else|esac|fi|for|function|if|in|select|then|until|while)(?=$|[)\s;|&])/,
      lookbehind: !0
    },
    // https://www.gnu.org/software/bash/manual/html_node/Shell-Builtin-Commands.html
    builtin: {
      pattern: /(^|[\s;|&]|[<>]\()(?:\.|:|alias|bind|break|builtin|caller|cd|command|continue|declare|echo|enable|eval|exec|exit|export|getopts|hash|help|let|local|logout|mapfile|printf|pwd|read|readarray|readonly|return|set|shift|shopt|source|test|times|trap|type|typeset|ulimit|umask|unalias|unset)(?=$|[)\s;|&])/,
      lookbehind: !0,
      // Alias added to make those easier to distinguish from strings.
      alias: "class-name"
    },
    boolean: {
      pattern: /(^|[\s;|&]|[<>]\()(?:false|true)(?=$|[)\s;|&])/,
      lookbehind: !0
    },
    "file-descriptor": {
      pattern: /\B&\d\b/,
      alias: "important"
    },
    operator: {
      // Lots of redirections here, but not just that.
      pattern: /\d?<>|>\||\+=|=[=~]?|!=?|<<[<-]?|[&\d]?>>|\d[<>]&?|[<>][&=]?|&[>&]?|\|[&|]?/,
      inside: {
        "file-descriptor": {
          pattern: /^\d/,
          alias: "important"
        }
      }
    },
    punctuation: /\$?\(\(?|\)\)?|\.\.|[{}[\];\\]/,
    number: {
      pattern: /(^|\s)(?:[1-9]\d*|0)(?:[.,]\d+)?\b/,
      lookbehind: !0
    }
  }, a.inside = e.languages.bash;
  for (var f = [
    "comment",
    "function-name",
    "for-or-select",
    "assign-left",
    "parameter",
    "string",
    "environment",
    "function",
    "keyword",
    "builtin",
    "boolean",
    "file-descriptor",
    "operator",
    "punctuation",
    "number"
  ], E = s.variable[1].inside, w = 0; w < f.length; w++)
    E[f[w]] = e.languages.bash[f[w]];
  e.languages.sh = e.languages.bash, e.languages.shell = e.languages.bash;
})(Prism);
Prism.languages.lua = {
  comment: /^#!.+|--(?:\[(=*)\[[\s\S]*?\]\1\]|.*)/m,
  // \z may be used to skip the following space
  string: {
    pattern: /(["'])(?:(?!\1)[^\\\r\n]|\\z(?:\r\n|\s)|\\(?:\r\n|[^z]))*\1|\[(=*)\[[\s\S]*?\]\2\]/,
    greedy: !0
  },
  number: /\b0x[a-f\d]+(?:\.[a-f\d]*)?(?:p[+-]?\d+)?\b|\b\d+(?:\.\B|(?:\.\d*)?(?:e[+-]?\d+)?\b)|\B\.\d+(?:e[+-]?\d+)?\b/i,
  keyword: /\b(?:and|break|do|else|elseif|end|false|for|function|goto|if|in|local|nil|not|or|repeat|return|then|true|until|while)\b/,
  function: /(?!\d)\w+(?=\s*(?:[({]))/,
  operator: [
    /[-+*%^&|#]|\/\/?|<[<=]?|>[>=]?|[=~]=?/,
    {
      // Match ".." but don't break "..."
      pattern: /(^|[^.])\.\.(?!\.)/,
      lookbehind: !0
    }
  ],
  punctuation: /[\[\](){},;]|\.+|:+/
};
(function(e) {
  var i = {
    pattern: /((?:^|[^\\$])(?:\\{2})*)\$(?:\w+|\{[^{}]*\})/,
    lookbehind: !0,
    inside: {
      "interpolation-punctuation": {
        pattern: /^\$\{?|\}$/,
        alias: "punctuation"
      },
      expression: {
        pattern: /[\s\S]+/,
        inside: null
        // see below
      }
    }
  };
  e.languages.groovy = e.languages.extend("clike", {
    string: {
      // https://groovy-lang.org/syntax.html#_dollar_slashy_string
      pattern: /'''(?:[^\\]|\\[\s\S])*?'''|'(?:\\.|[^\\'\r\n])*'/,
      greedy: !0
    },
    keyword: /\b(?:abstract|as|assert|boolean|break|byte|case|catch|char|class|const|continue|def|default|do|double|else|enum|extends|final|finally|float|for|goto|if|implements|import|in|instanceof|int|interface|long|native|new|package|private|protected|public|return|short|static|strictfp|super|switch|synchronized|this|throw|throws|trait|transient|try|void|volatile|while)\b/,
    number: /\b(?:0b[01_]+|0x[\da-f_]+(?:\.[\da-f_p\-]+)?|[\d_]+(?:\.[\d_]+)?(?:e[+-]?\d+)?)[glidf]?\b/i,
    operator: {
      pattern: /(^|[^.])(?:~|==?~?|\?[.:]?|\*(?:[.=]|\*=?)?|\.[@&]|\.\.<|\.\.(?!\.)|-[-=>]?|\+[+=]?|!=?|<(?:<=?|=>?)?|>(?:>>?=?|=)?|&[&=]?|\|[|=]?|\/=?|\^=?|%=?)/,
      lookbehind: !0
    },
    punctuation: /\.+|[{}[\];(),:$]/
  }), e.languages.insertBefore("groovy", "string", {
    shebang: {
      pattern: /#!.+/,
      alias: "comment",
      greedy: !0
    },
    "interpolation-string": {
      // TODO: Slash strings (e.g. /foo/) can contain line breaks but this will cause a lot of trouble with
      // simple division (see JS regex), so find a fix maybe?
      pattern: /"""(?:[^\\]|\\[\s\S])*?"""|(["/])(?:\\.|(?!\1)[^\\\r\n])*\1|\$\/(?:[^/$]|\$(?:[/$]|(?![/$]))|\/(?!\$))*\/\$/,
      greedy: !0,
      inside: {
        interpolation: i,
        string: /[\s\S]+/
      }
    }
  }), e.languages.insertBefore("groovy", "punctuation", {
    "spock-block": /\b(?:and|cleanup|expect|given|setup|then|when|where):/
  }), e.languages.insertBefore("groovy", "function", {
    annotation: {
      pattern: /(^|[^.])@\w+/,
      lookbehind: !0,
      alias: "punctuation"
    }
  }), i.inside.expression.inside = e.languages.groovy;
})(Prism);
const Q = /* @__PURE__ */ re({
  name: "AnchoHtmlNavBar",
  props: {
    type: {
      type: String,
      required: !1
    },
    content: {
      type: [String, Object, Number]
    },
    rawItem: {
      type: Object,
      required: !1
    },
    title: {
      type: String
    }
  },
  setup(e) {
    const i = se("rawitem");
    let a = null, s = "";
    e.rawItem && (a = e.rawItem.rawItem, s = a.contentType);
    const f = D(e.type || s || ""), E = D("");
    let w = null;
    s === "IMAGE" && (w = a.sysImage), s === "RAW" || s === "HTML" ? s === "RAW" ? (f.value = "TEXT", E.value = a.caption) : E.value = a.content : ["VIDEO", "DIVIDER", "INFO", "WARNING", "ERROR"].includes(s) || s === "IMAGE" && w && (E.value = w);
    const o = (p) => /^https?:|^http?:|(\.png|\.svg|\.jpg|\.png|\.gif|\.psd|\.tif|\.bmp|\.jpeg)/.test(p), g = D({
      id: te(),
      path: "",
      mute: !0,
      autoplay: !0,
      replay: !1,
      showcontrols: !0
    }), y = D({
      contentPosition: "center",
      html: ""
    }), b = D({
      type: "info",
      title: "",
      closeabled: !0,
      showIcon: !1
    }), d = D(""), S = D(!1), v = D([]), A = D(""), T = D([]), N = D(0), R = D(!1);
    let n = [], t = [];
    const r = D(!1), l = () => {
      if (f.value === "IMAGE" && typeof e.content == "string" && (o(e.content) ? E.value = {
        imagePath: e.content
      } : E.value = {
        cssClass: e.content
      }), ["TEXT", "HEADING1", "HEADING2", "HEADING3", "HEADING4", "HEADING5", "HEADING6", "PARAGRAPH", "HTML", "RAW"].includes(f.value) && (d.value = E.value, typeof d.value == "string")) {
        const p = d.value;
        d.value = p.replace(/&lt;/g, "<").replace(/&gt;/g, ">").replace(/&amp;nbsp;/g, " ").replace(/&nbsp;/g, " ");
      }
      if (["VIDEO", "DIVIDER", "INFO", "WARNING", "ERROR"].includes(f.value) && E.value) {
        let p = {};
        try {
          if (typeof E.value == "string")
            switch (p = new Function("return (".concat(E.value, ");"))(), f.value) {
              case "VIDEO":
                Object.assign(g.value, p);
                break;
              case "DIVIDER":
                Object.assign(y.value, p);
                break;
              case "INFO":
              case "WARNING":
              case "ERROR":
                b.value.type = f.value.toLocaleLowerCase(), Object.assign(b.value, p);
                break;
              default:
                break;
            }
        } catch (c) {
          ibiz.log.error(ibiz.i18n.t("component.rawItem.errorConfig", {
            type: f.value
          }));
        }
      }
    }, u = () => {
      if (t.length === 0)
        return;
      let p = n.length;
      t.forEach((c) => {
        const k = n.indexOf(c);
        k > -1 && p > k && (p = k);
      }), A.value = n[p];
    }, h = new IntersectionObserver((p) => {
      p.forEach((c) => {
        if (c.isIntersecting)
          c.target && c.target.id && t.push(c.target.id);
        else if (c.target && c.target.id) {
          const k = t.indexOf(c.target.id);
          k >= 0 && t.splice(k, 1);
        }
      }), u();
    }), _ = (p, c = 1) => {
      if (c > 6)
        return [p];
      const k = [], G = new RegExp("<h".concat(c, "[\\s\\S]*?>[\\s\\S]*?<\\/h").concat(c, ">"), "g"), P = new RegExp("<h".concat(c, "[\\s\\S]*?>([\\s\\S]*?)<\\/h").concat(c, ">"), "g"), U = p.split(G), j = p.match(P) || [];
      j.length > 0 && (r.value = !0);
      for (let $ = 0; $ < U.length; $++) {
        const Z = "title_".concat(te());
        n.push(Z), k.push({
          id: Z,
          title: j[$ - 1],
          level: c,
          children: _(U[$], c + 1)
        });
      }
      return k;
    }, m = () => {
      var p;
      if (n = [], t = [], r.value = !1, v.value = [], T.value = [], f.value === "HTML" && d.value && typeof d.value == "string") {
        const c = ((p = d.value.match(/src="([^"]+)"/g)) == null ? void 0 : p.map((k) => k.slice(5, -1))) || [];
        T.value = c, v.value = _(d.value, 1);
      }
    }, O = (p) => {
      const c = document.getElementById(p);
      c && c.scrollIntoView({
        behavior: "smooth",
        block: "start"
      });
    }, L = () => {
      S.value = !S.value;
    }, F = (p) => p.map((c) => [c.title ? I("p", {
      id: c.id,
      innerHTML: c.title
    }, null) : null, c.children && c.children.length > 0 ? F(c.children) : I("p", {
      innerHTML: c,
      onClick: z
    }, null)]), M = (p) => {
      const c = />(.*?)</g;
      return (p.match(c) || []).map((G) => G.slice(1, -1)).join("");
    }, B = (p) => p.map((c) => I("div", {
      class: [i.bem("ancho", "title-item", "text")]
    }, [c.title ? I("p", {
      class: [i.bem("ancho", "title-item", "text-title"), i.bem("ancho", "title-item", "text-".concat(c.level)), i.is("ancho-select", A.value === c.id)],
      title: M(c.title),
      innerHTML: c.title,
      onClick: () => O(c.id)
    }, null) : null, c.children && c.children.length > 0 ? B(c.children) : null])), W = (p) => {
      (p.key === "Escape" || p.keyCode === 27) && (R.value = !1, p.stopPropagation(), p.preventDefault());
    }, z = async (p) => {
      if (p && p.target instanceof HTMLElement && p.target.tagName === "IMG") {
        p.stopPropagation(), p.preventDefault();
        const c = p.target.getAttribute("src") || "";
        if (c) {
          const G = T.value.indexOf(c);
          N.value = G;
        }
        R.value = !0, await J();
        const k = document.querySelector(".el-image-viewer__wrapper");
        k && k.addEventListener("keydown", W);
      }
    }, H = () => {
      R.value = !1;
    }, C = async () => {
      h.disconnect(), await J(), n.forEach((p) => {
        const c = document.querySelector("#".concat(p));
        c && h.observe(c);
      });
    }, x = async () => {
      await J(), ye.highlightAll();
    };
    return l(), m(), ie(() => e.content, (p, c) => {
      p !== c && (E.value = p, l(), m(), C(), x());
    }, {
      immediate: !0
    }), {
      ns: i,
      rawItemText: d,
      playerParams: g,
      dividerParams: y,
      alertParams: b,
      rawItemType: f,
      rawItemContent: E,
      htmlContent: v,
      isCollapse: S,
      previewSrcList: T,
      selectAncho: A,
      showImg: R,
      previewImgIndex: N,
      showTitle: r,
      jumpAncho: O,
      changeCollapse: L,
      renderHTMLContent: F,
      renderAnchoList: B,
      closeImgPreview: H,
      imgClick: z
    };
  },
  render() {
    const e = () => this.rawItemType === "IMAGE" ? I(q("i-biz-icon"), {
      class: [this.ns.e("image")],
      icon: this.rawItemContent
    }, null) : this.rawItemType === "TEXT" || this.rawItemType === "RAW" ? I("span", {
      class: this.ns.e("text")
    }, [this.rawItemText]) : this.rawItemType === "HEADING1" ? I("h1", {
      class: this.ns.e("h1")
    }, [this.rawItemText]) : this.rawItemType === "HEADING2" ? I("h2", {
      class: this.ns.e("h2")
    }, [this.rawItemText]) : this.rawItemType === "HEADING3" ? I("h3", {
      class: this.ns.e("h3")
    }, [this.rawItemText]) : this.rawItemType === "HEADING4" ? I("h4", {
      class: this.ns.e("h4")
    }, [this.rawItemText]) : this.rawItemType === "HEADING5" ? I("h5", {
      class: this.ns.e("h5")
    }, [this.rawItemText]) : this.rawItemType === "HEADING6" ? I("h6", {
      class: this.ns.e("h6")
    }, [this.rawItemText]) : this.rawItemType === "PARAGRAPH" ? I("p", {
      class: this.ns.e("paragraph")
    }, [this.rawItemText]) : this.rawItemType === "HTML" ? I("div", {
      class: this.ns.e("paragraph")
    }, [I("div", {
      class: this.ns.em("paragraph", "html-content")
    }, [this.renderHTMLContent(this.htmlContent)]), this.showTitle ? I("div", {
      class: this.ns.em("paragraph", "ancho-container")
    }, [I("div", {
      class: [this.ns.em("paragraph", "ancho"), this.ns.b("ancho"), this.ns.is("ancho-collapse", this.isCollapse)]
    }, [I("div", {
      class: this.ns.be("ancho", "directory"),
      title: this.title
    }, [I("i", {
      class: "fa fa-sitemap",
      "aria-hidden": "true",
      onClick: this.changeCollapse,
      title: this.isCollapse ? "展开" : "收起"
    }, null), this.isCollapse ? null : I("span", {
      class: this.ns.bem("ancho", "directory", "title")
    }, [this.title || "目录"])]), I("div", {
      class: this.ns.be("ancho", "title-item")
    }, [this.renderAnchoList(this.htmlContent)])])]) : null]) : this.rawItemType === "VIDEO" ? I("div", {
      class: this.ns.e("video")
    }, [I("video", {
      id: this.playerParams.id,
      src: this.playerParams.path,
      autoplay: this.playerParams.autoplay,
      controls: this.playerParams.showcontrols,
      loop: this.playerParams.replay,
      muted: this.playerParams.mute
    }, [I("source", {
      src: this.playerParams.path,
      type: "video/mp4"
    }, null), I("source", {
      src: this.playerParams.path,
      type: "video/ogg"
    }, null), I("source", {
      src: this.playerParams.path,
      type: "video/webm"
    }, null), ibiz.i18n.t("component.rawItem.noSupportVideo")])]) : this.rawItemType === "DIVIDER" ? I(q("el-divider"), {
      "content-position": this.dividerParams.contentPosition
    }, {
      default: () => [I("span", {
        innerHTML: this.dividerParams.html
      }, null)]
    }) : this.rawItemType === "INFO" || this.rawItemType === "WARNING" || this.rawItemType === "ERROR" ? I(q("el-alert"), {
      title: this.alertParams.title,
      type: this.alertParams.type,
      "show-icon": this.alertParams.showIcon,
      closable: this.alertParams.closeabled
    }, null) : this.rawItemType === "MARKDOWN" ? I(q("iBizMarkDown"), {
      value: this.content,
      disabled: !0
    }, null) : (["PLACEHOLDER"].includes(this.rawItemType), null);
    return I("div", {
      class: this.ns.b()
    }, [e(), this.showImg ? I(q("el-image-viewer"), {
      urlList: this.previewSrcList,
      "initial-index": this.previewImgIndex,
      "hide-on-click-modal": !0,
      onClose: this.closeImgPreview
    }, null) : null]);
  }
}), ae = /* @__PURE__ */ re({
  name: "AnchoHtml",
  props: fe(),
  emits: be(),
  setup(e) {
    var y, b, d, S, v;
    const i = se("raw"), s = e.controller.model, f = D(""), E = D("");
    let w = "TEXT", o = "";
    s.contentType && (w = s.contentType), (y = s.editorParams) != null && y.contenttype && (w = (b = s.editorParams) == null ? void 0 : b.contenttype), (d = s.editorParams) != null && d.template && (o = s.editorParams.template.replaceAll("//n", "\n")), (S = s.editorParams) != null && S.TEMPLATE && (o = s.editorParams.TEMPLATE.replaceAll("//n", "\n")), (v = s.editorParams) != null && v.TITLE && (E.value = e.data[s.editorParams.TITLE]);
    const g = ge(() => !!(e.controlParams && e.controlParams.editmode === "hover"));
    return ie(() => e.value, async (A, T) => {
      if (A !== T && ((typeof A == "string" || typeof A == "number") && (f.value = A), o && A)) {
        let N = null;
        if (typeof A == "string")
          try {
            N = JSON.parse(A);
          } catch (R) {
            ibiz.log.error("JSON字符串转换错误");
          }
        f.value = await ibiz.util.hbs.render(o, N || A);
      }
    }, {
      immediate: !0
    }), {
      ns: i,
      content: f,
      type: w,
      template: o,
      title: E,
      showFormDefaultContent: g
    };
  },
  render() {
    return I("div", {
      class: [this.ns.b(), this.disabled ? this.ns.m("disabled") : "", this.readonly ? this.ns.m("readonly") : "", this.ns.is("show-default", this.showFormDefaultContent)]
    }, [this.content && I(Q, {
      class: this.ns.b("content"),
      content: this.content,
      type: this.type,
      title: this.title
    }, null)]);
  }
});
class Ee extends de {
}
class we {
  constructor() {
    V(this, "formEditor", "AnchoHtml");
    V(this, "gridEditor", "AnchoHtml");
  }
  async createController(i, a) {
    const s = new Ee(i, a);
    return await s.init(), s;
  }
}
const Te = {
  install(e) {
    e.component(Q.name, Q), e.component(ae.name, ae), pe("EDITOR_CUSTOMSTYLE_ANCHO_HTML", () => new we());
  }
};
export {
  Te as default
};
