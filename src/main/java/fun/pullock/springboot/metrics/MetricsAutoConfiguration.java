package fun.pullock.springboot.metrics;

import fun.pullock.springboot.metrics.support.MetricsHttpServiceImpl;
import fun.pullock.springboot.metrics.support.MetricsInfluxdbServiceImpl;
import fun.pullock.springboot.metrics.support.MetricsMysqlServiceImpl;
import fun.pullock.springboot.metrics.support.MetricsService;
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
