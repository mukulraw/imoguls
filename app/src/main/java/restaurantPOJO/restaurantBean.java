package restaurantPOJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class restaurantBean {

    @SerializedName("restaurant_data")
    @Expose
    private RestaurantData restaurantData;
    @SerializedName("restaurant_heading")
    @Expose
    private RestaurantHeading restaurantHeading;

    /**
     *
     * @return
     * The restaurantData
     */
    public RestaurantData getRestaurantData() {
        return restaurantData;
    }

    /**
     *
     * @param restaurantData
     * The restaurant_data
     */
    public void setRestaurantData(RestaurantData restaurantData) {
        this.restaurantData = restaurantData;
    }

    /**
     *
     * @return
     * The restaurantHeading
     */
    public RestaurantHeading getRestaurantHeading() {
        return restaurantHeading;
    }

    /**
     *
     * @param restaurantHeading
     * The restaurant_heading
     */
    public void setRestaurantHeading(RestaurantHeading restaurantHeading) {
        this.restaurantHeading = restaurantHeading;
    }

}
