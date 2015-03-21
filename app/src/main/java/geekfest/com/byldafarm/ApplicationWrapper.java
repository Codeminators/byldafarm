package geekfest.com.byldafarm;

import android.app.Application;

import com.ibm.mobile.services.core.IBMBluemix;

/**
 * Created by prempal on 22/3/15.
 */
public class ApplicationWrapper extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        IBMBluemix.initialize(getApplicationContext(), "c80c6b6c-642e-4bca-9863-f6b1d2bea5ed", "86961256a3e169c5eaabd38222cc14c7c326d45d", "http://byldafarm.mybluemix.net");
    }
}
