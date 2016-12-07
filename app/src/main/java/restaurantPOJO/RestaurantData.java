package restaurantPOJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class RestaurantData {

    @SerializedName("restaurant")
    @Expose
    private List<Restaurant> restaurant = null;

    /**
     *
     * @return
     * The restaurant
     */
    public List<Restaurant> getRestaurant() {
        return restaurant;
    }

    /**
     *
     * @param restaurant
     * The restaurant
     */
    public void setRestaurant(List<Restaurant> restaurant) {
        this.restaurant = restaurant;
    }


}
