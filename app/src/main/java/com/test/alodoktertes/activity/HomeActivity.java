package com.test.alodoktertes.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.test.alodoktertes.R;
import com.test.alodoktertes.adapter.ViewPagerAdapter;
import com.test.alodoktertes.fragment.HomeFragment;
import com.test.alodoktertes.fragment.ProfileFragment;
import com.test.alodoktertes.view.LockableViewPager;

import java.lang.reflect.Field;

public class HomeActivity extends AppCompatActivity {
    private LockableViewPager viewPager;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.navigation);
        BottomNavigationViewHelper.removeShiftMode(bottomNavigationView);
        bottomNavigationView.setItemIconTintList(null);
        viewPager = findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setSwipeable(false);
        setupViewPager(viewPager);
        bottomNavClick();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frame_layout, HomeFragment.newInstance());
        transaction.commit();
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment(), "Home");
        adapter.addFragment(new ProfileFragment(), "Profile");
        viewPager.setAdapter(adapter);
    }

    static class BottomNavigationViewHelper {
        @SuppressLint("RestrictedApi")
        static void removeShiftMode(BottomNavigationView view) {
            BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);

            try {
                Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
                shiftingMode.setAccessible(true);
                shiftingMode.setBoolean(menuView, false);
                shiftingMode.setAccessible(false);
                for (int i = 0; i < menuView.getChildCount(); i++) {
                    BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
//                    item.setShiftingMode(false);
                    item.setShifting(false);
                    // set once again checked value, so view will be updated
                    item.setChecked(item.getItemData().isChecked());
                }
            } catch (NoSuchFieldException e) {
                Log.e("ERROR NO SUCH FIELD", "Unable to get shift mode field");
            } catch (IllegalAccessException e) {
                Log.e("ERROR ILLEGAL ALG", "Unable to change value of shift mode");
            }
        }
    }

    public void bottomNavClick(){
        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull final MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_item1:
                                viewPager.setCurrentItem(0);
                                resetIcon();
                                item.setIcon(R.mipmap.home_icon_selected);
                                item.setChecked(true);
                                break;
                            case R.id.action_item2:
                                viewPager.setCurrentItem(1);
                                resetIcon();
                                item.setIcon(R.mipmap.account_icon_selected);
                                item.setChecked(true);
                                break;
                        }

                        return false;
                    }
                });
    }

    public void resetIcon(){
        bottomNavigationView.getMenu().getItem(0).setIcon(R.mipmap.home_icon_unselected);
        bottomNavigationView.getMenu().getItem(1).setIcon(R.mipmap.account_icon_unselected);
    }
}