package com.roll.clientserverhttp_viewpager.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.roll.clientserverhttp_viewpager.ViewPageFrag;
import com.roll.clientserverhttp_viewpager.entities.Contacts;

/**
 * Created by RDL on 05/03/2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    private ViewPageFrag currentPage = null;
    private Contacts contacts;

    public PagerAdapter(FragmentManager fm, Contacts contacts) {
        super(fm);
        this.contacts = contacts;
    }

    @Override
    public Fragment getItem(int position) {
        return ViewPageFrag.newInstance(contacts.getContacts().get(position));
    }

    @Override
    public int getCount() {
        return contacts.getContacts().size();
    }
}
