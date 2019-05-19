package navdrawer.test.com.navigationdrawertest.others;

import android.app.Application;
import android.support.multidex.MultiDexApplication;

/**
 * Created by touchstone on 9/29/2016.
 */

public class Global extends MultiDexApplication {

    private String nameOfcampuses;

    @Override
    public void onCreate() {
        super.onCreate();
    }


    public void setNameofCampuses(String nameOfcampuses) {
        this.nameOfcampuses = nameOfcampuses;
    }

    public String getNameOfCampuses() {
        return nameOfcampuses;
    }
}
