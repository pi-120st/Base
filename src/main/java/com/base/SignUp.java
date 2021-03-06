package com.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "SignUpTable")
@Getter
@Setter
public class SignUp {
    @Id
    @GeneratedValue
    private long signId;

    private String firstName;
    private String lastName;
    private long phone;
    private String email;
    private String password;
    private String role;

    @OneToMany(mappedBy = "signUp", cascade = CascadeType.ALL)
    private List<Resume> resumes = new ArrayList<Resume>();

    @OneToMany(mappedBy = "signUp", cascade = CascadeType.ALL)
    private List<Vacancy> vacancies = new ArrayList<Vacancy>();

    public SignUp(String firstName, String lastName, long phone, String email, String password, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
