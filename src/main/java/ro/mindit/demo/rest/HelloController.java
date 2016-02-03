package ro.mindit.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Alex on 03.02.2016.
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public ResponseEntity getContent() {
        return new ResponseEntity("hello", HttpStatus.OK);
    }

}
