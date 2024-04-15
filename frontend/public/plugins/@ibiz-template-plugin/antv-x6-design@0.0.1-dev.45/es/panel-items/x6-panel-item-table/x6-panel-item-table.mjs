import { onUnmounted, ref, createTextVNode, createVNode, resolveComponent, nextTick, defineComponent } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { X6PanelItemTableController } from './x6-panel-item-table.controller.mjs';
import { moreIcon, statusIcon, selectedIcon, removeIcon, editIcon, addIcon } from './icons/index.mjs';
import './x6-panel-item-table.css';

"use strict";
var X6PanelItemTable = /* @__PURE__ */ defineComponent({
  name: "IBizX6PanelItemTable",
  props: {
    modelData: {
      type: Object,
      required: true
    },
    controller: {
      type: X6PanelItemTableController,
      required: true
    }
  },
  setup(props) {
    const ns = useNamespace("x6-panel-item-table");
    props.controller.panel.evt.on("onMounted", () => {
      props.controller.load();
    });
    props.controller.subscribeMessage();
    if (props.controller.panel.state.isMounted) {
      props.controller.load();
    }
    onUnmounted(() => {
      props.controller.unsubscribeMessage();
    });
    const onConnectionChange = async (value, item) => {
      if (value) {
        await props.controller.createLink(item);
        return;
      }
      await props.controller.removeLink(item);
    };
    const table = ref(null);
    const onCommand = async (command, source) => {
      if (command === "initialState") {
        await props.controller.updateInitialState(source);
        return;
      }
      if (command === "remove") {
        const isDelete = await ibiz.confirm.warning({
          title: "\u786E\u8BA4\u79FB\u9664",
          options: {
            customClass: ns.b("message-box"),
            message: () => {
              return createVNode("div", {
                "class": ns.b("message-box-content")
              }, [createVNode("div", {
                "class": ns.be("message-box-content", "text")
              }, [createTextVNode("\u786E\u8BA4\u79FB\u9664")]), createVNode(resolveComponent("el-tag"), {
                "class": ns.be("message-box-content", "tag"),
                "type": "danger"
              }, {
                default: () => [source.srfmajortext || ""]
              }), createVNode("div", {
                "class": ns.be("message-box-content", "text")
              }, [createTextVNode("\u72B6\u6001\u5417?")])]);
            }
          }
        });
        if (!isDelete) {
          return;
        }
        const result = await props.controller.removeNode(source);
        if (result) {
          nextTick(() => {
            if (table.value) {
              table.value.doLayout();
            }
          });
        }
        return;
      }
      if (command === "edit") {
        props.controller.activeNode(source);
      }
    };
    const onEdit = (item) => {
      props.controller.activeLink(item);
    };
    const addStatus = async (e) => {
      await props.controller.createNode(e);
    };
    const activeStatus = ref("");
    const onVisibleChange = (visible, value) => {
      activeStatus.value = visible ? value : "";
    };
    const sourceList = ref(/* @__PURE__ */ new Set());
    return {
      ns,
      activeStatus,
      table,
      sourceList,
      onConnectionChange,
      onCommand,
      onEdit,
      addStatus,
      onVisibleChange
    };
  },
  render() {
    return createVNode("div", {
      "class": this.ns.b()
    }, [createVNode(resolveComponent("el-table"), {
      "ref": "table",
      "class": this.ns.b("content"),
      "data": this.controller.state.rows,
      "border": true
    }, {
      default: () => [this.controller.state.nodes.length ? createVNode(resolveComponent("el-table-column"), {
        "width": "280"
      }, {
        header: () => {
          return createVNode("div", {
            "class": this.ns.b("split-header")
          }, [createVNode("div", {
            "class": this.ns.be("split-header", "source")
          }, [createTextVNode("\u5F00\u59CB\u72B6\u6001")]), createVNode("div", {
            "class": this.ns.be("split-header", "target")
          }, [createTextVNode("\u76EE\u6807\u72B6\u6001")]), createVNode("div", {
            "class": this.ns.be("split-header", "line")
          }, null)]);
        },
        default: ({
          $index
        }) => {
          const source = this.controller.state.nodes[$index];
          let style = {};
          if (source.param12) {
            style = {
              "--el-tag-text-color": source.param12
            };
          }
          if (source.param13) {
            Object.assign(style, {
              "--el-tag-border-color": source.param13
            });
          }
          if (!source) {
            return;
          }
          return createVNode("div", {
            "class": [this.ns.b("source"), this.ns.is("active", this.activeStatus === source.srfkey), this.activeStatus ? this.ns.bm("source", "checked") : ""],
            "onMouseenter": () => {
              this.sourceList.add(source.srfkey);
            }
          }, [createVNode(resolveComponent("el-tag"), {
            "class": this.ns.b("source-text"),
            "effect": "dark",
            "round": true,
            "style": style,
            "color": source.param13 ? source.param13 : ""
          }, {
            default: () => [source.srfmajortext || ""]
          }), source.param9 ? createVNode(resolveComponent("el-tag"), {
            "class": this.ns.b("source-status"),
            "effect": "light",
            "round": true
          }, {
            default: () => [createTextVNode("\u521D\u59CB\u72B6\u6001")]
          }) : null, this.sourceList.has(source.srfkey) ? createVNode(resolveComponent("el-dropdown"), {
            "class": this.ns.b("source-dropdown"),
            "popper-class": this.ns.b("source-dropdown-popper"),
            "trigger": "click",
            "onCommand": (command) => this.onCommand(command, source),
            "onVisibleChange": (visible) => {
              this.onVisibleChange(visible, source.srfkey);
            }
          }, {
            default: () => {
              return createVNode("div", {
                "class": this.ns.be("source-dropdown", "icon")
              }, [moreIcon()]);
            },
            dropdown: () => {
              return createVNode(resolveComponent("el-dropdown-menu"), null, {
                default: () => [createVNode(resolveComponent("el-dropdown-item"), {
                  "command": "initialState"
                }, {
                  default: () => [createVNode("div", {
                    "class": this.ns.b("source-dropdown-item")
                  }, [createVNode("div", {
                    "class": this.ns.be("source-dropdown-item", "icon")
                  }, [statusIcon()]), createVNode("div", {
                    "class": this.ns.be("source-dropdown-item", "text")
                  }, [createTextVNode("\u521D\u59CB\u72B6\u6001")]), source.param9 ? createVNode("div", {
                    "class": [this.ns.be("source-dropdown-item", "icon"), this.ns.bem("source-dropdown-item", "icon", "selected")]
                  }, [selectedIcon()]) : null])]
                }), createVNode(resolveComponent("el-dropdown-item"), {
                  "command": "remove",
                  "disabled": !!source.param9
                }, {
                  default: () => [createVNode("div", {
                    "class": this.ns.b("source-dropdown-item")
                  }, [createVNode("div", {
                    "class": this.ns.be("source-dropdown-item", "icon")
                  }, [removeIcon()]), createVNode("div", {
                    "class": this.ns.be("source-dropdown-item", "text")
                  }, [createTextVNode("\u79FB\u9664")])])]
                }), createVNode(resolveComponent("el-dropdown-item"), {
                  "command": "edit"
                }, {
                  default: () => [createVNode("div", {
                    "class": this.ns.b("source-dropdown-item")
                  }, [createVNode("div", {
                    "class": this.ns.be("source-dropdown-item", "icon")
                  }, [editIcon()]), createVNode("div", {
                    "class": this.ns.be("source-dropdown-item", "text")
                  }, [createTextVNode("\u7F16\u8F91")])])]
                })]
              });
            }
          }) : null]);
        }
      }) : null, this.controller.state.nodes.map((item) => {
        return createVNode(resolveComponent("el-table-column"), {
          "min-width": "160",
          "prop": item.srfkey
        }, {
          header: ({
            $index
          }) => {
            const target = this.controller.state.nodes[$index - 1];
            let style = {};
            if (target.param12) {
              style = {
                "--el-tag-text-color": target.param12
              };
            }
            if (target.param13) {
              Object.assign(style, {
                "--el-tag-border-color": target.param13
              });
            }
            if (!target) {
              return;
            }
            return createVNode("div", {
              "class": this.ns.b("target")
            }, [createVNode(resolveComponent("el-tag"), {
              "class": this.ns.b("target-text"),
              "effect": "dark",
              "round": true,
              "style": style,
              "color": target.param13 ? target.param13 : ""
            }, {
              default: () => [target.srfmajortext || ""]
            })]);
          },
          default: ({
            row
          }) => {
            const cell = row[item.srfkey];
            if (!cell) {
              return;
            }
            return createVNode("div", {
              "class": this.ns.b("connection")
            }, [createVNode(resolveComponent("el-checkbox"), {
              "class": this.ns.b("connection-checkbox"),
              "onChange": (value) => this.onConnectionChange(value, cell),
              "modelValue": cell.isConnected,
              "onUpdate:modelValue": ($event) => cell.isConnected = $event,
              "disabled": cell.source === cell.target
            }, null), cell.isConnected ? createVNode("div", {
              "class": this.ns.b("connection-button"),
              "onClick": () => {
                this.onEdit(cell);
              }
            }, [createVNode("div", {
              "class": this.ns.be("connection-button", "icon")
            }, [editIcon()]), createVNode("div", {
              "class": this.ns.be("connection-button", "text")
            }, [createTextVNode("\u914D\u7F6E")])]) : null]);
          }
        });
      })]
    }), createVNode("div", {
      "class": this.ns.b("footer")
    }, [createVNode(resolveComponent("el-button"), {
      "class": this.ns.b("add-button"),
      "onClick": (e) => this.addStatus(e)
    }, {
      default: () => [createVNode("div", {
        "class": this.ns.be("add-button", "icon")
      }, [addIcon()]), createVNode("div", {
        "class": this.ns.be("add-button", "text")
      }, [createTextVNode("\u6DFB\u52A0\u72B6\u6001")])]
    })])]);
  }
});

export { X6PanelItemTable as default };
