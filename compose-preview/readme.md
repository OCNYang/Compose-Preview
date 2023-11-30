# 记录


#### debug 方法
./gradlew :app:build --no-daemon -Dorg.gradle.debug=true -Pkotlin.compiler.execution.strategy=in-process

参考：[https://github.com/google/ksp/issues/31](https://github.com/google/ksp/issues/31)


#### TODO

- [ ] 当一些自定义类没有提供参数时，可以去访问自动生成 OBES() 方法，用于生成参数的类实例
- [ ] 兼容 @Preview
- [ ] 在 @ComposePreview 添加标签，用于生成不同的文件中
- [ ] 添加 配置类，用于注解生成的主体配置
- [ ] 收集 @Preview 生成到一个布局中




#### Compose Navigation 路由[TODO]
/**
* 每个接口生成一个 NavHost
* 每个方法生成一个 composable; 可以考虑添加插值器
  */
  interface Route {// 路由名 == Screens
  fun home(url: String, id: Long) // 具体路由：方法名是路由名，参数是携带参数
  }
