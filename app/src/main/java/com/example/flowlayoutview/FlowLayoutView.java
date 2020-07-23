package com.example.flowlayoutview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * create by libo
 * create on 2020/7/23
 * description 流布局viewGroup
 */
public class FlowLayoutView extends ViewGroup {

    public FlowLayoutView(Context context) {
        super(context);
    }

    public FlowLayoutView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        //子view设置宽高为父view大小减去padding值
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int contentWidth = width - getPaddingLeft() - getPaddingRight();  //内部宽度
        int contentHeight = height - getPaddingTop() - getPaddingBottom();  //内部高度

        //设置每个子view宽高
        for (int i = 0; i < getChildCount(); i++) {
            View childView = getChildAt(i);

            //给子view设置AT_MOST模式，即布局属性为wrapcontent
            int childWidthSpec = MeasureSpec.makeMeasureSpec(contentWidth, widthMode == MeasureSpec.EXACTLY ? MeasureSpec.AT_MOST : widthMode);
            int childHeightSpec = MeasureSpec.makeMeasureSpec(contentHeight, heightMode == MeasureSpec.EXACTLY ? MeasureSpec.AT_MOST : heightMode);
            childView.measure(childWidthSpec, childHeightSpec);
        }

        //最后根据子view的宽高设置自己宽高
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int padding = 30;//当前序号子view的左边距
        for (int i = 0; i < getChildCount(); i++) {
            View childView = getChildAt(i);
            childView.layout(l, t, r, b);

            l = l + childView.getMeasuredWidth() + padding;  //每个起始位置修改
        }
    }

}
