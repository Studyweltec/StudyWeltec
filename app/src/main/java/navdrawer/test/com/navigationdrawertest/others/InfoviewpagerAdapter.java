package navdrawer.test.com.navigationdrawertest.others;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import navdrawer.test.com.navigationdrawertest.R;
import navdrawer.test.com.navigationdrawertest.fragment.Infopage1Fragment;
import navdrawer.test.com.navigationdrawertest.fragment.Infopage3Fragment;
import navdrawer.test.com.navigationdrawertest.fragment.Infopage4Fragment;
import navdrawer.test.com.navigationdrawertest.fragment.infopage2Fragment;

public class InfoviewpagerAdapter extends FragmentPagerAdapter {

    public InfoviewpagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new Infopage1Fragment();
            case 1:
                return new infopage2Fragment();
            case 2:
                return new Infopage3Fragment();
            case 3:
                return new Infopage4Fragment();
        }
        return null; //does not happen
    }

    @Override
    public int getCount() {
        return 4; //four fragments
    }
}