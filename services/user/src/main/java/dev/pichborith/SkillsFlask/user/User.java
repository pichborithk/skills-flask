package dev.pichborith.SkillsFlask.user;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collation = "users")
public class User {

    @Id
    private String id;

    private String firstname;
    private String lastname;
    private String email;
    private String password;

    private List<Integer> courses;
}
