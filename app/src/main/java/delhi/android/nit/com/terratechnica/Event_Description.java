package delhi.android.nit.com.terratechnica;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Event_Description extends AppCompatActivity {

    ImageView image;
    TextView despTitle,despTitleHint,despDesp,despContact;
    boolean flag = false;
    //String email ,lname,fname,college,phone;
    int data,mParam1;
    String eventName;
    //String IMAGE_LINK = "http://saptrangnitd.com/beta1/ap/images/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            Transition transition =  TransitionInflater.from(this).inflateTransition(R.transition.transition);
            getWindow().setSharedElementEnterTransition(transition);
            /*Slide slide = new Slide(Gravity.RIGHT);
            slide.setStartDelay(300);
            slide.setDuration(300);*/

            Slide fade1 = new Slide(Gravity.LEFT);
            fade1.excludeTarget(android.R.id.navigationBarBackground,true);
            fade1.excludeTarget(android.R.id.statusBarBackground,true);
            //fade1.excludeTarget(R.id.appbar,true);
            fade1.setStartDelay(300);
            fade1.setDuration(300);
            getWindow().setEnterTransition(fade1);

            Fade fade = new Fade();
            fade.setDuration(100);
            fade.excludeTarget(android.R.id.navigationBarBackground,true);
            fade.excludeTarget(android.R.id.statusBarBackground,true);
            getWindow().setReturnTransition(fade);
            //getWindow().setReenterTransition(null);
            //getWindow().setExitTransition(null);

        }

        setContentView(R.layout.activity_event__description);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        data = getIntent().getIntExtra("data",0);
        mParam1 = getIntent().getIntExtra("mParam1",1);
        eventName = getIntent().getStringExtra("eventName");

        if(mParam1  == 1) {
            //despTitle = (TextView) findViewById(R.id.despTitle);
            //despTitleHint = (TextView) findViewById(R.id.despTitleHint);
            //despDesp = (TextView) findViewById(R.id.despDesp);
            //despContact = (TextView) findViewById(R.id.despContact);

           // despTitle.setText(Data.title[data]);
            //despTitleHint.setText("(" + Data.titleDescription[data] + ")");
            //despDesp.setText(Data.description[data]);
            //despContact.setText(Data.contacts[data]);

            image = (ImageView) findViewById(R.id.image);

            Picasso.with(this)
                    .load(R.drawable.asdfgh)

                    .error(R.drawable.asd)
                    .into(image);
        }
        else{
            image = (ImageView) findViewById(R.id.image);

            Picasso.with(this)
                    .load(R.drawable.asdfgh)
                    .error(R.drawable.asd)
                    .into(image);
        }


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String url = "http://google.com";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                    }
                }
        );
    }

}
