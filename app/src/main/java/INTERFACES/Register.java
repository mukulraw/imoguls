package INTERFACES;


import POJO.RegisterBean;
import POJO.detailsBean;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface Register {

    @Multipart
    @POST("immogules/user_register.php")
    Call<RegisterBean> register(@Part("name") String name, @Part("email") String email, @Part("mobile") String mobile , @Part("password") String password , @Part("address") String address);


    @Multipart
    @POST("immogules/user_login.php")
    Call<RegisterBean> login(@Part("email") String email, @Part("password") String password);


    @Multipart
    @POST("immogules/verification.php")
    Call<RegisterBean> verify(@Part("userid") String email, @Part("name") String password);


    @Multipart
    @POST("immogules/user_detail.php")
    Call<detailsBean> details(@Part("id") String email);

    @Multipart
    @POST("immogules/user_detail.php")
    Call<RegisterBean> forgotPass(@Part("email") String email);



}
