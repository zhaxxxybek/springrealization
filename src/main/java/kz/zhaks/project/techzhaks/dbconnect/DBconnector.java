package kz.zhaks.project.techzhaks.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnector {
    private Connection connection;
    public DBconnector(String url,String user,String password){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(url,user,password);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        return this.connection;
    }
}
