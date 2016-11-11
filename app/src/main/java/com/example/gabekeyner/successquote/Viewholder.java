package com.example.gabekeyner.successquote;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by GabeKeyner on 11/9/2016.
 */

public class Viewholder extends RecyclerView.ViewHolder {

    private static final String TAG = RecyclerView.ViewHolder.class.getSimpleName();
    public TextView authorText, categoryText, bodyText;
    public CircleImageView authorImage;

    public TextView authorTextDetail, bodyTextDetail, categoryTextDetail;
    public CircleImageView authorDetailImage;

    public Context qcontext;
    public CardView qCardView;

    public Viewholder(View itemView) {
        super(itemView);
        authorImage = (CircleImageView) itemView.findViewById(R.id.author_picture);
        authorText = (TextView) itemView.findViewById(R.id.textAuthor);
        categoryText = (TextView) itemView.findViewById(R.id.textCategory);
        bodyText = (TextView) itemView.findViewById(R.id.detail_quote);

        authorDetailImage = (CircleImageView) itemView.findViewById(R.id.author_head_pic);
        authorTextDetail = (TextView) itemView.findViewById(R.id.author_head_name);
        bodyTextDetail = (TextView) itemView.findViewById(R.id.detail_quote2);
        categoryTextDetail = (TextView) itemView.findViewById(R.id.detail_category);

        qcontext = itemView.getContext();
        qCardView = (CardView) itemView.findViewById(R.id.cardView);
    }
}
