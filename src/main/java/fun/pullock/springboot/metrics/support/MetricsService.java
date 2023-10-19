package fun.pullock.springboot.metrics.support;

/**
 * 应用指标收集服务
 */
public interface MetricsService {

    /**
     * 收集应用指标
     * @param metrics 指标
     * @return true or false
     */
    boolean collect(Metrics metrics);

}
