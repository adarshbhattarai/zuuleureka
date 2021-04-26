package demo.verzn.zuulgateway;

import com.netflix.discovery.converters.Auto;
import demo.verzn.zuulgateway.filters.pre.SimpleFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author adarshbhattarai on 2021-04-25
 * @project zuuleureka
 */

@SpringBootApplication
//@EnableZuulProxy
//@EnableEurekaClient
@RestController
public class EdgeServer {

    @Autowired
    DiscoveryClient discoveryClient;

    public static void main(String[] args) {
        SpringApplication.run(EdgeServer.class, args);
    }

    /**
     * Different Filters:
     * pre
     * route
     * error
     * post
     */
    @Bean
    public SimpleFilter simpleFilter() {
        return new SimpleFilter();
    }

    @RequestMapping("/clients/{applicationName}")
    public @ResponseBody String getClientsByApplicationName(@PathVariable String applicationName) {
        System.out.println(applicationName);
        return this.discoveryClient.getInstances(applicationName).get(0).getUri().toString();
    }


    @Bean
    public RestTemplate buildRestTemplate(){
        return new RestTemplate();
    }
}
