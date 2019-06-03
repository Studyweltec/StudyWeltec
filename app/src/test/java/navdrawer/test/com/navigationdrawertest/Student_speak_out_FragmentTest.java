package navdrawer.test.com.navigationdrawertest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Student_speak_out_FragmentTest extends Fragment {

    ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_speak_out_, container, false);

        listView = (ListView) view.findViewById(R.id.Ques_list);
        String[] values = new String[]{"How do you feel about studying in WelTec ?", "How did you find your accomodation in NZ ?",
                "How did you find a job in NZ ?", "What made of transport do you usually use to get to your college ?","How do you feel about the teaching methods in WelTec ?",
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1, android.R.id.text1,values);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


            }
        });

        return view;
    }
}
