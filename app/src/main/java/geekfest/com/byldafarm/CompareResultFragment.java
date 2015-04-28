package geekfest.com.byldafarm;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by pujamathur on 22/3/15.
 */
public class CompareResultFragment extends Fragment {

    public CompareResultFragment() {
        // Required empty public constructor
    }

    public static CompareResultFragment newInstance() {
        CompareResultFragment compareResultFragment = new CompareResultFragment();
        return compareResultFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_compare_result, container, false);
    }

}
