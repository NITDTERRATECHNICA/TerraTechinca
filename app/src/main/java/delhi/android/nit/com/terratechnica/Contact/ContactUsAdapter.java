package delhi.android.nit.com.terratechnica.Contact;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

import delhi.android.nit.com.terratechnica.R;

/**
 * Created by Directioner on 3/16/2017.
 */

// This class is not required anymore ...

public class ContactUsAdapter extends RecyclerView.Adapter<ContactUsAdapter.MyViewHolder> {

    private static String URL = "http://insigniathefest.com/manojit/Shivam/";
    private List<ParentObject> contactList;
    private ViewGroup parent;

    private View.OnClickListener listener = null;
    private boolean flag = true;

    public ContactUsAdapter(List<ParentObject> contactList) {
        this.contactList = contactList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            this.parent = parent;
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item, parent, false);
            return new MyViewHolder(view);
        } else {
            this.parent = parent;
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_itme2, parent, false);
            return new MyViewHolder(view);
        }
    }

    private boolean isOnline() {

        ConnectivityManager manager = (ConnectivityManager) parent.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = manager.getActiveNetworkInfo();

        return netInfo != null && netInfo.isConnectedOrConnecting();

    }

    private void callPerson(String phno) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("tel:" + phno));
        parent.getContext().startActivity(intent);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final ContactsData contactUs = (ContactsData) contactList.get(position);
        holder.contactName.setText(contactUs.getPersonName());
        holder.supportLevel.setText(contactUs.getPersonSupportLevel());
        holder.contactName1.setText(contactUs.getPersonName());
        holder.supportLevel1.setText(contactUs.getPersonSupportLevel());

        listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callPerson(contactUs.getPersonContactNo());
            }
        };

        if(position % 2 == 0) {
            holder.up.setOnClickListener(listener);

        } else {
            holder.down.setOnClickListener(listener);
        }

        if (position % 2 == 0) {
            holder.down.setVisibility(View.GONE);
            holder.up.setVisibility(View.VISIBLE);

            if (isOnline()) {

                Picasso.with(parent.getContext())
                        .load(URL + contactUs.getPersonImage() + ".jpg")
                        .into(holder.person);
            }
        } else {
            holder.up.setVisibility(View.GONE);
            holder.down.setVisibility(View.VISIBLE);

            if (isOnline()) {
                Picasso.with(parent.getContext())
                        .load(URL + contactUs.getPersonImage() + ".jpg")
                        .into(holder.person1);
            }
            else if (flag) {
                Toast.makeText(parent.getContext(), "Failed to load the images!", Toast.LENGTH_SHORT).show();
                flag = false;
            }
        }
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class MyViewHolder extends ChildViewHolder /* RecyclerView.ViewHolder */ {

        RelativeLayout up, down;
        private TextView contactName, supportLevel, contactName1, supportLevel1;
        private ImageView person, person1;

        MyViewHolder(View itemView) {
            super(itemView);
            contactName = (TextView) itemView.findViewById(R.id.contact_name);
            supportLevel = (TextView) itemView.findViewById(R.id.support_level);
            contactName1 = (TextView) itemView.findViewById(R.id.contact_name1);
            supportLevel1 = (TextView) itemView.findViewById(R.id.support_level1);
            up = (RelativeLayout) itemView.findViewById(R.id.up);
            down = (RelativeLayout) itemView.findViewById(R.id.down);
            person = (ImageView) itemView.findViewById(R.id.person_image);
            person1 = (ImageView) itemView.findViewById(R.id.person_image1);

        }
    }

/*
    public class MyParentViewHolder extends ParentViewHolder {

        private TextView supportCateg;
        private ImageButton downArrow;

        public MyParentViewHolder(View itemView) {
            super(itemView);


        }
    }
*/
}
