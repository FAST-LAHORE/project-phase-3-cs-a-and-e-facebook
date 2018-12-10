/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author vostro 14
 */
public class accounthandler {
    public String userid;
    public String name;
    public String dp;
    
    public accounthandler(){
    
    }
    public accounthandler(String a , String b, String c){
        this.userid=a;
        this.name=b;
        this.dp=c;
    }
    
    public int login(String a , String b) throws SQLException {
        
           dbconnection db=new dbconnection();
          
           int set = db.login(a, b);
           
            
           
           
           return set;
           
           
           
    }
    public void setpics(int a , String b , String c){
        dbconnection db=new dbconnection();
        db.updatePics( a, b,c);
        
    
    }
     public List<String> returnheader(int a ){
        dbconnection db=new dbconnection();
        ResultSet ab= db.header(a) ;
        List<String> temp =  new ArrayList<String>();
        try{
         while (ab.next()) {
                  temp.add(ab.getString("dp"));
                  temp.add(ab.getString("cover"));
            }
        }
          catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
        return temp;
    }
    
     public List<accounthandler> returnallusers(){
          dbconnection db=new dbconnection();
          List<accounthandler> a = new ArrayList<accounthandler>();
          
           try{
           ResultSet ab= db.returnusers();
         while (ab.next()) {
                 String x=  ab.getString("userid");
                 String y= ab.getString("dp");
                 String z= ab.getString("fname");
                 
                  accounthandler temp = new accounthandler(x,z,y);
                  a.add(temp);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
          
     return a;
     
     }
     public void addfriend(int a, int b){
         dbconnection db=new dbconnection();
         db.addfriend(a,b);
     }
     public void addpost(String a, int id){
         dbconnection db=new dbconnection();
         db.addpost(a, id);
     }
     
   
}
