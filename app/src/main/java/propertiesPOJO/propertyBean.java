package propertiesPOJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class propertyBean {

    @SerializedName("hotel_detail")
    @Expose
    private List<HotelDetail> hotelDetail = new ArrayList<HotelDetail>();

    /**
     *
     * @return
     * The hotelDetail
     */
    public List<HotelDetail> getHotelDetail() {
        return hotelDetail;
    }

    /**
     *
     * @param hotelDetail
     * The hotel_detail
     */
    public void setHotelDetail(List<HotelDetail> hotelDetail) {
        this.hotelDetail = hotelDetail;
    }

}
