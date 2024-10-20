package guru.springframework.jacksonexamples.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by jt, Spring Framework Guru.
 */
@RestController
public class AuthorController {
    @PostMapping("/api/v1/author")
    public Author saveAuthor(@RequestBody Author author){
        author.setId(UUID.randomUUID().toString());
        return author;
    }
}
