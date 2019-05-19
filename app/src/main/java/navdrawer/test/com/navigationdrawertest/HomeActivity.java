package navdrawer.test.com.navigationdrawertest;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.RandomTransitionGenerator;

import java.util.ArrayList;
import java.util.List;

import navdrawer.test.com.navigationdrawertest.fragment.NavigationDrawerFragment;
import navdrawer.test.com.navigationdrawertest.others.LoadImageTask;

import static navdrawer.test.com.navigationdrawertest.R.id.fab4;


public class HomeActivity extends FragmentActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks, LoadImageTask.Listener {
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private CharSequence mTitle;
    private DrawerLayout mDrawerLayout;
    private Boolean isFabOpen = false;
    private FloatingActionButton fab, fb, google, youtube, twitter;
    private Animation fab_open, fab_close, rotate_forward, rotate_backward;
    private KenBurnsView kenBurnsView;
    private boolean isPlay = true;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        fab = (FloatingActionButton) findViewById( R.id.fab );
        fb = (FloatingActionButton) findViewById( R.id.fab1 );
        google = (FloatingActionButton) findViewById( R.id.fab2 );
        youtube = (FloatingActionButton) findViewById( R.id.fab3 );
        twitter = (FloatingActionButton) findViewById( R.id.fab4 );
        fab_open = AnimationUtils.loadAnimation( getApplicationContext(), R.anim.fab_open );
        fab_close = AnimationUtils.loadAnimation( getApplicationContext(), R.anim.fab_close );
        rotate_forward = AnimationUtils.loadAnimation( getApplicationContext(), R.anim.rotate_forward );
        rotate_backward = AnimationUtils.loadAnimation( getApplicationContext(), R.anim.rotate_backward );
        Window window = getWindow();
        // clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags( WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags( WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS );
        // finally change the color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor( getResources().getColor( R.color.colorPrimaryDark ) );
        }

        tabLayout = (TabLayout) findViewById( R.id.tabs );
        tabLayout.setupWithViewPager( viewPager );
        tabLayout.setTabMode( TabLayout.MODE_SCROLLABLE );
        tabLayout.setTabTextColors( ColorStateList.valueOf( getResources().getColor( R.color.lightblack )) );
        // Set up the drawer.
        mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById( R.id.navigation_drawer );
        mTitle = getTitle();
        mNavigationDrawerFragment.setUp( R.id.navigation_drawer, (DrawerLayout) findViewById( R.id.main_layout ) );

        toolbar = (Toolbar) findViewById( R.id.toolbar );
        //setSupportActionBar( toolbar );
        setTitle( "Home" );
        mDrawerLayout = (DrawerLayout) findViewById( R.id.main_layout );
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle( this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close );
        mDrawerLayout.setDrawerListener( toggle );
        toggle.syncState();
        //kenburn
        kenBurnsView = (KenBurnsView) findViewById( R.id.kenimage );
        AccelerateDecelerateInterpolator ACCELERATE_DECELERATE = new AccelerateDecelerateInterpolator();
        RandomTransitionGenerator generator = new RandomTransitionGenerator( 3000, ACCELERATE_DECELERATE );
        kenBurnsView.setTransitionGenerator( generator ); //set new transition on kenburns view

        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateFAB();
            }
        } );
        fb.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.facebook.com/Angels-World-159969984398878/";
                Intent i = new Intent( Intent.ACTION_VIEW );
                i.setData( Uri.parse( url ) );
                startActivity( i );
                Log.d( "Sahil", "Facebook" );
            }
        } );
        google.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url2 = "https://plus.google.com/104813184532389345588/";
                Intent i2 = new Intent( Intent.ACTION_VIEW );
                i2.setData( Uri.parse( url2 ) );
                startActivity( i2 );
                Log.d( "Sahil", "Google+" );
            }
        } );
        youtube.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url3 = "https://www.youtube.com/channel/UCqBud94c6Nx8DE-Uf6q93WQ/";
                Intent i3 = new Intent( Intent.ACTION_VIEW );
                i3.setData( Uri.parse( url3 ) );
                startActivity( i3 );
                Log.d( "Sahil", "You tube" );
            }
        } );
        twitter.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url4 = "https://twitter.com/Angelsworld311E/";
                Intent i4 = new Intent( Intent.ACTION_VIEW );
                i4.setData( Uri.parse( url4 ) );
                startActivity( i4 );
                Log.d( "Sahil", "Twitter" );
            }
        } );
    }

    @Override
    public void onImageLoaded(Bitmap bitmap) {
        kenBurnsView.setImageBitmap( bitmap );
    }

    @Override
    public void onError() {
        Toast.makeText( this, "Error Loading Image !", Toast.LENGTH_SHORT ).show();
    }

    public void animateFAB() {
        if (isFabOpen) {
            fab.startAnimation( rotate_backward );
            fb.startAnimation( fab_close );
            google.startAnimation( fab_close );
            youtube.startAnimation( fab_close );
            twitter.startAnimation( fab_close );
            fb.setClickable( false );
            google.setClickable( false );
            youtube.setClickable( false );
            twitter.setClickable( false );
            isFabOpen = false;
            Log.d( "Sahil", "close" );
        } else {
            fab.startAnimation( rotate_forward );
            fb.startAnimation( fab_open );
            google.startAnimation( fab_open );
            youtube.startAnimation( fab_open );
            twitter.startAnimation( fab_open );
            fb.setClickable( true );
            google.setClickable( true );
            youtube.setClickable( true );
            twitter.setClickable( true );
            isFabOpen = true;
            Log.d( "Sahil", "open" );
        }
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        //super.onBackPressed();
        openQuitDialog();
    }

    private void openQuitDialog() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder( HomeActivity.this );
        quitDialog.setTitle( "Confirm to Quit?" );
        quitDialog.setPositiveButton( "OK, Quit!", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                finish();
            }
        } );
        quitDialog.setNegativeButton( "NO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
            }
        } );
        quitDialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.menu_main, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.Search) {
            startActivity( new Intent( Intent.ACTION_VIEW ).setData( Uri.parse( "http://www.ngosindia.com/resources/ngo_registration.php" ) ) );
            return true;
        }
        return super.onOptionsItemSelected( item );
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super( manager );

        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get( position );
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add( fragment );
            mFragmentTitleList.add( title );
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get( position );
        }
    }
}
