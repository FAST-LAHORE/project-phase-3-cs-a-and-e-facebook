/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vostro 14
 */
public class adduser {
    private String fname;
    private String lname;
    private String email;
    private String pass;
    private String gender;
    
    public adduser(String a,String b,String c, String d, String e){
        this.fname=a;
        this.lname=b;
        this.email=c;
        this.pass=d;
        this.gender=e;
    }
    public adduser(){
    
    }
    public void register(adduser a ){
         dbconnection db=new dbconnection();
         db.adduserindb(a.fname, a.lname, a.email, a.pass, a.gender);
        
    }
     public boolean checkusernameavil(String email) throws SQLException
    {
         dbconnection db=new dbconnection();
        ResultSet rs=db.checkexist(email);
        return rs.next();
        
    }
    
    
}
