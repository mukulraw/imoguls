package internetmoguls.com.imoguls;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class bookingEngineBean {

    @SerializedName("bookengine_id")
    @Expose
    private String bookengineId;
    @SerializedName("hotel")
    @Expose
    private String hotel;
    @SerializedName("book_url")
    @Expose
    private String bookUrl;
    @SerializedName("status")
    @Expose
    private String status;

    public String getBookengineId() {
        return bookengineId;
    }

    public void setBookengineId(String bookengineId) {
        this.bookengineId = bookengineId;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
