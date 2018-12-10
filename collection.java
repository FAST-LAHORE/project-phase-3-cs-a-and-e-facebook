/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.List;

/**
 *
 * @author vostro 14
 */
abstract public class collection {
    public String name;//page name or group
    public String adminid;
    public List<accounthandler> members;
    public List<post> allposts;
    public String description;
    public int collectionid;
    public String imgpath;
    public collection(){
    
    }
    
    public collection(int collectionid, String name, String adminid,String desc, List<post> a,String imgpath){
        this.name=name;
        this.adminid=adminid;
        this.description=desc;
        this.allposts=a;
        this.collectionid=collectionid;
        this.imgpath=imgpath;
    }
    public void setmembers(List<accounthandler> m){
        this.members=m;
    }
    
    public abstract void addpost(String content, int userid, int collectionid);
    public abstract void createcollection(String name, int userid, String desc,String imgpath);
    
    
           
}
