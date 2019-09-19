package tw.com.js.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JsController {

    @GetMapping("/one")
    public String one(){
        return "one";
    }
}
