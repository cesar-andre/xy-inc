package br.com.xyinc.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@PropertySource("classpath:environment.properties")
@EnableWebMvc
@ComponentScan(basePackages = {"br.com.xyinc"})
public class AppWebConfiguration {

}
