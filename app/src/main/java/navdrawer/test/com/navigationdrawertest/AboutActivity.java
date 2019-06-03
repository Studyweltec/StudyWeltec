package navdrawer.test.com.navigationdrawertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import java.util.ArrayList;

import navdrawer.test.com.navigationdrawertest.others.CustomAdapter;
import navdrawer.test.com.navigationdrawertest.others.SubjectData;

public class AboutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        final ListView list = findViewById(R.id.list);
        ArrayList<SubjectData> arrayList = new ArrayList<SubjectData>();
        arrayList.add(new SubjectData("''I am an Android Developer and Analyst.I am passionate about what I do. You can count on me to deliver your projects!'' Sahil Kaushal", "https://www.linkedin.com/in/sahil-kaushal-kaushal-511052103/", "https://media.licdn.com/dms/image/C5603AQGzSOSJOjT58g/profile-displayphoto-shrink_200_200/0?e=1564617600&v=beta&t=Z_eTW34KAjtvNoTpCCDtvRpQcttLNsMw_-uvUkXlDf8"));
        arrayList.add(new SubjectData("''I am an Excellent Database developer and Project manager, I am consistent with my work.'' Bhavleen Kaur", "https://www.linkedin.com/in/bhavleen-kaur-2b70b4b7/", "https://media.licdn.com/dms/image/C4E03AQEBWxtZiQvwCw/profile-displayphoto-shrink_800_800/0?e=1564617600&v=beta&t=lirj_OOIn4-MRo0NIVLtzTSpc7LnNd6JNZyPxJdBYAQ"));
        arrayList.add(new SubjectData("''I am a Software Texter, I am passionate about what I do!'' Anudeep Varma", "https://www.linkedin.com/in/anudeep-varma-indukuri-164472b9/", "https://media.licdn.com/dms/image/C5103AQFhT_l-PkvKtA/profile-displayphoto-shrink_800_800/0?e=1564617600&v=beta&t=2VC1fkFsyv9aLvwyftsY2bEA10Pc649DmE47YbvaeFA"));
        CustomAdapter customAdapter = new CustomAdapter(this, arrayList);
        list.setAdapter(customAdapter);
    }
}
