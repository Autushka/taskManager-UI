package mainUi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@Configuration // needed to specify that the class contains global spring configurations
@ComponentScan
@EnableAutoConfiguration
@EnableTransactionManagement
@RestController // needed to enable rest end points within the class
@SpringBootApplication
public class MainUiSeedApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MainUiSeedApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MainUiSeedApplication.class, args);
    }

    @Inject
    private AppConfig configBean;

    @RequestMapping(value = "/config", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public AppConfig getConfig(){
        return configBean;
    }
}
