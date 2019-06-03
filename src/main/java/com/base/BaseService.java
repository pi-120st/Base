package com.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BaseService {
    @Autowired
    private SignUpRepository signUpRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private ResumeRepository resumeRepository;
    @Autowired
    private VacancyRepository vacancyRepository;

    //SignUp
    @Transactional
    public void signUpUser(SignUp signUp) {
        signUpRepository.save(signUp);
    }
    @Transactional
    public SignUp findByLogin(String email) {
        return signUpRepository.findByLogin(email);
    }
    @Transactional
    public SignUp findOneSign(long id){return signUpRepository.findOne(id);}
    @Transactional(readOnly = true)
    public List<SignUp> findSignUp(){ return  signUpRepository.findAll(); }
    @Transactional(readOnly = true)
    public List<SignUp> findEmployee(){return signUpRepository.findEmployee();}
    //User
    @Transactional
    public void addUserInfo(UserInfo userInfo){userInfoRepository.save(userInfo);}

    //Resume
    @Transactional
    public void  addResume(Resume resume){resumeRepository.save(resume);}

    //Vacancy
    @Transactional
    public void addVacancy(Vacancy vacancy){vacancyRepository.save(vacancy);}
    @Transactional(readOnly = true)
    public List<Vacancy> findVacancies(){ return  vacancyRepository.findAll(); }
}
