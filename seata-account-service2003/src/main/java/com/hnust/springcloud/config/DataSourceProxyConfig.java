package com.hnust.springcloud.config;

import org.springframework.context.annotation.Configuration;

/**
 * @Author EiletXie
 * @Since 2020/3/18 21:51
 * 使用Seata对数据源进行代理
 */
@Configuration
public class DataSourceProxyConfig {


//    @Bean
//    @Primary
//    public DataSourceProxy dataSourceProxy(DataSourceProperties properties){
//        HikariDataSource dataSource = properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
//        return new DataSourceProxy(dataSource);
//    }

    /*@Value("${mybatis.mapperLocations}")
    private String mapperLocations;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    @Bean
    public DataSourceProxy dataSourceProxy(DataSource druidDataSource) {
        return new DataSourceProxy(druidDataSource);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(DataSourceProxy dataSourceProxy) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSourceProxy);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources(mapperLocations));
        return bean.getObject();
    }*/
}


