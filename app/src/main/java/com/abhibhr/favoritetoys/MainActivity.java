package com.abhibhr.favoritetoys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Declare a TextView variable called mToysListTextView    !done
    TextView mToysListTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Use findViewById to get a reference to the TextView from the layout   !done
        mToysListTextView = findViewById(R.id.tv_toy_names);

        //Use the static ToyBox.getToyNames method and store the names in a String array    !done
        String toyNames[] = ToyBox.getToyNames();

        //Loop through each toy and append the name to the TextView (add \n for spacing)    !done
        for (String toyName: toyNames) {
            mToysListTextView.append(toyName+"\n\n\n");

        }

    }
}
