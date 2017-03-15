package delhi.android.nit.com.terratechnica;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Gravity;
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
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnTabSelectListener;
import com.squareup.picasso.Picasso;

import layout.Contact_Us;
import layout.Events;

public class LaunchActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,GoogleApiClient.OnConnectionFailedListener {

    private TextView info;
    private LoginButton loginButton;
    View header;
    private CallbackManager callbackManager;
    FrameLayout contentContainer;
    TextView navname,navEmail;
    ImageView navImage;
    GoogleApiClient mGoogleApiClient;
    int RC_SIGN_IN = 10298;
    boolean first = false;
    ImageView launchBG,navBG;
    int current;
    DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        if(sharedPreferences.contains("first"))
        {
            Log.e("Manojit","If    "+first);
            first = sharedPreferences.getBoolean("first",false);
        }
        else
        {
            Log.e("Manojit","Else     "+first);
            first = true;
        }
        if(first)
        {
            setContentView(R.layout.login_template);
            callbackManager = CallbackManager.Factory.create();
            //info = (TextView)findViewById(R.id.info);
            loginButton = (LoginButton) findViewById(R.id.login_button);

            //fb callback intercpt
            loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                @Override
                public void onSuccess(LoginResult loginResult) {
                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("first",false);
                    editor.commit();
                    startActivity(new Intent(LaunchActivity.this,LaunchActivity.class));
                    finish();
                }

                @Override
                public void onCancel() {
                    //info.setText("Login attempt canceled.");
                }

                @Override
                public void onError(FacebookException e) {
                    //info.setText("Login attempt failed.");
                }
            });
            GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestEmail()
                    .build();

            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                    .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                    .build();
        }
        else {


            setContentView(R.layout.activity_launch);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        toolbar.setTitle("TERRA TECHNICA");
            launchBG = (ImageView) findViewById(R.id.launchBG);
            Glide.with(this)
                    .load(R.drawable.bg2)
                    .centerCrop()
                    .crossFade()
                    .into(launchBG);

            drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
       /* ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();*/

            contentContainer = (FrameLayout) findViewById(R.id.contentContainer);

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);
            header = navigationView.inflateHeaderView(R.layout.nav_header_launch);
            navname = (TextView) header.findViewById(R.id.navName);
            navEmail = (TextView) header.findViewById(R.id.navEmail);
            navImage = (ImageView) header.findViewById(R.id.navImage);
            navBG = (ImageView) header.findViewById(R.id.navBG);
            Picasso.with(this)
                    .load(R.drawable.headers)
                    .into(navBG);
            //fb thing

            callbackManager = CallbackManager.Factory.create();
            //info = (TextView)findViewById(R.id.info);
            loginButton = (LoginButton) header.findViewById(R.id.login_button);

            //fb callback intercpt
            loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                @Override
                public void onSuccess(LoginResult loginResult) {

                }

                @Override
                public void onCancel() {
                    //info.setText("Login attempt canceled.");
                }

                @Override
                public void onError(FacebookException e) {
                    //info.setText("Login attempt failed.");
                }
            });


            //google login

            GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestEmail()
                    .build();

            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                    .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                    .build();

            SignInButton signInButton = (SignInButton) header.findViewById(R.id.sign_in_button);
            signInButton.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
                            startActivityForResult(signInIntent, RC_SIGN_IN);

                        }
                    }
            );


            final BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
            bottomBar.setDefaultTab(R.id.tab_about_us);
            //current = R.id.tab_about_us;
            //final BottomBarTab barTab = bottomBar.getCurrentTab();
            bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
                @Override
                public void onTabSelected(@IdRes int tabId) {
                    if (tabId == R.id.tab_about_us) {
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        if (getSupportFragmentManager().findFragmentById(R.id.contentContainer) != null) {
                            fragmentTransaction.remove(getSupportFragmentManager().findFragmentById(R.id.contentContainer));
                        }
                        fragmentTransaction.add(R.id.contentContainer, new About_Us());
                        fragmentTransaction.commit();
                        //current = bottomBar.getCurrentTabId();
                    } else if (tabId == R.id.tab_contact) {
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        if (getSupportFragmentManager().findFragmentById(R.id.contentContainer) != null) {
                            fragmentTransaction.remove(getSupportFragmentManager().findFragmentById(R.id.contentContainer));
                        }
                        fragmentTransaction.add(R.id.contentContainer, new Contact_Us());
                        fragmentTransaction.commit();
                        //current = bottomBar.getCurrentTabId();

                    } else if (tabId == R.id.tab_events) {
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        if (getSupportFragmentManager().findFragmentById(R.id.contentContainer) != null) {
                            fragmentTransaction.remove(getSupportFragmentManager().findFragmentById(R.id.contentContainer));
                        }
                        fragmentTransaction.add(R.id.contentContainer, new Events());
                        fragmentTransaction.commit();
                        //current = bottomBar.getCurrentTabId();
                    } else if (tabId == R.id.tab_instagram) {
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        if (getSupportFragmentManager().findFragmentById(R.id.contentContainer) != null) {
                            fragmentTransaction.remove(getSupportFragmentManager().findFragmentById(R.id.contentContainer));
                        }
                        fragmentTransaction.add(R.id.contentContainer, new insta());
                        fragmentTransaction.commit();
                        //current = bottomBar.getCurrentTabId();
                    }

                }
            });
        }

    }

    public void navigate(View v)
    {
        if(!drawer.isDrawerOpen(Gravity.LEFT))
            drawer.openDrawer(Gravity.LEFT);
        else
            drawer.closeDrawer(Gravity.LEFT);
    }

    public void login(View v){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("first",false);
        editor.commit();
        startActivity(new Intent(this,LaunchActivity.class));
        finish();
    }

    public void gmailSignin(View v){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("first",false);
        editor.commit();
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    public void skip(View v){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("first",false);
        editor.commit();
        startActivity(new Intent(this,LaunchActivity.class));
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    private void handleSignInResult(GoogleSignInResult result) {
        //Log.d(TAG, "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {
            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = result.getSignInAccount();
            navname.setText(acct.getDisplayName());
            navEmail.setText(acct.getEmail());
            Picasso.with(this)
                    .load(acct.getPhotoUrl())
                    .into(navImage);
            //updateUI(true);
        } else {
            // Signed out, show unauthenticated UI.
            //updateUI(false);
        }
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

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
