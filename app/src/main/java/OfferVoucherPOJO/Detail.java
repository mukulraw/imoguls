package OfferVoucherPOJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Detail {

    @SerializedName("hotel_name")
    @Expose
    private String hotelName;
    @SerializedName("hotel_id")
    @Expose
    private String hotelId;
    @SerializedName("hotel_description")
    @Expose
    private String hotelDescription;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelDescription() {
        return hotelDescription;
    }

    public void setHotelDescription(String hotelDescription) {
        this.hotelDescription = hotelDescription;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

}
