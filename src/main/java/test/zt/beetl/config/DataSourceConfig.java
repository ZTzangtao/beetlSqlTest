package test.zt.beetl.config;

import com.alibaba.druid.pool.DruidDataSource;
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

    @Bean(name = "datasource")
    public DataSource datasource(Environment env) {
        DruidDataSource ds = new DruidDataSource();
        ds.setUrl(env.getProperty("spring.datasource.url"));
        ds.setUsername(env.getProperty("spring.datasource.username"));
        ds.setPassword(env.getProperty("spring.datasource.password"));
        ds.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        return ds;
    }

}
