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
    @SerializedName("banquets")
    @Expose
    private String banquets;
    @SerializedName("status")
    @Expose
    private String status;

    public String getMeetId() {
        return meetId;
    }

    public void setMeetId(String meetId) {
        this.meetId = meetId;
    }

    public String getMeetName() {
        return meetName;
    }

    public void setMeetName(String meetName) {
        this.meetName = meetName;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getMeetDescription() {
        return meetDescription;
    }

    public void setMeetDescription(String meetDescription) {
        this.meetDescription = meetDescription;
    }

    public String getBanquets() {
        return banquets;
    }

    public void setBanquets(String banquets) {
        this.banquets = banquets;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
