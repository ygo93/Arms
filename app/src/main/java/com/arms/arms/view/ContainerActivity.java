package com.arms.arms.view;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.arms.arms.R;
import com.arms.arms.view.fragment.HomeFragment;
import com.arms.arms.view.fragment.ProfileFragment;
import com.arms.arms.view.fragment.SearchFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        BottomBar bottombar=(BottomBar) findViewById(R.id.bottombar);
        bottombar.setDefaultTab(R.id.home);
        bottombar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(int tabId) {
                switch (tabId)
                {
                    case R.id.home:
                        HomeFragment homeFragment= new HomeFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, homeFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit()
                        ;
                        break;

                    case R.id.profile:
                        ProfileFragment profileFragment= new ProfileFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, profileFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit()
                        ;
                        break;

                    case R.id.search:
                        SearchFragment searchFragment= new SearchFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, searchFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(null).commit()
                        ;
                    break;
                }
            }
        });

    }
}
