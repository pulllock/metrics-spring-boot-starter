package fun.pullock.springboot.metrics.support;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 应用指标实体类
 *
 * 比如：收集创建订单的数据
 * tag = order_create_data
 *
 * 来源：商城，是否成功：T
 * props = {"from":"mall", "success":"T"}
 *
 * 耗时：100，数量：1
 * factors = {"elapse": 100, "count": 1}
 */
public class Metrics implements Serializable {

    private static final long serialVersionUID = -2467036753370119476L;

    /**
     * 标签，用来表示一类数据
     */
    private String tag;

    /**
     * 指标的属性
     */
    private List<MetricsProps> props;

    /**
     * 指标的一些度量因子
     */
    private List<MetricsFactor> factors;

    public Metrics() {

    }

    public static Metrics build(String tag) {
        Metrics metrics = new Metrics();
        metrics.tag = tag;
        return metrics;
    }

    public Metrics addProp(String key, String value) {
        if (this.props == null) {
            this.props = new ArrayList<MetricsProps>();
        }

        this.props.add(new MetricsProps(key, value));
        return this;
    }

    public Metrics addFactor(String key, int value) {
        return addFactorInternal(key, value);
    }

    public Metrics addFactor(String key, long value) {
        return addFactorInternal(key, value);
    }

    public Metrics addFactor(String key, boolean value) {
        return addFactorInternal(key, value);
    }

    public Metrics addFactor(String key, double value) {
        return addFactorInternal(key, value);
    }

    public Metrics addFactor(String key, float value) {
        return addFactorInternal(key, value);
    }

    public Metrics addFactor(String key, String value) {
        return addFactorInternal(key, value);
    }

    public Metrics addFactor(String key, short value) {
        return addFactorInternal(key, value);
    }

    public Metrics addFactor(String key, char value) {
        return addFactorInternal(key, value);
    }

    private Metrics addFactorInternal(String key, Serializable value) {
        if (this.factors == null) {
            this.factors = new ArrayList<MetricsFactor>();
        }

        this.factors.add(new MetricsFactor(key, value));
        return this;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<MetricsProps> getProps() {
        return props;
    }

    public void setProps(List<MetricsProps> props) {
        this.props = props;
    }

    public List<MetricsFactor> getFactors() {
        return factors;
    }

    public void setFactors(List<MetricsFactor> factors) {
        this.factors = factors;
    }

    @Override
    public String toString() {
        return "Metrics{" +
            "tag='" + tag + '\'' +
            ", props=" + props +
            ", factors=" + factors +
            '}';
    }
}
