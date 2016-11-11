package com.example.gabekeyner.successquote;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.cleveroad.bubbleanimation.BubbleAnimationLayout;

import de.hdodenhof.circleimageview.CircleImageView;


public class AuthorDetailActivity extends AppCompatActivity {

    RecyclerView recyclerDetailView;
    TextView bodyText, categoryText, authorText;
    CircleImageView author_head;
    public BubbleAnimationLayout mBalBaseView;
    Animation fade_in;
    private String[] arraySpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        author_head = (CircleImageView) findViewById(R.id.author_head_pic);
        authorText = (TextView) findViewById(R.id.author_head_name);
        bodyText = (TextView) findViewById(R.id.detail_quote2);
        categoryText = (TextView) findViewById(R.id.detail_category);

        fade_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in_detail);
        bodyText.startAnimation(fade_in);
        categoryText.startAnimation(fade_in);

        //RETRIEVE DATA
        Intent intent = this.getIntent();
        String quote_body = intent.getExtras().getString("quote_body");
        String quote_author = intent.getExtras().getString("author");
        String author_picture = intent.getExtras().getString("author_picture");
        String quote_category = intent.getExtras().getString("quote_category");


        //BIND DATA
        authorText.setText(quote_author);
        bodyText.setText(quote_body);
        categoryText.setText(quote_category);
        PicassoClient.downloadImage(this, author_picture, author_head);

        //  recyclerDetailView = (RecyclerView) findViewById(R.id.recycler_quote_view);

    }
    //---------------------------------------------------------------------
    //TODO MAKE THE APP BAR NOT SHOW THE TITLE


}
