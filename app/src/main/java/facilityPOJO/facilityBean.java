package facilityPOJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class facilityBean {

    @SerializedName("hotel_name")
    @Expose
    private String hotelName;
    @SerializedName("heading_id")
    @Expose
    private String headingId;
    @SerializedName("heading")
    @Expose
    private String heading;
    @SerializedName("facility_data")
    @Expose
    private List<FacilityDatum> facilityData = null;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHeadingId() {
        return headingId;
    }

    public void setHeadingId(String headingId) {
        this.headingId = headingId;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public List<FacilityDatum> getFacilityData() {
        return facilityData;
    }

    public void setFacilityData(List<FacilityDatum> facilityData) {
        this.facilityData = facilityData;
    }

}
