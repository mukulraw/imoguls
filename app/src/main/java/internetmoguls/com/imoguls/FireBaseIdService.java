package internetmoguls.com.imoguls;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;



public class FireBaseIdService extends FirebaseInstanceIdService {

    SharedPreferences pref;
    static SharedPreferences.Editor edit;


    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        pref = getSharedPreferences("myPref" , Context.MODE_PRIVATE);
        edit = pref.edit();

        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d("asdasdasd" , token);

        edit.putString("RegId" , token);
        edit.apply();


    }
}
