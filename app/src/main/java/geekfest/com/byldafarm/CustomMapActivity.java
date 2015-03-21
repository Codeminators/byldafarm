package geekfest.com.byldafarm;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Calendar;


public class CustomMapActivity extends ActionBarActivity {

    private GridView gridView;
    private Calendar calendar;
    private static final String WINTER = "Winter";
    private static final String KHARIF = "Kharif";
    private static final String RABI = "Rabi";
    private static final String AUTUMN = "Autumn";
    private static final String SUMMER = "Summer";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_map);
        gridView = (GridView) findViewById(R.id.grid_view);
        calendar = Calendar.getInstance();

        int month = calendar.MONTH;
        Log.d("Raghav", ""+month);

        ArrayList<String> crops = new ArrayList<>();


        if(month == 0) {
            crops.add(RABI);
            crops.add(WINTER);
        } else if(month == 1){
            crops.add(RABI);
            crops.add(WINTER);
        } else if(month == 2){
            crops.add(RABI);
            //crops.add(WINTER);
            //crops.add(SUMMER);
            //crops.add(KHARIF);
        } else if(month == 3){
            crops.add(SUMMER);
        } else if(month == 4) {
            crops.add(SUMMER);
        } else if (month == 5) {
            crops.add(SUMMER);
        } else if (month == 6) {
            crops.add(KHARIF);
        } else if(month == 7){
            crops.add(KHARIF);
        } else if (month == 8) {
            crops.add(KHARIF);
        } else if (month == 9) {
            crops.add(KHARIF);
            crops.add(AUTUMN);
        } else if (month == 10) {
            crops.add(RABI);
            crops.add(AUTUMN);
        } else {
            crops.add(WINTER);
            crops.add(RABI);
        }


        String[] blanks = new String[] {
                "1", "2 ", " 3", " 4",
                " 8", " 7", " 6", " 5",
                " 9", " 10", " 11", " 12",
                " 13", " 14", " 15", " 16",
                "1", "2 ", " 3", " 4",
                " 8", " 7", " 6", " 5",
                " 9", " 10", " 11", " 12",
                " 13", " 14", " 15", " 16",
                "1", "2 ", " 3", " 4",
                " 8", " 7", " 6", " 5",
                " 9", " 10", " 11", " 12",
                " 13", " 14", " 15", " 16",
                "1", "2 ", " 3", " 4",
                " 8", " 7", " 6", " 5",
                " 9", " 10", " 11", " 12",
                " 13", " 14", " 15", " 16"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, blanks);

        gridView.setAdapter(adapter);
        gridView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    gridView.requestFocusFromTouch();
                    //     gridView.getSelectedView().setBackgroundColor(Color.parseColor("#000000"));
                    gridView.setSelection(gridView.pointToPosition((int) event.getX(), (int) event.getY()));

                    return true;
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    gridView.clearFocus();

                    return true;
                }

                return false;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_custom_map, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
