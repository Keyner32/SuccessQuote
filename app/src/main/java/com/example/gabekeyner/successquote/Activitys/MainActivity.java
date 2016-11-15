package com.example.gabekeyner.successquote.Activitys;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import com.example.gabekeyner.successquote.Adapter;
import com.example.gabekeyner.successquote.JavaClasses.QuoteHelper;
import com.example.gabekeyner.successquote.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;

    private final String quote_authors[] = {
            "Eric Thomas",
            "Les Brown",
            "Tony Robbins",
            "Nick Vujicic",
            "Arnold Schwarz.",
            "Zig Ziglar",
            "Wayne W.Dyer",
            "Elon Musk",
            "Jim Rohn"
    };
    private final String author_picture[] = {
            "http://speakerdata.s3.amazonaws.com/photo/image/839766/Eric_Thomas_Teena_Cathey.jpg",
            "https://pbs.twimg.com/profile_images/414511932063096832/9h-nqTVk.jpeg",
            "https://pbs.twimg.com/profile_images/540248015571660800/9qXSC-X9.png",
            "http://cdn-www.you.co.za/wp-content/uploads/2015/04/Nick.jpg",
            "http://www.ew.com/sites/default/files/i/2015/03/02/arnold-schwarzenegger_0.jpg",
            "http://www.workingvoices.com/wp-content/uploads/zig_ziglar.jpg",
            "http://www.klru.org/wp-content/uploads/2013/02/drwayne.jpg",
            "https://pi.tedcdn.com/r/pe.tedcdn.com/images/ted/2534551796ee0a2638b462ce82e33b65091b1d42_1600x1200.jpg?cb=05112016&quality=89&w=800",
            "http://dicasdosalgueiro.pt/wp-content/uploads/2016/01/Darren_Hardy_Interviews_Jim_Rohn_0.jpg"
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
    private final String quote_body[] = {
            "\"When you want to succeed as bad as you want to breathe, then youll be successful.\"",
            "\"Dont let someone elses opinion of you become your reality.\"",
            "\"If you do what youve always done, youll get what youve always gotten.\"",
            "\"The challenges in our lives are there to strengthen our convictions. They are NOT there to run us over.\"",
            "\"Strength does not come from winning. Your struggles develop your strengths. When you go through hardships and decide not to surrender, that is strength.\"",
            "\"What you get by achieving your goals is not as important as what you become by achieving your goals.\"",
            "\"Be miserable. Or motivate yourself. Whatever has to be done, its always your choice.\"",
            "\"When something is important enough, you do it even if the odds are not in your favor.\"",
            "\"If you dont design your own life plan, chances are youll fall into someone elses plan. And guess what they have planned for you? Not much.\""
    };
    private final String quote_links[] = {
            "http://etinspires.com/",
            "https://lesbrown.com/",
            "https://www.tonyrobbins.com/",
            "http://www.nickvujicic.com/",
            "http://www.schwarzenegger.com/",
            "https://www.ziglar.com/",
            "http://www.drwaynedyer.com/",
            "https://elonmusknews.org/#emn",
            "https://www.jimrohn.com/"

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Transition for FAB Animation
        Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.custom_transition);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setSharedElementEnterTransition(transition);
        getWindow().setSharedElementReturnTransition(transition);

        //Setting The Content & ToolBar Layouts
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //[ InitViews ] Method to Display ArrayList Of Data
        initViews();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        //FAB will Transition into the PostActivity
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PostActivity.class);

                android.util.Pair<View, String> pair = Pair.create((View) fab, "fabTransition");

                ActivityOptions opt = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pair);

                startActivityForResult(intent, RESULT_OK, opt.toBundle());

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void initViews() {

        //Initiating the RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        //OnCreate will Display a Linear Layout First
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        //Arraylist for Quotes Data & Sets it to the Adapter Class
        ArrayList<QuoteHelper> quoteHelpers = prepareData();
        Adapter adapter = new Adapter(getApplicationContext(), quoteHelpers);
        recyclerView.setAdapter(adapter);

    }

    private ArrayList<QuoteHelper> prepareData() {
        //Uses QuoteHelper Class that set the [ Quotes Attributes ]
        ArrayList<QuoteHelper> quoteHelpers = new ArrayList<>();
        for (int i = 0; i < quote_authors.length; i++) {
            QuoteHelper quoteHelper = new QuoteHelper();
            quoteHelper.setAuthor(quote_authors[i]);
            quoteHelper.setAuthor_picture(author_picture[i]);
            quoteHelper.setQuote_category(quote_category[i]);
            quoteHelper.setQuote_body(quote_body[i]);
            quoteHelper.setQuote_link(quote_links[i]);
            quoteHelpers.add(quoteHelper);

        }
        return quoteHelpers;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Switch Case To Toggle Between Views
        int id = item.getItemId();

        switch (id) {
            //[Linear View]
            case R.id.linearView:
                LinearLayoutManager linearlyMag = new LinearLayoutManager(this);
                linearlyMag.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(linearlyMag);
                break;
            //[Grid View]
            case R.id.staggerdView:
                StaggeredGridLayoutManager staggeredGridLayoutMang = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(staggeredGridLayoutMang);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


//Todo make tranisitons to the Detail Activity

}
