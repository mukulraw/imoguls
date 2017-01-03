package INTERFACES;


import java.util.List;

import OfferVoucherPOJO.ovBean;
import POJO.RegisterBean;
import POJO.detailsBean;
import POJO.fnbBean;
import PROMO_POJO.promoBean;
import aboutPOJO.aboutBean;
import contactPOJO.contactBean;
import facilityPOJO.facilityBean;
import galleryPOJO.galleryBean;
import internetmoguls.com.imoguls.bookingEngineBean;
import meetingsPOJO.meetingBean;
import notificationjPOJO.notifyBean;
import offerPOJO.offerBean;
import propertiesPOJO.propertyBean;
import restaurantPOJO.restaurantBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import roomsPOJO.roomsBean;

public interface Register {

    @Multipart
    @POST("immogules/user_register.php")
    Call<RegisterBean> register(@Part("name") String name, @Part("email") String email, @Part("mobile") String mobile , @Part("password") String password , @Part("address") String address);


    @Multipart
    @POST("immogules/user_login.php")
    Call<RegisterBean> login(@Part("email") String email, @Part("password") String password , @Part("reg_id") String token);


    @Multipart
    @POST("immogules/verification.php")
    Call<RegisterBean> verify(@Part("userid") String email, @Part("name") String password);


    @Multipart
    @POST("immogules/user_detail.php")
    Call<detailsBean> details(@Part("id") String email);

    @Multipart
    @POST("immogules/forgot_password.php")
    Call<RegisterBean> forgotPass(@Part("email") String email);

    @Multipart
    @POST("immogules/form_data.php")
    Call<RegisterBean> submitQuery(@Part("form1") String form1 , @Part("name") String name , @Part("email") String email , @Part("phone_number") String phone , @Part("subject") String subject , @Part("message") String message);


    @Multipart
    @POST("immogules/offer_data.php")
    Call<offerBean> getfnb(@Part("category") String category);


    @Multipart
    @POST("immogules/user_voucher.php")
    Call<promoBean> getPromo(@Part("id") String id);

    @Multipart
    @POST("immogules/notify.php")
    Call<promoBean> getPromo2(@Part("id") String id);



    @GET("immogules/hotel_detail.php")
    Call<propertyBean> getProperties();


    @Multipart
    @POST("immogules/hotel_about.php")
    Call<aboutBean> getAbout(@Part("hotel_id") String id);


    @Multipart
    @POST("immogules/hotel_meeting.php")
    Call<meetingBean> getMeetings(@Part("hotel_id") String id);

    @Multipart
    @POST("immogules/hotel_contact.php")
    Call<contactBean> getContact(@Part("hotel_id") String id);

    @Multipart
    @POST("immogules/hotel_gallery.php")
    Call<galleryBean> getGallery(@Part("hotel_id") String id);


    @Multipart
    @POST("immogules/hotel_room.php")
    Call<roomsBean> getRooms(@Part("hotel_id") String id);


    @Multipart
    @POST("immogules/hotel_restaurant.php")
    Call<restaurantBean> getRestaurants(@Part("hotel_id") String id);


    @Multipart
    @POST("immogules/hotel_facility.php")
    Call<List<facilityBean>> getFacilities(@Part("hotel_id") String id);

    @Multipart
    @POST("immogules/hotel_bookengine.php")
    Call<bookingEngineBean> getBookingEngine(@Part("hotel_id") String id);

    @Multipart
    @POST("immogules/notification.php")
    Call<notifyBean> getNotification(@Part("userid") String id);


    @Multipart
    @POST("immogules/offer_voucher.php")
    Call<ovBean> getPromoCodes(@Part("userid") String id , @Part("type") String type);



}
