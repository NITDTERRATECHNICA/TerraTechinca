package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import delhi.android.nit.com.terratechnica.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InformalEvent extends Fragment {


    public InformalEvent() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_informal_event, container, false);
    }

}
