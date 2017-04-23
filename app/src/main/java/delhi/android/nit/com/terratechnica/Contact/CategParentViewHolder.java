package delhi.android.nit.com.terratechnica.Contact;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;

import delhi.android.nit.com.terratechnica.R;

/**
 * Created by directioner on 10/4/17.
 */

public class CategParentViewHolder extends ParentViewHolder {

    public TextView support;
    public ImageButton downArrow;

    public CategParentViewHolder(View itemView) {
        super(itemView);
        support = (TextView) itemView.findViewById(R.id.support_categ);
        downArrow = (ImageButton) itemView.findViewById(R.id.down_arrow);
    }
}
