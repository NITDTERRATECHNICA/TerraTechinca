package delhi.android.nit.com.terratechnica.Contact;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;

import delhi.android.nit.com.terratechnica.R;

/**
 * Created by directioner on 10/4/17.
 */

public class CategChildViewHolder extends ChildViewHolder {

    public RelativeLayout up, down;
    public TextView contactName, supportLevel, contactName1, supportLevel1;
    public ImageView person, person1;

    public CategChildViewHolder(View itemView) {
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
