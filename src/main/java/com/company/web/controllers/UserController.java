package com.company.web.controllers;

import com.company.model.UserCreateForm;
import com.company.model.validator.UserCreateFormValidator;
import com.company.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * User controller
 * handles request with name and password for creating а record in
 * database
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserCreateFormValidator userCreateFormValidator;

    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView returnSignUpPage(UserCreateForm form, BindingResult bindingResult) {
        return new ModelAndView("signup", "form", new UserCreateForm());
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String createUser(@Valid @ModelAttribute("form") UserCreateForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // failed validation
            return "signup";
        }
        try {
            userService.createUser(form);
        } catch (DataIntegrityViolationException e) {
            return "signup";
        }
        // ok, redirect
        return "redirect:/hello";
    }
}
