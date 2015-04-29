package geekfest.com.byldafarm;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import java.util.ArrayList;


public class CustomMapActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_map);
        Intent intent = getIntent();
        final String area = intent.getStringExtra("Area");
        final ArrayList<Crop> crops = (ArrayList<Crop>) intent.getSerializableExtra("Crops");
        final int budget = intent.getIntExtra("Budget", 0);
        Log.d("Area", area);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container_custom_map, new CustomMapFragment(crops, area, budget))
                    .commit();
        }
    }

}
