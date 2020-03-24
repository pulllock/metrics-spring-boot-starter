package me.cxis.springboot.metrics.support;

import me.cxis.springboot.metrics.MetricsProperties;

/**
 * 使用mysql收集应用指标
 */
public class MetricsMysqlServiceImpl implements MetricsService {

    private MetricsProperties metricsProperties;

    public MetricsMysqlServiceImpl(MetricsProperties metricsProperties) {
        this.metricsProperties = metricsProperties;
    }

    public boolean collect(Metrics metrics) {
        System.out.println("使用mysql收集应用的指标");
        System.out.println(String.format("mysql配置：%s", metricsProperties));
        System.out.println(String.format("收集到的数据：%s", metrics));
        return false;
    }
}
