package propertiesPOJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class HotelDetail {

    @SerializedName("hotel_id")
    @Expose
    private String hotelId;
    @SerializedName("hotel_name")
    @Expose
    private String hotelName;
    @SerializedName("hotel_image")
    @Expose
    private String hotelImage;
    @SerializedName("hotel_description")
    @Expose
    private String hotelDescription;

    /**
     *
     * @return
     * The hotelId
     */
    public String getHotelId() {
        return hotelId;
    }

    /**
     *
     * @param hotelId
     * The hotel_id
     */
    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
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

    /**
     *
     * @return
     * The hotelImage
     */
    public String getHotelImage() {
        return hotelImage;
    }

    /**
     *
     * @param hotelImage
     * The hotel_image
     */
    public void setHotelImage(String hotelImage) {
        this.hotelImage = hotelImage;
    }

    /**
     *
     * @return
     * The hotelDescription
     */
    public String getHotelDescription() {
        return hotelDescription;
    }

    /**
     *
     * @param hotelDescription
     * The hotel_description
     */
    public void setHotelDescription(String hotelDescription) {
        this.hotelDescription = hotelDescription;
    }


}
