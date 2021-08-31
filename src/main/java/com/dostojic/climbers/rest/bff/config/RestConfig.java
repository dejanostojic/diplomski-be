package com.dostojic.climbers.rest.bff.config;

import com.dostojic.climbers.rest.bff.RestPackage;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by planina on 1.8.21..
 */
@Configuration
@ComponentScan(basePackageClasses = RestPackage.class)
public class RestConfig {

    public static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SS'Z'";


}
