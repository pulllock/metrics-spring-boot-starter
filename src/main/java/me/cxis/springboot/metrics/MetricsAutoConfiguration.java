package me.cxis.springboot.metrics;

import me.cxis.springboot.metrics.support.MetricsHttpServiceImpl;
import me.cxis.springboot.metrics.support.MetricsInfluxdbServiceImpl;
import me.cxis.springboot.metrics.support.MetricsMysqlServiceImpl;
import me.cxis.springboot.metrics.support.MetricsService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
@ConditionalOnClass({MetricsService.class})
@EnableConfigurationProperties({MetricsProperties.class})
public class MetricsAutoConfiguration {

    @Resource
    private MetricsProperties metricsProperties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "metrics.type", havingValue = "mysql")
    public MetricsService metricsMysqlService() {
        return new MetricsMysqlServiceImpl(metricsProperties);
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "metrics.type", havingValue = "influxdb")
    public MetricsService metricsInfluxdbService() {
        return new MetricsInfluxdbServiceImpl(metricsProperties);
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "metrics.type", havingValue = "http")
    public MetricsService metricsHttpService() {
        return new MetricsHttpServiceImpl(metricsProperties);
    }
}
