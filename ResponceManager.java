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
public class ResponceManager {

    private List<Responce> res;

    public ResponceManager(List<Responce> r) {
        res = r;
    }

    public void addResponce(String id, String ty, String use, String tex) {

        Connection con;
        Statement st = null;

        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/FB", "asd", "123");
            st = con.createStatement();

            st.executeUpdate("insert into Responses values (" + id + ",'" + ty + "','" + use + "','" + tex + "')");
        } catch (SQLException ex) {
            System.out.println("addResponce In (ResponceManager) Has An Error");
            System.out.println("" + ex);
        }

    }

    public void removeResponce(String id, String ty, String use, String tex) {

        Connection con;
        Statement st = null;

        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/FB", "asd", "123");
            st = con.createStatement();

            st.executeUpdate("delete from Responses where id = " + Integer.parseInt(id) + "  And typ = '" + ty + "' And use = '" + use + "' And txt = '" + tex + "'");
        } catch (SQLException ex) {
            System.out.println("removeResponce In (ResponceManager) Has An Error");
            System.out.println("" + ex);
        }

    }

}
