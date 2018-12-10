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
public class group extends collection {
    
    public group(){
    
    }
    public group(int id,String name, String adminid,String desc, List<post> a,List<accounthandler> m,String imgpath){
        super( id, name,  adminid, desc,  a,imgpath);
        super.setmembers(m);
    }
    @Override
    public  void addpost(String content, int userid, int collectionid ){
         dbconnection db=new dbconnection();
         db.addpost(content, userid);
         //as this is a group post
         db.addpostgroup(collectionid, userid);
    }
    @Override
    public void createcollection(String name, int userid, String desc,String imgpath){
        dbconnection db=new dbconnection();
        db.addgroup(userid, desc, name,imgpath);
    }
    
    public List<collection> returnallgroups(){
        List<collection> ab = new ArrayList<collection>();
        dbconnection db=new dbconnection();
        ResultSet dataset;
        List<Integer> ids = new ArrayList<Integer>();
        try{
            dataset=db.returngroupids(); 
            while (dataset.next()) {
                  ids.add(dataset.getInt("groupid"));
                  
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
        for(int i= 0 ; i < ids.size(); i++)
        {
            try{
             ResultSet local=db.returngroupdetails(ids.get(i));
              while (local.next()) {
                  String a= local.getString("gname");
                  String b=  local.getString("gdescription");
                  int c = local.getInt("adminid");
                  String adminid =Integer.toString(c);
                  String d=  local.getString("coverpic");
                 List<accounthandler> allaccounts = new ArrayList<accounthandler>();
                  List<post> allposts = new  ArrayList<post>();
                   allaccounts=  returnmembers(ids.get(i));
                    allposts= returposts(ids.get(i));
                    ab.add(new group(ids.get(i),  a, adminid, b,allposts,allaccounts,d));
            }
            }
              catch(SQLException e)
                {
                    JOptionPane.showMessageDialog(null, e);

                }
        
        }
      return ab;
    }
      public List<accounthandler>  returnmembers(int groupid){
        dbconnection db=new dbconnection();
        ResultSet dataset;
        List<accounthandler> temp = new ArrayList<accounthandler>();
        try{
             ResultSet local=db.returngroupmemebers(groupid);
              while (local.next()) {
                  int a= local.getInt("userid");
                  String userid=  Integer.toString(a);
                  String b=  local.getString("name");
                  String c = local.getString("dp");
                  accounthandler cuser = new accounthandler(userid, b, c);
                  temp.add(cuser);
                  
                  
            }
            }
              catch(SQLException e)
                {
                    JOptionPane.showMessageDialog(null, e);

                }
        return temp;
        }

     public List<post> returposts(int groupid){
        dbconnection db=new dbconnection();
        ResultSet dataset;
        List<post> temp = new ArrayList<post>();
        try{
             ResultSet local=db.returngroupposts(groupid);
              while (local.next()) {
                  int a= local.getInt("postid");
                  //String userid=  Integer.toString(a);
                  int b=  local.getInt("userid");
                  String c = local.getString("content");
                  post cuser = new post(a, b, c);
                  temp.add(cuser);
                  
                  
            }
            }
              catch(SQLException e)
                {
                    JOptionPane.showMessageDialog(null, e);

                }
        return temp;
        
     }
}
