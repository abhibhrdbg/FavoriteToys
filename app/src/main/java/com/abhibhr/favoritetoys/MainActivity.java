package com.abhibhr.favoritetoys;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.abhibhr.favoritetoys.utilities.NetworkUtils;

import java.io.IOException;
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



    void makeGithubSearchQuery(){
        String githubQueryString = mSearchBoxEditText.getText().toString();
        URL githubSearchUrl = NetworkUtils.buildUrl(githubQueryString);
        mUrlDisplayTextView.setText(githubSearchUrl.toString());
        // TODO (2) Call getResponseFromHttpUrl and display the results in mSearchResultsTextView
        String gitHubSearchResults = null;
        try{
            gitHubSearchResults = NetworkUtils.getResponseFromHttpUrl(githubSearchUrl);
            mSearchResultTextView.setText(gitHubSearchResults);

        }catch (IOException e) {
            e.printStackTrace();
        }
        // TODO (3) Surround the call to getResponseFromHttpUrl with a try / catch block to catch an IOException

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
              Context context = MainActivity.this;
            makeGithubSearchQuery();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
