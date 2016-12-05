package roomsPOJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Room {
    @SerializedName("room_id")
    @Expose
    private String roomId;
    @SerializedName("room_name")
    @Expose
    private String roomName;
    @SerializedName("room_image")
    @Expose
    private String roomImage;
    @SerializedName("room_description")
    @Expose
    private String roomDescription;

    /**
     *
     * @return
     * The roomId
     */
    public String getRoomId() {
        return roomId;
    }

    /**
     *
     * @param roomId
     * The room_id
     */
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    /**
     *
     * @return
     * The roomName
     */
    public String getRoomName() {
        return roomName;
    }

    /**
     *
     * @param roomName
     * The room_name
     */
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    /**
     *
     * @return
     * The roomImage
     */
    public String getRoomImage() {
        return roomImage;
    }

    /**
     *
     * @param roomImage
     * The room_image
     */
    public void setRoomImage(String roomImage) {
        this.roomImage = roomImage;
    }

    /**
     *
     * @return
     * The roomDescription
     */
    public String getRoomDescription() {
        return roomDescription;
    }

    /**
     *
     * @param roomDescription
     * The room_description
     */
    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

}
