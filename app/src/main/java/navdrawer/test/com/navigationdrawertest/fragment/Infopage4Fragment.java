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

import navdrawer.test.com.navigationdrawertest.ComingsoonActivity;
import navdrawer.test.com.navigationdrawertest.HomeActivity;
import navdrawer.test.com.navigationdrawertest.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Infopage4Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Infopage4Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Infopage4Fragment extends  Fragment {

Button end_btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_infopage4, container, false);
        end_btn = (Button) view.findViewById(R.id.info4_end_btn);

        end_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                startActivity(intent);

            }
        });
        return view;
    }
}
