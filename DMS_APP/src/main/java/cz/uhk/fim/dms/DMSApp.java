package cz.uhk.fim.dms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages={"cz.uhk.fim"})
@EntityScan("cz.uhk.fim.repository.entity")
public class DMSApp {

    public static void main(String[] args) {
        SpringApplication.run(DMSApp.class, args);
    }
}
