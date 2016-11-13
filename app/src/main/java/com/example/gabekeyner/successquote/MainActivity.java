package com.example.gabekeyner.successquote;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.tkurimura.flickabledialog.FlickableDialog;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = Adapter.class.getSimpleName();
    RecyclerView recyclerView;




    public static final String ANONYMOUS = "anonymous";
    private String qPhotoUrl;
    private String qUsername;

    private Adapter qAdapter;

    private final String quote_authors[] = {
            "Eric Thomas",
            "Les Brown",
            "Tony Robbins",
            "Nick Vujicic",
            "Arnold Schwarzenegger",
            "Zig Ziglar",
            "Dr. Wayne W.Dyer",
            "Elon Musk",
            "Jim Rohn"
    };
    private final String author_picture[] = {
            "http://speakerdata.s3.amazonaws.com/photo/image/839766/Eric_Thomas_Teena_Cathey.jpg",
            "https://pbs.twimg.com/profile_images/414511932063096832/9h-nqTVk.jpeg",
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initViews();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            FlickableDialog dialog = FlickableDialog.newInstance(R.layout.fragment_post_dialog);
            dialog.show(getSupportFragmentManager(), dialog.getClass().getSimpleName());

            }
        });
//        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void initViews() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
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
            quoteHelper.setQuote_body(quote_body[i]);
            quoteHelpers.add(quoteHelper);


        }
        return quoteHelpers;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


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

//    //Bring the Views for the Main Activity
//    private void initViews() {
//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        recyclerView.setHasFixedSize(true);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(layoutManager);

        // Write a message to the database
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message");
//
//        myRef.setValue("Hello, World!");





        //Displays quotes from the Database
//        mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();




        //Displays quotes from the Database
//        qDatabase = FirebaseDatabase.getInstance().getReference();
//        qChildRef = qDatabase.child("quotes");
//        qAdapter = new Adapter(QuoteHelper.class, R.layout.card_view, Viewholder.class, qChildRef, getApplicationContext());
//        recyclerView.setAdapter(qAdapter);
//
//        qChildRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                QuoteHelper quoteHelper = dataSnapshot.getValue(QuoteHelper.class);
//                Log.d(TAG, "Quote : " + quoteHelper.getAuthor());
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });
   // }
// Read from the database


//Todo make tranisitons to the Detail Activity


}
