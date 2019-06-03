package com.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BaseController {
    @Autowired
    private BaseService baseService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping("/")
    public String getSignUp(){return "index";}

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String singUpMethod(@RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam long phone,
                               @RequestParam String email,
                               @RequestParam String password,
                               @RequestParam String role){
        String passHash = bCryptPasswordEncoder.encode(password);

        baseService.signUpUser(new SignUp(firstName,lastName,phone,email,passHash, role));
        return getSignUp();
    }

    @RequestMapping("/employee")
    public String employeePage(){
        return "employee";
    }

    @RequestMapping("/admin")
    public String adminPage(){
        return "admin";
    }
}
