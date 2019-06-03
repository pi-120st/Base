package com.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Currency;
import java.util.Date;

@Entity
@NoArgsConstructor
@Table(name = "VacancyTable")
@Getter
@Setter
public class Vacancy {

    @Id
    @GeneratedValue
    private long vacancyId;

    private String vacancy;
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    private double salary;
    private String vacancyText;
    private float experience;
    @ManyToOne()
    @JoinColumn(name = "signId")
    private SignUp signUp;

    public Vacancy(String vacancy, Date creationDate, double salary, String vacancyText, float experience, SignUp signUp) {
        this.vacancy = vacancy;
        this.creationDate = creationDate;
        this.salary = salary;
        this.vacancyText = vacancyText;
        this.experience = experience;
        this.signUp = signUp;
    }
}
