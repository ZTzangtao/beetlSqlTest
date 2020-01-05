package test.zt.beetl.config;


import com.ibeetl.starter.BeetlSqlMutipleSourceCustomize;
import com.zaxxer.hikari.HikariDataSource;
import org.beetl.sql.core.DefaultConnectionSource;
import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * @author zangtao
 * @date 2020/1/2 10:37
 */
@Configuration
public class DataSourceConfig {

    @Autowired
    private ApplicationContext ctx;

    /**
     * 配置数据源
     *
     * @param env
     * @return
     */
    @Primary
    @Bean(name = "a")
    public DataSource datasource(Environment env) {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(env.getProperty("spring.datasource.url"));
        ds.setUsername(env.getProperty("spring.datasource.username"));
        ds.setPassword(env.getProperty("spring.datasource.password"));
        ds.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        return ds;
    }

    @Bean(name = "a-1")
    public DataSource slaveDatasource(Environment env) {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(env.getProperty("spring.datasource.url"));
        ds.setUsername(env.getProperty("spring.datasource.username"));
        ds.setPassword(env.getProperty("spring.datasource.password"));
        ds.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        return ds;
    }

    @Bean
    public BeetlSqlMutipleSourceCustomize beetlSqlCustomize() {
        return new BeetlSqlMutipleSourceCustomize() {
            @Override
            public void customize(String dataSource, SQLManager sqlManager) {
                if(dataSource.equals("a")){
                    DefaultConnectionSource defaultConnectionSource = (DefaultConnectionSource)sqlManager.getDs();
                    DataSource slave = (DataSource)ctx.getBean("a-1");
                    defaultConnectionSource.setSlaves(new DataSource[]{slave});
                }
            }
        };
    }

}
