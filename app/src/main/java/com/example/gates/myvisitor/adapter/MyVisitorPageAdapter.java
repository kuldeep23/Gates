package com.example.gates.myvisitor.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.gates.myvisitor.AllVisitor;
import com.example.gates.myvisitor.CurrentVisitor;
import com.example.gates.myvisitor.ExpectedVisitor;
import com.example.gates.myvisitor.WrongVisitor;

public class MyVisitorPageAdapter extends FragmentPagerAdapter
{
    int tabcount;
    public MyVisitorPageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0 : return new CurrentVisitor();
            case 1 : return new ExpectedVisitor();
            case 2 : return new WrongVisitor();
            case 3 : return new AllVisitor();
            default: return null;
        }

    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
