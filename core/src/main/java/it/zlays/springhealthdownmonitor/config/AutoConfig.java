package it.zlays.springhealthdownmonitor.config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration(proxyBeanMethods = false)
@EnableJpaRepositories("it.zlays.springhealthdownmonitor.*")
@EntityScan("it.zlays.*")
@ComponentScan("it.zlays.springhealthdownmonitor.*")
public class AutoConfig {

}
