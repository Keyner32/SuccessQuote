package com.example.gabekeyner.successquote;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gabekeyner.successquote.Activitys.AuthorDetailActivity;
import com.example.gabekeyner.successquote.JavaClasses.PicassoClient;
import com.example.gabekeyner.successquote.JavaClasses.QuoteHelper;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.gabekeyner.successquote.R.id.author_picture;
import static com.example.gabekeyner.successquote.R.id.quote_link;
import static com.example.gabekeyner.successquote.R.id.textAuthor;


/**
 * Created by GabeKeyner on 11/2/2016.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<QuoteHelper> quotes;
    private Context context;

    public Adapter(Context context, ArrayList<QuoteHelper> quotes) {
        this.quotes = quotes;
        this.context = context;
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final Adapter.ViewHolder holder, final int position) {
        final QuoteHelper quote = quotes.get(position);

        //Set thee Text for the Main Activity
        holder.authorText.setText(quote.getAuthor());
        holder.categoryText.setText(quote.getQuote_category());


        //Downloads Image from Internet through PicassoClient
        PicassoClient.downloadImage(context, quote.getAuthor_picture(), holder.authorImage);
        Picasso.with(context)
                .load(quotes.get(position).getAuthor_picture())
                .into(holder.authorImage);

        int lastPosition = -1;
        //Animation to Items in Card View
        AnimationUtil.setScaleAnimationImage(holder.authorImage);
        AnimationUtil.setFadeAnimation(holder.categoryText);
        AnimationUtil.setFadeAnimation(holder.authorText);
        AnimationUtil.setAnimation(holder.authorImage, lastPosition);
        AnimationUtil.setScaleAnimationItem(holder.itemView);


        //Opens Detail Activity when item is clicked
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetailActivity(
                        quote.getAuthor(),
                        quote.getAuthor_picture(),
                        quote.getQuote_category(),
                        quote.getQuote_body(),
                        quote.getQuote_link()
                );
                Toast.makeText(context, "More on " + quote.getAuthor(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        //Main Activity Views
        public TextView authorText, categoryText, bodyText;
        public CircleImageView authorImage;
        public RecyclerView quoteView;

        //Detail Activity Views
        public TextView authorTextDetail, bodyTextDetail, categoryTextDetail;
        public WebView linkTextDetail;
        public CircleImageView authorDetailImage;
        FloatingActionButton bioView, expandView, shareView;

        //Post Activity Views
        public FloatingActionButton addBtn;
        public EditText postName, postBody, postCategory;


        public ViewHolder(final View itemView) {
            super(itemView);

            //Instantiating Main Activity Views By ID
            authorImage = (CircleImageView) itemView.findViewById(author_picture);
            authorText = (TextView) itemView.findViewById(R.id.textAuthor);
            categoryText = (TextView) itemView.findViewById(R.id.textCategory);
            bodyText = (TextView) itemView.findViewById(R.id.detail_quote);

            //Instantiating Detail Activity Views By ID
            authorDetailImage = (CircleImageView) itemView.findViewById(R.id.author_head_pic);
            authorTextDetail = (TextView) itemView.findViewById(R.id.author_head_name);
            bodyTextDetail = (TextView) itemView.findViewById(R.id.detail_quote2);
            categoryTextDetail = (TextView) itemView.findViewById(R.id.detail_category);
            linkTextDetail = (WebView) itemView.findViewById(quote_link);
            bioView = (FloatingActionButton) itemView.findViewById(R.id.open_link);
            expandView = (FloatingActionButton) itemView.findViewById(R.id.expand_view);
            shareView = (FloatingActionButton) itemView.findViewById(R.id.share_quote);

            //Instantiating Post Activity View By ID
            addBtn = (FloatingActionButton) itemView.findViewById(R.id.post);
            postName = (EditText) itemView.findViewById(R.id.dialog_title);
            postBody = (EditText) itemView.findViewById(R.id.dialog_body);
            postCategory = (EditText) itemView.findViewById(R.id.category);
            quoteView = (RecyclerView) itemView.findViewById(R.id.recyclerView);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    View authorImage = view.findViewById(author_picture);
                    View authorName = view.findViewById(textAuthor);

                    Pair<View, String> pair1 = Pair.create((View)authorName, "authorNameTransition");
//                    ActivityOptions opt1 = ActivityOptions.makeSceneTransitionAnimation((Activity) view.getContext(), pair1);




                }
            });
        }
    }

    //OpenDetailAct. Method used to transfer data to Detail Activity
    private void openDetailActivity(String author, String author_picture, String quote_category, String quote_body, String quote_link) {
        Intent intent = new Intent(context, AuthorDetailActivity.class);
        intent.putExtra("author", author);
        intent.putExtra("author_picture", author_picture);
        intent.putExtra("quote_category", quote_category);
        intent.putExtra("quote_body", quote_body);
        intent.putExtra("quote_link", quote_link);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public void addQuote(QuoteHelper posts) {
        quotes.add(posts);
        notifyDataSetChanged();
    }
}
