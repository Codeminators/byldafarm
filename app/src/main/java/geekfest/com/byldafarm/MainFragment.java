package geekfest.com.byldafarm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by prempal on 22/3/15.
 */
public class MainFragment extends Fragment {

    private Button submitButton, buildFarmButton;
    private EditText farmAreaEdTxt, farmLocationEdTxt, farmBudgetEdTxt;
    String stringToPassInSQL = "";
    private ProgressBar progressBar;
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
        buildFarmButton = (Button) rootView.findViewById(R.id.build_a_farm);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progressBar);

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
                if(checkNotNull()) {
                    final String sqlInput = "SELECT * FROM `TABLE 1` WHERE District LIKE " + location + "AND Season LIKE " + stringToPassInSQL;

                    Log.d("Raghav", sqlInput);
                    new QueryTask() {
                        @Override
                        protected void onPreExecute() {
                            progressBar.setVisibility(View.VISIBLE);
                            super.onPreExecute();
                        }

                        @Override
                        protected void onPostExecute(String s) {
                            progressBar.setVisibility(View.GONE);
                            Log.d("Raghav", s);
                        }
                    }.execute(sqlInput);
                }
            }
        });
        buildFarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(checkNotNull()){
                    Intent intent = new Intent(getActivity().getApplicationContext(), CustomMapActivity.class);
                    intent.putExtra("Area", farmAreaEdTxt.getText().toString());
                    startActivity(intent);
                }
            }
        });


    return rootView;
    }

    public boolean checkNotNull(){
        if(farmAreaEdTxt.getText().toString().equals("")){
            Toast.makeText(getActivity().getApplicationContext(), "Please enter area", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(farmBudgetEdTxt.getText().toString().equals("")){
            Toast.makeText(getActivity().getApplicationContext(), "Please enter budget", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(farmLocationEdTxt.getText().toString().equals("")){
            Toast.makeText(getActivity().getApplicationContext(), "Please enter location", Toast.LENGTH_SHORT).show();
            return false;
        }
        Log.d("Show text", farmAreaEdTxt.getText().toString());

        return true;
    }
}