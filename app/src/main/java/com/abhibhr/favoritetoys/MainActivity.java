package com.abhibhr.favoritetoys;

import android.content.Context;
import android.os.AsyncTask;
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
        String gitHubSearchResults = null;
        new GitHubQueryTask().execute(githubSearchUrl);
        // TODO (4) Create a new GithubQueryTask and call its execute method, passing in the url to query
    }


    // TODO (1) Create a class called GithubQueryTask that extends AsyncTask<URL, Void, String>
    // TODO (2) Override the doInBackground method to perform the query. Return the results. (Hint: You've already written the code to perform the query)
    // TODO (3) Override onPostExecute to display the results in the TextView
    public class GitHubQueryTask extends AsyncTask <URL, Void, String>{
        @Override
        protected String doInBackground(URL... urls) {
            URL searchUrl = urls[0];
            String githubSearchResults = null;
            try {
                githubSearchResults = NetworkUtils.getResponseFromHttpUrl(searchUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return githubSearchResults;
        }

        @Override
        protected void onPostExecute(String s) {
            if( s!= null && !s.equals("")){
                mSearchResultTextView.setText(s);
            }
        }
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
