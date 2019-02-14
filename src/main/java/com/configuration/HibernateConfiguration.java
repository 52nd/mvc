package com.configuration;

import com.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@org.springframework.context.annotation.Configuration
public class HibernateConfiguration {

    @Bean
    public SessionFactory getSessionFactory() {
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(User.class);
        return configuration.buildSessionFactory();
    }

}
