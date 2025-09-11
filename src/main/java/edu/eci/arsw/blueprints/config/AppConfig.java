package edu.eci.arsw.blueprints.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import edu.eci.arsw.blueprints.services.BlueprintFilter;
import edu.eci.arsw.blueprints.services.RedundancyBlueprintFilter;
import edu.eci.arsw.blueprints.services.SubsamplingBlueprintFilter;

@Configuration
@ComponentScan(basePackages = {"edu.eci.arsw.blueprints"})
public class AppConfig {
    
    @Bean
	public BlueprintFilter blueprintFilter() {
        //return new RedundancyBlueprintFilter();
        return new SubsamplingBlueprintFilter();
	}

}
