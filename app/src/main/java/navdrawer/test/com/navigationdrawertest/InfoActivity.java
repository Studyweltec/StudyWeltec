package navdrawer.test.com.navigationdrawertest;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import navdrawer.test.com.navigationdrawertest.others.InfoviewpagerAdapter;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        ViewPager viewPager = findViewById(R.id.infoview_pager);
        viewPager.setAdapter(new InfoviewpagerAdapter(getSupportFragmentManager()));

    }
}
