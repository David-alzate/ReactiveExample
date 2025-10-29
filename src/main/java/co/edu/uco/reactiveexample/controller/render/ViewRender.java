package co.edu.uco.reactiveexample.controller.render;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewRender {

    @GetMapping("/")
    public String renderChatForm() {
        return "chat";
    }
}
