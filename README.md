# metrics-spring-boot-starter
application metrics collect 应用指标收集

# 命名
Spring文档建议官方的starter命名为：`spring-boot-starter-{name}`，非官方的starter命名为`{name}-spring-boot-starter`

# 使用
引入依赖：

```
<dependency>
    <groupId>me.cxis</groupId>
    <artifactId>metrics-spring-boot-starter</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

配置项：

```
metrics.type=mysql
metrics.mysql.url=jdbc:mysql://localhost
metrics.mysql.port=3306
metrics.mysql.username=root
metrics.mysql.password=123456
```

代码：

```
@Resource
private MetricsService metricsService;

public void testMetrics() {
    boolean result = metricsService.collect(
            Metrics.build("order_create")
                    .addProp("from", "mall")
                    .addProp("from_zh", "商城")
                    .addFactor("elapse", 100)
                    .addFactor("money", 100)
    );
}
```

代码使用来学习的，具体的收集功能没实现。