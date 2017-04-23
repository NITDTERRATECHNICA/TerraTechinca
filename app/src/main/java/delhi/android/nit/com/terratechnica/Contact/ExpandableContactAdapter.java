package delhi.android.nit.com.terratechnica.Contact;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import delhi.android.nit.com.terratechnica.R;

/**
 * Created by directioner on 10/4/17.
 */

public class ExpandableContactAdapter extends ExpandableRecyclerAdapter<CategParentViewHolder, CategChildViewHolder> {

    private LayoutInflater inflater;
    private List<ContactsData> contactList;
    private static String URL = "http://insigniathefest.com/manojit/Shivam/";
    private boolean flag = true;

    private Context context;

    public ExpandableContactAdapter(Context context, List<ParentObject> parentItemList) {
        super(context, parentItemList);
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public CategParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {

        View view = inflater.inflate(R.layout.contact_categ, viewGroup, false);
        return new CategParentViewHolder(view);
    }

    @Override
    public CategChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {

        View view;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            view = inflater.inflate(R.layout.contact_item, viewGroup, false);
        else
            view = inflater.inflate(R.layout.contact_itme2, viewGroup, false);

        return new CategChildViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(CategParentViewHolder categParentViewHolder, int i, Object o) {

        CategParent categParent = (CategParent) o;

        categParentViewHolder.support.setText(categParent.getTitle());
        categParentViewHolder.downArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: IMPLEMENT ME ...
            }
        });
    }

    private boolean isOnline() {

        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = manager.getActiveNetworkInfo();

        return netInfo != null && netInfo.isConnectedOrConnecting();

    }

    private void callPerson(String phno) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("tel:" + phno));
        context.startActivity(intent);
    }

    @Override
    public void onBindChildViewHolder(CategChildViewHolder categChildViewHolder, int i, Object o) {
        final CategChild categChild = (CategChild) o;

//        final ContactsData contactUs = contactList.get(i);
        categChildViewHolder.contactName.setText(categChild.getPersonName());
        categChildViewHolder.supportLevel.setText(categChild.getPersonSupportLevel());
        Log.e("Manojit","Hello"+ categChild.getPersonSupportLevel());
        categChildViewHolder.contactName1.setText(categChild.getPersonName());
        categChildViewHolder.supportLevel1.setText(categChild.getPersonSupportLevel());

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callPerson(categChild.getPersonContactNo());
            }
        };

        if(i % 2 == 0) {
            categChildViewHolder.up.setOnClickListener(listener);

        } else {
            categChildViewHolder.down.setOnClickListener(listener);
        }

        if (i % 2 == 0) {
            categChildViewHolder.down.setVisibility(View.GONE);
            categChildViewHolder.up.setVisibility(View.VISIBLE);

            if (isOnline()) {

                Picasso.with(context)
                        .load(URL + categChild.getPersonImage() + ".jpg")
                        .into(categChildViewHolder.person);
            }
        } else {
            categChildViewHolder.up.setVisibility(View.GONE);
            categChildViewHolder.down.setVisibility(View.VISIBLE);

            if (isOnline()) {
                Picasso.with(context)
                        .load(URL + categChild.getPersonImage() + ".jpg")
                        .into(categChildViewHolder.person1);
            }
            else if (flag) {
                Toast.makeText(context, "Failed to load the images!", Toast.LENGTH_SHORT).show();
                flag = false;
            }
        }
    }
}
