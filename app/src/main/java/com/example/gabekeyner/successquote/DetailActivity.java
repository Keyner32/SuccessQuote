package com.example.gabekeyner.successquote;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView authorText,bodyText,categoryText;

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
        setContentView(R.layout.activity_detail);

        authorText = (TextView) findViewById(R.id.author) ;
        bodyText = (TextView) findViewById(R.id.body);
        categoryText = (TextView)findViewById(R.id.category);

        //RETRIEVE DATA
        Intent intent = this.getIntent();
        String quote_author = intent.getExtras().getString("quote_author");
        String quote_body = intent.getExtras().getString("quote_body");
        String quote_category = intent.getExtras().getString("quote_category");

        //BIND DATA
        authorText.setText(quote_author);
        bodyText.setText(quote_body);
        categoryText.setText(quote_category);
    }
}
