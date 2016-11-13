package com.example.gabekeyner.successquote;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by GabeKeyner on 11/2/2016.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    //
//    private DatabaseReference mFirebaseDatabaseReference;
//    private FirebaseRecyclerAdapter<QuoteHelper, Viewholder>
//            mFirebaseAdapter;
    private ArrayList<QuoteHelper> quotes;
    private Context context;
    CardView cardView;
    int prevPos = 0;

    public Adapter(Context context, ArrayList<QuoteHelper> quotes) {
        this.quotes = quotes;
        this.context = context;
    }

//    protected void populateViewHolder(final Viewholder viewHolder, final QuoteHelper quote, int position) {
//        viewHolder.authorText.setText(quote.getAuthor());
//        viewHolder.categoryText.setText(quote.getQuote_category());
//        viewHolder.bodyText.setText(quote.getQuote_body());
//        PicassoClient.downloadImage(context, quote.getAuthor_picture(), viewHolder.authorImage);
////        Picasso.with(context)
////                .load(quotes.get(position).getAuthor_picture())
////                .into(holder.authorImage);
//
//
//        if (position > prevPos) {
//            //Animation for the position Descending
//            AnimationUtil.animate(viewHolder, true);
//
//        } else {
//            //Animation for the position Ascending
//            AnimationUtil.animate(viewHolder, false);
//        }
//        prevPos = position;
//
//        int lastPosition = -1;
//
//        //Animation to Items in Card View
//        AnimationUtil.setScaleAnimationImage(viewHolder.authorImage);
//        AnimationUtil.setFadeAnimation(viewHolder.categoryText);
//        AnimationUtil.setFadeAnimation(viewHolder.authorText);
//        AnimationUtil.setAnimation(viewHolder.authorImage, lastPosition);
//
//
//        AnimationUtil.setScaleAnimationItem(viewHolder.itemView);
//
//
//        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openDetailActivity(quote.getAuthor(), quote.getAuthor_picture(), quote.getQuote_category(), quote.getQuote_body());
//                Toast.makeText(context, "More on " + quote.getAuthor(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//
//    }
//
//    private void openDetailActivity(String author, String author_picture, String quote_category, String quote_body) {
//        Intent intent = new Intent(context, AuthorDetailActivity.class);
//        intent.putExtra("author", author);
//        intent.putExtra("author_picture", author_picture);
//        intent.putExtra("quote_category", quote_category);
//        intent.putExtra("quote_body", quote_body);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(intent);
//    }


    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final Adapter.ViewHolder holder, final int position) {
        final QuoteHelper quote = quotes.get(position);
        holder.authorText.setText(quote.getAuthor());
       // holder.bodyText.setText(quote.getQuote_body());
        holder.categoryText.setText(quote.getQuote_category());

        PicassoClient.downloadImage(context, quote.getAuthor_picture(), holder.authorImage);
        Picasso.with(context)
                .load(quotes.get(position).getAuthor_picture())
                .into(holder.authorImage);


        if (position > prevPos) {
            //Animation for the position Descending
            AnimationUtil.animate(holder, true);

        } else {
            //Animation for the position Ascending
            AnimationUtil.animate(holder, false);
        }
        prevPos = position;

        int lastPosition = -1;

        //Animation to Items in Card View
        AnimationUtil.setScaleAnimationImage(holder.authorImage);
        AnimationUtil.setFadeAnimation(holder.categoryText);
        AnimationUtil.setFadeAnimation(holder.authorText);
        AnimationUtil.setAnimation(holder.authorImage, lastPosition);


        AnimationUtil.setScaleAnimationItem(holder.itemView);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetailActivity(quote.getAuthor(), quote.getAuthor_picture(), quote.getQuote_category(), quote.getQuote_body());
                Toast.makeText(context, "More on " + quote.getAuthor(), Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView authorText, categoryText, bodyText;
        public CircleImageView authorImage;

        public TextView authorTextDetail, bodyTextDetail, categoryTextDetail;
        public CircleImageView authorDetailImage;

        public ViewHolder(View itemView) {
            super(itemView);
            authorImage = (CircleImageView) itemView.findViewById(R.id.author_picture);
            authorText = (TextView) itemView.findViewById(R.id.textAuthor);
            categoryText = (TextView) itemView.findViewById(R.id.textCategory);
            bodyText = (TextView) itemView.findViewById(R.id.detail_quote);

            authorDetailImage = (CircleImageView) itemView.findViewById(R.id.author_head_pic);
            authorTextDetail = (TextView) itemView.findViewById(R.id.author_head_name);
            bodyTextDetail = (TextView) itemView.findViewById(R.id.detail_quote2);
            categoryTextDetail = (TextView) itemView.findViewById(R.id.detail_category);


        }
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
