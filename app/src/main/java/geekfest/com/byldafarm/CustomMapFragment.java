package geekfest.com.byldafarm;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by prempal on 29/4/15.
 */
public class CustomMapFragment extends Fragment {

    String area;
    ArrayList<Crop> crops;
    private GridView gridView;
    private Button submitButton;
    private RadioGroup radioGroup;
    private TextView areaText;
    private Calendar calendar;
    int budget;
    private Adapter gridAdapter;

    public CustomMapFragment() {

    }

    public CustomMapFragment(ArrayList<Crop> crop, String farmArea, int budget) {
        crops = crop;
        area = farmArea;
        budget = budget;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_custom_map, container, false);
        gridView = (GridView) rootView.findViewById(R.id.grid_view);
        areaText = (TextView) rootView.findViewById(R.id.areaText);
        areaText.setText("Scale : 1 unit = " + Float.parseFloat(area) / 25.0 + " Hectare");
        submitButton = (Button) rootView.findViewById(R.id.submit);
        radioGroup = new RadioGroup(getActivity());
        radioGroup.setOrientation(LinearLayout.HORIZONTAL);
        RelativeLayout relativeLayout = (RelativeLayout) rootView.findViewById(R.id.relativeLayout);
        final ArrayList<String> cropList = new ArrayList<>();
        for (int i = 0; i < crops.size(); i++) {
            cropList.add(i, crops.get(i).cropName);
        }

        for (int i = 0; i < cropList.size(); i++) {
            final RadioButton button = new RadioButton(getActivity());
            button.setId(i);
            button.setBackgroundColor(Color.parseColor("#00000000"));
            button.setButtonDrawable(R.drawable.bbuton_primary_rounded);
            button.setPadding(80, 40, 0, 10);
            button.setTextSize(25);
            button.setText(cropList.get(i));
            button.setTextColor(Color.parseColor("#bdbdbd"));
            final int j = i;
            button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (buttonView.isChecked()) {
                        switch (j) {
                            case 0:
                                button.setTextColor(Color.parseColor("#FF0000"));
                                break;
                            case 1:
                                button.setTextColor(Color.parseColor("#00FF00"));
                                break;
                            case 2:
                                button.setTextColor(Color.parseColor("#0000FF"));
                                break;
                        }
                    } else {
                        button.setTextColor(Color.parseColor("#bdbdbd"));
                    }
                }
            });
            radioGroup.addView(button);
        }

        relativeLayout.addView(radioGroup);
        ArrayList<String> cropsGrown = Utils.getSeason();


        gridAdapter = new Adapter(getActivity());
        gridView.setAdapter(gridAdapter);
        gridView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    gridView.requestFocusFromTouch();
//                         gridView.getFocusedChild().setBackgroundColor(Color.parseColor("#000000"));

                    gridView.setSelection(gridView.pointToPosition((int) event.getX(), (int) event.getY()));
                    if (gridView.getSelectedItemPosition() != -1 && gridView.getChildAt(gridView.getSelectedItemPosition()).getTag() == null) {
                        switch (radioGroup.getCheckedRadioButtonId()) {
                            case 0:
                                gridView.getChildAt(gridView.getSelectedItemPosition()).setBackgroundColor(Color.parseColor("#FF0000"));
                                gridView.getChildAt(gridView.getSelectedItemPosition()).setTag(0);
                                break;
                            case 1:
                                gridView.getChildAt(gridView.getSelectedItemPosition()).setBackgroundColor(Color.parseColor("#00FF00"));
                                gridView.getChildAt(gridView.getSelectedItemPosition()).setTag(1);
                                break;
                            case 2:
                                gridView.getChildAt(gridView.getSelectedItemPosition()).setBackgroundColor(Color.parseColor("#0000FF"));
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
                double crop1 = 0.0;
                double crop2 = 0.0;
                double crop3 = 0.0;
                double sum = 0.0;
                for (int i = 0; i < gridView.getChildCount(); i++) {
                    if (gridView.getChildAt(i).getTag() != null) {
                        int index = (Integer) gridView.getChildAt(i).getTag();
                        switch (index) {
                            case 0:
                                crop1++;
                                break;
                            case 1:
                                crop2++;
                                break;
                            case 2:
                                crop3++;
                                break;
                        }
                        sum++;
                    }
                }

                if (sum == gridView.getChildCount()) {
                    Log.d("Crop Value", crop1 + " " + crop2 + " " + crop3);
//                    Intent intent = new Intent(getApplicationContext(), CustomProfitActivity.class);
//                    intent.putExtra("crop1", crop1);
//                    intent.putExtra("crop2", crop2);
//                    intent.putExtra("crop3", crop3);
//                    startActivity(intent);
                    double Area = Double.parseDouble(area);
                    FarmCalculationResult farmCalculationResult = new FarmCalculationResult();
                    farmCalculationResult.maxAreaCrop1 = crop1 / 25 * Area;
                    farmCalculationResult.maxAreaCrop2 = crop2 / 25 * Area;
                    farmCalculationResult.maxAreaCrop3 = crop3 / 25 * Area;
                    double profit = 0.0;
                    double cost = 0.0;
                    for (int i = 0; i < crops.size(); i++) {
                        if (i == 0) {
                            profit = profit + ((crops.get(i).sellingPrice * (crop1 / 25 * Area)) - (crops.get(i).costPrice * (crop1 / 25 * Area)));
                            cost = cost + (crops.get(i).costPrice * (crop1 / 25 * Area));
                        } else if (i == 1) {
                            profit = profit + ((crops.get(i).sellingPrice * (crop2 / 25 * Area)) - (crops.get(i).costPrice * (crop2 / 25 * Area)));
                            cost = cost + (crops.get(i).costPrice * (crop1 / 25 * Area));
                        } else if (i == 2) {
                            profit = profit + ((crops.get(i).sellingPrice * (crop3 / 25 * Area)) - (crops.get(i).costPrice * (crop3 / 25 * Area)));
                            cost = cost + (crops.get(i).costPrice * (crop1 / 25 * Area));
                        }
                    }
                    farmCalculationResult.areaUsed = Area;
                    farmCalculationResult.totalProfit = profit;
                    farmCalculationResult.totalCost = cost;
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container_custom_map, new ProfitFragment(crops, farmCalculationResult,budget))
                            .commit();
                }
            }

        });
        return rootView;
    }

    public class Adapter extends BaseAdapter {

        Context c;

        public Adapter(Context context) {
            this.c = context;
        }

        @Override
        public int getCount() {
            return 25;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
            View v = convertView;
            if (convertView == null) {
                v = layoutInflater.inflate(R.layout.grid_item, null);
            }
            return v;
        }
    }
}
