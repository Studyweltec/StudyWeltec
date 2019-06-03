package navdrawer.test.com.navigationdrawertest.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import navdrawer.test.com.navigationdrawertest.R;
import navdrawer.test.com.navigationdrawertest.student_speak_out.Student_speak_out1_Activity;
import navdrawer.test.com.navigationdrawertest.student_speak_out.Student_speak_out2_Activity;
import navdrawer.test.com.navigationdrawertest.student_speak_out.Student_speak_out3_Activity;
import navdrawer.test.com.navigationdrawertest.student_speak_out.Student_speak_out4_Activity;

public class Student_speak_out_Fragment extends Fragment {

    ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_speak_out_, container, false);

        listView = (ListView) view.findViewById(R.id.Ques_list);
        String[] values = new String[]{ "How did you find your accomodation in NZ ?",
                "How did you find a job in NZ ?", "What mode of transport do you use ?","How did you come across WelTec ?",
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1, android.R.id.text1,values);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent myIntent = new Intent(view.getContext(), Student_speak_out1_Activity.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 1) {
                    Intent myIntent = new Intent(view.getContext(), Student_speak_out2_Activity.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 2) {
                    Intent myIntent = new Intent(view.getContext(), Student_speak_out3_Activity.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 3) {
                    Intent myIntent = new Intent(view.getContext(), Student_speak_out4_Activity.class);
                    startActivityForResult(myIntent, 0);
                }


            }
        });

            return view;
    }
}
