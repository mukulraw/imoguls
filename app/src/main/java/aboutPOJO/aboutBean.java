package aboutPOJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class aboutBean {

    @SerializedName("about_id")
    @Expose
    private String aboutId;
    @SerializedName("hotel")
    @Expose
    private String hotel;
    @SerializedName("about_title")
    @Expose
    private String aboutTitle;
    @SerializedName("about_image")
    @Expose
    private String aboutImage;
    @SerializedName("about_description")
    @Expose
    private String aboutDescription;
    @SerializedName("status")
    @Expose
    private String status;

    /**
     *
     * @return
     * The aboutId
     */
    public String getAboutId() {
        return aboutId;
    }

    /**
     *
     * @param aboutId
     * The about_id
     */
    public void setAboutId(String aboutId) {
        this.aboutId = aboutId;
    }

    /**
     *
     * @return
     * The hotel
     */
    public String getHotel() {
        return hotel;
    }

    /**
     *
     * @param hotel
     * The hotel
     */
    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    /**
     *
     * @return
     * The aboutTitle
     */
    public String getAboutTitle() {
        return aboutTitle;
    }

    /**
     *
     * @param aboutTitle
     * The about_title
     */
    public void setAboutTitle(String aboutTitle) {
        this.aboutTitle = aboutTitle;
    }

    /**
     *
     * @return
     * The aboutImage
     */
    public String getAboutImage() {
        return aboutImage;
    }

    /**
     *
     * @param aboutImage
     * The about_image
     */
    public void setAboutImage(String aboutImage) {
        this.aboutImage = aboutImage;
    }

    /**
     *
     * @return
     * The aboutDescription
     */
    public String getAboutDescription() {
        return aboutDescription;
    }

    /**
     *
     * @param aboutDescription
     * The about_description
     */
    public void setAboutDescription(String aboutDescription) {
        this.aboutDescription = aboutDescription;
    }

    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

}
