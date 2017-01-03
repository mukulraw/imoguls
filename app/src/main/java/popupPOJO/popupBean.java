package popupPOJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class popupBean {

    @SerializedName("popimage")
    @Expose
    private Popimage popimage;

    public Popimage getPopimage() {
        return popimage;
    }

    public void setPopimage(Popimage popimage) {
        this.popimage = popimage;
    }


}
