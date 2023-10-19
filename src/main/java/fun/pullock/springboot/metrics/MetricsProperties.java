package fun.pullock.springboot.metrics;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "metrics")
public class MetricsProperties {

    private String type = "mysql";

    private final MySql mysql = new MySql();

    private final Influxdb influxdb = new Influxdb();

    public Influxdb getInfluxdb() {
        return influxdb;
    }

    public MySql getMysql() {
        return mysql;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class Influxdb {
        private String url;
        private String username;
        private String password;
        private String database;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getDatabase() {
            return database;
        }

        public void setDatabase(String database) {
            this.database = database;
        }

        @Override
        public String toString() {
            return "Influxdb{" +
                    "url='" + url + '\'' +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", database='" + database + '\'' +
                    '}';
        }
    }

    public static class MySql {
        private String url;
        private String username;
        private String password;
        private int port;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }

        @Override
        public String toString() {
            return "MySql{" +
                    "url='" + url + '\'' +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", port=" + port +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "MetricsProperties{" +
                "type='" + type + '\'' +
                ", mySql=" + mysql +
                ", influxdb=" + influxdb +
                '}';
    }
}
