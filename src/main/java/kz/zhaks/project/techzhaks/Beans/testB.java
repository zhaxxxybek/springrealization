package kz.zhaks.project.techzhaks.Beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class testB {
    public testB(){
        System.out.println("I am using default of B");
    }
    public testB(String code,double volume){
        this.code=code;
        this.volume=volume;
        System.out.println("I am using parametrized of B");

    }
    private double volume;
    private String code;
}
