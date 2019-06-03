package navdrawer.test.com.navigationdrawertest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class EnquiryTest extends Fragment {
    private EditText subjectview, enquiryview, To;
    Button sendbtn;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_enquiry, container, false);

        subjectview = (EditText) view.findViewById(R.id.subject_edit_text);
        enquiryview = (EditText) view.findViewById(R.id.enquiry_edit_text);
        sendbtn = (Button) view.findViewById(R.id.enquiry_snd_btn);
        To = (EditText) view.findViewById(R.id.etTO);

        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;
    }
}