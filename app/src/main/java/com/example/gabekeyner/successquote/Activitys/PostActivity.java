package com.example.gabekeyner.successquote.Activitys;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.example.gabekeyner.successquote.AnimationUtil;
import com.example.gabekeyner.successquote.R;

import static android.R.attr.startX;
import static android.R.attr.startY;
import static com.example.gabekeyner.successquote.R.id.fab1;
import static com.example.gabekeyner.successquote.R.id.recyclerView;

public class PostActivity extends AppCompatActivity {

    FloatingActionButton fab, addBtn;
    EditText postName, postBody, postCategory;

    ArrayAdapter<String> postAdapter;
    public RecyclerView quoteView;

    View postDialog;
    View revealView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(getDrawable(R.mipmap.ic_launcher));

        //Instantiating Views
        postName = (EditText) findViewById(R.id.dialog_title);
        postBody = (EditText) findViewById(R.id.dialog_body);
        postCategory = (EditText) findViewById(R.id.category);
        quoteView = (RecyclerView) findViewById(recyclerView);
        postDialog = findViewById(R.id.postDia);
        addBtn = (FloatingActionButton) findViewById(R.id.post);

        addBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PostActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //FloatingActionButton Animates into an Dialog
        fab = (FloatingActionButton) findViewById(fab1);
        revealView = findViewById(R.id.revealView);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //Animated Transition
        getWindow().getSharedElementEnterTransition().addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionEnd(Transition transition) {
                revealView();
            }

            @Override
            public void onTransitionStart(Transition transition) {
            }

            @Override
            public void onTransitionCancel(Transition transition) {

            }

            @Override
            public void onTransitionPause(Transition transition) {
            }

            @Override
            public void onTransitionResume(Transition transition) {
            }
        });
        AnimationUtil.setScaleDialog(postDialog);
        fab.setVisibility(View.INVISIBLE);
    }
    //Animate the Floating Action Button to Circular Reveal
    private void revealView() {

        // get the final radius for the clipping circle
        float finalRadius = (float) Math.hypot(startX, startY);

        // create the animator for this view (the start radius is zero)
        Animator animator = ViewAnimationUtils.createCircularReveal(revealView, startX, startY, 0, finalRadius);

        animator.setDuration(300);

        // make the view visible and start the animation
        revealView.setVisibility(View.VISIBLE);

        animator.start();


    }
    //Method to Post a Quote to the ArrayList
    private void addPost() {
        String newAuthor = postName.getText().toString();
        String newQuote = postBody.getText().toString();
        String newCategory = postCategory.getText().toString();
        if (!newAuthor.isEmpty() && newAuthor.length() > 0) {
            postAdapter.add(newAuthor);
        }
    }


}
