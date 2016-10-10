package internetmoguls.com.imoguls;


import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class NotificationService extends FirebaseMessagingService{

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Log.d("asdasdasdaFrom" , remoteMessage.getFrom());
        //Log.d("asdasdasdaId" , remoteMessage.getMessageId());
        Log.d("asdasdasdaBody" , remoteMessage.getNotification().getBody());

    }
}
