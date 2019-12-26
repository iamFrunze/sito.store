package com.byfrunze.sitostore.Activities;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.byfrunze.sitostore.R;
import com.rd.PageIndicatorView;
import com.rd.animation.type.AnimationType;

public class StartActivity extends FragmentActivity {
    private static final String MY_SETTINGS = "my_settings";
    private ViewPager viewPager;
    private SliderAdapter sliderAdapter;
    private PageIndicatorView pageIndicatorView;
    private TextView textViewBack;
    private TextView textViewNext;
    private int countPage;
    private int currentPage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        saveActivityPreferences();
        textViewBack = findViewById(R.id.btnBackIntro);
        textViewNext = findViewById(R.id.btnNextIntro);
        textViewBack.setVisibility(View.INVISIBLE);
        textViewBack.setEnabled(false);

        viewPager = findViewById(R.id.viewPager);
        sliderAdapter = new SliderAdapter(this);
        sliderAdapter.setHeadArr(getResources().getStringArray(R.array.intro_slider_heading));
        sliderAdapter.setDescriptionArr(getResources().getStringArray(R.array.intro_slider_description));
        viewPager.setAdapter(sliderAdapter);
        viewPager.addOnPageChangeListener(viewListener);

        countPage = sliderAdapter.getCount();
        //Indicator
        pageIndicatorView = findViewById(R.id.pageIndicator);
        pageIndicatorView.setCount(countPage);
        pageIndicatorView.setAnimationType(AnimationType.DROP);


    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            currentPage = position;
            pageIndicatorView.setSelection(position);

            if (position == 0) {
                textViewBack.setVisibility(View.INVISIBLE);
                textViewBack.setEnabled(false);
                textViewNext.setVisibility(View.VISIBLE);
                textViewNext.setEnabled(true);

            } else if (position == (countPage - 1)) {
                textViewBack.setVisibility(View.VISIBLE);
                textViewBack.setEnabled(true);
                textViewNext.setVisibility(View.INVISIBLE);
                textViewNext.setEnabled(false);


            } else {
                textViewBack.setVisibility(View.VISIBLE);
                textViewBack.setEnabled(true);
                textViewNext.setVisibility(View.VISIBLE);
                textViewNext.setEnabled(true);

            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


    public void OnClickBackIntro(View view) {
        viewPager.setCurrentItem(currentPage - 1, true);
    }

    public void OnClickNextIntro(View view) {
        viewPager.setCurrentItem(currentPage + 1, true);

    }

    public void OnClickSkipIntro(View view) {
        Intent intent = new Intent(StartActivity.this, MainActivity.class);
        startActivity(intent);
    }

    protected void saveActivityPreferences() {
        SharedPreferences activityPreferences = getSharedPreferences(MY_SETTINGS, Activity.MODE_PRIVATE);
        boolean hasVisited = activityPreferences.getBoolean("hasVisited", false);
        if(!hasVisited){
            SharedPreferences.Editor editor = activityPreferences.edit();
            editor.putBoolean("hasVisited", true);
            editor.apply();
        }else{
            Intent intent = new Intent(StartActivity.this, MainActivity.class);
            startActivity(intent);
        }


    }
}
