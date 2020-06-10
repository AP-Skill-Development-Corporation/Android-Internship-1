package com.example.whatsup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;

    TabLayout tabLayout;

    private int[] tabIcons = {
            R.drawable.ic_chat_bubble_outline_black_24dp,
            R.drawable.ic_contact_phone_black_24dp,
            R.drawable.ic_star_black_24dp
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.pager);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        tabLayout=findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);

        setupTabIcons();
    }

    class MyAdapter extends FragmentStatePagerAdapter
    {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position)
            {
                case 0:return new Chats();
                case 1:return new Contacts();
                case 2:return new Status();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position)
        {
            switch (position)
            {
                case 0:return "Chats";
                case 1:return "Contacts";
                case 2:return "Status";

            }
            return super.getPageTitle(position);
        }
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }

}
