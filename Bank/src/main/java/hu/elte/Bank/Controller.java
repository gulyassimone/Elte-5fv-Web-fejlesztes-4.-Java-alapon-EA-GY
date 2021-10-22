package hu.elte.Bank;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller {
    @RequestMapping("/")
    public String index() {
        return "Spring Boot Example";
    }
}
