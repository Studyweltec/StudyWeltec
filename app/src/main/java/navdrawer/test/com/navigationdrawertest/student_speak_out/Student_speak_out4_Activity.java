package navdrawer.test.com.navigationdrawertest.student_speak_out;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import navdrawer.test.com.navigationdrawertest.R;

public class Student_speak_out4_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_speak_out1_);
        WebView myWebView = (WebView) findViewById(R.id.webView);
        myWebView.loadUrl("https://www.youtube.com/watch?v=En-FJpRBbe8&t=7s");
    }
}
