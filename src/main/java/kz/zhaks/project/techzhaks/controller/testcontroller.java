package kz.zhaks.project.techzhaks.controller;

import kz.zhaks.project.techzhaks.Beans.testA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testcontroller {
    @Autowired
    private testA testA;
    @GetMapping(value = "/test-b")
    public String testB(Model model){
            model.addAttribute("testA",testA);
            return "test";

    }
    @GetMapping(value = "/change-test-b")
    public String changeTestB(){
        testA.setPrice(2000);
        testA.setName("maksim");
        return "redirect:/test-b";

    }
}
