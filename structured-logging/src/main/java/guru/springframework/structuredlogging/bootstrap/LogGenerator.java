package guru.springframework.structuredlogging.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by jt, Spring Framework Guru.
 */
@Slf4j
@Component
public class LogGenerator implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.trace("Trace log");
        log.debug("Debug log");
        log.info("Info log");
        log.warn("Hey, This is a warning!");
        log.error("Oops! We have an Error. OK");
//        String confidentialMarkerText = "CONFIDENTIAL";
//        Marker confidentialMarker = MarkerFactory.getMarker(confidentialMarkerText);
//        confidentialMarker.add(MarkerFactory.getMarker("bar"));
//        confidentialMarker.add(MarkerFactory.getMarker("another bar"));
//        log.error(confidentialMarker, "asdf");
//        log.atError().addMarker(confidentialMarker).log("asdf");
//        log.atError().setMessage("this is an error").addKeyValue("user", "john").log();
    }
}
