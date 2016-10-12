package PROMO_POJO;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class promoBean {

    @SerializedName("posts")
    @Expose
    private List<Post> posts = new ArrayList<Post>();

    /**
     *
     * @return
     * The posts
     */
    public List<Post> getPosts() {
        return posts;
    }

    /**
     *
     * @param posts
     * The posts
     */
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
