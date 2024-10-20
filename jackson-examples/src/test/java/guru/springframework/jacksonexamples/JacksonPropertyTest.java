package guru.springframework.jacksonexamples;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.val;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by jt, Spring Framework Guru.
 */
public class JacksonPropertyTest {
    @Data
    @Builder
    @AllArgsConstructor
    @JsonIgnoreType
    public static class Address {
        private String addressLine1;
        private String city;
        private String state;
        private String zip;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @JsonIgnoreProperties({"ssn"})
    public static class Person {
        private String firstName;

        @JsonProperty("surname")
        private String lastName;
        private String phoneNumber;

        @JsonIgnore
        private LocalDate birthDate;
        private String ssn;
        private String email;
        private BigDecimal salary;
        private Address address;
    }

    @Test
    void testJsonProperties() throws JsonProcessingException {
        val person = Person.builder()
                .firstName("John")
                .lastName("Doe")
                .phoneNumber("123-456-7890")
                .birthDate(LocalDate.of(1970, 1, 1))
                .ssn("123-45-6789")
                .email("exmaple.com")
                .salary(new BigDecimal("75000.00"))
                .address(Address.builder()
                        .addressLine1("1234 Some Street")
                        .city("Some City")
                        .state("ST")
                        .zip("12345")
                        .build())
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(person));
    }
}
