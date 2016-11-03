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

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MenuItem listview;
    public int mState = 0;


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
//                recyclerView.setLayoutManager(linearlayoutMang);

                break;
            case R.id.staggerdView:
                StaggeredGridLayoutManager staggeredGridLayoutMang = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
//                recyclerView.setLayoutManager(staggeredGridLayoutMang);
                break;
        }


        return super.onOptionsItemSelected(item);
    }




}
