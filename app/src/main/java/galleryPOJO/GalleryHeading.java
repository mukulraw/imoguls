package galleryPOJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GalleryHeading {

    @SerializedName("heading_id")
    @Expose
    private String headingId;
    @SerializedName("heading")
    @Expose
    private String heading;
    @SerializedName("hotel_name")
    @Expose
    private String hotelName;

    /**
     *
     * @return
     * The headingId
     */
    public String getHeadingId() {
        return headingId;
    }

    /**
     *
     * @param headingId
     * The heading_id
     */
    public void setHeadingId(String headingId) {
        this.headingId = headingId;
    }

    /**
     *
     * @return
     * The heading
     */
    public String getHeading() {
        return heading;
    }

    /**
     *
     * @param heading
     * The heading
     */
    public void setHeading(String heading) {
        this.heading = heading;
    }

    /**
     *
     * @return
     * The hotelName
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     *
     * @param hotelName
     * The hotel_name
     */
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

}
