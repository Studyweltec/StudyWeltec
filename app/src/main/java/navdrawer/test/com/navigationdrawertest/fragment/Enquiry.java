package navdrawer.test.com.navigationdrawertest.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import navdrawer.test.com.navigationdrawertest.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Enquiry.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Enquiry#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Enquiry extends Fragment {
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
                String to = To.getText().toString();
                String subject = subjectview.getText().toString();
                String message = enquiryview.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Select Email Client"));

            }
        });
        return view;
    }
}