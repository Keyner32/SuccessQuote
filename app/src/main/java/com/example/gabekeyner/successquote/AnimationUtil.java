package com.example.gabekeyner.successquote;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

import java.util.Random;

/**
 * Created by GabeKeyner on 11/5/2016.
 */

public class AnimationUtil {

    private final static int SCALE_DURATION = 1900;
    private final static int SCALE_DURATION_ITEM = 1500;
    private final static int FADE_DURATION = 2200;
    private final static int SCALE_DURATION_DIALOG = 2000;

    public static void animate(RecyclerView.ViewHolder holder, boolean goesDown) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator animatorTranslateY = ObjectAnimator.ofFloat(holder.itemView, "translationY", goesDown == true ? 800 : -800, 0);
        ObjectAnimator animatorTranslateX = ObjectAnimator.ofFloat(holder.itemView, "translationX", 1000, 0);
        animatorTranslateY.setDuration(800);
        animatorTranslateX.setDuration(500);
        animatorSet.playTogether(animatorTranslateY);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.start();
    }

    //Animation for Author Image
    public static void setScaleAnimationImage(View view) {
        ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setDuration(SCALE_DURATION);
        view.startAnimation(anim);
    }

    //Animation for Card Item
    public static void setScaleAnimationItem(View view) {
        ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 2.0f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setDuration(SCALE_DURATION_ITEM);
        view.startAnimation(anim);
    }

    //Animation for Buttons
    public static void setScaleAnimationButton(View view) {
        ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.ABSOLUTE, 2.0f, Animation.ABSOLUTE, 0.5f);
        anim.setDuration(SCALE_DURATION_ITEM);
        view.startAnimation(anim);
    }

    //Set Animation for the Position of the item
    public static void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        int lastPosition = -1;
        if (position > lastPosition) {
            ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            anim.setDuration(new Random().nextInt(501));//to make duration random number between [0,501)
            viewToAnimate.startAnimation(anim);
            lastPosition = position;
        }
    }

    //Fade Animation for Text
    public static void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }

    //Fade Animation for PostDialog
    public static void setScaleDialog(View view) {
        ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 2.0f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setDuration(SCALE_DURATION_DIALOG);
        view.startAnimation(anim);

    }

}
