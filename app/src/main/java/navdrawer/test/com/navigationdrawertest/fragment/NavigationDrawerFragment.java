package navdrawer.test.com.navigationdrawertest.fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import navdrawer.test.com.navigationdrawertest.ComingsoonFragment;
import navdrawer.test.com.navigationdrawertest.HomeActivity;
import navdrawer.test.com.navigationdrawertest.R;
import navdrawer.test.com.navigationdrawertest.others.ExpandableListAdapter;
import navdrawer.test.com.navigationdrawertest.others.ExpandableListDataPump;
import navdrawer.test.com.navigationdrawertest.others.Global;


public class NavigationDrawerFragment extends Fragment {
    private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";
    private NavigationDrawerCallbacks mCallbacks;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private ExpandableListView mDrawerListView;
    private View mFragmentContainerView;
    private int mCurrentSelectedPosition = 0;
    ArrayList<String> groupItem = new ArrayList<String>();
    ArrayList<Object> childItem = new ArrayList<Object>();
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;
    private Global globals;
    private  RelativeLayout relativeLayout ;

    public NavigationDrawerFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated( savedInstanceState );
        // Indicate that this fragment would like to influence the set of actions in the action bar.
        setHasOptionsMenu( true );

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mDrawerListView = (ExpandableListView) inflater.inflate( R.layout.drawer_drawer, container, false );

        mDrawerListView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItem( position );
            }
        } );

        globals = (Global) getActivity().getApplicationContext();

        expandableListDetail = ExpandableListDataPump.getData();
        expandableListTitle = new ArrayList<String>( expandableListDetail.keySet() );
        mDrawerListView.setAdapter( new ExpandableListAdapter( getActivity(), expandableListTitle, expandableListDetail ) );
        mDrawerListView.setOnGroupExpandListener( new OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
            }
        } );
        mDrawerListView.setOnGroupClickListener( new ExpandableListView.OnGroupClickListener() {
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                boolean retVal = true;
                relativeLayout = (RelativeLayout) getActivity().findViewById( R.id.homelayout );
                relativeLayout.setVisibility( View.INVISIBLE );
                if (groupPosition == ExpandableListAdapter.Home) {
                    Intent activityChangeIntent = new Intent( getActivity(), HomeActivity.class );
                    startActivity( activityChangeIntent );
                    retVal = false;
                }
                else if (groupPosition == ExpandableListAdapter.Student_speak_out) {
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace( R.id.container, new ComingsoonFragment(), "gallery" );
                    fragmentTransaction.commit();
                    mDrawerLayout.closeDrawers();
                    // call some activity here
                }
                else if (groupPosition == ExpandableListAdapter.Campuses) {
                    retVal = false;
                    relativeLayout.setVisibility( View.VISIBLE );

                }
                 else if (groupPosition == ExpandableListAdapter.Enquiry) {
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace( R.id.container, new Enquiry(), "enquiry" );
                    fragmentTransaction.commit();
                    mDrawerLayout.closeDrawers();
                } else if (groupPosition == ExpandableListAdapter.Location) {
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace( R.id.container, new GoogelMapsFragment(), "location" );
                    fragmentTransaction.commit();
                    mDrawerLayout.closeDrawers();
                } else if (groupPosition == ExpandableListAdapter.About) {
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace( R.id.container, new AboutFragment(), "about" );
                    fragmentTransaction.commit();
                    mDrawerLayout.closeDrawers();
                } else if (groupPosition == ExpandableListAdapter.Exit) {
                    getActivity().finish();
                }
                return retVal;
            }
        } );
        mDrawerListView.setOnChildClickListener( new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,int groupPosition, int childPosition, long id) {

                if (groupPosition == ExpandableListAdapter.Campuses) {
                    relativeLayout.setVisibility( View.INVISIBLE );

                    if (childPosition == ExpandableListAdapter.Petone) {
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace( R.id.container, new Campuses_list(), "petone" );
                        fragmentTransaction.commit();
                        mDrawerLayout.closeDrawers();
                        globals.setNameofCampuses("petone");
                    } else if (childPosition == ExpandableListAdapter.Auckland) {
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace( R.id.container, new Campuses_list(), "auckland" );
                        fragmentTransaction.commit();
                        mDrawerLayout.closeDrawers();
                        globals.setNameofCampuses("auckland");
                    } else if (childPosition == ExpandableListAdapter.Porirua) {
                        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace( R.id.container, new Campuses_list(), "porirua" );
                        fragmentTransaction.commit();
                        mDrawerLayout.closeDrawers();
                        globals.setNameofCampuses("porirua");
                    }                 }
                return true;
            }
        } );
        mDrawerListView.setItemChecked( mCurrentSelectedPosition, true );
        View header = inflater.inflate( R.layout.drawer_header, null );
        mDrawerListView.addHeaderView( header );
        return mDrawerListView;
    }

    public boolean isDrawerOpen() {
        return mDrawerLayout != null && mDrawerLayout.isDrawerOpen( mFragmentContainerView );


    }

    /**
     * Users of this fragment must call this method to set up the navigation drawer interactions.
     *
     * @param fragmentId   The android:id of this fragment in its activity's layout.
     * @param drawerLayout The DrawerLayout containing this fragment's UI.
     */
    public void setUp(int fragmentId, DrawerLayout drawerLayout) {
        mFragmentContainerView = getActivity().findViewById( fragmentId );
        mDrawerLayout = drawerLayout;

        // set a custom shadow that overlays the main content when the drawer opens
        mDrawerLayout.setDrawerShadow( R.drawable.drawer_shadow, GravityCompat.START );
        // set up the drawer's list view with items and click listener


        // ActionBarDrawerToggle ties together the the proper interactions
        // between the navigation drawer and the action bar app icon.
        mDrawerToggle = new ActionBarDrawerToggle( getActivity(), mDrawerLayout,/* DrawerLayout object */
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close  /* "close drawer" description for accessibility */

        ) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed( drawerView );


                if (!isAdded()) {
                    return;
                }

                getActivity().supportInvalidateOptionsMenu(); // calls onPrepareOptionsMenu()
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened( drawerView );


                if (!isAdded()) {
                    return;
                }


                getActivity().supportInvalidateOptionsMenu(); // calls onPrepareOptionsMenu()
            }
        };


        // Defer code dependent on restoration of previous instance state.
        mDrawerLayout.post( new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        } );

        mDrawerLayout.setDrawerListener( mDrawerToggle );
    }

    private void selectItem(int position) {
        mCurrentSelectedPosition = position;
        if (mDrawerListView != null) {
            mDrawerListView.setItemChecked( position, true );
        }
        if (mDrawerLayout != null) {
            mDrawerLayout.closeDrawer( mFragmentContainerView );
        }
        if (mCallbacks != null) {
            mCallbacks.onNavigationDrawerItemSelected( position );
        }
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState( outState );
        outState.putInt( STATE_SELECTED_POSITION, mCurrentSelectedPosition );
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged( newConfig );
        // Forward the new configuration the drawer toggle component.
        mDrawerToggle.onConfigurationChanged( newConfig );
    }

    public static interface NavigationDrawerCallbacks {
        /**
         * Called when an item in the navigation drawer is selected.
         */
        void onNavigationDrawerItemSelected(int position);
    }

    public void onBackPressed() {
        FragmentManager fm = getFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            Log.i( "HomeActivity", "popping backstack" );
            fm.popBackStack();
        } else {
            Log.i( "HomeActivity", "nothing on backstack, calling super" );
        }
    }
}
