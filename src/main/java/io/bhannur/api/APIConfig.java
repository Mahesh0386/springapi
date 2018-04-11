package io.bhannur.api;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
@ComponentScan
@EnableWebMvc
public class APIConfig {


    public static class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


        @Override
        protected Class<?>[] getRootConfigClasses() {
            return new Class[] {APIConfig.class};
        }

        @Override
        protected Class<?>[] getServletConfigClasses() {
            return new Class[0];
        }

        @Override
        protected String[] getServletMappings() {
            return new String[] {"/api/*"};
        }
    }
}
