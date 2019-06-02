package com.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BaseService {
    @Autowired
    private SignUpRepository signUpRepository;

    //SignUp
    @Transactional
    public void signUpUser(SignUp signUp) {
        signUpRepository.save(signUp);
    }

    @Transactional
    public SignUp findByLogin(String email) {
        return signUpRepository.findByLogin(email);
    }
}
