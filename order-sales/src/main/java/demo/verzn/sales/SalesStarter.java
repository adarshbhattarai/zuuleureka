package demo.verzn.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author adarshbhattarai on 2021-04-25
 * @project zuuleureka
 */
@SpringBootApplication
@RestController
@EnableEurekaClient
public class SalesStarter {

    public static void main(String[] args) {
        SpringApplication.run(SalesStarter.class,args);
    }

    @Bean
    public RestTemplate buildRestTemplate(){
        return new RestTemplate();
    }

    @GetMapping(value = "/sales", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> test() throws Exception {
        return new ResponseEntity<String>("Sales Data Received", HttpStatus.OK);
    }

    @RequestMapping(value = "/isAvailable")
    public String available(){
        return "Sales is up and running";
    }
}
