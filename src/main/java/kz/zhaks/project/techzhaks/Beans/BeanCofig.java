package kz.zhaks.project.techzhaks.Beans;

import kz.zhaks.project.techzhaks.dbconnect.DBconnector;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;

@Configuration
public class BeanCofig {
    @Bean
    public testB testB(){
        testB testB=new testB("Nazym",2000);
        testB.setCode("Java code");
        return testB;
    }
    @Bean
    public DBconnector connection(){
        DBconnector dBconnector=new
                DBconnector("jdbc:mysql://localhost:3306/techbootdb","root","root");
        return dBconnector;
    }
}
