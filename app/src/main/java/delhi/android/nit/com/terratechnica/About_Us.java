package delhi.android.nit.com.terratechnica;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class About_Us extends Fragment {

    ImageView image_logo;
    public About_Us() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about__us, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        image_logo = (ImageView) view.findViewById(R.id.image_logo);
        Uri uri = Uri.parse("android.resource://delhi.android.nit.com.terratechnica/drawable/logo2");
        Picasso.with(getContext())
                .load(uri)
                .into(image_logo);
    }
}
