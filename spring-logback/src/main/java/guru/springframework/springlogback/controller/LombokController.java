package guru.springframework.springlogback.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by jt, Spring Framework Guru.
 */

@Slf4j
@RestController
public class LombokController {
    @RequestMapping(value = "/lombok" )
    Map<String, String> index(){
        log.trace("This is a trace message");
        log.debug("This is a debug message");
        log.info("This is an info message");
        log.warn("This is a warn message");
        log.error("This is an error message");

        return Map.of("message", "Hello, World!");
    }
}
