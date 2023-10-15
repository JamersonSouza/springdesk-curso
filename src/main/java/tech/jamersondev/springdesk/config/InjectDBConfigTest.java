package tech.jamersondev.springdesk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import tech.jamersondev.springdesk.services.InjectDB;

@Configuration
@Profile("test")
public class InjectDBConfigTest {

     @Autowired
    private InjectDB injectDB;

    @Bean
    public void injectDbinfos(){
        this.injectDB.injectDBTest();
    }


    
}
