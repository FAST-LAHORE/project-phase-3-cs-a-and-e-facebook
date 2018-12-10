/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Post.Responce;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MHA
 */
public abstract class Post {

    protected List<Responce> res;
    protected String uId;
    protected String id;
    protected String text;
    
    public abstract void show();  

    public List<Responce> getRes() {
        return res;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getuId() {
        return uId;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void AddComment(String _uId, String _text) {
        if (res == null) {
            res = new ArrayList();
        }
        res.add(new Comment(id, _uId, _text));
        // Add Comment To DataBase
    }

    public void RemoveComment(String _uId, String _text) {

        if (res == null) {
            return;
        }
        int check = -1;

        for (int i = 0; i < res.size(); i++) {  
            if ((res.get(i).getUserId() == null ? _uId == null : res.get(i).getUserId().equals(_uId)) && (res.get(i).getText() == null ? _text == null : res.get(i).getText().equals(_text))) {
                check = i;
                break;
            }
        }
        
        if (check != -1) {
            res.remove(check);
            //Remove From DataBase
        }

    }

    public boolean setLike(String _uId) {
        int check = -1;

        if (res == null) {
            res = new ArrayList();
        }

        Responce r = null;

        for (int i = 0; i < res.size(); i++) {
            r = res.get(i);
            if (r.getUserId() == null ? _uId == null : r.getUserId().equals(_uId)) {
                check = i;
                break;
            }
        }
        if (check == -1) {
            res.add(new Like(id, _uId));
            return true;
            //Add To DataBase
        } else {
            res.remove(r);
            return false;
            //Remove From DataBase
        }
    }

}
