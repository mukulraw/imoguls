package INTERFACES;


import POJO.RegisterBean;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface Register {

    @Multipart
    @POST("immogules/user_register.php")
    Call<RegisterBean> register(@Part("name") String name, @Part("email") String email, @Part("mobile") String mobile , @Part("password") String password , @Part("address") String address);


}
