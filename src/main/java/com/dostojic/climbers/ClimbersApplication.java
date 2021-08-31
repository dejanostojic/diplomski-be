package com.dostojic.climbers;

import com.dostojic.climbers.logging.LoggingInterceptor;
import com.dostojic.climbers.repository.spring.data.adapter.config.RepositoryConfig;
import com.dostojic.climbers.rest.bff.config.RestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//(scanBasePackageClasses = {RestPackage.class, ClimbersApplication.class})
//@ComponentScan(basePackageClasses = {RestPackage.class, ClimbersApplication.class})
//@Import({RestConfig.class, RepositoryConfig.class})
public class ClimbersApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClimbersApplication.class, args);
    }



    @Bean
    public LoggingInterceptor loggingInterceptor() {
        return new LoggingInterceptor();
    }
}
