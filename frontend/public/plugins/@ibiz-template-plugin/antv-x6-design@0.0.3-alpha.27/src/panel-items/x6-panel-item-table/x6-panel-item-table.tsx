import { PropType, defineComponent, ref, nextTick, onUnmounted } from 'vue';
import { useNamespace } from '@ibiz-template/vue3-util';
import { IPanelRawItem } from '@ibiz/model-core';
import { IDataEntity } from '@ibiz-template/runtime';
import { X6PanelItemTableController } from './x6-panel-item-table.controller';
import { X6PanelItemTableLinkData } from '../../interface';
import {
  moreIcon,
  statusIcon,
  removeIcon,
  editIcon,
  selectedIcon,
  addIcon,
} from './icons';
import './x6-panel-item-table.scss';

export default defineComponent({
  name: 'IBizX6PanelItemTable',
  props: {
    modelData: {
      type: Object as PropType<IPanelRawItem>,
      required: true,
    },
    controller: {
      type: X6PanelItemTableController,
      required: true,
    },
  },
  setup(props) {
    const ns = useNamespace('x6-panel-item-table');

    props.controller.panel.evt.on('onMounted', () => {
      props.controller.load();
    });

    props.controller.subscribeMessage();
    if (props.controller.panel.state.isMounted) {
      props.controller.load();
    }

    onUnmounted(() => {
      props.controller.unsubscribeMessage();
    });

    const onConnectionChange = async (
      value: boolean,
      item: X6PanelItemTableLinkData,
    ) => {
      if (value) {
        await props.controller.createLink(item);
        return;
      }
      await props.controller.removeLink(item);
    };

    const table = ref<{ doLayout: () => void } | null>(null);

    const onCommand = async (command: string, source: IDataEntity) => {
      if (command === 'initialState') {
        await props.controller.updateInitialState(source);
        return;
      }
      if (command === 'remove') {
        const isDelete = await ibiz.confirm.warning({
          title: '确认移除',
          options: {
            customClass: ns.b('message-box'),
            message: () => {
              return (
                <div class={ns.b('message-box-content')}>
                  <div class={ns.be('message-box-content', 'text')}>
                    确认移除
                  </div>
                  <el-tag
                    class={ns.be('message-box-content', 'tag')}
                    type='danger'
                  >
                    {source.srfmajortext || ''}
                  </el-tag>
                  <div class={ns.be('message-box-content', 'text')}>
                    状态吗?
                  </div>
                </div>
              );
            },
          },
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
      if (command === 'edit') {
        props.controller.activeNode(source);
      }
    };

    const onEdit = (item: X6PanelItemTableLinkData) => {
      props.controller.activeLink(item);
    };

    const addStatus = async (e: MouseEvent) => {
      await props.controller.createNode(e);
    };

    const activeStatus = ref('');

    const onVisibleChange = (visible: boolean, value: string) => {
      activeStatus.value = visible ? value : '';
    };

    const sourceList = ref<Set<string>>(new Set());

    return {
      ns,
      activeStatus,
      table,
      sourceList,
      onConnectionChange,
      onCommand,
      onEdit,
      addStatus,
      onVisibleChange,
    };
  },
  render() {
    return (
      <div class={this.ns.b()}>
        <el-table
          ref='table'
          class={this.ns.b('content')}
          data={this.controller.state.rows}
          border
        >
          {this.controller.state.nodes.length ? (
            <el-table-column width='280'>
              {{
                header: () => {
                  return (
                    <div class={this.ns.b('split-header')}>
                      <div class={this.ns.be('split-header', 'source')}>
                        开始状态
                      </div>
                      <div class={this.ns.be('split-header', 'target')}>
                        目标状态
                      </div>
                      <div class={this.ns.be('split-header', 'line')}></div>
                    </div>
                  );
                },
                default: ({ $index }: { $index: number }) => {
                  const source = this.controller.state.nodes[$index];
                  let style = {};
                  if (source.param12) {
                    style = { '--el-tag-text-color': source.param12 };
                  }
                  if (source.param13) {
                    Object.assign(style, {
                      '--el-tag-border-color': source.param13,
                    });
                  }
                  if (!source) {
                    return;
                  }
                  return (
                    <div
                      class={[
                        this.ns.b('source'),
                        this.ns.is(
                          'active',
                          this.activeStatus === source.srfkey,
                        ),
                        this.activeStatus
                          ? this.ns.bm('source', 'checked')
                          : '',
                      ]}
                      onMouseenter={() => {
                        this.sourceList.add(source.srfkey);
                      }}
                    >
                      <el-tag
                        class={this.ns.b('source-text')}
                        effect='dark'
                        round
                        style={style}
                        color={source.param13 ? source.param13 : ''}
                      >
                        {source.srfmajortext || ''}
                      </el-tag>
                      {source.param9 ? (
                        <el-tag
                          class={this.ns.b('source-status')}
                          effect='light'
                          round
                        >
                          初始状态
                        </el-tag>
                      ) : null}
                      {this.sourceList.has(source.srfkey) ? (
                        <el-dropdown
                          class={this.ns.b('source-dropdown')}
                          popper-class={this.ns.b('source-dropdown-popper')}
                          trigger='click'
                          onCommand={(command: string) =>
                            this.onCommand(command, source)
                          }
                          onVisibleChange={(visible: boolean) => {
                            this.onVisibleChange(visible, source.srfkey);
                          }}
                        >
                          {{
                            default: () => {
                              return (
                                <div
                                  class={this.ns.be('source-dropdown', 'icon')}
                                >
                                  {moreIcon()}
                                </div>
                              );
                            },
                            dropdown: () => {
                              return (
                                <el-dropdown-menu>
                                  <el-dropdown-item command='initialState'>
                                    <div
                                      class={this.ns.b('source-dropdown-item')}
                                    >
                                      <div
                                        class={this.ns.be(
                                          'source-dropdown-item',
                                          'icon',
                                        )}
                                      >
                                        {statusIcon()}
                                      </div>
                                      <div
                                        class={this.ns.be(
                                          'source-dropdown-item',
                                          'text',
                                        )}
                                      >
                                        初始状态
                                      </div>
                                      {source.param9 ? (
                                        <div
                                          class={[
                                            this.ns.be(
                                              'source-dropdown-item',
                                              'icon',
                                            ),
                                            this.ns.bem(
                                              'source-dropdown-item',
                                              'icon',
                                              'selected',
                                            ),
                                          ]}
                                        >
                                          {selectedIcon()}
                                        </div>
                                      ) : null}
                                    </div>
                                  </el-dropdown-item>
                                  <el-dropdown-item
                                    command='remove'
                                    disabled={!!source.param9}
                                  >
                                    <div
                                      class={this.ns.b('source-dropdown-item')}
                                    >
                                      <div
                                        class={this.ns.be(
                                          'source-dropdown-item',
                                          'icon',
                                        )}
                                      >
                                        {removeIcon()}
                                      </div>
                                      <div
                                        class={this.ns.be(
                                          'source-dropdown-item',
                                          'text',
                                        )}
                                      >
                                        移除
                                      </div>
                                    </div>
                                  </el-dropdown-item>
                                  <el-dropdown-item command='edit'>
                                    <div
                                      class={this.ns.b('source-dropdown-item')}
                                    >
                                      <div
                                        class={this.ns.be(
                                          'source-dropdown-item',
                                          'icon',
                                        )}
                                      >
                                        {editIcon()}
                                      </div>
                                      <div
                                        class={this.ns.be(
                                          'source-dropdown-item',
                                          'text',
                                        )}
                                      >
                                        编辑
                                      </div>
                                    </div>
                                  </el-dropdown-item>
                                </el-dropdown-menu>
                              );
                            },
                          }}
                        </el-dropdown>
                      ) : null}
                    </div>
                  );
                },
              }}
            </el-table-column>
          ) : null}
          {this.controller.state.nodes.map(item => {
            return (
              <el-table-column min-width='160' prop={item.srfkey}>
                {{
                  header: ({ $index }: { $index: number }) => {
                    const target = this.controller.state.nodes[$index - 1];
                    let style = {};
                    if (target.param12) {
                      style = { '--el-tag-text-color': target.param12 };
                    }
                    if (target.param13) {
                      Object.assign(style, {
                        '--el-tag-border-color': target.param13,
                      });
                    }
                    if (!target) {
                      return;
                    }
                    return (
                      <div class={this.ns.b('target')}>
                        <el-tag
                          class={this.ns.b('target-text')}
                          effect='dark'
                          round
                          style={style}
                          color={target.param13 ? target.param13 : ''}
                        >
                          {target.srfmajortext || ''}
                        </el-tag>
                      </div>
                    );
                  },
                  default: ({
                    row,
                  }: {
                    row: Record<string, X6PanelItemTableLinkData>;
                  }) => {
                    const cell = row[item.srfkey];
                    if (!cell) {
                      return;
                    }
                    return (
                      <div class={this.ns.b('connection')}>
                        <el-checkbox
                          class={this.ns.b('connection-checkbox')}
                          onChange={(value: boolean) =>
                            this.onConnectionChange(value, cell)
                          }
                          v-model={cell.isConnected}
                          disabled={cell.source === cell.target}
                        />
                        {cell.isConnected ? (
                          <div
                            class={this.ns.b('connection-button')}
                            onClick={() => {
                              this.onEdit(cell);
                            }}
                          >
                            <div
                              class={this.ns.be('connection-button', 'icon')}
                            >
                              {editIcon()}
                            </div>
                            <div
                              class={this.ns.be('connection-button', 'text')}
                            >
                              配置
                            </div>
                          </div>
                        ) : null}
                      </div>
                    );
                  },
                }}
              </el-table-column>
            );
          })}
        </el-table>
        <div class={this.ns.b('footer')}>
          <el-button
            class={this.ns.b('add-button')}
            onClick={(e: MouseEvent) => this.addStatus(e)}
          >
            <div class={this.ns.be('add-button', 'icon')}>{addIcon()}</div>
            <div class={this.ns.be('add-button', 'text')}>添加状态</div>
          </el-button>
        </div>
      </div>
    );
  },
});
