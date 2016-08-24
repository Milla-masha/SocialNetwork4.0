package sjc.app.Firebase;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by psycl on 14.08.2016.
 */
public class FirebaseInitializer
{

   public void init(){
       FirebaseOptions options = null;
       try
       {
           options = new FirebaseOptions.Builder()
                   .setServiceAccount(new FileInputStream("firebase-secret-jsonkey/socialnetwork-fa62f914687e.json"))
                   .setDatabaseUrl("https://socialnetwork-a8eb6.firebaseio.com/")
                   .build();
       } catch (FileNotFoundException e)
       {
           e.printStackTrace();
       }
       FirebaseApp.initializeApp(options);
   }
}
