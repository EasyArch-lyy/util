package aoptest.config;

import aoptest.aspect.RoleAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "aoptest")
@EnableAspectJAutoProxy
public class AopConfig {

    @Bean
    public RoleAspect getAspect() {
        return new RoleAspect();
    }
}
