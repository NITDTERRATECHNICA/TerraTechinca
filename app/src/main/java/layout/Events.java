package layout;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import delhi.android.nit.com.terratechnica.Event_Main;
import delhi.android.nit.com.terratechnica.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Events extends Fragment {

    ViewPager viewPager;
    TabLayout tabLayout;
    public Events() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_events, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        viewPager.setAdapter(new MyCustomTabAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

    private class MyCustomTabAdapter extends FragmentPagerAdapter {

        public MyCustomTabAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            if (position == 0)
            {
                fragment = Event_Main.newInstance(1);
            }
            if (position == 1)
            {
                fragment = new InformalEvent();
            }
            if (position == 2)
            {

            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String title = new String();
            if (position == 0) {
                title = "Formal Events";
            }
            if (position == 1) {
                title = "Informal Events";
            }
            if (position == 2) {
                title = "Artist";
            }
            return title;
        }
    }
}
