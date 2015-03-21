package geekfest.com.byldafarm;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;


public class CustomMapActivity extends ActionBarActivity {

    private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_map);
        gridView = (GridView) findViewById(R.id.grid_view);

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
