package com.beautiful.soundss.poetryeditor.StrickerImageView;


import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.beautiful.soundss.poetryeditor.Model.AutoResizeTextView;


/**
 * Created by cheungchingai on 6/15/15.
 */
public class StickerTextView extends StickerView{
    private AutoResizeTextView tv_main;
    public StickerTextView(Context context) {
        super(context);
    }

    public StickerTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StickerTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public View getMainView() {
        if(tv_main != null)
            return tv_main;

        tv_main = new AutoResizeTextView(getContext());
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(),"fonts/Jameel Noori Nastaleeq Kasheeda.ttf");
        tv_main.setTypeface(typeface);
        //tv_main.setTextSize(22);
        tv_main.setTextColor(Color.WHITE);
        tv_main.setGravity(Gravity.CENTER);
        tv_main.setTextSize(900);
        tv_main.setShadowLayer(4, 0, 0, Color.BLACK);
        tv_main.setMaxLines(4);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        params.gravity = Gravity.CENTER;
        tv_main.setLayoutParams(params);
        if(getImageViewFlip()!=null)
            getImageViewFlip().setVisibility(View.GONE);
        return tv_main;
    }

    public void setText(String text){
        if(tv_main!=null)
            tv_main.setText(text);
    }

    public void setTextCclor(int colour){
        if(tv_main!=null)
            tv_main.setTextColor(colour);
        if (tv_main != null) {
            tv_main.setShadowLayer(30, 0, 0, colour);
        }
    }

    public String getText(){
        if(tv_main!=null)
            return tv_main.getText().toString();

        return null;
    }

    public static float pixelsToSp(Context context, float px) {
        float scaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
        return px/scaledDensity;
    }

    @Override
    protected void onScaling(boolean scaleUp) {
        super.onScaling(scaleUp);
    }
}
