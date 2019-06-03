package com.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Currency;
import java.util.Date;

@Controller
public class BaseController {
    @Autowired
    private BaseService baseService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping("/")
    public String getSignUp() {
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String singUpMethod(@RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam long phone,
                               @RequestParam String email,
                               @RequestParam String password,
                               @RequestParam String role) {
        String passHash = bCryptPasswordEncoder.encode(password);

        baseService.signUpUser(new SignUp(firstName, lastName, phone, email, passHash, role));
        return getSignUp();
    }

    @RequestMapping("/employee")
    public String employeePage() {
        return "employee";
    }

    @RequestMapping("/employer")
    public String employerPage(Model model) {
        model.addAttribute("signUps", baseService.findEmployee());
        model.addAttribute("vacancies", baseService.findVacancies());
        return "employer";
    }

    @RequestMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/vacancy_add")
    public String getVacancy(@RequestParam String vacancy,
                             @RequestParam double salary,
                             @RequestParam String vacancyText,
                             @RequestParam float experience,
                             SignUp signUp) {
        Date date = new Date();
        baseService.addVacancy(new Vacancy(vacancy, date, salary, vacancyText, experience, signUp));
        return employeePage();
    }

    @RequestMapping(value = "/new_vacancy")
    public String vacancyAddMethod(Model model) {
        User user = (User)SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        SignUp signUp = baseService.findByLogin(user.getUsername());
        long id = signUp.getSignId();
        model.addAttribute("signUp", baseService.findOneSign(id));
        return "vacancy_add_page";
    }
}
