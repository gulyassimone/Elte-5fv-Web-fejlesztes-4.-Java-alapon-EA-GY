package hu.elte.bankapp.controllers;

import hu.elte.bankapp.entities.Customer;
import hu.elte.bankapp.exception.UserAlreadyExistAuthenticationException;
import hu.elte.bankapp.service.CustomerService;
import hu.elte.bankapp.webdomain.CustomerView;
import hu.elte.bankapp.webdomain.ForgotView;
import hu.elte.bankapp.webdomain.RegisterView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    CustomerService customerService;
    private ObjectError elem;


    @RequestMapping("")
    public String loadContent(Model model) {
        model.addAttribute("title", "Home");
        return "index.html";
    }

    @GetMapping("/register")
    public String loadRegister(Model model) {
        model.addAttribute("title", "Registration");
        model.addAttribute("customer", new RegisterView());

        return "registration.html";
    }
    @PostMapping("/register")
    public String register(Model model, @Valid @ModelAttribute("customer") RegisterView customer ,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("customer",customer);
           return "registration.html";
        }
        try {
            Customer userCustomer = customerService.registerNewUserCustomer(customer);
        } catch (UserAlreadyExistAuthenticationException e) {
            model.addAttribute("customer", customer);
            model.addAttribute("message", "An account for that username/email already exists.");
            return "registration.html";
        }

        redirectAttributes.addFlashAttribute("message", "Customer successfully saved.");

        return "redirect:/login";
    }

    @RequestMapping("/forgot")
    public String loadForgot(Model model) {
        model.addAttribute("title", "Forgot Password");
        model.addAttribute("forgot", new ForgotView());

        return "forgot_password.html";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("title", "Login");
        return "login.html";
    }

    // Login form with error
    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login.html";
    }

    @PostMapping("/do_forgot")
    public ModelAndView forgot( @ModelAttribute("forgot") ForgotView forgotView) {

        System.out.println(forgotView);

        return new ModelAndView("redirect:/forgot");
    }
}
