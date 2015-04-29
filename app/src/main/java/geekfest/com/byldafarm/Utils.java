package geekfest.com.byldafarm;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by raghav on 22/03/15.
 */
public class Utils {
    public static ArrayList<String> getSeason() {

        final String WINTER = "Winter";
        final String KHARIF = "Kharif";
        final String RABI = "Rabi";
        final String AUTUMN = "Autumn";
        final String SUMMER = "Summer";
        final String WHOLE_YEAR = "Whole Year";
        Calendar calendar = Calendar.getInstance();

        int month = calendar.MONTH;
        Log.d("Raghav", "" + month);

        ArrayList<String> seasons = new ArrayList<>();

        seasons.add(WHOLE_YEAR);
        if (month == 0) {
            seasons.add(RABI);
            seasons.add(WINTER);
        } else if (month == 1) {
            seasons.add(RABI);
            seasons.add(WINTER);
        } else if (month == 2) {
            seasons.add(KHARIF);
            seasons.add(RABI);
            //seasons.add(WINTER);
            //seasons.add(SUMMER);
            //seasons.add(KHARIF);
        } else if (month == 3) {
            seasons.add(SUMMER);
        } else if (month == 4) {
            seasons.add(SUMMER);
        } else if (month == 5) {
            seasons.add(SUMMER);
        } else if (month == 6) {
            seasons.add(KHARIF);
        } else if (month == 7) {
            seasons.add(KHARIF);
        } else if (month == 8) {
            seasons.add(KHARIF);
        } else if (month == 9) {
            seasons.add(KHARIF);
            seasons.add(AUTUMN);
        } else if (month == 10) {
            seasons.add(RABI);
            seasons.add(AUTUMN);
        } else {
            seasons.add(WINTER);
            seasons.add(RABI);
        }
        return seasons;
    }

    public static boolean isEditTextEmpty(EditText editText) {
        String text = editText.getText().toString();
        if (text.matches("")) {
            return true;
        } else if (Float.valueOf(text) == 0) {
            return true;
        }
        return false;
    }

    public static boolean isConnectedToInternet(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
