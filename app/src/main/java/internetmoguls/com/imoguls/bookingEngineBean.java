package internetmoguls.com.imoguls;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class bookingEngineBean {

    @SerializedName("bookengine_id")
    @Expose
    private String bookengineId;
    @SerializedName("hotel_id")
    @Expose
    private String hotelId;
    @SerializedName("hotel_name")
    @Expose
    private String hotelName;
    @SerializedName("book_url")
    @Expose
    private String bookUrl;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("status")
    @Expose
    private String status;

    public String getBookengineId() {
        return bookengineId;
    }

    public void setBookengineId(String bookengineId) {
        this.bookengineId = bookengineId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
