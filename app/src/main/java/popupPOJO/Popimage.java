package popupPOJO;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Popimage {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("hotelid")
    @Expose
    private String hotelid;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("hotel_name")
    @Expose
    private String hotelName;
    @SerializedName("status")
    @Expose
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHotelid() {
        return hotelid;
    }

    public void setHotelid(String hotelid) {
        this.hotelid = hotelid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
