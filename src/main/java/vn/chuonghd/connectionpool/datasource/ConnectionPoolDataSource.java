package vn.chuonghd.connectionpool.datasource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.datasource.AbstractDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Define ConnectionPoolDataSource to use in the future. Using org.apache.commons.dbcp2.BasicDataSource
 * to apply connection pool. When it will get connection in the pool, after finish the transaction,
 * the connection will still in the pool and the status is sleep
 * Created by huynhduychuong on 4/1/2016.
 */
public class ConnectionPoolDataSource extends AbstractDataSource implements InitializingBean, DisposableBean {
    private BasicDataSource defaultDataSource;
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    @Override
    public Connection getConnection() throws SQLException {
        return defaultDataSource.getConnection();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return defaultDataSource.getConnection(username, password);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        defaultDataSource = new BasicDataSource();
        defaultDataSource.setDriverClassName(driverClassName);
        defaultDataSource.setUrl(url);
        defaultDataSource.setUsername(username);
        defaultDataSource.setPassword(password);
        defaultDataSource.addConnectionProperty("maxActive", "5");
        defaultDataSource.addConnectionProperty("maxIdle", "5");
        defaultDataSource.addConnectionProperty("maxWait", "10");
        defaultDataSource.addConnectionProperty("poolPreparedStatements", "true");
        defaultDataSource.addConnectionProperty("maxOpenPreparedStatements", "6");

    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

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

    @Override
    public void destroy() throws Exception {

        System.out.println("Destroying ConnectionPoolDataSource... ");

    }
}
