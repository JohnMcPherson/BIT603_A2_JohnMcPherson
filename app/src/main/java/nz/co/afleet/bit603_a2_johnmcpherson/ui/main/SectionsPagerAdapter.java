package nz.co.afleet.bit603_a2_johnmcpherson.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import nz.co.afleet.bit603_a2_johnmcpherson.InventoryFragment;
import nz.co.afleet.bit603_a2_johnmcpherson.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_logout, R.string.tab_text_inventory};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).

        // John...
        // I replaced the boiler plate code to return the fragment created by us
        switch (position) {
            case 0: return new LogoutFragment();
            // break not required because we have used return
            case 1: return new InventoryFragment();

            default: return null; // shouldn't happen
         }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show the number of pages we expect
        return 2;
    }
}