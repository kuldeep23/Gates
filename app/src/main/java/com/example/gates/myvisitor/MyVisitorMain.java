package com.example.gates.myvisitor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.gates.R;
import com.example.gates.myvisitor.adapter.MyVisitorPageAdapter;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MyVisitorMain extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem tabItem1, tabItem2, tabItem3;
    ViewPager viewPager;
    MyVisitorPageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tab_demo_app);

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabItem1 = (TabItem) findViewById(R.id.taball);
        tabItem2 = (TabItem) findViewById(R.id.tabexpected);
        tabItem3 = (TabItem) findViewById(R.id.tabcurrent);
        viewPager = (ViewPager) findViewById(R.id.vpager);

        pageAdapter = new MyVisitorPageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                if(tab.getPosition() ==0 || tab.getPosition() ==1 || tab.getPosition() ==2)
                    pageAdapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //Listener for scroll or page change

    }
}