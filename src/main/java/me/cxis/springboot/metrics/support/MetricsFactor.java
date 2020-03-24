package me.cxis.springboot.metrics.support;

import java.io.Serializable;

/**
 * 指标的度量因子
 */
public class MetricsFactor implements Serializable {

    private static final long serialVersionUID = -8216802714759621837L;

    private String key;

    private Serializable value;

    public MetricsFactor(String key, Serializable value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Serializable getValue() {
        return value;
    }

    public void setValue(Serializable value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MetricsFactor{" +
            "key='" + key + '\'' +
            ", value=" + value +
            '}';
    }
}
