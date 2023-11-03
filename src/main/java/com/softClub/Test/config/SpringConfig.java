package com.softClub.Test.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.softClub.Test")
@EnableJpaRepositories("com.softClub.Test.repositories")
@EntityScan("com.softClub.Test.models")
@EnableWebMvc
public class SpringConfig {
}
