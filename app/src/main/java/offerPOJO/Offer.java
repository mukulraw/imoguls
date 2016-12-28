package offerPOJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Offer {


    @SerializedName("offer_id")
    @Expose
    private String offerId;
    @SerializedName("hotel_id")
    @Expose
    private String hotelId;
    @SerializedName("offer_name")
    @Expose
    private String offerName;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("offer_day")
    @Expose
    private String offerDay;

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOfferDay() {
        return offerDay;
    }

    public void setOfferDay(String offerDay) {
        this.offerDay = offerDay;
    }


}
