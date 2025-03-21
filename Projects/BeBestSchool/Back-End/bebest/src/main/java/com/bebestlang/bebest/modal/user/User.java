package com.bebestlang.bebest.modal.user;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import com.bebestlang.bebest.modal.training.Subject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "user")
public class User {

    @Id
    private String id;

    private String firstName;

    private String middleName;

    private String lastName;

    // @Indexed(unique = true)
    private String username;

    // @Indexed(unique = true)
    private String email;

    private String phoneNumber;

    private LocalDate dateOfBirth;

    private Address address;

    private Set<Role> role;

    private Set<Subject> subjects;

    private Set<User> users;

    private Map<String, String> bio;

}
