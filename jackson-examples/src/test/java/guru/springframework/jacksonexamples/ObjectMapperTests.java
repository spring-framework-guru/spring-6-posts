package guru.springframework.jacksonexamples;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Created by jt, Spring Framework Guru.
 */
public class ObjectMapperTests {

    @Test
    void testMapToJson() throws JsonProcessingException {
        Map<String, Object> person = Map.of(
                "firstName", "Jimmy",
                "lastName", "Buffett",
                "address", Map.of(
                        "addressLine1", "500 Duval Street",
                        "city", "Key West",
                        "state", "FL",
                        "zip", "33040"
                )
        );

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(person));
    }

    // test to read JSON to map
    @Test
    void testJsonToMap() throws JsonProcessingException {
        String json = """
                {"lastName":"Buffett","address":{"city":"Key West","zip":"33040","addressLine1":"500 Duval Street","state":"FL"},"firstName":"Jimmy"}""";

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> person = objectMapper.readValue(json, Map.class);
        System.out.println(person);
    }

    //test to read JSON to JsonNode
    @Test
    void testJsonToNode() throws JsonProcessingException {
        String json = """
                {"lastName":"Buffett","address":{"city":"Key West","zip":"33040","addressLine1":"500 Duval Street","state":"FL"},"firstName":"Jimmy"}""";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode person = objectMapper.readTree(json);
        System.out.println(person);
        System.out.println(person.get("firstName").asText());
        System.out.println(person.get("address").get("city").asText());
    }

    // test to read json to person object
    @Test
    void testJsonToObject() throws JsonProcessingException {
        String json = """
                {"firstName":"Jimmy","lastName":"Buffett","address":{"addressLine1":"500 Duval Street","city":"Key West","state":"FL","zip":"33040"}}""";

        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(json, Person.class);
        System.out.println(person);
    }

    // test to read json array to list of person POJOs
    @Test
    void testJsonArrayToListOfObjects() throws JsonProcessingException {
        String json = """
                [{"firstName":"Jimmy","lastName":"Buffett","address":{"addressLine1":
                "500 Duval Street","city":"Key West","state":"FL","zip":"33040"}},
                {"firstName":"Jimmy","lastName":"Buffett","address":{"addressLine1":
                "500 Duval Street","city":"Key West","state":"FL","zip":"33040"}}]""";

        ObjectMapper objectMapper = new ObjectMapper();
        List<Person> people = objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, Person.class));
        System.out.println(people);
    }

    // test to read json array to list of person POJOs using TypeReference
    @Test
    void testJsonArrayToListOfObjectsTypeReference() throws JsonProcessingException {
        String json = """
                [{"firstName":"Jimmy","lastName":"Buffett","address":{"addressLine1":
                "500 Duval Street","city":"Key West","state":"FL","zip":"33040"}},
                {"firstName":"Jimmy","lastName":"Buffett","address":{"addressLine1":
                "500 Duval Street","city":"Key West","state":"FL","zip":"33040"}}]""";

        ObjectMapper objectMapper = new ObjectMapper();
        List<Person> people = objectMapper.readValue(json, new com.fasterxml.jackson.core.type.TypeReference<List<Person>>() {});
        System.out.println(people);
    }

    // test to write list of maps to json
    @Test
    void testListOfMapsToJson() throws JsonProcessingException {
        Map<String, Object> person1 = Map.of(
                "firstName", "Jimmy",
                "lastName", "Buffett",
                "address", Map.of(
                        "addressLine1", "500 Duval Street",
                        "city", "Key West",
                        "state", "FL",
                        "zip", "33040"
                )
        );
        Map<String, Object> person2 = Map.of(
                "firstName", "Jimmy",
                "lastName", "Buffett",
                "address", Map.of(
                        "addressLine1", "500 Duval Street",
                        "city", "Key West",
                        "state", "FL",
                        "zip", "33040"
                )
        );
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(List.of(person1, person2)));
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Address {
        private String addressLine1;
        private String city;
        private String state;
        private String zip;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Person {
        private String firstName;
        private String lastName;
        private Address address;
    }

    //create test to write person object to json
    @Test
    void testObjectToJson() throws JsonProcessingException {
        Person person = Person.builder()
                .firstName("Jimmy")
                .lastName("Buffett")
                .address(Address.builder()
                        .addressLine1("500 Duval Street")
                        .city("Key West")
                        .state("FL")
                        .zip("33040")
                        .build())
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(person));
    }

    //test to write list of person objects to json
    @Test
    void testListOfObjectsToJson() throws JsonProcessingException {
        Person person1 = Person.builder()
                .firstName("Jimmy")
                .lastName("Buffett")
                .address(Address.builder()
                        .addressLine1("500 Duval Street")
                        .city("Key West")
                        .state("FL")
                        .zip("33040")
                        .build())
                .build();
        Person person2 = Person.builder()
                .firstName("Jimmy")
                .lastName("Buffett")
                .address(Address.builder()
                        .addressLine1("500 Duval Street")
                        .city("Key West")
                        .state("FL")
                        .zip("33040")
                        .build())
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(List.of(person1, person2)));
    }


    public static class AddressSerializer extends StdSerializer<Address> {

        public AddressSerializer() {
            this(null);
        }

        public AddressSerializer(Class<Address> t) {
            super(t);
        }

        @Override
        public void serialize(Address address, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("line1", address.getAddressLine1());
            jsonGenerator.writeStringField("city", address.getCity());
            jsonGenerator.writeStringField("state", address.getState());
            jsonGenerator.writeStringField("postalCode", address.getZip());
            jsonGenerator.writeStringField("country", "USA");
            jsonGenerator.writeStringField("version", "1.0");
            jsonGenerator.writeEndObject();
        }
    }

    // test to write person object to json with custom serializer
    @Test
    void testObjectToJsonWithCustomSerializer() throws JsonProcessingException {
        Person person = Person.builder()
                .firstName("Jimmy")
                .lastName("Buffett")
                .address(Address.builder()
                        .addressLine1("500 Duval Street")
                        .city("Key West")
                        .state("FL")
                        .zip("33040")
                        .build())
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new com.fasterxml.jackson.databind.module.SimpleModule().addSerializer(Address.class, new AddressSerializer()));
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(person));
    }

    //custom deserializer for address
    public static class AddressDeserializer extends StdDeserializer<Address> {

        protected AddressDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public Address deserialize(JsonParser jsonParser,
                                   DeserializationContext deserializationContext) throws IOException {
            JsonNode node = jsonParser.getCodec().readTree(jsonParser);
            return Address.builder()
                    .addressLine1(node.get("line1").asText())
                    .city(node.get("city").asText())
                    .state(node.get("state").asText())
                    .zip(node.get("postalCode").asText())
                    .build();
        }
    }

    //test for custom deserializer for address class
    @Test
    void testJsonToObjectWithCustomDeserializer() throws JsonProcessingException {
        String json = """
                {"firstName":"Jimmy","lastName":"Buffett","address":{"line1":"500 Duval Street","city":"Key West","state":"FL","postalCode":"33040"}}""";

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new SimpleModule().addDeserializer(Address.class,
                new AddressDeserializer(Address.class)));
        Person person = objectMapper.readValue(json, Person.class);
        System.out.println(person);
    }

    // test to deserialize person with unknown properties
    @Test
    void testJsonToObjectWithUnknownProperties() throws JsonProcessingException {

        String json = """
                {"firstName":"Jimmy","lastName":"Buffett","address":{"addressLine1":
                "500 Duval Street","city":"Key West","state":"FL","zip":"33040"},
                "foo":"bar"}}""";

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Person person = objectMapper.readValue(json, Person.class);
        System.out.println(person);
    }
}
