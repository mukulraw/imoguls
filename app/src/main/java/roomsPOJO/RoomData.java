package roomsPOJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RoomData {

    @SerializedName("room")
    @Expose
    private List<Room> room = null;

    /**
     *
     * @return
     * The room
     */
    public List<Room> getRoom() {
        return room;
    }

    /**
     *
     * @param room
     * The room
     */
    public void setRoom(List<Room> room) {
        this.room = room;
    }

}
