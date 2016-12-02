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
    @SerializedName("contact_phone")
    @Expose
    private String contactPhone;
    @SerializedName("contact_address")
    @Expose
    private String contactAddress;
    @SerializedName("contact_email")
    @Expose
    private String contactEmail;
    @SerializedName("contact_description")
    @Expose
    private String contactDescription;
    @SerializedName("status")
    @Expose
    private String status;

    /**
     *
     * @return
     * The contactId
     */
    public String getContactId() {
        return contactId;
    }

    /**
     *
     * @param contactId
     * The contact_id
     */
    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    /**
     *
     * @return
     * The contactTitle
     */
    public String getContactTitle() {
        return contactTitle;
    }

    /**
     *
     * @param contactTitle
     * The contact_title
     */
    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    /**
     *
     * @return
     * The hotel
     */
    public String getHotel() {
        return hotel;
    }

    /**
     *
     * @param hotel
     * The hotel
     */
    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    /**
     *
     * @return
     * The contactPhone
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     *
     * @param contactPhone
     * The contact_phone
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    /**
     *
     * @return
     * The contactAddress
     */
    public String getContactAddress() {
        return contactAddress;
    }

    /**
     *
     * @param contactAddress
     * The contact_address
     */
    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    /**
     *
     * @return
     * The contactEmail
     */
    public String getContactEmail() {
        return contactEmail;
    }

    /**
     *
     * @param contactEmail
     * The contact_email
     */
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    /**
     *
     * @return
     * The contactDescription
     */
    public String getContactDescription() {
        return contactDescription;
    }

    /**
     *
     * @param contactDescription
     * The contact_description
     */
    public void setContactDescription(String contactDescription) {
        this.contactDescription = contactDescription;
    }

    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

}
