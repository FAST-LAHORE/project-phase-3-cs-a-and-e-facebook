/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Post.Responce;

import java.util.ArrayList;

/**
 *
 * @author MHA
 */
public class TextPost extends Post{
    
    
    public TextPost(String _uid, String _id, String _text) {
        res=new ArrayList();
        id=_id;
        uId=_uid;
        text=_text;
                
    }
    

    @Override
    public void show() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
