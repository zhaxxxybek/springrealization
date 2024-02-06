package kz.zhaks.project.techzhaks.Beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
@Getter
@Setter


public class testA {
    public testA(){
        System.out.println("I am creating new object of testA");
        this.name="zharkynbek";
        this.price=2000;
    }
    public testA(String name){
        System.out.println("using parametrized constuctor");
        this.name=name;
    }
    private String name;
    private int price;

}
