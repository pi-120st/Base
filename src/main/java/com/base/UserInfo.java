package com.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "UserTable")
@Getter
@Setter
public class UserInfo {
    @Id
    @GeneratedValue
    private long UserId;

    @OneToOne()
    @JoinColumn(name = "signId")
    private SignUp signUp;

    @Temporal(TemporalType.DATE)
    private Date birthday;
    private String city;

    public UserInfo(SignUp signUp, Date birthday, String city) {
        this.signUp = signUp;
        this.birthday = birthday;
        this.city = city;
    }
}
