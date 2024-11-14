package guru.springframework.structuredlogging.log;

import ch.qos.logback.classic.spi.ILoggingEvent;
import org.springframework.boot.json.JsonWriter;
import org.springframework.boot.logging.structured.StructuredLogFormatter;

/**
 * Created by jt, Spring Framework Guru.
 */
public class JsonLogger implements StructuredLogFormatter<ILoggingEvent> {
    private final JsonWriter<ILoggingEvent> writer = JsonWriter.<ILoggingEvent>of((members) -> {
        members.add("level", ILoggingEvent::getLevel);
        members.add("time", ILoggingEvent::getTimeStamp);
        members.add("message", ILoggingEvent::getFormattedMessage);
        members.add("applicationInfo").usingMembers((applicationInfo) -> {
            applicationInfo.add("name", "StructuredLoggingApplication");
            applicationInfo.add("version", "1.0.0-SNAPSHOT");
        });

    }).withNewLineAtEnd();

    @Override
    public String format(ILoggingEvent event) {
        return this.writer.writeToString(event);
    }
}
