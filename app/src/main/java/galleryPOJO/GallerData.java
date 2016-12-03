package galleryPOJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GallerData {

    @SerializedName("gallery")
    @Expose
    private List<Gallery> gallery = new ArrayList<Gallery>();

    /**
     *
     * @return
     * The gallery
     */
    public List<Gallery> getGallery() {
        return gallery;
    }

    /**
     *
     * @param gallery
     * The gallery
     */
    public void setGallery(List<Gallery> gallery) {
        this.gallery = gallery;
    }

}
