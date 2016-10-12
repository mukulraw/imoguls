package internetmoguls.com.imoguls;


import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;

import java.io.IOException;

public class DeleteTokenService extends IntentService{

    public static final String TAG = DeleteTokenService.class.getSimpleName();
    SharedPreferences pref;
    static SharedPreferences.Editor edit;

    public DeleteTokenService()
    {
        super(TAG);
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        try
        {
            // Check for current token
            String originalToken = getTokenFromPrefs();
            Log.d(TAG, "Token before deletion: " + originalToken);

            // Resets Instance ID and revokes all tokens.
            FirebaseInstanceId.getInstance().deleteInstanceId();

            // Clear current saved token
            saveTokenToPrefs("");

            // Check for success of empty token
            String tokenCheck = getTokenFromPrefs();
            Log.d(TAG, "Token deleted. Proof: " + tokenCheck);

            // Now manually call onTokenRefresh()
            Log.d(TAG, "Getting new token");
            FirebaseInstanceId.getInstance().getToken();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    private void saveTokenToPrefs(String _token)
    {
        pref = getSharedPreferences("myPref" , Context.MODE_PRIVATE);
        edit = pref.edit();
        edit.putString("RegId" , _token);
        edit.apply();
    }

    private String getTokenFromPrefs()
    {
        pref = getSharedPreferences("myPref" , Context.MODE_PRIVATE);
        return pref.getString("RegId", null);
    }


}
