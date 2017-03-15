package delhi.android.nit.com.terratechnica;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;


public class Robotics_Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private int mParam1;
    RecyclerView rvEvent;
    
    public Robotics_Fragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Robotics_Fragment newInstance(int param1) {
        Robotics_Fragment fragment = new Robotics_Fragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Explode explode = new Explode();
            explode.setDuration(500);
            explode.excludeTarget(android.R.id.navigationBarBackground,true);
            getActivity().getWindow().setEnterTransition(new Slide(Gravity.TOP));
            getActivity().getWindow().setExitTransition(new Fade());
            Transition transition1 =  TransitionInflater.from(getActivity()).inflateTransition(R.transition.transition);
            transition1.excludeTarget(android.R.id.navigationBarBackground,true);
            //transition1.setStartDelay(1000);
            getActivity().getWindow().setSharedElementExitTransition(transition1);
            getActivity().getWindow().setReenterTransition(new Fade());
            /*Explode explode1 = new Explode();
            explode1.setDuration(700);
            getActivity().getWindow().setExitTransition(explode1);*/
        }

        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event__main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvEvent = (RecyclerView) view.findViewById(R.id.rvEvent);
        rvEvent.setLayoutManager(new LinearLayoutManager(getContext()));
        rvEvent.setAdapter(new Adater());

    }

    private class Adater extends RecyclerView.Adapter<Holder>{

        public Adater() {
        }

        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_view1,parent,false);
            Holder holder = new Holder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(final Holder holder, int position) {
            if(mParam1 == 1) {
                holder.textView2.setText(Data.roboEvent[position]);
                holder.titleDesp.setText("(" + "Robotics" + ")");
                //Uri uri = Uri.parse("android.resource://delhi.android.nit.com.terratechnica/drawable/asdfgh");
                Picasso.with(getContext())
                        .load(Data.RoboPics[position])
                        .resize(500,500)
                        .centerCrop()
                        .into(holder.imageView2);
            }else{
                Picasso.with(getContext())
                        .load(R.drawable.asdfgh)
                        .resize(700,700)
                        .into(holder.imageView2);
            }
            // ViewCompat.setTransitionName(holder.album_image,String.valueOf(position) + "_albumart");
        }

        @Override
        public int getItemCount() {
            if(mParam1 == 1)
                return 8;
            else
                return 8;
        }
    }


    private class Holder extends RecyclerView.ViewHolder{
        ImageView imageView2;
        TextView textView2,titleDesp,despDesp;
        LinearLayout back;
        public Holder(final View itemView) {
            super(itemView);
            imageView2 = (ImageView) itemView.findViewById(R.id.imageView2);
            textView2 = (TextView) itemView.findViewById(R.id.textView2);
            titleDesp = (TextView) itemView.findViewById(R.id.textView5);
            back = (LinearLayout) itemView.findViewById(R.id.back);

            itemView.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                            {
                                //imageResId = image[recyclerView1.getChildAdapterPosition(itemView)];
                                //Log.e("Manojit",""+recyclerView1.getChildAdapterPosition(itemView));
                                Intent intent = new Intent(getActivity(),Event_Description.class);
                                intent.putExtra("position",rvEvent.getChildAdapterPosition(itemView));
                                intent.putExtra("type","robotics");
                                ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(),imageView2,imageView2.getTransitionName());
                                startActivity(intent,activityOptionsCompat.toBundle());
                            }
                            else{
                                Intent intent = new Intent(getActivity(),Event_Description.class);
                                intent.putExtra("position",rvEvent.getChildAdapterPosition(itemView));
                                intent.putExtra("type","robotics");
                                startActivity(intent);
                            }
                        }
                    }
            );
        }
    }
    
    
}
