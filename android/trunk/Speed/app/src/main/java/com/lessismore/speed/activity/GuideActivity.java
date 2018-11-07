package com.lessismore.speed.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.lessismore.speed.R;
import com.lessismore.speed.util.SharedPreferencesUtils;

import java.util.ArrayList;


public class GuideActivity extends BaseActivity {
    private ViewPager viewPager;
    private ArrayList<ImageView> imageViews;
    //当前下那是的下标
    private int curPosition = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initViewPager();
        setListeners();
    }

    private void setListeners() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                curPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            float startX;
            float endX;
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        startX=event.getX();
                        break;
                    case MotionEvent.ACTION_UP:
                        endX=event.getX();
                        WindowManager windowManager= (WindowManager)getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
                        //获取屏幕的宽度
                        Point size = new Point();
                        windowManager.getDefaultDisplay().getSize(size);
                        int width=size.x;
                        //判断最后一页，如果还是左滑就跳转新页面
                        if (curPosition == imageViews.size()-1 &&startX-endX>=(width/4)){
                            Intent intent = new Intent(GuideActivity.this, MainActivity.class);
                            startActivity(intent);
                            GuideActivity.this.finish();
                            SharedPreferencesUtils.put(GuideActivity.this,"isFirstOpen",false);
                        }
                }
                return false;
            }
        });
    }

    private void initViewPager() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        imageViews = new ArrayList<>();
        int [] imgs = {R.drawable.guide1,R.drawable.guide2,R.drawable.guide3};
        for (int i = 0;i<imgs.length;i++){
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new ViewPager.LayoutParams());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(imgs[i]);
            imageViews.add(imageView);
        }
        viewPager.setAdapter(new ViewPagerAdaper());
    }


    private class ViewPagerAdaper extends PagerAdapter{

        @Override
        public int getCount() {
            return imageViews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        /**
         * 从ViewGroup中移除当前对象（图片）
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(imageViews.get(position));
        }

        /**
         * 当前要显示的对象（图片）
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(imageViews.get(position));
            return imageViews.get(position);
        }
    }

}
