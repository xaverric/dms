package cz.uhk.fim.dms;

import cz.uhk.fim.dms.tools.InitialDataSet;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.templateresolver.TemplateResolver;

@SpringBootApplication(scanBasePackages = {"cz.uhk.fim"})
@EntityScan("cz.uhk.fim.repository.entity")
public class DMSApp {

    @Autowired
    private InitialDataSet initialDataSet;

    public static void main(String[] args) {
        SpringApplication.run(DMSApp.class, args);
    }

    @Bean
    InitializingBean init() {
        return initialDataSet.load();
    }
}

