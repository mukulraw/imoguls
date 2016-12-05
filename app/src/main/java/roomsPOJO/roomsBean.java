package roomsPOJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class roomsBean {

    @SerializedName("room_data")
    @Expose
    private RoomData roomData;
    @SerializedName("room_heading")
    @Expose
    private RoomHeading roomHeading;

    /**
     *
     * @return
     * The roomData
     */
    public RoomData getRoomData() {
        return roomData;
    }

    /**
     *
     * @param roomData
     * The room_data
     */
    public void setRoomData(RoomData roomData) {
        this.roomData = roomData;
    }

    /**
     *
     * @return
     * The roomHeading
     */
    public RoomHeading getRoomHeading() {
        return roomHeading;
    }

    /**
     *
     * @param roomHeading
     * The room_heading
     */
    public void setRoomHeading(RoomHeading roomHeading) {
        this.roomHeading = roomHeading;
    }

}
