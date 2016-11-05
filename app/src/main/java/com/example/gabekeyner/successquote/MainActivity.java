package com.example.gabekeyner.successquote;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
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
    private final String author_picture[] = {
            "http://speakerdata.s3.amazonaws.com/photo/image/839766/Eric_Thomas_Teena_Cathey.jpg",
            "http://i.ytimg.com/vi/8kWPbB672_g/maxresdefault.jpg",
            "https://pbs.twimg.com/profile_images/540248015571660800/9qXSC-X9.png",
            "https://www.steemimg.com/images/2016/09/05/nickvijucic334cd.jpg",
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initViews();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "This Button Will Share to FaceBook or Twitter ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);


        return true;
    }

    private void initViews() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<QuoteHelper> quoteHelpers = prepareData();
        Adapter adapter = new Adapter(getApplicationContext(), quoteHelpers);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<QuoteHelper> prepareData() {
        ArrayList<QuoteHelper> quoteHelpers = new ArrayList<>();
        for (int i = 0; i < quote_authors.length; i++) {
            QuoteHelper quoteHelper = new QuoteHelper();
            quoteHelper.setAuthor(quote_authors[i]);
            quoteHelper.setAuthor_picture(author_picture[i]);
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
