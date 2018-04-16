package annotation.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/error")
@RestController
public class ErrorController {

    public String errorOn404(){
        return "404";
    }
}
