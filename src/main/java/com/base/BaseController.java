package com.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BaseController {
    @Autowired
    private BaseService baseService;

    @RequestMapping("/")
    public String getSignUp(){return "index";}

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String singUpMethod(@RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam long phone,
                               @RequestParam String email,
                               @RequestParam String password,
                               @RequestParam String role){
        baseService.signUpUser(new SignUp(firstName,lastName,phone,email,password,role));
        return getSignUp();
    }
}
