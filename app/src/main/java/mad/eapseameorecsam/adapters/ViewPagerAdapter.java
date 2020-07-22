package mad.eapseameorecsam.adapters;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    Fragment[] fragments;
    String[] pageTitles;

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior, Fragment[] fragments, String[] pageTitles) {
        super(fm, behavior);
        this.fragments = fragments;
        this.pageTitles = pageTitles;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitles[position];
    }
}
