package com.byfrunze.sitostore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.ViewFlipper;

import com.rd.PageIndicatorView;
import com.rd.animation.type.AnimationType;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private PageIndicatorView pageIndicatorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);

        LayoutInflater inflater = LayoutInflater.from(this);
        int[] myPages = {R.layout.start_view_flipper_one, R.layout.start_view_flipper_two,
                R.layout.start_view_flipper_three, R.layout.start_view_flipper_four};

        List<View> pages = new ArrayList<>();
        for (int page : myPages) pages.add(inflater.inflate(page, null));

        pageIndicatorView = findViewById(R.id.pageIndicator);
        pageIndicatorView.setCount(pages.size());
        pageIndicatorView.setAnimationType(AnimationType.THIN_WORM);

        StartPagerAdapter pagerAdapter = new StartPagerAdapter(pages);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(new OnPageChangeListener(){
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pageIndicatorView.setSelection(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

}
