package kz.zhaks.project.techzhaks.controller;

import kz.zhaks.project.techzhaks.Beans.testA;
import kz.zhaks.project.techzhaks.Beans.testB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class othercontroller {
    @Autowired
    private testA testA;
    @Autowired
    private testB testB;

    @GetMapping(value = "/test-a")
    public String testA(Model model){
        System.out.println(testA.getName()+testA.getPrice());

        model.addAttribute("testA",testA);
        System.out.println(testB.getCode()+""+testB.getVolume());
        return "test";
    }

}
