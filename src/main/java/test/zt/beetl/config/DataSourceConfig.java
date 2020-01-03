package test.zt.beetl.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.beetl.sql.ext.spring4.BeetlSqlScannerConfigurer;
import org.springframework.boot.jdbc.DataSourceBuilder;
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
    /**
     * 配置数据源
     *
     * @param env
     * @return
     */
//    @Bean(name = "datasource")
//    public DataSource datasource(Environment env) {
//        DruidDataSource ds = new DruidDataSource();
//        ds.setUrl(env.getProperty("spring.datasource.url"));
//        ds.setUsername(env.getProperty("spring.datasource.username"));
//        ds.setPassword(env.getProperty("spring.datasource.password"));
//        ds.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
//        return ds;
//    }

//    @Bean(name= "beetlSqlScannerConfigurer")
//    public BeetlSqlScannerConfigurer getBeetlSqlScannerConfigurer(Environment env){
//        BeetlSqlScannerConfigurer conf = new BeetlSqlScannerConfigurer();
//        conf.setBasePackage(env.getProperty("beetlsql.basePackage"));
//        conf.setDaoSuffix(env.getProperty("beetlsql.daoSuffix"));
//        conf.setSqlManagerFactoryBeanName("sqlManageFactoryBean");
//        return conf;
//    }

}
