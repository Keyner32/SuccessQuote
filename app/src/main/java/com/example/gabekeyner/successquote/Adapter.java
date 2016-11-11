package com.example.gabekeyner.successquote;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;

/**
 * Created by GabeKeyner on 11/2/2016.
 */

public class Adapter extends FirebaseRecyclerAdapter<QuoteHelper, Viewholder> {

//
//    private DatabaseReference mFirebaseDatabaseReference;
//    private FirebaseRecyclerAdapter<QuoteHelper, Viewholder>
//            mFirebaseAdapter;
    private Context context;
    int prevPos = 0;


    public Adapter(Class<QuoteHelper> itemClass, int itemLayout, Class<Viewholder> viewHolderClass, Query ref, Context context) {
        super(itemClass, itemLayout, viewHolderClass, ref);
        this.context = context;
    }

    @Override
    protected void populateViewHolder(final Viewholder viewHolder, final QuoteHelper quote, int position) {
        viewHolder.authorText.setText(quote.getAuthor());
        viewHolder.categoryText.setText(quote.getQuote_category());
        viewHolder.bodyText.setText(quote.getQuote_body());
        PicassoClient.downloadImage(context, quote.getAuthor_picture(), viewHolder.authorImage);
//        Picasso.with(context)
//                .load(quotes.get(position).getAuthor_picture())
//                .into(holder.authorImage);


        if (position > prevPos) {
            //Animation for the position Descending
            AnimationUtil.animate(viewHolder, true);

        } else {
            //Animation for the position Ascending
            AnimationUtil.animate(viewHolder, false);
        }
        prevPos = position;

        int lastPosition = -1;

        //Animation to Items in Card View
        AnimationUtil.setScaleAnimationImage(viewHolder.authorImage);
        AnimationUtil.setFadeAnimation(viewHolder.categoryText);
        AnimationUtil.setFadeAnimation(viewHolder.authorText);
        AnimationUtil.setAnimation(viewHolder.authorImage, lastPosition);


        AnimationUtil.setScaleAnimationItem(viewHolder.itemView);


        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetailActivity(quote.getAuthor(), quote.getAuthor_picture(), quote.getQuote_category(), quote.getQuote_body());
                Toast.makeText(context, "More on " + quote.getAuthor(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void openDetailActivity(String author, String author_picture, String quote_category, String quote_body) {
        Intent intent = new Intent(context, AuthorDetailActivity.class);
        intent.putExtra("author", author);
        intent.putExtra("author_picture", author_picture);
        intent.putExtra("quote_category", quote_category);
        intent.putExtra("quote_body", quote_body);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }


}
