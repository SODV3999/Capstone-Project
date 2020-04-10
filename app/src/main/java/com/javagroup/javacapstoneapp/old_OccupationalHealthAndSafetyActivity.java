package com.javagroup.javacapstoneapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class old_OccupationalHealthAndSafetyActivity extends
        AppCompatActivity implements View.OnClickListener {

    private static final int NUM_PAGES = 4;
    private ViewPager2 viewPager;
    private FragmentStateAdapter pagerAdapter;

    RelativeLayout relativeLayout;
    Button Viewmore1;
    int height;
    private ConstraintLayout browserContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.old_activity_ohs);

        TextView ohsActAndCodeLink = (TextView) findViewById(R.id.ohsActRegAndCodeLink);
        TextView safetyRightsLink = (TextView) findViewById(R.id.safetyRightsLink);
        relativeLayout=(RelativeLayout) findViewById(R.id.expandable1);

        Viewmore1 = (Button) findViewById(R.id.Worker_Right);
        Viewmore1.setOnClickListener(this);

        relativeLayout.getViewTreeObserver().addOnPreDrawListener(
                new ViewTreeObserver.OnPreDrawListener() {
                    @Override
                    public boolean onPreDraw() {
                        relativeLayout.getViewTreeObserver().removeOnPreDrawListener(this);
                        relativeLayout.setVisibility(View.GONE);
                        final int widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                        final int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                        relativeLayout.measure(widthSpec, heightSpec);
                        height = relativeLayout.getMeasuredHeight();
                        return true;
                    }
                });

        browserContainer = (ConstraintLayout)findViewById(R.id.browserContainer);
        ohsActAndCodeLink.setOnClickListener(this);
        safetyRightsLink.setOnClickListener(this);
        Intent intent = getIntent();

        // Instantiate a ViewPager2 and a PagerAdapter.
        viewPager = findViewById(R.id.view_pager);
        pagerAdapter = new ScreenSlidePagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);

//        // for swipe to left and right in OHS - twinkle
        ViewPager viewPager = findViewById(R.id.viewpagerOHS);
        viewPager.setAdapter(
                new ViewPagerAdapter(getSupportFragmentManager(),
                        4,
                        4));
    }
    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }
    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {
        public ScreenSlidePagerAdapter(FragmentActivity fa) {
            super(fa);
        }

        @Override
        public Fragment createFragment(int position) {
            return new ScreenSlidePageFragment();
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }

    private void expand(RelativeLayout layout, int layoutHeight) {
        layout.setVisibility(View.VISIBLE);
        ValueAnimator animator = slideAnimator(layout, 0, layoutHeight);
        animator.start();
    }

    private void collapse(final RelativeLayout layout) {
        int finalHeight = layout.getHeight();
        ValueAnimator mAnimator = slideAnimator(layout, finalHeight, 0);

        mAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationEnd(Animator animator) {
                //Height=0, but it set visibility to GONE
                layout.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationStart(Animator animator) {
            }

            @Override
            public void onAnimationCancel(Animator animator) {
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
            }
        });
        mAnimator.start();
    }

    private ValueAnimator slideAnimator(final RelativeLayout layout, int start, int end) {
        ValueAnimator animator = ValueAnimator.ofInt(start, end);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                //Update Height
                int value = (Integer) valueAnimator.getAnimatedValue();

                ViewGroup.LayoutParams layoutParams = layout.getLayoutParams();
                layoutParams.height = value;
                layout.setLayoutParams(layoutParams);
            }
        });
        return animator;
    }

    private void openingLink(String url){
        browserContainer.setTranslationY(3000);
        browserContainer.animate().translationYBy(-3000).setDuration(700);
        final FragmentTransaction openTheBrowser = getSupportFragmentManager().beginTransaction();
        final WebBrowserActivity webBrowserActivity = new WebBrowserActivity();
        Bundle link = new Bundle();
        link.putString("url", url);
        webBrowserActivity.setArguments(link);
        openTheBrowser.add(R.id.browserContainer, webBrowserActivity);
        openTheBrowser.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
                //LINKS BUTTONS
            case R.id.ohsActRegAndCodeLink:
                openingLink("https://www.alberta.ca/ohs-act-regulation-code.aspx");
                break;
            case R.id.safetyRightsLink:
                openingLink("https://workershealthcentre.ca/4-health-and-safety-rights/");
                break;
        }

        switch (v.getId()) {
            case R.id.Worker_Right:
                if (relativeLayout.getVisibility() == View.GONE) {
                    expand(relativeLayout, height);
                } else {
                    collapse(relativeLayout);
                }
                break;

//            case R.id.viewmore1:
//                if (relativeLayout1.getVisibility() == View.GONE) {
//                    expand(relativeLayout1, height1);
//                } else {
//                    collapse(relativeLayout1);
//                }
//                break;
//
//            case R.id.viewmore2:
//                if (relativeLayout2.getVisibility() == View.GONE) {
//                    expand(relativeLayout2, height2);
//                } else {
//                    collapse(relativeLayout2);
//                }
//                break;
        }
    }

    public void workerright(View view) {
    }

    public void workplacehazard(View view) {
    }

    public void casestudy(View view) {
    }
}
