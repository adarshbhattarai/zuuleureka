package demo.verzn.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author adarshbhattarai on 2021-04-25
 * @project zuuleureka
 */
@SpringBootApplication
@RestController
@EnableEurekaClient
public class SalesStarter {

    @Autowired
    OrderRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SalesStarter.class,args);
    }

    @Bean
    public RestTemplate buildRestTemplate(){
        return new RestTemplate();
    }

    @GetMapping(value = "/get-order", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Sorder>> getAllOrder(){
        List<Sorder> returnValue= new ArrayList<>();
        repository.findAll().forEach(returnValue::add);
        return new ResponseEntity<List<Sorder>>(returnValue, HttpStatus.OK);
    }

    @PostMapping(value = "/add-order", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addSalesOrder(@RequestBody Sorder salesorder){
        repository.save(salesorder);
        return new ResponseEntity<String>("Added successfully", HttpStatus.OK);
    }
}
