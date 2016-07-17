# 简易Java构建 with Travis-CI && Gradle

在 IDEA 中使用 Gradle 构建工具，自动 build 后，目录结构如下：  

    project
    |--.gradle
    |--.idea
    |--gradle
    |--build.gradle
    |--gradlew
    |--gradlew.bat
    |--settings.gradle

在编码前建立标准的 Maven 结构目录：

    project
    |--.gradle
    |--.idea
    |--gradle
    |--src
       |--main
       |  |--java
       |     |--Example.java
       |--test
          |--java
             |--ExampleTest.java
    |--build.gradle
    |--gradlew
    |--gradlew.bat
    |--settings.gradle

### Gradle 部分
在编码过程后进行第一次构建，在 IDEA 的 Terminal 中运行：  

    ./gradlew clean
    ./gradlew build

运行测试为：

    ./gradlew test

此时目录结构变为  

    project
    |--.gradle
    |--.idea
    |--build
    |--gradle
    |--src
       |--main
       |  |--java
       |     |--Example.java
       |--test
          |--java
             |--ExampleTest.java
    |--build.gradle
    |--gradlew
    |--gradlew.bat
    |--settings.gradle

### Travis-CI 部分

在 Travis-CI 中添加 Github 中的仓库，在本地 commit 之前添加 .gitignore 与构建有关的文件仅保留 build.gradle 与 .travis.yml 。

建立 .gradle.yml 文件。文件中可以只有如下内容：

    language: java
    jdk: oraclejdk8
    script: gradle test

在每次构建时，Travis-CI 会自动运行测试，如果测试失败，则本次构建也会失败。

### 关于测试覆盖率

Gradle 的测试覆盖率生成需要用到 jacoco 插件。在 IDEA 中通过修改 build.gradle 文件来实现，不需要自己进行配置。

在 build.gradle 文件末加入如下内容：

    apply plugin: "application"
    apply plugin: "jacoco"
    mainClassName = "org.gradle.MyMain"

    jacoco{
        toolVersion = "0.7.1.201405082137"
        reportsDir = file("$buildDir/jacocoReports")
    }
在 IDEA Terminal 中运行

    ./gradlew test

后，即可在 build/jacocoReports/test/html 中看到测试覆盖率报告。
