package geekfest.com.byldafarm;


import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.PercentFormatter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfitFragment extends android.support.v4.app.Fragment {

    protected ArrayList<String> mParties = new ArrayList<>();
    FarmCalculationResult mainResult;
    private PieChart mChart;
    int farmBudget;
    private ArrayList<Crop> arrayList;

    public ProfitFragment() {

    }

    public ProfitFragment(ArrayList<Crop> crop, FarmCalculationResult farmCalculationResult, int budget) {
        arrayList = crop;
        mainResult = farmCalculationResult;
        farmBudget = budget;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_profit, container, false);

        mChart = (PieChart) rootView.findViewById(R.id.chart);
        mChart.setDescription("Mixed cropping distribution");
        mChart.setDescriptionTextSize(24);
        mChart.setUsePercentValues(true);
        mChart.setHoleColorTransparent(true);

        mChart.setCenterText(getResources().getString(R.string.profit) +" \u20B9 " +String.format("%.2f",mainResult.totalProfit));
        setData(3, 100);
        mChart.setCenterTextSizePixels(50);
        Log.d("Area", mainResult.areaUsed + "");
        TextView areaText = (TextView) rootView.findViewById(R.id.areaUsed);
        TextView totalCost = (TextView) rootView.findViewById(R.id.totalCost);
        areaText.setText(getResources().getString(R.string.area) + " " + String.format("%.2f",mainResult.areaUsed) + " hectares");
        totalCost.setText(getResources().getString(R.string.cost) + " " + String.format("%.2f",mainResult.totalCost));

        if(mainResult.totalCost > farmBudget) {
            Toast.makeText(getActivity(), "The total cost is more than your budget", Toast.LENGTH_LONG)
                    .show();
        }

        TextView seed1 = (TextView) rootView.findViewById(R.id.aacostofseeds1);
        TextView fert1 = (TextView) rootView.findViewById(R.id.aafertilizer1);
        TextView insec1 = (TextView) rootView.findViewById(R.id.insecticide1);
        TextView irri1 = (TextView) rootView.findViewById(R.id.aairrigation1);
        TextView labour1 = (TextView) rootView.findViewById(R.id.aalabour1);
        TextView animallabour1 = (TextView) rootView.findViewById(R.id.aaanimallabour1);
        TextView crop1 = (TextView) rootView.findViewById(R.id.crop1name);
        TextView interest = (TextView) rootView.findViewById(R.id.interest);
        TextView rent = (TextView) rootView.findViewById(R.id.rent);
        TextView depreciation = (TextView) rootView.findViewById(R.id.depreciation);

        crop1.setText(arrayList.get(0).cropName + "(Per Hectare)");

        if(mainResult.maxAreaCrop1 != 0.0) {
            Log.d("raghav", ""+arrayList.get(0).maxArea);

            seed1.setText(getResources().getString(R.string.seed) +" \u20B9 " + arrayList.get(0).seedCost);
            fert1.setText(getResources().getString(R.string.fertiliser) +" \u20B9 " + arrayList.get(0).fertilizerCost);
            irri1.setText(getResources().getString(R.string.irrigation) +" \u20B9 " + arrayList.get(0).irrigationCost);
            insec1.setText(getResources().getString(R.string.insecticides) +" \u20B9 " + arrayList.get(0).insecticides);
            labour1.setText(getResources().getString(R.string.human) +" \u20B9 "+ arrayList.get(0).manualLabourCost);
            animallabour1.setText(getResources().getString(R.string.animal) +" \u20B9 " + arrayList.get(0).animalLabourCost);
            interest.setText(getResources().getString(R.string.interest) +" \u20B9 " + arrayList.get(0).totalInterest);
            rent.setText(getResources().getString(R.string.rent) +" \u20B9 " + arrayList.get(0).totalRent);
            depreciation.setText(getResources().getString(R.string.depreciation) +" \u20B9 " + arrayList.get(0).totalDepreciation );

        } else {

            crop1.setVisibility(View.GONE);
            seed1.setVisibility(View.GONE);
            insec1.setVisibility(View.GONE);
            fert1.setVisibility(View.GONE);
            irri1.setVisibility(View.GONE);
            labour1.setVisibility(View.GONE);
            animallabour1.setVisibility(View.GONE);

        }

        TextView seed2 = (TextView) rootView.findViewById(R.id.aacostofseeds2);
        TextView fert2 = (TextView) rootView.findViewById(R.id.aafertilizer2);
        TextView insec2 = (TextView) rootView.findViewById(R.id.insecticide2);
        TextView irri2 = (TextView) rootView.findViewById(R.id.aairrigation2);
        TextView labour2 = (TextView) rootView.findViewById(R.id.aalabour2);
        TextView crop2 = (TextView) rootView.findViewById(R.id.crop2name);
        TextView animallabour2 = (TextView) rootView.findViewById(R.id.aaanimallabour2);


        if(arrayList.size() >= 2) {

            crop2.setText(arrayList.get(1).cropName + "(Per Hectare)");

            if (mainResult.maxAreaCrop2 != 0.0) {
                Log.d("raghav", "" + arrayList.get(1).maxArea);

                seed2.setText(getResources().getString(R.string.seed) +" \u20B9 " + arrayList.get(1).seedCost);
                fert2.setText(getResources().getString(R.string.fertiliser) +" \u20B9 " + arrayList.get(1).fertilizerCost);
                irri2.setText(getResources().getString(R.string.irrigation) +" \u20B9 " +arrayList.get(1).irrigationCost);
                insec2.setText(getResources().getString(R.string.insecticides) +" \u20B9 " + arrayList.get(1).insecticides);
                labour2.setText(getResources().getString(R.string.human) +" \u20B9 " +arrayList.get(1).manualLabourCost);
                animallabour2.setText(getResources().getString(R.string.animal) +" \u20B9 " + arrayList.get(1).animalLabourCost);
                int totalInterest = arrayList.get(0).totalInterest ;//+ arrayList.get(1).totalInterest;
                int totalRent = arrayList.get(0).totalRent;// + arrayList.get(1).totalRent;
                int totalDepreciation = arrayList.get(0).totalDepreciation ;//+ arrayList.get(1).totalDepreciation;
                interest.setText(getResources().getString(R.string.interest) +" \u20B9 " + totalInterest);
                rent.setText(getResources().getString(R.string.rent) +" \u20B9 " + totalRent);
                depreciation.setText(getResources().getString(R.string.depreciation) +" \u20B9 " + totalDepreciation);

            } else {
                crop2.setVisibility(View.GONE);
                insec2.setVisibility(View.GONE);
                seed2.setVisibility(View.GONE);
                fert2.setVisibility(View.GONE);
                irri2.setVisibility(View.GONE);
                labour2.setVisibility(View.GONE);
                animallabour2.setVisibility(View.GONE);
            }
        } else {
            insec2.setVisibility(View.GONE);
            crop2.setVisibility(View.GONE);
            seed2.setVisibility(View.GONE);
            fert2.setVisibility(View.GONE);
            irri2.setVisibility(View.GONE);
            labour2.setVisibility(View.GONE);
            animallabour2.setVisibility(View.GONE);
        }
        TextView seed3 = (TextView) rootView.findViewById(R.id.aacostofseeds3);
        TextView fert3 = (TextView) rootView.findViewById(R.id.aafertilizer3);
        TextView insec3 = (TextView) rootView.findViewById(R.id.insecticide3);
        TextView irri3 = (TextView) rootView.findViewById(R.id.aairrigation3);
        TextView labour3 = (TextView) rootView.findViewById(R.id.aalabour3);
        TextView crop3 = (TextView) rootView.findViewById(R.id.crop3name);
        TextView animallabour3 = (TextView) rootView.findViewById(R.id.aaanimallabour3);

        if(arrayList.size() >= 3) {

            crop3.setText(arrayList.get(2).cropName + "(Per Hectare)");
            if (mainResult.maxAreaCrop3 != 0.0) {
                Log.d("raghav", "" + arrayList.get(2).maxArea);

                seed3.setText(getResources().getString(R.string.seed) +" \u20B9 " +arrayList.get(2).seedCost);
                fert3.setText(getResources().getString(R.string.fertiliser) +" \u20B9 " +arrayList.get(2).fertilizerCost);
                insec3.setText(getResources().getString(R.string.insecticides) +" \u20B9 " + arrayList.get(2).insecticides);
                irri3.setText(getResources().getString(R.string.irrigation) +" \u20B9 " + arrayList.get(2).irrigationCost);
                labour3.setText(getResources().getString(R.string.human) +" \u20B9 " +arrayList.get(2).manualLabourCost);
                animallabour3.setText(getResources().getString(R.string.animal) +" \u20B9 " +arrayList.get(2).animalLabourCost);
                int totalInterest = arrayList.get(0).totalInterest;// + arrayList.get(1).totalInterest + arrayList.get(2).totalInterest;
                int totalRent = arrayList.get(0).totalRent ;//+ arrayList.get(1).totalRent + arrayList.get(2).totalRent;
                int totalDepreciation = arrayList.get(0).totalDepreciation;// + arrayList.get(1).totalDepreciation + arrayList.get(2).totalDepreciation;
                interest.setText(getResources().getString(R.string.interest) +" \u20B9 " + totalInterest);
                rent.setText(getResources().getString(R.string.rent) +" \u20B9 " +totalRent);
                depreciation.setText(getResources().getString(R.string.depreciation) +" \u20B9 " +totalDepreciation);
            } else {
                crop3.setVisibility(View.GONE);
                insec3.setVisibility(View.GONE);
                seed3.setVisibility(View.GONE);
                fert3.setVisibility(View.GONE);
                irri3.setVisibility(View.GONE);
                labour3.setVisibility(View.GONE);
                animallabour3.setVisibility(View.GONE);
            }
        } else {
            crop3.setVisibility(View.GONE);
            insec3.setVisibility(View.GONE);
            seed3.setVisibility(View.GONE);
            fert3.setVisibility(View.GONE);
            irri3.setVisibility(View.GONE);
            labour3.setVisibility(View.GONE);
            animallabour3.setVisibility(View.GONE);
        }




        return rootView;
    }

    private void setData(int count, float range) {
        float mult = range;
        for (int i = 0; i < arrayList.size(); i++) {
            mParties.add(arrayList.get(i).cropName);
        }
        ArrayList<Entry> yVals1 = new ArrayList<Entry>();
        yVals1.add(new Entry((float) mainResult.maxAreaCrop1, 0));
        yVals1.add(new Entry((float) mainResult.maxAreaCrop2, 1));
        yVals1.add(new Entry((float) mainResult.maxAreaCrop3, 2));
        ArrayList<String> xVals = new ArrayList<String>();
        for (int i = 0; i < count + 1; i++)
            xVals.add(mParties.get(i % mParties.size()));
        PieDataSet dataSet = new PieDataSet(yVals1, "");
        dataSet.setSliceSpace(3f);
// add a lot of colors
        ArrayList<Integer> colors = new ArrayList<Integer>();
//        for (int c : ColorTemplate.VORDIPLOM_COLORS)
//            colors.add(c);
//        for (int c : ColorTemplate.JOYFUL_COLORS)
//            colors.add(c);
        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);
        colors.add(ColorTemplate.getHoloBlue());
        dataSet.setColors(colors);
        PieData data = new PieData(xVals, dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
        mChart.setData(data);
// undo all highlights
        mChart.highlightValues(null);
        mChart.invalidate();
    }


}
