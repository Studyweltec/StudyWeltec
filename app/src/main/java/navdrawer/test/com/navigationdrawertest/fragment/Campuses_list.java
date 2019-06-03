package navdrawer.test.com.navigationdrawertest.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

import navdrawer.test.com.navigationdrawertest.R;
import navdrawer.test.com.navigationdrawertest.others.Global;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Campuses_list.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Campuses_list#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Campuses_list extends Fragment {
    ListView listView;
   ArrayList<String> PETONE= new ArrayList<>();
   // List<String> PETONE= new ArrayList();
    List<String> AUCKLAND= new ArrayList();
    List<String> PORIRUA= new ArrayList();
    private Global global;
    private ArrayAdapter adapter;
    private ArrayAdapter listAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_list, container, false );


        global = (Global) getActivity().getApplicationContext();
        String nameOfcampuses = global.getNameOfCampuses();
        listView = (ListView) view.findViewById( R.id.dept_list);


        PETONE.add( "IT" );
        PETONE.add( "Busniess" );
        PETONE.add( "Civil" );




        AUCKLAND.add( "Coming Soon" );

        PORIRUA.add( "Coming Soon" );



        //switch between the cases
        switch (nameOfcampuses) {
            case "PETONE":
                adapter = new ArrayAdapter( getActivity().getApplicationContext(), android.R.layout.simple_list_item_1,PETONE);
                setListAdapter( adapter );
                break;
            case "AUCKLAND":
                adapter = new ArrayAdapter( getActivity().getApplicationContext(), android.R.layout.simple_list_item_1,AUCKLAND);
                setListAdapter( adapter );
                break;
            case "PORIRUA":
                adapter = new ArrayAdapter( getActivity().getApplicationContext(), android.R.layout.simple_list_item_1,PORIRUA);
                setListAdapter( adapter );
                break;
        } return view;}

    public void setListAdapter(ArrayAdapter listAdapter) {
        this.listAdapter = listAdapter;
        listView.setAdapter(adapter);



    }
}
