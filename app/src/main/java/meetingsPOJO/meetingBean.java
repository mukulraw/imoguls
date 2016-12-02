package meetingsPOJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class meetingBean {

    @SerializedName("meet_id")
    @Expose
    private String meetId;
    @SerializedName("meet_name")
    @Expose
    private String meetName;
    @SerializedName("hotel")
    @Expose
    private String hotel;
    @SerializedName("meet_description")
    @Expose
    private String meetDescription;
    @SerializedName("status")
    @Expose
    private String status;

    /**
     *
     * @return
     * The meetId
     */
    public String getMeetId() {
        return meetId;
    }

    /**
     *
     * @param meetId
     * The meet_id
     */
    public void setMeetId(String meetId) {
        this.meetId = meetId;
    }

    /**
     *
     * @return
     * The meetName
     */
    public String getMeetName() {
        return meetName;
    }

    /**
     *
     * @param meetName
     * The meet_name
     */
    public void setMeetName(String meetName) {
        this.meetName = meetName;
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
     * The meetDescription
     */
    public String getMeetDescription() {
        return meetDescription;
    }

    /**
     *
     * @param meetDescription
     * The meet_description
     */
    public void setMeetDescription(String meetDescription) {
        this.meetDescription = meetDescription;
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
