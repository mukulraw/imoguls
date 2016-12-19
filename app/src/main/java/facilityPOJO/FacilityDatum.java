package facilityPOJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FacilityDatum {

    @SerializedName("facility_id")
    @Expose
    private String facilityId;
    @SerializedName("facility_name")
    @Expose
    private String facilityName;
    @SerializedName("facility_title")
    @Expose
    private String facilityTitle;
    @SerializedName("facility_image")
    @Expose
    private String facilityImage;
    @SerializedName("facility_description")
    @Expose
    private String facilityDescription;
    @SerializedName("status")
    @Expose
    private String status;

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getFacilityTitle() {
        return facilityTitle;
    }

    public void setFacilityTitle(String facilityTitle) {
        this.facilityTitle = facilityTitle;
    }

    public String getFacilityImage() {
        return facilityImage;
    }

    public void setFacilityImage(String facilityImage) {
        this.facilityImage = facilityImage;
    }

    public String getFacilityDescription() {
        return facilityDescription;
    }

    public void setFacilityDescription(String facilityDescription) {
        this.facilityDescription = facilityDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}
