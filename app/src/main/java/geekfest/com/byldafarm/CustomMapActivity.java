package geekfest.com.byldafarm;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Calendar;


public class CustomMapActivity extends ActionBarActivity {

    private GridView gridView;

    private Button submitButton;
    private RadioGroup radioGroup;

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

        submitButton = (Button) findViewById(R.id.submit);
        radioGroup = new RadioGroup(this);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        final ArrayList<String> cropList = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            cropList.add("Crop" + i);
        }

        for(int i = 0; i < cropList.size(); i++){
            RadioButton button = new RadioButton(this);
            button.setText("Button" + i);
            button.setId(i);
            RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            if(i > 0) {
                layoutParams1.addRule(RelativeLayout.RIGHT_OF, i - 1);
            }
            button.setLayoutParams(layoutParams1);
            radioGroup.addView(button);
        }

        relativeLayout.addView(radioGroup);

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
                };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, blanks);

        gridView.setAdapter(adapter);
        gridView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    gridView.requestFocusFromTouch();
//                         gridView.getFocusedChild().setBackgroundColor(Color.parseColor("#000000"));

                    gridView.setSelection(gridView.pointToPosition((int) event.getX(), (int) event.getY()));
                    if(gridView.getSelectedItemPosition() != -1 && gridView.getChildAt(gridView.getSelectedItemPosition()).getTag() == null) {
                        switch (radioGroup.getCheckedRadioButtonId()){
                            case 0 :
                                gridView.getChildAt(gridView.getSelectedItemPosition()).setBackgroundColor(Color.parseColor("#000000"));
                                gridView.getChildAt(gridView.getSelectedItemPosition()).setTag(0);
                                break;
                            case 1 :
                                gridView.getChildAt(gridView.getSelectedItemPosition()).setBackgroundColor(Color.parseColor("#0000FF"));
                                gridView.getChildAt(gridView.getSelectedItemPosition()).setTag(1);
                                break;
                            case 2 :
                                gridView.getChildAt(gridView.getSelectedItemPosition()).setBackgroundColor(Color.parseColor("#00FF00"));
                                gridView.getChildAt(gridView.getSelectedItemPosition()).setTag(2);
                                break;
                        }

                    }

                    return true;
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
//                    gridView.clearFocus();

                    return true;
                }

                return false;
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int crop1 = 0;
                int crop2 = 0;
                int crop3 = 0;
                int sum = 0;
                for(int i = 0; i < gridView.getChildCount(); i++){
                    if(gridView.getChildAt(i).getTag()!= null){
                        int index = (Integer)gridView.getChildAt(i).getTag();
                        switch (index){
                            case 0 : crop1++;
                                break;
                            case 1 : crop2++;
                                break;
                            case 2 : crop3++;
                                break;
                        }
                        sum++;
                    }
                }

                if(sum == gridView.getChildCount()){
                    Log.d("Crop Value", crop1 + " " + crop2 + " " + crop3);
                }
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
