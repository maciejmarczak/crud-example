package org.maciejmarczak.cl.crud.config;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import java.sql.SQLException;

@Configuration
@ComponentScan("org.maciejmarczak.cl.crud.core")
@EnableTransactionManagement
public class RootConfig {

    @Bean
    public JpaTransactionManager transactionManager(
            EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
        emfb.setPersistenceUnitName("crud-example");
        return emfb;
    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2ConsoleServer() throws SQLException {
        return Server.createWebServer("-web", "-webAllowOthers",
                "-webDaemon", "-webPort", "8082");
    }
}
