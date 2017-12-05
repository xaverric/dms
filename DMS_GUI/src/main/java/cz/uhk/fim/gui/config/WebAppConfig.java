package cz.uhk.fim.gui.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login.html");
        registry.addViewController("/index").setViewName("index.html");
        registry.addViewController("/success-login").setViewName("success-login.html");
        registry.addViewController("/user/{username}").setViewName("user.html");
        registry.addViewController("/wrong-username-or-password").setViewName("wrong-username-or-password.html");
        registry.addRedirectViewController("/", "index");
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        super.configurePathMatch(configurer);
        configurer.setUseSuffixPatternMatch(false);
    }
}