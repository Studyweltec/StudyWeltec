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
 * {@link infopage2Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link infopage2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class infopage2Fragment extends  Fragment {

    Button skip_btn, nxt_btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_infopage2, container, false);

        skip_btn = (Button) view.findViewById(R.id.info2_skip_btn);
        nxt_btn = (Button) view.findViewById(R.id.info2_nxt_btn);

        skip_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                startActivity(intent);

            }
        });

        nxt_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Infopage3Fragment.class);
                startActivity(intent);

            }
        });

        return view;
    }
}
