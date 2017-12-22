package com.abhibhr.favoritetoys;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.abhibhr.favoritetoys.utilities.NetworkUtils;

import java.net.URL;

public class MainActivity extends AppCompatActivity {


    TextView mSearchBoxEditText;

    TextView mUrlDisplayTextView;
    TextView mSearchResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSearchBoxEditText = findViewById(R.id.et_search_box);

        mUrlDisplayTextView = findViewById(R.id.tv_url_display);
        mSearchResultTextView = findViewById(R.id.tv_github_search_result_json);
    }


    // TODO (2) Create a method called makeGithubSearchQuery
    // TODO (3) Within this method, build the URL with the text from the EditText and set the built URL to the TextView

    void makeGithubSearchQuery(){
        String githubQueryString = mSearchBoxEditText.getText().toString();
        URL githubSearchUrl = NetworkUtils.buildUrl(githubQueryString);
        mUrlDisplayTextView.setText(githubSearchUrl.toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int menuItemThatWasSelected = item.getItemId();
        if(menuItemThatWasSelected == R.id.action_search){
            // TODO (4) Remove the Toast message when the search menu item is clicked
            Context context = MainActivity.this;
            String textToShow = "Search clicked";
            Toast.makeText(context, textToShow, Toast.LENGTH_SHORT).show();
            // TODO (5) Call makeGithubSearchQuery when the search menu item is clicked
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
