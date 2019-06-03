package com.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Currency;
import java.util.Date;

@Entity
@NoArgsConstructor
@Table(name = "ResumeTable")
@Getter
@Setter
public class Resume {
    @Id
    @GeneratedValue
    private long resumeId;

    @ManyToOne()
    @JoinColumn(name = "signId")
    private SignUp signUp;

    private String specialization;
    private float experience;
    private String schedule;

    @Temporal(TemporalType.DATE)
    private Date creationDate;
    private Currency salary;
    private String resumeText;

    public Resume(SignUp signUp, String specialization, float experience, String schedule, Date creationDate, Currency salary, String resumeText) {
        this.signUp = signUp;
        this.specialization = specialization;
        this.experience = experience;
        this.schedule = schedule;
        this.creationDate = creationDate;
        this.salary = salary;
        this.resumeText = resumeText;
    }
}
