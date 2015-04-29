package geekfest.com.byldafarm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by prempal on 22/3/15.
 */
public class MainFragment extends Fragment {

    String stringToPassInSQL = "", location = "";
    float maxProfit;
    private Button submitButton, buildFarmButton;
    private EditText farmAreaEdTxt,farmBudgetEdTxt;
    private Spinner farmLocation;
    private ProgressBar progressBar;

    public MainFragment() {
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        submitButton = (Button) rootView.findViewById(R.id.submit);
        farmAreaEdTxt = (EditText) rootView.findViewById(R.id.farm_area);
        farmBudgetEdTxt = (EditText) rootView.findViewById(R.id.farm_budget);
        farmLocation = (Spinner) rootView.findViewById(R.id.farm_location);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, new String[]{"Agra","agra"});
        farmLocation.setAdapter(dataAdapter);
        buildFarmButton = (Button) rootView.findViewById(R.id.build_a_farm);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progressBar);

        ArrayList<String> cropsGrown = Utils.getSeason();


        for (int i = 0; i < cropsGrown.size(); i++) {
            if (i == cropsGrown.size() - 1) {
                stringToPassInSQL = stringToPassInSQL + "\'" + cropsGrown.get(i) + "\');";
            } else
                stringToPassInSQL = stringToPassInSQL + "\'" + cropsGrown.get(i) + "\', "; //"\' OR Season LIKE ";
        }
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validate()) {

                    final int farmBudget = Integer.parseInt(farmBudgetEdTxt.getText().toString());
                    final double farmArea = Double.parseDouble(farmAreaEdTxt.getText().toString());
                    location = farmLocation.getSelectedItem().toString();
                    final String sqlInput = "SELECT * FROM `nigga` WHERE District LIKE " + "\'" + location + "\'" + " AND Season IN (" + stringToPassInSQL;

                    Log.d("Raghav", sqlInput);
                    new QueryTask() {

                        @Override
                        protected void onPreExecute() {
                            progressBar.setVisibility(View.VISIBLE);
                        }


                        @Override
                        protected void onPostExecute(String stringResponse) {
                            try {

                                JSONArray jsonArray = new JSONArray(stringResponse);
                                ArrayList<Crop> crop = new ArrayList<Crop>();
                                int i = 0;
                                while (i < jsonArray.length() && i < 3) {
                                    crop.add(i, new Crop());
                                    crop.get(i).cropName = jsonArray.getJSONObject(i).getString("Crop");
                                    crop.get(i).seedCost = jsonArray.getJSONObject(i).getInt("SeedCost");
                                    crop.get(i).fertilizerCost = jsonArray.getJSONObject(i).getInt("Fertilizer");
                                    crop.get(i).irrigationCost = jsonArray.getJSONObject(i).getInt("Irrigation");
                                    crop.get(i).labourCost = jsonArray.getJSONObject(i).getInt("LabourCost");
                                    crop.get(i).sellingPrice = jsonArray.getJSONObject(i).getInt("SellingPrice");
                                    crop.get(i).costPrice = jsonArray.getJSONObject(i).getInt("CostPrice");
                                    i++;
                                }
                                FarmCalculationResult farmCalResult = AlgorithmTwoCrops.efficientFarm(farmBudget, farmArea, crop);

//                            for( i = 0; i < crop.size(); i++){
//                                if(i == 0){
//                                    crop.get(i).maxArea = farmCalResult.maxAreaCrop1;
//
//                                } else if (i == 1) {
//                                   crop.get(i).maxArea = farmCalResult.maxAreaCrop2;
//
//                                } else if (i ==2) {
//                                    crop.get(i).maxArea = farmCalResult.maxAreaCrop3;
//
//                                }
//                            }
//                            maxProfit = farmCalResult.totalProfit;
                                Log.d("Raghav", "" + maxProfit + "" + farmCalResult.maxAreaCrop1 + "" + farmCalResult.maxAreaCrop2 + "" + farmCalResult.maxAreaCrop3);
                                progressBar.setVisibility(View.GONE);

                                getActivity().getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.container, new ProfitFragment(crop, farmCalResult))
                                        .addToBackStack("profitFragment")
                                        .commit();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }.execute(sqlInput);


                }
            }
        });
        buildFarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validate()) {
                    final int farmBudget = Integer.parseInt(farmBudgetEdTxt.getText().toString());
                    final int farmArea = Integer.parseInt(farmAreaEdTxt.getText().toString());
                    location = farmLocation.getSelectedItem().toString();
                    final String sqlInput = "SELECT * FROM `nigga` WHERE District LIKE " + "\'" + location + "\'" + " AND Season IN (" + stringToPassInSQL;

                    Log.d("Raghav", sqlInput);
                    new QueryTask() {

                        @Override
                        protected void onPreExecute() {
                            progressBar.setVisibility(View.VISIBLE);
                        }


                        @Override
                        protected void onPostExecute(String stringResponse) {
                            try {

                                JSONArray jsonArray = new JSONArray(stringResponse);
                                ArrayList<Crop> crop = new ArrayList<Crop>();
                                int i = 0;
                                while (i < jsonArray.length() && i < 3) {
                                    crop.add(i, new Crop());
                                    crop.get(i).cropName = jsonArray.getJSONObject(i).getString("Crop");
                                    crop.get(i).seedCost = jsonArray.getJSONObject(i).getInt("SeedCost");
                                    crop.get(i).fertilizerCost = jsonArray.getJSONObject(i).getInt("Fertilizer");
                                    crop.get(i).irrigationCost = jsonArray.getJSONObject(i).getInt("Irrigation");
                                    crop.get(i).labourCost = jsonArray.getJSONObject(i).getInt("LabourCost");
                                    crop.get(i).sellingPrice = jsonArray.getJSONObject(i).getInt("SellingPrice");
                                    crop.get(i).costPrice = jsonArray.getJSONObject(i).getInt("CostPrice");
                                    i++;
                                }
                                Intent intent = new Intent(getActivity(), CustomMapActivity.class);
                                intent.putExtra("Area", farmAreaEdTxt.getText().toString());
                                intent.putExtra("Crops", crop);
                                startActivity(intent);
                                progressBar.setVisibility(View.GONE);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }.execute(sqlInput);
                }

            }
        });


        return rootView;
    }

    private boolean validate() {
        if (Utils.isEditTextEmpty(farmAreaEdTxt)) {
            farmAreaEdTxt.setError("Required");
            return false;
        }
        if (Utils.isEditTextEmpty(farmBudgetEdTxt)) {
            farmBudgetEdTxt.setError("Required");
            return false;
        }
        return true;
    }

}