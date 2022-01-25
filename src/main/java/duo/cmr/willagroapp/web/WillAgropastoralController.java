package duo.cmr.willagroapp.web;


import duo.cmr.willagroapp.service.Formular;
import duo.cmr.willagroapp.service.ServiceAgro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

// TODO: 22.01.22 Das Ganze mit JDBC zum laufen bringen
@Controller
public class WillAgropastoralController {

    ServiceAgro service;


    @GetMapping("/")
    public String index1(Model model) {
        model.addAttribute("form", service.getForm());
        return "index";
    }

    @PostMapping("/")
    public String index(Model model, @ModelAttribute("form") Formular formular) {
        service.calculAnalytique();
        //model.addAttribute("form", service.getForm());
        return "index";
    }
}
