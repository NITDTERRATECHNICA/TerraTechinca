package layout;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import delhi.android.nit.com.terratechnica.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Contact_Us extends Fragment {
    RecyclerView contactRV;
    String[] name = {"Agrima Rajput","Anish","Vipin Kumar","Naman Jain","Aditya Kumar","Abha Khinoo",
            "Nimisha Karnam","Vaibhav Kinra","Sahil Sinha","Prithvish Banerjee","Sunil Vaishnav","Sanjana Sinha",
            "Manojit Paul","Akaash Vishal Hazarika","Yash Jain"};

    String[] post = {"Convener","Co-convener","Co-convener","Technical ","Design and Print","Event ",
            "Publicity ","Infrastructure ","Sponsorhip ","Hospitality","Discipline","Creative Content",
            "Android Developer","Android Developer","Android Developer"};

    String[] number = {"9650419350","8130113842","9717271101"};

    String[] mail = {"manojitp4@gmail.com","anurag@gmail.com",
            "kapil@gmail.com"};

    public Contact_Us() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact__us, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        contactRV = (RecyclerView) view.findViewById(R.id.contactRV);
        contactRV.setLayoutManager(new LinearLayoutManager(getContext()));
        contactRV.setAdapter(new Adapter());
    }

    private class Adapter extends RecyclerView.Adapter<Holder>{

        @Override
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_contact_us,parent,false));
        }

        @Override
        public void onBindViewHolder(Holder holder, int position) {
            Picasso.with(getContext())
                    .load(R.drawable.asdfgh)
                    .resize(400,400)
                    .centerCrop()
                    .into(holder.imageView);
            holder.textView1.setText("Name "+position);
            holder.textView2.setText("Post");
        }

        @Override
        public int getItemCount() {
            return 15;
        }
    }


    private class Holder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView1,textView2;
        ImageButton imageButton1,imageButton2;

        public Holder(final View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.people_image);
            textView1 = (TextView) itemView.findViewById(R.id.people_name);
            textView2 = (TextView) itemView.findViewById(R.id.people_post);
            imageButton1 = (ImageButton) itemView.findViewById(R.id.people_call);
            imageButton2 = (ImageButton) itemView.findViewById(R.id.people_mail);

            imageButton1.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int n = contactRV.getChildAdapterPosition(itemView);
                            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number[(n%3)]));
                            startActivity(intent);
                        }
                    }
            );

            imageButton2.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int n = contactRV.getChildAdapterPosition(itemView);
                            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                                    "mailto",mail[n%3],null));
                            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "FeedBack");
                            //emailIntent.putExtra(Intent.EXTRA_TEXT, "Body");
                            startActivity(Intent.createChooser(emailIntent, "Send email..."));
                        }
                    }
            );

        }
    }
}
