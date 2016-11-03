package com.example.gabekeyner.successquote;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    private final String quote_authors[] = {
            "Eric Thomas",
            "Les Brown",
            "Tony Robbins",
            "Nick Vujicic",
            "Arnold Schwarzenegger",
            "Zig Ziglar",
            "Dr.Wayne W.Dyer",
            "Elon Musk",
            "Jim Rohn"
    };
    private final String quote_body[] = {
            "When you want to succeed as bad as you want to breathe, then youll be successful.",
            "Dont let someone elses opinion of you become your reality.",
            "If you do what youve always done, youll get what youve always gotten.",
            "The challenges in our lives are there to strengthen our convictions. They are NOT there to run us over.",
            "Strength does not come from winning. Your struggles develop your strengths. When you go through hardships and decide not to surrender, that is strength.",
            "What you get by achieving your goals is not as important as what you become by achieving your goals.",
            "Be miserable. Or motivate yourself. Whatever has to be done, its always your choice.",
            "When something is important enough, you do it even if the odds are not in your favor.",
            "If you dont design your own life plan, chances are youll fall into someone elses plan. And guess what they have planned for you? Not much."
    };
    private final String quote_category[] = {
            "Motivational",
            "Motivational",
            "Motivational",
            "Determination",
            "Fitness",
            "Business",
            "Mindset",
            "Entrepreneur",
            "Mindset"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "This Button Will Share to FaceBook or Twitter ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private Menu mMenu;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);


        return true;
    }

    private ArrayList<QuoteHelper> prepareData() {
        ArrayList<QuoteHelper> quoteHelpers = new ArrayList<>();
        for (int i = 0; i <quote_authors.length; i++) {
            QuoteHelper quoteHelper = new QuoteHelper();
            quoteHelper.setAuthor(quote_authors[i]);
            quoteHelper.setQuote_body(quote_body[i]);
            quoteHelper.setQuote_category(quote_category[i]);
            quoteHelpers.add(quoteHelper);


        }
        return quoteHelpers;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
//        if (mMenu != null) {
//            MenuItem item1 = mMenu.findItem(R.id.linearView);
//            if (item1 != null) {
//                item1.setVisible(false);
//            }
//        }

        switch (id) {
            case R.id.linearView:

                LinearLayoutManager linearlayoutMang = new LinearLayoutManager(this);
                linearlayoutMang.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(linearlayoutMang);

                break;
            case R.id.staggerdView:
                StaggeredGridLayoutManager staggeredGridLayoutMang = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(staggeredGridLayoutMang);
                break;
        }


        return super.onOptionsItemSelected(item);
    }


}
