package com.sparkdev.foodapp.mainscreen.productpage;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import com.sparkdev.foodapp.R;



public class ProductPageActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private LinearLayout linearLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);

//        ReviewFragment fragment = new ReviewFragment();
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.fragmentReviews, fragment);
//        fragmentTransaction.commit();



        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new OrderFragment(), "Order");
        adapter.AddFragment(new DescriptionFragment(), "Description");
        adapter.AddFragment(new ReviewFragment(), "Review");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);



    }
}