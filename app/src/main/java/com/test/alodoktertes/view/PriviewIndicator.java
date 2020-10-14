package com.test.alodoktertes.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;

import com.test.alodoktertes.R;
import com.test.alodoktertes.utils.DisplayUtil;

import java.util.ArrayList;
import java.util.List;

public class PriviewIndicator extends LinearLayout {

    private final int INDICATOR_COUNT = 3;
    private List<ImageView> mImageList = new ArrayList<>();

    public PriviewIndicator(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PriviewIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        for (int i = 0; i < INDICATOR_COUNT; i++) {
            ImageView imageView = new ImageView(getContext());
            if (i == 0) {
                imageView.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.bg_circle_selected));
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.bg_circle_unselected));
            }
            LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(DisplayUtil.dp2px(getContext(), 5), 0, DisplayUtil.dp2px(getContext(), 5), 0);
            addView(imageView, params);
            mImageList.add(imageView);
        }
    }

    public void setSelected(int position) {
        for (int i = 0; i < mImageList.size(); i++) {
            ImageView imageView = mImageList.get(i);
            if (i == position) {
                imageView.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.bg_circle_selected));
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.bg_circle_unselected));
            }
        }
    }

}
