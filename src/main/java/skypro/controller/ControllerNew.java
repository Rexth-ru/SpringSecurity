package skypro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerNew {
    @GetMapping("/")
    public String showPublicInfo(){
        return "publicInfo";
    }
    @GetMapping("/server_info")
    public String showServerInfo(){
        return "serverInfo";
    }
    @GetMapping("/stuff_info")
    public String showStuffInfo(){
        return "stuffInfo";
    }
    @GetMapping("/director_info")
    public String showDirectorInfo(){
        return "directorInfo";
    }
}
