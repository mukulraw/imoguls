package galleryPOJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Gallery {

    @SerializedName("gallery_id")
    @Expose
    private String galleryId;
    @SerializedName("gallery_title")
    @Expose
    private String galleryTitle;
    @SerializedName("gallery_image")
    @Expose
    private String galleryImage;
    @SerializedName("gallery_description")
    @Expose
    private String galleryDescription;

    /**
     *
     * @return
     * The galleryId
     */
    public String getGalleryId() {
        return galleryId;
    }

    /**
     *
     * @param galleryId
     * The gallery_id
     */
    public void setGalleryId(String galleryId) {
        this.galleryId = galleryId;
    }

    /**
     *
     * @return
     * The galleryTitle
     */
    public String getGalleryTitle() {
        return galleryTitle;
    }

    /**
     *
     * @param galleryTitle
     * The gallery_title
     */
    public void setGalleryTitle(String galleryTitle) {
        this.galleryTitle = galleryTitle;
    }

    /**
     *
     * @return
     * The galleryImage
     */
    public String getGalleryImage() {
        return galleryImage;
    }

    /**
     *
     * @param galleryImage
     * The gallery_image
     */
    public void setGalleryImage(String galleryImage) {
        this.galleryImage = galleryImage;
    }

    /**
     *
     * @return
     * The galleryDescription
     */
    public String getGalleryDescription() {
        return galleryDescription;
    }

    /**
     *
     * @param galleryDescription
     * The gallery_description
     */
    public void setGalleryDescription(String galleryDescription) {
        this.galleryDescription = galleryDescription;
    }

}
