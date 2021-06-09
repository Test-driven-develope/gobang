# 五子棋小游戏

本仓库用于实现一个命令行版五子棋小游戏，所用开发语言为Kotlin/Java，为TDD(测试驱动开发) WorkShop提供实现案例。

本案例使用敏捷看板进行管理开发，请点击这里进入看板[五子棋需求看板]()

## 你该怎么做？

### Step 1: Clone此仓库

请`clone`此到你本地：`git clone https://github.com/Jinghua-Li/gobang.git`

### Step 2: 构建此项目

请使用命令`./gradlew clean build`来下载相关依赖并构建此项目

### step 3: 运行此游戏

在项目根目录下运行命令`java -jar ./build/libs/gobang-1.0-SNAPSHOT.jar`运行此游戏, 有如下输出可以认为你本地已经搭建成功：

```bash
欢迎来到五子连珠小游戏，分为黑子(◉)和白子(◯):
  0 1 2 3 4 5 6 7 8 9
0 ┌─┬─┬─┬─┬─┬─┬─┬─┬─┐
1 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
2 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
3 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
4 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
5 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
6 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
7 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
8 ├─┼─┼─┼─┼─┼─┼─┼─┼─┤
9 └─┴─┴─┴─┴─┴─┴─┴─┴─┘
请黑子(◉)输入行列坐标(如3,4):
```

### Step 4：和你的小伙伴一起试玩一下此游戏


### Step 5：使用`IntellJ Idea`打开此项目

使用`IntellJ Idea`打开此项目，等待相关依赖导入成功，之后切换到`tdd`分支进行开发。

## 分支管理说明

此项目总共两个分支：

* **main分支：** 此分支已经实现了此游戏，用于大家进行参考和本地试玩
* **tdd分支：** 此分支有部分实现，用于TDD学习者来练习开发的分支。


