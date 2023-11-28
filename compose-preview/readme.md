# 记录


#### debug 方法
./gradlew :app:build --no-daemon -Dorg.gradle.debug=true -Pkotlin.compiler.execution.strategy=in-process

参考：[https://github.com/google/ksp/issues/31](https://github.com/google/ksp/issues/31)


#### TODO

- [ ] 当一些自定义类没有提供参数时，可以去访问自动生成 OBES() 方法，用于生成参数的类实例
- [ ] 兼容 @Preview
- [ ] 在 @ComposePreview 添加标签，用于生成不同的文件中
- [ ] 添加 配置类，用于注解生成的主体配置
