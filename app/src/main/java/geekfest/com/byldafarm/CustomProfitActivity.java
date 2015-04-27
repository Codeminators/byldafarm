package geekfest.com.byldafarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomProfitActivity extends ActionBarActivity {
    int bajra[] = {384, 22, 530, 3090, 8954, 4086};
    int maize[] = {183, 580, 383, 4572, 9656, 5413};
    int sugercane[] = {1190, 1815, 98, 6828, 12984, 9931};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_profit);

        Intent intent = getIntent();
        double crop1 = intent.getIntExtra("crop1", 0);
        double crop2 = intent.getIntExtra("crop2", 0);
        double crop3 = intent.getIntExtra("crop3", 0);

        crop1 = Math.round(crop1*1000)/1000.0d;
        crop1 = Math.round(crop1*1000)/1000.0d;
        crop1 = Math.round(crop1*1000)/1000.0d;

        TextView dsv = (TextView) findViewById(R.id.costofseeds);
        TextView dff = (TextView) findViewById(R.id.fertilizer);
        TextView dsdfv = (TextView) findViewById(R.id.irrigation);
        TextView dsdfdv = (TextView) findViewById(R.id.name);
        TextView dsdfddv = (TextView) findViewById(R.id.labour);

        dff.setText("Total profit = Rs. " +(4859*crop1 + 3851*crop2 + 3055*crop3));
        dsdfddv.setText("Total price of labour = Rs. " +(3090*crop1 + 4572*crop2 + 6828*crop3));
        dsdfdv.setText("Total price of seeds = Rs. " +(381*crop1 + 183*crop2 + 1190*crop3));
        dsv.setText("Total price of irrigation = Rs. " +(590*crop1 + 378*crop2 + 98*crop3));
        dsdfv.setText("Total price of fertilizers = Rs. " +(22*crop1 + 580*crop2 + 1815*crop3));


    }


    public class Adapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 3;
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
            LayoutInflater inflater = (LayoutInflater) getApplicationContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.list_item_profit, parent, false);
            TextView name = (TextView) rowView.findViewById(R.id.name);
            TextView irrigation = (TextView) rowView.findViewById(R.id.irrigation);
            TextView costofseeds = (TextView) rowView.findViewById(R.id.costofseeds);
            TextView fertilizer = (TextView) rowView.findViewById(R.id.fertilizer);
            TextView labour = (TextView) rowView.findViewById(R.id.labour);
            if(position ==0){
                name.setText("Bajra");
                irrigation.setText("Irrigation = Rs. " + bajra[2]);
                costofseeds.setText("" +bajra[0]);
                fertilizer.setText(""+bajra[1]);
                labour.setText(""+bajra[3]);
            }
            else if(position==1){
                name.setText("Maize");
                irrigation.setText(""+maize[2]);
                costofseeds.setText(""+maize[0]);
                fertilizer.setText(""+maize[1]);
                labour.setText(""+maize[3]);
            }
            else{
                name.setText("SugarCane");
                irrigation.setText(""+sugercane[2]);
                costofseeds.setText(""+sugercane[0]);
                fertilizer.setText(""+sugercane[1]);
                labour.setText(""+sugercane[3]);
            }
            return null;
        }
    }

}