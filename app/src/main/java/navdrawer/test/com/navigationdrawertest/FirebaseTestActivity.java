package navdrawer.test.com.navigationdrawertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class FirebaseTestActivity extends AppCompatActivity {

     Button sign_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_test);
        sign_btn = (Button) findViewById(R.id.sign_btn);

    }
}
