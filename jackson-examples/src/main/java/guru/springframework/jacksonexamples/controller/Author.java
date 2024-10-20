package guru.springframework.jacksonexamples.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jt, Spring Framework Guru.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    private String id;
    private String firstName;
    private String lastName;
}
