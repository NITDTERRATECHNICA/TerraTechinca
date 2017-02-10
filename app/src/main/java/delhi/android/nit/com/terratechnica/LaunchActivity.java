package delhi.android.nit.com.terratechnica;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import layout.Contact_Us;
import layout.Events;

public class LaunchActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FrameLayout contentContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("TERRA TECHNICA");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        contentContainer = (FrameLayout) findViewById(R.id.contentContainer);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_about_us) {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    if(getSupportFragmentManager().findFragmentById(R.id.contentContainer)!=null) {
                        fragmentTransaction.remove(getSupportFragmentManager().findFragmentById(R.id.contentContainer));
                    }
                    fragmentTransaction.add(R.id.contentContainer,new About_Us());
                    fragmentTransaction.commit();
                }
                else if (tabId == R.id.tab_contact)
                {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    if(getSupportFragmentManager().findFragmentById(R.id.contentContainer)!=null) {
                        fragmentTransaction.remove(getSupportFragmentManager().findFragmentById(R.id.contentContainer));
                    }
                    fragmentTransaction.add(R.id.contentContainer,new Contact_Us());
                    fragmentTransaction.commit();

                }
                else if (tabId == R.id.tab_events)
                {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    if(getSupportFragmentManager().findFragmentById(R.id.contentContainer)!=null) {
                        fragmentTransaction.remove(getSupportFragmentManager().findFragmentById(R.id.contentContainer));
                    }
                    fragmentTransaction.add(R.id.contentContainer,new Events());
                    fragmentTransaction.commit();
                }
                else if (tabId == R.id.tab_instagram)
                {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    if(getSupportFragmentManager().findFragmentById(R.id.contentContainer)!=null) {
                        fragmentTransaction.remove(getSupportFragmentManager().findFragmentById(R.id.contentContainer));
                    }
                    fragmentTransaction.add(R.id.contentContainer,new insta());
                    fragmentTransaction.commit();
                }else if (tabId == R.id.tab_location)
                {

                }

            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.launch, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.location) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
