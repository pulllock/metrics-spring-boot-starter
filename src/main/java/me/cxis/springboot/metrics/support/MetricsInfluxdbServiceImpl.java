package me.cxis.springboot.metrics.support;

import me.cxis.springboot.metrics.MetricsProperties;

/**
 * 使用Influxdb收集应用指标
 */
public class MetricsInfluxdbServiceImpl implements MetricsService {

    private MetricsProperties metricsProperties;

    public MetricsInfluxdbServiceImpl(MetricsProperties metricsProperties) {
        this.metricsProperties = metricsProperties;
    }

    public boolean collect(Metrics metrics) {
        System.out.println("使用influxdb收集应用的指标");
        System.out.println(String.format("influxdb配置：%s", metricsProperties));
        System.out.println(String.format("收集到的数据：%s", metrics));
        return false;
    }
}
