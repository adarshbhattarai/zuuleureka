package demo.verzn.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author adarshbhattarai on 2021-04-25
 * @project zuuleureka
 *
 * @EnableEurekaClient is essentially
 * similar to @EnableDiscoveryClient
 * when using eureka.
 * Discovery client lives in spring-cloud-commons
 * There are multiple discovery services (Zookeeper, eureka, consul)
 *
 * @EnableEurekaClient lives in spring-cloud-netflix and only works for eureka
 */
@SpringBootApplication
@EnableEurekaClient
public class EmployeeStarter {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeStarter.class,args);
    }

}
