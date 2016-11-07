package com.example.gabekeyner.successquote;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.gabekeyner.successquote.R.id.author_picture;

/**
 * Created by GabeKeyner on 11/2/2016.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<QuoteHelper> quotes;
    private Context context;
    int prevPos = 0;

    public Adapter(Context context, ArrayList<QuoteHelper> quotes) {
        this.quotes = quotes;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final Adapter.ViewHolder holder, final int position) {
        final QuoteHelper quote = quotes.get(position);
        holder.authorText.setText(quote.getAuthor());
        holder.categoryText.setText(quote.getQuote_category());
//        holder.bodyText.setText(quote.getQuote_body());


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
        AnimationUtil.setScaleAnimation(holder.authorImage);
        AnimationUtil.setFadeAnimation(holder.categoryText);
        AnimationUtil.setFadeAnimation(holder.authorText);
        AnimationUtil.setAnimation(holder.authorImage, lastPosition);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetailActivity(quote.getAuthor(), quote.getAuthor_picture(), quote.getQuote_category(), quote.getQuote_body());
                Toast.makeText(context, "More on " + quote.getAuthor(), Toast.LENGTH_SHORT).show();
            }
        });


        //TODO use animations but change them slightly


    }

    @Override
    public int getItemCount() {
        return quotes.size();
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


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView authorText, categoryText, bodyText;
        public CircleImageView authorImage;


        public ViewHolder(final View itemView) {
            super(itemView);

            authorText = (TextView) itemView.findViewById(R.id.textAuthor);
            authorImage = (CircleImageView) itemView.findViewById(author_picture);
            categoryText = (TextView) itemView.findViewById(R.id.textCategory);
            bodyText = (TextView) itemView.findViewById(R.id.detail_quote);




            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }
    }

}
