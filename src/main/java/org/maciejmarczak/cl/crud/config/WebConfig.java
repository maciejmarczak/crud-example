package org.maciejmarczak.cl.crud.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan("org.maciejmarczak.cl.crud.web")
@Import(ThymeleafConfiguration.class)
public class WebConfig extends WebMvcConfigurerAdapter {
}
