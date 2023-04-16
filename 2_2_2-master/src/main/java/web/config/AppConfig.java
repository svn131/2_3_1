package web.config;


import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;




@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScan(value = "web")
public class AppConfig {


    private Environment env;

    @Autowired
    public AppConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }



    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
        return jpaTransactionManager;
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(getDataSource());
        em.setPackagesToScan(env.getRequiredProperty("db.entity.package")); /////  ???????????
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(getHibernateProperties());
        return em;
    }


    @Bean
    public DataSource getDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(env.getRequiredProperty("db.url"));
        ds.setDriverClassName(env.getRequiredProperty("db.driver"));
        ds.setUsername(env.getRequiredProperty("db.username"));
        ds.setPassword(env.getRequiredProperty("db.password"));
        return ds;
    }

    public Properties getHibernateProperties() {


        try {
            Properties properties = new Properties();
            InputStream is = getClass().getClassLoader().getResourceAsStream("hibernate.properties");
            properties.load(is);
            return properties;
        } catch (IOException e) {
            try {
                throw new IOException(e);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

    }

}


































//
//
//@Configuration
//@PropertySource("classpath:db.properties")
//@ComponentScan("web")
//@EnableTransactionManagement
//public class AppConfig {
//
//    @Autowired
//    private Environment environment;
//
//    @Autowired
//    private ObjectProvider<EntityManagerFactory> entityManagerFactoryProvider;
//
//
////        public AppConfig(Environment env) {
////        this.environment = environment;
////    }
//
//    @Bean
//    public DataSource getDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(environment.getProperty("db.driver"));
//        dataSource.setUrl(environment.getProperty("db.url"));
//        dataSource.setUsername(environment.getProperty("db.username"));
//        dataSource.setPassword(environment.getProperty("db.password"));
//
//        return dataSource;
//    }
//
//    @Bean
//    public JdbcTemplate jdbcTemplate() {
//        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//        jdbcTemplate.setDataSource(getDataSource());
//        return jdbcTemplate;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Environment environment) {
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setGenerateDdl(true);
//
//        Properties properties = new Properties();
//        properties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
//        properties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
//        properties.put("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
//        properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.update"));
//
//        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactoryBean.setDataSource(dataSource);
//        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
//        entityManagerFactoryBean.setJpaProperties(properties);
//        entityManagerFactoryBean.setPackagesToScan("web");
//        entityManagerFactoryBean.setPersistenceUnitName("MyPU");
//
//        return entityManagerFactoryBean;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        return new JpaTransactionManager(entityManagerFactoryProvider.getIfAvailable());
//    }
//}











































//    @Bean
//    public DataSource getDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(env.getProperty("db.driver"));
//        dataSource.setUrl(env.getProperty("db.url"));
//        dataSource.setUsername(env.getProperty("db.username"));
//        dataSource.setPassword(env.getProperty("db.password"));
//        return dataSource;
//    }
//
//    @Bean
//    public LocalSessionFactoryBean getSessionFactory() {
//        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
//        factoryBean.setDataSource(getDataSource());
//
//        Properties props = new Properties();
//        props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
//        props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
//
//        factoryBean.setHibernateProperties(props);
//        factoryBean.setAnnotatedClasses(User.class);
//        return factoryBean;
//    }
//
//    @Bean
//    public HibernateTransactionManager getTransactionManager() {
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(getSessionFactory().getObject());
//        return transactionManager;
//    }
//}
