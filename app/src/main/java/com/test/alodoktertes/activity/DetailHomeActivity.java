package com.test.alodoktertes.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.alodoktertes.R;
import com.test.alodoktertes.view.PriviewIndicator;

import java.util.ArrayList;
import java.util.List;

public class DetailHomeActivity extends AppCompatActivity {
    private int[] bear = new int[]{R.mipmap.bear1, R.mipmap.bear2, R.mipmap.bear3};
    private int[] bird = new int[]{R.mipmap.bird1, R.mipmap.bird2, R.mipmap.bird3};
    private int[] cat = new int[]{R.mipmap.cat1, R.mipmap.cat2, R.mipmap.cat3};
    private int[] dog = new int[]{R.mipmap.dog1, R.mipmap.dog2, R.mipmap.dog3};
    private List<View> mViewList = new ArrayList<>();
    private ViewPager vpImage;
    private PriviewIndicator mIndicator;
    private CustomPagerAdapter mAdapter;
    private int mCurrentPage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_home);

        vpImage = (ViewPager) findViewById(R.id.vp_image);
        mIndicator = (PriviewIndicator) findViewById(R.id.indicator);

        String type = getIntent().getStringExtra("type");

        if (type.equals("cat")){
            for (int i = 0; i < cat.length; i++) {
                View view = LayoutInflater.from(this).inflate(R.layout.img_priview_item, null, false);
                ((ImageView) view.findViewById(R.id.iv_intro_image)).setImageResource(cat[i]);
                mViewList.add(view);
            }
        }else if (type.equals("dog")){
            for (int i = 0; i < dog.length; i++) {
                View view = LayoutInflater.from(this).inflate(R.layout.img_priview_item, null, false);
                ((ImageView) view.findViewById(R.id.iv_intro_image)).setImageResource(dog[i]);
                mViewList.add(view);
            }
        }else if (type.equals("bird")){
            for (int i = 0; i < bird.length; i++) {
                View view = LayoutInflater.from(this).inflate(R.layout.img_priview_item, null, false);
                ((ImageView) view.findViewById(R.id.iv_intro_image)).setImageResource(bird[i]);
                mViewList.add(view);
            }
        }else if (type.equals("bear")){
            for (int i = 0; i < bear.length; i++) {
                View view = LayoutInflater.from(this).inflate(R.layout.img_priview_item, null, false);
                ((ImageView) view.findViewById(R.id.iv_intro_image)).setImageResource(bear[i]);
                mViewList.add(view);
            }
        }

        mAdapter = new CustomPagerAdapter(mViewList);
        vpImage.setAdapter(mAdapter);

        vpImage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mCurrentPage = position;
                mIndicator.setSelected(mCurrentPage);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public static class CustomPagerAdapter extends PagerAdapter {

        private List<View> mViewList;

        public CustomPagerAdapter(List<View> viewList) {
            mViewList = viewList;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mViewList.get(position));
            return mViewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViewList.get(position));
        }

        @Override
        public int getCount() {
            return mViewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }
}