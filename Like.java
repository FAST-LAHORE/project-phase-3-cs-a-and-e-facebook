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
public class Like extends Responce{

    
    
    @Override
    public String type() {
        return "L";
    }
    
    public Like(String _pId,String _uId){
        postId=_pId;
        userId=_uId;
        text="";
    }


    
    @Override
    public String getResponce() {
        return null;
    }

    @Override
    public String getResponceText() {
        return null;
    }
    
}
