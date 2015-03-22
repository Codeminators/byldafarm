package geekfest.com.byldafarm;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by prempal on 22/3/15.
 */
public class MainFragment extends Fragment {

    private Button submitButton;
    private EditText farmAreaEdTxt, farmLocationEdTxt, farmBudgetEdTxt;
    String stringToPassInSQL = "";
    public MainFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        submitButton = (Button) rootView.findViewById(R.id.submit);
        farmAreaEdTxt = (EditText) rootView.findViewById(R.id.farm_area);
        farmBudgetEdTxt = (EditText) rootView.findViewById(R.id.farm_budget);
        farmLocationEdTxt = (EditText) rootView.findViewById(R.id.farm_location);

        ArrayList<String> cropsGrown = Utils.getSeason();

        final String location = farmLocationEdTxt.getText().toString();
        for(int i = 0; i < cropsGrown.size(); i++){
            if( i == cropsGrown.size() - 1){
                stringToPassInSQL = stringToPassInSQL + "\'"+cropsGrown.get(i)+"\'";
            } else
            stringToPassInSQL = stringToPassInSQL + "\'"+cropsGrown.get(i)+"\' OR Season=";
        }
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String sqlInput = "SELECT * FROM `TABLE 1` WHERE District LIKE " + location + "AND Season LIKE "+ stringToPassInSQL;

                Log.d("Raghav", sqlInput);
                new QueryTask(){
                    @Override
                    protected void onPostExecute(String s) {
                        Log.d("Raghav", s);
                    }
                }.execute(sqlInput);

            }
        });
        return rootView;
    }
}