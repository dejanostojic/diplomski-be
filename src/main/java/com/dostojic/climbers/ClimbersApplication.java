package com.dostojic.climbers;

import com.dostojic.climbers.logging.LoggingInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClimbersApplication {

  public static void main(String[] args) {
    SpringApplication.run(ClimbersApplication.class, args);
  }

  @Bean
  public LoggingInterceptor loggingInterceptor() {
    return new LoggingInterceptor();
  }
}
