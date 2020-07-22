package mad.eapseameorecsam.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import mad.eapseameorecsam.R;
import mad.eapseameorecsam.adapters.ViewPagerAdapter;
import mad.eapseameorecsam.ui.fragments.AccountFragment;
import mad.eapseameorecsam.ui.fragments.CategoriesFragment;
import mad.eapseameorecsam.ui.fragments.HomeFragment;
import mad.eapseameorecsam.ui.fragments.SearchFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new ViewPagerAdapter(
                getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,
                new Fragment[]{
                        new HomeFragment(),
                        new CategoriesFragment(),
                        new SearchFragment(),
                        new AccountFragment()
                },
                new String[]{
                        "Home", "Categories", "Search", "Account"
                }
        ));

    }
}