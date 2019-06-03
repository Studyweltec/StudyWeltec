package navdrawer.test.com.navigationdrawertest;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.RandomTransitionGenerator;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import navdrawer.test.com.navigationdrawertest.fragment.NavigationDrawerFragment;
import navdrawer.test.com.navigationdrawertest.others.CustomAdapter;
import navdrawer.test.com.navigationdrawertest.others.LoadImageTask;
import navdrawer.test.com.navigationdrawertest.others.SubjectData;

public class HomeActivityTest extends FragmentActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks, LoadImageTask.Listener {
    private NavigationDrawerFragment mNavigationDrawerFragment;
    private CharSequence mTitle;
    private DrawerLayout mDrawerLayout;
    private Boolean isFabOpen = false;
    private FloatingActionButton fab, fb, google, linkdn, twitter;
    private Animation fab_open, fab_close, rotate_forward, rotate_backward;
    private KenBurnsView kenBurnsView;
    private boolean isPlay = true;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    Toolbar toolbar;
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

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
        String pathToFile = "https://i.ytimg.com/vi/Rc7GM7rJBCE/maxresdefault.jpg";
        HomeActivity.DownloadImageWithURLTask downloadTask = new HomeActivity.DownloadImageWithURLTask(kenBurnsView);
        downloadTask.execute(pathToFile);

        AccelerateDecelerateInterpolator ACCELERATE_DECELERATE = new AccelerateDecelerateInterpolator();
        RandomTransitionGenerator generator = new RandomTransitionGenerator( 3000, ACCELERATE_DECELERATE );
        kenBurnsView.setTransitionGenerator( generator ); //set new transition on kenburns view

        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateFAB();
            }
        } );
    private class DownloadImageWithURLTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;
        public DownloadImageWithURLTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String pathToFile = urls[0];
            Bitmap bitmap = null;
            try {
                InputStream in = new java.net.URL(pathToFile).openStream();
                bitmap = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return bitmap;
        }
        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
    @Override
    public void onImageLoaded(Bitmap bitmap) {
        kenBurnsView.setImageBitmap( bitmap );
    }

    @Override
    public void onError() {
        Toast.makeText( this, "Error Loading Image !", Toast.LENGTH_SHORT ).show();
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
