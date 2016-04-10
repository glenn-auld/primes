package org.glenn.exercise.primegen;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
@ComponentScan("org.glenn.exercise.primegen")
public class SpringConfig {

    @Bean
    public ServletRegistrationBean dispatcherServlet(ApplicationContext applicationContext) {
        DispatcherServlet servlet = new DispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setThrowExceptionIfNoHandlerFound(true);
        return new ServletRegistrationBean(servlet, "/*");
    }
}
