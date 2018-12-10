/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Post.Responce;

/**
 *
 * @author MHA
 */
public class Comment extends Responce{

    
    
    public Comment(String _pId, String _uId,String _comment) {
        postId = _pId;
        userId = _uId;
        text= _comment;
    }

    @Override
    public String getResponce() {
        return null;
    }
    
    @Override
    public String getResponceText() {
        return text;
    }

    @Override
    public String type() {
        return "C";
    }

}
