package com.example.gabekeyner.successquote.JavaClasses;

import android.content.Context;

import com.example.gabekeyner.successquote.R;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by GabeKeyner on 11/4/2016.
 */

public class PicassoClient {
    //PicassoClient is used to Download Images from Google
    public static void downloadImage(Context context, String author_picture, CircleImageView authorImage) {

        if (author_picture != null && author_picture.length() > 0) {
            Picasso.with(context)
                    .load(author_picture)
                    .placeholder(R.drawable.blank_profile)
                    .into(authorImage);

        } else {
            Picasso.with(context)
                    .load(R.drawable.blank_profile)
                    .into(authorImage);
        }
    }
}
