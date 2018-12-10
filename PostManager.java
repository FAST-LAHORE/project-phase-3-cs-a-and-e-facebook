/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Post.Responce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author MHA
 */
public class PostManager {

    protected List<Post> post;

    public PostManager(List<Post> p) {
        post = p;
    }

    public boolean isPost(String id) {
        for (int i = 0; i < post.size(); i++) {
            if (id == null ? post.get(i).getId() == null : id.equals(post.get(i).getId())) {
                return true;
            }
        }
        return false;
    }

    public int addPost(String use, String tex, String typ,String cc) {

        Connection con;
        Statement st = null;
        int zz=0;
        ResultSet rs = null;
        boolean is=false;
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/FB", "asd", "123");
            st = con.createStatement();
            st.executeUpdate("insert into UserPost(use,text,typ,cc) values ('" + use +"','" + tex + "','" + typ + "','"+ cc +"')");
            rs = st.executeQuery("select * from UserPost where use = '"+use+"' And text ='"+tex+"' And cc = '" + cc+"'");
            while (rs.next()) {
                zz=rs.getInt("id");
            }
        } catch (SQLException ex) {
            System.out.println("addPost In (PostManager) Has An Error");
            System.out.println("" + ex);
        }
        
        return zz;
        
    }
    
    
        public void removePost(String typ) {

        Connection con;
        Statement st = null;

        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/FB", "asd", "123");
            st = con.createStatement();
            st.executeUpdate("delete from UserPost where ID = " + typ );     
        } catch (SQLException ex) {
            System.out.println("removePost In (PostManager) Has An Error");
            System.out.println("" + ex);
        }

    }
    

}
