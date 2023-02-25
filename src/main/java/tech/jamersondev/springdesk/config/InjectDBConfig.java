package tech.jamersondev.springdesk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tech.jamersondev.springdesk.services.InjectDB;

@Configuration
public class InjectDBConfig {

    @Autowired
    private InjectDB injectDB;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String value;

    @Bean
    public boolean injectDbinfos(){
        if(value.equals("create")){
            this.injectDB.injectDB();
        }
        return false;
    }
    
    
    
}
