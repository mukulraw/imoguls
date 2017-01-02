package contactPOJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class contactBean {

    @SerializedName("contact_id")
    @Expose
    private String contactId;
    @SerializedName("contact_title")
    @Expose
    private String contactTitle;
    @SerializedName("hotel")
    @Expose
    private String hotel;
    @SerializedName("hotel_name")
    @Expose
    private String hotelName;
    @SerializedName("contact_phone")
    @Expose
    private String contactPhone;
    @SerializedName("contact_address")
    @Expose
    private String contactAddress;
    @SerializedName("contact_email")
    @Expose
    private String contactEmail;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("contact_description")
    @Expose
    private String contactDescription;
    @SerializedName("status")
    @Expose
    private String status;

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
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

    public String getContactDescription() {
        return contactDescription;
    }

    public void setContactDescription(String contactDescription) {
        this.contactDescription = contactDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
