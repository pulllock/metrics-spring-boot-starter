package me.cxis.springboot.metrics.support;

import java.io.Serializable;

/**
 * 指标的属性
 */
public class MetricsProps implements Serializable {

    private static final long serialVersionUID = -8828143390564259702L;

    private String key;

    private String value;

    public MetricsProps(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MetricsProps{" +
            "key='" + key + '\'' +
            ", value='" + value + '\'' +
            '}';
    }
}
