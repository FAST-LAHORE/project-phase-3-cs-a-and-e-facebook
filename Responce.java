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
public abstract class Responce {

    protected String postId;
    protected String userId;
    protected String text;

    public String getText() {
        return text;
    }

    public abstract String getResponce();
    public abstract String getResponceText();

    public String getPostId() {
        return postId;
    }

    public String getUserId() {
        return userId;
    }
    
    public abstract String type();
    
}
