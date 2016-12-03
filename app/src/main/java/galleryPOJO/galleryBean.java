package galleryPOJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class galleryBean {

    @SerializedName("galler_data")
    @Expose
    private GallerData gallerData;
    @SerializedName("gallery_heading")
    @Expose
    private GalleryHeading galleryHeading;

    /**
     *
     * @return
     * The gallerData
     */
    public GallerData getGallerData() {
        return gallerData;
    }

    /**
     *
     * @param gallerData
     * The galler_data
     */
    public void setGallerData(GallerData gallerData) {
        this.gallerData = gallerData;
    }

    /**
     *
     * @return
     * The galleryHeading
     */
    public GalleryHeading getGalleryHeading() {
        return galleryHeading;
    }

    /**
     *
     * @param galleryHeading
     * The gallery_heading
     */
    public void setGalleryHeading(GalleryHeading galleryHeading) {
        this.galleryHeading = galleryHeading;
    }


}
