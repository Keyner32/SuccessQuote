package com.example.gabekeyner.successquote;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by GabeKeyner on 11/2/2016.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<QuoteHelper> quotes;
    private Context context;
    CardView cardView;
    int prevPos = 0;

    public Adapter(Context context, ArrayList<QuoteHelper> quotes) {
        this.quotes = quotes;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final Adapter.ViewHolder holder, final int position) {
        final QuoteHelper quote = quotes.get(position);
        holder.authorText.setText(quote.getAuthor());
        holder.bodyText.setText(quote.getQuote_body());
        holder.categoryText.setText(quote.getQuote_category());

        cardView = (CardView) cardView.findViewById(R.id.cardView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetailActivity(quote.getAuthor(),quote.getQuote_body(),quote.getQuote_category());
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
    private void openDetailActivity (String author, String quote_body, String quote_category) {
        Intent intent = new Intent(context,DetailActivity.class);
        intent.putExtra("author",author);
        intent.putExtra("quote_body", quote_body);
        intent.putExtra("quote_catergory",quote_category);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView authorText, bodyText, categoryText;

        public ViewHolder(final View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            authorText = (TextView) itemView.findViewById(R.id.textAuthor) ;
            bodyText = (TextView)itemView.findViewById(R.id.textBody) ;
            categoryText = (TextView)itemView.findViewById(R.id.textCategory) ;
        }
    }
}
