package com.abhibhr.favoritetoys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    // TODO (26) Create an EditText variable called mSearchBoxEditText
    TextView mSearchBoxEditText;

    // TODO (27) Create a TextView variable called mUrlDisplayTextView
    TextView mUrlDisplayTextView;
    // TODO (28) Create a TextView variable called mSearchResultsTextView
    TextView mSearchResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO (29) Use findViewById to get a reference to mSearchBoxEditText
        mSearchBoxEditText = findViewById(R.id.et_search_box);

        // TODO (30) Use findViewById to get a reference to mUrlDisplayTextView
        mUrlDisplayTextView = findViewById(R.id.tv_url_display);
        // TODO (31) Use findViewById to get a reference to mSearchResultsTextView
        mSearchResultTextView = findViewById(R.id.tv_github_search_result_json);


    }
}
