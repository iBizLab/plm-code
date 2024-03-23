## 前言

### 1. 简介

iBizPLM前端项目基于iBiz平台产出的模型，采用了模板技术结合Vue全家桶（Vue3、Vite、Element Plus、TSX）来构建。本文档旨在帮助开发人员快速掌握项目的上手流程，并对代码结构进行详细说明，以便提供开发上的指导和支持。随着我们决定将该框架开源，我们热切期望更多有共同理念的伙伴能加入到iBizPLM前端项目的持续迭代和优化中来。欢迎大家的参与，共同推动iBizPLM前端项目的发展！

### 2. 开发环境要求

- Node.js

- pnpm

- Vite

### 3. 开发技术要求

掌握`Vue`、`TypeScript`、`less`、`html`等技术。

### 4. 技术栈

- 前端MVVM框架：vue.js@3.3.8

- 路由：vue-router@4.2.5

- 状态管理：pinia@2.1.7

- 国际化：vue-i18n@9.5.0

- UI框架：element-plus@2.4.1

- 第三方组件：@wangeditor/editor@5.1.23,@wangeditor/editor-for-vue@5.1.12,vue-grid-layout@3.0.0-beta1,@imengyu/vue3-context-menu@1.3.3,vuedraggable@4.1.0

- 第三方工具库：qs@6.11.2,ramda@0.29.1,qx-util@0.4.8,lodash-es@4.17.21,async-validator@4.2.5

- 其他：@ibiz-template/core@^0.6.3,@ibiz-template/model-helper@0.6.4,@ibiz-template/runtime@0.6.4,@ibiz-template/theme@^0.6.0,@ibiz-template/vue3-components@0.6.4,@ibiz-template/vue3-util@0.6.4,@ibiz-template/web-theme@^1.1.11"

## 快速上手

### 1. 开发环境

> 在安装使用 `pnpm`前，务必确认 [Node.js](https://nodejs.org) 已经升级到版本16+，强烈建议升级至最新版本。
> 如果你想了解更多 `pnpm` 工具链的功能和命令，建议访问 [pnpm](https://www.pnpm.cn/) 了解更多。

- 访问 [Node.js](https://nodejs.org) ，根据文档安装 `Node.js`。
- 访问 [Pnpm](https://www.pnpm.cn/) ，根据文档安装 `pnpm`。

以下为 Windows 环境开发正常配置 
<br>
![开发环境信息](sample/getting-started/development.png)

### 2. 安装依赖

打开前端项目，进入工作空间下，执行安装依赖命令

```bash
$ pnpm install
```

### 3. 启动

在工作空间下，执行启动命令

```bash
$ pnpm run dev
```

启动后，访问开发项目。<br>

### 3. 预览

在工作空间下，执行预览命令

```bash
$ pnpm run preview
```

启动后，预览开发项目。<br>

### 4. 打包

在工作空间下，执行打包命令

```bash
$ pnpm run build
```

打包完成，生成最终交付产物。

## 成果物结构

```
|─ ─ app
​    |─ ─ public                                 public文件夹
​        |─ ─ assets                             静态文件夹
​        |─ ─ environments                       环境文件
​        |─ ─ extras                             依赖包文件
​        |─ ─ model                              图标文件
​        |─ ─ cas-login.html                     单点登录
        |─ ─ favicon.ico                        图标
​    |─ ─ src                                    工程文件夹
        |─ ─ components                         基础组件，主要包含编辑器组件和其他全局使用的组件
        |─ ─ guard                              身份验证
        |─ ─ model                              模型加载适配
        |─ ─ publish                            模块名称
            |─ ─ model                          模块名称
​                |─ ─  app                       项目模型
​                |─ ─  code-list                 代码表
​                |─ ─  entities                  实体模型
​                |─ ─  view-config               视图模型
​                |─ ─  view                      视图模型
            |─ ─ pages                          页面组件
​        |─ ─ main.ts                            入口文件
​        |─ ─ user-register.ts                   自定义组件全局注册
​    |─ ─ vite-plugins                           插件模型
        ​|─ ─ package.json                       依赖管理文件
        ​|─ ─ tsconfig.json                      TypeScript 项目的主要配置文件
        ​|─ ─ tsconfig.node.json                 Node.js 环境的 TypeScript 配置文件
​        |─ ─ vite.config.ts                     vite 配置文件
```

## 更新日志

每个版本的详细更改都记录在[发行说明](CHANGELOG.md)中。

## 如何贡献

如果你希望参与贡献，欢迎 [Pull Request](<https://github.com/iBizLab/plm-code/issues/new>)，或通过自助服务群给我们报告 Bug。

强烈推荐阅读 [《提问的智慧》](https://github.com/ryanhanwu/How-To-Ask-Questions-The-Smart-Way)(本指南不提供此项目的实际支持服务！)、[《如何向开源社区提问题》](https://github.com/seajs/seajs/issues/545) 和 [《如何有效地报告 Bug》](https://www.chiark.greenend.org.uk/~sgtatham/bugs-cn.html)、[《如何向开源项目提交无法解答的问题》](https://zhuanlan.zhihu.com/p/25795393)，更好的问题更容易获得帮助。

## 社区互助

- 欢迎加入iBizPLM交流QQ群：1067434627

## 常见问题

#### 1. 启动项目时，出现eslint报错，如何解决？
 
   解决方法: 将vite.config.ts部分代码注释，详见下图。<br>
   ![远程代理地址](sample/getting-started/problem.png)


