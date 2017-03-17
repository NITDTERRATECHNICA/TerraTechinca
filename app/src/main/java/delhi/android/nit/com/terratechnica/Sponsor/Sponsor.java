package delhi.android.nit.com.terratechnica.Sponsor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import delhi.android.nit.com.terratechnica.R;


/**
 * Created by Manojit Paul on 3/18/2017.
 */

public class Sponsor extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.contact_us, container, false);
    }
    private RecyclerView recyclerView;
    ImageView contactBG;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new SponsorUsAdapter());
        contactBG = (ImageView) view.findViewById(R.id.contactBG);
        Glide.with(getActivity())
                .load(R.drawable.bg2)
                .crossFade()
                .centerCrop()
                .into(contactBG);
    }

    private class SponsorUsAdapter extends RecyclerView.Adapter<ViewHolder>{

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.no_sponsor,parent,false));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 4;
        }
    }

    private class ViewHolder extends RecyclerView.ViewHolder{

        ImageView sponsor_image;
        TextView sponsor_name,sponsor_support_level,sponsor_weblink;

        public ViewHolder(View itemView) {
            super(itemView);
            sponsor_image = (ImageView) itemView.findViewById(R.id.sponsor_image);
            sponsor_name = (TextView) itemView.findViewById(R.id.sponsor_name);
            sponsor_support_level = (TextView) itemView.findViewById(R.id.sponsor_support_level);
            sponsor_weblink = (TextView) itemView.findViewById(R.id.sponsor_weblink);

        }
    }
}
