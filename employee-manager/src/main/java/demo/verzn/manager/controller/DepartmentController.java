package demo.verzn.manager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author adarshbhattarai on 2021-04-25
 * @project zuuleureka
 */
@RestController
public class DepartmentController {

    @GetMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> test() throws Exception {
        return new ResponseEntity<String>("Data received", HttpStatus.OK);
    }

    @RequestMapping(value = "/isAvailable")
    public String available() {
        return "Manager is up and running";
    }



}
