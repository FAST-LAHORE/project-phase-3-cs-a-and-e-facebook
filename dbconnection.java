/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author vostro 14
 */
public class dbconnection {
    Connection con;
    Statement stmt;
    
    dbconnection() //cons
    {
        
        try
        {
             String s = "jdbc:sqlserver://localhost:1433;databaseName=facebook";
             con=DriverManager.getConnection(s,"admin","admin1");
           
            stmt = con.createStatement(); 
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
     public void adduserindb(String fname,String lname,String email,String pass,String gender)
    {
        
        try
        {
          PreparedStatement statement;
          String mysql="INSERT INTO Users " +
                   "VALUES (?, ?, ?, ?, ?)";
            statement = con.prepareStatement(mysql);
            statement.setString(1, fname);
            statement.setString(2, lname);
            statement.setString(3, email);
            statement.setString(4, pass);
            statement.setString(5, gender);
            statement.executeUpdate();
            
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
        
    }
    
    public ResultSet checkexist(String email) throws SQLException
    {
        
        PreparedStatement statement;
          String mysql="select * from users where email = ?";
            statement = con.prepareStatement(mysql); 
        
        statement.setString(1, email);
        try
        {
            return statement.executeQuery();
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    public int login(String a, String b) throws SQLException
    {
        
        PreparedStatement statement;
          String mysql="select * from users where email = ? and pass = ?";
            statement = con.prepareStatement(mysql); 
        ResultSet rs = null;
        int id=-1;
        statement.setString(1, a);
        statement.setString(2, b);
        try
        {
            rs= statement.executeQuery();
           
            while (rs.next()) {
                 id = rs.getInt("userid");
            }
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
        return id;
    }
    public void updatePics(int id,String a,String b)
    {
        try
        {
            PreparedStatement statement;
            String mysql="UPDATE userprofile SET dp =?, cover=? WHERE userid=?";
            statement = con.prepareStatement(mysql);
            
            statement.setInt(3, id);
            statement.setString(1, a);
            statement.setString(2, b);
           
            statement.executeUpdate();
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
    }
     public ResultSet header(int a) 
    {
        
        ResultSet rs = null;
      
        try
        {
            PreparedStatement statement;
        String mysql="select * from userprofile where userid = ? ";
            statement = con.prepareStatement(mysql); 
        
        int id=-1;
        statement.setInt(1, a);
            rs= statement.executeQuery();
           
            
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
        return rs;
    }
    public ResultSet returnusers() throws SQLException
    {
        PreparedStatement statement;
        String mysql="select * from users a join userprofile b on a.userid=b.userid";
        statement = con.prepareStatement(mysql); 
        ResultSet rs = null;
        int id=-1;
        
        try
        {
            rs= statement.executeQuery();
           
           
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
        return rs;
    }
     public void addfriend(int a,int b)
    {
        
        try
        {
          PreparedStatement statement;
          String mysql="INSERT INTO friendlist " +
                   "VALUES (?, ?)";
            statement = con.prepareStatement(mysql);
            statement.setInt(1, a);
            statement.setInt(2, b);
            
            statement.executeUpdate();
            
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
        
    }
     public void addpost(String a, int id)
    {
        
        try
        {
          PreparedStatement statement;
          String mysql="INSERT INTO post " +
                   "VALUES (?, ?)";
            statement = con.prepareStatement(mysql);
            statement.setInt(1, id);
            statement.setString(2, a);
            
            statement.executeUpdate();
            
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
        
    }
       public void addpostgroup(int collectionid, int postid)
    {
        
        try
        {
          PreparedStatement statement;
          String mysql="INSERT INTO groupposts " +
                   "VALUES (?, ?)";
            statement = con.prepareStatement(mysql);
            statement.setInt(1, collectionid);
            statement.setInt(2, postid);
            
            statement.executeUpdate();
            
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
        
    }
      public ResultSet returnuserposts(int id) throws SQLException
    {
        PreparedStatement statement;
        String mysql="select * from post where userid=?";
        statement = con.prepareStatement(mysql); 
       
            
        statement.setInt(1, id);
        ResultSet rs = null;
       
        
        try
        {
            rs= statement.executeQuery();
           
           
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
        return rs;
    }
    public void addgroup(int user,String  des,String name,String path)
    {
        
        try
        {
          PreparedStatement statement;
          String mysql="INSERT INTO groups " +
                   "VALUES (?, ?,?,?)";
            statement = con.prepareStatement(mysql);
            statement.setString(1, name);
            statement.setString(2, des);
            statement.setInt(3, user);
            statement.setString(4, path);
            statement.executeUpdate();
            
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
        
    }
    
     public void addpage(int user,String  des,String name,String path)
    {
        
        try
        {
          PreparedStatement statement;
          String mysql="INSERT INTO pages " +
                   "VALUES (?, ?,?,?)";
            statement = con.prepareStatement(mysql);
            statement.setString(1, name);
            statement.setString(2, des);
            statement.setInt(3, user);
             statement.setString(4, path);
            statement.executeUpdate();
            
            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
        
    }
      public ResultSet returngroupids() throws SQLException
    {
        PreparedStatement statement;
        String mysql="select * from groups";
        statement = con.prepareStatement(mysql); 
        ResultSet rs = null;
        try
        {
            
            rs= statement.executeQuery();
           
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
        return rs;
    }
    public ResultSet returngroupdetails(int groupid) throws SQLException
    {
        PreparedStatement statement;
        String mysql="select * from groups where groupid = ? ";
        statement = con.prepareStatement(mysql); 
        ResultSet rs = null;
        try
        {
            statement.setInt(1, groupid);
            rs= statement.executeQuery();
           
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
        return rs;
    }
     public ResultSet returngroupmemebers(int groupid) throws SQLException
    {
        PreparedStatement statement;
        String mysql="select * from groupusers where groupid =? ";
        statement = con.prepareStatement(mysql); 
        ResultSet rs = null;
        try
        {
            statement.setInt(1, groupid);
            rs= statement.executeQuery();
           
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
        return rs;
    }
     public ResultSet returngroupposts(int groupid) throws SQLException
    {
        PreparedStatement statement;
        String mysql="select * from groupposts a join post b on a.postid=b.postid where a.groupid=? ";
        statement = con.prepareStatement(mysql); 
        ResultSet rs = null;
        try
        {
             statement.setInt(1, groupid);
            rs= statement.executeQuery();
           
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
        return rs;
    }
//     public void returngroups()
//    {
//        
//        try
//        {
//          PreparedStatement statement;
//          String mysql="INSERT INTO friendlist " +
//                   "VALUES (?, ?)";
//            statement = con.prepareStatement(mysql);
//            statement.setInt(1, a);
//            statement.setInt(2, b);
//            
//            statement.executeUpdate();
//            
//            
//        }
//        catch(SQLException e)
//        {
//            JOptionPane.showMessageDialog(null, e);
//            
//        }
//        
//    }
    
}
