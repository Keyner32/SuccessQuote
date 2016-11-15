package com.example.gabekeyner.successquote.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.example.gabekeyner.successquote.AnimationUtil;
import com.example.gabekeyner.successquote.JavaClasses.PicassoClient;
import com.example.gabekeyner.successquote.R;

import de.hdodenhof.circleimageview.CircleImageView;


public class AuthorDetailActivity extends AppCompatActivity {

    FloatingActionButton bioView, expandView, shareView;
    TextView bodyText, categoryText, authorText;
    CircleImageView author_head;
    Animation fade_in;
    WebView linkText;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Instantiating Views
        author_head = (CircleImageView) findViewById(R.id.author_head_pic);
        authorText = (TextView) findViewById(R.id.author_head_name);
        bodyText = (TextView) findViewById(R.id.detail_quote2);
        categoryText = (TextView) findViewById(R.id.detail_category);
        bioView = (FloatingActionButton) findViewById(R.id.open_link);
        expandView = (FloatingActionButton) findViewById(R.id.expand_view);
        shareView = (FloatingActionButton) findViewById(R.id.share_quote);
        linkText = (WebView) findViewById(R.id.quote_link);
        backBtn = (Button) findViewById(R.id.backButton);


        //Animations
        fade_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in_detail);
        bodyText.startAnimation(fade_in);
        categoryText.startAnimation(fade_in);
        AnimationUtil.setScaleAnimationButton(bioView);
        AnimationUtil.setScaleAnimationButton(expandView);
        AnimationUtil.setScaleAnimationButton(shareView);

        //RETRIEVE DATA
        Intent intent = this.getIntent();
        String quote_body = intent.getExtras().getString("quote_body");
        String quote_author = intent.getExtras().getString("author");
        String author_picture = intent.getExtras().getString("author_picture");
        String quote_category = intent.getExtras().getString("quote_category");
        String quote_link = intent.getExtras().getString("quote_link");

        //BIND DATA
        authorText.setText(quote_author);
        bodyText.setText(quote_body);
        categoryText.setText(quote_category);
        linkText.loadUrl(quote_link);
        PicassoClient.downloadImage(this, author_picture, author_head);

        //Web View will be shown when BioView Button is Clicked
        bioView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linkText.setVisibility(View.VISIBLE);
            }
        });
        //Custom Back Button For Activity to Return to Main Menu
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    //Method will close the Web View on the Back Pressed
    public void onBackPressed() {
        linkText.setVisibility(View.INVISIBLE);
    }

}
