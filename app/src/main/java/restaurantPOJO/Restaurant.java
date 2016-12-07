package restaurantPOJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Restaurant {

    @SerializedName("restaurant_id")
    @Expose
    private String restaurantId;
    @SerializedName("restaurant_name")
    @Expose
    private String restaurantName;
    @SerializedName("restaurant_title")
    @Expose
    private String restaurantTitle;
    @SerializedName("restaurant_image")
    @Expose
    private String restaurantImage;
    @SerializedName("restaurant_description")
    @Expose
    private String restaurantDescription;

    /**
     *
     * @return
     * The restaurantId
     */
    public String getRestaurantId() {
        return restaurantId;
    }

    /**
     *
     * @param restaurantId
     * The restaurant_id
     */
    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    /**
     *
     * @return
     * The restaurantName
     */
    public String getRestaurantName() {
        return restaurantName;
    }

    /**
     *
     * @param restaurantName
     * The restaurant_name
     */
    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    /**
     *
     * @return
     * The restaurantTitle
     */
    public String getRestaurantTitle() {
        return restaurantTitle;
    }

    /**
     *
     * @param restaurantTitle
     * The restaurant_title
     */
    public void setRestaurantTitle(String restaurantTitle) {
        this.restaurantTitle = restaurantTitle;
    }

    /**
     *
     * @return
     * The restaurantImage
     */
    public String getRestaurantImage() {
        return restaurantImage;
    }

    /**
     *
     * @param restaurantImage
     * The restaurant_image
     */
    public void setRestaurantImage(String restaurantImage) {
        this.restaurantImage = restaurantImage;
    }

    /**
     *
     * @return
     * The restaurantDescription
     */
    public String getRestaurantDescription() {
        return restaurantDescription;
    }

    /**
     *
     * @param restaurantDescription
     * The restaurant_description
     */
    public void setRestaurantDescription(String restaurantDescription) {
        this.restaurantDescription = restaurantDescription;
    }


}
