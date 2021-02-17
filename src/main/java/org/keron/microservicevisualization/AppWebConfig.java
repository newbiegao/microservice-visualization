package org.keron.microservicevisualization;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppWebConfig implements WebMvcConfigurer {

    @Value("${micro.vis.index}")
    private String index ;

    @Override
    public void addViewControllers(ViewControllerRegistry registry){

        registry.addViewController("/").setViewName(index);

    }
}
