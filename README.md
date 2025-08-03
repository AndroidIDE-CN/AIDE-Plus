![AIDEPlus](https://socialify.git.ci/AndroidIDE-CN/AIDE-Plus/image?description=1&font=KoHo&forks=1&issues=1&logo=https%3A%2F%2Fraw.githubusercontent.com%2FAndroidIDE-CN%2FAIDE-Plus%2Frefs%2Fheads%2F2.3%2F.idea%2Ficon.svg&name=1&owner=1&pattern=Circuit+Board&pulls=1&stargazers=1&theme=Auto)

# AIDE-Plus
因为懂的都懂的原因，现将AIDE Plus源码闭源，不在开源，这个仓库以后只用来发布新版本。
Because of the reason that everyone understands, the AIDE Plus source code is now closed source, not open source, and this repository will only be used to release new versions in the future.

# 补充
因为发现有人不遵守AGPL协议，因此所有作者一致决定闭源。我当初也只是让所有对AIDE有兴趣的人可以定制自己的AIDE，但是使用本项目源码，却不遵守AGPL协议且使用加壳技术，让我放弃分享了。
不会影响后续版本的推送。

Because it was discovered that someone did not comply with the AGPL protocol,all authors have unanimously decided to close the source code. My original intention was to allow anyone interested in AIDE to customize their own version, but some users utilized this project's source code without adhering to the AGPL license and even packed the software with protective shells. This has led me to abandon further code sharing. This decision will not affect subsequent version updates.


## 🪪 仓库信息
[![GitHub contributors](https://img.shields.io/github/contributors/AndroidIDE-CN/AIDE-Plus)](https://github.com/AndroidIDE-CN/AIDE-Plus/graphs/contributors)
[![GitHub last commit](https://img.shields.io/github/last-commit/AndroidIDE-CN/AIDE-Plus)](https://github.com/AndroidIDE-CN/AIDE-Plus/commits/)
[![Repository Size](https://img.shields.io/github/repo-size/AndroidIDE-CN/AIDE-Plus)](https://github.com/AndroidIDE-CN/AIDE-Plus)
[![GitHub Release](https://img.shields.io/github/v/release/AndroidIDE-CN/AIDE-Plus)](https://github.com/AndroidIDE-CN/AIDE-Plus/releases)
[![Total downloads](https://img.shields.io/github/downloads/AndroidIDE-CN/AIDE-Plus/total)](https://github.com/AndroidIDE-CN/AIDE-Plus/releases)

## 📝 已实现功能
- [x] 构建服务优化和重写
- [x] aapt更替为aapt2
- [x] dx更替为D8
- [x] 一些Java8语法的实现(默认语法分析)
- [x] 一些Java9语法的实现(默认语法分析)
- [x] 一些Java11语法的实现(默认语法分析)
- [x] Java23编译(通过ecj实现，需要设置开启)
- [x] Java高版本格式化(通过ecj实现，需要设置开启)
- [x] 自定义class解析器，以实现高版本的class特性
- [x] 实现了`runtimeOnly`，`compileOnly`，`libgdxNatives`
- [x] 重写Gradle解析器
- [x] 新的Maven下载器(bom已支持)
- [x] 应用冷启动优化
- [x] 添加更多语法高亮
- [x] 使用D8进行混淆
- [x] AIDE默认框架替换为Androidx
- [x] 还原了部分AIDE的dex混淆
- [x] 代码自定义颜色
- [x] ViewBinding支持
- [x] DateBinding支持
- [x] 清单合并工具更新
- [x] 修复静默安装和支持更多安装器(shizuku)
- [x] 新UI的实现
- [x] 修复了补全和高亮丢失问题
- [x] 修复了创建签名的问题
- [x] ApkSign支持了的v1-v3签名
- [x] 新增一些基础的语法补全
- [x] 修复软件内的git问题
- [x] apk资源对齐
- [x] Java项目支持安卓api
- [x] Lambda实现 (ecj) [fbf450d](https://github.com/AndroidIDE-CN/AIDE-Plus/commit/fbf450dba15ccaf51a7a6dd77db300d50551e98b)
- [x] 支持cmake构建 [e702347](https://github.com/AndroidIDE-CN/AIDE-Plus/commit/e702347df0c10b718df5aeb4798402802334e310)
- [x] Xml补全修改逻辑 [0ecb637](https://github.com/AndroidIDE-CN/AIDE-Plus/commit/f7960418b9326231d55726514f10385396e9e8b6)
- [x] 支持 exclude (exclude group: "xxx", module: "xxx")

### 🏗️ 计划实现
- [ ] 更多补全 (Lsp)
- [ ] Apks/AAB的生成(未添加)
- [ ] 清单文件编辑
- [ ] 矢量图获取
- [ ] 重写布局可视化


## 🌠 相关资源
- [AIDE-Ndk-Install](https://github.com/ZeroAicy/AIDE-Ndk-Install) NDK安装器
- [AIDE-Repair](https://github.com/ZeroAicy/AIDE-Repair) 反混淆

# 📬️ 相关信息
- QQ群
  * [487145957](https://qm.qq.com/q/W0WJq5qne2)
  * [1002980489](https://qm.qq.com/q/W0WJq5qne2) 
- [QQ频道](https://pd.qq.com/s/auq589py2)
- [网站](https://plus.androidide.cn)

# 🏅 特别感谢
> [!TIP]
> 如果没有看到您或者您的项目可以联系我们添加上去
### 😎 项目相关
- [@墨凡尘轩](https://github.com/ZeroAicy) 项目创始人
- [@烂泥扶上墙](https://github.com/eirv) 项目合作者
- [@原罪](https://github.com/neu233) 项目合作者
- [@0047ol](https://github.com/0047ol) 项目合作者
- [@梔锿-雨桐](https://iyutong.cn) 项目合作者
- [@hujiayucc](https://github.com/hujiayucc) 项目合作者
- [@dev-bz](https://github.com/dev-bz) (不知者来此) 提供了帮助
### 🐱 开源集成
- [Gradle项目](https://github.com/neu233/AIDE-Plus) AS版本
- [AndroidIDE](https://github.com/AndroidIDEOfficial/AndroidIDE) 借鉴了部分代码
- [CodeAssist](https://github.com/tyron12233/CodeAssist) 借鉴了部分代码
- [Termux-app](https://github.com/termux/termux-app) 集成到软件内部
- [AIDE-Pro](https://github.com/AndroidIDE-CN/) 借鉴UI

