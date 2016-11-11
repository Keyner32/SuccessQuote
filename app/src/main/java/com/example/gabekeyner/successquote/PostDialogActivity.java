package com.example.gabekeyner.successquote;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.tkurimura.flickabledialog.FlickableDialog;

public class PostDialogActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    Spinner spinner;
    FloatingActionButton postBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_dialog);

        spinner = (Spinner) findViewById(R.id.spinner_category);

        FlickableDialog dialog = FlickableDialog.newInstance(R.layout.activity_post_dialog);
        dialog.show(getSupportFragmentManager(), dialog.getClass().getSimpleName());


        postBtn = (FloatingActionButton) findViewById(R.id.post);
        postBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
//
//                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.category));
//                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                spinner.setAdapter(arrayAdapter);
//                spinner.setOnItemSelectedListener(MainActivity.this);

    }





    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        TextView myText = (TextView) view;
        Toast.makeText(this, myText.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
