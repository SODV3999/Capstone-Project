package com.javagroup.javacapstoneapp;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class subsection_WorkplaceSafety_OHS extends
        AppCompatActivity implements View.OnClickListener {

    private static final int NUM_PAGES = 4;
    public ViewPager viewPager,viewPagerHazard;
    public SwipeOHSCollectionAdapter adapter;
    public SwipeOHSWorkplaceHazardCollectionAdapter adapterHazard;
    RelativeLayout relativeLayoutexpandable1, relativeLayoutexpandable2;
    Button Viewmore1,Viewmore2;
    int heightexpandable1,heightexpandable2;
    private ConstraintLayout browserContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subsection_workplacesafety_ohs);

        TextView ohsActAndCodeLink = (TextView) findViewById(R.id.ohsActRegAndCodeLink);
        TextView safetyRightsLink = (TextView) findViewById(R.id.safetyRightsLink);

        // for Worker's rights butoon
        relativeLayoutexpandable1=(RelativeLayout) findViewById(R.id.expandable1);
        Viewmore1 = (Button) findViewById(R.id.Worker_Right);
        Viewmore1.setOnClickListener(this);

        relativeLayoutexpandable1.getViewTreeObserver().addOnPreDrawListener(
                new ViewTreeObserver.OnPreDrawListener() {
                    @Override
                    public boolean onPreDraw() {
                        relativeLayoutexpandable1.getViewTreeObserver().removeOnPreDrawListener(this);
                        relativeLayoutexpandable1.setVisibility(View.GONE);
                        final int widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                        final int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                        relativeLayoutexpandable1.measure(widthSpec, heightSpec);
                        heightexpandable1 = relativeLayoutexpandable1.getMeasuredHeight();
                        return true;
                    }
                });

        // for workplace hazard button
        relativeLayoutexpandable2=(RelativeLayout) findViewById(R.id.expandable2);
        Viewmore2 = (Button) findViewById(R.id.Workplace_Hazard);
        Viewmore2.setOnClickListener(this);

        relativeLayoutexpandable2.getViewTreeObserver().addOnPreDrawListener(
                new ViewTreeObserver.OnPreDrawListener() {
                    @Override
                    public boolean onPreDraw() {
                        relativeLayoutexpandable2.getViewTreeObserver().removeOnPreDrawListener(this);
                        relativeLayoutexpandable2.setVisibility(View.GONE);
                        final int widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                        final int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                        relativeLayoutexpandable2.measure(widthSpec, heightSpec);
                        heightexpandable2 = relativeLayoutexpandable2.getMeasuredHeight();
                        return true;
                    }
                });

        browserContainer = (ConstraintLayout)findViewById(R.id.browserContainer);
        ohsActAndCodeLink.setOnClickListener(this);
        safetyRightsLink.setOnClickListener(this);
        Intent intent = getIntent();


        // for swipe in OHS
        viewPager=findViewById(R.id.viewpagerOHS);
        adapter=new SwipeOHSCollectionAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        viewPagerHazard=findViewById(R.id.viewpagerOHSWorkplaceHazard);
        adapterHazard=new SwipeOHSWorkplaceHazardCollectionAdapter(getSupportFragmentManager());
        viewPagerHazard.setAdapter(adapterHazard);
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

        switch (v.getId()) {
                        case R.id.ohsActRegAndCodeLink:
                openingLink("https://www.alberta.ca/ohs-act-regulation-code.aspx");
                break;
            case R.id.safetyRightsLink:
                openingLink("https://workershealthcentre.ca/4-health-and-safety-rights/");
                break;

            case R.id.Worker_Right:
                if (relativeLayoutexpandable1.getVisibility() == View.GONE) {
                    expand(relativeLayoutexpandable1, heightexpandable1);
                } else {
                    collapse(relativeLayoutexpandable1);
                }
                break;

            case R.id.Workplace_Hazard:
                if (relativeLayoutexpandable2.getVisibility() == View.GONE) {
                    expand(relativeLayoutexpandable2, heightexpandable2);
                } else {
                    collapse(relativeLayoutexpandable2);
                }
                break;

//            case R.id.CaseStudy_Link:
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

    public void Albertaohsact(View view) {
        String url = "https://www.alberta.ca/ohs-act-regulation-code.aspx";
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }


    public void ohsrights(View view) {
        String url = "https://workershealthcentre.ca/4-health-and-safety-rights/";
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
