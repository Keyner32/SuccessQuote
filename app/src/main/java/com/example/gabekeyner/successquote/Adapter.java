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

        PicassoClient.downloadImage(context, quote.getAuthor_picture(),holder.authorImage);
        Picasso.with(context)
                .load(quotes.get(position)
                .getAuthor_picture())
//                .resize(800, 500)
//                .centerCrop()
                .into(holder.authorImage);

        if (position > prevPos) {

            //put animation here
        } else {
            //put animation here
        }
        prevPos = position;
        int lastPosition = -1;
        //Animation to authorText
        //Animation to bodyText
        //Animation to categoryText


        //TODO INSTEAD OF THESE CLICK LISTENERS SET TO THE TEXTVIEWS THEY WILL BE SET ON THE POSITIONS ONCE THE ANIMATIONS ARE SET UP

        holder.authorText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetailActivity(quote.getAuthor(), quote.getAuthor_picture(), quote.getQuote_category());
                Toast.makeText(context, "More on " + quote.getAuthor(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.authorImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetailActivity(quote.getAuthor(), quote.getAuthor_picture(), quote.getQuote_category());
                Toast.makeText(context, "More on " + quote.getAuthor(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.categoryText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetailActivity(quote.getAuthor(), quote.getAuthor_picture(), quote.getQuote_category());
                Toast.makeText(context, "More on " + quote.getAuthor(), Toast.LENGTH_SHORT).show();
            }
        });

        //TODO use animations but change them slightly
//TODO FINISH PUTTING INFO ON BINDHOLDER in the one that goes on the card view
        //TODO ONLY SHOW [CERTAIN AMOUNT OF BODY] AND [CATERGORY] AND [AUTHOR]

    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }

    private void openDetailActivity(String author, String author_picture, String quote_category) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("author", author);
        intent.putExtra("author_picture",author_picture );
        intent.putExtra("quote_catergory", quote_category);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView authorText, categoryText;
        public CircleImageView authorImage;


        public ViewHolder(final View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            authorText = (TextView) itemView.findViewById(R.id.textAuthor);
            authorImage = (CircleImageView) itemView.findViewById(R.id.author_picture);
            categoryText = (TextView) itemView.findViewById(R.id.textCategory);
        }
    }
}
